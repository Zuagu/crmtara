package arcade.data;

import arcade.model.UnidadMedida;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class UnidadMedidaDao {

    //==============================================================================
    public static String select_unidadesmedida_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_unidadesmedida();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<UnidadMedida> unidadmedidas = new ArrayList<UnidadMedida>();
            while (s.rs.next()) {
                UnidadMedida e = new UnidadMedida();
                e.setId_unidadmedida(s.rs.getInt("id_unidad"));
                e.setUnidadmedida(s.rs.getString("unidad"));
                unidadmedidas.add(e);
            }
            for (UnidadMedida c : unidadmedidas) {
                renglones += "<option value='" + c.getId_unidadmedida() + "'>" + c.getUnidadmedida() + "</option>";
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
}
