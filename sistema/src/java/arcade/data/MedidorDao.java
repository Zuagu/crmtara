package arcade.data;

import arcade.model.Medidor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class MedidorDao {

    //==========================================================================
    public static String select_medidor_tabla(int id_puesto) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_medidor('" + id_puesto + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Medidor> medidor = new ArrayList<Medidor>();
            while (s.rs.next()) {
                Medidor c = new Medidor();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_medidor(s.rs.getInt("id_medidor"));
                c.setMedidor(s.rs.getString("medidor"));
                c.setDescripcion(s.rs.getString("descripcion"));
                medidor.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>MEDIDOR / INDICADOR</th>"
                    + "<th>DESCRIPCION</th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tr>"
                    + "<td>*</td>"
                    + "<td><input id='medidor_insert' class='alfanumerico' type='text'></td>"
                    + "<td><textarea id='descripcion_insert' style='width:100%;resize: none;'></textarea></td>"
                    + "<td style='text-align:center;'><a class='insert_medidor' href='#'><img src='images/i_add.png'/></a></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            int _cons = 1;
            for (Medidor c : medidor) {
                renglones += ""
                        + "<tr id='" + c.getId_medidor() + "'>"
                        + "<td>" + _cons + "</td>"
                        + "<td><input type='text' value='" + c.getMedidor() + "' style='font-weight:bold;border:none;background:transparent;'></td>"
                        + "<td><input type='text;' value='" + c.getDescripcion() + "' style='border:none;background:transparent;'></td>"
                        + "<td style='width: 2%'><a class='delete_medidor' href='#'><img src='images/i_delete.png'/></a></td>"
                        + "</tr>";
                _cons++;
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
    public static String select_medidor_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_medidor();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Medidor> medidor = new ArrayList<Medidor>();
            while (s.rs.next()) {
                Medidor e = new Medidor();
                e.setId_medidor(s.rs.getInt("id_medidor"));
                e.setMedidor(s.rs.getString("medidor"));
                medidor.add(e);
            }
            for (Medidor c : medidor) {
                renglones += "<option value='" + c.getId_medidor() + "'>" + c.getMedidor() + "</option>";
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
    public static List<Medidor> select_medidor() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_medidor();";
            s.rs = s.st.executeQuery(sql);
            List<Medidor> medidor = new ArrayList<Medidor>();
            while (s.rs.next()) {
                Medidor e = new Medidor();
                e.setId_medidor(s.rs.getInt("id_medidor"));
                e.setMedidor(s.rs.getString("medidor"));
                medidor.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return medidor;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_medidor(int id_puesto, String medidor, String descripcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_medidor('" + id_puesto + "', '" + medidor + "', '" + descripcion + "');";
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
    public static String update_medidor(int id_medidor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_medidor('" + id_medidor + "');";
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
    public static String delete_medidor(int id_medidor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_medidor('" + id_medidor + "');";
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
