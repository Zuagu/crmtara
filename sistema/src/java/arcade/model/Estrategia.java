package arcade.model;

/* @author Luis Cortez */
public class Estrategia {

    private int id_estrategia;
    private String estrategia;
    private String funcion;
    private String descripcion;
    private int id_usuario;
    private int desarrollo;
    private int id_puesto;
    private String codigo;
    private int f_active;

    private String usuario;
    private String puesto;
    private String active;

    public Estrategia() {
    }

    public int getId_estrategia() {
        return id_estrategia;
    }

    public void setId_estrategia(int id_estrategia) {
        this.id_estrategia = id_estrategia;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(int desarrollo) {
        this.desarrollo = desarrollo;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getF_active() {
        return f_active;
    }

    public void setF_active(int f_active) {
        this.f_active = f_active;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

}
