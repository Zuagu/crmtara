package arcade.model;

/* @author luiscortez */
public class Manual {

    private int id_renglon;
    private String tipo;
    private String texto;
    private String jsp;
    private int orden;

    public Manual() {
    }

    public int getId_renglon() {
        return id_renglon;
    }

    public void setId_renglon(int id_renglon) {
        this.id_renglon = id_renglon;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getJsp() {
        return jsp;
    }

    public void setJsp(String jsp) {
        this.jsp = jsp;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

}
