/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

import arcade.data.StartConn;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;

/**
 *
 * @author Emmanuel Medina
 */
public class ModelDataCuentaAzteca {
    
    public static String datosCuenta(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql2 = "select * from azteca_base_genenral_original as bg left join azteca_estatus_cuenta as sc on bg.ID_ESTATUS_CUENTA = sc.id_estatus_cuenta where bg.CLIENTE_UNICO = '" + cuenta + "';";
//            System.out.println(sql2);
            ic.rs = ic.st.executeQuery(sql2);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));
                objCuenta.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objCuenta.put("NOMBRE_CTE", ic.rs.getString("NOMBRE_CTE"));
                objCuenta.put("CUADRANTE", ic.rs.getString("CUADRANTE"));
                objCuenta.put("ZONA_GEO", ic.rs.getString("ZONA_GEO"));
                objCuenta.put("RFC_CTE", ic.rs.getString("RFC_CTE"));
                objCuenta.put("ID_DESPACHO", ic.rs.getString("ID_DESPACHO"));
                objCuenta.put("DIRECCION_CTE", ic.rs.getString("DIRECCION_CTE"));
                objCuenta.put("NUM_EXT_CTE", ic.rs.getString("NUM_EXT_CTE"));
                objCuenta.put("NUM_INT_CTE", ic.rs.getString("NUM_INT_CTE"));
                objCuenta.put("CP_CTE", ic.rs.getString("CP_CTE"));
                objCuenta.put("COLONIA_CTE", ic.rs.getString("COLONIA_CTE"));
                objCuenta.put("POBLACION_CTE", ic.rs.getString("POBLACION_CTE"));
                objCuenta.put("ESTADO_CTE", ic.rs.getString("ESTADO_CTE"));
                objCuenta.put("CLASIFICACION_CTE", ic.rs.getString("CLASIFICACION_CTE"));
                objCuenta.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objCuenta.put("SALDO", ic.rs.getString("SALDO"));
                objCuenta.put("MORATORIOS", ic.rs.getString("MORATORIOS"));
                objCuenta.put("SALDO_TOTAL", ic.rs.getString("SALDO_TOTAL"));
                objCuenta.put("DIA_DE_PAGO", ic.rs.getString("DIA_DE_PAGO"));
                objCuenta.put("FECHA_ULTIMO_PAGO", ic.rs.getString("FECHA_ULTIMO_PAGO"));
                objCuenta.put("ANO", ic.rs.getString("ANO"));
                objCuenta.put("IMP_ULTIMO_PAGO", ic.rs.getString("IMP_ULTIMO_PAGO"));
                objCuenta.put("CALLE_EMPLEO", ic.rs.getString("CALLE_EMPLEO"));
                objCuenta.put("NUM_EXT_EMPLEO", ic.rs.getString("NUM_EXT_EMPLEO"));
                objCuenta.put("NUM_INT_EMPLEO", ic.rs.getString("NUM_INT_EMPLEO"));
                objCuenta.put("COLONIA_EMPLEO", ic.rs.getString("COLONIA_EMPLEO"));
                objCuenta.put("POBLACION_EMPLEO", ic.rs.getString("POBLACION_EMPLEO"));
                objCuenta.put("ESTADO_EMPLEO", ic.rs.getString("ESTADO_EMPLEO"));
                objCuenta.put("NOMBRE_AVAL", ic.rs.getString("NOMBRE_AVAL"));
                objCuenta.put("TELAVAL", ic.rs.getString("TELAVAL"));
                objCuenta.put("CALLEAVAL", ic.rs.getString("CALLEAVAL"));
                objCuenta.put("NUMEXTAVAL", ic.rs.getString("NUMEXTAVAL"));
                objCuenta.put("COLONIAAVAL", ic.rs.getString("COLONIAAVAL"));
                objCuenta.put("CPAVAL", ic.rs.getString("CPAVAL"));
                objCuenta.put("POBLACIONAVAL", ic.rs.getString("POBLACIONAVAL"));
                objCuenta.put("ESTADOAVAL", ic.rs.getString("ESTADOAVAL"));
                objCuenta.put("DIA_PAGO", ic.rs.getString("DIA_PAGO"));
                objCuenta.put("TELEFONO1", ic.rs.getString("TELEFONO1"));
                objCuenta.put("TIPOTEL1", ic.rs.getString("TIPOTEL1"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TIPOTEL2", ic.rs.getString("TIPOTEL2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("TIPOTEL3", ic.rs.getString("TIPOTEL3"));
                objCuenta.put("TELEFONO4", ic.rs.getString("TELEFONO4"));
                objCuenta.put("TIPOTEL4", ic.rs.getString("TIPOTEL4"));
                objCuenta.put("MIGRADO_A_CYBER", ic.rs.getString("MIGRADO_A_CYBER"));
                objCuenta.put("LATITUD", ic.rs.getString("LATITUD"));
                objCuenta.put("LONGITUD", ic.rs.getString("LONGITUD"));
                objCuenta.put("GERENCIA", ic.rs.getString("GERENCIA"));
                objCuenta.put("GERENTE", ic.rs.getString("GERENTE"));
                objCuenta.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objCuenta.put("CAMPANIA", ic.rs.getString("CAMPANIA"));
                objCuenta.put("IDENTIFICADOR", ic.rs.getString("IDENTIFICADOR"));
                objCuenta.put("CANAL", ic.rs.getString("CANAL"));
                objCuenta.put("EDAD", ic.rs.getString("EDAD"));
                objCuenta.put("SCORE", ic.rs.getString("SCORE"));
                objCuenta.put("RANGO", ic.rs.getString("RANGO"));
                objCuenta.put("RANGO_DE_EDAD", ic.rs.getString("RANGO_DE_EDAD"));
                objCuenta.put("IDENTIFICADOR2", ic.rs.getString("IDENTIFICADOR2"));
                objCuenta.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                objCuenta.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objCuenta.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objCuenta.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objCuenta.put("ID_CLIENTE", ic.rs.getString("ID_CLIENTE"));

                objCuenta.put("NOM_TEL1", ic.rs.getString("NOM_TEL1"));
                objCuenta.put("NOM_TEL2", ic.rs.getString("NOM_TEL2"));
                objCuenta.put("NOM_TEL3", ic.rs.getString("NOM_TEL3"));
                objCuenta.put("NOM_TEL4", ic.rs.getString("NOM_TEL4"));
                objCuenta.put("TIPO_CONTACTO1", ic.rs.getString("TIPO_CONTACTO1"));
                objCuenta.put("TIPO_CONTACTO2", ic.rs.getString("TIPO_CONTACTO2"));
                objCuenta.put("TIPO_CONTACTO3", ic.rs.getString("TIPO_CONTACTO3"));
                objCuenta.put("TIPO_CONTACTO4", ic.rs.getString("TIPO_CONTACTO4"));

                objCuenta.put("ESTATUS_POSIBLES_TXT", ic.rs.getString("ESTATUS_POSIBLES_TXT"));

                objCuenta.put("NOM_TEL5", ic.rs.getString("NOM_TEL5"));
                objCuenta.put("TELEFONO1_2", ic.rs.getString("TELEFONO1_2"));
                objCuenta.put("TIPOTEL1_2", ic.rs.getString("TIPOTEL1_2"));
                objCuenta.put("TELEFONO2_2", ic.rs.getString("TELEFONO2_2"));
                objCuenta.put("TIPOTEL2_2", ic.rs.getString("TIPOTEL2_2"));
                objCuenta.put("TELEFONO3_2", ic.rs.getString("TELEFONO3_2"));
                objCuenta.put("TIPOTEL3_2", ic.rs.getString("TIPOTEL3_2"));
                objCuenta.put("TELEFONO4_2", ic.rs.getString("TELEFONO4_2"));
                objCuenta.put("TIPOTEL4_2", ic.rs.getString("TIPOTEL4_2"));
                objCuenta.put("TELEFONO5_2", ic.rs.getString("TELEFONO5_2"));
                objCuenta.put("TIPOTEL5_2", ic.rs.getString("TIPOTEL5_2"));
                objCuenta.put("TELEFONO5", ic.rs.getString("TELEFONO5"));
                objCuenta.put("TELAVAL2", ic.rs.getString("TELAVAL2"));

                objCuenta.put("CRM", ic.rs.getString("CRM"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
//            System.out.println(objCuenta.toString());
            return objCuenta.toString();
        } catch (SQLException e) {
            
            System.out.println(e);
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
        
    }

    public static String guardarGestion(String objGestion) {
        try {
            System.out.println(objGestion);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objGestion);

            Object _ID_SUCURSAL = jsonObject.get("_ID_SUCURSAL");
            Object _ID_CLIENTE = jsonObject.get("_ID_CLIENTE");
            Object _TERRITORIO = jsonObject.get("_TERRITORIO");
            Object _CANAL = jsonObject.get("_CANAL");
            Object _ATRASO_MAXIMO = jsonObject.get("_ATRASO_MAXIMO");
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
            Object _ID_EQUIPO = jsonObject.get("_ID_EQUIPO");

            StartConexion ic = new StartConexion();
            String sql = "call azteca_insert_gestion(" + _ID_SUCURSAL + ", " + _ID_CLIENTE + ", '" + _TERRITORIO + "', '" + _CANAL + "', " + _ATRASO_MAXIMO + ", '" + _CUENTA + "', '" + _NUMERO_MARCADO + "', " + _ID_ESTATUS_CUENTA + ", " + _ID_ESTATUS_LLAMADA + ", " + _ID_USUARIO + ", '" + _GESTION + "', '" + _DURACION + "', '" + _RETASO + "', " + _ID_PUESTO + ", " + _PROMESA + ", " + _F_PREDICTIVO + ", " + _ID_EQUIPO + ");";
//            System.out.println(sql);
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

    public static String select_buscar_cuentas(String busqueda, int id_puesto) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "call azteca_buscar_cuentas('%" + busqueda.replace(";", "") + "%');";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listCuentas = new JSONArray();

            while (ic.rs.next()) { //id_cuenta, CLIENTE_UNICO, NOMBRE_CTE, NOMBRE_AVAL, TELEFONO1, TELEFONO2, TELEFONO3, TELEFONO4, TELAVAL
                JSONObject objCuenta = new JSONObject();
                objCuenta.put("id_cuenta", ic.rs.getString("id_cuenta"));
                objCuenta.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objCuenta.put("NOMBRE_CTE", ic.rs.getString("NOMBRE_CTE"));
                objCuenta.put("NOMBRE_AVAL", ic.rs.getString("NOMBRE_AVAL"));
                objCuenta.put("TELEFONO1", ic.rs.getString("TELEFONO1"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("TELEFONO4", ic.rs.getString("TELEFONO4"));
                objCuenta.put("TELAVAL", ic.rs.getString("TELAVAL"));
                objCuenta.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
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

    public static String select_datos_cuenta_relacionada(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
//            System.out.println(objCuenta.toString());

            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_telefonos_cr(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_gestiones_cuenta(String cuenta, String fecha_inico) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "CALL azteca_gestiones_cuenta('" + cuenta + "');";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listGestion = new JSONArray();
            while (ic.rs.next()) {
                JSONObject objGestion = new JSONObject();
                objGestion.put("ID_GESTION", ic.rs.getString("ID_GESTION"));
                objGestion.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objGestion.put("HORA", ic.rs.getString("HORA"));
                objGestion.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objGestion.put("CANAL", ic.rs.getString("CANAL"));
                objGestion.put("FECHA_LARGA", ic.rs.getString("FECHA_LARGA"));
                objGestion.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objGestion.put("CUENTA", ic.rs.getString("CUENTA"));
                objGestion.put("NUMERO_MARCADO", ic.rs.getString("NUMERO_MARCADO"));
                objGestion.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objGestion.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objGestion.put("ID_USUARIO", ic.rs.getString("ID_USUARIO"));
                objGestion.put("GESTION", ic.rs.getString("GESTION"));
                objGestion.put("DURACION", ic.rs.getString("DURACION"));
                objGestion.put("RETASO", ic.rs.getString("RETASO"));
                objGestion.put("ID_PUESTO", ic.rs.getString("ID_PUESTO"));
                objGestion.put("PROMESA", ic.rs.getString("PROMESA"));
                objGestion.put("F_PREDICTIVO", ic.rs.getString("F_PREDICTIVO"));
                objGestion.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
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

    public static String select_cuenta_siguiente(String id_usuario) {
        try {
            StartConexion ic = new StartConexion();
//            String sql = "SELECT * FROM azteca_base_genenral_original ORDER BY RAND() LIMIT 1;";
            String sql = "call azteca_cuenta_siguente(" + id_usuario + ");";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));
                objCuenta.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objCuenta.put("NOMBRE_CTE", ic.rs.getString("NOMBRE_CTE"));
                objCuenta.put("CUADRANTE", ic.rs.getString("CUADRANTE"));
                objCuenta.put("ZONA_GEO", ic.rs.getString("ZONA_GEO"));
                objCuenta.put("RFC_CTE", ic.rs.getString("RFC_CTE"));
                objCuenta.put("ID_DESPACHO", ic.rs.getString("ID_DESPACHO"));
                objCuenta.put("DIRECCION_CTE", ic.rs.getString("DIRECCION_CTE"));
                objCuenta.put("NUM_EXT_CTE", ic.rs.getString("NUM_EXT_CTE"));
                objCuenta.put("NUM_INT_CTE", ic.rs.getString("NUM_INT_CTE"));
                objCuenta.put("CP_CTE", ic.rs.getString("CP_CTE"));
                objCuenta.put("COLONIA_CTE", ic.rs.getString("COLONIA_CTE"));
                objCuenta.put("POBLACION_CTE", ic.rs.getString("POBLACION_CTE"));
                objCuenta.put("ESTADO_CTE", ic.rs.getString("ESTADO_CTE"));
                objCuenta.put("CLASIFICACION_CTE", ic.rs.getString("CLASIFICACION_CTE"));
                objCuenta.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objCuenta.put("SALDO", ic.rs.getString("SALDO"));
                objCuenta.put("MORATORIOS", ic.rs.getString("MORATORIOS"));
                objCuenta.put("SALDO_TOTAL", ic.rs.getString("SALDO_TOTAL"));
                objCuenta.put("DIA_DE_PAGO", ic.rs.getString("DIA_DE_PAGO"));
                objCuenta.put("FECHA_ULTIMO_PAGO", ic.rs.getString("FECHA_ULTIMO_PAGO"));
                objCuenta.put("ANO", ic.rs.getString("ANO"));
                objCuenta.put("IMP_ULTIMO_PAGO", ic.rs.getString("IMP_ULTIMO_PAGO"));
                objCuenta.put("CALLE_EMPLEO", ic.rs.getString("CALLE_EMPLEO"));
                objCuenta.put("NUM_EXT_EMPLEO", ic.rs.getString("NUM_EXT_EMPLEO"));
                objCuenta.put("NUM_INT_EMPLEO", ic.rs.getString("NUM_INT_EMPLEO"));
                objCuenta.put("COLONIA_EMPLEO", ic.rs.getString("COLONIA_EMPLEO"));
                objCuenta.put("POBLACION_EMPLEO", ic.rs.getString("POBLACION_EMPLEO"));
                objCuenta.put("ESTADO_EMPLEO", ic.rs.getString("ESTADO_EMPLEO"));
                objCuenta.put("NOMBRE_AVAL", ic.rs.getString("NOMBRE_AVAL"));
                objCuenta.put("TELAVAL", ic.rs.getString("TELAVAL"));
                objCuenta.put("CALLEAVAL", ic.rs.getString("CALLEAVAL"));
                objCuenta.put("NUMEXTAVAL", ic.rs.getString("NUMEXTAVAL"));
                objCuenta.put("COLONIAAVAL", ic.rs.getString("COLONIAAVAL"));
                objCuenta.put("CPAVAL", ic.rs.getString("CPAVAL"));
                objCuenta.put("POBLACIONAVAL", ic.rs.getString("POBLACIONAVAL"));
                objCuenta.put("ESTADOAVAL", ic.rs.getString("ESTADOAVAL"));
                objCuenta.put("DIA_PAGO", ic.rs.getString("DIA_PAGO"));
                objCuenta.put("TELEFONO1", ic.rs.getString("TELEFONO1"));
                objCuenta.put("TIPOTEL1", ic.rs.getString("TIPOTEL1"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TIPOTEL2", ic.rs.getString("TIPOTEL2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("TIPOTEL3", ic.rs.getString("TIPOTEL3"));
                objCuenta.put("TELEFONO4", ic.rs.getString("TELEFONO4"));
                objCuenta.put("TIPOTEL4", ic.rs.getString("TIPOTEL4"));
                objCuenta.put("MIGRADO_A_CYBER", ic.rs.getString("MIGRADO_A_CYBER"));
                objCuenta.put("LATITUD", ic.rs.getString("LATITUD"));
                objCuenta.put("LONGITUD", ic.rs.getString("LONGITUD"));
                objCuenta.put("GERENCIA", ic.rs.getString("GERENCIA"));
                objCuenta.put("GERENTE", ic.rs.getString("GERENTE"));
                objCuenta.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objCuenta.put("CAMPANIA", ic.rs.getString("CAMPANIA"));
                objCuenta.put("IDENTIFICADOR", ic.rs.getString("IDENTIFICADOR"));
                objCuenta.put("CANAL", ic.rs.getString("CANAL"));
                objCuenta.put("EDAD", ic.rs.getString("EDAD"));
                objCuenta.put("SCORE", ic.rs.getString("SCORE"));
                objCuenta.put("RANGO", ic.rs.getString("RANGO"));
                objCuenta.put("RANGO_DE_EDAD", ic.rs.getString("RANGO_DE_EDAD"));
                objCuenta.put("IDENTIFICADOR2", ic.rs.getString("IDENTIFICADOR2"));
                objCuenta.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                objCuenta.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objCuenta.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objCuenta.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objCuenta.put("ID_CLIENTE", ic.rs.getString("ID_CLIENTE"));

                objCuenta.put("NOM_TEL1", ic.rs.getString("NOM_TEL1"));
                objCuenta.put("NOM_TEL2", ic.rs.getString("NOM_TEL2"));
                objCuenta.put("NOM_TEL3", ic.rs.getString("NOM_TEL3"));
                objCuenta.put("NOM_TEL4", ic.rs.getString("NOM_TEL4"));
                objCuenta.put("TIPO_CONTACTO1", ic.rs.getString("TIPO_CONTACTO1"));
                objCuenta.put("TIPO_CONTACTO2", ic.rs.getString("TIPO_CONTACTO2"));
                objCuenta.put("TIPO_CONTACTO3", ic.rs.getString("TIPO_CONTACTO3"));
                objCuenta.put("TIPO_CONTACTO4", ic.rs.getString("TIPO_CONTACTO4"));

                objCuenta.put("ESTATUS_POSIBLES_TXT", ic.rs.getString("ESTATUS_POSIBLES_TXT"));

                objCuenta.put("NOM_TEL5", ic.rs.getString("NOM_TEL5"));
                objCuenta.put("TELEFONO1_2", ic.rs.getString("TELEFONO1_2"));
                objCuenta.put("TIPOTEL1_2", ic.rs.getString("TIPOTEL1_2"));
                objCuenta.put("TELEFONO2_2", ic.rs.getString("TELEFONO2_2"));
                objCuenta.put("TIPOTEL2_2", ic.rs.getString("TIPOTEL2_2"));
                objCuenta.put("TELEFONO3_2", ic.rs.getString("TELEFONO3_2"));
                objCuenta.put("TIPOTEL3_2", ic.rs.getString("TIPOTEL3_2"));
                objCuenta.put("TELEFONO4_2", ic.rs.getString("TELEFONO4_2"));
                objCuenta.put("TIPOTEL4_2", ic.rs.getString("TIPOTEL4_2"));
                objCuenta.put("TELEFONO5_2", ic.rs.getString("TELEFONO5_2"));
                objCuenta.put("TIPOTEL5_2", ic.rs.getString("TIPOTEL5_2"));
                objCuenta.put("TELEFONO5", ic.rs.getString("TELEFONO5"));

                objCuenta.put("CRM", ic.rs.getString("CRM"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
//            System.out.println(objCuenta.toString());
            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta siguiente azteca Code Error: " + e;
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

    public static String select_cuentas_de_estaus(String id_equipo, String estatus, String id_usuario) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_primera_llamada_gestor(String id_gestor) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT TIME(FECHA_LARGA) AS HORA FROM azteca_gestiones where ID_USUARIO = '" + id_gestor + "' and DATE(FECHA_LARGA) = CURDATE() ORDER BY FECHA_LARGA ASC LIMIT 1;";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject obj = new JSONObject();
            while (ic.rs.next()) {
                obj.put("HORA", ic.rs.getString("HORA"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return obj.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_numero_llamadas_gestor(String id_gestor) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT COUNT(ID_GESTION) AS NUM_GESTIONES FROM azteca_gestiones where ID_USUARIO = '" + id_gestor + "' and DATE(FECHA_LARGA) = CURDATE();";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject obj = new JSONObject();
            while (ic.rs.next()) {
                obj.put("NUM_GESTIONES", ic.rs.getString("NUM_GESTIONES"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return obj.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_numero_cuentas_tocadas_gestor(String id_gestor) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT COUNT(distinct CUENTA) AS NUM_CUENTAS FROM azteca_gestiones where ID_USUARIO = '" + id_gestor + "' and DATE(FECHA_LARGA) = CURDATE();";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject obj = new JSONObject();
            while (ic.rs.next()) {
                obj.put("NUM_CUENTAS", ic.rs.getString("NUM_CUENTAS"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return obj.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_numero_convenios_gestor(String id_gestor) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT COUNT(ID_CONVENIO) AS NUM_CONVENIOS FROM azteca_convenios where ID_USUARIO = '" + id_gestor + "' and DATE(FECHA_INSET) = CURDATE();";
//            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject obj = new JSONObject();
            while (ic.rs.next()) {
                obj.put("NUM_CONVENIOS", ic.rs.getString("NUM_CONVENIOS"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return obj.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String actualizar_telefono_1(String objContacto) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objContacto);

            Object _CUENTA = jsonObject.get("_CUENTA");
            Object nom_tel_1 = jsonObject.get("nom_tel_1");
            Object tipo_contact_tel_1 = jsonObject.get("tipo_contact_tel_1");
            Object act_tel_1 = jsonObject.get("act_tel_1");

            StartConexion ic = new StartConexion();
            String sql = "UPDATE azteca_base_genenral_original SET\n"
                    + "NOM_TEL1 = '" + nom_tel_1 + "',\n"
                    + "TIPO_CONTACTO1 = '" + tipo_contact_tel_1 + "',\n"
                    + "TELEFONO1 = '" + act_tel_1 + "'\n"
                    + "WHERE CLIENTE_UNICO = '" + _CUENTA + "';";
//            System.out.println(sql);
            ic.st.executeUpdate(sql);
//            JSONObject objCuenta = new JSONObject();
//            while (ic.rs.next()) {
////                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));
//
//            }
//            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return jsonObject.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
            return "SQL: Falla en el parser de JSONObject";
        }

    }

    public static String update_time_gestor(String id_cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "UPDATE azteca_tiempos_usuarios SET tiempo_conectado = ADDTIME(tiempo_conectado, '59') WHERE id_usuario = " + id_cuenta + " AND fecha = CURDATE();";
//            System.out.println(sql);

            ic.st.executeUpdate(sql);
            ic.st.close();
            ic.conn.close();

            return "{\"menssage\":\"tiempo actualizado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String actualizar_informacion_contacto(String nom_tel1, String tel1_1, String tel1_2, String nom_tel2, String tel2_1, String tel2_2, String nom_tel3, String tel3_1, String tel3_2, String nom_tel4, String tel4_1, String tel4_2, String nom_tel5, String tel5_1, String tel5_2, String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            /*
            nom_tel1            tel1_1            tel1_2            nom_tel2            tel2_1            tel2_2
            nom_tel3            tel3_1            tel3_2            nom_tel4            tel4_1            tel4_2
            nom_tel5            tel5_1            tel5_2            nom_tel_aval        tel_aval_1        tel_aval_2
             */
            String sql = "UPDATE azteca_base_genenral_original SET\n"
                    + "NOM_TEL1 = '" + nom_tel1 + "',\n"
                    + "TELEFONO1 = '" + tel1_1 + "',\n"
                    + "TELEFONO1_2 = '" + tel1_2 + "',\n"
                    + "NOM_TEL2 = '" + nom_tel2 + "',\n"
                    + "TELEFONO2 = '" + tel2_1 + "',\n"
                    + "TELEFONO2_2 = '" + tel2_2 + "',\n"
                    + "NOM_TEL3 = '" + nom_tel3 + "',\n"
                    + "TELEFONO3 = '" + tel3_1 + "',\n"
                    + "TELEFONO3_2 = '" + tel3_2 + "',\n"
                    + "NOM_TEL4 = '" + nom_tel4 + "',\n"
                    + "TELEFONO4 = '" + tel4_1 + "',\n"
                    + "TELEFONO4_2 = '" + tel4_2 + "',\n"
                    + "NOM_TEL5 = '" + nom_tel5 + "',\n"
                    + "TELEFONO5 = '" + tel5_1 + "',\n"
                    + "TELEFONO5_2 = '" + tel5_2 + "'\n"
                    + "WHERE CLIENTE_UNICO = '" + cuenta + "';";
//            System.out.println(sql);

            ic.st.executeUpdate(sql);
            ic.st.close();
            ic.conn.close();

            return "{\"menssage\":\"Datos del contacto Actualizado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String actualizar_informacion_aval(String nom_tel_aval, String tel_aval_1, String tel_aval_2, String calle_aval, String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "UPDATE azteca_base_genenral_original SET\n"
                    + "NOMBRE_AVAL = '" + nom_tel_aval + "',\n"
                    + "CALLEAVAL = '" + calle_aval + "',\n"
                    + "TELAVAL = '" + tel_aval_1 + "',\n"
                    + "TELAVAL2 = '" + tel_aval_2 + "'\n"
                    + "WHERE CLIENTE_UNICO = '" + cuenta + "';";
//            System.out.println(sql);

            ic.st.executeUpdate(sql);
            ic.st.close();
            ic.conn.close();

            return "{\"menssage\":\"Datos del aval Actualizado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String select_pagos_cuenta(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT * FROM azteca_pagos where CLIENTE_UNICO = '" + cuenta + "';";
//            ID_PAGO, ANIO, SEMANA, DIA, PAIS, CANAL, SUCURSAL, FOLIO, RECUPERACION_CAPITAL, RECUPERACION_MORATORIOS, SALDO_ACTUAL, MORATORIO, FECHA_GESTION, CARGO_AUTOMATICO, CLIENTE_UNICO, ZONA, GERENTE, ID_GESTOR
            ic.rs = ic.st.executeQuery(sql);
            JSONArray pagos = new JSONArray();
            while (ic.rs.next()) {
                JSONObject pago = new JSONObject();
                pago.put("ID_PAGO", ic.rs.getString("ID_PAGO"));
                pago.put("ANIO", ic.rs.getString("ANIO"));
                pago.put("SEMANA", ic.rs.getString("SEMANA"));
                pago.put("DIA", ic.rs.getString("DIA"));
                pago.put("SUCURSAL", ic.rs.getString("SUCURSAL"));
                pago.put("CANAL", ic.rs.getString("CANAL"));
                pago.put("RECUPERACION_CAPITAL", ic.rs.getString("RECUPERACION_CAPITAL"));
                pago.put("RECUPERACION_MORATORIOS", ic.rs.getString("RECUPERACION_MORATORIOS"));
                pago.put("SALDO_ACTUAL", ic.rs.getString("SALDO_ACTUAL"));
                pago.put("MORATORIO", ic.rs.getString("MORATORIO"));
                pago.put("FECHA_GESTION", ic.rs.getString("FECHA_GESTION"));
                pago.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                pago.put("ZONA", ic.rs.getString("ZONA"));
                pago.put("GERENTE", ic.rs.getString("GERENTE"));
                pago.put("ID_GESTOR", ic.rs.getString("ID_GESTOR"));
                pagos.add(pago);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return pagos.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los pagos azteca Code Error: " + e;
        }
    }

}
