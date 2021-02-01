package arcade.data;

import arcade.model.Blacklist;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class BlacklistDao {

    //==============================================================================
    public static String select_blacklist() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_blacklist();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Blacklist> blacklist = new ArrayList<Blacklist>();
            while (s.rs.next()) {
                Blacklist c = new Blacklist();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_cuenta(s.rs.getInt("id_cuenta"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setUsuario(s.rs.getString("usuario"));
                c.setFecha(s.rs.getString("fecha"));
                blacklist.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align: center;'>CUENTA</th>"
                    + "<th style='text-align: center;'>USUARIO</th>"
                    + "<th style='text-align: center;'>FECHA</th>"
                    + "<th style='width: 2%;'></th>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Blacklist c : blacklist) {
                renglones += ""
                        + "<tr id='" + c.getCuenta() + "'>"
                        + "<td style='text-align: center;'>" + c.getCuenta() + "</td>"
                        + "<td>" + c.getUsuario() + "</td>"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td><img class='delete_blacklist' src='images/i_delete.png'></td>"
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

    //==========================================================================
    public static String insert_blacklist(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_blacklist('" + nombre + "');";
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
    public static String update_blacklist(int id_usuario, String cuenta, int fbl) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_blacklist('" + id_usuario + "', '" + cuenta + "', '" + fbl + "');";
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
    public static String delete_blacklist(int id_blacklist) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_blacklist('" + id_blacklist + "');";
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
