package edu.upv.poo;

import java.util.ArrayList;

/**
 *
 * @author nahum
 */
public class SubjectFrame extends javax.swing.JFrame {

    private final ArrayList<MensajeListener> mensajeListeners = 
            new ArrayList<>();
    
    /**
     * Creates new form SubjectFrame
     */
    public SubjectFrame() {
        initComponents();
    }
    
    public void addMensajeListener(MensajeListener l) {
        if(l != null) mensajeListeners.add(l);
    }
    
    public void removeMensajeListener(MensajeListener l) {
        if (l != null) mensajeListeners.remove(l);
    }
    
    private void notifyMensaje(String mensaje) {
        if (mensaje == null || mensaje.isEmpty()) return;
        for (MensajeListener l : mensajeListeners) {
            MensajeEvent e = new MensajeEvent(this, mensaje);
            l.mensajeRecibido(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.JLabel lblMensaje = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JTextField();
        javax.swing.JButton btnEnviarMensaje = new javax.swing.JButton();
        // Variables declaration - do not modify                     
        javax.swing.JButton btnCrearReceptorMensajes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SubjectFtame");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblMensaje.setText("Mensaje:");

        btnEnviarMensaje.setText("Enviar Mensaje");
        btnEnviarMensaje.addActionListener(this::btnEnviarMensajeActionPerformed);

        btnCrearReceptorMensajes.setText("Crear Receptor Mensajes");
        btnCrearReceptorMensajes.addActionListener(this::btnCrearReceptorMensajesActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEnviarMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCrearReceptorMensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEnviarMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearReceptorMensajes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnEnviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarMensajeActionPerformed
        notifyMensaje(txtMensaje.getText());
        txtMensaje.setText("");
    }//GEN-LAST:event_btnEnviarMensajeActionPerformed

    private void btnCrearReceptorMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearReceptorMensajesActionPerformed
        ReceptorMensajesFrame receptorMensajesFrame = 
                new ReceptorMensajesFrame(this);
        addMensajeListener(receptorMensajesFrame);
        receptorMensajesFrame.setVisible(true);
    }//GEN-LAST:event_btnCrearReceptorMensajesActionPerformed


    private javax.swing.JTextField txtMensaje;
    // End of variables declaration                   
}
