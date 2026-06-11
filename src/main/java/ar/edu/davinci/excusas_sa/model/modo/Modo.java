package edu.davinci.modo;

import edu.davinci.email.ConsoleEmailSender;
import edu.davinci.email.EmailSender;
import edu.davinci.empleado.responsable.Responsable;

public abstract class Modo implements IModo{
    protected final EmailSender emailSender = new ConsoleEmailSender();

    @Override
    public boolean esAdecuado(Responsable unResponsable){
        return false;
    };
}
