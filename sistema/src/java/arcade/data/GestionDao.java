package arcade.data;

import arcade.model.Gestion;
import arcade.model.Indicador;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class GestionDao {

    //==========================================================================
    public static String select_gestion_tabla(String cuenta) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestion_cuenta('" + cuenta + "');";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestion> gestion = new ArrayList<Gestion>();
            while (s.rs.next()) {
                Gestion c = new Gestion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestion(s.rs.getInt("id_gestion"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setGestor(s.rs.getString("gestor"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setEstatus_llamada(s.rs.getString("estatus_llamada"));
                c.setGestion(s.rs.getString("gestion"));
                c.setDuracion(s.rs.getString("duracion"));
                gestion.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA 
                    // CONS.	FECHA	HORA	NÚMERO	GESTOR	ESTATUS	CODIGO	GESTION	TIEMPO
                    + "<th style='width: 2%'></th>"
                    + "<th>FECHA</th>"
                    + "<th>NUMERO</th>"
                    + "<th>ID AGENTE</th>"
                    + "<th>ID AGENTE</th>"
                    + "<th>ESTATUS</th>"
                    + "<th>SUBESTATUS</th>"
                    + "<th>DISPOSICION</th>"
                    + "<th>TIEMPO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int cons = 1;
            for (Gestion c : gestion) {
                renglones += ""
                        + "<tr id='" + c.getId_gestion() + "'>"
                        + "<td>" + (cons + 1) + "</td>"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
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

    //==============================================================================
    // ACTUALMENTE NO SE USA, PERO PODRIAMOS UTILIZARLAS EN UNA CAPACITACION VIRTUAL
    public static String select_gestion_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_gestion();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Gestion> gestion = new ArrayList<Gestion>();
            while (s.rs.next()) {
                Gestion e = new Gestion();
                e.setId_gestion(s.rs.getInt("id_gestion"));
                e.setGestion(s.rs.getString("gestion"));
                gestion.add(e);
            }
            for (Gestion c : gestion) {
                renglones += "<option value='" + c.getId_gestion() + "'>" + c.getGestion() + "</option>";
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
    public static String insert_gestion(String cuenta, String telefono, int id_estatus_cuenta, int id_estatus_llamada, int id_usuario, String gestion, String duracion, String retraso, String expediente, int f_predictivo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_gestion('" + cuenta + "','" + telefono + "' ,'" + id_estatus_cuenta + "','" + id_estatus_llamada + "','" + id_usuario + "','" + gestion + "','" + duracion + "','" + retraso + "', '" + expediente + "', '" + f_predictivo + "');";
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
    public static String update_gestion(int id_gestion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_gestion('" + id_gestion + "');";
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
    public static String delete_gestion(int id_gestion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_gestion('" + id_gestion + "');";
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

    //==============================================================================
    public static String select_gestiones_cuenta(String cuenta) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestion_cuenta('" + cuenta + "');";
            int _f_blacklist = 0;
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestion> gestion = new ArrayList<Gestion>();
            while (s.rs.next()) {
                Gestion c = new Gestion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestion(s.rs.getInt("id_gestion"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setGestor(s.rs.getString("gestor"));
                c.setNumero_marcado(s.rs.getString("numero_marcado"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setEstatus_llamada(s.rs.getString("estatus_llamada"));
                c.setGestion(s.rs.getString("gestion"));
                c.setDuracion(s.rs.getString("duracion"));
                c.setF_predictivo(s.rs.getInt("f_predictivo"));
                _f_blacklist = s.rs.getInt("f_blacklisted");

                gestion.add(c);
            }

            System.out.println(_f_blacklist);
            if (_f_blacklist == 1) {
                renglones = "<div style='height:208px;background:#000;text-align:center;font-size:2.4rem;color:#FFF;'><br>Blacklist, ¡NO Gestionar!"
                        + "<br><br><img src='images/anonymous-64.png'>"
                        + "</div>";
            } else {

                renglones = ""
                        + "<table><thead><tr>"
                        // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA 
                        + "<th style='width: 2%'></th>"
                        + "<th style='text-align:center;width:10%;'>FECHA</th>"
                        + "<th style='text-align:center;'>HORA</th>"
                        + "<th style='text-align:center;'>NUMERO</th>"
                        + "<th style='text-align:center;'>AGENTE</th>"
                        + "<th style='text-align:center;'>ESTATUS</th>"
                        + "<th style='text-align:center;'>SUBESTATUS</th>"
                        + "<th style='text-align:center;'>DISPOSICION</th>"
                        + "<th style='text-align:center;'>TIEMPO</th>"
                        + "</tr></thead>";

                // CUEPRO DE LA TABLA
                int cons = 0;
                for (Gestion c : gestion) {
//                    System.out.println(c.getId_gestion() + c.getGestor());
//                    System.out.println(c.getId_gestion() + c.getGestor());
                    renglones += ""
                            + "<tr id='" + c.getId_gestion() + "' title='" + c.getId_gestion() + "' " + (c.getGestor().equals("SISTEMA") ? "style='background: #93FF93 !important;'" : "") + ">"
                            + "<td style='text-align:center;" + (c.getF_predictivo() == 1 ? "background:yellow;" : "") + "'>" + (cons + 1) + "</td>"
                            + "<td style='text-align:center;'>" + c.getFecha() + "</td>"
                            + "<td style='text-align:center;'>" + c.getHora() + "</td>"
                            + "<td style='text-align:center;'>" + c.getNumero_marcado() + "</td>"
                            + "<td style='text-align:center;'>" + c.getGestor() + "</td>"
                            + "<td style='text-align:center;'>" + c.getEstatus_cuenta() + "</td>"
                            + "<td style='text-align:center;'>" + c.getEstatus_llamada() + "</td>"
                            + "<td>" + c.getGestion() + "</td>"
                            + "<td style='text-align:center;'>" + c.getDuracion() + "</td>"
                            + "</tr>";
                    cons++;
                }

                renglones += "</table>";

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
    public static String select_gestiones_cuenta_fit(String cuenta) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestion_cuenta('" + cuenta + "');";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestion> gestion = new ArrayList<Gestion>();
            while (s.rs.next()) {
                Gestion c = new Gestion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestion(s.rs.getInt("id_gestion"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setGestor(s.rs.getString("gestor"));
                c.setNumero_marcado(s.rs.getString("numero_marcado"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setEstatus_llamada(s.rs.getString("estatus_llamada"));
                c.setGestion(s.rs.getString("gestion"));
                c.setDuracion(s.rs.getString("duracion"));
                c.setF_predictivo(s.rs.getInt("f_predictivo"));

                gestion.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'></th>"
                    + "<th style='text-align:center;'>FECHA</th>"
                    + "<th style='text-align:center;'>HORA</th>"
                    + "<th style='text-align:center;'>AGENTE</th>"
                    //                    + "<th style='text-align:center;'>ESTATUS</th>"
                    //                    + "<th style='text-align:center;'>SUBESTATUS</th>"
                    + "<th style='text-align:center;'>DISPOSICION</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int cons = 0;
            for (Gestion c : gestion) {
                renglones += ""
                        + "<tr id='" + c.getId_gestion() + "' title='" + c.getId_gestion() + "' " + (c.getGestor().equals("SISTEMA") ? "style='background: #93FF93 !important;'" : "") + ">"
                        + "<td style='text-align:center;" + (c.getF_predictivo() == 1 ? "background:yellow;" : "") + "'>" + (cons + 1) + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora() + "</td>"
                        + "<td style='text-align:center;'>" + c.getGestor() + "</td>"
                        //                        + "<td style='text-align:center;'>"+ c.getEstatus_cuenta() + "</td>"
                        //                        + "<td style='text-align:center;'>"+ c.getEstatus_llamada() + "</td>"
                        + "<td>" + c.getGestion() + "</td>"
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
    public static String select_gestiones_cuenta_todas(String cuenta) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_gestion_cuenta_todas('" + cuenta + "');";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Gestion> gestion = new ArrayList<Gestion>();
            while (s.rs.next()) {
                Gestion c = new Gestion();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_gestion(s.rs.getInt("id_gestion"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setGestor(s.rs.getString("gestor"));
                c.setNumero_marcado(s.rs.getString("numero_marcado"));
                c.setEstatus_cuenta(s.rs.getString("estatus_cuenta"));
                c.setEstatus_llamada(s.rs.getString("estatus_llamada"));
                c.setGestion(s.rs.getString("gestion"));
                c.setDuracion(s.rs.getString("duracion"));
                c.setF_predictivo(s.rs.getInt("f_predictivo"));
                gestion.add(c);
            }

            renglones = ""
                    + "<table><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA 
                    + "<th style='width: 2%'></th>"
                    + "<th style='text-align:center;width:10%;'>FECHA</th>"
                    + "<th style='text-align:center;'>HORA</th>"
                    + "<th style='text-align:center;'>NUMERO</th>"
                    + "<th style='text-align:center;'>AGENTE</th>"
                    + "<th style='text-align:center;'>ESTATUS</th>"
                    + "<th style='text-align:center;'>SUBESTATUS</th>"
                    + "<th style='text-align:center;'>DISPOSICION</th>"
                    + "<th style='text-align:center;'>TIEMPO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            int cons = 0;
            for (Gestion c : gestion) {
                renglones += ""
                        + "<tr id='" + c.getId_gestion() + "' title='" + c.getId_gestion() + "'>"
                        + "<td style='text-align:center;" + (c.getF_predictivo() == 1 ? "background:yellow;" : "") + "'>" + (cons + 1) + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora() + "</td>"
                        + "<td style='text-align:center;'>" + c.getNumero_marcado() + "</td>"
                        + "<td style='text-align:center;'>" + c.getGestor() + "</td>"
                        + "<td style='text-align:center;'>" + c.getEstatus_cuenta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getEstatus_llamada() + "</td>"
                        + "<td>" + c.getGestion() + "</td>"
                        + "<td style='text-align:center;'>" + c.getDuracion() + "</td>"
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
    public static String select_reporte_gestiones(int _id_sucursal, String _fecha_inicio, String _fecha_fin, String _columna, String _orden) {
        try {
            StartConn s = new StartConn();
            String sql = "select id_gestor as id, usuario,\n"
                    + "	hora_entrada as entrada, ultima_gestion as salida, 1A, 3A, 3E, 3D, 3B, 4A, 4B, 4C, 4D, 4F,\n"
                    + "\n"
                    + "	CAST(((cuentas_contacto/llamadas)*100) AS DECIMAL(11,2)) as porcentaje,\n"
                    + "	 \n"
                    + "	cuentas, llamadas, promesado, promesadox, region as reg, color, antiguedad as ant\n"
                    + "\n"
                    + "from\n"
                    + "\n"
                    + "	(select\n"
                    + "	id_gestor, ifnull(nombre_usuario_alias(id_gestor), 'no registrado en nuevo sistema') as usuario,\n"
                    + "	min(time(fecha_larga)) as hora_entrada,\n"
                    + "	max(time(fecha_larga)) as ultima_gestion,\n"
                    + "\n"
                    + "	sum(id_estatus_llamada=1) as 1A,\n"
                    + "	sum(id_estatus_llamada=3) as 3A,\n"
                    + "	sum(id_estatus_llamada=5) as 3E,\n"
                    + "	sum(id_estatus_llamada=2) as 3D,\n"
                    + "	sum(id_estatus_llamada=4) as 3B,\n"
                    + "	sum(id_estatus_llamada=11) as 4A,\n"
                    + "	sum(id_estatus_llamada=12) as 4B,\n"
                    + "	sum(id_estatus_llamada=13) as 4C,\n"
                    + "	sum(id_estatus_llamada=14) as 4D,\n"
                    + "	sum(id_estatus_llamada=15) as 4F,\n"
                    + "\n"
                    + "	sum(id_estatus_llamada in(1,2,3,5)) as cuentas_contacto,\n"
                    + "\n"
                    + "	count(distinct(cuenta)) as cuentas,\n"
                    + "	count(1) as llamadas,\n"
                    + "\n"
                    + "	promesado_gestor_rango(id_gestor, '" + _fecha_inicio + "', '" + _fecha_fin + "') as promesadox,\n"
                    + "	format(promesado_gestor_rango(id_gestor, '" + _fecha_inicio + "', '" + _fecha_fin + "'),2) as promesado,\n"
                    + "ifnull(alias_region(id_region_id_asignacion(id_asignacion_equipo(id_equipo_gestor(id_gestor)))),'') as region,\n"
                    + "'' as color,\n"
                    + "antiguedad_usuario(id_gestor) as antiguedad\n"
                    + "from\n"
                    + "arcade_gestiones\n"
                    + "where\n"
                    + "	(date(fecha_larga) between '" + _fecha_inicio + "' and '" + _fecha_fin + "')\n"
                    + "and id_sucursal = if(" + _id_sucursal + "=0,id_sucursal, " + _id_sucursal + ")\n"
                    + "group by\n"
                    + "	id_gestor) as src\n"
                    + "order by " + _columna + " " + _orden + ";";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Indicador> indicador = new ArrayList<Indicador>();
            while (s.rs.next()) {
                Indicador c = new Indicador();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_indicador(s.rs.getInt("id"));
                c.setIndicador(s.rs.getString("usuario"));
                c.setHora_entrada(s.rs.getString("entrada"));
                c.setHora_salida(s.rs.getString("salida"));

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

                c.setPorcentaje_contacto(s.rs.getString("porcentaje"));
                c.setCuentas(s.rs.getString("cuentas"));
                c.setLlamadas(s.rs.getString("llamadas"));
                c.setPromesado(s.rs.getString("promesado"));

                c.setRegion(s.rs.getString("reg"));
                c.setAntiguedad(s.rs.getFloat("ant"));
                indicador.add(c);
            }

            renglones = ""
                    + "<table id='tabla_promesado'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;width: 2%'>ID<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>USUARIO<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>ANT<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>REG<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>ENTRADA<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>SALIDA<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>1A<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>3A<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>3E<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>3D<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>3B<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>4A<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>4B<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>4C<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>4D<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>4F<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;width:5%;text-align:center;'>PORCENTAJE<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>CUENTAS<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>LLAMADAS<img src='images/i_order.png'></th>"
                    + "<th class='th_orden' style='cursor:pointer;text-align:center;'>PROMESADOx<img src='images/i_order.png'></th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (Indicador c : indicador) {
                renglones += ""
                        + "<tr id='" + c.getId_indicador() + "'>"
                        + "<td style='text-align:right;'>" + c.getId_indicador() + "</td>"
                        + "<td>" + c.getIndicador() + "</td>"
                        + "<td style='text-align:center;'>" + c.getAntiguedad() + "</td>"
                        + "<td style='text-align:center;'>" + c.getRegion() + "</td>"
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
                        + "<td style='text-align:right;padding-right:20px;' class='importe_promesado'>$" + c.getPromesado() + "</td>"
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
    public static String select_reporte_gestiones_region(int id_region, String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_reporte_gestiones_region('" + id_region + "', '" + desde + "', '" + hasta + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Indicador> indicador = new ArrayList<Indicador>();
            while (s.rs.next()) {
                Indicador c = new Indicador();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setIndicador(s.rs.getString("gestor"));

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

                c.setLlamadas(s.rs.getString("suma"));
                c.setCuentas(s.rs.getString("cuentas"));
                c.setPorcentaje_contacto(s.rs.getString("contacto"));
                c.setPromesado(s.rs.getString("promesado"));
                c.setRetraso(s.rs.getString("color")); // USADO COMO COLOR
                indicador.add(c);
            }

            renglones = ""
                    + "<table id='tabla_gestiones_region' class='striped bordered highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA 
                    + "<th style='text-align:center;'>GESTOR</th>"
                    + "<th style='text-align:center;'>1A</th>"
                    + "<th style='text-align:center;'>3A</th>"
                    + "<th style='text-align:center;'>3E</th>"
                    + "<th style='text-align:center;'>3D</th>"
                    + "<th style='text-align:center;'>3B</th>"
                    + "<th style='text-align:center;'>4A</th>"
                    + "<th style='text-align:center;'>4B</th>"
                    + "<th style='text-align:center;'>4C</th>"
                    + "<th style='text-align:center;'>4D</th>"
                    + "<th style='text-align:center;'>4F</th>"
                    + "<th style='text-align:center;'>N LLAMADAS</th>"
                    + "<th style='text-align:center;'>T. CUENTAS</th>"
                    + "<th style='text-align:center;'> % </th>"
                    + "<th style='text-align:center;'>PROMESADO</th>"
                    + "</tr></thead>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            for (Indicador c : indicador) {
                renglones += ""
                        + "<tr style='" + c.getRetraso() + "'>"
                        + "<td>" + c.getIndicador() + "</td>"
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
                        + "<td style='text-align:center;'>" + c.getLlamadas() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCuentas() + "</td>"
                        + "<td style='text-align:right;'>" + c.getPorcentaje_contacto() + "%</td>"
                        + "<td style='text-align:right;padding-right:20px;'>" + c.getPromesado() + "</td>"
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
    public static String select_reporte_gestiones_csv(int id_cliente, int id_region, int id_asignacion, String fecha_inicial, String fecha_final, String hora_inicia, String hora_final) throws IOException {

        String filename = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\sistema\\excel\\reporte-gestiones.csv";
        System.out.println("FILE NAME: " + filename);

        try {
            String resultado;
            FileWriter fw = new FileWriter(filename);
            StartConn s = new StartConn();
            String sql = "call arcade_select_reporte_gestiones_csv("
                    + "'" + id_cliente + "',"
                    + "'" + id_region + "',"
                    + "'" + id_asignacion + "',"
                    + "'" + fecha_inicial + "',"
                    + "'" + fecha_final + "',"
                    + "'" + hora_inicia + "',"
                    + "'" + hora_final + "'"
                    + ");";

            System.out.println(sql);

            //PONERMOS LOS ENCABEZADOS
            fw.append("#");
            fw.append(',');
            fw.append("ASIGNACION");
            fw.append(',');
            fw.append("FECHA");
            fw.append(',');
            fw.append("HORA");
            fw.append(',');
            fw.append("CUENTA");
            fw.append(',');
            fw.append("NUMERO");
            fw.append(',');
            fw.append("ID GESTOR");
            fw.append(',');
            fw.append("NOMBRE");
            fw.append(',');
            fw.append("ESTATUS");
            fw.append(',');
            fw.append("CODIGO");
            fw.append(',');
            fw.append("GESTION");
            fw.append(',');
            fw.append("DURACION");
            fw.append('\n');

            s.rs = s.st.executeQuery(sql);
            int _cons = 1;
            while (s.rs.next()) {

                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                fw.append(Integer.toString(_cons));
                fw.append(',');
                fw.append(s.rs.getString("asignacion"));
                fw.append(',');
                fw.append(s.rs.getString("fecha"));
                fw.append(',');
                fw.append(s.rs.getString("hora"));
                fw.append(',');
                fw.append(s.rs.getString("cuenta"));
                fw.append(',');
                fw.append(s.rs.getString("numero_marcado"));
                fw.append(',');
                fw.append(s.rs.getString("id_gestor"));
                fw.append(',');
                fw.append(s.rs.getString("gestor"));
                fw.append(',');
                fw.append(s.rs.getString("estatus_cuenta"));
                fw.append(',');
                fw.append(s.rs.getString("estatus_llamada"));
                fw.append(',');
                fw.append(s.rs.getString("gestion"));
                fw.append(',');
                fw.append(s.rs.getString("duracion"));
                fw.append('\n');

                _cons++;
            }

            fw.flush();
            fw.close();

            // CUEPRO DE LA TABLA
            s.rs.close();
            s.st.close();
            s.conn.close();

            resultado = "Se ha generado el Reporte de Gestiones en CSV de manera correcta.";
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_llamadas_gestor(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String llamadas = "";
            String cuentas = "";
            String entrada = "";
            String estrategia = "";
            String cuentas_estrategia = "";
            String sql = "call arcade_select_llamadas_gestor('" + id_usuario + "');";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                llamadas = (s.rs.getString("llamadas"));
                cuentas = (s.rs.getString("cuentas"));
                entrada = (s.rs.getString("hora_entrada"));
                estrategia = (s.rs.getString("estrategia"));
                cuentas_estrategia = (s.rs.getString("cuentas_estrategia"));
            }
            resultado += cuentas;
            resultado += "#AND#";
            resultado += llamadas;
            resultado += "#AND#";
            resultado += entrada;
            resultado += "#AND#";
            resultado += estrategia;
            resultado += "#AND#";
            resultado += cuentas_estrategia;

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_llamadas_gestor2(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String llamadas = "";
            String cuentas = "";
            String entrada = "";
            String estrategia = "";
            String cuentas_estrategia = "";
            String sql = "call arcade_select_llamadas_gestor2('" + id_usuario + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                llamadas = (s.rs.getString("llamadas"));
                cuentas = (s.rs.getString("cuentas"));
                entrada = (s.rs.getString("hora_entrada"));
                estrategia = (s.rs.getString("estrategia"));
                cuentas_estrategia = (s.rs.getString("cuentas_estrategia"));
            }
            resultado += cuentas;
            resultado += "#AND#";
            resultado += llamadas;
            resultado += "#AND#";
            resultado += entrada;
            resultado += "#AND#";
            resultado += estrategia;
            resultado += "#AND#";
            resultado += cuentas_estrategia;

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String import_gestiones_blaster(int id_usuario, int id_cliente) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String result_set = "call arcade_gestionar_blaster('" + id_usuario + "');";
            String truncar_cuentas = "truncate arcade_gestionar_blaster;";

            String importar = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\gestiones-blaster.csv'\n"
                    + "INTO TABLE arcade_gestionar_blaster \n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "IGNORE 1 ROWS\n"
                    + "(\n"
                    + "@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8,@col9)\n"
                    + "set\n"
                    + "id_cliente='" + id_cliente + "', cuenta=@col1, numero_marcado=@col2, fecha_larga=@col3, id_estatus=@col4, id_codigo=@col5, gestion=@col6, id_region=@col7, id_asignacion=@col8, expediente=@col9;\n";

            // NOS ASEGURAMOS QUE NO EXISTAN CUENTAS SUBIDAS ANTERIORMENTE
            s.st.executeUpdate(truncar_cuentas);

            // IMPORTAMOS EL ARCHIVO EN NUESTRA TABLA
            s.st.executeUpdate(importar);

            // GESTIONAMOS LAS CUENTAS CARGADAS, EELIMINAMOS DATOS Y CREAMOS LOG
            s.rs = s.st.executeQuery(result_set);

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
    public static String select_gestiones_chbk_csv(String desde, String hasta) throws IOException {

        String filename = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\sistema\\excel\\gestiones-chbk.csv";
        System.out.println("FILE NAME: " + filename);

        try {
            String resultado;
            FileWriter fw = new FileWriter(filename);
            StartConn s = new StartConn();
            String sql = "call arcade_select_gestiones_chbk('" + desde + "', '" + hasta + "');";
            System.out.println(sql);

            System.out.println(sql);

            //PONERMOS LOS ENCABEZADOS
            fw.append("#");
            fw.append(',');
            fw.append("ASIGNACION");
            fw.append(',');
            fw.append("FECHA");
            fw.append(',');
            fw.append("HORA");
            fw.append(',');
            fw.append("CUENTA");
            fw.append(',');
            fw.append("NUMERO");
            fw.append(',');
            fw.append("ID GESTOR");
            fw.append(',');
            fw.append("NOMBRE");
            fw.append(',');
            fw.append("ESTATUS");
            fw.append(',');
            fw.append("CODIGO");
            fw.append(',');
            fw.append("GESTION");
            fw.append(',');
            fw.append("DURACION");
            fw.append('\n');

            s.rs = s.st.executeQuery(sql);
            int _cons = 1;
            while (s.rs.next()) {

                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                fw.append(Integer.toString(_cons));
                fw.append(',');
                fw.append(s.rs.getString("asignacion"));
                fw.append(',');
                fw.append(s.rs.getString("fecha"));
                fw.append(',');
                fw.append(s.rs.getString("hora"));
                fw.append(',');
                fw.append(s.rs.getString("cuenta"));
                fw.append(',');
                fw.append(s.rs.getString("numero_marcado"));
                fw.append(',');
                fw.append(s.rs.getString("id_gestor"));
                fw.append(',');
                fw.append(s.rs.getString("gestor"));
                fw.append(',');
                fw.append(s.rs.getString("estatus_cuenta"));
                fw.append(',');
                fw.append(s.rs.getString("estatus_llamada"));
                fw.append(',');
                fw.append(s.rs.getString("gestion"));
                fw.append(',');
                fw.append(s.rs.getString("duracion"));
                fw.append('\n');

                _cons++;
            }

            fw.flush();
            fw.close();

            // CUEPRO DE LA TABLA
            s.rs.close();
            s.st.close();
            s.conn.close();

            resultado = "Se ha generado el Reporte de Gestiones en CSV de manera correcta.";
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
}
