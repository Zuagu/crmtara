package arcade.data;

import arcade.model.CargarArchivo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class CargarArchivoDao {

    //==============================================================================
    public static String select_nombre_archivos_tabla(String filtro, int usuario_sistema) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_archivo_filtro('" + filtro + "', '" + usuario_sistema + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<CargarArchivo> cargararchivo = new ArrayList<CargarArchivo>();
            while (s.rs.next()) {
                CargarArchivo c = new CargarArchivo();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_archivo(s.rs.getInt("id_archivo"));
                c.setNombre(s.rs.getString("nombre_archivo"));
                c.setNombre_usuario(s.rs.getString("nombre"));
                cargararchivo.add(c);
            }

            renglones = ""
                    + "<table  class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th class='center-align'style='color: white; background-color: #c70314;font-size:15px;' colspan='4'>LISTA DE ARCHIVOS</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (CargarArchivo c : cargararchivo) {
                renglones += "<tr id='" + c.getId_archivo() + "'>"
                        + "<td style='width:5%'>  <i class='material-icons'>attach_file</i></td>"
                        + "<td><a href='../archivos/" + c.getNombre() + "' download>" + c.getNombre() + "</a></td>"
                        + "<td>" + c.getNombre_usuario()+ "</td>"
                        + "</tr>";
            }
            renglones += "</tbody></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String insert_cargar_archivo(String fichero, int usuario_sistema) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_nombre_archivo('" + fichero + "', '" + usuario_sistema + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
     public static String select_archivo_filtro(String filtro, int usuario_sistema) {
        try {
            StartConn s = new StartConn();
            System.out.println(filtro + usuario_sistema );
            String sql = "call arcade_select_archivo_filtro('" + filtro + "', '" + usuario_sistema + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<CargarArchivo> cargararchivo = new ArrayList<CargarArchivo>();
            while (s.rs.next()) {
                CargarArchivo c = new CargarArchivo();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_archivo(s.rs.getInt("id_archivo"));
                c.setNombre(s.rs.getString("nombre_archivo"));
                c.setNombre_usuario(s.rs.getString("nombre"));
                cargararchivo.add(c);
            }

            renglones = ""
                    + "<table  class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th class='center-align'style='color: white; background-color: #c70314;font-size:15px;' colspan='4'>LISTA DE ARCHIVOS</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (CargarArchivo c : cargararchivo) {
                renglones += "<tr>"
                        + "<td style='width:5%'>  <i class='material-icons'>attach_file</i></td>"
                        + "<td><a href='../archivos/" + c.getNombre() + "' download>" + c.getNombre() + "</a></td>"
                        + "<td>" + c.getNombre_usuario()+ "</td>"
                        + "<td style='width:5%'></td>"
                        + "</tr>";
            }
            renglones += "</tbody></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }


    //==========================================================================
    public static String insert_cargar_archivo_rh(String fichero, int usuario_sistema) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_nombre_archivo_rh('" + fichero + "', '" + usuario_sistema + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
     public static String select_archivo_filtro_rh(String filtro, int usuario_sistema) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_archivos_filtro_rh('" + filtro + "', '" + usuario_sistema + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<CargarArchivo> cargararchivo = new ArrayList<CargarArchivo>();
            while (s.rs.next()) {
                CargarArchivo c = new CargarArchivo();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_archivo(s.rs.getInt("id_archivo"));
                c.setNombre(s.rs.getString("nombre_archivo"));
                c.setNombre_usuario(s.rs.getString("nombre"));
                cargararchivo.add(c);
            }

            renglones = ""
                    + "<table  class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th class='center-align'style='color: white; background-color: #c70314;font-size:15px;' colspan='4'>LISTA DE ARCHIVOS</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (CargarArchivo c : cargararchivo) {
                renglones += "<tr>"
                        + "<td style='width:5%'>  <i class='material-icons'>attach_file</i></td>"
                        + "<td><a href='../archivosrh/" + c.getNombre() + "' download>" + c.getNombre() + "</a></td>"
                        + "<td>" + c.getNombre_usuario()+ "</td>"
                        + "<td style='width:5%'></td>"
                        + "</tr>";
            }
            renglones += "</tbody></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }


    //==============================================================================
}
