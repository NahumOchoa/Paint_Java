package edu.upv.poo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author nahum
 */
public class PaintPanel extends JPanel {

    private final ToolsEvents toolsEvents = new ToolsEvents();

    private final ArrayList<TrazoPencil> trazosPencil = new ArrayList<>();

    private final ArrayList<TrazoLinea> trazosLinea = new ArrayList<>();
    private final ArrayList<TrazoLinea> trazosLineaFinal = new ArrayList<>();

    private final ArrayList<TrazoCirculo> trazosCirculo = new ArrayList<>();
    private final ArrayList<TrazoCirculo> trazosCirculoFinal = new ArrayList<>();
    private final ArrayList<TrazoRect> trazosRectangulo = new ArrayList<>();
    private final ArrayList<TrazoRect> trazosRectanguloFinal = new ArrayList<>();

    private final ArrayList<MouseEvent> clicks = new ArrayList<>();
    
    private TrazoLinea lineAux;

    private Color colorActual = Color.BLACK;
    private int sizeActual = 20;
    private float [] colorAux = null;

    private final int MODO_LIBRE = 1;
    private final int MODO_LINEA = 2;
    private final int MODO_CIRCULO = 3;
    private final int MODO_RECTANGULO = 4;
    private int modo = MODO_LIBRE;

    public PaintPanel() {

        PaintPanelMouseEvents mouseEvents = new PaintPanelMouseEvents();
        addMouseListener(mouseEvents);
        addMouseMotionListener(mouseEvents);

    }

    public Color getColorActual() {
        return colorActual;
    }

    public void setColorActual(Color value) {
        colorActual = value;
    }

    public int getSizeActual() {
        return sizeActual;
    }

    public void setSizeActual(int size) {
        sizeActual = size;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int nuevoModo) {
        modo = nuevoModo;
    }

    public ToolsListener getToolsListener() {
        return toolsEvents;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        draw(g2);
    }

    private void draw(Graphics2D g) {
        trazosPencil.forEach(t -> {
            t.draw(g);
        });
        trazosLineaFinal.forEach(t -> {
            t.dibujarLinea(g);
        });
         trazosLinea.forEach(t -> {
            t.dibujarLinea(g);
        });
        trazosCirculoFinal.forEach(t -> {
            t.dibujarCirculo(g);
        });
        trazosCirculo.forEach(t -> {
            t.dibujarCirculo(g);
        });
        trazosRectanguloFinal.forEach(t -> {
            t.dibujarRectangulo(g);
        });

        trazosRectangulo.forEach(t -> {
            t.dibujarRectangulo(g);
        });
        
    }

    class PaintPanelMouseEvents implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // System.out.printf("CLICK @ %d, %d\n", e.getX(), e.getY());
            if (modo == MODO_LIBRE) {
                TrazoPencil trazo = new TrazoPencil(e.getPoint(), getColorActual(), getSizeActual());
                trazosPencil.add(trazo);
                repaint();
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // System.out.printf("PRESSED @ %d, %d\n", e.getX(), e.getY());
            switch (modo) {
                case MODO_LIBRE:
                    TrazoPencil trazo = new TrazoPencil(e.getPoint(), getColorActual(), getSizeActual());
                    trazosPencil.add(trazo);
                    break;
                case MODO_LINEA:
                    clicks.add(0, e);
                    break;
                case MODO_CIRCULO:
                    clicks.add(0, e);
                    break;
                case MODO_RECTANGULO:
                    clicks.add(0, e);
                    break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // System.out.printf("RELEASED @ %d, %d\n", e.getX(), e.getY());
            switch (modo) {
                 case MODO_LIBRE:
                    TrazoPencil trazo = new TrazoPencil(e.getPoint(), getColorActual(), getSizeActual());
                    trazosPencil.add(trazo);
                    break;
                case MODO_LINEA:
                    
                    clicks.add(1, e);
                    TrazoLinea linea = new TrazoLinea(clicks, colorActual,getSizeActual());
                    trazosLineaFinal.add(linea);
                    break;
                case MODO_CIRCULO:
                    clicks.add(1, e);
                    TrazoCirculo circulo = new TrazoCirculo(clicks, colorActual,getSizeActual());
                    trazosCirculoFinal.add(circulo);
                    break;
                case MODO_RECTANGULO:
                    clicks.add(1, e);
                    TrazoRect rectangulo = new TrazoRect(clicks, colorActual,getSizeActual());
                    trazosRectanguloFinal.add(rectangulo);
                    break;
            }
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // System.out.printf("ENTERED @ %d, %d\n", e.getX(), e.getY());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // System.out.printf("EXIT @ %d, %d\n", e.getX(), e.getY());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            switch (modo) {
                case MODO_LIBRE:
                    TrazoPencil trazo = new TrazoPencil(e.getPoint(), getColorActual(), getSizeActual());
                    trazosPencil.add(trazo);
                    repaint();
                    break;
                case MODO_LINEA:
                    clicks.add(1, e);   
                    TrazoLinea linea = new TrazoLinea(clicks, new Color(getColorActual().getRed()
                            ,getColorActual().getGreen()
                            ,getColorActual().getBlue(),60) 
                            ,getSizeActual());
                    trazosLinea.add(linea);
                    lineAux = linea;
                    try {
                        int lineaAnterior = trazosLinea.size()-3;
                        
                        trazosLinea.remove(lineaAnterior);
                        
                        
                        repaint();
                    } catch (IndexOutOfBoundsException ex) {
                        return;
                    }
                    
                    break;
                case MODO_CIRCULO:
                    clicks.add(1, e);
                    TrazoCirculo circulo = new TrazoCirculo(clicks, new Color(getColorActual().getRed()
                            ,getColorActual().getGreen()
                            ,getColorActual().getBlue(),60) 
                            ,getSizeActual());
                    trazosCirculo.add(circulo);
                    try {
                        int circuloAnterior = trazosCirculo.size() - 3;
                        trazosCirculo.remove(circuloAnterior);
                        repaint();
                    } catch (IndexOutOfBoundsException ex) {
                        return;
                    }
                    break;
                case MODO_RECTANGULO:
                    clicks.add(1, e);
                    TrazoRect rectangulo = new TrazoRect(clicks, new Color(getColorActual().getRed()
                            ,getColorActual().getGreen()
                            ,getColorActual().getBlue(),60) 
                            ,getSizeActual());
                    trazosRectangulo.add(rectangulo);
                    try {
                        int rectanguloAnterior = trazosRectangulo.size() - 3;
                        trazosRectangulo.remove(rectanguloAnterior);
                        repaint();
                    } catch (IndexOutOfBoundsException ex) {
                        return;
                    }
                    break;
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // System.out.printf("MOVED @ %d, %d\n", e.getX(), e.getY());
        }

    }

    class ToolsEvents implements ToolsListener {

        @Override
        public void colorChanged(ColorChangedEvent e) {
            setColorActual(e.getColor());
        }

        @Override
        public void trazoChanged(TrazoChangedEvent e) {
            setSizeActual(e.getTrazo());
        }

        @Override
        public void modoChanged(ModoChangedEvent e) {
            setModo(e.getModo());
        }

    }

}
