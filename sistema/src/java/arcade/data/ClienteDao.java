package arcade.data;

import arcade.model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Luis Cortez */
public class ClienteDao {
//==============================================================================

    public static String select_clientes_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_clientes();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (s.rs.next()) {
                Cliente c = new Cliente();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                c.setRfc(s.rs.getString("rfc"));
                c.setColonia(s.rs.getString("colonia"));
                c.setCalle(s.rs.getString("calle"));
                c.setNum_ext(s.rs.getString("num_ext"));
                c.setNum_int(s.rs.getString("num_int"));
                c.setTelefonos(s.rs.getString("telefonos"));
                c.setEmail(s.rs.getString("email"));
                c.setComentarios(s.rs.getString("comentarios"));
                clientes.add(c);
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
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (Cliente c : clientes) {
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
                        + "<td style='width: 2%'><a class='edit_cliente' href='#'><img src='images/i_edit.png' title='GUARDAR CAMBIOS'/></a></td>"
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

    public static String select_clientes_check() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_clientes();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (s.rs.next()) {
                Cliente c = new Cliente();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                clientes.add(c);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table id='cliente_disp'><thead><tr>"
                    + "<th></th>"
                    + "<th>CLIENTE</th>"
                    + "</tr></thead>"
                    + "<tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (Cliente c : clientes) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td style='padding: 0px;'><input type='checkbox' class='check_cliente' style='cursor:pointer;'></td>"
                        + "<td><input class='razon_social transparente' type='text' value='" + c.getRazon_social() + "'></td>"
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

    //==========================================================================
    public static String select_clientes_filtro(String filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_clientes_filtro('" + filtro + "');";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (s.rs.next()) {
                Cliente c = new Cliente();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                c.setRfc(s.rs.getString("rfc"));
                c.setColonia(s.rs.getString("colonia"));
                c.setCalle(s.rs.getString("calle"));
                c.setNum_ext(s.rs.getString("num_ext"));
                c.setNum_int(s.rs.getString("num_int"));
                c.setTelefonos(s.rs.getString("telefonos"));
                c.setEmail(s.rs.getString("email"));
                c.setComentarios(s.rs.getString("comentarios"));
                clientes.add(c);
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
                    + "</tr></thead>"
                    + "<tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (Cliente c : clientes) {
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
                        + "<td>0.00</td>"
                        + "<td style='width: 2%'><a class='update_cliente' href='#'><img src='images/i_save.png' title='GUARDAR CAMBIOS'/></a></td>"
                        + "<td style='width: 2%'><a class='archivo_cliente' href='#'><img src='images/i_ver.png' title='VER ARCHIVO DEL CLIENTE'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_cliente' href='#'><img src='images/i_delete.png' title='ELIMINAR CLIENTE'/></a></td>"
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

    public static String select_clientes_combo() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_clientes();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (s.rs.next()) {
                Cliente c = new Cliente();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                clientes.add(c);
            }
            for (Cliente c : clientes) {
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

    public static String insert_cliente(Cliente cliente) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_cliente('" + cliente.getRazon_social() + "', '" + cliente.getRfc() + "','" + cliente.getCodigo_postal() + "','" + cliente.getColonia() + "','" + cliente.getCalle() + "','" + cliente.getNum_ext() + "','" + cliente.getNum_int() + "','" + cliente.getId_pais() + "','" + cliente.getId_estado() + "','" + cliente.getId_municipio() + "','" + cliente.getTelefonos() + "','" + cliente.getEmail() + "', '" + cliente.getComentarios() + "');";
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

    public static String arcade_update_cliente(Cliente cliente) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_cliente('" + cliente.getId() + "','" + cliente.getRazon_social() + "', '" + cliente.getRfc() + "','" + cliente.getCodigo_postal() + "','" + cliente.getColonia() + "','" + cliente.getCalle() + "','" + cliente.getNum_ext() + "','" + cliente.getNum_int() + "','" + cliente.getId_pais() + "','" + cliente.getId_estado() + "','" + cliente.getId_municipio() + "','" + cliente.getTelefonos() + "','" + cliente.getEmail() + "', '" + cliente.getComentarios() + "');";
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

    public static String delete_cliente(int id, int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_cliente('" + id + "', '" + id_usuario + "');";
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

    public static String update_cliente(Cliente c) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_cliente('" + c.getId() + "', '" + c.getRazon_social() + "','" + c.getRfc() + "','" + c.getColonia() + "','" + c.getCalle() + "','" + c.getNum_ext() + "','" + c.getNum_int() + "','" + c.getTelefonos() + "','" + c.getEmail() + "','" + c.getComentarios() + "');";
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

    public static String select_datos_fiscales() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_fiscales();";
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
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_datos_fiscales";
        }
    }
//==============================================================================

    public static String select_datos_fiscales_oc(int folio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_fiscales_oc('" + folio + "');";
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
    public static String update_datos_fiscales(Cliente c) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_datos_fiscales('" + c.getNombre_comercial() + "', '" + c.getRazon_social() + "','" + c.getRfc() + "','" + c.getColonia() + "','" + c.getCalle() + "','" + c.getCodigo_postal() + "','" + c.getMunicipio() + "','" + c.getEstado() + "','" + c.getTelefonos() + "','" + c.getPagina_web() + "');";
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
    public static String select_clientes_combo_materialize() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_clientes();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (s.rs.next()) {
                Cliente c = new Cliente();
                c.setId(s.rs.getInt("id"));
                c.setRazon_social(s.rs.getString("razon_social"));
                clientes.add(c);
            }
            for (Cliente c : clientes) {
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
}
