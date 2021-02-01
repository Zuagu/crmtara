package arcade.data;

import arcade.model.Cotizacion;
import arcade.model.Linea;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Luis Cortez */
public class CotizacionDao {
//==============================================================================

    public static String select_cotizaciones_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_cotizaciones();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Cotizacion> proveedores = new ArrayList<Cotizacion>();
            while (s.rs.next()) {
                Cotizacion c = new Cotizacion();
                c.setId(s.rs.getInt("id"));
                c.setUsuario(s.rs.getString("usuario"));
                c.setCliente(s.rs.getString("cliente"));
                c.setSubtotal(s.rs.getFloat("subtotal"));
                c.setIva(s.rs.getFloat("iva"));
                c.setTotal(s.rs.getFloat("total"));
                c.setFecha(s.rs.getString("fecha"));
                c.setComentarios(s.rs.getString("comentarios"));
                proveedores.add(c);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table><thead><tr>"
                    + "<th style='width: 2%'>FOLIO</th>"
                    + "<th>ELABORÓ</th>"
                    + "<th>CLIENTE</th>"
                    + "<th>SUBTOTAL</th>"
                    + "<th>IVA</th>"
                    + "<th>TOTAL</th>"
                    + "<th>FECHA</th>"
                    + "<th>COMENTARIOS</th>"
                    + "<th></th>"
                    + "</tr></thead><tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (Cotizacion c : proveedores) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td style='text-align:center;color:red;font-weight:bold;'>" + c.getId() + "</td>"
                        + "<td>" + c.getUsuario() + "</td>"
                        + "<td><b>" + c.getCliente() + "</b></td>"
                        + "<td style='text-align:right;'>$" + c.getSubtotal() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getIva() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getTotal() + "</td>"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td><textarea disabled style='width:100%;resize:none;'>" + c.getComentarios() + "</textarea></td>"
                        + "<td style='width: 2%'><a class='select_cotizacion' href='#'><img src='images/i_page.png' title='VER ARCHIVO'/></a></td>"
                        + "</tr>";
            }
            // CUEPRO DE LA TABLA

            renglones += "</tbody></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

    public static String agregar_producto_cotizacion(int cantidad, String id_producto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_agregar_producto_cotizacion('" + cantidad + "', '" + id_producto + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

    public static String insert_cotizacion(
            int usuario_sistema,
            int id_cliente,
            Float subtotal,
            Float iva,
            Float total,
            int id_formapago,
            int numero_parcialidades,
            String id_metodopago,
            int cuenta_pago,
            int id_condicionespago,
            int dias_credito,
            int lugar_entrega,
            String comentarios,
            String lineas_cotizacion
    ) {
        try {
            StartConn s = new StartConn();
            String id = "";
            String sql = "call arcade_insert_cotizacion('" + usuario_sistema + "', '" + id_cliente + "','" + subtotal + "','" + iva + "','" + total + "','" + id_formapago + "','" + numero_parcialidades + "','" + id_metodopago + "','" + cuenta_pago + "','" + id_condicionespago + "','" + dias_credito + "','" + lugar_entrega + "', '" + comentarios + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            
            if (s.rs.next()) {
                id = s.rs.getString("resultado");
            }
            
            String sql2 = "INSERT INTO `arcade_lineas_cotizacion` (`id_padre`, `cantidad`, `id_producto`, `precio`, `importe`) VALUES ";
            System.out.println(sql2);
            String ldvs[] = lineas_cotizacion.split("#AND#");

            for (String ldv : ldvs) {
                String lv[] = ldv.split("#-#");
                System.out.println("UNA COLUMNA DE LINEA DE VENTA:" + lv[0]);
                sql2 += "('" + id + "', '" + lv[0] + "', '" + lv[1] + "', '" + lv[2] + "','" + lv[3] + "'),";
            }
            sql2 = sql2.substring(0, sql2.length() - 1);
            sql2 += ";";
            s.st.executeUpdate(sql2);

            String resultado = id;

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

    public static String select_datos_cliente_cotizacion(int folio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_cliente_cotizacion('" + folio + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

    public static String select_cuerpo_cotizacion(int folio) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_cuerpo_cotizacion('" + folio + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Linea> lineas = new ArrayList<Linea>();
            while (s.rs.next()) {
                Linea l = new Linea();
                l.setCantidad(s.rs.getInt("cantidad"));
                l.setId_producto(s.rs.getString("id_producto"));
                l.setUnidad(s.rs.getString("unidad"));
                l.setProducto(s.rs.getString("producto"));
                l.setPrecio(s.rs.getString("precio"));
                l.setImporte(s.rs.getString("importe"));
                lineas.add(l);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table style='border: solid 1px black;'><thead><tr>"
                    + "<th style='width: 2%;border: solid 1px black;text-align:center;'>No.</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>CANTIDAD</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>CLAVE</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>UNIDAD</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>DESCRIPCION</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>UNITARIO</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>IMPORTE</th>"
                    + "</tr></thead><tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            int lv = 1;
            for (Linea l : lineas) {
                renglones += ""
                        + "<td style='border: solid 1px black;text-align:center;'>" + lv + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + l.getCantidad() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + l.getId_producto() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + l.getUnidad() + "</td>"
                        + "<td style='border: solid 1px black;'>" + l.getProducto() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + l.getPrecio() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + l.getImporte() + "</td>"
                        + "</tr>";
                lv++;
            }
            // CUEPRO DE LA TABLA

            renglones += "</tbody></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

    public static String select_importes_cotizacion(int folio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_importes_cotizacion('" + folio + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================
}