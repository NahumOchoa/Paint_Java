package edu.upv.poo;
/**
 * Esta clase representa la clase principal de el programa
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
        new MainForm().setVisible(false);
        PaintFrame paintFrame = new PaintFrame();
        PaintToolboxFrame paintToolboxFrame = new PaintToolboxFrame();
        paintFrame.setLocation(paintToolboxFrame.getWidth(), 0);
        paintFrame.setVisible(true);
        paintToolboxFrame.addToolsListener(paintFrame);
        paintToolboxFrame.addToolsListener(
                paintFrame.getPaintPanel().getToolsListener());
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
        
        SubjectFrame subjectFrame = new SubjectFrame();
        MensajeListener mensajeListener = e -> System.out.println(
                    "Mensaje recibido en clase app. => " + e.getMensaje());
        subjectFrame.addMensajeListener(mensajeListener);
        
        subjectFrame.addMensajeListener(this::recibirMensajeDesdeSubjectFrame);
        MensajeListener mensajeListenerFunc = e -> System.out.println(
                "mensajeListenerFunc =>" + e.getMensaje());
        subjectFrame.addMensajeListener(mensajeListenerFunc);
        subjectFrame.setVisible(false);
    }
    
    private void recibirMensajeDesdeSubjectFrame(MensajeEvent e) {
        System.out.println(
                "recibirMensajeDesdeSubjectFrame() => " + e.getMensaje());
    }
}
