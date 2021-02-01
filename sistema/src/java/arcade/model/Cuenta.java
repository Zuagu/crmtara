package arcade.model;

public class Cuenta {

    private int id_cuenta;
    private String cuenta;
    private String cliente_unico;
    private String nombre;
    private String expediente;
    private String telefono;
    private String telefono1;
    private String telefono2;
    private String telefono3;
    private String tipo_cuenta;
    private String estatus_cuenta;
    private String estatus_telefono;
    private String dias_antiguedad;
    private String plan_tarifario;
    private String clase_credito;
    private String ciclo_facturacion;
    private String estatus_cobranza;
    private Float deposito_garantia;
    private Float saldo_estimado;
    private Float penalizacion_pendiente_iva;
    private String abogado;
    private String fecha;
    private String hora;
    private Float penalizacion_aprobada_iva;
    private String rfc;
    private Float adeudo_asignado;
    private String acc_pas;
    private String asignacion;
    private int clasificacion;
    private int id_gestor1;
    private int id_gestor2;
    private int id_gestor3;
    private Float p_contacto;
    private int f_visto;
    private String visto;
    private int f_pagado;
    private String pagado;
    private int f_active;
    private String active;
    private int id_region;
    private String region;
    private String ultima_gestion;
    private String ultima_hora;
    private int id_estatus;
    private String estatus;
    private int id_estatus_rea;
    private int id_estatus_chbk;
    private int id_estatus_visita;
    private int id_codigo;
    private int usuario_anterior;
    private String fecha_pagado;
    private String fecha_inicio;
    private String fecha_devolucion;
    private Float suma_pagos;

    private int id_equipo;
    private String equipo;
    private String referencias;
    private String ultimo_estatus_cuenta;
    private String ultimo_estatus_llamada;

    public Cuenta() {

    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCliente_unico() {
        return cliente_unico;
    }

    public void setCliente_unico(String cliente_unico) {
        this.cliente_unico = cliente_unico;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getEstatus_cuenta() {
        return estatus_cuenta;
    }

    public void setEstatus_cuenta(String estatus_cuenta) {
        this.estatus_cuenta = estatus_cuenta;
    }

    public String getEstatus_telefono() {
        return estatus_telefono;
    }

    public void setEstatus_telefono(String estatus_telefono) {
        this.estatus_telefono = estatus_telefono;
    }

    public String getDias_antiguedad() {
        return dias_antiguedad;
    }

    public void setDias_antiguedad(String dias_antiguedad) {
        this.dias_antiguedad = dias_antiguedad;
    }

    public String getPlan_tarifario() {
        return plan_tarifario;
    }

    public void setPlan_tarifario(String plan_tarifario) {
        this.plan_tarifario = plan_tarifario;
    }

    public String getClase_credito() {
        return clase_credito;
    }

    public void setClase_credito(String clase_credito) {
        this.clase_credito = clase_credito;
    }

    public String getCiclo_facturacion() {
        return ciclo_facturacion;
    }

    public void setCiclo_facturacion(String ciclo_facturacion) {
        this.ciclo_facturacion = ciclo_facturacion;
    }

    public String getEstatus_cobranza() {
        return estatus_cobranza;
    }

    public void setEstatus_cobranza(String estatus_cobranza) {
        this.estatus_cobranza = estatus_cobranza;
    }

    public Float getDeposito_garantia() {
        return deposito_garantia;
    }

    public void setDeposito_garantia(Float deposito_garantia) {
        this.deposito_garantia = deposito_garantia;
    }

    public Float getSaldo_estimado() {
        return saldo_estimado;
    }

    public void setSaldo_estimado(Float saldo_estimado) {
        this.saldo_estimado = saldo_estimado;
    }

    public Float getPenalizacion_pendiente_iva() {
        return penalizacion_pendiente_iva;
    }

    public void setPenalizacion_pendiente_iva(Float penalizacion_pendiente_iva) {
        this.penalizacion_pendiente_iva = penalizacion_pendiente_iva;
    }

    public String getAbogado() {
        return abogado;
    }

    public void setAbogado(String abogado) {
        this.abogado = abogado;
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

    public Float getPenalizacion_aprobada_iva() {
        return penalizacion_aprobada_iva;
    }

    public void setPenalizacion_aprobada_iva(Float penalizacion_aprobada_iva) {
        this.penalizacion_aprobada_iva = penalizacion_aprobada_iva;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Float getAdeudo_asignado() {
        return adeudo_asignado;
    }

    public void setAdeudo_asignado(Float adeudo_asignado) {
        this.adeudo_asignado = adeudo_asignado;
    }

    public String getAcc_pas() {
        return acc_pas;
    }

    public void setAcc_pas(String acc_pas) {
        this.acc_pas = acc_pas;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getId_gestor1() {
        return id_gestor1;
    }

    public void setId_gestor1(int id_gestor1) {
        this.id_gestor1 = id_gestor1;
    }

    public int getId_gestor2() {
        return id_gestor2;
    }

    public void setId_gestor2(int id_gestor2) {
        this.id_gestor2 = id_gestor2;
    }

    public int getId_gestor3() {
        return id_gestor3;
    }

    public void setId_gestor3(int id_gestor3) {
        this.id_gestor3 = id_gestor3;
    }

    public Float getP_contacto() {
        return p_contacto;
    }

    public void setP_contacto(Float p_contacto) {
        this.p_contacto = p_contacto;
    }

    public int getF_visto() {
        return f_visto;
    }

    public void setF_visto(int f_visto) {
        this.f_visto = f_visto;
    }

    public String getVisto() {
        return visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
    }

    public int getF_pagado() {
        return f_pagado;
    }

    public void setF_pagado(int f_pagado) {
        this.f_pagado = f_pagado;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public int getF_active() {
        return f_active;
    }

    public void setF_active(int f_active) {
        this.f_active = f_active;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUltima_gestion() {
        return ultima_gestion;
    }

    public void setUltima_gestion(String ultima_gestion) {
        this.ultima_gestion = ultima_gestion;
    }

    public String getUltima_hora() {
        return ultima_hora;
    }

    public void setUltima_hora(String ultima_hora) {
        this.ultima_hora = ultima_hora;
    }

    public int getId_estatus() {
        return id_estatus;
    }

    public void setId_estatus(int id_estatus) {
        this.id_estatus = id_estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getId_estatus_rea() {
        return id_estatus_rea;
    }

    public void setId_estatus_rea(int id_estatus_rea) {
        this.id_estatus_rea = id_estatus_rea;
    }

    public int getId_estatus_chbk() {
        return id_estatus_chbk;
    }

    public void setId_estatus_chbk(int id_estatus_chbk) {
        this.id_estatus_chbk = id_estatus_chbk;
    }

    public int getId_estatus_visita() {
        return id_estatus_visita;
    }

    public void setId_estatus_visita(int id_estatus_visita) {
        this.id_estatus_visita = id_estatus_visita;
    }

    public int getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
    }

    public int getUsuario_anterior() {
        return usuario_anterior;
    }

    public void setUsuario_anterior(int usuario_anterior) {
        this.usuario_anterior = usuario_anterior;
    }

    public String getFecha_pagado() {
        return fecha_pagado;
    }

    public void setFecha_pagado(String fecha_pagado) {
        this.fecha_pagado = fecha_pagado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public Float getSuma_pagos() {
        return suma_pagos;
    }

    public void setSuma_pagos(Float suma_pagos) {
        this.suma_pagos = suma_pagos;
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

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
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

}
