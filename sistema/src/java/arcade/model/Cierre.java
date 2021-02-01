package arcade.model;

/* @author Luis Cortez */
public class Cierre {

    private String region;
    private String asignacion;
    private String cuenta;
    private String ultima_gestion;
    private String estatus;
    private String codigo;

    public Cierre() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
