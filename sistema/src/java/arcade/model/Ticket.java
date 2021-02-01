package arcade.model;

/* @author Luis Cortez */
public class Ticket {

    private int id_ticket; // 1 - AI
    private String ticket; // call arcade_insert_asignacion_visitas(); 

    private int id_story;

    private String comentarios; // para crear una asignacion de visitas...
    private String fecha_insert; // now()
    private int id_usuario; // 1                    Scrum Master
    private String usuario; // Luis Cortez

    private int id_usuario_asignado; // 1 - 2
    private String usuario_asignado; // 1 - 2

    private String tiempo_estimado; // 02:00:00
    private String tiempo_real; // 00:54:00

    private String fecha_inicio; // 2018-03-01 15:30:00   Activar con boton

    private String fecha_fin_teoria;  // fecha_inicio + tiempo_estimado
    private String fecha_fin; // Activar con botón  Activar con botón

    private int f_estatus; // 0 - 1

    private String categoria; // front-end;
    private int f_delete;

    // ESTAS VARIABLES SON PARA TENER EL "n00B RESUME" DEL AVANCE DEL SISTEMA
    private int trabajando;
    private String desde;
    private int pendientes;
    private String trabajo_restante;
    private String porcentaje_puntualidad;

    public Ticket() {
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getId_story() {
        return id_story;
    }

    public void setId_story(int id_story) {
        this.id_story = id_story;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFecha_insert() {
        return fecha_insert;
    }

    public void setFecha_insert(String fecha_insert) {
        this.fecha_insert = fecha_insert;
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

    public int getId_usuario_asignado() {
        return id_usuario_asignado;
    }

    public void setId_usuario_asignado(int id_usuario_asignado) {
        this.id_usuario_asignado = id_usuario_asignado;
    }

    public String getUsuario_asignado() {
        return usuario_asignado;
    }

    public void setUsuario_asignado(String usuario_asignado) {
        this.usuario_asignado = usuario_asignado;
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

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin_teoria() {
        return fecha_fin_teoria;
    }

    public void setFecha_fin_teoria(String fecha_fin_teoria) {
        this.fecha_fin_teoria = fecha_fin_teoria;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getF_estatus() {
        return f_estatus;
    }

    public void setF_estatus(int f_estatus) {
        this.f_estatus = f_estatus;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getF_delete() {
        return f_delete;
    }

    public void setF_delete(int f_delete) {
        this.f_delete = f_delete;
    }

    public int getTrabajando() {
        return trabajando;
    }

    public void setTrabajando(int trabajando) {
        this.trabajando = trabajando;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public int getPendientes() {
        return pendientes;
    }

    public void setPendientes(int pendientes) {
        this.pendientes = pendientes;
    }

    public String getTrabajo_restante() {
        return trabajo_restante;
    }

    public void setTrabajo_restante(String trabajo_restante) {
        this.trabajo_restante = trabajo_restante;
    }

    public String getPorcentaje_puntualidad() {
        return porcentaje_puntualidad;
    }

    public void setPorcentaje_puntualidad(String porcentaje_puntualidad) {
        this.porcentaje_puntualidad = porcentaje_puntualidad;
    }

}
