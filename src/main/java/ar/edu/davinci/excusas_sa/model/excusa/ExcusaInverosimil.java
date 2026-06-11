package edu.davinci.excusa;

import edu.davinci.empleado.Empleado;
import edu.davinci.empleado.responsable.Responsable;

public class ExcusaInverosimil extends Excusa {

    public ExcusaInverosimil(Empleado empleado, String texto) {
        super(empleado, texto);
    }

    @Override
    public boolean esInverosimil() {
        return true;
    }

    @Override
    public void procesarse(Responsable responsable) {
        String origen = responsable.getEmail();
        String destino = this.getEmpleado().getEmail();
        emailSender.enviarEmail(destino, origen, "Excusa aprobada","Aprobado por creatividad.");
    }
}
