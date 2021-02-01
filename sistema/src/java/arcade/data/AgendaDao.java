package arcade.data;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import arcade.model.Agenda;
 
/* @author Luis Cortez */
public class AgendaDao {
 
//==============================================================================
    public static String insert_agenda(Agenda agenda) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_agenda('" + agenda.getId_usuario() + "','" + agenda.getCuenta() + "','" + agenda.getFecha() + "','" + agenda.getHora() + "');";
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
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR insert_agenda";
        }
    }
//==============================================================================
 
    public static String update_agenda(Agenda agenda) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_agenda('" + agenda.getId_agenda() + "','" + agenda.getId_equipo() + "','" + agenda.getCuenta() + "','" + agenda.getFecha() + "','" + agenda.getHora() + "','" + agenda.getF_visto() + "');";
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
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR update_agenda";
        }
    }
//==============================================================================
 
    public static String delete_agenda(Agenda agenda) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call delete_agenda('" + agenda.getId_agenda() + "','" + agenda.getId_equipo() + "','" + agenda.getCuenta() + "','" + agenda.getFecha() + "','" + agenda.getHora() + "','" + agenda.getF_visto() + "');";
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
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR delete_agenda";
        }
    }
//==============================================================================
 
    public static String select_agendas_pareja(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_agendas_pareja('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Agenda> agendas = new ArrayList<Agenda>();
            while (s.rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId_agenda(s.rs.getInt("id_agenda"));
                agenda.setEquipo(s.rs.getString("equipo"));
                agenda.setCuenta(s.rs.getString("cuenta"));
                agenda.setFecha(s.rs.getString("fecha"));
                agenda.setHora(s.rs.getString("hora"));
                agendas.add(agenda);
            }
 
            renglones = ""
                    + "<table style='width:100%;'>"
                    + "<thead>"
                    + "<tr>"
                    + "<th style='font-size: 12px;width:2%;'></th>"
                    + "<th style='font-size: 12px;'>EQUIPO</th>"
                    + "<th style='font-size: 12px;'>CUENTA</th>"
                    + "<th style='font-size: 12px;'>FECHA</th>"
                    + "<th style='font-size: 12px;'>HORA</th>"
                    + "</tr>"
                    + "</thead>";
 
            int _cons = 1;
 
            for (Agenda p : agendas) {
                renglones += ""
                        + "<tr id='" + p.getCuenta() + "'>"
                        + "<td style='text-align:right;'>" + _cons + "</td>"
                        + "<td>" + p.getEquipo() + "</td>"
                        + "<td style='text-align:center;'><a href='#' class='cuenta_encontrada'>" + p.getCuenta() + "</a></td>"
                        + "<td style='text-align:center;'>" + p.getFecha() + "</td>"
                        + "<td style='text-align:center;'>" + p.getHora() + "</td>"
                        + "</tr>";
                _cons++;
            }
            renglones += "</table>";
 
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
//==============================================================================
 
    public static String select_agenda_tabla(String fecha) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_agendas_fecha('" + fecha + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Agenda> agendas = new ArrayList<Agenda>();
            while (s.rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setGestor(s.rs.getString("gestor"));
                agenda.setEquipo(s.rs.getString("equipo"));
                agenda.setCuenta(s.rs.getString("cuenta"));
                agenda.setHora(s.rs.getString("hora"));
                agenda.setF_visto(s.rs.getInt("f_visto"));
                agenda.setF_pasada(s.rs.getInt("f_pasada"));
                agendas.add(agenda);
            }
 
            renglones = ""
                    + "<table id='tabla_agendas' style='width:100%;'>"
                    + "<thead>"
                    + "<tr>"
                    + "<th style='font-size: 12px;width:2%;'></th>"
                    + "<th style='font-size: 12px;'>CUENTA</th>"
                    + "<th style='font-size: 12px;'>EQUIPO</th>"
                    + "<th style='font-size: 12px;'>HORA</th>"
                    + "</tr>"
                    + "</thead><tbody>";
 
            int _cons = 1;
 
            for (Agenda p : agendas) {
                renglones += ""
                        + "<tr " + (p.getF_pasada() == 1 ? "class='pasada'" : "") + " id='" + p.getCuenta() + "'>"
                        + "<td style='text-align:right;" + (p.getF_pasada() == 1 ? "background:#FE5D49;" : "") + "'>" + _cons + "</td>"
                        + "<td style='text-align:center;'><a href='#' class='cuenta_encontrada'>" + p.getCuenta() + "</a></td>"
                        + "<td>" + p.getEquipo() + "</td>"
                        + "<td style='text-align:center;'>" + p.getHora() + "</td>"
                        + "</tr>";
                _cons++;
            }
            renglones += "</tbody></table>";
 
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}