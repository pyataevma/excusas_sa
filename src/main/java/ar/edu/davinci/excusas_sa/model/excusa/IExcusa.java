package ar.edu.davinci.excusas_sa.model.excusa;

import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;

public interface IExcusa {
    boolean esTrivial();
    boolean esModerada();
    boolean esCompleja();
    boolean esInverosimil();
    void procesarse(Responsable responsable);
    void aceptar();
    void rechazar();
}
