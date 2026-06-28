package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.model.dto.EmpleadoDTO;
import ar.edu.davinci.excusas_sa.model.dto.ExcusaCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.ExcusaDTO;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.repository.EmpleadoRepository;
import ar.edu.davinci.excusas_sa.repository.ExcusaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcusaService {

    private final ExcusaRepository excusaRepository;
    private final EmpleadoRepository empleadoRepository;

    public ExcusaService(ExcusaRepository excusaRepository,
                         EmpleadoRepository empleadoRepository) {
        this.excusaRepository = excusaRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public List<ExcusaDTO> obtenerTodos() {
        return excusaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ExcusaDTO guardar(ExcusaCreateDTO dto) {

        Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Excusa excusa = new Excusa(
                empleado,
                dto.getTipo(),
                dto.getTexto()
        );

        Excusa guardada = excusaRepository.save(excusa);

        return toDTO(guardada);
    }

    private ExcusaDTO toDTO(Excusa excusa) {

        EmpleadoDTO empleadoDTO = new EmpleadoDTO(
                excusa.getEmpleado().getId(),
                excusa.getEmpleado().getNombre(),
                excusa.getEmpleado().getEmail(),
                excusa.getEmpleado().getLegajo()
        );

        return new ExcusaDTO(
                excusa.getId(),
                empleadoDTO,
                excusa.getTipo(),
                excusa.getTexto(),
                excusa.getFecha(),
                excusa.getAceptada()
        );
    }
}