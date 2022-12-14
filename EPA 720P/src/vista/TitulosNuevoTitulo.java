/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlNivel;
import controlador.CtrlTitulo;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modelo.Nivel;
import modelo.Titulo;
import static vista.PantallaEPA.desktopPane;

/**
 *
 * @author Leonel
 */
public class TitulosNuevoTitulo extends javax.swing.JInternalFrame {
    CtrlTitulo ctrlTitulo = new CtrlTitulo();
    CtrlNivel ctrlNivel = new CtrlNivel();
    Titulo titulo = new Titulo();
    Nivel nivel = new Nivel();
    List<Nivel> listaNiveles = new ArrayList();
    /**
     * Creates new form NuevoTitulo
     */
    public TitulosNuevoTitulo() {
        initComponents();
        cargarCbxNivel();
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = this.getSize();
        this.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
    }
    public void cargarCbxNivel()
    {
        listaNiveles = ctrlNivel.leerTodos();
        for(int i=0; i< listaNiveles.size(); i++){
            cbxNivel.addItem(listaNiveles.get(i).getNivel());
        }
    }
    
    public Boolean validar()
    {
        txtTitulo.setBorder(new JTextField().getBorder());
        Boolean validar = false;
        Boolean mostrarMsj = false;
        if(txtTitulo.getText().equals(""))
        {
            txtTitulo.setBorder(new LineBorder(Color.RED, 2));
            txtTitulo.requestFocus();
            mostrarMsj = true;
        }else
            if(cbxNivel.getSelectedItem() == null && mostrarMsj == false)
            {
                JOptionPane.showMessageDialog(null, "Antes de continuar debe registrar Niveles");
                mostrarMsj = true;
            }else{
                validar = true;
            }
        return validar;
    }
    
    public void crearTitulo()
    {
        if(validar() == true)
        {
            titulo = ctrlTitulo.leerTitulo(txtTitulo.getText().toUpperCase());
            if(titulo!=null)
            {
                JOptionPane.showMessageDialog(null, "Este Titulo ya existe");
                txtTitulo.requestFocus();
            }else{
                titulo = new Titulo();
                titulo.setTitulo(txtTitulo.getText().toUpperCase());
                titulo.setNivel(ctrlNivel.leerNivel(cbxNivel.getSelectedItem().toString()));
                ctrlTitulo.crearTitulo(titulo);
                dispose();
                PersonalRegistroDePersonal.cargarCbxTitulo();
                PersonalRegistroDePersonal.cbxTitulo.setSelectedItem(txtTitulo.getText().toUpperCase());
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
        jLabel2 = new javax.swing.JLabel();
        cbxNivel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Nuevo Titulo");

        jPanel1.setBackground(new java.awt.Color(64, 207, 255));

        jLabel2.setText("Nivel");

        jLabel1.setText("Titulo");

        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTituloKeyTyped(evt);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 297, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void txtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyTyped
        if(txtTitulo.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtTituloKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        crearTitulo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        PersonalRegistroDePersonal.cargarCbxTitulo();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
