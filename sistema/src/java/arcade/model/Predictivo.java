package arcade.model;

/* @author Luis Cortez */
public class Predictivo {

    private int id_region;
    private int id_asignacion;
    private int id_status_cuenta;
    private String region;
    private String asignacion;
    private String dias;
    private String fecha_inicio;
    private String fecha_fin;
    private int cuentas;
    private Float a_gestionar;
    private Float importe;
    private Float resto;
    private String estatus;
    private String estado;
    private String numero;
    private String marcado;
    private String telefono;
    private String cr;
    private String nombre;

    public Predictivo() {
        
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

    public int getCuentas() {
        return cuentas;
    }

    public void setCuentas(int cuentas) {
        this.cuentas = cuentas;
    }

    public Float getA_gestionar() {
        return a_gestionar;
    }

    public void setA_gestionar(Float a_gestionar) {
        this.a_gestionar = a_gestionar;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Float getResto() {
        return resto;
    }

    public void setResto(Float resto) {
        this.resto = resto;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_status_cuenta() {
        return id_status_cuenta;
    }

    public void setId_status_cuenta(int id_status_cuenta) {
        this.id_status_cuenta = id_status_cuenta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarcado() {
        return marcado;
    }

    public void setMarcado(String marcado) {
        this.marcado = marcado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
