package ar.edu.davinci.excusas_sa.model.excusa;

import ar.edu.davinci.excusas_sa.model.email.ConsoleEmailSender;
import ar.edu.davinci.excusas_sa.model.email.EmailSender;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Excusa implements IExcusa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoExcusa tipo;
    private String texto;
    private LocalDateTime fecha;
    private boolean aceptada;

    @ManyToOne
    private  Empleado empleado;

    @Transient
    protected EmailSender emailSender = new ConsoleEmailSender();

    @Override
    public boolean esTrivial() {
        return this.tipo==TipoExcusa.TRIVIAL;
    }

    @Override
    public boolean esModerada() {
        return this.tipo==TipoExcusa.MODERADA;
    }

    @Override
    public boolean esCompleja() {
        return this.tipo==TipoExcusa.COMPLEJA; }
    @Override

    public boolean esInverosimil(){
        return this.tipo==TipoExcusa.INVEROSIMIL;
    }

    @Override
    public void procesarse(Responsable responsable) {
            String origen = responsable.getEmail();
            String destino = this.empleado.getEmail();
            emailSender.enviarEmail(destino, origen, "Disposición","Escusa fue aceptada");
    }

    protected Excusa() {}

    public Excusa(Empleado empleado, TipoExcusa tipo, String texto){
        this.tipo = tipo;
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

    public Long getId() {
        return id;
    }

    public TipoExcusa getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Boolean getAceptada() {
        return aceptada;
    }
}
