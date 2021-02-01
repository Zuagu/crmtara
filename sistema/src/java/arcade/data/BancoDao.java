package arcade.data;

import arcade.model.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Administrator */
public class BancoDao {
//==============================================================================

    public static String select_bancos_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_bancos();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Banco> bancos = new ArrayList<Banco>();
            while (s.rs.next()) {
                Banco b = new Banco();
                b.setId_banco(s.rs.getInt("id_banco"));
                b.setBanco(s.rs.getString("banco"));
                bancos.add(b);
            }
            for (Banco b : bancos) {
                renglones += "<option value='" + b.getId_banco() + "'>" + b.getBanco() + "</option>";
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
