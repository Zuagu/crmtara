package arcade.data;

import arcade.model.Telefono;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class TelefonoDao {

    //==============================================================================
    public static String telefonos_cuenta(String cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_telefonos_cuenta('" + cuenta + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Telefono> telefono = new ArrayList<Telefono>();
            while (s.rs.next()) {
                Telefono c = new Telefono();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setTipo_tel(s.rs.getString("tipo_tel"));
                c.setLlamando(s.rs.getString("llamando"));
                c.setTelefono(s.rs.getString("numero"));
                c.setNombre(s.rs.getString("nombre"));
                telefono.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 7%;text-align:center;'><img src='images/i_add.png'/></th>"
                    + "<th style='width:7%;'></th>"
                    + "<th style='width: 81px;'>TELEFONO</th>"
                    + "<th>NOMBRE</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Telefono c : telefono) {
                renglones += ""
                        + "<tr id='" + c.getId_telefono() + "'>"
                        + "<td style='text-align:center;'>" + (Integer.parseInt(c.getTipo_tel()) == 0 || Integer.parseInt(c.getTipo_tel()) == 1 ? "<img src='images/tipo_tel" + c.getTipo_tel() + ".png'>" : "") + "</td>"
                        + "<td style='text-align:center;'>" + c.getLlamando() + "</td>"
                        + "<td><a href='#' class='a_marcar'><b>" + c.getTelefono() + "</b></a></td>"
                        + "<td>" + c.getNombre() + "</td>"
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
    public static String select_telefono_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_telefono();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Telefono> telefono = new ArrayList<Telefono>();
            while (s.rs.next()) {
                Telefono e = new Telefono();
                e.setId_telefono(s.rs.getInt("id_telefono"));
                e.setTelefono(s.rs.getString("telefono"));
                telefono.add(e);
            }
            for (Telefono c : telefono) {
                renglones += "<option value='" + c.getId_telefono() + "'>" + c.getTelefono() + "</option>";
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
    public static List<Telefono> select_telefono() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_telefono();";
            s.rs = s.st.executeQuery(sql);
            List<Telefono> telefono = new ArrayList<Telefono>();
            while (s.rs.next()) {
                Telefono e = new Telefono();
                e.setId_telefono(s.rs.getInt("id_telefono"));
                e.setTelefono(s.rs.getString("telefono"));
                telefono.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return telefono;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_telefono(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_telefono('" + nombre + "');";
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
    public static String update_telefono(int id_telefono) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_telefono('" + id_telefono + "');";
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
    public static String delete_telefono(int id_telefono) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_telefono('" + id_telefono + "');";
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
