package edu.upv.poo;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Esta clase representa un trazo rectangular
 * @author nahum
 */

public class TrazoRect {
    
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final Color color;
     private final int size;
    
    public TrazoRect(ArrayList<MouseEvent> clicks, Color color, int size) {
        this.x1 = clicks.get(0).getX();
        this.y1 = clicks.get(0).getY();
        this.x2 = clicks.get(1).getX();
        this.y2 = clicks.get(1).getY();
        this.color = color;
        this.size = size;
    }
    public final int getSize() { return size; }
    
    /**
    * Metodo hecho para el dibujo de un rectangulo
    */  
    public void dibujarRectangulo(Graphics2D g) {
        
        g.setColor(color);
        g.setStroke(new BasicStroke(getSize()));
        if (dibujarRectanguloPropiedades(g, x2 < x1, y2, y1, x1 < x2)) return;
        if (dibujarRectanguloPropiedades(g, x1 > x2, y1, y2, x2 > x1)) return;
    }
    
    private boolean dibujarRectanguloPropiedades(Graphics2D g, boolean b, int y2, int y1, boolean b2) {
        if (b && y2 < y1) {
            g.drawRect(x2, y2, x1 - x2, y1 - y2);
            return true;
        }
        if (b2 && y1 > y2) {
            g.drawRect(x1, y2, x2 - x1, y1 - y2);
            return true;
        }
        return false;
    }
}
