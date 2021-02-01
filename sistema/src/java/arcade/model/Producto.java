package arcade.model;

/* @author Luis Cortez */
 /* @agency ARCADE Software */
public class Producto {

    private String id_producto;
    private int id_categoria;
    private String nombre;
    private String descripcion;
    private int id_unidadmedida;
    private int cantidad_minima;
    private int id_moneda;
    private int id_tasa;
    private Float precio_sin_iva;
    private Float iva;
    private Float precio;
    private int f_comprable;

    // VALORES GENERADOS
    private String moneda;
    private String categoria;
    private String unidadmedida;
    private String tasa;
    // VALORES GENERADOS

    // VALORES CORTE LASER
    private String calibre;
    private Float perimetro;
    private Float area;
    private Float tiempo;
    private Float peso;
    private int inicios;

    // linea ot laser
    private int id_linea;
    private int cantidad;
    private int cantidad_buenas;
    private int cantidad_scrap;
    private int cantidad_devueltas;
    private int cantidad_recibidas_flete;
    private int cantidad_recibidas;

    public Producto() {
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_unidadmedida() {
        return id_unidadmedida;
    }

    public void setId_unidadmedida(int id_unidadmedida) {
        this.id_unidadmedida = id_unidadmedida;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public int getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(int id_moneda) {
        this.id_moneda = id_moneda;
    }

    public int getId_tasa() {
        return id_tasa;
    }

    public void setId_tasa(int id_tasa) {
        this.id_tasa = id_tasa;
    }

    public Float getPrecio_sin_iva() {
        return precio_sin_iva;
    }

    public void setPrecio_sin_iva(Float precio_sin_iva) {
        this.precio_sin_iva = precio_sin_iva;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getF_comprable() {
        return f_comprable;
    }

    public void setF_comprable(int f_comprable) {
        this.f_comprable = f_comprable;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public Float getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(Float perimetro) {
        this.perimetro = perimetro;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getTiempo() {
        return tiempo;
    }

    public void setTiempo(Float tiempo) {
        this.tiempo = tiempo;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public int getInicios() {
        return inicios;
    }

    public void setInicios(int inicios) {
        this.inicios = inicios;
    }

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad_buenas() {
        return cantidad_buenas;
    }

    public void setCantidad_buenas(int cantidad_buenas) {
        this.cantidad_buenas = cantidad_buenas;
    }

    public int getCantidad_scrap() {
        return cantidad_scrap;
    }

    public void setCantidad_scrap(int cantidad_scrap) {
        this.cantidad_scrap = cantidad_scrap;
    }

    public int getCantidad_devueltas() {
        return cantidad_devueltas;
    }

    public void setCantidad_devueltas(int cantidad_devueltas) {
        this.cantidad_devueltas = cantidad_devueltas;
    }

    public int getCantidad_recibidas_flete() {
        return cantidad_recibidas_flete;
    }

    public void setCantidad_recibidas_flete(int cantidad_recibidas_flete) {
        this.cantidad_recibidas_flete = cantidad_recibidas_flete;
    }

    public int getCantidad_recibidas() {
        return cantidad_recibidas;
    }

    public void setCantidad_recibidas(int cantidad_recibidas) {
        this.cantidad_recibidas = cantidad_recibidas;
    }

}
