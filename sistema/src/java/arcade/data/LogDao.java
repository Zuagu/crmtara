package arcade.data;

import arcade.model.Log;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class LogDao {

    //==============================================================================
    public static String select_log_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_log();";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Log> log = new ArrayList<Log>();
            while (s.rs.next()) {
                Log c = new Log();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setLog(s.rs.getString("log"));
                log.add(c);
            }

            // CUEPRO DE LA TABLA
            for (Log c : log) {
                renglones += c.getLog();
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
    public static String select_log_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_log();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Log> log = new ArrayList<Log>();
            while (s.rs.next()) {
                Log e = new Log();
                e.setId_log(s.rs.getInt("id_log"));
                e.setLog(s.rs.getString("log"));
                log.add(e);
            }
            for (Log c : log) {
                renglones += "<option value='" + c.getId_log() + "'>" + c.getLog() + "</option>";
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
    public static List<Log> select_log() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_log();";
            s.rs = s.st.executeQuery(sql);
            List<Log> log = new ArrayList<Log>();
            while (s.rs.next()) {
                Log e = new Log();
                e.setId_log(s.rs.getInt("id_log"));
                e.setLog(s.rs.getString("log"));
                log.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return log;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_log(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_log('" + nombre + "');";
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
    public static String update_log(int id_log) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_log('" + id_log + "');";
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
    public static String delete_log(int id_log) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_log('" + id_log + "');";
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
