/* Lowenz Corp */
package arcade.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartConn {

    public StartConn() {
        try {
            conn = BDCrm.getConnectionPool();
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(StartConn.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
}
