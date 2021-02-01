package arcade.model;

public class CargarArchivo {
    
    private String nombre; 
    private int id_archivo;
    private String nombre_usuario;
    private String fecha;

    public int getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(int id_archivo) {
        this.id_archivo = id_archivo;
    }

    public CargarArchivo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
