package arcade.model;
 
/* @author Luis Cortez */
public class Sucursal {
 
    private int id_sucursal;
    private String sucursal;
 
    private int id_piso;
    private int base;
    private int altura;
    private String clases;
 
    public Sucursal() {
    }
 
    public int getId_sucursal() {
        return id_sucursal;
    }
 
    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
 
    public String getSucursal() {
        return sucursal;
    }
 
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
 
    public int getId_piso() {
        return id_piso;
    }
 
    public void setId_piso(int id_piso) {
        this.id_piso = id_piso;
    }
 
    public int getBase() {
        return base;
    }
 
    public void setBase(int base) {
        this.base = base;
    }
 
    public int getAltura() {
        return altura;
    }
 
    public void setAltura(int altura) {
        this.altura = altura;
    }
 
    public String getClases() {
        return clases;
    }
 
    public void setClases(String clases) {
        this.clases = clases;
    }
 
}