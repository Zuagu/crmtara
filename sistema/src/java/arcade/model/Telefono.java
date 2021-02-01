package arcade.model;

/* @author Luis Cortez */
public class Telefono {

    private int id_telefono;
    private String telefono;
    private int id_tipo_tel;
    private String tipo_tel;
    private String nombre;
    private String porcentaje;
    private String llamando;

    public Telefono() {
    }

    public int getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_tipo_tel() {
        return id_tipo_tel;
    }

    public void setId_tipo_tel(int id_tipo_tel) {
        this.id_tipo_tel = id_tipo_tel;
    }

    public String getTipo_tel() {
        return tipo_tel;
    }

    public void setTipo_tel(String tipo_tel) {
        this.tipo_tel = tipo_tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getLlamando() {
        return llamando;
    }

    public void setLlamando(String llamando) {
        this.llamando = llamando;
    }

}
