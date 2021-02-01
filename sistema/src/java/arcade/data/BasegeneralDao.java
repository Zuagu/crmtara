package arcade.data;

import arcade.model.Asignacion;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class BasegeneralDao {

    //==========================================================================
    public static String select_basegeneral_tabla(int id_region) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_basegeneral('" + id_region + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> basegeneral = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion b = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                b.setRegion(s.rs.getString("region"));
                b.setAsignacion(s.rs.getString("asignacion"));
                b.setCuenta(s.rs.getString("cuenta"));
                b.setId_equipo(s.rs.getInt("id_equipo"));
                b.setEquipo(s.rs.getString("equipo"));
                b.setUltima_gestion(s.rs.getString("ultima_gestion"));
                b.setUltimo_estatus_cuenta(s.rs.getString("estatus"));
                b.setUltimo_estatus_llamada(s.rs.getString("codigo"));
                b.setImporte_asignado(s.rs.getString("importe_asignado"));
                b.setPenalizacion(s.rs.getString("penalizacion"));
                b.setCancelacion(s.rs.getString("cancelacion"));
                b.setAjustes(s.rs.getString("ajustes"));
                b.setPagos_anticipados(s.rs.getString("pagos_anticipados"));
                b.setPagos(s.rs.getString("pagos"));
                b.setA_gestionar(s.rs.getString("a_gestionar"));
                b.setResto(s.rs.getString("resto"));
                b.setPorcentaje(s.rs.getString("porcentaje"));
                b.setLada(s.rs.getString("lada"));
                b.setNombre(s.rs.getString("nombre"));
                b.setExpediente(s.rs.getString("expediente"));
                b.setCiudad(s.rs.getString("ciudad"));
                b.setColonia(s.rs.getString("colonia"));
                b.setCalle(s.rs.getString("calle"));
                b.setNumero(s.rs.getString("numero"));
                b.setCuentas_multiples(s.rs.getString("cuentas_multiples"));
                b.setImporte_cuentas_multiples(s.rs.getString("importe_cuentas_multiples"));
                b.setTiene_cr(s.rs.getString("tiene_cr"));

                b.setFecha_inicio(s.rs.getString("fecha_inicio"));
                b.setFecha_fin(s.rs.getString("fecha_fin"));
                b.setDias_transcurridos(s.rs.getInt("dias"));

                b.setTel1(s.rs.getString("tel1"));
                b.setTel2(s.rs.getString("tel2"));
                b.setTel3(s.rs.getString("tel3"));
                b.setCorreo(s.rs.getString("correo"));
                b.setEstado(s.rs.getString("estado"));
                b.setCp(s.rs.getString("cp"));

                basegeneral.add(b);
            }

            renglones = "REGION,"
                    + "ASIGNACION,"
                    + "CUENTA,"
                    + "ID,"
                    + "EQUIPO,"
                    + "ULTIMA GESTION,"
                    + "ESTATUS,"
                    + "CODIGO,"
                    + "ASIGNADO,"
                    + "PENALIZACION,"
                    + "AJUSTES,"
                    + "CANCELACION,"
                    + "ANTICIPADO,"
                    + "PAGADO,"
                    + "GESTIONAR,"
                    + "RESTO,"
                    + "PORCENTAJE,"
                    + "LADA,"
                    + "NOMBRE,"
                    + "T1," // nuevas columnas...
                    + "T2," // nuevas columnas...
                    + "T3," // nuevas columnas...
                    + "CORREO," // nuevas columnas...
                    + "EXPEDIENTE,"
                    + "CIUDAD,"
                    + "ESTADO," // nuevas columnas...
                    + "COLONIA,"
                    + "CALLE,"
                    + "NUMERO,"
                    + "CP," // nuevas columnas...
                    + "CUENTAS,"
                    + "TOTAL,"
                    + "TIENE CR,"
                    + "DIAS,"
                    + "INICIO,"
                    + "FIN<br>";

            // CUEPRO DE LA TABLA
            for (Asignacion b : basegeneral) {
                renglones += ""
                        + "" + b.getRegion() + ","
                        + "" + b.getAsignacion() + ","
                        + "" + b.getCuenta() + ","
                        + "" + b.getId_equipo() + ","
                        + "" + b.getEquipo() + ","
                        + "" + b.getUltima_gestion() + ","
                        + "" + b.getUltimo_estatus_cuenta() + ","
                        + "" + b.getUltimo_estatus_llamada() + ","
                        + "" + b.getImporte_asignado() + ","
                        + "" + b.getPenalizacion() + ","
                        + "" + b.getAjustes() + ","
                        + "" + b.getCancelacion() + ","
                        + "" + b.getPagos_anticipados() + ","
                        + "" + b.getPagos() + ","
                        + "" + b.getA_gestionar() + ","
                        + "" + b.getResto() + ","
                        + "" + b.getPorcentaje() + ","
                        + "" + b.getLada() + ","
                        + "" + b.getNombre() + ","
                        + "" + b.getTel1() + ","
                        + "" + b.getTel2() + ","
                        + "" + b.getTel3() + ","
                        + "" + b.getCorreo() + ","
                        + "" + b.getExpediente() + ","
                        + "" + b.getCiudad() + ","
                        + "" + b.getEstado() + ","
                        + "" + b.getColonia() + ","
                        + "" + b.getCalle() + ","
                        + "" + b.getNumero() + ","
                        + "" + b.getCp() + ","
                        + "" + b.getCuentas_multiples() + ","
                        + "" + b.getImporte_cuentas_multiples() + ","
                        + "" + b.getTiene_cr() + ","
                        + "" + b.getDias_transcurridos() + ","
                        + "" + b.getFecha_inicio() + ","
                        + "" + b.getFecha_fin() + "<br>";
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
    public static String select_basegeneral_csv(int id_region) throws IOException {

        String filename = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\sistema\\excel\\base-general.csv";
        System.out.println("FILE NAME: " + filename);

        try {
            String resultado;
            FileWriter fw = new FileWriter(filename);
            StartConn s = new StartConn();
            String sql = "call arcade_select_basegeneral('" + id_region + "');";
            System.out.println(sql);

            //PONERMOS LOS ENCABEZADOS
            fw.append("REGION");
            fw.append(',');
            fw.append("ASIGNACION");
            fw.append(',');
            fw.append("CUENTA");
            fw.append(',');
            fw.append("ID EQUIPO");
            fw.append(',');
            fw.append("EQUIPO");
            fw.append(',');
            fw.append("ULTIMA GESTION");
            fw.append(',');
            fw.append("ESTATUS");
            fw.append(',');
            fw.append("CODIGO");
            fw.append(',');
            fw.append("IMPORTE ASIGNADO");
            fw.append(',');
            fw.append("PENALIZACION");
            fw.append(',');
            
            fw.append("FINEQ");
            fw.append(',');
            
            fw.append("AJUSTES");
            fw.append(',');
            fw.append("CANCELACION");
            fw.append(',');
            fw.append("PAGOS ANTICIPADOS");
            fw.append(',');
            fw.append("PAGOS");
            fw.append(',');
            fw.append("A GESTIONAR");
            fw.append(',');
            fw.append("RESTO");
            fw.append(',');
            fw.append("PORCENTAJE");
            fw.append(',');
            fw.append("LADA");
            fw.append(',');
            fw.append("NOMBRE");
            fw.append(',');
            fw.append("TEL_1");
            fw.append(',');
            fw.append("TEL_2");
            fw.append(',');
            fw.append("TEL_3");
            fw.append(',');
            fw.append("CORREO");
            fw.append(',');
            fw.append("EXPEDIENTE");
            fw.append(',');
            fw.append("CIUDAD");
            fw.append(',');
            fw.append("ESTADO");
            fw.append(',');
            fw.append("COLONIA");
            fw.append(',');
            fw.append("CALLE");
            fw.append(',');
            fw.append("NUMERO");
            fw.append(',');
            fw.append("CP");
            fw.append(',');
            fw.append("CUENTAS MULTIPLES");
            fw.append(',');
            fw.append("TOTAL MULTIPLES");
            fw.append(',');
            fw.append("TIENE CR");
            fw.append(',');
            fw.append("DIAS");
            fw.append(',');
            fw.append("REFERENCIA 1");
            fw.append(',');
            fw.append("TEL REF 1");
            fw.append(',');
            fw.append("TT_R1");
            fw.append(',');
            fw.append("REFERENCIA 2");
            fw.append(',');
            fw.append("TEL REF 2");
            fw.append(',');
            fw.append("TT_R2");
            fw.append(',');
            fw.append("REFERENCIA 3");
            fw.append(',');
            fw.append("TEL REF 3");
            fw.append(',');
            fw.append("TT_R3");
            fw.append(',');
            fw.append("REFERENCIA 4");
            fw.append(',');
            fw.append("TEL REF 4");
            fw.append(',');
            fw.append("TT_R4");
            fw.append(',');
            fw.append("MOTIVO SUSPENSION");
            fw.append(',');
            fw.append("TIPO PLAN");
            fw.append(',');
            fw.append("RFC");
            fw.append(',');
            fw.append("FECHA INICIO");
            fw.append(',');
            fw.append("FECHA FIN");
            fw.append(',');
            fw.append("NUMERO VISITAS");
            fw.append(',');
            fw.append("FECHA ULTIMO PAGO");
            fw.append('\n');

            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                fw.append(s.rs.getString("region"));
                fw.append(',');
                fw.append(s.rs.getString("asignacion"));
                fw.append(',');
                fw.append(s.rs.getString("cuenta"));
                fw.append(',');
                fw.append(s.rs.getString("id_equipo"));
                fw.append(',');
                fw.append(s.rs.getString("equipo"));
                fw.append(',');
                fw.append(s.rs.getString("ultima_gestion"));
                fw.append(',');
                fw.append(s.rs.getString("estatus"));
                fw.append(',');
                fw.append(s.rs.getString("codigo"));
                fw.append(',');
                fw.append(s.rs.getString("importe_asignado"));
                fw.append(',');
                fw.append(s.rs.getString("penalizacion"));
                fw.append(',');
                
                fw.append(s.rs.getString("columna19"));
                fw.append(',');
                
                fw.append(s.rs.getString("ajustes"));
                fw.append(',');
                fw.append(s.rs.getString("cancelacion"));
                fw.append(',');
                fw.append(s.rs.getString("pagos_anticipados"));
                fw.append(',');
                fw.append(s.rs.getString("pagos"));
                fw.append(',');
                fw.append(s.rs.getString("a_gestionar"));
                fw.append(',');
                fw.append(s.rs.getString("resto"));
                fw.append(',');
                fw.append(s.rs.getString("porcentaje"));
                fw.append(',');
                fw.append(s.rs.getString("lada"));
                fw.append(',');
                fw.append(s.rs.getString("nombre"));
                fw.append(',');
                fw.append(s.rs.getString("tel1"));
                fw.append(',');
                fw.append(s.rs.getString("tel2"));
                fw.append(',');
                fw.append(s.rs.getString("tel3"));
                fw.append(',');
                fw.append(s.rs.getString("correo"));
                fw.append(',');
                fw.append(s.rs.getString("expediente"));
                fw.append(',');
                fw.append(s.rs.getString("ciudad"));
                fw.append(',');
                fw.append(s.rs.getString("estado"));
                fw.append(',');
                fw.append(s.rs.getString("colonia"));
                fw.append(',');
                fw.append(s.rs.getString("calle"));
                fw.append(',');
                fw.append(s.rs.getString("numero"));
                fw.append(',');
                fw.append(s.rs.getString("cp"));
                fw.append(',');
                fw.append(s.rs.getString("cuentas_multiples"));
                fw.append(',');
                fw.append(s.rs.getString("importe_cuentas_multiples"));
                fw.append(',');
                fw.append(s.rs.getString("tiene_cr"));
                fw.append(',');
                fw.append(s.rs.getString("dias"));
                fw.append(',');
                fw.append(s.rs.getString("referencia1"));
                fw.append(',');
                fw.append(s.rs.getString("tel_referencia1"));
                fw.append(',');
                fw.append(s.rs.getString("tt_r1"));
                fw.append(',');
                fw.append(s.rs.getString("referencia2"));
                fw.append(',');
                fw.append(s.rs.getString("tel_referencia2"));
                fw.append(',');
                fw.append(s.rs.getString("tt_r2"));
                fw.append(',');
                fw.append(s.rs.getString("referencia3"));
                fw.append(',');
                fw.append(s.rs.getString("tel_referencia3"));
                fw.append(',');
                fw.append(s.rs.getString("tt_r3"));
                fw.append(',');
                fw.append(s.rs.getString("referencia4"));
                fw.append(',');
                fw.append(s.rs.getString("tel_referencia4"));
                fw.append(',');
                fw.append(s.rs.getString("tt_r4"));
                fw.append(',');
                fw.append(s.rs.getString("columna72"));
                fw.append(',');
                fw.append(s.rs.getString("columna77"));
                fw.append(',');
                fw.append(s.rs.getString("columna16"));
                fw.append(',');
                fw.append(s.rs.getString("fecha_inicio"));
                fw.append(',');
                fw.append(s.rs.getString("fecha_fin"));
                fw.append(',');
                fw.append(s.rs.getString("visitas"));
                fw.append(',');
                fw.append(s.rs.getString("columna80"));
                fw.append('\n');
            }

            fw.flush();
            fw.close();

            s.rs.close();
            s.st.close();
            s.conn.close();

            resultado = "Se ha generado la base general en CSV de manera correcta.";
            return resultado;

        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
//    //==========================================================================
//    public static String select_basegeneral_tabla(int id_region) {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_select_basegeneral('" + id_region + "');";
//            String renglones;
//            s.rs = s.st.executeQuery(sql);
//            List<Asignacion> basegeneral = new ArrayList<Asignacion>();
//            while (s.rs.next()) {
//                Asignacion b = new Asignacion();
//                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
//                b.setRegion(s.rs.getString("region"));
//                b.setAsignacion(s.rs.getString("asignacion"));
//                b.setCuenta(s.rs.getString("cuenta"));
//                b.setLada(s.rs.getString("lada"));
//                b.setNombre(s.rs.getString("nombre"));
//                b.setExpediente(s.rs.getString("expediente"));
//                b.setCiudad(s.rs.getString("ciudad"));
//                b.setColonia(s.rs.getString("colonia"));
//                b.setCalle(s.rs.getString("calle"));
//                b.setCuentas_multiples(s.rs.getString("cuentas_multiples"));
//                        + "<td style='text-align:right;'>" + b.getImporte_cuentas_multiples() + "</td>"
//                        + "<td style='text-align:right;'>" + b.getTiene_cr() + "</td>"
//                        + "<td style='text-align:center;'>" + b.getDias_transcurridos() + "</td>"
//                        + "<td style='text-align:center;'>" + b.getFecha_inicio() + "</td>"
//                        + "<td style='text-align:center;'>" + b.getFecha_fin() + "</td>"
//                        + "</tr>";
//                cons++;
//            }
//
//            renglones += "</table>";
//
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return renglones;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }

    //==========================================================================
    public static String update_basegeneral(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_basegeneral('" + id_asignacion + "');";
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
    public static String select_basegeneral_asignar_tabla(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_basegeneral_asignar('" + id_asignacion + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> basegeneral = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion b = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                b.setCliente(s.rs.getString("cliente"));
                b.setRegion(s.rs.getString("region"));
                b.setAsignacion(s.rs.getString("asignacion"));
                b.setEquipo(s.rs.getString("id_equipo"));
                b.setTipo_mora(s.rs.getString("tipo_mora"));
                b.setZona(s.rs.getString("zona"));
                b.setTipo_plan(s.rs.getString("tipo_plan"));
                b.setFecha_inicio(s.rs.getString("fecha_inicio"));
                b.setFecha_fin(s.rs.getString("fecha_fin"));
                b.setCuenta(s.rs.getString("columna1"));
                basegeneral.add(b);
            }

            renglones = ""
                    + "<table id='base_general'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width:2%;text-align:right;'></th>"
                    + "<th style='text-align:center;'>CLIENTE</th>"
                    + "<th style='text-align:center;'>REGION</th>"
                    + "<th style='text-align:center;'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>EQUIPO</th>"
                    + "<th style='text-align:center;'>ZONA</th>"
                    + "<th style='text-align:center;'>TIPOMORA</th>"
                    + "<th style='text-align:center;'>TIPO PLAN</th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int cons = 1;
            for (Asignacion b : basegeneral) {
                renglones += ""
                        + "<tr>"
                        + "<td style='text-align:right;'>" + cons + "</td>"
                        + "<td style='text-align:center;'>" + b.getCliente() + "</td>"
                        + "<td style='text-align:center;'>" + b.getRegion() + "</td>"
                        + "<td style='text-align:center;'>" + b.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'>" + b.getEquipo() + "</td>"
                        + "<td style='text-align:center;'>" + b.getZona() + "</td>"
                        + "<td style='text-align:center;'>" + b.getTipo_mora() + "</td>"
                        + "<td style='text-align:center;'>" + b.getTipo_plan() + "</td>"
                        + "<td style='text-align:center;'>" + b.getCuenta() + "</td>"
                        + "</tr>";
                cons++;
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
    public static String asignar_cuentas(int id_asignacion, String equipos) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_asignacion_cartera('" + id_asignacion + "', '" + equipos + "');";
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
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_basechargeback_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_basechargeback_tabla();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> basegeneral = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion b = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                b.setCuenta(s.rs.getString("cuenta"));
                b.setRegion(s.rs.getString("id_region"));
                b.setId_supervisor(s.rs.getInt("id_supervisor"));
                b.setId_usuario(s.rs.getInt("id_usuario"));
                b.setUsuario(s.rs.getString("usuario"));
                b.setAsignacion(s.rs.getString("asignacion"));
                b.setFecha_inicio(s.rs.getString("fecha_reactivacion"));
                b.setFecha_fin(s.rs.getString("fecha_vencimiento"));
                b.setUltimo_estatus_cuenta(s.rs.getString("estatus"));
                b.setUltimo_estatus_llamada(s.rs.getString("id_codigo"));
                b.setCiclo(s.rs.getInt("ciclo"));
                b.setImporte_asignado(s.rs.getString("saldo"));
                b.setEstatus_original(s.rs.getString("estatus_original"));
                b.setUltima_gestion(s.rs.getString("f_automatico"));
                basegeneral.add(b);
            }

            renglones = ""
                    + "<table id='base_general'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>REGION</th>"
                    + "<th style='text-align:center;'>SUPERVISOR</th>"
                    + "<th style='text-align:center;'>ID GESTOR</th>"
                    //                    + "<th style='text-align:center;'>USUARIO</th>"
                    + "<th style='text-align:center;'>ASIGNACION</th>"
                    + "<th style='text-align:center;'>REACTIVACION</th>"
                    + "<th style='text-align:center;'>DEVOLUCION</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>CODIGO</th>"
                    + "<th style='text-align:center;'>CICLO</th>"
                    + "<th style='text-align:center;'>SALDO</th>"
                    + "<th style='text-align:center;'>ESTATUS ORIGINAL</th>"
                    + "<th style='text-align:center;'>ULTIMA GESTION</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion b : basegeneral) {
                renglones += ""
                        + "<tr>"
                        + "<td style='text-align:center;'>" + b.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + b.getRegion() + "</td>"
                        + "<td style='text-align:center;'>" + b.getId_supervisor() + "</td>"
                        + "<td style='text-align:center;'>" + b.getId_usuario() + "</td>"
                        //                        + "<td style='text-align:center;'>" + b.getUsuario() + "</td>"
                        + "<td style='text-align:center;'>" + b.getAsignacion() + "</td>"
                        + "<td style='text-align:center;'>" + b.getFecha_inicio() + "</td>"
                        + "<td style='text-align:center;'>" + b.getFecha_fin() + "</td>"
                        + "<td style='text-align:right;'>" + b.getUltimo_estatus_cuenta() + "</td>"
                        + "<td style='text-align:right;'>" + b.getUltimo_estatus_llamada() + "</td>"
                        + "<td style='text-align:right;'>" + b.getCiclo() + "</td>"
                        + "<td style='text-align:center;'>" + b.getImporte_asignado() + "</td>"
                        + "<td style='text-align:center;'>" + b.getEstatus_original() + "</td>"
                        + "<td style='text-align:center;'>" + b.getUltima_gestion() + "</td>"
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
    public static String select_basechargeback_resumen_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_basechargeback_resumen_tabla();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> basegeneral = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion b = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                b.setUltimo_estatus_cuenta(s.rs.getString("estatus"));
                b.setCuentas(s.rs.getInt("cuentas"));
                b.setPorcentaje(s.rs.getString("porcentaje"));

                basegeneral.add(b);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>CUENTAS</th>"
                    + "<th style='text-align:center;'>PORCENTAJE</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion b : basegeneral) {
                renglones += ""
                        + "<tr>"
                        + "<td style='text-align:center;'>" + b.getUltimo_estatus_cuenta() + "</td>"
                        + "<td style='text-align:right;'>" + b.getCuentas() + "</td>"
                        + "<td style='text-align:center;'>" + b.getPorcentaje() + "%</td>"
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
    public static String select_basechargeback_resumen_tabla_actual() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_basechargeback_resumen_tabla_actual();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Asignacion> basegeneral = new ArrayList<Asignacion>();
            while (s.rs.next()) {
                Asignacion b = new Asignacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                b.setUltimo_estatus_cuenta(s.rs.getString("estatus"));
                b.setCuentas(s.rs.getInt("cuentas"));
                b.setPorcentaje(s.rs.getString("porcentaje"));

                basegeneral.add(b);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>CUENTAS</th>"
                    + "<th style='text-align:center;'>PORCENTAJE</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Asignacion b : basegeneral) {
                renglones += ""
                        + "<tr>"
                        + "<td style='text-align:center;'>" + b.getUltimo_estatus_cuenta() + "</td>"
                        + "<td style='text-align:right;'>" + b.getCuentas() + "</td>"
                        + "<td style='text-align:center;'>" + b.getPorcentaje() + "%</td>"
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

    public static String update_f_active_cuentas(int id_usuario, String cuentas, int f_active) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
//            String sql = "call arcade_update_f_active_cuentas('" + id_usuario + "', '" + cuentas + "', '" + f_active + "');";
            String sql_update = "update arcade_basegeneral set f_active = " + f_active + " where columna1 in (" + cuentas + ") and id_cuenta > 0;";
            System.out.println(sql_update);
            String sql = "select CONCAT('<br>SE HAN PUESTO ', if(" + f_active + "=0,'<b>INACTIVAS </b>','<b>ACTIVAS </b>'), (SELECT LENGTH('" + cuentas + "') - LENGTH(REPLACE('" + cuentas + "', ',', '')) + 1), ' CUENTAS CORRECTAMENTE.') as resultado;";
            System.out.println(sql);
            s.st.executeUpdate(sql_update);

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
}
