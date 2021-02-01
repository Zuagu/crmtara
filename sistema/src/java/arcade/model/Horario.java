package arcade.model;

/* @author Luis Cortez */
public class Horario {

    private int id_horario;
    private int id_usuario;
    private String dia;
    private String hora_entrada;
    private String hora_salida;
    private String salida_comida;
    private String entrada_comida;
    private String horas_comida;
    private String horas_trabajadas;
    private String descripcion;
    private String turno;

    private String nombre;
    private String puesto;

    public Horario() {
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
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

    public String getHoras_comida() {
        return horas_comida;
    }

    public void setHoras_comida(String horas_comida) {
        this.horas_comida = horas_comida;
    }

    public String getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(String horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
