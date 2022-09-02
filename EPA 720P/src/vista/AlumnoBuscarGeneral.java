/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlAlumno;
import controlador.CtrlAlumnoSancion;
import controlador.CtrlLugar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;

/**
 *
 * @author Kevin
 */
public class AlumnoBuscarGeneral extends javax.swing.JInternalFrame {

    public static Alumno alumno;
    //private AlumnoSanciones alumnoSanciones = new AlumnoSanciones();
//------------------------------------------------------------------------------    
    private CtrlAlumno ctrlAlumno;
    private CtrlLugar ctrlLugar;
    private CtrlAlumnoSancion ctrlAlumnoSancion;
//------------------------------------------------------------------------------
    public static List<Alumno> listAlumno = new ArrayList<>();
//------------------------------------------------------------------------------
    private Date fecha;
    private DefaultTableModel model;
    private int punto = -1, vista = 0;
    public static boolean cerrar = false;

    public AlumnoBuscarGeneral(int vis) {
        initComponents();
        vista = vis;
//------------------------------------------------------------------------------
        alumno = new Alumno();
//------------------------------------------------------------------------------
        fecha = new Date();
        ctrlAlumno = new CtrlAlumno();
        ctrlLugar = new CtrlLugar();
        ctrlAlumnoSancion = new CtrlAlumnoSancion();
//------------------------------------------------------------------------------
        cargarTabla();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/legajo.png")));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSancion = new javax.swing.JTable();
        cbxBuscar = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();

        setTitle("Buscar Alumno");

        jPanel1.setBackground(new java.awt.Color(0, 152, 101));

        jPanel2.setBackground(new java.awt.Color(0, 152, 101));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alumno Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuil.png"))); // NOI18N

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        tblSancion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Legajo", "CUIL", "Apellido y Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSancionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSancionMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblSancion);

        cbxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Legajo", "CUIL", "Apellido" }));
        cbxBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBuscarItemStateChanged(evt);
            }
        });
        cbxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(btnSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        switch (cbxBuscar.getSelectedIndex()) {
            case 0: {
                if (txtBuscar.getText().length() >= 8) {
                    evt.consume();
                }
                char validar = evt.getKeyChar();
                //soloNumeros(validar, evt);
                if (Character.isLetter(validar)
                        || evt.getKeyChar() >= 32 && evt.getKeyChar() <= 47
                        || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 255) {
                    getToolkit().beep();
                    evt.consume();
                }
                cargarTablaBuscar();
                break;
            }
            case 1: {
                if (txtBuscar.getText().length() >= 8) {
                    evt.consume();
                }
                char validar = evt.getKeyChar();
                //soloNumeros(validar, evt);
                if (Character.isLetter(validar)
                        || evt.getKeyChar() >= 32 && evt.getKeyChar() <= 47
                        || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 255) {
                    getToolkit().beep();
                    evt.consume();
                }
                cargarTablaBuscar();
                break;
            }
            case 2: {
                if (txtBuscar.getText().length() >= 20) {
                    evt.consume();
                }
                char validar = evt.getKeyChar();
                if (Character.isDigit(validar)) {
                    getToolkit().beep();
                    evt.consume();
                    //lblValidNombre.setVisible(true);
                }
                if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 64
                        || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
                        || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                        || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                        || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {
                    evt.consume();

                }
                cargarTablaBuscar();
                break;
            }
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (punto >= 0 && tblSancion.getRowCount() > 0) {
            cargarCampos();
        } else {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblSancionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSancionMouseClicked
        punto = tblSancion.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            cargarCampos();
            //handle double click event.
        }

    }//GEN-LAST:event_tblSancionMouseClicked

    private void tblSancionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSancionMousePressed

    }//GEN-LAST:event_tblSancionMousePressed

    private void cbxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxBuscarActionPerformed

    private void cbxBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBuscarItemStateChanged
        switch (cbxBuscar.getSelectedIndex()) {
            case 0: {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/legajo.png")));
                break;
            }
            case 1: {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuil.png")));
                break;
            }
            case 2: {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nombreApellido.png")));
                break;
            }
        }

    }//GEN-LAST:event_cbxBuscarItemStateChanged

