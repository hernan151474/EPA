/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlAula;
import controlador.CtrlCaracter;
import controlador.CtrlCurso;
import controlador.CtrlDivision;
import controlador.CtrlHora;
import controlador.CtrlHorario;
import controlador.CtrlMateria;
import controlador.CtrlPersonal;
import controlador.CtrlPersonalMateria;
import controlador.CtrlTurno;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Aula;
import modelo.Caracter;
import modelo.Curso;
import modelo.Division;
import modelo.Hora;
import modelo.Horario;
import modelo.Materia;
import modelo.Personal;
import modelo.PersonalMateria;
import modelo.Turno;

/**
 *
 * @author Leonel
 */
public class PersonalModificarHoraCurso extends javax.swing.JInternalFrame {
    CtrlPersonalMateria ctrlPersonalMateria = new CtrlPersonalMateria();
    CtrlPersonal ctrlPersonal = new CtrlPersonal();
    CtrlMateria ctrlMateria = new CtrlMateria();
    CtrlCaracter ctrlCaracter = new CtrlCaracter();
    CtrlAula ctrlAula = new CtrlAula();
    CtrlCurso ctrlCurso = new CtrlCurso();
    CtrlDivision ctrlDivision = new CtrlDivision();
    CtrlTurno ctrlTurno = new CtrlTurno();
    CtrlHora ctrlHora = new CtrlHora();
    CtrlHorario ctrlHorario = new CtrlHorario();
    PersonalMateria personalMateria = new PersonalMateria();
    Personal personal = new Personal();
    Aula aula = new Aula();
    Curso curso = new Curso();
    Division division = new Division();
    Turno turno = new Turno();
    Horario horario = new Horario();
    Hora hora = new Hora();
    Materia materia = new Materia();
    List<Materia> listaMaterias = new ArrayList();
    List<Caracter> listaCaracteres = new ArrayList();
    List<Aula> listaAulas = new ArrayList();
    List<Hora> listaHoras = new ArrayList();
    List<PersonalMateria> listaPersonalMaterias = new ArrayList(), listaPersonalMaterias2 = new ArrayList();
    List<Horario> listaHorarios = new ArrayList();
    DefaultTableModel modeloTabla = new DefaultTableModel(), modeloTabla2 = new DefaultTableModel(), modeloTabla3 = new DefaultTableModel(), modeloTabla4 = new DefaultTableModel();
    DefaultTableModel modeloTabla5 = new DefaultTableModel();
    /**
     * Creates new form ModificarMHP
     */
    public PersonalModificarHoraCurso() {
        initComponents();
//        cargarTablaHoras();
        cargarTablaAulas();
        btnCambiar1.setEnabled(false);
        btnCambiar2.setEnabled(false);
    }
    
//    public void cargarTablaHoras()
//    {
//        modeloTabla2 = (DefaultTableModel) tblHoras.getModel();
//        String[] fila = new String[3];
//        modeloTabla2.setRowCount(0);
//        listaHoras = ctrlHora.leerTodos();
//        
//        for(int i=0; i< listaHoras.size(); i++){
//            tblHoras.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
//            fila[1] = listaHoras.get(i).getDesde();
//            fila[2] = listaHoras.get(i).getHasta();
//            modeloTabla2.addRow(fila);
//        }
//        tblHoras.setModel(modeloTabla2);
//    }
    
    public void cargarTablaHoras()
    {
        modeloTabla2 = (DefaultTableModel) tblHoras.getModel();
        String[] fila = new String[3];
        modeloTabla2.setRowCount(0);
        listaHoras = ctrlHora.leerTodos();
        if(turno.getTurno().equals("MAÑANA"))
        {
            for(int i=0; i< listaHoras.size()/2; i++){
            tblHoras.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
            fila[1] = listaHoras.get(i).getDesde();
            fila[2] = listaHoras.get(i).getHasta();
            modeloTabla2.addRow(fila);
            }
            tblHoras.setModel(modeloTabla2);
        }else{
            for(int i=6; i< listaHoras.size(); i++){
            tblHoras.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
            fila[1] = listaHoras.get(i).getDesde();
            fila[2] = listaHoras.get(i).getHasta();
            modeloTabla2.addRow(fila);
            }
            tblHoras.setModel(modeloTabla2);
        }
    }
    
