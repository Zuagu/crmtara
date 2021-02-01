package arcade.data;

import arcade.model.Puesto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class PuestoDao {

    public static String select_puesto_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_puesto();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Puesto> puesto = new ArrayList<Puesto>();
            while (s.rs.next()) {
                Puesto c = new Puesto();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_puesto(s.rs.getInt("id_puesto"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setDepartamento(s.rs.getString("departamento"));
                c.setVacantes_cubiertas(s.rs.getInt("vacantes_cubiertas"));
                c.setVacantes(s.rs.getInt("vacantes"));
                c.setPorcentaje(s.rs.getString("porcentaje"));
                puesto.add(c);
            }

            renglones = ""
                    + "<table id='tabla_puestos' class='bordered striped highlight'><thead><tr style=\"width: 100%;color: white; background-color: #c70314;\">"
                    // ESTS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='padding: 0px 1.5%';>DEPARTAMENTO</th>"
                    + "<th style='padding: 0px .01%';>PUESTO</th>"
                    + "<th>VACANTE</th>"
                    + "<th>%</th>"
                    + "</tr></thead>"
//                    + "<tfoot><tr style=\"width: 100%;color: white; background-color: #b71c1c ;\">"
//                    + "<th style='padding: 0px 1.5%';>DEPARTAMENTO</th>"
//                    + "<th style='padding: 0px .01%';>PUESTO</th>"
//                    + "<th>VACANTE</th>"
//                    + "<th>%</th>"
//                    + "</tr></tfoot>"
                    + "<tbody>"
                    + "<tr><td colspan='4'>"
                    + "<div class='innerb'>"
                    + "<table>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            for (Puesto c : puesto) {
                renglones += ""
                        + "<tr id='" + c.getId_puesto() + "' class='renglon'>"
                        + "<td style='padding: 4px 7px;width: 34.5%;'>" + c.getDepartamento() + "</td>"
                        + "<td style='padding: 4px 7px;width: 23%;'><a href='#' id='select_menu_puesto' class='select_menu_puesto'>" + c.getPuesto() + "</a></td>"
                        + "<td colspan='2' style='width: 30%;padding: 4px 7px;'>" + c.getVacantes_cubiertas() + " / <b>" + c.getVacantes() + "</b> </td>"
                        + "<td>" + c.getPorcentaje() + "</td>"
                        + "<tr>";
            }

            renglones += ""
                    + "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</td></tr>"
                    + "</tbody>"
                    + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_puesto_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_puesto();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Puesto> puesto = new ArrayList<Puesto>();
            while (s.rs.next()) {
                Puesto e = new Puesto();
                e.setId_puesto(s.rs.getInt("id_puesto"));
                e.setPuesto(s.rs.getString("puesto"));
                puesto.add(e);
            }
            for (Puesto c : puesto) {
                renglones += "<option value='" + c.getId_puesto() + "'>" + c.getPuesto() + "</option>";
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
    public static List<Puesto> select_puesto() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_puesto();";
            s.rs = s.st.executeQuery(sql);
            List<Puesto> puesto = new ArrayList<Puesto>();
            while (s.rs.next()) {
                Puesto e = new Puesto();
                e.setId_puesto(s.rs.getInt("id_puesto"));
                e.setPuesto(s.rs.getString("puesto"));
                puesto.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return puesto;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_puesto(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_puesto('" + nombre + "');";
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
    public static String update_puesto(int id_puesto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_puesto('" + id_puesto + "');";
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
    public static String delete_puesto(int id_puesto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_puesto('" + id_puesto + "');";
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
    public static String select_menu_puesto(int id_puesto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_menu_puesto('" + id_puesto + "');";
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
    public static String update_menu_puesto(int id_puesto, String html_menu) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_menu_puesto('" + id_puesto + "','" + html_menu + "');";
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
    public static String select_puesto_tabla_vac() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_puesto();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Puesto> puesto = new ArrayList<Puesto>();
            while (s.rs.next()) {
                Puesto c = new Puesto();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_puesto(s.rs.getInt("id_puesto"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setDepartamento(s.rs.getString("departamento"));
                c.setVacantes_cubiertas(s.rs.getInt("vacantes_cubiertas"));
                c.setVacantes(s.rs.getInt("vacantes"));
                c.setPorcentaje(s.rs.getString("porcentaje"));
                puesto.add(c);
            }

            renglones = "";

            // CUEPRO DE LA TABLA
            for (Puesto c : puesto) {
                renglones += ""
                        + "<tr id='" + c.getId_puesto() + "' class='renglon'>"
                        + "<td style='padding: 4px 7px;width: 181px;'>" + c.getDepartamento() + "</td>"
                        + "<td style='padding: 4px 7px;'><a href='#' class='select_menu_puesto'>" + c.getPuesto() + "</a></td>"
                        + "<td colspan='2' style='width: 84px;padding: 4px 7px;'>" + c.getVacantes_cubiertas() + " / <b>" + c.getVacantes() + "</b> </td>"
                        + "<td>" + c.getPorcentaje() + "</td>"
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
