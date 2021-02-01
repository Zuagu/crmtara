package arcade.model;

/* @author Luis Cortez */
public class PagoProveedor {

    private int folio;
    private int id_proveedor;
    private int id_oc;
    private int id_registrante;
    private Float importe;
    private String fecha;
    private String id_metodopago;
    private int id_cuenta;
    private int id_banco_destino;
    private int id_cuenta_destino;
    private String comentarios;
    private int f_deleted;
    private int id_usuario_deleted;
    private String fecha_deleted;

    private String registrante;
    private String metodopago;
    private String cuenta;
    private String usuario_deleted;

    private String banco;
    private String banco_destino;
    private String proveedor;

    public PagoProveedor() {
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_oc() {
        return id_oc;
    }

    public void setId_oc(int id_oc) {
        this.id_oc = id_oc;
    }

    public int getId_registrante() {
        return id_registrante;
    }

    public void setId_registrante(int id_registrante) {
        this.id_registrante = id_registrante;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId_metodopago() {
        return id_metodopago;
    }

    public void setId_metodopago(String id_metodopago) {
        this.id_metodopago = id_metodopago;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getF_deleted() {
        return f_deleted;
    }

    public void setF_deleted(int f_deleted) {
        this.f_deleted = f_deleted;
    }

    public int getId_usuario_deleted() {
        return id_usuario_deleted;
    }

    public void setId_usuario_deleted(int id_usuario_deleted) {
        this.id_usuario_deleted = id_usuario_deleted;
    }

    public String getFecha_deleted() {
        return fecha_deleted;
    }

    public void setFecha_deleted(String fecha_deleted) {
        this.fecha_deleted = fecha_deleted;
    }

    public String getRegistrante() {
        return registrante;
    }

    public void setRegistrante(String registrante) {
        this.registrante = registrante;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getId_banco_destino() {
        return id_banco_destino;
    }

    public void setId_banco_destino(int id_banco_destino) {
        this.id_banco_destino = id_banco_destino;
    }

    public int getId_cuenta_destino() {
        return id_cuenta_destino;
    }

    public void setId_cuenta_destino(int id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }

    public String getUsuario_deleted() {
        return usuario_deleted;
    }

    public void setUsuario_deleted(String usuario_deleted) {
        this.usuario_deleted = usuario_deleted;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getBanco_destino() {
        return banco_destino;
    }

    public void setBanco_destino(String banco_destino) {
        this.banco_destino = banco_destino;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

}
