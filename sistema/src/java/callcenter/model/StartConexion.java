/* Lowenz Corp */
package callcenter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartConexion {

    public StartConexion() {
        try {
            conn = DbCallcenter.getConnectionPool();
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(StartConexion.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
}
