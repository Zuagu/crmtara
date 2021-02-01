package arcade.data;

import java.sql.SQLException;

/* @author LUIS CORTEZ */
public class MetricasOperativasDao {

    //==========================================================================
    public static String select_datos_metricas_operativas(int id_region, String _desde, String _hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_metricas_operativas('" + id_region + "','" + _desde + "','" + _hasta + "');";
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
            return "SQL Error. Code: " + ex;
        }
    }
    //==========================================================================
}
