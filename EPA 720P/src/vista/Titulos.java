/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlNivel;
import controlador.CtrlTitulo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Nivel;
import modelo.Titulo;

/**
 *
 * @author Leonel
 */
public class Titulos extends javax.swing.JInternalFrame {
    CtrlTitulo ctrlTitulo = new CtrlTitulo();
    CtrlNivel ctrlNivel = new CtrlNivel();
    Titulo titulo = new Titulo();
    Nivel nivel = new Nivel();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    List<Titulo> listaTitulos = new ArrayList();
    List<Nivel> listaNiveles = new ArrayList();
    int idTitulo;
    /**
     * Creates new form Titulos
     */
    public Titulos() {
        initComponents();
        cargarCbxNivel();
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    public void cargarTabla()
    {
        modeloTabla = (DefaultTableModel) tblTitulos.getModel();
        String[] fila = new String[2];
        modeloTabla.setRowCount(0);
        listaTitulos = ctrlTitulo.leerTodos();
        
        for(int i=0; i< listaTitulos.size(); i++){
            fila[0] = listaTitulos.get(i).getTitulo();
            fila[1] = listaTitulos.get(i).getNivel().getNivel();
            modeloTabla.addRow(fila);
        }
        tblTitulos.setModel(modeloTabla); 
    }
    
    public void cargarCbxNivel()
    {
        listaNiveles = ctrlNivel.leerTodos();
        for(int i=0; i< listaNiveles.size(); i++){
            cbxNivel.addItem(listaNiveles.get(i).getNivel());
        }
    }
    
    public void limpiar()
    {
        txtTitulo.setText("");
        cbxNivel.setSelectedIndex(0);
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        idTitulo = 0;
        txtTitulo.requestFocus();
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
                limpiar();
            }
        }
    }
    
    public void modificarTitulo()
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
                titulo.setIdTitulo(idTitulo);
                titulo.setTitulo(txtTitulo.getText().toUpperCase());
                titulo.setNivel(ctrlNivel.leerNivel(cbxNivel.getSelectedItem().toString()));
                ctrlTitulo.modificarTitulo(titulo);
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
        txtTitulo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTitulos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxNivel = new javax.swing.JComboBox<>();

        setTitle("Titulos");

        jPanel1.setBackground(new java.awt.Color(64, 207, 255));

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

        tblTitulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TITULO", "NIVEL"
            }
        ));
        tblTitulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTitulosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblTitulos);
        if (tblTitulos.getColumnModel().getColumnCount() > 0) {
            tblTitulos.getColumnModel().getColumn(0).setResizable(false);
            tblTitulos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblTitulos.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Nivel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 339, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        crearTitulo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea modificar el titulo?","Modificar",confirmar);
        if (respuesta == 0 )
        {
            modificarTitulo();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea eliminar el titulo?","Eliminar",confirmar);
        if (respuesta == 0 )
        {
            ctrlTitulo.eliminarTitulo(titulo);
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblTitulosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTitulosMousePressed
        int FilaSelec = tblTitulos.getSelectedRow();
        txtTitulo.setText(tblTitulos.getValueAt(FilaSelec, 0).toString());
        cbxNivel.setSelectedItem(tblTitulos.getValueAt(FilaSelec, 1).toString());
        nivel = ctrlNivel.leerNivel(tblTitulos.getValueAt(FilaSelec, 1).toString());
        titulo = ctrlTitulo.leerTitulo(txtTitulo.getText(), nivel.getIdNivel());
        idTitulo = titulo.getIdTitulo();
        txtTitulo.requestFocus();
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblTitulosMousePressed

    private void txtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyTyped
        if(txtTitulo.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtTituloKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTitulos;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
