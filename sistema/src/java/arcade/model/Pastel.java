package arcade.model;

/**
 * @author AYCM
 */
public class Pastel {

    private int id_estatus;
    private String estatus;
    private int cuentas;
    private int pagadas;
    private int por_cobrar;
    private Float pagado_estatus;
    private Float por_cobrar_estatus;
    private Float valor_estatus;
    private String ultima_gestion;
    private int id_usuario;

    public Pastel() {
    }

    public int getId_estatus() {
        return id_estatus;
    }

    public void setId_estatus(int id_estatus) {
        this.id_estatus = id_estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getCuentas() {
        return cuentas;
    }

    public void setCuentas(int cuentas) {
        this.cuentas = cuentas;
    }

    public int getPagadas() {
        return pagadas;
    }

    public void setPagadas(int pagadas) {
        this.pagadas = pagadas;
    }

    public int getPor_cobrar() {
        return por_cobrar;
    }

    public void setPor_cobrar(int por_cobrar) {
        this.por_cobrar = por_cobrar;
    }

    public Float getPagado_estatus() {
        return pagado_estatus;
    }

    public void setPagado_estatus(Float pagado_estatus) {
        this.pagado_estatus = pagado_estatus;
    }

    public Float getPor_cobrar_estatus() {
        return por_cobrar_estatus;
    }

    public void setPor_cobrar_estatus(Float por_cobrar_estatus) {
        this.por_cobrar_estatus = por_cobrar_estatus;
    }

    public Float getValor_estatus() {
        return valor_estatus;
    }

    public void setValor_estatus(Float valor_estatus) {
        this.valor_estatus = valor_estatus;
    }

    public String getUltima_gestion() {
        return ultima_gestion;
    }

    public void setUltima_gestion(String ultima_gestion) {
        this.ultima_gestion = ultima_gestion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
