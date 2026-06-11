package edu.davinci.excusa;

import edu.davinci.empleado.responsable.Responsable;

public interface IExcusa {
    boolean esTrivial();
    boolean esModerada();
    boolean esCompleja();
    boolean esInverosimil();
    void procesarse(Responsable responsable);
    void aceptar();
    void rechazar();
}
