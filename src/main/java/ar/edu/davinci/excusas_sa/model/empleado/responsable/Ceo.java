package edu.davinci.empleado.responsable;

import edu.davinci.excusa.Excusa;
import edu.davinci.modo.DeliveryModo;
import edu.davinci.prontuario.AdministradorDeProntuarios;
import edu.davinci.prontuario.Prontuario;

public class Ceo extends Responsable {

    public Ceo(String nombre, String email, String legajo, Responsable seguente, DeliveryModo deliveryModo) {
        super(nombre, email, legajo, seguente, deliveryModo);
    }

    public boolean puedeProcesar(Excusa unaExcusa) {
        return unaExcusa.esInverosimil();
    }
    public void procesarExcusa(Excusa unaExcusa) {
        unaExcusa.procesarse(this);
        unaExcusa.aceptar();
        AdministradorDeProntuarios adminProntuarios = AdministradorDeProntuarios.getInstance();
        adminProntuarios.agregarProntuario(new Prontuario(unaExcusa));
        adminProntuarios.avisarEquipo(this, "Nuevo prontuario", "Inicié un nuevo prontuario");
    }
}
