package arcade.data;

import arcade.model.Ticket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class TicketDao {

    //==============================================================================
    public static String select_ticket_tabla(int id_story) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_ticket('" + id_story + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Ticket> ticket = new ArrayList<Ticket>();
            int _cant = 0;
            while (s.rs.next()) {
                _cant++;
                Ticket c = new Ticket();
                c.setId_ticket(s.rs.getInt("id_ticket"));
                c.setTicket(s.rs.getString("ticket"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setTiempo_estimado(s.rs.getString("tiempo_estimado"));
                c.setTiempo_real(s.rs.getString("tiempo_real"));
                c.setF_estatus(s.rs.getInt("f_estatus"));

                c.setUsuario_asignado(s.rs.getString("usuario_asignado"));
                ticket.add(c);
            }

            if (_cant > 0) {

                for (Ticket c : ticket) {
                    renglones += ""
                            + "<tr id='" + c.getId_ticket() + "'>"
                            + "<td>" + c.getId_ticket() + "</td>"
                            + "<td>" + c.getTicket() + "</td>"
                            + "<td>" + c.getComentarios() + "</td>"
                            + "<td style='text-align:center;'><b>" + c.getUsuario_asignado() + "</b></td>"
                            + "<td>" + c.getTiempo_estimado() + "</td>"
                            + "<td style='text-align:center;'>" + c.getTiempo_real() + "</td>"
                            + "<td>" + (c.getF_estatus() == 0 ? "<a style='padding: 0px 15px;' class='waves-effect waves-light btn blue'><i class='material-icons'>play_arrow</i></a>" : c.getF_estatus() == 1 ? "<a style='padding: 0px 15px;' class='waves-effect waves-light btn red'><i class='material-icons'>stop</i></a>" : "<a style='padding: 0px 15px;' class='waves-effect waves-light btn'><i class='material-icons'>done</i></a>") + "</td>"
                            + "</tr>";
                }

                renglones += ""
                        + "<tr>"
                        + "<td colspan='7' style='text-align:center;'>"
                        + "<a class='insert_ticket' href='#' style='float:right;'>Registrar nuevo ticket</a>"
                        + "<a id='regresar_a_stories' href='#' style='float:left;'>Regresar a los User Stories</a>"
                        + "</td>"
                        + "</tr>";

            } else {
                renglones += ""
                        + "<div style='text-align:center;'>"
                        + "<br><br>"
                        + "Este story no tiene ningún ticket.<br>"
                        + "Quizá te interese, <a class='insert_ticket' href='#'>crear un nuevo ticket</a>,<br>"
                        + "o ¿prefieres <a id='regresar_a_stories' href='#'>regresar a los User Stories</a>?"
                        + "<div>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_tickets_en_proceso() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_ticket_trabajando();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Ticket> ticket = new ArrayList<Ticket>();
            int _cant = 0;
            while (s.rs.next()) {
                _cant++;
                Ticket c = new Ticket();
                c.setId_ticket(s.rs.getInt("id_ticket"));
                c.setTicket(s.rs.getString("ticket"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setTiempo_estimado(s.rs.getString("tiempo_estimado"));
                c.setTiempo_real(s.rs.getString("tiempo_real"));
                c.setF_estatus(s.rs.getInt("f_estatus"));
                c.setFecha_inicio(s.rs.getString("fecha_inicio"));

                c.setUsuario_asignado(s.rs.getString("usuario_asignado"));
                ticket.add(c);
            }

            if (_cant > 0) {

                for (Ticket c : ticket) {
                    renglones += ""
                            + "<tr id='" + c.getId_ticket() + "'>"
                            + "<td>" + c.getId_ticket() + "</td>"
                            + "<td>" + c.getTicket() + "</td>"
                            + "<td>" + c.getComentarios() + "</td>"
                            + "<td style='text-align:center;'><b>" + c.getUsuario_asignado() + "</b></td>"
                            + "<td>" + c.getTiempo_estimado() + "</td>"
                            + "<td style='text-align:center;'>" + c.getTiempo_real() + "</td>"
                            + "<td style='text-align:center;'><b>" + c.getFecha_inicio() + "</b></td>"
                            + "<td>" + (c.getF_estatus() == 0 ? "<a style='padding: 0px 15px;' class='waves-effect waves-light btn blue'><i class='material-icons'>play_arrow</i></a>" : c.getF_estatus() == 1 ? "<a style='padding: 0px 15px;' class='waves-effect waves-light btn red'><i class='material-icons'>stop</i></a>" : "<a style='padding: 0px 15px;' class='waves-effect waves-light btn'><i class='material-icons'>done</i></a>") + "</td>"
                            + "</tr>";
                }

            } else {
                renglones += ""
                        + "<div style='text-align:center;'>"
                        + "<br><br>"
                        + "No hay ningún ticket en proceso<br><br>"
                        + "D:"
                        + "<div>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_tickets_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_tickets_usuario('" + id_usuario + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Ticket> ticket = new ArrayList<Ticket>();
            int _cant = 0;
            while (s.rs.next()) {
                _cant++;
                Ticket c = new Ticket();
                c.setId_ticket(s.rs.getInt("id_ticket"));
                c.setTicket(s.rs.getString("ticket"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setTiempo_estimado(s.rs.getString("tiempo_estimado"));
                c.setTiempo_real(s.rs.getString("tiempo_real"));
                c.setF_estatus(s.rs.getInt("f_estatus"));
                c.setFecha_inicio(s.rs.getString("fecha_inicio"));
                ticket.add(c);
            }

            if (_cant > 0) {

                for (Ticket c : ticket) {
                    renglones += ""
                            + "<tr id='" + c.getId_ticket() + "'>"
                            + "<td>" + c.getId_ticket() + "</td>"
                            + "<td>" + c.getTicket() + "</td>"
                            + "<td>" + c.getComentarios() + "</td>"
                            + "<td title='" + c.getFecha_inicio() + "'>" + c.getTiempo_estimado() + "</td>"
                            + "<td style='text-align:center;'>" + c.getTiempo_real() + "</td>"
                            + "<td>" + (c.getF_estatus() == 0 ? "<a style='padding: 0px 15px;' class='update_tiempos waves-effect waves-light btn blue'><i class='material-icons'>play_arrow</i></a>" : c.getF_estatus() == 1 ? "<a style='padding: 0px 15px;' class='update_tiempos waves-effect waves-light btn red'><i class='material-icons'>stop</i></a>" : "<a style='padding: 0px 15px;' class='waves-effect waves-light btn'><i class='material-icons'>done</i></a>") + "</td>"
                            + "</tr>";
                }
            } else {
                renglones += ""
                        + "<div style='text-align:center;'>"
                        + "<br><br>"
                        + "Felicidades!.<br>"
                        + "No tienes tickets pendientes,<br>"
                        + "<div>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_resumen_tickets_usuario() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_tickets_por_usuario();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Ticket> ticket = new ArrayList<Ticket>();
            while (s.rs.next()) {

                Ticket c = new Ticket();
                c.setUsuario_asignado(s.rs.getString("usuario"));
                c.setTrabajando(s.rs.getInt("trabajando"));
                c.setDesde(s.rs.getString("desde"));
                c.setPendientes(s.rs.getInt("pendientes"));
                c.setTrabajo_restante(s.rs.getString("trabajo_restante"));
                c.setPorcentaje_puntualidad(s.rs.getString("porcentaje_puntualidad"));
                ticket.add(c);
            }

            for (Ticket c : ticket) {
                renglones += ""
                        + "<div class='col s6' style='padding: 10px;'>"
                        + "<div style='border: solid 1px #DADADA;border-radius: 10px;'>"
                        + "<table>"
                        + "<tr>"
                        + "<td style='width: 1%;padding: 6px 0px 0px 9px;'><i class='material-icons'>account_circle</i></td>"
                        + "<td style='text-align:left;font-size: 1.6rem;'><b>" + c.getUsuario_asignado() + "</b></td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style='width: 1%;padding: 6px 0px 0px 9px;'><i class='material-icons'>info_outline</i></td>"
                        + "<td style='text-align:left;'>Esta trabajando <b>" + c.getTrabajando() + " ticket</b>" + (c.getTrabajando() > 0 ? " desde las <b>" + c.getDesde() + "</b>." : ".") + " </td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style='width: 1%;padding: 6px 0px 0px 9px;'><i class='material-icons'>access_time</i></td>"
                        + "<td style='text-align:left;'>Tiene <b>" + c.getPendientes() + " tickets </b>más por hacer. " + (c.getPendientes() > 0 ? "(<b>" + c.getTrabajo_restante() + "</b> aproximadamente)" : "") + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style='width: 1%;padding: 6px 0px 0px 9px;'><i class='material-icons'>" + (Float.parseFloat(c.getPorcentaje_puntualidad()) > 50 ? "thumb_up" : "thumb_down") + "</i></td>"
                        + "<td style='text-align:left;'>El <b>" + c.getPorcentaje_puntualidad() + "%</b> de sus tickets han sido entregados a tiempo.</td>"
                        + "</tr>"
                        + "</table>"
                        + "</div>"
                        + "</div>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_ticket_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_ticket();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Ticket> ticket = new ArrayList<Ticket>();
            while (s.rs.next()) {
                Ticket e = new Ticket();
                e.setId_ticket(s.rs.getInt("id_ticket"));
                e.setTicket(s.rs.getString("ticket"));
                ticket.add(e);
            }
            for (Ticket c : ticket) {
                renglones += "<option value='" + c.getId_ticket() + "'>" + c.getTicket() + "</option>";
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
    public static List<Ticket> select_ticket() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_ticket();";
            s.rs = s.st.executeQuery(sql);
            List<Ticket> ticket = new ArrayList<Ticket>();
            while (s.rs.next()) {
                Ticket e = new Ticket();
                e.setId_ticket(s.rs.getInt("id_ticket"));
                e.setTicket(s.rs.getString("ticket"));
                ticket.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return ticket;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_ticket(String ticket, int id_story, String comentarios, int id_usuario, int id_usuario_asignado, String tiempo_estimado, String categoria) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_ticket('" + ticket + "', '" + id_story + "', '" + comentarios + "', '" + id_usuario + "', '" + id_usuario_asignado + "', '" + tiempo_estimado + "', '" + categoria + "');";
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
    public static String update_ticket(int id_ticket) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_ticket('" + id_ticket + "');";
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
    public static String update_tiempos_tickets(int id_ticket) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_tiempos_tickets('" + id_ticket + "');";
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
    public static String delete_ticket(int id_ticket) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_ticket('" + id_ticket + "');";
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
