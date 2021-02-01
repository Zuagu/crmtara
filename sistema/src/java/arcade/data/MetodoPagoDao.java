package arcade.data;

import arcade.model.MetodoPago;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author ARCADE Software */
public class MetodoPagoDao {

    //==============================================================================
    public static String select_metodos_combo() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_metodospago();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<MetodoPago> categorias = new ArrayList<MetodoPago>();
            while (s.rs.next()) {
                MetodoPago e = new MetodoPago();
                e.setId_metodo(s.rs.getString("id_metodo"));
                e.setMetodo(s.rs.getString("metodo"));
                categorias.add(e);
            }
            for (MetodoPago c : categorias) {
                renglones += "<option value='" + c.getId_metodo() + "'>" + c.getMetodo() + "</option>";
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
}
