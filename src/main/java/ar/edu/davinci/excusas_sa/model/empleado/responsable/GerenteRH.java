package ar.edu.davinci.excusas_sa.model.empleado.responsable;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.model.modo.DeliveryModo;

public class GerenteRH extends Responsable {
    public GerenteRH(String nombre, String email, String legajo, Responsable seguente, DeliveryModo delivery) {
        super(nombre, email, legajo, seguente, delivery);
    }

    public boolean puedeProcesar(Excusa unaExcusa) {
        return unaExcusa.esCompleja();
    }

    public void procesarExcusa(Excusa unaExcusa) {
        unaExcusa.procesarse(this);
        unaExcusa.aceptar();
    }
}
