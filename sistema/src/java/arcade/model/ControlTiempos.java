package arcade.model;

/**
 *
 * @author Administrador
 */
public class ControlTiempos {

    private int id_relacion;
    private int id_gestor;
    private int id_tipo_registro;
    private String gestor;
    private String fecha;
    private String hora;
    private String retraso_acumulado;

    public ControlTiempos() {
    }

    public int getId_tipo_registro() {
        return id_tipo_registro;
    }

    public void setId_tipo_registro(int id_tipo_registro) {
        this.id_tipo_registro = id_tipo_registro;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public int getId_relacion() {
        return id_relacion;
    }

    public void setId_relacion(int id_relacion) {
        this.id_relacion = id_relacion;
    }

    public int getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(int id_gestor) {
        this.id_gestor = id_gestor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRetraso_acumulado() {
        return retraso_acumulado;
    }

    public void setRetraso_acumulado(String retraso_acumulado) {
        this.retraso_acumulado = retraso_acumulado;
    }

}
