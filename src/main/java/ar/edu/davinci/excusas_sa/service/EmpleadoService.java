package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.mapper.EmpleadoMapper;
import ar.edu.davinci.excusas_sa.model.dto.EmpleadoCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.EmpleadoDTO;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;
    private final EmpleadoMapper mapper;

    public EmpleadoService(EmpleadoRepository repository, EmpleadoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmpleadoDTO> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(empleado -> mapper.toDTO(empleado))
                .toList();
    }

    public EmpleadoDTO guardar(EmpleadoCreateDTO dto) {
        Empleado empleado = mapper.toEntity(dto);
        Empleado guardado = repository.save(empleado);
        return mapper.toDTO(guardado);
    }
}