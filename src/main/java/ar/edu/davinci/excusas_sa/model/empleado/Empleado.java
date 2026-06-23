package ar.edu.davinci.excusas_sa.model.empleado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String email;
    private String legajo;

    public Empleado(String nombre, String email, String legajo){
            this.nombre=nombre;
            this.email=email;
            this.legajo=legajo;
    }

    public Empleado() {

    }

    public String getEmail() {
        return email;
    }
}
