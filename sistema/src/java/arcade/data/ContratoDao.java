package arcade.data;

import arcade.model.Contrato;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class ContratoDao {

    //==========================================================================
    public static String select_contratos_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_contratos_usuario('" + id_usuario + "');";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Contrato> contrato = new ArrayList<Contrato>();
            while (s.rs.next()) {
                Contrato c = new Contrato();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_contrato(s.rs.getInt("id_contrato"));
                contrato.add(c);
            }

            // CUEPRO DE LA TABLA
            int _cant = 0;
            for (Contrato c : contrato) {
                _cant++;
                renglones += "<div class='contrato'>" + c.getId_contrato() + ""
                        + "<img src='images/i_contract.png' style='width:96px;'></div>";
            }

            if (_cant == 0) {
                renglones += "<div style='float: left;width: 100%;'><br>Este usuario no tiene contratos registrados. Quizá te interese: "
                        + "<br><a id='mostrar_contrato_nuevo' href='#'>Agregar un contrato a este usuario</a></div>";
            } else {
                renglones += "<div style='float: left;width: 100%;'><br><a id='mostrar_contrato_nuevo' href='#'>Registrar otro contrato a este usuario</a></div>";
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
    public static String insert_contrato(int id_usuario, int id_seleccion, String fecha_inicio, String fecha_fin, String salario_diario, int horas_semana, String tipo_contrato) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_contrato("
                    + "'" + id_usuario + "',"
                    + "'" + id_seleccion + "',"
                    + "'" + fecha_inicio + "',"
                    + "'" + fecha_fin + "',"
                    + "'" + salario_diario + "',"
                    + "'" + horas_semana + "',"
                    + "'" + tipo_contrato + "'"
                    + ");";
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
//    public static String select_contrato_combo() {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_select_contrato();";
//            String renglones = "";
//            s.rs = s.st.executeQuery(sql);
//            List<Contrato> contrato = new ArrayList<Contrato>();
//            while (s.rs.next()) {
//                Contrato e = new Contrato();
//                e.setId_contrato(s.rs.getInt("id_contrato"));
//                e.setContrato(s.rs.getString("contrato"));
//                contrato.add(e);
//            }
//            for (Contrato c : contrato) {
//                renglones += "<option value='" + c.getId_contrato() + "'>" + c.getContrato() + "</option>";
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return renglones;
//        } catch (SQLException ex) {
//            return "SQL Code: " + ex;
//        }
//    }

    //==========================================================================
//    public static List<Contrato> select_contrato() {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_select_contrato();";
//            s.rs = s.st.executeQuery(sql);
//            List<Contrato> contrato = new ArrayList<Contrato>();
//            while (s.rs.next()) {
//                Contrato e = new Contrato();
//                e.setId_contrato(s.rs.getInt("id_contrato"));
//                e.setContrato(s.rs.getString("contrato"));
//                contrato.add(e);
//            }
//
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return contrato;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
//
//    //==========================================================================
//    public static String insert_contrato(String nombre) {
//        try {
//            StartConn s = new StartConn();
//            String resultado = "";
//            String sql = "call arcade_insert_contrato('" + nombre + "');";
//            s.rs = s.st.executeQuery(sql);
//            while (s.rs.next()) {
//                resultado = (s.rs.getString("resultado"));
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return resultado;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }
//
//    //==========================================================================
//    public static String update_contrato(int id_contrato) {
//        try {
//            StartConn s = new StartConn();
//            String resultado = "";
//            String sql = "call arcade_update_contrato('" + id_contrato + "');";
//            s.rs = s.st.executeQuery(sql);
//            while (s.rs.next()) {
//                resultado = (s.rs.getString("resultado"));
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return resultado;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }
//
//    //==========================================================================
//    public static String delete_contrato(int id_contrato) {
//        try {
//            StartConn s = new StartConn();
//            String resultado = "";
//            String sql = "call arcade_delete_contrato('" + id_contrato + "');";
//            s.rs = s.st.executeQuery(sql);
//            while (s.rs.next()) {
//                resultado = (s.rs.getString("resultado"));
//            }
//            s.rs.close();
//            s.st.close();
//            s.conn.close();
//            return resultado;
//        } catch (SQLException ex) {
//            return "SQL COde:" + ex;
//        }
//    }
//    //==========================================================================
}
