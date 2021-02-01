package arcade.model;

/* @author Luis Cortez */
public class NodoOrganigrama {

    private int id_nodo;
    private String descripcion;
    private int id_padre;
    private int hijos;

    private int id_tipo_nodo;
    private String tipo_nodo;

    private int id_contenido;
    private String contenido;

    private String estatus_vacante;
    private String color;
    private String porcentaje_cubierto;

    public NodoOrganigrama() {
    }

    public int getId_nodo() {
        return id_nodo;
    }

    public void setId_nodo(int id_nodo) {
        this.id_nodo = id_nodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public int getId_tipo_nodo() {
        return id_tipo_nodo;
    }

    public void setId_tipo_nodo(int id_tipo_nodo) {
        this.id_tipo_nodo = id_tipo_nodo;
    }

    public String getTipo_nodo() {
        return tipo_nodo;
    }

    public void setTipo_nodo(String tipo_nodo) {
        this.tipo_nodo = tipo_nodo;
    }

    public int getId_contenido() {
        return id_contenido;
    }

    public void setId_contenido(int id_contenido) {
        this.id_contenido = id_contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstatus_vacante() {
        return estatus_vacante;
    }

    public void setEstatus_vacante(String estatus_vacante) {
        this.estatus_vacante = estatus_vacante;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPorcentaje_cubierto() {
        return porcentaje_cubierto;
    }

    public void setPorcentaje_cubierto(String porcentaje_cubierto) {
        this.porcentaje_cubierto = porcentaje_cubierto;
    }

}