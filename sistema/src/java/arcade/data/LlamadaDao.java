package arcade.data;

import arcade.model.Llamada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class LlamadaDao {

    //==============================================================================
    public static String select_llamadas_marcacion_tabla(int id_marcacion) {
        try {
            StartConn s = new StartConn();
            String sql = "SELECT * FROM arcade_call.calls where id_campaign = " + id_marcacion + ";";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Llamada> llamada = new ArrayList<Llamada>();
            while (s.rs.next()) {
                Llamada c = new Llamada();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_llamada(s.rs.getInt("id"));
                c.setId_marcacion(s.rs.getInt("id_campaign"));
                c.setTelefono(s.rs.getString("phone"));
                llamada.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>CAMPAÑA</th>"
                    + "<th>TELEFONO</th>"
                    + "<th>INTENTOS</th>"
                    + "<th>NO LLAMAR?</th>"
                    + "<th>PROGRAMADA?</th>"
                    + "<th></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Llamada c : llamada) {
                renglones += ""
                        + "<tr id='" + c.getId_llamada() + "'>"
                        + "<td>" + c.getId_llamada() + "</td>"
                        + "<td>" + c.getId_marcacion() + "</td>"
                        + "<td>" + c.getTelefono() + "</td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td style='width: 2%'><a class='delete_llamada' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String insert_llamada(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_llamada('" + nombre + "');";
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
    public static String update_llamada(int id_llamada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_llamada('" + id_llamada + "');";
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
    public static String delete_llamada(int id_llamada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_llamada('" + id_llamada + "');";
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
