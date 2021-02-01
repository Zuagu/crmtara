package arcade.model;

/* @author Luis Cortez */
public class Nota {

    private int id_nota;
    private int id_usuario;
    private String usuario;
    private int id_equipo;
    private String equipo;
    private String nota;
    private String f_deleted;
    private String f_insert;

    private String fecha;
    private String hora;

    public Nota() {
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getF_deleted() {
        return f_deleted;
    }

    public void setF_deleted(String f_deleted) {
        this.f_deleted = f_deleted;
    }

    public String getF_insert() {
        return f_insert;
    }

    public void setF_insert(String f_insert) {
        this.f_insert = f_insert;
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

}
