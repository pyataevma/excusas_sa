package ar.edu.davinci.excusas_sa.model.empleado.responsable;

import ar.edu.davinci.excusas_sa.model.email.ConsoleEmailSender;
import ar.edu.davinci.excusas_sa.model.email.EmailSender;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.cargo.Cargo;
import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.model.modo.DeliveryModo;
import ar.edu.davinci.excusas_sa.model.modo.Modo;
import jakarta.persistence.*;


@Entity
public class Responsable extends Empleado implements IResponsable {

    private static final int MIN_MINUTOS_BREAK = 10;
    private static final int MAX_MINUTOS_BREAK = 15;

    @ManyToOne
    private Cargo cargo;

    @OneToOne
    @JoinColumn(name = "seguente_id")
    private Responsable seguente;

    @Transient
    private Modo modo;
    private int numeroProcesado;

    @Transient
    private DeliveryModo deliveryModo;

    @Transient
    protected EmailSender emailSender = new ConsoleEmailSender();

    public Responsable getSeguente() {
        return seguente;
    }

    public void setSeguente(Responsable seguente) {
        this.seguente = seguente;
    }

    public Responsable(){}

    public Responsable(String nombre, String email, String legajo, Responsable seguente, DeliveryModo deliveryModo) {
        super(nombre, email, legajo);
        this.seguente = seguente;
        this.numeroProcesado = 0;
        this.deliveryModo = deliveryModo;
        this.modo = deliveryModo.proporcionarModo(this);
    }

    public int getNumeroProcesado() {
        return numeroProcesado;
    }

    @Override
    public void revisarExcusa(Excusa unaExcusa) {
        if (puedeProcesar(unaExcusa)){
            procesarExcusa(unaExcusa);
            numeroProcesado++;
            modo = deliveryModo.proporcionarModo(this);
        } else {
            seguente.revisarExcusa(unaExcusa);
        }
    }

    @Override
    public void procesarExcusa(Excusa unaExcusa) {

    }

    @Override
    public boolean puedeProcesar(Excusa excusa) {
        return cargo.getMotivosQueProcesa().contains(excusa.getTipo());
    }


//    public void tomarCafe(){
//        numeroProcesado = 0;
//        modo = deliveryModo.proporcionarModo(this);
//    }
//
//    public void tomarBreak(int cantidadMinutos){
//        if ((numeroProcesado > ModoNormal.NUMERO_PROCESADO_MAX)
//                && (cantidadMinutos >= MIN_MINUTOS_BREAK)
//                && (cantidadMinutos <= MAX_MINUTOS_BREAK)){
//            numeroProcesado = ModoProductivx.NUMERO_PROCESADO_MAX+1;
//            modo = deliveryModo.proporcionarModo(this);
//        }
//    }
//
//    public void volverAlTrbajo(){
//        if (numeroProcesado > ModoNormal.NUMERO_PROCESADO_MAX){
//            if (Math.random() < 0.5) {
//                numeroProcesado = 0;
//            } else {
//                numeroProcesado = ModoProductivx.NUMERO_PROCESADO_MAX+1;
//            }
//        }
//        modo = deliveryModo.proporcionarModo(this);
//    }

}
