/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Emmanuel Medina
 */
public class ModelEquipoAzteca {

    public static String select_equipos() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT ID_EQUIPO, NOMBRE_EQUIPO, IFNULL(CUENTAS, 0) AS CUENTAS, IFNULL(VALOR,0) VALOR, DESCRIPCION, F_DELETE FROM azteca_equipos;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray equipos = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                JSONObject equipo = new JSONObject();
                equipo.put("ID_EQUIPO", inicioConexion.rs.getInt("ID_EQUIPO"));
                equipo.put("NOMBRE_EQUIPO", inicioConexion.rs.getString("NOMBRE_EQUIPO"));
                equipo.put("DESCRIPCION", inicioConexion.rs.getString("DESCRIPCION"));
                equipo.put("CUENTAS", inicioConexion.rs.getString("CUENTAS"));
                equipo.put("VALOR", inicioConexion.rs.getString("VALOR"));
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

    public static String select_usarios_equipo(String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT id, nombre\n"
                    + "	FROM arcade_usuarios \n"
                    + "    where \n"
                    + "		id_equipo1 = " + id_equipo + "\n"
                    + "		or id_equipo2 = " + id_equipo + "\n"
                    + "		or id_equipo3 = " + id_equipo + "\n"
                    + "		or id_equipo4 = " + id_equipo + "\n"
                    + "		or id_equipo5 = " + id_equipo + "\n"
                    + "    and f_active = 1";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray usuarios = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                JSONObject usuario = new JSONObject();
                usuario.put("id", inicioConexion.rs.getInt("id"));
                usuario.put("nombre", inicioConexion.rs.getString("nombre"));
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

    public static String agregar_gestor_a_equipo(String id_gestor, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "CALL azteca_agregar_gestor_a_equipo(" + id_gestor + ", " + id_equipo + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject equipo = new JSONObject();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                equipo.put("response", inicioConexion.rs.getString("response"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipo.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String eliminar_gestor_de_equipo(String id_gestor, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "CALL azteca_eliminar_gestor_a_equipo(" + id_gestor + ", " + id_equipo + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject equipo = new JSONObject();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                equipo.put("response", inicioConexion.rs.getString("response"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipo.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_territorio_options() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT TERRITORIO FROM azteca_base_genenral_original GROUP BY TERRITORIO;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                gerencia.add(inicioConexion.rs.getString("TERRITORIO"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_gerente_options(String territorio) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT GERENTE FROM azteca_base_genenral_original WHERE TERRITORIO IN(" + territorio.replace("\"", "'") + ") GROUP BY GERENTE;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                gerencia.add(inicioConexion.rs.getString("GERENTE"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_etapas_options(String territorio, String gerente) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT ETAPA FROM azteca_base_genenral_original WHERE TERRITORIO IN (" + territorio + ") AND GERENTE IN (" + gerente + ") GROUP BY ETAPA;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                gerencia.add(inicioConexion.rs.getString("ETAPA"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String crear_equipo(String nombre_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "INSERT INTO azteca_equipos(NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE) VALUES('" + nombre_equipo + "', 0, 0.00, '', 0);";
            System.out.println(sql);

            inicioConexion.st.executeUpdate(sql);

            JSONObject equipo = new JSONObject();
            equipo.put("resultado", "Equipo Creado");

            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipo.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String agregar_cuentas_equipo(String territorios, String gerentes, String etapa) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql_act_data_equipo = "CALL azteca_actualizar_datos_equipos();";
            String sql_ob_equi_max = "SELECT ID_EQUIPO FROM azteca_equipos order by ID_EQUIPO desc limit 1;";
            int id_max = 0;
            System.out.println(sql_ob_equi_max);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql_ob_equi_max);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                id_max = inicioConexion.rs.getInt("ID_EQUIPO");
            }

            System.out.println(id_max);

            String sql = "UPDATE azteca_base_genenral_original SET \n"
                    + "ID_EQUIPO = " + id_max + "\n"
                    + "WHERE TERRITORIO IN (" + territorios.replace("\"", "'") + ") \n"
                    + "	AND GERENTE IN (" + gerentes.replace("\"", "'") + ") \n"
                    + "    AND ETAPA IN (" + etapa.replace("\"", "'") + ");";
            System.out.println(sql);
            inicioConexion.st.executeUpdate(sql);

            inicioConexion.rs = inicioConexion.st.executeQuery(sql_act_data_equipo);

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String agregar_nuevas_cuentas_equipo(String territorios, String gerentes, String etapa, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();

            String sql_act_data_equipo = "CALL azteca_actualizar_datos_equipos();";
            System.out.println(sql_act_data_equipo);

            JSONObject response = new JSONObject();

            String sql = "UPDATE azteca_base_genenral_original SET \n"
                    + "ID_EQUIPO = " + id_equipo + "\n"
                    + "WHERE TERRITORIO IN (" + territorios.replace("\"", "'") + ") \n"
                    + "	AND GERENTE IN (" + gerentes.replace("\"", "'") + ") \n"
                    + "    AND ETAPA IN (" + etapa.replace("\"", "'") + ");";
            System.out.println(sql);
            inicioConexion.st.executeUpdate(sql);

            inicioConexion.rs = inicioConexion.st.executeQuery(sql_act_data_equipo);

            response.put("response", "ok");

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return response.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_asignaiones_usuarios() {
        try {
            StartConexion inicioConexion = new StartConexion();

            String sql = "select u.id as id_gestor, \n"
                    + "	count(b.CLIENTE_UNICO) as cantidad, \n"
                    + "    format(sum(b.SALDO_TOTAL),2) as importe,\n"
                    + "    ifnull(nombre_usuario_alias(b.ID_GESTOR_ASIGNADO), 'No Asignado') gestor,\n"
                    + "    ifnull(u.orden,'ninguno') as orden, \n"
                    + "    ifnull(u.orden_importe,'ninguno') as orden_importe \n"
                    + "from azteca_base_genenral_original b\n"
                    + "left join arcade_usuarios u on u.id = b.ID_GESTOR_ASIGNADO \n"
                    + "where IDENTIFICADOR != '0' group by b.ID_GESTOR_ASIGNADO;";
            JSONArray asig_gestores = new JSONArray();

            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            while (inicioConexion.rs.next()) {
                JSONObject gestor = new JSONObject();
                gestor.put("id_gestor", inicioConexion.rs.getString("id_gestor"));
                gestor.put("cantidad", inicioConexion.rs.getString("cantidad"));
                gestor.put("importe", inicioConexion.rs.getString("importe"));
                gestor.put("gestor", inicioConexion.rs.getString("gestor"));
                gestor.put("orden", inicioConexion.rs.getString("orden"));
                gestor.put("orden_importe", inicioConexion.rs.getString("orden_importe"));
                asig_gestores.add(gestor);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return asig_gestores.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String update_config_gestor(String val_order, String val_order_importe, String id_gestor) {
        try {
            StartConexion inicioConexion = new StartConexion();

            String sql = "update arcade_usuarios set orden = '" + val_order + "', orden_importe = '" + val_order_importe + "' where id = '" + id_gestor + "';";
//            JSONArray asig_gestores = new JSONArray();
            JSONObject response = new JSONObject();

            inicioConexion.st.executeUpdate(sql);
            response.put("response", "Actualizado con exito");

//            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return response.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }
    
    
    public static String update_config_todos_gestor(String order_ult_gestion, String order_monto) {
        try {
            StartConexion inicioConexion = new StartConexion();

            String sql = "update arcade_usuarios set orden = '" + order_ult_gestion + "', orden_importe = '" + order_monto + "';";
//            JSONArray asig_gestores = new JSONArray();
            JSONObject response = new JSONObject();

            inicioConexion.st.executeUpdate(sql);
            response.put("response", "Actualizado con exito");

//            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return response.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String estatus_asignacion_gestor(String id_gestor) {
        try {
            StartConexion inicioConexion = new StartConexion();

            String sql = "select count(CLIENTE_UNICO) as cantidad,\n"
                    + "	nombre_estatus_llamada_azteca(ID_ESTATUS_LLAMADA) as ESTATUS_LLAMADA\n"
                    + "from azteca_base_genenral_original where ID_GESTOR_ASIGNADO = '"+id_gestor+"' and IDENTIFICADOR != '0' group by ID_ESTATUS_LLAMADA;";
            JSONArray est_gestores = new JSONArray();

            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            while (inicioConexion.rs.next()) {
                JSONObject gestor = new JSONObject();
                gestor.put("ESTATUS_LLAMADA", inicioConexion.rs.getString("ESTATUS_LLAMADA"));
                gestor.put("cantidad", inicioConexion.rs.getString("cantidad"));
                est_gestores.add(gestor);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return est_gestores.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

}
