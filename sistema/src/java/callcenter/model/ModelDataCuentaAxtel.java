/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author zuagu
 */
public class ModelDataCuentaAxtel {

    public static String datosCuenta(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
//            String sql = "SELECT * FROM axtel_base_general AS bg \n"
//                    + "LEFT JOIN azteca_estatus_cuenta AS sc ON bg.TIPO_LLAMADA = sc.id_estatus_cuenta \n"
//                    + "WHERE bg.CUENTA = '';";
            String sql = "CALL axtel_datos_cuenta('" + cuenta + "');";
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("ID_CUENTA", ic.rs.getInt("ID_CUENTA"));
                objCuenta.put("CUENTA", ic.rs.getString("CUENTA"));
                objCuenta.put("REFERENCIA", ic.rs.getString("REFERENCIA"));
                objCuenta.put("ESTADOS_INSTANCIA", ic.rs.getString("ESTADOS_INSTANCIA"));
                objCuenta.put("CLIENTE", ic.rs.getString("CLIENTE"));
                objCuenta.put("TOTAL", ic.rs.getString("TOTAL"));
                objCuenta.put("CORIENTE", ic.rs.getString("CORIENTE"));
                objCuenta.put("VENCIDO", ic.rs.getString("VENCIDO"));
                objCuenta.put("DIAS_MORA", ic.rs.getString("DIAS_MORA"));
                objCuenta.put("DESCUENTO", ic.rs.getString("DESCUENTO"));
                objCuenta.put("BUCKET", ic.rs.getString("BUCKET"));
                objCuenta.put("OCA", ic.rs.getString("OCA"));
                objCuenta.put("RENTAS_NO_DEVENGADAS", ic.rs.getString("RENTAS_NO_DEVENGADAS"));
                objCuenta.put("FECHA_ASIGNACION", ic.rs.getString("FECHA_ASIGNACION"));
                objCuenta.put("FECHA_ULTIMO_PAGO", ic.rs.getString("FECHA_ULTIMO_PAGO"));
                objCuenta.put("MONTO_ULTIMO_PAGO", ic.rs.getString("MONTO_ULTIMO_PAGO"));
                objCuenta.put("FECHA_ULTIMA_PROMESA", ic.rs.getString("FECHA_ULTIMA_PROMESA"));
                objCuenta.put("MONTO_ULTIMO_PROMESA", ic.rs.getString("MONTO_ULTIMO_PROMESA"));
                objCuenta.put("B30", ic.rs.getString("B30"));
                objCuenta.put("B60", ic.rs.getString("B60"));
                objCuenta.put("B90", ic.rs.getString("B90"));
                objCuenta.put("B150", ic.rs.getString("B150"));
                objCuenta.put("B180", ic.rs.getString("B180"));
                objCuenta.put("B210", ic.rs.getString("B210"));
                objCuenta.put("B240", ic.rs.getString("B240"));
                objCuenta.put("B270", ic.rs.getString("B270"));
                objCuenta.put("B300", ic.rs.getString("B300"));
                objCuenta.put("B330", ic.rs.getString("B330"));
                objCuenta.put("B360", ic.rs.getString("B360"));
                objCuenta.put("B390", ic.rs.getString("B390"));
                objCuenta.put("CALLE_NUM", ic.rs.getString("CALLE_NUM"));
                objCuenta.put("COLONIA", ic.rs.getString("COLONIA"));
                objCuenta.put("CIUDAD", ic.rs.getString("CIUDAD"));
                objCuenta.put("ESTADO", ic.rs.getString("ESTADO"));
                objCuenta.put("CP", ic.rs.getString("CP"));
                objCuenta.put("TELEFONO_PRINCIPAL", ic.rs.getString("TELEFONO_PRINCIPAL"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("COMENTERIO1", ic.rs.getString("COMENTERIO1"));
                objCuenta.put("COMENTERIO2", ic.rs.getString("COMENTERIO2"));
                objCuenta.put("COMENTERIO3", ic.rs.getString("COMENTERIO3"));
                objCuenta.put("QUEUE", ic.rs.getString("QUEUE"));
                objCuenta.put("CATEGORIA", ic.rs.getString("CATEGORIA"));
                objCuenta.put("SEGMENTO", ic.rs.getString("SEGMENTO"));
                objCuenta.put("TIPO_CLIENTE", ic.rs.getString("TIPO_CLIENTE"));
                objCuenta.put("MONEDA", ic.rs.getString("MONEDA"));
                objCuenta.put("CLICLO", ic.rs.getString("CLICLO"));
                objCuenta.put("RFC", ic.rs.getString("RFC"));
                objCuenta.put("CONTACTO_PRINCIAL", ic.rs.getString("CONTACTO_PRINCIAL"));
                objCuenta.put("ULTIMA_GESTION", ic.rs.getString("ULTIMA_GESTION"));
                objCuenta.put("TIPO_LLAMADA", ic.rs.getString("TIPO_LLAMADA"));
                objCuenta.put("ESTATUS_LLAMADA", ic.rs.getString("ESTATUS_LLAMADA"));
                objCuenta.put("MEJOR_ESTATUS", ic.rs.getString("MEJOR_ESTATUS"));
                objCuenta.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                objCuenta.put("ID_GESTOR_ASIGNADO", ic.rs.getString("ID_GESTOR_ASIGNADO"));
                objCuenta.put("FECHA_INSERT", ic.rs.getString("FECHA_INSERT"));
                objCuenta.put("FECHA_RETIRADA", ic.rs.getString("FECHA_RETIRADA"));
                objCuenta.put("FECHA_REACT", ic.rs.getString("FECHA_REACT"));
                objCuenta.put("IDENTIFICADOR", ic.rs.getString("IDENTIFICADOR"));
                objCuenta.put("IDENTIFICADOR2", ic.rs.getString("IDENTIFICADOR2"));
                objCuenta.put("ID_CLIENTE", ic.rs.getString("ID_CLIENTE"));
                objCuenta.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objCuenta.put("ID_RELACION", ic.rs.getString("ID_RELACION"));
                objCuenta.put("NOM_TEL_PRINCIPAL", ic.rs.getString("NOM_TEL_PRINCIPAL"));
                objCuenta.put("NOM_TEL2", ic.rs.getString("NOM_TEL2"));
                objCuenta.put("NOM_TEL3", ic.rs.getString("NOM_TEL3"));
                objCuenta.put("ESTATUS_POSIBLES_TXT", ic.rs.getString("ESTATUS_POSIBLES_TXT"));
                objCuenta.put("CRM", ic.rs.getString("CRM"));
                objCuenta.put("TELEFONO_PRINCIPAL_2", ic.rs.getString("TELEFONO_PRINCIPAL_2"));
                objCuenta.put("TELEFONO2_2", ic.rs.getString("TELEFONO2_2"));
                objCuenta.put("TELEFONO3_2", ic.rs.getString("TELEFONO3_2"));
                objCuenta.put("TELEFONO_REFERENCIA1", ic.rs.getString("TELEFONO_REFERENCIA1"));
                objCuenta.put("TELEFONO_REFERENCIA2", ic.rs.getString("TELEFONO_REFERENCIA2"));
                objCuenta.put("DIRECCION_REFERENCIA", ic.rs.getString("DIRECCION_REFERENCIA"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objCuenta.toString();

        } catch (SQLException e) {

            System.out.println(e);
            return "{\"SQL\":\"Error al traer los datos de la cuenta azteca Code Error: " + e + "\"}";
        }
    }
    public static String cuentaSiguiete(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
//            String sql = "SELECT * FROM axtel_base_general AS bg \n"
//                    + "LEFT JOIN azteca_estatus_cuenta AS sc ON bg.TIPO_LLAMADA = sc.id_estatus_cuenta \n"
//                    + "WHERE bg.CUENTA = '';";
            String sql = "select * FROM axtel_base_general bg LEFT JOIN azteca_estatus_cuenta AS sc ON bg.TIPO_LLAMADA = sc.id_estatus_cuenta order by rand() limit 1;";
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("ID_CUENTA", ic.rs.getInt("ID_CUENTA"));
                objCuenta.put("CUENTA", ic.rs.getString("CUENTA"));
                objCuenta.put("REFERENCIA", ic.rs.getString("REFERENCIA"));
                objCuenta.put("ESTADOS_INSTANCIA", ic.rs.getString("ESTADOS_INSTANCIA"));
                objCuenta.put("CLIENTE", ic.rs.getString("CLIENTE"));
                objCuenta.put("TOTAL", ic.rs.getString("TOTAL"));
                objCuenta.put("CORIENTE", ic.rs.getString("CORIENTE"));
                objCuenta.put("VENCIDO", ic.rs.getString("VENCIDO"));
                objCuenta.put("DIAS_MORA", ic.rs.getString("DIAS_MORA"));
                objCuenta.put("DESCUENTO", ic.rs.getString("DESCUENTO"));
                objCuenta.put("BUCKET", ic.rs.getString("BUCKET"));
                objCuenta.put("OCA", ic.rs.getString("OCA"));
                objCuenta.put("RENTAS_NO_DEVENGADAS", ic.rs.getString("RENTAS_NO_DEVENGADAS"));
                objCuenta.put("FECHA_ASIGNACION", ic.rs.getString("FECHA_ASIGNACION"));
                objCuenta.put("FECHA_ULTIMO_PAGO", ic.rs.getString("FECHA_ULTIMO_PAGO"));
                objCuenta.put("MONTO_ULTIMO_PAGO", ic.rs.getString("MONTO_ULTIMO_PAGO"));
                objCuenta.put("FECHA_ULTIMA_PROMESA", ic.rs.getString("FECHA_ULTIMA_PROMESA"));
                objCuenta.put("MONTO_ULTIMO_PROMESA", ic.rs.getString("MONTO_ULTIMO_PROMESA"));
                objCuenta.put("B30", ic.rs.getString("B30"));
                objCuenta.put("B60", ic.rs.getString("B60"));
                objCuenta.put("B90", ic.rs.getString("B90"));
                objCuenta.put("B120", ic.rs.getString("B120"));
                objCuenta.put("B150", ic.rs.getString("B150"));
                objCuenta.put("B180", ic.rs.getString("B180"));
                objCuenta.put("B210", ic.rs.getString("B210"));
                objCuenta.put("B240", ic.rs.getString("B240"));
                objCuenta.put("B270", ic.rs.getString("B270"));
                objCuenta.put("B300", ic.rs.getString("B300"));
                objCuenta.put("B330", ic.rs.getString("B330"));
                objCuenta.put("B360", ic.rs.getString("B360"));
                objCuenta.put("B390", ic.rs.getString("B390"));
                objCuenta.put("CALLE_NUM", ic.rs.getString("CALLE_NUM"));
                objCuenta.put("COLONIA", ic.rs.getString("COLONIA"));
                objCuenta.put("CIUDAD", ic.rs.getString("CIUDAD"));
                objCuenta.put("ESTADO", ic.rs.getString("ESTADO"));
                objCuenta.put("CP", ic.rs.getString("CP"));
                objCuenta.put("TELEFONO_PRINCIPAL", ic.rs.getString("TELEFONO_PRINCIPAL"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("COMENTERIO1", ic.rs.getString("COMENTERIO1"));
                objCuenta.put("COMENTERIO2", ic.rs.getString("COMENTERIO2"));
                objCuenta.put("COMENTERIO3", ic.rs.getString("COMENTERIO3"));
                objCuenta.put("QUEUE", ic.rs.getString("QUEUE"));
                objCuenta.put("CATEGORIA", ic.rs.getString("CATEGORIA"));
                objCuenta.put("SEGMENTO", ic.rs.getString("SEGMENTO"));
                objCuenta.put("TIPO_CLIENTE", ic.rs.getString("TIPO_CLIENTE"));
                objCuenta.put("MONEDA", ic.rs.getString("MONEDA"));
                objCuenta.put("CLICLO", ic.rs.getString("CLICLO"));
                objCuenta.put("RFC", ic.rs.getString("RFC"));
                objCuenta.put("CONTACTO_PRINCIAL", ic.rs.getString("CONTACTO_PRINCIAL"));
                objCuenta.put("ULTIMA_GESTION", ic.rs.getString("ULTIMA_GESTION"));
                objCuenta.put("TIPO_LLAMADA", ic.rs.getString("TIPO_LLAMADA"));
                objCuenta.put("ESTATUS_LLAMADA", ic.rs.getString("ESTATUS_LLAMADA"));
                objCuenta.put("MEJOR_ESTATUS", ic.rs.getString("MEJOR_ESTATUS"));
                objCuenta.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                objCuenta.put("ID_GESTOR_ASIGNADO", ic.rs.getString("ID_GESTOR_ASIGNADO"));
                objCuenta.put("FECHA_INSERT", ic.rs.getString("FECHA_INSERT"));
                objCuenta.put("FECHA_RETIRADA", ic.rs.getString("FECHA_RETIRADA"));
                objCuenta.put("FECHA_REACT", ic.rs.getString("FECHA_REACT"));
                objCuenta.put("IDENTIFICADOR", ic.rs.getString("IDENTIFICADOR"));
                objCuenta.put("IDENTIFICADOR2", ic.rs.getString("IDENTIFICADOR2"));
                objCuenta.put("ID_CLIENTE", ic.rs.getString("ID_CLIENTE"));
                objCuenta.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objCuenta.put("ID_RELACION", ic.rs.getString("ID_RELACION"));
                objCuenta.put("NOM_TEL_PRINCIPAL", ic.rs.getString("NOM_TEL_PRINCIPAL"));
                objCuenta.put("NOM_TEL2", ic.rs.getString("NOM_TEL2"));
                objCuenta.put("NOM_TEL3", ic.rs.getString("NOM_TEL3"));
                objCuenta.put("ESTATUS_POSIBLES_TXT", ic.rs.getString("ESTATUS_POSIBLES_TXT"));
                objCuenta.put("CRM", ic.rs.getString("CRM"));
                objCuenta.put("TELEFONO_PRINCIPAL_2", ic.rs.getString("TELEFONO_PRINCIPAL_2"));
                objCuenta.put("TELEFONO2_2", ic.rs.getString("TELEFONO2_2"));
                objCuenta.put("TELEFONO3_2", ic.rs.getString("TELEFONO3_2"));
                objCuenta.put("TELEFONO_REFERENCIA1", ic.rs.getString("TELEFONO_REFERENCIA1"));
                objCuenta.put("TELEFONO_REFERENCIA2", ic.rs.getString("TELEFONO_REFERENCIA2"));
                objCuenta.put("DIRECCION_REFERENCIA", ic.rs.getString("DIRECCION_REFERENCIA"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objCuenta.toString();

        } catch (SQLException e) {

            System.out.println(e);
            return "{\"SQL\":\"Error al traer los datos de la cuenta azteca Code Error: " + e + "\"}";
        }
    }

    public static String guardarGestion(String objGestion) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objGestion);

            Object _CUENTA = jsonObject.get("_CUENTA");
            Object _NUMERO_MARCADO = jsonObject.get("_NUMERO_MARCADO");
            Object _ID_ESTATUS_CUENTA = jsonObject.get("_ID_ESTATUS_CUENTA");
            Object _ID_ESTATUS_LLAMADA = jsonObject.get("_ID_ESTATUS_LLAMADA");
            Object _ID_USUARIO = jsonObject.get("_ID_USUARIO");
            Object _GESTION = jsonObject.get("_GESTION");
            Object _DURACION = jsonObject.get("_DURACION");
            Object _RETASO = jsonObject.get("_RETASO");
            Object _ID_PUESTO = jsonObject.get("_ID_PUESTO");
            Object _PROMESA = jsonObject.get("_PROMESA");
            Object _F_PREDICTIVO = jsonObject.get("_F_PREDICTIVO");

            StartConexion ic = new StartConexion();
            String sql = "CALL axtel_insert_gestion('" + _CUENTA + "', '" + _NUMERO_MARCADO + "', " + _ID_ESTATUS_CUENTA + ", " + _ID_ESTATUS_LLAMADA + ", " + _ID_USUARIO + ", '" + _GESTION + "', '" + _DURACION + "', '" + _RETASO + "', " + _ID_PUESTO + ", " + _PROMESA + ", " + _F_PREDICTIVO + ");";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);

            JSONObject objRes = new JSONObject();
//            System.out.println(objRes);
            while (ic.rs.next()) {
                objRes.put("response", ic.rs.getString("response"));

            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objRes.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error: al insertar datos de gestion Code Error: " + e;
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
            return "SQL: Falla en el parser de JSONObject";
        }
    }

    // -------------------------------------------------------------------------
    public static String select_buscar_cuentas(String busqueda, int id_puesto) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "call axtel_buscar_cuentas('" + busqueda.replace(";", "") + "');";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listCuentas = new JSONArray();

            while (ic.rs.next()) { //  ID_CUENTA, CUENTA, CLIENTE, REFERENCIA, CATEGORIA, RFC
                JSONObject objCuenta = new JSONObject();
                objCuenta.put("ID_CUENTA", ic.rs.getString("ID_CUENTA"));
                objCuenta.put("CUENTA", ic.rs.getString("CUENTA"));
                objCuenta.put("CLIENTE", ic.rs.getString("CLIENTE"));
                objCuenta.put("REFERENCIA", ic.rs.getString("REFERENCIA"));
                objCuenta.put("CATEGORIA", ic.rs.getString("CATEGORIA"));
                objCuenta.put("RFC", ic.rs.getString("RFC"));
                listCuentas.add(objCuenta);

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listCuentas.toString();
        } catch (SQLException e) {
            return "SQL: Error al buscar ceuntas Code Error: " + e;
        }
    }

    // -------------------------------------------------------------------------
    public static String select_gestiones_cuenta(String cuenta, String fecha_inico) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "CALL axtel_gestiones_cuenta('" + cuenta + "');";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listGestion = new JSONArray();
            while (ic.rs.next()) {
                JSONObject objGestion = new JSONObject();
                objGestion.put("ID_GESTION", ic.rs.getString("ID_GESTION"));
                objGestion.put("FECHA_INSERT", ic.rs.getString("FECHA_INSERT"));
                objGestion.put("HORA", ic.rs.getString("HORA"));
                objGestion.put("CUENTA", ic.rs.getString("CUENTA"));
                objGestion.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objGestion.put("ID_ESTATUS_LLAMDA", ic.rs.getString("ID_ESTATUS_LLAMDA"));
                objGestion.put("NUMERO_MARCADO", ic.rs.getString("NUMERO_MARCADO"));
                objGestion.put("ID_USUARIO", ic.rs.getString("ID_USUARIO"));
                objGestion.put("GESTION", ic.rs.getString("GESTION"));
                objGestion.put("DURACION", ic.rs.getString("DURACION"));
                objGestion.put("RETRASO", ic.rs.getString("RETRASO"));
                objGestion.put("PROMESA", ic.rs.getString("PROMESA"));
                listGestion.add(objGestion);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listGestion.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer las gestiones de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_convenios_cuenta(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "call azteca_convenios_cuenta('" + cuenta + "');";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listConvenios = new JSONArray();
            while (ic.rs.next()) {
                JSONObject objConvenio = new JSONObject();
                objConvenio.put("ID_CONVENIO", ic.rs.getString("ID_CONVENIO"));
                objConvenio.put("CONVENIO", ic.rs.getString("CONVENIO"));
                objConvenio.put("RESTO", ic.rs.getString("RESTO"));
                objConvenio.put("APLICA", ic.rs.getString("APLICA"));
                objConvenio.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objConvenio.put("CANAL", ic.rs.getString("CANAL"));
                objConvenio.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objConvenio.put("FECHA", ic.rs.getString("FECHA"));
                objConvenio.put("ID_USUARIO", ic.rs.getString("ID_USUARIO"));
                objConvenio.put("CUENTA", ic.rs.getString("CUENTA"));
                objConvenio.put("ID_ESTATUS", ic.rs.getString("ID_ESTATUS"));
                objConvenio.put("FECHA_INSET", ic.rs.getString("FECHA_INSET"));
                objConvenio.put("PAGOS", ic.rs.getString("PAGOS"));
                objConvenio.put("FECHA_PAGO", ic.rs.getString("FECHA_PAGO"));
                objConvenio.put("EFECTIVIDAD", ic.rs.getString("EFECTIVIDAD"));
                objConvenio.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                listConvenios.add(objConvenio);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listConvenios.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String insertar_convenio(String objConvenio) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objConvenio);

            Object _CONVENIO = jsonObject.get("CONVENIO");
            Object _FECHA = jsonObject.get("FECHA");
            Object _ID_USUARIO = jsonObject.get("ID_USUARIO");
            Object _CUENTA = jsonObject.get("CUENTA");
            Object _TERRITORIO = jsonObject.get("TERRITORIO");
            Object _GERENCIA = jsonObject.get("GERENCIA");
            Object _GERENTE = jsonObject.get("GERENTE");
            Object _NOMBRE = jsonObject.get("NOMBRE_CTE");
            Object _ID_ESTATUS_LLAMADA = jsonObject.get("ID_ESTATUS_LLAMADA");
            Object _TIPO_CONVENIO = jsonObject.get("TIPO_CONVENIO");
            Object _CANAL = jsonObject.get("CANAL");
            Object _ATRASO_MAXIMO = jsonObject.get("ATRASO_MAXIMO");
            Object _ID_EQUIPO = jsonObject.get("ID_EQUIPO");
            Object _PASSwORD = jsonObject.get("PASSwORD");

            StartConexion ic = new StartConexion();
            String sql = "CALL azteca_insert_convenio( " + _CONVENIO + ", '" + _FECHA + "', " + _ID_USUARIO + ", '" + _CUENTA + "', '" + _TERRITORIO + "', '" + _CANAL + "' , " + _ATRASO_MAXIMO + ", " + _ID_EQUIPO + ", '" + _PASSwORD + "', '" + _GERENCIA + "', '" + _GERENTE + "', '" + _ID_ESTATUS_LLAMADA + "', '" + _TIPO_CONVENIO + "', '" + _NOMBRE + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            // response
            JSONObject objResp = new JSONObject();
            while (ic.rs.next()) {
                objResp.put("resultado", ic.rs.getString("response"));
                objResp.put("mensaje", ic.rs.getString("mensaje"));

            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objResp.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al insertar datos de gestion Code Error: " + e;
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
            return "SQL: Falla en el parser de JSONObject";
        }
    }

    public static String actualizar_informacion_contacto(String nom_tel2, String tel2_1, String tel2_2, String nom_tel3, String tel3_1, String tel3_2, String cuenta) {
        try {
            StartConexion ic = new StartConexion();

            String sql = " UPDATE axtel_base_general SET\n"
                    + "NOM_TEL2 = '"+ nom_tel2 +"',\n"
                    + "TELEFONO2 = '"+ tel2_1 +"',\n"
                    + "TELEFONO2_2 = '"+ tel2_2 +"',\n"
                    + "NOM_TEL3 = '"+ nom_tel3 +"',\n"
                    + "TELEFONO3 = '"+ tel3_1 +"',\n"
                    + "TELEFONO3_2 = '"+ tel3_2 +"'\n"
                    + "WHERE CUENTA = '"+ cuenta +"';";
            System.out.println(sql);

            ic.st.executeUpdate(sql);
            ic.st.close();
            ic.conn.close();

            return "{\"menssage\":\"Datos del contacto Actualizado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }
    
    public static String actualizar_informacion_cont_principal(String nom_tel1, String tel1, String tel2, String cuenta) {
        try {
            StartConexion ic = new StartConexion();

            String sql = " UPDATE axtel_base_general SET\n"
                    + "CONTACTO_PRINCIAL = '"+ nom_tel1 +"',\n"
                    + "TELEFONO_PRINCIPAL = '"+ tel1 +"',\n"
                    + "TELEFONO_PRINCIPAL_2 = '"+ tel2 +"' \n"
                    + "WHERE CUENTA = '"+ cuenta +"';";
            System.out.println(sql);

            ic.st.executeUpdate(sql);
            ic.st.close();
            ic.conn.close();

            return "{\"menssage\":\"Datos del contacto Actualizado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }
    
    // Agendas
    public static String select_agendas(String id_gestor) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT \n"
                    + "	ID_REGISTRO, \n"
                    + "	CLIENTE_UNICO, \n"
                    + "    DESCRIPCION, \n"
                    + "    DATE(FECHA_AGENDA) AS FECHA, \n"
                    + "    TIME(FECHA_AGENDA) AS HORA, \n"
                    + "    if( time_to_sec(TIMEDIFF(FECHA_AGENDA, NOW())) < 0, 3, time_to_sec(TIMEDIFF(FECHA_AGENDA, NOW())) ) AS H_EJECUTAR, \n"
                    + "    if(time_to_sec(TIMEDIFF(FECHA_AGENDA, NOW())) < 0 and F_ACTIVE = 1,'yellow','green') as F_ACTIVE \n"
                    + "FROM axtel_registro_agenda WHERE ID_GESTOR = " + id_gestor + " AND F_ACTIVE = 1 AND DATE(FECHA_AGENDA) = CURDATE() ;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray listAgenda = new JSONArray();
            // llamadas, cuentas, convenios, hora
            while (inicioConexion.rs.next()) {
                JSONObject agenda = new JSONObject();
                agenda.put("ID_REGISTRO", inicioConexion.rs.getString("ID_REGISTRO"));
                agenda.put("CLIENTE_UNICO", inicioConexion.rs.getString("CLIENTE_UNICO"));
                agenda.put("DESCRIPCION", inicioConexion.rs.getString("DESCRIPCION"));
                agenda.put("FECHA", inicioConexion.rs.getString("FECHA"));
                agenda.put("HORA", inicioConexion.rs.getString("HORA"));
                agenda.put("H_EJECUTAR", inicioConexion.rs.getString("H_EJECUTAR"));
                agenda.put("F_ACTIVE", inicioConexion.rs.getString("F_ACTIVE"));
                listAgenda.add(agenda);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return listAgenda.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }
    
    public static String insertar_agenda(String cliente_unico, String id_usuario, String descripcion, String fecha, String hora) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call axtel_insertar_agenda('" + cliente_unico + "', " + id_usuario + ", '" + descripcion + "', '" + fecha + "', '" + hora + ":00');";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject reponse = new JSONObject();
            // llamadas, cuentas, convenios, hora
            while (inicioConexion.rs.next()) {
                reponse.put("response", inicioConexion.rs.getString("response"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return reponse.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }
    
    public static String descartar_agenda_gestor(String id_reg) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "UPDATE axtel_registro_agenda SET F_ACTIVE = '0' WHERE (`ID_REGISTRO` = '" + id_reg + "');";
            System.out.println(sql);
            
            inicioConexion.st.executeUpdate(sql);
            
//            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return "{\"response\":\"Registro de agenda Actualializada\"}";
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

}
