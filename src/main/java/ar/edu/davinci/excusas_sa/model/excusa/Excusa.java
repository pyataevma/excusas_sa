package ar.edu.davinci.excusas_sa.model.excusa;

import ar.edu.davinci.excusas_sa.model.email.ConsoleEmailSender;
import ar.edu.davinci.excusas_sa.model.email.EmailSender;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Excusa implements IExcusa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private  Empleado empleado;

    private  String texto;
    private LocalDateTime fecha;
    private Boolean aceptada;
    @Transient
    protected EmailSender emailSender = new ConsoleEmailSender();

    @Override
    public boolean esTrivial() {
        return false;
    }
    @Override
    public boolean esModerada() {
        return false;
    }
    @Override
    public boolean esCompleja() { return false; }
    @Override
    public boolean esInverosimil(){
        return false;
    }

    protected Excusa() {}

    public Excusa(Empleado empleado, String texto){
        this.empleado = empleado;
        this.texto = texto;
        this.fecha = LocalDateTime.now();
        this.aceptada = false;
    }

    public void aceptar() { aceptada=true; }

    public void rechazar() {
        aceptada=false;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
}
