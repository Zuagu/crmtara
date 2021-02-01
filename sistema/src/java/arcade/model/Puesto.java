package arcade.model;
 
/* @author AYCM */
public class Puesto {
 
    private int id_puesto;
    private String puesto;
    private int id_perfil;
    private String menu;
    private String pantalla_inicio;
    private String departamento;
 
    private int vacantes;
    private int vacantes_cubiertas;
    private String porcentaje;
 
    public Puesto() {
    }
 
    public int getId_puesto() {
        return id_puesto;
    }
 
    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }
 
    public String getPuesto() {
        return puesto;
    }
 
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
 
    public int getId_perfil() {
        return id_perfil;
    }
 
    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
 
    public String getMenu() {
        return menu;
    }
 
    public void setMenu(String menu) {
        this.menu = menu;
    }
 
    public String getPantalla_inicio() {
        return pantalla_inicio;
    }
 
    public void setPantalla_inicio(String pantalla_inicio) {
        this.pantalla_inicio = pantalla_inicio;
    }
 
    public String getDepartamento() {
        return departamento;
    }
 
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
 
    public int getVacantes() {
        return vacantes;
    }
 
    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }
 
    public int getVacantes_cubiertas() {
        return vacantes_cubiertas;
    }
 
    public void setVacantes_cubiertas(int vacantes_cubiertas) {
        this.vacantes_cubiertas = vacantes_cubiertas;
    }
 
    public String getPorcentaje() {
        return porcentaje;
    }
 
    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
 
}