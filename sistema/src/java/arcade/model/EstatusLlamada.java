package arcade.model;

/* @author Luis Cortez */
public class EstatusLlamada {

    private int id_estatus_llamada;
    private String estatus_llamada;
    private String descripcion;

    public EstatusLlamada() {
    }

    public int getId_estatus_llamada() {
        return id_estatus_llamada;
    }

    public void setId_estatus_llamada(int id_estatus_llamada) {
        this.id_estatus_llamada = id_estatus_llamada;
    }

    public String getEstatus_llamada() {
        return estatus_llamada;
    }

    public void setEstatus_llamada(String estatus_llamada) {
        this.estatus_llamada = estatus_llamada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
