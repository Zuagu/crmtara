package arcade.data;

import arcade.model.PagoProveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Luis Cortez */
public class PagoProveedorDao {
//==============================================================================

    public static String select_pagos_proveedor_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_pagos_oc();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<PagoProveedor> pagos = new ArrayList<PagoProveedor>();
            while (s.rs.next()) {
                PagoProveedor p = new PagoProveedor();
                p.setFolio(s.rs.getInt("folio"));
                p.setId_oc(s.rs.getInt("id_oc"));
                p.setRegistrante(s.rs.getString("registrante"));
                p.setImporte(s.rs.getFloat("importe"));
                p.setMetodopago(s.rs.getString("metodopago"));
                p.setCuenta(s.rs.getString("cuenta"));
                p.setComentarios(s.rs.getString("comentarios"));
                p.setProveedor(s.rs.getString("proveedor"));
                pagos.add(p);
            }

            //ENCABEZADOS TABLA
            renglones = ""
                    + "<table><thead><tr>"
                    + "<th style='width: 2%;text-align:center;'>FOLIO</th>"
                    + "<th style='text-align:center;'>O. C.</th>"
                    + "<th style='text-align:center;'>REGISTRÓ</th>"
                    + "<th style='text-align:center;'>IMPORTE</th>"
                    + "<th style='text-align:center;'>METODO PAGO</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>PROVEEDOR</th>"
                    + "<th style='text-align:center;'>COMENTARIOS</th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tbody>";
            //ENCABEZADOS TABLA

            // CUEPRO DE LA TABLA
            for (PagoProveedor p : pagos) {
                renglones += ""
                        + "<tr id='" + p.getFolio() + "'>"
                        + "<td style='text-align:center;'>" + p.getFolio() + "</td>"
                        + "<td style='text-align:center;'>" + p.getId_oc() + "</td>"
                        + "<td>" + p.getRegistrante() + "</td>"
                        + "<td style='text-align:right;'>" + p.getImporte() + "</td>"
                        + "<td>" + p.getMetodopago() + "</td>"
                        + "<td>" + p.getCuenta() + "</td>"
                        + "<td>" + p.getProveedor() + "</td>"
                        + "<td>" + p.getComentarios() + "</td>"
                        + "<td style='width: 2%'><a class='delete_pago_oc' href='#'><img src='images/i_delete.png' title='ELIMINAR PAGO'/></a></td>"
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

    public static String insert_pago_oc(PagoProveedor p) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_pago_oc('" + p.getId_registrante() + "', '" + p.getId_proveedor() + "','" + p.getId_oc() + "','" + p.getImporte() + "','" + p.getId_metodopago() + "','" + p.getId_cuenta() + "','" + p.getId_banco_destino() + "','" + p.getId_cuenta_destino() + "','" + p.getComentarios() + "');";
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

    public static String delete_pago_oc(int id, int id_usuario) {
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
}
