package arcade.data;

import arcade.model.Manual;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class ManualDao {

    //==============================================================================
    public static String select_manual(String jsp) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_manual('" + jsp + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Manual> manuales = new ArrayList<Manual>();
            while (s.rs.next()) {
                Manual m = new Manual();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                m.setTipo(s.rs.getString("tipo"));
                m.setTexto(s.rs.getString("texto"));
                manuales.add(m);
            }

            // CUEPRO DE LA TABLA
            for (Manual m : manuales) {

                if (m.getTipo().equals("imagen")) {
                    renglones += "<div class='imagen'><img src='" + m.getTexto() + "'></div>";
                } else {
                    renglones += "<div class='" + m.getTipo() + "'>" + m.getTexto() + "</div>";
                }
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
}
