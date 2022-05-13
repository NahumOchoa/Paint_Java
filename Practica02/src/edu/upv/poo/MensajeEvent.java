package edu.upv.poo;

import java.util.EventObject;

/**
 *  Esta clase represente el argumento del evento que nos 
 * indica el cambio de los mensajes
 * @author nahum
 */
public class MensajeEvent extends EventObject {
    
    private final String mensaje;
    
    public MensajeEvent(Object source, String mensaje) {
        super(source);
        this.mensaje = mensaje;
    }
    
    public String getMensaje() { return mensaje; }
    
}
