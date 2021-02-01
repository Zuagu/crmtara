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
public class ModelSolicitud {

    public static String select_values_inputselect() {
        try {

            StartConexion ic = new StartConexion();
            String sql = "SELECT * FROM admin_opciones_solicitud;";
            ic.rs = ic.st.executeQuery(sql);

            JSONArray dataSelects = new JSONArray();
            // id_registro, id_selector, value, modulo, jsp, f_delete, pregunta, f_padre, dependencia, tipo
            while (ic.rs.next()) {
                JSONObject select = new JSONObject();
                select.put("id_registro", ic.rs.getInt("id_registro"));
                select.put("id_selector", ic.rs.getString("id_selector"));
                select.put("value", ic.rs.getString("value"));
                select.put("modulo", ic.rs.getString("modulo"));
                select.put("jsp", ic.rs.getString("jsp"));
                select.put("f_delete", ic.rs.getString("f_delete"));
                select.put("pregunta", ic.rs.getString("pregunta"));
                select.put("f_padre", ic.rs.getString("f_padre"));
                select.put("dependencia", ic.rs.getString("dependencia"));
                select.put("tipo", ic.rs.getString("tipo"));
                dataSelects.add(select);
            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return dataSelects.toJSONString();
        } catch (SQLException e) {
            return "Falla en en el select Error: " + e;
        }
    }

    public static String select_tipo_pregunta() {
        try {

            StartConexion ic = new StartConexion();
            String sql = "SELECT tipo FROM admin_opciones_solicitud GROUP BY tipo;";
            ic.rs = ic.st.executeQuery(sql);

            JSONArray dataSelects = new JSONArray();
            // id_registro, id_selector, value, modulo, jsp, f_delete, pregunta, f_padre, dependencia, tipo
            while (ic.rs.next()) {
                JSONObject select = new JSONObject();
                select.put("tipo", ic.rs.getString("tipo"));
                dataSelects.add(select);
            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return dataSelects.toJSONString();
        } catch (SQLException e) {
            return "Falla en en el select Error: " + e;
        }
    }

    public static String select_preguntas(String tipo) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "SELECT id_selector, pregunta FROM admin_opciones_solicitud WHERE tipo = '" + tipo + "' GROUP BY id_selector;";
            ic.rs = ic.st.executeQuery(sql);

            JSONArray dataSelects = new JSONArray();
            // id_registro, id_selector, value, modulo, jsp, f_delete, pregunta, f_padre, dependencia, tipo
            while (ic.rs.next()) {
                JSONObject select = new JSONObject();
                select.put("id_selector", ic.rs.getString("id_selector"));
                select.put("pregunta", ic.rs.getString("pregunta"));
                dataSelects.add(select);
            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return dataSelects.toJSONString();
        } catch (SQLException e) {
            return "Falla en en el select Error: " + e;
        }
    }

    public static String select_data_inputselect(String id_selector) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "SELECT * FROM admin_opciones_solicitud WHERE id_selector = '" + id_selector + "' ;";
            ic.rs = ic.st.executeQuery(sql);

            JSONArray dataSelects = new JSONArray();
            // id_registro, id_selector, value, modulo, jsp, f_delete, pregunta, f_padre, dependencia, tipo
            while (ic.rs.next()) {
                JSONObject select = new JSONObject();
                select.put("id_registro", ic.rs.getInt("id_registro"));
                select.put("id_selector", ic.rs.getString("id_selector"));
                select.put("value", ic.rs.getString("value"));
                select.put("modulo", ic.rs.getString("modulo"));
                select.put("jsp", ic.rs.getString("jsp"));
                select.put("f_delete", ic.rs.getString("f_delete"));
                select.put("pregunta", ic.rs.getString("pregunta"));
                select.put("f_padre", ic.rs.getString("f_padre"));
                select.put("dependencia", ic.rs.getString("dependencia"));
                select.put("tipo", ic.rs.getString("tipo"));
                dataSelects.add(select);
            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return dataSelects.toJSONString();
        } catch (SQLException e) {
            return "Falla en en el select Error: " + e;
        }
    }

    public static String insert_new_option(String id_selector, String pregunta, String tipo, String value) {
        try {

            StartConexion ic = new StartConexion();
            // id_registro, id_selector, value, modulo, jsp, f_delete, pregunta, f_padre, dependencia, tipo
            String sql = "INSERT INTO admin_opciones_solicitud(id_selector, value, pregunta, tipo) VALUES ('"+ id_selector +"','"+ value +"','"+ pregunta +"','"+ tipo +"');";
            System.out.println(sql);
            
            ic.st.executeUpdate(sql);

            JSONObject select = new JSONObject();
            select.put("response", "corect");

            ic.st.close();
            ic.conn.close();

            return select.toJSONString();
        } catch (SQLException e) {
            return "Falla en en el select Error: " + e;
        }
    }

}
