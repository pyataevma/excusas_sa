package ar.edu.davinci.excusas_sa.model.dto;

public class ResponsableCreateDTO {

    private String nombre;
    private String email;
    private String legajo;

    private Long cargoId;

    private Long seguenteId;

    public ResponsableCreateDTO() {
    }

    public ResponsableCreateDTO(
            String nombre,
            String email,
            String legajo,
            Long cargoId,
            Long seguenteId) {

        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
        this.cargoId = cargoId;
        this.seguenteId = seguenteId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getLegajo() {
        return legajo;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public Long getSeguenteId() {
        return seguenteId;
    }
}