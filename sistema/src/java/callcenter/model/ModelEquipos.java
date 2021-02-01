package callcenter.model;

import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class ModelEquipos {

    public static String select_equipo_tabla() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call arcade_select_equipo();";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray equipos = new JSONArray();
            // id_equipo, equipo, descripcion, cuentas, asignacion, importe
            while (inicioConexion.rs.next()) {
                JSONObject equipo = new JSONObject();
                equipo.put("id_equipo", inicioConexion.rs.getInt("id_equipo"));
                equipo.put("equipo", inicioConexion.rs.getString("equipo"));
                equipo.put("descripcion", inicioConexion.rs.getString("descripcion"));
                equipo.put("cuentas", inicioConexion.rs.getString("cuentas"));
                equipo.put("asignacion", inicioConexion.rs.getString("asignacion"));
                equipo.put("importe", inicioConexion.rs.getString("importe"));
                equipos.add(equipo);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipos.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String agregar_gestor_equipo(int id_equipo, int id_gestor) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String resultado = "";
            String sql = "call arcade_agregar_gestor_equipo('" + id_equipo + "', '" + id_gestor + "');";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                resultado = (inicioConexion.rs.getString("resultado"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String select_usuarios_equipo(int id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call arcade_select_equipo_usuarios('" + id_equipo + "');";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray usuarios = new JSONArray();
            // id_equipo, equipo, descripcion, cuentas, asignacion, importe
            while (inicioConexion.rs.next()) {
                JSONObject usuario = new JSONObject();
                usuario.put("id_equipo", inicioConexion.rs.getInt("id_equipo"));
                usuario.put("id_usuario", inicioConexion.rs.getInt("id_usuario"));
                usuario.put("usuario", inicioConexion.rs.getString("usuario"));
                usuarios.add(usuario);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return usuarios.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String delete_usuario_equipo(int id_equipo, int id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call arcade_delete_usuario_equipo('" + id_usuario + "', '" + id_equipo + "');";
            System.out.println(sql);
            JSONObject usuario = new JSONObject();
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                usuario.put("respuesta", inicioConexion.rs.getString("resultado"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return usuario.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String select_regiones() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select id_region, region from arcade_regiones_clientes where id_cliente = 1;";
            System.out.println(sql);
            JSONArray regiones = new JSONArray();
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                JSONObject region = new JSONObject();
                region.put("id_region", inicioConexion.rs.getInt("id_region"));
                region.put("region", inicioConexion.rs.getString("region"));
                regiones.add(region);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            System.out.println(regiones);
            return regiones.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String select_asignaciones_region(int id_region) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select id_asignacion, asignacion from arcade_asignaciones where f_active = 1 and id_region = " + id_region + ";";
            System.out.println(sql);
            JSONArray asignaciones = new JSONArray();
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                JSONObject asignacion = new JSONObject();
                asignacion.put("id_asignacion", inicioConexion.rs.getInt("id_asignacion"));
                asignacion.put("asignacion", inicioConexion.rs.getString("asignacion"));
                asignaciones.add(asignacion);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return asignaciones.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String select_ciclos_asignacion(int id_asignacion) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select columna10 from arcade_basegeneral where id_asignacion = " + id_asignacion + " group by columna10;";
            System.out.println(sql);
            JSONArray ciclos = new JSONArray();
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                JSONObject ciclo = new JSONObject();
                ciclo.put("ciclo", inicioConexion.rs.getInt("columna10"));
                ciclos.add(ciclo);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return ciclos.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String select_estados_ciclos(int id_asignacion, String cadena_ciclos) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select columna35 from arcade_basegeneral where id_asignacion = " + id_asignacion + " and columna10 in (" + cadena_ciclos + ") group by columna35;";
            System.out.println(sql);
            JSONArray estados = new JSONArray();
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                JSONObject estado = new JSONObject();
                estado.put("estado", inicioConexion.rs.getString("columna35"));
                estados.add(estado);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return estados.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String select_status_estados(int id_asignacion, String cadena_ciclos, String cadena_estados) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select ultimo_estatus_cuenta, nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus "
                    + "from arcade_basegeneral \n"
                    + "where id_asignacion = " + id_asignacion + " and columna10 in (" + cadena_ciclos + ")"
                    + "and columna35 in (" + cadena_estados + ") group by ultimo_estatus_cuenta;";
            System.out.println(sql);
            JSONArray status = new JSONArray();
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                JSONObject statu = new JSONObject();
                statu.put("id_estatus_cuenta", inicioConexion.rs.getInt("ultimo_estatus_cuenta"));
                statu.put("estatus", inicioConexion.rs.getString("estatus"));
                status.add(statu);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return status.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static void asignar_equipo(String sql) {
        try {
            StartConexion inicioConexion = new StartConexion();
            inicioConexion.st.executeUpdate(sql);
            System.out.println(sql);
            inicioConexion.st.close();
            inicioConexion.conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static String crear_equipo_especial(int id_asignacion, String cadena_ciclos, String cadena_estados, String cadena_status, String con_cr, String monto) {
        try {
            StartConexion inicioConexion = new StartConexion();
            int _id_equipo = 0;
            inicioConexion.rs = inicioConexion.st.executeQuery("call arcade_insert_equipo();");
            String sql_id_new_equipo = "select id_equipo from arcade_equipos order by id_equipo desc limit 1;";
            System.out.println(sql_id_new_equipo);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql_id_new_equipo);
            while (inicioConexion.rs.next()) {
                _id_equipo = inicioConexion.rs.getInt("id_equipo");
            }
            String sql = "update arcade_basegeneral "
                    + "set id_equipo = " + _id_equipo + " \n"
                    + "where id_asignacion = " + id_asignacion + "\n"
                    + "	and columna10 in (" + cadena_ciclos.replace("'", "\\'") + ")\n"
                    + "    and columna35 in (" + cadena_estados.replace("'", "\\'") + ")\n"
                    + "    and ultimo_estatus_cuenta in (" + cadena_status.replace("'", "\\'") + ")\n"
                    + "    and tiene_cr in (" + con_cr + ")\n"
                    + "    and resto >= " + monto + ";";
            
            System.out.println("call sic_crear_equipo_especial('"+ sql +"')");
            inicioConexion.rs = inicioConexion.st.executeQuery("call sic_crear_equipo_especial('"+ sql +"')");
            
            
            JSONObject mensaje = new JSONObject();
            mensaje.put("mensaje", "Las cuentas fueron asignadas al equipo " + _id_equipo + " correctamente");
            mensaje.put("id_equipo_nuevo", _id_equipo);

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return mensaje.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String ver_cuentas_nuevo_equipo_especial(int id_asignacion, String cadena_ciclos, String cadena_estados, String cadena_status, String con_cr, String monto) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select \n"
                    + "	columna1 as cuenta,\n"
                    + "    columna10 as ciclo,\n"
                    + "    columna35 as estado,\n"
                    + "    nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus,\n"
                    + "    if(tiene_cr = 1, 'Si','No') as tiene_cr,\n"
                    + "    resto\n"
                    + "from arcade_basegeneral \n"
                    + "where id_asignacion = " + id_asignacion + "\n"
                    + "	and columna10 in (" + cadena_ciclos + ")\n"
                    + "    and columna35 in (" + cadena_estados + ")\n"
                    + "    and ultimo_estatus_cuenta in (" + cadena_status + ")\n"
                    + "    and tiene_cr in (" + con_cr + ")\n"
                    + "    and resto >= " + monto + ";";
            System.out.println(sql);

            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray cuentas = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject cuenta = new JSONObject();
                cuenta.put("cuenta", inicioConexion.rs.getString("cuenta"));
                cuenta.put("ciclo", inicioConexion.rs.getString("ciclo"));
                cuenta.put("estado", inicioConexion.rs.getString("estado"));
                cuenta.put("estatus", inicioConexion.rs.getString("estatus"));
                cuenta.put("tiene_cr", inicioConexion.rs.getString("tiene_cr"));
                cuenta.put("resto", inicioConexion.rs.getString("resto"));
                cuentas.add(cuenta);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return cuentas.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String guardar_registro_equipo(int id_asignacion, String cadena_ciclos, String cadena_estados, String cadena_status, String con_cr, String monto, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            JSONObject registro = new JSONObject();
            registro.put("id_asignacion", id_asignacion);
            registro.put("cadena_ciclos", cadena_ciclos.replace("'", "."));
            registro.put("cadena_estados", cadena_estados.replace("'", "."));
            registro.put("cadena_status", cadena_status.replace("'", "."));
            registro.put("con_cr", con_cr);
            registro.put("monto", monto);
            String sql = "insert into sic_log_registro_equipo(asignacion, id_equipo, cuentas, importe,parametros_creacion,id_region)\n"
                    + "select \n"
                    + "	id_asignacion, \n"
                    + "    id_equipo, \n"
                    + "    count(1) as cuentas, \n"
                    + "    sum(a_gestionar) as asignado,\n"
                    + " '" + registro.toJSONString() + "' as parametros,\n "
                    + " id_region_id_asignacion("+id_asignacion+")"
                    + "from arcade_basegeneral\n"
                    + "where f_active = 1 and id_equipo = "+ id_equipo +" \n"
                    + "group by id_equipo\n"
                    + "order by id_equipo desc limit 1;";
            
            inicioConexion.st.executeUpdate(sql);
            System.out.println(sql);

            inicioConexion.st.close();
            inicioConexion.conn.close();
            return "{\"toso\":\"loco\"}";
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String guardar_registro_equipo_usuario(int id_equipo, int id_gestor) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_guardar_registro_equipo_usuario('" + id_equipo + "', '" + id_gestor + "');";
            inicioConexion.st.executeUpdate(sql);
            
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return "";
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    public static String select_cuentas_equipo(int id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select \n"
                    + "	columna1 as cuenta,\n"
                    + "    columna10 as ciclo,\n"
                    + "    columna35 as estado,\n"
                    + "    ultimo_estatus_cuenta,\n"
                    + "    nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus,\n"
                    + "    tiene_cr,resto\n"
                    + "from arcade_basegeneral where id_equipo = " + id_equipo + ";";
            System.out.println(sql);
            String datos = "";

            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray cuentas = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject cuenta = new JSONObject();
                cuenta.put("cuenta", inicioConexion.rs.getString("cuenta"));
                cuenta.put("ciclo", inicioConexion.rs.getString("ciclo"));
                cuenta.put("estado", inicioConexion.rs.getString("estado"));
                cuenta.put("ultimo_estatus_cuenta", inicioConexion.rs.getInt("ultimo_estatus_cuenta"));
                cuenta.put("estatus", inicioConexion.rs.getString("estatus"));
                cuenta.put("tiene_cr", inicioConexion.rs.getString("tiene_cr"));
                cuenta.put("resto", inicioConexion.rs.getString("resto"));
                cuentas.add(cuenta);
            }
            
            String sql2 = "select parametros_creacion from sic_log_registro_equipo where id_equipo = " + id_equipo + " limit 1;";
            inicioConexion.rs = inicioConexion.st.executeQuery(sql2);
            
            while (inicioConexion.rs.next()) {
                datos =  inicioConexion.rs.getString("parametros_creacion");
            }
            datos = datos.replace(".", "");
            cuentas.add(datos);
            
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return cuentas.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

}
