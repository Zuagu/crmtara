//==============================================================================
package arcade.data;  // NOS INDICA A QUE PACKAGE PERTENECE
//==============================================================================

import arcade.model.Municipio;
//==============================================================================
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//==============================================================================

public class MunicipioDao {
//==============================================================================

    public static String select_municipios_estado_combo(int id_estado) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_municipios_estado('" + id_estado + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Municipio> municipios = new ArrayList<Municipio>();
            while (s.rs.next()) {
                Municipio e = new Municipio();
                e.setId_municipio(s.rs.getInt("id_municipio"));
                e.setMunicipio(s.rs.getString("municipio"));
                municipios.add(e);
            }
            for (Municipio c : municipios) {
                renglones += "<option value='" + c.getId_municipio() + "'>" + c.getMunicipio() + "</option>";
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
