package arcade.data;

import arcade.data.StartConn;
import java.sql.SQLException;
import arcade.model.Speech;

/**
 * @author AYCM
 */
public class SpeechDao {

    public static String insert_speech(Speech speech) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_speech('" + speech.getSpeech() + "','" + speech.getId_nivel() + "');";
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
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR insert_speech";
        }
    }
//==============================================================================

    public static String update_speech(Speech speech) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_speech('" + speech.getId_speech() + "','" + speech.getSpeech() + "','" + speech.getId_nivel() + "');";
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
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR update_speech";
        }
    }
//==============================================================================

    public static String delete_speech(Speech speech) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call delete_speech('" + speech.getId_speech() + "','" + speech.getSpeech() + "','" + speech.getId_nivel() + "');";
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
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR delete_speech";
        }
    }
//==============================================================================
}
