package arcade.data;

import arcade.model.Solicitud;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* librerias Json */
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author zuagu
 */
public class DashboardReclutadorDao {
    //==========================================================================

    public static String select_xxyyzz_tabla() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_solicitud('');";
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

    public static String select_xxyyzz_combo() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_solicitud('');";
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

    public static String select_ingresos_rango(String desde, String hasta, String opcion, int usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_ingresos_reclutador_rango('" + desde + "','" + hasta + "'," + usuario + ");";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_bajas_rango(String desde, String hasta, String opcion, int usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_bajas_reclutador_rango('" + desde + "','" + hasta + "'," + usuario + ");";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_baja"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_entrevistas_rango(String desde, String hasta, String opcion, int usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_entrevistas_reclutador_rango('" + desde + "','" + hasta + "'," + usuario + ");";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_permanencia(String desde, String hasta, String opcion, int usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_permanencia_reclutador_usuarios('" + desde + "','" + hasta + "'," + usuario + ");";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("dias_trabajados"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>DIAS TBJ</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_tabla_citados(String desde, String hasta, int usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select * from citados where id_reclutador = " + usuario + " and if('" + desde + "' = '0000-00-00', fecha = curdate() , fecha between '" + desde + "' and '" + hasta + "' ) ;";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id_cita"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha"));
                c.setMedio(s.rs.getString("medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setFecha(s.rs.getString("hora"));
                c.setCelular(s.rs.getString("contacto"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }

            resultado = ""
                    + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                    + "<th style='width:25%'>NOMBRE</th>"
                    + "<th style='width:20%'>MEDIO</th>"
                    + "<th style='width:20%'>ESP. MEDIO</th>"
                    + "<th style='width:10%'>FECHA</th>"
                    + "<th style='width:10%'>HORA</th>"
                    + "<th style='width:15%'>CONTACTO</th>"
                    + "</tr></thead>"
                    + "<tbody>"
                    + "<tr><td colspan='6'>"
                    + "<div class='inner2'>"
                    + "<table class='striped  highlight select_tr'>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            int i = 0;
            for (Solicitud c : solicitud) {
                i++;
                resultado += ""
                        + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                        + "<td style='width:25%'>" + c.getNombre() + "</td>"
                        + "<td style='width:20%'>" + c.getMedio() + "</td>"
                        + "<td style='width:20%'>" + c.getEspecifica_medio() + "</td>"
                        + "<td style='width:10%'>" + c.getFecha_alta() + "</td>"
                        + "<td style='width:10%'>" + c.getFecha() + "</td>"
                        + "<td style='width:15%'>" + c.getCelular() + "</td>"
                        + "</tr>";
            }
            resultado
                    += "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</td></tr>"
                    + "</tbody>"
                    + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_citados_rango(String desde, String hasta, String opcion, int usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select * from citados where id_reclutador = " + usuario + " and if('" + desde + "' = '0000-00-00', fecha = curdate() , fecha between '" + desde + "' and '" + hasta + "' ) ;";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id_cita"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha"));
                c.setMedio(s.rs.getString("medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setFecha(s.rs.getString("hora"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>NOMBRE</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>FECHA</th>"
                        + "<th>HORA</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                for (Solicitud c : solicitud) {

                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getFecha() + "</td>"
                            + "</tr>";
                }
                resultado += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";
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
    public static String select_grafica_entrevistas(int mes, String desde, String hasta, int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "";
            if (mes == 0) {
                sql = "select \n"
                        + " id,\n"
                        + "    contratacion,\n"
                        + "    date(fecha) as fecha,\n"
                        + "    week(fecha) as semana,\n"
                        + "    month(fecha) as mes,\n"
                        + "    year(fecha) as ano\n"
                        + "from arcade_ingresos\n"
                        + "where \n"
                        + " date(fecha) between '" + desde + "' and '" + hasta + "' and reclutador = " + id + " \n"
                        + " order by ano,semana,fecha;";
            } else {
                sql = "select id,contratacion,date(fecha) as fecha,week(fecha) as semana,month(fecha) as mes,year(fecha) as ano\n"
                        + "from arcade_ingresos where year(fecha) = year(curdate()) and reclutador = " + id + " order by ano,fecha;";
            }
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_solicitud(s.rs.getInt("id"));
                c.setContratacion(s.rs.getString("contratacion"));
                c.setFecha(s.rs.getString("fecha"));
                c.setSemana(s.rs.getInt("semana"));
                c.setMes(s.rs.getInt("mes"));
                c.setAno(s.rs.getInt("ano"));
                solicitud.add(c);
            }

            // loop para obtener la longitud de las graficas
            int semana_anterior = 100, limite_graficas = 0;

            // definimos las variables a usar
            
            int contador = 0;
            String[] desripcion = {"", ""};

            // comparador tipo de grafica que se va ha generar
            if (mes == 0) { // condicion de consulta de grafica con rango ed fechas
                for (Solicitud c : solicitud) {
                    if (c.getSemana() != semana_anterior || semana_anterior == 100) {
                        semana_anterior = c.getSemana();
                        limite_graficas++;
                    }
                }
                int[][] datos = new int[5][limite_graficas];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < limite_graficas; j++) {
                        datos[i][j] = 0;
                    }
                }
                semana_anterior = 100;
                for (Solicitud c : solicitud) {
                    if (c.getSemana() != semana_anterior || semana_anterior == 100) {
                        desripcion[0] += "Semana" + (c.getSemana() + 1) + "(" + c.getFecha() + "),";
                        semana_anterior = c.getSemana();
                        contador++;
//                    System.out.print(semana_anterior + "  ");
                    }
                    if (c.getContratacion().equals("Aprobado")) {
                        datos[0][(contador - 1)] = datos[0][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("Caido")) {
                        datos[1][(contador - 1)] = datos[1][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("No Aplica")) {
                        datos[2][(contador - 1)] = datos[2][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("No evaluado")) {
                        datos[3][(contador - 1)] = datos[3][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("Stand By")) {
                        datos[4][(contador - 1)] = datos[4][(contador - 1)] + 1;
                    }

                }
                resultado += desripcion[0];
                resultado += "#";
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < contador; j++) {
                        resultado += datos[i][j] + ",";
                    }
                    resultado += "#";
                }

            } else { // condicion por año

                for (Solicitud c : solicitud) {
                    if (c.getMes() != semana_anterior || semana_anterior == 100) {
                        semana_anterior = c.getMes();
                        limite_graficas++;
                    }

                }
                int[][] datos = new int[5][limite_graficas];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < limite_graficas; j++) {
                        datos[i][j] = 0;
                    }
                }
                semana_anterior = 100;
                for (Solicitud c : solicitud) {

                    if (c.getMes() != semana_anterior || semana_anterior == 100) {
                        desripcion[0] += "Mes " + (c.getMes()) + ",";
                        semana_anterior = c.getMes();
                        contador++;
//                    System.out.print(semana_anterior + "  ");
                    }
//                System.out.print(contador - 1);
                    if (c.getContratacion().equals("Aprobado")) {
                        datos[0][(contador - 1)] = datos[0][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("Caido")) {
                        datos[1][(contador - 1)] = datos[1][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("No Aplica")) {
                        datos[2][(contador - 1)] = datos[2][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("No evaluado")) {
                        datos[3][(contador - 1)] = datos[3][(contador - 1)] + 1;
                    } else if (c.getContratacion().equals("Stand By")) {
                        datos[4][(contador - 1)] = datos[4][(contador - 1)] + 1;
                    }

                }
                resultado += desripcion[0];

                resultado += "#";

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < contador; j++) {
                        resultado += datos[i][j] + ",";
                    }
                    resultado += "#";
                }

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

    public static String insert_cita(int id, String nombre, String medio, String especifica_medio, String fecha, String hora, String desc) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call insert_cita(" + id + ", '" + nombre + "', '" + medio + "', '" + especifica_medio + "', '" + fecha + "', '" + hora + "', '" + desc + "');";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("result"));
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

}
