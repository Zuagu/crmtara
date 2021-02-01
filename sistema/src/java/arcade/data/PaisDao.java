package arcade.data;

import arcade.model.Pais;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDao {

//==============================================================================
    public static String select_paises_combo() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_paises();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Pais> paises = new ArrayList<Pais>();
            while (s.rs.next()) {
                Pais p = new Pais();
                p.setId_pais(s.rs.getInt("id_pais"));
                p.setPais(s.rs.getString("pais"));
                paises.add(p);
            }
            for (Pais p : paises) {
                renglones += "<option value='" + p.getId_pais() + "'>" + p.getPais() + "</option>";
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================
} // FIN DE LA CLASE

