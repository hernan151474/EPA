/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlHora;
import controlador.CtrlHorario;
import controlador.CtrlPersonal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Hora;
import modelo.Horario;
import modelo.Personal;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Leonel
 */
public class ConsultaHorariosDePersonal extends javax.swing.JInternalFrame {
    CtrlPersonal ctrlPersonal = new CtrlPersonal();
    CtrlHorario ctrlHorario = new CtrlHorario();
    Personal personal = new Personal();
    DefaultTableModel modeloTabla = new DefaultTableModel(),modeloTabla2 = new DefaultTableModel();
    List<Horario> listaHorarios = new ArrayList();
    
    List<Hora> listaHoras = new ArrayList();
    CtrlHora ctrlHora = new CtrlHora();
    /**
     * Creates new form HorariosDePersonal
     */
    public ConsultaHorariosDePersonal() {
        initComponents();
    }

    public void cargarTablaMaterias()
    {
        modeloTabla = (DefaultTableModel) tblHorarios.getModel();
        String[] fila = new String[7];
        modeloTabla.setRowCount(0);
        listaHorarios = new ArrayList();
        listaHorarios = ctrlHorario.leerHorariosPersonal(txtCuil.getText());
        listaHoras = new ArrayList();
        listaHoras = ctrlHora.leerTodos();
        
        for(int i = 0; i<listaHoras.size(); i++)
        {
            fila[0] = listaHoras.get(i).getDesde()+" a "+listaHoras.get(i).getHasta();
            modeloTabla.addRow(fila);
        }
        tblHorarios.setModel(modeloTabla);
        int filaHora = tblHorarios.getRowCount();
        for(int i=0; i< listaHorarios.size(); i++){
            for(int j=0; j<filaHora; j++)
            {
                if((listaHorarios.get(i).getHora().getDesde()+" a "+listaHorarios.get(i).getHora().getHasta()).equals(tblHorarios.getValueAt(j, 0).toString()))
                {
                    tblHorarios.setValueAt(listaHorarios.get(i).getPersonalMateria().getMateria().getMateria(), j, listaHorarios.get(i).getDia()+1);
                }
            }
        }
    }
    
