/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlCargo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modelo.Cargo;

/**
 *
 * @author Leonel
 */
public class Cargos extends javax.swing.JInternalFrame {
    CtrlCargo ctrlCargo = new CtrlCargo();
    Cargo cargo = new Cargo();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    List<Cargo> listaCargos = new ArrayList();
    int idCargo;
    /**
     * Creates new form Cargos
     */
    public Cargos() {
        initComponents();
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void cargarTabla()
    {
        modeloTabla = (DefaultTableModel) tblCargos.getModel();
        String[] fila = new String[1];
        modeloTabla.setRowCount(0);
        listaCargos = ctrlCargo.leerTodos();
        
        for(int i=0; i< listaCargos.size(); i++){
            fila[0] = listaCargos.get(i).getCargo();
            modeloTabla.addRow(fila);
        }
        tblCargos.setModel(modeloTabla);
    }
    
    public void limpiar()
    {
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        idCargo = 0;
        txtCargo.setText("");
        txtCargo.requestFocus();
    }
    
    public Boolean validar()
    {
        txtCargo.setBorder(new JTextField().getBorder());
        Boolean validar = false;
        if(txtCargo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar Cargo");
            txtCargo.setBorder(new LineBorder(Color.RED, 2));
            txtCargo.requestFocus();
        }else{
            validar = true;
        }
        return validar;
    }
    
    public void crearCargo()
    {
        if(validar() == true)
        {
            cargo = ctrlCargo.leerCargo(txtCargo.getText().toUpperCase());
            if(cargo!=null)
            {
                JOptionPane.showMessageDialog(null, "Este Cargo ya existe");
                txtCargo.requestFocus();
            }else{
                cargo = new Cargo();
                cargo.setCargo(txtCargo.getText().toUpperCase());
                ctrlCargo.crearCargo(cargo);
                limpiar();
            }
        }
    }
    
    public void modificarCargo()
    {
        if(validar() == true)
        {
            cargo = ctrlCargo.leerCargo(txtCargo.getText().toUpperCase());
            if(cargo!=null)
            {
                JOptionPane.showMessageDialog(null, "Este Cargo ya existe");
                txtCargo.requestFocus();
            }else{
                cargo = new Cargo();
                cargo.setIdCargo(idCargo);
                cargo.setCargo(txtCargo.getText().toUpperCase());
                ctrlCargo.modificarCargo(cargo);
                limpiar();
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
        txtCargo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();

        setTitle("Cargos");

        jPanel1.setBackground(new java.awt.Color(64, 207, 255));

        jLabel1.setText("Cargo");

        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCargoKeyTyped(evt);
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

        btnModificar.setBackground(new java.awt.Color(0, 51, 51));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar2.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CARGOS"
            }
        ));
        tblCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCargosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCargos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCargo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        crearCargo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblCargosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargosMousePressed
        int FilaSelec = tblCargos.getSelectedRow();
        txtCargo.setText(tblCargos.getValueAt(FilaSelec, 0).toString());
        cargo = ctrlCargo.leerCargo(txtCargo.getText());
        idCargo = cargo.getIdCargo();
        txtCargo.requestFocus();
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblCargosMousePressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"??Desea modificar el cargo?","Modificar",confirmar);
        if (respuesta == 0 )
        {
            modificarCargo();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"??Desea eliminar el cargo?","Eliminar",confirmar);
        if (respuesta == 0 )
        {
            ctrlCargo.eliminarCargo(cargo);
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
        if(txtCargo.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtCargoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCargos;
    private javax.swing.JTextField txtCargo;
    // End of variables declaration//GEN-END:variables
}
