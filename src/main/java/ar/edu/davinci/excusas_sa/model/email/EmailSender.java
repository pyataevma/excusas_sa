package ar.edu.davinci.excusas_sa.model.email;

public interface EmailSender {
    void enviarEmail(String unEmailDestino, String unEmailOrigen, String unAsunto, String unCuerpo);
}
