package callcenter.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class ModelGestor {

    public static String select_buscar_cuentas(String _busqueda, int id_puesto) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_buscar_cuentas('" + _busqueda + "'," + id_puesto + " );";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray cuentas = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject cuenta = new JSONObject();

                cuenta.put("id_cuenta", inicioConexion.rs.getInt("id_cuenta"));
                cuenta.put("cuenta", inicioConexion.rs.getString("cuenta"));
                cuenta.put("nombre", inicioConexion.rs.getString("nombre"));
                cuenta.put("expediente", inicioConexion.rs.getString("expediente"));
                cuenta.put("referencia1", inicioConexion.rs.getString("referencia1"));
                cuenta.put("referencia2", inicioConexion.rs.getString("referencia2"));
                cuenta.put("asignacion", inicioConexion.rs.getString("asignacion"));
                cuenta.put("ultimo_estatus_cuenta", inicioConexion.rs.getString("ultimo_estatus_cuenta"));
                cuenta.put("ultimo_estatus_llamada", inicioConexion.rs.getString("ultimo_estatus_llamada"));

                cuentas.add(cuenta);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return cuentas.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String select_datos_cuenta(String id_cuenta) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_datos_cuenta(" + id_cuenta + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject dato = new JSONObject();
            JSONObject telefonos = new JSONObject();
            while (inicioConexion.rs.next()) {
                dato.put("id_cuenta_deudor", inicioConexion.rs.getInt("id_cuenta"));
                dato.put("id_asignacion_deudor", inicioConexion.rs.getInt("id_asignacion"));
                dato.put("id_region_deudor", inicioConexion.rs.getInt("id_region"));
                dato.put("id_cliente_deudor", inicioConexion.rs.getInt("id_cliente"));
                dato.put("fecha_fin_deudor", inicioConexion.rs.getString("fecha_fin"));

                dato.put("cuenta_deudor", inicioConexion.rs.getInt("cuenta"));
                dato.put("nombre_deudor", inicioConexion.rs.getString("nombre"));
                dato.put("expediente_deudor", inicioConexion.rs.getString("expediente"));
                dato.put("resto_deudor", "$" + inicioConexion.rs.getString("resto"));
                dato.put("cancelacion_deudor", "$" + inicioConexion.rs.getString("cancelacion"));
                dato.put("vencido_deudor", "$" + inicioConexion.rs.getString("vencido"));
                dato.put("pagado_deudor", "$" + inicioConexion.rs.getString("pagado"));
                dato.put("penafineq_deudor", "$" + inicioConexion.rs.getString("pena_fineq"));
                dato.put("penakitbp_deudor", "$" + inicioConexion.rs.getString("pena_kip_bp"));
                dato.put("ult_pago_deudor", inicioConexion.rs.getString("fecha_ultimo_pago"));
                dato.put("plazo_deudor", inicioConexion.rs.getString("plazo"));
                dato.put("cuentas_dobles_deudor", inicioConexion.rs.getString("cuentas_multiples"));
                dato.put("total_cuentas_deudor", "$" + inicioConexion.rs.getString("importe_cuentas_multiples"));
                dato.put("inicio_deudor", inicioConexion.rs.getString("fecha_inicio"));
                dato.put("devolucion_deudor", inicioConexion.rs.getString("fecha_fin"));
                dato.put("asignacion_deudor", inicioConexion.rs.getString("asignacion"));
                dato.put("plan_deudor", inicioConexion.rs.getString("plan"));
                dato.put("equipo_deudor", inicioConexion.rs.getString("equipo"));
                dato.put("baja_deudor", inicioConexion.rs.getString("motivo_baja"));
                dato.put("direccion_deudor", inicioConexion.rs.getString("direcion"));
                dato.put("status", inicioConexion.rs.getString("estatus"));
                dato.put("ref_bancaria1", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria2", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria3", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria4", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria5", inicioConexion.rs.getString("ref_bancaria"));

                telefonos.put("T1", inicioConexion.rs.getString("t1"));
                telefonos.put("T2", inicioConexion.rs.getString("t2"));
                telefonos.put("R1", inicioConexion.rs.getString("tel_referencia1"));
                telefonos.put("R2", inicioConexion.rs.getString("tel_referencia2"));
                dato.put("telefonos", telefonos);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
//            System.out.println(dato.toJSONString());
            return dato.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String select_datos_cuenta_relacionada(String id_cuenta) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_datos_cuenta_2(" + id_cuenta + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject dato = new JSONObject();
            JSONObject telefonos = new JSONObject();
            while (inicioConexion.rs.next()) {
                dato.put("id_cuenta_deudor", inicioConexion.rs.getInt("id_cuenta"));
                dato.put("id_asignacion_deudor", inicioConexion.rs.getInt("id_asignacion"));
                dato.put("id_region_deudor", inicioConexion.rs.getInt("id_region"));
                dato.put("id_cliente_deudor", inicioConexion.rs.getInt("id_cliente"));
                dato.put("fecha_fin_deudor", inicioConexion.rs.getString("fecha_fin"));

                dato.put("cuenta_deudor", inicioConexion.rs.getInt("cuenta"));
                dato.put("nombre_deudor", inicioConexion.rs.getString("nombre"));
                dato.put("expediente_deudor", inicioConexion.rs.getString("expediente"));
                dato.put("resto_deudor", "$" + inicioConexion.rs.getString("resto"));
                dato.put("cancelacion_deudor", "$" + inicioConexion.rs.getString("cancelacion"));
                dato.put("vencido_deudor", "$" + inicioConexion.rs.getString("vencido"));
                dato.put("pagado_deudor", "$" + inicioConexion.rs.getString("pagado"));
                dato.put("penafineq_deudor", "$" + inicioConexion.rs.getString("pena_fineq"));
                dato.put("penakitbp_deudor", "$" + inicioConexion.rs.getString("pena_kip_bp"));
                dato.put("ult_pago_deudor", inicioConexion.rs.getString("fecha_ultimo_pago"));
                dato.put("plazo_deudor", inicioConexion.rs.getString("plazo"));
                dato.put("cuentas_dobles_deudor", inicioConexion.rs.getString("cuentas_multiples"));
                dato.put("total_cuentas_deudor", "$" + inicioConexion.rs.getString("importe_cuentas_multiples"));
                dato.put("inicio_deudor", inicioConexion.rs.getString("fecha_inicio"));
                dato.put("devolucion_deudor", inicioConexion.rs.getString("fecha_fin"));
                dato.put("asignacion_deudor", inicioConexion.rs.getString("asignacion"));
                dato.put("plan_deudor", inicioConexion.rs.getString("plan"));
                dato.put("equipo_deudor", inicioConexion.rs.getString("equipo"));
                dato.put("baja_deudor", inicioConexion.rs.getString("motivo_baja"));
                dato.put("direccion_deudor", inicioConexion.rs.getString("direcion"));
                dato.put("status", inicioConexion.rs.getString("estatus"));
                dato.put("ref_bancaria1", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria2", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria3", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria4", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria5", inicioConexion.rs.getString("ref_bancaria"));

                telefonos.put("T1", inicioConexion.rs.getString("t1"));
                telefonos.put("T2", inicioConexion.rs.getString("t2"));
                telefonos.put("R1", inicioConexion.rs.getString("tel_referencia1"));
                telefonos.put("R2", inicioConexion.rs.getString("tel_referencia2"));
                dato.put("telefonos", telefonos);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return dato.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String select_telefonos_cr(String id_cuenta) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select numero_relacionado, nombre from arcade_cuentas_relacionadas where cuenta = " + id_cuenta + ";";
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
//            System.out.println(sql);
            JSONArray tel_cr = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject dato = new JSONObject();
                dato.put("nombre", inicioConexion.rs.getString("nombre"));
                dato.put("telefono", inicioConexion.rs.getString("numero_relacionado"));
                tel_cr.add(dato);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return tel_cr.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String select_gestiones_cuenta(String id_cuenta, String fecha_inicio) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_gestiones_cuenta(" + id_cuenta + ",'" + fecha_inicio + "');";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray gestiones = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject gestion = new JSONObject();
                gestion.put("fecha", inicioConexion.rs.getString("fecha"));
                gestion.put("hora", inicioConexion.rs.getString("hora"));
                gestion.put("numero_marcado", inicioConexion.rs.getString("numero_marcado"));
                gestion.put("estatus_cuenta", inicioConexion.rs.getString("estatus_cuenta"));
                gestion.put("estatus_llamada", inicioConexion.rs.getString("estatus_llamada"));
                gestion.put("gestor", inicioConexion.rs.getString("gestor"));
                gestion.put("gestion", inicioConexion.rs.getString("gestion"));
                gestion.put("duracion", inicioConexion.rs.getString("duracion"));
                gestion.put("f_predictivo", inicioConexion.rs.getInt("f_predictivo"));
                gestiones.add(gestion);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gestiones.toString();
        } catch (Exception e) {
            return "sql code" + e;
        }
    }

    public static String select_pagos_cuenta(String cuenta, String fecha_inicio) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select\n"
                    + "id_pago,\n"
                    + "cuenta, fecha_pago, origen, importe, forma, status, fecha_aplicacion\n"
                    + "from arcade_pagos where cuenta = " + cuenta + "\n"
                    + "and fecha_aplicacion >='" + fecha_inicio + "';";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray pagos = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject pago = new JSONObject();
                pago.put("id_pago", inicioConexion.rs.getInt("id_pago"));
                pago.put("cuenta", inicioConexion.rs.getString("cuenta"));
                pago.put("fecha_pago", inicioConexion.rs.getString("fecha_pago"));
                pago.put("origen", inicioConexion.rs.getString("origen"));
                pago.put("importe", inicioConexion.rs.getString("importe"));
                pago.put("forma", inicioConexion.rs.getString("forma"));
                pago.put("status", inicioConexion.rs.getString("status"));
                pago.put("fecha_aplicacion", inicioConexion.rs.getString("fecha_aplicacion"));
                pagos.add(pago);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return pagos.toString();
        } catch (Exception e) {
            return "sql code" + e;
        }
    }

    public static String mostrar_pagos_diarios(String desde, String hasta, String id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_pagos_diarios_gestor(" + id_usuario + ",'" + desde + "','" + hasta + "');";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray pagos = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject pago = new JSONObject();
                pago.put("fecha", inicioConexion.rs.getString("fecha"));
                pago.put("asignacion", inicioConexion.rs.getString("asignacion"));
                pago.put("cuenta", inicioConexion.rs.getString("cuenta"));
                pago.put("nombre_equipo", inicioConexion.rs.getString("nombre_equipo"));
                pago.put("vencido", inicioConexion.rs.getFloat("vencido"));
                pago.put("resto", inicioConexion.rs.getFloat("resto"));
                pago.put("pago", inicioConexion.rs.getFloat("pago"));
                pago.put("aplica", inicioConexion.rs.getFloat("aplica"));
                pago.put("resto_actual", inicioConexion.rs.getFloat("resto_actual"));
                pago.put("id_asignacion", inicioConexion.rs.getInt("id_asignacion"));

                pagos.add(pago);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return pagos.toString();
        } catch (Exception e) {
            return "sql code" + e;
        }
    }

    public static String select_convenios_cuenta(String id_cuenta) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_convenio_cuenta(" + id_cuenta + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray convenios = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject convenio = new JSONObject();
                convenio.put("id_convenio", inicioConexion.rs.getString("id_convenio"));
                convenio.put("cuenta", inicioConexion.rs.getString("cuenta"));
                convenio.put("usuario", inicioConexion.rs.getString("usuario"));
                convenio.put("convenio", inicioConexion.rs.getString("convenio"));
                convenio.put("fecha_gestion", inicioConexion.rs.getString("fecha_gestion"));
                convenio.put("plazo", inicioConexion.rs.getString("plazo"));
                convenio.put("fecha_convenio", inicioConexion.rs.getString("fecha_convenio"));
                convenio.put("pagos", inicioConexion.rs.getString("pagos"));
                convenio.put("fecha_pago", inicioConexion.rs.getString("fecha_pago"));
                convenio.put("efectividad", inicioConexion.rs.getString("efectividad"));
                convenio.put("estatus", inicioConexion.rs.getString("estatus"));
                convenio.put("id_estatus", inicioConexion.rs.getInt("id_estatus"));
                convenios.add(convenio);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return convenios.toString();
        } catch (Exception e) {
            return "sql code" + e;
        }
    }

    public static String select_gestor_tabla() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call arcade_select_gestor();";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray equipos = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject equipo = new JSONObject();
                equipo.put("id", inicioConexion.rs.getInt("id"));
                equipo.put("nombre", inicioConexion.rs.getString("nombre"));
                equipo.put("alias", inicioConexion.rs.getString("alias"));
                equipo.put("id_nodo", inicioConexion.rs.getInt("id_nodo"));
                equipo.put("descripcion", inicioConexion.rs.getString("descripcion"));
                equipos.add(equipo);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipos.toString();
        } catch (Exception e) {
            return "sql code" + e;
        }
    }

    public static String select_gestor_tabla_filtro(String _filtro) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call arcade_select_gestor_filtro('" + _filtro + "');";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray equipos = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject equipo = new JSONObject();
                equipo.put("id", inicioConexion.rs.getInt("id"));
                equipo.put("nombre", inicioConexion.rs.getString("nombre"));
                equipo.put("alias", inicioConexion.rs.getString("alias"));
                equipo.put("id_nodo", inicioConexion.rs.getInt("id_nodo"));
                equipo.put("descripcion", inicioConexion.rs.getString("descripcion"));
                equipos.add(equipo);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipos.toString();
        } catch (Exception e) {
            return "sql code" + e;
        }
    }

    public static String select_cuenta_siguiente(String id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_cuenta_siguiente(" + id_usuario + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject dato = new JSONObject();
            JSONObject telefonos = new JSONObject();
            while (inicioConexion.rs.next()) {
                dato.put("id_cuenta_deudor", inicioConexion.rs.getInt("id_cuenta"));
                dato.put("id_asignacion_deudor", inicioConexion.rs.getInt("id_asignacion"));
                dato.put("id_region_deudor", inicioConexion.rs.getInt("id_region"));
                dato.put("id_cliente_deudor", inicioConexion.rs.getInt("id_cliente"));
                dato.put("fecha_fin_deudor", inicioConexion.rs.getString("fecha_fin"));

                dato.put("cuenta_deudor", inicioConexion.rs.getInt("cuenta"));
                dato.put("nombre_deudor", inicioConexion.rs.getString("nombre"));
                dato.put("expediente_deudor", inicioConexion.rs.getString("expediente"));
                dato.put("resto_deudor", "$" + inicioConexion.rs.getString("resto"));
                dato.put("cancelacion_deudor", "$" + inicioConexion.rs.getString("cancelacion"));
                dato.put("vencido_deudor", "$" + inicioConexion.rs.getString("vencido"));
                dato.put("pagado_deudor", "$" + inicioConexion.rs.getString("pagado"));
                dato.put("penafineq_deudor", "$" + inicioConexion.rs.getString("pena_fineq"));
                dato.put("penakitbp_deudor", "$" + inicioConexion.rs.getString("pena_kip_bp"));
                dato.put("ult_pago_deudor", inicioConexion.rs.getString("fecha_ultimo_pago"));
                dato.put("plazo_deudor", inicioConexion.rs.getString("plazo"));
                dato.put("cuentas_dobles_deudor", inicioConexion.rs.getString("cuentas_multiples"));
                dato.put("total_cuentas_deudor", "$" + inicioConexion.rs.getString("importe_cuentas_multiples"));
                dato.put("inicio_deudor", inicioConexion.rs.getString("fecha_inicio"));
                dato.put("devolucion_deudor", inicioConexion.rs.getString("fecha_fin"));
                dato.put("asignacion_deudor", inicioConexion.rs.getString("asignacion"));
                dato.put("plan_deudor", inicioConexion.rs.getString("plan"));
                dato.put("equipo_deudor", inicioConexion.rs.getString("equipo"));
                dato.put("baja_deudor", inicioConexion.rs.getString("motivo_baja"));
                dato.put("direccion_deudor", inicioConexion.rs.getString("direcion"));
                dato.put("status", inicioConexion.rs.getString("estatus"));
                dato.put("ref_bancaria1", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria2", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria3", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria4", inicioConexion.rs.getString("ref_bancaria"));
                dato.put("ref_bancaria5", inicioConexion.rs.getString("ref_bancaria"));

                telefonos.put("T1", inicioConexion.rs.getString("t1"));
                telefonos.put("T2", inicioConexion.rs.getString("t2"));
                telefonos.put("R1", inicioConexion.rs.getString("tel_referencia1"));
                telefonos.put("R2", inicioConexion.rs.getString("tel_referencia2"));
                dato.put("telefonos", telefonos);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return dato.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String guardar_gestion(String datos) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(datos);
//            System.out.println(jsonObject);

            Object id_cliente = jsonObject.get("id_cliente");
            Object id_asignacion = jsonObject.get("id_asignacion");
            Object id_region = jsonObject.get("id_region");
            Object id_cuenta = jsonObject.get("id_cuenta");
            Object fecha_fin = jsonObject.get("fecha_fin");
            Object cuenta = jsonObject.get("cuenta");
            Object numero_marcado = jsonObject.get("numero_marcado");
            Object id_estatus_cuenta = jsonObject.get("id_estatus_cuenta");
            Object id_estatus_llamada = jsonObject.get("id_estatus_llamada");
            Object id_usuario = jsonObject.get("id_usuario");
            Object id_puesto = jsonObject.get("id_puesto");
            Object gestion = jsonObject.get("gestion");
            Object duracion = jsonObject.get("duracion");
            Object retraso_llamada = jsonObject.get("retraso_llamada");
            Object expediente = jsonObject.get("expediente");
            Object f_predictivo = jsonObject.get("f_predictivo");

            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_insertar_gestion(\n"
                    + id_cliente + ",\n"
                    + id_asignacion + ",\n"
                    + id_region + ",\n"
                    + id_cuenta + ",\n"
                    + "'" + fecha_fin + "',\n"
                    + cuenta + ",\n"
                    + "'" + numero_marcado + "',\n"
                    + id_estatus_cuenta + ",\n"
                    + id_estatus_llamada + ",\n"
                    + id_usuario + ",\n"
                    + id_puesto + ",\n"
                    + "'" + gestion + "',\n"
                    + "'" + duracion + "',\n"
                    + "'" + retraso_llamada + "',\n"
                    + "'" + expediente + "',\n"
                    + "'" + f_predictivo + "'\n"
                    + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject dato = new JSONObject();
            while (inicioConexion.rs.next()) {
                dato.put("resultado", inicioConexion.rs.getString("resultado"));
            }
//            System.out.println(dato);

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return dato.toJSONString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String insertar_convenio(String datos) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(datos);
//            System.out.println(jsonObject);

            Object convenio = jsonObject.get("convenio");
            Object fecha = jsonObject.get("fecha");
            Object id_usuario = jsonObject.get("id_usuario");
            Object cuenta = jsonObject.get("cuenta");
            Object id_asignacion = jsonObject.get("id_asignacion");
            Object id_region = jsonObject.get("id_region");

            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_insert_convenio(" + convenio + ","
                    + "'" + fecha + "', "
                    + id_usuario + ", "
                    + cuenta + ", "
                    + id_asignacion + ", "
                    + id_region + ")";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject dato = new JSONObject();
            while (inicioConexion.rs.next()) {
                dato.put("resultado", inicioConexion.rs.getString("resultado"));
            }
//            System.out.println(dato);

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return dato.toJSONString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String select_saldos_gestores(String id_usuario, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_saldos_gestores(" + id_usuario + "," + id_equipo + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray grupos = new JSONArray();
            // color, region, estatus, ultimo_estatus_cuenta, cuentas, valor, ultimo_toque, grupo
            while (inicioConexion.rs.next()) {
                JSONObject grupo = new JSONObject();
                grupo.put("color", inicioConexion.rs.getString("color"));
                grupo.put("region", inicioConexion.rs.getString("region"));
                grupo.put("estatus", inicioConexion.rs.getString("estatus"));
                grupo.put("ultimo_estatus_cuenta", inicioConexion.rs.getString("ultimo_estatus_cuenta"));
                grupo.put("cuentas", inicioConexion.rs.getString("cuentas"));
                grupo.put("valor", inicioConexion.rs.getFloat("valor"));
                grupo.put("ultimo_toque", inicioConexion.rs.getString("ultimo_toque"));
                grupo.put("grupo", inicioConexion.rs.getString("grupo"));
                grupos.add(grupo);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return grupos.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_cuentas_de_estaus(String id_equipo, String id_status, String id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_cuentas_estatus_gestor(" + id_usuario + ", " + id_equipo + ", " + id_status + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray grupos = new JSONArray();
            // region, cuenta, estatus, resto, ultima_gestion
            while (inicioConexion.rs.next()) {
                JSONObject grupo = new JSONObject();
                grupo.put("region", inicioConexion.rs.getString("region"));
                grupo.put("cuenta", inicioConexion.rs.getString("cuenta"));
                grupo.put("estatus", inicioConexion.rs.getString("estatus"));
                grupo.put("resto", inicioConexion.rs.getFloat("resto"));
                grupo.put("ultima_gestion", inicioConexion.rs.getString("ultima_gestion"));
                grupos.add(grupo);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return grupos.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_equipos_usuario(String id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_equipos_usuario(" + id_usuario + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray grupos = new JSONArray();
            // id_equipo, id_asignacion, asignacion, equipo, cuentas, asignado
            while (inicioConexion.rs.next()) {
                JSONObject grupo = new JSONObject();
                grupo.put("id_equipo", inicioConexion.rs.getInt("id_equipo"));
                grupo.put("id_asignacion", inicioConexion.rs.getInt("id_asignacion"));
                grupo.put("asignacion", inicioConexion.rs.getString("asignacion"));
                grupo.put("equipo", inicioConexion.rs.getString("equipo"));
                grupo.put("cuentas", inicioConexion.rs.getInt("cuentas"));
                grupo.put("asignado", inicioConexion.rs.getFloat("asignado"));
                grupos.add(grupo);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return grupos.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_llamadas_gestor(String id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_llamadas_gestor(" + id_usuario + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject llamada = new JSONObject();
            // llamadas, cuentas, convenios, hora
            while (inicioConexion.rs.next()) {
                llamada.put("llamadas", inicioConexion.rs.getInt("llamadas"));
                llamada.put("cuentas", inicioConexion.rs.getInt("cuentas"));
                llamada.put("convenios", inicioConexion.rs.getInt("convenios"));
                llamada.put("hora", inicioConexion.rs.getString("hora"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return llamada.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String insertar_agenda(String cliente_unico, String id_usuario, String descripcion, String fecha, String hora) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call azteca_insertar_agenda('" + cliente_unico + "', " + id_usuario + ", '" + descripcion + "', '" + fecha + "', '" + hora + ":00');";
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
                    + "FROM azteca_registro_agenda WHERE ID_GESTOR = " + id_gestor + " AND F_ACTIVE = 1 AND DATE(FECHA_AGENDA) = CURDATE() ;";
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

    public static String descartar_agenda_gestor(String id_reg) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "UPDATE azteca_registro_agenda SET F_ACTIVE = '0' WHERE (`ID_REGISTRO` = '" + id_reg + "');";
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
