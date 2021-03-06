/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upv.poo;


import java.awt.BorderLayout;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Este frame represente el menu de seleccion de herramientas
 *
 * @author nahum
 */
public class PaintToolboxFrame extends javax.swing.JFrame implements ToolsListener {

    private final ArrayList<ToolsListener> toolsListeners = new ArrayList<>();
    
    private final PaintPanel paintPanel = new PaintPanel();

    /**
     * Creates new form PaintToolboxFrame2
     */
    public PaintToolboxFrame() {
        initComponents();
        

        paintPanel.setSize(mainPanel.getWidth(), mainPanel.getHeight());
        paintPanel.setLocation(0,0);
        paintPanel.setBackground(Color.white);
        mainPanel.add(paintPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.setBackground(Color.white);
        
    }
    
    public PaintPanel getPaintPanel() { return paintPanel; }
    
    public ToolsListener getToolsListener() {
        return paintPanel.getToolsListener();
    }
 
    public void addToolsListener(ToolsListener l) {
        if (l != null) {
            toolsListeners.add(l);
        }
    }

    public void removeToolsListeners(ToolsListener l) {
        if (l != null) {
            toolsListeners.remove(l);
        }
    }

    private void notifyColorChanged(Color color, String colorName) {
        for (ToolsListener l : toolsListeners) {
            ColorChangedEvent e = new ColorChangedEvent(this, color, colorName);
            l.colorChanged(e);
        }
    }

    private void notifyTrazoChanged(int trazo) {
        for (ToolsListener l : toolsListeners) {
            TrazoChangedEvent e = new TrazoChangedEvent(this, trazo);
            l.trazoChanged(e);
        }
    }

    private void notifyModoChanged(int modo) {
        for (ToolsListener l : toolsListeners) {
            ModoChangedEvent e = new ModoChangedEvent(modo);
            l.modoChanged(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCcolor = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        btnColorAzul = new javax.swing.JButton();
        btnColorRojo = new javax.swing.JButton();
        lblTool = new javax.swing.JLabel();
        btnColorNegro = new javax.swing.JButton();
        jSliCambiarTexto = new javax.swing.JSlider();
        btnLibre = new javax.swing.JButton();
        btnRectangulo = new javax.swing.JButton();
        btnCirculo = new javax.swing.JButton();
        btnRecta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        mainPanel = new javax.swing.JPanel();
        btnColorCyan = new javax.swing.JButton();
        btnColorDarkGrey = new javax.swing.JButton();
        btnColorWhite = new javax.swing.JButton();
        btnColorGray = new javax.swing.JButton();
        btnColorPink = new javax.swing.JButton();
        btnColorOrange = new javax.swing.JButton();
        btnColorYellow = new javax.swing.JButton();
        btnColorGreen = new javax.swing.JButton();
        btnColorMagenta = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnTriangulo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        labelCcolor.setText("Selecciona un color");

        lblSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSize.setText("Tama??o actual del trazo: 20");
        lblSize.setToolTipText("");

        btnColorAzul.setBackground(new java.awt.Color(0, 0, 204));
        btnColorAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorAzulActionPerformed(evt);
            }
        });

        btnColorRojo.setBackground(new java.awt.Color(255, 0, 0));
        btnColorRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorRojoActionPerformed(evt);
            }
        });

        lblTool.setText("Herramientas: Lapiz");

        btnColorNegro.setBackground(new java.awt.Color(0, 0, 0));
        btnColorNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorNegroActionPerformed(evt);
            }
        });

        jSliCambiarTexto.setMinimum(1);
        jSliCambiarTexto.setValue(20);
        jSliCambiarTexto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliCambiarTextoStateChanged(evt);
            }
        });

        btnLibre.setText("Lapiz");
        btnLibre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibreActionPerformed(evt);
            }
        });

        btnRectangulo.setText("Rectangulo");
        btnRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectanguloActionPerformed(evt);
            }
        });

        btnCirculo.setText("Circulo");
        btnCirculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoActionPerformed(evt);
            }
        });

        btnRecta.setText("Recta");
        btnRecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectaActionPerformed(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        btnColorCyan.setBackground(java.awt.Color.cyan);
        btnColorCyan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorCyanActionPerformed(evt);
            }
        });

        btnColorDarkGrey.setBackground(java.awt.Color.darkGray);
        btnColorDarkGrey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorDarkGreyActionPerformed(evt);
            }
        });

        btnColorWhite.setBackground(java.awt.Color.lightGray);
        btnColorWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorWhiteActionPerformed(evt);
            }
        });

        btnColorGray.setBackground(java.awt.Color.gray);
        btnColorGray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorGrayActionPerformed(evt);
            }
        });

        btnColorPink.setBackground(java.awt.Color.pink);
        btnColorPink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorPinkActionPerformed(evt);
            }
        });

        btnColorOrange.setBackground(java.awt.Color.orange);
        btnColorOrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorOrangeActionPerformed(evt);
            }
        });

        btnColorYellow.setBackground(java.awt.Color.yellow);
        btnColorYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorYellowActionPerformed(evt);
            }
        });

        btnColorGreen.setBackground(java.awt.Color.green);
        btnColorGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorGreenActionPerformed(evt);
            }
        });

        btnColorMagenta.setBackground(java.awt.Color.magenta);
        btnColorMagenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorMagentaActionPerformed(evt);
            }
        });

        btnTriangulo.setText("Triangulo");
        btnTriangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton1.setText("Borrador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCcolor)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnColorPink, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorMagenta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorCyan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorGray, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnColorYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorOrange, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnColorDarkGrey, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnColorNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRectangulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCirculo, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(btnRecta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblTool))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTriangulo, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSize, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSliCambiarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSliCambiarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTool)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCirculo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLibre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTriangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRecta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addComponent(btnRectangulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelCcolor)
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnColorPink, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnColorMagenta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnColorOrange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnColorAzul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnColorGreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnColorYellow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnColorGray, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnColorNegro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnColorDarkGrey, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnColorWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnColorCyan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnColorAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorAzulActionPerformed
        notifyColorChanged(Color.BLUE, "Azul");
    }//GEN-LAST:event_btnColorAzulActionPerformed

    private void btnColorRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorRojoActionPerformed
        notifyColorChanged(Color.RED, "Rojo");
    }//GEN-LAST:event_btnColorRojoActionPerformed

    private void btnColorNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorNegroActionPerformed
        notifyColorChanged(Color.BLACK, "Negro");
    }//GEN-LAST:event_btnColorNegroActionPerformed

    
    private void jSliCambiarTextoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliCambiarTextoStateChanged
        try {
            int sizeTrazo = jSliCambiarTexto.getValue();
            System.out.println("Trazo: " + sizeTrazo);
            notifyTrazoChanged(sizeTrazo);
            lblSize.setText("Tama??o actual del trazo: " + sizeTrazo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El valor del tama??o del trazo debe ser numerico y entero.");
        }


    }//GEN-LAST:event_jSliCambiarTextoStateChanged

    private void btnCirculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoActionPerformed
        
        notifyModoChanged(3);
        lblTool.setText("Herramienta: Circulo");
    }//GEN-LAST:event_btnCirculoActionPerformed

    private void btnRectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectaActionPerformed
        notifyModoChanged(2);
        lblTool.setText("Herramienta: Recta");
    }//GEN-LAST:event_btnRectaActionPerformed

    private void btnRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectanguloActionPerformed
        notifyModoChanged(4);
        lblTool.setText("Herramienta: Cuadrado");
    }//GEN-LAST:event_btnRectanguloActionPerformed

    private void btnLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibreActionPerformed
        notifyModoChanged(1);
        lblTool.setText("Herramienta: Lapiz");
    }//GEN-LAST:event_btnLibreActionPerformed

    private void btnColorCyanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorCyanActionPerformed
        notifyColorChanged(Color.CYAN, "Cyan");
    }//GEN-LAST:event_btnColorCyanActionPerformed

    private void btnColorDarkGreyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorDarkGreyActionPerformed
        notifyColorChanged(Color.DARK_GRAY, "Gris oscuro");
    }//GEN-LAST:event_btnColorDarkGreyActionPerformed

    private void btnColorWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorWhiteActionPerformed
        notifyColorChanged(Color.lightGray, "gray");
    }//GEN-LAST:event_btnColorWhiteActionPerformed

    private void btnColorGrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorGrayActionPerformed
        notifyColorChanged(Color.GRAY, "Gris");
    }//GEN-LAST:event_btnColorGrayActionPerformed

    private void btnColorPinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorPinkActionPerformed
        notifyColorChanged(Color.PINK, "Rosa");
    }//GEN-LAST:event_btnColorPinkActionPerformed

    private void btnColorOrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorOrangeActionPerformed
        notifyColorChanged(Color.ORANGE, "Naranja");
    }//GEN-LAST:event_btnColorOrangeActionPerformed

    private void btnColorYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorYellowActionPerformed
        notifyColorChanged(Color.YELLOW, "Amarillo");
    }//GEN-LAST:event_btnColorYellowActionPerformed

    private void btnColorGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorGreenActionPerformed
        notifyColorChanged(Color.GREEN, "Verde");
    }//GEN-LAST:event_btnColorGreenActionPerformed

    private void btnColorMagentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorMagentaActionPerformed
        notifyColorChanged(Color.MAGENTA, "Magenta");
    }//GEN-LAST:event_btnColorMagentaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
       JFileChooser f = new JFileChooser();
       f.showSaveDialog(null);
       BufferedImage screenshotImage = new BufferedImage(
                this.getBounds().width, this.getBounds().height,
                BufferedImage.TYPE_INT_RGB);
        this.paint(screenshotImage.getGraphics());
        try {
            BufferedImage dest = screenshotImage.getSubimage(mainPanel.getBounds().x, mainPanel.getBounds().y+15, mainPanel.getBounds().width, mainPanel.getBounds().height);
            ImageIO.write(dest, "png", new File(f.getSelectedFile()+".png" ));
        } catch (IOException ex) {
            System.err.println("ImageIsuues");
        }
         
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnTrianguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrianguloActionPerformed
        notifyModoChanged(5);
        lblTool.setText("Herramienta: Triangulo");
    }//GEN-LAST:event_btnTrianguloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       notifyColorChanged(Color.WHITE, "");
       
       notifyModoChanged(1);
       lblTool.setText("Herramienta: Borrador");
       
       
    }//GEN-LAST:event_jButton1ActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaintToolboxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaintToolboxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaintToolboxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaintToolboxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaintToolboxFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCirculo;
    private javax.swing.JButton btnColorAzul;
    private javax.swing.JButton btnColorCyan;
    private javax.swing.JButton btnColorDarkGrey;
    private javax.swing.JButton btnColorGray;
    private javax.swing.JButton btnColorGreen;
    private javax.swing.JButton btnColorMagenta;
    private javax.swing.JButton btnColorNegro;
    private javax.swing.JButton btnColorOrange;
    private javax.swing.JButton btnColorPink;
    private javax.swing.JButton btnColorRojo;
    private javax.swing.JButton btnColorWhite;
    private javax.swing.JButton btnColorYellow;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLibre;
    private javax.swing.JButton btnRecta;
    private javax.swing.JButton btnRectangulo;
    private javax.swing.JButton btnTriangulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSlider jSliCambiarTexto;
    private javax.swing.JLabel labelCcolor;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblTool;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

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
            case 5:
                System.out.println("Cambio a modo cuadrado.");
                break;
                
        }
    }

}
