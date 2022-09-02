/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlAlumno;
import controlador.CtrlAlumnoMateria;
import controlador.CtrlComunidad;
import controlador.CtrlDomicilio;
import controlador.CtrlEdificio;
import controlador.CtrlEstado;
import controlador.CtrlEstadoCivil;
//import controlador.CtrlLocalidad;
import controlador.CtrlLugar;
import controlador.CtrlNacionalidad;
import controlador.CtrlPersonal;
import controlador.CtrlPesoTalla;
import controlador.CtrlPlanSocial;
import controlador.CtrlPlanSocialAlumno;
import controlador.CtrlRegimenEspecial;
import controlador.CtrlSexo;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Comunidad;
import modelo.Domicilio;
import modelo.Edificio;
import modelo.Estado;
import modelo.EstadoCivil;
import modelo.Lugar;
import modelo.Nacionalidad;
import modelo.Personal;
import modelo.PesoTalla;
import modelo.PlanSocial;
import modelo.PlanSocialAlumno;
import modelo.RegimenEspecial;
import modelo.Sexo;

/**
 *
 * @author Kevin
 */
public class PersonalAlumnoRegistrar extends javax.swing.JInternalFrame {

    //Declaracion de Variables del paquete Modelo
    private Alumno alumno;
    private Personal personal;
    private Estado estado;
    private EstadoCivil estadoCivil;
    private Lugar lugar;
    private Sexo sexo;
    private Nacionalidad nacionalidad;
    private Domicilio domicilio;
    private Edificio edificio;
    private PesoTalla pesoTalla;
    private Comunidad comunidad;
    private RegimenEspecial regimenEspecial;
    //Declaracion de Variables del paquete Controlador
    private CtrlPersonal ctrlPersonal;
    private CtrlAlumno ctrlAlumno;
    private CtrlEstado ctrlEstado;
    private CtrlEstadoCivil ctrlEstadoCivil;
    private CtrlSexo ctrlSexo;
    private CtrlLugar ctrlLugar;
    private CtrlNacionalidad ctrlNacionalidad;
    private CtrlDomicilio ctrlDomicilio;
    private CtrlEdificio ctrlEdificio;
    private CtrlPesoTalla ctrlPesoTalla;
    private CtrlComunidad ctrlComunidad;
    private CtrlRegimenEspecial ctrlRegimenEspecial;
    private CtrlPlanSocial ctrlPlanSocial;
    private CtrlPlanSocialAlumno ctrlPlanSocialAlumno;
    private CtrlAlumnoMateria ctrlAlumnoMateria;
    //Lista Obejto
    private List<Estado> listaEstado = new ArrayList<>();
    private List<EstadoCivil> listaEstadoCivil = new ArrayList<>();
    private List<Lugar> listaLocalidad = new ArrayList<>();
    private List<Lugar> listaBarrio = new ArrayList<>();
    private List<Lugar> listaCalle = new ArrayList<>();
    private List<Lugar> listaNacionalidad = new ArrayList<>();
    private List<Sexo> listaSexo = new ArrayList<>();
    private List<Comunidad> listComunidad = new ArrayList<>();
    private List<RegimenEspecial> listRegimenEspecial = new ArrayList<>();
    private List<PlanSocial> listPlan = new ArrayList<>();
    private List<PlanSocial> listPlanMod = new ArrayList<>();
    private List<PlanSocial> listPlanResultante = new ArrayList<>();
    //Variable tipo Byte
    byte[] imagen = null;

    private DefaultTableModel model = new DefaultTableModel();

