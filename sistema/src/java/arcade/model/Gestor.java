package arcade.model;

/* @author Luis Cortez */
public class Gestor {

    private int id_gestor;
    private String gestor;
    private String alias;
    private int extension;
    private int id_equipo;
    private String equipo;
    private String puesto;

    private int f_active;
    private int f_bloqueado;
    private String estrategia;

    // VALORES PARA LA ESTRATEGIA DINÁMICA DE EXTRAJUDICIAL
    private int f_cr;
    private String select_cr;
    private int importe;
    private String orden;
    private String select_orden;
    private String cadena_estatus;
    private String estatus;
    private String select_seguimientos;

    private int cuentas;

    private int id_categoria;
    private String categoria;

    private String recuperado_mensual;

    public Gestor() {
    }

    public int getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(int id_gestor) {
        this.id_gestor = id_gestor;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getF_active() {
        return f_active;
    }

    public void setF_active(int f_active) {
        this.f_active = f_active;
    }

    public int getF_bloqueado() {
        return f_bloqueado;
    }

    public void setF_bloqueado(int f_bloqueado) {
        this.f_bloqueado = f_bloqueado;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public int getF_cr() {
        return f_cr;
    }

    public void setF_cr(int f_cr) {
        this.f_cr = f_cr;
    }

    public String getSelect_cr() {
        return select_cr;
    }

    public void setSelect_cr(String select_cr) {
        this.select_cr = select_cr;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getSelect_orden() {
        return select_orden;
    }

    public void setSelect_orden(String select_orden) {
        this.select_orden = select_orden;
    }

    public String getCadena_estatus() {
        return cadena_estatus;
    }

    public void setCadena_estatus(String cadena_estatus) {
        this.cadena_estatus = cadena_estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getSelect_seguimientos() {
        return select_seguimientos;
    }

    public void setSelect_seguimientos(String select_seguimientos) {
        this.select_seguimientos = select_seguimientos;
    }

    public int getCuentas() {
        return cuentas;
    }

    public void setCuentas(int cuentas) {
        this.cuentas = cuentas;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRecuperado_mensual() {
        return recuperado_mensual;
    }

    public void setRecuperado_mensual(String recuperado_mensual) {
        this.recuperado_mensual = recuperado_mensual;
    }

}
