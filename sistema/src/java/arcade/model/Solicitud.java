package arcade.model;

public class Solicitud {

    private int id_solicitud;
    private String solicitud;

    private String nombre;
    private String sucursal;
    private String puesto;
    private String fecha;
    private String fecha_alta;
    private String telefono;
    private String celular;
    private String jefe_inmediato;
    private String estatus;
    private int edad;
    private int mes;
    private int semana;
    private int ano;
    private String exp;
    private String contratacion;
    private String reclutador;
    private String medio;
    private int id_reclutador;
    private String especifica_medio;
    private String fecha_baja;

    public Solicitud() {

    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getJefe_inmediato() {
        return jefe_inmediato;
    }

    public void setJefe_inmediato(String jefe_inmediato) {
        this.jefe_inmediato = jefe_inmediato;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getContratacion() {
        return contratacion;
    }

    public void setContratacion(String contratacion) {
        this.contratacion = contratacion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getReclutador() {
        return reclutador;
    }

    public void setReclutador(String reclutador) {
        this.reclutador = reclutador;
    }

    public int getId_reclutador() {
        return id_reclutador;
    }

    public void setId_reclutador(int id_reclutador) {
        this.id_reclutador = id_reclutador;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getEspecifica_medio() {
        return especifica_medio;
    }

    public void setEspecifica_medio(String especifica_medio) {
        this.especifica_medio = especifica_medio;
    }

    public String getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

}
