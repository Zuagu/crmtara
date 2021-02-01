package arcade.data;

import arcade.model.Linea;
import arcade.model.Requisicion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequisicionDao {

    //==========================================================================
    public static String select_requisiciones_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_requisiciones();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Requisicion> requisiciones = new ArrayList<Requisicion>();
            while (s.rs.next()) {
                Requisicion c = new Requisicion();
                c.setId(s.rs.getInt("id"));
                c.setUsuario(s.rs.getString("usuario"));
                c.setFecha_solicitada(s.rs.getString("fecha_solicitada"));
                c.setFecha_requerida(s.rs.getString("fecha_requerida"));
                c.setUrgente(s.rs.getString("urgente"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setUsuario_respuesta(s.rs.getString("usuario_respuesta"));
                c.setRespuesta(s.rs.getString("respuesta"));
                c.setFecha_respuesta(s.rs.getString("fecha_respuesta"));
                c.setId_pedido(s.rs.getInt("id_pedido"));
                requisiciones.add(c);
            }
            String renglones = "<table><thead><tr>"
                    + "<th style='width: 2%'>FOLIO</th>"
                    + "<th>ELABORÓ</th>"
                    + "<th>FECHA SOLICITADA</th>"
                    + "<th>FECHA REQUERIDA</th>"
                    + "<th></th>"
                    + "<th>COMENTARIOS</th>"
                    + "<th>ATIENDE REQUISICION</th>"
                    + "<th>RESPUESTA</th>"
                    + "<th>FECHA RESPUESTA</th>"
                    + "<th>PEDIDO</th>"
                    + "<th></th>"
                    + "<th></th>"
                    + "</tr></thead><tbody>";

            //CUERPO DE LA TABLA
            for (Requisicion r : requisiciones) {
                renglones += "<tr id='" + r.getId() + "'>"
                        + "<td style='text-align:center;color:red;font-weight:bold;'>" + r.getId() + "</td>"
                        + "<td title='TG MANUFACTURING'>" + r.getUsuario() + "</td>"
                        + "<td style='text-align:center;'>" + r.getFecha_solicitada() + "</td>"
                        + "<td style='text-align:center;'>" + r.getFecha_requerida() + "</td>"
                        + "<td style='text-align:center;color:red;font-weight:bold;'>" + r.getUrgente() + "</td>"
                        + "<td><textarea disabled style='width:100%;resize:none;'>" + r.getComentarios() + "</textarea></td>"
                        + "<td>" + r.getUsuario_respuesta() + "</td>"
                        + "<td><textarea disabled style='width:100%;resize:none;'>" + r.getRespuesta() + "</textarea></td>"
                        + "<td style='text-align:center;'>" + r.getFecha_respuesta() + "</td>"
                        + "<td style='text-align:center;font-weight:bold;'>" + (r.getId_pedido() > 0 ? r.getId_pedido() : "") + "</td>"
                        + "<td style='text-align:center;'><input class='insert_pedido' type='button' value='GENERAR PEDIDO'></td>"
                        + "<td style='width: 2%'><a class='select_requisicion' href='#'><img src='images/i_open.png' title='VER ARCHIVO'/></a></td>"
                        + "</tr>";
            }
            //CUERPO DE LA TABLA

            renglones = renglones + "</tbody></table>";
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_requisiciones_tabla_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_requisiciones_usuario('" + id_usuario + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Requisicion> requisiciones = new ArrayList<Requisicion>();
            while (s.rs.next()) {
                Requisicion c = new Requisicion();
                c.setId(s.rs.getInt("id"));
                c.setUsuario(s.rs.getString("usuario"));
                c.setFecha_solicitada(s.rs.getString("fecha_solicitada"));
                c.setFecha_requerida(s.rs.getString("fecha_requerida"));
                c.setUrgente(s.rs.getString("urgente"));
                c.setComentarios(s.rs.getString("comentarios"));
                c.setUsuario_respuesta(s.rs.getString("usuario_respuesta"));
                c.setRespuesta(s.rs.getString("respuesta"));
                c.setFecha_respuesta(s.rs.getString("fecha_respuesta"));
                requisiciones.add(c);
            }
            String renglones = "<table><thead><tr>"
                    + "<th style='width: 2%'>FOLIO</th>"
                    + "<th>ELABORÓ</th>"
                    + "<th>FECHA SOLICITADA</th>"
                    + "<th>FECHA REQUERIDA</th>"
                    + "<th></th>"
                    + "<th>COMENTARIOS</th>"
                    + "<th>ATIENDE REQUISICION</th>"
                    + "<th>RESPUESTA</th>"
                    + "<th>FECHA RESPUESTA</th>"
                    + "<th></th>"
                    + "</tr></thead><tbody>";

            //CUERPO DE LA TABLA
            for (Requisicion r : requisiciones) {
                renglones += "<tr id='" + r.getId() + "'>"
                        + "<td style='text-align:center;color:red;font-weight:bold;'>" + r.getId() + "</td>"
                        + "<td>" + r.getUsuario() + "</td>"
                        + "<td style='text-align:center;'>" + r.getFecha_solicitada() + "</td>"
                        + "<td style='text-align:center;'>" + r.getFecha_requerida() + "</td>"
                        + "<td style='text-align:center;'>" + r.getUrgente() + "</td>"
                        + "<td><textarea disabled style='width:100%;resize:none;'>" + r.getComentarios() + "</textarea></td>"
                        + "<td>" + r.getUsuario_respuesta() + "</td>"
                        + "<td><textarea disabled style='width:100%;resize:none;'>" + r.getRespuesta() + "</textarea></td>"
                        + "<td style='text-align:center;'>" + r.getFecha_respuesta() + "</td>"
                        + "<td style='width: 2%'><a class='select_requisicion' href='#'><img src='images/i_open.png' title='VER ARCHIVO'/></a></td>"
                        + "</tr>";
            }
            //CUERPO DE LA TABLA

            renglones = renglones + "</tbody></table>";
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String agregar_producto_requisicion(float cantidad, String id_producto) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_agregar_producto_requisicion('" + cantidad + "', '" + id_producto + "');";
            System.out.println(sql);
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
    public static String insert_requisicion(int usuario_sistema, String fecha_requerida, int f_urgente, String comentarios, String lineas_requisicion) {
        try {
            StartConn s = new StartConn();
            String id = "";
            String sql = "call arcade_insert_requisicion('" + usuario_sistema + "', '" + fecha_requerida + "','" + f_urgente + "','" + comentarios + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                id = s.rs.getString("resultado");
            }
            String sql2 = "INSERT INTO `arcade_lineas_requisicion` (`id_padre`, `cantidad`, `id_producto`) VALUES ";
            String[] ldvs = lineas_requisicion.split("#AND#");

            for (String ldv : ldvs) {
                String[] lv = ldv.split("#-#");
                sql2 = sql2 + "('" + id + "', '" + lv[0] + "', '" + lv[1] + "'),";
            }
            sql2 = sql2.substring(0, sql2.length() - 1); // Elimina la , de la ultima linea
            sql2 = sql2 + ";";
            s.st.executeUpdate(sql2);
            String resultado = id;
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_cuerpo_requisicion(int folio) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_cuerpo_requisicion('" + folio + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            ArrayList<Linea> lineas = new ArrayList<Linea>();
            while (s.rs.next()) {
                Linea l = new Linea();
                l.setCantidad((float) s.rs.getFloat("cantidad"));
                l.setId_producto(s.rs.getString("id_producto"));
                l.setUnidad(s.rs.getString("unidad"));
                l.setProducto(s.rs.getString("producto"));
                lineas.add(l);
            }
            String renglones = "<table style='border: solid 1px black;'>"
                    + "<thead><tr><th style='width: 2%;border: solid 1px black;text-align:center;'>No.</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>CANTIDAD</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>CLAVE</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>UNIDAD</th>"
                    + "<th style='border: solid 1px black;text-align:center;'>DESCRIPCION</th>"
                    + "</tr></thead><tbody>";
            int lv = 1;
            for (Linea l : lineas) {
                renglones = renglones + ""
                        + "<td style='border: solid 1px black;text-align:center;'>" + lv + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + l.getCantidad() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + l.getId_producto() + "</td>"
                        + "<td style='border: solid 1px black;text-align:center;'>" + l.getUnidad() + "</td>"
                        + "<td style='border: solid 1px black;'>" + l.getProducto() + "</td>"
                        + "</tr>";
                ++lv;
            }
            renglones = renglones + "</tbody></table>";
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_detalles_documento(int folio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_detalles_requisicion('" + folio + "');";
            System.out.println(sql);
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
}
