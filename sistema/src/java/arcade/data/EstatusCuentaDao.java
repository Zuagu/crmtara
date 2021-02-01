package arcade.data;

import arcade.model.EstatusCuenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class EstatusCuentaDao {

    //==========================================================================
    public static String select_estatus_cuenta_cliente_tabla(int id_cliente) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_cuenta_cliente('" + id_cliente + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta c = new EstatusCuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setDescripcion(s.rs.getString("descripcion"));
                estatus_cuenta.add(c);
            }

            renglones = ""
                    + "<table id='tabla_estatus_cliente'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%';>ID</th>"
                    + "<th>ESTATUS (ABREVIADO)</th>"
                    + "<th>DESCRIPCION</th>"
                    + "<th></th>"
                    //                    + "<th>ORDEN</th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_productos_estatus_cuenta'>*</a></td>"
                    + "<td><input id='estatus_cuenta_insert' class='alfanumerico' type='text'></td>"
                    + "<td><input id='descripcion_insert' class='alfanumerico' type='text'></td>"
                    + "<td style='width: 2%;'><a id='insert_estatus_cuenta' href='#'><img src='images/i_add.png'/></a></td>"
                    + "</tr><tbody id='estatus_disponibles'>";

            // CUEPRO DE LA TABLA
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += ""
                        + "<tr id='" + c.getId_estatus_cuenta() + "'>"
                        + "<td><input class='agregado' type='checkbox'></td>"
                        + "<td>" + c.getEstatus_cuenta() + "</td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td style='width: 2%;'><a class='delete_estatus_cuenta' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_estatus_cuenta_cliente_tabla2(int id_cliente) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_cuenta_cliente('" + id_cliente + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta c = new EstatusCuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setDescripcion(s.rs.getString("descripcion"));
                estatus_cuenta.add(c);
            }

            renglones = ""
                    + "<table id='tabla_estatus_cliente'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 7%';></th>"
                    + "<th style='width: 2%';>ID</th>"
                    + "<th>ESTATUS</th>"
                    + "<th>DESCRIPCION</th>"
                    + "<th></th>"
                    //                    + "<th>ORDEN</th>"
                    + "</tr></thead><tbody id='estatus_disponibles'>";

            // CUEPRO DE LA TABLA
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += ""
                        + "<tr id='" + c.getId_estatus_cuenta() + "'>"
                        + "<td><input class='agregado' type='checkbox' style='cursor:pointer;'></td>"
                        + "<td>" + c.getId_estatus_cuenta() + "</td>"
                        + "<td class='abreviado'><b>" + c.getEstatus_cuenta() + "</b></td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td style='width: 2%;'><a class='delete_estatus_cuenta' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_estatus_cuenta_cliente_tabla3(int id_cliente) {
        // Este formato es para la edicion de los distintos estatus a los que puede brincar el actual estatus...
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_cuenta_cliente('" + id_cliente + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta c = new EstatusCuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setDescripcion(s.rs.getString("descripcion"));
                c.setEstatus_posibles(s.rs.getString("estatus_posibles"));
                estatus_cuenta.add(c);
            }

            renglones = ""
                    + "<table id='tabla_estatus_cliente'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%';>ID</th>"
                    + "<th style='width: 7%';></th>"
                    + "<th style='width: 7%';><input id='agregado_todos' type='checkbox' style='cursor:pointer;'></th>"
                    + "<th>ESTATUS</th>"
                    + "<th>DESCRIPCION</th>"
                    + "<th style='width:50%;'>PUEDE CAMBIAR A...</th>"
                    + "<th></th>"
                    + "</tr>"
                    + "<tr>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td><input id='estatus_cuenta_insert' type='text' class='alfanumerico'></td>"
                    + "<td><input id='descripcion_insert' type='text' class='alfanumerico'></td>"
                    + "<td></td>"
                    + "<td><a id='insert_estatus_cuenta' href='#'><img src='images/i_add.png'/></a></td>"
                    + "</tr></thead><tbody id='estatus_disponibles'>";

            // CUEPRO DE LA TABLA
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += ""
                        + "<tr id='" + c.getId_estatus_cuenta() + "'>"
                        + "<td>" + c.getId_estatus_cuenta() + "</td>"
                        + "<td><input name='para_editar' class='editar_estatus_nivel' type='radio' style='cursor:pointer;'></td>"
                        + "<td><input class='agregado' type='checkbox' style='cursor:pointer;'></td>"
                        + "<td class='abreviado'><b>" + c.getEstatus_cuenta() + "</b></td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td>" + c.getEstatus_posibles() + "<input class='estatus_detallado' type='hidden' value='<option class=\"select_eyc\" value=\"" + c.getId_estatus_cuenta() + "\">" + c.getEstatus_cuenta() + " (" + c.getDescripcion() + ")</option>'></td>"
                        + "<td style='width: 2%;'><a class='delete_estatus_cuenta' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_estatus_cuenta_tabla(int id_cliente) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_cuenta('" + id_cliente + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta c = new EstatusCuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setDescripcion(s.rs.getString("descripcion"));
                estatus_cuenta.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>ESTATUS (ABREVIADO)</th>"
                    + "<th>DESCRIPCION</th>"
                    + "<th></th>"
                    //                    + "<th>ORDEN</th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_productos_estatus_cuenta'>*</a></td>"
                    + "<td><input id='estatus_cuenta_insert' class='alfanumerico' type='text'></td>"
                    + "<td><input id='descripcion_insert' class='alfanumerico' type='text'></td>"
                    + "<td><a id='insert_estatus_cuenta' href='#'><img src='images/i_add.png'/></a></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += ""
                        + "<tr id='" + c.getId_estatus_cuenta() + "'>"
                        + "<td><input type='checkbox'></td>"
                        + "<td>" + c.getEstatus_cuenta() + "</td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td style='width: 2%'><a class='delete_estatus_cuenta' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_estatus_puesto_tabla(int id_puesto) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_puesto('" + id_puesto + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta c = new EstatusCuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                estatus_cuenta.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>DESCRIPCION</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += ""
                        + "<tr id='" + c.getId_estatus_cuenta() + "'>"
                        + "<td>" + c.getId_estatus_cuenta() + "</td>"
                        + "<td>" + c.getEstatus_cuenta() + "</td>"
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
    public static String select_estatus_cuenta_combo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_estatus_cuenta('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta e = new EstatusCuenta();
                e.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                e.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                e.setDescripcion(s.rs.getString("descripcion"));
                estatus_cuenta.add(e);
            }
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += "<option style='padding-bottom: 3px;font-weight:bold;font-size:16px;' value='" + c.getId_estatus_cuenta() + "'>" + c.getEstatus_cuenta() + " (" + c.getDescripcion() + ")</option>";
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
    public static String select_estatus_cuenta_cuenta_combo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_estatus_cuenta_cuenta_combo('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta e = new EstatusCuenta();
                e.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                e.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                e.setDescripcion(s.rs.getString("descripcion"));
                estatus_cuenta.add(e);
            }
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += "<option style='padding-bottom: 3px;font-weight:bold;font-size:16px;' value='" + c.getId_estatus_cuenta() + "'>" + c.getEstatus_cuenta() + " (" + c.getDescripcion() + ")</option>";
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
    public static String select_estatus_puesto_combo(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_estatus_puesto_combo('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta e = new EstatusCuenta();
                e.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                e.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                e.setDescripcion(s.rs.getString("descripcion"));
                estatus_cuenta.add(e);
            }
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += "<option class='select_eyc' value='" + c.getId_estatus_cuenta() + "'>" + c.getEstatus_cuenta() + " (" + c.getDescripcion() + ")</option>";
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
    public static List<EstatusCuenta> select_estatus_cuenta() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_estatus_cuenta();";
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta e = new EstatusCuenta();
                e.setId_estatus_cuenta(s.rs.getInt("id_estatus_cuenta"));
                e.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                estatus_cuenta.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return estatus_cuenta;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_estatus_cuenta(String estatus_cuenta, String descripcion, int id_cliente) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_estatus_cuenta('" + estatus_cuenta + "', '" + descripcion + "', '" + id_cliente + "');";
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
    public static String update_estatus_cuenta(int id_estatus_cuenta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_estatus_cuenta('" + id_estatus_cuenta + "');";
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
    public static String delete_estatus_cuenta(int id_estatus_cuenta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_estatus_cuenta('" + id_estatus_cuenta + "');";
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
    public static String insert_estatus_puesto(int id_puesto, String estatus) {
        try {
            StartConn s = new StartConn();

            // ELIMINAMOS LA ULTIMA ","
//            estatus = estatus.substring(0, estatus.length() - 1);
            estatus = estatus.substring(0, estatus.length() - 2); // SE QUITAN DOS POR ", " [Espacio y coma]
            System.out.println(estatus);
            String resultado = "";
            String eliminar_estatus_puesto = "call arcade_delete_estatus_puesto('" + id_puesto + "');";
            System.out.println(eliminar_estatus_puesto);

            String insert = "INSERT INTO arcade_estatus_cuenta_puesto(id_puesto, id_estatus_cuenta) values " + estatus;
            System.out.println(insert);
            String sql = "call arcade_select_estatus_puesto_cant('" + id_puesto + "');";
            System.out.println(sql);

            s.st.executeUpdate(eliminar_estatus_puesto);
            s.st.executeUpdate(insert);

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

    public static String select_estatus_cuenta_tabla(String cad1, String cad2, String cad3, String cad4, int resto, String tiene_cr) {
        try {
            StartConn s = new StartConn();
            String sql = "select\n"
                    + "nombre_region(id_region) as region,\n"
                    + "ultimo_estatus_cuenta as id_estatus,\n"
                    + "nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus,\n"
                    + "format(count(1),0) as cuentas,\n"
                    + "format(sum(resto),2) as valor,\n"
                    + "min(ultima_gestion) as promedio,\n"
                    + "datediff(curdate(), min(ultima_gestion)) as dias,\n"
                    + "grupo_estatus_cuenta(ultimo_estatus_cuenta) as grupo,\n"
                    + "'' as color \n"
                    + "from arcade_basegeneral\n"
                    + "where f_active = 1\n"
                    + "and id_cliente in(" + cad1 + ")\n"
                    + "and id_region in(" + cad2 + ")\n"
                    + "and id_asignacion in(" + cad3 + ")\n"
                    + "and id_equipo in(" + cad4 + ")\n"
                    + "and resto >= " + resto + " and tiene_cr = " + tiene_cr + "\n"
                    + "group by ultimo_estatus_cuenta,id_region "
                    + "union all \n"
                    //==================================================================

                    + "select\n"
                    + "'TOTAL ' as region,\n"
                    + "'' as id_estatus,\n"
                    + "'' as estatus,\n"
                    + "format(count(columna1) ,0)as cuentas,\n"
                    + "format(sum(resto),2) valor,\n"
                    + "grupo_estatus_cuenta(ultimo_estatus_cuenta) as promedio,\n"
                    + "'' as dias,\n"
                    + "grupo_estatus_cuenta(ultimo_estatus_cuenta) as grupo,\n"
                    + "'background-color: #bfbfbf; color: #FFF !important;' as color \n"
                    + "from arcade_basegeneral\n"
                    + "where f_active = 1\n"
                    + "and id_cliente in(" + cad1 + ")\n"
                    + "and id_region in(" + cad2 + ")\n"
                    + "and id_asignacion in(" + cad3 + ")\n"
                    + "and id_equipo in(" + cad4 + ")\n"
                    + "and resto >= " + resto + " and tiene_cr = " + tiene_cr + "\n"
                    + "group by grupo union all select\n"
                    + "'TOTAL CARTERA' as region,\n"
                    + "'' as id_estatus,\n"
                    + "'' as estatus,\n"
                    + "format (count(columna1),0)as cuentas,\n"
                    + "format(sum(resto),2) valor,\n"
                    + "'' as promedio,\n"
                    + "'' as dias,\n"
                    + "'z' as grupo,\n"
                    + "'background-color: #bfbfbf; color: #FFF !important;' as color \n"
                    + "from arcade_basegeneral\n"
                    + "where f_active = 1\n"
                    + "and id_cliente in(" + cad1 + ")\n"
                    + "and id_region in(" + cad2 + ")\n"
                    + "and id_asignacion in(" + cad3 + ")\n"
                    + "and id_equipo in(" + cad4 + ")\n"
                    + "and resto >= " + resto + " and tiene_cr = " + tiene_cr + " \n"
                    + "order by grupo,estatus,cuentas desc;\n";
            String renglones;
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta c = new EstatusCuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region"));
                c.setId_estatus_cuenta(s.rs.getInt("id_estatus"));
                c.setEstatus_cuenta(s.rs.getString("estatus"));
                c.setCuentas(s.rs.getInt("cuentas"));
                c.setValor(s.rs.getString("valor"));
                c.setPromedio(s.rs.getString("promedio"));
                c.setDias(s.rs.getInt("dias"));
                c.setColor(s.rs.getString("color"));
                estatus_cuenta.add(c);
            }

            renglones = ""
                    + "<table id='resultado_saldos_estatus'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;width:5%;' class='ds'><input id='check_id_estatus_todos' type='checkbox' style='cursor:pointer;' ></th>"
                    + "<th style='text-align:center;'>REGION</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>CUENTAS</th>"
                    + "<th style='text-align:center;'>VALOR</th>"
                    + "<th style='text-align:center;'>ULTIMO TOQUE ESTATUS</th>"
                    + "<th style='text-align:center;width:2%;' class='ds'></th>"
                    + "</tr><tbody>";
            // CUEPRO DE LA TABLA
            for (EstatusCuenta c : estatus_cuenta) {
                renglones += ""
                        + "<tr id='" + c.getId_estatus_cuenta() + "' style='" + c.getColor() + "'>"
                        + "<td style='text-align:center;font-size: 1.2rem;' class='ds'><input class='check_id_estatus' type='checkbox' style='cursor:pointer;' ></td>"
                        + "<td style='text-align:center;font-size: 1.5rem;'>" + c.getRegion() + "</td>"
                        + "<td style='text-align:center;font-size: 1.2rem;'><b>" + c.getEstatus_cuenta() + "</b></td>"
                        + "<td style='text-align:right;font-size: 1.5rem;' class='td_num_cuentas'>" + c.getCuentas() + "</td>"
                        + "<td style='text-align:right;font-size: 1.5rem;' class='td_valor_estatus'>$" + c.getValor() + "</td>"
                        + "<td style='text-align:center;font-size: 1.5rem;font-weight: bolder;color: " + (c.getDias() > 7 ? "#F14F14" : (c.getDias() > 3 ? "#EDA700" : "#31BD06")) + "'>" + c.getPromedio() + "</td>"
                        + "<td style='text-align:center;font-size: 1.5rem;font-weight: bolder;' class='ds'><img class='ver_cuentas' src='images/i_open.png' style='cursor:pointer;'></td>"
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
    public static String select_cuentas_estatus(String a, String b, String c, String d, String e, String f, String g) {
        try {
            StartConn s = new StartConn();
            String sql = "select\n"
                    + "columna1 as cuenta,\n"
                    + "nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus,\n"
                    + "ultima_gestion\n"
                    + "from arcade_basegeneral\n"
                    + "where f_active = 1\n"
                    + "and id_cliente in (" + a + ")\n"
                    + "and id_region in (" + b + ")\n"
                    + "and id_asignacion in (" + c + ")\n"
                    + "and id_equipo in (" + d + ")\n"
                    + "and resto >= '" + e + "'\n"
                    + "and tiene_cr = " + f + "\n"
                    + "and ultimo_estatus_cuenta = " + g + "\n"
                    + "order by ultima_gestion asc;";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<EstatusCuenta> estatus_cuenta = new ArrayList<EstatusCuenta>();
            while (s.rs.next()) {
                EstatusCuenta ec = new EstatusCuenta();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                ec.setCuenta(s.rs.getString("cuenta"));
                ec.setEstatus_cuenta(s.rs.getString("estatus"));
                ec.setUltima_gestion(s.rs.getString("ultima_gestion"));
                estatus_cuenta.add(ec);
            }

            int cons = 1;
            renglones = ""
                    + "<table><thead><tr>"
                    + "<th></th>"
                    + "<th style='text-align:center;'>CUENTA</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>ULTIMA GESTION</th>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (EstatusCuenta ec : estatus_cuenta) {
                renglones += ""
                        + "<tr>"
                        + "<td style='text-align:center;'>" + cons + "</td>"
                        + "<td style='text-align:center;'>" + ec.getCuenta() + "</td>"
                        + "<td style='text-align:center;'>" + ec.getEstatus_cuenta() + "</td>"
                        + "<td style='text-align:center;'>" + ec.getUltima_gestion() + "</td>"
                        + "</tr>";

                cons++;
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

    public static String editar_puede_cambiar(int id_estatus, String puede_cambiar, String puede_cambiar_txt) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_editar_puede_cambiar('" + id_estatus + "', '" + puede_cambiar + "', '" + puede_cambiar_txt + "');";
//            System.out.println(sql);
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
    public static String select_importe_region(int region) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_grafica_datos_region('" + region + "');";
            System.out.println(result_set);
            s.rs = s.st.executeQuery(result_set);
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
    public static String select_datos_estatus_grafica(int region) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_grafica_datos_estatus('" + region + "');";
            System.out.println(result_set);
            s.rs = s.st.executeQuery(result_set);
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
    public static String select_nombre_estatus_grafica(int region) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_grafica_nombre_estatus('" + region + "');";
            System.out.println(result_set);
            s.rs = s.st.executeQuery(result_set);
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
    public static String select_grafica_datos_general(int tipo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "CALL arcade_select_datos_grafica('" + tipo + "');";
            System.out.println(result_set);
            s.rs = s.st.executeQuery(result_set);
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
    public static String select_datos_grafica_individual(int tipo1, int tipo2) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "CALL arcade_select_datos_grafica_individuales(" + tipo1 + "," + tipo2 + ");";
            System.out.println(result_set);
            s.rs = s.st.executeQuery(result_set);
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
