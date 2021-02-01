package arcade.model;

/*  @author Luis Cortez */
public class Llamada {

    private int id_llamada;
    private int id_marcacion;
    private String telefono;
    private int intentos;
    private int dnc;
    private int programada;
    private String fecha;
    private String hora;
    private String cuenta;
    private String disposicion;
    private String duracion;
    private String ultima_accion;

    public Llamada() {
    }

    public int getId_llamada() {
        return id_llamada;
    }

    public void setId_llamada(int id_llamada) {
        this.id_llamada = id_llamada;
    }

    public int getId_marcacion() {
        return id_marcacion;
    }

    public void setId_marcacion(int id_marcacion) {
        this.id_marcacion = id_marcacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getDnc() {
        return dnc;
    }

    public void setDnc(int dnc) {
        this.dnc = dnc;
    }

    public int getProgramada() {
        return programada;
    }

    public void setProgramada(int programada) {
        this.programada = programada;
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

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(String disposicion) {
        this.disposicion = disposicion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getUltima_accion() {
        return ultima_accion;
    }

    public void setUltima_accion(String ultima_accion) {
        this.ultima_accion = ultima_accion;
    }

}
