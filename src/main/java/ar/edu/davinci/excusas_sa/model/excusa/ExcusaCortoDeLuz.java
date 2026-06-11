package edu.davinci.excusa;

import edu.davinci.empleado.Empleado;
import edu.davinci.empleado.responsable.Responsable;

public class ExcusaCortoDeLuz extends Excusa{
    public ExcusaCortoDeLuz(Empleado empleado, String texto) {
        super(empleado, texto);
    }

    @Override
    public boolean esModerada() {
        return true;
    }

    @Override
    public void procesarse(Responsable responsable) {
        String origen = responsable.getEmail();
        String destino = this.getEmpleado().getEmail();
        emailSender.enviarEmail(destino, origen, "Corto de la luz","¿Es verdad que se cortó la luz hoy?");
    }
}
