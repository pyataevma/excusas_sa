package edu.davinci.modo;

import edu.davinci.empleado.responsable.Responsable;
import edu.davinci.excusa.Excusa;

public class ModoNormal extends Modo {
    public static final int NUMERO_PROCESADO_MAX = 10;

    @Override
    public void procesarExcusa(Responsable unResponsable, Excusa unaExcusa) {
        unResponsable.procesarExcusa(unaExcusa);
    }

    @Override
    public boolean puedeProcesar(Responsable unResponsable, Excusa unaExcusa) {
        return unResponsable.puedeProcesar(unaExcusa);
    }
    @Override
    public boolean esAdecuado(Responsable unResponsable) {
        int num = unResponsable.getNumeroProcesado();
        return ((num > ModoProductivx.NUMERO_PROCESADO_MAX) && (num <= NUMERO_PROCESADO_MAX));
    }

}
