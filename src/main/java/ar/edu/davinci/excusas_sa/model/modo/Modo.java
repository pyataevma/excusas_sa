package ar.edu.davinci.excusas_sa.model.modo;

import ar.edu.davinci.excusas_sa.model.email.ConsoleEmailSender;
import ar.edu.davinci.excusas_sa.model.email.EmailSender;
import ar.edu.davinci.excusas_sa.model.empleado.responsable.Responsable;

public abstract class Modo implements IModo{
    protected final EmailSender emailSender = new ConsoleEmailSender();

    @Override
    public boolean esAdecuado(Responsable unResponsable){
        return false;
    };
}
