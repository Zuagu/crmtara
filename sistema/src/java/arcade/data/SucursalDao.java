package arcade.data;

import arcade.model.Sucursal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Luis Cortez */
public class SucursalDao {

    //==========================================================================
    public static String select_sucursal_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_sucursales();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Sucursal> sucursales = new ArrayList<Sucursal>();
            while (s.rs.next()) {
                Sucursal c = new Sucursal();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_sucursal(s.rs.getInt("id_sucursal"));
                c.setSucursal(s.rs.getString("sucursal"));
                sucursales.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>SUCURSAL</th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_productos_sucursal'>*</a></td>"
                    + "<td><input id='sucursal_insert' class='alfanumerico' type='text'></td>"
                    + "<td><a id='insert_sucursal' href='#'><img src='images/i_add.png'/></a></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Sucursal c : sucursales) {
                renglones += ""
                        + "<tr id='" + c.getId_sucursal() + "'>"
                        + "<td>" + c.getId_sucursal() + "</td>"
                        + "<td>" + c.getSucursal() + "</td>"
                        + "<td style='width: 2%'><a class='delete_sucursal' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_sucursal_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_sucursales();";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Sucursal> sucursales = new ArrayList<Sucursal>();
            while (s.rs.next()) {
                Sucursal e = new Sucursal();
                e.setId_sucursal(s.rs.getInt("id_sucursal"));
                e.setSucursal(s.rs.getString("sucursal"));
                sucursales.add(e);
            }
            for (Sucursal c : sucursales) {
                renglones += "<option value='" + c.getId_sucursal() + "'>" + c.getSucursal() + "</option>";
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
    public static String insert_sucursal(String sucursal) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_sucursal('" + sucursal + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_sucursal(int id_sucursal, String sucursal) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_sucursal('" + id_sucursal + "', '" + sucursal + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String delete_sucursal(int id_sucursal) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_sucursal('" + id_sucursal + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String generar_mapa(int id_sucursal) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_generar_mapa('" + id_sucursal + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Sucursal> sucursales = new ArrayList<Sucursal>();
            while (s.rs.next()) {
                Sucursal c = new Sucursal();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_piso(s.rs.getInt("id_piso"));
                c.setId_sucursal(s.rs.getInt("id_sucursal"));
                c.setClases(s.rs.getString("clases"));
                sucursales.add(c);
            }

            // CUEPRO DE LA TABLA
            int cons = 1;
            for (Sucursal c : sucursales) {

                renglones += ""
                        + "<div id='" + c.getId_piso() + "' class='" + c.getClases() + "'>" + cons + "</div>";
                cons++;
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_clases(int id_piso, String clases) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_clases('" + id_piso + "', '" + clases + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
}
