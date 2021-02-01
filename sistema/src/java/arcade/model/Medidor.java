package arcade.model;

/* @author Luis Cortez */
public class Medidor {

    private int id_medidor;
    private int id_puesto;
    private String medidor; // 45
    private String descripcion; // 255

    public Medidor() {
    }

    public int getId_medidor() {
        return id_medidor;
    }

    public void setId_medidor(int id_medidor) {
        this.id_medidor = id_medidor;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getMedidor() {
        return medidor;
    }

    public void setMedidor(String medidor) {
        this.medidor = medidor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
