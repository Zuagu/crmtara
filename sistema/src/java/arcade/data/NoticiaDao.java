package arcade.data;

import java.sql.SQLException;
//==============================================================================
public class NoticiaDao {
//==============================================================================

    public static String AgendarTarea(int folio, String descripcion, String fecha, int id_responsable, int id_dependencia, int prioridad, int id_estatus, int porcentaje, String respuesta, String fecha_respuesta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_ticket(" + folio + ", '" + descripcion + "', '" + fecha + "', " + id_responsable + ",  " + id_dependencia + ", " + prioridad + ", " + id_estatus + ", " + porcentaje + ",'" + respuesta + "', '" + fecha_respuesta + "' )";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

//==============================================================================
    public static String select_noticias() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_noticias();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
//==============================================================================

}