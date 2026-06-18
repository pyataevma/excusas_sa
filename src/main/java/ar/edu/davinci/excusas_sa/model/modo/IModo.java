package ar.edu.davinci.excusas_sa.model.modo;

import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;
import ar.edu.davinci.excusas_sa.model.excusa.Excusa;

public interface IModo {
    void procesarExcusa(Responsable unResponsable, Excusa unaExcusa);
    boolean puedeProcesar(Responsable unResponsable, Excusa unaExcusa);
    boolean esAdecuado(Responsable unResponsable);
}
