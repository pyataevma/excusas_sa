package ar.edu.davinci.excusas_sa.model.empleado;


public class Empleado {
    private String nombre;
    private String email;
    private String legajo;

    public Empleado(String nombre, String email, String legajo){
            this.nombre=nombre;
            this.email=email;
            this.legajo=legajo;
    }

    public String getEmail() {
        return email;
    }
}
