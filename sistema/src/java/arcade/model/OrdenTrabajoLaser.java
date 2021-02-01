package arcade.model;

/* @author Administrator */
public class OrdenTrabajoLaser {

    private int id_ot;
    private int id_cliente;
    private String fecha_registro;
    private int piezas_totales;
    private String porcentaje_avance;
    private String fecha_inicio;
    private String fecha_fin;

    private int piezas_buenas;
    private int piezas_malas;

    public OrdenTrabajoLaser() {
    }

    public int getId_ot() {
        return id_ot;
    }

    public void setId_ot(int id_ot) {
        this.id_ot = id_ot;
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

    public int getPiezas_totales() {
        return piezas_totales;
    }

    public void setPiezas_totales(int piezas_totales) {
        this.piezas_totales = piezas_totales;
    }

    public String getPorcentaje_avance() {
        return porcentaje_avance;
    }

    public void setPorcentaje_avance(String porcentaje_avance) {
        this.porcentaje_avance = porcentaje_avance;
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

    public int getPiezas_buenas() {
        return piezas_buenas;
    }

    public void setPiezas_buenas(int piezas_buenas) {
        this.piezas_buenas = piezas_buenas;
    }

    public int getPiezas_malas() {
        return piezas_malas;
    }

    public void setPiezas_malas(int piezas_malas) {
        this.piezas_malas = piezas_malas;
    }

}
