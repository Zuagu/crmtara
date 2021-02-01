package arcade.data;

import arcade.model.Predictivo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


/* @author LUIS CORTEZ */
public class PredictivoDao {

    //==============================================================================
    public static String datos_regiones() {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "	nombre_region(id_region) as region,\n"
                    + "    count(id_cuenta) as cuentas,\n"
                    + "    sum(a_gestionar) as a_gestionar,\n"
                    + "    sum(importe_asignado) as importe,\n"
                    + "    sum(resto) as resto\n"
                    + "from arcade_basegeneral where f_active = 1 group by id_region;";
            s.rs = s.st.executeQuery(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setRegion(s.rs.getString("region"));
                e.setCuentas(s.rs.getInt("cuentas"));
                e.setA_gestionar(s.rs.getFloat("a_gestionar"));
                e.setImporte(s.rs.getFloat("importe"));
                e.setResto(s.rs.getFloat("resto"));
                predictivo.add(e);
            }
            JSONObject regiones = new JSONObject();

            for (Predictivo c : predictivo) {
                JSONObject datosRegiones = new JSONObject();
                datosRegiones.put("nombre", c.getRegion());
                datosRegiones.put("cuentas", c.getCuentas());
                datosRegiones.put("a_gestionar", new Float(c.getA_gestionar()));
                datosRegiones.put("importe", new Float(c.getImporte()));
                datosRegiones.put("resto", new Float(c.getResto()));
                regiones.put(c.getRegion(), datosRegiones);
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return regiones.toJSONString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String estatus_regiones() {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "	nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus,\n"
                    + "    count(id_cuenta) as cuentas,\n"
                    + "    sum(resto) as resto\n"
                    + "from arcade_basegeneral \n"
                    + "where f_active = 1\n"
                    + "group by ultimo_estatus_cuenta;";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setCuentas(s.rs.getInt("cuentas"));
                e.setEstatus(s.rs.getString("estatus"));
                e.setResto(s.rs.getFloat("resto"));
                predictivo.add(e);
            }
            JSONObject estatusRegiones = new JSONObject();

            for (Predictivo c : predictivo) {

                JSONObject datos = new JSONObject();
                datos.put("cuentas", new Integer(c.getCuentas()));
                datos.put("resto", new Float(c.getResto()));
                estatusRegiones.put(c.getEstatus(), datos);

            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return estatusRegiones.toJSONString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String estatus_region(int id_region) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "	nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus,\n"
                    + "    count(id_cuenta) cuentas,\n"
                    + "    sum(resto) as resto\n"
                    + "from arcade_basegeneral \n"
                    + "where f_active = 1 and id_region  = " + id_region + "\n"
                    + "group by ultimo_estatus_cuenta;";
            s.rs = s.st.executeQuery(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setCuentas(s.rs.getInt("cuentas"));
                e.setEstatus(s.rs.getString("estatus"));
                e.setResto(s.rs.getFloat("resto"));
                predictivo.add(e);
            }
            JSONObject estatusRegiones = new JSONObject();

            for (Predictivo c : predictivo) {
                JSONObject datos = new JSONObject();
                datos.put("cuentas", new Integer(c.getCuentas()));
                datos.put("resto", new Float(c.getResto()));
                estatusRegiones.put(c.getEstatus(), datos);

            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return estatusRegiones.toJSONString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String estatus_asignacion(int id_asignacion) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "	nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus,\n"
                    + "    count(id_cuenta) cuentas,\n"
                    + "    sum(resto) as resto\n"
                    + "from arcade_basegeneral \n"
                    + "where f_active = 1 and id_asignacion = " + id_asignacion + "\n"
                    + "group by ultimo_estatus_cuenta;";
            s.rs = s.st.executeQuery(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setCuentas(s.rs.getInt("cuentas"));
                e.setEstatus(s.rs.getString("estatus"));
                e.setResto(s.rs.getFloat("resto"));
                predictivo.add(e);
            }
            JSONObject estatusRegiones = new JSONObject();

            for (Predictivo c : predictivo) {
                JSONObject datos = new JSONObject();
                datos.put("cuentas", new Integer(c.getCuentas()));
                datos.put("resto", new Float(c.getResto()));
                estatusRegiones.put(c.getEstatus(), datos);

            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return estatusRegiones.toJSONString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String datos_asignacion(int id_region) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select \n"
                    + "	id_asignacion,\n"
                    + "	nombre_asignacion(id_asignacion) as asignacion,\n"
                    + "    count(id_cuenta) as cuentas,\n"
                    + "    sum(a_gestionar) as a_gestionar,\n"
                    + "    sum(resto) as resto,\n"
                    + "    fecha_inicio,\n"
                    + "    dias,\n"
                    + "    fecha_fin\n"
                    + "from arcade_basegeneral \n"
                    + "where f_active = 1 and id_region = " + id_region + "\n"
                    + "group by id_asignacion;";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo c = new Predictivo();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_asignacion(s.rs.getInt("id_asignacion"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuentas(s.rs.getInt("cuentas"));
                c.setA_gestionar(s.rs.getFloat("a_gestionar"));
                c.setResto(s.rs.getFloat("resto"));
                c.setFecha_inicio(s.rs.getString("fecha_inicio"));
                c.setDias(s.rs.getString("dias"));
                c.setFecha_fin(s.rs.getString("fecha_fin"));
                predictivo.add(c);
            }
            resultado = ""
                    + "<table class='striped bordered highlight'><thead><tr>"
                    + "<th>Asignacion</th>"
                    + "<th>Cuentas</th>"
                    + "<th>A_gestionar</th>"
                    + "<th>Resto</th>"
                    + "<th>Fecha inicio</th>"
                    + "<th>Dias</th>"
                    + "<th>Fecha fin</th>"
                    + "</tr></thead>"
                    + "<tbody>"
                    + "<tr><td colspan='7'>"
                    + "<div class='innerb'>"
                    + "<table class=''>"
                    + "<tbody>";
            // CUEPRO DE LA TABLA
            for (Predictivo c : predictivo) {
                resultado += ""
                        + "<tr id='" + c.getId_asignacion() + "' class='renglon' style='cursor: pointer;'>"
                        + "<td class='nom_asig'>" + c.getAsignacion() + "</td>"
                        + "<td>" + c.getCuentas() + "</td>"
                        + "<td>" + c.getA_gestionar() + "</td>"
                        + "<td>" + c.getResto() + "</td>"
                        + "<td>" + c.getFecha_inicio() + "</td>"
                        + "<td>" + c.getDias() + "</td>"
                        + "<td>" + c.getFecha_fin() + "</td>"
                        + "</tr>";
            }
            resultado += "</tbody></table></div></td></tr></tbody></table>";
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_caja_asignaciones(int tiempo, String id_region) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "select \n"
                    + "	id_asignacion,\n"
                    + "    nombre_asignacion(id_asignacion) as asignacion\n"
                    + "from arcade_basegeneral \n"
                    + "where if( " + id_region + " = 0 , f_active = 1 , f_active = 1 and id_region = " + id_region + " ) \n"
                    + (tiempo != 0 ? "and if(" + tiempo + " = 1, dias < 40, dias >= 40) \n" : "")
                    + "group by id_asignacion;";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setId_asignacion(s.rs.getInt("id_asignacion"));
                e.setAsignacion(s.rs.getString("asignacion"));
                predictivo.add(e);
            }
            renglones = "<div class='col s12 m11 cajas' style='max-height:200px; overflow:auto;'>"
                    + "<input type='checkbox' id='check_asignacion_todos'/>"
                    + "<label for='check_asignacion_todos'><b>Asignacion</b></label><br>";

            for (Predictivo c : predictivo) {

                renglones += ""
                        + "<input type='checkbox' id='" + c.getId_asignacion() + "' class='check_asignacion'/>"
                        + "<label for='" + c.getId_asignacion() + "'>" + c.getAsignacion() + "</label><br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String select_caja_estados(String id_asignaciones) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "select \n"
                    + "	columna35\n"
                    + "from arcade_basegeneral \n"
                    + "where f_active = 1 and id_asignacion in (" + id_asignaciones + ") \n"
                    + "group by columna35;";
            s.rs = s.st.executeQuery(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setEstado(s.rs.getString("columna35"));
                predictivo.add(e);
            }
            renglones = "<div class='col s12 m11 cajas' style='max-height:200px; overflow:auto;'>"
                    + "<input type='checkbox' id='check_estado_todos'/>"
                    + "<label for='check_estado_todos'><b>Estados</b></label><br>";

            for (Predictivo c : predictivo) {

                renglones += ""
                        + "<input type='checkbox' id='" + c.getEstado() + "' class='check_estado'/>"
                        + "<label for='" + c.getEstado() + "'>" + c.getEstado() + "</label><br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String select_caja_status(String id_asignaciones, String estados) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "select \n"
                    + "	ultimo_estatus_cuenta as id_status,\n"
                    + "    nombre_estatus_cuenta(ultimo_estatus_cuenta) as status\n"
                    + "from arcade_basegeneral \n"
                    + "where f_active = 1 and  id_asignacion in (" + id_asignaciones + ") and columna35 in(" + estados + ")\n"
                    + "group by ultimo_estatus_cuenta;";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);

            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setId_status_cuenta(s.rs.getInt("id_status"));
                e.setEstatus(s.rs.getString("status"));
                predictivo.add(e);
            }
            renglones = "<div class='col s12 m11 cajas' style='max-height:200px; overflow:auto;'>"
                    + "<input type='checkbox' id='check_status_todos'/>"
                    + "<label for='check_status_todos'><b>Status</b></label><br>";

            for (Predictivo c : predictivo) {

                renglones += ""
                        + "<input type='checkbox' id='" + c.getId_status_cuenta() + "' class='check_status'/>"
                        + "<label for='" + c.getId_status_cuenta() + "'>" + c.getEstatus() + "</label><br>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==============================================================================
    public static String select_tabla_predictivo(String id_asignaciones, String estados, String status, String t_numero, int cr, float resto, String desde) {
        try {
            StartConn s = new StartConn();
            String renglones = "", sql = "";
            // =================================================================
            String filtro_fecha = " and date(ultima_gestion) <= '"+desde+"' ";
            
            // =================================================================
            String sql_tit = "select \n"
                    + "	b.columna40 as 'num', \n"
                    + "    b.columna40 as marcado,\n"
                    + "    b.columna1 as cuenta,b.columna2,\n"
                    + "    if(b.id_region=1,'MONTERREY',if(b.id_region=2,'CHIHUAHUA','PUEBLA'))as region,\n"
                    + "    nombre_asignacion(b.id_asignacion) as asignacion,\n"
                    + "    nombre_estatus_cuenta(b.ultimo_estatus_cuenta)as estatus,\n"
                    + "    't1' as tel,\n"
                    + "    if(tiene_cr = 1,'si','no') as cr,\n"
                    + "    b.resto \n"
                    + "from arcade_basegeneral b\n"
                    + "where	b.id_asignacion in (" + id_asignaciones + ")\n"
                    + "    and b.columna35 in (" + estados + ")\n"
                    + "    and b.ultimo_estatus_cuenta in (" + status + ")\n"
                    + "    and b.resto >= " + resto + (desde.equals("0000-00-00") ? " " : filtro_fecha) + " union all \n"
                    + "select \n"
                    + "	b.columna81 as 'num', \n"
                    + "    b.columna81 as marcado,\n"
                    + "    b.columna1 as cuenta,b.columna2,\n"
                    + "    if(b.id_region=1,'MONTERREY',if(b.id_region=2,'CHIHUAHUA','PUEBLA'))as region,\n"
                    + "    nombre_asignacion(b.id_asignacion) as asignacion,\n"
                    + "    nombre_estatus_cuenta(b.ultimo_estatus_cuenta)as estatus,\n"
                    + "    't2' as tel,\n"
                    + "    if(tiene_cr = 1,'si','no') as cr,\n"
                    + "    b.resto \n"
                    + "from arcade_basegeneral b\n"
                    + "where	b.id_asignacion in (" + id_asignaciones + ")\n"
                    + "    and b.columna35 in (" + estados + ")\n"
                    + "    and b.ultimo_estatus_cuenta in (" + status + ")\n"
                    + "    and b.resto >= " + resto + (desde.equals("0000-00-00") ? " " : filtro_fecha) +" ";
            // =================================================================
            String sql_crs = "select \n"
                    + "	cr.numero_relacionado as 'num', \n"
                    + "    cr.numero_relacionado as marcado,\n"
                    + "    b.columna1 as cuenta,b.columna2,\n"
                    + "    if(b.id_region=1,'MONTERREY',if(b.id_region=2,'CHIHUAHUA','PUEBLA'))as region,\n"
                    + "    nombre_asignacion(b.id_asignacion) as asignacion,\n"
                    + "    nombre_estatus_cuenta(b.ultimo_estatus_cuenta)as estatus,\n"
                    + "    'cr' as tel,\n"
                    + "    if(tiene_cr = 1,'si','no') as cr,\n"
                    + "    b.resto \n"
                    + "from arcade_basegeneral b \n"
                    + "left join arcade_cuentas_relacionadas cr on b.columna1 = cr.cuenta \n"
                    + "where b.id_asignacion in (" + id_asignaciones + ")\n"
                    + "    and b.columna35 in (" + estados + ")\n"
                    + "    and b.ultimo_estatus_cuenta in (" + status + ")\n"
                    + "    and cr.id_asignacion in (" + id_asignaciones + ")\n"
                    + "    and b.resto >= " + resto + (desde.equals("0000-00-00") ? " " : filtro_fecha) + " ";
            // =================================================================
            String sql_ref = "select \n"
                    + "	b.tel_referencia1 as 'num', \n"
                    + "    b.tel_referencia1 as marcado,\n"
                    + "    b.columna1 as cuenta,b.columna2,\n"
                    + "    if(b.id_region=1,'MONTERREY',if(b.id_region=2,'CHIHUAHUA','PUEBLA'))as region,\n"
                    + "    nombre_asignacion(b.id_asignacion) as asignacion,\n"
                    + "    nombre_estatus_cuenta(b.ultimo_estatus_cuenta)as estatus,\n"
                    + "    'ref1' as tel,\n"
                    + "    if(tiene_cr = 1,'si','no') as cr,\n"
                    + "    b.resto \n"
                    + "from arcade_basegeneral b\n"
                    + "where	b.id_asignacion in (" + id_asignaciones + ")\n"
                    + "    and b.columna35 in (" + estados + ")\n"
                    + "    and b.ultimo_estatus_cuenta in (" + status + ")\n"
                    + "    and b.resto >= " + resto + (desde.equals("0000-00-00") ? " " : filtro_fecha) + " union all \n"
                    + "select \n"
                    + "	b.tel_referencia2 as 'num', \n"
                    + "    b.tel_referencia2 as marcado,\n"
                    + "    b.columna1 as cuenta,b.columna2,\n"
                    + "    if(b.id_region=1,'MONTERREY',if(b.id_region=2,'CHIHUAHUA','PUEBLA'))as region,\n"
                    + "    nombre_asignacion(b.id_asignacion) as asignacion,\n"
                    + "    nombre_estatus_cuenta(b.ultimo_estatus_cuenta)as estatus,\n"
                    + "    'ref2' as tel,\n"
                    + "    if(tiene_cr = 1,'si','no') as cr,\n"
                    + "    b.resto \n"
                    + "from arcade_basegeneral b\n"
                    + "where	b.id_asignacion in (" + id_asignaciones + ")\n"
                    + "    and b.columna35 in (" + estados + ")\n"
                    + "    and b.ultimo_estatus_cuenta in (" + status + ")\n"
                    + "    and b.resto >= " + resto + (desde.equals("0000-00-00") ? " " : filtro_fecha) + " ";
            // =================================================================

            String[] numero_t = t_numero.split(", ");
            int tamano = numero_t.length;
            for (int i = 0; i < tamano; i++) {
                if (numero_t[i].equals("tit")) {
                    if (i == 0) {
                        sql += sql_tit;
                    } else {
                        sql += " union all " + sql_tit;
                    }

                } else if (numero_t[i].equals("crs")) {
                    if (i == 0) {
                        sql += sql_crs;
                    } else {
                        sql += " union all " + sql_crs;
                    }

                } else if (numero_t[i].equals("ref")) {
                    if (i == 0) {
                        sql += sql_ref;
                    } else {
                        sql += " union all " + sql_ref;
                    }
                }
            }
            sql += " order by resto desc;";
            System.out.println("sql: " + sql );
            s.rs = s.st.executeQuery(sql);
            List<Predictivo> predictivo = new ArrayList<Predictivo>();
            while (s.rs.next()) {
                Predictivo e = new Predictivo();
                e.setNumero(s.rs.getString("num"));
                e.setMarcado(s.rs.getString("marcado"));
                e.setCuentas(s.rs.getInt("cuenta"));
                e.setRegion(s.rs.getString("region"));
                e.setAsignacion(s.rs.getString("asignacion"));
                e.setEstatus(s.rs.getString("estatus"));
                e.setTelefono(s.rs.getString("tel"));
                e.setCr(s.rs.getString("cr"));
                e.setNombre(s.rs.getString("columna2"));
                e.setResto(s.rs.getFloat("resto"));
                predictivo.add(e);
            }

            renglones = ""
                    + "<table class='striped bordered highlight' style='max-width:200px'><thead><tr>"
                    + "<th style='width:15%'></th>"
                    + "<th style='width:14%'>marcando</th>"
                    + "<th style='width:12%'>cuenta</th>"
                    + "<th style='width:12%'>region</th>"
                    + "<th style='width:10%'>asignacion</th>"
                    + "<th style='width:8%'>estatus</th>"
                    + "<th style='width:6%'>tel</th>"
                    + "<th>cr</th>"
                    + "<th>resto</th>"
                    + "<th style='width:12%'>Nombre</th>"
                    + "</tr></thead>"
                    + "<tbody>"
                    + "<tr><td colspan='10'>"
                    + "<div class='innerb'>"
                    + "<table id='tabla_predictivo' class='' style='max-width:200px'>"
                    + "<tbody>";
            // CUEPRO DE LA TABLA
            for (Predictivo c : predictivo) {
                if (!c.getNumero().equals("")) {

                    if (cr == 0) {
                        renglones += ""
                                + "<tr class='renglon' style='cursor: pointer;'>"
                                + "<td>" + c.getNumero() + "</td>"
                                + "<td>" + c.getMarcado() + "</td>"
                                + "<td>" + c.getCuentas() + "</td>"
                                + "<td>" + c.getRegion() + "</td>"
                                + "<td>" + c.getAsignacion() + "</td>"
                                + "<td>" + c.getEstatus() + "</td>"
                                + "<td>" + c.getTelefono() + "</td>"
                                + "<td>" + c.getCr() + "</td>"
                                + "<td>" + c.getResto() + "</td>"
                                + "<td>" + c.getNombre()+ "</td>"
                                + "</tr>";
                    }else if (cr == 1 && c.getCr().equals("si")) {
                        renglones += ""
                                + "<tr class='renglon' style='cursor: pointer;'>"
                                + "<td>" + c.getNumero() + "</td>"
                                + "<td>" + c.getMarcado() + "</td>"
                                + "<td>" + c.getCuentas() + "</td>"
                                + "<td>" + c.getRegion() + "</td>"
                                + "<td>" + c.getAsignacion() + "</td>"
                                + "<td>" + c.getEstatus() + "</td>"
                                + "<td>" + c.getTelefono() + "</td>"
                                + "<td>" + c.getCr() + "</td>"
                                + "<td>" + c.getResto() + "</td>"
                                + "<td>" + c.getNombre()+ "</td>"
                                + "</tr>";
                    }else if (cr == 2 && c.getCr().equals("no")) {
                        renglones += ""
                                + "<tr class='renglon' style='cursor: pointer;'>"
                                + "<td>" + c.getNumero() + "</td>"
                                + "<td>" + c.getMarcado() + "</td>"
                                + "<td>" + c.getCuentas() + "</td>"
                                + "<td>" + c.getRegion() + "</td>"
                                + "<td>" + c.getAsignacion() + "</td>"
                                + "<td>" + c.getEstatus() + "</td>"
                                + "<td>" + c.getTelefono() + "</td>"
                                + "<td>" + c.getCr() + "</td>"
                                + "<td>" + c.getResto() + "</td>"
                                + "<td>" + c.getNombre()+ "</td>"
                                + "</tr>";
                    }

                }

            }
            renglones += "</tbody></table></div></td></tr></tbody></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==============================================================================
}
