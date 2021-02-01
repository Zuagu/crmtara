package callcenter.model;

import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author mac
 */
public class ModelOrganigrama {

    public static String select_organigrama() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_organigrama();";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray datos_organigrama = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject dato = new JSONObject();
                dato.put("ocupado", inicioConexion.rs.getInt("ocupados"));
                dato.put("id_puesto", inicioConexion.rs.getInt("id_puesto"));
                dato.put("puesto", inicioConexion.rs.getString("puesto"));
                dato.put("id_departamento", inicioConexion.rs.getInt("id_departamento"));
                dato.put("departamento", inicioConexion.rs.getString("departamento"));
                dato.put("vacantes", inicioConexion.rs.getInt("vacantes"));
                datos_organigrama.add(dato);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return datos_organigrama.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String select_lista_usuarios_vacantes(int id_puesto) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_select_usuarios_puesto(" + id_puesto + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray datos_organigrama = new JSONArray();
            // id, nombre, fecha_ingreso, horario, puesto
            while (inicioConexion.rs.next()) {
                JSONObject dato = new JSONObject();
                dato.put("id", inicioConexion.rs.getString("id"));
                dato.put("horario", inicioConexion.rs.getString("horario"));
                dato.put("nombre", inicioConexion.rs.getString("nombre"));
                dato.put("fecha_ingreso", inicioConexion.rs.getString("fecha_ingreso"));
                dato.put("puesto", inicioConexion.rs.getString("puesto"));
                datos_organigrama.add(dato);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return datos_organigrama.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String sic_vacantes_organigrama() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_vacantes_organigrama();";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray datos_organigrama = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject dato = new JSONObject();
                dato.put("cant_usuarios", inicioConexion.rs.getInt("cant_usuarios"));
                dato.put("id_puesto", inicioConexion.rs.getInt("id_puesto"));
                dato.put("vacantes", inicioConexion.rs.getInt("vacantes"));
                datos_organigrama.add(dato);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return datos_organigrama.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String update_numero_vancantes(int id_puesto, int vacantes) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "update sic_puestos set  vacantes =" + vacantes + " where id_puesto =" + id_puesto + ";";
            System.out.println(sql);
            inicioConexion.st.executeUpdate(sql);
            JSONObject dato = new JSONObject();
            dato.put("mensaje", "Actualizado");
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return dato.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

    public static String select_lista_gestores() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select id, nombre from arcade_usuarios where f_active = 1";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray usuarios = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject usuario = new JSONObject();
                usuario.put("id", inicioConexion.rs.getInt("id"));
                usuario.put("nombre", inicioConexion.rs.getString("nombre"));
                usuarios.add(usuario);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return usuarios.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }
    public static String select_lista_gestores_filtro(String _filtro) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "select id, nombre from arcade_usuarios where f_active = 1 and (id like '%"+_filtro+"%' or nombre like '%"+_filtro+"%')";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray usuarios = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject usuario = new JSONObject();
                usuario.put("id", inicioConexion.rs.getInt("id"));
                usuario.put("nombre", inicioConexion.rs.getString("nombre"));
                usuarios.add(usuario);
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return usuarios.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }
    
    

    public static String asignar_puesto_vacante(int id_usuario, int id_puesto) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_asignar_puesto_vacante(" + id_puesto + ", " + id_usuario + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject dato = new JSONObject();
            while (inicioConexion.rs.next()) {
                dato.put("mensaje", inicioConexion.rs.getString("resp"));
            } 
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return dato.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }
    public static String eliminar_usuario_vacante(int id_usuario, int id_puesto) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call eliminar_usuario_vacante(" + id_usuario + "," + id_puesto + ");";
            System.out.println(sql);
            inicioConexion.st.executeUpdate(sql);
            JSONObject dato = new JSONObject();
            dato.put("mensaje","Usuario Eliminado del Puesto");
            
            inicioConexion.st.close();
            inicioConexion.conn.close();
            return dato.toString();
        } catch (SQLException e) {
            return "sql code" + e.getMessage();
        }
    }

}
