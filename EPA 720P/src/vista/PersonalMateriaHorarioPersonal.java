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
import javax.swing.JTable;
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
public class PersonalMateriaHorarioPersonal extends javax.swing.JInternalFrame {
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
    List<Materia> listaMaterias = new ArrayList(), listaAñosMateria = new ArrayList();
    List<Caracter> listaCaracteres = new ArrayList();
    List<Aula> listaAulas = new ArrayList();
    List<Hora> listaHoras = new ArrayList();
    List<PersonalMateria> listaPersonalMaterias = new ArrayList();
    List<Horario> listaHorarios = new ArrayList();
    DefaultTableModel modeloTabla = new DefaultTableModel(), modeloTabla2 = new DefaultTableModel(), modeloTabla3 = new DefaultTableModel();
    public static Boolean limpiar = false;
    /**
     * Creates new form MateriaHorarioPersonal
     */
    public PersonalMateriaHorarioPersonal() {
        initComponents();
        cargarCbxMateria();
        cargarCbxCaracter();
        cargarTablaAulas();
        btnGuardar.setEnabled(false);
        btnQuitar.setEnabled(false);
        btnAgregar2.setEnabled(false);
    }
    
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
    
    public void cargarCbxMateria()
    {
        listaMaterias = ctrlMateria.leerTodos();
        cbxMateria.removeAllItems();
        for(int i=0; i< listaMaterias.size(); i++){
            cbxMateria.addItem(listaMaterias.get(i).getMateria()+" "+listaMaterias.get(i).getAño()+" °");
        }
    }
    
    public void cargarCbxCaracter()
    {
        listaCaracteres = ctrlCaracter.leerTodos();
        for(int i=0; i< listaCaracteres.size(); i++){
            cbxCaracter.addItem(listaCaracteres.get(i).getCaracter());
        }
    }
    
    public void cargarTablaAulas()
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
    
