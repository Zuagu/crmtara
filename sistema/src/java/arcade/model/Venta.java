package arcade.model;

/* @author Luis Cortez */
public class Venta {

    private int id;
    private int id_usuario;
    private int id_cliente;
    private Float subtotal;
    private Float iva;
    private Float total;
    private String fecha;
    private int id_forma_pago;
    private int numero_parcialidades;
    private String id_metodopago;
    private int cuenta_pago;
    private int id_condicionespago;
    private int dias_credito;
    private int lugar_entrega;
    private String comentarios;

    private String usuario;
    private String cliente;
    private String forma_pago;
    private String metodo_pago;
    private String condiciones_pago;

    private int f_deleted;
    private String deleted;

    public Venta() {
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

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public int getF_deleted() {
        return f_deleted;
    }

    public void setF_deleted(int f_deleted) {
        this.f_deleted = f_deleted;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

}
