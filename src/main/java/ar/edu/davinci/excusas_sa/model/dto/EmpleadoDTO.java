package ar.edu.davinci.excusas_sa.model.dto;

public class EmpleadoDTO {

    private String nombre;
    private String email;
    private String legajo;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(String nombre, String email, String legajo) {
        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
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
}
