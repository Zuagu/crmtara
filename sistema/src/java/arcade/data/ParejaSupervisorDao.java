package arcade.data;

import arcade.data.StartConn;
import java.sql.SQLException;
import arcade.model.ParejaSupervisor;

/**
 * @author AYCM
 */
public class ParejaSupervisorDao {

    public static String insert_parejasupervisor(ParejaSupervisor parejasupervisor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_parejasupervisor('" + parejasupervisor.getId_pareja() + "','" + parejasupervisor.getId_supervisor() + "','" + parejasupervisor.getAsignacion() + "','" + parejasupervisor.getId_region() + "','" + parejasupervisor.getImporte_asignado() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR insert_parejasupervisor";
        }
    }
//==============================================================================

    public static String update_parejasupervisor(ParejaSupervisor parejasupervisor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_parejasupervisor('" + parejasupervisor.getId_registro() + "','" + parejasupervisor.getId_pareja() + "','" + parejasupervisor.getId_supervisor() + "','" + parejasupervisor.getAsignacion() + "','" + parejasupervisor.getId_region() + "','" + parejasupervisor.getImporte_asignado() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR update_parejasupervisor";
        }
    }
//==============================================================================

    public static String delete_parejasupervisor(ParejaSupervisor parejasupervisor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call delete_parejasupervisor('" + parejasupervisor.getId_registro() + "','" + parejasupervisor.getId_pareja() + "','" + parejasupervisor.getId_supervisor() + "','" + parejasupervisor.getAsignacion() + "','" + parejasupervisor.getId_region() + "','" + parejasupervisor.getImporte_asignado() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR delete_parejasupervisor";
        }
    }
//==============================================================================
}