//Metodos-----------------------------------------------------------------------
    private void cargarTabla() {
        model = (DefaultTableModel) tblSancion.getModel();
        model.setRowCount(0);
        listAlumno = ctrlAlumno.leerTodos();
        Object[] fila = new Object[3];
        for (int i = 0; i < listAlumno.size(); i++) {
            fila[0] = listAlumno.get(i).getPersonal().getLegajo();
            fila[1] = listAlumno.get(i).getPersonal().getCuil();
            fila[2] = listAlumno.get(i).getPersonal().getApellido() + " "
                    + listAlumno.get(i).getPersonal().getNombre();
            model.addRow(fila);
        }
        tblSancion.setModel(model);
    }

    private void cargarTablaBuscar() {
        model = (DefaultTableModel) tblSancion.getModel();
        model.setRowCount(0);
        listAlumno = ctrlAlumno.leerTodos(txtBuscar.getText(), cbxBuscar.getSelectedIndex());
        Object[] fila = new Object[3];
        for (int i = 0; i < listAlumno.size(); i++) {
            fila[0] = listAlumno.get(i).getPersonal().getLegajo();
            fila[1] = listAlumno.get(i).getPersonal().getCuil();
            fila[2] = listAlumno.get(i).getPersonal().getApellido() + " "
                    + listAlumno.get(i).getPersonal().getNombre();
            model.addRow(fila);
        }
        tblSancion.setModel(model);
    }

    private void cargarCampos() {

        alumno = listAlumno.get(punto);
        String domicilioText = "B° " + ctrlLugar.extraerNombre(alumno.getPersonal().getDomicilio().getCalle().getDe())
                + " Calle " + alumno.getPersonal().getDomicilio().getCalle().getNombre() + " N° "
                + alumno.getPersonal().getDomicilio().getNumero()
                + " Localidad de " + ctrlLugar.extraerNombre(alumno.getLocalidad().getIdLugar());

        switch (vista) {
            case 0: {
                AlumnoSanciones.txtApeNom.setText(alumno.getPersonal().getApellido() + " " + alumno.getPersonal().getNombre());
                AlumnoSanciones.txtLegajo.setText(alumno.getPersonal().getLegajo());
                AlumnoSanciones.txtDomicilio.setText(domicilioText);
                AlumnoSanciones.txtCuil.setText(alumno.getPersonal().getCuil());

                AlumnoSanciones.alumnoVista = alumno;

                AlumnoSanciones.Habilitar();
                AlumnoSanciones.btnGuardar.setEnabled(true);
                AlumnoSanciones.cbxSancion.requestFocus();
                break;
            }
            case 1: {
                LibroMatriz.txtApeNom.setText(alumno.getPersonal().getApellido() + " " + alumno.getPersonal().getNombre());
                LibroMatriz.txtLegajo.setText(alumno.getPersonal().getLegajo());
                LibroMatriz.txtDomicilio.setText(domicilioText);
                LibroMatriz.txtCuil.setText(alumno.getPersonal().getCuil());
                LibroMatriz.txtFechaNacimiento.setText(alumno.getPersonal().getFechaNacimiento().toString());
                LibroMatriz.txtFechaIngreso.setText(alumno.getPersonal().getFechaAlta().toString());

                LibroMatriz.alumno = alumno;

                LibroMatriz.cargarTabla();

                LibroMatriz.btnImprimir.setEnabled(true);
                LibroMatriz.btnImprimir.requestFocus();
                break;
            }
            case 2: {

                AlumnoMaterias.alumno = alumno;
                AlumnoMaterias.txtApeNom.setText(alumno.getPersonal().getApellido() + " " + alumno.getPersonal().getNombre());
                AlumnoMaterias.txtLegajo.setText(alumno.getPersonal().getLegajo());
                AlumnoMaterias.txtDomicilio.setText(domicilioText);
                AlumnoMaterias.txtCuil.setText(alumno.getPersonal().getCuil());
                AlumnoMaterias.estadoObjetos(true);
                AlumnoMaterias.btnGuardar.setEnabled(true);
                AlumnoMaterias.cbxPlanEst.requestFocus();
                break;
            }
        }

        //this.setVisible(false);
        this.dispose();

    }

//Funciones---------------------------------------------------------------------    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSancion;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
