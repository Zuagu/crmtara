package arcade.data;

import arcade.model.OrdenDeCompra;
import arcade.model.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Luis Cortez */
public class ProveedorDao {
//==============================================================================

    public static String select_proveedores_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_proveedores();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Proveedor> proveedores = new ArrayList<Proveedor>();
            while (s.rs.next()) {
                Proveedor c = new Proveedor();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                c.setRfc(s.rs.getString("rfc"));
                c.setColonia(s.rs.getString("colonia"));
                c.setCalle(s.rs.getString("calle"));
                c.setNum_ext(s.rs.getString("num_ext"));
                c.setNum_int(s.rs.getString("num_int"));
                c.setEmail(s.rs.getString("email"));
                c.setTelefonos(s.rs.getString("telefonos"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setDeuda(s.rs.getString("deuda"));
                c.setPagado(s.rs.getString("pagado"));
                c.setSaldo(s.rs.getString("saldo"));
                proveedores.add(c);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table style='width:100%;'><thead><tr>"
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>RAZON SOCIAL</th>"
                    + "<th>R. F. C.</th>"
                    + "<th>COLONIA</th>"
                    + "<th>CALLE</th>"
                    + "<th>NUM. EXT.</th>"
                    + "<th>NUM. INT.</th>"
                    + "<th>TELFONOS</th>"
                    + "<th>EMAIL</th>"
                    + "<th>CONTACTO</th>"
                    + "<th>SALDO</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (Proveedor c : proveedores) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td><input class='id transparente' type='text' value='" + c.getId() + "' style='width:100%;' readonly></td>"
                        + "<td><input class='razon_social transparente' type='text' value='" + c.getRazon_social() + "' style='width:300px;'></td>"
                        + "<td><input class='rfc transparente' type='text' value='" + c.getRfc() + "'></td>"
                        + "<td><input class='colonia transparente' type='text' value='" + c.getColonia() + "'></td>"
                        + "<td><input class='calle transparente' type='text' value='" + c.getCalle() + "'></td>"
                        + "<td><input class='num_ext transparente' type='text' value='" + c.getNum_ext() + "'></td>"
                        + "<td><input class='num_int transparente' type='text' value='" + c.getNum_int() + "'></td>"
                        + "<td><input class='telefonos transparente' type='text' value='" + c.getTelefonos() + "'></td>"
                        + "<td><input class='email transparente' type='text' value='" + c.getEmail() + "'></td>"
                        + "<td><input class='comentarios transparente' type='text' value='" + c.getComentarios() + "'></td>"
                        + "<td>" + c.getSaldo() + "</td>"
                        + "<td style='width: 2%'><a class='update_proveedor' href='#'><img src='images/i_save.png' title='GUARDAR CAMBIOS'/></a></td>"
                        + "<td style='width: 2%'><a class='deuda_proveedor' href='#'><img src='images/i_archive.png' title='VER DEUDA ACTIVA DEL PROVEEDOR'/></a></td>"
                        + "<td style='width: 2%'><a class='archivo_proveedor' href='#'><img src='images/i_ver.png' title='VER ARCHIVO DEL PROVEEDOR'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_proveedor' href='#'><img src='images/i_delete.png' title='ELIMINAR PROVEEDOR'/></a></td>"
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

    public static String select_proveedores_filtro(String filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_proveedores_filtro('" + filtro + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Proveedor> proveedores = new ArrayList<Proveedor>();
            while (s.rs.next()) {
                Proveedor c = new Proveedor();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                c.setRfc(s.rs.getString("rfc"));
                c.setColonia(s.rs.getString("colonia"));
                c.setCalle(s.rs.getString("calle"));
                c.setNum_ext(s.rs.getString("num_ext"));
                c.setNum_int(s.rs.getString("num_int"));
                c.setEmail(s.rs.getString("email"));
                c.setTelefonos(s.rs.getString("telefonos"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setDeuda(s.rs.getString("deuda"));
                c.setPagado(s.rs.getString("pagado"));
                c.setSaldo(s.rs.getString("saldo"));
                proveedores.add(c);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table><thead><tr>"
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>RAZON SOCIAL</th>"
                    + "<th>R. F. C.</th>"
                    + "<th>COLONIA</th>"
                    + "<th>CALLE</th>"
                    + "<th>NUM. EXT.</th>"
                    + "<th>NUM. INT.</th>"
                    + "<th>TELFONOS</th>"
                    + "<th>EMAIL</th>"
                    + "<th>CONTACTO</th>"
                    + "<th>SALDO</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (Proveedor c : proveedores) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td><input class='id transparente' type='text' value='" + c.getId() + "' style='width:100%;' readonly></td>"
                        + "<td><input class='razon_social transparente' type='text' value='" + c.getRazon_social() + "' style='width:300px;'></td>"
                        + "<td><input class='rfc transparente' type='text' value='" + c.getRfc() + "'></td>"
                        + "<td><input class='colonia transparente' type='text' value='" + c.getColonia() + "'></td>"
                        + "<td><input class='calle transparente' type='text' value='" + c.getCalle() + "'></td>"
                        + "<td><input class='num_ext transparente' type='text' value='" + c.getNum_ext() + "'></td>"
                        + "<td><input class='num_int transparente' type='text' value='" + c.getNum_int() + "'></td>"
                        + "<td><input class='telefonos transparente' type='text' value='" + c.getTelefonos() + "'></td>"
                        + "<td><input class='email transparente' type='text' value='" + c.getEmail() + "'></td>"
                        + "<td><input class='comentarios transparente' type='text' value='" + c.getComentarios() + "'></td>"
                        + "<td>" + c.getSaldo() + "</td>"
                        + "<td style='width: 2%'><a class='update_proveedor' href='#'><img src='images/i_save.png' title='GUARDAR CAMBIOS'/></a></td>"
                        + "<td style='width: 2%'><a class='deuda_proveedor' href='#'><img src='images/i_archive.png' title='VER DEUDA ACTIVA DEL PROVEEDOR'/></a></td>"
                        + "<td style='width: 2%'><a class='archivo_proveedor' href='#'><img src='images/i_ver.png' title='VER ARCHIVO DEL PROVEEDOR'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_proveedor' href='#'><img src='images/i_delete.png' title='ELIMINAR PROVEEDOR'/></a></td>"
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

    public static String select_proveedores_combo() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_proveedores();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Proveedor> proveedores = new ArrayList<Proveedor>();
            while (s.rs.next()) {
                Proveedor c = new Proveedor();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                proveedores.add(c);
            }
            for (Proveedor c : proveedores) {
                renglones += "<option value='" + c.getId() + "'>" + c.getRazon_social() + "</option>";
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

    public static String insert_proveedor(Proveedor proveedor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_proveedor('" + proveedor.getRazon_social() + "', '" + proveedor.getRfc() + "','" + proveedor.getCodigo_postal() + "','" + proveedor.getColonia() + "','" + proveedor.getCalle() + "','" + proveedor.getNum_ext() + "','" + proveedor.getNum_int() + "','" + proveedor.getId_pais() + "','" + proveedor.getId_estado() + "','" + proveedor.getId_municipio() + "','" + proveedor.getTelefonos() + "','" + proveedor.getEmail() + "', '" + proveedor.getComentarios() + "');";
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

    public static String arcade_update_proveedor(Proveedor proveedor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_proveedor('" + proveedor.getId() + "','" + proveedor.getRazon_social() + "', '" + proveedor.getRfc() + "','" + proveedor.getCodigo_postal() + "','" + proveedor.getColonia() + "','" + proveedor.getCalle() + "','" + proveedor.getNum_ext() + "','" + proveedor.getNum_int() + "','" + proveedor.getId_pais() + "','" + proveedor.getId_estado() + "','" + proveedor.getId_municipio() + "','" + proveedor.getTelefonos() + "','" + proveedor.getEmail() + "', '" + proveedor.getComentarios() + "');";
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

    public static String delete_proveedor(int id, int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_proveedor('" + id + "', '" + id_usuario + "');";
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

    public static String update_proveedor(Proveedor p) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_proveedor('" + p.getId() + "', '" + p.getRazon_social() + "','" + p.getRfc() + "','" + p.getColonia() + "','" + p.getCalle() + "','" + p.getNum_ext() + "','" + p.getNum_int() + "','" + p.getTelefonos() + "','" + p.getEmail() + "','" + p.getComentarios() + "');";
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

    public static String select_datos_proveedor(int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_proveedor('" + id + "');";
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

    public static String cuerpo_estado_de_cuenta(int id) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_cuerpo_estado_de_cuenta('" + id + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<OrdenDeCompra> ordenes = new ArrayList<OrdenDeCompra>();
            while (s.rs.next()) {
                OrdenDeCompra o = new OrdenDeCompra();
                o.setId(s.rs.getInt("id"));
                o.setFecha(s.rs.getString("fecha"));
                o.setFactura(s.rs.getString("factura"));
                o.setFecha_factura(s.rs.getString("fecha_factura"));
                o.setDias_credito(s.rs.getInt("dias_credito"));
                o.setVencimiento(s.rs.getString("vencimiento"));
                o.setTotal(s.rs.getString("total"));
                o.setAbonos(s.rs.getString("abonos"));
                o.setSaldo(s.rs.getString("saldo"));
                ordenes.add(o);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table style='border: solid 1px black;'><thead><tr>"
                    + "<th style='border: solid 1px black;text-align:center;'>O. C.</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>FECHA OC</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>FACTURA</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>FECHA FACT.</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>DIAS CREDITO</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>VENCIMIENTO</th>"
                    + "<th style='border: solid 1px black;text-align:right;'>TOTAL</th>"
                    + "<th style='border: solid 1px black;text-align:right;'>ABONOS</th>"
                    + "<th style='border: solid 1px black;text-align:right;'>SALDO</th>"
                    + "</tr></thead><tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (OrdenDeCompra o : ordenes) {
                renglones += ""
                        + "<td style='border: solid 1px black;text-align:center;color:red;'>" + o.getId() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + o.getFecha() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;font-weight: bold;'>" + o.getFactura() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;font-weight: bold;'>" + o.getFecha_factura() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + o.getDias_credito() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + o.getVencimiento() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + o.getTotal() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + o.getAbonos() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + o.getSaldo() + "</td>"
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

    public static String select_importes_edc(int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_importes_edc('" + id + "');";
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

    public static String cuerpo_estado_de_cuenta_deudaactual(int id) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_cuerpo_estado_de_cuenta_deudaactual('" + id + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<OrdenDeCompra> ordenes = new ArrayList<OrdenDeCompra>();
            while (s.rs.next()) {
                OrdenDeCompra o = new OrdenDeCompra();
                o.setId(s.rs.getInt("id"));
                o.setFecha(s.rs.getString("fecha"));
                o.setFactura(s.rs.getString("factura"));
                o.setFecha_factura(s.rs.getString("fecha_factura"));
                o.setDias_credito(s.rs.getInt("dias_credito"));
                o.setVencimiento(s.rs.getString("vencimiento"));
                o.setTotal(s.rs.getString("total"));
                o.setAbonos(s.rs.getString("abonos"));
                o.setSaldo(s.rs.getString("saldo"));
                ordenes.add(o);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table style='border: solid 1px black;'><thead><tr>"
                    + "<th style='border: solid 1px black;text-align:center;'>O. C.</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>FECHA OC</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>FACTURA</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>FECHA FACT.</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>DIAS CREDITO</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>VENCIMIENTO</th>"
                    + "<th style='border: solid 1px black;text-align:right;'>TOTAL</th>"
                    + "<th style='border: solid 1px black;text-align:right;'>ABONOS</th>"
                    + "<th style='border: solid 1px black;text-align:right;'>SALDO</th>"
                    + "</tr></thead><tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (OrdenDeCompra o : ordenes) {
                renglones += ""
                        + "<td style='border: solid 1px black;text-align:center;color:red;'>" + o.getId() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + o.getFecha() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;font-weight: bold;'>" + o.getFactura() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;font-weight: bold;'>" + o.getFecha_factura() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + o.getDias_credito() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + o.getVencimiento() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + o.getTotal() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + o.getAbonos() + "</td>"
                        + "<td style='border: solid 1px black;text-align:right;'>" + o.getSaldo() + "</td>"
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

    public static String select_importes_edc_deudaactual(int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_importes_edc_deudaactual('" + id + "');";
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
