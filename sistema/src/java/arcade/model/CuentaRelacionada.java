package arcade.model;

/**
 * @author AYCM
 */
public class CuentaRelacionada {

    private int id_cr;
    private int cuenta_en_despacho;
    private String telefono;
    private String estatus;
    private String nombre;
    private String rfc;

    public CuentaRelacionada() {
    }

    public int getId_cr() {
        return id_cr;
    }

    public void setId_cr(int id_cr) {
        this.id_cr = id_cr;
    }

    public int getCuenta_en_despacho() {
        return cuenta_en_despacho;
    }

    public void setCuenta_en_despacho(int cuenta_en_despacho) {
        this.cuenta_en_despacho = cuenta_en_despacho;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

}

