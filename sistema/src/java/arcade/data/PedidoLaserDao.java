package arcade.data;

import arcade.model.PedidoLaser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class PedidoLaserDao {

    //==============================================================================
    public static String select_pedidos_laser_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pedidos_laser();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<PedidoLaser> pedidos_laser = new ArrayList<PedidoLaser>();
            while (s.rs.next()) {
                PedidoLaser c = new PedidoLaser();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_pedido(s.rs.getInt("id_categoria"));
                pedidos_laser.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>CLIENTE</th>"
                    + "<th>FECHA REGISTRO</th>"
                    + "<th>PORCENTAJE AVANCE</th>"
                    + "<th>INICIO CORTE</th>"
                    + "<th>FIN CORTE</th>"
                    + "<th></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (PedidoLaser c : pedidos_laser) {
                renglones += ""
                        + "<tr id='" + c.getId_pedido() + "'>"
                        + "<td>" + c.getId_pedido() + "</td>"
                        + "<td>" + c.getCliente() + "</td>"
                        + "<td>" + c.getFecha_registro() + "</td>"
                        + "<td>" + c.getFecha_inicio_corte() + "</td>"
                        + "<td>" + c.getFecha_fin_corte() + "</td>"
                        + "<td style='width: 2%'><a class='select_pedido_aser' href='#'><img src='images/i_archive.png'/></a></td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String select_pedidos_laser_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pedidos_laser();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<PedidoLaser> pedidos_laser = new ArrayList<PedidoLaser>();
            while (s.rs.next()) {
                PedidoLaser e = new PedidoLaser();
                e.setId_pedido(s.rs.getInt("id_pedido"));
                e.setId_requisicion(s.rs.getInt("id_requisicion"));
                pedidos_laser.add(e);
            }
            for (PedidoLaser c : pedidos_laser) {
                renglones += "<option value='" + c.getId_pedido() + "'>PEDIDO " + c.getId_pedido() + " (REQUISICION " + c.getId_requisicion() + ")</option>";
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String select_pedidos_laser_usuario_combo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pedidos_laser_usuario_combo('" + id_usuario + "');";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<PedidoLaser> pedidos_laser = new ArrayList<PedidoLaser>();
            while (s.rs.next()) {
                PedidoLaser e = new PedidoLaser();
                e.setId_pedido(s.rs.getInt("id_pedido"));
                pedidos_laser.add(e);
            }
            for (PedidoLaser c : pedidos_laser) {
                renglones += "<option value='" + c.getId_pedido() + "'>PEDIDO " + c.getId_pedido() + "</option>";
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
    public static String insert_pedido_laser(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_pedido_laser('" + nombre + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String delete_pedido_laser(int id_pedido_laser) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_categoria('" + id_pedido_laser + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String insert_pedido_laser(int id_cotizacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_pedido_laser('" + id_cotizacion + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_detalles_pedido_laser(int id_pedido) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_detalles_pedido_laser('" + id_pedido + "');";
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
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
}
