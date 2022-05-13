package edu.upv.poo;

import java.util.EventListener;

/**
 *  Esta clase represente el listener de las herramientas
 * @author nahum
 */
public interface ToolsListener extends EventListener {
    
    /**
     * Hace el cambio de color del trazo
     * @param e Evento
     */
    void colorChanged(ColorChangedEvent e);

    /**
     * Hace el cambio del grosor del trazo
     * @param e Evento
     */
    void trazoChanged(TrazoChangedEvent e);
    
    /**
     * Hace el cambio de herramienta
     * @param e Evento
     */
    void modoChanged(ModoChangedEvent e);
    
}
