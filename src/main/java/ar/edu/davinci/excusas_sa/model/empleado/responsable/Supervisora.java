package edu.davinci.empleado.responsable;

import edu.davinci.excusa.Excusa;
import edu.davinci.modo.DeliveryModo;

public class Supervisora extends Responsable{

    public Supervisora(String nombre, String email, String legajo, Responsable seguente, DeliveryModo delivery) {
        super(nombre, email, legajo, seguente, delivery);
    }

    public boolean puedeProcesar(Excusa unaExcusa) {
        return unaExcusa.esModerada();
    }
    public void procesarExcusa(Excusa unaExcusa) {
        unaExcusa.procesarse(this);
        unaExcusa.aceptar();
    }
}
