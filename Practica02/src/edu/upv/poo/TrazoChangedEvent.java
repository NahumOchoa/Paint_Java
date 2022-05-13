package edu.upv.poo;

import java.util.EventObject;

/**
 * Esta clase representa el argumento del cambio
 * del tamaño del trazo
 * @author nahum
 */
public class TrazoChangedEvent extends EventObject {

    private final int trazo;
    
    public TrazoChangedEvent (Object source, int trazo) {
        super(source);
        this.trazo = trazo;
    }
    
    public int getTrazo() { return trazo; }
}
