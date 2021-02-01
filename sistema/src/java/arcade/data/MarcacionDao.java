package arcade.data;

import arcade.model.Marcacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class MarcacionDao {

    //==========================================================================
    public static String select_marcacion_tabla(String estatus) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "select arcade_llamadas_campaign(id) as llamadas, campaign.* from call_center.campaign where estatus in (" + estatus + ");";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Marcacion> marcacion = new ArrayList<Marcacion>();
            while (s.rs.next()) {
                Marcacion c = new Marcacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_marcacion(s.rs.getInt("id"));
                c.setLlamadas(s.rs.getInt("llamadas"));
                c.setMarcacion(s.rs.getString("name"));
                c.setFecha_inicio(s.rs.getString("datetime_init"));
                c.setHora_inicio(s.rs.getString("daytime_init"));
                c.setFecha_fin(s.rs.getString("datetime_end"));
                c.setHora_fin(s.rs.getString("daytime_end"));
                c.setIntentos(s.rs.getInt("retries"));
                c.setTrunk(s.rs.getString("trunk"));
                c.setContext(s.rs.getString("context"));
                c.setQueue(s.rs.getString("queue"));
                c.setMax_canales(s.rs.getString("max_canales"));
                c.setNum_completadas(s.rs.getString("num_completadas"));
                c.setPromedio(s.rs.getString("promedio"));
                c.setDesviacion(s.rs.getString("desviacion"));
                c.setScript(s.rs.getString("script"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setId_url(s.rs.getInt("id_url"));
                marcacion.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>PREDICTIVO</th>"
                    + "<th>COLA</th>"
                    + "<th style='text-align:center;'>NUMEROS</th>"
                    + "<th style='text-align:center;'>FECHA INICIO</th>"
                    + "<th style='text-align:center;'>HORA INICIO</th>"
                    + "<th style='text-align:center;'>FECHA FIN</th>"
                    + "<th style='text-align:center;'>HORA FIN</th>"
                    + "<th style='text-align:center;'>INTENTOS</th>"
                    //                    + "<th>TRONCAL</th>"
                    //                    + "<th>CONTEXT</th>"
                    //                    + "<th>MAX CANALES</th>"
                    + "<th style='text-align:center;'>COMPLETADAS</th>"
                    + "<th style='text-align:center;'>PROMEDIO</th>"
                    + "<th style='text-align:center;'>DESVIACION</th>"
                    + "<th style='text-align:center;width:2%;'></th>"
                    + "<th style='text-align:center;width:2%;'></th>"
                    + "<th style='text-align:center;width:2%;'></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Marcacion c : marcacion) {
                renglones += ""
                        + "<tr id='" + c.getId_marcacion() + "' style='cursor:pointer;' class='select_id_campaign'>"
                        + "<td>" + c.getId_marcacion() + "</td>"
                        + "<td>" + c.getMarcacion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getQueue() + "</td>"
                        + "<td style='text-align:center;'><b>" + c.getLlamadas() + "</b></td>"
                        + "<td style='text-align:center;'>" + c.getFecha_inicio() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_inicio() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_fin() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_fin() + "</td>"
                        + "<td style='text-align:center;font-weight:bold;'>" + c.getIntentos() + "</td>"
                        //                        + "<td>" + c.getTrunk() + "</td>"
                        //                        + "<td>" + c.getContext() + "</td>"
                        //                        + "<td>" + c.getMax_canales() + "</td>"
                        + "<td>" + c.getNum_completadas() + "</td>"
                        + "<td>" + c.getPromedio() + "</td>"
                        + "<td>" + c.getDesviacion() + "</td>"
                        + "<td style='width: 2%;text-align:center;'><a class='update_estatus_campania' href='#'><img src='images/campaign" + c.getEstatus() + ".gif'/></a></td>"
                        + "<td style='width: 2%'><a class='obtener_resultado_predictivo' href='#' title='OBTENER RESULTADO PREDICTIVO'><img src='images/i_excel.png'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_marcacion' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_marcacion_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_marcacion();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Marcacion> marcacion = new ArrayList<Marcacion>();
            while (s.rs.next()) {
                Marcacion e = new Marcacion();
                e.setId_marcacion(s.rs.getInt("id_marcacion"));
                e.setMarcacion(s.rs.getString("marcacion"));
                marcacion.add(e);
            }
            for (Marcacion c : marcacion) {
                renglones += "<option value='" + c.getId_marcacion() + "'>" + c.getMarcacion() + "</option>";
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
    public static List<Marcacion> select_marcacion() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_marcacion();";
            s.rs = s.st.executeQuery(sql);
            List<Marcacion> marcacion = new ArrayList<Marcacion>();
            while (s.rs.next()) {
                Marcacion e = new Marcacion();
                e.setId_marcacion(s.rs.getInt("id_marcacion"));
                e.setMarcacion(s.rs.getString("marcacion"));
                marcacion.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return marcacion;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_marcacion(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_marcacion('" + nombre + "');";
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
    public static String update_marcacion(int id_marcacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_marcacion('" + id_marcacion + "');";
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
    public static String delete_marcacion(int id_marcacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_marcacion('" + id_marcacion + "');";
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
    public static String insert_campania_marcacion(int id_asignacion, int f_tipo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_campania_marcacion('" + id_asignacion + "','" + f_tipo + "');";
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
    public static String update_estatus_campania(int id_campaign) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_estatus_campania('" + id_campaign + "');";
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
    public static String update_cola_campania(int id_campaign, int id_cola) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_cola_campania('" + id_campaign + "', '" + id_cola + "');";
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
    public static String identificar() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql_result = "call arcade_identifica();";

            s.st.executeUpdate("TRUNCATE arcade_identifica;");

            String sql = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\identifica.csv'\n"
                    + "INTO TABLE arcade_identifica -- 1 columna\n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    //                    + "IGNORE 1 LINES"
                    + "(@col1)\n"
                    + "set\n"
                    + "numero=@col1;\n";

            s.st.executeUpdate(sql);

            s.rs = s.st.executeQuery(sql_result);
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
    public static String select_numeros_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_numeros_identificados();";
            s.rs = s.st.executeQuery(sql);
            List<Marcacion> marcacion = new ArrayList<Marcacion>();
            while (s.rs.next()) {
                Marcacion c = new Marcacion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNumero(s.rs.getString("numero"));
                c.setTipo(s.rs.getString("tipo"));
                c.setEmpresa(s.rs.getString("empresa"));
                marcacion.add(c);
            }

            renglones = ""
                    + "<table id='numeros_identificados'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>NUMERO</th>"
                    + "<th>TIPO</th>"
                    + "<th>EMPRESA</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Marcacion c : marcacion) {
                renglones += ""
                        + "<tr>"
                        + "<td>" + c.getNumero() + "</td>"
                        + "<td>" + c.getTipo() + "</td>"
                        + "<td>" + c.getEmpresa() + "</td>"
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
}