    public PersonalAlumnoRegistrar() {
        initComponents();
        //Seleccionar No
        rbtnDisNo.setSelected(true);
        rbtnDocInteNo.setSelected(true);
        rbtnTanspEscolarNo.setSelected(true);
        rbtnBeneficioEscolarNo.setSelected(true);
        rbtnPlanSocialNo.setSelected(true);

        ckbSinInst.setSelected(true);

        txtCualInterCul.setEnabled(false);
        txtRegEspCual.setEnabled(false);

        fechaAlta.setDate(new Date());
        //Instancias de controladores
        ctrlAlumno = new CtrlAlumno();
        ctrlEstado = new CtrlEstado();
        ctrlPersonal = new CtrlPersonal();
        ctrlEstadoCivil = new CtrlEstadoCivil();
        
        ctrlLugar = new CtrlLugar();
        ctrlSexo = new CtrlSexo();
        ctrlNacionalidad = new CtrlNacionalidad();
        ctrlDomicilio = new CtrlDomicilio();
        ctrlEdificio = new CtrlEdificio();
        ctrlPesoTalla = new CtrlPesoTalla();
        ctrlRegimenEspecial = new CtrlRegimenEspecial();
        ctrlComunidad = new CtrlComunidad();
        ctrlPlanSocial = new CtrlPlanSocial();
        ctrlPlanSocialAlumno = new CtrlPlanSocialAlumno();
        ctrlAlumnoMateria = new CtrlAlumnoMateria();
        //Lamado de Metodos
        cargarComboEstado();
        cargarComboEstadoCivil();
        cargarComboLocalidad();
        cargarComboNacionalidad();
        cargarComboSexo();
        checkBoxDiscapacidad(false);
        checkBoxServAlimentEscolar(false);
        checkBoxPlanSocial(false);
        cargarComboRegimen();
        cargarComboComunidad();
        cargarTablaPlanReg();

        cbxCualInterCul.setSelectedItem("No pertenece");
        cbxRegEspExist.setSelectedItem("No pertenece");

        txtCuil.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gprBeneServicio = new javax.swing.ButtonGroup();
        gprPlanSocial = new javax.swing.ButtonGroup();
        gprDocenteIntegrador = new javax.swing.ButtonGroup();
        gprTransporte = new javax.swing.ButtonGroup();
        gprDiscapacidad = new javax.swing.ButtonGroup();
        gprTutor = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        tpnDatPersonales = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        webCam = new JPanelWebCam.JPanelWebCam();
        lblWebCam = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbxCalle = new javax.swing.JComboBox<>();
        txtFijo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cbxSexo = new javax.swing.JComboBox<>();
        lblBarrio = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDepto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHijos = new javax.swing.JTextField();
        cbxNacionalidad = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblTorre = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        fechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtTorre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxEstadoCivil = new javax.swing.JComboBox<>();
        fechaAlta = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxBarrio = new javax.swing.JComboBox<>();
        txtCodPost = new javax.swing.JTextField();
        lblNacionalidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbxLocalidad = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCuil = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        lblKg = new javax.swing.JLabel();
        lblFechaMedicion = new javax.swing.JLabel();
        fechaMedicion = new com.toedter.calendar.JDateChooser();
        txtTalla = new javax.swing.JTextField();
        lblTalla = new javax.swing.JLabel();
        lblCm = new javax.swing.JLabel();
        lblFechaCarga = new javax.swing.JLabel();
        fechaCarga = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        lblDiscapacidad = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        rbtnDisSi = new javax.swing.JRadioButton();
        rbtnDisNo = new javax.swing.JRadioButton();
        lblBeneficioEscolarCual1 = new javax.swing.JLabel();
        ckbCeguera = new javax.swing.JCheckBox();
        ckbSordera = new javax.swing.JCheckBox();
        ckbMotora = new javax.swing.JCheckBox();
        ckbNeuromotora = new javax.swing.JCheckBox();
        ckbHipoacusia = new javax.swing.JCheckBox();
        ckbDisminuciónVisual = new javax.swing.JCheckBox();
        ckbAutista = new javax.swing.JCheckBox();
        ckbDiscapacidadOtro = new javax.swing.JCheckBox();
        txtDiscapacidadOtro = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        lblDoceInter = new javax.swing.JLabel();
        rbtnSecEstatal = new javax.swing.JRadioButton();
        rbtnSecPrivado = new javax.swing.JRadioButton();
        rbtnDocInteNo = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblPlanSocial = new javax.swing.JLabel();
        rbtnPlanSocialSi = new javax.swing.JRadioButton();
        rbtnPlanSocialNo = new javax.swing.JRadioButton();
        lblPlanSocialCual = new javax.swing.JLabel();
        lblPlanSocReg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlanSocReg = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlanSocAlum = new javax.swing.JTable();
        lblPlanSocAlum = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblTanspEscolar = new javax.swing.JLabel();
        rbtnSiFinanEdu = new javax.swing.JRadioButton();
        rbtnSiFinaOrganismo = new javax.swing.JRadioButton();
        rbtnTanspEscolarNo = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        lblBeneficioEscolar = new javax.swing.JLabel();
        rbtnBeneficioEscolarSi = new javax.swing.JRadioButton();
        rbtnBeneficioEscolarNo = new javax.swing.JRadioButton();
        lblBeneficioEscolarCual = new javax.swing.JLabel();
        ckbDesaMerComp = new javax.swing.JCheckBox();
        ckbAlmuerzo = new javax.swing.JCheckBox();
        ckbMerienda = new javax.swing.JCheckBox();
        ckbDesayuno = new javax.swing.JCheckBox();
        ckbComeSimple = new javax.swing.JCheckBox();
        ckbCena = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        ckbSinInst = new javax.swing.JRadioButton();
        ckbPriComp = new javax.swing.JRadioButton();
        ckbPriIncomp = new javax.swing.JRadioButton();
        ckbSecuPolComp = new javax.swing.JRadioButton();
        ckbSecuPolInComp = new javax.swing.JRadioButton();
        ckbSupComp = new javax.swing.JRadioButton();
        ckbSupImcomp = new javax.swing.JRadioButton();
        ckbNosabe = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblCualInterCul = new javax.swing.JLabel();
        cbxCualInterCul = new javax.swing.JComboBox<>();
        ckbCualInter = new javax.swing.JCheckBox();
        txtCualInterCul = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbxRegEspExist = new javax.swing.JComboBox<>();
        txtRegEspCual = new javax.swing.JTextField();
        ckbCualRegimen = new javax.swing.JCheckBox();

        setTitle("Administrar Alumnos");

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

        btnModificar.setBackground(new java.awt.Color(0, 51, 51));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar2.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
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

        tpnDatPersonales.setBackground(new java.awt.Color(0, 152, 101));
        tpnDatPersonales.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 152, 101));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        webCam.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        webCam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                webCamMousePressed(evt);
            }
        });
        webCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWebCam.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lblWebCam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWebCam.setText("Activar WebCam");
        webCam.add(lblWebCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 220));

        btnCargarFoto.setBackground(new java.awt.Color(0, 51, 51));
        btnCargarFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargarFoto.png"))); // NOI18N
        btnCargarFoto.setToolTipText("Si no tiene WebCam, puede cargar la foto manualmente");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Click en el video para tomar foto");

        jPanel14.setBackground(new java.awt.Color(0, 152, 101));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hijos.png"))); // NOI18N
        jLabel7.setText("Hijos");

        cbxCalle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCalleItemStateChanged(evt);
            }
        });

        txtFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFijoKeyTyped(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuil.png"))); // NOI18N
        jLabel1.setText("CUIL");

        lblNumero.setForeground(new java.awt.Color(255, 255, 255));
        lblNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/numberHouse.png"))); // NOI18N
        lblNumero.setText("Numero");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fecha.png"))); // NOI18N
        jLabel21.setText("Fecha de Alta");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edificio.png"))); // NOI18N
        jLabel17.setText("Edificio");

        lblCalle.setForeground(new java.awt.Color(255, 255, 255));
        lblCalle.setText("Calle");

        btnBuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoActionPerformed(evt);
            }
        });

        lblBarrio.setForeground(new java.awt.Color(255, 255, 255));
        lblBarrio.setText("B°");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nombreApellido.png"))); // NOI18N
        jLabel3.setText("Nombre");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Referencia");

        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estadoCivil.png"))); // NOI18N
        jLabel6.setText("Estado Civil");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fijo.png"))); // NOI18N
        jLabel11.setText("Telefono Fijo");

        txtHijos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHijosKeyTyped(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Situacion Academica");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblTorre.setForeground(new java.awt.Color(255, 255, 255));
        lblTorre.setText("Torre");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/email.png"))); // NOI18N
        jLabel9.setText("Email");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Depto");

        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        fechaNacimiento.setBackground(new java.awt.Color(0, 152, 101));

        txtTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTorreActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sexo.png"))); // NOI18N
        jLabel5.setText("Sexo");

        cbxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoCivilActionPerformed(evt);
            }
        });

        fechaAlta.setBackground(new java.awt.Color(0, 152, 101));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/legajo.png"))); // NOI18N
        jLabel13.setText("Legajo");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Codigo Postal");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Piso");

        cbxBarrio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBarrioItemStateChanged(evt);
            }
        });

        lblNacionalidad.setForeground(new java.awt.Color(255, 255, 255));
        lblNacionalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nacionalidad.png"))); // NOI18N
        lblNacionalidad.setText("Nacionalidad");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fecha.png"))); // NOI18N
        jLabel4.setText("Fecha de Nacimiento");

        txtLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLegajoKeyTyped(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/localidad.png"))); // NOI18N
        jLabel12.setText("Localidad");

        cbxLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLocalidadItemStateChanged(evt);
            }
        });
        cbxLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLocalidadActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nombreApellido.png"))); // NOI18N
        jLabel2.setText("Apellido");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/celular.png"))); // NOI18N
        jLabel8.setText("Telefono Celular");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/domicilio.png"))); // NOI18N
        jLabel10.setText("Domicilio");

        txtCuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuilKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(6, 6, 6)
                        .addComponent(fechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13)
                        .addGap(12, 12, 12)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(lblNacionalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(cbxLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel10)
                        .addGap(15, 15, 15)
                        .addComponent(lblBarrio)
                        .addGap(6, 6, 6)
                        .addComponent(cbxBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblCalle)
                        .addGap(6, 6, 6)
                        .addComponent(cbxCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodPost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(lblTorre)
                        .addGap(6, 6, 6)
                        .addComponent(txtTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(9, 9, 9)
                        .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNacionalidad)
                        .addComponent(jLabel4))
                    .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cbxLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBarrio)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cbxBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblCalle))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumero)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txtCodPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(lblTorre)
                        .addComponent(txtTorre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(fechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel19))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel22.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Subir foto Manualmente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(webCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        tpnDatPersonales.addTab("Datos Personales", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 152, 101));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel11.setBackground(new java.awt.Color(0, 152, 101));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Crecimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        lblPeso.setForeground(new java.awt.Color(255, 255, 255));
        lblPeso.setText("Peso");

        lblKg.setForeground(new java.awt.Color(255, 255, 255));
        lblKg.setText("Kg");

        lblFechaMedicion.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaMedicion.setText("Fecha de medición");

        fechaMedicion.setBackground(new java.awt.Color(0, 152, 101));

        lblTalla.setForeground(new java.awt.Color(255, 255, 255));
        lblTalla.setText("Talla");

        lblCm.setForeground(new java.awt.Color(255, 255, 255));
        lblCm.setText("cm");

        lblFechaCarga.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaCarga.setText("Fecha de carga ");

        fechaCarga.setBackground(new java.awt.Color(0, 152, 101));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblTalla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKg))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblCm)))
                .addGap(35, 35, 35)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblFechaMedicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaMedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblFechaCarga)
                        .addGap(22, 22, 22)
                        .addComponent(fechaCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPeso)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaMedicion)
                        .addComponent(lblKg))
                    .addComponent(fechaMedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaCarga)
                        .addComponent(lblTalla)
                        .addComponent(lblCm))
                    .addComponent(fechaCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 152, 101));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Discapacidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        lblDiscapacidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDiscapacidad.setForeground(new java.awt.Color(255, 255, 255));
        lblDiscapacidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/discapacidad.png"))); // NOI18N
        lblDiscapacidad.setText("DISCAPACIDAD (completar solo si corresponde)");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("¿El alumno posee alguna Discapacidad?");

        rbtnDisSi.setBackground(new java.awt.Color(0, 152, 101));
        gprDiscapacidad.add(rbtnDisSi);
        rbtnDisSi.setForeground(new java.awt.Color(255, 255, 255));
        rbtnDisSi.setText("Si");
        rbtnDisSi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnDisSiItemStateChanged(evt);
            }
        });
        rbtnDisSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnDisSiMousePressed(evt);
            }
        });
        rbtnDisSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDisSiActionPerformed(evt);
            }
        });

        rbtnDisNo.setBackground(new java.awt.Color(0, 152, 101));
        gprDiscapacidad.add(rbtnDisNo);
        rbtnDisNo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnDisNo.setText("No");
        rbtnDisNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDisNoActionPerformed(evt);
            }
        });

        lblBeneficioEscolarCual1.setForeground(new java.awt.Color(255, 255, 255));
        lblBeneficioEscolarCual1.setText("¿Cuál?");

        ckbCeguera.setBackground(new java.awt.Color(0, 152, 101));
        ckbCeguera.setForeground(new java.awt.Color(255, 255, 255));
        ckbCeguera.setText("Ceguera");

        ckbSordera.setBackground(new java.awt.Color(0, 152, 101));
        ckbSordera.setForeground(new java.awt.Color(255, 255, 255));
        ckbSordera.setText("Sordera");

        ckbMotora.setBackground(new java.awt.Color(0, 152, 101));
        ckbMotora.setForeground(new java.awt.Color(255, 255, 255));
        ckbMotora.setText("Motora pura Intelectual");

        ckbNeuromotora.setBackground(new java.awt.Color(0, 152, 101));
        ckbNeuromotora.setForeground(new java.awt.Color(255, 255, 255));
        ckbNeuromotora.setText("Neuromotora");

        ckbHipoacusia.setBackground(new java.awt.Color(0, 152, 101));
        ckbHipoacusia.setForeground(new java.awt.Color(255, 255, 255));
        ckbHipoacusia.setText("Hipoacusia");
        ckbHipoacusia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbHipoacusiaActionPerformed(evt);
            }
        });

        ckbDisminuciónVisual.setBackground(new java.awt.Color(0, 152, 101));
        ckbDisminuciónVisual.setForeground(new java.awt.Color(255, 255, 255));
        ckbDisminuciónVisual.setText("Disminución Visual");

        ckbAutista.setBackground(new java.awt.Color(0, 152, 101));
        ckbAutista.setForeground(new java.awt.Color(255, 255, 255));
        ckbAutista.setText("Trastorno del Espectro Autista      ");

        ckbDiscapacidadOtro.setBackground(new java.awt.Color(0, 152, 101));
        ckbDiscapacidadOtro.setForeground(new java.awt.Color(255, 255, 255));
        ckbDiscapacidadOtro.setText("Otro");
        ckbDiscapacidadOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbDiscapacidadOtroActionPerformed(evt);
            }
        });

        txtDiscapacidadOtro.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(ckbNeuromotora)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbHipoacusia)
                            .addComponent(ckbSordera))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbDisminuciónVisual)
                            .addComponent(ckbMotora)))
                    .addComponent(ckbCeguera)
                    .addComponent(jLabel31)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(rbtnDisSi)
                        .addGap(38, 38, 38)
                        .addComponent(rbtnDisNo))
                    .addComponent(lblBeneficioEscolarCual1)
                    .addComponent(lblDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(ckbAutista)
                        .addGap(18, 18, 18)
                        .addComponent(ckbDiscapacidadOtro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiscapacidadOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDiscapacidad)
                .addGap(7, 7, 7)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnDisSi)
                    .addComponent(rbtnDisNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBeneficioEscolarCual1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbCeguera)
                    .addComponent(ckbSordera)
                    .addComponent(ckbMotora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbNeuromotora)
                    .addComponent(ckbDisminuciónVisual)
                    .addComponent(ckbHipoacusia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbAutista)
                    .addComponent(txtDiscapacidadOtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbDiscapacidadOtro))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(0, 152, 101));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Docente Integrador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        lblDoceInter.setForeground(new java.awt.Color(255, 255, 255));
        lblDoceInter.setText("¿Tiene docente integrador o de apoyo que lo acompañe?");

        rbtnSecEstatal.setBackground(new java.awt.Color(0, 152, 101));
        gprDocenteIntegrador.add(rbtnSecEstatal);
        rbtnSecEstatal.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSecEstatal.setText("Si, del sector estatal");

        rbtnSecPrivado.setBackground(new java.awt.Color(0, 152, 101));
        gprDocenteIntegrador.add(rbtnSecPrivado);
        rbtnSecPrivado.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSecPrivado.setText("Si, del sector Privado");

        rbtnDocInteNo.setBackground(new java.awt.Color(0, 152, 101));
        gprDocenteIntegrador.add(rbtnDocInteNo);
        rbtnDocInteNo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnDocInteNo.setText("No");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rbtnSecEstatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnSecPrivado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnDocInteNo))
                    .addComponent(lblDoceInter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDoceInter)
                .addGap(6, 6, 6)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnSecEstatal)
                    .addComponent(rbtnSecPrivado)
                    .addComponent(rbtnDocInteNo))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 360, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );

        tpnDatPersonales.addTab("Datos Medícos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 152, 101));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(0, 152, 101));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Plan Social", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        lblPlanSocial.setForeground(new java.awt.Color(255, 255, 255));
        lblPlanSocial.setText("¿El menor y/o sus padres/ tutores son beneficiarios de algún Plan Social?");

        rbtnPlanSocialSi.setBackground(new java.awt.Color(0, 152, 101));
        gprPlanSocial.add(rbtnPlanSocialSi);
        rbtnPlanSocialSi.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPlanSocialSi.setText("Si");
        rbtnPlanSocialSi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnPlanSocialSiItemStateChanged(evt);
            }
        });

        rbtnPlanSocialNo.setBackground(new java.awt.Color(0, 152, 101));
        gprPlanSocial.add(rbtnPlanSocialNo);
        rbtnPlanSocialNo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPlanSocialNo.setText("No");
        rbtnPlanSocialNo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnPlanSocialNoItemStateChanged(evt);
            }
        });
        rbtnPlanSocialNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPlanSocialNoActionPerformed(evt);
            }
        });

        lblPlanSocialCual.setForeground(new java.awt.Color(255, 255, 255));
        lblPlanSocialCual.setText("¿Cuál?");

        lblPlanSocReg.setForeground(new java.awt.Color(255, 255, 255));
        lblPlanSocReg.setText("Plan Social Registrados");

        tblPlanSocReg = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblPlanSocReg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlanSocReg.setEnabled(false);
        tblPlanSocReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlanSocRegMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlanSocReg);

        btnAgregar.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar>>");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(new java.awt.Color(0, 51, 51));
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("<<Quitar");
        btnQuitar.setEnabled(false);
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        tblPlanSocAlum = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblPlanSocAlum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlanSocAlum.setEnabled(false);
        tblPlanSocAlum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlanSocAlumMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPlanSocAlum);

        lblPlanSocAlum.setForeground(new java.awt.Color(255, 255, 255));
        lblPlanSocAlum.setText("Plan Social Alumno");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlanSocial)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(rbtnPlanSocialSi)
                                .addGap(38, 38, 38)
                                .addComponent(rbtnPlanSocialNo))
                            .addComponent(lblPlanSocialCual)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblPlanSocReg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPlanSocAlum)
                        .addGap(93, 93, 93))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblPlanSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnPlanSocialSi)
                    .addComponent(rbtnPlanSocialNo))
                .addGap(0, 0, 0)
                .addComponent(lblPlanSocialCual)
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlanSocReg, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPlanSocAlum, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitar)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );

        jPanel7.setBackground(new java.awt.Color(0, 152, 101));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transporte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        lblTanspEscolar.setForeground(new java.awt.Color(255, 255, 255));
        lblTanspEscolar.setText("¿Utiliza Transporte Escolar?");

        rbtnSiFinanEdu.setBackground(new java.awt.Color(0, 152, 101));
        gprTransporte.add(rbtnSiFinanEdu);
        rbtnSiFinanEdu.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSiFinanEdu.setText("Si, Financiado por Educación (BEGU)");

        rbtnSiFinaOrganismo.setBackground(new java.awt.Color(0, 152, 101));
        gprTransporte.add(rbtnSiFinaOrganismo);
        rbtnSiFinaOrganismo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSiFinaOrganismo.setText("Si, Financiado por otro organismo");
        rbtnSiFinaOrganismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSiFinaOrganismoActionPerformed(evt);
            }
        });

        rbtnTanspEscolarNo.setBackground(new java.awt.Color(0, 152, 101));
        gprTransporte.add(rbtnTanspEscolarNo);
        rbtnTanspEscolarNo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnTanspEscolarNo.setText("No");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTanspEscolar)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(rbtnSiFinanEdu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnSiFinaOrganismo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnTanspEscolarNo)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTanspEscolar)
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnSiFinanEdu)
                    .addComponent(rbtnSiFinaOrganismo)
                    .addComponent(rbtnTanspEscolarNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 152, 101));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Beneficio Alimentario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        lblBeneficioEscolar.setForeground(new java.awt.Color(255, 255, 255));
        lblBeneficioEscolar.setText("¿Es beneficiario de Servicio Alimentario Escolar?");

        rbtnBeneficioEscolarSi.setBackground(new java.awt.Color(0, 152, 101));
        gprBeneServicio.add(rbtnBeneficioEscolarSi);
        rbtnBeneficioEscolarSi.setForeground(new java.awt.Color(255, 255, 255));
        rbtnBeneficioEscolarSi.setText("Si");
        rbtnBeneficioEscolarSi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnBeneficioEscolarSiItemStateChanged(evt);
            }
        });

        rbtnBeneficioEscolarNo.setBackground(new java.awt.Color(0, 152, 101));
        gprBeneServicio.add(rbtnBeneficioEscolarNo);
        rbtnBeneficioEscolarNo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnBeneficioEscolarNo.setText("No");
        rbtnBeneficioEscolarNo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnBeneficioEscolarNoItemStateChanged(evt);
            }
        });
        rbtnBeneficioEscolarNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnBeneficioEscolarNoActionPerformed(evt);
            }
        });

        lblBeneficioEscolarCual.setForeground(new java.awt.Color(255, 255, 255));
        lblBeneficioEscolarCual.setText("¿Cuál?");

        ckbDesaMerComp.setBackground(new java.awt.Color(0, 152, 101));
        ckbDesaMerComp.setForeground(new java.awt.Color(255, 255, 255));
        ckbDesaMerComp.setText("Desayuno/ merienda completa");
        ckbDesaMerComp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbDesaMerCompItemStateChanged(evt);
            }
        });
        ckbDesaMerComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbDesaMerCompActionPerformed(evt);
            }
        });

        ckbAlmuerzo.setBackground(new java.awt.Color(0, 152, 101));
        ckbAlmuerzo.setForeground(new java.awt.Color(255, 255, 255));
        ckbAlmuerzo.setText("Almuerzo");

        ckbMerienda.setBackground(new java.awt.Color(0, 152, 101));
        ckbMerienda.setForeground(new java.awt.Color(255, 255, 255));
        ckbMerienda.setText("Merienda");

        ckbDesayuno.setBackground(new java.awt.Color(0, 152, 101));
        ckbDesayuno.setForeground(new java.awt.Color(255, 255, 255));
        ckbDesayuno.setText("Desayuno");

        ckbComeSimple.setBackground(new java.awt.Color(0, 152, 101));
        ckbComeSimple.setForeground(new java.awt.Color(255, 255, 255));
        ckbComeSimple.setText("Comedor Simple");

        ckbCena.setBackground(new java.awt.Color(0, 152, 101));
        ckbCena.setForeground(new java.awt.Color(255, 255, 255));
        ckbCena.setText("Cena");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBeneficioEscolarCual)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbDesaMerComp)
                            .addComponent(ckbAlmuerzo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(ckbMerienda)
                                .addGap(18, 18, 18)
                                .addComponent(ckbCena))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(ckbDesayuno)
                                .addGap(12, 12, 12)
                                .addComponent(ckbComeSimple))))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(rbtnBeneficioEscolarSi)
                            .addGap(38, 38, 38)
                            .addComponent(rbtnBeneficioEscolarNo))
                        .addComponent(lblBeneficioEscolar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBeneficioEscolar)
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnBeneficioEscolarSi)
                    .addComponent(rbtnBeneficioEscolarNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBeneficioEscolarCual)
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckbDesaMerComp)
                    .addComponent(ckbDesayuno)
                    .addComponent(ckbComeSimple))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckbAlmuerzo)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ckbMerienda)
                        .addComponent(ckbCena)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tpnDatPersonales.addTab("Datos Socio Economico", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 152, 101));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel9.setBackground(new java.awt.Color(0, 152, 101));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Tutor o Encargado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("¿Cuál es el máximo nivel educativo alcanzo por la madre, padre o tutor?");

        ckbSinInst.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbSinInst);
        ckbSinInst.setForeground(new java.awt.Color(255, 255, 255));
        ckbSinInst.setText("Sin instrucción");

        ckbPriComp.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbPriComp);
        ckbPriComp.setForeground(new java.awt.Color(255, 255, 255));
        ckbPriComp.setText("Primaria/EGB Completa");

        ckbPriIncomp.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbPriIncomp);
        ckbPriIncomp.setForeground(new java.awt.Color(255, 255, 255));
        ckbPriIncomp.setText("Primaria/EGB Incompleta");

        ckbSecuPolComp.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbSecuPolComp);
        ckbSecuPolComp.setForeground(new java.awt.Color(255, 255, 255));
        ckbSecuPolComp.setText("Secundaria/Polimodal Completa");

        ckbSecuPolInComp.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbSecuPolInComp);
        ckbSecuPolInComp.setForeground(new java.awt.Color(255, 255, 255));
        ckbSecuPolInComp.setText("Secundaria/Polimodal Incompleta");

        ckbSupComp.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbSupComp);
        ckbSupComp.setForeground(new java.awt.Color(255, 255, 255));
        ckbSupComp.setText("Superior Completo");

        ckbSupImcomp.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbSupImcomp);
        ckbSupImcomp.setForeground(new java.awt.Color(255, 255, 255));
        ckbSupImcomp.setText("Superior Incompleto");

        ckbNosabe.setBackground(new java.awt.Color(0, 152, 101));
        gprTutor.add(ckbNosabe);
        ckbNosabe.setForeground(new java.awt.Color(255, 255, 255));
        ckbNosabe.setText("No Sabe");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbSinInst)
                            .addComponent(ckbSecuPolInComp))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbPriComp)
                            .addComponent(ckbSupComp))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbSupImcomp)
                            .addComponent(ckbPriIncomp)))
                    .addComponent(jLabel35)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(ckbSecuPolComp)
                        .addGap(18, 18, 18)
                        .addComponent(ckbNosabe))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbSinInst)
                    .addComponent(ckbPriComp)
                    .addComponent(ckbPriIncomp))
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbSecuPolInComp)
                    .addComponent(ckbSupComp)
                    .addComponent(ckbSupImcomp))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbSecuPolComp)
                    .addComponent(ckbNosabe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(0, 152, 101));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interculturalidad y Regimen Especial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/interCul.png"))); // NOI18N
        jLabel29.setText("INTERCULTURALIDAD");

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("¿Se considera indígena o perteneciente a una comunidad indígena o habla una lengua indígena?");

        lblCualInterCul.setForeground(new java.awt.Color(255, 255, 255));
        lblCualInterCul.setText("¿Cuál?");

        ckbCualInter.setBackground(new java.awt.Color(0, 152, 101));
        ckbCualInter.setForeground(new java.awt.Color(255, 255, 255));
        ckbCualInter.setText("Otro");
        ckbCualInter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbCualInterItemStateChanged(evt);
            }
        });
        ckbCualInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbCualInterActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("REGIMEN ESPECIAL");

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Si se encuentra privado de la libertad o en régimen semi-abierto, escriba cual es el nombre del centro de donde proviene");

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("¿Cuál?");

        ckbCualRegimen.setBackground(new java.awt.Color(0, 152, 101));
        ckbCualRegimen.setForeground(new java.awt.Color(255, 255, 255));
        ckbCualRegimen.setText("Otro");
        ckbCualRegimen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbCualRegimenItemStateChanged(evt);
            }
        });
        ckbCualRegimen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbCualRegimenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblCualInterCul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCualInterCul, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(ckbCualInter)
                        .addGap(12, 12, 12)
                        .addComponent(txtCualInterCul, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxRegEspExist, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(ckbCualRegimen)
                        .addGap(12, 12, 12)
                        .addComponent(txtRegEspCual, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCualInterCul)
                    .addComponent(cbxCualInterCul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCualInterCul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbCualInter))
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(cbxRegEspExist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegEspCual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbCualRegimen))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        tpnDatPersonales.addTab("Datos Complementarios", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tpnDatPersonales)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tpnDatPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (validar()) {
            guardar();
        } else {
            System.err.println("no se puede");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarDomicilio();
        modificarPersonal();
        modificarAlumno();
        modificarEdificio();
        modificarPlanSocialAlumno();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (ctrlAlumnoMateria.tieneMaterias(alumno.getIdAlumno()) == true) {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar al Alumno","Error",JOptionPane.ERROR_MESSAGE);
        } else{
            ctrlAlumno.eliminar(alumno.getIdAlumno());
            JOptionPane.showMessageDialog(this, "El alumno ha sido eliminado correctamente");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        JFileChooser file = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagen", "jpg", "png", "jpeg");
        file.setFileFilter(filtro);

        int seleccion = file.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //File files = file.getSelectedFile();
            String fil = file.getSelectedFile().getPath();
//            String files = file.getSelectedFile().toString();
//            ImageIcon ico = new ImageIcon(fil);
//            Image img = ico.getImage();
//
//            Image newImg = img.getScaledInstance(webCam.getWidth(), webCam.getHeight(), java.awt.Image.SCALE_SMOOTH);

            imagen = AvatarToByte(fil);
            webCam.setImagen(imagen);
        }

    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void webCamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webCamMousePressed
        imagen = webCam.getBytes();
    }//GEN-LAST:event_webCamMousePressed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed

    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped

    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped

    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtHijosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHijosKeyTyped

    }//GEN-LAST:event_txtHijosKeyTyped

    private void cbxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoCivilActionPerformed

    }//GEN-LAST:event_cbxEstadoCivilActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargarCampos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoActionPerformed

    }//GEN-LAST:event_cbxSexoActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped

    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtLegajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyTyped

    }//GEN-LAST:event_txtLegajoKeyTyped

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

    private void cbxLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLocalidadActionPerformed

    }//GEN-LAST:event_cbxLocalidadActionPerformed

    private void txtFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFijoKeyTyped

    }//GEN-LAST:event_txtFijoKeyTyped

    private void ckbHipoacusiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbHipoacusiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbHipoacusiaActionPerformed

    private void rbtnSiFinaOrganismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSiFinaOrganismoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnSiFinaOrganismoActionPerformed

    private void txtTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTorreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTorreActionPerformed

    private void cbxBarrioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBarrioItemStateChanged
        cbxCalle.removeAllItems();
        cargarComboCalle();
    }//GEN-LAST:event_cbxBarrioItemStateChanged

    private void cbxCalleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCalleItemStateChanged

    }//GEN-LAST:event_cbxCalleItemStateChanged

    private void cbxLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLocalidadItemStateChanged
        cbxBarrio.removeAllItems();
        cargarComboBarrio();
    }//GEN-LAST:event_cbxLocalidadItemStateChanged

    private void rbtnDisNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDisNoActionPerformed
        checkBoxDiscapacidad(false);
    }//GEN-LAST:event_rbtnDisNoActionPerformed

    private void rbtnDisSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDisSiActionPerformed
        checkBoxDiscapacidad(true);
    }//GEN-LAST:event_rbtnDisSiActionPerformed

    private void rbtnDisSiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnDisSiMousePressed
        // checkBoxDiscapacidad(true);
    }//GEN-LAST:event_rbtnDisSiMousePressed

    private void ckbDiscapacidadOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbDiscapacidadOtroActionPerformed
        txtDiscapacidadOtro.setEnabled(ckbDiscapacidadOtro.isSelected());
        checkBoxDiscapacidad(!ckbDiscapacidadOtro.isSelected());
        ckbDiscapacidadOtro.setEnabled(true);
    }//GEN-LAST:event_ckbDiscapacidadOtroActionPerformed

    private void rbtnBeneficioEscolarNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnBeneficioEscolarNoActionPerformed

    }//GEN-LAST:event_rbtnBeneficioEscolarNoActionPerformed

    private void rbtnPlanSocialNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPlanSocialNoActionPerformed

    }//GEN-LAST:event_rbtnPlanSocialNoActionPerformed

    private void ckbDesaMerCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbDesaMerCompActionPerformed
        ckbDesayuno.setEnabled(!ckbDesaMerComp.isSelected());
        ckbDesayuno.setSelected(false);
        ckbMerienda.setEnabled(!ckbDesaMerComp.isSelected());
        ckbMerienda.setSelected(false);
    }//GEN-LAST:event_ckbDesaMerCompActionPerformed

    private void ckbCualInterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbCualInterActionPerformed

    }//GEN-LAST:event_ckbCualInterActionPerformed

    private void ckbCualRegimenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbCualRegimenActionPerformed

    }//GEN-LAST:event_ckbCualRegimenActionPerformed

    private void rbtnDisSiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnDisSiItemStateChanged
        checkBoxDiscapacidad(true);
    }//GEN-LAST:event_rbtnDisSiItemStateChanged

    private void rbtnBeneficioEscolarSiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnBeneficioEscolarSiItemStateChanged
        checkBoxServAlimentEscolar(true);
    }//GEN-LAST:event_rbtnBeneficioEscolarSiItemStateChanged

    private void rbtnPlanSocialSiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnPlanSocialSiItemStateChanged
        checkBoxPlanSocial(true);
    }//GEN-LAST:event_rbtnPlanSocialSiItemStateChanged

    private void ckbDesaMerCompItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbDesaMerCompItemStateChanged
        ckbDesayuno.setEnabled(!ckbDesaMerComp.isSelected());
        ckbDesayuno.setSelected(false);
        ckbMerienda.setEnabled(!ckbDesaMerComp.isSelected());
        ckbMerienda.setSelected(false);
    }//GEN-LAST:event_ckbDesaMerCompItemStateChanged

    private void tblPlanSocAlumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlanSocAlumMouseClicked
        if (tblPlanSocAlum.isEnabled() != false) {
            btnQuitar.setEnabled(true);
        }
    }//GEN-LAST:event_tblPlanSocAlumMouseClicked

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPlanSocAlum.getModel();
        int filaSeleccionada = tblPlanSocAlum.getSelectedRow();
        if (tblPlanSocAlum.isEnabled()) {
            tblPlanSocReg.setModel(btnQuitar(filaSeleccionada));
            model.removeRow(filaSeleccionada);
            btnQuitar.setEnabled(false);
            btnAgregar.setEnabled(false);
            ordenarTablaPlanReg();
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPlanSocReg.getModel();
        int filaSeleccionada = tblPlanSocReg.getSelectedRow();

        tblPlanSocAlum.setModel(btnAgregar(filaSeleccionada));
        model.removeRow(filaSeleccionada);
        ordenarTablaplanAlumno();
        btnAgregar.setEnabled(false);
        btnQuitar.setEnabled(false);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblPlanSocRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlanSocRegMouseClicked
        if (tblPlanSocReg.isEnabled()) {
            btnAgregar.setEnabled(true);
        }

    }//GEN-LAST:event_tblPlanSocRegMouseClicked

    private void ckbCualInterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbCualInterItemStateChanged
        txtCualInterCul.setEnabled(ckbCualInter.isSelected());
        cbxCualInterCul.setEnabled(!ckbCualInter.isSelected());
    }//GEN-LAST:event_ckbCualInterItemStateChanged

    private void ckbCualRegimenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbCualRegimenItemStateChanged
        txtRegEspCual.setEnabled(ckbCualRegimen.isSelected());
        cbxRegEspExist.setEnabled(!ckbCualRegimen.isSelected());
    }//GEN-LAST:event_ckbCualRegimenItemStateChanged

    private void rbtnBeneficioEscolarNoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnBeneficioEscolarNoItemStateChanged
        checkBoxServAlimentEscolar(false);
    }//GEN-LAST:event_rbtnBeneficioEscolarNoItemStateChanged

    private void rbtnPlanSocialNoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnPlanSocialNoItemStateChanged
        checkBoxPlanSocial(false);
    }//GEN-LAST:event_rbtnPlanSocialNoItemStateChanged
