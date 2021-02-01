package arcade.data;

import arcade.data.StartConn;
import java.sql.SQLException;
import arcade.model.Pareja;

/**
 * @author AYCM
 */
public class ParejaDao {

    public static String insert_pareja(Pareja pareja) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_pareja('" + pareja.getId_pareja() + "','" + pareja.getId_gestor() + "','" + pareja.getNombre_pareja() + "','" + pareja.getId_region() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR insert_pareja";
        }
    }
//==============================================================================

    public static String update_pareja(Pareja pareja) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_pareja('" + pareja.getId_registro() + "','" + pareja.getId_pareja() + "','" + pareja.getId_gestor() + "','" + pareja.getNombre_pareja() + "','" + pareja.getId_region() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR update_pareja";
        }
    }
//==============================================================================

    public static String delete_pareja(Pareja pareja) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call delete_pareja('" + pareja.getId_registro() + "','" + pareja.getId_pareja() + "','" + pareja.getId_gestor() + "','" + pareja.getNombre_pareja() + "','" + pareja.getId_region() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR delete_pareja";
        }
    }
//==============================================================================
}