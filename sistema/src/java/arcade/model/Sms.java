package arcade.model;

/* @author Luis Cortez */
public class Sms {

    private int id_sms;
    private String sms;
    private int id_categoria;
    private int id_usuario;
    private String usuario;
    private String fecha_insert;
    private int f_autorizado;
    private String fecha_autorizado;

    public Sms() {
    }

    public int getId_sms() {
        return id_sms;
    }

    public void setId_sms(int id_sms) {
        this.id_sms = id_sms;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha_insert() {
        return fecha_insert;
    }

    public void setFecha_insert(String fecha_insert) {
        this.fecha_insert = fecha_insert;
    }

    public int getF_autorizado() {
        return f_autorizado;
    }

    public void setF_autorizado(int f_autorizado) {
        this.f_autorizado = f_autorizado;
    }

    public String getFecha_autorizado() {
        return fecha_autorizado;
    }

    public void setFecha_autorizado(String fecha_autorizado) {
        this.fecha_autorizado = fecha_autorizado;
    }

}
