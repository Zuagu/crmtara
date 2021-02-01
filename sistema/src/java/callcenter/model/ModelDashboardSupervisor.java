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
 * @author zuagu
 */
public class ModelDashboardSupervisor {

    public static String select_gestor_tabla(int id_usuario, int id_puesto) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_gestores(" + id_usuario + ", " + id_puesto + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray gestores = new JSONArray();
            // id, nombre, id_usuario, id_equipo, id_asignacion
            while (inicioConexion.rs.next()) {
                JSONObject gestor = new JSONObject();
                gestor.put("id", inicioConexion.rs.getInt("id"));
                gestor.put("nombre", inicioConexion.rs.getString("nombre"));
                gestores.add(gestor);

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gestores.toString();
        } catch (SQLException e) {

            return "sql code" + e;
        }
    }

    public static String select_valores_usuarios(int id_puesto_usuario, int id_puesto2_usuario, int id_puesto3_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_valores_usuarios(" + id_puesto_usuario + ", " + id_puesto2_usuario + "," + id_puesto3_usuario + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONObject usuario = new JSONObject();
            // id, nombre, id_usuario, id_equipo, id_asignacion
            while (inicioConexion.rs.next()) {

                usuario.put("total_usuarios", inicioConexion.rs.getInt("total_usuarios"));
                usuario.put("total_activos", inicioConexion.rs.getInt("total_activos"));

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return usuario.toString();
        } catch (SQLException e) {

            return "sql code" + e;
        }
    }

    public static String select_regitro_usuarios_entrada(int id_puesto_usuario, int id_puesto2_usuario, int id_puesto3_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_regitro_usuarios_entrada(" + id_puesto_usuario + ", " + id_puesto2_usuario + "," + id_puesto3_usuario + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray usuarios = new JSONArray();
            // id, nombre, id_usuario, id_equipo, id_asignacion
            while (inicioConexion.rs.next()) {
                JSONObject dato = new JSONObject();
                dato.put("id", inicioConexion.rs.getInt("id"));
                dato.put("nombre", inicioConexion.rs.getString("nombre"));
                dato.put("entrada", inicioConexion.rs.getString("entrada"));
                dato.put("hora_entrada", inicioConexion.rs.getString("hora_entrada"));
                dato.put("f_llegada", inicioConexion.rs.getInt("f_llegada"));
                dato.put("estatus_entrada", inicioConexion.rs.getInt("estatus_entrada"));
                usuarios.add(dato);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return usuarios.toString();
        } catch (SQLException e) {

            return "sql code" + e;
        }
    }

    public static String select_regiones(int id_puesto_usuario, int id_puesto2_usuario, int id_puesto3_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_regiones_x_puestos(" + id_puesto_usuario + ", " + id_puesto2_usuario + "," + id_puesto3_usuario + ");";
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

    public static String select_asignaciones_region(String id_region) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select id_asignacion, asignacion from arcade_asignaciones where f_active = 1 and id_region in(" + id_region + ");";
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

    public static String select_regitro_usuarios_entrada_rango(String desde, String hasta,String region,String asignacion, int id_puesto_usuario, int id_puesto2_usuario, int id_puesto3_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_valores_usuarios_rango(" + desde + "," + hasta + "," + id_puesto_usuario + ", " + id_puesto2_usuario + "," + id_puesto3_usuario + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONObject usuario = new JSONObject();
            // id, nombre, id_usuario, id_equipo, id_asignacion
            while (inicioConexion.rs.next()) {

                usuario.put("total_usuarios", inicioConexion.rs.getInt("total_usuarios"));
                usuario.put("total_activos", inicioConexion.rs.getInt("total_activos"));

            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return usuario.toString();
        } catch (SQLException e) {

            return "sql code" + e;
        }
    }

}
