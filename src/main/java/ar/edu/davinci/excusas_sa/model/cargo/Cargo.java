package ar.edu.davinci.excusas_sa.model.cargo;

import ar.edu.davinci.excusas_sa.model.excusa.TipoExcusa;
import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<TipoExcusa> motivosQueProcesa = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<TipoExcusa> getMotivosQueProcesa() {
        return motivosQueProcesa;
    }
}
