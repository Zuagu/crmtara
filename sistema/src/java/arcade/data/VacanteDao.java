package arcade.data;

import arcade.model.Vacante;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/* @author LUIS CORTEZ */
public class VacanteDao {

    //==============================================================================
    public static String select_vacante_tabla(int id_puesto) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call org_select_vacantes_puesto('" + id_puesto + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Vacante> vacante = new ArrayList<Vacante>();
            while (s.rs.next()) {
                Vacante c = new Vacante();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_vacante(s.rs.getInt("id_vacante"));
                c.setVacante(s.rs.getString("vacante"));
                c.setUsuario(s.rs.getString("usuario"));
                c.setFecha_creacion_vacante(s.rs.getString("fecha_creacion_vacante"));
                c.setFecha_asignacion_usuario(s.rs.getString("fecha_asignacion_usuario"));
                vacante.add(c);
            }
            renglones = ""
                    + "<table class=''><thead><tr style=\"width: 460px;color: white; background-color: #c70314;\">"
                    // ESTS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "</tr></thead>"
                    + "<tfoot><tr style=\"width: 100%;color: white; background-color: #b71c1c ;\">"
                    + "</tr></tfoot>"
                    + "<tbody>"
                    + "<tr><td colspan='4'>"
                    + "<div class=''>"
                    + "<table class='bordered striped highlight'>"
                    + "<tbody class='listado_vacantes z-depth-1'>";

            // CUEPRO DE LA TABLA
            for (Vacante c : vacante) {
                renglones += ""
                        + "<tr style='padding: 4px 2px 4px 19.9px;'  id='" + c.getId_vacante() + "'class='renglon vacante_tr'>"
                        + "<td style=';width:20%;'><a href='#' class='get_id_vacante'>" + c.getVacante() + "</a></td>"
                        + "<td style=';width: 20%;'><b class='get_usuarioName'>" + c.getUsuario() + "</b></td>"
                        + "<td style=' width:20%'>" + c.getFecha_creacion_vacante() + "</td>"
                        + "<td style=' width:20%'>" + c.getFecha_asignacion_usuario() + "</td>"
                        + "</tr>";
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
    public static String select_vacante_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_vacante();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Vacante> vacante = new ArrayList<Vacante>();
            while (s.rs.next()) {
                Vacante e = new Vacante();
                e.setId_vacante(s.rs.getInt("id_vacante"));
                e.setVacante(s.rs.getString("vacante"));
                vacante.add(e);
            }
            for (Vacante c : vacante) {
                renglones += "<option value='" + c.getId_vacante() + "'>" + c.getVacante() + "</option>";
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
    public static List<Vacante> select_vacante() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_vacante();";
            s.rs = s.st.executeQuery(sql);
            List<Vacante> vacante = new ArrayList<Vacante>();
            while (s.rs.next()) {
                Vacante e = new Vacante();
                e.setId_vacante(s.rs.getInt("id_vacante"));
                e.setVacante(s.rs.getString("vacante"));
                vacante.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return vacante;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_vacante(String vacante, int id_puesto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_insert_vacante('" + vacante + "', '" + id_puesto + "');";
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
    public static String update_vacante(int id_vacante) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_vacante('" + id_vacante + "');";
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
    public static String delete_vacante(int id_vacante) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_delete_vacante('" + id_vacante + "');";
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
    public static String udpate_id_usuario_vacante(int id_vacante, int id_usuario, Float sueldo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_update_id_usuario_vacante('" + id_vacante + "', '" + id_usuario + "', '" + sueldo + "');";
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
    public static String reasignar_vacante(int puesto, int vacante, int usuario_id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_vacante('" + puesto + "', '" + vacante + "', '" + usuario_id + "');";
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
    public static String select_data_vacante(int id_puesto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_select_vacantes_puesto('" + id_puesto + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            JSONArray lista_vacantes = new JSONArray();
            while (s.rs.next()) {
                JSONObject vacantes = new JSONObject();
                vacantes.put("id_vacante", s.rs.getInt("id_vacante"));
                vacantes.put("vacante", s.rs.getString("vacante"));
                vacantes.put("id_puesto", s.rs.getInt("id_puesto"));
                vacantes.put("id_usuario", s.rs.getInt("id_usuario"));
                vacantes.put("usuario", s.rs.getString("usuario"));
                vacantes.put("fecha_creacion_vacante", s.rs.getString("fecha_creacion_vacante"));
                vacantes.put("fecha_asignacion_usuario", s.rs.getString("fecha_asignacion_usuario"));
                lista_vacantes.add(vacantes);
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return lista_vacantes.toString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
}
