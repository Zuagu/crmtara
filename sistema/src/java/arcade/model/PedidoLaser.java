package arcade.model;

/* @author Luis Cortez */
public class PedidoLaser {

    private int id_pedido;
    private int id_cliente;
    private String fecha_registro;
    private String porcentaje_avance;
    private String fecha_inicio_corte;
    private String fecha_fin_corte;

    private String cliente;
    private int id_requisicion;

    public PedidoLaser() {
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getPorcentaje_avance() {
        return porcentaje_avance;
    }

    public void setPorcentaje_avance(String porcentaje_avance) {
        this.porcentaje_avance = porcentaje_avance;
    }

    public String getFecha_inicio_corte() {
        return fecha_inicio_corte;
    }

    public void setFecha_inicio_corte(String fecha_inicio_corte) {
        this.fecha_inicio_corte = fecha_inicio_corte;
    }

    public String getFecha_fin_corte() {
        return fecha_fin_corte;
    }

    public void setFecha_fin_corte(String fecha_fin_corte) {
        this.fecha_fin_corte = fecha_fin_corte;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId_requisicion() {
        return id_requisicion;
    }

    public void setId_requisicion(int id_requisicion) {
        this.id_requisicion = id_requisicion;
    }

}
