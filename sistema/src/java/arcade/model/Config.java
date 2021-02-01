package arcade.model;

/* @author luiscortez */
public class Config {

    private int id_tema;
    private String franja_index;
    private String nombre_cliente;
    private String color;
    private String color_menu;

    public Config() {
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public String getFranja_index() {
        return franja_index;
    }

    public void setFranja_index(String franja_index) {
        this.franja_index = franja_index;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor_menu() {
        return color_menu;
    }

    public void setColor_menu(String color_menu) {
        this.color_menu = color_menu;
    }

}
