package arcade.data;

import arcade.model.Entrada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/* @author LUIS CORTEZ */
public class EntradaDao {

    //==========================================================================
    // nuevo query de entradas 
    public static String select_entrada_tabla(String fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_call.lista_entradas('" + fecha + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Entrada> entrada = new ArrayList<Entrada>();
            while (s.rs.next()) {
                Entrada c = new Entrada();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setTurno(s.rs.getString("descripcion"));
                c.setId_usuario(s.rs.getInt("id"));
                c.setUsuario(s.rs.getString("nombre"));
                c.setArea(s.rs.getString("area"));
                c.setSucursal(s.rs.getString("sucursal"));
                c.setEntrada(s.rs.getString("h_entrada"));
//                c.setSalida_comida(s.rs.getString("salida_comida"));
//                c.setEntrada_comida(s.rs.getString("entrada_comida"));
                c.setSalida(s.rs.getString("h_salida"));
//                c.setTotal(s.rs.getString("total"));
                c.setColor(s.rs.getString("status"));
                entrada.add(c);
            }

            //variables a usar
            int old_id = 0;

            renglones = ""
                    + "<table id='tabla_entradas' class='striped';><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;'>ID</th>"
                    + "<th style='text-align:left'>NOMBRE</th>"
                    + "<th style='text-align:left'>AREA</th>"
                    + "<th style='text-align:left;'>SUCURSAL</th>"
                    + "<th>TURNO</th>"
                    + "<th style='text-align:center;'>ENTRADA</th>"
                    + "<th style='text-align:center;'>SALIDA</th>"
                    + "</tr></thead><tbody>";
            // CUEPRO DE LA TABLA
            for (Entrada c : entrada) {

                if (old_id == 0 || c.getId_usuario() != old_id) {

                    renglones += ""
                            + "<tr id='" + c.getId_usuario() + "' style='cursor: pointer; background-color:" + c.getColor() + ";'>"
                            + "<td style='text-align:center;' >" + c.getId_usuario() + "</td>"
                            + "<td style='text-align:left;' >" + c.getUsuario() + "</td>"
                            + "<td style='text-align:left;' >" + c.getArea() + "</td>"
                            + "<td style='text-align:left;' >" + c.getSucursal() + "</td>"
                            + "<td>" + c.getTurno() + "</td>"
                            + "<td>" + c.getEntrada() + "</td>"
                            + "<td>" + c.getSalida() + "</td>"
                            + "</tr>";
                    old_id = c.getId_usuario();

                }

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
//    public static String select_entrada_tabla(String fecha) {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_call.arcade_select_lista_entradas('" + fecha + "');";
//            System.out.println(sql);
//            String renglones;
//            s.rs = s.st.executeQuery(sql);
//            List<Entrada> entrada = new ArrayList<Entrada>();
//            while (s.rs.next()) {
//                Entrada c = new Entrada();
//                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
//                c.setTurno(s.rs.getString("turno"));
//                c.setId_usuario(s.rs.getInt("id"));
//                c.setUsuario(s.rs.getString("alias"));
//                c.setSucursal(s.rs.getString("sucursal"));
//                c.setEntrada(s.rs.getString("entrada"));
//                c.setSalida_comida(s.rs.getString("salida_comida"));
//                c.setEntrada_comida(s.rs.getString("entrada_comida"));
//                c.setSalida(s.rs.getString("salida"));
//                c.setTotal(s.rs.getString("total"));
//                c.setColor(s.rs.getString("color"));
//                entrada.add(c);
//            }
//
//            renglones = ""
//                    + "<table id='tabla_entradas' class='striped';><thead><tr>"
//                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
//                    + "<th>TURNO</th>"
//                    + "<th style='text-align:center;'>ID</th>"
//                    + "<th style='text-align:left'>NOMBRE</th>"
//                    + "<th style='text-align:left;'>SUCURSAL</th>"
//                    + "<th style='text-align:center;'>ENTRADA</th>"
//                    + "<th style='text-align:center;'>S.COMIDA</th>"
//                    + "<th style='text-align:center;'>E.COMIDA</th>"
//                    + "<th style='text-align:center;'>SALIDA</th>"
//                    + "<th style='text-align:center;'>TOTAL</th>"
//                    + "</tr></thead><tbody>";
//
//            // CUEPRO DE LA TABLA
//            for (Entrada c : entrada) {
//                renglones += ""
//                        + "<tr id='" + c.getId_usuario() + "' style='cursor: pointer; background-color:" + c.getColor() + ";'>"
//                        + "<td>" + c.getTurno() + "</td>"
//                        + "<td style='text-align:center;' >" + c.getId_usuario() + "</td>"
//                        + "<td style='text-align:left;' >" + c.getUsuario() + "</td>"
//                        + "<td style='text-align:left;' >" + c.getSucursal() + "</td>"
//                        + "<td>" + c.getEntrada() + "</td>"
//                        + "<td>" + c.getSalida_comida() + "</td>"
//                        + "<td>" + c.getEntrada_comida() + "</td>"
//                        + "<td>" + c.getSalida() + "</td>"
//                        + "<td>" + c.getTotal() + "</td>"
//                        + "</tr>";
//            }
//            renglones += "</tbody></table>";
//
//           s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return renglones;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }

    //==============================================================================
    public static String select_entrada_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_entrada();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Entrada> entrada = new ArrayList<Entrada>();
            while (s.rs.next()) {
                Entrada e = new Entrada();
                e.setId_entrada(s.rs.getInt("id_entrada"));
                e.setEntrada(s.rs.getString("entrada"));
                entrada.add(e);
            }
            for (Entrada c : entrada) {
                renglones += "<option value='" + c.getId_entrada() + "'>" + c.getEntrada() + "</option>";
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
    public static List<Entrada> select_entrada() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_entrada();";
            s.rs = s.st.executeQuery(sql);
            List<Entrada> entrada = new ArrayList<Entrada>();
            while (s.rs.next()) {
                Entrada e = new Entrada();
                e.setId_entrada(s.rs.getInt("id_entrada"));
                e.setEntrada(s.rs.getString("entrada"));
                entrada.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return entrada;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_registro(int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_checar('" + id + "');";
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
    public static String insert_registro_2(int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_checar_2('" + id + "');";
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
    public static String select_nombre_entrada(int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_checar_1('" + id + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("res"));
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
    public static String update_entrada(int id_entrada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_entrada('" + id_entrada + "');";
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
    public static String delete_entrada(int id_entrada) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_entrada('" + id_entrada + "');";
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
    public static String select_hora_server() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select curtime() as resultado;";
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
    public static String select_reporte_entradas(int id_sucursal, int admin, String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // delcalracion de varibles 
            String sql_datos, sql_difrencia;
            // consulta para calcular la longitud de dias
            sql_difrencia = "select datediff( '" + hasta + "' , '" + desde + "' ) as dias;";
            // ejecutar la consulta y guardar el valor obtenido
            int difrencia_dias = 0;
            s.rs = s.st.executeQuery(sql_difrencia);
            System.out.println(sql_difrencia);
            while (s.rs.next()) {
                difrencia_dias = s.rs.getInt("dias");
            }
            int i = 0;
            System.out.println(difrencia_dias);

//            do {
//                i = i + 10; 
//                System.out.println("Valor de " + 1);
//            } while (difrencia_dias > i);
//            
//            difrencia_dias = i;
//            
//            difrencia_dias = i;
//            System.out.println("esta es la i" + i);
            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // obtener el dia de partida
            // ejecutar la consulta y guardar el valor obtenido
            int dia_inicio = 0;
            s.rs = s.st.executeQuery("select dayofyear('" + desde + "') as dia ");
            while (s.rs.next()) {
                dia_inicio = s.rs.getInt("dia");
            }
            System.out.println(dia_inicio);
            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //diferencia de dias para obtener la posicion exacta
            int dif_dia_pos = (dia_inicio - 2);
            System.out.println(dif_dia_pos);
//            if (dif_dia_pos < 0 ){ 
            dif_dia_pos = -1 * dif_dia_pos;
//            }else{
//                dif_dia_pos =  -1 * dif_dia_pos;
//            }
            System.out.println(dif_dia_pos);
            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // consulta para traer los datos de la tabla
            sql_datos = "call arcade_select_reporte_horarios(" + id_sucursal + ",  " + admin + ",'" + desde + "','" + hasta + "');";
            System.out.println(sql_datos);
            String renglones;
            s.rs = s.st.executeQuery(sql_datos);
            List<Entrada> entrada = new ArrayList<Entrada>();
            while (s.rs.next()) {
                Entrada c = new Entrada();
                c.setId_usuario(s.rs.getInt("id_usuario"));
                c.setUsuario(s.rs.getString("nombre"));
                c.setEntrada(s.rs.getString("hora_entrada"));
                c.setDia(s.rs.getInt("dia"));
                c.setStatus_entrada(s.rs.getInt("status_entrada"));
                c.setFecha(s.rs.getString("fecha"));
                c.setDia_semana(s.rs.getInt("dia_sem"));

                entrada.add(c);
            }
            // declaramos las variables para construir el array
            int num_filas = 0, j = 0, old_id = 0;
            i = 0;
            for (Entrada c : entrada) {
                if (old_id == 0 || c.getId_usuario() != old_id) {
                    old_id = c.getId_usuario();
                    num_filas++;
                }
            }
            // llenamos todas las columnas con falta
            String[][] datos_entrada = new String[(num_filas + 2)][(difrencia_dias + 3)];
//            System.out.println("Longitud del Array: filas: " + (num_filas+2) +" columnas:"+ (difrencia_dias+3));
            for (i = 0; i < (num_filas + 2); i++) {
                for (j = 0; j < difrencia_dias + 3; j++) {
                    datos_entrada[i][j] = (i == 0 ? "<th class='" + (j - 1) + " " + ((j - 1) > 10 ? "hide" : "") + "'></th>" : "<td class='" + (j - 1) + " " + ((j - 1) > 10 ? "hide" : "") + "'>Falta</td>");
                }
            }
//            System.out.println("valor de la resta de coincidencia: " + dif_dia_pos);
            renglones = "";
            String[] nombre_dia = {"", "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "viernes", "Sabado"};

            // VACIADO DE DATOS EN UN ARREGO DE 2 DIMENCIONES PARA SEPARAR LOS DATOS DE LOS DIAS DE LA SEMANA
            old_id = 0;
            i = 1;
            for (Entrada c : entrada) {
//                System.out.print("(" + i +" "+ (c.getDia() + dif_dia_pos) + ")- " );

//                System.out.println(old_id +" "+ c.getId_usuario());
                if (old_id == 0) {
                    // colocamos el id del usuario
                    datos_entrada[i][0] = "<td class='ajuste1'>" + Integer.toString(c.getId_usuario()) + "</td>";
                    // colocamos el nombre del usuario
                    datos_entrada[i][1] = "<td class='ajuste2'>" + c.getUsuario() + "</td>";
//                    System.out.println(c.getId_usuario() + " " +  c.getUsuario() );
                    old_id = c.getId_usuario();

                }
                datos_entrada[0][(c.getDia() + dif_dia_pos)] = "<th class='" + ((c.getDia() + dif_dia_pos) - 1) + " " + ((c.getDia() + dif_dia_pos) - 1 > 10 ? "hide" : "") + "'>" + nombre_dia[c.getDia_semana()] + "<br>" + c.getFecha() + "</th>";
                // se pone la hora de entrada 

                if (c.getId_usuario() != old_id) {
                    // colocamos el id del usuario
                    i++;
//                    System.out.println(old_id +" "+ c.getId_usuario());
//                    System.out.println("yo soy I: "+i);
                    datos_entrada[i][0] = "<td class='ajuste1'>" + Integer.toString(c.getId_usuario()) + "</td>";
                    // colocamos el nombre del usuario
                    datos_entrada[i][1] = "<td class='ajuste2'>" + c.getUsuario() + "</td>";

                    old_id = c.getId_usuario();
                }
//                System.out.println((c.getDia() + dif_dia_pos ));
                datos_entrada[i][(c.getDia() + dif_dia_pos)] = "<td class='" + ((c.getDia() + dif_dia_pos) - 1) + " " + (((c.getDia() + dif_dia_pos) - 1) > 10 ? "hide" : "") + "' style='background-color:" + (c.getStatus_entrada() == 1 ? "#00e676" : "#ffff00") + "'>" + c.getEntrada() + "</td>";

            }
//            System.out.println(i);
            renglones = "<table id='entrada_tabla' class='centered'><thead><tr>";

            datos_entrada[0][0] = "<th class='ajuste1'>Id</th>";
            datos_entrada[0][1] = "<th class='ajuste2'>Nombre</th>";

            for (j = 0; j < (difrencia_dias + 3); j++) {
                renglones += datos_entrada[0][j];
            }

            renglones += "<tbody>";
            for (i = 1; i < (num_filas + 2); i++) {
                renglones += "<tr class='row" + i + " " + (i > 4 ? "hide" : "") + "'>";
                for (j = 0; j < (difrencia_dias + 3); j++) {
//                    System.out.print(datos_entrada[i][j]); 
                    renglones += datos_entrada[i][j];
                }
                renglones += "</tr>";
//                System.out.println("");
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
        public static String select_datos_entradas(int id_sucursal, String fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_datos_entradas("+id_sucursal+", '"+fecha+"');";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            JSONArray entradas = new JSONArray();
            
            while (s.rs.next()) {
                
                JSONObject usuarios = new JSONObject();
                usuarios.put("registro", s.rs.getInt("id_registro"));
                usuarios.put("id", s.rs.getInt("id_usuario"));
                usuarios.put("nombre", s.rs.getString("usuario"));
                usuarios.put("entrada", s.rs.getString("hora_entrada"));
                usuarios.put("salida", s.rs.getString("hora_salida"));
                usuarios.put("comentario", s.rs.getString("comentario"));
                usuarios.put("status", s.rs.getString("s_entrada"));
                
                
                entradas.add(usuarios);
            }
//            System.out.println(entradas);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return entradas.toString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
        public static String insert_comentarios(String comentario, int registro) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_insert_comentario_entrada("+registro+", '"+comentario+"');";
            String renglones = "Comentario insertado";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
        public static String update_hora_emtrada(int registro, String nueva_h_entrada, String nueva_h_salida, int status) {
        try {
            StartConn s = new StartConn();
            String sql = "UPDATE arcade_asistencia SET hora_entrada = '"+nueva_h_entrada+"', hora_salida='"+nueva_h_salida+"', status_entrada = '"+status+"' WHERE (id_registro = '"+registro+"');";
            String renglones = "Hora Entrada Actualizada";
            s.st.executeUpdate(sql);
            System.out.println(sql);
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================

}
