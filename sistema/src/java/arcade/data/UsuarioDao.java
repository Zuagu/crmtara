package arcade.data;

import arcade.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class UsuarioDao {

    //==========================================================================
    public static int iniciar_sesion(int id_perfil, int id_usuario, String password) {
        try {
            StartConn s = new StartConn();
            int resultado = 0;
            String sql = "call arcade_iniciar_sesion('" + id_perfil + "','" + id_usuario + "', '" + password + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = Integer.parseInt(s.rs.getString("resultado"));
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }
    //==========================================================================
    public static void cerrar_sesion(int id_usuario) {
        try {
            StartConn s = new StartConn();
            System.out.println("Cerrando sesion");
            String sql = "call cerrar_sesion('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            s.conn.close();
            s.rs.close();
            s.st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //==========================================================================
    public static String nombre_usuario(int id_usuario) {
        try {
            String resultado = "";
            StartConn s = new StartConn();
            String sql = "call arcade_nombre_usuario('" + id_usuario + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String color() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_color();";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String franjaindex() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_franjaindex();";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String color_menu() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_colormenu();";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================

    public static String nombre_cliente() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_cliente();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================

    public static String jsp_puesto(int id_empleado) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_jsp_puesto(" + id_empleado + ");";
            String resultado = "";
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================

    public static String cambiar_password(int id_perfil, int id, String password0) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_cambiar_password('" + id_perfil + "','" + id + "','" + password0 + "');";
            System.out.println(sql);
            String resultado = "";
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_usuario_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuarios();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setSucursal(s.rs.getString("sucursal"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setSexo(s.rs.getString("sexo"));
                c.setTelefono(s.rs.getString("telefono"));
                c.setCelular(s.rs.getString("celular"));
                c.setEmail(s.rs.getString("email"));
                c.setJefe_inmediato(s.rs.getString("jefe_inmediato"));
                c.setActive(s.rs.getString("active"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_usuarios' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>SUCURSAL</th>"
                    + "<th>PUESTO</th>"
                    + "<th>FECHA ALTA</th>"
                    + "<th>TELEFONO</th>"
                    + "<th>CELULAR</th>"
                    + "<th>JEFE INMEDIATO</th>"
                    + "<th>ESTATUS</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr class='usuario renglon' id='" + c.getId() + "' style='cursor: pointer;'>"
                        + "<td style='text-align:center;'>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;' class='getSucursal'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPuesto() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_alta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getTelefono() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCelular() + "</td>"
                        + "<td>" + c.getJefe_inmediato() + "</td>"
                        + "<td>" + c.getActive() + "</td>"
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

    //============================tabla_nomina==================================
    public static String select_usuario_tabla_nomina() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuarios();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setSucursal(s.rs.getString("sucursal"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setSexo(s.rs.getString("sexo"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_usuarios'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>SUCURSAL</th>"
                    + "<th>PUESTO</th>"
                    + "<th>FECHA ALTA</th>"
                    + "<th>SEXO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td style='text-align:center;'>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPuesto() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_alta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getSexo() + "</td>"
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
    public static String select_usuario_filtro(String _filtro) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuario_filtro('" + _filtro + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setSucursal(s.rs.getString("sucursal"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setSexo(s.rs.getString("sexo"));
                c.setTelefono(s.rs.getString("telefono"));
                c.setCelular(s.rs.getString("celular"));
                c.setEmail(s.rs.getString("email"));
                c.setJefe_inmediato(s.rs.getString("jefe_inmediato"));
                c.setActive(s.rs.getString("active"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_usuarios' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>SUCURSAL</th>"
                    + "<th>PUESTO</th>"
                    + "<th>FECHA ALTA</th>"
                    + "<th>TELEFONO</th>"
                    + "<th>CELULAR</th>"
                    + "<th>JEFE INMEDIATO</th>"
                    + "<th>ESTATUS</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr class='usuario renglon' id='" + c.getId() + "' style='cursor: pointer;'>"
                        + "<td style='text-align:center;'>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPuesto() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_alta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getTelefono() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCelular() + "</td>"
                        + "<td>" + c.getJefe_inmediato() + "</td>"
                        + "<td>" + c.getActive() + "</td>"
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

    //==============================================================================
    public static String select_usuario_combo(int f_active) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_usuario('" + f_active + "');";
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario e = new Usuario();
                e.setId(s.rs.getInt("id"));
                e.setNombre(s.rs.getString("nombre"));
                usuario.add(e);
            }
            for (Usuario c : usuario) {
                renglones += "<option value='" + c.getId() + "'>" + c.getNombre() + "</option>";
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static List<Usuario> select_usuario() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuario();";
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario e = new Usuario();
                e.setId(s.rs.getInt("id_usuario"));
                e.setNombre(s.rs.getString("usuario"));
                usuario.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return usuario;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_usuario(String nombre, String alias, int id_sucursal, int id_puesto, int id_jefe_inmediato, String sexo, String telefono, String celular, String email
    ) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_usuario("
                    + "'" + nombre + "',"
                    + "'" + alias + "',"
                    + "'" + id_sucursal + "',"
                    + "'" + id_puesto + "',"
                    + "'" + id_jefe_inmediato + "',"
                    + "'" + sexo + "',"
                    + "'" + telefono + "',"
                    + "'" + celular + "',"
                    + "'" + email + "'"
                    + ");";
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
    public static String update_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_usuario('" + id_usuario + "');";
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
    public static String delete_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_usuario('" + id_usuario + "');";
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
    public static String select_datos_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_usuario('" + id_usuario + "');";
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

    public static String update_usuario_rrhh(int id_seleccion, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String d9, String d10, String d11) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_usuario_rrhh('" + id_seleccion + "', '" + d1 + "', '" + d2 + "', '" + d3 + "', '" + d4 + "', '" + d5 + "', '" + d6 + "', '" + d7 + "', '" + d8 + "', '" + d9 + "', '" + d10 + "','" + d11 + "');";
            System.out.println(sql);
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
    public static String select_entrada_tabla(String fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_entrada('" + fecha + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id_usuario"));
                c.setId_registro(s.rs.getInt("id_registro"));
                c.setNombre(s.rs.getString("usuario"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setSalida(s.rs.getString("salida"));
                c.setHoras(s.rs.getString("horas"));
                c.setSucursal(s.rs.getString("sucursal"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_entradas' class='striped';><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>SUCURSAL</th>"
                    + "<th style='text-align:center;'>ENTRADA</th>"
                    + "<th style='text-align:center;'>SALIDA</th>"
                    + "<th style='text-align:center;'>ID</th>"
                    + "<th style='text-align:center;'>USUARIO</th>"
                    + "<th style='text-align:center;'>TOTAL</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "' style='cursor: pointer;'>"
                        + "<td style='text-align:center;'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora() + "</td>"
                        + "<td>" + c.getSalida() + "</td>"
                        + "<td>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td>" + c.getHoras() + "</td>"
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
    public static String select_resumen_usuario() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_resumen_usuario();";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRes_titulo(s.rs.getString("titulo"));
                c.setRes_valor(s.rs.getString("valor"));
                c.setRes_imagen(s.rs.getString("imagen"));
                usuario.add(c);
            }

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += "<div class='datagrid sombra'>"
                        + "<div style='float: left; width:26%;'>"
                        + "<img src='" + c.getRes_imagen() + "' alt='' > " // Esto que eso???? revisar mañana
                        + "</div>"
                        + "<div style='float: right;width: 74%; text-align: left; padding-top: 6px;padding-left: 7px;'>"
                        + "<span style='font-size: 1.8rem; color: #9b9999;'>" + c.getRes_titulo() + "</span>"
                        + "<br>"
                        + "<input type='text' value='" + c.getRes_valor() + "' readonly style='border: none; font-size: 3rem;'> "
                        + "</div>"
                        + "</div>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================

    public static String select_inactivos_tabla_filtro(String _filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_user_inactive('" + _filtro + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "</tr></thead></tr>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "' class='agregar_gestor renglon' style='cursor:pointer;'>"
                        + "<td style='text-align:left;'>" + c.getId() + "</td>"
                        + "<td style='text-align:left;'>" + c.getNombre() + "</td>"
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
    public static String select_activos_tabla_filtro(String _filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_user_active('" + _filtro + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "</tr></thead></tr>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "' class='reasignar_gestor renglon' style='cursor:pointer;'>"
                        + "<td style='text-align:left;'>" + c.getId() + "</td>"
                        + "<td style='text-align:left;'>" + c.getNombre() + "</td>"
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
    public static String update_cargo(int id_usuario, int cargo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_cargo(" + id_usuario + "," + cargo + ");";
            System.out.println(sql);
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
    //==========================================================================
    // CONSULTA PARA MOD_USUARIOS SECCION ENTRADAS
    // traer datos para hacer un reporte de entradas para cada usuario de un mes
    public static String select_calendario_entradas(int id_usuario, String fecha) {
        fecha = fecha.replace(" ", "");
        System.out.println(fecha);
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_datos_entrada_usuario('" + id_usuario + "','" + fecha + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setFecha(s.rs.getString("fecha"));
                c.setDia_fech(s.rs.getInt("dia_fech"));
                c.setDia_sem(s.rs.getInt("dia_sem"));
                c.setDia(s.rs.getInt("dia"));
                c.setHora_entrada(s.rs.getString("hora_entrada"));
                c.setHora_llegada(s.rs.getString("hora_llegada"));
                c.setMes(s.rs.getString("mes"));
                c.setColor(s.rs.getString("color"));
                usuario.add(c);
            }

            String fechas = "", status = "";
            int limite = usuario.size(), i = 0;

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                i++;
                String datos[] = c.getFecha().split("-");
                fechas += datos[0] + ", " + datos[1] + ", " + Integer.parseInt(datos[2]) + (limite == i ? "#corte#" : "##");
                status += c.getColor() + (limite == i ? "" : "#c#");
            }

            System.out.println(fechas);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return fechas + status;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_contrato(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_datos_contrato(" + id_usuario + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            System.out.println(resultado);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    //==========================================================================
    public static String update_chunnun(
            int id_usuario,
            boolean acta,
            boolean ife,
            boolean nss,
            boolean curp,
            boolean comp_est,
            boolean comp_dom,
            boolean cartas,
            boolean fotos,
            boolean infonavit,
            boolean rfc
    ) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_chunnun('" + id_usuario + "','" + acta + "','" + ife + "','" + nss + "','" + curp + "','" + comp_est + "','" + comp_dom + "','" + cartas + "','" + fotos + "','" + infonavit + "','" + rfc + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println();
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String datos_usuarios() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select \n"
                    + "	id,\n"
                    + "    nombre,\n"
                    + "	nombre_puesto(id_puesto) as puesto,\n"
                    + "	DATE_FORMAT(date(fecha_alta), '%Y-%m-%d') as fecha_alta,\n"
                    + "    celular,\n"
                    + "    ifnull(nombre_usuario_alias(id_jefe_inmediato),'') as jefe,\n"
                    + "    if(f_active = 1, 'ACTIVO', if(f_active=2, 'BAJA DEFINITIVA', 'INACTIVO')) as active,\n"
                    + "	alias,\n"
                    + "    email,\n"
                    + "	id_sucursal,\n"
                    + "	id_puesto,\n"
                    + "    id_jefe_inmediato,\n"
                    + "	f_active,\n"
                    + "    telefono,\n"
                    + "    if(sexo = 'H','Masculino','Femenino') as sexo1,\n"
                    + "	sexo,\n"
                    + "    if(f_administrativo = 1,'Administrativo','Operativo') as tipo,\n"
                    + "	f_administrativo,\n"
                    + "    if(id_sucursal = 1,'Monterrey','Puebla') sucursal,\n"
                    + "	DATE_FORMAT(date(fecha_nacimiento), '%Y-%m-%d') f_nacimiento,\n"
                    + "	acta,\n"
                    + "	ife,\n"
                    + "	nss,\n"
                    + "	curp,\n"
                    + "	comp_est,\n"
                    + "	comp_dom,\n"
                    + "	cartas,\n"
                    + "	fotos,\n"
                    + "	infonavit,\n"
                    + "	rfc,\n"
                    + "	nombre_horario(id_horario) as horario,\n"
                    + "	suspencion,\n"
                    + "	contrato,\n"
                    + "	memorandum,\n"
                    + "	reglamento,\n"
                    + "	acta_administrativa,\n"
                    + "	ausencia_laboral,\n"
                    + "	carta_recomendacion,\n"
                    + "	constancia_laboral\n"
                    + "from arcade_usuarios where f_active in (1,0);";
            s.rs = s.st.executeQuery(sql);

            JSONArray usuarios = new JSONArray();
            //nombre, puesto, fecha_alta, celular, jefe, active, alias, email, id_sucursal, id_puesto, id_jefe_inmediato, f_active, telefono, sexo, sexo, tipo, f_administrativo, sucursal, f_nacimiento, acta, ife, nss, curp, comp_est, comp_dom, cartas, fotos, infonavit, rfc, horario, suspencion
            while (s.rs.next()) {
//                JSONArray datos = new JSONArray();
                JSONObject datos = new JSONObject();
                datos.put("id", s.rs.getInt("id"));
                datos.put("nombre", s.rs.getString("nombre"));
                datos.put("puesto", s.rs.getString("puesto"));
                datos.put("fecha_alta", s.rs.getString("fecha_alta"));
                datos.put("celular", s.rs.getString("celular"));
                datos.put("jefe", s.rs.getString("jefe"));
                datos.put("active", s.rs.getString("active"));
                datos.put("alias", s.rs.getString("alias"));
                datos.put("email", s.rs.getString("email"));
                datos.put("id_sucursal", s.rs.getString("id_sucursal"));
                datos.put("id_puesto", s.rs.getString("id_puesto"));
                datos.put("id_jefe_inmediato", s.rs.getString("id_jefe_inmediato"));
                datos.put("f_active", s.rs.getString("f_active"));
                datos.put("telefono", s.rs.getString("telefono"));
                datos.put("sexo1", s.rs.getString("sexo1"));
                datos.put("sexo", s.rs.getString("sexo"));
                datos.put("tipo", s.rs.getString("tipo"));
                datos.put("f_administrativo", s.rs.getString("f_administrativo"));
                datos.put("sucursal", s.rs.getString("sucursal"));
                datos.put("f_nacimiento", s.rs.getString("f_nacimiento"));
                datos.put("acta", s.rs.getString("acta"));
                datos.put("ife", s.rs.getString("ife"));
                datos.put("nss", s.rs.getString("nss"));
                datos.put("curp", s.rs.getString("curp"));
                datos.put("comp_est", s.rs.getString("comp_est"));
                datos.put("comp_dom", s.rs.getString("comp_dom"));
                datos.put("cartas", s.rs.getString("cartas"));
                datos.put("fotos", s.rs.getString("fotos"));
                datos.put("infonavit", s.rs.getString("infonavit"));
                datos.put("rfc", s.rs.getString("rfc"));
                datos.put("horario", s.rs.getString("horario"));
                datos.put("suspencion", s.rs.getString("suspencion"));
                datos.put("contrato", s.rs.getString("contrato"));
                datos.put("memorandum", s.rs.getString("memorandum"));
                datos.put("reglamento", s.rs.getString("reglamento"));
                datos.put("reglamento", s.rs.getString("reglamento"));
                datos.put("acta_administrativa", s.rs.getString("acta_administrativa"));
                datos.put("ausencia_laboral", s.rs.getString("ausencia_laboral"));
                datos.put("carta_recomendacion", s.rs.getString("carta_recomendacion"));
                datos.put("constancia_laboral", s.rs.getString("constancia_laboral"));

                usuarios.add(datos);
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return usuarios.toJSONString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_formato(int id, String col, String dato) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "update arcade_usuarios set " + col + "='" + dato + "' where id = " + id + ";";
            System.out.println(sql);
            s.st.executeUpdate(sql);
            renglones = "Actualizacion Exitosa";
//            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_tabla_hoario(int id) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_horario(" + id + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            JSONArray tabla = new JSONArray();
            while (s.rs.next()) {
                JSONObject datos = new JSONObject();
                datos.put("num_dia", s.rs.getString("_dia"));
                datos.put("id_entrada", s.rs.getString("id_entrada"));
                datos.put("dia", s.rs.getString("dia"));
                datos.put("hora_entrada", s.rs.getString("hora_entrada"));
                datos.put("hora_salida", s.rs.getString("hora_salida"));
                datos.put("horas_trabajadas", s.rs.getString("horas_trabajadas"));
                datos.put("turno", s.rs.getString("turno"));
                tabla.add(datos);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return tabla.toString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_lista_horarios() {
        try {
            StartConn s = new StartConn();
            String sql = "SELECT * FROM arcade_call.arcade_horarios_trabajo;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            JSONArray horario = new JSONArray();
            while (s.rs.next()) { //id_horario, descripcion, entrada, salida, salida_comida, entrada_comida, entrada_sabado, salida_sabado, tipo_admin
                JSONObject datos = new JSONObject();
                datos.put("id_horario", s.rs.getInt("id_horario"));
                datos.put("descripcion", s.rs.getString("descripcion"));
                datos.put("entrada", s.rs.getString("entrada"));
                datos.put("salida", s.rs.getString("salida"));
                datos.put("entrada_sabado", s.rs.getString("entrada_sabado"));
                datos.put("salida_sabado", s.rs.getString("salida_sabado"));
                datos.put("tipo_admin", s.rs.getInt("tipo_admin"));
                horario.add(datos);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return horario.toString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String arcade_select_puesto() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_puesto();";
            s.rs = s.st.executeQuery(sql);
            
            JSONArray lista_puestos = new JSONArray();
            while (s.rs.next()) { // , , , , , 
                
                JSONObject puesto = new JSONObject();
                puesto.put("id_puesto", s.rs.getString("id_puesto"));
                puesto.put("departamento", s.rs.getString("departamento"));
                puesto.put("puesto", s.rs.getString("puesto"));
                puesto.put("vacantes_cubiertas", s.rs.getString("vacantes_cubiertas"));
                puesto.put("vacantes", s.rs.getString("vacantes"));
                puesto.put("porcentaje", s.rs.getString("porcentaje"));
                lista_puestos.add(puesto);
            }
//            System.out.println(lista_puestos);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return lista_puestos.toString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
}
