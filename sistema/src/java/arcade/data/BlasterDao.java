package arcade.data;

import arcade.model.Blaster;
import arcade.model.Llamada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class BlasterDao {

    //==============================================================================
    public static String select_blaster_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_blaster();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Blaster> blaster = new ArrayList<Blaster>();
            while (s.rs.next()) {
                Blaster c = new Blaster();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_blaster(s.rs.getInt("id_blaster"));
                c.setBlaster(s.rs.getString("blaster"));
                c.setPor_marcar(s.rs.getInt("marcadas"));
                c.setNumeros(s.rs.getInt("numeros"));
                c.setPrimer_llamada(s.rs.getString("primer_llamada"));
                c.setUltima_llamada(s.rs.getString("ultima_llamada"));
                c.setF_resultado(s.rs.getInt("resultado"));
                c.setContestadas(s.rs.getInt("contestadas"));
                c.setNo_contestadas(s.rs.getInt("no_contestadas"));
                c.setPorcentaje_contacto(s.rs.getString("porcentaje_contacto"));
                blaster.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'></th>"
                    + "<th>BLASTER</th>"
                    + "<th style='width:10%;text-align:center;'>MARCADOS</th>"
                    + "<th style='width:10%;text-align:center;'>PRIMERA</th>"
                    + "<th style='width:10%;text-align:center;'>ULTIMA</th>"
                    + "<th style='width:10%;text-align:center;'>CONTESTADAS</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Blaster c : blaster) {
                renglones += ""
                        + "<tr id='" + c.getId_blaster() + "'>"
                        + "<td style='text-align:center;'>" + (c.getPor_marcar() == c.getNumeros() ? (c.getF_resultado() == 0 ? "<a class='obtener_resultado_blaster' href='#'><img src='images/b_info.png' title='OBTENER EL RESULTADO DEL BLASTER'></a>" : "<img src='images/b_tick.png'>") : "<img src='images/campaignA.gif' title='BLASTER EN PROGRESO'>") + "</td>"
                        + "<td title='" + c.getId_blaster() + "'><a href='#' class='select_productos_blaster'>" + c.getBlaster() + "</a></td>"
                        + "<td style='text-align:center;'>" + c.getPor_marcar() + " / <b>" + c.getNumeros() + "<b></td>"
                        + "<td style='text-align:center;'>" + c.getPrimer_llamada() + "</td>"
                        + "<td style='text-align:center;'>" + (c.getPor_marcar() == c.getNumeros() ? c.getUltima_llamada() : "") + "</td>"
                        + "<td style='text-align:center;'>"
                        + "<a href='#' class='contestadas'><span title='LLAMADAS CONTESTADAS' style='color:green;font-weight:bold;'>" + c.getContestadas() + "</span></a>"
                        + " / "
                        + "<a href='#' class='nocontestadas'><span title='LLAMADAS NO CONTESTADAS' style='color:red;font-weight:bold;'>" + c.getNo_contestadas() + "</span></a>"
                        + "</td>"
                        + "<td style='text-align:center;'><b>" + c.getPorcentaje_contacto() + "</b></td>"
                        + "<td style='width: 2%'>" + (c.getF_resultado() == 0 ? "" : "<a class='genera_predictivo' href='#'><img src='images/b_phone.png' title='GENERAR CAMPAÑA DE PREDICTIVO DE ESTE BLASTER'/></a>") + "</td>"
                        + "<td style='width: 2%'><a class='remarcar_blaster_ans' href='#'><img src='images/b_siguiente.png' title='VOLVER A MARCAR LO CONTESTADO'/></a></td>"
                        + "<td style='width: 2%'><a class='remarcar_blaster_nc' href='#'><img src='images/b_remarcar.png' title='VOLVER A MARCAR LO NO CONTESTADO'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_blaster' href='#'><img src='images/b_delete.png' title='ELIMINAR ESTE BLASTER'/></a></td>"
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
    public static String select_blaster_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_blaster_combo();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Blaster> blaster = new ArrayList<Blaster>();
            while (s.rs.next()) {
                Blaster e = new Blaster();
                e.setId_blaster(s.rs.getInt("id_blaster"));
                e.setBlaster(s.rs.getString("blaster"));
                blaster.add(e);
            }
            for (Blaster c : blaster) {
                renglones += "<option value='" + c.getId_blaster() + "'>" + c.getBlaster() + "</option>";
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
    public static List<Blaster> select_blaster() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_blaster();";
            s.rs = s.st.executeQuery(sql);
            List<Blaster> blaster = new ArrayList<Blaster>();
            while (s.rs.next()) {
                Blaster e = new Blaster();
                e.setId_blaster(s.rs.getInt("id_blaster"));
                e.setBlaster(s.rs.getString("blaster"));
                blaster.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return blaster;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_blaster(String nombre, int reintentos, int timbrado, String troncal, String prefijo, String audio, int confirmar) {
        try {
            StartConn s = new StartConn();
            String resultado = "";

            // Creamos variable para obtener el id del blaster generado
            int _id_blaster = 0;

            // Definimos la consulta
            String insert_blaster = "call arcade_insert_blaster('" + nombre + "');";

            // Ejecutamos el SP y cachamois el resultado
            s.rs = s.st.executeQuery(insert_blaster);
            if (s.rs.next()) {
                _id_blaster = s.rs.getInt("resultado");
            }

            String sql_import = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\blaster.csv'\n"
                    + "INTO TABLE arcade_blaster_numeros -- 2 columnas\n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "IGNORE 1 ROWS\n"
                    + "(\n"
                    + "@col1,@col2)\n"
                    + "set\n"
                    + "id_blaster='" + _id_blaster + "', telefono=concat('" + prefijo + "',@col1), troncal='" + troncal + "', intentos='" + reintentos + "',\n"
                    + "retry_time='" + timbrado + "', wait_time=30,contexto='" + audio + "', cuenta=@col2;";

            // Importamos las cuentas
            s.st.executeUpdate(sql_import);

            // Generamos la query del resultado
            String sql_resultado = "call arcade_datos_blaster('" + _id_blaster + "');";

            // Cachamos el resultado
            s.rs = s.st.executeQuery(sql_resultado);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR insert_cr";
        }
    }

    //==========================================================================
    public static String update_blaster(int id_blaster) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_blaster('" + id_blaster + "');";
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
    public static String delete_blaster(int id_blaster) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_blaster('" + id_blaster + "');";
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
    public static String remarcar_blaster(int id_usuario, int id_blaster, int todo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_remarcar_blaster('" + id_usuario + "', '" + id_blaster + "', '" + todo + "');";
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
    public static String obtener_resultado_blaster(int id_blaster) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_obtener_resultado_blaster('" + id_blaster + "');";
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
    public static String genera_predictivo(int id_usuario, int id_blaster) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_genera_predictivo('" + id_usuario + "', '" + id_blaster + "');";
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

    //==============================================================================
    public static String select_blaster_resultado_tabla(int id_blaster, int ans) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_blaster_resultado('" + id_blaster + "','" + ans + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Llamada> llamadas = new ArrayList<Llamada>();
            while (s.rs.next()) {
                Llamada ll = new Llamada();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                ll.setId_llamada(s.rs.getInt("id_llamada"));
                ll.setTelefono(s.rs.getString("telefono"));
                ll.setCuenta(s.rs.getString("cuenta"));
                ll.setFecha(s.rs.getString("fecha"));
                ll.setHora(s.rs.getString("hora"));
                ll.setDisposicion(s.rs.getString("disposicion"));
                ll.setDuracion(s.rs.getString("duracion"));
                ll.setUltima_accion(s.rs.getString("ultima_accion"));
                llamadas.add(ll);
            }

            renglones = ""
                    + "<table id='resultado'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>TELEFONO</th>"
                    + "<th>FECHA</th>"
                    + "<th>HORA</th>"
                    + "<th>CUENTA</th>"
                    + "<th>DISPOSICION</th>"
                    + "<th>DURACION</th>"
                    + "<th>ACCION</th>"
                    + "</tr></thead>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Llamada ll : llamadas) {
                renglones += ""
                        + "<tr id='" + ll.getId_llamada() + "'>"
                        + "<td>" + ll.getTelefono() + "</td>"
                        + "<td>" + ll.getFecha() + "</td>"
                        + "<td>" + ll.getHora() + "</td>"
                        + "<td>" + ll.getCuenta() + "</td>"
                        + "<td>" + ll.getDisposicion() + "</td>"
                        + "<td>" + ll.getDuracion() + "</td>"
                        + "<td>" + ll.getUltima_accion() + "</td>"
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
    public static String select_audios_blaster(int f_active) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_audios_blaster('" + f_active + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Blaster> blaster = new ArrayList<Blaster>();
            while (s.rs.next()) {
                Blaster e = new Blaster();
                e.setId_blaster(s.rs.getInt("id_audio"));
                e.setBlaster(s.rs.getString("audio"));
                blaster.add(e);
            }
            for (Blaster c : blaster) {
                renglones += "<option value='blaster" + c.getId_blaster() + "'>" + c.getBlaster() + "</option>";
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
    public static String select_audios_blaster_tabla(int f_active) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_audios_blaster('" + f_active + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Blaster> blaster = new ArrayList<Blaster>();
            while (s.rs.next()) {
                Blaster c = new Blaster();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_blaster(s.rs.getInt("id_audio"));
                c.setBlaster(s.rs.getString("audio"));
                c.setPor_marcar(s.rs.getInt("f_active"));
                blaster.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    + "<th style='width: 2%'></th>"
                    + "<th>NOMBRE AUDIO</th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "</tr>";

            for (Blaster c : blaster) {
                renglones += "<tr id='" + c.getId_blaster() + "'>"
                        + "<td>" + c.getId_blaster() + "</td>"
                        + "<td><input class='nombre_audio_blaster alfanumerico' type='text' value='" + c.getBlaster() + "' style='border:none;background:transparent;font-weight:bold;'></td>"
                        + "<td><input id='f_active" + c.getId_blaster() + "' type='hidden' value='" + c.getPor_marcar() + "'>"
                        + "<input type='checkbox' class='activar_audio' " + (c.getPor_marcar() == 0 ? "" : "checked") + " style='cursor:pointer;'>"
                        + "</td>"
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
    public static String update_nombre_audio_blaster(int id_audio, String audio) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_update_nombre_audio_blaster('" + id_audio + "', '" + audio + "');";
            String resultado = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_estatus_audio_blaster(int id_audio, int f_active) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_update_estatus_audio_blaster('" + id_audio + "', '" + f_active + "');";
            String resultado = "";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
}
