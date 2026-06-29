package ar.edu.davinci.excusas_sa.mapper;

import ar.edu.davinci.excusas_sa.model.dto.ProntuarioDTO;
import ar.edu.davinci.excusas_sa.model.prontuario.Prontuario;
import org.springframework.stereotype.Component;

@Component
public class ProntuarioMapper {
    private ExcusaMapper excusaMapper;

    public ProntuarioMapper(ExcusaMapper excusaMapper) {
        this.excusaMapper = excusaMapper;
    }

    public ProntuarioDTO toDTO(Prontuario prontuario) {
        ProntuarioDTO dto = new ProntuarioDTO(excusaMapper.toDTO(prontuario.getExcusa()));
        return dto;
    }
}