//------------------------------------------------------------------------------
// Metodos

    private void guardar() {
        crearDomicilio();
        crearPersonal();
        crearAlumno();
        crearPlanSocialAlumno();

        JOptionPane.showMessageDialog(this, "Guardado");
        limpiar();
    }

    private void cargarComboEstado() {
        listaEstado = ctrlEstado.leerTodo();
        for (int i = 0; i < listaEstado.size(); i++) {
            cbxEstado.addItem(listaEstado.get(i).getEstado());
        }
    }

    private void cargarComboEstadoCivil() {
        listaEstadoCivil = ctrlEstadoCivil.leerTodos();
        for (int i = 0; i < listaEstadoCivil.size(); i++) {
            cbxEstadoCivil.addItem(listaEstadoCivil.get(i).getEstadoCivil());
        }
    }

    private void cargarComboLocalidad() {
        listaLocalidad = ctrlLugar.leerTodoLocalidad();
        for (int i = 0; i < listaLocalidad.size(); i++) {
            cbxLocalidad.addItem(listaLocalidad.get(i).getNombre());
        }
    }

    private void cargarComboBarrio() {
        listaBarrio = ctrlLugar.leerTodoBarrio(listaLocalidad.get(cbxLocalidad.getSelectedIndex()).getIdLugar());
        for (int i = 0; i < listaBarrio.size(); i++) {
            cbxBarrio.addItem(listaBarrio.get(i).getNombre());
        }
    }

    private void cargarComboCalle() {
        listaCalle = ctrlLugar.leerTodoCalle(listaBarrio.get(cbxBarrio.getSelectedIndex()).getIdLugar());
        for (int i = 0; i < listaCalle.size(); i++) {
            cbxCalle.addItem(listaCalle.get(i).getNombre());
        }
    }

    private void cargarComboSexo() {
        listaSexo = ctrlSexo.leerTodos();
        for (int i = 0; i < listaSexo.size(); i++) {
            cbxSexo.addItem(listaSexo.get(i).getSexo());
        }
    }

    private void cargarComboComunidad() {
        cbxCualInterCul.removeAllItems();
        listComunidad = ctrlComunidad.leerTodoComunidad();
        for (int i = 0; i < listComunidad.size(); i++) {
            cbxCualInterCul.addItem(listComunidad.get(i).getNombre());
        }
    }

    private void cargarComboRegimen() {
        cbxRegEspExist.removeAllItems();
        listRegimenEspecial = ctrlRegimenEspecial.leerTodoRegimen();
        for (int i = 0; i < listRegimenEspecial.size(); i++) {
            cbxRegEspExist.addItem(listRegimenEspecial.get(i).getNombre());
        }
    }

    private void crearPersonal() {
        personal = new Personal();
        lugar = new Lugar();
        estadoCivil = new EstadoCivil();
        sexo = new Sexo();

        lugar.setIdLugar(listaNacionalidad.get(cbxNacionalidad.getSelectedIndex()).getIdLugar());
        sexo.setIdSexo(listaSexo.get(cbxSexo.getSelectedIndex()).getIdSexo());
        estadoCivil.setIdEstadoCivil(listaEstadoCivil.get(cbxEstadoCivil.getSelectedIndex()).getIdEstadoCivil());
        personal.setApellido(txtApellido.getText());
        personal.setCuil(txtCuil.getText());
        personal.setDomicilio(domicilio);
        personal.setEmail(txtEmail.getText());
        personal.setEstadoCivil(estadoCivil);
        personal.setFechaAlta(fechaAlta.getDate());
        personal.setFechaNacimiento(fechaNacimiento.getDate());
        personal.setFoto(imagen);
        personal.setHijos(Integer.parseInt(txtHijos.getText()));
        personal.setLegajo(txtLegajo.getText());
        personal.setNacionalidad(lugar);
        personal.setNombre(txtNombre.getText());
        personal.setSexo(sexo);
        personal.setTelefonoCelular(txtCelular.getText());
        ctrlPersonal.crearAlumno(personal);
        personal.setIdPersonal(ctrlPersonal.leerUltimoRegCargado());
    }

    private void crearAlumno() {
        alumno = new Alumno();
        pesoTalla = new PesoTalla();
        estado = new Estado();

        alumno.setPersonal(personal);
        alumno.setEstado(listaEstado.get(cbxEstado.getSelectedIndex()));

        if (ckbCualInter.isSelected() && !txtCualInterCul.getText().isEmpty()) {
            comunidad = new Comunidad();
            comunidad.setNombre(txtCualInterCul.getText());

            ctrlComunidad.crear(comunidad);
            comunidad.setIdCargoPersonal(ctrlComunidad.leerUltimoRegCargado());
            alumno.setInterCulturalidad(comunidad);
            //Debo Validar si el usuario se hace el picaro y registra uno ya existente
            //Como idea es tomar el nombre y buscar lo en la lista
        } else {
            alumno.setInterCulturalidad(listComunidad.get(cbxCualInterCul.getSelectedIndex()));

        }

        if (ckbCualRegimen.isSelected() && !txtRegEspCual.getText().isEmpty()) {
            regimenEspecial = new RegimenEspecial();
            regimenEspecial.setNombre(txtRegEspCual.getText());
            ctrlRegimenEspecial.crear(regimenEspecial);
            regimenEspecial.setIdRegimenEspecial(ctrlRegimenEspecial.leerUltimoRegCargado());
            alumno.setRegimenEspecial(regimenEspecial);
            //Debo Validar si el usuario se hace el picaro y registra uno ya existente
            //Como idea es tomar el nombre y buscar lo en la lista
        } else {
            alumno.setRegimenEspecial(listRegimenEspecial.get(cbxRegEspExist.getSelectedIndex()));
        }

        alumno.setLocalidad(listaLocalidad.get(cbxLocalidad.getSelectedIndex()));

        if (rbtnSiFinanEdu.isSelected()) {
            alumno.setTransporte(0);
        } else if (rbtnSiFinaOrganismo.isSelected()) {
            alumno.setTransporte(1);
        } else {
            alumno.setTransporte(2);
        }

        if (rbtnBeneficioEscolarSi.isSelected()) {
            alumno.setServicioAlimentarioEscolar(0);
        } else {
            alumno.setServicioAlimentarioEscolar(1);
        }

        alumno.setDesayunoMeriendaCompleta(ckbDesaMerComp.isSelected());
        alumno.setDesayuno(ckbDesayuno.isSelected());
        alumno.setComedorSimple(ckbComeSimple.isSelected());
        alumno.setAlmuerzo(ckbAlmuerzo.isSelected());
        alumno.setMerienda(ckbMerienda.isSelected());
        alumno.setCena(ckbCena.isSelected());

        if (rbtnSecEstatal.isSelected()) {
            alumno.setDocenteIntegrador(0);
        } else if (rbtnSecPrivado.isSelected()) {
            alumno.setDocenteIntegrador(1);
        } else {
            alumno.setDocenteIntegrador(2);
        }

        if (ckbSinInst.isSelected()) {
            alumno.setNivelTutor(0);
        } else if (ckbPriComp.isSelected()) {
            alumno.setNivelTutor(1);
        } else if (ckbPriIncomp.isSelected()) {
            alumno.setNivelTutor(2);
        } else if (ckbSecuPolComp.isSelected()) {
            alumno.setNivelTutor(3);
        } else if (ckbSecuPolInComp.isSelected()) {
            alumno.setNivelTutor(4);
        } else if (ckbSupComp.isSelected()) {
            alumno.setNivelTutor(5);
        } else if (ckbSupImcomp.isSelected()) {
            alumno.setNivelTutor(6);
        } else {
            alumno.setNivelTutor(7);
        }

        if (rbtnDisSi.isSelected()) {
            alumno.setDiscapacidad(0);
        } else {
            alumno.setDiscapacidad(1);
        }

        alumno.setCeguera(ckbCeguera.isSelected());
        alumno.setSordera(ckbSordera.isSelected());
        alumno.setMotoraPuraIntelectual(ckbMotora.isSelected());
        alumno.setNeuromotora(ckbNeuromotora.isSelected());
        alumno.setTrastornoEspectroAutista(ckbAutista.isSelected());
        alumno.setDisminucionVisual(ckbDisminuciónVisual.isSelected());
        alumno.setHipoacusia(ckbHipoacusia.isSelected());

        if (ckbDiscapacidadOtro.isSelected() && !txtDiscapacidadOtro.getText().isEmpty()) {
            alumno.setOtroDiscapacidad(txtDiscapacidadOtro.getText().toUpperCase());
        }

        ctrlAlumno.crear(alumno);

        alumno.setIdAlumno(ctrlAlumno.leerUltimoRegCargado());
        pesoTalla.setAlumno(alumno);
        pesoTalla.setPeso(Float.valueOf(txtPeso.getText()));
        pesoTalla.setTalla(Float.valueOf(txtTalla.getText()));
        pesoTalla.setFechaCreacion(fechaCarga.getDate());
        pesoTalla.setFechaMedicion(fechaMedicion.getDate());
        ctrlPesoTalla.crear(pesoTalla);
    }

    private void crearDomicilio() {
        domicilio = new Domicilio();
        domicilio.setCalle(listaCalle.get(cbxCalle.getSelectedIndex()));
        domicilio.setCodPostal(txtCodPost.getText());
        domicilio.setNumero(txtNumero.getText());
        domicilio.setTelefonoFijo(txtFijo.getText());
        domicilio.setReferencia(txtRef.getText());
        if (txtTorre.getText().isEmpty() && txtDepto.getText().isEmpty() && txtPiso.getText().isEmpty()) {
            ctrlDomicilio.crear(domicilio, false);
            domicilio.setIdDomicilio(ctrlDomicilio.leerUltimoRegCargado());
        } else {
            ctrlDomicilio.crear(domicilio, true);
            domicilio.setIdDomicilio(ctrlDomicilio.leerUltimoRegCargado());
            crearEdificio();
        }
    }

    private void crearEdificio() {
        edificio = new Edificio();
        edificio.setDomicilio(domicilio);
        edificio.setDpto(txtDepto.getText());
        edificio.setTorre(txtTorre.getText());
        edificio.setPiso(txtPiso.getText());
        edificio.setTelefonoFijo(txtFijo.getText());
        ctrlEdificio.crear(edificio);
    }

    private void crearPlanSocialAlumno() {
        PlanSocialAlumno planSocialAlumno = null;
        for (int i = 0; i < tblPlanSocAlum.getRowCount(); i++) {
            planSocialAlumno = new PlanSocialAlumno();
            planSocialAlumno.setAlumno(alumno);
            planSocialAlumno.setPlanSocial(ctrlPlanSocial.leerID(tblPlanSocAlum.getValueAt(i, 0).toString()));
            ctrlPlanSocialAlumno.crear(planSocialAlumno);
        }
    }

    private void cargarComboNacionalidad() {
        listaNacionalidad = ctrlLugar.leerTodoNacionalidad();
        for (int i = 0; i < listaNacionalidad.size(); i++) {
            cbxNacionalidad.addItem(listaNacionalidad.get(i).getNombre());
        }
    }

    private void checkBoxDiscapacidad(Boolean action) {
        ckbCeguera.setEnabled(action);
        ckbSordera.setEnabled(action);
        ckbMotora.setEnabled(action);
        ckbAutista.setEnabled(action);
        ckbNeuromotora.setEnabled(action);
        ckbHipoacusia.setEnabled(action);
        ckbDisminuciónVisual.setEnabled(action);
        ckbDiscapacidadOtro.setEnabled(action);
    }

    private void checkBoxServAlimentEscolar(Boolean action) {
        ckbDesaMerComp.setEnabled(action);
        ckbDesayuno.setEnabled(action);
        ckbComeSimple.setEnabled(action);
        ckbAlmuerzo.setEnabled(action);
        ckbMerienda.setEnabled(action);
        ckbCena.setEnabled(action);
    }

    private void checkBoxPlanSocial(Boolean action) {
        tblPlanSocAlum.setEnabled(action);
        tblPlanSocReg.setEnabled(action);

//        ckbAsigEmba.setEnabled(action);
//        ckbSieteHijo.setEnabled(action);
//        ckbPension.setEnabled(action);
//        ckbEhacen.setEnabled(action);
//        ckbAsiUniHijo.setEnabled(action);
//        ckbProgre.setEnabled(action);
//        ckbDiscapacidad.setEnabled(action);
    }

    private Boolean validar() {
        txtApellido.setBorder(new JTextField().getBorder());
        txtNombre.setBorder(new JTextField().getBorder());
        txtCuil.setBorder(new JTextField().getBorder());
        txtHijos.setBorder(new JTextField().getBorder());
        txtCelular.setBorder(new JTextField().getBorder());
        txtEmail.setBorder(new JTextField().getBorder());
        txtFijo.setBorder(new JTextField().getBorder());
        txtLegajo.setBorder(new JTextField().getBorder());
        txtDepto.setBorder(new JTextField().getBorder());
        txtPiso.setBorder(new JTextField().getBorder());
        Boolean validar = false;
        Boolean mostrarMsj = false;
        if (txtCuil.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar CUIL");
            txtCuil.setBorder(new LineBorder(Color.RED, 2));
            txtCuil.requestFocus();
            mostrarMsj = true;
        } else if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Apellido");
            txtApellido.setBorder(new LineBorder(Color.RED, 2));
            txtApellido.requestFocus();
            mostrarMsj = true;
        } else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Nombre");
            txtNombre.setBorder(new LineBorder(Color.RED, 2));
            txtNombre.requestFocus();
            mostrarMsj = true;
        } else if (fechaNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Fecha de nacimiento");
            mostrarMsj = true;
        } else if (txtHijos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Cantidad de hijos");
            txtHijos.setBorder(new LineBorder(Color.RED, 2));
            txtHijos.requestFocus();
            mostrarMsj = true;
        } else if (txtCelular.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Telefono Celular");
            txtCelular.setBorder(new LineBorder(Color.RED, 2));
            txtCelular.requestFocus();
            mostrarMsj = true;
        } else if (txtFijo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Telefono Fijo");
            txtFijo.setBorder(new LineBorder(Color.RED, 2));
            txtFijo.requestFocus();
            mostrarMsj = true;
        } else if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar E-MAIL");
            txtEmail.setBorder(new LineBorder(Color.RED, 2));
            txtEmail.requestFocus();
            mostrarMsj = true;
        } else if (fechaAlta.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Fecha de alta");
            mostrarMsj = true;
        } else {
            if (!txtTorre.getText().isEmpty()) {
                if (txtPiso.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar Piso");
                    txtPiso.setBorder(new LineBorder(Color.RED, 2));
                    txtPiso.requestFocus();
                    mostrarMsj = true;
                } else if (txtDepto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar Depto");
                    txtDepto.setBorder(new LineBorder(Color.RED, 2));
                    txtDepto.requestFocus();
                    mostrarMsj = true;
                } else {
                    validar = true;
                }
            } else {
                validar = true;
            }

        }
        return validar;
    }

    private void cargarCampos() {

        alumno = ctrlAlumno.leer(txtCuil.getText());

        if (alumno != null) {
            edificio = ctrlEdificio.leerIdDomicilio(alumno.getPersonal().getDomicilio().getIdDomicilio());
            pesoTalla = ctrlPesoTalla.leerIdAlumno(alumno.getIdAlumno());
            btnGuardar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtApellido.setText(alumno.getPersonal().getApellido());
            txtNombre.setText(alumno.getPersonal().getNombre());
            fechaNacimiento.setDate(alumno.getPersonal().getFechaNacimiento());
            txtHijos.setText(String.valueOf(alumno.getPersonal().getHijos()));

            txtEmail.setText(alumno.getPersonal().getEmail());
            txtCelular.setText(alumno.getPersonal().getTelefonoCelular());
            txtCodPost.setText(alumno.getPersonal().getDomicilio().getCodPostal());
            txtRef.setText(alumno.getPersonal().getDomicilio().getReferencia());
            txtNumero.setText(alumno.getPersonal().getDomicilio().getNumero());
            fechaAlta.setDate(alumno.getPersonal().getFechaAlta());
            txtLegajo.setText(alumno.getPersonal().getLegajo());
            if (alumno.getPersonal().getFoto() != null) {
                webCam.setImagen(alumno.getPersonal().getFoto());
            }

            SeleccionarNacionalidad(alumno.getPersonal().getNacionalidad().getIdLugar());
            SeleccionarSexo(alumno.getPersonal().getSexo().getIdSexo());
            SeleccionarEstadoCivil(alumno.getPersonal().getEstadoCivil().getIdEstadoCivil());
            SeleccionarLocalidad(alumno.getLocalidad().getIdLugar());
            SeleccionarBarrio(alumno.getPersonal().getDomicilio().getCalle().getDe());
            SeleccionarCalle(alumno.getPersonal().getDomicilio().getCalle().getIdLugar());
            SeleccionarEstado(alumno.getEstado().getIdEstado());
            if (edificio != null) {
                txtPiso.setText(edificio.getPiso());
                txtTorre.setText(edificio.getTorre());
                txtDepto.setText(edificio.getDpto());
                txtFijo.setText(edificio.getTelefonoFijo());
            } else {
                txtFijo.setText(alumno.getPersonal().getDomicilio().getTelefonoFijo());
            }
//------------------------------------------------------------------------------
//Panel Datos Medicos
            if (alumno.getDiscapacidad() == 0) {
                rbtnDisSi.setSelected(true);
            } else {
                rbtnDisNo.setSelected(true);
            }

            ckbCeguera.setSelected(alumno.isCeguera());
            ckbSordera.setSelected(alumno.isSordera());
            ckbMotora.setSelected(alumno.isMotoraPuraIntelectual());
            ckbAutista.setSelected(alumno.isTrastornoEspectroAutista());
            ckbNeuromotora.setSelected(alumno.isNeuromotora());
            ckbHipoacusia.setSelected(alumno.isHipoacusia());
            ckbDisminuciónVisual.setSelected(alumno.isDisminucionVisual());
            if (!alumno.getOtroDiscapacidad().isEmpty()) {
                ckbDiscapacidadOtro.setSelected(true);
                txtDiscapacidadOtro.setText(alumno.getOtroDiscapacidad());
            }
            txtPeso.setText(String.valueOf(pesoTalla.getPeso()));
            txtTalla.setText(String.valueOf(pesoTalla.getTalla()));
            fechaMedicion.setDate(pesoTalla.getFechaMedicion());
            fechaCarga.setDate(pesoTalla.getFechaCreacion());
//------------------------------------------------------------------------------
//Datos Socio Economico
            switch (alumno.getTransporte()) {
                case 0:
                    rbtnSiFinanEdu.setSelected(true);
                    break;

                case 1:
                    rbtnSiFinaOrganismo.setSelected(true);
                    break;
                default:
                    rbtnTanspEscolarNo.setSelected(true);
                    break;
            }
            if (alumno.getServicioAlimentarioEscolar() == 0) {
                rbtnBeneficioEscolarSi.setSelected(true);
                ckbDesaMerComp.setSelected(alumno.isDesayunoMeriendaCompleta());
                ckbDesayuno.setSelected(alumno.isDesayuno());
                ckbComeSimple.setSelected(alumno.isComedorSimple());
                ckbAlmuerzo.setSelected(alumno.isAlmuerzo());
                ckbMerienda.setSelected(alumno.isMerienda());
                ckbCena.setSelected(alumno.isCena());

            } else {
                rbtnBeneficioEscolarNo.setSelected(true);
            }
            cargarTablaPlanAlum();
            cargarTablaPlanRegMod();
            if (!listPlanResultante.isEmpty()) {
                rbtnPlanSocialSi.setSelected(true);
            } else {
                rbtnPlanSocialNo.setSelected(true);
            }
//------------------------------------------------------------------------------
//Datos Complemenetarios
            SeleccionarInterCult(alumno.getInterCulturalidad().getIdCargoPersonal());
            SeleccionarRegEsp(alumno.getRegimenEspecial().getIdRegimenEspecial());

            switch (alumno.getNivelTutor()) {
                case 0: {
                    ckbSinInst.setSelected(true);
                    break;
                }
                case 1: {
                    ckbPriComp.setSelected(true);
                    break;
                }
                case 2: {
                    ckbPriIncomp.setSelected(true);
                    break;
                }
                case 3: {
                    ckbSecuPolComp.setSelected(true);
                    break;
                }
                case 4: {
                    ckbSecuPolInComp.setSelected(true);
                    break;
                }
                case 5: {
                    ckbSupComp.setSelected(true);
                    break;
                }
                case 6: {
                    ckbSupImcomp.setSelected(true);
                    break;
                }
                case 7: {
                    ckbNosabe.setSelected(true);
                    break;
                }
            }
//------------------------------------------------------------------------------            
        } else {
            JOptionPane.showMessageDialog(this, "No se econtró Alumno", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SeleccionarInterCult(int Id) {
        for (int i = 0; i < listComunidad.size(); i++) {
            if (Id == listComunidad.get(i).getIdCargoPersonal()) {
                cbxCualInterCul.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarRegEsp(int Id) {
        for (int i = 0; i < listRegimenEspecial.size(); i++) {
            
            if (Id == listRegimenEspecial.get(i).getIdRegimenEspecial()) {
                cbxRegEspExist.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarNacionalidad(int Id) {
        for (int i = 0; i < listaNacionalidad.size(); i++) {
            if (Id == listaNacionalidad.get(i).getIdLugar()) {
                cbxNacionalidad.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarSexo(int Id) {
        for (int i = 0; i < listaSexo.size(); i++) {
            if (Id == listaSexo.get(i).getIdSexo()) {
                cbxSexo.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarEstadoCivil(int Id) {
        for (int i = 0; i < listaEstadoCivil.size(); i++) {

            if (Id == listaEstadoCivil.get(i).getIdEstadoCivil()) {
                cbxEstadoCivil.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarLocalidad(int Id) {
        for (int i = 0; i < listaLocalidad.size(); i++) {
            if (Id == listaLocalidad.get(i).getIdLugar()) {
                cbxLocalidad.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarBarrio(int Id) {
        for (int i = 0; i < listaBarrio.size(); i++) {
            if (Id == listaBarrio.get(i).getIdLugar()) {
                cbxBarrio.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarCalle(int Id) {
        for (int i = 0; i < listaCalle.size(); i++) {
            if (Id == listaCalle.get(i).getIdLugar()) {
                cbxCalle.setSelectedIndex(i);
                break;
            }
        }
    }

    private void SeleccionarEstado(int Id) {
        for (int i = 0; i < listaEstado.size(); i++) {
            if (Id == listaEstado.get(i).getIdEstado()) {
                cbxEstado.setSelectedIndex(i);
                break;
            }
        }
    }

    public byte[] AvatarToByte(String url) {
        byte[] data = null;
        String extension = "";
        try {
            BufferedImage bImage = ImageIO.read(new File(url));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            if (url.toLowerCase().contains(".png")) {
                extension = "png";
            } else {
                extension = "jpg";
            }
            ImageIO.write(bImage, extension, bos);
            data = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void limpiar() {
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtApellido.setText(null);
        txtNombre.setText(null);
        fechaNacimiento.setDate(null);
        txtHijos.setText(null);
        txtCuil.setText(null);

        txtEmail.setText(null);
        txtCelular.setText(null);
        txtCodPost.setText(null);
        txtRef.setText(null);
        txtNumero.setText(null);
        fechaAlta.setDate(new Date());
        txtLegajo.setText(null);
        
        webCam.setImagenNull();

        txtPiso.setText(null);
        txtTorre.setText(null);
        txtDepto.setText(null);
        txtFijo.setText(null);
        txtPeso.setText(null);
        txtTalla.setText(null);
        txtDiscapacidadOtro.setText(null);
        txtCualInterCul.setText(null);
        txtRegEspCual.setText(null);
        fechaMedicion.setDate(null);
        fechaCarga.setDate(null);

        model = (DefaultTableModel) tblPlanSocAlum.getModel();
        model.setRowCount(0);
        tblPlanSocAlum.setModel(model);

        btnAgregar.setEnabled(false);
        btnQuitar.setEnabled(false);

        gprBeneServicio.clearSelection();
        gprDiscapacidad.clearSelection();
        gprDocenteIntegrador.clearSelection();
        gprPlanSocial.clearSelection();
        gprTransporte.clearSelection();
        gprTutor.clearSelection();

        rbtnDisNo.setSelected(true);
        rbtnDocInteNo.setSelected(true);
        rbtnTanspEscolarNo.setSelected(true);
        rbtnBeneficioEscolarNo.setSelected(true);
        rbtnPlanSocialNo.setSelected(true);
        
        
        ckbSinInst.setSelected(true);

        ckbDesaMerComp.setSelected(false);
        ckbDesayuno.setSelected(false);
        ckbComeSimple.setSelected(false);
        ckbAlmuerzo.setSelected(false);
        ckbMerienda.setSelected(false);
        ckbCena.setSelected(false);

        ckbCeguera.setSelected(false);
        ckbSordera.setSelected(false);
        ckbMotora.setSelected(false);
        ckbAutista.setSelected(false);
        ckbNeuromotora.setSelected(false);
        ckbHipoacusia.setSelected(false);
        ckbDisminuciónVisual.setSelected(false);
        ckbDiscapacidadOtro.setSelected(false);

        ckbCualInter.setSelected(false);
        ckbCualRegimen.setSelected(false);

        cbxNacionalidad.setSelectedIndex(0);
        cbxSexo.setSelectedIndex(0);
        cbxEstadoCivil.setSelectedIndex(0);
        cbxLocalidad.setSelectedIndex(0);
        cbxEstado.setSelectedIndex(0);
        

        cargarTablaPlanReg();
        cargarComboRegimen();
        cargarComboComunidad();
        
        cbxCualInterCul.setSelectedItem("No pertenece");
        cbxRegEspExist.setSelectedItem("No pertenece");
    }

    private DefaultTableModel btnQuitar(int filaSelec) {
        DefaultTableModel model = (DefaultTableModel) tblPlanSocReg.getModel();
        Object[] fila = new Object[1];
        fila[0] = tblPlanSocAlum.getValueAt(filaSelec, 0).toString();
        model.addRow(fila);
        return model;
    }

    private DefaultTableModel btnAgregar(int filaSelec) {
        DefaultTableModel model = (DefaultTableModel) tblPlanSocAlum.getModel();
        Object[] fila = new Object[1];
        fila[0] = tblPlanSocReg.getValueAt(filaSelec, 0).toString();
        model.addRow(fila);
        return model;
    }

    private void ordenarTablaplanAlumno() {
        DefaultTableModel modelDis = (DefaultTableModel) tblPlanSocAlum.getModel();
        PlanSocial planComparar = null;
        List<PlanSocial> listServicioAux = new ArrayList();
        for (int i = 0; i < tblPlanSocAlum.getRowCount(); i++) {
            planComparar = new PlanSocial();
            planComparar.setNombre(tblPlanSocAlum.getValueAt(i, 0).toString());
            listServicioAux.add(planComparar);
        }

        Collections.sort(listServicioAux);
        modelDis.setRowCount(0);
        Object[] fila = new Object[1];
        for (int i = 0; i < listServicioAux.size(); i++) {
            fila[0] = listServicioAux.get(i).getNombre();
            modelDis.addRow(fila);
        }
        tblPlanSocAlum.setModel(modelDis);
    }

    private void ordenarTablaPlanReg() {
        DefaultTableModel model = (DefaultTableModel) tblPlanSocReg.getModel();
        PlanSocial planComparar = null;
        List<PlanSocial> listPlanSocialAux = new ArrayList();
        for (int i = 0; i < tblPlanSocReg.getRowCount(); i++) {
            planComparar = new PlanSocial();
            planComparar.setNombre(tblPlanSocReg.getValueAt(i, 0).toString());
            listPlanSocialAux.add(planComparar);
        }

        Collections.sort(listPlanSocialAux);
        model.setRowCount(0);
        Object[] fila = new Object[1];
        for (int i = 0; i < listPlanSocialAux.size(); i++) {
            fila[0] = listPlanSocialAux.get(i).getNombre();
            model.addRow(fila);
        }
        tblPlanSocReg.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxBarrio;
    private javax.swing.JComboBox<String> cbxCalle;
    private javax.swing.JComboBox<String> cbxCualInterCul;
    public static javax.swing.JComboBox<String> cbxEstado;
    public static javax.swing.JComboBox<String> cbxEstadoCivil;
    public static javax.swing.JComboBox<String> cbxLocalidad;
    private javax.swing.JComboBox<String> cbxNacionalidad;
    private javax.swing.JComboBox<String> cbxRegEspExist;
    public static javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JCheckBox ckbAlmuerzo;
    private javax.swing.JCheckBox ckbAutista;
    private javax.swing.JCheckBox ckbCeguera;
    private javax.swing.JCheckBox ckbCena;
    private javax.swing.JCheckBox ckbComeSimple;
    private javax.swing.JCheckBox ckbCualInter;
    private javax.swing.JCheckBox ckbCualRegimen;
    private javax.swing.JCheckBox ckbDesaMerComp;
    private javax.swing.JCheckBox ckbDesayuno;
    private javax.swing.JCheckBox ckbDiscapacidadOtro;
    private javax.swing.JCheckBox ckbDisminuciónVisual;
    private javax.swing.JCheckBox ckbHipoacusia;
    private javax.swing.JCheckBox ckbMerienda;
    private javax.swing.JCheckBox ckbMotora;
    private javax.swing.JCheckBox ckbNeuromotora;
    private javax.swing.JRadioButton ckbNosabe;
    private javax.swing.JRadioButton ckbPriComp;
    private javax.swing.JRadioButton ckbPriIncomp;
    private javax.swing.JRadioButton ckbSecuPolComp;
    private javax.swing.JRadioButton ckbSecuPolInComp;
    private javax.swing.JRadioButton ckbSinInst;
    private javax.swing.JCheckBox ckbSordera;
    private javax.swing.JRadioButton ckbSupComp;
    private javax.swing.JRadioButton ckbSupImcomp;
    private com.toedter.calendar.JDateChooser fechaAlta;
    private com.toedter.calendar.JDateChooser fechaCarga;
    private com.toedter.calendar.JDateChooser fechaMedicion;
    private com.toedter.calendar.JDateChooser fechaNacimiento;
    private javax.swing.ButtonGroup gprBeneServicio;
    private javax.swing.ButtonGroup gprDiscapacidad;
    private javax.swing.ButtonGroup gprDocenteIntegrador;
    private javax.swing.ButtonGroup gprPlanSocial;
    private javax.swing.ButtonGroup gprTransporte;
    private javax.swing.ButtonGroup gprTutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBarrio;
    private javax.swing.JLabel lblBeneficioEscolar;
    private javax.swing.JLabel lblBeneficioEscolarCual;
    private javax.swing.JLabel lblBeneficioEscolarCual1;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCm;
    private javax.swing.JLabel lblCualInterCul;
    private javax.swing.JLabel lblDiscapacidad;
    private javax.swing.JLabel lblDoceInter;
    private javax.swing.JLabel lblFechaCarga;
    private javax.swing.JLabel lblFechaMedicion;
    private javax.swing.JLabel lblKg;
    private javax.swing.JLabel lblNacionalidad;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPlanSocAlum;
    private javax.swing.JLabel lblPlanSocReg;
    private javax.swing.JLabel lblPlanSocial;
    private javax.swing.JLabel lblPlanSocialCual;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JLabel lblTanspEscolar;
    private javax.swing.JLabel lblTorre;
    private javax.swing.JLabel lblWebCam;
    private javax.swing.JRadioButton rbtnBeneficioEscolarNo;
    private javax.swing.JRadioButton rbtnBeneficioEscolarSi;
    private javax.swing.JRadioButton rbtnDisNo;
    private javax.swing.JRadioButton rbtnDisSi;
    private javax.swing.JRadioButton rbtnDocInteNo;
    private javax.swing.JRadioButton rbtnPlanSocialNo;
    private javax.swing.JRadioButton rbtnPlanSocialSi;
    private javax.swing.JRadioButton rbtnSecEstatal;
    private javax.swing.JRadioButton rbtnSecPrivado;
    private javax.swing.JRadioButton rbtnSiFinaOrganismo;
    private javax.swing.JRadioButton rbtnSiFinanEdu;
    private javax.swing.JRadioButton rbtnTanspEscolarNo;
    private javax.swing.JTable tblPlanSocAlum;
    private javax.swing.JTable tblPlanSocReg;
    private javax.swing.JTabbedPane tpnDatPersonales;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodPost;
    private javax.swing.JTextField txtCualInterCul;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtDiscapacidadOtro;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFijo;
    private javax.swing.JTextField txtHijos;
    private javax.swing.JTextField txtLegajo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtRegEspCual;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtTorre;
    private JPanelWebCam.JPanelWebCam webCam;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaPlanReg() {
        model = (DefaultTableModel) tblPlanSocReg.getModel();
        model.setRowCount(0);
        Object[] fila = new Object[1];
        listPlan = ctrlPlanSocial.leerTodos();

        for (int i = 0; i < listPlan.size(); i++) {
            fila[0] = listPlan.get(i).getNombre();
            model.addRow(fila);
        }
        tblPlanSocReg.setModel(model);
    }

    private void cargarTablaPlanRegMod() {
        model = (DefaultTableModel) tblPlanSocReg.getModel();
        model.setRowCount(0);
        Object[] fila = new Object[1];

        for (int i = 0; i < listPlanResultante.size(); i++) {
            remover(listPlanResultante.get(i).getIdPlanSocial());
        }

        Collections.sort(listPlan);

        for (int i = 0; i < listPlan.size(); i++) {
            fila[0] = listPlan.get(i).getNombre();
            model.addRow(fila);
        }

        tblPlanSocReg.setModel(model);
    }

    private void remover(int id) {
        for (int i = 0; i < listPlan.size(); i++) {
            if (id == listPlan.get(i).getIdPlanSocial()) {
                listPlan.remove(i);
                break;
            }
        }
    }

    private void cargarTablaPlanAlum() {
        DefaultTableModel model = (DefaultTableModel) tblPlanSocAlum.getModel();
        model.setRowCount(0);
        Object[] fila = new Object[1];
        listPlanResultante = ctrlPlanSocial.leerPlanAlumno(alumno.getIdAlumno());
        for (int i = 0; i < listPlanResultante.size(); i++) {
            fila[0] = listPlanResultante.get(i).getNombre();
            model.addRow(fila);
        }
        tblPlanSocAlum.setModel(model);
    }

    private void modificarPersonal() {
        personal = new Personal();
        domicilio = alumno.getPersonal().getDomicilio();
        lugar = new Lugar();
        estadoCivil = new EstadoCivil();
        sexo = new Sexo();
        personal.setIdPersonal(alumno.getPersonal().getIdPersonal());
        lugar.setIdLugar(listaNacionalidad.get(cbxNacionalidad.getSelectedIndex()).getIdLugar());
        sexo.setIdSexo(listaSexo.get(cbxSexo.getSelectedIndex()).getIdSexo());
        estadoCivil.setIdEstadoCivil(listaEstadoCivil.get(cbxEstadoCivil.getSelectedIndex()).getIdEstadoCivil());
        personal.setApellido(txtApellido.getText());
        personal.setCuil(txtCuil.getText());

        personal.setDomicilio(domicilio);
        personal.setEmail(txtEmail.getText());
        personal.setEstadoCivil(estadoCivil);
        personal.setFechaAlta(fechaAlta.getDate());
        personal.setFechaNacimiento(fechaNacimiento.getDate());
        personal.setFoto(imagen);
        personal.setHijos(Integer.parseInt(txtHijos.getText()));
        personal.setLegajo(txtLegajo.getText());
        personal.setNacionalidad(lugar);
        personal.setNombre(txtNombre.getText());
        personal.setSexo(sexo);
        personal.setTelefonoCelular(txtCelular.getText());
        ctrlPersonal.modificarAlumno(personal);
        // personal.setIdPersonal(ctrlPersonal.leerUltimoRegCargado());
    }

    private void modificarAlumno() {
//        alumno = new Alumno();
//        pesoTalla = new PesoTalla();

        alumno.setPersonal(personal);
        alumno.setEstado(listaEstado.get(cbxEstado.getSelectedIndex()));

        if (ckbCualInter.isSelected() && !txtCualInterCul.getText().isEmpty()) {

            if (ctrlComunidad.existe(txtCualInterCul.getText())>0) {

                comunidad = ctrlComunidad.leerId(txtCualInterCul.getText());
            } else {
                comunidad = new Comunidad();
                comunidad.setNombre(txtCualInterCul.getText());
                ctrlComunidad.crear(comunidad);
                comunidad.setIdCargoPersonal(ctrlComunidad.leerUltimoRegCargado());
            }

            alumno.setInterCulturalidad(comunidad);
            //Debo Validar si el usuario se hace el picaro y registra uno ya existente
            //Como idea es tomar el nombre y buscar lo en la lista
        } else {
            alumno.setInterCulturalidad(listComunidad.get(cbxCualInterCul.getSelectedIndex()));

        }
//------------------------------------------------------------------------------

        if (ckbCualRegimen.isSelected() && !txtRegEspCual.getText().isEmpty()) {

            if (ctrlRegimenEspecial.existe(txtRegEspCual.getText())>0) {
                regimenEspecial = ctrlRegimenEspecial.leerId(txtRegEspCual.getText());
            } else {
                
                regimenEspecial = new RegimenEspecial();
                regimenEspecial.setNombre(txtRegEspCual.getText());
                ctrlRegimenEspecial.crear(regimenEspecial);
                regimenEspecial.setIdRegimenEspecial(ctrlRegimenEspecial.leerUltimoRegCargado());

            }
            alumno.setRegimenEspecial(regimenEspecial);
            //Debo Validar si el usuario se hace el picaro y registra uno ya existente
            //Como idea es tomar el nombre y buscar lo en la lista
        } else {
            alumno.setRegimenEspecial(listRegimenEspecial.get(cbxRegEspExist.getSelectedIndex()));
        }

        alumno.setLocalidad(listaLocalidad.get(cbxLocalidad.getSelectedIndex()));

        if (rbtnSiFinanEdu.isSelected()) {
            alumno.setTransporte(0);
        } else if (rbtnSiFinaOrganismo.isSelected()) {
            alumno.setTransporte(1);
        } else {
            alumno.setTransporte(2);
        }

        if (rbtnBeneficioEscolarSi.isSelected()) {
            alumno.setServicioAlimentarioEscolar(0);
        } else {
            alumno.setServicioAlimentarioEscolar(1);
        }

        alumno.setDesayunoMeriendaCompleta(ckbDesaMerComp.isSelected());
        alumno.setDesayuno(ckbDesayuno.isSelected());
        alumno.setComedorSimple(ckbComeSimple.isSelected());
        alumno.setAlmuerzo(ckbAlmuerzo.isSelected());
        alumno.setMerienda(ckbMerienda.isSelected());
        alumno.setCena(ckbCena.isSelected());

        if (rbtnSecEstatal.isSelected()) {
            alumno.setDocenteIntegrador(0);
        } else if (rbtnSecPrivado.isSelected()) {
            alumno.setDocenteIntegrador(1);
        } else {
            alumno.setDocenteIntegrador(2);
        }

        if (ckbSinInst.isSelected()) {
            alumno.setNivelTutor(0);
        } else if (ckbPriComp.isSelected()) {
            alumno.setNivelTutor(1);
        } else if (ckbPriIncomp.isSelected()) {
            alumno.setNivelTutor(2);
        } else if (ckbSecuPolComp.isSelected()) {
            alumno.setNivelTutor(3);
        } else if (ckbSecuPolInComp.isSelected()) {
            alumno.setNivelTutor(4);
        } else if (ckbSupComp.isSelected()) {
            alumno.setNivelTutor(5);
        } else if (ckbSupImcomp.isSelected()) {
            alumno.setNivelTutor(6);
        } else {
            alumno.setNivelTutor(7);
        }

        if (rbtnDisSi.isSelected()) {
            alumno.setDiscapacidad(0);
        } else {
            alumno.setDiscapacidad(1);
        }

        alumno.setCeguera(ckbCeguera.isSelected());
        alumno.setSordera(ckbSordera.isSelected());
        alumno.setMotoraPuraIntelectual(ckbMotora.isSelected());
        alumno.setNeuromotora(ckbNeuromotora.isSelected());
        alumno.setTrastornoEspectroAutista(ckbAutista.isSelected());
        alumno.setDisminucionVisual(ckbDisminuciónVisual.isSelected());
        alumno.setHipoacusia(ckbHipoacusia.isSelected());

        if (ckbDiscapacidadOtro.isSelected() && !txtDiscapacidadOtro.getText().isEmpty()) {
            alumno.setOtroDiscapacidad(txtDiscapacidadOtro.getText().toUpperCase());
        }

        ctrlAlumno.modificar(alumno);

        //alumno.setIdAlumno(ctrlAlumno.leerUltimoRegCargado());
        pesoTalla.setAlumno(alumno);
        pesoTalla.setPeso(Float.valueOf(txtPeso.getText()));
        pesoTalla.setTalla(Float.valueOf(txtTalla.getText()));
        pesoTalla.setFechaCreacion(fechaCarga.getDate());
        pesoTalla.setFechaMedicion(fechaMedicion.getDate());
        ctrlPesoTalla.modificar(pesoTalla);
    }

    private void modificarDomicilio() {
        domicilio = new Domicilio();

        if (ctrlDomicilio.existeDomicilio(listaCalle.get(cbxCalle.getSelectedIndex()).getIdLugar(), txtNumero.getText())) {
            domicilio.setIdDomicilio(alumno.getPersonal().getDomicilio().getIdDomicilio());
            domicilio.setCodPostal(txtCodPost.getText());
            domicilio.setNumero(txtNumero.getText());
            domicilio.setTelefonoFijo(txtFijo.getText());
            domicilio.setReferencia(txtRef.getText());
            if (txtTorre.getText().isEmpty() && txtDepto.getText().isEmpty() && txtPiso.getText().isEmpty()) {
                ctrlDomicilio.modificar(domicilio, false);
            } else {
                ctrlDomicilio.modificar(domicilio, true);
            }
        } else {
            domicilio.setCalle(listaCalle.get(cbxCalle.getSelectedIndex()));
            domicilio.setCodPostal(txtCodPost.getText());
            domicilio.setNumero(txtNumero.getText());
            domicilio.setTelefonoFijo(txtFijo.getText());
            domicilio.setReferencia(txtRef.getText());
            if (txtTorre.getText().isEmpty() && txtDepto.getText().isEmpty() && txtPiso.getText().isEmpty()) {
                ctrlDomicilio.crear(domicilio, true);
                domicilio.setIdDomicilio(ctrlDomicilio.leerUltimoRegCargado());
            } else {
                ctrlDomicilio.crear(domicilio, false);
                domicilio.setIdDomicilio(ctrlDomicilio.leerUltimoRegCargado());
                crearEdificio();
            }
        }
    }

    private void modificarEdificio() {
        edificio = new Edificio();
        //edificio.setIdEdificio(HIDE_ON_CLOSE);
        domicilio = new Domicilio();
        domicilio = alumno.getPersonal().getDomicilio();
        edificio.setDomicilio(domicilio);
        edificio.setDpto(txtDepto.getText());
        edificio.setTorre(txtTorre.getText());
        edificio.setPiso(txtPiso.getText());
        edificio.setTelefonoFijo(txtFijo.getText());
        ctrlEdificio.modificar(edificio);
    }

    private void modificarPlanSocialAlumno() {
        PlanSocialAlumno planSocialAlumno = null;
        for (int i = 0; i < tblPlanSocAlum.getRowCount(); i++) {
            if (ctrlPlanSocialAlumno.existePlanAlum(tblPlanSocAlum.getValueAt(i, 0).toString(), alumno.getIdAlumno()) == false) {
                planSocialAlumno = new PlanSocialAlumno();
                planSocialAlumno.setAlumno(alumno);
                planSocialAlumno.setPlanSocial(ctrlPlanSocial.leerID(tblPlanSocAlum.getValueAt(i, 0).toString()));
                ctrlPlanSocialAlumno.crear(planSocialAlumno);
            }
        }
        for (int i = 0; i < tblPlanSocReg.getRowCount(); i++) {
            if (ctrlPlanSocialAlumno.existePlanAlum(tblPlanSocReg.getValueAt(i, 0).toString(), alumno.getIdAlumno())) {

                planSocialAlumno = new PlanSocialAlumno();
                planSocialAlumno.setAlumno(alumno);
                planSocialAlumno.setPlanSocial(ctrlPlanSocial.leerID(tblPlanSocReg.getValueAt(i, 0).toString()));

                ctrlPlanSocialAlumno.eliminar(planSocialAlumno);
            }
        }
    }
}
