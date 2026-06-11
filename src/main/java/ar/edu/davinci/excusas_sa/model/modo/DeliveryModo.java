package edu.davinci.modo;

import edu.davinci.empleado.responsable.Responsable;

import java.util.ArrayList;

public class DeliveryModo {
    private ArrayList<Modo> modos;

    public DeliveryModo() {
        modos = new ArrayList<>();
        agregarModo(new ModoProductivx());
        agregarModo(new ModoNormal());
        agregarModo(new ModoVagx());
    }

    public void agregarModo(Modo unModo){
        modos.add(unModo);
    }

    public void quitarModo(Modo unModo){
        modos.remove(unModo);
    }

    public Modo proporcionarModo(Responsable unResponsable){
        for(Modo unModo : modos){
            if (unModo.esAdecuado(unResponsable)){
                return unModo;
            }
        }
        throw new RuntimeException("No se encontro un modo adecuado");
    }
}
