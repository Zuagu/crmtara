//package arcade.data;
//
//import arcade.model.Xxyyzz;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///* @author LUIS CORTEZ */
//public class XxyyzzDao {
//
//    //==============================================================================
//    public static String select_xxyyzz_tabla() {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_select_xxyyzz();";
//            String renglones;
//            s.rs = s.st.executeQuery(sql);
//            List<Xxyyzz> xxyyzz = new ArrayList<Xxyyzz>();
//            while (s.rs.next()) {
//                Xxyyzz c = new Xxyyzz();
//                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
//                c.setId_xxyyzz(s.rs.getInt("id_xxyyzz"));
//                c.setXxyyzz(s.rs.getString("xxyyzz"));
//                xxyyzz.add(c);
//            }
//
//            renglones = ""
//                    + "<table><thead><tr>"
//                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
//                    + "<th style='width: 2%'>ID</th>"
//                    + "<th>CATEGORIA</th>"
//                    + "<th></th>"
//                    + "<th></th>"
//                    + "</tr></thead>"
//                    + "<tr id='0'>"
//                    + "<td><a href='#' class='select_productos_xxyyzz'>*</a></td>"
//                    + "<td><input id='xxyyzz_insert' class='alfanumerico' type='text'></td>"
//                    + "<td><a id='insert_xxyyzz' href='#'><img src='images/i_add.png'/></a></td>"
//                    + "<td></td>"
//                    + "</tr>";
//
//            // CUEPRO DE LA TABLA
//            for (Xxyyzz c : xxyyzz) {
//                renglones += ""
//                        + "<tr id='" + c.getId_xxyyzz() + "'>"
//                        + "<td>" + c.getId_xxyyzz() + "</td>"
//                        + "<td><a href='#' class='select_productos_xxyyzz'>" + c.getXxyyzz() + "</a></td>"
//                        + "<td style='width: 2%'><a class='update_xxyyzz' href='#'><img src='images/i_edit.png'/></a></td>"
//                        + "<td style='width: 2%'><a class='delete_xxyyzz' href='#'><img src='images/i_delete.png'/></a></td>"
//                        + "</tr>";
//            }
//
//            renglones += "</table>";
//
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return renglones;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }
//
//    //==============================================================================
//    public static String select_xxyyzz_combo() {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_select_xxyyzz();";
//            String renglones = "";
//            s.rs = s.st.executeQuery(sql);
//            List<Xxyyzz> xxyyzz = new ArrayList<Xxyyzz>();
//            while (s.rs.next()) {
//                Xxyyzz e = new Xxyyzz();
//                e.setId_xxyyzz(s.rs.getInt("id_xxyyzz"));
//                e.setXxyyzz(s.rs.getString("xxyyzz"));
//                xxyyzz.add(e);
//            }
//            for (Xxyyzz c : xxyyzz) {
//                renglones += "<option value='" + c.getId_xxyyzz() + "'>" + c.getXxyyzz() + "</option>";
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return renglones;
//        } catch (SQLException ex) {
//            return "SQL Code: " + ex;
//        }
//    }
//
//    //==========================================================================
//    public static List<Xxyyzz> select_xxyyzz() {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_select_xxyyzz();";
//            s.rs = s.st.executeQuery(sql);
//            List<Xxyyzz> xxyyzz = new ArrayList<Xxyyzz>();
//            while (s.rs.next()) {
//                Xxyyzz e = new Xxyyzz();
//                e.setId_xxyyzz(s.rs.getInt("id_xxyyzz"));
//                e.setXxyyzz(s.rs.getString("xxyyzz"));
//                xxyyzz.add(e);
//            }
//
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return xxyyzz;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
//
//    //==========================================================================
//    public static String insert_xxyyzz(String nombre) {
//        try {
//            StartConn s = new StartConn();
//            String resultado = "";
//            String sql = "call arcade_insert_xxyyzz('" + nombre + "');";
//            s.rs = s.st.executeQuery(sql);
//            while (s.rs.next()) {
//                resultado = (s.rs.getString("resultado"));
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return resultado;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }
//
//    //==========================================================================
//    public static String update_xxyyzz(int id_xxyyzz) {
//        try {
//            StartConn s = new StartConn();
//            String resultado = "";
//            String sql = "call arcade_update_xxyyzz('" + id_xxyyzz + "');";
//            s.rs = s.st.executeQuery(sql);
//            while (s.rs.next()) {
//                resultado = (s.rs.getString("resultado"));
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return resultado;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }
//
//    //==========================================================================
//    public static String delete_xxyyzz(int id_xxyyzz) {
//        try {
//            StartConn s = new StartConn();
//            String resultado = "";
//            String sql = "call arcade_delete_xxyyzz('" + id_xxyyzz + "');";
//            s.rs = s.st.executeQuery(sql);
//            while (s.rs.next()) {
//                resultado = (s.rs.getString("resultado"));
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return resultado;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }
//    //==========================================================================
//}
