package arcade.data;

import arcade.model.OrdenDeCompra;
import arcade.model.Linea;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Luis Cortez */
public class OrdenDeCompraDao {
//==============================================================================

    public static String select_ordenes_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_ordenes();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<OrdenDeCompra> proveedores = new ArrayList<OrdenDeCompra>();
            while (s.rs.next()) {
                OrdenDeCompra c = new OrdenDeCompra();
                c.setId(s.rs.getInt("id"));
                c.setUsuario(s.rs.getString("usuario"));
                c.setProveedor(s.rs.getString("proveedor"));
                c.setId_requisicion(s.rs.getInt("id_requisicion"));
                c.setSubtotal(s.rs.getString("subtotal"));
                c.setIva(s.rs.getString("iva"));
                c.setTotal(s.rs.getString("total"));
                c.setFecha(s.rs.getString("fecha"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setAutorizado_por(s.rs.getString("autorizado_por"));
                c.setFactura(s.rs.getString("factura"));
                c.setFecha_factura(s.rs.getString("fecha_factura"));
                proveedores.add(c);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table><thead><tr>"
                    + "<th style='width: 2%'>FOLIO</th>"
                    + "<th style='text-align:center;'>ELABORÓ</th>"
                    + "<th style='text-align:center;'>PROVEEDOR</th>"
                    + "<th style='text-align:center;'>REQUISICION</th>"
                    + "<th style='text-align:center;'>SUBTOTAL</th>"
                    + "<th style='text-align:center;'>IVA</th>"
                    + "<th style='text-align:center;'>TOTAL</th>"
                    + "<th style='text-align:center;'>FECHA</th>"
                    + "<th style='text-align:center;'>COMENTARIOS</th>"
                    + "<th style='text-align:center;'>FACTURA</th>"
                    + "<th style='text-align:center;' title='FECHA FACTURA'>FECHA</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead><tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (OrdenDeCompra c : proveedores) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td style='text-align:center;color:red;font-weight:bold;'>" + c.getId() + "</td>"
                        + "<td>" + c.getUsuario() + "</td>"
                        + "<td title='" + c.getProveedor() + "'><b>" + c.getProveedor() + "</b></td>"
                        + "<td style='text-align:center;'><b>" + c.getId_requisicion() + "</b></td>"
                        + "<td style='text-align:right;'>$" + c.getSubtotal() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getIva() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getTotal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha() + "</td>"
                        + "<td><textarea disabled style='width:100%;resize:none;'>" + c.getComentarios() + "</textarea></td>"
                        + "<td style='text-align:center;'><input class='input_factura' value='" + c.getFactura() + "' style='border-radius: 5px;border: solid 1px lightgrey;width: 100px;text-align: center;' type='text'></td>"
                        + "<td style='text-align:center;'><input class='datepicker fecha_factura' value='" + c.getFecha_factura() + "' readonly style='border-radius: 5px;border: solid 1px lightgrey;width: 100px;text-align: center;' type='text'></td>"
                        + "<td style='text-align:center;' title='" + c.getAutorizado_por() + "'>" + c.getEstatus() + "</td>"
                        + "<td style='width: 2%'><a class='update_orden_autorizar' href='#'><img src='images/i_tick.png' title='AUTORIZAR ARCHIVO'/></a></td>"
                        + "<td style='width: 2%'><a class='select_orden' href='#'><img src='images/i_page.png' title='VER ARCHIVO'/></a></td>"
                        + "<td style='width: 2%'><a class='update_orden_delete' href='#'><img src='images/i_delete.png' title='CANCELAR ARCHIVO'/></a></td>"
                        + "</tr>";
            }
            // CUEPRO DE LA TABLA

            renglones += "</tbody></table>"
                    + "<script type='text/javascript' src='datepicker/jquery-ui.js'></script>"
                    + "<link rel='stylesheet' href='datepicker/jquery-ui.css'>"
                    + "<script>"
                    + "$(function () {'"
                    + "$('.datepicker').datepicker({changeMonth: true, changeYear: true, numberOfMonths: 1});'"
                    + "});</script>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

    public static String agregar_producto_orden(float cantidad, String id_producto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_agregar_producto_orden('" + cantidad + "', '" + id_producto + "');";
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

    public static String insert_orden(
            int usuario_sistema,
            int id_proveedor,
            int id_requisicion,
            int id_empresa,
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
            String lineas_orden
    ) {
        try {
            StartConn s = new StartConn();
            String id = "";
            String sql = "call arcade_insert_ordendecompra('" + usuario_sistema + "', '" + id_proveedor + "','" + id_requisicion + "','" + id_empresa + "','" + subtotal + "','" + iva + "','" + total + "','" + id_formapago + "','" + numero_parcialidades + "','" + id_metodopago + "','" + cuenta_pago + "','" + id_condicionespago + "','" + dias_credito + "','" + lugar_entrega + "', '" + comentarios + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);

            if (s.rs.next()) {
                id = s.rs.getString("resultado");
            }

            String sql2 = "INSERT INTO `arcade_lineas_ordenesdecompra` (`id_padre`, `cantidad`, `id_producto`, `precio`, `importe`) VALUES ";
            String ldvs[] = lineas_orden.split("#AND#");

            for (String ldv : ldvs) {
                String lv[] = ldv.split("#-#");
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

    public static String select_datos_proveedor_orden(int folio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_proveedor_orden('" + folio + "');";
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

    public static String select_cuerpo_orden(int folio) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_cuerpo_orden('" + folio + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Linea> lineas = new ArrayList<Linea>();
            while (s.rs.next()) {
                Linea l = new Linea();
                l.setCantidad(s.rs.getFloat("cantidad"));
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
                        + "<td style='border: solid 1px black;text-align:right;'>$" + l.getPrecio() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>$" + l.getImporte() + "</td>"
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

    public static String select_cuerpo_orden_requisicion(int folio) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_cuerpo_orden_requisicion('" + folio + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Linea> lineas = new ArrayList<Linea>();
            while (s.rs.next()) {
                Linea l = new Linea();
                l.setCantidad(s.rs.getFloat("cantidad"));
                l.setId_producto(s.rs.getString("id_producto"));
                l.setUnidad(s.rs.getString("unidad"));
                l.setProducto(s.rs.getString("producto"));
                l.setPrecio(s.rs.getString("precio"));
                l.setImporte(s.rs.getString("importe"));
                lineas.add(l);
            }

            // CUEPRO DE LA TABLA
            for (Linea l : lineas) {
                renglones += "<tr>"
                        + "<td class='lv' style='text-align:center;'></td>"
                        + "<td><input disabled class='prod transparente cantidad' value='" + l.getCantidad() + "' type='text' style='width:30px;text-align:center;''></td>"
                        + "<td style='display:none'><input class='prod' value='#-#'></td>"
                        + "<td>" + l.getUnidad() + "</td>"
                        + "<td><input disabled class='prod transparente' value='" + l.getId_producto() + "' type='text'></td>"
                        + "<td>" + l.getProducto() + "</td>"
                        + "<td style='display:none'><input class='prod' value='#-#'></td>"
                        + "<td><input class='precio prod transparente flotante' value='" + l.getPrecio() + "' type='text'></td>"
                        + "<td style='display:none'><input class='prod' value='#-#'></td>"
                        + "<td><input disabled class='importe prod transparente' value='" + l.getImporte() + "' type='text'></td>"
                        + "<td style='width:2%;'><input class='eliminar_linea_orden' value='-' style='height: 30px;width:30px;font-size: 26px;' type='button'></td>\n"
                        + "<td style='display:none'><input class='prod' value='#AND#'></td>"
                        + "</tr>";
            }
            // CUEPRO DE LA TABLA

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

    public static String select_importes_orden(int folio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_importes_orden('" + folio + "');";
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

    public static String update_orden_compra(int folio, int id_usuario, int f_autorizado) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_orden_compra('" + folio + "', '" + id_usuario + "', '" + f_autorizado + "');";
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

    public static String update_factura_orden(int _id_oc, String _factura) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_factura_orden('" + _id_oc + "', '" + _factura + "');";
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

    public static String update_fecha_factura_orden(int _id_oc, String _fecha_factura) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_fecha_factura_orden('" + _id_oc + "', '" + _fecha_factura + "');";
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

    public static String select_ordenes_sin_pagar_proveedor(int id_proveedor) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_ordenes_sin_pagar_proveedor('" + id_proveedor + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<OrdenDeCompra> ordenes = new ArrayList<OrdenDeCompra>();
            while (s.rs.next()) {
                OrdenDeCompra o = new OrdenDeCompra();
                o.setId(s.rs.getInt("id"));
                o.setComentarios(s.rs.getString("oc"));
                ordenes.add(o);
            }
            for (OrdenDeCompra o : ordenes) {
                renglones += "<option value='" + o.getId() + "'>" + o.getComentarios() + "</option>";
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

    public static String select_deuda_general(int id_empresa) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_deuda_general('" + id_empresa + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<OrdenDeCompra> ocs = new ArrayList<OrdenDeCompra>();
            while (s.rs.next()) {
                OrdenDeCompra oc = new OrdenDeCompra();
                oc.setId_proveedor(s.rs.getInt("id_proveedor"));
                oc.setProveedor(s.rs.getString("proveedor"));
                oc.setTotal(s.rs.getString("saldo"));
                ocs.add(oc);
            }
            renglones += "<table>"
                    + "<thead>"
                    + "<tr>"
                    + "<th>ID</th>"
                    + "<th>RAZON SOCIAL PROVEEDOR</th>"
                    + "<th>SALDO</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            for (OrdenDeCompra oc : ocs) {

                renglones += "<tr>"
                        + "<td><b>" + oc.getId_proveedor() + "</b></td>"
                        + "<td><b>" + oc.getProveedor() + "</b></td>"
                        + "<td style='text-align:right;'><b>$" + oc.getTotal() + "</b></td>"
                        + "</tr>";

                String sql2 = "call arcade_cuerpo_estado_de_cuenta_deudaactual_empresa('" + oc.getId_proveedor() + "', '" + id_empresa + "');";
                System.out.println(sql2);
                s.rs = s.st.executeQuery(sql2);
                List<OrdenDeCompra> list_ocs_provedor = new ArrayList<OrdenDeCompra>();
                while (s.rs.next()) {
                    OrdenDeCompra ocs_provedor = new OrdenDeCompra();
                    ocs_provedor.setFecha_factura(s.rs.getString("fecha_factura"));
                    ocs_provedor.setFactura(s.rs.getString("factura"));
                    ocs_provedor.setTotal(s.rs.getString("saldo"));
                    list_ocs_provedor.add(ocs_provedor);
                }
                for (OrdenDeCompra ocs_provedor : list_ocs_provedor) {
                    renglones += "<tr>"
                            + "<td>" + ocs_provedor.getFecha_factura() + "</td>"
                            + "<td>FACTURA: " + ocs_provedor.getFactura() + "</td>"
                            + "<td style='text-align:right;'>" + ocs_provedor.getTotal() + "</td>"
                            + "</tr>";
                }
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
}
