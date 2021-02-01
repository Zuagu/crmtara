package arcade.model;

/* @author Luis Cortez */
public class OrdenDeCompra {

    private int id;
    private int id_usuario;
    private int id_proveedor;
    private int id_requisicion;
    private String subtotal;
    private String iva;
    private String total;
    private String fecha;
    private int id_forma_pago;
    private int numero_parcialidades;
    private String id_metodopago;
    private int cuenta_pago;
    private int id_condicionespago;
    private int dias_credito;
    private int lugar_entrega;
    private String comentarios;
    private String estatus;
    private String autorizado_por;

    private String usuario;
    private String proveedor;
    private String forma_pago;
    private String metodo_pago;
    private String condiciones_pago;

    private String factura;
    private String fecha_factura;
    private String vencimiento;
    private String abonos;
    private String saldo;

    public OrdenDeCompra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_requisicion() {
        return id_requisicion;
    }

    public void setId_requisicion(int id_requisicion) {
        this.id_requisicion = id_requisicion;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_forma_pago() {
        return id_forma_pago;
    }

    public void setId_forma_pago(int id_forma_pago) {
        this.id_forma_pago = id_forma_pago;
    }

    public int getNumero_parcialidades() {
        return numero_parcialidades;
    }

    public void setNumero_parcialidades(int numero_parcialidades) {
        this.numero_parcialidades = numero_parcialidades;
    }

    public String getId_metodopago() {
        return id_metodopago;
    }

    public void setId_metodopago(String id_metodopago) {
        this.id_metodopago = id_metodopago;
    }

    public int getCuenta_pago() {
        return cuenta_pago;
    }

    public void setCuenta_pago(int cuenta_pago) {
        this.cuenta_pago = cuenta_pago;
    }

    public int getId_condicionespago() {
        return id_condicionespago;
    }

    public void setId_condicionespago(int id_condicionespago) {
        this.id_condicionespago = id_condicionespago;
    }

    public int getDias_credito() {
        return dias_credito;
    }

    public void setDias_credito(int dias_credito) {
        this.dias_credito = dias_credito;
    }

    public int getLugar_entrega() {
        return lugar_entrega;
    }

    public void setLugar_entrega(int lugar_entrega) {
        this.lugar_entrega = lugar_entrega;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getAutorizado_por() {
        return autorizado_por;
    }

    public void setAutorizado_por(String autorizado_por) {
        this.autorizado_por = autorizado_por;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getCondiciones_pago() {
        return condiciones_pago;
    }

    public void setCondiciones_pago(String condiciones_pago) {
        this.condiciones_pago = condiciones_pago;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getAbonos() {
        return abonos;
    }

    public void setAbonos(String abonos) {
        this.abonos = abonos;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

}
