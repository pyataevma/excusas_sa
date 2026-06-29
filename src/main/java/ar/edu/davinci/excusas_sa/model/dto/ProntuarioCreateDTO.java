package ar.edu.davinci.excusas_sa.model.dto;

public class ProntuarioCreateDTO {
    private Long excusaId;

    public Long getExcusaId() { return excusaId; }

    public ProntuarioCreateDTO(Long excusaId) {
        this.excusaId = excusaId;
    }
}