    public void cargarTablaMaterias()
    {
        modeloTabla = (DefaultTableModel) tblMaterias.getModel();
        String[] fila = new String[2];
        modeloTabla.setRowCount(0);
        listaPersonalMaterias = ctrlPersonalMateria.leerPersonalMateria(txtCuil.getText());
        
        for(int i=0; i< listaPersonalMaterias.size(); i++){
            fila[0] = listaPersonalMaterias.get(i).getMateria().getMateria();
            fila[1] = String.valueOf(listaPersonalMaterias.get(i).getMateria().getAño());
            modeloTabla.addRow(fila);
        }
        tblMaterias.setModel(modeloTabla);
    }
    
    public void cargarTablaDias()
    {
        int FilaSelec = tblMaterias.getSelectedRow();
        listaHorarios = ctrlHorario.leerHorariosMateria(tblMaterias.getValueAt(FilaSelec, 0).toString(),Integer.valueOf(tblMaterias.getValueAt(FilaSelec, 1).toString()),txtCuil.getText());
        modeloTabla3 = (DefaultTableModel) tblDias.getModel();
        String[] fila = new String[3];
        modeloTabla3.setRowCount(0);
        
        for(int i=0; i< listaHorarios.size(); i++){
            if(listaHorarios.get(i).getDia() == 0)
                fila[0] = "Lunes";
            if(listaHorarios.get(i).getDia() == 1)
                fila[0] = "Martes";
            if(listaHorarios.get(i).getDia() == 2)
                fila[0] = "Miercoles";
            if(listaHorarios.get(i).getDia() == 3)
                fila[0] = "Jueves";
            if(listaHorarios.get(i).getDia() == 4)
                fila[0] = "Viernes";
            if(listaHorarios.get(i).getDia() == 5)
                fila[0] = "Sabado";
            
            fila[1] = listaHorarios.get(i).getHora().getDesde();
            fila[2] = listaHorarios.get(i).getHora().getHasta();
            modeloTabla3.addRow(fila);
        }
        tblDias.setModel(modeloTabla3);
    }
    
    public void cargarTablaAulas()
    {
        String[] fila = new String[3];
        modeloTabla4 = (DefaultTableModel) tblAulas.getModel();
        modeloTabla4.setRowCount(0);
        listaAulas = ctrlAula.leerTodos();
        
        for(int i=0; i< listaAulas.size(); i++){
            fila[0] = listaAulas.get(i).getCurso().getCurso();
            fila[1] = listaAulas.get(i).getDivision().getDivision();
            fila[2] = listaAulas.get(i).getTurno().getTurno();
            modeloTabla4.addRow(fila);
        }
        tblAulas.setModel(modeloTabla4);
    }
    
