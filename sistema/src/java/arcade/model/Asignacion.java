package arcade.model;

/* @author Luis Cortez */
public class Asignacion extends AsignacionOriginal {

    // DATOS DE LA TABLA SQL
    private int id_asignacion;
    private String asignacion;
    private int id_cliente;
    private int id_region;
    private int id_administrador;
    private int id_gerente;
    private int id_supervisor;
    private String fecha_inicio;
    private String fecha_fin;
    private int dias_anticipados;
    private int dias_transcurridos;
    private String meta;
    private int f_active;

    // DATOS A GENERAR
    private int cuentas;
    private int id_equipo;
    private String equipo;
    private String importe_asignado;
    private Float importe_asignado_x;
    private String pagos_anticipados;
    private String ajustes;
    private String a_gestionar;
    private String pagos;
    private String recuperado;
    private Float recuperado_x;
    private String porcentaje;
    private String porcentaje_debido;
    private String diferencia_porcentual;
    private String costo_gestion;
    private String utilidad_gestion;

    private String cliente;
    private String region;
    private String administrador;
    private String gerente;
    private String supervisor;

    private String etapa_cobraza; // APERTURA, PRECIERRE, CIERRE

    private String ultima_gestion;
    private String ultima_gestion_fecha;
    private String ultima_gestion_hora;
    private String ultimo_estatus_cuenta;
    private String ultimo_estatus_llamada;
    private String cuenta;
    private String resto;

    //ASIGNACION DE CARTERA
    private String tipo_mora;
    private String zona;
    private String tipo_plan;

    // CHARGEBACK
    private int id_estatus_llamada;
    private int ciclo;
    private String estatus_original;
    private int id_usuario;
    private String usuario;
    private String penalizacion;
    private String cancelacion;

    private String lada;
    private String nombre;
    private String expediente;
    private String ciudad;
    private String colonia;
    private String calle;
    private String numero;
    private String cuentas_multiples;
    private String importe_cuentas_multiples;
    private String tiene_cr;

    // PARA REFERENCIAS
    private int id_cuenta;
    private String dato_original;
    private String referencia1;
    private String tel_referencia1;
    private String tt_ref1;
    private String referencia2;
    private String tel_referencia2;
    private String tt_ref2;
    private String referencia3;
    private String tel_referencia3;
    private String tt_ref3;
    private String referencia4;
    private String tel_referencia4;
    private String tt_ref4;

    private String tel1;
    private String tel2;
    private String tel3;
    private String correo;
    private String estado;
    private String cp;

