package arcade.model;

/* @author Luis Cortez */
public class Proveedor extends Usuario {

    private int id;
    private String razon_social;
    private String rfc;
    private int codigo_postal;
    private String colonia;
    private String calle;
    private String num_ext;
    private String num_int;
    private int id_pais;
    private int id_estado;
    private int id_municipio;
    private String telefonos;
    private String email;
    private String comentarios;
    private String fecha_insert;
    private String f_deleted;
    private String deleted;
    private String id_usuario_deleted;
    private String usuario_deleted;

    private String deuda;
    private String pagado;
    private String saldo;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
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

    public String getNum_ext() {
        return num_ext;
    }

    public void setNum_ext(String num_ext) {
        this.num_ext = num_ext;
    }

    public String getNum_int() {
        return num_int;
    }

    public void setNum_int(String num_int) {
        this.num_int = num_int;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFecha_insert() {
        return fecha_insert;
    }

    public void setFecha_insert(String fecha_insert) {
        this.fecha_insert = fecha_insert;
    }

    public String getF_deleted() {
        return f_deleted;
    }

    public void setF_deleted(String f_deleted) {
        this.f_deleted = f_deleted;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getId_usuario_deleted() {
        return id_usuario_deleted;
    }

    public void setId_usuario_deleted(String id_usuario_deleted) {
        this.id_usuario_deleted = id_usuario_deleted;
    }

    public String getUsuario_deleted() {
        return usuario_deleted;
    }

    public void setUsuario_deleted(String usuario_deleted) {
        this.usuario_deleted = usuario_deleted;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

}
