package arcade.model;

/* @author ARCADE Software Group */
public class Estatus {

    private int id_estatus;  
    private String estatus;
    private int id_usuario;
    private String descripcion;
    private int id_jerarquia;
    private String jerarquia;

    public Estatus() {
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_jerarquia() {
        return id_jerarquia;
    }

    public void setId_jerarquia(int id_jerarquia) {
        this.id_jerarquia = id_jerarquia;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

}
