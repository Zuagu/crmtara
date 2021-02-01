package arcade.data;

import arcade.model.CategoriaSms;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class CategoriaSmsDao {

    //==============================================================================
    public static String select_categoria_sms_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categoria_sms();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<CategoriaSms> categoria_sms = new ArrayList<CategoriaSms>();
            while (s.rs.next()) {
                CategoriaSms c = new CategoriaSms();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_categoria_sms(s.rs.getInt("id_categoria_sms"));
                c.setCategoria_sms(s.rs.getString("categoria_sms"));
                c.setF_autorizado(s.rs.getInt("f_autorizado"));
                categoria_sms.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE PLANTILLA SMS</th>"
                    + "<th colspan='2'>AUTORIZADO?</th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_sms_categoria_sms'>*</a></td>"
                    + "<td><input id='categoria_sms_insert' class='alfanumerico' type='text'></td>"
                    + "<td><input type='button' id='insert_categoria_sms' value='AGREGAR'></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (CategoriaSms c : categoria_sms) {
                renglones += ""
                        + "<tr id='" + c.getId_categoria_sms() + "'>"
                        + "<td>" + c.getId_categoria_sms() + "</td>"
                        + "<td><a href='#' class='select_sms_categoria_sms'>" + c.getCategoria_sms() + "</a></td>"
                        + "<td style='width: 2%;text-align:center;'>" + (c.getF_autorizado() == 1 ? "<input type='button' value='AUTORIZADO' style='background: #0C7B00;'>" : "<input class='autorizar_sms' type='button' value='AUTORIZAR' style='background: #FF3333;'>") + "</td>"
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
    public static String select_categoria_sms_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categoria_sms();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<CategoriaSms> categoria_sms = new ArrayList<CategoriaSms>();
            while (s.rs.next()) {
                CategoriaSms e = new CategoriaSms();
                e.setId_categoria_sms(s.rs.getInt("id_categoria_sms"));
                e.setCategoria_sms(s.rs.getString("categoria_sms"));
                categoria_sms.add(e);
            }
            for (CategoriaSms c : categoria_sms) {
                renglones += "<option value='" + c.getId_categoria_sms() + "'>" + c.getCategoria_sms() + "</option>";
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
    public static String insert_categoria_sms(int id_usuario, String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_categoria_sms('" + id_usuario + "', '" + nombre + "');";
            System.out.println(sql);
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
    public static String update_sms(int id_usuario, int id_sms, String sms) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_sms('" + id_usuario + "', '" + id_sms + "', '" + sms + "');";
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
    public static String delete_sms(int id_usuario, int id_sms) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_sms('" + id_usuario + "', '" + id_sms + "');";
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
    public static String autorizar_sms(int id_usuario, int id_sms) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_autorizar_sms('" + id_usuario + "', '" + id_sms + "');";
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
    public static String select_sms(int id_sms) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_sms('" + id_sms + "');";
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
