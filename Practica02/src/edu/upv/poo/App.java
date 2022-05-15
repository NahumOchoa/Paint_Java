package edu.upv.poo;
/**
 * Esta clase representa la clase principal de el programa que tiene como objetivo emular un paint
 * 
 * @author nahum
 */
public class App {
    
    public static void main(String[] args) {
      
        new App().run();
    }
    
    public App() {
        
    }
    
    public void run() {
        PaintFrame paintFrame = new PaintFrame();
        PaintToolboxFrame paintToolboxFrame = new PaintToolboxFrame();
        //paintFrame.setLocation(paintToolboxFrame.getWidth(), 0);
        paintFrame.setVisible(false);
        paintToolboxFrame.addToolsListener(paintToolboxFrame);
        paintToolboxFrame.addToolsListener(
                paintToolboxFrame.getPaintPanel().getToolsListener());
        ToolsListener eventosTools = new ToolsListener() {
            @Override
            public void colorChanged(ColorChangedEvent e) {
                System.out.println("(eventosTools) Color cambiado a " + e.getColorName());
            }
            @Override
            public void trazoChanged(TrazoChangedEvent e) {
                System.out.println("(eventosTools) Trazo cambiado a " + e.getTrazo());
            }
            @Override
            public void modoChanged(ModoChangedEvent e) {
        
            }
        };
        paintToolboxFrame.addToolsListener(new ToolsListener() {
            @Override
            public void colorChanged(ColorChangedEvent e) {
                System.out.println("Color cambiado a " + e.getColorName());
            }
            @Override
            public void trazoChanged(TrazoChangedEvent e) {
                System.out.println("Trazo cambiado a " + e.getTrazo());
            }
            
            @Override
            public void modoChanged(ModoChangedEvent e) {
        
            }
        });
        paintToolboxFrame.setVisible(true);
        
        
    }
    
    
}
