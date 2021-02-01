package arcade.data;

import arcade.model.Horario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class HorarioDao {

    //==============================================================================
      public static String select_horario_user(String filtro, int f_adminstrativo) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "	u.id, \n"
                    + "    u.nombre,\n"
                    + "    ifnull(ht.descripcion,'No Tienen Horario') as horario,\n"
                    + "    ifnull(ht.entrada,'00:00:00') as entrada,\n"
                    + "    ifnull(ht.salida,'00:00:00') as salida\n"
                    + "from arcade_usuarios u \n"
                    + "	left join arcade_horarios_trabajo ht on u.id_horario = ht.id_horario\n"
                    + "where u.f_active = 1 and u.f_administrativo = "+f_adminstrativo+" and (u.nombre like '%"+filtro+"%' or u.id like '%"+filtro+"%'or ht.descripcion like '%"+filtro+"%');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            
            List<Horario> horario = new ArrayList<Horario>();
            while (s.rs.next()) {
                Horario c = new Horario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_usuario(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setDescripcion(s.rs.getString("horario"));
                c.setHora_entrada(s.rs.getString("entrada"));
                c.setHora_salida(s.rs.getString("salida"));
                horario.add(c);
            }

            renglones = ""
                    + "<table class=''><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
//                    + "<th>Id</th>"
                    + "<th style='padding-left: 5px; padding-right: 16px;'>Id</th>"
                    + "<th style='padding-left: 6px; padding-right: 175px;'>Nombre</th>"
                    + "<th style='padding-left: 0px; padding-right: 94px;'>Horario</th>"
                    + "<th style='padding-left: 0px; padding-right: 0px;'>Entrada</th>"
                    + "<th style='padding-left: 0px; padding-right: 8px;'>Salida</th>"
                    + "</tr></thead>"
                    + "<tbody>"
                    + "<tr><td colspan='5'>"
                    + "<div class='innerb'>"
                    + "<table class='striped bordered highlight'>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            for (Horario c : horario) {
                renglones += ""
                        + "<tr id='" + c.getId_usuario() + "' class='renglon1 renglon'>"
                        + "<td>" + c.getId_usuario() + "</td>"
                        + "<td class='get_usuarioName'>" + c.getNombre() + "</td>"
                        + "<td class='get_horarioName'>" + c.getDescripcion()+ "</td>"
                        + "<td>" + c.getHora_entrada()+ "</td>"
                        + "<td>" + c.getHora_salida()+ "</td>"
                        + "</tr>";
            }
            renglones += ""
                    + "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</td></tr>"
                    + "</tbody>"
                    + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
     //==============================================================================
    public static String select_horario_user_op(String filtro, int f_adminstrativo) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "	u.id, \n"
                    + "    u.nombre,\n"
                    + "    ifnull(ht.descripcion,'No Tiene Horario') as horario,\n"
                    + "    ifnull(ht.entrada,'00:00:00') as entrada,\n"
                    + "    ifnull(ht.salida,'00:00:00') as salida\n"
                    + "from arcade_usuarios u \n"
                    + "	left join arcade_horarios_trabajo ht on u.id_horario = ht.id_horario\n"
                    + "where u.f_active = 1 and u.f_administrativo = "+f_adminstrativo+" and (u.nombre like '%"+filtro+"%' or u.id like '%"+filtro+"%'or ht.descripcion like '%"+filtro+"%');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            
            List<Horario> horario = new ArrayList<Horario>();
            while (s.rs.next()) {
                Horario c = new Horario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_usuario(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setDescripcion(s.rs.getString("horario"));
                c.setHora_entrada(s.rs.getString("entrada"));
                c.setHora_salida(s.rs.getString("salida"));
                horario.add(c);
            }

            renglones = ""
                     + "<table class=''><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width:10%;'>Id</th>"
                    + "<th style='width:40%;'>Nombre</th>"
                    + "<th style='width:30%;'>Horario</th>"
                    + "<th style='width:10%;'>Entrada</th>"
                    + "<th style='width:10%;'>Salida</th>"
                    + "</tr></thead>"
                    + "<tbody class='striped bordered highlight'>"
                    + "<tr class='striped bordered highlight'><td colspan='5'>"
                    + "<div class='innerb striped bordered highlight'>"
                    + "<table class='striped bordered highlight'>"
                    + "<tbody class='striped bordered highlight'>";

            // CUEPRO DE LA TABLA
            for (Horario c : horario) {
                renglones += ""
                        + "<tr id='" + c.getId_usuario() + "' class='renglon'>"
                        + "<td>" + c.getId_usuario() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td>" + c.getDescripcion()+ "</td>"
                        + "<td>" + c.getHora_entrada()+ "</td>"
                        + "<td>" + c.getHora_salida()+ "</td>"
                        + "</tr>";
            }
            renglones += ""
                    + "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</td></tr>"
                    + "</tbody>"
                    + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }


    //==============================================================================
    public static String select_empleado(String filtro, int f_adminstrativo) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_empleado_tipo('" + filtro + "', '" + f_adminstrativo + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Horario> horario = new ArrayList<Horario>();
            while (s.rs.next()) {
                Horario c = new Horario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_usuario(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("alias"));
                horario.add(c);
            }

            renglones = "";
            // CUEPRO DE LA TABLA
            for (Horario c : horario) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getId_usuario() + "' class='check_usuario' />"
                        + "<label for='" + c.getId_usuario() + "' style='color:#000;'>" + c.getId_usuario() + "  " + c.getNombre() + "</label> <br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_horario_tabla(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_horario('" + id_usuario + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Horario> horario = new ArrayList<Horario>();
            int _cant = 0;
            while (s.rs.next()) {
                _cant++;
                Horario c = new Horario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_horario(s.rs.getInt("id_entrada"));
                c.setDia(s.rs.getString("dia"));
                c.setHora_entrada(s.rs.getString("hora_entrada"));
                c.setHora_salida(s.rs.getString("hora_salida"));
                c.setHoras_trabajadas(s.rs.getString("horas_trabajadas"));
                c.setTurno(s.rs.getString("turno"));
                horario.add(c);
            }

            if (_cant > 0) {
                renglones = ""
                        + "<table class='bordered striped highlight z-depth-2'><thead><tr>"
                        // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                        + "<th>DIA</th>"
                        + "<th>ENTRADA</th>"
                        + "<th>SALIDA</th>"
                        + "<th>TOTAL</th>"
                        + "<th>TURNO</th>"
                        + "</tr></thead>"
                        + "<tr id='0'>"
                        + "</tr>";

                // CUEPRO DE LA TABLA
                for (Horario c : horario) {
                    renglones += ""
                            + "<tr id='" + c.getId_horario() + "' class='renglon'>"
                            + "<td>" + c.getDia() + "</td>"
                            + "<td>" + c.getHora_entrada() + "</td>"
                            + "<td>" + c.getHora_salida() + "</td>"
                            + "<td>" + c.getHoras_trabajadas() + "</td>"
                            + "<td>" + c.getTurno()+ "</td>"
                            + "</tr>";
                }

                renglones += "</table>";
            } else {

                renglones = "<div class='center-align'>"
                        + "<br>"
                        + "<img src='images/e_sad-128.png' style='width:64px;'><br>"
                        + "<h5>Este empleado, aún no tiene un horario asignado.</h5>"
                        + "<h6>Registra uno con el panel de la parte izquierda.</h6>"
                        + "<br>"
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
    public static String insert_horario_admin(String id_usuario, int dia, String entrada, String salida ) {
        String[] usuarios = id_usuario.split(",");
        int i;
        try {
            StartConn s = new StartConn();
            String resultado = "";
            
            for (i = 0; i <= usuarios.length - 1; i++) {
                String sql = "call arcade_insert_horario('" + usuarios[i] + "','" + dia + "','" + entrada + "','" + salida + "');";
                s.rs = s.st.executeQuery(sql);
            }
            
            
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
    public static String insert_horario2(String id_usuario, String select_horario) {
        String[] usuarios = id_usuario.split(",");
        int i;

        try {
            StartConn s = new StartConn();
            String resultado = "";
            
            for (i = 0; i <= usuarios.length - 1; i++) {
                String sql = "call arcade_insert_horario_operativo('" + usuarios[i] + "','" + select_horario + "');";
                s.rs = s.st.executeQuery(sql);
            }
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
    //==============================================================================
    public static String select_horario_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_horario();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Horario> horario = new ArrayList<Horario>();
            while (s.rs.next()) {
                Horario e = new Horario();
                e.setId_horario(s.rs.getInt("id_horario"));
                horario.add(e);
            }
            for (Horario c : horario) {
                renglones += "<option value='" + c.getId_horario() + "'>" + c.getId_horario() + "</option>";
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
    public static List<Horario> select_horario() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_horario();";
            s.rs = s.st.executeQuery(sql);
            List<Horario> horario = new ArrayList<Horario>();
            while (s.rs.next()) {
                Horario e = new Horario();
                e.setId_horario(s.rs.getInt("id_horario"));
                horario.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return horario;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String delete_horario(int id_horario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_horario('" + id_horario + "');";
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
    public static String select_horarios_combo(String tipo) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "SELECT id_horario, descripcion FROM arcade_call.arcade_horarios_trabajo where tipo_admin = "+ tipo +";";
            s.rs = s.st.executeQuery(sql);
            List<Horario> horario = new ArrayList<Horario>();
            while (s.rs.next()) {
                Horario e = new Horario();
                e.setId_horario(s.rs.getInt("id_horario"));
                e.setDescripcion(s.rs.getString("descripcion"));
                horario.add(e);
            }
            for (Horario c : horario) {
                renglones += "<option>" + c.getDescripcion() + "</option>";
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
    public static String select_nombre_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select nombre_usuario(" + id_usuario + ") as resultado;";
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

}