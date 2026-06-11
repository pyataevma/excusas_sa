package edu.davinci.modo;

//import edu.davinci.email.ConsoleEmailSender;
//import edu.davinci.email.EmailSender;
import edu.davinci.empleado.responsable.Responsable;
import edu.davinci.excusa.Excusa;


public class ModoProductivx extends Modo {
    public static final int NUMERO_PROCESADO_MAX = 5;
    private static final String emailCTO="cto@excusassa.com";

    @Override
    public void procesarExcusa(Responsable unResponsable, Excusa unaExcusa) {
        unResponsable.procesarExcusa(unaExcusa);
    }

    @Override
    public boolean puedeProcesar(Responsable unResponsable, Excusa unaExcusa) {
        boolean loPuede = unResponsable.puedeProcesar(unaExcusa);
        if (!loPuede) {
            emailSender.enviarEmail(emailCTO, unResponsable.getEmail(), "Lo siento", "No lo puedo procesar");
        }
        return loPuede;
    }

    @Override
    public boolean esAdecuado(Responsable unResponsable) {
        return (unResponsable.getNumeroProcesado()<=NUMERO_PROCESADO_MAX);
    }
}
