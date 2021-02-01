package callcenter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/* @author Luis Cortez */
public class DbCallcenter {

    private static DataSource dataSource = null;

    public static Connection getConnectionPool() {
        try {
            if (dataSource == null) {
                InitialContext ic = new InitialContext();
                dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/arcade_call");
            }
            return dataSource.getConnection();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static void freeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void freeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
        }
    }

    public static void freeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException ex) {
        }
    }

    public static Connection getConexion() {
        try {
            String url = "jdbc:mysql://192.168.0.6:3306/arcade_call?autoReconnect=true";
            String usuario = "root";
            String password = "Arcade2019";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, password);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
}
