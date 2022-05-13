package edu.upv.poo;


/**
 * Esta clase represente el argumento del evento que nos 
 * indica que se cambio de herramienta
 * @author nahum
 */
public class ModoChangedEvent {
    
    private final int modo;
    
    public ModoChangedEvent(int nuevoModo) {
        this.modo = nuevoModo;
    }
    
    public int getModo() { return modo; }
    
}
