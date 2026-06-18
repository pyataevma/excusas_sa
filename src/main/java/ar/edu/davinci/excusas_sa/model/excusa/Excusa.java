package ar.edu.davinci.excusas_sa.model.excusa;

import ar.edu.davinci.excusas_sa.model.email.ConsoleEmailSender;
import ar.edu.davinci.excusas_sa.model.email.EmailSender;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;

import java.time.LocalDateTime;

public abstract class Excusa implements IExcusa {
    private final Empleado empleado;
    private final String texto;
    private final LocalDateTime fecha;
    private Boolean aceptada;
    protected final EmailSender emailSender = new ConsoleEmailSender();

    @Override
    public boolean esTrivial() {
        return false;
    };
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
