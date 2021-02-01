package arcade.data;

import arcade.model.Equipo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class EquipoDao {

    //=============================================================================
    //==============================================================================
    public static String select_equipo_check(String cadena_asignaciones) {
        try {
            StartConn s = new StartConn();
            String sql = "select distinct(id_equipo), nombre_equipo(id_equipo) as equipo from arcade_basegeneral where id_asignacion in (" + cadena_asignaciones + ") and id_equipo > 0 order by id_equipo;";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Equipo> equipo = new ArrayList<Equipo>();
            while (s.rs.next()) {
                Equipo c = new Equipo();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_equipo(s.rs.getInt("id_equipo"));
                c.setEquipo(s.rs.getString("equipo"));
                equipo.add(c);
            }

            renglones = ""
                    + "<table id='equipo_disp'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th><input id='check_equipo_todos' type='checkbox' style='cursor:pointer;'></th>"
                    + "<th>EQUIPO</th>"
                    + "</tr></tr><tbody>";

            for (Equipo c : equipo) {
                renglones += ""
                        + "<tr id='" + c.getId_equipo() + "'>"
                        + "<td style='text-align:center;width:34px;'><input class='check_equipo' type='checkbox' style='cursor:pointer;'></td>"
                        + "<td>" + c.getEquipo() + "</td>"
                        + "</tr>";
            }
            renglones += "</tbody><table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_equipo_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_equipo();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Equipo> equipo = new ArrayList<Equipo>();
            while (s.rs.next()) {
                Equipo e = new Equipo();
                e.setId_equipo(s.rs.getInt("id_equipo"));
                e.setEquipo(s.rs.getString("equipo"));
                equipo.add(e);
            }

            for (Equipo c : equipo) {
                renglones += "<option value='" + c.getId_equipo() + "'>" + c.getEquipo() + "</option>";
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
    public static String insert_equipo() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_equipo();";
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
    public static String update_equipo(int id_equipo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_equipo('" + id_equipo + "');";
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
    public static String delete_equipo(int id_equipo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_equipo('" + id_equipo + "');";
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
    public static String deshacer_equipo(int id_equipo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_deshacer_equipo('" + id_equipo + "');";
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
    public static String reset_equipo(int id_equipo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_reset_equipo('" + id_equipo + "');";
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

    //==============================================================================
    public static String select_usuarios_equipo(int id_equipo) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_equipo_usuarios('" + id_equipo + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Equipo> equipo = new ArrayList<Equipo>();
            while (s.rs.next()) {
                Equipo c = new Equipo();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_equipo(s.rs.getInt("id_equipo"));
                c.setId_usuario(s.rs.getInt("id_usuario"));
                c.setUsuario(s.rs.getString("usuario"));
                equipo.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "<th style='width: 2%'></th>"
                    + "</tr></thead></tr>";

            // CUEPRO DE LA TABLA
            for (Equipo c : equipo) {
                renglones += ""
                        + "<tr id='" + c.getId_usuario() + "'>"
                        + "<td style='text-align:right;'>" + c.getId_usuario() + "</td>"
                        + "<td>" + c.getUsuario() + "</td>"
                        + "<td><img class='delete_gestor_equipo' src='images/i_delete.png'></td>"
                        + "</tr>";
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
}
