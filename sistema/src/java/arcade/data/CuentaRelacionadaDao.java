package arcade.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import arcade.model.CuentaRelacionada;

/**
 * @author AYCM
 */
public class CuentaRelacionadaDao {

    public static String insert_cuentarelacionada(CuentaRelacionada cuentarelacionada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_cuentarelacionada('" + cuentarelacionada.getCuenta_en_despacho() + "','" + cuentarelacionada.getTelefono() + "','" + cuentarelacionada.getEstatus() + "','" + cuentarelacionada.getNombre() + "','" + cuentarelacionada.getRfc() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR insert_cuentarelacionada";
        }
    }
//==============================================================================

    public static String update_cuentarelacionada(CuentaRelacionada cuentarelacionada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_cuentarelacionada('" + cuentarelacionada.getId_cr() + "','" + cuentarelacionada.getCuenta_en_despacho() + "','" + cuentarelacionada.getTelefono() + "','" + cuentarelacionada.getEstatus() + "','" + cuentarelacionada.getNombre() + "','" + cuentarelacionada.getRfc() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR update_cuentarelacionada";
        }
    }
//==============================================================================

    public static String delete_cuentarelacionada(CuentaRelacionada cuentarelacionada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call delete_cuentarelacionada('" + cuentarelacionada.getId_cr() + "','" + cuentarelacionada.getCuenta_en_despacho() + "','" + cuentarelacionada.getTelefono() + "','" + cuentarelacionada.getEstatus() + "','" + cuentarelacionada.getNombre() + "','" + cuentarelacionada.getRfc() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR delete_cuentarelacionada";
        }
    }
//==============================================================================

    public static List<CuentaRelacionada> select_cuentas_relacionadas(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_cuentas_relacionadas('" + cuenta + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<CuentaRelacionada> listado_crs = new ArrayList<CuentaRelacionada>();
            while (s.rs.next()) {
                CuentaRelacionada cr = new CuentaRelacionada();
                cr.setId_cr(s.rs.getInt("id_cr"));
                cr.setTelefono(s.rs.getString("telefono"));
                cr.setEstatus(s.rs.getString("estatus"));
                cr.setNombre(s.rs.getString("nombre"));
                cr.setRfc(s.rs.getString("rfc"));
                listado_crs.add(cr);
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return listado_crs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
