package edu.upv.poo;

import java.util.EventListener;

/**
 * Esta clase represente el listener de los mensajes
 * @author nahum
 */
public interface MensajeListener extends EventListener {
    
    void mensajeRecibido(MensajeEvent e);
    
}
