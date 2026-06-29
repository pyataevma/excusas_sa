package ar.edu.davinci.excusas_sa.mapper;

import ar.edu.davinci.excusas_sa.model.dto.EmpleadoCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.EmpleadoDTO;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public EmpleadoDTO toDTO(Empleado empleado) {
        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getEmail(),
                empleado.getLegajo()
        );
    }

    public Empleado toEntity(EmpleadoCreateDTO dto) {
        return new Empleado(
                dto.getNombre(),
                dto.getEmail(),
                dto.getLegajo()
        );
    }
}
