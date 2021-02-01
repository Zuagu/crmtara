package arcade.model;

/* @author Luis Cortez - ARCADE Software Group */
public class Marcacion {

    private int id_marcacion;
    private int llamadas;
    private String marcacion; // Elastixs maxlenght 64 caracteres
    private String fecha_inicio;
    private String hora_inicio;
    private String fecha_fin;
    private String hora_fin;
    private int intentos;
    private String trunk;
    private String context;
    private String queue;
    private String max_canales;
    private String num_completadas;
    private String promedio;
    private String desviacion;
    private String script;
    private String estatus;
    private int id_url;

    // IDENTIFICACION DE NUMEROS
    private int id;
    private String numero;
    private String tipo;
    private String empresa;
    private String columna1;
    private String columna2;
    private String columna3;
    private String columna4;
    private String columna5;
    private String columna6;

    public Marcacion() {
    }

    public int getId_marcacion() {
        return id_marcacion;
    }

    public void setId_marcacion(int id_marcacion) {
        this.id_marcacion = id_marcacion;
    }

    public String getMarcacion() {
        return marcacion;
    }

    public int getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(int llamadas) {
        this.llamadas = llamadas;
    }

    public void setMarcacion(String marcacion) {
        this.marcacion = marcacion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String getTrunk() {
        return trunk;
    }

    public void setTrunk(String trunk) {
        this.trunk = trunk;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getMax_canales() {
        return max_canales;
    }

    public void setMax_canales(String max_canales) {
        this.max_canales = max_canales;
    }

    public String getNum_completadas() {
        return num_completadas;
    }

    public void setNum_completadas(String num_completadas) {
        this.num_completadas = num_completadas;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getDesviacion() {
        return desviacion;
    }

    public void setDesviacion(String desviacion) {
        this.desviacion = desviacion;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getId_url() {
        return id_url;
    }

    public void setId_url(int id_url) {
        this.id_url = id_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getColumna1() {
        return columna1;
    }

    public void setColumna1(String columna1) {
        this.columna1 = columna1;
    }

    public String getColumna2() {
        return columna2;
    }

    public void setColumna2(String columna2) {
        this.columna2 = columna2;
    }

    public String getColumna3() {
        return columna3;
    }

    public void setColumna3(String columna3) {
        this.columna3 = columna3;
    }

    public String getColumna4() {
        return columna4;
    }

    public void setColumna4(String columna4) {
        this.columna4 = columna4;
    }

    public String getColumna5() {
        return columna5;
    }

    public void setColumna5(String columna5) {
        this.columna5 = columna5;
    }

    public String getColumna6() {
        return columna6;
    }

    public void setColumna6(String columna6) {
        this.columna6 = columna6;
    }

}
