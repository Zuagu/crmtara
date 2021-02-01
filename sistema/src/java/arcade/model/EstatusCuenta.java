package arcade.model;

/* @author Luis Cortez */
public class EstatusCuenta {

    private int id_estatus_cuenta;
    private String estatus_cuenta;
    private String descripcion;
    private int id_cliente;
    private int id_orden;
    private int f_deleted;

    // SALDOS POR ESTATUS Y REGION
    private String region;
    private int cuentas;
    private String valor;
    private String promedio;
    private int dias;
    private String color;

    // ULTIMA GESTION
    private String cuenta;
    private String ultima_gestion;

    private String estatus_posibles;
    private String estatus_posibles_txt;

    public EstatusCuenta() {
    }

    public int getId_estatus_cuenta() {
        return id_estatus_cuenta;
    }

    public void setId_estatus_cuenta(int id_estatus_cuenta) {
        this.id_estatus_cuenta = id_estatus_cuenta;
    }

    public String getEstatus_cuenta() {
        return estatus_cuenta;
    }

    public void setEstatus_cuenta(String estatus_cuenta) {
        this.estatus_cuenta = estatus_cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getF_deleted() {
        return f_deleted;
    }

    public void setF_deleted(int f_deleted) {
        this.f_deleted = f_deleted;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCuentas() {
        return cuentas;
    }

    public void setCuentas(int cuentas) {
        this.cuentas = cuentas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getUltima_gestion() {
        return ultima_gestion;
    }

    public void setUltima_gestion(String ultima_gestion) {
        this.ultima_gestion = ultima_gestion;
    }

    public String getEstatus_posibles() {
        return estatus_posibles;
    }

    public void setEstatus_posibles(String estatus_posibles) {
        this.estatus_posibles = estatus_posibles;
    }

    public String getEstatus_posibles_txt() {
        return estatus_posibles_txt;
    }

    public void setEstatus_posibles_txt(String estatus_posibles_txt) {
        this.estatus_posibles_txt = estatus_posibles_txt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
