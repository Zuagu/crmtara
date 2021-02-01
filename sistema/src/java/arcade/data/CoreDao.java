package arcade.data;

import arcade.model.Core;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class CoreDao {

    //==============================================================================
    public static String select_core_tabla(String filtro) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_core('" + filtro + "')";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Core> core = new ArrayList<Core>();
            while (s.rs.next()) {
                Core c = new Core();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_registro(s.rs.getString("id"));
                c.setId_cliente(s.rs.getString("cliente"));
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setTipo_tel(s.rs.getString("tipo_tel"));
                c.setTelefono(s.rs.getString("telefono"));
                c.setNombre(s.rs.getString("nombre"));
                core.add(c);
            }

            renglones = ""
                    + "<table class='striped bordered highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>CLIENTE</th>"
                    + "<th>REGION</th>"
                    + "<th>ASIGNACION</th>"
                    + "<th>CUENTA</th>"
                    + "<th></th>"
                    + "<th>TELEFONO</th>"
                    + "<th>NOMBRE</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Core c : core) {
                renglones += ""
                        + "<tr id='" + c.getId_registro() + "' class='renglon'>"
                        + "<td>" + c.getId_cliente() + "</td>"
                        + "<td>" + c.getRegion() + "</td>"
                        + "<td>" + c.getAsignacion() + "</td>"
                        + "<td>" + c.getCuenta() + "</td>"
                        + "<td class='tipo_tel'><input class='editar_dato' type='text' value='" + c.getTipo_tel() + "'></td>"
                        + "<td class='telefono'><input class='editar_dato' type='text' value='" + c.getTelefono() + "'></td>"
                        + "<td class='nombre'><input class='editar_dato letras' type='text' value='" + c.getNombre() + "'></td>"
                        + "</tr>";
            }
            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_core_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_core();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Core> core = new ArrayList<Core>();
            while (s.rs.next()) {
                Core e = new Core();
                e.setId_registro(s.rs.getString("id_core"));
                e.setId_cliente(s.rs.getString("core"));
                core.add(e);
            }
            for (Core c : core) {
                renglones += "<option value='" + c.getId_registro() + "'>" + c.getId_cliente() + "</option>";
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static List<Core> select_core() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_core();";
            s.rs = s.st.executeQuery(sql);
            List<Core> core = new ArrayList<Core>();
            while (s.rs.next()) {
                Core e = new Core();
                e.setId_cliente(s.rs.getString("core"));
                core.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return core;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_core(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_core('" + nombre + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_core(int id_core) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_core('" + id_core + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String delete_core(int id_core) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_core('" + id_core + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_dato_core(int id_usuario, int id_registro, String columna, String nuevo_valor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_dato_core('" + id_usuario + "', '" + id_registro + "', '" + columna + "', '" + nuevo_valor + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
}
