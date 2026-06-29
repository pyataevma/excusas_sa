package ar.edu.davinci.excusas_sa.model.dto;

public class ProntuarioDTO {

    private ExcusaDTO excusaDTO;

    public ExcusaDTO getExcusaDTO() {
        return excusaDTO;
    }
    public ProntuarioDTO(ExcusaDTO  excusaDTO) {
        this.excusaDTO = excusaDTO;
    }
}
