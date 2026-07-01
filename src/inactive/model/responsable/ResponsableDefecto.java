package ar.edu.davinci.excusas_sa.model.empleado.responsable;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.model.modo.DeliveryModo;

public class ResponsableDefecto extends Responsable{

    public ResponsableDefecto(String nombre, String email, String legajo, Responsable seguente, DeliveryModo delivery) {
        super(nombre, email, legajo, seguente, delivery);
    }

    @Override
    public void procesarExcusa(Excusa unaExcusa) {
        String origen = this.getEmail();
        String destino = unaExcusa.getEmpleado().getEmail();
        unaExcusa.rechazar();
        emailSender.enviarEmail(destino, origen, "Excusa rechasada","Nadie la pudo procesar");
    }

    @Override
    public boolean puedeProcesar(Excusa unaExcusa) {
        return true;
    }
}

