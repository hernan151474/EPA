/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlEstadoCivil;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modelo.EstadoCivil;
import static vista.PantallaEPA.desktopPane;

/**
 *
 * @author Leonel
 */
public class EstadosCivilesNuevoEstadoCivil extends javax.swing.JInternalFrame {
    CtrlEstadoCivil ctrlEstadoCivil = new CtrlEstadoCivil();
    EstadoCivil estadoCivil = new EstadoCivil();
    /**
     * Creates new form NuevoEstadoCivil
     */
    public EstadosCivilesNuevoEstadoCivil() {
        initComponents();
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = this.getSize();
        this.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
    }
    public Boolean validar()
    {
        txtEstadoCivil.setBorder(new JTextField().getBorder());
        Boolean validar = false;
        if(txtEstadoCivil.getText().equals(""))
        {
            txtEstadoCivil.setBorder(new LineBorder(Color.RED, 2));
            txtEstadoCivil.requestFocus();
        }else{
            validar = true;
        }
        return validar;
    }
    
    public void crearEstadoCivil()
    {
        if(validar() == true)
        {
            estadoCivil = ctrlEstadoCivil.leerEstadoCivil(txtEstadoCivil.getText().toUpperCase());
            if(estadoCivil!=null)
            {
                JOptionPane.showMessageDialog(null, "Este Estado Civil ya existe");
                txtEstadoCivil.requestFocus();
            }else{
                estadoCivil = new EstadoCivil();
                estadoCivil.setEstadoCivil(txtEstadoCivil.getText().toUpperCase());
                ctrlEstadoCivil.crearEstadoCivil(estadoCivil);
                dispose();
                PersonalRegistroDePersonal.cargarCbxEstadoCivil();
                PersonalRegistroDePersonal.cbxEstadoCivil.setSelectedItem(txtEstadoCivil.getText().toUpperCase());
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEstadoCivil = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Nuevo Estado Civil");

        jPanel1.setBackground(new java.awt.Color(64, 207, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estadoCivil.png"))); // NOI18N
        jLabel1.setText("Estado Civil");

        txtEstadoCivil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadoCivilKeyTyped(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(0, 51, 51));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 51, 51));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(155, 155, 155))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEstadoCivilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoCivilKeyTyped
        if(txtEstadoCivil.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtEstadoCivilKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        crearEstadoCivil();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        PersonalRegistroDePersonal.cargarCbxEstadoCivil();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEstadoCivil;
    // End of variables declaration//GEN-END:variables
}
