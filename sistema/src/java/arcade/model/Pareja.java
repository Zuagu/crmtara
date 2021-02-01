package arcade.model;

/**
 * @author AYCM
 */
public class Pareja {

    private int id_registro;
    private int id_pareja;
    private String nombre_pareja;
    private int id_gestor;
    private int id_region;
    private String region;

    public Pareja() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_pareja() {
        return id_pareja;
    }

    public void setId_pareja(int id_pareja) {
        this.id_pareja = id_pareja;
    }

    public int getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(int id_gestor) {
        this.id_gestor = id_gestor;
    }

    public String getNombre_pareja() {
        return nombre_pareja;
    }

    public void setNombre_pareja(String nombre_pareja) {
        this.nombre_pareja = nombre_pareja;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
