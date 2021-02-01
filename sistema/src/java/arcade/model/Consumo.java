package arcade.model;

/* @author Luis Cortez */
public class Consumo {

    private int id_consumo;
    private String consumo; // DISPOSICION
    private String fecha;
    private String src; // ORIGEN DE LA LLAMADA
    private String numero_marcado;
    private String contexto;
    private String canal;
    private String duracion;
    private String billsec;
    private int id_tipo;
    private String tipo;
    private int minutos;
    private float costo;

    public Consumo() {
    }

    public int getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(int id_consumo) {
        this.id_consumo = id_consumo;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getNumero_marcado() {
        return numero_marcado;
    }

    public void setNumero_marcado(String numero_marcado) {
        this.numero_marcado = numero_marcado;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getBillsec() {
        return billsec;
    }

    public void setBillsec(String billsec) {
        this.billsec = billsec;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}
