package arcade.model;

/* @author Luis Cortez */
public class Vacante {

    private int id_vacante;
    private String vacante;
    private int id_puesto;
    private int id_usuario;
    private String usuario;
    private String fecha_creacion_vacante;
    private String fecha_asignacion_usuario;
    private String sueldo;

    public Vacante() {
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public String getVacante() {
        return vacante;
    }

    public void setVacante(String vacante) {
        this.vacante = vacante;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
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

    public String getFecha_creacion_vacante() {
        return fecha_creacion_vacante;
    }

    public void setFecha_creacion_vacante(String fecha_creacion_vacante) {
        this.fecha_creacion_vacante = fecha_creacion_vacante;
    }

    public String getFecha_asignacion_usuario() {
        return fecha_asignacion_usuario;
    }

    public void setFecha_asignacion_usuario(String fecha_asignacion_usuario) {
        this.fecha_asignacion_usuario = fecha_asignacion_usuario;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

}
