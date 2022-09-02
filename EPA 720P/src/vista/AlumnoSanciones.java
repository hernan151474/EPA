/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlAlumno;
import controlador.CtrlAlumnoSancion;
import controlador.CtrlLugar;
import controlador.CtrlSancion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.AlumnoSancion;
import modelo.Sancion;

/**
 *
 * @author Leonel
 */
public class AlumnoSanciones extends javax.swing.JInternalFrame {

    public static Alumno alumnoVista;

    private Sancion sancion;
    private AlumnoSancion alumnoSancion;
//------------------------------------------------------------------------------    
    public static CtrlAlumno ctrlAlumno;
    public static CtrlSancion ctrlSancion;
    public static CtrlAlumnoSancion ctrlAlumnoSancion;
    public static CtrlLugar ctrlLugar;

//------------------------------------------------------------------------------
    private List<Sancion> listaSacion = new ArrayList<>();

//------------------------------------------------------------------------------
    private Date fecha;
    public static String domicilioText;
    private int total = 0;

    public AlumnoSanciones() {
        initComponents();
        btnGuardar.setEnabled(false);
//------------------------------------------------------------------------------
        alumnoVista = new Alumno();
//------------------------------------------------------------------------------
        fecha = new Date();
        ctrlAlumno = new CtrlAlumno();
        ctrlAlumnoSancion = new CtrlAlumnoSancion();
        ctrlSancion = new CtrlSancion();
        ctrlLugar = new CtrlLugar();
        jdcFechaCarga.setDate(fecha);
//------------------------------------------------------------------------------
        cargarComboCantidad();
        cargarComboSancion();
        desHabilitar();
        txtTotal.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCuil = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApeNom = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cbxSancion = new javax.swing.JComboBox<>();
        cbxCantidad = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jdcFechaCarga = new com.toedter.calendar.JDateChooser();
        lblObser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaObser = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setTitle("Registrar Sanciones Alumno");

        jPanel1.setBackground(new java.awt.Color(0, 152, 101));

        jPanel2.setBackground(new java.awt.Color(0, 152, 101));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/domicilio.png"))); // NOI18N
        jLabel10.setText("Domicilio");

        txtDomicilio.setEditable(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuil.png"))); // NOI18N
        jLabel1.setText("CUIL");

        txtCuil.setEditable(false);
        txtCuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuilKeyTyped(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nombreApellido.png"))); // NOI18N
        jLabel2.setText("Apellido y Nombre");

        txtApeNom.setEditable(false);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/legajo.png"))); // NOI18N
        jLabel13.setText("Legajo");

        txtLegajo.setEditable(false);
        txtLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLegajoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApeNom))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(12, 12, 12)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApeNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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

        jPanel5.setBackground(new java.awt.Color(0, 152, 101));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asignar Sanción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Sancion");

        cbxSancion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSancionItemStateChanged(evt);
            }
        });
        cbxSancion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxSancionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxSancionFocusLost(evt);
            }
        });
        cbxSancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSancionActionPerformed(evt);
            }
        });

        cbxCantidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCantidadItemStateChanged(evt);
            }
        });
        cbxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCantidadActionPerformed(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Cantidad");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Fecha");

        lblObser.setForeground(new java.awt.Color(255, 255, 255));
        lblObser.setText("Observación");

        txaObser.setColumns(20);
        txaObser.setRows(5);
        jScrollPane1.setViewportView(txaObser);

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Total");

        txtTotal.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSancion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxCantidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jdcFechaCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblObser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbxSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jdcFechaCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblObser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnGuardar.setBackground(new java.awt.Color(0, 51, 51));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar))
                .addGap(14, 14, 14))
        );

        principal.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
            .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
            .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCuilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuilKeyTyped
        if (txtCuil.getText().length() >= 11) {
            evt.consume();
        }
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)
                || evt.getKeyChar() >= 32 && evt.getKeyChar() <= 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCuilKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        //AlumnoBuscar vista = new AlumnoBuscar();
        AlumnoBuscarGeneral vista = new AlumnoBuscarGeneral(0);
        PantallaEPA.desktopPane.add(vista);
        vista.toFront();
        vista.show();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxSancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSancionActionPerformed

    private void cbxCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCantidadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        sancion = new Sancion();
        alumnoSancion = new AlumnoSancion();
        alumnoSancion.setAlumno(alumnoVista);
        alumnoSancion.setSancion(listaSacion.get(cbxSancion.getSelectedIndex()));
        alumnoSancion.setCantidad(Integer.parseInt(cbxCantidad.getSelectedItem().toString()));
        alumnoSancion.setFecha(jdcFechaCarga.getDate());
        alumnoSancion.setObservacion(txaObser.getText());
        ctrlAlumnoSancion.crear(alumnoSancion);
        if (ctrlAlumnoSancion.existeSancionAlumno(alumnoVista.getIdAlumno(), listaSacion.get(cbxSancion.getSelectedIndex()).getIdSancion())) {

        }
        JOptionPane.showMessageDialog(this, "Guardado");
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtLegajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyTyped

    }//GEN-LAST:event_txtLegajoKeyTyped

    private void cbxSancionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSancionItemStateChanged
        total = ctrlAlumnoSancion.obtenerTotal(alumnoVista.getIdAlumno(), listaSacion.get(cbxSancion.getSelectedIndex()).getIdSancion());
        String defTotal = "" + (total + (cbxCantidad.getSelectedIndex() + 1));
        txtTotal.setText(defTotal);
    }//GEN-LAST:event_cbxSancionItemStateChanged

    private void cbxCantidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCantidadItemStateChanged
        String defTotal = "" + (total + (cbxCantidad.getSelectedIndex() + 1));
        txtTotal.setText(defTotal);
    }//GEN-LAST:event_cbxCantidadItemStateChanged

    private void cbxSancionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxSancionFocusLost
        
    }//GEN-LAST:event_cbxSancionFocusLost

    private void cbxSancionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxSancionFocusGained
        total = ctrlAlumnoSancion.obtenerTotal(alumnoVista.getIdAlumno(), listaSacion.get(cbxSancion.getSelectedIndex()).getIdSancion());
        String defTotal = "" + (total + (cbxCantidad.getSelectedIndex() + 1));
        txtTotal.setText(defTotal);
    }//GEN-LAST:event_cbxSancionFocusGained

