/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlCargo;
import controlador.CtrlCargoPersonal;
import controlador.CtrlDomicilio;
import controlador.CtrlEdificio;
import controlador.CtrlEstadoCivil;
import controlador.CtrlLugar;
import java.awt.Color;
import javax.swing.border.LineBorder;
import controlador.CtrlPersonal;
import controlador.CtrlRevista;
import controlador.CtrlSexo;
import controlador.CtrlTitulo;
import controlador.CtrlTituloPersonal;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Cargo;
import modelo.CargoPersonal;
import modelo.Domicilio;
import modelo.Edificio;
import modelo.EstadoCivil;
import modelo.Lugar;
import modelo.Personal;
import modelo.Revista;
import modelo.Sexo;
import modelo.Titulo;
import modelo.TituloPersonal;

/**
 *
 * @author Leonel
 */
public class PersonalRegistroDePersonal extends javax.swing.JInternalFrame {
    CtrlPersonal ctrlPersonal = new CtrlPersonal();
    static CtrlSexo ctrlSexo = new CtrlSexo();
    static CtrlEstadoCivil ctrlEstadoCivil = new CtrlEstadoCivil();
    static CtrlTitulo ctrlTitulo = new CtrlTitulo();
    CtrlLugar ctrlLugar = new CtrlLugar();
    CtrlTituloPersonal ctrlTituloPersonal = new CtrlTituloPersonal();
    CtrlCargoPersonal ctrlCargoPersonal = new CtrlCargoPersonal();
    CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
    CtrlEdificio ctrlEdificio = new CtrlEdificio();
    static CtrlRevista ctrlRevista = new CtrlRevista();
    static CtrlCargo ctrlCargo = new CtrlCargo();
    Personal personal = new Personal();
    CargoPersonal cargoPersonal = new CargoPersonal();
    TituloPersonal tituloPersonal = new TituloPersonal();
    Titulo titulo = new Titulo();
    Lugar lugar = new Lugar();
    Domicilio domicilio = new Domicilio();
    Edificio edificio = new Edificio();
    static List<Sexo> listaSexos = new ArrayList();
    static List<EstadoCivil> listaEstadosCiviles = new ArrayList();
    static List<Titulo> listaTitulos = new ArrayList();
    static List<Cargo> listaCargos = new ArrayList();
    static List<Revista> listaRevistas = new ArrayList();
    List<CargoPersonal> listaCargosPersonales = new ArrayList();
    List<TituloPersonal> listaTitulosPersonales = new ArrayList();
    DefaultTableModel modeloTabla = new DefaultTableModel(),modeloTabla2 = new DefaultTableModel();
    Boolean cambiarFoto = false;
    File portada;
    byte[] imagen;
    Boolean noFoto = false;
    static List<String> lista;
    /**
     * Creates new form Personales
     */
    public PersonalRegistroDePersonal() {
        initComponents();
        cargarCombos();
        modeloTabla = (DefaultTableModel) tblCargos.getModel();
        modeloTabla2 = (DefaultTableModel) tblTitulos.getModel();
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar2.setEnabled(false);
        btnQuitar.setEnabled(false);
        btnQuitar2.setEnabled(false);
        lblWebCam.setVisible(true);
        deshabilitarTodo();
        lista = ctrlLugar.leerTodos(4);
        cargarCombo(cbxDepartamento, lista);
    }

    public static void cargarCombos()
    {
        cargarCbxSexo();
        cargarCbxEstadoCivil();
        cargarCbxTitulo();
        cargarCbxCargo();
        cargarCbxRevista();
    }
    
    private static void limpiarCombo(JComboBox cbx)
    {
        cbx.removeAllItems();
        cbx.addItem("SELECCIONAR");
    }
    
    public static void cargarCombo(JComboBox cbx, List<String> lst)
    {
        cbx.removeAllItems();
        cbx.addItem("SELECCIONAR");
        if(lst != null)
        {
            for(int i=0; i<lst.size(); i++)
            {
                cbx.addItem(lst.get(i));
            }
        }
    }
    
    public void cargarTablaCargos()
    {
        String[] fila = new String[4];
        modeloTabla.setRowCount(0);
        listaCargosPersonales = ctrlCargoPersonal.leerCargos(txtCuil.getText());
        
        for(int i=0; i< listaCargosPersonales.size(); i++){
            fila[0] = listaCargosPersonales.get(i).getCargo().getCargo();
            fila[1] = listaCargosPersonales.get(i).getRevista().getRevista();
            fila[2] = String.valueOf(listaCargosPersonales.get(i).getDesde());
            if(listaCargosPersonales.get(i).getHasta()==null)
            {
                fila[3] = "-";
            }else{
                fila[3] = String.valueOf(listaCargosPersonales.get(i).getHasta());
            }
            modeloTabla.addRow(fila);
        }
        tblCargos.setModel(modeloTabla);
        listaCargosPersonales = new ArrayList();
    }
    
