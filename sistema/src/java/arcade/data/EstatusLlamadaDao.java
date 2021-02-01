package arcade.data;

import arcade.model.EstatusLlamada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class EstatusLlamadaDao {

    //==============================================================================
    public static String select_estatus_llamada_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_llamada();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<EstatusLlamada> estatus_llamada = new ArrayList<EstatusLlamada>();
            while (s.rs.next()) {
                EstatusLlamada c = new EstatusLlamada();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estatus_llamada(s.rs.getInt("id_estatus_llamada"));
                c.setEstatus_llamada(s.rs.getString("estatus_llamada"));
                c.setDescripcion(s.rs.getString("descripcion"));
                estatus_llamada.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th style='width:75px;'>ESTATUS</th>"
                    + "<th>SIGNIFICADO</th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_productos_estatus_llamada'>*</a></td>"
                    + "<td><input id='estatus_llamada_insert' class='alfanumerico' type='text'></td>"
                    + "<td><input id='descripcion_insert' class='alfanumerico' type='text'></td>"
                    + "<td style='text-align:center;'><a id='insert_estatus_llamada' href='#'><img src='images/i_add.png'/></a></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (EstatusLlamada c : estatus_llamada) {
                renglones += ""
                        + "<tr id='" + c.getId_estatus_llamada() + "'>"
                        + "<td>" + c.getId_estatus_llamada() + "</td>"
                        + "<td style='text-align:center;'><b>" + c.getEstatus_llamada() + "</b></td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td style='width: 2%'><a class='delete_estatus_llamada' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_estatus_llamada_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_llamada();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<EstatusLlamada> estatus_llamada = new ArrayList<EstatusLlamada>();
            while (s.rs.next()) {
                EstatusLlamada e = new EstatusLlamada();
                e.setId_estatus_llamada(s.rs.getInt("id_estatus_llamada"));
                e.setEstatus_llamada(s.rs.getString("estatus_llamada"));
                e.setDescripcion(s.rs.getString("descripcion"));
                estatus_llamada.add(e);
            }
            for (EstatusLlamada c : estatus_llamada) {
                renglones += "<option style='padding-bottom: 3px;font-weight:bold;font-size:16px;' value='" + c.getId_estatus_llamada() + "'>" + c.getEstatus_llamada() + " (" + c.getDescripcion() + ")</option>";
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
    public static List<EstatusLlamada> select_estatus_llamada() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_llamada();";
            s.rs = s.st.executeQuery(sql);
            List<EstatusLlamada> estatus_llamada = new ArrayList<EstatusLlamada>();
            while (s.rs.next()) {
                EstatusLlamada e = new EstatusLlamada();
                e.setId_estatus_llamada(s.rs.getInt("id_estatus_llamada"));
                e.setEstatus_llamada(s.rs.getString("estatus_llamada"));
                estatus_llamada.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return estatus_llamada;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_estatus_llamada(String estatus_llamada, String descripcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_estatus_llamada('" + estatus_llamada + "', '" + descripcion + "');";
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
    public static String update_estatus_llamada(int id_estatus_llamada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_estatus_llamada('" + id_estatus_llamada + "');";
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
    public static String delete_estatus_llamada(int id_estatus_llamada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_estatus_llamada('" + id_estatus_llamada + "');";
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
