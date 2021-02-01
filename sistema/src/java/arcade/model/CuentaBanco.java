package arcade.model;

/* @author Luis Cortez */
public class CuentaBanco {

    private int id_cuenta;
    private int id_banco;
    private int cuenta;
    private String clabe;
    private String titular;
    private String tarjeta;
    private String tarjeta_adicional;
    private String nota;

    private String banco;

    public CuentaBanco() {
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getTarjeta_adicional() {
        return tarjeta_adicional;
    }

    public void setTarjeta_adicional(String tarjeta_adicional) {
        this.tarjeta_adicional = tarjeta_adicional;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

}
