package arcade.data;

import arcade.model.Convenio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class ConvenioDao {

    //==========================================================================
    public static String select_convenio_tabla(int id_usuario, int id_cliente, int id_region, String desde, String hasta, int id_reporte) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_convenio('" + id_usuario + "', '" + id_cliente + "', '" + id_region + "', '" + desde + "', '" + hasta + "', '" + id_reporte + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio c = new Convenio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_convenio(s.rs.getInt("id_convenio"));
                c.setConvenio(s.rs.getString("convenio"));
                c.setCliente(s.rs.getString("cliente"));
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setGestor(s.rs.getString("usuario"));
                c.setFecha_gestion(s.rs.getString("fecha_gestion"));
                c.setFecha_convenio(s.rs.getString("fecha_convenio"));
                c.setPlazo(s.rs.getInt("plazo"));
                c.setPagos(s.rs.getString("pagos"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setEfectividad(s.rs.getString("efectividad"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setId_estatus(s.rs.getInt("id_estatus"));
                c.setResto(s.rs.getString("resto"));
                c.setAplica(s.rs.getString("aplica"));
                convenio.add(c);
            }

            renglones = ""
                    + "<table id='tabla_convenios'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>FOLIO</th>"
//                    + "<th style='text-align:center;'>CLIENTE</th>"
                    + "<th style='text-align:center;'>REGION</th>"
                    + "<th style='text-align:center;'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>GESTOR</th>"
                    + "<th style='text-align:center;'>IMPORTE PR</th>"
                    + "<th style='text-align:center;'>F. GESTION</th>"
                    + "<th style='text-align:center;'>PLAZO</th>"
                    + "<th style='text-align:center;'>F. PROMESA</th>"
                    + "<th style='text-align:center;'>PAGADO</th>"
                    + "<th style='text-align:center;'>F. PAGO</th>"
                    + "<th style='text-align:center;'>EFECTIVIDAD</th>"
                    + "<th style='text-align:center;'>RESTO</th>"
                    + "<th style='text-align:center;'>APLICA</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Convenio c : convenio) {
                renglones += "<tbody>"
                        + "<tr id='" + c.getId_convenio() + "' style='border:none;background:" + (c.getId_estatus() == 2 ? "#51FB43" : (c.getId_estatus() == 3 ? "#FE5D49" : "#FEDC01")) + "'>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getId_convenio() + "</td>"
//                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getCliente() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getRegion() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:left;'>" + c.getGestor() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;' class='importe_convenio'>$" + c.getConvenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getFecha_gestion() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getPlazo() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getFecha_convenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;' class='importe_pagado' >$" + c.getPagos() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getFecha_pago() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;'>" + c.getEfectividad() + "%</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;'>$" + c.getResto() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;'class='importe_aplica'>$" + c.getAplica() + "</td>"
                        + "</tr></tbody>";
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
    public static String select_convenio_agrupado_tabla(int id_usuario, int id_cliente, int id_region, String desde, String hasta, int id_reporte) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_convenio_agrupado('" + id_usuario + "', '" + id_cliente + "', '" + id_region + "', '" + desde + "', '" + hasta + "', '" + id_reporte + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio c = new Convenio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_convenio(s.rs.getInt("id_convenio"));
                c.setConvenio(s.rs.getString("convenio"));
                c.setCliente(s.rs.getString("cliente"));
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setId_gestor(s.rs.getInt("id_usuario"));
                c.setGestor(s.rs.getString("usuario"));
                c.setFecha_gestion(s.rs.getString("fecha_gestion"));
                c.setFecha_convenio(s.rs.getString("fecha_convenio"));
                c.setPlazo(s.rs.getInt("plazo"));
                c.setPagos(s.rs.getString("pagos"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setEfectividad(s.rs.getString("efectividad"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setId_estatus(s.rs.getInt("id_estatus"));
                c.setAplica(s.rs.getString("aplica"));
               

                // caprichos del fran
                c.setCuentas(s.rs.getInt("cuentas"));
                convenio.add(c);
            }

            renglones = ""
                    + "<table id='tabla_convenios'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>FOLIO</th>"
                    + "<th style='text-align:center;'>CLIENTE</th>"
                    + "<th style='text-align:center;'>REGION</th>"
                    + "<th style='text-align:center;'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>ID</th>"
                    + "<th style='text-align:center;'>GESTOR</th>"
                    + "<th style='text-align:center;'>IMPORTE PR</th>"
                    + "<th style='text-align:center;'>CUENTAS</th>"
                    + "<th style='text-align:center;' title='PROMEDIO DE PLAZO OTORGADO POR EL GESTOR'>PLAZO</th>"
                    + "<th style='text-align:center;'>F. PROMESA</th>"
                    + "<th style='text-align:center;'>PAGADO</th>"
                    + "<th style='text-align:center;'>F. PAGO</th>"
                    + "<th style='text-align:center;'>EFECT.</th>"
                    + "<th style='text-align:center;'>APLICA.</th>"
                    //                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Convenio c : convenio) {
                renglones += "<tbody>"
                        + "<tr id='" + c.getId_convenio() + "' style='border:none;background:" + (Float.parseFloat(c.getEfectividad()) >= 50.00 ? "#51FB43" : (Float.parseFloat(c.getEfectividad()) < 35.01 ? "#FE5D49" : "#FEDC01")) + "'>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getId_convenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getCliente() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getRegion() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:left;'>" + c.getId_gestor() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:left;'>" + c.getGestor() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;' class='importe_convenio'>$" + c.getConvenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getCuentas() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getPlazo() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getFecha_convenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;' class='importe_pagado'>$" + c.getPagos() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getFecha_pago() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;'>" + c.getEfectividad() + "%</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:right;'class='importe_aplica'>" + c.getAplica() + "%</td>"
                        //                        + "<td style='border: solid 1px #000 !important;background: transparent !important; cursor:pointer;text-align:center;'>" + c.getEstatus() + "</td>"
                        + "</tr></tbody>";
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
    public static String select_convenio_cuenta_tabla(String cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_convenio_cuenta('" + cuenta + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio c = new Convenio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_convenio(s.rs.getInt("id_convenio"));
                c.setConvenio(s.rs.getString("convenio"));
                c.setCliente(s.rs.getString("cliente"));
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setGestor(s.rs.getString("usuario"));
                c.setFecha_gestion(s.rs.getString("fecha_gestion"));
                c.setFecha_convenio(s.rs.getString("fecha_convenio"));
                c.setPlazo(s.rs.getInt("plazo"));
                c.setPagos(s.rs.getString("pagos"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setEfectividad(s.rs.getString("efectividad"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setId_estatus(s.rs.getInt("id_estatus"));
                convenio.add(c);
            }

            renglones = ""
                    + "<table id='tabla_convenios'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>FOLIO</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>GESTOR</th>"
                    + "<th style='text-align:center;'>IMPORTE PR</th>"
                    + "<th style='text-align:center;'>F. GESTION</th>"
                    + "<th style='text-align:center;'>PLAZO</th>"
                    + "<th style='text-align:center;'>F. PROMESA</th>"
                    + "<th style='text-align:center;'>PAGADO</th>"
                    + "<th style='text-align:center;'>F. PAGO</th>"
                    + "<th style='text-align:center;'>EFECT.</th>"
                    //                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Convenio c : convenio) {
                renglones += "<tbody>"
                        + "<tr id='" + c.getId_convenio() + "' style='border-bottom: solid 1px grey !important;background:" + (c.getId_estatus() == 2 ? "#51FB43" : (c.getId_estatus() == 3 ? "#FE5D49" : "#FEDC01")) + "'>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getId_convenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'><b>" + c.getCuenta() + "</b></td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:left;'>" + c.getGestor() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;' class='importe_convenio'>$" + c.getConvenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getFecha_gestion() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getPlazo() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getFecha_convenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;'>$" + c.getPagos() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getFecha_pago() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;'>" + c.getEfectividad() + "%</td>"
                        //                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;'>" + c.getEstatus() + "</td>"
                        + "</tr></tbody>";
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
    public static String select_convenio_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_convenio();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio e = new Convenio();
                e.setId_convenio(s.rs.getInt("id_convenio"));
                e.setConvenio(s.rs.getString("convenio"));
                convenio.add(e);
            }
            for (Convenio c : convenio) {
                renglones += "<option value='" + c.getId_convenio() + "'>" + c.getConvenio() + "</option>";
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
    public static List<Convenio> select_convenio() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_convenio();";
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio e = new Convenio();
                e.setId_convenio(s.rs.getInt("id_convenio"));
                e.setConvenio(s.rs.getString("convenio"));
                convenio.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return convenio;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_convenio(Float importe, String fecha, int id_usuario, String cuenta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_convenio('" + importe + "', '" + fecha + "', '" + id_usuario + "', '" + cuenta + "');";
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
    public static String update_convenio(int id_convenio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_convenio('" + id_convenio + "');";
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
    public static String delete_convenio(int id_convenio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_convenio('" + id_convenio + "');";
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
    public static String select_convenio_gestor_tabla(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_convenio_gestor('" + id_usuario + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio c = new Convenio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_convenio(s.rs.getInt("id_convenio"));
                c.setConvenio(s.rs.getString("convenio"));
//                c.setCliente(s.rs.getString("cliente"));
//                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setGestor(s.rs.getString("usuario"));
                c.setFecha_gestion(s.rs.getString("fecha_gestion"));
                c.setFecha_convenio(s.rs.getString("fecha"));
                c.setPlazo(s.rs.getInt("plazo"));
                c.setPagos(s.rs.getString("pagos"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setEfectividad(s.rs.getString("efectividad"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setId_estatus(s.rs.getInt("id_estatus"));
                c.setResto(s.rs.getString("resto"));
                c.setAplica(s.rs.getString("aplica"));
                convenio.add(c);
            }

            renglones = ""
                    + "<table id='tabla_convenios'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>FOLIO</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>IMPORTE PR</th>"
                    + "<th style='text-align:center;' title='RESTO AL MOMENTO DE HACER EL CONVENIO'>RESTO</th>"
                    + "<th style='text-align:center;'>F. GESTION</th>"
                    + "<th style='text-align:center;'>PLAZO</th>"
                    + "<th style='text-align:center;'>F. PROMESA</th>"
                    + "<th style='text-align:center;'>PAGADO</th>"
                    + "<th style='text-align:center;'>F. PAGO</th>"
                    + "<th style='text-align:center;'>EFECT.</th>"
                    + "<th style='text-align:center;'>APLICA</th>"
                    + "</tr></thead>";

            /// CUEPRO DE LA TABLA
            for (Convenio c : convenio) {
                renglones += "<tbody>"
                        + "<tr id='" + c.getCuenta() + "' style='border-bottom: solid 1px grey !important;background:" + (c.getId_estatus() == 2 ? "#51FB43" : (c.getId_estatus() == 3 ? "#FE5D49" : "#FEDC01")) + "'>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getId_convenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'><a href='#' class='cuenta_encontrada'><b>" + c.getCuenta() + "</b></a></td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;' class='importe_convenio'>$" + c.getConvenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;' title='RESTO AL MOMENTO DE HACER EL CONVENIO'>$" + c.getResto() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getFecha_gestion() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getPlazo() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getFecha_convenio() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;'>$" + c.getPagos() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:center;'>" + c.getFecha_pago() + "</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;'>" + c.getEfectividad() + "%</td>"
                        + "<td style='border: solid 1px #000 !important;background: transparent !important;cursor:pointer;text-align:right;'>$" + c.getAplica() + "</td>"
                        + "</tr></tbody>";
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
    public static String select_por_cobrar(int id_usuario, String fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_por_cobrar('" + id_usuario + "', '" + fecha + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio c = new Convenio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setGestor(s.rs.getString("gestor"));
                c.setDia1(s.rs.getString("dia1"));
                c.setDia2(s.rs.getString("dia2"));
                c.setDia3(s.rs.getString("dia3"));
                c.setDia4(s.rs.getString("dia4"));
                c.setDia5(s.rs.getString("dia5"));
                c.setDia6(s.rs.getString("dia6"));
                c.setDia7(s.rs.getString("dia7"));
                convenio.add(c);
            }

            // CUEPRO DE LA TABLA
            int _cons = 1;

            for (Convenio c : convenio) {

                if (_cons == 1) {
                    renglones += ""
                            + "<table id='tabla_por_cobrar'><thead>"
                            // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                            + "<tr>"
                            + "<th style='width:30%;text-align:center;'>" + c.getGestor() + "</th>"
                            + "<th style='width:10%;text-align:center;'>" + c.getDia1() + "</th>"
                            + "<th style='width:10%;text-align:center;'>" + c.getDia2() + "</th>"
                            + "<th style='width:10%;text-align:center;'>" + c.getDia3() + "</th>"
                            + "<th style='width:10%;text-align:center;'>" + c.getDia4() + "</th>"
                            + "<th style='width:10%;text-align:center;'>" + c.getDia5() + "</th>"
                            + "<th style='width:10%;text-align:center;'>" + c.getDia6() + "</th>"
                            + "<th style='width:10%;text-align:center;'>" + c.getDia7() + "</th>"
                            + "</tr>"
                            + "</thead></tr><tbody>";
                } else {
                    renglones += ""
                            + "<tr>"
                            + "<td style='text-align:left;'>" + c.getGestor() + "</td>"
                            + "<td style='text-align:center;'>" + c.getDia1() + "</td>"
                            + "<td style='text-align:center;'>" + c.getDia2() + "</td>"
                            + "<td style='text-align:right;'>" + c.getDia3() + "</td>"
                            + "<td style='text-align:center;'>" + c.getDia4() + "</td>"
                            + "<td style='text-align:center;'>" + c.getDia5() + "</td>"
                            + "<td style='text-align:right;'>" + c.getDia6() + "</td>"
                            + "<td style='text-align:right;'>" + c.getDia7() + "</td>"
                            + "</tr>";
                }

                _cons++;
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
    public static String select_reporte_gral(int id_usuario, String desde, String hasta, int id_reporte) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_reporte_convenios_gral('" + id_usuario + "', '" + desde + "', '" + hasta + "', '" + id_reporte + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Convenio> convenio = new ArrayList<Convenio>();
            while (s.rs.next()) {
                Convenio c = new Convenio();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region")); // REGION
                c.setImporte(s.rs.getString("importe")); // IMPORTE
                c.setPorcentaje(s.rs.getString("porcentaje")); // IMPORTE
                c.setPorcentajes(s.rs.getString("porcentajes")); // IMPORTES
                c.setColor(s.rs.getString("color")); // COLOR

                convenio.add(c);
            }

            renglones = ""
                    + "<table id='tabla_convenios_gral'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;width:10%'>REGION</th>"
                    + "<th style='text-align:center;width:10%'>MONTO</th>"
                    + "<th style='text-align:left;width:70%'>PORCENTAJE DEL TOTAL</th>"
                    + "</tr></thead>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            for (Convenio c : convenio) {
                renglones += ""
                        + "<tr id='" + c.getId_convenio() + "' style='border:none;'>"
                        + "<td style='cursor:pointer;'>" + c.getRegion() + "</td>"
                        + "<td style='pointer;text-align:right;'>$" + c.getImporte() + "</td>"
                        + "<td style='cursor:pointer;text-align:right;'><div class='barra' style='width: " + c.getPorcentaje() + "%;background: " + c.getColor() + ";'>" + c.getPorcentajes() + "</div></td>"
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
}
