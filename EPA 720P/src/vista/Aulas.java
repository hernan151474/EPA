/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlAula;
import controlador.CtrlCurso;
import controlador.CtrlDivision;
import controlador.CtrlTurno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Aula;
import modelo.Curso;
import modelo.Division;
import modelo.Turno;

/**
 *
 * @author Leonel
 */
public class Aulas extends javax.swing.JInternalFrame {
    CtrlAula ctrlAula = new CtrlAula();
    CtrlCurso ctrlCurso = new CtrlCurso();
    CtrlDivision ctrlDivision = new CtrlDivision();
    CtrlTurno ctrlTurno = new CtrlTurno();
    Aula aula = new Aula();
    Curso curso = new Curso();
    Division division = new Division();
    Turno turno = new Turno();
    List<Curso> listaCursos = new ArrayList();
    List<Division> listaDivisiones = new ArrayList();
    List<Turno> listaTurnos = new ArrayList();
    List<Aula> listaAulas = new ArrayList();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    int idAula;
    /**
     * Creates new form Aulas
     */
    public Aulas() {
        initComponents();
        cargarCbxCurso();
        cargarCbxDivision();
        cargarCbxTurno();
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void cargarTabla()
    {
        modeloTabla = (DefaultTableModel) tblAulas.getModel();
        String[] fila = new String[3];
        modeloTabla.setRowCount(0);
        listaAulas = ctrlAula.leerTodos();
        
        for(int i=0; i< listaAulas.size(); i++){
            fila[0] = listaAulas.get(i).getCurso().getCurso();
            fila[1] = listaAulas.get(i).getDivision().getDivision();
            fila[2] = listaAulas.get(i).getTurno().getTurno();
            modeloTabla.addRow(fila);
        }
        tblAulas.setModel(modeloTabla);
    }
    
    public void cargarCbxCurso()
    {
        listaCursos = ctrlCurso.leerTodos();
        for(int i=0; i< listaCursos.size(); i++){
            cbxCurso.addItem(listaCursos.get(i).getCurso());
        }
    }
    
    public void cargarCbxDivision()
    {
        listaDivisiones = ctrlDivision.leerTodos();
        for(int i=0; i< listaDivisiones.size(); i++){
            cbxDivision.addItem(listaDivisiones.get(i).getDivision());
        }
    }
    
    public void cargarCbxTurno()
    {
        listaTurnos = ctrlTurno.leerTodos();
        for(int i=0; i< listaTurnos.size(); i++){
            cbxTurno.addItem(listaTurnos.get(i).getTurno());
        }
    }

    public void limpiar()
    {
        cbxCurso.setSelectedIndex(0);
        cbxDivision.setSelectedIndex(0);
        cbxTurno.setSelectedIndex(0);
        cargarTabla();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        idAula = 0;
    }
    
    public Boolean validar()
    {
        Boolean validar = false;
        Boolean mostrarMsj = false;
        if(cbxCurso.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null, "Antes de continuar debe registrar Cursos");
            mostrarMsj = true;
        }else
            if(cbxDivision.getSelectedItem() == null && mostrarMsj == false)
            {
                JOptionPane.showMessageDialog(null, "Antes de continuar debe registrar Divisiones");
                mostrarMsj = true;
            }else
                if(cbxTurno.getSelectedItem() == null && mostrarMsj == false)
                {
                    JOptionPane.showMessageDialog(null, "Antes de continuar debe registrar Turnos");
                    mostrarMsj = true;
                }else{
                    validar = true;
                }
        return validar;
    }
    
    public void crearAula()
    {
        if(validar() == true)
        {
            aula.setCurso(ctrlCurso.leerCurso(cbxCurso.getSelectedItem().toString()));
            aula.setDivision(ctrlDivision.leerDivision(cbxDivision.getSelectedItem().toString()));
            aula.setTurno(ctrlTurno.leerTurno(cbxTurno.getSelectedItem().toString()));
            aula = ctrlAula.existeAula(aula.getCurso().getIdCurso(), aula.getDivision().getIdDivision());
            if(aula!=null)
            {
                JOptionPane.showMessageDialog(null, "Esta Aula ya existe");
                cbxCurso.requestFocus();
            }else{
                aula = new Aula();
                aula.setCurso(ctrlCurso.leerCurso(cbxCurso.getSelectedItem().toString()));
                aula.setDivision(ctrlDivision.leerDivision(cbxDivision.getSelectedItem().toString()));
                aula.setTurno(ctrlTurno.leerTurno(cbxTurno.getSelectedItem().toString()));
                ctrlAula.crearAula(aula);
                limpiar();
            }
        }
    }
    
    public void modificarAula()
    {
        if(validar() == true)
        {
            aula = new Aula();
            curso = ctrlCurso.leerCurso(cbxCurso.getSelectedItem().toString());
            division = ctrlDivision.leerDivision(cbxDivision.getSelectedItem().toString());
            turno = ctrlTurno.leerTurno(cbxTurno.getSelectedItem().toString());
            aula = ctrlAula.existeAula(curso.getIdCurso(),division.getIdDivision());
            if(aula!=null)
            {
                if(idAula != aula.getIdAula())
                {
                    JOptionPane.showMessageDialog(null, "Esta Aula ya existe");
                    cbxCurso.requestFocus();
                }else{
                aula = new Aula();
                aula.setIdAula(idAula);
                aula.setCurso(ctrlCurso.leerCurso(cbxCurso.getSelectedItem().toString()));
                aula.setDivision(ctrlDivision.leerDivision(cbxDivision.getSelectedItem().toString()));
                aula.setTurno(ctrlTurno.leerTurno(cbxTurno.getSelectedItem().toString()));
                ctrlAula.modificarAula(aula);
                limpiar();
            }  
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
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAulas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxDivision = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox<>();

        setTitle("Aulas");

        jPanel1.setBackground(new java.awt.Color(64, 207, 255));

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

        tblAulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CURSO", "DIVISION", "TURNO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAulas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAulasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAulas);
        if (tblAulas.getColumnModel().getColumnCount() > 0) {
            tblAulas.getColumnModel().getColumn(0).setResizable(false);
            tblAulas.getColumnModel().getColumn(1).setResizable(false);
            tblAulas.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Curso");

        jLabel2.setText("Division");

        jLabel3.setText("Turno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
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
        crearAula();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea eliminar el aula?","Eliminar",confirmar);
        if (respuesta == 0 )
        {
            ctrlAula.eliminarAula(aula);
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblAulasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAulasMousePressed
        int FilaSelec = tblAulas.getSelectedRow();
        cbxCurso.setSelectedItem(tblAulas.getValueAt(FilaSelec, 0).toString());
        cbxDivision.setSelectedItem(tblAulas.getValueAt(FilaSelec, 1).toString());
        cbxTurno.setSelectedItem(tblAulas.getValueAt(FilaSelec, 2).toString());
        curso = ctrlCurso.leerCurso(tblAulas.getValueAt(FilaSelec, 0).toString());
        division = ctrlDivision.leerDivision(tblAulas.getValueAt(FilaSelec, 1).toString());
        turno = ctrlTurno.leerTurno(tblAulas.getValueAt(FilaSelec, 2).toString());
        aula = ctrlAula.leerAula(curso.getIdCurso(), division.getIdDivision(), turno.getIdTurno());
        idAula = aula.getIdAula();
        cbxCurso.requestFocus();
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblAulasMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea modificar el aula?","Modificar",confirmar);
        if (respuesta == 0 )
        {
            modificarAula();
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxDivision;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAulas;
    // End of variables declaration//GEN-END:variables
}
