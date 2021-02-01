package arcade.data;

import arcade.model.Visitas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author Desarrollo */
public class VisitasDao {

    //==========================================================================
    public static String select_cadena_datos_carta_visita(int cuenta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_cadena_datos_carteo(" + cuenta + ");";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("datos"));
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
    public static String select_cadena_datos_cartas(
            String id_region,
            String cadena_asignaciones,
            String cadena_ciudades,
            String cadena_colonias,
            String cadena_codigos,
            String cadena_ladas,
            String resto
    ) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String renglones;
            String sql = "SELECT \n"
                    + "concat( \n"
                    + "'legal.mty@sicsaabogados.com',',', -- coreo sicsa \n"
                    + "'(81) 19.32.38.44',',', -- telefono sicsa \n"
                    + "a.columna2,',', -- nombre \n"
                    + "a.columna16,',', -- rfc \n"
                    + "a.columna1,',', -- cuenta \n"
                    + "a.columna31,' N#',columna30,',', -- domicilio \n"
                    + "a.columna33,',', -- colonia \n"
                    + "a.columna32,',', -- ciudad \n"
                    + "a.columna36,',', -- cp \n"
                    + "a.columna3,',', -- linea \n"
                    + "a.a_gestionar,',' -- a gestiopnar adeudo \n"
                    + "'No Definido',',', -- gestor \n"
                    + "'8119323844',',', -- numero area metropolitana \n"
                    + "a.columna3,',', -- expediente \n"
                    + "nombre_asignacion(a.id_asignacion),',', \n"
                    + "'USUARIO',',', \n"
                    + "nombre_estatus_cuenta(a.ultimo_estatus_cuenta),',', \n"
                    + "a.a_gestionar,',', -- saldo \n"
                    + "a.penalizacion,',', -- multa \n"
                    + "(a.a_gestionar + a.penalizacion),',', -- total \n"
                    + "a.resto,',', \n"
                    + "date(now()),'#CORTE#' \n"
                    + ") as datos \n"
                    + "FROM arcade_call.arcade_basegeneral a \n"
                    + "left join arcade_call.arcade_visitas_cuentas b \n"
                    + "on a.columna1 = b.cuenta \n"
                    + "WHERE a.f_active = 1 \n"
                    + "and b.cuenta is null \n"
                    + "and a.id_region = " + id_region + " \n"
                    + "and a.id_asignacion in (" + cadena_asignaciones + ") \n"
                    + "and a.columna32 in (" + cadena_ciudades + ") \n"
                    + "and a.columna33 in (" + n_cadena_colonias + ") \n"
                    + "and a.columna36 in (" + cadena_codigos + ") \n"
                    + "and a.ultimo_estatus_cuenta in (" + cadena_ladas + ") \n"
                    + "and a.resto >= " + resto + " ;\n ";

            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                c.setDatos(s.rs.getString("datos"));
                visitas.add(c);
            }

