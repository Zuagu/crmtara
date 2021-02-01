package arcade.model;

/**
 * @author Luis Cortez
 */
public class Inbound {

    private String fecha;
    private String hora;
    private String src;
    private String dst;
    private int billsec;
    private String disposition;
    private String did;

    public Inbound() {
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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public int getBillsec() {
        return billsec;
    }

    public void setBillsec(int billsec) {
        this.billsec = billsec;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

}
