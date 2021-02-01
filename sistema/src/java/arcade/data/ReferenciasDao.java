package arcade.data;

//import arcade.model.Referencias;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

public class ReferenciasDao {

    //==========================================================================
    public static String insert_Referencias(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_xxyyzz('" + nombre + "');";
            s.rs = s.st.executeQuery(sql);
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
}