            renglones = "";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += c.getDatos();
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
    public static String select_cadena_datos_cartas2(String id_region, String cadena_asignaciones, String cadena_ciudades, String cadena_colonias, String cadena_codigos, String cadena_ladas, String resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String renglones;
            String sql = "SELECT \n"
                    + "concat( \n"
                    + "'legal.mty@sicsaabogados.com',',', -- coreo sicsa \n"
                    + "'(81) 19.32.38.44',',', -- telefono sicsa \n"
                    + "a.columna2,',', -- nombre \n"
                    + "a.columna16,',', -- rfc \n"
                    + "a.columna1,',', -- cuenta \n"
                    + "a.columna31,' N#',columna30,',', -- domicilio \n"
                    + "a.columna33,',', -- colonia \n"
                    + "a.columna32,',', -- ciudad \n"
                    + "a.columna36,',', -- cp \n"
                    + "a.columna3,',', -- linea \n"
                    + "a.a_gestionar,',' -- a gestiopnar adeudo \n"
                    + "'No Definido',',', -- gestor \n"
                    + "'8119323844',',', -- numero area metropolitana \n"
                    + "a.columna3,',', -- expediente \n"
                    + "nombre_asignacion(a.id_asignacion),',', \n"
                    + "'USUARIO',',', \n"
                    + "nombre_estatus_cuenta(a.ultimo_estatus_cuenta),',', \n"
                    + "a.a_gestionar,',', -- saldo \n"
                    + "a.penalizacion,',', -- multa \n"
                    + "(a.a_gestionar + a.penalizacion),',', -- total \n"
                    + "a.resto,',', \n"
                    + "date(now()),'#CORTE#' \n"
                    + ") as datos \n"
                    + "FROM arcade_call.arcade_basegeneral a \n"
                    + "left join arcade_call.arcade_visitas_cuentas b \n"
                    + "on a.columna1 = b.cuenta \n"
                    + "WHERE a.f_active = 1 \n"
                    + "and b.cuenta is null \n"
                    + "and a.id_region = "+ id_region +" \n"
                    + "and a.id_asignacion in (" + cadena_asignaciones + ") \n"
                    + "and a.columna32 in ("+ cadena_ciudades +") \n"
                    + "and a.columna33 in ("+ n_cadena_colonias +") \n"
                    + "and a.columna36 in ("+ cadena_codigos +") \n"
                    + "and a.ultimo_estatus_cuenta in ("+ cadena_ladas +") \n"
                    + "and a.resto >= "+ resto +" ;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                c.setDatos(s.rs.getString("datos"));
                visitas.add(c);
            }

