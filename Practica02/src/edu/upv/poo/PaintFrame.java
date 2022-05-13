package edu.upv.poo;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Esta clase represente el argumento de los cambios de herramientas 
 * en el panel principal
 * @author nahum
 */
public class PaintFrame extends JFrame implements ToolsListener {
    
    private final PaintPanel paintPanel = new PaintPanel();
    
    public PaintFrame() {
        super("My Paint App");
        initComponents();
    }
    
    private void initComponents() {
        add(paintPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 720);
    }
    
    public PaintPanel getPaintPanel() { return paintPanel; }
    
    public ToolsListener getToolsListener() {
        return paintPanel.getToolsListener();
    }

    @Override
    public void colorChanged(ColorChangedEvent e) {
        System.out.println("Cambio de color del trazo a " + e.getColorName());
        paintPanel.setColorActual(e.getColor());
    }
    
    @Override
    public void trazoChanged(TrazoChangedEvent e) {
        System.out.println("Cambio de trazo a " +  e.getTrazo());
        paintPanel.setSizeActual(e.getTrazo());
    }

    @Override
    public void modoChanged(ModoChangedEvent e) {
        paintPanel.setModo(e.getModo());
        switch(paintPanel.getModo()) {
            case 1: 
                System.out.println("Cambio a modo libre.");
                break;
            case 2:
                System.out.println("Cambio a modo linea.");
                break;
            case 3:
                System.out.println("Cambio a modo circulo.");
                break;
            case 4:
                System.out.println("Cambio a modo cuadrado.");
                break;
        }
    }
}
