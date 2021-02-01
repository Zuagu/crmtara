package arcade.data;

import arcade.model.Tasa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class TasaDao {

    //==========================================================================
    public static String select_tasas_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_tasas();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Tasa> unidadmedidas = new ArrayList<Tasa>();
            while (s.rs.next()) {
                Tasa e = new Tasa();
                e.setId_tasa(s.rs.getInt("id_tasa"));
                e.setTasa(s.rs.getString("tasa"));
                unidadmedidas.add(e);
            }
            for (Tasa c : unidadmedidas) {
                renglones += "<option value='" + c.getId_tasa() + "'>" + c.getTasa() + "</option>";
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
