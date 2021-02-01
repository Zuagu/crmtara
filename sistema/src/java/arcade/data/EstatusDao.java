package arcade.data;

import arcade.data.StartConn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import arcade.model.Estatus;

public class EstatusDao {

//==============================================================================
    public static String insert_estatus(Estatus estatus) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_estatus('" + estatus.getEstatus() + "','" + estatus.getDescripcion() + "','" + estatus.getId_jerarquia() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR insert_estatus";
        }
    }
//==============================================================================

    public static String update_estatus(Estatus estatus) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_estatus('" + estatus.getId_estatus() + "','" + estatus.getEstatus() + "','" + estatus.getDescripcion() + "','" + estatus.getId_jerarquia() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR update_estatus";
        }
    }
//==============================================================================

    public static String delete_estatus(Estatus estatus) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call delete_estatus('" + estatus.getId_estatus() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR delete_estatus";
        }
    }
//==============================================================================
     public static String update_estatus_gestor(Estatus estrategia) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call update_estatus_gestor('" + estrategia.getId_usuario() + "','" + estrategia.getId_estatus() + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR update_estatus";
        }
    }
//==============================================================================
     public static String select_nombre_estatus (int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_nombre_estatus('" + id_usuario + "');";
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
            return "COMUNICARSE CON SISTEMAS. ERROR update_estatus";
        }
    }
//==============================================================================

    public static List<Estatus> select_estatus_llamada() {
        try {
            StartConn s = new StartConn();
            String sql = "call select_estatus_llamada();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Estatus> estatus = new ArrayList<Estatus>();
            while (s.rs.next()) {
                Estatus e = new Estatus();
                e.setId_estatus(s.rs.getInt("id_estatus"));
                e.setDescripcion(s.rs.getString("descripcion"));
                estatus.add(e);
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return estatus;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

//==============================================================================
    public static List<Estatus> select_estatus_llamada_puesto(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_estatus_llamada_puesto(" + id_usuario + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Estatus> estatus = new ArrayList<Estatus>();
            while (s.rs.next()) {
                Estatus e = new Estatus();
                e.setId_estatus(s.rs.getInt("id_estatus"));
                e.setDescripcion(s.rs.getString("descripcion"));
                estatus.add(e);
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return estatus;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }//==============================================================================
    public static List<Estatus> select_estatus_conexion(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call select_estatus_conexion('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Estatus> estatus = new ArrayList<Estatus>();
            while (s.rs.next()) {
                Estatus e = new Estatus();
                e.setId_estatus(s.rs.getInt("id_estatus"));
                e.setEstatus(s.rs.getString("estatus"));
                estatus.add(e);
            }
            s.st.close();
            s.rs.close();
            s.conn.close();
            return estatus;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

//==============================================================================
}
