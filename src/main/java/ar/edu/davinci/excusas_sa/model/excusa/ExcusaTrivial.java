package ar.edu.davinci.excusas_sa.model.excusa;

import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;

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
