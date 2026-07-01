package ar.edu.davinci.excusas_sa.model.excusa;

import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;

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

    @Override
    public TipoExcusa getTipo() {
        return TipoExcusa.INVEROSIMIL;
    }

}
