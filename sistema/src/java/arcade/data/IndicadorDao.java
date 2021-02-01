package arcade.data;

import arcade.model.Indicador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class IndicadorDao {

    //==============================================================================
    public static String select_indicador_tabla(String fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_indicador('" + fecha + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Indicador> indicador = new ArrayList<Indicador>();
            while (s.rs.next()) {
                Indicador c = new Indicador();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_indicador(s.rs.getInt("id_gestor"));
                c.setIndicador(s.rs.getString("usuario"));
                c.setHora_entrada(s.rs.getString("hora_entrada"));
                c.setHora_salida(s.rs.getString("ultima_gestion"));

                c.set1A(s.rs.getString("1A"));
                c.set3A(s.rs.getString("3A"));
                c.set3E(s.rs.getString("3E"));
                c.set3D(s.rs.getString("3D"));
                c.set3B(s.rs.getString("3B"));
                c.set4A(s.rs.getString("4A"));
                c.set4B(s.rs.getString("4B"));
                c.set4C(s.rs.getString("4C"));
                c.set4D(s.rs.getString("4D"));
                c.set4F(s.rs.getString("4F"));

                c.setPorcentaje_contacto(s.rs.getString("porcentaje_contacto"));
                c.setCuentas(s.rs.getString("cuentas"));
                c.setLlamadas(s.rs.getString("llamadas"));
                c.setRetraso(s.rs.getString("retraso"));
                indicador.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>USUARIO</th>"
                    + "<th>ENTRADA</th>"
                    + "<th>SALIDA</th>"
                    + "<th>1A</th>"
                    + "<th>3A</th>"
                    + "<th>3E</th>"
                    + "<th>3D</th>"
                    + "<th>3B</th>"
                    + "<th>4A</th>"
                    + "<th>4B</th>"
                    + "<th>4C</th>"
                    + "<th>4D</th>"
                    + "<th>4F</th>"
                    + "<th style='width:5%;text-align:center;'>%</th>"
                    + "<th>CUENTAS</th>"
                    + "<th>LLAMADAS</th>"
                    + "<th>RETRASO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Indicador c : indicador) {
                renglones += ""
                        + "<tr id='" + c.getId_indicador() + "'>"
                        + "<td style='text-align:right;'>" + c.getId_indicador() + "</td>"
                        + "<td>" + c.getIndicador() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_entrada() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_salida() + "</td>"
                        + "<td style='text-align:center;'>" + c.get1A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3E() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3D() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3B() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4B() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4C() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4D() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4F() + "</td>"
                        + "<td style='text-align:right;'>" + c.getPorcentaje_contacto() + "%</td>"
                        + "<td style='text-align:center;'>" + c.getCuentas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getLlamadas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRetraso() + "</td>"
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
    public static String select_indicador_rango_tabla(String fecha, String fecha2) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_indicador_rango('" + fecha + "', '" + fecha2 + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Indicador> indicador = new ArrayList<Indicador>();
            while (s.rs.next()) {
                Indicador c = new Indicador();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_indicador(s.rs.getInt("id_gestor"));
                c.setIndicador(s.rs.getString("usuario"));
                c.setHora_entrada(s.rs.getString("hora_entrada"));
                c.setHora_salida(s.rs.getString("ultima_gestion"));

                c.set1A(s.rs.getString("1A"));
                c.set3A(s.rs.getString("3A"));
                c.set3E(s.rs.getString("3E"));
                c.set3D(s.rs.getString("3D"));
                c.set3B(s.rs.getString("3B"));
                c.set4A(s.rs.getString("4A"));
                c.set4B(s.rs.getString("4B"));
                c.set4C(s.rs.getString("4C"));
                c.set4D(s.rs.getString("4D"));
                c.set4F(s.rs.getString("4F"));

                c.setPorcentaje_contacto(s.rs.getString("porcentaje_contacto"));
                c.setCuentas(s.rs.getString("cuentas"));
                c.setLlamadas(s.rs.getString("llamadas"));
                c.setRetraso(s.rs.getString("retraso"));
                indicador.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>USUARIO</th>"
                    + "<th>ENTRADA</th>"
                    + "<th>SALIDA</th>"
                    + "<th>1A</th>"
                    + "<th>3A</th>"
                    + "<th>3E</th>"
                    + "<th>3D</th>"
                    + "<th>3B</th>"
                    + "<th>4A</th>"
                    + "<th>4B</th>"
                    + "<th>4C</th>"
                    + "<th>4D</th>"
                    + "<th>4F</th>"
                    + "<th style='width:5%;text-align:center;'>%</th>"
                    + "<th>CUENTAS</th>"
                    + "<th>LLAMADAS</th>"
                    + "<th>RETRASO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Indicador c : indicador) {
                renglones += ""
                        + "<tr id='" + c.getId_indicador() + "'>"
                        + "<td style='text-align:right;'>" + c.getId_indicador() + "</td>"
                        + "<td>" + c.getIndicador() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_entrada() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_salida() + "</td>"
                        + "<td style='text-align:center;'>" + c.get1A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3E() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3D() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3B() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4B() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4C() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4D() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4F() + "</td>"
                        + "<td style='text-align:right;'>" + c.getPorcentaje_contacto() + "%</td>"
                        + "<td style='text-align:center;'>" + c.getCuentas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getLlamadas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRetraso() + "</td>"
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
    public static String select_indicador_rango_chbk_tabla(String fecha, String fecha2) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_indicador_rango_chbk('" + fecha + "', '" + fecha2 + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Indicador> indicador = new ArrayList<Indicador>();
            while (s.rs.next()) {
                Indicador c = new Indicador();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_indicador(s.rs.getInt("id_gestor"));
                c.setIndicador(s.rs.getString("usuario"));
                c.setHora_entrada(s.rs.getString("hora_entrada"));
                c.setHora_salida(s.rs.getString("ultima_gestion"));

                c.set1A(s.rs.getString("1A"));
                c.set3A(s.rs.getString("3A"));
                c.set3E(s.rs.getString("3E"));
                c.set3D(s.rs.getString("3D"));
                c.set3B(s.rs.getString("3B"));
                c.set4A(s.rs.getString("4A"));
                c.set4B(s.rs.getString("4B"));
                c.set4C(s.rs.getString("4C"));
                c.set4D(s.rs.getString("4D"));
                c.set4F(s.rs.getString("4F"));

                c.setPorcentaje_contacto(s.rs.getString("porcentaje_contacto"));
                c.setCuentas(s.rs.getString("cuentas"));
                c.setLlamadas(s.rs.getString("llamadas"));
                c.setRetraso(s.rs.getString("retraso"));
                indicador.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>USUARIO</th>"
                    + "<th>ENTRADA</th>"
                    + "<th>SALIDA</th>"
                    + "<th>1A</th>"
                    + "<th>3A</th>"
                    + "<th>3E</th>"
                    + "<th>3D</th>"
                    + "<th>3B</th>"
                    + "<th>4A</th>"
                    + "<th>4B</th>"
                    + "<th>4C</th>"
                    + "<th>4D</th>"
                    + "<th>4F</th>"
                    + "<th style='width:5%;text-align:center;'>%</th>"
                    + "<th>CUENTAS</th>"
                    + "<th>LLAMADAS</th>"
                    + "<th>RETRASO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Indicador c : indicador) {
                renglones += ""
                        + "<tr id='" + c.getId_indicador() + "'>"
                        + "<td style='text-align:right;'>" + c.getId_indicador() + "</td>"
                        + "<td>" + c.getIndicador() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_entrada() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora_salida() + "</td>"
                        + "<td style='text-align:center;'>" + c.get1A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3E() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3D() + "</td>"
                        + "<td style='text-align:center;'>" + c.get3B() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4A() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4B() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4C() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4D() + "</td>"
                        + "<td style='text-align:center;'>" + c.get4F() + "</td>"
                        + "<td style='text-align:right;'>" + c.getPorcentaje_contacto() + "%</td>"
                        + "<td style='text-align:center;'>" + c.getCuentas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getLlamadas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRetraso() + "</td>"
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
    public static String select_indicador_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_indicador();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Indicador> indicador = new ArrayList<Indicador>();
            while (s.rs.next()) {
                Indicador e = new Indicador();
                e.setId_indicador(s.rs.getInt("id_indicador"));
                e.setIndicador(s.rs.getString("indicador"));
                indicador.add(e);
            }
            for (Indicador c : indicador) {
                renglones += "<option value='" + c.getId_indicador() + "'>" + c.getIndicador() + "</option>";
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
    public static List<Indicador> select_indicador() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_indicador();";
            s.rs = s.st.executeQuery(sql);
            List<Indicador> indicador = new ArrayList<Indicador>();
            while (s.rs.next()) {
                Indicador e = new Indicador();
                e.setId_indicador(s.rs.getInt("id_indicador"));
                e.setIndicador(s.rs.getString("indicador"));
                indicador.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return indicador;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_indicador(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_indicador('" + nombre + "');";
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
    public static String update_indicador(int id_indicador) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_indicador('" + id_indicador + "');";
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
    public static String delete_indicador(int id_indicador) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_indicador('" + id_indicador + "');";
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
}
