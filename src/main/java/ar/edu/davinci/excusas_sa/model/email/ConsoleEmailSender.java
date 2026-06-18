package ar.edu.davinci.excusas_sa.model.email;

public class ConsoleEmailSender implements EmailSender {
    @Override
    public void enviarEmail(String unEmailDestino, String unEmailOrigen, String unAsunto, String unCuerpo){
        System.out.println("Enviando email de " + unEmailOrigen + " a " + unEmailDestino);
        System.out.println("Asunto: " + unAsunto);
        System.out.println("Cuerpo: " + unCuerpo + "\n");
    }
}
