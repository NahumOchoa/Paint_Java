package edu.upv.poo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Esta clase representa una linea trazada
 * @author nahum
 */
public class TrazoLinea {
    
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final Color color;
    private final int size;
    
    public final int getSize() { return size; }
    
    
   
    public TrazoLinea(ArrayList<MouseEvent> clicks, Color color, int size) {
        this.x1 = clicks.get(0).getX();
        this.y1 = clicks.get(0).getY();
        this.x2 = clicks.get(1).getX();
        this.y2 = clicks.get(1).getY();
        this.color = color;
        this.size = size;
    }
    
    /**
    * Metodo hecho para el dibujo de la recta
    */  
    public void dibujarLinea(Graphics2D g) {
        Graphics2D g1 = g;
        g.setColor(color);
        g.setStroke(new BasicStroke(getSize()));
        g.drawLine(x1, y1, x2, y2);
        
        
    }
}
