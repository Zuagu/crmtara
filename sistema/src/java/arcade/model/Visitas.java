package arcade.model;

/**
* @author programador_BackEnd
*/
public class Visitas {
    /* Variables generales*/
    private int id_cuenta;
    private String cuenta;
    private String datos;
    private String id_visitador;
    /* Variables para filtro de segundo carteo */
    private int id_asignacion;
    private String region;
    private String asignacion;
    private String ciudades;
    private String colonias;
    private String cp;
    private String lada;
    private String resto;
    private String visita;
    private String id_status;
    private String status;
    

    public Visitas() {
        
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getId_visitador() {
        return id_visitador;
    }

    public void setId_visitador(String id_visitador) {
        this.id_visitador = id_visitador;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public String getCiudades() {
        return ciudades;
    }

    public void setCiudades(String ciudades) {
        this.ciudades = ciudades;
    }

    public String getColonias() {
        return colonias;
    }

    public void setColonias(String colonias) {
        this.colonias = colonias;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLada() {
        return lada;
    }

    public void setLada(String lada) {
        this.lada = lada;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getResto() {
        return resto;
    }

    public void setResto(String resto) {
        this.resto = resto;
    }

    public String getVisita() {
        return visita;
    }

    public void setVisita(String visita) {
        this.visita = visita;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
