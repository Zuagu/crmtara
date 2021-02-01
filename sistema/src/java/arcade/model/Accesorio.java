package arcade.model;

/* @author Luis Cortez */
public class Accesorio {

    private int id_accesorio;
    private String accesorio;
    private int id_padre;
    private int id_estatus;
    private String estatus;
    private String nota;
    private String fecha_insert;
    private int f_deleted;

    public Accesorio() {
    }

    public int getId_accesorio() {
        return id_accesorio;
    }

    public void setId_accesorio(int id_accesorio) {
        this.id_accesorio = id_accesorio;
    }

    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getId_estatus() {
        return id_estatus;
    }

    public void setId_estatus(int id_estatus) {
        this.id_estatus = id_estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFecha_insert() {
        return fecha_insert;
    }

    public void setFecha_insert(String fecha_insert) {
        this.fecha_insert = fecha_insert;
    }

    public int getF_deleted() {
        return f_deleted;
    }

    public void setF_deleted(int f_deleted) {
        this.f_deleted = f_deleted;
    }

}
