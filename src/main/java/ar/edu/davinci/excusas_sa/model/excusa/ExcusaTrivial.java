package edu.davinci.excusa;

import edu.davinci.empleado.Empleado;
import edu.davinci.empleado.responsable.Responsable;

public class ExcusaTrivial extends Excusa {

    public ExcusaTrivial(Empleado empleado, String texto) {
        super(empleado, texto);
    }

    @Override
    public boolean esTrivial() {
        return true;
    }

    @Override
    public void procesarse(Responsable responsable) {
        String origen = responsable.getEmail();
        String destino = this.getEmpleado().getEmail();
        emailSender.enviarEmail(destino, origen, "Motivo demora","La licencia fue aceptada");
    }
}