    public void cargarCursoMateria()
    {
        String[] fila = new String[3];
        modeloTabla5 = (DefaultTableModel) tblCursos.getModel();
        modeloTabla5.setRowCount(0);
        int FilaSelec = tblMaterias.getSelectedRow();
        listaPersonalMaterias2 = ctrlPersonalMateria.leerAulasDeMateria(txtCuil.getText(), tblMaterias.getValueAt(FilaSelec, 0).toString());
        
        for(int i=0; i< listaPersonalMaterias2.size(); i++){
            fila[0] = listaPersonalMaterias2.get(i).getAula().getCurso().getCurso();
            fila[1] = listaPersonalMaterias2.get(i).getAula().getDivision().getDivision();
            fila[2] = listaPersonalMaterias2.get(i).getAula().getTurno().getTurno();
            modeloTabla5.addRow(fila);
        }
        tblCursos.setModel(modeloTabla5);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDias = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCuil = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDias = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAulas = new javax.swing.JTable();
        btnCambiar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoras = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        checkLunes = new javax.swing.JRadioButton();
        checkMartes = new javax.swing.JRadioButton();
        checkMiercoles = new javax.swing.JRadioButton();
        checkJueves = new javax.swing.JRadioButton();
        checkViernes = new javax.swing.JRadioButton();
        checkSabado = new javax.swing.JRadioButton();
        btnCambiar2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setTitle("Modificar Horario y Curso de Personal");

        jPanel1.setBackground(new java.awt.Color(0, 152, 101));

        jPanel3.setBackground(new java.awt.Color(0, 152, 101));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Personal");

        txtPersonal.setEditable(false);

        btnBuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuil.png"))); // NOI18N
        jLabel1.setText("CUIL");

        txtCuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuilKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonal))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 152, 101));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Materia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATERIAS", "AÑO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMateriasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblMaterias);
        if (tblMaterias.getColumnModel().getColumnCount() > 0) {
            tblMaterias.getColumnModel().getColumn(0).setResizable(false);
            tblMaterias.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(0, 152, 101));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dias y Horarios de la Materia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblDias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DIA", "DESDE", "HASTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDiasMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tblDias);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 152, 101));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Nuevo Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

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

        btnCambiar1.setBackground(new java.awt.Color(0, 51, 51));
        btnCambiar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cambiar.png"))); // NOI18N
        btnCambiar1.setText("Cambiar");
        btnCambiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnCambiar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiar1))
        );

        jPanel5.setBackground(new java.awt.Color(0, 152, 101));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Nuevo Dia y Horario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(0, 152, 101));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblHoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AGREGAR", "DESDE", "HASTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblHorasMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoras);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(0, 152, 101));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        grupoDias.add(checkLunes);
        checkLunes.setForeground(new java.awt.Color(255, 255, 255));
        checkLunes.setText("Lun");

        grupoDias.add(checkMartes);
        checkMartes.setForeground(new java.awt.Color(255, 255, 255));
        checkMartes.setText("Mar");

        grupoDias.add(checkMiercoles);
        checkMiercoles.setForeground(new java.awt.Color(255, 255, 255));
        checkMiercoles.setText("Mie");

        grupoDias.add(checkJueves);
        checkJueves.setForeground(new java.awt.Color(255, 255, 255));
        checkJueves.setText("Jue");

        grupoDias.add(checkViernes);
        checkViernes.setForeground(new java.awt.Color(255, 255, 255));
        checkViernes.setText("Vie");

        grupoDias.add(checkSabado);
        checkSabado.setForeground(new java.awt.Color(255, 255, 255));
        checkSabado.setText("Sab");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkLunes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkMartes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkMiercoles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkJueves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkViernes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkSabado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkLunes)
                    .addComponent(checkMartes)
                    .addComponent(checkMiercoles)
                    .addComponent(checkJueves)
                    .addComponent(checkViernes)
                    .addComponent(checkSabado))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnCambiar2.setBackground(new java.awt.Color(0, 51, 51));
        btnCambiar2.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cambiar.png"))); // NOI18N
        btnCambiar2.setText("Cambiar");
        btnCambiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCambiar2)
                .addGap(160, 160, 160))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiar2)
                .addGap(6, 6, 6))
        );

        jPanel6.setBackground(new java.awt.Color(0, 152, 101));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos de la Materia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCursosMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tblCursos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 31, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            }else{
                txtPersonal.setText("");
                txtPersonal.setBorder(new LineBorder(Color.RED, 2));
                txtCuil.requestFocus();
            }
        }else{
            txtCuil.setBorder(new LineBorder(Color.RED, 2));
            txtCuil.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCuilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuilKeyTyped
        if(txtCuil.getText().length() == 11){
            evt.consume();
        }
    }//GEN-LAST:event_txtCuilKeyTyped

    private void tblMateriasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMateriasMousePressed
        cargarTablaDias();
        cargarCursoMateria();
    }//GEN-LAST:event_tblMateriasMousePressed

    private void tblDiasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiasMousePressed
        int FilaSelec = tblDias.getSelectedRow();
        int dia = 0;
        if(tblDias.getValueAt(FilaSelec, 0).equals("Lunes"))
        {
            dia=0;
        }
        if(tblDias.getValueAt(FilaSelec, 0).equals("Martes"))
        {
            dia=1;
        }
        if(tblDias.getValueAt(FilaSelec, 0).equals("Miercoles"))
        {
            dia=2;
        }
        if(tblDias.getValueAt(FilaSelec, 0).equals("Jueves"))
        {
            dia=3;
        }
        if(tblDias.getValueAt(FilaSelec, 0).equals("Viernes"))
        {
            dia=4;
        }
        if(tblDias.getValueAt(FilaSelec, 0).equals("Sabado"))
        {
            dia=5;
        }
        hora = ctrlHora.leerHora(tblDias.getValueAt(FilaSelec, 1).toString(), tblDias.getValueAt(FilaSelec, 2).toString());
        horario = ctrlHorario.leerIdHorario(dia, hora.getIdHora());
    }//GEN-LAST:event_tblDiasMousePressed

    private void tblAulasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAulasMousePressed
        int FilaSelec = tblAulas.getSelectedRow();
        curso = ctrlCurso.leerCurso(tblAulas.getValueAt(FilaSelec, 0).toString());
        division = ctrlDivision.leerDivision(tblAulas.getValueAt(FilaSelec, 1).toString());
        turno = ctrlTurno.leerTurno(tblAulas.getValueAt(FilaSelec, 2).toString());
        aula = ctrlAula.leerAula(curso.getIdCurso(), division.getIdDivision(), turno.getIdTurno());
        cargarTablaHoras();
        btnCambiar1.setEnabled(true);
    }//GEN-LAST:event_tblAulasMousePressed

    private void btnCambiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiar2ActionPerformed
        for(int i = 0; i<tblHoras.getRowCount(); i++)
        {
            if(modeloTabla2.getValueAt(i, 0) != null)
            {
                hora = ctrlHora.leerHora(tblHoras.getValueAt(i, 1).toString(), tblHoras.getValueAt(i, 2).toString());
                horario.setHora(hora);
                if(checkLunes.isSelected())
                    horario.setDia(0);
                if(checkMartes.isSelected())
                    horario.setDia(1);
                if(checkMiercoles.isSelected())
                    horario.setDia(2);
                if(checkJueves.isSelected())
                    horario.setDia(3);
                if(checkViernes.isSelected())
                    horario.setDia(4);
                if(checkSabado.isSelected())
                    horario.setDia(5);
                Boolean verificar = false;
                verificar = ctrlHorario.verificarHorario(horario,txtCuil.getText());
                if(verificar == true)
                {
                    int confirmar,respuesta;
                    confirmar = JOptionPane.YES_NO_OPTION;
                    respuesta = JOptionPane.showConfirmDialog(null,"¿Desea modificar el dia y horario?","Modificar",confirmar);
                    if (respuesta == 0 )
                    {
                        ctrlHorario.modificarHorario(horario);
                        grupoDias.clearSelection();
                        cargarTablaHoras();
                        cargarTablaDias();
                        btnCambiar2.setEnabled(false);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCambiar2ActionPerformed

    private void tblCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursosMousePressed
        int FilaSelec = tblCursos.getSelectedRow();
        curso = ctrlCurso.leerCurso(tblCursos.getValueAt(FilaSelec, 0).toString());
        division = ctrlDivision.leerDivision(tblCursos.getValueAt(FilaSelec, 1).toString());
        turno = ctrlTurno.leerTurno(tblCursos.getValueAt(FilaSelec, 2).toString());
        aula = ctrlAula.leerAula(curso.getIdCurso(), division.getIdDivision(), turno.getIdTurno());
        personalMateria = ctrlPersonalMateria.leerAulaDeMateria(txtCuil.getText(), tblMaterias.getValueAt(FilaSelec, 0).toString(), aula.getIdAula());
    }//GEN-LAST:event_tblCursosMousePressed

    private void btnCambiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiar1ActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea modificar el curso?","Modificar",confirmar);
        if (respuesta == 0 )
        {
            int FilaSelec = tblAulas.getSelectedRow();
            curso = ctrlCurso.leerCurso(tblAulas.getValueAt(FilaSelec, 0).toString());
            division = ctrlDivision.leerDivision(tblAulas.getValueAt(FilaSelec, 1).toString());
            turno = ctrlTurno.leerTurno(tblAulas.getValueAt(FilaSelec, 2).toString());
            aula = ctrlAula.leerAula(curso.getIdCurso(), division.getIdDivision(), turno.getIdTurno());
            ctrlPersonalMateria.modificarAulaPersonalMateria(personalMateria, aula.getIdAula());
            cargarCursoMateria();
            cargarTablaAulas();
            btnCambiar1.setEnabled(false);
        }
    }//GEN-LAST:event_btnCambiar1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblHorasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHorasMouseReleased
        btnCambiar2.setEnabled(true);
    }//GEN-LAST:event_tblHorasMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCambiar1;
    private javax.swing.JButton btnCambiar2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JRadioButton checkJueves;
    private javax.swing.JRadioButton checkLunes;
    private javax.swing.JRadioButton checkMartes;
    private javax.swing.JRadioButton checkMiercoles;
    private javax.swing.JRadioButton checkSabado;
    private javax.swing.JRadioButton checkViernes;
    private javax.swing.ButtonGroup grupoDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblAulas;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTable tblDias;
    private javax.swing.JTable tblHoras;
    private javax.swing.JTable tblMaterias;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables
}
