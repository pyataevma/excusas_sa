package edu.davinci.empleado.responsable;

import edu.davinci.excusa.Excusa;
import edu.davinci.modo.DeliveryModo;

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

