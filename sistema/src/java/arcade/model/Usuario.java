package arcade.model;

/* @author ARCADE Software Group® */
public class Usuario {

    private int id;
    private int id_sucursal;
    private String password0;
    private String nombre;
    private int id_puesto;
    private String fecha_alta;

    private String sexo;
    private String telefono;
    private String celular;
    private String email;

    private int id_jefe_inmediato;

    private int f_active;

    private String sucursal;
    private String puesto;
    private String jefe_inmediato;
    private String active;

    private String fecha;
    private String hora;
    private String salida;

    private String res_titulo;
    private String res_valor;
    private String res_imagen;

    private int id_registro;
    private String horas;
    
    // variable para reporte de entradas individual
    private int dia_fech;
    private int dia_sem;
    private int dia;
    private String hora_entrada;
    private String hora_llegada;
    private String mes;
    private String color;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getPassword0() {
        return password0;
    }

    public void setPassword0(String password0) {
        this.password0 = password0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_jefe_inmediato() {
        return id_jefe_inmediato;
    }

    public void setId_jefe_inmediato(int id_jefe_inmediato) {
        this.id_jefe_inmediato = id_jefe_inmediato;
    }

    public int getF_active() {
        return f_active;
    }

    public void setF_active(int f_active) {
        this.f_active = f_active;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getJefe_inmediato() {
        return jefe_inmediato;
    }

    public void setJefe_inmediato(String jefe_inmediato) {
        this.jefe_inmediato = jefe_inmediato;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getRes_titulo() {
        return res_titulo;
    }

    public void setRes_titulo(String res_titulo) {
        this.res_titulo = res_titulo;
    }

    public String getRes_valor() {
        return res_valor;
    }

    public void setRes_valor(String res_valor) {
        this.res_valor = res_valor;
    }

    public String getRes_imagen() {
        return res_imagen;
    }

    public void setRes_imagen(String res_imagen) {
        this.res_imagen = res_imagen;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public int getDia_fech() {
        return dia_fech;
    }

    public void setDia_fech(int dia_fech) {
        this.dia_fech = dia_fech;
    }

    public int getDia_sem() {
        return dia_sem;
    }

    public void setDia_sem(int dia_sem) {
        this.dia_sem = dia_sem;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
