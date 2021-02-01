package arcade.data;

import arcade.model.Accesorio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class AccesorioDao {

    //==========================================================================
    public static String select_accesorio_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_accesorio();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Accesorio> accesorio = new ArrayList<Accesorio>();
            while (s.rs.next()) {
                Accesorio c = new Accesorio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_accesorio(s.rs.getInt("id_accesorio"));
                c.setAccesorio(s.rs.getString("accesorio"));
                accesorio.add(c);
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
                    + "<td><a href='#' class='select_productos_accesorio'>*</a></td>"
                    + "<td><input id='accesorio_insert' class='alfanumerico' type='text'></td>"
                    + "<td><a id='insert_accesorio' href='#'><img src='images/i_add.png'/></a></td>"
                    + "<td></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Accesorio c : accesorio) {
                renglones += ""
                        + "<tr id='" + c.getId_accesorio() + "'>"
                        + "<td>" + c.getId_accesorio() + "</td>"
                        + "<td><a href='#' class='select_productos_accesorio'>" + c.getAccesorio() + "</a></td>"
                        + "<td style='width: 2%'><a class='update_accesorio' href='#'><img src='images/i_edit.png'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_accesorio' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_accesorio_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_accesorio();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Accesorio> accesorio = new ArrayList<Accesorio>();
            while (s.rs.next()) {
                Accesorio e = new Accesorio();
                e.setId_accesorio(s.rs.getInt("id_accesorio"));
                e.setAccesorio(s.rs.getString("accesorio"));
                accesorio.add(e);
            }
            for (Accesorio c : accesorio) {
                renglones += "<option value='" + c.getId_accesorio() + "'>" + c.getAccesorio() + "</option>";
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
    public static List<Accesorio> select_accesorio() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_accesorio();";
            s.rs = s.st.executeQuery(sql);
            List<Accesorio> accesorio = new ArrayList<Accesorio>();
            while (s.rs.next()) {
                Accesorio e = new Accesorio();
                e.setId_accesorio(s.rs.getInt("id_accesorio"));
                e.setAccesorio(s.rs.getString("accesorio"));
                accesorio.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return accesorio;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_accesorio(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_accesorio('" + nombre + "');";
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
    public static String update_accesorio(int id_accesorio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_accesorio('" + id_accesorio + "');";
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
    public static String delete_accesorio(int id_accesorio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_accesorio('" + id_accesorio + "');";
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
