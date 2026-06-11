package edu.davinci.empleado.responsable;

import edu.davinci.email.ConsoleEmailSender;
import edu.davinci.email.EmailSender;
import edu.davinci.empleado.Empleado;
import edu.davinci.excusa.Excusa;
import edu.davinci.modo.DeliveryModo;
import edu.davinci.modo.Modo;
import edu.davinci.modo.ModoNormal;
import edu.davinci.modo.ModoProductivx;

public abstract class Responsable extends Empleado implements IResponsable {
    private static final int MIN_MINUTOS_BREAK = 10;
    private static final int MAX_MINUTOS_BREAK = 15;
    private final Responsable seguente;
    private Modo modo;
    private DeliveryModo deliveryModo;
    private int numeroProcesado;
    protected final EmailSender emailSender = new ConsoleEmailSender();

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
        if (modo.puedeProcesar(this,unaExcusa)){
            modo.procesarExcusa(this,unaExcusa);
            numeroProcesado++;
            modo = deliveryModo.proporcionarModo(this);
        } else {
            seguente.revisarExcusa(unaExcusa);
        }
    }

    public void tomarCafe(){
        numeroProcesado = 0;
        modo = deliveryModo.proporcionarModo(this);
    }

    public void tomarBreak(int cantidadMinutos){
        if ((numeroProcesado > ModoNormal.NUMERO_PROCESADO_MAX)
                && (cantidadMinutos >= MIN_MINUTOS_BREAK)
                && (cantidadMinutos <= MAX_MINUTOS_BREAK)){
            numeroProcesado = ModoProductivx.NUMERO_PROCESADO_MAX+1;
            modo = deliveryModo.proporcionarModo(this);
        }
    }

    public void volverAlTrbajo(){
        if (numeroProcesado > ModoNormal.NUMERO_PROCESADO_MAX){
            if (Math.random() < 0.5) {
                numeroProcesado = 0;
            } else {
                numeroProcesado = ModoProductivx.NUMERO_PROCESADO_MAX+1;
            }
        }
        modo = deliveryModo.proporcionarModo(this);
    }

}
