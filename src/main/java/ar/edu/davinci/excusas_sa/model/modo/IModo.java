package edu.davinci.modo;

import edu.davinci.empleado.responsable.Responsable;
import edu.davinci.excusa.Excusa;

public interface IModo {
    void procesarExcusa(Responsable unResponsable, Excusa unaExcusa);
    boolean puedeProcesar(Responsable unResponsable, Excusa unaExcusa);
    boolean esAdecuado(Responsable unResponsable);
}
