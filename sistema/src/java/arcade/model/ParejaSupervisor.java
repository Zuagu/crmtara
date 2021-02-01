package arcade.model;

/**
 * @author AYCM
 */
public class ParejaSupervisor {

    private int id_registro;
    private String registro;
    private int id_pareja;
    private String pareja;
    private int id_supervisor;
    private String supervisor;
    private String asignacion;
    private int id_region;
    private String region;
    private Float importe_asignado;

    public ParejaSupervisor() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public int getId_pareja() {
        return id_pareja;
    }

    public void setId_pareja(int id_pareja) {
        this.id_pareja = id_pareja;
    }

    public String getPareja() {
        return pareja;
    }

    public void setPareja(String pareja) {
        this.pareja = pareja;
    }

    public int getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(int id_supervisor) {
        this.id_supervisor = id_supervisor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
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

    public Float getImporte_asignado() {
        return importe_asignado;
    }

    public void setImporte_asignado(Float importe_asignado) {
        this.importe_asignado = importe_asignado;
    }

}
