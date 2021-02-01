package arcade.data;

import arcade.model.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Luis Cortez */
public class ProductoDao {

    //==========================================================================
    public static String select_productos_categoria_tabla(int _id_categoria) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_productos_categoria(" + _id_categoria + ");";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Producto> productos = new ArrayList<Producto>();
            while (s.rs.next()) {
                Producto c = new Producto();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_producto(s.rs.getString("id_producto"));
                c.setNombre(s.rs.getString("nombre"));
                c.setDescripcion(s.rs.getString("descripcion"));
                c.setUnidadmedida(s.rs.getString("unidadmedida"));
                c.setPrecio_sin_iva(s.rs.getFloat("precio_sin_iva"));
                c.setIva(s.rs.getFloat("iva"));
                c.setPrecio(s.rs.getFloat("precio"));
                productos.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>CODIGO</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>DESCRIPCION</th>"
                    + "<th>U. MEDIDA</th>"
                    + "<th>SIN IVA</th>"
                    + "<th>IVA</th>"
                    + "<th>PRECIO</th>"
                    + "<th></th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Producto c : productos) {
                renglones += ""
                        + "<tr id='" + c.getId_producto() + "'>"
                        + "<td>" + c.getId_producto() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td>" + c.getDescripcion() + "</td>"
                        + "<td>" + c.getUnidadmedida() + "</td>"
                        + "<td>" + c.getPrecio_sin_iva() + "</td>"
                        + "<td>" + c.getIva() + "</td>"
                        + "<td>" + c.getPrecio() + "</td>"
                        + "<td style='width: 2%'><a class='delete_producto' href='#'><img src='images/i_delete.png'/></a></td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code:" + ex;
        }
    }

    //==========================================================================
    public static String select_productos_categoria_tabla_corte(int _id_categoria) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_productos_categoria_corte(" + _id_categoria + ");";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Producto> productos = new ArrayList<Producto>();
            while (s.rs.next()) {
                Producto c = new Producto();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_producto(s.rs.getString("id_producto"));
                c.setNombre(s.rs.getString("nombre"));
                c.setCalibre(s.rs.getString("calibre"));
                c.setPerimetro(s.rs.getFloat("perimetro"));
                c.setArea(s.rs.getFloat("area"));
                c.setTiempo(s.rs.getFloat("tiempo"));
                c.setPrecio(s.rs.getFloat("precio"));
                c.setInicios(s.rs.getInt("inicios"));
                c.setPeso(s.rs.getFloat("peso"));
                productos.add(c);
            }

            renglones = ""
                    + "<table id='tabla_piezas'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;'>#</th>"
                    + "<th style='text-align:center;'>NO. PARTE</th>"
                    + "<th style='text-align:center;'>CALIBRE</th>"
                    + "<th style='text-align:center;'>L. DE CORTE (In)</th>"
                    + "<th style='text-align:center;'>ÁREA(In2)</th>"
                    + "<th style='text-align:center;'>TIEMPO APROX. DE CORTE (s)</th>"
                    + "<th style='text-align:center;'>PESO (Kg)</th>"
                    + "<th style='text-align:center;'>INICIOS</th>"
                    + "<th style='text-align:center;'>PRECIO</th>"
                    + "<th style='text-align:center;'>GRAFICO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int _cons = 1;
            for (Producto c : productos) {
                renglones += ""
                        + "<tr id='" + c.getId_producto() + "'>"
                        + "<td style='text-align:center;'>" + _cons + "</td>"
                        + "<td style='text-align:left;font-weight: bold;font-size:20px;'>" + c.getId_producto() + "</td>"
                        + "<td><input class='calibre' value='" + c.getCalibre() + "' type='text' style='text-align:center;font-weight:bold;padding: 2px 0px;font-size:20px;border:none;background:transparent;'></td>"
                        + "<td><input class='perimetro flotante' value='" + c.getPerimetro() + "' type='text' style='text-align:center;font-weight:bold;padding: 2px 0px;font-size:20px;border:none;background:transparent;'></td>"
                        + "<td><input class='area flotante' value='" + c.getArea() + "' type='text' style='text-align:center;font-weight:bold;padding: 2px 0px;font-size:20px;border:none;background:transparent;'></td>"
                        + "<td><input class='tiempo flotante' value='" + c.getTiempo() + "' type='text' style='text-align:center;font-weight:bold;padding: 2px 0px;font-size:20px;border:none;background:transparent;'></td>"
                        + "<td><input class='tiempo flotante' value='" + c.getPeso() + "' type='text' style='text-align:center;font-weight:bold;padding: 2px 0px;font-size:20px;border:none;background:transparent;'></td>"
                        + "<td><input class='inicios entero' value='" + c.getInicios() + "' type='text' style='text-align:center;font-weight:bold;padding: 2px 0px;font-size:20px;border:none;background:transparent;'></td>"
                        + "<td style='text-align:center;font-weight:bold;padding: 2px 0px;font-size:20px;border:none;background:transparent;'>" + c.getPrecio() + "</td>"
                        + "<td style='text-align:center;width:20%;'><img style='max-width:400px;' src='http://metalostudio.com/files/lasercut/piezas/" + c.getId_producto() + ".jpg' title='GRAFICO' alt='Sin imagen'></td>"
                        + "</tr>";
                _cons++;
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_productos_categoria_combo(int _id_categoria) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_productos_categoria(" + _id_categoria + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Producto> categorias = new ArrayList<Producto>();
            while (s.rs.next()) {
                Producto e = new Producto();
                e.setId_producto(s.rs.getString("id_producto"));
                e.setNombre(s.rs.getString("nombre"));
                categorias.add(e);
            }
            for (Producto c : categorias) {
                renglones += "<option value='" + c.getId_producto() + "'>" + c.getNombre() + "</option>";
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
    public static String insert_producto(Producto p) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_producto("
                    + "'" + p.getId_producto() + "',"
                    + "'" + p.getId_categoria() + "',"
                    + "'" + p.getNombre() + "',"
                    + "'" + p.getDescripcion() + "',"
                    + "'" + p.getId_unidadmedida() + "',"
                    + "'" + p.getCantidad_minima() + "',"
                    + "'" + p.getId_moneda() + "',"
                    + "'" + p.getId_tasa() + "',"
                    + "'" + p.getPrecio_sin_iva() + "',"
                    + "'" + p.getIva() + "',"
                    + "'" + p.getPrecio() + "',"
                    + "'" + p.getF_comprable() + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String delete_producto(String id_producto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_producto('" + id_producto + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_calibre(String id_producto, String _measure) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_prod_update_calibre('" + id_producto + "','" + _measure + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_perimetro(String id_producto, Float _measure) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_prod_update_perimetro('" + id_producto + "','" + _measure + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_area(String id_producto, Float _measure) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_prod_update_area('" + id_producto + "','" + _measure + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_tiempo(String id_producto, Float _measure) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_prod_update_tiempo('" + id_producto + "','" + _measure + "');";
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
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_inicios(String id_producto, int _measure) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_prod_update_inicios('" + id_producto + "','" + _measure + "');";
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
            return "SQL Code: " + ex;
        }
    }
//==========================================================================
}