    public Asignacion() {
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public int getId_gerente() {
        return id_gerente;
    }

    public void setId_gerente(int id_gerente) {
        this.id_gerente = id_gerente;
    }

    public int getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(int id_supervisor) {
        this.id_supervisor = id_supervisor;
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

    public int getDias_anticipados() {
        return dias_anticipados;
    }

    public void setDias_anticipados(int dias_anticipados) {
        this.dias_anticipados = dias_anticipados;
    }

    public int getDias_transcurridos() {
        return dias_transcurridos;
    }

    public void setDias_transcurridos(int dias_transcurridos) {
        this.dias_transcurridos = dias_transcurridos;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public int getF_active() {
        return f_active;
    }

    public void setF_active(int f_active) {
        this.f_active = f_active;
    }

    public int getCuentas() {
        return cuentas;
    }

    public void setCuentas(int cuentas) {
        this.cuentas = cuentas;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getImporte_asignado() {
        return importe_asignado;
    }

    public void setImporte_asignado(String importe_asignado) {
        this.importe_asignado = importe_asignado;
    }

    public Float getImporte_asignado_x() {
        return importe_asignado_x;
    }

    public void setImporte_asignado_x(Float importe_asignado_x) {
        this.importe_asignado_x = importe_asignado_x;
    }

    public String getPagos_anticipados() {
        return pagos_anticipados;
    }

    public void setPagos_anticipados(String pagos_anticipados) {
        this.pagos_anticipados = pagos_anticipados;
    }

    public String getAjustes() {
        return ajustes;
    }

    public void setAjustes(String ajustes) {
        this.ajustes = ajustes;
    }

    public String getA_gestionar() {
        return a_gestionar;
    }

    public void setA_gestionar(String a_gestionar) {
        this.a_gestionar = a_gestionar;
    }

    public String getPagos() {
        return pagos;
    }

    public void setPagos(String pagos) {
        this.pagos = pagos;
    }

    public String getRecuperado() {
        return recuperado;
    }

    public void setRecuperado(String recuperado) {
        this.recuperado = recuperado;
    }

    public Float getRecuperado_x() {
        return recuperado_x;
    }

    public void setRecuperado_x(Float recuperado_x) {
        this.recuperado_x = recuperado_x;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPorcentaje_debido() {
        return porcentaje_debido;
    }

    public void setPorcentaje_debido(String porcentaje_debido) {
        this.porcentaje_debido = porcentaje_debido;
    }

    public String getDiferencia_porcentual() {
        return diferencia_porcentual;
    }

    public void setDiferencia_porcentual(String diferencia_porcentual) {
        this.diferencia_porcentual = diferencia_porcentual;
    }

    public String getCosto_gestion() {
        return costo_gestion;
    }

    public void setCosto_gestion(String costo_gestion) {
        this.costo_gestion = costo_gestion;
    }

    public String getUtilidad_gestion() {
        return utilidad_gestion;
    }

    public void setUtilidad_gestion(String utilidad_gestion) {
        this.utilidad_gestion = utilidad_gestion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getEtapa_cobraza() {
        return etapa_cobraza;
    }

    public void setEtapa_cobraza(String etapa_cobraza) {
        this.etapa_cobraza = etapa_cobraza;
    }

    public String getUltima_gestion() {
        return ultima_gestion;
    }

    public void setUltima_gestion(String ultima_gestion) {
        this.ultima_gestion = ultima_gestion;
    }

    public String getUltima_gestion_fecha() {
        return ultima_gestion_fecha;
    }

    public void setUltima_gestion_fecha(String ultima_gestion_fecha) {
        this.ultima_gestion_fecha = ultima_gestion_fecha;
    }

    public String getUltima_gestion_hora() {
        return ultima_gestion_hora;
    }

    public void setUltima_gestion_hora(String ultima_gestion_hora) {
        this.ultima_gestion_hora = ultima_gestion_hora;
    }

    public String getUltimo_estatus_cuenta() {
        return ultimo_estatus_cuenta;
    }

    public void setUltimo_estatus_cuenta(String ultimo_estatus_cuenta) {
        this.ultimo_estatus_cuenta = ultimo_estatus_cuenta;
    }

    public String getUltimo_estatus_llamada() {
        return ultimo_estatus_llamada;
    }

    public void setUltimo_estatus_llamada(String ultimo_estatus_llamada) {
        this.ultimo_estatus_llamada = ultimo_estatus_llamada;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getResto() {
        return resto;
    }

    public void setResto(String resto) {
        this.resto = resto;
    }

    public String getTipo_mora() {
        return tipo_mora;
    }

    public void setTipo_mora(String tipo_mora) {
        this.tipo_mora = tipo_mora;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipo_plan() {
        return tipo_plan;
    }

    public void setTipo_plan(String tipo_plan) {
        this.tipo_plan = tipo_plan;
    }

    public int getId_estatus_llamada() {
        return id_estatus_llamada;
    }

    public void setId_estatus_llamada(int id_estatus_llamada) {
        this.id_estatus_llamada = id_estatus_llamada;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getEstatus_original() {
        return estatus_original;
    }

    public void setEstatus_original(String estatus_original) {
        this.estatus_original = estatus_original;
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

    public String getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(String penalizacion) {
        this.penalizacion = penalizacion;
    }

    public String getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(String cancelacion) {
        this.cancelacion = cancelacion;
    }

    public String getLada() {
        return lada;
    }

    public void setLada(String lada) {
        this.lada = lada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCuentas_multiples() {
        return cuentas_multiples;
    }

    public void setCuentas_multiples(String cuentas_multiples) {
        this.cuentas_multiples = cuentas_multiples;
    }

    public String getImporte_cuentas_multiples() {
        return importe_cuentas_multiples;
    }

    public void setImporte_cuentas_multiples(String importe_cuentas_multiples) {
        this.importe_cuentas_multiples = importe_cuentas_multiples;
    }

    public String getTiene_cr() {
        return tiene_cr;
    }

    public void setTiene_cr(String tiene_cr) {
        this.tiene_cr = tiene_cr;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getDato_original() {
        return dato_original;
    }

    public void setDato_original(String dato_original) {
        this.dato_original = dato_original;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getTel_referencia1() {
        return tel_referencia1;
    }

    public void setTel_referencia1(String tel_referencia1) {
        this.tel_referencia1 = tel_referencia1;
    }

    public String getTt_ref1() {
        return tt_ref1;
    }

    public void setTt_ref1(String tt_ref1) {
        this.tt_ref1 = tt_ref1;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getTel_referencia2() {
        return tel_referencia2;
    }

    public void setTel_referencia2(String tel_referencia2) {
        this.tel_referencia2 = tel_referencia2;
    }

    public String getTt_ref2() {
        return tt_ref2;
    }

    public void setTt_ref2(String tt_ref2) {
        this.tt_ref2 = tt_ref2;
    }

    public String getReferencia3() {
        return referencia3;
    }

    public void setReferencia3(String referencia3) {
        this.referencia3 = referencia3;
    }

    public String getTel_referencia3() {
        return tel_referencia3;
    }

    public void setTel_referencia3(String tel_referencia3) {
        this.tel_referencia3 = tel_referencia3;
    }

    public String getTt_ref3() {
        return tt_ref3;
    }

    public void setTt_ref3(String tt_ref3) {
        this.tt_ref3 = tt_ref3;
    }

    public String getReferencia4() {
        return referencia4;
    }

    public void setReferencia4(String referencia4) {
        this.referencia4 = referencia4;
    }

    public String getTel_referencia4() {
        return tel_referencia4;
    }

    public void setTel_referencia4(String tel_referencia4) {
        this.tel_referencia4 = tel_referencia4;
    }

    public String getTt_ref4() {
        return tt_ref4;
    }

    public void setTt_ref4(String tt_ref4) {
        this.tt_ref4 = tt_ref4;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

}