    public void cargarTablaTitulos()
    {
        String[] fila = new String[2];
        modeloTabla2.setRowCount(0);
        listaTitulosPersonales = ctrlTituloPersonal.leerTitulos(txtCuil.getText());
        
        for(int i=0; i< listaTitulosPersonales.size(); i++){
            fila[0] = listaTitulosPersonales.get(i).getTitulo().getTitulo();
            fila[1] = listaTitulosPersonales.get(i).getTitulo().getNivel().getNivel();
            modeloTabla2.addRow(fila);
        }
        tblTitulos.setModel(modeloTabla2);
        listaTitulosPersonales = new ArrayList();
    }
    
    public static void cargarCbxCargo()
    {
        listaCargos = ctrlCargo.leerTodos();
        cbxCargo.removeAllItems();
        cbxCargo.addItem("SELECCIONAR");
        for(int i=0; i< listaCargos.size(); i++){
            cbxCargo.addItem(listaCargos.get(i).getCargo());
        }
        cbxCargo.addItem("OTRO");
    }
    
    public static void cargarCbxRevista()
    {
        listaRevistas = ctrlRevista.leerTodos();
        cbxRevista.removeAllItems();
        cbxRevista.addItem("SELECCIONAR");
        for(int i=0; i< listaRevistas.size(); i++){
            cbxRevista.addItem(listaRevistas.get(i).getRevista());
        }
        cbxRevista.addItem("OTRA");
    }
    
    public static void cargarCbxTitulo()
    {
        listaTitulos = ctrlTitulo.leerTodos();
        cbxTitulo.removeAllItems();
        cbxTitulo.addItem("SELECCIONAR");
        for(int i=0; i< listaTitulos.size(); i++){
            cbxTitulo.addItem(listaTitulos.get(i).getTitulo());
        }
        cbxTitulo.addItem("OTRO");
    }
    
    public static void cargarCbxSexo()
    {
        listaSexos = ctrlSexo.leerTodos();
        cbxSexo.removeAllItems();
        cbxSexo.addItem("SELECCIONAR");
        for(int i=0; i< listaSexos.size(); i++){
            cbxSexo.addItem(listaSexos.get(i).getSexo());
        }
        cbxSexo.addItem("OTRO");
    }
    
    public static void cargarCbxEstadoCivil()
    {
        listaEstadosCiviles = ctrlEstadoCivil.leerTodos();
        cbxEstadoCivil.removeAllItems();
        cbxEstadoCivil.addItem("SELECCIONAR");
        for(int i=0; i< listaEstadosCiviles.size(); i++){
            cbxEstadoCivil.addItem(listaEstadosCiviles.get(i).getEstadoCivil());
        }
        cbxEstadoCivil.addItem("OTRO");
    }
    
    public Boolean validar()
    {
        txtApellido.setBorder(new JTextField().getBorder());
        txtCuil.setBorder(new JTextField().getBorder());
        txtNombre.setBorder(new JTextField().getBorder());
        txtHijos.setBorder(new JTextField().getBorder());
        txtCelular.setBorder(new JTextField().getBorder());
        txtEmail.setBorder(new JTextField().getBorder());

        txtFijo.setBorder(new JTextField().getBorder());
        txtLegajo.setBorder(new JTextField().getBorder());
        Boolean validar = false;
        Boolean mostrarMsj = false;
        if(txtCuil.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar CUIL");
            txtCuil.setBorder(new LineBorder(Color.RED, 2));
            txtCuil.requestFocus();
            mostrarMsj = true;
        }else
            if(txtApellido.getText().equals("") && mostrarMsj == false)
            {
                JOptionPane.showMessageDialog(null, "Debe ingresar Apellido");
                txtApellido.setBorder(new LineBorder(Color.RED, 2));
                txtApellido.requestFocus();
                mostrarMsj = true;
            }else
                if(txtNombre.getText().equals("")  && mostrarMsj == false)
                {
                    JOptionPane.showMessageDialog(null, "Debe ingresar Nombre");
                    txtNombre.setBorder(new LineBorder(Color.RED, 2));
                    txtNombre.requestFocus();
                    mostrarMsj = true;
                }else
                    if(fechaNacimiento.getDate() == null && mostrarMsj == false)
                    {
                        JOptionPane.showMessageDialog(null, "Debe ingresar Fecha de Nacimiento");
                        fechaNacimiento.requestFocusInWindow();
                        mostrarMsj = true;
                    }else
                        if(txtHijos.getText().equals("") && mostrarMsj == false)
                        {
                            JOptionPane.showMessageDialog(null, "Debe ingresar Cantidad de Hijos");
                            txtHijos.setBorder(new LineBorder(Color.RED, 2));
                            txtHijos.requestFocus();
                            mostrarMsj = true;
                        }else
                            if(txtCelular.getText().equals("") && mostrarMsj == false)
                            {
                                JOptionPane.showMessageDialog(null, "Debe ingresar Telefono Celular");
                                txtCelular.setBorder(new LineBorder(Color.RED, 2));
                                txtCelular.requestFocus();
                                mostrarMsj = true;
                            }else
                                if(txtEmail.getText().equals("") && mostrarMsj == false)
                                {
                                    JOptionPane.showMessageDialog(null, "Debe ingresar Email");
                                    txtEmail.setBorder(new LineBorder(Color.RED, 2));
                                    txtEmail.requestFocus();
                                    mostrarMsj = true;
                                }else
                                    
                                        if(txtFijo.getText().equals("") && mostrarMsj == false)
                                        {
                                            JOptionPane.showMessageDialog(null, "Debe ingresar Telefono Fijo");
                                            txtFijo.setBorder(new LineBorder(Color.RED, 2));
                                            txtFijo.requestFocus();
                                            mostrarMsj = true;
                                        }else
                                            if(txtLegajo.getText().equals("") && mostrarMsj == false)
                                            {
                                                JOptionPane.showMessageDialog(null, "Debe ingresar Legajo");
                                                txtLegajo.setBorder(new LineBorder(Color.RED, 2));
                                                txtLegajo.requestFocus();
                                                mostrarMsj = true;
                                            }
                                            else
                                                if(fechaAlta.getDate() == null && mostrarMsj == false)
                                                {
                                                    JOptionPane.showMessageDialog(null, "Debe ingresar Fecha de Alta");
                                                    fechaAlta.requestFocusInWindow();
                                                    mostrarMsj = true;
                                                }else
                                                    if(tblTitulos.getRowCount() == 0 && mostrarMsj == false)
                                                    {
                                                        JOptionPane.showMessageDialog(null, "Debe ingresar Titulo/s");
                                                        cbxTitulo.requestFocus();
                                                        mostrarMsj = true;
                                                    }else
                                                        if(tblCargos.getRowCount() == 0 && mostrarMsj == false)
                                                        {
                                                            JOptionPane.showMessageDialog(null, "Debe ingresar Cargo/s");
                                                            cbxCargo.requestFocus();
                                                            mostrarMsj = true;
                                                        }else{
                                                            validar = true;
                                                        }
        return validar;
    }
    
