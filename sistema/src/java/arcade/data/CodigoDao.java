package arcade.data;

import arcade.data.StartConn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import arcade.model.Codigo;

/* @author PC */
public class CodigoDao {

//==============================================================================
    public static String insert_codigo(Codigo codigo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_codigo('" + codigo.getCodigo() + "','" + codigo.getDescripcion() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR insert_codigo";
        }
    }
//==============================================================================

    public static String update_codigo(Codigo codigo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_codigo('" + codigo.getId_codigo() + "','" + codigo.getCodigo() + "','" + codigo.getDescripcion() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR update_codigo";
        }
    }
//==============================================================================

    public static String delete_codigo(Codigo codigo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call delete_codigo('" + codigo.getId_codigo() + "','" + codigo.getCodigo() + "','" + codigo.getDescripcion() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR delete_codigo";
        }
    }
//==============================================================================
    public static List<Codigo> select_codigo_resultado() {
        try {
            StartConn s = new StartConn();
            String sql = "call select_codigo_resultado();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Codigo> codigo = new ArrayList<Codigo>();
            while (s.rs.next()) {
                Codigo e = new Codigo();
                e.setId_codigo(s.rs.getInt("id_codigo_resultado")); 
                e.setDescripcion(s.rs.getString("descripcion"));
                codigo.add(e);
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return codigo;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
//==============================================================================

}
