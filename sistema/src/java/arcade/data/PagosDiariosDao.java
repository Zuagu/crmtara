package arcade.data;

import arcade.model.Pagocuenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

/* @author LUIS CORTEZ */
public class PagosDiariosDao {

    //==========================================================================
    public static String select_pagos_diarios_tabla(int id_region, String desde, String hasta) {
        try {
            DecimalFormat deci = new DecimalFormat("0.00");
            StartConn s = new StartConn();
            String sql = "call arcade_select_pagos_diarios('" + id_region + "','" + desde + "','" + hasta + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setForma(s.rs.getString("color"));
                c.setDesde(s.rs.getString("fecha"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setId_equipo(s.rs.getString("id_equipo"));
                c.setNombre_equipo(s.rs.getString("nombre_equipo"));
                c.setVencido(s.rs.getString("vencido"));
                c.setResto(s.rs.getString("resto"));
                c.setPago(s.rs.getString("pago"));
                c.setAplica(s.rs.getString("aplica"));
                c.setResto_actual(s.rs.getString("resto_actual"));
                pagocuenta.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight' style='font-size:13px !important;'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:left;'>FECHA</th>"
                    + "<th style='text-align:left;'>ASIGNACION</th>"
                    + "<th style='text-align:left;'>CUENTA</th>"
                    + "<th style='text-align:left;'>ID EQUIPO</th>"
                    + "<th style='text-align:center;width: 380px;'>NOMBRE EQUIPO</th>"
                    + "<th style='text-align:left;'>VENCIDO</th>"
                    + "<th style='text-align:left;'>RESTO ANT</th>"
                    + "<th style='text-align:left;'>PAGO</th>"
                    + "<th style='text-align:left;width: 105px;'>APLICA</th>"
                    + "<th style='text-align:left;'>RESTO ACTUAL</th>"
                    + "</tr></thead>"
                    +"<tbody>"
                    + "<tr><td colspan='10'>"
                    + "<div class='innerb_recuperacion'>"
                    + "<table>"
                    + "<tbody>";

            Double total_final = 0.00;
            Double total_final_equipo = 0.00;
            String last_asignacion = "none";
            String last_equipo_id = "none";
            String last_equipo = "none";

            // CUEPRO DE LA TABLA
            for (Pagocuenta c : pagocuenta) {
                if (last_asignacion.equals("none") || last_asignacion.equals(c.getAsignacion())) {
                    total_final = total_final + Double.parseDouble(c.getAplica().replaceAll("^\"|\"$", ""));
                    Double total_final_equipo_pasado = total_final_equipo;
                    total_final_equipo = total_final_equipo + Double.parseDouble(c.getAplica().replaceAll("^\"|\"$", ""));

                    if (last_equipo_id.equals(c.getId_equipo()) || last_equipo_id.equals("none")) {
                        renglones += "";

                        if (c.getForma().equals("1")) {
                            renglones += "<tr style=''>";
                        } else {
                            renglones += "<tr style='font-weight:bold;background-color:#e0e0e0 ;'>";
                        }
                        renglones += "<td style='text-align:left;'>" + c.getDesde() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getAsignacion() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getCuenta() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getId_equipo() + "</td>";
                        renglones += "<td style='text-align:left;center;width: 450px;'>" + c.getNombre_equipo() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getVencido() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getResto() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getPago() + "</td>";
                        renglones += "<td style='text-align:left;'>" + "$ " + c.getAplica() + "</td>";
                        renglones += "<td style='text-align:left;width: 120px;'>" + c.getResto_actual() + "</td>";
                        renglones += "</tr>";
                    } else {
                        renglones += "";
                        renglones += "<tr style='color:black;background-color:#9e9e9e!;'>";
                        renglones += "<td style='text-align:left;'> Asignacion: </td>";
                        renglones += "<td style='text-align:left;'>" + last_asignacion + "</td>";
                        renglones += "<td style='text-align:left;'></td>";
                        renglones += "<td style='text-align:left;'>" + last_equipo_id + "</td>";
                        renglones += "<td style='text-align:left;center;width: 450px;'>" + last_equipo + "</td>";
                        renglones += "<td style='text-align:left;'></td>";
                        renglones += "<td style='text-align:left;'></td>";
                        renglones += "<td style='text-align:left;'> Total: </td>";
                        renglones += "<td style='text-align:left;'>" + "$ " + deci.format(total_final_equipo_pasado) + "</td>";
                        renglones += "<td style='text-align:left;width: 120px;'></td>";
                        renglones += "</tr>";

                        total_final_equipo = Double.parseDouble(c.getAplica().replaceAll("^\"|\"$", ""));

                        renglones += "";
                        if (c.getForma().equals("1")) {
                            renglones += "<tr style=''>";
                        } else {
                            renglones += "<tr style='font-weight:bold;'>";
                        }
                        renglones += "<td style='text-align:left;'>" + c.getDesde() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getAsignacion() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getCuenta() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getId_equipo() + "</td>";
                        renglones += "<td style='text-align:left;center;width: 450px;'>" + c.getNombre_equipo() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getVencido() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getResto() + "</td>";
                        renglones += "<td style='text-align:left;'>" + c.getPago() + "</td>";
                        renglones += "<td style='text-align:left;'>" + "$ " + c.getAplica() + "</td>";
                        renglones += "<td style='text-align:left;width: 120px;'>" + c.getResto_actual() + "</td>";
                        renglones += "</tr>";
                    }
                } else {
                    renglones += "";
                    renglones += "<tr style='color:black;background-color:#9e9e9e;'>";
                    renglones += "<td style='text-align:left;'> Asignacion: </td>";
                    renglones += "<td style='text-align:left;'>" + last_asignacion + "</td>";
                    renglones += "<td style='text-align:left;'></td>";
                    renglones += "<td style='text-align:left;'>" + last_equipo_id + "</td>";
                    renglones += "<td style='text-align:left;center;width: 450px;'>" + last_equipo + "</td>";
                    renglones += "<td style='text-align:left;'></td>";
                    renglones += "<td style='text-align:left;'></td>";
                    renglones += "<td style='text-align:left;'> Total: </td>";
                    renglones += "<td style='text-align:left;'>" + "$ " + deci.format(total_final_equipo) + "</td>";
                    renglones += "<td style='text-align:left;width: 120px;'></td>";
                    renglones += "</tr>";

                    renglones += "";
                    renglones += "<tr style='color:white;background-color:red!important;font-weight:bold;'>";
                    renglones += "<td style='text-align:left;'> Asignacion: </td>";
                    renglones += "<td style='text-align:left;'>" + last_asignacion + "</td>";
                    renglones += "<td style='text-align:left;'></td>";
                    renglones += "<td style='text-align:left;'></td>";
                    renglones += "<td style='text-align:left;center;width: 450px;'></td>";
                    renglones += "<td style='text-align:left;'></td>";
                    renglones += "<td style='text-align:left;'></td>";
                    renglones += "<td style='text-align:left;'> Total: </td>";
                    renglones += "<td style='text-align:left;'>" + "$ " + deci.format(total_final) + "</td>";
                    renglones += "<td style='text-align:left;width: 120px;'></td>";
                    renglones += "</tr>";

                    total_final = Double.parseDouble(c.getAplica().replaceAll("^\"|\"$", ""));
                    total_final_equipo = Double.parseDouble(c.getAplica().replaceAll("^\"|\"$", ""));

                    renglones += "";
                    if (c.getForma().equals("1")) {
                        renglones += "<tr style=''>";
                    } else {
                        renglones += "<tr style='font-weight:bold;'>";
                    }
                    renglones += "<td style='text-align:left;'>" + c.getDesde() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getAsignacion() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getCuenta() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getId_equipo() + "</td>";
                    renglones += "<td style='text-align:left;center;width: 450px;'>" + c.getNombre_equipo() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getVencido() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getResto() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getPago() + "</td>";
                    renglones += "<td style='text-align:left;'>" + "$ " + c.getAplica() + "</td>";
                    renglones += "<td style='text-align:left;width: 120px;'>" + c.getResto_actual() + "</td>";
                    renglones += "</tr>";
                }

                last_asignacion = c.getAsignacion();
                last_equipo_id = c.getId_equipo();
                last_equipo = c.getNombre_equipo();
            }

            renglones += "";
            renglones += "<tr style='color:black;background-color:#9e9e9e;'>";
            renglones += "<td style='text-align:left;'> Asignacion: </td>";
            renglones += "<td style='text-align:left;'>" + last_asignacion + "</td>";
            renglones += "<td style='text-align:left;'></td>";
            renglones += "<td style='text-align:left;'>" + last_equipo_id + "</td>";
            renglones += "<td style='text-align:left;center;width: 450px;'>" + last_equipo + "</td>";
            renglones += "<td style='text-align:left;'></td>";
            renglones += "<td style='text-align:left;'></td>";
            renglones += "<td style='text-align:left;'> Total: </td>";
            renglones += "<td style='text-align:left;'>" + "$ " + total_final_equipo + "</td>";
            renglones += "<td style='text-align:left;width: 120px;'></td>";
            renglones += "</tr>";

            renglones += "";
            renglones += "<tr style='color:white;background-color:red;font-weight:bold;'>";
            renglones += "<td style='text-align:left;'> Asignacion: </td>";
            renglones += "<td style='text-align:left;'>" + last_asignacion + "</td>";
            renglones += "<td style='text-align:left;'></td>";
            renglones += "<td style='text-align:left;'></td>";
            renglones += "<td style='text-align:left;center;width: 450px;'></td>";
            renglones += "<td style='text-align:left;'></td>";
            renglones += "<td style='text-align:left;'></td>";
            renglones += "<td style='text-align:left;'> Total: </td>";
            renglones += "<td style='text-align:left;'>" + "$ " + deci.format(total_final) + "</td>";
            renglones += "<td style='text-align:left;width: 120px;'></td>";
            renglones += "</tr>";

            renglones += "</tbody>"
                      + "</table>"
                      + "</div>"
                      + "</td></tr>"
                      + "</tbody>"
                      + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==============================================================================

    public static String select_pagos_diarios_gestor(int usuario_sistema, String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_pagos_diarios_gestor('" + usuario_sistema + "','" + desde + "','" + hasta + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setDesde(s.rs.getString("fecha"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setId_equipo(s.rs.getString("id_equipo"));
                c.setNombre_equipo(s.rs.getString("nombre_equipo"));
                c.setVencido(s.rs.getString("vencido"));
                c.setResto(s.rs.getString("resto"));
                c.setPago(s.rs.getString("pago"));
                c.setAplica(s.rs.getString("aplica"));
                c.setResto_actual(s.rs.getString("resto_actual"));
                pagocuenta.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;'>FECHA</th>"
                    + "<th style='text-align:center;'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>ID EQUIPO</th>"
                    + "<th style='text-align:center;width: 380px;'>NOMBRE EQUIPO</th>"
                    + "<th style='text-align:left;'>VENCIDO</th>"
                    + "<th style='text-align:left;'>RESTO ANT</th>"
                    + "<th style='text-align:left;'>PAGO</th>"
                    + "<th style='text-align:left;width: 100px;'>APLICA</th>"
                    + "<th style='text-align:left;'>RESTO ACTUAL</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Pagocuenta c : pagocuenta) {
                renglones += ""
                        + "<tr>"
                        + "<td style='text-align:center;'>" + c.getDesde() + "</td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getId_equipo() + "</td>"
                        + "<td style='text-align:left;width: 380px;'>" + c.getNombre_equipo() + "</td>"
                        + "<td style='text-align:left;'>" + c.getVencido() + "</td>"
                        + "<td style='text-align:left;'>" + c.getResto() + "</td>"
                        + "<td style='text-align:left;'>" + c.getPago() + "</td>"
                        + "<td style='text-align:left;width: 100px;'>" + "$ " + c.getAplica() + "</td>"
                        + "<td style='text-align:left;'>" + c.getResto_actual() + "</td>"
                        + "</tr>";
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
    public static String select_reporte_recuperacion_previa(int id_region, String desde) {
        try {
            DecimalFormat deci = new DecimalFormat("0.00");
            StartConn s = new StartConn();
            String sql = "call arcade_select_reporte_recuperacion_previa('" + id_region + "','" + desde + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setForma(s.rs.getString("color"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setNombre_equipo(s.rs.getString("equipo"));
                c.setVencido(s.rs.getString("gestionar"));
                c.setPunto(s.rs.getString("punto"));
                c.setCuenta(s.rs.getString("cuentas"));
                c.setRecuperado(s.rs.getString("recuperado"));
                c.setAplica(s.rs.getString("por_recuperado"));
                pagocuenta.add(c);
            }

            renglones = ""
                   + "<table class='bordered striped highlight'><thead><tr style='font-size:13px;'>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;padding-right: 0px;0px;padding-left: 0px;'>ASIGNACION</th>"
                    + "<th style='text-align:center;width:490px;padding-right: 0px;padding-left: 0px;'>EQUIPO</th>"
                    + "<th style='text-align:center;padding-right:0px;padding-left: 0px;'>ASIGNADO</th>"
                    + "<th style='text-align:right;padding-left: 0px;'>PUNTO</th>"
                    + "<th style='text-align:center;padding-right:0px;'>CUENTA</th>"
                    + "<th style='text-align:left;padding-right:0px;padding-left:0px;'>RECUPERADO</th>"
                    + "<th style='text-align:left;'>%</th>"
                    + "</tr></thead>"
                    +"<tbody>"
                    + "<tr><td colspan='7'>"
                    + "<div class='innerb_recuperacion'>"
                    + "<table>"
                    + "<tbody>";

            Double total = 0.00;
            Double total_equipo = 0.00;
            String last_asignacion = "none";
            String last_equipo = "none";

            Double asignado = 0.00;
            Double punto = 0.00;
            Integer cuentas = 0;
            Double recuperado = 0.00;

            Double asignado_total = 0.00;
            Double punto_total = 0.00;
            Integer cuentas_total = 0;
            Double recuperado_total = 0.00;

            // CUEPRO DE LA TABLA
            for (Pagocuenta c : pagocuenta) {
                asignado_total = asignado_total + Double.parseDouble(c.getVencido().replaceAll("[^\\d.]", ""));
                punto_total = punto_total + Double.parseDouble(c.getPunto().replaceAll("[^\\d.]", ""));
                cuentas_total = cuentas_total + Integer.parseInt(c.getCuenta().replaceAll("[^\\d.]", ""));
                recuperado_total = recuperado_total + Double.parseDouble(c.getRecuperado().replaceAll("[^\\d.]", ""));

                if (last_asignacion.equals(c.getAsignacion()) || last_asignacion.equals("none")) {
                    renglones += "";
                    renglones += "<tr style='" + c.getForma() + "'>";
                    renglones += "<td style='text-align:center;'>" + c.getAsignacion() + "</td>";
                    renglones += "<td style='text-align:center;width:490px;'>" + c.getNombre_equipo() + "</td>";
                    renglones += "<td style='text-align:center;'>" + c.getVencido() + "</td>";
                    renglones += "<td style='text-align:center;'>" + c.getPunto() + "</td>";
                    renglones += "<td style='text-align:center;'>" + c.getCuenta() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getRecuperado() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getAplica() + " %" + "</td>";
                    renglones += "</tr>";
                          

                    last_equipo = c.getNombre_equipo();
                    asignado = asignado + Double.parseDouble(c.getVencido().replaceAll("[^\\d.]", ""));
                    punto = punto + Double.parseDouble(c.getPunto().replaceAll("[^\\d.]", ""));
                    cuentas = cuentas + Integer.parseInt(c.getCuenta().replaceAll("[^\\d.]", ""));
                    recuperado = recuperado + Double.parseDouble(c.getRecuperado().replaceAll("[^\\d.]", ""));
                } else {
                    renglones += "";
                    renglones += "<tr style='color:black;background-color:#9e9e9e!important;'>";
                    renglones += "<td style='text-align:center;'>" + last_asignacion + "</td>";
                    renglones += "<td style='text-align:center;width:490px;'></td>";
                    renglones += "<td style='text-align:center;'>" + deci.format(asignado) + "</td>";
                    renglones += "<td style='text-align:center;'>" + deci.format(punto) + "</td>";
                    renglones += "<td style='text-align:center;'>" + cuentas + "</td>";
                    renglones += "<td style='text-align:left;'>" + deci.format(recuperado) + "</td>";
                    renglones += "<td style='text-align:left;'>" + deci.format((recuperado / asignado) * 100) + " %" + "</td>";
                    renglones += "</tr>";

                    asignado = Double.parseDouble(c.getVencido().replaceAll("[^\\d.]", ""));
                    punto = Double.parseDouble(c.getPunto().replaceAll("[^\\d.]", ""));
                    cuentas = Integer.parseInt(c.getCuenta().replaceAll("[^\\d.]", ""));
                    recuperado = Double.parseDouble(c.getRecuperado().replaceAll("[^\\d.]", ""));

                    renglones += "";
                    renglones += "<tr style='" + c.getForma() + "'>";
                    renglones += "<td style='text-align:center;'>" + c.getAsignacion() + "</td>";
                    renglones += "<td style='text-align:center;width:490px;'>" + c.getNombre_equipo() + "</td>";
                    renglones += "<td style='text-align:center;'>" + c.getVencido() + "</td>";
                    renglones += "<td style='text-align:center;'>" + c.getPunto() + "</td>";
                    renglones += "<td style='text-align:center;'>" + c.getCuenta() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getRecuperado() + "</td>";
                    renglones += "<td style='text-align:left;'>" + c.getAplica() + " %" + "</td>";
                    renglones += "</tr>";
                }

                last_asignacion = c.getAsignacion();
            }

            renglones += "";
            renglones += "<tr style='color:black;background-color:#9e9e9e!important;'>";
            renglones += "<td style='text-align:center;'>" + last_asignacion + "</td>";
            renglones += "<td style='text-align:center;width:490px;'></td>";
            renglones += "<td style='text-align:center;'>" + asignado + "</td>";
            renglones += "<td style='text-align:center;'>" + deci.format(punto) + "</td>";
            renglones += "<td style='text-align:center;'>" + cuentas + "</td>";
            renglones += "<td style='text-align:left;'>" + deci.format(recuperado) + "</td>";
            renglones += "<td style='text-align:left;'>" + deci.format((recuperado / asignado) * 100) + " %" + "</td>";
            renglones += "</tr>";

            renglones += "";
            renglones += "<tr style='color:white;background-color:red;font-weight:bold;'>";
            renglones += "<td style='text-align:center;'>Total</td>";
            renglones += "<td style='text-align:center;width:490px;'></td>";
            renglones += "<td style='text-align:center;'>" + deci.format(asignado_total) + "</td>";
            renglones += "<td style='text-align:center;'>" + deci.format(punto_total) + "</td>";
            renglones += "<td style='text-align:center;'>" + cuentas_total + "</td>";
            renglones += "<td style='text-align:left;'>" + deci.format(recuperado_total) + "</td>";
            renglones += "<td style='text-align:left;'>" + deci.format((recuperado_total / asignado_total) * 100) + " %" + "</td>";
            renglones += "</tr>"
                    + "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</td></tr>"
                    + "</tbody>"
                    + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_reporte_estadistica(int id_region) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estadisticas('" + id_region + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setForma(s.rs.getString("color"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuentas"));
                c.setDesde(s.rs.getString("fecha_inicio"));
                c.setHasta(s.rs.getString("fecha_fin"));
                c.setDias(s.rs.getString("dias"));
                c.setAsignado(s.rs.getString("asignado"));
                c.setAnticipado(s.rs.getString("anticipados"));
                c.setVencido(s.rs.getString("a_gestionar"));
                c.setRecuperado(s.rs.getString("recuperado"));
                c.setPorcentaje(s.rs.getString("porcentaje"));
                pagocuenta.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight' style='font-size: 14px!important;'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:left;width:416px'>ASIGNACION</th>"
                    + "<th style='text-align:left;width:65.75px'>CUENTAS</th>"
                    + "<th style='text-align:center;width:110.98px'>INICIO</th>"
                    + "<th style='text-align:center;width:110.98px'>DEVOLUCION</th>"
                    + "<th style='text-align:right;width:49.78px'>DIAS</th>"
                    + "<th style='text-align:center;width:131.06px'>ASIGNADO</th>"
                    + "<th style='text-align:left;width:110.9px'>ANTICIPADOS</th>"
                    + "<th style='text-align:left;width:131.06px'>GESTIONAR</th>"
                    + "<th style='text-align:left;width:119.21px'>RECUPERACION</th>"
                    + "<th style='text-align:left;width:79.75px'>%</th>"
                    + "</tr></thead>"
                    + "<tbody>"
                    + "<tr><td colspan='10'>"
                    + "<div class='innerb'>"
                    + "<table>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            for (Pagocuenta c : pagocuenta) {
                renglones += ""
                        + "<tr style='" + c.getForma() + "'>"
                        + "<td style='text-align:left;width:406px'>" + c.getAsignacion() + "</td>"
                        + "<td style='text-align:center;width:65.75px'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:left;width:110.98px'>" + c.getDesde() + "</td>"
                        + "<td style='text-align:left;width:110.98px'>" + c.getHasta() + "</td>"
                        + "<td style='text-align:right;width:49.78.98px'>" + c.getDias() + "</td>"
                        + "<td style='text-align:right;width:131.06px'>" + "$ " + c.getAsignado() + "</td>"
                        + "<td style='text-align:left;width:110.9px'>" + "$ " + c.getAnticipado() + "</td>"
                        + "<td style='text-align:left;width:131.06px'>" + "$ " + c.getVencido() + "</td>"
                        + "<td style='text-align:left;width:119.21px'>" + "$ " + c.getRecuperado() + "</td>"
                        + "<td style='text-align:left;width:79.75px'>" + c.getPorcentaje() + "%" + "</td>"
                        + "</tr>";
            }
            renglones += ""
                    + "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</td></tr>"
                    + "</tbody>"
                    + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==============================================================================

    //no le muevan, namas le puede mover Bob
    public static String select_reporte_estadistica_diaria(int id_region, String hasta) {
        try {
            DecimalFormat deci = new DecimalFormat("0.00");
            StartConn s = new StartConn();
            String sql = "call arcade_select_estadistica_diaria('" + id_region + "','" + hasta + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Pagocuenta> pagocuenta = new ArrayList<Pagocuenta>();
            while (s.rs.next()) {
                Pagocuenta c = new Pagocuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setForma(s.rs.getString("color"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuentas"));
                c.setDesde(s.rs.getString("fecha_inicio"));
                c.setHasta(s.rs.getString("fecha_fin"));
                c.setDias(s.rs.getString("dias"));
                c.setAsignado(s.rs.getString("asignado"));
                c.setAnticipado(s.rs.getString("anticipados"));
                c.setVencido(s.rs.getString("a_gestionar"));
                c.setRecuperado(s.rs.getString("recuperado"));
                c.setC_recuperacion(s.rs.getString("c_recuperacion"));
                c.setPorcentaje(s.rs.getString("porcentaje"));
                c.setC_porcentaje(s.rs.getString("c_porcentaje"));
                c.setAvance(s.rs.getString("avance"));
                c.setC_avance(s.rs.getString("c_avance"));
                c.setDiario(s.rs.getString("diario"));
                c.setCorte(s.rs.getString("corte"));
                pagocuenta.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><b><thead><tr style='background-color: #0d47a1; color:white'>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:left; width: 25%;'><b>ASIGNACION</b></th>"
                    + "<th style='text-align:left;'>CUENTAS</th>"
                    + "<th style='text-align:left;'>INICIO</th>"
                    + "<th style='text-align:center;'>DEVOLUCION</th>"
                    + "<th style='text-align:right;'>DIAS</th>"
                    + "<th style='text-align:right;'>ASIGNADO</th>"
                    + "<th style='text-align:right;'>ANTICIPADOS</th>"
                    + "<th style='text-align:right;'>GESTIONAR</th>"
                    + "<th style='text-align:right;'>RECUPERACION</th>"
                    + "<th style='text-align:right;'>%</th>"
                    + "<th style='text-align:right;'>AVANCE</th>"
                    + "<th style='text-align:right;'>DIARIO</th>"
                    + "<th style='text-align:right;'>CORTE</th>"
                    + "</tr></thead>";

            String renglones_temp = "";

            Double bob_recuperado = 0.00;
            Double bob_gestionar = 0.00;
            Double bob_datediff = 0.00;
            Double bob_porcentaje = 0.00;
            Double bob_spe = 0.00;
            Double bob_avance = 0.00;
            Double bob_diario = 0.00;
            Double bob_corte = 0.00;
            Double bob_corte_real = 0.00;
            Double bob_asignado = 0.00;
            Double bob_anticipado = 0.00;
            Double bob_vencido = 0.00;

            Double resumen_dias = 0.00;
            Double resumen_asignado = 0.00;
            Double resumen_anticipados = 0.00;
            Double resumen_recuperado = 0.00;
            Double resumen_gestionar = 0.00;
            Double resumen_porcentaje = 0.00;
            Double resumen_avance = 0.00;
            Double resumen_diario = 0.00;
            Double resumen_corte = 0.00;

            String getAsignacion_temp = "";
            String getCuenta_temp = "";
            String getDesde_temp = "";
            String getHasta_temp = "";
            String getAsignado_temp = "";
            String getAnticipado_temp = "";
            Double getDiario_temp = 0.00;
            Double getCorte_temp = 0.00;

            // CUEPRO DE LA TABLA
            for (Pagocuenta c : pagocuenta) {
                if (c.getForma().equals("resumen")) {
                    //checa que sea el resumen de uno anterior

                    if (bob_gestionar > 0) {
                        resumen_porcentaje = (resumen_recuperado / resumen_gestionar) * 100;
                        resumen_avance = (id_region == 2 ? resumen_dias * 0.50 : resumen_dias * 0.59);
                        resumen_diario = resumen_porcentaje - (getDiario_temp / resumen_gestionar) * 100;
                        resumen_corte = resumen_porcentaje - (getCorte_temp / resumen_gestionar) * 100;

                        renglones += "";
                        renglones += "<tr style='background-color: #757575; color: #FFF;'>";
                        renglones += "<td style='text-align:left;'>" + getAsignacion_temp + "</td>";
                        renglones += "<td style='text-align:center;'>" + getCuenta_temp + "</td>";
                        renglones += "<td style='text-align:left;'>" + getDesde_temp + "</td>";
                        renglones += "<td style='text-align:left;'>" + getHasta_temp + "</td>";
                        renglones += "<td style='text-align:right;'>" + resumen_dias + "</td>";
                        renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_asignado) + "</td>";
                        renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_anticipados) + "</td>";
                        renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_gestionar) + "</td>";
                        renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_recuperado) + "</td>";
                        renglones += "<td style='text-align:right; background:;'>" + deci.format(resumen_porcentaje) + "%" + "</td>";
                        renglones += "<td style='text-align:right;background:" + c.getC_avance() + "'>" + deci.format(resumen_avance) + "%" + "</td>";
                        renglones += "<td style='text-align:right;'>" + deci.format(resumen_diario) + "%" + "</td>";
                        renglones += "<td style='text-align:right;'>" + deci.format(resumen_corte) + "%" + "</td>";
                        renglones += "</tr>";

                        renglones = renglones + renglones_temp;
                    }

                    getAsignacion_temp = c.getAsignacion();
                    getCuenta_temp = c.getCuenta();
                    getDesde_temp = c.getDesde();
                    getHasta_temp = c.getHasta();

                    getDiario_temp = 0.00;
                    if (c.getDiario() != null && c.getDiario() != "") {
                        getDiario_temp = Double.parseDouble(c.getDiario().replaceAll("^\"|\"$", ""));
                    }

                    getCorte_temp = 0.00;
                    if (c.getCorte() != null && c.getCorte() != "") {
                        getCorte_temp = Double.parseDouble(c.getCorte().replaceAll("^\"|\"$", ""));
                    }

                    resumen_dias = 0.00;
                    if (c.getDias() != null && c.getDias() != "") {
                        resumen_dias = Double.parseDouble(c.getDias().replaceAll("^\"|\"$", ""));
                    }

                    resumen_asignado = 0.00;
                    resumen_anticipados = 0.00;
                    resumen_recuperado = 0.00;
                    resumen_gestionar = 0.00;

                    renglones_temp = "";
                } else {
                    bob_recuperado = 0.00;
                    if (c.getRecuperado() != null && c.getRecuperado() != "") {
                        bob_recuperado = Double.parseDouble(c.getRecuperado().replaceAll("^\"|\"$", ""));
                        resumen_recuperado = resumen_recuperado + bob_recuperado;
                    }

                    bob_gestionar = 1.00;
                    if (c.getVencido() != null && c.getVencido() != "") {
                        bob_gestionar = Double.parseDouble(c.getVencido().replaceAll("^\"|\"$", ""));
                        resumen_gestionar = resumen_gestionar + bob_gestionar;
                    }

                    bob_datediff = 1.00;
                    if (c.getAvance() != null && c.getAvance() != "") {
                        bob_datediff = Double.parseDouble(c.getAvance().replaceAll("^\"|\"$", ""));
                    }

                    bob_spe = 0.00;
                    if (c.getDiario() != null && c.getDiario() != "") {
                        bob_spe = Double.parseDouble(c.getDiario().replaceAll("^\"|\"$", ""));
                    }

                    bob_corte = 0.00;
                    if (c.getCorte() != null && c.getCorte() != "") {
                        bob_corte = Double.parseDouble(c.getCorte().replaceAll("^\"|\"$", ""));
                    }
                    bob_asignado = 0.00;
                    if (c.getAsignado() != null && c.getAsignado() != "") {
                        bob_asignado = bob_asignado + Double.parseDouble(c.getAsignado().replaceAll("^\"|\"$", ""));
                    }
                    bob_anticipado = 0.00;
                    if (c.getAnticipado() != null && c.getAnticipado() != "") {
                        bob_anticipado = bob_anticipado + Double.parseDouble(c.getAnticipado().replaceAll("^\"|\"$", ""));
                    }
                    bob_vencido = 0.00;
                    if (c.getVencido() != null && c.getVencido() != "") {
                        bob_vencido = bob_vencido + Double.parseDouble(c.getVencido().replaceAll("^\"|\"$", ""));
                    }

                    bob_porcentaje = (bob_recuperado / bob_gestionar) * 100;
                    bob_avance = (bob_porcentaje - bob_datediff);
                    bob_diario = bob_porcentaje - ((bob_spe / bob_gestionar) * 100);

                    if (c.getAsignado() != null && c.getAsignado() != "") {
                        resumen_asignado = resumen_asignado + Double.parseDouble(c.getAsignado().replaceAll("^\"|\"$", ""));
                    }

                    if (c.getAnticipado() != null && c.getAnticipado() != "") {
                        resumen_anticipados = resumen_anticipados + Double.parseDouble(c.getAnticipado().replaceAll("^\"|\"$", ""));
                    }

                    if (bob_diario < 0.01) {
                        bob_diario = 0.00;
                    }

                    bob_corte_real = (bob_recuperado / bob_gestionar) * 100 - (bob_corte / bob_gestionar) * 100;

                    renglones_temp += "";
                    renglones_temp += "<tr style='" + c.getForma() + "'>";
                    renglones_temp += "<td style='text-align:left;'>" + c.getAsignacion() + "</td>";
                    renglones_temp += "<td style='text-align:center;'>" + c.getCuenta() + "</td>";
                    renglones_temp += "<td style='text-align:left;'>" + c.getDesde() + "</td>";
                    renglones_temp += "<td style='text-align:left;'></td>";
                    renglones_temp += "<td style='text-align:right;'>" + c.getDias() + "</td>";
                    renglones_temp += "<td style='text-align:right;'>" + "$ " + deci.format(bob_asignado) + "</td>";
                    renglones_temp += "<td style='text-align:right;'>" + "$ " + deci.format(bob_anticipado) + "</td>";
                    renglones_temp += "<td style='text-align:right;'>" + "$ " + deci.format(bob_vencido) + "</td>";
                    renglones_temp += "<td style='text-align:right;background:" + c.getC_recuperacion() + "'>" + "$ " + deci.format(bob_recuperado) + "</td>";
                    renglones_temp += "<td style='text-align:right; background:;'>" + deci.format(bob_porcentaje) + "%" + "</td>";
                    renglones_temp += "<td style='text-align:right;background:" + c.getC_avance() + "'>" + deci.format(bob_avance) + "%" + "</td>";
                    renglones_temp += "<td style='text-align:right;'>" + deci.format(bob_diario) + "%" + "</td>";
                    renglones_temp += "<td style='text-align:right;'>" + deci.format(bob_corte_real) + "%" + "</td>";
                    renglones_temp += "</tr>";

                }

            }

            if (bob_gestionar > 0) {
                resumen_porcentaje = (resumen_recuperado / resumen_gestionar) * 100;
                resumen_avance = (id_region == 2 ? resumen_dias * 0.50 : resumen_dias * 0.59);
                resumen_diario = resumen_porcentaje - (getDiario_temp / resumen_gestionar) * 100;
                resumen_corte = resumen_porcentaje - (getCorte_temp / resumen_gestionar) * 100;

                renglones += "";
                renglones += "<tr style='background-color: #757575; color: #FFF;'>";
                renglones += "<td style='text-align:left;'>" + getAsignacion_temp + "</td>";
                renglones += "<td style='text-align:center;'>" + getCuenta_temp + "</td>";
                renglones += "<td style='text-align:left;'>" + getDesde_temp + "</td>";
                renglones += "<td style='text-align:left;'>" + getHasta_temp + "</td>";
                renglones += "<td style='text-align:right;'>" + resumen_dias + "</td>";
                renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_asignado) + "</td>";
                renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_anticipados) + "</td>";
                renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_gestionar) + "</td>";
                renglones += "<td style='text-align:right;'>" + "$ " + deci.format(resumen_recuperado) + "</td>";
                renglones += "<td style='text-align:right; background:;'>" + deci.format(resumen_porcentaje) + "%" + "</td>";
                renglones += "<td style='text-align:right;background:#fb000f;'>" + deci.format(resumen_avance) + "%" + "</td>";
                renglones += "<td style='text-align:right;'>" + deci.format(resumen_diario) + "%" + "</td>";
                renglones += "<td style='text-align:right;'>" + deci.format(resumen_corte) + "%" + "</td>";
                renglones += "</tr>";

                renglones = renglones + renglones_temp;
            }
            renglones += "</b></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==============================================================================
}
