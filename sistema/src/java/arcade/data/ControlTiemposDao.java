/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcade.data;

import arcade.data.StartConn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import arcade.model.ControlTiempos;

/**
 *
 * @author Administrador
 */
public class ControlTiemposDao {

    //==============================================================================
    public static String insert_registro_tiempo(ControlTiempos reporte) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_registro_tiempo('" + reporte.getId_gestor() + "','" + reporte.getId_tipo_registro() + "','" + reporte.getRetraso_acumulado() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR insert_registro_tiempo";
        }
    }
    //==============================================================================
}
