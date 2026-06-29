package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.mapper.ExcusaMapper;
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
        Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        Excusa excusa = new Excusa(
                empleado,
                dto.getTipo(),
                dto.getTexto()
        );
        Excusa guardada = excusaRepository.save(excusa);
        return excusaMapper.toDTO(guardada);
    }
}