    public void crearPersonal()
    {
        if(validar() == true)
        {
            personal = new Personal();
            personal.setCuil(txtCuil.getText());
            personal.setApellido(txtApellido.getText().toUpperCase());
            personal.setNombre(txtNombre.getText().toUpperCase());
            personal.setFechaNacimiento(fechaNacimiento.getDate());
            personal.setSexo(ctrlSexo.leerSexo(cbxSexo.getSelectedItem().toString()));
            personal.setEstadoCivil(ctrlEstadoCivil.leerEstadoCivil(cbxEstadoCivil.getSelectedItem().toString()));
            personal.setHijos(Integer.valueOf(txtHijos.getText()));
            personal.setTelefonoCelular(txtCelular.getText());
            personal.setEmail(txtEmail.getText().toUpperCase());
            
            domicilio.setCalle(lugar);
            domicilio.setNumero(txtNro.getText());
            domicilio.setReferencia(txtReferencia.getText());
            domicilio.setCodPostal(txtCodigoPostal.getText());
            
            if(!txtTorre.getText().equals("") && !txtPiso.getText().equals("") && !txtDepto.getText().equals(""))
            {
                ctrlDomicilio.crearDomicilio(domicilio);
                domicilio = ctrlDomicilio.leerUltimo();
                edificio.setDomicilio(domicilio);
                edificio.setTelefonoFijo(txtFijo.getText());
                edificio.setTorre(txtTorre.getText());
                edificio.setPiso(txtPiso.getText());
                edificio.setDpto(txtDepto.getText());
                ctrlEdificio.crearEdificio(edificio);
            }else{
                domicilio.setTelefonoFijo(txtFijo.getText());
                ctrlDomicilio.crearDomicilio(domicilio);
                domicilio = ctrlDomicilio.leerUltimo();
            }
            personal.setDomicilio(domicilio);
            
            personal.setLegajo(txtLegajo.getText().toUpperCase());
            personal.setFechaAlta(fechaAlta.getDate());
            if(noFoto == false)
                imagen = webCam.getBytes();
            personal.setFoto(imagen);
            cargarListaCargosPersonales(listaCargosPersonales);
            cargarListaTitulosPersonales(listaTitulosPersonales);
            personal.setListaCargosPersonales(listaCargosPersonales);
            personal.setListaTitulosPersonales(listaTitulosPersonales);
            ctrlPersonal.crearPersonal(personal);
            limpiar();
        }
    }
    
    public Boolean validarCargo()
    {
        Boolean validar = false;
        Boolean mostrarMsj = false;
        if(fechaDesde.getDate() == null && mostrarMsj == false)
            {
                fechaDesde.requestFocusInWindow();
                mostrarMsj = true;
            }else
                if(fechaHasta.getDate() == null && mostrarMsj == false)
                {
                    fechaHasta.requestFocusInWindow();
                    mostrarMsj = true;
                }else{
                    validar = true;
                }
        return validar;
    }
    
