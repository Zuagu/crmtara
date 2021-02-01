package arcade.data;

import arcade.model.Cierre;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class CierreDao {

    //==============================================================================
    public static String select_cierre_tabla(int id_usuario, int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_cierre('" + id_usuario + "','" + id_asignacion + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Cierre> cierre = new ArrayList<Cierre>();
            while (s.rs.next()) {
                Cierre c = new Cierre();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setUltima_gestion(s.rs.getString("ultima_gestion"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setCodigo(s.rs.getString("codigo"));
                cierre.add(c);
            }

            renglones = ""
                    + "<table id='tabla_cierre'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>REGION</th>"
                    + "<th>ASIGNACION</th>"
                    + "<th>CUENTA</th>"
                    + "<th>ULTIMA GESTION</th>"
                    + "<th>ESTATUS</th>"
                    + "<th>CODIGO</th>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Cierre c : cierre) {
                renglones += ""
                        + "<tr>"
                        + "<td>" + c.getRegion() + "</td>"
                        + "<td>" + c.getAsignacion() + "</td>"
                        + "<td>" + c.getCuenta() + "</td>"
                        + "<td>" + c.getUltima_gestion() + "</td>"
                        + "<td>" + c.getEstatus() + "</td>"
                        + "<td>" + c.getCodigo() + "</td>"
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
}
