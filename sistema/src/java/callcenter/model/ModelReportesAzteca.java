/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

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
 * @author zuagu
 */
public class ModelReportesAzteca {

    public static String reporte_convenios_tabla(String desde, String hasta, String territrio) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_reporte_convenios('" + desde + "', '" + hasta + "', '" + territrio + "');";
            System.out.println(sql);
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
                objConvenio.put("USUARIO", ic.rs.getString("USUARIO"));
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

            return listConvenios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String reporte_promesado_diario(String territorio, String desde) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_promesado_diario('" + territorio + "','" + desde + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listConvenios = new JSONArray();
            // GESTOR, CUENTA, NOMBRE, GERENTE, ESTATUS_LLAMADA, CONVENIO, PAGOS, FECHA, ESTATUS_PAGO, FECHA_PAGO
            while (ic.rs.next()) {
                JSONObject objConvenio = new JSONObject();
                objConvenio.put("GESTOR", ic.rs.getString("GESTOR"));
                objConvenio.put("CUENTA", ic.rs.getString("CUENTA"));
                objConvenio.put("NOMBRE", ic.rs.getString("NOMBRE"));
                objConvenio.put("GERENTE", ic.rs.getString("GERENTE"));
                objConvenio.put("ESTATUS_LLAMADA", ic.rs.getString("ESTATUS_LLAMADA"));
                objConvenio.put("CONVENIO", ic.rs.getString("CONVENIO"));
                objConvenio.put("PAGOS", ic.rs.getString("PAGOS"));
                objConvenio.put("FECHA", ic.rs.getString("FECHA"));
                objConvenio.put("ESTATUS_PAGO", ic.rs.getString("ESTATUS_PAGO"));
                objConvenio.put("FECHA_PAGO", ic.rs.getString("FECHA_PAGO"));
                listConvenios.add(objConvenio);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return listConvenios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String reporte_promesado_al_momento(String territorio, String desde) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_prmesado_al_momento('" + territorio + "','" + desde + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listConvenios = new JSONArray();
            // TERRITORIO, GESTOR, CUENTA, NOMBRE, GERENTE, ESTATUS_LLAMADA, CONVENIO, FECHA_INSET, HORA, ESTATUS_PAGO, FECHA
            while (ic.rs.next()) {
                JSONObject objConvenio = new JSONObject();
                objConvenio.put("GESTOR", ic.rs.getString("GESTOR"));
                objConvenio.put("CUENTA", ic.rs.getString("CUENTA"));
                objConvenio.put("NOMBRE", ic.rs.getString("NOMBRE"));
                objConvenio.put("GERENTE", ic.rs.getString("GERENTE"));
                objConvenio.put("ESTATUS_LLAMADA", ic.rs.getString("ESTATUS_LLAMADA"));
                objConvenio.put("CONVENIO", ic.rs.getString("CONVENIO"));
                objConvenio.put("FECHA_INSET", ic.rs.getString("FECHA_INSET"));
                objConvenio.put("HORA", ic.rs.getString("HORA"));
                objConvenio.put("ESTATUS_PAGO", ic.rs.getString("ESTATUS_PAGO"));
                objConvenio.put("FECHA", ic.rs.getString("FECHA"));
                listConvenios.add(objConvenio);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return listConvenios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String reporte_promesas_incumplidas(String desde) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_promesas_incumplidas('" + desde + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listConvenios = new JSONArray();
            // GERENTE, TOTAL, FECHA, ID_ESTATUS
            while (ic.rs.next()) {
                JSONObject objConvenio = new JSONObject();
                objConvenio.put("GERENTE", ic.rs.getString("GERENTE"));
                objConvenio.put("TOTAL", ic.rs.getString("TOTAL"));
                objConvenio.put("FECHA", ic.rs.getString("FECHA"));
                objConvenio.put("ID_ESTATUS", ic.rs.getString("ID_ESTATUS"));
                objConvenio.put("DIA_SEM", ic.rs.getString("DIA_SEM"));
                listConvenios.add(objConvenio);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return listConvenios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String reporte_promesas_por_gestor(String f_inicio) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_recuperacion_por_gestor('" + f_inicio + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listConvenios = new JSONArray();
            // GESTOR, CONVENIO, PAGOS, FECHA
            while (ic.rs.next()) {
                JSONObject objConvenio = new JSONObject();
                objConvenio.put("GESTOR", ic.rs.getString("GESTOR"));
                objConvenio.put("CONVENIO", ic.rs.getString("CONVENIO"));
                objConvenio.put("PAGOS", ic.rs.getString("PAGOS"));
                objConvenio.put("FECHA", ic.rs.getString("FECHA"));
                objConvenio.put("DIA_SEM", ic.rs.getString("DIA_SEM"));
                listConvenios.add(objConvenio);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return listConvenios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String reporte_gestiones_tabla(String desde, String hasta, String territrio) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_reporte_gestiones('" + desde + "', '" + hasta + "', '" + territrio + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listGestiones = new JSONArray();

            while (ic.rs.next()) {
                JSONObject objGestion = new JSONObject();
                objGestion.put("ID_GESTION", ic.rs.getString("ID_GESTION"));
                objGestion.put("HORA", ic.rs.getString("HORA"));
                objGestion.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objGestion.put("CANAL", ic.rs.getString("CANAL"));
                objGestion.put("FECHA_LARGA", ic.rs.getString("FECHA_LARGA"));
                objGestion.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objGestion.put("CUENTA", ic.rs.getString("CUENTA"));
                objGestion.put("NUMERO_MARCADO", ic.rs.getString("NUMERO_MARCADO"));
                objGestion.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objGestion.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objGestion.put("USUARIO", ic.rs.getString("USUARIO"));
                objGestion.put("GESTION", ic.rs.getString("GESTION"));
                objGestion.put("DURACION", ic.rs.getString("DURACION"));
                objGestion.put("RETASO", ic.rs.getString("RETASO"));
                objGestion.put("PROMESA", ic.rs.getString("PROMESA"));
                objGestion.put("F_PREDICTIVO", ic.rs.getString("F_PREDICTIVO"));
                listGestiones.add(objGestion);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listGestiones.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String reporte_gestiones_descarga(String desde, String hasta, String territrio) throws IOException {
//        String filename = "/var/lib/tomcat8/webapps/sistema/excel/GestionesBaseCrm.csv";
        String filename = "/opt/tomcat/webapps/sistema/excel/GestionesBaseCrm.csv";
//        String filename = "C:\\Users\\Public\\GestionesBaseCrm.csv";
        System.out.println("FILE NAME: " + filename);
        try {
            StartConexion ic = new StartConexion();
            FileWriter fw = new FileWriter(filename);
            String sql = "call azteca_reporte_gestiones('" + desde + "', '" + hasta + "', '" + territrio + "');";
            ic.rs = ic.st.executeQuery(sql);

            fw.append("ID_GESTION");
            fw.append(',');
            fw.append("HORA");
            fw.append(',');
            fw.append("TERRITORIO");
            fw.append(',');
            fw.append("CANAL");
            fw.append(',');
            fw.append("FECHA_LARGA");
            fw.append(',');
            fw.append("ATRASO_MAXIMO");
            fw.append(',');
            fw.append("CUENTA");
            fw.append(',');
            fw.append("NUMERO_MARCADO");
            fw.append(',');
            fw.append("ID_ESTATUS_CUENTA");
            fw.append(',');
            fw.append("ID_ESTATUS_LLAMADA");
            fw.append(',');
            fw.append("USUARIO");
            fw.append(',');
            fw.append("GESTION");
            fw.append(',');
            fw.append("DURACION");
            fw.append(',');
            fw.append("RETASO");
            fw.append(',');
            fw.append("F_PREDICTIVO");
            fw.append('\n');

            while (ic.rs.next()) {
                JSONObject objGestion = new JSONObject();
                fw.append(ic.rs.getString("ID_GESTION"));
                fw.append(',');
                fw.append(ic.rs.getString("HORA"));
                fw.append(',');
                fw.append(ic.rs.getString("TERRITORIO"));
                fw.append(',');
                fw.append(ic.rs.getString("CANAL"));
                fw.append(',');
                fw.append(ic.rs.getString("FECHA_LARGA"));
                fw.append(',');
                fw.append(ic.rs.getString("ATRASO_MAXIMO"));
                fw.append(',');
                fw.append(ic.rs.getString("CUENTA"));
                fw.append(',');
                fw.append(ic.rs.getString("NUMERO_MARCADO"));
                fw.append(',');
                fw.append(ic.rs.getString("ID_ESTATUS_CUENTA"));
                fw.append(',');
                fw.append(ic.rs.getString("ID_ESTATUS_LLAMADA"));
                fw.append(',');
                fw.append(ic.rs.getString("USUARIO"));
                fw.append(',');
                fw.append(ic.rs.getString("GESTION"));
                fw.append(',');
                fw.append(ic.rs.getString("DURACION"));
                fw.append(',');
                fw.append(ic.rs.getString("RETASO"));
                fw.append(',');
                fw.append(ic.rs.getString("F_PREDICTIVO"));
                fw.append('\n');
            }

            fw.flush();
            fw.close();

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return "{\"response\":\"Archivo CSV generado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String reporte_convenios_descarga(String desde, String hasta, String territrio) throws IOException {
//        String filename = "/var/lib/tomcat8/webapps/sistema/excel/ConveniosBaseCrm.csv";
        String filename = "/opt/tomcat/webapps/sistema/excel/ConveniosBaseCrm.csv";
//        String filename = "C:\\Users\\Public\\ConveniosBaseCrm.csv";
        System.out.println("FILE NAME: " + filename);
        try {

            StartConexion ic = new StartConexion();

            FileWriter fw = new FileWriter(filename);
            String sql = "call azteca_reporte_convenios('" + desde + "', '" + hasta + "', '" + territrio + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);

            fw.append("ID_CONVENIO");
            fw.append(',');
            fw.append("CONVENIO");
            fw.append(',');
            fw.append("RESTO");
            fw.append(',');
            fw.append("APLICA");
            fw.append(',');
            fw.append("TERRITORIO");
            fw.append(',');
            fw.append("CANAL");
            fw.append(',');
            fw.append("ATRASO_MAXIMO");
            fw.append(',');
            fw.append("FECHA");
            fw.append(',');
            fw.append("USUARIO");
            fw.append(',');
            fw.append("CUENTA");
            fw.append(',');
            fw.append("ID_ESTATUS");
            fw.append(',');
            fw.append("FECHA_INSET");
            fw.append(',');
            fw.append("PAGOS");
            fw.append(',');
            fw.append("FECHA_PAGO");
            fw.append(',');
            fw.append("EFECTIVIDAD");
            fw.append(',');
            fw.append("ID_EQUIPO");
            fw.append('\n');

            while (ic.rs.next()) {
                fw.append(ic.rs.getString("ID_CONVENIO"));
                fw.append(',');
                fw.append(ic.rs.getString("CONVENIO"));
                fw.append(',');
                fw.append(ic.rs.getString("RESTO"));
                fw.append(',');
                fw.append(ic.rs.getString("APLICA"));
                fw.append(',');
                fw.append(ic.rs.getString("TERRITORIO"));
                fw.append(',');
                fw.append(ic.rs.getString("CANAL"));
                fw.append(',');
                fw.append(ic.rs.getString("ATRASO_MAXIMO"));
                fw.append(',');
                fw.append(ic.rs.getString("FECHA"));
                fw.append(',');
                fw.append(ic.rs.getString("USUARIO"));
                fw.append(',');
                fw.append(ic.rs.getString("CUENTA"));
                fw.append(',');
                fw.append(ic.rs.getString("ID_ESTATUS"));
                fw.append(',');
                fw.append(ic.rs.getString("FECHA_INSET"));
                fw.append(',');
                fw.append(ic.rs.getString("PAGOS"));
                fw.append(',');
                fw.append(ic.rs.getString("FECHA_PAGO"));
                fw.append(',');
                fw.append(ic.rs.getString("EFECTIVIDAD"));
                fw.append(',');
                fw.append(ic.rs.getString("ID_EQUIPO"));
                fw.append('\n');
            }

            fw.flush();
            fw.close();

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return "{\"response\":\"Archivo CSV generado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String azteca_reporte_operacion_descarga(String desde, String hasta) throws IOException {
//        String filename = "/var/lib/tomcat8/webapps/sistema/excel/ReporteOperacionBaseCrm.csv";
        String filename = "/opt/tomcat/webapps/sistema/excel/ReporteOperacionBaseCrm.csv";
//        String filename = "C:\\Users\\Public\\ReporteOperacionBaseCrm.csv";
        System.out.println("FILE NAME: " + filename);
        try {
            StartConexion ic = new StartConexion();

            FileWriter fw = new FileWriter(filename);

            String sql = "SELECT \n"
                    + "	tu.id_usuario,\n"
                    + "    u.nombre,\n"
                    + "    tu.fecha,\n"
                    + "    tu.hora_inicial,\n"
                    + "    tu.tiempo_conectado,\n"
                    + "    week(tu.fecha) as semana\n"
                    + "FROM azteca_tiempos_usuarios tu\n"
                    + "left join arcade_usuarios u on tu.id_usuario = u.id\n"
                    + "where  fecha between '" + desde + "' and '" + hasta + "';";
            System.out.println(sql);

            fw.append("id_usuario");
            fw.append(',');
            fw.append("nombre");
            fw.append(',');
            fw.append("fecha");
            fw.append(',');
            fw.append("hora_inicial");
            fw.append(',');
            fw.append("tiempo_conectado");
            fw.append(',');
            fw.append("semana");
            fw.append('\n');

            ic.rs = ic.st.executeQuery(sql);

            while (ic.rs.next()) {
                fw.append(ic.rs.getString("id_usuario"));
                fw.append(',');
                fw.append(ic.rs.getString("nombre"));
                fw.append(',');
                fw.append(ic.rs.getString("fecha"));
                fw.append(',');
                fw.append(ic.rs.getString("hora_inicial"));
                fw.append(',');
                fw.append(ic.rs.getString("tiempo_conectado"));
                fw.append(',');
                fw.append(ic.rs.getString("semana"));
                fw.append('\n');
            }

            fw.flush();
            fw.close();

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return "{\"response\":\"Archivo CSV generado\"}";
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String azteca_reporte_operacion(String desde, String hasta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT \n"
                    + "	tu.id_usuario,\n"
                    + "    u.nombre,\n"
                    + "    tu.fecha,\n"
                    + "    tu.hora_inicial,\n"
                    + "    tu.tiempo_conectado,\n"
                    + "    week(tu.fecha) as semana\n"
                    + "FROM azteca_tiempos_usuarios tu\n"
                    + "left join arcade_usuarios u on tu.id_usuario = u.id\n"
                    + "where  fecha between '" + desde + "' and '" + hasta + "';";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listUsu = new JSONArray();

            while (ic.rs.next()) {
                JSONObject usu = new JSONObject();
                usu.put("id_usuario", ic.rs.getString("id_usuario"));
                usu.put("nombre", ic.rs.getString("nombre"));
                usu.put("fecha", ic.rs.getString("fecha"));
                usu.put("hora_inicial", ic.rs.getString("hora_inicial"));
                usu.put("tiempo_conectado", ic.rs.getString("tiempo_conectado"));
                usu.put("semana", ic.rs.getString("semana"));
                listUsu.add(usu);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listUsu.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String azteca_reporte_pagos(String desde, String hasta, String zona) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "call azteca_reporte_pagos('" + desde + "', '" + hasta + "',  '" + zona + "')";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listPagos = new JSONArray();

            while (ic.rs.next()) {
                JSONObject objPago = new JSONObject();
                objPago.put("ID_PAGO", ic.rs.getString("ID_PAGO"));
                objPago.put("ANIO", ic.rs.getString("ANIO"));
                objPago.put("SEMANA", ic.rs.getString("SEMANA"));
                objPago.put("DIA", ic.rs.getString("DIA"));
                objPago.put("PAIS", ic.rs.getString("PAIS"));
                objPago.put("CANAL", ic.rs.getString("CANAL"));
                objPago.put("SUCURSAL", ic.rs.getString("SUCURSAL"));
                objPago.put("FOLIO", ic.rs.getString("FOLIO"));
                objPago.put("RECUPERACION_CAPITAL", ic.rs.getString("RECUPERACION_CAPITAL"));
                objPago.put("RECUPERACION_MORATORIOS", ic.rs.getString("RECUPERACION_MORATORIOS"));
                objPago.put("SALDO_ACTUAL", ic.rs.getString("SALDO_ACTUAL"));
                objPago.put("MORATORIO", ic.rs.getString("MORATORIO"));
                objPago.put("FECHA_GESTION", ic.rs.getString("FECHA_GESTION"));
                objPago.put("CARGO_AUTOMATICO", ic.rs.getString("CARGO_AUTOMATICO"));
                objPago.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objPago.put("ZONA", ic.rs.getString("ZONA"));
                objPago.put("GERENTE", ic.rs.getString("GERENTE"));
                objPago.put("ID_GESTOR", ic.rs.getString("ID_GESTOR"));
                listPagos.add(objPago);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listPagos.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }
    // =========================================================================

    public static String select_territorios() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT count(CLIENTE_UNICO) as catidad,TERRITORIO FROM azteca_base_genenral_original where IDENTIFICADOR != '0' GROUP BY TERRITORIO ;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listterri = new JSONArray();
            while (ic.rs.next()) {
                JSONObject territorio = new JSONObject();
                territorio.put("catidad", ic.rs.getString("catidad"));
                territorio.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                listterri.add(territorio);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listterri.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_gerentes(String _territorios) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT count(CLIENTE_UNICO) as catidad,GERENTE FROM azteca_base_genenral_original where IDENTIFICADOR != '0' and TERRITORIO in (" + _territorios.replace("\"", "'") + ") GROUP BY GERENTE;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listgerentes = new JSONArray();
            while (ic.rs.next()) {
                JSONObject gerentes = new JSONObject();
                gerentes.put("catidad", ic.rs.getString("catidad"));
                gerentes.put("GERENTE", ic.rs.getString("GERENTE"));
                listgerentes.add(gerentes);

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listgerentes.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_gerencias(String _territorios, String _gerentes) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT count(CLIENTE_UNICO) as catidad,GERENCIA FROM azteca_base_genenral_original where IDENTIFICADOR != '0' and TERRITORIO in (" + _territorios.replace("\"", "'") + ") and GERENTE in (" + _gerentes.replace("\"", "'") + ") GROUP BY GERENCIA;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listgerencias = new JSONArray();
            while (ic.rs.next()) {
                JSONObject gerencias = new JSONObject();
                gerencias.put("catidad", ic.rs.getString("catidad"));
                gerencias.put("GERENCIA", ic.rs.getString("GERENCIA"));
                listgerencias.add(gerencias);

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listgerencias.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String generar_csv_telefonos(String _tipo_base, String territorio, String gerente, String gerencia) throws IOException {

//        String filename = "/var/lib/tomcat8/webapps/sistema/excel/NumerosBaseCrm.csv";
        String filename = "/opt/tomcat/webapps/sistema/excel/NumerosBaseCrm.csv";
        // /var/lib/tomcat8/webapps/sistema/excel
//        String filename = "C:\\Users\\Public\\NumerosBaseCrm.csv";
        System.out.println("FILE NAME: " + filename);

        try {
            String resultado;
            FileWriter fw = new FileWriter(filename);
            StartConexion s = new StartConexion();
            String sql;
            if (_tipo_base.equals("completo")) {
                sql = "select CLIENTE_UNICO,NOMBRE_CTE,\n"
                        + "NOM_TEL1,TELEFONO1,TELEFONO1_2,\n"
                        + "NOM_TEL2,TELEFONO2,TELEFONO2_2,\n"
                        + "NOM_TEL3,TELEFONO3,TELEFONO3_2,\n"
                        + "NOM_TEL4,TELEFONO4,TELEFONO4_2,\n"
                        + "NOM_TEL5,TELEFONO5,TELEFONO5_2,\n"
                        + "NOMBRE_AVAL,TELAVAL,TELAVAL2 \n"
                        + "from azteca_base_genenral_original where IDENTIFICADOR != '0'";

            } else if (_tipo_base.equals("medio_completo")) {
                sql = "select CLIENTE_UNICO,NOMBRE_CTE,\n"
                        + "NOM_TEL1,TELEFONO1,TELEFONO1_2,\n"
                        + "NOM_TEL2,TELEFONO2,TELEFONO2_2,\n"
                        + "NOM_TEL3,TELEFONO3,TELEFONO3_2,\n"
                        + "NOM_TEL4,TELEFONO4,TELEFONO4_2,\n"
                        + "NOM_TEL5,TELEFONO5,TELEFONO5_2,\n"
                        + "NOMBRE_AVAL,TELAVAL,TELAVAL2 \n"
                        + "from azteca_base_genenral_original where IDENTIFICADOR != '0' and TERRITORIO in (" + territorio.replace("\"", "'") + ") and GERENTE in (" + gerente.replace("\"", "'") + ");";

            } else {
                sql = "select CLIENTE_UNICO,NOMBRE_CTE,\n"
                        + "NOM_TEL1,TELEFONO1,TELEFONO1_2,\n"
                        + "NOM_TEL2,TELEFONO2,TELEFONO2_2,\n"
                        + "NOM_TEL3,TELEFONO3,TELEFONO3_2,\n"
                        + "NOM_TEL4,TELEFONO4,TELEFONO4_2,\n"
                        + "NOM_TEL5,TELEFONO5,TELEFONO5_2,\n"
                        + "NOMBRE_AVAL,TELAVAL,TELAVAL2 \n"
                        + "from azteca_base_genenral_original where IDENTIFICADOR != '0' and TERRITORIO in (" + territorio.replace("\"", "'") + ") and GERENTE in (" + gerente.replace("\"", "'") + ") and GERENCIA in ('" + gerencia.replace("\"", "'") + "');";

            }

            System.out.println(sql);

            fw.append("CLIENTE_UNICO");
            fw.append(',');
            fw.append("NOMBRE_CTE");
            fw.append(',');
            fw.append("NOM_TEL1");
            fw.append(',');
            fw.append("TELEFONO1");
            fw.append(',');
            fw.append("TELEFONO1_2");
            fw.append(',');
            fw.append("NOM_TEL2");
            fw.append(',');
            fw.append("TELEFONO2");
            fw.append(',');
            fw.append("TELEFONO2_2");
            fw.append(',');
            fw.append("NOM_TEL3");
            fw.append(',');
            fw.append("TELEFONO3");
            fw.append(',');
            fw.append("TELEFONO3_2");
            fw.append(',');
            fw.append("NOM_TEL4");
            fw.append(',');
            fw.append("TELEFONO4");
            fw.append(',');
            fw.append("TELEFONO4_2");
            fw.append(',');
            fw.append("NOM_TEL5");
            fw.append(',');
            fw.append("TELEFONO5");
            fw.append(',');
            fw.append("TELEFONO5_2");
            fw.append(',');
            fw.append("NOMBRE_AVAL");
            fw.append(',');
            fw.append("TELAVAL");
            fw.append(',');
            fw.append("TELAVAL2");
            fw.append('\n');

            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                fw.append(s.rs.getString("CLIENTE_UNICO"));
                fw.append(',');
                fw.append(s.rs.getString("NOMBRE_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL1"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO1"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO1_2"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL2"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO2"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO2_2"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL3"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO3"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO3_2"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL4"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO4"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO4_2"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL5"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO5"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO5_2"));
                fw.append(',');
                fw.append(s.rs.getString("NOMBRE_AVAL"));
                fw.append(',');
                fw.append(s.rs.getString("TELAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("TELAVAL2"));
                fw.append('\n');
            }

            fw.flush();
            fw.close();

            s.rs.close();
            s.st.close();
            s.conn.close();
            resultado = "{\"response\":\"Se ha generado la base general en CSV de manera correcta.\"}";
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    // =========================================================================
    public static String select_options_territorios() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT TERRITORIO FROM azteca_base_genenral_original GROUP BY TERRITORIO;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray territorios = new JSONArray();
            while (ic.rs.next()) {
                territorios.add(ic.rs.getString("TERRITORIO"));
//                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return territorios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_options_territorios_convenios() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT TERRITORIO FROM azteca_convenios GROUP BY TERRITORIO;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray territorios = new JSONArray();
            while (ic.rs.next()) {
                territorios.add(ic.rs.getString("TERRITORIO"));
//                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return territorios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_options_zona() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT ZONA FROM azteca_pagos GROUP BY ZONA;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray territorios = new JSONArray();
            while (ic.rs.next()) {
                territorios.add(ic.rs.getString("ZONA"));
//                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return territorios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String select_options_territorios(String objContacto) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objContacto);

            Object _CUENTA = jsonObject.get("_CUENTA");

            StartConexion ic = new StartConexion();
            String sql = "CALL azteca_reporte_convenios();";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
//                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
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

    public static String descargar_base() throws IOException {

//        String filename = "/var/lib/tomcat8/webapps/sistema/excel/BaseAztecaCrm.csv";
        String filename = "/opt/tomcat/webapps/sistema/excel/BaseAztecaCrm.csv";
//        String filename = "C:\\Users\\Public\\BaseAztecaCrm.csv";
        System.out.println("FILE NAME: " + filename);

        try {
            String resultado;
            FileWriter fw = new FileWriter(filename);
            StartConexion s = new StartConexion();
            String sql = "SELECT CLIENTE_UNICO,PLAN, \n"
                    + "    nombre_estatus_llamada_azteca(ID_ESTATUS_LLAMADA) as ESTATUS_LLAMADA, \n"
                    + "    GRUPO,NOMBRE_CTE,EDAD,RANGO_DE_EDAD,ATRASO_MAXIMO,\n"
                    + "    ETAPA,SCORE,SALDO,RANGO,MORATORIOS,\n"
                    + "    SALDO_TOTAL,GERENTE,TERRITORIO,GERENCIA,DIA_DE_PAGO,\n"
                    + "    PRODUCTO,MICRO,ITALICA,CANAL,FECHA_ULTIMO_PAGO,\n"
                    + "    ANO,IMP_ULTIMO_PAGO,ESTADOAVAL,NOMBRE_AVAL,CUADRANTE,\n"
                    + "    RFC_CTE,TELAVAL,TELEFONO1,TIPOTEL1,TELEFONO2,\n"
                    + "    TIPOTEL2,TELEFONO3,TIPOTEL3,TELEFONO4,TIPOTEL4,\n"
                    + "    IDENTIFICADOR2,"
                    + "    nombre_estatus_llamada_azteca(ID_MEJOR_ESTATUS) as MEJOR_ESTATUS,"
                    + "    date_format(ULTIMA_GESTION,'%Y-%m-%d') as FECHA_ULTIMA_GESTION, time(ULTIMA_GESTION) as HORA_ULTIMA_GESTION,\n"
                    + "    nombre_estatus_llamada_azteca(ID_ESTATUS_CUENTA) AS ESTATUS_CUENTA\n"
                    + "FROM azteca_base_genenral_original where IDENTIFICADOR != '0' ORDER BY ULTIMA_GESTION DESC;";
            System.out.println(sql);
            
            fw.append("CLIENTE_UNICO");
            fw.append(',');
            fw.append("PLAN");
            fw.append(',');
            fw.append("ESTATUS_LLAMADA");
            fw.append(',');
            fw.append("GRUPO");
            fw.append(',');
            fw.append("NOMBRE_CTE");
            fw.append(',');
            fw.append("EDAD");
            fw.append(',');
            fw.append("RANGO_DE_EDAD");
            fw.append(',');
            fw.append("ATRASO_MAXIMO");
            fw.append(',');
            fw.append("ETAPA");
            fw.append(',');
            fw.append("SCORE");
            fw.append(',');
            fw.append("SALDO");
            fw.append(',');
            fw.append("RANGO");
            fw.append(',');
            fw.append("MORATORIOS");
            fw.append(',');
            fw.append("SALDO_TOTAL");
            fw.append(',');
            fw.append("GERENTE");
            fw.append(',');
            fw.append("TERRITORIO");
            fw.append(',');
            fw.append("GERENCIA");
            fw.append(',');
            fw.append("DIA_DE_PAGO");
            fw.append(',');
            fw.append("PRODUCTO");
            fw.append(',');
            fw.append("MICRO");
            fw.append(',');
            fw.append("ITALICA");
            fw.append(',');
            fw.append("CANAL");
            fw.append(',');
            fw.append("FECHA_ULTIMO_PAGO");
            fw.append(',');
            fw.append("ANO");
            fw.append(',');
            fw.append("IMP_ULTIMO_PAGO");
            fw.append(',');
            fw.append("ESTADOAVAL");
            fw.append(',');
            fw.append("NOMBRE_AVAL");
            fw.append(',');
            fw.append("CUADRANTE");
            fw.append(',');
            fw.append("RFC_CTE");
            fw.append(',');
            fw.append("TELAVAL");
            fw.append(',');
            fw.append("TELEFONO1");
            fw.append(',');
            fw.append("TIPOTEL1");
            fw.append(',');
            fw.append("TELEFONO2");
            fw.append(',');
            fw.append("TIPOTEL2");
            fw.append(',');
            fw.append("TELEFONO3");
            fw.append(',');
            fw.append("TIPOTEL3");
            fw.append(',');
            fw.append("TELEFONO4");
            fw.append(',');
            fw.append("TIPOTEL4");
            fw.append(',');
            fw.append("IDENTIFICADOR2");
            fw.append(',');
            fw.append("MEJOR_ESTATUS");
            fw.append(',');
            fw.append("FECHA_ULTIMA_GESTION");
            fw.append(',');
            fw.append("HORA_ULTIMA_GESTION");
            fw.append(',');
            fw.append("ESTATUS_ACT_CUENTA");
            fw.append('\n');

            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                fw.append(s.rs.getString("CLIENTE_UNICO"));
                fw.append(',');
                fw.append(s.rs.getString("PLAN"));
                fw.append(',');
                fw.append(s.rs.getString("ESTATUS_LLAMADA"));
                fw.append(',');
                fw.append(s.rs.getString("GRUPO"));
                fw.append(',');
                fw.append(s.rs.getString("NOMBRE_CTE").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("EDAD").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("RANGO_DE_EDAD").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("ATRASO_MAXIMO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("ETAPA").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("SCORE").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("SALDO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("RANGO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("MORATORIOS").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("SALDO_TOTAL").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("GERENTE").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TERRITORIO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("GERENCIA").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("DIA_DE_PAGO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("PRODUCTO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("MICRO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("ITALICA").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("CANAL").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("FECHA_ULTIMO_PAGO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("ANO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("IMP_ULTIMO_PAGO").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("ESTADOAVAL").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("NOMBRE_AVAL").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("CUADRANTE").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("RFC_CTE").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TELAVAL").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO1").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL1").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO2").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL2").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO3").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL3").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO4").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL4").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("IDENTIFICADOR2").replace("\n", "") );
                fw.append(',');
                fw.append(s.rs.getString("MEJOR_ESTATUS") );
                fw.append(',');
                fw.append(s.rs.getString("FECHA_ULTIMA_GESTION") );
                fw.append(',');
                fw.append(s.rs.getString("HORA_ULTIMA_GESTION") );
                fw.append(',');
                fw.append(s.rs.getString("ESTATUS_CUENTA").replace("\n", "") );
                fw.append('\n');
            }

            fw.flush();
            fw.close();

            s.rs.close();
            s.st.close();
            s.conn.close();
            resultado = "{\"response\":\"Se ha generado la base general en CSV de manera correcta.\"}";
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

}
