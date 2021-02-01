package arcade.model;

/* @author luiscortez */
public class Story {

    private int id_story; // 1
    private String story; // modulo visitas
    private String descripcion; // en este modulo la mamá de tito de los reyes del camino
    private int id_prioridad; // 1

    private int id_usuario; // 1
    private String usuario; // 1
    private String fecha_insert; // now

    private int f_delete; // 0
    private String fecha_delete; // null
    private int id_usuario_delete; // null
    private String usuario_delete; // null

    private String tiempo_estimado; // 15:00:00 horas
    private String tiempo_real; // 15:00:00 horas
    private String tickets; // 5 de 15

    public Story() {
    }

    public int getId_story() {
        return id_story;
    }

    public void setId_story(int id_story) {
        this.id_story = id_story;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_prioridad() {
        return id_prioridad;
    }

    public void setId_prioridad(int id_prioridad) {
        this.id_prioridad = id_prioridad;
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

    public int getF_delete() {
        return f_delete;
    }

    public void setF_delete(int f_delete) {
        this.f_delete = f_delete;
    }

    public String getFecha_delete() {
        return fecha_delete;
    }

    public void setFecha_delete(String fecha_delete) {
        this.fecha_delete = fecha_delete;
    }

    public int getId_usuario_delete() {
        return id_usuario_delete;
    }

    public void setId_usuario_delete(int id_usuario_delete) {
        this.id_usuario_delete = id_usuario_delete;
    }

    public String getUsuario_delete() {
        return usuario_delete;
    }

    public void setUsuario_delete(String usuario_delete) {
        this.usuario_delete = usuario_delete;
    }

    public String getTiempo_estimado() {
        return tiempo_estimado;
    }

    public void setTiempo_estimado(String tiempo_estimado) {
        this.tiempo_estimado = tiempo_estimado;
    }

    public String getTiempo_real() {
        return tiempo_real;
    }

    public void setTiempo_real(String tiempo_real) {
        this.tiempo_real = tiempo_real;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

}
