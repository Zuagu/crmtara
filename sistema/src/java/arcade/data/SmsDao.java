package arcade.data;

import arcade.model.Sms;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class SmsDao {

    //==============================================================================
    public static String select_sms_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_sms();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Sms> sms = new ArrayList<Sms>();
            while (s.rs.next()) {
                Sms c = new Sms();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_sms(s.rs.getInt("id_sms"));
                c.setSms(s.rs.getString("sms"));
                sms.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE DE LA PLANILLA</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_productos_sms'>*</a></td>"
                    + "<td><input id='sms_insert' class='alfanumerico' type='text'></td>"
                    + "<td colspan='2'><input type='button' id='insert_sms' value='AGREGAR' style='background:#0C7B00'></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Sms c : sms) {
                renglones += ""
                        + "<tr id='" + c.getId_sms() + "'>"
                        + "<td>" + c.getId_sms() + "</td>"
                        + "<td><a href='#' class='select_productos_sms'>" + c.getSms() + "</a></td>"
                        + "<td style='width: 2%'><a class='update_sms' href='#'><img src='images/i_edit.png'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_sms' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_sms_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_sms();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Sms> sms = new ArrayList<Sms>();
            while (s.rs.next()) {
                Sms e = new Sms();
                e.setId_sms(s.rs.getInt("id_sms"));
                e.setSms(s.rs.getString("sms"));
                sms.add(e);
            }
            for (Sms c : sms) {
                renglones += "<option value='" + c.getId_sms() + "'>" + c.getSms() + "</option>";
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
    public static List<Sms> select_sms() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_sms();";
            s.rs = s.st.executeQuery(sql);
            List<Sms> sms = new ArrayList<Sms>();
            while (s.rs.next()) {
                Sms e = new Sms();
                e.setId_sms(s.rs.getInt("id_sms"));
                e.setSms(s.rs.getString("sms"));
                sms.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return sms;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_sms(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_sms('" + nombre + "');";
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
    public static String update_sms(int id_sms) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_sms('" + id_sms + "');";
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
    public static String delete_sms(int id_sms) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_sms('" + id_sms + "');";
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
