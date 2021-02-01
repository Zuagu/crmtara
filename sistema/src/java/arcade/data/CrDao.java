package arcade.data;

import arcade.model.Cr;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class CrDao {

    //==============================================================================
    public static String select_cr_tabla(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_cr('" + id_asignacion + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Cr> cr = new ArrayList<Cr>();
            while (s.rs.next()) {
                Cr c = new Cr();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_cr(s.rs.getInt("id_cr"));
                c.setCr(s.rs.getString("cuenta"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setNumero_relacionado(s.rs.getString("numero_relacionado"));
                c.setEstatus_ab(s.rs.getString("estatus_ab"));
                c.setFecha_activacion(s.rs.getString("fecha_activacion"));
                c.setNombre(s.rs.getString("nombre"));
                c.setRfc(s.rs.getString("rfc"));
                cr.add(c);
            }

            renglones = ""
                    + "<table id='tabla_crs'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;width: 2%;'></th>"
                    + "<th style='text-align:center;'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>CUENTA*</th>"
                    + "<th style='text-align:center;'>NUMERO*</th>"
                    + "<th style='text-align:center;'>ESTATUS*</th>"
                    + "<th style='text-align:center;'>ACTIVACION*</th>"
                    + "<th style='text-align:center;'>RFC*</th>"
                    + "<th style='text-align:center;'>NOMBRE*</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int cons = 1;
            for (Cr c : cr) {
                renglones += ""
                        + "<tr id='" + c.getId_cr() + "'>"
                        + "<td style='text-align:right;'>" + cons + "</td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCr() + "</td>"
                        + "<td style='text-align:center;'>" + c.getNumero_relacionado() + "</td>"
                        + "<td style='text-align:center;'>" + c.getEstatus_ab() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_activacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRfc() + "</td>"
                        + "<td style='text-align:center;'>" + c.getNombre() + "</td>"
                        + "</tr>";
                cons++;
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
    public static String select_cr_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_cr();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Cr> cr = new ArrayList<Cr>();
            while (s.rs.next()) {
                Cr e = new Cr();
                e.setId_cr(s.rs.getInt("id_cr"));
                e.setCr(s.rs.getString("cr"));
                cr.add(e);
            }
            for (Cr c : cr) {
                renglones += "<option value='" + c.getId_cr() + "'>" + c.getCr() + "</option>";
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
    public static List<Cr> select_cr() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_cr();";
            s.rs = s.st.executeQuery(sql);
            List<Cr> cr = new ArrayList<Cr>();
            while (s.rs.next()) {
                Cr e = new Cr();
                e.setId_cr(s.rs.getInt("id_cr"));
                e.setCr(s.rs.getString("cr"));
                cr.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return cr;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_cr(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";

            String delete_crs = ("DELETE FROM `arcade_cuentas_relacionadas` WHERE `id_relacionada`>'0' and id_asignacion = '" + id_asignacion + "';");
            String sql_import = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\crs.csv'\n"
                    + "INTO TABLE arcade_cuentas_relacionadas -- 6 columnas\n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "IGNORE 1 ROWS\n"
                    + "(\n"
                    + "@col1,@col2,@col3,@col4,@col5,@col6\n"
                    + ")\n"
                    + "set\n"
                    + "id_asignacion='" + id_asignacion + "',\n"
                    + "cuenta=@col1,numero_relacionado=@col2,estatus_ab=@col3,\n"
                    + "fecha_activacion=@col4,rfc=@col5,nombre=@col6;";

            String sql_resultado = "call arcade_update_basegeneral_cr('" + +id_asignacion + "');";
            
            String sql_asignar_equipo = "sic_asignar_equipo("+ id_asignacion +")";

            s.st.executeUpdate(delete_crs);

            s.st.executeUpdate(sql_import);
            
            s.st.executeQuery(sql_asignar_equipo);

            System.out.println(delete_crs);
            System.out.println(sql_import);
            System.out.println(sql_resultado);

            s.rs = s.st.executeQuery(sql_resultado);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR insert_cr";
        }
    }

    //==========================================================================
    public static String update_cr(int id_cr) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_cr('" + id_cr + "');";
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
    public static String delete_cr(int id_cr) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_cr('" + id_cr + "');";
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
    public static String select_cr_cuenta_tabla(String cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_cr_cuenta('" + cuenta + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Cr> cr = new ArrayList<Cr>();
            while (s.rs.next()) {
                Cr c = new Cr();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_cr(s.rs.getInt("id_cr"));
                c.setCr(s.rs.getString("cuenta"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setNumero_relacionado(s.rs.getString("numero_relacionado"));
                c.setEstatus_ab(s.rs.getString("estatus_ab"));
                c.setFecha_activacion(s.rs.getString("fecha_activacion"));
                c.setNombre(s.rs.getString("nombre"));
                c.setRfc(s.rs.getString("rfc"));
                cr.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;width: 2%;'></th>"
                    + "<th style='text-align:center;'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>NUMERO CR</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>ACTIVACION</th>"
                    + "<th style='text-align:center;'>RFC</th>"
                    + "<th style='text-align:center;'>NOMBRE</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int cons = 1;
            for (Cr c : cr) {
                renglones += ""
                        + "<tr id='" + c.getId_cr() + "'>"
                        + "<td style='text-align:right;'>" + cons + "</td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCr() + "</td>"
                        + "<td style='text-align:center;'>" + c.getNumero_relacionado() + "</td>"
                        + "<td style='text-align:center;'>" + c.getEstatus_ab() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_activacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRfc() + "</td>"
                        + "<td style='text-align:center;'>" + c.getNombre() + "</td>"
                        + "</tr>";
                cons++;
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