    public void cargarTablaCARGOS()
    {
        String[] fila = new String[4];
        if(validarCargo() == true)
        {
            java.sql.Date fecha = new java.sql.Date(fechaDesde.getDate().getTime());
            java.sql.Date fecha2 = new java.sql.Date(fechaHasta.getDate().getTime());
            fila[0] = cbxCargo.getSelectedItem().toString();
            fila[1] = cbxRevista.getSelectedItem().toString(); 
            fila[2] = fecha.toString();
            fila[3] = fecha2.toString();
            
            modeloTabla.addRow(fila);
            tblCargos.setModel(modeloTabla);
            tblCargos.getColumnModel().getColumn(0).setPreferredWidth(200); 
            tblCargos.getColumnModel().getColumn(1).setPreferredWidth(120);
            
            cbxCargo.setSelectedIndex(0);
            cbxRevista.setSelectedIndex(0);
            fechaDesde.setDate(null);
            fechaHasta.setDate(null);
            cbxCargo.requestFocus();
        }
    }
    
    public void cargarListaCargosPersonales(List listaCargosPersonales)
    {   
        for(int i = 0; i < tblCargos.getRowCount(); i++)
        {
            cargoPersonal = new CargoPersonal();
            cargoPersonal.setCargo(ctrlCargo.leerCargo(tblCargos.getValueAt(i, 0).toString()));
            cargoPersonal.setRevista(ctrlRevista.leerRevista(tblCargos.getValueAt(i, 1).toString()));
            Date date1,date2;  
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tblCargos.getValueAt(i, 2).toString());
                cargoPersonal.setDesde(date1);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(tblCargos.getValueAt(i, 3).toString());
                cargoPersonal.setHasta(date2);
            } catch (ParseException ex) {
                Logger.getLogger(PersonalRegistroDePersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaCargosPersonales.add(cargoPersonal);
        }
    }
    
    public void cargarTablaTITULOS()
    {
        String[] fila = new String[2];
        fila[0] = cbxTitulo.getSelectedItem().toString();
        fila[1] = txtNivel.getText();
        modeloTabla2.addRow(fila);
        tblTitulos.setModel(modeloTabla2);
        cbxTitulo.setSelectedIndex(0);
        cbxTitulo.requestFocus();
    }
    
    public void cargarListaTitulosPersonales(List listaTitulosPersonales)
    {
        for(int i = 0; i < tblTitulos.getRowCount(); i++)
        {
            tituloPersonal = new TituloPersonal();
            tituloPersonal.setTitulo(ctrlTitulo.leerTitulo(tblTitulos.getValueAt(i, 0).toString()));
            listaTitulosPersonales.add(tituloPersonal);
        }
    }

    public void modificarPersonal()
    {
        if(validar() == true)
        {
            personal.setCuil(txtCuil.getText());
            personal.setApellido(txtApellido.getText().toUpperCase());
            personal.setNombre(txtNombre.getText().toUpperCase());
            personal.setFechaNacimiento(fechaNacimiento.getDate());
            personal.setSexo(ctrlSexo.leerSexo(cbxSexo.getSelectedItem().toString()));
            personal.setEstadoCivil(ctrlEstadoCivil.leerEstadoCivil(cbxEstadoCivil.getSelectedItem().toString()));
            personal.setHijos(Integer.valueOf(txtHijos.getText()));
            personal.setTelefonoCelular(txtCelular.getText());
            personal.setEmail(txtEmail.getText().toUpperCase());

            personal.setLegajo(txtLegajo.getText().toUpperCase());
            personal.setFechaAlta(fechaAlta.getDate());
            
            domicilio.setCalle(lugar);
            domicilio.setNumero(txtNro.getText());
            domicilio.setReferencia(txtReferencia.getText());
            domicilio.setCodPostal(txtCodigoPostal.getText());
            
            if(!txtTorre.getText().equals("") && !txtPiso.getText().equals("") && !txtDepto.getText().equals(""))
            {
                ctrlDomicilio.modificarDomicilio(domicilio);
                edificio.setDomicilio(domicilio);
                edificio.setTelefonoFijo(txtFijo.getText());
                edificio.setTorre(txtTorre.getText());
                edificio.setPiso(txtPiso.getText());
                edificio.setDpto(txtDepto.getText());
                ctrlEdificio.modificarEdificio(edificio);
            }else{
                domicilio.setTelefonoFijo(txtFijo.getText());
                ctrlDomicilio.modificarDomicilio(domicilio);
            }
            if(cambiarFoto == true)
            {
                byte[] imagen = webCam.getBytes();
                personal.setFoto(imagen);
            }
            ctrlCargoPersonal.eliminarCargosPersonales(personal.getIdPersonal());
            ctrlTituloPersonal.eliminarTitulosPersonales(personal.getIdPersonal());
            cargarListaCargosPersonales(listaCargosPersonales);
            cargarListaTitulosPersonales(listaTitulosPersonales);
            personal.setListaCargosPersonales(listaCargosPersonales);
            personal.setListaTitulosPersonales(listaTitulosPersonales);
            ctrlPersonal.modificarPersonal(personal);
            limpiar();
        }
    }
    
