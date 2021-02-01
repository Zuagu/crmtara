package arcade.data;

import arcade.model.NodoOrganigrama;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class NodoOrganigramaDao {

    //==========================================================================
    public static String select_nodos_organigrama(int _id_padre) {
        try {
            StartConn s = new StartConn();
            String sql = "call org_select_nodos('" + _id_padre + "');";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<NodoOrganigrama> nodos = new ArrayList<NodoOrganigrama>();
            while (s.rs.next()) {
                NodoOrganigrama n = new NodoOrganigrama();

                n.setId_nodo(s.rs.getInt("id_nodo"));
                n.setDescripcion(s.rs.getString("descripcion"));
                n.setId_padre(s.rs.getInt("id_padre"));
                n.setHijos(s.rs.getInt("hijos"));
                n.setEstatus_vacante(s.rs.getString("estatus_vacantes"));
                n.setColor(s.rs.getString("color"));
                n.setPorcentaje_cubierto(s.rs.getString("porcentaje"));
                nodos.add(n);
            }

            for (NodoOrganigrama n : nodos) {
                renglones += "<div class='contenedor_hijos'>"
                        + "<div id='" + n.getId_nodo() + "' class='nodo'>"
                        + "<input type='text' value='" + n.getDescripcion() + "' maxlenght='45' class='alfanumerico'>"
                        + "<span style='display:none;'>" + n.getId_padre() + "</span>"
                        + "<div class='estatus_vacante' title='" + n.getPorcentaje_cubierto() + "' style='background:" + n.getColor() + "'>" + n.getEstatus_vacante() + "</div>"
                        + "</div>";
                if (n.getHijos() > 0) {
                    renglones += select_hijos(n.getId_nodo());
                }
                renglones += "</div>";
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
    public static String select_hijos(int id_padre) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql_hijos = "call org_select_nodos(" + id_padre + ");";
            System.out.println(sql_hijos + "NODOS HIJO");
            s.rs = s.st.executeQuery(sql_hijos);
            List<NodoOrganigrama> hijos = new ArrayList<NodoOrganigrama>();
            while (s.rs.next()) {
                NodoOrganigrama h = new NodoOrganigrama();
                h.setId_nodo(s.rs.getInt("id_nodo"));
                h.setDescripcion(s.rs.getString("descripcion"));
                h.setId_padre(s.rs.getInt("id_padre"));
                h.setHijos(s.rs.getInt("hijos"));
                h.setEstatus_vacante(s.rs.getString("estatus_vacantes"));
                h.setColor(s.rs.getString("color"));
                h.setPorcentaje_cubierto(s.rs.getString("porcentaje"));
                hijos.add(h);
            }
            for (NodoOrganigrama h : hijos) {
                renglones += "<div class='contenedor_hijos_not_dad'>"
                        + "<div class='union_izquierda'>"
                        + "<div id='" + h.getId_nodo() + "' class='nodo' title='0/2'>"
                        + "<input type='text' value='" + h.getDescripcion() + "' maxlenght='45' class='alfanumerico'>"
                        + "<span style='display:none;'>" + h.getId_padre() + "</span>"
                        + "<div class='estatus_vacante' title='" + h.getPorcentaje_cubierto() + "' style='background:" + h.getColor() + "'>" + h.getEstatus_vacante() + "</div>"
                        + "</div>";
                if (h.getHijos() > 0) {
                    renglones += select_hijos(h.getId_nodo());
                }
                renglones += "</div></div>";
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
    public static String insert_nodo_organigrama(String descripcion, int id_padre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_insert_nodo('" + descripcion + "','" + id_padre + "');";
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
    public static String delete_nodo_organigrama(int id_padre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_delete_nodo('" + id_padre + "');";
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
    public static String update_nodo_organigrama(int id_nodo, String descripcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_update_nodo('" + id_nodo + "', '" + descripcion + "');";
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
    public static String select_tipos_nodo() {
        try {
            StartConn s = new StartConn();
            String sql = "call org_select_tipos_nodo();";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<NodoOrganigrama> nodos = new ArrayList<NodoOrganigrama>();
            while (s.rs.next()) {
                NodoOrganigrama n = new NodoOrganigrama();

                n.setId_nodo(s.rs.getInt("id_tipo_nodo"));
                n.setDescripcion(s.rs.getString("tipo_nodo"));
                nodos.add(n);
            }

            renglones += "<table>"
                    + "<thead><tr>"
                    + "<th style='width:2%;'></th>"
                    + "<th>NOMBRE</th>"
                    //                    + "<th style='width:2%;'></th>"
                    + "</tr></thead>";
            //                    + "<tbody><tr>"
            //                    + "<td style='text-align:center;'>*</td>"
            //                    + "<td><input id='tipo_nodo_toadd' type='text' class='alfanumerico'></td>"
            //                    + "<td style='text-align:center;'><img id='insert_tipo_nodo' src='images/i_add.png' alt='' title='AGREGAR NUEVO TIPO DE NODO' style='cursor:pointer;'></td>"
            //                    + "</tr>"

            for (NodoOrganigrama n : nodos) {
                renglones += "<tr id='" + n.getId_nodo() + "'>"
                        + "<td style='text-align:center;'>" + n.getId_nodo() + "</td>"
                        + "<td>" + n.getDescripcion() + "</td>"
                        //                        + "<td style='text-align:center;cursor:pointer;'><img class='delete_tipo_nodo_organigrama' src='images/i_delete.png' alt='' title='ELIMINA TIPO DE NODO'></td>"
                        + "</tr>";
            }
            renglones += "</tbody><table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String delete_tipo_nodo_organigrama(int id_tipo_nodo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_delete_tipo_nodo_organigrama('" + id_tipo_nodo + "');";
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
    public static String insert_tipo_nodo(String tipo_nodo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_insert_tipo_nodo('" + tipo_nodo + "');";
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
    public static String select_tipos_nodo_combo() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call org_select_tipos_nodo();";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<NodoOrganigrama> nodos = new ArrayList<NodoOrganigrama>();
            while (s.rs.next()) {
                NodoOrganigrama n = new NodoOrganigrama();
                n.setId_tipo_nodo(s.rs.getInt("id_tipo_nodo"));
                n.setTipo_nodo(s.rs.getString("tipo_nodo"));
                nodos.add(n);
            }
            for (NodoOrganigrama c : nodos) {
                renglones += "<option value='" + c.getId_tipo_nodo() + "'>" + c.getTipo_nodo() + "</option>";
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
    public static String insert_contenido_tipo_nodo(int id_tipo_nodo, String descripcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_insert_contenido_tipo_nodo('" + id_tipo_nodo + "','" + descripcion + "');";
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
    public static String select_contenidos_tipo_nodo(int id_tipo_nodo) {
        try {
            StartConn s = new StartConn();
            String sql = "call org_select_contenidos_tipo_nodo('" + id_tipo_nodo + "');";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<NodoOrganigrama> nodos = new ArrayList<NodoOrganigrama>();
            while (s.rs.next()) {
                NodoOrganigrama n = new NodoOrganigrama();

                n.setId_contenido(s.rs.getInt("id_contenido"));
                n.setDescripcion(s.rs.getString("descripcion"));
                nodos.add(n);
            }

            renglones += "<table>"
                    + "<thead><tr>"
                    + "<th style='width:2%;'></th>"
                    + "<th>CONTENIDO</th>"
                    + "<th style='width:2%;'></th>"
                    + "</tr></thead>"
                    + "<tbody><tr>";
            int _cons = 1;
            for (NodoOrganigrama n : nodos) {
                renglones += "<tr id='" + n.getId_contenido() + "'>"
                        + "<td style='text-align:center;'>" + _cons + "</td>"
                        + "<td>" + n.getDescripcion() + "</td>"
                        + "<td style='text-align:center;cursor:pointer;'><img class='delete_contenido_tipo_nodo' src='images/i_delete.png' alt='' title='ELIMINA CONTENIDO DEL TIPO DE NODO'></td>"
                        + "</tr>";
                _cons++;
            }
            renglones += "</tbody><table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String delete_contenido_tipo_nodo(int id_tipo_nodo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_delete_contenido_tipo_nodo('" + id_tipo_nodo + "');";
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
    public static String insert_contenidos_nodo(int id_nodo, int id_tipo_nodo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_insert_contenidos_nodo('" + id_nodo + "','" + id_tipo_nodo + "');";
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
    public static String select_contenidos_nodo(int id_nodo) {
        try {
            StartConn s = new StartConn();
            String sql = "call org_select_contenidos_nodo('" + id_nodo + "');";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<NodoOrganigrama> nodos = new ArrayList<NodoOrganigrama>();
            while (s.rs.next()) {
                NodoOrganigrama n = new NodoOrganigrama();

                n.setId_contenido(s.rs.getInt("id"));
                n.setDescripcion(s.rs.getString("descripcion"));
                n.setContenido(s.rs.getString("contenido"));
                nodos.add(n);
            }

            renglones += "<table>"
                    + "<thead><tr>"
                    + "<th>CONTENIDOS</th>"
                    + "</tr></thead>"
                    + "<tbody><tr>";
            int _cons = 1;
            for (NodoOrganigrama n : nodos) {
                renglones += "<tr id='" + n.getId_contenido() + "'>"
                        + "<td><span style='font-weight:bold;color:red;'>" + _cons + "</span> - <span style='font-weight:bold;color:black;'>" + n.getDescripcion() + "</span><br>"
                        + "<textarea class='contenido_nodo'>" + n.getContenido() + "</textarea></td>"
                        + "</tr>";
                _cons++;
            }
            renglones += "</tbody><table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String update_contenido_nodo(int id_contenido, String contenido) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call org_update_contenido_nodo('" + id_contenido + "','" + contenido + "');";
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
