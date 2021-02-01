package arcade.data;
 
import arcade.model.Region;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
/* @author LUIS CORTEZ */
public class RegionDao {
 
    //==============================================================================
    public static String select_region_tabla(int id_cliente) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_region('" + id_cliente + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Region> region = new ArrayList<Region>();
            while (s.rs.next()) {
                Region c = new Region();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_region(s.rs.getInt("id_region"));
                c.setRegion(s.rs.getString("region"));
                c.setId_cliente(s.rs.getInt("id_cliente"));
                region.add(c);
            }
 
            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>REGION</th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><input id='region_insert' class='alfanumerico' type='text'></td>"
                    + "<td style='width:2%;'><a id='insert_region' href='#'><img src='images/i_add.png'/></a></td>"
                    + "</tr><tbody>";
 
            // CUEPRO DE LA TABLA
            for (Region c : region) {
                renglones += ""
                        + "<tr id='" + c.getId_region() + "'>"
                        + "<td>" + c.getRegion() + "</td>"
                        + "<td style='width: 2%'><a class='delete_region' href='#'><img src='images/i_delete.png'/></a></td>"
                        + "</tr>";
            }
 
            renglones += "</tbody></table>";
 
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
 
    //==============================================================================
    public static String select_region_check(String _cadena_clientes) {
        try {
            StartConn s = new StartConn();
            String sql = "select * from arcade_regiones_clientes where id_cliente in (" + _cadena_clientes + ");";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Region> region = new ArrayList<Region>();
            while (s.rs.next()) {
                Region c = new Region();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_region(s.rs.getInt("id_region"));
                c.setRegion(s.rs.getString("region"));
                region.add(c);
            }
 
            renglones = ""
                    + "<table id='region_disp'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th><input id='check_region_todos' type='checkbox' style='cursor:pointer;'></th>"
                    + "<th>REGION</th>"
                    + "</tr></tr><tbody>";
 
            // CUEPRO DE LA TABLA
            for (Region c : region) {
                renglones += ""
                        + "<tr id='" + c.getId_region() + "'>"
                        + "<td><input type='checkbox' class='check_region' style='cursor:pointer;'></td>"
                        + "<td>" + c.getRegion() + "</td>"
                        + "</tr>";
            }
 
            renglones += "</tbody></table>";
 
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
 
    //==============================================================================
    public static String select_region_combo(int id_cliente) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_region('" + id_cliente + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Region> region = new ArrayList<Region>();
            while (s.rs.next()) {
                Region e = new Region();
                e.setId_region(s.rs.getInt("id_region"));
                e.setRegion(s.rs.getString("region"));
                region.add(e);
            }
            for (Region c : region) {
                renglones += "<option value='" + c.getId_region() + "'>" + c.getRegion() + "</option>";
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
    public static List<Region> select_region() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_region();";
            s.rs = s.st.executeQuery(sql);
            List<Region> region = new ArrayList<Region>();
            while (s.rs.next()) {
                Region e = new Region();
                e.setId_region(s.rs.getInt("id_region"));
                e.setRegion(s.rs.getString("region"));
                region.add(e);
            }
 
            s.rs.close();
            s.st.close();
            s.conn.close();
            return region;
        } catch (SQLException ex) {
            return null;
        }
    }
 
    //==========================================================================
    public static String insert_region(String region, int id_cliente) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_region('" + region + "', '" + id_cliente + "');";
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
    public static String update_region(int id_region) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_region('" + id_region + "');";
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
    public static String delete_region(int id_region) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_region('" + id_region + "');";
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
        public static String select_region_combo_materialize(int id_cliente) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_region('" + id_cliente + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Region> region = new ArrayList<Region>();
            while (s.rs.next()) {
                Region e = new Region();
                e.setId_region(s.rs.getInt("id_region"));
                e.setRegion(s.rs.getString("region"));
                region.add(e);
            }
            for (Region c : region) {
                renglones += "<option value='" + c.getId_region() + "'>" + c.getRegion() + "</option>";
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
}