    public void limpiar()
    {
        txtApellido.setText("");
        txtCuil.setText("");
        txtNombre.setText("");
        fechaNacimiento.setDate(null);
        txtHijos.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        txtFijo.setText("");
        txtLegajo.setText("");
        txtNro.setText("");
        txtTorre.setText("");
        txtDepto.setText("");
        txtPiso.setText("");
        txtCodigoPostal.setText("");
        txtReferencia.setText("");
        cbxDepartamento.setSelectedIndex(0);
        fechaAlta.setDate(null);
        cbxSexo.setSelectedIndex(0);
        cbxEstadoCivil.setSelectedIndex(0);
        cbxBarrio.setSelectedIndex(0);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar2.setEnabled(false);
        btnQuitar.setEnabled(false);
        btnQuitar2.setEnabled(false);
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);
        modeloTabla.addColumn("CARGO");
        modeloTabla.addColumn("SIT. DE REVISTA");
        modeloTabla.addColumn("DESDE");
        modeloTabla.addColumn("HASTA");
        
        modeloTabla2.setRowCount(0);
        modeloTabla2.setColumnCount(0);
        modeloTabla2.addColumn("TITULO");
        modeloTabla2.addColumn("NIVEL");
        
        webCam.setImagenNull();
        lblWebCam.setVisible(true);
        listaCargosPersonales = new ArrayList();
        listaTitulosPersonales = new ArrayList();
        cambiarFoto = false;
        noFoto = false;
        lblWebCam.setIcon(null);
        deshabilitarTodo();
        txtCuil.requestFocus();
    }
    
    public void deshabilitarTodo()
    {
        txtApellido.setEnabled(false);
        txtNombre.setEnabled(false);
        fechaNacimiento.setEnabled(false);
        cbxSexo.setEnabled(false);
        cbxEstadoCivil.setEnabled(false);
        txtHijos.setEnabled(false);
        txtCelular.setEnabled(false);
        txtEmail.setEnabled(false);

        txtFijo.setEnabled(false);
        cbxDepartamento.setEnabled(false);
        cbxLocalidad.setEnabled(false);
        cbxBarrio.setEnabled(false);
        cbxCalle.setEnabled(false);
        txtNro.setEnabled(false);
        txtTorre.setEnabled(false);
        txtPiso.setEnabled(false);
        txtDepto.setEnabled(false);
        txtLegajo.setEnabled(false);
        fechaAlta.setEnabled(false);
        cbxTitulo.setEnabled(false);
        btnAgregar2.setEnabled(false);
        btnAgregar.setEnabled(false);
        cbxCargo.setEnabled(false);
        cbxRevista.setEnabled(false);
        fechaDesde.setEnabled(false);
        fechaHasta.setEnabled(false);
        btnGuardar.setEnabled(false);
    }
    
    public void habilitarTodo()
    {
        txtApellido.setEnabled(true);
        txtNombre.setEnabled(true);
        fechaNacimiento.setEnabled(true);
        cbxSexo.setEnabled(true);
        cbxEstadoCivil.setEnabled(true);
        txtHijos.setEnabled(true);
        txtCelular.setEnabled(true);
        txtEmail.setEnabled(true);

        txtFijo.setEnabled(true);
        cbxDepartamento.setEnabled(true);
        cbxLocalidad.setEnabled(true);
        cbxBarrio.setEnabled(true);
        cbxCalle.setEnabled(true);
        txtNro.setEnabled(true);
        txtTorre.setEnabled(true);
        txtPiso.setEnabled(true);
        txtDepto.setEnabled(true);
        txtLegajo.setEnabled(true);
        fechaAlta.setEnabled(true);
        cbxTitulo.setEnabled(true);
        btnAgregar2.setEnabled(true);
        btnAgregar.setEnabled(true);
        cbxCargo.setEnabled(true);
        cbxRevista.setEnabled(true);
        fechaDesde.setEnabled(true);
        fechaHasta.setEnabled(true);
        btnGuardar.setEnabled(true);
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
        webCam = new JPanelWebCam.JPanelWebCam();
        lblWebCam = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        fechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtCuil = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cbxEstadoCivil = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtHijos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        fechaAlta = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbxCargo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxRevista = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        btnAgregar = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cbxTitulo = new javax.swing.JComboBox<>();
        btnAgregar2 = new javax.swing.JButton();
        btnQuitar2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTitulos = new javax.swing.JTable();
        btnCargarFoto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtNro = new javax.swing.JTextField();
        cbxCalle = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbxLocalidad = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbxBarrio = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFijo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbxDepartamento = new javax.swing.JComboBox<>();
        txtTorre = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtDepto = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();

        setTitle("Registro del Personal");

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
        webCam.add(lblWebCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 230, 220));

        btnSalir.setBackground(new java.awt.Color(0, 51, 51));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Click en el video para tomar foto");

        jPanel2.setBackground(new java.awt.Color(0, 152, 101));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuil.png"))); // NOI18N
        jLabel1.setText("CUIL");

        txtCuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuilKeyTyped(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/legajo.png"))); // NOI18N
        jLabel13.setText("Legajo");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nombreApellido.png"))); // NOI18N
        jLabel2.setText("Apellido");

        txtLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLegajoKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nombreApellido.png"))); // NOI18N
        jLabel3.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fecha.png"))); // NOI18N
        jLabel4.setText("Fecha de Nacimiento");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sexo.png"))); // NOI18N
        jLabel5.setText("Sexo");

        cbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estadoCivil.png"))); // NOI18N
        jLabel6.setText("Estado Civil");

        btnBuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoCivilActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hijos.png"))); // NOI18N
        jLabel7.setText("Hijos");

        txtHijos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHijosKeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/celular.png"))); // NOI18N
        jLabel8.setText("Telefono Celular");

        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/email.png"))); // NOI18N
        jLabel9.setText("Email");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fecha.png"))); // NOI18N
        jLabel21.setText("Fecha de Alta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel9)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 152, 101));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Cargo/s", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cargo");

        cbxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCargoActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Revista");

        cbxRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRevistaActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Desde");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Hasta");

        btnAgregar.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar2.setBackground(new java.awt.Color(0, 51, 51));
        btnModificar2.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(new java.awt.Color(0, 51, 51));
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuitar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbxRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar2)
                        .addComponent(btnQuitar))
                    .addComponent(btnAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 152, 101));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Titulo/s", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Titulo");

        cbxTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTituloActionPerformed(evt);
            }
        });

        btnAgregar2.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregar2.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        btnQuitar2.setBackground(new java.awt.Color(0, 51, 51));
        btnQuitar2.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar.png"))); // NOI18N
        btnQuitar2.setText("Quitar");
        btnQuitar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar2ActionPerformed(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nivel");

        txtNivel.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTitulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNivel))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(btnAgregar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQuitar2)))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbxTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar2)
                    .addComponent(btnQuitar2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 152, 101));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cargos del Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CARGO", "REVISTA", "DESDE", "HASTA"
            }
        ));
        tblCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCargosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblCargos);
        if (tblCargos.getColumnModel().getColumnCount() > 0) {
            tblCargos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblCargos.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 152, 101));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Titulos del Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

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
        jScrollPane2.setViewportView(tblTitulos);
        if (tblTitulos.getColumnModel().getColumnCount() > 0) {
            tblTitulos.getColumnModel().getColumn(0).setPreferredWidth(250);
            tblTitulos.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCargarFoto.setBackground(new java.awt.Color(0, 51, 51));
        btnCargarFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargarFoto.png"))); // NOI18N
        btnCargarFoto.setToolTipText("Si no tiene WebCam, puede cargar la foto manualmente");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 152, 101));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Domicilio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        cbxCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCalleActionPerformed(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/localidad.png"))); // NOI18N
        jLabel23.setText("Localidad");

        cbxLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLocalidadActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/localidad.png"))); // NOI18N
        jLabel12.setText("Barrio");

        cbxBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBarrioActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/localidad.png"))); // NOI18N
        jLabel22.setText("Calle");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fijo.png"))); // NOI18N
        jLabel11.setText("Telefono Fijo");

        txtFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFijoKeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nro");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/localidad.png"))); // NOI18N
        jLabel24.setText("Departamento");

        cbxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepartamentoActionPerformed(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Torre");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Piso");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Depto");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Referencia");

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Codigo Postal");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbxCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(cbxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cbxLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbxBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtTorre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Subir foto Manualmente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30))
                            .addComponent(webCam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(16, 16, 16))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addGap(436, 436, 436))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(webCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        crearPersonal();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea modificar el personal?","Modificar",confirmar);
        if (respuesta == 0 )
        {
            modificarPersonal();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmar,respuesta;
        confirmar = JOptionPane.YES_NO_OPTION;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea eliminar el personal?","Eliminar",confirmar);
        if (respuesta == 0 )
        {
            ctrlPersonal.eliminarPersonal(personal);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        habilitarTodo();
        personal = ctrlPersonal.leerPersonal(txtCuil.getText());
        if(personal != null)
        {
            txtApellido.setText(personal.getApellido());
            txtNombre.setText(personal.getNombre());
            fechaNacimiento.setDate(personal.getFechaNacimiento());
            cbxSexo.setSelectedItem(personal.getSexo().getSexo());
            cbxEstadoCivil.setSelectedItem(personal.getEstadoCivil().getEstadoCivil());
            txtHijos.setText(String.valueOf(personal.getHijos()));
            txtCelular.setText(personal.getTelefonoCelular());
            txtEmail.setText(personal.getEmail());

            txtLegajo.setText(personal.getLegajo());
            fechaAlta.setDate(personal.getFechaAlta());
            
            txtNro.setText(personal.getDomicilio().getNumero());
            if(personal.getDomicilio().getTelefonoFijo() == null)
            {
                edificio = ctrlEdificio.leerEdificio(personal.getDomicilio().getIdDomicilio());
                txtFijo.setText(edificio.getTelefonoFijo());
                txtTorre.setText(edificio.getTorre());
                txtPiso.setText(edificio.getPiso());
                txtDepto.setText(edificio.getDpto());
            }else{
                txtFijo.setText(personal.getDomicilio().getTelefonoFijo());
                txtTorre.setText("");
                txtPiso.setText("");
                txtDepto.setText("");
            }
            
            txtReferencia.setText(personal.getDomicilio().getReferencia());
            txtCodigoPostal.setText(personal.getDomicilio().getCodPostal());
            String depto,localidad,barrio,calle;
            lugar = ctrlLugar.leerLugar(personal.getDomicilio().getCalle().getNombre());
            calle = lugar.getNombre();
            lugar = ctrlLugar.leerLugar(personal.getDomicilio().getCalle().getDe());
            barrio = lugar.getNombre();
            lugar = ctrlLugar.leerLugar(lugar.getDe());
            localidad = lugar.getNombre();
            lugar = ctrlLugar.leerLugar(lugar.getDe());
            depto = lugar.getNombre();
            cbxDepartamento.setSelectedItem(depto);
            cbxLocalidad.setSelectedItem(localidad);
            cbxBarrio.setSelectedItem(barrio);
            cbxCalle.setSelectedItem(calle);
            
            btnGuardar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            cargarTablaCargos();
            cargarTablaTitulos();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCuilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuilKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
        if(txtCuil.getText().length() == 11){
            evt.consume();
        }
    }//GEN-LAST:event_txtCuilKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        if ((!Character.isLetter(evt.getKeyChar()) && (evt.getKeyChar() != KeyEvent.VK_SPACE))) {
            evt.consume();
        }
        if(txtApellido.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if ((!Character.isLetter(evt.getKeyChar()) && (evt.getKeyChar() != KeyEvent.VK_SPACE))) {
            evt.consume();
        }
        if(txtNombre.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
        if(txtCelular.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        if(txtEmail.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtLegajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyTyped
        if(txtLegajo.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtLegajoKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        cargarTablaCARGOS();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        cargarTablaTITULOS();
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void tblCargosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargosMousePressed
        int FilaSelec = tblCargos.getSelectedRow();
        cbxCargo.setSelectedItem(tblCargos.getValueAt(FilaSelec, 0).toString());
        cbxRevista.setSelectedItem(tblCargos.getValueAt(FilaSelec, 1).toString());
        try {
            String fechaD = tblCargos.getValueAt(FilaSelec, 2).toString();
            String fechaH = tblCargos.getValueAt(FilaSelec, 3).toString();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            date = formatter.parse(fechaD);
            fechaDesde.setDate(date);
            date = formatter.parse(fechaH);
            fechaHasta.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(PersonalRegistroDePersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAgregar.setEnabled(false);
        btnModificar2.setEnabled(true);
        btnQuitar.setEnabled(true);
    }//GEN-LAST:event_tblCargosMousePressed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblCargos.getModel();
        dtm.removeRow(tblCargos.getSelectedRow());
        cargarTablaCARGOS();
        btnAgregar.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnQuitar.setEnabled(false);
        cbxCargo.setSelectedIndex(0);
        cbxRevista.setSelectedIndex(0);
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        cbxCargo.requestFocus();
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblCargos.getModel();
        dtm.removeRow(tblCargos.getSelectedRow());
        btnAgregar.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnQuitar.setEnabled(false);
        cbxCargo.setSelectedIndex(0);
        cbxRevista.setSelectedIndex(0);
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        cbxCargo.requestFocus();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnQuitar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar2ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblTitulos.getModel();
        dtm.removeRow(tblTitulos.getSelectedRow());
        btnQuitar2.setEnabled(false);
        btnAgregar2.setEnabled(true);
        cbxTitulo.setSelectedIndex(0);
        cbxTitulo.requestFocus();
    }//GEN-LAST:event_btnQuitar2ActionPerformed

    private void cbxTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTituloActionPerformed
        if(cbxTitulo.getSelectedItem()!=null && cbxTitulo.getSelectedItem().equals("OTRO"))
        {
            TitulosNuevoTitulo ventana = new TitulosNuevoTitulo();
            PantallaEPA.desktopPane.add(ventana);
            ventana.setVisible(true);
        }else{
            if(cbxTitulo.getSelectedItem()!=null && cbxTitulo.getSelectedItem()!= "SELECCIONAR")
            {
                titulo = ctrlTitulo.leerTitulo(cbxTitulo.getSelectedItem().toString());
                txtNivel.setText(titulo.getNivel().getNivel());
            }
        }
    }//GEN-LAST:event_cbxTituloActionPerformed

    private void tblTitulosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTitulosMousePressed
        btnQuitar2.setEnabled(true);
        btnAgregar2.setEnabled(false);
    }//GEN-LAST:event_tblTitulosMousePressed

    private void txtHijosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHijosKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
        if(txtHijos.getText().length() == 2){
            evt.consume();
        }
    }//GEN-LAST:event_txtHijosKeyTyped

    private void cbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoActionPerformed
        if(cbxSexo.getSelectedItem()!=null && cbxSexo.getSelectedItem().equals("OTRO"))
        {
            SexosNuevoSexo ventana = new SexosNuevoSexo();
            PantallaEPA.desktopPane.add(ventana);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_cbxSexoActionPerformed

    private void cbxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoCivilActionPerformed
        if(cbxEstadoCivil.getSelectedItem()!=null && cbxEstadoCivil.getSelectedItem().equals("OTRO"))
        {
            EstadosCivilesNuevoEstadoCivil ventana = new EstadosCivilesNuevoEstadoCivil();
            PantallaEPA.desktopPane.add(ventana);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_cbxEstadoCivilActionPerformed

    private void cbxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCargoActionPerformed
        if(cbxCargo.getSelectedItem()!=null && cbxCargo.getSelectedItem() != "SELECCIONAR" && cbxCargo.getSelectedItem().equals("OTRO"))
        {
            CargosNuevoCargo ventana = new CargosNuevoCargo();
            PantallaEPA.desktopPane.add(ventana);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_cbxCargoActionPerformed

    private void cbxRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRevistaActionPerformed
        if(cbxRevista.getSelectedItem()!=null && cbxRevista.getSelectedItem() != "SELECCIONAR" && cbxRevista.getSelectedItem().equals("OTRA"))
        {
            RevistasNuevaRevista ventana = new RevistasNuevaRevista();
            PantallaEPA.desktopPane.add(ventana);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_cbxRevistaActionPerformed

    private void webCamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webCamMousePressed
        lblWebCam.setVisible(false);
        cambiarFoto = true;
    }//GEN-LAST:event_webCamMousePressed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        cambiarFoto = true;
        int resultado;
        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.cargaFoto.setFileFilter(filtro);
        resultado= ventana.cargaFoto.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado)
        {
            portada = ventana.cargaFoto.getSelectedFile();
            try{
                ImageIcon icon = new ImageIcon(portada.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblWebCam.getWidth(), lblWebCam.getHeight(), Image.SCALE_DEFAULT));
                imagen = Files.readAllBytes(portada.toPath());
                //lblWebCam.setText(null);
                lblWebCam.setIcon(icono);
                noFoto = true;
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
            }
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void cbxCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCalleActionPerformed
        if(cbxCalle.getSelectedItem() != null && cbxCalle.getSelectedIndex()>0)
        {    
            lugar = ctrlLugar.leerLugar(cbxCalle.getSelectedItem().toString());
        }else{
            lugar = new Lugar();
        }
    }//GEN-LAST:event_cbxCalleActionPerformed

    private void cbxLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLocalidadActionPerformed
        if(cbxLocalidad.getSelectedItem() == null || cbxLocalidad.getSelectedIndex() == 0)
        {
            limpiarCombo(cbxBarrio);
            limpiarCombo(cbxCalle);
        }else{
            lugar = ctrlLugar.leerLugar(cbxLocalidad.getSelectedItem().toString());
            lista = ctrlLugar.leerTodosDe(lugar);
            cargarCombo(cbxBarrio, lista);
        }
    }//GEN-LAST:event_cbxLocalidadActionPerformed

    private void cbxBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBarrioActionPerformed
        if(cbxBarrio.getSelectedItem() == null || cbxBarrio.getSelectedIndex() == 0)
        {
            limpiarCombo(cbxCalle);
        }else{
            lugar = ctrlLugar.leerLugar(cbxBarrio.getSelectedItem().toString());
            lista = ctrlLugar.leerTodosDe(lugar);
            cargarCombo(cbxCalle, lista);
        }
    }//GEN-LAST:event_cbxBarrioActionPerformed

    private void txtFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFijoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
        if(txtFijo.getText().length() == 45){
            evt.consume();
        }
    }//GEN-LAST:event_txtFijoKeyTyped

    private void cbxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepartamentoActionPerformed
        if(cbxDepartamento.getSelectedIndex() == 0)
        {
            limpiarCombo(cbxLocalidad);
            limpiarCombo(cbxBarrio);
            limpiarCombo(cbxCalle);
        }else{
            lugar = ctrlLugar.leerLugar(cbxDepartamento.getSelectedItem().toString());
            lista = ctrlLugar.leerTodosDe(lugar);
            cargarCombo(cbxLocalidad, lista);
        }
    }//GEN-LAST:event_cbxDepartamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitar2;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox<String> cbxBarrio;
    public static javax.swing.JComboBox<String> cbxCalle;
    public static javax.swing.JComboBox<String> cbxCargo;
    public static javax.swing.JComboBox<String> cbxDepartamento;
    public static javax.swing.JComboBox<String> cbxEstadoCivil;
    public static javax.swing.JComboBox<String> cbxLocalidad;
    public static javax.swing.JComboBox<String> cbxRevista;
    public static javax.swing.JComboBox<String> cbxSexo;
    public static javax.swing.JComboBox<String> cbxTitulo;
    private com.toedter.calendar.JDateChooser fechaAlta;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private com.toedter.calendar.JDateChooser fechaNacimiento;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblWebCam;
    private javax.swing.JTable tblCargos;
    private javax.swing.JTable tblTitulos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFijo;
    private javax.swing.JTextField txtHijos;
    private javax.swing.JTextField txtLegajo;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNro;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTorre;
    private JPanelWebCam.JPanelWebCam webCam;
    // End of variables declaration//GEN-END:variables
}