//Metodos-----------------------------------------------------------------------
    private void cargarComboSancion() {
        listaSacion = ctrlSancion.leerTodos();

        for (int i = 0; i < listaSacion.size(); i++) {
            cbxSancion.addItem(listaSacion.get(i).getSancion());
        }
    }

    private void cargarComboCantidad() {
        for (int i = 0; i < 25; i++) {
            cbxCantidad.addItem(String.valueOf(i + 1));
        }
    }

    public void cargarCampos(Alumno alumno) {

        // alumno = ctrlAlumno.leer(txtCuil.getText());
        alumnoVista = alumno;
        if (alumno != null) {
            domicilioText = "B° " + ctrlLugar.extraerNombre(alumno.getPersonal().getDomicilio().getCalle().getDe())
                    + " Calle " + alumno.getPersonal().getDomicilio().getCalle().getNombre() + " N° "
                    + alumno.getPersonal().getDomicilio().getNumero()
                    + " Localidad de " + ctrlLugar.extraerNombre(alumno.getLocalidad().getIdLugar());
            btnGuardar.setEnabled(true);
            txtCuil.setText(alumno.getPersonal().getCuil());
            txtLegajo.setText(alumno.getPersonal().getLegajo());
            txtApeNom.setText(alumno.getPersonal().getApellido() + " " + alumno.getPersonal().getNombre());
            txtDomicilio.setText(domicilioText);
        } else {
            JOptionPane.showMessageDialog(this, "No se econtró Alumno", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void desHabilitar() {
        cbxSancion.setEnabled(false);
        cbxCantidad.setEnabled(false);
        jdcFechaCarga.setEnabled(false);
        txaObser.setEnabled(false);
    }

    public static void Habilitar() {
        cbxSancion.setEnabled(true);
        cbxCantidad.setEnabled(true);
        jdcFechaCarga.setEnabled(true);
        //jdcFechaCarga.setBackground(new java.awt.Color(0, 152, 101));
        txaObser.setEnabled(true);
        
    }

    private void limpiar() {
        txtApeNom.setText(null);
        txtLegajo.setText(null);
        txtDomicilio.setText(null);
        txtCuil.setText(null);
        txaObser.setText(null);
        jdcFechaCarga.setDate(fecha);
        cbxCantidad.setSelectedIndex(0);
        cbxSancion.setSelectedIndex(0);
        alumnoVista = new Alumno();
        txtTotal.setText(null);
        desHabilitar();
    }

//Funciones---------------------------------------------------------------------    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox<String> cbxCantidad;
    public static javax.swing.JComboBox<String> cbxSancion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.toedter.calendar.JDateChooser jdcFechaCarga;
    private javax.swing.JLabel lblObser;
    public static javax.swing.JDesktopPane principal;
    public static javax.swing.JTextArea txaObser;
    public static javax.swing.JTextField txtApeNom;
    public static javax.swing.JTextField txtCuil;
    public static javax.swing.JTextField txtDomicilio;
    public static javax.swing.JTextField txtLegajo;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
