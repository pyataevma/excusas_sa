package ar.edu.davinci.excusas_sa.model.prontuario;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import jakarta.persistence.*;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Excusa excusa;
    public Prontuario(Excusa excusa) {
        this.excusa = excusa;
    }

    public Prontuario() {}
}
