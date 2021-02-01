/* ARCADE Software Group */
package arcade.data;

import arcade.data.BDCrm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author ARCADE Software*/
public class ConexionMarcador {

    public ConexionMarcador() {
        try {
            conn = BDCrm.getConnectionPool();
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMarcador.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
}
