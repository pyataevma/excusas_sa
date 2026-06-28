package ar.edu.davinci.excusas_sa.model.excusa;

import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;

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
