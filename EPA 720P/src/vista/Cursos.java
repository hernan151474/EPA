/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlCurso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modelo.Curso;

/**
 *
 * @author Leonel
 */
public class Cursos extends javax.swing.JInternalFrame {
    CtrlCurso ctrlCurso = new CtrlCurso();
    Curso curso = new Curso();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    List<Curso> listaCursos = new ArrayList();
    int idCurso;
    /**
     * Creates new form Cursos
     */
    public Cursos() {
        initComponents();
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    public void cargarTabla()
    {
        modeloTabla = (DefaultTableModel) tblCursos.getModel();
        String[] fila = new String[1];
        modeloTabla.setRowCount(0);
        listaCursos = ctrlCurso.leerTodos();
        
        for(int i=0; i< listaCursos.size(); i++){
            fila[0] = listaCursos.get(i).getCurso();
            modeloTabla.addRow(fila);
        }
        tblCursos.setModel(modeloTabla);
    }
    
    public void limpiar()
    {
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtCurso.setText("");
        idCurso = 0;
        txtCurso.requestFocus();
    }
    
    public Boolean validar()
    {
        txtCurso.setBorder(new JTextField().getBorder());
        Boolean validar = false;
        if(txtCurso.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar Curso");
            txtCurso.setBorder(new LineBorder(Color.RED, 2));
            txtCurso.requestFocus();
        }else{
            validar = true;
        }
        return validar;
    }
    
    public void crearCurso()
    {
        if(validar() == true)
        {
            curso = ctrlCurso.leerCurso(txtCurso.getText().toUpperCase());
            if(curso!=null)
            {
                JOptionPane.showMessageDialog(null, "Este Curso ya existe");
                txtCurso.requestFocus();
            }else{
                curso = new Curso();
                curso.setCurso(txtCurso.getText().toUpperCase());
                ctrlCurso.crearCurso(curso);
                limpiar();
            }
        }
    }
    
    public void modificarCurso()
    {
        if(validar() == true)
        {
            curso = ctrlCurso.leerCurso(txtCurso.getText().toUpperCase());
            if(curso!=null)
            {
                JOptionPane.showMessageDialog(null, "Este Curso ya existe");
                txtCurso.requestFocus();
            }else{
                curso = new Curso();
                curso.setIdCurso(idCurso);
                curso.setCurso(txtCurso.getText().toUpperCase());
                ctrlCurso.modificarCurso(curso);
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
        txtCurso = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();

        setTitle("Cursos");

        jPanel1.setBackground(new java.awt.Color(64, 207, 255));

        jLabel1.setText("Curso");

        txtCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCursoKeyTyped(evt);
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

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CURSOS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCursosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCursos);
        if (tblCursos.getColumnModel().getColumnCount() > 0) {
            tblCursos.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCurso)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
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
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        crearCurso();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea modificar el curso?","Modificar",confirmar);
        if (respuesta == 0 )
        {
            modificarCurso();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea eliminar el curso?","Eliminar",confirmar);
        if (respuesta == 0 )
        {
            ctrlCurso.eliminarCurso(curso);
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursosMousePressed
        int FilaSelec = tblCursos.getSelectedRow();
        txtCurso.setText(tblCursos.getValueAt(FilaSelec, 0).toString());
        curso = ctrlCurso.leerCurso(txtCurso.getText());
        idCurso = curso.getIdCurso();
        txtCurso.requestFocus();
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblCursosMousePressed

    private void txtCursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCursoKeyTyped
        if(txtCurso.getText().length() == 10){
            evt.consume();
        }
    }//GEN-LAST:event_txtCursoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextField txtCurso;
    // End of variables declaration//GEN-END:variables
}
