/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlPlanEstudio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PlanEstudio;

/**
 *
 * @author Leonel
 */
public class PlanEstudios extends javax.swing.JInternalFrame {

    /**
     * Creates new form Personales
     */
    private PlanEstudio planEstudio;
    private CtrlPlanEstudio ctrlPlanEstudio;

    private List<PlanEstudio> listaPlanEst = new ArrayList<>();

    private int punto = 0;
    private boolean modif = false;
    private DefaultTableModel model;

    public PlanEstudios() {
        initComponents();
        btnModificar.setEnabled(false);
        btnQuitar.setEnabled(false);

        ctrlPlanEstudio = new CtrlPlanEstudio();

        cargarTabla();
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
        webCam = new JPanelWebCam.JPanelWebCam();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblResulucion = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        txtTitulo = new javax.swing.JTextField();
        txtResolucion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlanEst = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();

        setTitle("Plan de Estudios");

        jPanel1.setBackground(new java.awt.Color(0, 152, 101));

        webCam.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        webCam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                webCamMousePressed(evt);
            }
        });
        webCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(0, 51, 51));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 152, 101));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Plan de Estudios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Titulo");

        lblResulucion.setForeground(new java.awt.Color(255, 255, 255));
        lblResulucion.setText("Resolucion");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Desde");

        fechaDesde.setBackground(new java.awt.Color(0, 152, 101));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Hasta");

        fechaHasta.setBackground(new java.awt.Color(0, 152, 101));

        txtResolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo)
                .addGap(28, 28, 28)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel17)
                .addGap(7, 7, 7)
                .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblResulucion)
                .addGap(6, 6, 6)
                .addComponent(txtResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel18)
                .addGap(10, 10, 10)
                .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblTitulo))
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel17))
                    .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblResulucion))
                    .addComponent(txtResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        tblPlanEst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Resolucion", "Desde", "Hasta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlanEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlanEstMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPlanEstMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblPlanEst);
        if (tblPlanEst.getColumnModel().getColumnCount() > 0) {
            tblPlanEst.getColumnModel().getColumn(0).setPreferredWidth(180);
        }

        btnAgregar.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        btnQuitar.setBackground(new java.awt.Color(0, 51, 51));
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnQuitar.setText("Eliminar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(webCam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnAgregar)
                        .addGap(12, 12, 12)
                        .addComponent(btnModificar)
                        .addGap(12, 12, 12)
                        .addComponent(btnQuitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(webCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnQuitar)
                        .addComponent(btnSalir)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe cargar un Titulo");
        } else if (fechaDesde.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe cargar la fecha Desde");
        } else {
            guardar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe cargar un Titulo");
        } else if (fechaDesde.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe cargar la fecha Desde");
        } else {
            modificar();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void webCamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webCamMousePressed

    }//GEN-LAST:event_webCamMousePressed

    private void txtResolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResolucionActionPerformed

    private void tblPlanEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlanEstMouseClicked
        punto = tblPlanEst.rowAtPoint(evt.getPoint());
        txtTitulo.setText(listaPlanEst.get(punto).getTitulo());
        txtResolucion.setText(listaPlanEst.get(punto).getResolucion());
        fechaDesde.setDate(listaPlanEst.get(punto).getVigenciaDesde());
        fechaHasta.setDate(listaPlanEst.get(punto).getVigenciaHasta());
        modif = true;

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnQuitar.setEnabled(true);
    }//GEN-LAST:event_tblPlanEstMouseClicked

    private void tblPlanEstMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlanEstMousePressed

    }//GEN-LAST:event_tblPlanEstMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblResulucion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblPlanEst;
    private javax.swing.JTextField txtResolucion;
    private javax.swing.JTextField txtTitulo;
    private JPanelWebCam.JPanelWebCam webCam;
    // End of variables declaration//GEN-END:variables

    private void guardar() {
        planEstudio = new PlanEstudio();
        planEstudio.setResolucion(txtResolucion.getText());
        planEstudio.setTitulo(txtTitulo.getText());
        planEstudio.setVigenciaDesde(fechaDesde.getDate());
        planEstudio.setVigenciaHasta(fechaHasta.getDate());
        ctrlPlanEstudio.crear(planEstudio);
        cargarTabla();
        limpiar();
    }

    private void cargarTabla() {
        listaPlanEst = ctrlPlanEstudio.leer();
        model = (DefaultTableModel) tblPlanEst.getModel();
        model.setRowCount(0);
        Object[] fila = new Object[4];
        for (int i = 0; i < listaPlanEst.size(); i++) {
            fila[0] = listaPlanEst.get(i).getTitulo();

            if (listaPlanEst.get(i).getResolucion().isEmpty()) {
                fila[1] = "Sin Resolución";
            } else {
                fila[1] = listaPlanEst.get(i).getResolucion();
            }

            fila[2] = listaPlanEst.get(i).getVigenciaDesde();

            if (listaPlanEst.get(i).getVigenciaHasta() == null) {
                fila[3] = "Tiempo Indefinido";
            } else {
                fila[3] = listaPlanEst.get(i).getVigenciaHasta();
            }

            model.addRow(fila);
        }
        tblPlanEst.setModel(model);
    }

    private void limpiar() {
        txtResolucion.setText(null);
        txtTitulo.setText(null);
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        modif = false;
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnQuitar.setEnabled(false);
    }

    private void modificar() {
        planEstudio = new PlanEstudio();
        planEstudio.setIdPlanEstudio(listaPlanEst.get(punto).getIdPlanEstudio());
        planEstudio.setResolucion(txtResolucion.getText());
        planEstudio.setTitulo(txtTitulo.getText());
        planEstudio.setVigenciaDesde(fechaDesde.getDate());
        planEstudio.setVigenciaHasta(fechaHasta.getDate());
        ctrlPlanEstudio.modificar(planEstudio);
        cargarTabla();
        limpiar();
    }

    private void eliminar() {
        planEstudio = new PlanEstudio();
        planEstudio.setIdPlanEstudio(listaPlanEst.get(punto).getIdPlanEstudio());
        ctrlPlanEstudio.eliminar(planEstudio);
        cargarTabla();
        limpiar();
    }
}