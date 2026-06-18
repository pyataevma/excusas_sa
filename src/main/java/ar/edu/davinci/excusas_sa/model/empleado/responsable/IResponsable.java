package ar.edu.davinci.excusas_sa.model.empleado.responsable;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;

public interface IResponsable {
    void revisarExcusa(Excusa unaExcusa);
    void procesarExcusa(Excusa unaExcusa);
    boolean puedeProcesar(Excusa unaExcusa);
}
