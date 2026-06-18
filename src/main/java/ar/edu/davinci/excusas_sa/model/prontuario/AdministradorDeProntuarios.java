package ar.edu.davinci.excusas_sa.model.prontuario;

import ar.edu.davinci.excusas_sa.model.email.ConsoleEmailSender;
import ar.edu.davinci.excusas_sa.model.email.EmailSender;
import ar.edu.davinci.excusas_sa.model.empleado.responsable.Ceo;

import java.util.ArrayList;

//import static ar.edu.email.davinci.edu.EmailSender.enviarEmail;

public class AdministradorDeProntuarios {
    private final ArrayList<Prontuario> prontuarios;
    private final ArrayList<Ceo> ceos;
    private static AdministradorDeProntuarios administradorDeProntuarios; {}
    private EmailSender emailSender;

    private AdministradorDeProntuarios() {
        ceos = new ArrayList<Ceo>();
        prontuarios = new ArrayList<Prontuario>();
        emailSender = new ConsoleEmailSender();
    }

    public static AdministradorDeProntuarios getInstance() {
        if  (administradorDeProntuarios == null) {
            administradorDeProntuarios = new AdministradorDeProntuarios();
        }
        return administradorDeProntuarios;
    }

    public void avisarEquipo(Ceo remitente, String asunto, String cuerpo){
        String origen = remitente.getEmail();
        for(Ceo ceo : ceos) {
            if (ceo!=remitente) {
                String destino = ceo.getEmail();
                emailSender.enviarEmail(destino, origen, asunto, cuerpo);
            }
        }
    }

    public void agregarProntuario(Prontuario unProntuario) {
        prontuarios.add(unProntuario);
    }

    public void agregarCeo(Ceo unCeo) {
        ceos.add(unCeo);
    }

    public void quitarCeo(Ceo unCeo) {
        if (ceos.contains(unCeo))  {
            ceos.remove(unCeo);
        }
    }
}
