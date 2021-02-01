package arcade.model;

/* @author Luis Cortez */
public class Blaster {

    private int id_blaster;
    private String blaster;
    private int por_marcar;
    private int numeros;
    private int contestadas;
    private int no_contestadas;
    private String hora_contesta;

    private String primer_llamada;
    private String ultima_llamada;

    private int id_padre; // Se origina este blaster a raiz de otro llamado padre
    private int f_resultado; // Se origina este blaster a raiz de otro llamado padre
    private String porcentaje_contacto;

    public Blaster() {
    }

    public int getId_blaster() {
        return id_blaster;
    }

    public void setId_blaster(int id_blaster) {
        this.id_blaster = id_blaster;
    }

    public String getBlaster() {
        return blaster;
    }

    public void setBlaster(String blaster) {
        this.blaster = blaster;
    }

    public int getPor_marcar() {
        return por_marcar;
    }

    public void setPor_marcar(int por_marcar) {
        this.por_marcar = por_marcar;
    }

    public int getNumeros() {
        return numeros;
    }

    public void setNumeros(int numeros) {
        this.numeros = numeros;
    }

    public int getContestadas() {
        return contestadas;
    }

    public void setContestadas(int contestadas) {
        this.contestadas = contestadas;
    }

    public int getNo_contestadas() {
        return no_contestadas;
    }

    public void setNo_contestadas(int no_contestadas) {
        this.no_contestadas = no_contestadas;
    }

    public String getHora_contesta() {
        return hora_contesta;
    }

    public void setHora_contesta(String hora_contesta) {
        this.hora_contesta = hora_contesta;
    }

    public String getPrimer_llamada() {
        return primer_llamada;
    }

    public void setPrimer_llamada(String primer_llamada) {
        this.primer_llamada = primer_llamada;
    }

    public String getUltima_llamada() {
        return ultima_llamada;
    }

    public void setUltima_llamada(String ultima_llamada) {
        this.ultima_llamada = ultima_llamada;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getF_resultado() {
        return f_resultado;
    }

    public void setF_resultado(int f_resultado) {
        this.f_resultado = f_resultado;
    }

    public String getPorcentaje_contacto() {
        return porcentaje_contacto;
    }

    public void setPorcentaje_contacto(String porcentaje_contacto) {
        this.porcentaje_contacto = porcentaje_contacto;
    }

}