    public Boolean validarTodo()
    {
        Boolean validar = false;
        Boolean mostrarMsj = false;
        txtCupof.setBorder(new JTextField().getBorder());
        tblAulas.setBorder(new JTable().getBorder());
        tblHoras.setBorder(new JTable().getBorder());
        if(aula.getIdAula()<1 && mostrarMsj == false)
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar Curso");
            tblAulas.setBorder(new LineBorder(Color.RED, 2));
            mostrarMsj = true;
        }else
            if(fechaDesde.getDate() == null && mostrarMsj == false)
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar Fecha de Inicio");
                fechaDesde.requestFocusInWindow();
                mostrarMsj = true;
            }else
                if(fechaHasta.getDate() == null && mostrarMsj == false)
                {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar Fecha de Finalizacion");
                    fechaHasta.requestFocusInWindow();
                    mostrarMsj = true;
                }else
                    if(txtCupof.getText().equals("") && mostrarMsj == false)
                    {
                        JOptionPane.showMessageDialog(null, "Debe ingresar Cupof");
                        txtCupof.setBorder(new LineBorder(Color.RED, 2));
                        txtCupof.requestFocus();
                        mostrarMsj = true;
                    }else
                        if(tblDias.getRowCount() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "Debe agregar dia y hora");
                            checkLunes.requestFocus();
                            mostrarMsj = true;
                        }
                            else{
                                validar = true;
                            }
        return validar;
    }
    
    public void crearMateriaHorarioPersonal()
    {
        if(validarTodo() == true)
        {
            personalMateria.setPersonal(personal);
            personalMateria.setMateria(materia);
            //personalMateria.setMateria(ctrlMateria.leerMateria(cbxMateria.getSelectedItem().toString()));
            personalMateria.setCaracter(ctrlCaracter.leerCaracter(cbxCaracter.getSelectedItem().toString()));
            personalMateria.setAula(aula);
            personalMateria.setDesde(fechaDesde.getDate());
            personalMateria.setHasta(fechaHasta.getDate());
            personalMateria.setCupof(txtCupof.getText());
            personalMateria.setObservaciones(txtObservaciones.getText());
            cargarLista();
            personalMateria.setListaHorarios(listaHorarios);
            ctrlPersonalMateria.crearPersonalMateria(personalMateria);
            if(limpiar == true)
            {
                limpiar();
            }
        }
    }
    
    public void limpiar()
    {
        txtCuil.setText("");
        txtPersonal.setText("");
        txtPersonal.setBorder(new JTextField().getBorder());
        cbxMateria.setSelectedIndex(0);
        cbxCaracter.setSelectedIndex(0);
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        txtCupof.setText("");
        txtObservaciones.setText("");
        modeloTabla3.setRowCount(0);
        cargarTablaAulas();
        listaHorarios.clear();
        txtCuil.requestFocus();
    }
    
    public void limpiarChecks()
    {
        checkLunes.setSelected(false);
        checkMartes.setSelected(false);
        checkMiercoles.setSelected(false);
        checkJueves.setSelected(false);
        checkViernes.setSelected(false);
        checkSabado.setSelected(false);
    }
    
    public void cargarLista()
    {
        for(int i = 0; i < tblDias.getRowCount(); i++)
        {
            if(!String.valueOf(tblDias.getValueAt(i, 0)).equals("null"))
            {
                int dia = 0;
                if(tblDias.getValueAt(i, 0).equals("Lunes"))
                {
                    dia=0;
                }
                if(tblDias.getValueAt(i, 0).equals("Martes"))
                {
                    dia=1;
                }
                if(tblDias.getValueAt(i, 0).equals("Miercoles"))
                {
                    dia=2;
                }
                if(tblDias.getValueAt(i, 0).equals("Jueves"))
                {
                    dia=3;
                }
                if(tblDias.getValueAt(i, 0).equals("Viernes"))
                {
                    dia=4;
                }
                if(tblDias.getValueAt(i, 0).equals("Sabado"))
                {
                    dia=5;
                }
                horario.setDia(dia);
                hora = new Hora();
                hora = ctrlHora.leerHora(tblDias.getValueAt(i, 1).toString(), tblDias.getValueAt(i, 2).toString());
                horario.setHora(hora);
                listaHorarios.add(horario);
                horario = new Horario();
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

        grupoDias = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAulas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCuil = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbxMateria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxCaracter = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoras = new javax.swing.JTable();
        btnAgregar2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        checkLunes = new javax.swing.JRadioButton();
        checkMartes = new javax.swing.JRadioButton();
        checkMiercoles = new javax.swing.JRadioButton();
        checkJueves = new javax.swing.JRadioButton();
        checkViernes = new javax.swing.JRadioButton();
        checkSabado = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtCupof = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDias = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();

        setTitle("Materia y Horario de Personal");

        jPanel1.setBackground(new java.awt.Color(0, 152, 101));

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

        jPanel2.setBackground(new java.awt.Color(0, 152, 101));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        cbxMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMateriaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Caracter");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Materia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCaracter, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCaracter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 152, 101));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Dia y Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblHorasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoras);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 90, 349, -1));

        btnAgregar2.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar2.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 331, -1, -1));

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

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 152, 101));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Informacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fecha.png"))); // NOI18N
        jLabel10.setText("Fecha Inicio");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fecha.png"))); // NOI18N
        jLabel7.setText("Fecha Finalizacion");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cupof");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Observaciones");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane3.setViewportView(txtObservaciones);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCupof, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCupof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131))
        );

        jPanel9.setBackground(new java.awt.Color(0, 152, 101));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dias y Horarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

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

        btnQuitar.setBackground(new java.awt.Color(0, 51, 51));
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuitar)
                .addGap(291, 291, 291))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnQuitar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnSalir))))
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
                cbxMateria.requestFocus();
                btnGuardar.setEnabled(true);
            }else{
                txtPersonal.setText("");
                txtPersonal.setBorder(new LineBorder(Color.RED, 2));
                txtCuil.requestFocus();
                btnGuardar.setEnabled(false);
            }
        }else{
            txtCuil.setBorder(new LineBorder(Color.RED, 2));
            txtCuil.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblAulasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAulasMousePressed
        int FilaSelec = tblAulas.getSelectedRow();
        curso = ctrlCurso.leerCurso(tblAulas.getValueAt(FilaSelec, 0).toString());
        division = ctrlDivision.leerDivision(tblAulas.getValueAt(FilaSelec, 1).toString());
        turno = ctrlTurno.leerTurno(tblAulas.getValueAt(FilaSelec, 2).toString());
        aula = ctrlAula.leerAula(curso.getIdCurso(), division.getIdDivision(), turno.getIdTurno());
        cargarTablaHoras();
    }//GEN-LAST:event_tblAulasMousePressed

    private void tblHorasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHorasMousePressed
        if(grupoDias.getSelection()!=null)
        {
            int FilaSelec = tblHoras.getSelectedRow();
        hora = ctrlHora.leerHora(tblHoras.getValueAt(FilaSelec, 1).toString(), tblHoras.getValueAt(FilaSelec, 2).toString());
        btnAgregar2.setEnabled(true);
        }else{
            btnAgregar2.setEnabled(false);
        }
        
    }//GEN-LAST:event_tblHorasMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        crearMateriaHorarioPersonal();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMateriaActionPerformed
        if(cbxMateria.getSelectedItem() != null)
        {
            String datosMateria = (String) cbxMateria.getSelectedItem();
            String[] parts = datosMateria.split(" ");
            String nombreMateria = parts[0];
            int añoMateria = Integer.valueOf(parts[1]);
            materia = ctrlMateria.leerMateria(nombreMateria,añoMateria);
        }
    }//GEN-LAST:event_cbxMateriaActionPerformed

    private void tblDiasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiasMousePressed
        btnQuitar.setEnabled(true);
    }//GEN-LAST:event_tblDiasMousePressed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        modeloTabla3 = (DefaultTableModel) tblDias.getModel();
        String[] fila = new String[3];
        for(int i = 0; i<tblHoras.getRowCount(); i++)
        {
            if(modeloTabla2.getValueAt(i, 0) != null)
            {
                if(checkLunes.isSelected())
                    fila[0] = "Lunes";
                if(checkMartes.isSelected())
                    fila[0] = "Martes";
                if(checkMiercoles.isSelected())
                    fila[0] = "Miercoles";
                if(checkJueves.isSelected())
                    fila[0] = "Jueves";
                if(checkViernes.isSelected())
                    fila[0] = "Viernes";
                if(checkSabado.isSelected())
                    fila[0] = "Sabado";
                fila[1] = modeloTabla2.getValueAt(i, 1).toString();
                fila[2] = modeloTabla2.getValueAt(i, 2).toString();
                modeloTabla3.addRow(fila);
                tblDias.setModel(modeloTabla3);
                btnQuitar.setEnabled(false);
            }
        }
        grupoDias.clearSelection();
        btnAgregar2.setEnabled(false);
        cargarTablaHoras();
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int FilaSelec = tblDias.getSelectedRow();
        if(FilaSelec >= 0)
        {
            modeloTabla3.removeRow(FilaSelec);
            listaHorarios.remove(FilaSelec);
            tblDias.setModel(modeloTabla3);
            btnQuitar.setEnabled(false);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxCaracter;
    private javax.swing.JComboBox<String> cbxMateria;
    private javax.swing.JRadioButton checkJueves;
    private javax.swing.JRadioButton checkLunes;
    private javax.swing.JRadioButton checkMartes;
    private javax.swing.JRadioButton checkMiercoles;
    private javax.swing.JRadioButton checkSabado;
    private javax.swing.JRadioButton checkViernes;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.ButtonGroup grupoDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTable tblAulas;
    private javax.swing.JTable tblDias;
    private javax.swing.JTable tblHoras;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtCupof;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables
}
