package arcade.model;

public class Requisicion {

    private int id;
    private int id_usuario;
    private String fecha_solicitada;
    private String fecha_requerida;
    private int f_urgente;
    private String comentarios;
    private int id_usuario_respuesta;
    private String respuesta;
    private String fecha_respuesta;
    private String usuario;
    private String urgente;
    private String usuario_respuesta;

    //CAMPOS PARA LASER
    private int id_pedido;
    //CAMPOS PARA LASER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_solicitada() {
        return fecha_solicitada;
    }

    public void setFecha_solicitada(String fecha_solicitada) {
        this.fecha_solicitada = fecha_solicitada;
    }

    public String getFecha_requerida() {
        return fecha_requerida;
    }

    public void setFecha_requerida(String fecha_requerida) {
        this.fecha_requerida = fecha_requerida;
    }

    public int getF_urgente() {
        return f_urgente;
    }

    public void setF_urgente(int f_urgente) {
        this.f_urgente = f_urgente;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getId_usuario_respuesta() {
        return id_usuario_respuesta;
    }

    public void setId_usuario_respuesta(int id_usuario_respuesta) {
        this.id_usuario_respuesta = id_usuario_respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getFecha_respuesta() {
        return fecha_respuesta;
    }

    public void setFecha_respuesta(String fecha_respuesta) {
        this.fecha_respuesta = fecha_respuesta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUrgente() {
        return urgente;
    }

    public void setUrgente(String urgente) {
        this.urgente = urgente;
    }

    public String getUsuario_respuesta() {
        return usuario_respuesta;
    }

    public void setUsuario_respuesta(String usuario_respuesta) {
        this.usuario_respuesta = usuario_respuesta;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

}
