package ar.edu.davinci.excusas_sa.mapper;

import ar.edu.davinci.excusas_sa.model.dto.ExcusaDTO;
import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import org.springframework.stereotype.Component;

@Component
public class ExcusaMapper {

    private EmpleadoMapper empleadoMapper;
    public ExcusaMapper(EmpleadoMapper empleadoMapper) {
        this.empleadoMapper = empleadoMapper;
    }


    public ExcusaDTO toDTO(Excusa excusa) {

        return new ExcusaDTO(
                excusa.getId(),
                empleadoMapper.toDTO(excusa.getEmpleado()),
                excusa.getTipo(),
                excusa.getTexto(),
                excusa.getFecha(),
                excusa.getAceptada()
        );
    }

}
