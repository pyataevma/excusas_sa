package edu.davinci.excusa;

import edu.davinci.empleado.Empleado;
import edu.davinci.empleado.responsable.Responsable;

public class ExcusaCompleja extends Excusa{
    public ExcusaCompleja(Empleado empleado, String texto) {
        super(empleado, texto);
    }

    @Override
    public boolean esCompleja() {
        return true;
    }

    @Override
    public void procesarse(Responsable responsable) {
        String origen = responsable.getEmail();
        String destino = this.getEmpleado().getEmail();
        emailSender.enviarEmail(destino, origen, "Disposición","Escusa fue aceptada");
    }
}
