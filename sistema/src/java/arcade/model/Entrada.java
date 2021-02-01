package arcade.model;

/* @author luiscortez */
public class Entrada {

    private int id_entrada;
    private String fecha;
    
    private String turno;
    private int id_usuario;
    private String usuario;
    private String sucursal;
    private String entrada;
    private String salida;
    private String total;
    private String color;
    private String salida_comida;
    private String entrada_comida;
    private String area;
    
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    private String sabado;
    private int dia_semana;
    
    
    private int dia;
    private int status_entrada;
    
    

    private int f_bono;

    public Entrada() {
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getF_bono() {
        return f_bono;
    }

    public void setF_bono(int f_bono) {
        this.f_bono = f_bono;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSalida_comida() {
        return salida_comida;
    }

    public void setSalida_comida(String salida_comida) {
        this.salida_comida = salida_comida;
    }

    public String getEntrada_comida() {
        return entrada_comida;
    }

    public void setEntrada_comida(String entrada_comida) {
        this.entrada_comida = entrada_comida;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getStatus_entrada() {
        return status_entrada;
    }

    public void setStatus_entrada(int status_entrada) {
        this.status_entrada = status_entrada;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }



}
