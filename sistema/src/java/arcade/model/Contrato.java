package arcade.model;

/* @author Luis Cortez */
public class Contrato {

    private int id_contrato;
    private int id_usuario;
    private String fecha_inicio;
    private String fecha_fin;
    private String salario_diario;
    private int horas_semana;
    private String tipo_contrato;
    private int f_estatus;

    private String usuario;
    private String terminado;
    private String id_puesto;
    private String estatus;

    public Contrato() {
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public int getF_estatus() {
        return f_estatus;
    }

    public void setF_estatus(int f_estatus) {
        this.f_estatus = f_estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getSalario_diario() {
        return salario_diario;
    }

    public void setSalario_diario(String salario_diario) {
        this.salario_diario = salario_diario;
    }

    public int getHoras_semana() {
        return horas_semana;
    }

    public void setHoras_semana(int horas_semana) {
        this.horas_semana = horas_semana;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTerminado() {
        return terminado;
    }

    public void setTerminado(String terminado) {
        this.terminado = terminado;
    }

    public String getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(String id_puesto) {
        this.id_puesto = id_puesto;
    }

}