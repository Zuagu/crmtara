package arcade.model;

/* @author Luis Cortez */
public class Pagocuenta {

    private int id_pago;
    private int id_cliente;
    private int id_region;
    private int id_asignacion;
    private String cuenta;
    private String fecha_pago;
    private String origen;
    private Float importe;
    private String forma;
    private String estatus;
    private String fecha_aplicacion;
    private int f_gestionado;
    private String gestionado;

//    clases de pagodiario
    private String desde;
    private String hasta;
    private String asignacion;
    private String id_cuenta;
    private String id_equipo;
    private String nombre_equipo;
    private String vencido;
    private String resto;
    private String pago;
    private String aplica;
    private String resto_actual;
    private String punto;
    private String recuperado;
    private String dias;
    private String asignado;
    private String anticipado;
    private String porcentaje;
    private String avance;
    private String diario;
    private String corte;
    private String c_porcentaje;
    private String c_recuperacion;
    private String c_avance;

    public Pagocuenta() {
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public int getF_gestionado() {
        return f_gestionado;
    }

    public void setF_gestionado(int f_gestionado) {
        this.f_gestionado = f_gestionado;
    }

    public String getGestionado() {
        return gestionado;
    }

    public void setGestionado(String gestionado) {
        this.gestionado = gestionado;
    }

    //GETERS AND SETTER PARA PAGOS DIARIOS
    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public String getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(String id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getVencido() {
        return vencido;
    }

    public void setVencido(String vencido) {
        this.vencido = vencido;
    }

    public String getResto() {
        return resto;
    }

    public void setResto(String resto) {
        this.resto = resto;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getAplica() {
        return aplica;
    }

    public void setAplica(String aplica) {
        this.aplica = aplica;
    }

    public String getResto_actual() {
        return resto_actual;
    }

    public void setResto_actual(String resto_actual) {
        this.resto_actual = resto_actual;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getRecuperado() {
        return recuperado;
    }

    public void setRecuperado(String recuperado) {
        this.recuperado = recuperado;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getAsignado() {
        return asignado;
    }

    public void setAsignado(String asignado) {
        this.asignado = asignado;
    }

    public String getAnticipado() {
        return anticipado;
    }

    public void setAnticipado(String anticipado) {
        this.anticipado = anticipado;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }

    public String getDiario() {
        return diario;
    }

    public void setDiario(String diario) {
        this.diario = diario;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    public String getC_porcentaje() {
        return c_porcentaje;
    }

    public void setC_porcentaje(String c_porcentaje) {
        this.c_porcentaje = c_porcentaje;
    }

    public String getC_recuperacion() {
        return c_recuperacion;
    }

    public void setC_recuperacion(String c_recuperacion) {
        this.c_recuperacion = c_recuperacion;
    }

    public String getC_avance() {
        return c_avance;
    }

    public void setC_avance(String c_avance) {
        this.c_avance = c_avance;
    }

}
