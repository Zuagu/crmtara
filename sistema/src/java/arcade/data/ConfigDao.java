package arcade.data;

import java.sql.SQLException;

/* @author LUIS CORTEZ */
public class ConfigDao {

    //==========================================================================
    public static String select_config() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "SELECT concat(franja_index,'#AND#',nombre_cliente,'#AND#',color,'#AND#',color_menu) as resultado FROM arcade_call.arcade_config;";

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
    public static String select_license() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "select concat(conv(fl3,16,10),' DE ', nombre_mes(conv(fl2,16,10)),' DEL ', conv(fl1,16,10),'#AND#',conv(users,16,10)) as resultado from arcade_config;";

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
    public static String update_config(String v1, String v2, String v3, String v4) {
        try {
            StartConn s = new StartConn();
            String resultado = "updated arcade config";
            String sql = "UPDATE `arcade_call`.`arcade_config`"
                    + "SET"
                    + "`franja_index`='background: " + v1 + "',"
                    + "`nombre_cliente`='" + v2 + "',"
                    + "`color`='" + v3 + "',"
                    + "`color_menu`='" + v4 + "'"
                    + "WHERE `id_tema`='1';";
            // s.rs = s.st.executeQuery(sql);

            System.out.println(sql);

            s.st.executeUpdate(sql);

            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================

}
