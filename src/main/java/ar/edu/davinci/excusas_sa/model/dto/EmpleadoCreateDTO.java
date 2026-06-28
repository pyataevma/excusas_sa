package ar.edu.davinci.excusas_sa.model.dto;

public class EmpleadoCreateDTO {
    private String nombre;
    private String email;
    private String legajo;

    public EmpleadoCreateDTO() {
    }

    public EmpleadoCreateDTO(String nombre, String email, String legajo) {
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
