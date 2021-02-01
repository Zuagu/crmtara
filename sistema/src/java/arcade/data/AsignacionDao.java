package arcade.data;

import arcade.model.Asignacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class AsignacionDao {

    //==========================================================================
    public static String select_asignacion_tabla(int f_active) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignaciones('" + f_active + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_asignacion(s.rs.getInt("id_asignacion"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCliente(s.rs.getString("cliente"));
                c.setRegion(s.rs.getString("region"));
                c.setCuentas(s.rs.getInt("cuentas"));
                c.setFecha_inicio(s.rs.getString("fecha_inicio"));
                c.setFecha_fin(s.rs.getString("fecha_fin"));
                c.setDias_transcurridos(s.rs.getInt("dias_transcurridos"));
                c.setImporte_asignado(s.rs.getString("importe_asignado"));
                c.setPagos_anticipados(s.rs.getString("pagos_anticipados"));
                c.setAjustes(s.rs.getString("ajustes"));
                c.setA_gestionar(s.rs.getString("importe_a_gestionar"));
                c.setRecuperado(s.rs.getString("recuperado"));
                c.setPorcentaje(s.rs.getString("porcentaje"));
                c.setPorcentaje_debido(s.rs.getString("porcentaje_debido"));
                c.setDiferencia_porcentual(s.rs.getString("diferencia_porcentual"));
                c.setF_active(s.rs.getInt("f_active"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;width: 2%'>ID</th>"
                    + "<th style='text-align:center;width: 10%'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>CLIENTE</th>"
                    + "<th style='text-align:center;'>REGION</th>"
                    + "<th style='text-align:center;'>CUENTAS</th>"
                    + "<th style='text-align:center;'>ASIGNADA</th>"
                    + "<th style='text-align:center;'>DEVOLUCION</th>"
                    + "<th style='text-align:center;'>DIAS</th>"
                    + "<th style='text-align:center;'>ASIGNADO</th>"
                    + "<th style='text-align:center;'>ANTICIPADOS</th>"
                    + "<th style='text-align:center;'>AJUSTES</th>"
                    + "<th style='text-align:center;'>A.GESTIONAR</th>"
                    + "<th style='text-align:center;'>RECUPERADO</th>"
                    + "<th style='text-align:center;'>%</th>"
                    + "<th style='text-align:center;'>%DEBIDO</th>"
                    + "<th style='text-align:center;'>DIF.</th>"
                    + "<th style='text-align:center;'></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr id='" + c.getId_asignacion() + "'>"
                        + "<td style='text-align:center;'>" + c.getId_asignacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCliente() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRegion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuentas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_inicio() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_fin() + "</td>"
                        + "<td style='text-align:center;' title='DIAS TRANSCURRIDOS DESDE LA ASIGNACION'>" + c.getDias_transcurridos() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getImporte_asignado() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getPagos_anticipados() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getAjustes() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getA_gestionar() + "</td>"
                        + "<td style='text-align:right;'>$" + c.getRecuperado() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPorcentaje() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPorcentaje_debido() + "</td>"
                        + "<td style='text-align:right;font-weight:bold;'>" + c.getDiferencia_porcentual() + "</td>"
                        + "<td style='text-align:center;'><img class='update_asignacion' title='ACTUALIZAR VALORES ASIGNACION' src='images/" + (Float.parseFloat(c.getDiferencia_porcentual()) > 0.00 ? "i_up.png" : "i_down.png") + "'></td>"
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

    //==========================================================================
    public static String select_asignacion_referencias() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignacion_referencias();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_asignacion(s.rs.getInt("id_asignacion"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuentas(s.rs.getInt("cuentas"));
                c.setPorcentaje(s.rs.getString("porcentaje"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;width: 2%'>ID</th>"
                    + "<th style='text-align:center;width: 10%;'>ASIGNACION</th>"
                    + "<th style='text-align:center;width: 10%;'>CUENTAS</th>"
                    + "<th style='text-align:center;width:25%;'>ACTUALIZACION</th>"
                    + "<th style='text-align:center;width:2%;'></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr id='" + c.getId_asignacion() + "'>"
                        + "<td style='text-align:center;'>" + c.getId_asignacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'><b>" + c.getCuentas() + "</b></td>"
                        + "<td style='text-align:center;padding:0px;'><div class='actualiza_referencias_bg' title='DA UN CLICK PARA COMENZAR A ACTULIZAR LAS REFERENCIAS...' style='cursor:pointer;padding:0px 5px;width:" + c.getPorcentaje() + "%;height:22px;font-weight:bold;background:" + (Float.parseFloat(c.getPorcentaje()) >= 90.01 ? "#51FB43" : ((Float.parseFloat(c.getPorcentaje()) <= 30.01 ? "#FE5D49" : "#FEDC01"))) + "'>" + c.getPorcentaje() + "%</div></td>"
                        + "<td style='text-align:center;'>" + (Float.parseFloat(c.getPorcentaje()) < 99.99 ? "<img src='images/i_clock.png'>" : "<img src='images/i_tick.png'>") + "</td>"
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

    //==========================================================================
    public static String select_cuentas_referencias(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_cuentas_referencias('" + id_asignacion + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_cuenta(s.rs.getInt("id_cuenta"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setDato_original(s.rs.getString("dato_original"));
                c.setReferencia1(s.rs.getString("referencia1"));
                c.setTel_referencia1(s.rs.getString("tel_referencia1"));
                c.setReferencia2(s.rs.getString("referencia2"));
                c.setTel_referencia2(s.rs.getString("tel_referencia2"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    //                    + "<th style='text-align:center;width: 2%'>CUENTA</th>"
                    + "<th style='text-align:center;width: 20%;'>DATO ORIGINAL</th>"
                    + "<th style='text-align:center;width: 10%;'>REFERENCIA 1</th>"
                    + "<th style='text-align:center;width: 7%;'>TEL REF1</th>"
                    + "<th style='text-align:center;width: 10%;'>REFERENCIA 2</th>"
                    + "<th style='text-align:center;width: 7%;'>TEL REF2</th>"
                    + "<th style='text-align:center;width: 2%;'></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr id='" + c.getId_cuenta() + "'>"
                        //                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:center;font-size:1.4rem;'>" + c.getDato_original() + "</td>"
                        + "<td style='text-align:center;'><input class='ref1' type='text' value='" + c.getReferencia1() + "'></td>"
                        + "<td style='text-align:center;'><input class='t_ref1 entero' type='text' value='" + c.getTel_referencia1() + "'></td>"
                        + "<td style='text-align:center;'><input class='ref2' type='text' value='" + c.getReferencia2() + "'></td>"
                        + "<td style='text-align:center;'><input class='t_ref2 entero' type='text' value='" + c.getReferencia2() + "'></td>"
                        + "<td style='text-align:center;'><img class='updt_col99' src='images/i_tick.png' style='cursor:pointer;' title='LISTO'></td>"
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

    //==========================================================================
    public static String select_asignacion_region_tabla(int id_region, int f_active) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_asignacion_region_tabla('" + id_region + "', '" + f_active + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_asignacion(s.rs.getInt("id_asignacion"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCliente(s.rs.getString("cliente"));
                c.setRegion(s.rs.getString("region"));
                c.setCuentas(s.rs.getInt("cuentas"));
                c.setFecha_inicio(s.rs.getString("fecha_inicio"));
                c.setFecha_fin(s.rs.getString("fecha_fin"));
                c.setDias_transcurridos(s.rs.getInt("dias"));
                c.setImporte_asignado(s.rs.getString("importe_asignado"));
                c.setPagos_anticipados(s.rs.getString("pagos_anticipados"));
                c.setAjustes(s.rs.getString("ajustes"));
                c.setA_gestionar(s.rs.getString("a_gestionar"));
                c.setRecuperado(s.rs.getString("recuperacion"));
                c.setPorcentaje(s.rs.getString("porcentaje"));
                c.setPorcentaje_debido(s.rs.getString("debido"));
                c.setDiferencia_porcentual(s.rs.getString("diferencia_porcentual"));
                c.setF_active(s.rs.getInt("f_active"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table id='tabla_asignaciones'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;width: 2%'>ID</th>"
                    + "<th style='text-align:center;width: 7%;'>ASIGNACION</th>"
                    //                    + "<th style='text-align:center;'>CLIENTE</th>"
                    + "<th style='text-align:center;'>REGION</th>"
                    + "<th style='text-align:center;'>CUENTAS</th>"
                    + "<th style='text-align:center;'>ASIGNADA</th>"
                    + "<th style='text-align:center;'>DEVOLUCION</th>"
                    + "<th style='text-align:center;'>DIAS</th>"
                    + "<th style='text-align:center;'>ASIGNADO</th>"
                    + "<th style='text-align:center;'>ANTICIPADOS</th>"
                    + "<th style='text-align:center;'>AJUSTES</th>"
                    + "<th style='text-align:center;'>A.GESTIONAR</th>"
                    + "<th style='text-align:center;'>RECUPERADO</th>"
                    + "<th style='text-align:center;'>%</th>"
                    + "<th style='text-align:center;'>%DEBIDO</th>"
                    + "<th style='text-align:center;'>DIF.</th>"
                    + "<th style='text-align:center;'></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr id='" + c.getId_asignacion() + "'>"
                        + "<td style='text-align:center;'>" + c.getId_asignacion() + "</td>"
                        + "<td style='text-align:center;'><a href='#'>" + c.getAsignacion() + "</a></td>"
                        //                        + "<td style='text-align:center;'>" + c.getCliente() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRegion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuentas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_inicio() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_fin() + "</td>"
                        + "<td style='text-align:center;' title='DIAS TRANSCURRIDOS DESDE LA ASIGNACION'>" + c.getDias_transcurridos() + "</td>"
                        + "<td style='text-align:right;'>" + c.getImporte_asignado() + "</td>"
                        + "<td style='text-align:right;'>" + c.getPagos_anticipados() + "</td>"
                        + "<td style='text-align:right;'>" + c.getAjustes() + "</td>"
                        + "<td style='text-align:right;'>" + c.getA_gestionar() + "</td>"
                        + "<td style='text-align:right;'>" + c.getRecuperado() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPorcentaje() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPorcentaje_debido() + "</td>"
                        + "<td style='text-align:right;font-weight:bold;'>" + c.getDiferencia_porcentual() + "</td>"
                        + "<td style='text-align:center;'><img class='update_asignacion' title='ACTUALIZAR VALORES ASIGNACION' src='images/" + (Float.parseFloat(c.getDiferencia_porcentual()) > 0.00 ? "i_up.png" : "i_down.png") + "' style='cursor:pointer;'></td>"
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

    //==========================================================================
    public static String select_asignacion_region_check(String cadena_regiones) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select id_asignacion, asignacion from arcade_asignaciones where id_region in (" + cadena_regiones + ") and f_active = 1;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_asignacion(s.rs.getInt("id_asignacion"));
                c.setAsignacion(s.rs.getString("asignacion"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table id='asignacion_disp'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th><input id='check_asignacion_todos' type='checkbox' style='cursor:pointer;'></th>"
                    + "<th>ASIGNACION</th>"
                    + "</tr></tr><tbody>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr id='" + c.getId_asignacion() + "'>"
                        + "<td style='text-align:center;width:34px;'><input class='check_asignacion' type='checkbox' style='cursor:pointer;'></td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
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
    public static String select_asignacion_combo(int f_active) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignaciones('" + f_active + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setId_asignacion(s.rs.getInt("id_asignacion"));
                e.setAsignacion(s.rs.getString("asignacion"));
                e.setCliente(s.rs.getString("cliente"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getId_asignacion() + "'>" + c.getAsignacion() + " (" + c.getCliente() + ")</option>";
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
    public static String select_asignacion_chbk_combo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignacion_chbk_combo('" + id_usuario + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setAsignacion(s.rs.getString("asignacion"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getAsignacion() + "'>" + c.getAsignacion() + "</option>";
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
    public static String select_ciclos_chbk_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_ciclos_chbk_usuario('" + id_usuario + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setAsignacion(s.rs.getString("ciclo"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getAsignacion() + "'>" + c.getAsignacion() + "</option>";
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
    public static String select_estatus_chbk_usuario(int id_usuario, int ciclo) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_estatus_chbk_usuario('" + id_usuario + "', '" + ciclo + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setAsignacion(s.rs.getString("estatus"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getAsignacion() + "'>" + c.getAsignacion() + "</option>";
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
    public static String select_estatus_gestion_chbk_usuario(int id_usuario, int ciclo, String estatus_original) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_estatus_gestion_chbk_usuario('" + id_usuario + "', '" + ciclo + "', '" + estatus_original + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setAsignacion(s.rs.getString("estatus"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getAsignacion() + "'>" + c.getAsignacion() + "</option>";
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
    public static int contar_cuentas_chbk_usuario(int id_usuario, int ciclo, String estatus_original, String estatus) {
        try {
            StartConn s = new StartConn();
            int resultado = 0;
            String sql = "select contar_cuentas_chbk_usuario('" + id_usuario + "', '" + ciclo + "', '" + estatus_original + "', '" + estatus + "') as resultado;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getInt("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return 0;
        }
    }

    //==========================================================================
    public static String select_asignacion_cliente_combo(int id_cliente, int f_active) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_asignaciones_cliente('" + id_cliente + "','" + f_active + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setId_asignacion(s.rs.getInt("id_asignacion"));
                e.setAsignacion(s.rs.getString("asignacion"));
                e.setCliente(s.rs.getString("cliente"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getId_asignacion() + "'>" + c.getAsignacion() + " (" + c.getCliente() + ")</option>";
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
    public static String select_asignacion_region_combo(int id_cliente, int f_active) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_asignaciones_region('" + id_cliente + "','" + f_active + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setId_asignacion(s.rs.getInt("id_asignacion"));
                e.setAsignacion(s.rs.getString("asignacion"));
                e.setCliente(s.rs.getString("cliente"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getId_asignacion() + "'>" + c.getAsignacion() + " (" + c.getCliente() + ")</option>";
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
    public static List<Asignacion> select_asignacion() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignacion();";
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setId_asignacion(s.rs.getInt("id_asignacion"));
                e.setAsignacion(s.rs.getString("asignacion"));
                asignacion.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return asignacion;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_asignacion(int id_usuario, String asignacion, int id_sucursal, int id_cliente, int id_region, String fecha_inicio, String fecha_fin, int dias_anticipados, float meta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_asignacion("
                    + "'" + id_usuario + "',"
                    + "'" + asignacion + "',"
                    + "'" + id_sucursal + "',"
                    + "'" + id_cliente + "',"
                    + "'" + id_region + "',"
                    + "'" + fecha_inicio + "',"
                    + "'" + fecha_fin + "',"
                    + "'" + dias_anticipados + "',"
                    + "'" + meta + "'"
                    + ");";
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
    public static String update_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "Importes de asignacion con id " + id_asignacion + " actualizados correctamente.";
            String sql = "call job_actualizar_importes_asignacion2('" + id_asignacion + "');";
            s.rs = s.st.executeQuery(sql);
//            s.st.executeUpdate(sql);
            System.out.println(sql);
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
    public static String delete_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_asignacion('" + id_asignacion + "');";
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
    public static String match_datos_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call match_datos_asignacion('" + id_asignacion + "');";
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
    public static String select_datos_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_asignacion('" + id_asignacion + "');";
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
    public static String select_colas() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_colas();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setAsignacion(s.rs.getString("id_cola"));
                e.setCalle(s.rs.getString("cola"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getAsignacion() + "'>" + c.getAsignacion() + " : " + c.getCalle() + "</option>";
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
    public static String reasignar(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_reasignar('" + id_asignacion + "');";

            String importar = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\reasignacion.csv'\n"
                    + "INTO TABLE arcade_basegeneral_reasignar -- 2 columnas\n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "IGNORE 1 ROWS\n"
                    + "(\n"
                    + "@col1,@col2)\n"
                    + "set\n"
                    + "cuenta=@col1,id_equipo=@col2;\n";

            s.st.executeUpdate(importar);

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
    public static String updt_col99(int id_cuenta, String ref1, String telr1, String ref2, String telr2) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_updt_col99('" + id_cuenta + "', '" + ref1 + "', '" + telr1 + "', '" + ref2 + "', '" + telr2 + "');";

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
    public static String insert_basechbk() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_resultado_carga_basechbk();";
            String truncar_cuentas = "truncate arcade_basegeneral_chbk;";

            String importar = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\base_chbk.csv'\n"
                    + "INTO TABLE arcade_basegeneral_chbk \n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "IGNORE 1 ROWS\n"
                    + "(\n"
                    + "@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10)\n"
                    + "set\n"
                    + "cuenta=@col1, id_region=@col2, id_supervisor=@col3, id_usuario=@col4,"
                    + "asignacion=@col5, fecha_reactivacion=fecha_sistema(@col6), fecha_vencimiento=fecha_sistema(@col7),"
                    + "estatus=@col9, id_codigo=4, ciclo=@col8, saldo=@col10, f_active=1, estatus_original=@col9,"
                    + "f_automatico = now();\n";

            s.st.executeUpdate(truncar_cuentas);
            s.st.executeUpdate(importar);

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
    public static String select_ladas_check(int id_asignacion, String cadena_asignaciones, String tiene_cr, String cadena_estatus) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(substr(columna3,1,3)) as lada from arcade_basegeneral where id_region = " + id_asignacion + " and id_asignacion in (" + cadena_asignaciones + ") and\n"
                    + "tiene_cr = " + tiene_cr + " "
                    //                    + "and ultimo_estatus_cuenta in (" + cadena_estatus + ")"
                    + "order by columna3 asc;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setLada(s.rs.getString("lada"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table id='ladas_disponibles'>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr id='" + c.getLada() + "'>"
                        + "<td style='text-align:center;width:34px;'><input class='agregado_ladas' type='checkbox'></td>"
                        + "<td style='text-align:center;'>" + c.getLada() + "</td>"
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

    //==========================================================================
    public static String select_estatus_cuenta_check(int id_region, String cadena_asignaciones, String tiene_cr, String cadena_ladas) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(ultimo_estatus_cuenta) as id_estatus, nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus from arcade_basegeneral where id_region = " + id_region + " and id_asignacion in (" + cadena_asignaciones + ") and\n"
                    + "tiene_cr = " + tiene_cr + " and substr(columna3, 1, 3) in (" + cadena_ladas + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setUltimo_estatus_cuenta(s.rs.getString("id_estatus"));
                c.setNombre(s.rs.getString("estatus"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table id='estatus_disponibles'>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr id='" + c.getUltimo_estatus_cuenta() + "'>"
                        + "<td style='text-align:center;width:34px;'><input class='agregado_estatus' type='checkbox'></td>"
                        + "<td style='text-align:center;'>" + c.getNombre() + "</td>"
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

    //==========================================================================
    public static String select_cuentas_sms_blaster(int id_region, String cadena_asignaciones, String tiene_cr, String cadena_ladas, String cadena_estatus, int importe, String orden) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select columna1 as cuenta, columna2 as titular, columna3 as expediente, nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus, nombre_estatus_llamada(ultimo_estatus_llamada) as codigo, nombre_asignacion(id_asignacion) as asignacion, resto\n"
                    + "from arcade_basegeneral\n"
                    + "where f_active =  1 and resto >= " + importe + "\n"
                    + "and id_region = " + id_region + "\n"
                    + "and tiene_cr = " + tiene_cr + "\n"
                    + "and id_asignacion in (" + cadena_asignaciones + ")\n"
                    + "and substr(columna3, 1, 3) in (" + cadena_ladas + ")\n"
                    + "and ultimo_estatus_cuenta in (" + cadena_estatus + ")\n"
                    + "order by resto " + orden + ";";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setResto(s.rs.getString("resto"));
                c.setExpediente(s.rs.getString("expediente"));
                c.setUltimo_estatus_cuenta(s.rs.getString("estatus"));
                c.setUltimo_estatus_llamada(s.rs.getString("codigo"));
                c.setNombre(s.rs.getString("titular"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table id='cuentas'>"
                    + "<thead>"
                    + "<tr>"
                    + "<th></th>"
                    + "<th style='text-align:center;'>asignacion</th>"
                    + "<th style='text-align:center;'>cuenta</th>"
                    + "<th style='text-align:center;'>marcando</th>"
                    + "<th style='text-align:center;'>nombre</th>"
                    + "<th style='text-align:center;'>resto</th>"
                    + "<th style='text-align:center;'>estatus</th>"
                    + "<th style='text-align:center;'>codigo</th>"
                    + "<th style='text-align:center;'>expediente</th>"
                    + "<th style='text-align:center;'>tipo_tel</th>"
                    + "</tr>"
                    + "</thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<tr>"
                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuenta() + "</td>"
                        + "<td style='text-align:left;'>" + c.getNombre() + "</td>"
                        + "<td style='text-align:right;'>" + c.getResto() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_cuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_llamada() + "</td>"
                        + "<td style='text-align:center;'>" + c.getExpediente() + "</td>"
                        + "<td style='text-align:right;'>" + c.getResto() + "</td>"
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

    //==========================================================================ç
    public static String select_asignacion_region_combo_materialize(int id_cliente, int f_active) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_asignaciones_cliente('" + id_cliente + "','" + f_active + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion e = new Asignacion();
                e.setId_asignacion(s.rs.getInt("id_asignacion"));
                e.setAsignacion(s.rs.getString("asignacion"));
                e.setCliente(s.rs.getString("cliente"));
                asignacion.add(e);
            }
            for (Asignacion c : asignacion) {
                renglones += "<option value='" + c.getId_asignacion() + "'>" + c.getAsignacion() + " (" + c.getCliente() + ")</option>";
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
    public static String select_burndown_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "call arcade_select_burndown_asignacion('" + id_asignacion + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setImporte_asignado_x(s.rs.getFloat("importe_asignado"));
                c.setRecuperado_x(s.rs.getFloat("recuperado"));
                asignacion.add(c);
            }
            resultado = "";
            float _acumulado = 0;
            for (Asignacion c : asignacion) {
                _acumulado = _acumulado + c.getRecuperado_x();
                resultado += (c.getImporte_asignado_x() - _acumulado) + ", ";
            }
            resultado = resultado.substring(0, resultado.length() - 2);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String nombre_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_titulo_grafica('" + id_asignacion + "');";

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
    public static String fechas_pago_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call fechas_pago_asignacion('" + id_asignacion + "');";

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
    public static String recuperado_diario(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_recuperado_diario_asignacion('" + id_asignacion + "');";

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
    public static String detalles_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_detalles_asignacion('" + id_asignacion + "');";

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
    public static String select_asignacion_region_check_materialize(String cadena_regiones) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select id_asignacion, nombre_asignacion(id_asignacion) as asignacion from arcade_basegeneral where id_region in (" + cadena_regiones + ") and f_active = 1 and dias < 40 group by id_asignacion;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_asignacion(s.rs.getInt("id_asignacion"));
                c.setAsignacion(s.rs.getString("asignacion"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<input type='checkbox' id='check_asignacion_todos'/>"
                    + "<label for='check_asignacion_todos'><b>ASIGNACIÓN</b></label>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getId_asignacion() + "' class='check_asignacion' />"
                        + "<label for='" + c.getId_asignacion() + "'>" + c.getAsignacion() + "</label>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
	 public static String select_ciudades_asignaciones_check(String cadena_asignaciones, int region ) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(columna32) as ciudad from arcade_basegeneral where id_asignacion in ('" + cadena_asignaciones + "') "+ (region == 1 ? "and columna35='N L'":"" ) +" and f_active = 1  order by columna32 ;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setCiudad(s.rs.getString("ciudad"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<input type='checkbox' id='check_ciudad_todos'/>"
                    + "<label for='check_ciudad_todos'><b>CIUDAD</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getCiudad() + "' class='check_ciudad'/>"
                        + "<label for='" + c.getCiudad() + "'>" + c.getCiudad() + "</label><br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //========================================================================== 
    public static String select_colonias_ciudades_check(String id_asigancion, String cadena_ciudades, String cadena_codigos) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(columna33) as colonia from arcade_basegeneral where id_asignacion in (" + id_asigancion + ") and columna32 in (" + cadena_ciudades + ") and columna36 in (" + cadena_codigos + ") order by columna33 ;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setColonia(s.rs.getString("colonia"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<input type='checkbox' id='check_colonia_todos'/>"
                    + "<label for='check_colonia_todos'><b>COLONIA</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                //EN ESTA PARTE DEL CODIGO AL ID_COLONIAS Y EN LA PROPIEDAD FOR DEL LABEL SE LE AGRGO EL PREFIJO DE "_C"
                renglones += ""
                        + "<input type='checkbox' id='" + c.getColonia() + "_C' class='check_colonia'/>"
                        + "<label for='" + c.getColonia() + "_C'>" + c.getColonia() + "</label><br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //========================================================================== 
    public static String select_codigo_postal_colonias_check(String cadena_asignaciones, String cadena_ciudades) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(columna36) as cp from arcade_basegeneral where id_asignacion in (" + cadena_asignaciones + ") and columna32 in ( " + cadena_ciudades + " ) order by columna36 ;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setCp(s.rs.getString("cp"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<input type='checkbox' id='check_codigo_todos'/>"
                    + "<label for='check_codigo_todos'><b>C.P.</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getCp() + "' class='check_codigo'/>"
                        + "<label for='" + c.getCp() + "'>" + c.getCp() + "</label><br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //========================================================================== 
    public static String select_status_codigo_postal_check(String cadena_asignaciones, String cadena_colonias, String cadena_codigos) {
        try {
            StartConn s = new StartConn();
            String renglones;
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //sE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            System.out.println("CADENA QUE SE MANDA A LA BASE DE DATOS: "+n_cadena_colonias);
            
            
            
            String sql ="select distinct \n"
                +"  ultimo_estatus_cuenta as id_status, \n"
                +"  nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus \n"
                +"from arcade_basegeneral where \n"
                +"  id_asignacion in ("+cadena_asignaciones+") \n"
                +"  and  columna33 in ("+n_cadena_colonias+") \n"
                +"  and columna36 in ("+cadena_codigos+") \n"
                +"order by ultimo_estatus_cuenta;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estatus_llamada(s.rs.getInt("id_status"));
                c.setUltimo_estatus_cuenta(s.rs.getString("estatus"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<input type='checkbox' id='check_lada_todos'/>"
                    + "<label for='check_lada_todos'><b>ESTATUS</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<input type='checkbox' id='" +c.getId_estatus_llamada()+ "' class='check_lada'/>"
                        + "<label for='" + c.getId_estatus_llamada() + "'>" + c.getUltimo_estatus_cuenta() + "</label><br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_visitas(int id_region, String cadena_asignaciones, String cadena_ciudades, String cadena_colonias, String cadena_codigos, String cadena_ladas, int resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID de cada check_box NO SE REPIRIERA EN EL FRONT END 
            //sE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String sql = "select \n"
                    + "nombre_region(a.id_region) as id_region, \n"
                    + "nombre_asignacion(a.id_asignacion) as id_asignacion, \n"
                    + "a.columna1 as cuenta, \n"
                    + "a.columna32 as ciudades, \n"
                    + "a.columna33 as colonia, \n"
                    + "a.columna36 as cp , \n"
                    + "nombre_estatus_cuenta(a.ultimo_estatus_cuenta) as status, \n"
                    + "format(a.resto, 2) as resto \n"
                    + "from arcade_call.arcade_basegeneral a \n"
                    + "left join arcade_call.arcade_visitas_cuentas b \n"
                    + "on a.columna1 = b.cuenta \n"
                    + "where a.id_region = " + id_region + " \n"
                    + "and b.cuenta is null \n"
                    + "and a.f_active = 1 \n"
                    + "and a.id_asignacion in (" + cadena_asignaciones + ") \n"
                    + "and a.columna32 in (" + cadena_ciudades + ") \n"
                    + "and a.columna33 in (" + n_cadena_colonias + ") \n"
                    + "and a.columna36 in (" + cadena_codigos + ") \n"
                    + "and a.ultimo_estatus_cuenta in (" + cadena_ladas + ") \n"
                    + "and a.resto >= " + resto + "; \n";
            String renglones;
            int filas = 0;
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();

                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("id_region"));
                c.setAsignacion(s.rs.getString("id_asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setLada(s.rs.getString("status"));
                c.setResto(s.rs.getString("resto"));
                c.setCiudad(s.rs.getString("ciudades"));
                c.setColonia(s.rs.getString("colonia"));
                c.setCp(s.rs.getString("cp"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table id='lista_user' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;border:solid 1px;'>IMPRESION</th>"
                    + "<th style='text-align:center;border:solid 1px;'>NO#</th>"
                    + "<th style='text-align:center;border:solid 1px;'>ASIGNACION</th>"
                    + "<th style='text-align:center;border:solid 1px;'>CUENTA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>STATUS</th>"
                    + "<th style='text-align:center;border:solid 1px;'>COLONIA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>SALDO ACT</th>"
                    + "<th style='text-align:center;border:solid 1px;'>FECHA VISITA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>CODIGO</th>"
                    + "<th style='text-align:center;border:solid 1px;'>PLANO</th>"
                    + "<th style='text-align:center;border:solid 1px;'>RESULTADO</th>"
                    + "<th style='text-align:center;border:solid 1px;'>TELEFONO/ FECHA PROMESA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>COMENTARIOS</th>"
                    + "</tr><tbody>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                filas ++;
                renglones += ""
                        + "<tr class='cuenta' id='" + c.getCuenta() + "'>"
                        + "<td style='text-align:center;border:solid 1px;'> <a href='#'><i id='print_carteo' class='material-icons print_carteo'>print</i></a> </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + filas + ".-ACUSE </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getAsignacion() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getCuenta() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getLada() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getColonia() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + "$ " + c.getResto() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
                        + "<td style='text-align:center;border:solid 1px;'>1|2|3</td>"
                        + "<td style='text-align:center;border:solid 1px;'></td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
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
    public static String select_datos_carteo_tabla(int id_region, int id_asignacion, String cadena_ciudades, String cadena_colonias, String cadena_codigos) {  
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID de cada check_box NO SE REPIRIERA EN EL FRONT END 
            //sE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String sql = "select \n"
                    + "	nombre_region(a.id_region) as region, \n"
                    + "	nombre_asignacion(a.id_asignacion) as asignacion, \n"
                    + "	a.columna1 as cuenta, \n"
                    + "	a.columna32 as ciudad, \n"
                    + "	a.columna33 as colonia, \n"
                    + "	a.columna36 as cp, \n"
                    + "	a.resto \n"
                    + "from arcade_call.arcade_basegeneral a \n"
                    + "	left join arcade_call.arcade_carteos_cuentas b\n"
                    + "    on a.columna1 = b.cuenta\n"
                    + "where b.cuenta is null\n"
                    + "	AND a.f_active = 1 \n"
                    + "	and a.id_region = "+id_region+" \n"
                    + "	and a.id_asignacion in ("+id_asignacion+") \n"
                    + "	and a.columna32 in ("+cadena_ciudades+") \n"
                    + "	and a.columna33 in ("+n_cadena_colonias+") \n"
                    + "	and a.columna36 in ("+cadena_codigos+"); \n";
            String renglones;
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> asignacion = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion c = new Asignacion();

                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setCiudad(s.rs.getString("ciudad"));
                c.setColonia(s.rs.getString("colonia"));
                c.setCp(s.rs.getString("cp"));
                c.setResto(s.rs.getString("resto"));
                asignacion.add(c);
            }

            renglones = ""
                    + "<table id='lista_user' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;'>ID REGION</th>"
                    + "<th style='text-align:left;'>ASIGNACION</th>"
                    + "<th style='text-align:left;'>CUENTA</th>"
                    + "<th style='text-align:left;'>CIUDAD</th>"
                    + "<th style='text-align:left;'>COLONIA</th>"
                    + "<th style='text-align:center;'>C.P.</th>"
                    + "<th style='text-align:center;'>RESTO</th>"
                    + "</tr><tbody>";

            // CUEPRO DE LA TABLA
            for (Asignacion c : asignacion) {
                renglones += ""
                        + "<td style='text-align:center;'> " + c.getRegion() + " </td>"
                        + "<td style='text-align:left;'> " + c.getAsignacion() + " </td>"
                        + "<td> " + c.getCuenta() + " </td>"
                        + "<td> " + c.getCiudad() + " </td>"
                        + "<td> " + c.getColonia() + " </td>"
                        + "<td style='text-align:center;'> " + c.getCp() + " </td>"
                        + "<td style='text-align:center;'> " + c.getResto() + " </td>"
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
}
