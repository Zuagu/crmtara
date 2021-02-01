package arcade.model;

/* @author AYCM */
public class Agenda {

    private int id_agenda;
    private String agenda;
    private int id_usuario;
    private int id_equipo;
    private String equipo;
    private int id_gestor;
    private String gestor;
    private String cuenta;
    private String fecha;
    private String hora;
    private int f_visto;
    private String visto;
    private int f_pasada;

    public Agenda() {
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(int id_gestor) {
        this.id_gestor = id_gestor;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
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

    public int getF_visto() {
        return f_visto;
    }

    public void setF_visto(int f_visto) {
        this.f_visto = f_visto;
    }

    public String getVisto() {
        return visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
    }

    public int getF_pasada() {
        return f_pasada;
    }

    public void setF_pasada(int f_pasada) {
        this.f_pasada = f_pasada;
    }

}
