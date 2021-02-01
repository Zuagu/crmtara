package arcade.data;

import arcade.model.Estrategia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class EstrategiaDao {

    //==============================================================================
    public static String select_estrategia_tabla(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estrategia('" + id_usuario + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Estrategia> estrategia = new ArrayList<Estrategia>();
            while (s.rs.next()) {
                Estrategia c = new Estrategia();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estrategia(s.rs.getInt("id_estrategia"));
                c.setEstrategia(s.rs.getString("estrategia"));
                c.setFuncion(s.rs.getString("funcion"));
                c.setDescripcion(s.rs.getString("descripcion"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setDesarrollo(s.rs.getInt("desarrollo"));
                estrategia.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>ESTRATEGIA</th>"
                    + "<th>FUNCION</th>"
                    + "<th>DESCRIPCION</th>"
                    + "<th>PUESTO</th>"
                    + "<th>DESARROLLO</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Estrategia c : estrategia) {
                renglones += ""
                        + "<tr id='" + c.getId_estrategia() + "'>"
                        + "<td>" + c.getId_estrategia() + "</td>"
                        + "<td>" + c.getEstrategia() + "</td>"
                        + "<td>" + c.getFuncion() + "</td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td>" + c.getPuesto() + "</td>"
                        + "<td>" + c.getDesarrollo() + "%</td>"
                        + "<td style='width: 2%'><input class='update_estrategia' href='#' type='button' value='SQL'></td>"
                        + "<td style='width: 2%'><a class='delete_estrategia' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_estrategia_combo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estrategia('" + id_usuario + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Estrategia> estrategia = new ArrayList<Estrategia>();
            while (s.rs.next()) {
                Estrategia e = new Estrategia();
                e.setId_estrategia(s.rs.getInt("id_estrategia"));
                e.setEstrategia(s.rs.getString("estrategia"));
                estrategia.add(e);
            }
            for (Estrategia c : estrategia) {
                renglones += "<option value='" + c.getId_estrategia() + "'>" + c.getEstrategia() + "</option>";
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
    public static List<Estrategia> select_estrategia() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estrategia();";
            s.rs = s.st.executeQuery(sql);
            List<Estrategia> estrategia = new ArrayList<Estrategia>();
            while (s.rs.next()) {
                Estrategia e = new Estrategia();
                e.setId_estrategia(s.rs.getInt("id_estrategia"));
                e.setEstrategia(s.rs.getString("estrategia"));
                estrategia.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return estrategia;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_estrategia(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_estrategia('" + nombre + "');";
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
    public static String update_estrategia(int id_estrategia) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_estrategia('" + id_estrategia + "');";
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
    public static String delete_estrategia(int id_estrategia) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_estrategia('" + id_estrategia + "');";
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
    public static String update_estrategia_gestor(int id_usuario, int id_estrategia, int id_estatus) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_estrategia_gestor('" + id_usuario + "', '" + id_estrategia + "', '" + id_estatus + "');";
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
