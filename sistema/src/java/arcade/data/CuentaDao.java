package arcade.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import arcade.model.Cuenta;
import arcade.model.Pastel;

public class CuentaDao {
    //==============================================================================

    public static String select_datos_cuenta(String cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call datos_cuenta('" + cuenta + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_datos_cuenta";
        }
    }
    //==============================================================================

    public static String select_datos_cuenta_chbk(String cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call datos_cuenta_chbk('" + cuenta + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_datos_cuenta";
        }
    }
    //==============================================================================

    public static String select_cuenta_siguiente(int id_usuario) {
        try {
            StartConn s = new StartConn();
//            String sql = "call select_cuenta_siguiente('" + id_usuario + "');";
            String sql = "call arcade_select_cuenta_siguiente('" + id_usuario + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_cuenta_siguiente";
        }
    }
    //==============================================================================

    public static String select_cuenta_siguiente_chbk(int id_usuario, int ciclo, String estatus_original, String estatus) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_cuenta_siguiente_chbk('" + id_usuario + "', '" + ciclo + "','" + estatus_original + "', '" + estatus + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_cuenta_siguiente_chbk";
        }
    }

    // =========================================================================
    public static String select_referencias_bancarias(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_referencias_bancarias('" + cuenta + "');";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                renglones = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error. Código de error: " + ex;
        }
    }

    // =========================================================================
    public static String select_speech_cuenta(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_speech_cuenta('" + cuenta + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_speech_cuenta";
        }
    }

    // =========================================================================
    public static String select_control_tiempos(int id_gestor) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_control_tiempos('" + id_gestor + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_speech_cuenta";
        }
    }

    // =========================================================================
    public static String select_referencia_cuenta(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_referencia_cuenta('" + cuenta + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_referencia_cuenta";
        }
    }

    // =========================================================================
    public static String update_referencia_cuenta(int cuenta, String referencia) {
        try {
            StartConn s = new StartConn();
            String sql = "call update_referencia_cuenta('" + cuenta + "','" + referencia + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR update_referencia_cuenta";
        }
    }

    // =========================================================================
    public static String select_buscar_cuentas(String cadena) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_buscar_cuentas('" + cadena + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Cuenta> cuentas = new ArrayList<Cuenta>();
            while (s.rs.next()) {
                Cuenta c = new Cuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_cuenta(s.rs.getInt("id_cuenta"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setNombre(s.rs.getString("nombre"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setExpediente(s.rs.getString("expediente"));
                c.setReferencias(s.rs.getString("referencias"));
                c.setUltimo_estatus_cuenta(s.rs.getString("ultimo_estatus_cuenta"));
                c.setUltimo_estatus_llamada(s.rs.getString("ultimo_estatus_llamada"));
                c.setEquipo(s.rs.getString("equipo"));
                cuentas.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>CUENTA</th>"
                    + "<th>ASIGNACION</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>ESTATUS</th>"
                    + "<th>CODIGO</th>"
                    + "<th>REFERENCIAS</th>"
                    + "<th>EXPEDIENTE</th>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Cuenta c : cuentas) {
                renglones += ""
                        + "<tr id='" + c.getCuenta() + "' title='" + c.getEquipo() + "'>"
                        + "<td style='text-align:center;'><a href='#' class='cuenta_encontrada'>" + c.getCuenta() + "</a></td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_cuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_llamada() + "</td>"
                        + "<td>" + c.getReferencias() + "</td>"
                        + "<td style='text-align:center;'>" + c.getExpediente() + "</td>"
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

    // =========================================================================
    public static String select_buscar_cuentas_chbk(String cadena) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_buscar_cuentas_chbk('" + cadena + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Cuenta> cuentas = new ArrayList<Cuenta>();
            while (s.rs.next()) {
                Cuenta c = new Cuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_cuenta(s.rs.getInt("id_cuenta"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setNombre(s.rs.getString("nombre"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setExpediente(s.rs.getString("expediente"));
                c.setReferencias(s.rs.getString("referencias"));
                c.setUltimo_estatus_cuenta(s.rs.getString("ultimo_estatus_cuenta"));
                c.setUltimo_estatus_llamada(s.rs.getString("ultimo_estatus_llamada"));
                cuentas.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>CUENTA</th>"
                    + "<th>ASIGNACION</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>ESTATUS</th>"
                    + "<th>CODIGO</th>"
                    + "<th>REFERENCIAS</th>"
                    + "<th>EXPEDIENTE</th>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Cuenta c : cuentas) {
                renglones += ""
                        + "<tr id='" + c.getCuenta() + "'>"
                        + "<td style='text-align:center;'><a href='#' class='cuenta_encontrada'>" + c.getCuenta() + "</a></td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_cuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_llamada() + "</td>"
                        + "<td>" + c.getReferencias() + "</td>"
                        + "<td style='text-align:center;'>" + c.getExpediente() + "</td>"
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
    public static String listado_por_estatus_gestor(int id_gestor, int id_estatus) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_listado_por_estatus_gestor('" + id_gestor + "', '" + id_estatus + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Cuenta> cuentas = new ArrayList<Cuenta>();
            while (s.rs.next()) {
                Cuenta c = new Cuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setCuenta(s.rs.getString("cuenta"));
                c.setNombre(s.rs.getString("nombre"));
                c.setUltimo_estatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setUltimo_estatus_llamada(s.rs.getString("estatus_llamada"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setExpediente(s.rs.getString("expediente"));
                c.setEquipo(s.rs.getString("equipo"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                cuentas.add(c);
            }

            renglones = ""
                    + "<table style='width:100%;'>"
                    + "<thead>"
                    + "<tr>"
                    + "<th style='font-size: 12px;'>CUENTA</th>"
                    + "<th style='font-size: 12px;'>NOMBRE</th>"
                    + "<th style='font-size: 12px;'>FECHA</th>"
                    + "<th style='font-size: 12px;'>HORA</th>"
                    + "<th style='font-size: 12px;'>ESTATUS</th>"
                    + "<th style='font-size: 12px;'>CODIGO</th>"
                    + "<th style='font-size: 12px;'>ASIGNACIÓN</th>"
                    + "<th style='font-size: 12px;'>EQUIPO</th>"
                    + "</tr>"
                    + "</thead>";

            // CUEPRO DE LA TABLA
            for (Cuenta c : cuentas) {
                renglones += ""
                        + "<tr id='" + c.getCuenta() + "'>"
                        + "<td style='text-align:center;'><a class='cuenta_encontrada'>" + c.getCuenta() + "</a></td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_cuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getUltimo_estatus_llamada() + "</td>"
                        + "<td style='text-align:center;'>" + c.getAsignacion() + "</td>"
                        + "<td>" + c.getEquipo() + "</td>"
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

    public static List<Pastel> select_pastel_gestor(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_pastel_gestor('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Pastel> pastel = new ArrayList<Pastel>();
            while (s.rs.next()) {
                Pastel p = new Pastel();
                p.setEstatus(s.rs.getString("estatus"));
                p.setPagadas(s.rs.getInt("pagadas"));
                p.setPor_cobrar(s.rs.getInt("por_cobrar"));
                p.setCuentas(s.rs.getInt("cuentas"));
                p.setPagado_estatus(s.rs.getFloat("pagado_estatus"));
                p.setPor_cobrar_estatus(s.rs.getFloat("por_cobrar_estatus"));
                p.setValor_estatus(s.rs.getFloat("valor_estatus"));
                p.setUltima_gestion(s.rs.getString("ultima_gestion"));
                pastel.add(p);
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return pastel;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    //==========================================================================
    public static String select_detalle_cartera_chbk(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_detalle_cartera_chbk('" + id_usuario + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_detalle_cartera_chbk";
        }
    }

    //==============================================================================
    public static String update_f_seguimiento_cuenta(String cuenta, int f_seguimiento) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_update_f_seguimiento_cuenta('" + cuenta + "', '" + f_seguimiento + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error:" + ex;
        }
    }

    //==========================================================================
    public static String f_seguimiento(String cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_f_seguimiento('" + cuenta + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error:" + ex;
        }
    }

    //==========================================================================
    public static String select_etiquetas_cliente(int id_puesto, String etiquetas) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_etiquetas_cliente('" + id_puesto + "', '" + etiquetas + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error:" + ex;
        }
    }

    //==========================================================================
    public static String select_etiquetas_puesto_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_etiquetas_puesto_usuario('" + id_usuario + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error:" + ex;
        }
    }

    //==========================================================================
    public static String insert_etiquetas_cliente(int id_puesto, String etiquetas) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_insert_etiquetas_cliente('" + id_puesto + "', '" + etiquetas + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error:" + ex;
        }
    }

    //==========================================================================
    public static String clonar_etiquetas(int id_puesto, int id_puesto2) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_clonar_etiquetas('" + id_puesto + "', '" + id_puesto2 + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error:" + ex;
        }
    }

    //==========================================================================
    public static String insert_nuevo_numero_contacto(int id_usuario, String cuenta, String numero) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_insert_nuevo_numero_contacto('" + id_usuario + "', '" + cuenta + "', '" + numero + "');";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL Error:" + ex;
        }
    }
    //==========================================================================
        public static String select_numero_visitas(String cuenta) {
        try {
            StartConn s = new StartConn();
            //String sql = "call arcade_select_cuenta_siguiente('" + cuenta + "');";
            String sql = "SELECT count(cuenta) as resultado FROM arcade_call.arcade_gestiones where cuenta = "+cuenta+" and id_estatus_llamada in (6,20,21);";
            System.out.println(sql);
            String numero_visitas = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                numero_visitas = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return numero_visitas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_cuenta_siguiente";
        }
    }
    //==============================================================================
    public static String update_numero_visitas(int cuenta, int codigo) {
        try {
            StartConn s = new StartConn();
            String sql = "call actualizar_numero_visitas('"+ cuenta +"',"+codigo+");";
            System.out.println(sql);
            String datos_cuenta = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                datos_cuenta = s.rs.getString("resultado");
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return datos_cuenta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR update_referencia_cuenta";
        }
    }
     // =========================================================================
     public static String select_saldos_gestores(int usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_saldos_gestores("+usuario+");"; 
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
             List<Cuenta> cuentas = new ArrayList<Cuenta>();
            while (s.rs.next()) {
                Cuenta c = new Cuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region"));
                c.setUltimo_estatus_cuenta(s.rs.getString("estatus"));
                c.setId_estatus(s.rs.getInt("ultimo_estatus_cuenta"));
                c.setCuenta(s.rs.getString("cuentas"));
                c.setSaldo_estimado(s.rs.getFloat("valor"));
                c.setFecha(s.rs.getString("ultimo_toque"));
                c.setEstatus(s.rs.getString("grupo"));
                c.setNombre(s.rs.getString("color"));
                cuentas.add(c);
            }

            renglones = ""
                    + "<table style='width:100%;'>"
                    + "<thead>"
                    + "<tr>"
                    + "<th style='font-size: 12px;'>REGION</th>"
                    + "<th style='font-size: 12px;'>ESTATUS</th>"
                    + "<th style='font-size: 12px;'>NUMERO DE CUENTAS</th>"
                    + "<th style='font-size: 12px;'>VALOR</th>"
                    + "<th style='font-size: 12px;'>ULTIMO ESTATUS</th>"   
                    + "<th style='font-size: 12px;'>GRUPO</th>"   
                    + "</tr>"
                    + "</thead>";

            // CUEPRO DE LA TABLA
            for (Cuenta c : cuentas) {
                renglones += ""
                        + "<tr class='cuentas_estatus pointer'  id='"+ c.getId_estatus() +"' style='"+c.getNombre()+"' >"
                        + "<td><a class='cuenta_encontrada'>" + c.getRegion() + "</a></td>"
                        + "<td>" + c.getUltimo_estatus_cuenta() + "</td>"
                        + "<td>" + c.getCuenta() + "</td>"
                        + "<td> $" + c.getSaldo_estimado() + "</td>"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td style>" + c.getEstatus()+ "</td>"
                        + "</tr>";
            }

            renglones += "</table>";
            s.st.close();
            s.rs.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_cuenta_siguiente";
        }
    }
    // =========================================================================
     public static String select_cuentas_de_estaus(int id_usuario, int id_estatus) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_cuentas_estatus_gestor("+id_usuario+","+id_estatus+");"; 
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
             List<Cuenta> cuentas = new ArrayList<Cuenta>();
            while (s.rs.next()) {
                Cuenta c = new Cuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region"));
                c.setUltimo_estatus_cuenta(s.rs.getString("cuenta"));
                c.setCuenta(s.rs.getString("estatus"));
                c.setSaldo_estimado(s.rs.getFloat("resto"));
                c.setFecha(s.rs.getString("ultima_gestion"));
                cuentas.add(c);
            }

            renglones = ""
                    + "<table style='width:100%;'>"
                    + "<thead>"
                    + "<tr>"
                    + "<th style='font-size: 12px;'>REGION</th>"
                    + "<th style='font-size: 12px;'>CUENTA</th>"
                    + "<th style='font-size: 12px;'>ESTATUS</th>"
                    + "<th style='font-size: 12px;'>RESTO</th>"
                    + "<th style='font-size: 12px;'>ULTIMA GESTION</th>"   
                    + "</tr>"
                    + "</thead>";

            // CUEPRO DE LA TABLA
            for (Cuenta c : cuentas) {
                renglones += ""
                        + "<tr id='" + c.getUltimo_estatus_cuenta() + "' class='pointer' >"
                        + "<td class='cuenta_encontrada' >" + c.getRegion() + "</a></td>"
                        + "<td class='cuenta_encontrada' >" + c.getUltimo_estatus_cuenta() + "</td>"
                        + "<td class='cuenta_encontrada' >" + c.getCuenta() + "</td>"
                        + "<td class='cuenta_encontrada' > $" + c.getSaldo_estimado() + "</td>"
                        + "<td class='cuenta_encontrada' >" + c.getFecha() + "</td>"
                        + "</tr>";
            }

            renglones += "<button id='boton_chido'>Regresar</button>" + "</table>";
            s.st.close();
            s.rs.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR select_cuenta_siguiente";
        }
    }
    // =========================================================================
}
