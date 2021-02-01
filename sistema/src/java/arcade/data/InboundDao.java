package arcade.data;

import arcade.model.Inbound;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Cortez
 */
public class InboundDao {

    //==========================================================================
    public static String select_inbound_fecha(String fecha, String hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_inbound_fecha('" + fecha + "','" + hasta + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Inbound> inbound = new ArrayList<Inbound>();
            while (s.rs.next()) {
                Inbound c = new Inbound();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setSrc(s.rs.getString("src"));
                c.setDst(s.rs.getString("dst"));
                c.setBillsec(s.rs.getInt("billsec"));
                c.setDisposition(s.rs.getString("disposition"));
                c.setDid(s.rs.getString("did"));
                inbound.add(c);
            }

            renglones = ""
                    + "<table id='tabla_entradas'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>FECHA</th>"
                    + "<th>HORA</th>"
                    + "<th>SRC</th>"
                    + "<th>DST</th>"
                    + "<th>BILLSEC</th>"
                    + "<th>DISPOSITION</th>"
                    + "<th>DID</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (Inbound c : inbound) {
                renglones += "<tr " + (c.getDisposition().equals("NO ANSWER") ? "style='background:#FE5D49;'" : "") + ">"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getSrc() + "</td>"
                        + "<td>" + c.getDst() + "</td>"
                        + "<td>" + c.getBillsec() + "</td>"
                        + "<td>" + c.getDisposition() + "</td>"
                        + "<td>" + c.getDid() + "</td>"
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

    //==========================================================================
    public static String select_inbound_fecha_resumen(String fecha, String hasta, String _group) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_inbound_fecha_resumen('" + fecha + "','" + hasta + "','" + _group + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Inbound> inbound = new ArrayList<Inbound>();
            while (s.rs.next()) {
                Inbound c = new Inbound();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setFecha(s.rs.getString("concepto"));
                c.setDisposition(s.rs.getString("veces"));
                inbound.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>CONCEPTO</th>"
                    + "<th>EVENTOS</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (Inbound c : inbound) {
                renglones += "<tr>"
                        + "<td style='text-align:right;'>" + c.getFecha() + "</td>"
                        + "<td  style='text-align:right;'>" + c.getDisposition() + "</td>"
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

    //==========================================================================
    public static String select_outbound_fecha(String fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_outbound_fecha('" + fecha + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Inbound> inbound = new ArrayList<Inbound>();
            while (s.rs.next()) {
                Inbound c = new Inbound();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setSrc(s.rs.getString("src"));
                c.setDst(s.rs.getString("dst"));
                c.setBillsec(s.rs.getInt("billsec"));
                c.setDisposition(s.rs.getString("disposition"));
                c.setDid(s.rs.getString("did"));
                inbound.add(c);
            }

            renglones = ""
                    + "<table id='tabla_entradas'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>FECHA</th>"
                    + "<th>HORA</th>"
                    + "<th>SRC</th>"
                    + "<th>DST</th>"
                    + "<th>BILLSEC</th>"
                    + "<th>DISPOSITION</th>"
                    + "<th>DID</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (Inbound c : inbound) {
                renglones += "<tr " + (c.getDisposition().equals("NO ANSWER") ? "style='background:#FE5D49;'" : "") + ">"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getSrc() + "</td>"
                        + "<td>" + c.getDst() + "</td>"
                        + "<td>" + c.getBillsec() + "</td>"
                        + "<td>" + c.getDisposition() + "</td>"
                        + "<td>" + c.getDid() + "</td>"
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

    //==========================================================================
    public static String select_outbound_fecha_resumen(String fecha, String _group) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_inbound_fecha_resumen('" + fecha + "','" + _group + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Inbound> inbound = new ArrayList<Inbound>();
            while (s.rs.next()) {
                Inbound c = new Inbound();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setFecha(s.rs.getString("concepto"));
                c.setDisposition(s.rs.getString("veces"));
                inbound.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>CONCEPTO</th>"
                    + "<th>EVENTOS</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (Inbound c : inbound) {
                renglones += "<tr>"
                        + "<td style='text-align:right;'>" + c.getFecha() + "</td>"
                        + "<td  style='text-align:right;'>" + c.getDisposition() + "</td>"
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

    //==========================================================================
    public static String select_inbound_serie(String fecha_inicio, String fecha_fin, String disp) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_inbound_serie('" + fecha_inicio + "', '" + fecha_fin + "', '" + disp + "');";
            System.out.println(result_set);
            s.rs = s.st.executeQuery(result_set);
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

    public static String select_detalles_inbound(String fecha_inicio, String fecha_fin) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_detalles_inbound('" + fecha_inicio + "', '" + fecha_fin + "');";
            System.out.println(result_set);
            s.rs = s.st.executeQuery(result_set);
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
}
