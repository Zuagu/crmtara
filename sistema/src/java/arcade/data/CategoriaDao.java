package arcade.data;

import arcade.model.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class CategoriaDao {

    //==============================================================================
    public static String select_categorias_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categorias();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Categoria> categorias = new ArrayList<Categoria>();
            while (s.rs.next()) {
                Categoria c = new Categoria();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_categoria(s.rs.getInt("id_categoria"));
                c.setCategoria(s.rs.getString("categoria"));
                categorias.add(c);
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
                    + "<td><a href='#' class='select_productos_categoria'>*</a></td>"
                    + "<td><input id='categoria_insert' class='alfanumerico' type='text'></td>"
                    + "<td><a class='insert_categoria' href='#'><img src='images/i_add.png'/></a></td>"
                    + "<td></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Categoria c : categorias) {
                renglones += ""
                        + "<tr id='" + c.getId_categoria() + "'>"
                        + "<td>" + c.getId_categoria() + "</td>"
                        + "<td><a href='#' class='select_productos_categoria'>" + c.getCategoria() + "</a></td>"
                        + "<td style='width: 2%'><a class='update_categoria' href='#'><img src='images/i_edit.png'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_categoria' href='#'><img src='images/i_delete.png'/></a></td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_categorias_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categorias();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Categoria> categorias = new ArrayList<Categoria>();
            while (s.rs.next()) {
                Categoria e = new Categoria();
                e.setId_categoria(s.rs.getInt("id_categoria"));
                e.setCategoria(s.rs.getString("categoria"));
                categorias.add(e);
            }
            for (Categoria c : categorias) {
                renglones += "<option value='" + c.getId_categoria() + "'>" + c.getCategoria() + "</option>";
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
    public static String select_categoria_cliente_combo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categoria_cliente('" + id_usuario + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Categoria> categorias = new ArrayList<Categoria>();
            while (s.rs.next()) {
                Categoria e = new Categoria();
                e.setId_categoria(s.rs.getInt("id_categoria"));
                e.setCategoria(s.rs.getString("categoria"));
                categorias.add(e);
            }
            for (Categoria c : categorias) {
                renglones += "<option value='" + c.getId_categoria() + "'>" + c.getCategoria() + "</option>";
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
    public static String select_categorias_laser_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categorias_laser_combo();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Categoria> categorias = new ArrayList<Categoria>();
            while (s.rs.next()) {
                Categoria e = new Categoria();
                e.setId_categoria(s.rs.getInt("id_categoria"));
                e.setCategoria(s.rs.getString("categoria"));
                categorias.add(e);
            }
            for (Categoria c : categorias) {
                renglones += "<option value='" + c.getId_categoria() + "'>" + c.getCategoria() + "</option>";
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
    public static List<Categoria> select_categorias() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categorias();";
            s.rs = s.st.executeQuery(sql);
            List<Categoria> categorias = new ArrayList<Categoria>();
            while (s.rs.next()) {
                Categoria e = new Categoria();
                e.setId_categoria(s.rs.getInt("id_categoria"));
                e.setCategoria(s.rs.getString("categoria"));
                categorias.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return categorias;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_categoria(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_categoria('" + nombre + "');";
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
    public static String delete_categoria(int id_categoria) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_categoria('" + id_categoria + "');";
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
