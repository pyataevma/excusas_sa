package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.model.dto.EmpleadoCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.EmpleadoDTO;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<EmpleadoDTO> obtenerTodos() {

        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public EmpleadoDTO guardar(EmpleadoCreateDTO dto) {

        Empleado empleado = toEntity(dto);

        Empleado guardado = repository.save(empleado);

        return toDTO(guardado);
    }

    private EmpleadoDTO toDTO(Empleado empleado) {
        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getEmail(),
                empleado.getLegajo()
        );
    }

    private Empleado toEntity(EmpleadoCreateDTO dto) {
        return new Empleado(
                dto.getNombre(),
                dto.getEmail(),
                dto.getLegajo()
        );
    }
}