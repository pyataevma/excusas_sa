package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.mapper.ExcusaMapper;
import ar.edu.davinci.excusas_sa.model.dto.ExcusaCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.ExcusaDTO;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.model.excusa.TipoExcusa;
import ar.edu.davinci.excusas_sa.repository.EmpleadoRepository;
import ar.edu.davinci.excusas_sa.repository.ExcusaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExcusaService {

    private final ExcusaRepository excusaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final ExcusaMapper excusaMapper;

    public ExcusaService(ExcusaRepository excusaRepository,
                         EmpleadoRepository empleadoRepository, ExcusaMapper excusaMapper) {
        this.excusaRepository = excusaRepository;
        this.empleadoRepository = empleadoRepository;
        this.excusaMapper = excusaMapper;
    }

    public List<ExcusaDTO> obtenerTodos() {
        return excusaRepository.findAll()
                .stream()
                .map(excusa -> excusaMapper.toDTO(excusa))
                .toList();
    }

    public ExcusaDTO guardar(ExcusaCreateDTO dto) {
        TipoExcusa tipo;

        try {
            tipo = TipoExcusa.valueOf(dto.getTipo().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Tipo de excusa no válido"
            );
        }
        Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        Excusa excusa = new Excusa(
                empleado,
                tipo,
                dto.getTexto()
        );
        Excusa guardada = excusaRepository.save(excusa);
        return excusaMapper.toDTO(guardada);
    }

    public List<ExcusaDTO> obtenerPorLegajo(String legajo) {
        return excusaRepository.findByEmpleadoLegajo(legajo)
                .stream()
                .map(excusaMapper::toDTO)
                .toList();
    }

    public List<ExcusaDTO> buscar(String legajo, LocalDate fechaDesde, LocalDate fechaHasta) {

        return excusaRepository.findByEmpleadoLegajo(legajo)
                .stream()
                .filter(excusa -> cumpleFiltroFecha(excusa, fechaDesde, fechaHasta))
                .map(excusaMapper::toDTO)
                .toList();
    }

    public List<ExcusaDTO> obtenerRechazadas() {

        return excusaRepository.findByAceptada(false)
                .stream()
                .map(excusaMapper::toDTO)
                .toList();
    }

    private boolean cumpleFiltroFecha(
            Excusa excusa,
            LocalDate fechaDesde,
            LocalDate fechaHasta) {

        LocalDate fecha = excusa.getFecha().toLocalDate();

        if (fechaDesde != null && fecha.isBefore(fechaDesde)) {
            return false;
        }

        if (fechaHasta != null && fecha.isAfter(fechaHasta)) {
            return false;
        }

        return true;
    }
}