            renglones = "";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += c.getDatos();
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
    /* consulta a la tabla arcade_visitas_cuentas para traer las asiganciones que tienen cuentas 
    que ya se le mandaron un carta de notificacion previa */
    public static String select_asignacion_region_check_visitas(int id_region) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "select id_asignacion, nombre_asignacion(id_asignacion) as asignacion from arcade_basegeneral where f_active = 1 and id_region = " + id_region + " and dias >= 40 group by id_asignacion;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                c.setId_asignacion(s.rs.getInt("id_asignacion"));
                c.setAsignacion(s.rs.getString("asignacion"));
                visitas.add(c);
            }

            renglones = ""
                    + "<input type='checkbox' id='check_asignacion_todos'/>"
                    + "<label for='check_asignacion_todos'><b>ASIGNACIÓN</b></label>";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getId_asignacion() + "' class='check_asignacion' />"
                        + "<label for='" + c.getId_asignacion() + "'>" + c.getAsignacion() + "</label>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //========================================================================== select_ciudades_check
    public static String select_ciudades_check(String cadena_asignaciones, int id_region) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(columna32) as ciudad from arcade_basegeneral where id_asignacion in ('" + cadena_asignaciones + "') " + (id_region == 1 ? "and columna35='N L'" : "") + " and f_active = 1  order by columna32 ;";

            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setCiudades(s.rs.getString("ciudad"));
                visitas.add(c);
            }

            renglones = "<div style='height=170px; overflow=auto;'>"
                    + "<input type='checkbox' id='check_ciudad_todos'/>"
                    + "<label for='check_ciudad_todos'><b>CIUDAD</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getCiudades() + "' class='check_ciudad'/>"
                        + "<label for='" + c.getCiudades() + "'>" + c.getCiudades() + "</label><br>";
            }
            renglones += "</div>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //========================================================================== asta aqui falta los manaje
    public static String select_colonias_check(String cadena_asignaciones, String cadena_ciudades, String cadena_codigos, int tipo) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(columna33) as colonia from arcade_basegeneral where id_asignacion in (" + cadena_asignaciones + ") and columna32 in (" + cadena_ciudades + ") and columna36 in (" + cadena_codigos + ") order by columna33;";

            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setColonias(s.rs.getString("colonia"));
                visitas.add(c);
            }

            renglones = "<div style='height=170px; overflow=auto;'>"
                    + "<input type='checkbox' id='check_colonia_todos'/>"
                    + "<label for='check_colonia_todos'><b>COLONIA</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                //EN ESTA PARTE DEL CODIGO AL ID_COLONIAS Y EN LA PROPIEDAD FOR DEL LABEL SE LE AGRGO EL PREFIJO DE "_C"
                renglones += ""
                        + "<input type='checkbox' id='" + c.getColonias() + "_C' class='check_colonia'/>"
                        + "<label for='" + c.getColonias() + "_C'>" + c.getColonias() + "</label><br>";
            }
            renglones += "</div>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_codigo_postal_check(String cadena_asignaciones, String cadena_ciudades, int tipo) {
        try {
            StartConn s = new StartConn();
            String renglones;
            // SOLO LAS CUENTAS ACTIVAS, YA QUE ES PARA GENERAR EL ARCHIVO DE SMS (Y SOLO SE TOCA LO ACTIVO)
            String sql = "select distinct(columna36) as cp from arcade_basegeneral where id_asignacion in (" + cadena_asignaciones + ") and columna32 in ( " + cadena_ciudades + " ) order by columna36;";

            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setCp(s.rs.getString("cp"));
                visitas.add(c);
            }

            renglones = "<div style='height=170px; overflow=auto;'>"
                    + "<input type='checkbox' id='check_codigo_todos'/>"
                    + "<label for='check_codigo_todos'><b>C.P.</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getCp() + "' class='check_codigo'/>"
                        + "<label for='" + c.getCp() + "'>" + c.getCp() + "</label><br>";
            }
            renglones += "</div>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //========================================================================== 
    public static String select_status_check(String cadena_asignaciones, String cadena_colonias, String cadena_codigos) {
        try {
            StartConn s = new StartConn();
            String renglones;
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String sql = "select distinct \n"
                    + "  ultimo_estatus_cuenta as id_status, \n"
                    + "  nombre_estatus_cuenta(ultimo_estatus_cuenta) as estatus \n"
                    + "from arcade_basegeneral where \n"
                    + "  id_asignacion in (" + cadena_asignaciones + ") \n"
                    + "  and  columna33 in (" + n_cadena_colonias + ") \n"
                    + "  and columna36 in (" + cadena_codigos + ") \n"
                    + "order by ultimo_estatus_cuenta;";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_status(s.rs.getString("id_status"));
                c.setStatus(s.rs.getString("estatus"));
                visitas.add(c);
            }

            renglones = "<div style='height=170px; overflow=auto;'>"
                    + "<input type='checkbox' id='check_lada_todos'/>"
                    + "<label for='check_lada_todos'><b>ESTATUS</b></label><br>";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += ""
                        + "<input type='checkbox' id='" + c.getId_status() + "' class='check_lada'/>"
                        + "<label for='" + c.getId_status() + "'>" + c.getStatus() + "</label><br>";
            }
            renglones += "</div>";
            
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_segunda_visitas(int id_region, String cadena_asignaciones, String cadena_ciudades, String cadena_colonias, String cadena_codigos, String cadena_ladas, int resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String sql = "select \n"
                    + "nombre_region(a.id_region) as region, \n"
                    + "nombre_asignacion(a.id_asignacion) as asignacion, \n"
                    + "a.columna1 as cuenta, \n"
                    + "a.columna32 as ciudades, \n"
                    + "a.columna33 as colonia, \n"
                    + "a.columna36 as cp , \n"
                    + "nombre_estatus_cuenta(a.ultimo_estatus_cuenta) as status, \n"
                    + "format(a.resto, 2) as resto \n"
                    + "from arcade_call.arcade_basegeneral a \n"
                    + "left join arcade_call.arcade_visitas_cuentas b \n"
                    + "on a.columna1 = b.cuenta \n"
                    + "where a.id_region = " + id_region + " \n"
                    + "and b.cuenta is null \n"
                    + "and a.f_active = 1 \n"
                    + "and a.id_asignacion in (" + cadena_asignaciones + ") \n"
                    + "and a.columna32 in (" + cadena_ciudades + ") \n"
                    + "and a.columna33 in (" + n_cadena_colonias + ") \n"
                    + "and a.columna36 in (" + cadena_codigos + ") \n"
                    + "and a.ultimo_estatus_cuenta in (" + cadena_ladas + ") \n"
                    + "and a.resto >= " + resto + "; \n";
            String renglones;
            int filas = 0;
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();

                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setCiudades(s.rs.getString("ciudades"));
                c.setColonias(s.rs.getString("colonia"));
                c.setCp(s.rs.getString("cp"));
                c.setLada(s.rs.getString("status"));
                c.setResto(s.rs.getString("resto"));
                visitas.add(c);
            }

            renglones = ""
                    + "<table id='lista_user' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='text-align:center;border:solid 1px;'>IMPRESION</th>"
                    + "<th style='text-align:center;border:solid 1px;'>NO#</th>"
                    + "<th style='text-align:center;border:solid 1px;'>ASIGNACION</th>"
                    + "<th style='text-align:center;border:solid 1px;'>CUENTA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>STATUS</th>"
                    + "<th style='text-align:center;border:solid 1px;'>COLONIA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>SALDO ACT</th>"
                    + "<th style='text-align:center;border:solid 1px;'>FECHA VISITA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>CODIGO</th>"
                    + "<th style='text-align:center;border:solid 1px;'>PLANO</th>"
                    + "<th style='text-align:center;border:solid 1px;'>RESULTADO</th>"
                    + "<th style='text-align:center;border:solid 1px;'>TELEFONO/ FECHA PROMESA</th>"
                    + "<th style='text-align:center;border:solid 1px;'>COMENTARIOS</th>"
                    + "</tr><tbody>";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                filas++;
                renglones += ""
                        + "<tr class='cuenta' id='" + c.getCuenta() + "'>"
                        + "<td style='text-align:center;border:solid 1px;'> <a href='#'><i id='print_carteo' class='material-icons print_carteo'>print</i></a> </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + filas + ".-ACUSE </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getAsignacion() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getCuenta() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getLada() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + c.getColonias() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> " + "$ " + c.getResto() + " </td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
                        + "<td style='text-align:center;border:solid 1px;'>1|2|3</td>"
                        + "<td style='text-align:center;border:solid 1px;'></td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
                        + "<td style='text-align:center;border:solid 1px;'> </td>"
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
    public static String insert_cuentas_visitas(String id_region, String cadena_asignaciones, String cadena_ciudades, String cadena_colonias, String cadena_codigos, String cadena_ladas, String resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String resultado = "VIsitas";
            String sql = "insert into arcade_call.arcade_visitas_cuentas( \n"
                    + "    id_visitador, fecha_asignacion, id_region, id_asignacion, cuenta, fecha_inicio, fecha_fin, status, comentarios,  \n"
                    + "    email, telefono, nombre, rfc, calle, numero_ext, numero_int, colonia, ciudad, estado, codigo_postal, espediente,  \n"
                    + "    resto, saldo, multa, linea, visitas) \n"
                    + "select  \n"
                    + "    1111, -- id_visitador -- 2 \n"
                    + "    now() as f_asignacion, -- fecha de la asignacion -- 3 \n"
                    + "    a.id_region, -- id_region -- 4 \n"
                    + "    a.id_asignacion, -- asignacion -- 5 \n"
                    + "    a.columna1, -- cuenta -- 6 \n"
                    + "    a.fecha_inicio, -- fecha Inicio -- 7 \n"
                    + "    a.fecha_fin, -- fecha Fin -- 8  \n"
                    + "    a.ultimo_estatus_cuenta, -- status -- 9 \n"
                    + "    '' as comentarios, -- comentarios --10 \n"
                    + "    a.columna37, -- correo -- 11 \n"
                    + "    a.columna40, -- numero -- 12 \n"
                    + "    a.columna2, -- nombre -- 13 \n"
                    + "    a.columna16, -- rfc -- 14 \n"
                    + "    a.columna31, -- calle -- 15  \n"
                    + "    a.columna34, -- numero ext -- 16  \n"
                    + "    a.columna30, -- numero int -- 17 \n"
                    + "    a.columna33, -- colonia -- 18 \n"
                    + "    a.columna32, -- ciudad  -- 19  \n"
                    + "    a.columna35, -- estado  -- 20 \n"
                    + "    a.columna36, -- cp  -- 21 \n"
                    + "    a.columna3, -- expediente -- 22 \n"
                    + "    a.resto, -- resto -- 23 \n"
                    + "    a_gestionar, -- saldo_vencido -- 24 \n"
                    + "    a.penalizacion, -- multa -- 25  \n"
                    + "    '' as linea, -- linea -- 26  \n"
                    + "    1 as visitas -- visitas -- 27 \n"
                    + "from arcade_call.arcade_basegeneral a \n"
                    + "   left join arcade_visitas_cuentas b on a.columna1 = b.cuenta \n"
                    + "   where b.cuenta is null \n"
                    + "    and a.f_active = 1 \n"
                    + "    and a.id_region = " + id_region + " \n"
                    + "    and a.id_asignacion in (" + cadena_asignaciones + ") \n"
                    + "    and a.columna32 in (" + cadena_ciudades + ")  \n"
                    + "    and a.columna33 in (" + n_cadena_colonias + ")  \n"
                    + "   and a.columna36 in (" + cadena_codigos + ")  \n"
                    + "   and a.ultimo_estatus_cuenta in (" + cadena_ladas + ")  \n"
                    + "   and a.resto >= " + resto + ";";
            System.out.println(sql);
            s.st.executeUpdate(sql);

//            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String insert_datos_carteo(int id_region, int id_asignacion, String cadena_ciudades, String cadena_colonias, String cadena_codigos, int resto) {
        try {
            StartConn s = new StartConn();
            String resultado = "CARTEO";
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String sql = "INSERT INTO arcade_call.arcade_carteos_cuentas( \n"
                    + "    id_region, id_asignacion, cuenta, fecha_fin, email, telefono, nombre, rfc, calle, num_ext, num_int,  \n"
                    + "    colonia, ciudad, estado, codigo_postal, expediente, saldo_vencido, resto, carta \n"
                    + ") \n"
                    + "SELECT  \n"
                    + "  a.id_region, \n"
                    + "  a.id_asignacion, \n"
                    + "  a.columna1, -- cuenta \n"
                    + "  a.fecha_fin,  \n"
                    + "  a.columna37, -- email \n"
                    + "  a.columna40, -- num \n"
                    + "  a.columna2, -- nombre \n"
                    + "  a.columna16, -- rfc \n"
                    + "  a.columna31, -- calle \n"
                    + "  a.columna34, -- num_ext \n"
                    + "  a.columna30, -- num_int \n"
                    + "  a.columna33, -- colonia \n"
                    + "  a.columna32, -- ciudad \n"
                    + "  a.columna35, -- estado \n"
                    + "  a.columna36, -- cp \n"
                    + "  a.columna3, -- expe \n"
                    + "  a.a_gestionar,  \n"
                    + "  a.resto, \n"
                    + "  1 as carta \n"
                    + "FROM arcade_call.arcade_basegeneral a \n"
                    + "  LEFT JOIN arcade_call.arcade_carteos_cuentas b \n"
                    + "  ON a.columna1 = b.cuenta \n"
                    + "WHERE  \n"
                    + " b.cuenta IS NULL \n"
                    + " AND a.f_active = 1 \n"
                    + " AND a.id_region = " + id_region + " \n"
                    + " AND a.id_asignacion = " + id_asignacion + " \n"
                    + " AND a.columna32 in (" + cadena_ciudades + ") \n"
                    + " AND a.columna33 in (" + n_cadena_colonias + ") \n"
                    + " AND a.columna36 in (" + cadena_codigos + ") \n"
                    + " AND a.resto >= " + resto + ";";
            System.out.println(sql);
            s.st.executeUpdate(sql);

//            s.rs.close();
//            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_numero_visitas(String id_region, String cadena_asignaciones, String cadena_ciudades, String cadena_colonias, String cadena_codigos, String cadena_ladas, String resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String resultado = "SE HA ACTUALIZADO EL NUMERO DE VISITAS DE LAS CENTAS SELECCIONADAS";
            String sql = "UPDATE  arcade_call.arcade_visitas_cuentas \n"
                    + "SET visitas = visitas + 1 \n"
                    + "WHERE id_region = " + id_region + " \n"
                    + "AND id_asignacion IN (" + cadena_asignaciones + ") \n"
                    + "AND ciudad IN (" + cadena_ciudades + ") \n"
                    + "AND colonia IN (" + n_cadena_colonias + ") \n"
                    + "AND codigo_postal IN (" + cadena_codigos + ") \n"
                    + "AND substring(telefono,1,3) IN (" + cadena_ladas + ") \n"
                    + "AND resto >= " + resto + "; ";
            System.out.println(sql);
            s.st.executeUpdate(sql);

            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_carteo(int id_region, int id_asignaciones, String cadena_ciudades, String cadena_colonias, String cadena_codigos, int resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            
            String renglones;
            String sql = "SELECT \n"
                    + "concat( \n"
                    + "'legal.mty@sicsaabogados.com',',', -- coreo sicsa \n"
                    + "'(81) 19.32.38.44',',', -- telefono sicsa \n"
                    + "a.columna2,',', -- nombre \n"
                    + "a.columna16,',', -- rfc \n"
                    + "a.columna1,',', -- cuenta \n"
                    + "a.columna31,' N#',columna30,',', -- domicilio \n"
                    + "a.columna33,',', -- colonia \n"
                    + "a.columna32,',', -- ciudad \n"
                    + "a.columna36,',', -- cp \n"
                    + "'LINEA',',', -- linea \n"
                    + "a.a_gestionar,',', -- a gestiopnar adeudo \n"
                    + "a.columna3,',', -- expediente \n"
                    + "nombre_asignacion(a.id_asignacion),',', \n"
                    + "(a.a_gestionar + a.penalizacion),',', -- total \n"
                    + "a.resto,',', \n"
                    + "date(now()),'#CORTE#' \n"
                    + ") as datos \n"
                    + "FROM arcade_call.arcade_basegeneral a \n"
                    + "left join arcade_call.arcade_carteos_cuentas b \n"
                    + "on a.columna1 = b.cuenta \n"
                    + "WHERE a.f_active = 1 \n"
                    + "and b.cuenta is null \n"
                    + "and a.id_region = " + id_region + " \n"
                    + "and a.id_asignacion in (" + id_asignaciones + ") \n"
                    + "and a.columna32 in (" + cadena_ciudades + ") \n"
                    + "and a.columna33 in (" + n_cadena_colonias + ") \n"
                    + "and a.columna36 in (" + cadena_codigos + ") \n"
                    + "and a.resto >= " + resto + " ;\n ";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                c.setDatos(s.rs.getString("datos"));
                visitas.add(c);
            }

            renglones = "";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += c.getDatos();
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
    public static String select_datos_segundo_carteo_tabla(int id_region, String cadena_asignaciones, String cadena_ciudades, String cadena_colonias, String cadena_codigos, int resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String sql = "select \n"
                    + "nombre_region(id_region) as region, \n"
                    + "nombre_asignacion(id_asignacion) asignacion, \n"
                    + "cuenta as cuenta, \n"
                    + "ciudad as ciudades , \n"
                    + "colonia as colonia, \n"
                    + "codigo_postal as cp , \n"
                    + "format(resto, 2) as resto \n"
                    + "from arcade_call.arcade_carteos_cuentas \n"
                    + "where id_region = " + id_region + " \n"
                    + "and id_asignacion in (" + cadena_asignaciones + ") \n"
                    + "and ciudad in (" + cadena_ciudades + ") \n"
                    + "and colonia in (" + n_cadena_colonias + ") \n"
                    + "and codigo_postal in (" + cadena_codigos + ") \n"
                    + "and resto >= " + resto + "; \n";
            String renglones;
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();

                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRegion(s.rs.getString("region"));
                c.setAsignacion(s.rs.getString("asignacion"));
                c.setCuenta(s.rs.getString("cuenta"));
                c.setCiudades(s.rs.getString("ciudades"));
                c.setColonias(s.rs.getString("colonia"));
                c.setCp(s.rs.getString("cp"));
                c.setResto(s.rs.getString("resto"));
                visitas.add(c);
            }

            renglones = ""
                    + "<table id='lista_user' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style=''>ID REGION</th>"
                    + "<th style=''>ASIGNACION</th>"
                    + "<th style=''>CUENTA</th>"
                    + "<th style=''>CIUDAD</th>"
                    + "<th style=''>COLONIA</th>"
                    + "<th style='text-align:center;'>C.P.</th>"
                    + "<th style='text-align:center;'>RESTO</th>"
                    + "</tr><tbody>";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += ""
                        + "<tr class='cuenta' id='" + c.getCuenta() + "'>"
                        + "<td> " + c.getRegion() + " </td>"
                        + "<td> " + c.getAsignacion() + " </td>"
                        + "<td> " + c.getCuenta() + " </td>"
                        + "<td> " + c.getCiudades() + " </td>"
                        + "<td> " + c.getColonias() + " </td>"
                        + "<td style='text-align:center;'> " + c.getCp() + " </td>"
                        + "<td> " + "$ " + c.getResto() + " </td>"
                        + "<td> <a href='#'><i id='print_carteo' class='material-icons print_carteo'>print</i></a> </td>"
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
    public static String select_datos_segundo_carteo(int id_region, int id_asignacion, String cadena_ciudades, String cadena_colonias, String cadena_codigos, int resto) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            String renglones;
            String sql = "SELECT \n"
                    + "concat( \n"
                    + " 'legal.mty@sicsaabogados.com',',', -- coreo sicsa \n"
                    + " '(81) 19.32.38.44',',', -- telefono sicsa \n"
                    + " nombre,',', -- nombre \n"
                    + " rfc,',', -- rfc \n"
                    + " cuenta,',', -- cuenta \n"
                    + " calle,' N#',num_int,',', -- domicilio \n"
                    + " colonia,',', -- colonia \n"
                    + " ciudad,',', -- ciudad \n"
                    + " codigo_postal,',', -- cp \n"
                    + " '1',',', -- linea \n"
                    + " saldo_vencido,',', -- a gestiopnar adeudo \n"
                    + " expediente,',', -- expediente \n"
                    + " nombre_asignacion(id_asignacion),',', \n"
                    + " saldo_vencido,',', -- total \n"
                    + " resto,',', \n"
                    + " date(now()),'#CORTE#' \n"
                    + ") as datos \n"
                    + "FROM arcade_call.arcade_carteos_cuentas\n"
                    + "WHERE id_region = " + id_region + " \n"
                    + " and id_asignacion in (" + id_asignacion + ") \n"
                    + " and ciudad in (" + cadena_ciudades + ") \n"
                    + " and colonia in (" + n_cadena_colonias + ") \n"
                    + " and codigo_postal in (" + cadena_codigos + ") \n"
                    + " and resto >= 0 ;\n";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Visitas> visitas = new ArrayList<Visitas>();
            while (s.rs.next()) {
                Visitas c = new Visitas();
                c.setDatos(s.rs.getString("datos"));
                visitas.add(c);
            }

            renglones = "";

            // CUEPRO DE LA TABLA
            for (Visitas c : visitas) {
                renglones += c.getDatos();
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

    public static String update_numero_carta(int id_region, int id_asignacion, String cadena_ciudades, String cadena_colonias, String cadena_codigos) {
        try {
            StartConn s = new StartConn();
            
            //SE HISO UNA MODIFICACION PARA QUE EL ID NO SE REPIRIERA EN EL FRONT END 
            //DE LE AGREGO UN PREFIJO "_C" AL NOMBRE DE LAS COLONIAS PARA QUE NO SE REPITIERAN Y CAUSARAN EL BUG
            //A QUI DE REMPLAZA LA PREFIJO "_C" POR EL VALOR DE NADA PARA QUE SE PUEDA EFECTUAR LA CONSULTA
            String n_cadena_colonias;
            n_cadena_colonias = cadena_colonias.replace("_C", "");
            
            
            String resultado = "SE HA ACTUALIZADO EL NUMERO DE VISITAS DE LAS CENTAS SELECCIONADAS";
            String sql = "UPDATE  arcade_call.arcade_carteos_cuentas \n"
                    + "SET carta = carta + 1 \n"
                    + "WHERE id_region = " + id_region + " \n"
                    + "AND id_asignacion IN (" + id_asignacion + ") \n"
                    + "AND ciudad IN (" + cadena_ciudades + ") \n"
                    + "AND colonia IN (" + n_cadena_colonias + ") \n"
                    + "AND codigo_postal IN (" + cadena_codigos + ") \n";
            System.out.println(sql);
            s.st.executeUpdate(sql);

            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
}
