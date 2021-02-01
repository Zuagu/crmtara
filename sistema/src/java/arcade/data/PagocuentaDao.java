package arcade.data;

import arcade.model.Pagocuenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class PagocuentaDao {

    //==============================================================================
    public static String select_pagos_asignacion_tabla(int _id_asignacion) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pagos_asignacion('" + _id_asignacion + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_pago(s.rs.getInt("id_pago"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setOrigen(s.rs.getString("origen"));
                c.setImporte(s.rs.getFloat("importe"));
                c.setForma(s.rs.getString("forma"));
                c.setEstatus(s.rs.getString("status"));
                c.setFecha_aplicacion(s.rs.getString("fecha_aplicacion"));
                pagocuenta.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width:2%;'></th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>FECHA PAGO</th>"
                    + "<th style='text-align:center;'>ORIGEN</th>"
                    + "<th style='text-align:center;'>IMPORTE</th>"
                    + "<th style='text-align:center;'>FORMA</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>FECHA APLICACION</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int _cons = 1;
            for (Pagocuenta c : pagocuenta) {

                renglones += ""
                        + "<tr id='" + c.getId_pago() + "'>"
                        + "<td style='text-align:right;'>" + _cons + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_pago() + "</td>"
                        + "<td style='text-align:center;'>" + c.getOrigen() + "</td>"
                        + "<td style='text-align:right;'>" + c.getImporte() + "</td>"
                        + "<td style='text-align:center;'>" + c.getForma() + "</td>"
                        + "<td style='text-align:center;'>" + c.getEstatus() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_aplicacion() + "</td>"
                        + "</tr>";
                _cons++;
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
    public static String select_pagos_asignacion_tabla_fecha(int _id_asignacion, String _fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pagos_asignacion_fecha('" + _id_asignacion + "', '" + _fecha + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_pago(s.rs.getInt("id_pago"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setOrigen(s.rs.getString("origen"));
                c.setImporte(s.rs.getFloat("importe"));
                c.setForma(s.rs.getString("forma"));
                c.setEstatus(s.rs.getString("status"));
                c.setFecha_aplicacion(s.rs.getString("fecha_aplicacion"));
                pagocuenta.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width:2%;'></th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>FECHA PAGO</th>"
                    + "<th style='text-align:center;'>ORIGEN</th>"
                    + "<th style='text-align:center;'>IMPORTE</th>"
                    + "<th style='text-align:center;'>FORMA</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>FECHA APLICACION</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int _cons = 1;
            for (Pagocuenta c : pagocuenta) {
                renglones += ""
                        + "<tr id='" + c.getId_pago() + "'>"
                        + "<td style='text-align:right;'>" + _cons + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_pago() + "</td>"
                        + "<td style='text-align:center;'>" + c.getOrigen() + "</td>"
                        + "<td style='text-align:right;'>" + c.getImporte() + "</td>"
                        + "<td style='text-align:center;'>" + c.getForma() + "</td>"
                        + "<td style='text-align:center;'>" + c.getEstatus() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_aplicacion() + "</td>"
                        + "</tr>";
                _cons++;
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
    public static String select_pagocuenta_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pagocuenta();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta e = new Pagocuenta();
                e.setCuenta(s.rs.getString("pagocuenta"));
                pagocuenta.add(e);
            }
            for (Pagocuenta c : pagocuenta) {
                renglones += "<option value='" + c.getId_pago() + "'>" + c.getId_pago() + "</option>";
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
    public static List<Pagocuenta> select_pagocuenta() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pagocuenta();";
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta e = new Pagocuenta();
                pagocuenta.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return pagocuenta;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_pagocuenta(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_pagocuenta('" + nombre + "');";
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
    public static String update_pagocuenta(int id_pagocuenta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_pagocuenta('" + id_pagocuenta + "');";
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
    public static String delete_pagocuenta(int id_pagocuenta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_pagocuenta('" + id_pagocuenta + "');";
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
    //==============================================================================
    public static String select_pagos_cuenta_tabla(String cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pagos_cuenta('" + cuenta + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_pago(s.rs.getInt("id_pago"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setOrigen(s.rs.getString("origen"));
                c.setImporte(s.rs.getFloat("importe"));
                c.setForma(s.rs.getString("forma"));
                c.setEstatus(s.rs.getString("status"));
                c.setFecha_aplicacion(s.rs.getString("fecha_aplicacion"));
                pagocuenta.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width:2%;'></th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>FECHA PAGO</th>"
                    + "<th style='text-align:center;'>ORIGEN</th>"
                    + "<th style='text-align:center;'>IMPORTE</th>"
                    + "<th style='text-align:center;'>FORMA</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>FECHA APLICACION</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int _cons = 1;
            for (Pagocuenta c : pagocuenta) {

                renglones += ""
                        + "<tr id='" + c.getId_pago() + "'>"
                        + "<td style='text-align:right;'>" + _cons + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_pago() + "</td>"
                        + "<td style='text-align:center;'>" + c.getOrigen() + "</td>"
                        + "<td style='text-align:right;'>" + c.getImporte() + "</td>"
                        + "<td style='text-align:center;'>" + c.getForma() + "</td>"
                        + "<td style='text-align:center;'>" + c.getEstatus() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_aplicacion() + "</td>"
                        + "</tr>";
                _cons++;
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
    //==========================================================================
}
