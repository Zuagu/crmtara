package arcade.data;

import arcade.model.Story;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class StoryDao {

    //==============================================================================
    public static String select_story_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_story();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Story> story = new ArrayList<Story>();
            while (s.rs.next()) {
                Story c = new Story();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_story(s.rs.getInt("id_story"));
                c.setStory(s.rs.getString("story"));
                c.setDescripcion(s.rs.getString("descripcion"));
                c.setTiempo_estimado(s.rs.getString("tiempo_estimado"));
                c.setTickets(s.rs.getString("tickets"));
                story.add(c);
            }

            for (Story c : story) {
                renglones += ""
                        + "<tr id='" + c.getId_story() + "' class='renglon'>"
                        + "<td>" + c.getId_story() + "</td>"
                        + "<td>" + c.getStory() + "</td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getTickets() + "</td>"
                        + "<td>" + c.getTiempo_estimado() + "</td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_story_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_story();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Story> story = new ArrayList<Story>();
            while (s.rs.next()) {
                Story e = new Story();
                e.setId_story(s.rs.getInt("id_story"));
                e.setStory(s.rs.getString("story"));
                story.add(e);
            }
            for (Story c : story) {
                renglones += "<option value='" + c.getId_story() + "'>" + c.getStory() + "</option>";
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
    public static List<Story> select_story() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_story();";
            s.rs = s.st.executeQuery(sql);
            List<Story> story = new ArrayList<Story>();
            while (s.rs.next()) {
                Story e = new Story();
                e.setId_story(s.rs.getInt("id_story"));
                e.setStory(s.rs.getString("story"));
                story.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return story;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_story(int id_usuario, String story, String descripcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_story('" + id_usuario + "', '" + story + "', '" + descripcion + "');";
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
    public static String update_story(int id_story) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_story('" + id_story + "');";
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
    public static String delete_story(int id_story) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_story('" + id_story + "');";
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

    //==============================================================================
    public static String select_usuarios_desarrollo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuarios_desarrollo();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Story> story = new ArrayList<Story>();
            while (s.rs.next()) {
                Story e = new Story();
                e.setId_story(s.rs.getInt("id"));
                e.setStory(s.rs.getString("nombre"));
                story.add(e);
            }
            for (Story c : story) {
                renglones += "<option value='" + c.getId_story() + "'>" + c.getStory() + "</option>";
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

    public static String select_reporte_actividades(int id_usuario, String fecha, String hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_reporte_actividades ('" + id_usuario + "','" + fecha + "','" + hasta + "');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Story> story = new ArrayList<Story>();
            while (s.rs.next()) {
                Story c = new Story();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_story(s.rs.getInt("id_ticket"));
                c.setStory(s.rs.getString("ticket"));
                c.setDescripcion(s.rs.getString("comentarios"));
                c.setTiempo_estimado(s.rs.getString("tiempo_estimado"));
                c.setTiempo_real(s.rs.getString("tiempo_real"));
                story.add(c);
            }

            for (Story c : story) {
                renglones += ""
                        + "<tr id='" + c.getId_story() + "' class='renglon'>"
                        + "<td>" + c.getId_story() + "</td>"
                        + "<td>" + c.getStory() + "</td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td>" + c.getTiempo_estimado() + "</td>"
                        + "<td>" + c.getTiempo_real() + "</td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_reporte_actividades(int id_usuario, String fecha, String hasta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_reporte_actividades('" + id_usuario + "','" + fecha + "','" + hasta + "');";
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
