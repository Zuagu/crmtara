package arcade.model;

/* @author Luis Cortez */
public class CategoriaSms {

    private int id_categoria_sms;
    private String categoria_sms;
    private int f_autorizado;
    private String autorizado;

    public CategoriaSms() {
    }

    public int getId_categoria_sms() {
        return id_categoria_sms;
    }

    public void setId_categoria_sms(int id_categoria_sms) {
        this.id_categoria_sms = id_categoria_sms;
    }

    public String getCategoria_sms() {
        return categoria_sms;
    }

    public void setCategoria_sms(String categoria_sms) {
        this.categoria_sms = categoria_sms;
    }

    public int getF_autorizado() {
        return f_autorizado;
    }

    public void setF_autorizado(int f_autorizado) {
        this.f_autorizado = f_autorizado;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

}
