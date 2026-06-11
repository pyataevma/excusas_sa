package edu.davinci.modo;

import edu.davinci.empleado.responsable.Responsable;
import edu.davinci.excusa.Excusa;

public class ModoVagx extends Modo {
    @Override
    public void procesarExcusa(Responsable unResponsable, Excusa unaExcusa) {
    }

    @Override
    public boolean puedeProcesar(Responsable unResponsable, Excusa unaExcusa) {
        return false;
    }

    public boolean esAdecuado(Responsable unResponsable) {
        return ((unResponsable.getNumeroProcesado() > ModoNormal.NUMERO_PROCESADO_MAX));
    }
}
