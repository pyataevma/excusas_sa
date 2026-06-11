package edu.davinci.empleado.responsable;

import edu.davinci.excusa.Excusa;

public interface IResponsable {
    void revisarExcusa(Excusa unaExcusa);
    void procesarExcusa(Excusa unaExcusa);
    boolean puedeProcesar(Excusa unaExcusa);
}
