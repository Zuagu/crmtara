package arcade.data;

import arcade.model.Estado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDao {

//==============================================================================
    public static String select_estados_pais_combo(int id_pais) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_estados_pais('" + id_pais + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Estado> categorias = new ArrayList<Estado>();
            while (s.rs.next()) {
                Estado e = new Estado();
                e.setId_estado(s.rs.getInt("id_estado"));
                e.setEstado(s.rs.getString("estado"));
                categorias.add(e);
            }
            for (Estado c : categorias) {
                renglones += "<option value='" + c.getId_estado() + "'>" + c.getEstado() + "</option>";
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
} // FIN DE LA CLASE
