package arcade.model;

/* @author Arcade Ssoftware */
public class MetricasOperativas {

    private int id_region;
    private String fecha_inicio;
    private String fecha_fin;

    // CALL OUTBOUND
    private int intentos;
    private int contactos;
    private String radio_contactibilidad;
    private String cpc;
    private String radio_cpc;
    private int promesas;
    private String radio_promesas;
    private int promesas_cumplidas;
    private String radio_promesas_cumplidas;

    // IVR
    private int intentos_ivr;
    private int contactos_ivr;
    private String porcen_contactos_ivr;

    // CARTAS
    private int enviadas;
    private int entregadas;
    private String porcen_entregadas;

    // VISITAS REALIZADAS
    private int visitas_realizadas;
    private int visitas_exitosas;
    private String porcen_exitosas;

    // CALL INBOUND
    private int call_recibidas;
    private int call_no_atendidas;
    private String porcen_abandono;

    // SMS
    private int sms_eviados;

    // CORREOS ELCTRONICOS
    private int correos_enviados;

    //ESTADISTICA DE LLAMS EN GENERAL
    private String tiempo_medio_operacion;
    private String tiempo_medio_espera;
    private int contacto_posision;
    private int posision_atencion;
    private String disponibilidad;
    private String ocupacion;
    private String ausentismo;
    private String rotacion;

    public MetricasOperativas() {
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
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

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getContactos() {
        return contactos;
    }

    public void setContactos(int contactos) {
        this.contactos = contactos;
    }

    public String getRadio_contactibilidad() {
        return radio_contactibilidad;
    }

    public void setRadio_contactibilidad(String radio_contactibilidad) {
        this.radio_contactibilidad = radio_contactibilidad;
    }

    public String getCpc() {
        return cpc;
    }

    public void setCpc(String cpc) {
        this.cpc = cpc;
    }

    public String getRadio_cpc() {
        return radio_cpc;
    }

    public void setRadio_cpc(String radio_cpc) {
        this.radio_cpc = radio_cpc;
    }

    public int getPromesas() {
        return promesas;
    }

    public void setPromesas(int promesas) {
        this.promesas = promesas;
    }

    public String getRadio_promesas() {
        return radio_promesas;
    }

    public void setRadio_promesas(String radio_promesas) {
        this.radio_promesas = radio_promesas;
    }

    public int getPromesas_cumplidas() {
        return promesas_cumplidas;
    }

    public void setPromesas_cumplidas(int promesas_cumplidas) {
        this.promesas_cumplidas = promesas_cumplidas;
    }

    public String getRadio_promesas_cumplidas() {
        return radio_promesas_cumplidas;
    }

    public void setRadio_promesas_cumplidas(String radio_promesas_cumplidas) {
        this.radio_promesas_cumplidas = radio_promesas_cumplidas;
    }

    public int getIntentos_ivr() {
        return intentos_ivr;
    }

    public void setIntentos_ivr(int intentos_ivr) {
        this.intentos_ivr = intentos_ivr;
    }

    public int getContactos_ivr() {
        return contactos_ivr;
    }

    public void setContactos_ivr(int contactos_ivr) {
        this.contactos_ivr = contactos_ivr;
    }

    public String getPorcen_contactos_ivr() {
        return porcen_contactos_ivr;
    }

    public void setPorcen_contactos_ivr(String porcen_contactos_ivr) {
        this.porcen_contactos_ivr = porcen_contactos_ivr;
    }

    public int getEnviadas() {
        return enviadas;
    }

    public void setEnviadas(int enviadas) {
        this.enviadas = enviadas;
    }

    public int getEntregadas() {
        return entregadas;
    }

    public void setEntregadas(int entregadas) {
        this.entregadas = entregadas;
    }

    public String getPorcen_entregadas() {
        return porcen_entregadas;
    }

    public void setPorcen_entregadas(String porcen_entregadas) {
        this.porcen_entregadas = porcen_entregadas;
    }

    public int getVisitas_realizadas() {
        return visitas_realizadas;
    }

    public void setVisitas_realizadas(int visitas_realizadas) {
        this.visitas_realizadas = visitas_realizadas;
    }

    public int getVisitas_exitosas() {
        return visitas_exitosas;
    }

    public void setVisitas_exitosas(int visitas_exitosas) {
        this.visitas_exitosas = visitas_exitosas;
    }

    public String getPorcen_exitosas() {
        return porcen_exitosas;
    }

    public void setPorcen_exitosas(String porcen_exitosas) {
        this.porcen_exitosas = porcen_exitosas;
    }

    public int getCall_recibidas() {
        return call_recibidas;
    }

    public void setCall_recibidas(int call_recibidas) {
        this.call_recibidas = call_recibidas;
    }

    public int getCall_no_atendidas() {
        return call_no_atendidas;
    }

    public void setCall_no_atendidas(int call_no_atendidas) {
        this.call_no_atendidas = call_no_atendidas;
    }

    public String getPorcen_abandono() {
        return porcen_abandono;
    }

    public void setPorcen_abandono(String porcen_abandono) {
        this.porcen_abandono = porcen_abandono;
    }

    public int getSms_eviados() {
        return sms_eviados;
    }

    public void setSms_eviados(int sms_eviados) {
        this.sms_eviados = sms_eviados;
    }

    public int getCorreos_enviados() {
        return correos_enviados;
    }

    public void setCorreos_enviados(int correos_enviados) {
        this.correos_enviados = correos_enviados;
    }

    public String getTiempo_medio_operacion() {
        return tiempo_medio_operacion;
    }

    public void setTiempo_medio_operacion(String tiempo_medio_operacion) {
        this.tiempo_medio_operacion = tiempo_medio_operacion;
    }

    public String getTiempo_medio_espera() {
        return tiempo_medio_espera;
    }

    public void setTiempo_medio_espera(String tiempo_medio_espera) {
        this.tiempo_medio_espera = tiempo_medio_espera;
    }

    public int getContacto_posision() {
        return contacto_posision;
    }

    public void setContacto_posision(int contacto_posision) {
        this.contacto_posision = contacto_posision;
    }

    public int getPosision_atencion() {
        return posision_atencion;
    }

    public void setPosision_atencion(int posision_atencion) {
        this.posision_atencion = posision_atencion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getAusentismo() {
        return ausentismo;
    }

    public void setAusentismo(String ausentismo) {
        this.ausentismo = ausentismo;
    }

    public String getRotacion() {
        return rotacion;
    }

    public void setRotacion(String rotacion) {
        this.rotacion = rotacion;
    }

}
