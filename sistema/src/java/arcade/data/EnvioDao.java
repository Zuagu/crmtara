package arcade.data;

import arcade.model.Envio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class EnvioDao {

    //==============================================================================
    public static String select_envio_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_envio();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Envio> envio = new ArrayList<Envio>();
            while (s.rs.next()) {
                Envio c = new Envio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_envio(s.rs.getInt("id_envio"));
                c.setEnvio(s.rs.getString("envio"));
                envio.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>CATEGORIA</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_productos_envio'>*</a></td>"
                    + "<td><input id='envio_insert' class='alfanumerico' type='text'></td>"
                    + "<td><a class='insert_envio' href='#'><img src='images/i_add.png'/></a></td>"
                    + "<td></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Envio c : envio) {
                renglones += ""
                        + "<tr id='" + c.getId_envio() + "'>"
                        + "<td>" + c.getId_envio() + "</td>"
                        + "<td><a href='#' class='select_productos_envio'>" + c.getEnvio() + "</a></td>"
                        + "<td style='width: 2%'><a class='update_envio' href='#'><img src='images/i_edit.png'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_envio' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_envio_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_envio();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Envio> envio = new ArrayList<Envio>();
            while (s.rs.next()) {
                Envio e = new Envio();
                e.setId_envio(s.rs.getInt("id_envio"));
                e.setEnvio(s.rs.getString("envio"));
                envio.add(e);
            }
            for (Envio c : envio) {
                renglones += "<option value='" + c.getId_envio() + "'>" + c.getEnvio() + "</option>";
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
    public static List<Envio> select_envio() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_envio();";
            s.rs = s.st.executeQuery(sql);
            List<Envio> envio = new ArrayList<Envio>();
            while (s.rs.next()) {
                Envio e = new Envio();
                e.setId_envio(s.rs.getInt("id_envio"));
                e.setEnvio(s.rs.getString("envio"));
                envio.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return envio;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_envio(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_envio('" + nombre + "');";
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
    public static String update_envio(int id_envio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_envio('" + id_envio + "');";
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
    public static String delete_envio(int id_envio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_envio('" + id_envio + "');";
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
    public static String calcular_precio_envio(String distancia) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call calcular_precio_envio('" + distancia + "');";
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
}
