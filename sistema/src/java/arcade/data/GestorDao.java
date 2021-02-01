package arcade.data;
 
import arcade.model.Gestor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
/* @author LUIS CORTEZ */
public class GestorDao {
 
    //==========================================================================
    public static String select_gestor_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestor();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor c = new Gestor();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestor(s.rs.getInt("id"));
                c.setGestor(s.rs.getString("nombre"));
                c.setAlias(s.rs.getString("alias"));
                c.setPuesto(s.rs.getString("descripcion"));
                gestor.add(c);
            }
 
            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    //                    + "<th>PUESTO</th>"
                    + "</tr></thead></tr>";
 
            // CUEPRO DE LA TABLA
            for (Gestor c : gestor) {
                renglones += ""
                        + "<tr id='" + c.getId_gestor() + "' class='agregar_gestor' style='cursor:pointer;'>"
                        + "<td style='text-align:right;'>" + c.getId_gestor() + "</td>"
                        + "<td>" + c.getGestor() + "</td>"
                        //                        + "<td>" + c.getPuesto() + "</td>"
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
    public static String select_gestor_tabla_control() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestor_control();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor c = new Gestor();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestor(s.rs.getInt("id"));
                c.setGestor(s.rs.getString("nombre"));
                c.setAlias(s.rs.getString("alias"));
                c.setPuesto(s.rs.getString("descripcion"));
                c.setF_active(s.rs.getInt("f_active"));
                c.setF_bloqueado(s.rs.getInt("f_bloqueado"));
                c.setEstrategia(s.rs.getString("estrategia"));
                gestor.add(c);
            }
 
            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th style='width:2%;'></th>"
                    + "<th>NOMBRE</th>"
                    + "<th>ESTRATEGIA</th>"
                    + "<th>PUESTO</th>"
                    + "</tr></thead></tr>";
 
            // CUEPRO DE LA TABLA
            for (Gestor c : gestor) {
                renglones += ""
                        + "<tr id='" + c.getId_gestor() + "' class='agregar_gestor' style='cursor:pointer;'>"
                        + "<td style='text-align:right;'>" + c.getId_gestor() + "</td>"
                        + "<td style='text-align:center;'><img class='update_f_bloqueado' src='images/candado" + c.getF_bloqueado() + ".png' alt=''></td>"
                        + "<td>" + c.getGestor() + "</td>"
                        + "<td>" + c.getEstrategia() + "</td>"
                        + "<td>" + c.getPuesto() + "</td>"
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
    public static String select_gestor_tabla_control_filtro(String filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestor_control_filtro('" + filtro + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor c = new Gestor();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestor(s.rs.getInt("id"));
                c.setGestor(s.rs.getString("nombre"));
                c.setAlias(s.rs.getString("alias"));
                c.setPuesto(s.rs.getString("descripcion"));
                c.setF_active(s.rs.getInt("f_active"));
                c.setF_bloqueado(s.rs.getInt("f_bloqueado"));
                c.setEstrategia(s.rs.getString("estrategia"));
                c.setCategoria(s.rs.getString("categoria"));
                gestor.add(c);
            }
 
            renglones = ""
                    + "<table id='listado_usuarios' class='striped bordered'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th style='width:2%;'></th>"
                    + "<th>NOMBRE</th>"
                    + "<th>ESTRATEGIA</th>"
                    + "<th>PUESTO</th>"
                    + "<th>CATEGORIA</th>"
                    + "</tr></thead></tr>";
 
            // CUEPRO DE LA TABLA
            for (Gestor c : gestor) {
                renglones += ""
                        + "<tr class='usuario renglon' id='" + c.getId_gestor() + "' class='agregar_gestor' style='cursor:pointer;'>"
                        + "<td style='text-align:right;'>" + c.getId_gestor() + "</td>"
                        + "<td style='text-align:center;'><img class='update_f_bloqueado' src='images/candado_" + c.getF_bloqueado() + ".png' alt=''></td>"
                        + "<td>" + c.getGestor() + "</td>"
                        + "<td>" + c.getEstrategia() + "</td>"
                        + "<td>" + c.getPuesto() + "</td>"
                        + "<td>" + c.getCategoria() + "</td>"
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
    public static String select_gestor_tabla_filtro(String _filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestor_filtro('" + _filtro + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor c = new Gestor();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestor(s.rs.getInt("id"));
                c.setGestor(s.rs.getString("nombre"));
                c.setAlias(s.rs.getString("alias"));
                c.setPuesto(s.rs.getString("descripcion"));
                gestor.add(c);
            }
 
            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
//                    + "<th>PUESTO</th>"
                    + "</tr></thead></tr>";
 
            // CUEPRO DE LA TABLA
            for (Gestor c : gestor) {
                renglones += ""
                        + "<tr id='" + c.getId_gestor() + "' class='agregar_gestor renglon' style='cursor:pointer;'>"
                        + "<td style='text-align:right;'>" + c.getId_gestor() + "</td>"
                        + "<td>" + c.getAlias() + "</td>"
//                        + "<td>" + c.getPuesto() + "</td>"
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
    public static String select_gestor_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_gestor();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor e = new Gestor();
                e.setId_gestor(s.rs.getInt("id_gestor"));
                e.setGestor(s.rs.getString("gestor"));
                gestor.add(e);
            }
            for (Gestor c : gestor) {
                renglones += "<option value='" + c.getId_gestor() + "'>" + c.getGestor() + "</option>";
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
    public static List<Gestor> select_gestor() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_gestor();";
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor e = new Gestor();
                e.setId_gestor(s.rs.getInt("id_gestor"));
                e.setGestor(s.rs.getString("gestor"));
                gestor.add(e);
            }
 
            s.rs.close();
            s.st.close();
            s.conn.close();
            return gestor;
        } catch (SQLException ex) {
            return null;
        }
    }
 
    //==========================================================================
    public static String insert_gestor(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_gestor('" + nombre + "');";
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
   public static String update_gestor(int id_gestor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_gestor('" + id_gestor + "');";
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
    public static String delete_gestor(int id_gestor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_gestor('" + id_gestor + "');";
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
    public static String update_f_bloqueado(int id_gestor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_f_bloqueado('" + id_gestor + "');";
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
    public static String select_gestor_panel_tabla() {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestor_panel();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor c = new Gestor();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestor(s.rs.getInt("id"));
                c.setGestor(s.rs.getString("nombre"));
                c.setAlias(s.rs.getString("alias"));
                c.setPuesto(s.rs.getString("descripcion"));
                c.setF_bloqueado(s.rs.getInt("f_bloqueado"));
                c.setSelect_cr(s.rs.getString("select_cr"));
                c.setImporte(s.rs.getInt("importe"));
                c.setCuentas(s.rs.getInt("cuentas"));
                c.setSelect_orden(s.rs.getString("select_orden"));
                c.setSelect_seguimientos(s.rs.getString("select_seguimientos"));
 
                // VALORES DE LA ESTRATEGIA
                c.setEstatus(s.rs.getString("estatus"));
                gestor.add(c);
            }
 
            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th style='width: 2%'></th>"
                    + "<th>NOMBRE</th>"
                    + "<th style='width:10%;text-align:center;'><img src='images/i_filter.png'>CON CRs?</th>"
                    + "<th style='width:6%;text-align:center;'><img src='images/dinero.png'> >=</th>"
                    + "<th style='width:10%;text-align:center;'>ORDEN RESTO</th>"
                    + "<th colspan='2' style='width:30%;text-align:center;'><img src='images/i_filter.png'>ESTATUS</th>"
                    + "<th style='width:5%;text-align:center;'><img src='images/i_star1.png'></th>"
                    + "<th style='width:4%;text-align:center;'></th>"
                    + "<th style='width:5%;text-align:center;'>CUENTAS</th>"
                    + "</tr></thead></tr>";
 
            // CUEPRO DE LA TABLA
            for (Gestor c : gestor) {
                renglones += ""
                        + "<tr id='" + c.getId_gestor() + "' class='agregar_gestor' style='cursor:pointer;'>"
                        + "<td style='text-align:right;'>" + c.getId_gestor() + "</td>"
                        + "<td style='text-align:center;'><img class='update_f_bloqueado' src='images/candado" + c.getF_bloqueado() + ".png' alt=''></td>"
                        + "<td>" + c.getAlias() + "</td>"
                        + "<td>" + c.getSelect_cr() + "</td>" // con CRS
                        + "<td><input class='update_importe_gestor' value='" + c.getImporte() + "' type='text' style='text-align:center;font-weight:bold;' class='entero'></td>" // IMPORTE Mayor o igual A
                        + "<td>" + c.getSelect_orden() + "</td>"
                        + "<td style='width:5%;'><input class='definir_estatus' type='button' value='DEFINIR' style='background:red;'></td>"
                        + "<td>" + c.getEstatus() + "</td>"
                        + "<td>" + c.getSelect_seguimientos() + "</td>"
                        + "<td><input class='estrategia_automatico' type='button' value=' * ' title='PONER A ESTE USUARIOS EN AUTOMATICO'></td>"
                        + "<td><input value='" + c.getCuentas() + "' type='text' style='font-weight:bold;text-align:center;background:transparent;border:none;' readonly></td>"
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
    public static String update_crs_gestor(int id_usuario, int f_cr) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_crs_gestor('" + id_usuario + "', '" + f_cr + "');";
            s.st.executeUpdate(sql);
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
 
    //==========================================================================
    public static String update_importe_gestor(int id_usuario, int valor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_importe_gestor('" + id_usuario + "', '" + valor + "');";
            s.st.executeUpdate(sql);
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
 
    //==========================================================================
    public static String update_orden_gestor(int id_usuario, String valor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_orden_gestor('" + id_usuario + "', '" + valor + "');";
            s.st.executeUpdate(sql);
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
 
    //==========================================================================
    public static String update_estatus_estrategia_gestor(int id_usuario, String cadena_estatus, String estatus) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_estatus_estrategia_gestor('" + id_usuario + "', '" + cadena_estatus + "', '" + estatus + "');";
            System.out.println(sql);
            s.st.executeUpdate(sql);
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
 
    //==========================================================================
    public static String update_seguimientos_gestor(int id_usuario, int f_seguimiento) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_seguimientos_gestor('" + id_usuario + "', '" + f_seguimiento + "');";
            System.out.println(sql);
            s.st.executeUpdate(sql);
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
 
    //==========================================================================
    public static String ajustes_estrategia_gestor(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_ajustes_estrategia_gestor('" + id_usuario + "');";
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
 
    public static String select_categoria_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_categoria();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Gestor> gestor = new ArrayList<Gestor>();
            while (s.rs.next()) {
                Gestor e = new Gestor();
                e.setId_categoria(s.rs.getInt("id_categoria"));
                e.setCategoria(s.rs.getString("categoria"));
                gestor.add(e);
            }
            for (Gestor c : gestor) {
                renglones += "<option value='" + c.getId_categoria() + "'>" + c.getCategoria() + "</option>";
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
 
    public static String update_categoria_gestor(int id_gestor, int id_categoria) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_categoria_gestor('" + id_gestor + "', '" + id_categoria + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
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
    public static String insert_categoria_gestor(String categoria) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "arcade_insert_categoria_gestor('" + categoria + "');";
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
    public static String delete_categoria(int id_categoria) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_categoria_gestor('" + id_categoria + "');";
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
    public static String select_gestor_convenios(String fecha_inicio, String fecha_fin, int id_gestor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_gestor_convenios('" + fecha_inicio + "', '" + fecha_fin + "', '" + id_gestor + "');";
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
    public static String select_gestor_pagos(String fecha_inicio, String fecha_fin, int id_gestor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_gestor_pagos('" + fecha_inicio + "', '" + fecha_fin + "', '" + id_gestor + "');";
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
    public static String select_gestor_fechas(String fecha_inicio, String fecha_fin, int id_gestor) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_select_gestor_fechas('" + fecha_inicio + "', '" + fecha_fin + "', '" + id_gestor + "');";
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
    public static String select_nombre_gestor(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "resultado";
            String sql = "select nombre_usuario('" + id_usuario + "');";
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
    public static String evaluar_estatus_f_bloqueado(int id_gestor) {
        try {
            StartConn s = new StartConn();
            String resultado = "resultado";
            String sql = "SELECT f_bloqueado as resultado FROM arcade_call.arcade_usuarios WHERE id = "+ id_gestor +";";
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
}