    public void imprimirHorarioPersonal()
    {
        try {
            JasperReport jr = (JasperReport)JRLoader.loadObject(java.security.Principal.class.getResource("/reportes/horarioPersonal.jasper"));
            Map parametros = new HashMap<>();
            for(int i = 0; i<=tblHorarios.getRowCount()/2; i++)
            {
                parametros.put("hora"+String.valueOf(i+1), tblHorarios.getValueAt(i, 0));
                if(tblHorarios.getValueAt(i, 1) == null)
                {
                    parametros.put("lunes"+String.valueOf(i+1), "");
                }else{
                    parametros.put("lunes"+String.valueOf(i+1), tblHorarios.getValueAt(i, 1));
                }
                if(tblHorarios.getValueAt(i, 2) == null)
                {
                    parametros.put("martes"+String.valueOf(i+1), "");
                }else{
                    parametros.put("martes"+String.valueOf(i+1), tblHorarios.getValueAt(i, 2));
                }
                if(tblHorarios.getValueAt(i, 3) == null)
                {
                    parametros.put("miercoles"+String.valueOf(i+1), "");
                }else{
                    parametros.put("miercoles"+String.valueOf(i+1), tblHorarios.getValueAt(i, 3));
                }
                if(tblHorarios.getValueAt(i, 4) == null)
                {
                    parametros.put("jueves"+String.valueOf(i+1), "");
                }else{
                    parametros.put("jueves"+String.valueOf(i+1), tblHorarios.getValueAt(i, 4));
                }
                if(tblHorarios.getValueAt(i, 5) == null)
                {
                    parametros.put("viernes"+String.valueOf(i+1), "");
                }else{
                    parametros.put("viernes"+String.valueOf(i+1), tblHorarios.getValueAt(i, 5));
                }
                if(tblHorarios.getValueAt(i, 6) == null)
                {
                    parametros.put("sabado"+String.valueOf(i+1), "");
                }else{
                    parametros.put("sabado"+String.valueOf(i+1), tblHorarios.getValueAt(i, 6));
                }
            }
            int k=0;
            for(int i = 6; i<tblHorarios.getRowCount(); i++)
            {
                parametros.put("hora"+String.valueOf(k+1)+"_1", tblHorarios.getValueAt(i, 0));
                if(tblHorarios.getValueAt(i, 1) == null)
                {
                    parametros.put("lunes"+String.valueOf(k+1)+"_1", "");
                }else{
                    parametros.put("lunes"+String.valueOf(k+1)+"_1", tblHorarios.getValueAt(i, 1));
                }
                if(tblHorarios.getValueAt(i, 2) == null)
                {
                    parametros.put("martes"+String.valueOf(k+1)+"_1", "");
                }else{
                    parametros.put("martes"+String.valueOf(k+1)+"_1", tblHorarios.getValueAt(i, 2));
                }
                if(tblHorarios.getValueAt(i, 3) == null)
                {
                    parametros.put("miercoles"+String.valueOf(k+1)+"_1", "");
                }else{
                    parametros.put("miercoles"+String.valueOf(k+1)+"_1", tblHorarios.getValueAt(i, 3));
                }
                if(tblHorarios.getValueAt(i, 4) == null)
                {
                    parametros.put("jueves"+String.valueOf(k+1)+"_1", "");
                }else{
                    parametros.put("jueves"+String.valueOf(k+1)+"_1", tblHorarios.getValueAt(i, 4));
                }
                if(tblHorarios.getValueAt(i, 5) == null)
                {
                    parametros.put("viernes"+String.valueOf(k+1)+"_1", "");
                }else{
                    parametros.put("viernes"+String.valueOf(k+1)+"_1", tblHorarios.getValueAt(i, 5));
                }
                if(tblHorarios.getValueAt(i, 6) == null)
                {
                    parametros.put("sabado"+String.valueOf(k+1)+"_1", "");
                }else{
                    parametros.put("sabado"+String.valueOf(k+1)+"_1", tblHorarios.getValueAt(i, 6));
                }
                k++;
            }
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHorarios = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCuil = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setTitle("Horarios de Personal");

        jPanel1.setBackground(new java.awt.Color(156, 156, 156));

        tblHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HORARIO", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO"
            }
        ));
        tblHorarios.setRowHeight(30);
        jScrollPane2.setViewportView(tblHorarios);

        btnSalir.setBackground(new java.awt.Color(0, 51, 51));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(64, 207, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Personal"));

        jLabel6.setText("Personal");

        txtPersonal.setEditable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuil.png"))); // NOI18N
        jLabel1.setText("CUIL");

        txtCuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuilKeyTyped(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnReporte.setBackground(new java.awt.Color(0, 51, 51));
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(btnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(440, 440, 440))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addComponent(btnReporte))
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

    private void txtCuilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuilKeyTyped
        if(txtCuil.getText().length() == 11){
            evt.consume();
        }
    }//GEN-LAST:event_txtCuilKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        txtCuil.setBorder(new JTextField().getBorder());
        if(!txtCuil.getText().equals(""))
        {
            personal = ctrlPersonal.leerPersonal(txtCuil.getText());
            if(personal!=null)
            {
                txtPersonal.setText(personal.getApellido()+(" ")+personal.getNombre());
                txtPersonal.setBorder(new LineBorder(Color.GREEN, 2));
                cargarTablaMaterias();
            }
        }else{
            txtPersonal.setText("");
            txtPersonal.setBorder(new LineBorder(Color.RED, 2));
            txtCuil.setBorder(new LineBorder(Color.RED, 2));
            txtCuil.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        imprimirHorarioPersonal();
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHorarios;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables
}
