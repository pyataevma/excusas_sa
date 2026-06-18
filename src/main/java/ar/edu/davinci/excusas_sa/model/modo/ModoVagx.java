package ar.edu.davinci.excusas_sa.model.modo;

import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;
import ar.edu.davinci.excusas_sa.model.excusa.Excusa;

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
