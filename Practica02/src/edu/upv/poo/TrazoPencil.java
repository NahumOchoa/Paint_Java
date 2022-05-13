package edu.upv.poo;

import java.awt.*;

/**
 * Esta clase representa un trazo de un lapiz
 * @author nahum
 */
public class TrazoPencil {
    
    private final Point point;
    private final Color color;
    private final int size;
    
    public TrazoPencil(Point point, Color color, int size) {
        this.point = point;
        this.color = color;
        this.size = size;
    }
    
    public final Point getPoint() { return point; }
    
    public final Color getColor() { return color; }
    
    public final int getSize() { return size; }
    
    public final int getX() { return (int)getPoint().getX(); }
    
    public final int getY() { return (int)getPoint().getY(); }
    /**
    * Metodo hecho para el dibujo de un lapiz
    */  
    public void draw(Graphics2D g) {
        
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getSize(), getSize());
        
        
    } 
    
}
