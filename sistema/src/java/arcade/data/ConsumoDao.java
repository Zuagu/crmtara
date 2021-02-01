package arcade.data;

import arcade.model.Consumo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class ConsumoDao {

    //==============================================================================
    public static String select_consumo_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_consumo();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Consumo> consumo = new ArrayList<Consumo>();
            while (s.rs.next()) {
                Consumo c = new Consumo();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_consumo(s.rs.getInt("id_consumo"));
                c.setConsumo(s.rs.getString("consumo"));
                consumo.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>CATEGORIA</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead>"
                    + "<tr id='0'>"
                    + "<td><a href='#' class='select_productos_consumo'>*</a></td>"
                    + "<td><input id='consumo_insert' class='alfanumerico' type='text'></td>"
                    + "<td><a id='insert_consumo' href='#'><img src='images/i_add.png'/></a></td>"
                    + "<td></td>"
                    + "</tr>";

            // CUEPRO DE LA TABLA
            for (Consumo c : consumo) {
                renglones += ""
                        + "<tr id='" + c.getId_consumo() + "'>"
                        + "<td>" + c.getId_consumo() + "</td>"
                        + "<td><a href='#' class='select_productos_consumo'>" + c.getConsumo() + "</a></td>"
                        + "<td style='width: 2%'><a class='update_consumo' href='#'><img src='images/i_edit.png'/></a></td>"
                        + "<td style='width: 2%'><a class='delete_consumo' href='#'><img src='images/i_delete.png'/></a></td>"
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
    public static String select_consumo_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_consumo();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Consumo> consumo = new ArrayList<Consumo>();
            while (s.rs.next()) {
                Consumo e = new Consumo();
                e.setId_consumo(s.rs.getInt("id_consumo"));
                e.setConsumo(s.rs.getString("consumo"));
                consumo.add(e);
            }
            for (Consumo c : consumo) {
                renglones += "<option value='" + c.getId_consumo() + "'>" + c.getConsumo() + "</option>";
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
    public static List<Consumo> select_consumo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_consumo();";
            s.rs = s.st.executeQuery(sql);
            List<Consumo> consumo = new ArrayList<Consumo>();
            while (s.rs.next()) {
                Consumo e = new Consumo();
                e.setId_consumo(s.rs.getInt("id_consumo"));
                e.setConsumo(s.rs.getString("consumo"));
                consumo.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return consumo;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_consumo(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_consumo('" + nombre + "');";
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
    public static String update_consumo(int id_consumo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_consumo('" + id_consumo + "');";
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
    public static String delete_consumo(int id_consumo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_consumo('" + id_consumo + "');";
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
    public static String importar_consumo(int _id_sucursal) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_resultado_carga_consumo();";
            String truncar_cuentas = "truncate arcade_consumo_telefonia_temp;";

            String importar = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\cdr.csv'\n"
                    + "INTO TABLE arcade_consumo_telefonia_temp \n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "IGNORE 1 ROWS\n"
                    + "(\n"
                    + "@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10)\n"
                    + "set\n"
                    + "cuenta=@col1, id_region=@col2, id_supervisor=@col3, id_usuario=@col4,"
                    + "asignacion=@col5, fecha_reactivacion=fecha_sistema(@col6), fecha_vencimiento=fecha_sistema(@col7),"
                    + "estatus=@col9, id_codigo=4, ciclo=@col8, saldo=@col10, f_active=1, estatus_original=@col9,"
                    + "f_automatico = now();\n";

            s.st.executeUpdate(truncar_cuentas);
            s.st.executeUpdate(importar);

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
}
