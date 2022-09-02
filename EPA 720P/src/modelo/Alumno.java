package modelo;

public class Alumno {

    private int idAlumno;
    private int nroLibMatriz;
    private Personal personal;
    private Estado estado;
    private Lugar localidad;
    private Comunidad interCulturalidad;
    private RegimenEspecial regimenEspecial;
    private int transporte;
    private int servicioAlimentarioEscolar;
    private boolean desayunoMeriendaCompleta;
    private boolean desayuno;
    private boolean comedorSimple;
    private boolean cena;
    private boolean almuerzo;
    private boolean merienda;
    private int docenteIntegrador;
    private int nivelTutor;
    private int discapacidad;
    private boolean ceguera;
    private boolean sordera;
    private boolean motoraPuraIntelectual;
    private boolean hipoacusia;
    private boolean neuromotora;
    private boolean trastornoEspectroAutista;
    private boolean disminucionVisual;
    String otroDiscapacidad;

    public String getOtroDiscapacidad() {
        return otroDiscapacidad;
    }

    public void setOtroDiscapacidad(String otroDiscapacidad) {
        this.otroDiscapacidad = otroDiscapacidad;
    }
    
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getNroLibMatriz() {
        return nroLibMatriz;
    }

    public void setNroLibMatriz(int nroLibMatriz) {
        this.nroLibMatriz = nroLibMatriz;
    }

    public Lugar getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Lugar localidad) {
        this.localidad = localidad;
    }

    public Comunidad getInterCulturalidad() {
        return interCulturalidad;
    }

    public void setInterCulturalidad(Comunidad interCulturalidad) {
        this.interCulturalidad = interCulturalidad;
    }

    public RegimenEspecial getRegimenEspecial() {
        return regimenEspecial;
    }

    public void setRegimenEspecial(RegimenEspecial regimenEspecial) {
        this.regimenEspecial = regimenEspecial;
    }

    public int getTransporte() {
        return transporte;
    }

    public void setTransporte(int transporte) {
        this.transporte = transporte;
    }

    public int getServicioAlimentarioEscolar() {
        return servicioAlimentarioEscolar;
    }

    public void setServicioAlimentarioEscolar(int servicioAlimentarioEscolar) {
        this.servicioAlimentarioEscolar = servicioAlimentarioEscolar;
    }

    public boolean isDesayunoMeriendaCompleta() {
        return desayunoMeriendaCompleta;
    }

    public void setDesayunoMeriendaCompleta(boolean desayunoMeriendaCompleta) {
        this.desayunoMeriendaCompleta = desayunoMeriendaCompleta;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isComedorSimple() {
        return comedorSimple;
    }

    public void setComedorSimple(boolean comedorSimple) {
        this.comedorSimple = comedorSimple;
    }

    public boolean isCena() {
        return cena;
    }

    public void setCena(boolean cena) {
        this.cena = cena;
    }

    public boolean isAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }

    public boolean isMerienda() {
        return merienda;
    }

    public void setMerienda(boolean merienda) {
        this.merienda = merienda;
    }

    public int getDocenteIntegrador() {
        return docenteIntegrador;
    }

    public void setDocenteIntegrador(int docenteIntegrador) {
        this.docenteIntegrador = docenteIntegrador;
    }

    public int getNivelTutor() {
        return nivelTutor;
    }

    public void setNivelTutor(int nivelTutor) {
        this.nivelTutor = nivelTutor;
    }

    public int getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(int discapacidad) {
        this.discapacidad = discapacidad;
    }

    public boolean isCeguera() {
        return ceguera;
    }

    public void setCeguera(boolean ceguera) {
        this.ceguera = ceguera;
    }

    public boolean isSordera() {
        return sordera;
    }

    public void setSordera(boolean sordera) {
        this.sordera = sordera;
    }

    public boolean isMotoraPuraIntelectual() {
        return motoraPuraIntelectual;
    }

    public void setMotoraPuraIntelectual(boolean motoraPuraIntelectual) {
        this.motoraPuraIntelectual = motoraPuraIntelectual;
    }

    public boolean isHipoacusia() {
        return hipoacusia;
    }

    public void setHipoacusia(boolean hipoacusia) {
        this.hipoacusia = hipoacusia;
    }

    public boolean isNeuromotora() {
        return neuromotora;
    }

    public void setNeuromotora(boolean neuromotora) {
        this.neuromotora = neuromotora;
    }

    public boolean isTrastornoEspectroAutista() {
        return trastornoEspectroAutista;
    }

    public void setTrastornoEspectroAutista(boolean trastornoEspectroAutista) {
        this.trastornoEspectroAutista = trastornoEspectroAutista;
    }

    public boolean isDisminucionVisual() {
        return disminucionVisual;
    }

    public void setDisminucionVisual(boolean disminucionVisual) {
        this.disminucionVisual = disminucionVisual;
    }

}
