package arcade.data;

import arcade.model.Nota;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class NotaDao {

    //==============================================================================
    public static String select_nota_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_nota();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Nota> nota = new ArrayList<Nota>();
            while (s.rs.next()) {
                Nota c = new Nota();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_nota(s.rs.getInt("id_nota"));
                c.setNota(s.rs.getString("nota"));
                nota.add(c);
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
                    + "<td><a href='#' class='select_productos_nota'>*</a></td>"
                    + "<td><input id='nota_insert' class='alfanumerico' type='text'></td>"
                    + "<td><a id='insert_nota' href='#'><img src='images/i_add.png'/></a></td>"
                    + "<td></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Nota c : nota) {
                renglones += ""
                        + "<tr id='" + c.getId_nota() + "'>"
                        + "<td>" + c.getId_nota() + "</td>"
                        + "<td><a href='#' class='select_productos_nota'>" + c.getNota() + "</a></td>"
                        + "<td style='width: 2%'><a class='update_nota' href='#'><img src='images/i_edit.png'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_nota' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_nota_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_nota();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Nota> nota = new ArrayList<Nota>();
            while (s.rs.next()) {
                Nota e = new Nota();
                e.setId_nota(s.rs.getInt("id_nota"));
                e.setNota(s.rs.getString("nota"));
                nota.add(e);
            }
            for (Nota c : nota) {
                renglones += "<option value='" + c.getId_nota() + "'>" + c.getNota() + "</option>";
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
    public static String insert_nota(int id_usuario, String nota) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_nota('" + id_usuario + "', '" + nota + "');";
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
    public static String update_nota(int id_nota) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_nota('" + id_nota + "');";
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
    public static String delete_nota(int id_nota) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_nota('" + id_nota + "');";
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
    public static String select_notas_equipo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_notas_equipo('" + id_usuario + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Nota> nota = new ArrayList<Nota>();
            while (s.rs.next()) {
                Nota c = new Nota();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_nota(s.rs.getInt("id_nota"));
                c.setUsuario(s.rs.getString("usuario"));
                c.setNota(s.rs.getString("nota"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                nota.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>FECHA</th>"
                    + "<th>HORA</th>"
                    + "<th>USUARIO</th>"
                    + "<th style='width:60%;'>NOTA</th>"
                    + "<th></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Nota c : nota) {
                renglones += ""
                        + "<tr id='" + c.getId_nota() + "'>"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getUsuario() + "</td>"
                        + "<td>" + c.getNota() + "</td>"
                        + "<td style='text-align:center;'><input class='delete_nota' type='button' value=' - ' style='width: 28px;border-radius: 13px;border: none;'></td>"
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
}
