package arcade.data;

import arcade.model.Solicitud;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* librerias Json */
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/* @author LUIS CORTEZ */
public class SolicitudDao {

    //==============================================================================
    public static String select_solicitud_tabla(String filtro) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_ingresos_tabla('" + filtro + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_solicitud(s.rs.getInt("id"));
                c.setSolicitud(s.rs.getString("nombre"));
                c.setEdad(s.rs.getInt("edad"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setFecha_alta(s.rs.getString("fecha"));
                c.setExp(s.rs.getString("exp"));
                c.setCelular(s.rs.getString("celular"));
                c.setContratacion(s.rs.getString("contratacion"));
                c.setReclutador(s.rs.getString("nom_reclutador"));
                c.setMedio(s.rs.getString("id_medio"));
                solicitud.add(c);
            }

            renglones = ""
                    + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                    + "<th style='padding-right: 0px; padding-left: 10px';>FOLIO</th>"
                    + "<th style='padding-right: 73px; padding-left: 0px';>NOMBRE</th>"
                    + "<th style='padding-right: 0px; padding-left: 0px';>EDAD</th>"
                    + "<th style='padding-right: 17px; padding-left: 0px';>PUESTO</th>"
                    + "<th style='padding-right: 20px; padding-left: 0px';>FECHA</th>"
                    + "<th style='padding-right: 32px; padding-left: 0px';>EXP</th>"
                    + "<th style='padding-right: 0px; padding-left: 0px';>CELULAR</th>"
                    + "<th style='padding-right: 0px; padding-left: 0px';>CONTRATADO</th>" //checar margins
                    + "<th style='padding-right: 32px; padding-left: 0px';>MEDIO</th>" //checar margins
                    + "<th style='padding-right: 0px; padding-left: 0px';>RECLUTADOR</th>" //checar margins
                    + "</tr></thead>"
                    //                    + "<tfoot><tr style=\"width: 100%;color: white; background-color: #b71c1c ;\">"
                    //                    + "<th style='padding: 0px 1.5%';>DEPARTAMENTO</th>"
                    //                    + "<th style='padding: 0px .01%';>PUESTO</th>"
                    //                    + "<th>VACANTE</th>"
                    //                    + "<th>%</th>"
                    //                    + "</tr></tfoot>"
                    + "<tbody>"
                    + "<tr><td colspan='10'>"
                    + "<div class='innerb'>"
                    + "<table class=''>"
                    + "<tbody>";

            // CUEPRO DE LA TABLA
            int i = 0;
            for (Solicitud c : solicitud) {
                i++;
                renglones += ""
                        + "<tr class='solicitud renglon' id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                        + "<td>" + i + "</td>"
                        + "<td>" + c.getSolicitud() + "</td>"
                        + "<td>" + c.getEdad() + "</td>"
                        + "<td>" + c.getPuesto() + "</td>"
                        + "<td>" + c.getFecha_alta() + "</td>"
                        + "<td>" + c.getExp() + "</td>"
                        + "<td>" + c.getCelular() + "</td>"
                        + "<td>" + c.getContratacion() + "</td>"
                        + "<td>" + c.getMedio() + "</td>"
                        + "<td>" + c.getReclutador() + "</td>"
                        + "</tr>";
            }

            renglones
                    += "</tbody>"
                    + "</table>"
                    + "</div>"
                    + "</td></tr>"
                    + "</tbody>"
                    + "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

//    //==============================================================================
//    public static String insert_solicitud() {
//        try {
//            StartConn s = new StartConn();
//            String sql = "call arcade_select_solicitud();";
//            String renglones = "";
//            s.rs = s.st.executeQuery(sql);
//            List<Solicitud> solicitud = new ArrayList<Solicitud>();
//            while (s.rs.next()) {
//                Solicitud e = new Solicitud();
//                e.setId_solicitud(s.rs.getInt("id_solicitud"));
//                e.setSolicitud(s.rs.getString("solicitud"));
//                solicitud.add(e);
//            }
//            for (Solicitud c : solicitud) {
//                renglones += "<option value='" + c.getId_solicitud() + "'>" + c.getSolicitud() + "</option>";
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
    public static String insert_solicitud(
            String nombre, String puesto, String fecha, String exp, String sucursal, String medio, String reclutador, String calle, String telefono, String celular, String colonia,
            String ciudad, String mail, String fecha_n, String lugar_n, String sexo, int edad, String num_imms, String clinica, String civil, String religion,
            String rfc, String dep_eco, String curp, String infonavit, String complexion, String edo_sal, String tipo_empleo, String cambio_res, String viajar, String auto,
            String lic, String extra, String tbj_act, String horario_1, String est_act, String horario_2, String call_center, String mora, String nivel, String grado,
            String idioma_1, int rango_1, String idioma_2, int rango_2, String software, String padre, String edad_padre, String domicilio_padre, String ocupacion_padre, String madre,
            String edad_madre, String domicilio_madre, String ocupacion_madre, String otro_1, String otro_1_edad, String otro_1_domicilio, String otro_1_ocupacion, String otro_2, String otro_2_edad, String otro_2_domicilio, String otro_2_ocupacion,
            String nombre_1, String giro_1, String area_1, String puesto_1, String domi_1, String dura_1, String mora_1, String tel_1, String jefe_1, String inicio_1, String termina_1, String sueldo_1, String comision_1, String producto_1, String motivo_1, String rh_1, String funcion_1, String tec_1,
            String nombre_2, String giro_2, String area_2, String puesto_2, String domi_2, String dura_2, String mora_2, String tel_2, String jefe_2, String inicio_2, String termina_2, String sueldo_2, String comision_2, String producto_2, String motivo_2, String rh_2, String funcion_2, String tec_2,
            String nombre_3, String giro_3, String area_3, String puesto_3, String domi_3, String dura_3, String mora_3, String tel_3, String jefe_3, String inicio_3, String termina_3, String sueldo_3, String comision_3, String producto_3, String motivo_3, String rh_3, String funcion_3, String tec_3,
            String virtud, String especificaMedio, String alias
    ) {
        // FUNCION PARA REMPLAZAR
        nombre = nombre.replace(',', ' ');
        calle = calle.replace(',', ' ');
        puesto = puesto.replace(',', ' ');
        colonia = colonia.replace(',', ' ');
        ciudad = ciudad.replace(',', ' ');
        mail = mail.replace(',', ' ');
        lugar_n = lugar_n.replace(',', ' ');
        dep_eco = dep_eco.replace(',', ' ');
        horario_1 = horario_1.replace(',', ' ');
        horario_2 = horario_2.replace(',', ' ');
        software = software.replace(',', ' ');
        domicilio_padre = domicilio_padre.replace(',', ' ');
        ocupacion_padre = ocupacion_padre.replace(',', ' ');
        domicilio_madre = domicilio_madre.replace(',', ' ');
        ocupacion_madre = ocupacion_madre.replace(',', ' ');
        otro_1_domicilio = otro_1_domicilio.replace(',', ' ');
        otro_1_ocupacion = otro_1_ocupacion.replace(',', ' ');
        otro_2_domicilio = otro_2_domicilio.replace(',', ' ');
        otro_2_ocupacion = otro_2_ocupacion.replace(',', ' ');

        nombre_1 = nombre_1.replace(',', ' ');
        giro_1 = giro_1.replace(',', ' ');
        area_1 = area_1.replace(',', ' ');
        puesto_1 = puesto_1.replace(',', ' ');
        domi_1 = domi_1.replace(',', ' ');
        dura_1 = dura_1.replace(',', ' ');
        mora_1 = mora_1.replace(',', ' ');
        jefe_1 = jefe_1.replace(',', ' ');
        producto_1 = producto_1.replace(',', ' ');
        motivo_1 = motivo_1.replace(',', ' ');
        rh_1 = rh_1.replace(',', ' ');
        funcion_1 = funcion_1.replace(',', ' ');
        tec_1 = tec_1.replace(',', ' ');

        nombre_2 = nombre_2.replace(',', ' ');
        giro_2 = giro_2.replace(',', ' ');
        area_2 = area_2.replace(',', ' ');
        puesto_2 = puesto_2.replace(',', ' ');
        domi_2 = domi_2.replace(',', ' ');
        dura_2 = dura_2.replace(',', ' ');
        mora_2 = mora_2.replace(',', ' ');
        jefe_2 = jefe_2.replace(',', ' ');
        producto_2 = producto_2.replace(',', ' ');
        motivo_2 = motivo_2.replace(',', ' ');
        rh_2 = rh_2.replace(',', ' ');
        funcion_2 = funcion_2.replace(',', ' ');
        tec_2 = tec_2.replace(',', ' ');

        nombre_3 = nombre_3.replace(',', ' ');
        giro_3 = giro_3.replace(',', ' ');
        area_3 = area_3.replace(',', ' ');
        puesto_3 = puesto_3.replace(',', ' ');
        domi_3 = domi_3.replace(',', ' ');
        dura_3 = dura_3.replace(',', ' ');
        mora_3 = mora_3.replace(',', ' ');
        jefe_3 = jefe_3.replace(',', ' ');
        producto_3 = producto_3.replace(',', ' ');
        motivo_3 = motivo_3.replace(',', ' ');
        rh_3 = rh_3.replace(',', ' ');
        funcion_3 = funcion_3.replace(',', ' ');
        tec_3 = tec_3.replace(',', ' ');
        virtud = virtud.replace(',', ' ');
        alias = alias.replace(',', ' ');

        try {
            StartConn s = new StartConn();
            String resultado;
            String sql = "INSERT INTO arcade_ingresos( \n"
                    + "fecha_insert, nombre, puesto, fecha, exp, sucursal, id_medio, reclutador, calle, telefono, celular, colonia, -- 12 \n"
                    + "ciudad, mail, fecha_nacimineto, lugar_nacimiento, sexo, edad, num_imss, clinica, civil, religion, -- 10 \n"
                    + "rfc, dep_eco, curp, infonavit, complexion, edo_sal, tipo_empleo, cambio_res, viajar, auto, -- 10 \n"
                    + "lic, extra, trabajo_act, horario_1, est_act, horario_2, call_center, mora, nivel, grado, -- 10 \n"
                    + "idioma_1, rango_1, idioma_2, rango_2, software, padre, edad_padre, domicilio_padre, ocupacion_padre, madre, -- 10  \n"
                    + "edad_madre, domicilio_madre, ocupacion_madre, otro_1, otro_1_edad, otro_1_domicilio, otro_1_ocupacion, otro_2, otro_2_edad, otro_2_domicilio, otro_2_ocupacion, -- 11 \n"
                    + "nombre_1, giro_1, area_1, puesto_1, domi_1, dura_1, mora_1, tel_1, jefe_1, inicio_1, termina_1, sueldo_1, comicion_1, producto_1, motivo_1, rh_1, funcion_1, tec_1, -- 18 \n"
                    + "nombre_2, giro_2, area_2, puesto_2, domi_2, dura_2, mora_2, tel_2, jefe_2, inicio_2, termina_2, sueldo_2, comicion_2, producto_2, motivo_2, rh_2, funcion_2, tec_2, -- 18 \n"
                    + "nombre_3, giro_3, area_3, puesto_3, domi_3, dura_3, mora_3, tel_3, jefe_3, inicio_3, termina_3, sueldo_3, comicion_3, producto_3, motivo_3, rh_3, funcion_3, tec_3,  -- 18 \n"
                    + "presentacion, experiencia, facilidad, normas, infliencia, equipo, estabilidad, logro, contratacion, fecha_ingreso, reclutador_rh, observacion, referido, virtud, especifica_medio, alias, evaluador_rh, anexo, anexo_rh \n"
                    + ")\n"
                    + "VALUES(\n"
                    + "NOW(),"
                    + "'" + nombre + "','" + puesto + "','" + fecha + "','" + exp + "','" + sucursal + "','" + medio + "','" + reclutador + "','" + calle + "','" + telefono + "','" + celular + "','" + colonia + "',\n"
                    + "'" + ciudad + "','" + mail + "','" + fecha_n + "','" + lugar_n + "','" + sexo + "'," + edad + ",'" + num_imms + "','" + clinica + "','" + civil + "','" + religion + "',\n"
                    + "'" + rfc + "','" + dep_eco + "','" + curp + "','" + infonavit + "','" + complexion + "','" + edo_sal + "','" + tipo_empleo + "','" + cambio_res + "','" + viajar + "','" + auto + "',\n"
                    + "'" + lic + "','" + extra + "','" + tbj_act + "','" + horario_1 + "','" + est_act + "','" + horario_2 + "','" + call_center + "','" + mora + "','" + nivel + "','" + grado + "',\n"
                    + "'" + idioma_1 + "'," + rango_1 + ",'" + idioma_2 + "'," + rango_2 + ",'" + software + "','" + padre + "','" + edad_padre + "','" + domicilio_padre + "','" + ocupacion_padre + "','" + madre + "',\n"
                    + "'" + edad_madre + "','" + domicilio_madre + "','" + ocupacion_madre + "','" + otro_1 + "','" + otro_1_edad + "','" + otro_1_domicilio + "','" + otro_1_ocupacion + "','" + otro_2 + "','" + otro_2_edad + "','" + otro_2_domicilio + "','" + otro_2_ocupacion + "',\n"
                    + "'" + nombre_1 + "','" + giro_1 + "','" + area_1 + "','" + puesto_1 + "','" + domi_1 + "','" + dura_1 + "','" + mora_1 + "','" + tel_1 + "','" + jefe_1 + "','" + inicio_1 + "','" + termina_1 + "','" + sueldo_1 + "','" + comision_1 + "','" + producto_1 + "','" + motivo_1 + "','" + rh_1 + "','" + funcion_1 + "','" + tec_1 + "',\n"
                    + "'" + nombre_2 + "','" + giro_2 + "','" + area_2 + "','" + puesto_2 + "','" + domi_2 + "','" + dura_2 + "','" + mora_2 + "','" + tel_2 + "','" + jefe_2 + "','" + inicio_2 + "','" + termina_2 + "','" + sueldo_2 + "','" + comision_2 + "','" + producto_2 + "','" + motivo_2 + "','" + rh_2 + "','" + funcion_2 + "','" + tec_2 + "',\n"
                    + "'" + nombre_3 + "','" + giro_3 + "','" + area_3 + "','" + puesto_3 + "','" + domi_3 + "','" + dura_3 + "','" + mora_3 + "','" + tel_3 + "','" + jefe_3 + "','" + inicio_3 + "','" + termina_3 + "','" + sueldo_3 + "','" + comision_3 + "','" + producto_3 + "','" + motivo_3 + "','" + rh_3 + "','" + funcion_3 + "','" + tec_3 + "',\n"
                    + "'" + "No evaluado" + "','" + "No evaluado" + "','" + "No evaluado" + "', '" + "No evaluado" + "', '" + "No evaluado" + "', '" + "No evaluado" + "', '" + "No evaluado" + "', '" + "No evaluado" + "', '" + "No evaluado" + "', '" + "0000-00-00" + "', '" + "No evaluado" + "', '" + "No evaluado" + "', '" + "No evaluado" + "', '" + virtud + "', '" + especificaMedio + "', '" + alias + "', '" + "No evaluado" + "','" + "No evaluado" + "','" + "No evaluado" + "' \n"
                    + ");\n";
//            System.out.println(sql);
            s.st.executeUpdate(sql);

            resultado = "se ha guardado si ingreso";

//            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_solicitud(int id_solicitud) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_solicitud('" + id_solicitud + "');";
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
    public static String delete_solicitud(int id_solicitud) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_solicitud('" + id_solicitud + "');";
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
    public static String select_datos_solicitud(int id_solicitud) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_ingreso('" + id_solicitud + "');";
//            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("datos_ingreso"));
//                System.out.println(resultado);
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
    public static String enviar_evaluacion(
            String dato1, String dato2, String dato3, String dato4, String dato5, String dato6, String dato7, String dato8, String dato9, String dato10,
            String dato11, String dato12, String dato13, String dato14, String dato15, int dato16, String dato17, String dato18, String dato19, String dato20,
            String dato21, String dato22, String dato23, String dato24, String dato25, String dato26, String dato27, String dato28, String dato29, String dato30, String dato31,
            String dato32, String dato33, String dato34, String dato35, String dato36, String dato37, String dato38, String dato39, String dato40,
            String dato41, int dato42, String dato43, int dato44, String dato45, String dato46, String dato47, String dato48, String dato49, String dato50,
            String dato51, String dato52, String dato53, String dato54, String dato55, String dato56, String dato57, String dato58, String dato59, String dato60,
            String dato61, String dato62, String dato63, String dato64, String dato65, String dato66, String dato67, String dato68, String dato69, String dato70,
            String dato71, String dato72, String dato73, String dato74, String dato75, String dato76, String dato77, String dato78, String dato79, String dato80,
            String dato81, String dato82, String dato83, String dato84, String dato85, String dato86, String dato87, String dato88, String dato89, String dato90,
            String dato91, String dato92, String dato93, String dato94, String dato95, String dato96, String dato97, String dato98, String dato99, String dato100,
            String dato101, String dato102, String dato103, String dato104, String dato105, String dato106, String dato107, String dato108, String dato109, String dato110,
            String dato111, String dato112, String dato113, String dato114, String dato115, String dato116,
            int id_solicitud, String presentacion, String experiencia, String facilidad, String normas, String influencia, String equipo, String estabilidad, String logro, String contratacion, String fecha_ingreso, String nombre_reclutador, String referido, String observacion, String virtud, String especificaMedio, String alias, String evaluador_rh, String anexo, String anexo_rh) {
        dato1 = dato1.replace(',', ' ');
        dato2 = dato2.replace(',', ' ');
        dato6 = dato6.replace(',', ' ');
        dato7 = dato7.replace(',', ' ');
        dato8 = dato8.replace(',', ' ');
        dato9 = dato9.replace(',', ' ');
        dato10 = dato10.replace(',', ' ');
        dato11 = dato11.replace(',', ' ');
        dato12 = dato12.replace(',', ' ');
        dato14 = dato14.replace(',', ' ');
        dato17 = dato17.replace(',', ' ');
        dato21 = dato21.replace(',', ' ');
        dato23 = dato23.replace(',', ' ');
        dato24 = dato24.replace(',', ' ');
        dato34 = dato34.replace(',', ' ');
        dato36 = dato36.replace(',', ' ');
        dato40 = dato40.replace(',', ' ');
        dato45 = dato45.replace(',', ' ');
        dato46 = dato46.replace(',', ' ');
        dato48 = dato48.replace(',', ' ');
        dato49 = dato49.replace(',', ' ');
        dato50 = dato50.replace(',', ' ');
        dato52 = dato52.replace(',', ' ');
        dato53 = dato53.replace(',', ' ');
        dato54 = dato54.replace(',', ' ');
        dato56 = dato56.replace(',', ' ');
        dato57 = dato57.replace(',', ' ');
        dato58 = dato58.replace(',', ' ');
        dato60 = dato60.replace(',', ' ');
        dato61 = dato61.replace(',', ' ');
        dato62 = dato62.replace(',', ' ');
        dato63 = dato63.replace(',', ' ');
        dato64 = dato64.replace(',', ' ');
        dato65 = dato65.replace(',', ' ');
        dato66 = dato66.replace(',', ' ');
        dato67 = dato67.replace(',', ' ');
        dato68 = dato68.replace(',', ' ');
        dato69 = dato69.replace(',', ' ');
        dato70 = dato70.replace(',', ' ');
        dato80 = dato80.replace(',', ' ');
        dato81 = dato81.replace(',', ' ');
        dato82 = dato82.replace(',', ' ');
        dato83 = dato83.replace(',', ' ');
        dato84 = dato84.replace(',', ' ');
        dato85 = dato85.replace(',', ' ');
        dato86 = dato86.replace(',', ' ');
        dato87 = dato87.replace(',', ' ');
        dato88 = dato88.replace(',', ' ');
        dato93 = dato93.replace(',', ' ');
        dato94 = dato94.replace(',', ' ');
        dato95 = dato95.replace(',', ' ');
        dato96 = dato96.replace(',', ' ');
        dato97 = dato97.replace(',', ' ');

        dato98 = dato98.replace(',', ' ');
        dato99 = dato99.replace(',', ' ');
        dato100 = dato100.replace(',', ' ');
        dato101 = dato101.replace(',', ' ');
        dato102 = dato102.replace(',', ' ');
        dato103 = dato103.replace(',', ' ');
        dato104 = dato104.replace(',', ' ');
        dato105 = dato105.replace(',', ' ');
        dato106 = dato106.replace(',', ' ');
        dato111 = dato111.replace(',', ' ');
        dato112 = dato112.replace(',', ' ');
        dato113 = dato113.replace(',', ' ');
        dato114 = dato114.replace(',', ' ');
        dato115 = dato115.replace(',', ' ');
        observacion = observacion.replace(',', ' ');
        referido = referido.replace(',', ' ');
        virtud = virtud.replace(',', ' ');
        alias = alias.replace(',', ' ');
        evaluador_rh = evaluador_rh.replace(',', ' ');
        anexo = anexo.replace(',', ' ');
        anexo_rh = anexo_rh.replace(',', ' ');
        try {
            StartConn s = new StartConn();
            String resultado = "ASPIRANTE EVALUADO";
            String sql = "update arcade_ingresos \n"
                    + "SET  \n"
                    + "    nombre = '" + dato1 + "', puesto = '" + dato2 + "', fecha = '" + dato3 + "', exp = '" + dato4 + "', id_medio= '" + dato5 + "', reclutador = '" + dato6 + "', calle = '" + dato7 + "', telefono = '" + dato8 + "',  \n"
                    + "    celular = '" + dato9 + "', colonia = '" + dato10 + "', ciudad = '" + dato11 + "', mail = '" + dato12 + "', fecha_nacimineto = '" + dato13 + "', lugar_nacimiento = '" + dato14 + "', sexo = '" + dato15 + "', edad =" + dato16 + ", num_imss = '" + dato17 + "', clinica = '" + dato18 + "',civil = '" + dato19 + "',religion = '" + dato20 + "', rfc = '" + dato21 + "', dep_eco = '" + dato22 + "', curp = '" + dato23 + "', infonavit = '" + dato24 + "',complexion = '" + dato25 + "',edo_sal = '" + dato26 + "',tipo_empleo = '" + dato27 + "',cambio_res = '" + dato28 + "',viajar= '" + dato29 + "',auto = '" + dato30 + "', lic = '" + dato31 + "', \n"
                    + "    extra = '" + dato32 + "',trabajo_act= '" + dato33 + "', horario_1 = '" + dato34 + "', est_act= '" + dato35 + "', horario_2 = '" + dato36 + "', call_center= '" + dato37 + "',mora = '" + dato38 + "',nivel = '" + dato39 + "', grado = '" + dato40 + "', idioma_1 = '" + dato41 + "',rango_1 = '" + dato42 + "', idioma_2 = '" + dato43 + "',rango_2 = '" + dato44 + "', software = '" + dato45 + "',  \n"
                    + "    padre = '" + dato46 + "', edad_padre = '" + dato47 + "', domicilio_padre = '" + dato48 + "', ocupacion_padre = '" + dato49 + "', madre = '" + dato50 + "', edad_madre = '" + dato51 + "', domicilio_madre = '" + dato52 + "', ocupacion_madre = '" + dato53 + "', otro_1 = '" + dato54 + "', otro_1_edad = '" + dato55 + "', otro_1_domicilio = '" + dato56 + "', otro_1_ocupacion = '" + dato57 + "', otro_2 = '" + dato58 + "', otro_2_edad = '" + dato59 + "', otro_2_domicilio = '" + dato60 + "', otro_2_ocupacion = '" + dato61 + "',  \n"
                    + "    nombre_1 = '" + dato62 + "', giro_1 = '" + dato63 + "', area_1 = '" + dato64 + "', puesto_1 = '" + dato65 + "', domi_1 = '" + dato66 + "', dura_1 = '" + dato67 + "', mora_1 = '" + dato68 + "', tel_1 = '" + dato69 + "', jefe_1 = '" + dato70 + "', inicio_1 = '" + dato71 + "', termina_1 = '" + dato72 + "', sueldo_1 = '" + dato73 + "', comicion_1 = '" + dato74 + "', producto_1 = '" + dato75 + "', motivo_1 = '" + dato76 + "', rh_1 = '" + dato77 + "', funcion_1 = '" + dato78 + "', tec_1 = '" + dato79 + "',  \n"
                    + "    nombre_2 = '" + dato80 + "', giro_2 = '" + dato81 + "', area_2 = '" + dato82 + "', puesto_2 = '" + dato83 + "', domi_2 = '" + dato84 + "', dura_2 = '" + dato85 + "', mora_2 = '" + dato86 + "', tel_2 = '" + dato87 + "', jefe_2 = '" + dato88 + "', inicio_2 = '" + dato89 + "', termina_2 = '" + dato90 + "', sueldo_2 = '" + dato91 + "', comicion_2 = '" + dato92 + "', producto_2 = '" + dato93 + "', motivo_2 = '" + dato94 + "', rh_2 = '" + dato95 + "', funcion_2 = '" + dato96 + "', tec_2 = '" + dato97 + "',  \n"
                    + "    nombre_3 = '" + dato98 + "', giro_3 = '" + dato99 + "', area_3 = '" + dato100 + "', puesto_3 = '" + dato101 + "', domi_3 = '" + dato102 + "', dura_3 = '" + dato103 + "', mora_3 = '" + dato104 + "', tel_3 = '" + dato105 + "', jefe_3 = '" + dato106 + "', inicio_3 = '" + dato107 + "', termina_3 = '" + dato108 + "', sueldo_3 = '" + dato109 + "', comicion_3 = '" + dato110 + "', producto_3 = '" + dato111 + "', motivo_3 = '" + dato112 + "', rh_3 = '" + dato113 + "', funcion_3 = '" + dato114 + "', tec_3 = '" + dato115 + "', sucursal = '" + dato116 + "',  \n"
                    + "    presentacion = '" + presentacion + "', experiencia = '" + experiencia + "', facilidad = '" + facilidad + "', normas = '" + normas + "', infliencia = '" + influencia + "', equipo = '" + equipo + "', estabilidad = '" + estabilidad + "', logro = '" + logro + "', contratacion = '" + contratacion + "', fecha_ingreso = '" + fecha_ingreso + "', reclutador_rh = '" + nombre_reclutador + "', referido = '" + referido + "' , observacion = '" + observacion + "', virtud = '" + virtud + "', especifica_medio ='" + especificaMedio + "', alias = '" + alias + "', evaluador_rh = '" + evaluador_rh + "', anexo ='" + anexo + "', anexo_rh ='" + anexo_rh + "' \n"
                    + "WHERE \n"
                    + "  id = " + id_solicitud + ";";
//            System.out.println(sql);
            s.st.executeUpdate(sql);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String insert_usuario(String nombre, String alias, String id_sucursal, String sexo, String telefono, String celular, String email, int codigo_reclutador
    ) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_usuario("
                    + "'" + nombre + "',"
                    + "'" + alias + "',"
                    + "'" + (id_sucursal.equals("Monterrey") ? 1 : 6) + "',"
                    + "'" + 0 + "',"
                    + "'" + 0 + "',"
                    + "'" + (sexo.equals("Hombre") ? "H" : "M") + "',"
                    + "'" + telefono + "',"
                    + "'" + celular + "',"
                    + "'" + email + "',"
                    + "'" + codigo_reclutador + "'"
                    + ");";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);

            String sql2 = "select id from arcade_usuarios order by id desc limit 1 ";

            s.rs = s.st.executeQuery(sql2);
//            System.out.println(sql2);

            while (s.rs.next()) {
                resultado += (s.rs.getString("id"));
            }
//            System.out.println(resultado);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    //==========================================================================
    public static String datos_grafica_dashboart() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select \n"
                    + "	id,\n"
                    + "    contratacion,\n"
                    + "    fecha_insert,\n"
                    + "    month(fecha_insert) as mes\n"
                    + "from arcade_ingresos\n"
                    + "where date(fecha_insert) >= '2019-01-01'\n"
                    + "order by year(fecha_insert),mes,contratacion; ";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_solicitud(s.rs.getInt("id"));
                c.setContratacion(s.rs.getString("contratacion"));
                c.setFecha_alta(s.rs.getString("fecha_insert"));
                c.setMes(s.rs.getInt("mes"));
                solicitud.add(c);
            }
            // desripcion[0] = mes \\\\ desripcion[2] = status contratacion
            int mes_anterior = 0, contador = 0;
            String[] desripcion = {"", ""};
            String[] nombre_mes = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            int[][] datos = new int[13][5];
            int[] mes = new int[12];

            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 5; j++) {
                    datos[i][j] = 0;
                }
            }

            for (Solicitud c : solicitud) {

                if (c.getMes() != mes_anterior || mes_anterior == 0) {
                    desripcion[0] += nombre_mes[c.getMes()] + ",";
                    mes_anterior = c.getMes();
                    mes[contador] = mes_anterior;
                    contador++;
//                    System.out.print(mes_anterior + "  ");
                }

                if (c.getContratacion().equals("Aprobado")) {
                    datos[mes_anterior][0] = datos[mes_anterior][0] + 1;
                } else if (c.getContratacion().equals("Caido")) {
                    datos[mes_anterior][1] = datos[mes_anterior][1] + 1;
                } else if (c.getContratacion().equals("No Aplica")) {
                    datos[mes_anterior][2] = datos[mes_anterior][2] + 1;
                } else if (c.getContratacion().equals("No evaluado")) {
                    datos[mes_anterior][3] = datos[mes_anterior][3] + 1;
                } else if (c.getContratacion().equals("Stand By")) {
                    datos[mes_anterior][4] = datos[mes_anterior][4] + 1;
                }

            }
//            System.out.println("contador " + contador);
//            for (int i = 0; i < 13; i++) {
//                for (int j = 0; j < 5; j++) {
//                    System.out.print(datos[i][j] + "   ");
//                }
//                System.out.println("\n");
//            }
//            System.out.println(desripcion[0]);

//            for (int i = 0; i < contador; i++) {
//                resultado += nombre_mes[mes[i]] + ",";
//            }
            resultado += desripcion[0];
            resultado += "#";

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < contador; j++) {
//                    System.out.println(mes[j]);
                    resultado += datos[mes[j]][i] + ",";
                }
                resultado += "#";
            }

//            System.out.println(resultado);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String datos_grafica_dashboart_mensual(int mes, String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "";
            if (mes == 0) {
                sql = "select \n"
                        + " id,\n"
                        + "    contratacion,\n"
                        + "    date(fecha) as fecha,\n"
                        + "    week(fecha) as semana,\n"
                        + "    month(fecha) as mes,\n"
                        + "    year(fecha) as ano\n"
                        + "from arcade_ingresos\n"
                        + "where \n"
                        + " date(fecha) between '" + desde + "' and '" + hasta + "' \n"
                        + " order by ano,semana,fecha; ";
            } else {
                sql = "select \n"
                        + " id,\n"
                        + "    contratacion,\n"
                        + "    date(fecha) as fecha,\n"
                        + "    week(fecha) as semana,\n"
                        + "    month(fecha) as mes,\n"
                        + "    year(fecha) as ano\n"
                        + "from arcade_ingresos\n"
                        + "where \n"
                        + " month(fecha) = '" + mes + "'\n"
                        + " order by ano,semana,fecha; ";
            }
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_solicitud(s.rs.getInt("id"));
                c.setContratacion(s.rs.getString("contratacion"));
                c.setFecha(s.rs.getString("fecha"));
                c.setSemana(s.rs.getInt("semana"));
                c.setMes(s.rs.getInt("mes"));
                c.setAno(s.rs.getInt("ano"));
                solicitud.add(c);
            }
            // loop para obtener la longitud de las graficas
            int semana_anterior = 100, limite_graficas = 0;
            for (Solicitud c : solicitud) {
                if (c.getSemana() != semana_anterior || semana_anterior == 100) {
                    semana_anterior = c.getSemana();
                    limite_graficas++;
                }
            }
//            System.out.println(limite_graficas);
            // definimos las variables a usar
            semana_anterior = 100;
            int contador = 0;
            String[] desripcion = {"", ""};
            int[][] datos = new int[5][limite_graficas];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < limite_graficas; j++) {
                    datos[i][j] = 0;
                }
            }

//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < limite_graficas; j++) {
//                    System.out.print(datos[i][j] + ", ");
//                }
//                System.out.println("\n");
//            }
            for (Solicitud c : solicitud) {

                if (c.getSemana() != semana_anterior || semana_anterior == 100) {
                    desripcion[0] += "Semana" + (c.getSemana() + 1) + "(" + c.getFecha() + "),";
                    semana_anterior = c.getSemana();
                    contador++;
//                    System.out.print(semana_anterior + "  ");
                }
//                System.out.print(contador - 1);
                if (c.getContratacion().equals("Aprobado")) {
                    datos[0][(contador - 1)] = datos[0][(contador - 1)] + 1;
                } else if (c.getContratacion().equals("Caido")) {
                    datos[1][(contador - 1)] = datos[1][(contador - 1)] + 1;
                } else if (c.getContratacion().equals("No Aplica")) {
                    datos[2][(contador - 1)] = datos[2][(contador - 1)] + 1;
                } else if (c.getContratacion().equals("No evaluado")) {
                    datos[3][(contador - 1)] = datos[3][(contador - 1)] + 1;
                } else if (c.getContratacion().equals("Stand By")) {
                    datos[4][(contador - 1)] = datos[4][(contador - 1)] + 1;
                }

            }
//            System.out.println("\n contador " + contador);
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < limite_graficas; j++) {
//                    System.out.print(datos[i][j] + "   ");
//                }
//                System.out.println("\n");
//            }
//            System.out.println(desripcion[0]);

            resultado += desripcion[0];

            resultado += "#";

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < contador; j++) {
                    resultado += datos[i][j] + ",";
                }
                resultado += "#";
            }

//            System.out.println(resultado);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String datos_grafica_dashboart_dos(String desde, String hasta, int opcion) {
        try {

            StartConn s = new StartConn();
            String res = "";
            String sql = "call arcade_select_datos_dashboart_dos('" + desde + "','" + hasta + "','" + opcion + "');";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_reclutador(s.rs.getInt("reclutador"));
                c.setContratacion(s.rs.getString("contratacion"));
                c.setNombre(s.rs.getString("nombre"));
                solicitud.add(c);
            }
            // loop para obtener la cantidad de reclutadores que hay en ese rango de fecha
            int reclutador_anterior = 100, cantidad_reclutadores = 0;
            for (Solicitud c : solicitud) {
                if (c.getId_reclutador() != reclutador_anterior || reclutador_anterior == 100) {
                    reclutador_anterior = c.getId_reclutador();
                    cantidad_reclutadores++;
                }
            }
            // variables a usar para allmacenar los ciclos 
            // se crearan dos cadenas en caso usar mas datos se añade mas cadenas 
            String[] nombres = new String[cantidad_reclutadores];
            int[] entrevistas = new int[cantidad_reclutadores];
            int[] ingresos = new int[cantidad_reclutadores];
            int contador = 0;
            reclutador_anterior = 100;
            //objetivos con este ciclo for 
            // obtener el numero de entrvistas que tiene cada reclutador
            for (Solicitud c : solicitud) {
                if (c.getId_reclutador() != reclutador_anterior || reclutador_anterior == 100) {
                    reclutador_anterior = c.getId_reclutador();
                    nombres[contador] = "\"" + c.getNombre() + "\"";

                    contador++;
                }
                entrevistas[(contador - 1)]++;
                if (c.getContratacion().equals("Aprobado")) {
                    ingresos[(contador - 1)]++;
                }
            }
            res += "{\"reclutador\":" + Arrays.asList(nombres) + ",\"entevistas\":" + Arrays.toString(entrevistas) + ",\"ingreso\":" + Arrays.toString(ingresos) + "}";
//            System.out.println(res);
//            System.out.println(Arrays.asList(nombres));
//            System.out.println(Arrays.toString(entrevistas));
//            System.out.println(Arrays.toString(ingresos));
            s.rs.close();
            s.st.close();
            s.conn.close();
            return res;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_activos(String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_activos_dashboard()";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_activos_total(String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_total_dashboard();";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_entrevista(String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_entrevistas_dashboard();";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha(s.rs.getString("fecha"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                c.setContratacion(s.rs.getString("contratacion"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "<th>CONTRATACION</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='7'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "<td>" + c.getContratacion() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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

    public static String select_ingresos(String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_ingresos_dashboard();";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_bajas(String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_bajas_dashboard();";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_baja(s.rs.getString("fecha_baja"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_baja() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String datos_grafica_dashboart3(int mes, String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_datos_grafica_dashboard_tres('" + mes + "','" + desde + "','" + hasta + "');";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            /* Aqui empieza el desmadre  XD */
            JSONArray datos = new JSONArray();

            JSONObject objetos_datos1 = new JSONObject();
            int i = 0, j = 0, k = 0, old_id_reclutador = 0;
            String old_medio = "", old_especifica_medio = "";

            objetos_datos1.put("id", i + "." + j);
            objetos_datos1.put("parent", "");
            objetos_datos1.put("name", "SICSA(Reclutadores)");

            datos.add(objetos_datos1);

            while (s.rs.next()) {
                /* comparador para obtener los datos de los reclutadores "nivel 1" */
                if (s.rs.getInt("reclutador") != old_id_reclutador || old_id_reclutador == 0) {
                    JSONObject objetos_datos = new JSONObject();
                    i++;
                    objetos_datos.put("id", "1." + i);
                    objetos_datos.put("parent", "0.0");
                    objetos_datos.put("name", s.rs.getString("nombre"));

//                    System.out.println(objetos_datos);
                    datos.add(objetos_datos);
                    old_medio = "";

                }
                /* comparador para obtener los medios de los reclutadores "nivel 2" */
                if (s.rs.getString("id_medio").equals("") || !s.rs.getString("id_medio").equals(old_medio)) {
                    JSONObject objetos_datos = new JSONObject();
                    j++;
                    objetos_datos.put("id", "2." + j);
                    objetos_datos.put("parent", "1." + i);
                    objetos_datos.put("name", s.rs.getString("id_medio"));

//                    System.out.println(objetos_datos);
                    datos.add(objetos_datos);
                    old_especifica_medio = "";
                }
                /* comparador para obtener el especifica_medios de los reclutadores "nivel 3" */
//                System.out.println(s.rs.getString("especifica_medio") + "  " + old_especifica_medio);
                if (s.rs.getString("especifica_medio").equals("") || !s.rs.getString("especifica_medio").equals(old_especifica_medio)) {
                    JSONObject objetos_datos = new JSONObject();
                    k++;
                    objetos_datos.put("id", "3." + k);
                    objetos_datos.put("parent", "2." + j);
                    objetos_datos.put("name", s.rs.getString("especifica_medio"));
                    objetos_datos.put("value", new Integer(s.rs.getInt("numero")));

//                    System.out.println(objetos_datos);
                    datos.add(objetos_datos);
//                    contador_entrevistas = 0;
                }

                old_id_reclutador = s.rs.getInt("reclutador");
                old_medio = s.rs.getString("id_medio");
                old_especifica_medio = s.rs.getString("especifica_medio");
//                contador_entrevistas++;

            }
            System.out.println(datos);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return datos.toString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_permanencia(String desde, String hasta, String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_permanencia_usuarios('" + desde + "','" + hasta + "');";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_datos_informe_vacantes(String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "    especifica_medio,\n"
                    + "    count(id) as numero\n"
                    + "from arcade_ingresos \n"
                    + "where fecha between '" + desde + "' and '" + hasta + "' \n"
                    + "group by especifica_medio\n"
                    + "order by especifica_medio;";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);

            JSONObject datos_tabla1 = new JSONObject();
            JSONObject datos_tabla2 = new JSONObject();

            while (s.rs.next()) {
                datos_tabla1.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }
            String sql_2 = "select \n"
                    + "    i.especifica_medio,\n"
                    + "    count(i.id) as numero\n"
                    + "from  arcade_usuarios u\n"
                    + "left join arcade_ingresos i on i.nombre = u.nombre\n"
                    + "where date(u.fecha_alta) between '" + desde + "' and '" + hasta + "'  \n"
                    + "group by i.especifica_medio\n"
                    + "order by i.especifica_medio;";
            s.rs = s.st.executeQuery(sql_2);
//            System.out.println(sql_2);

            while (s.rs.next()) {
                datos_tabla2.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }

            String sql_3 = "select \n"
                    + "    especifica_medio,\n"
                    + "    count(id) as numero\n"
                    + "from arcade_ingresos \n"
                    + "where fecha_ingreso between '" + desde + "' and '" + hasta + "'  \n"
                    + "group by especifica_medio\n"
                    + "order by especifica_medio;";
            s.rs = s.st.executeQuery(sql_3);
//            System.out.println(sql_3);

            JSONObject datos_tabla3 = new JSONObject();

            while (s.rs.next()) {
                datos_tabla3.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }

            String sql_4 = "select especifica_medio,count(id_cita) as numero from citados \n"
                    + "where fecha between '" + desde + "' and '" + hasta + "' group by especifica_medio order by especifica_medio;";
            s.rs = s.st.executeQuery(sql_4);
//            System.out.println(sql_4);

            JSONObject datos_tabla4 = new JSONObject();

            while (s.rs.next()) {
                datos_tabla4.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }

//            System.out.println(datos_tabla1);
//            System.out.println(datos_tabla2);
//            System.out.println(datos_tabla3);
//            System.out.println(datos_tabla4);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return datos_tabla1.toString() + "##" + datos_tabla2.toString() + "##" + datos_tabla3.toString() + "##" + datos_tabla4.toString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_ingresos_rango(String desde, String hasta, String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_ingresos_rango('" + desde + "','" + hasta + "');";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_bajas_rango(String desde, String hasta, String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_bajas_rango('" + desde + "','" + hasta + "');";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_baja(s.rs.getString("fecha_baja"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='6'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha_baja() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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

    public static String select_entrevistas_rango(String desde, String hasta, String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_entrevista_rango('" + desde + "','" + hasta + "');";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha(s.rs.getString("fecha"));
                c.setMedio(s.rs.getString("id_medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setReclutador(s.rs.getString("alias"));
                c.setContratacion(s.rs.getString("contratacion"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>FECHA</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>RECLUTADOR</th>"
                        + "<th>CONTRATACION</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='7'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                int i = 0;
                for (Solicitud c : solicitud) {
                    i++;
                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + +c.getId_solicitud() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getFecha() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "<td>" + c.getContratacion() + "</td>"
                            + "</tr>";
                }

                resultado
                        += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";

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
    public static String select_datos_informe_reclutadores(String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            String sql = "call informe_de_reclutadores('" + desde + "', '" + hasta + "');";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);

            int old_id = 0, citados = 0, ingresos = 0, entrevistas = 0, programados = 0;
            String old_nombre = "";

            String informe = "";
            JSONObject reporte = new JSONObject();
                    JSONObject reclutadorR = new JSONObject();

            while (s.rs.next()) {

                if (old_id == 0 || old_id != s.rs.getInt("id_reclutador")) {
                    JSONObject reclutador = new JSONObject();

                    reclutador.put("Nombre", old_nombre);
                    reclutador.put("Citados", citados);
                    reclutador.put("Ingresos", ingresos);
                    reclutador.put("Entrevistas", entrevistas);
                    reclutador.put("Programados", programados);

                    reporte.put(old_id, reclutador);

                    System.out.println(s.rs.getInt("id_reclutador"));

                    old_id = s.rs.getInt("id_reclutador");
                    old_nombre = s.rs.getString("nombre");
                    //reseteo de variable
                    citados = 0;
                    ingresos = 0;
                    entrevistas = 0;
                    programados = 0;

                }

                if (s.rs.getString("tipo").equals("Citados")) {
                    citados = s.rs.getInt("numero");
                }
                if (s.rs.getString("tipo").equals("Ingresos")) {
                    ingresos = s.rs.getInt("numero");
                }
                if (s.rs.getString("tipo").equals("Entrevistas")) {
                    entrevistas = s.rs.getInt("numero");
                }
                if (s.rs.getString("tipo").equals("Programados")) {
                    programados = s.rs.getInt("numero");
                }

            }
            reclutadorR.put("Nombre", old_nombre);
            reclutadorR.put("Citados", citados);
            reclutadorR.put("Ingresos", ingresos);
            reclutadorR.put("Entrevistas", entrevistas);
            reclutadorR.put("Programados", programados);
            
            reporte.put(old_id, reclutadorR);
            
            System.out.println(reporte);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return reporte.toString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_reclutadores() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "select id, alias from arcade_usuarios where id_puesto = 21 and f_active = 1;";
            s.rs = s.st.executeQuery(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud e = new Solicitud();
                e.setId_reclutador(s.rs.getInt("id"));
                e.setNombre(s.rs.getString("alias"));
                solicitud.add(e);
            }
            for (Solicitud c : solicitud) {
                renglones += "<option value='" + c.getId_reclutador() + "'>" + c.getNombre() + "</option>";
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
    public static String select_datos_informe_individual_vacantes(String desde, String hasta, String id_reclutador) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "    especifica_medio,\n"
                    + "    count(id) as numero\n"
                    + "from arcade_ingresos \n"
                    + "where fecha between '" + desde + "' and '" + hasta + "' and reclutador = '" + id_reclutador + "' \n"
                    + "group by especifica_medio\n"
                    + "order by especifica_medio;";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);

            JSONObject datos_tabla1 = new JSONObject();
            JSONObject datos_tabla2 = new JSONObject();

            while (s.rs.next()) {
                datos_tabla1.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }
            String sql_2 = "select \n"
                    + "    i.especifica_medio,\n"
                    + "    count(i.id) as numero\n"
                    + "from  arcade_usuarios u\n"
                    + "left join arcade_ingresos i on i.nombre = u.nombre\n"
                    + "where date(u.fecha_alta) between '" + desde + "' and '" + hasta + "' and i.reclutador = '" + id_reclutador + "' \n"
                    + "group by i.especifica_medio\n"
                    + "order by i.especifica_medio;";
            s.rs = s.st.executeQuery(sql_2);
            System.out.println(sql_2);

            while (s.rs.next()) {
                datos_tabla2.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }

            String sql_3 = "select \n"
                    + "    especifica_medio,\n"
                    + "    count(id) as numero\n"
                    + "from arcade_ingresos \n"
                    + "where fecha_ingreso between '" + desde + "' and '" + hasta + "' and reclutador = '" + id_reclutador + "' \n"
                    + "group by especifica_medio\n"
                    + "order by especifica_medio;";
            s.rs = s.st.executeQuery(sql_3);
            System.out.println(sql_3);

            JSONObject datos_tabla3 = new JSONObject();

            while (s.rs.next()) {
                datos_tabla3.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }

            String sql_4 = "select especifica_medio,count(id_cita) as numero from citados \n"
                    + "where fecha between '" + desde + "' and '" + hasta + "'  and id_reclutador = '" + id_reclutador + "' group by especifica_medio order by id_reclutador;";

            s.rs = s.st.executeQuery(sql_4);
            System.out.println(sql_4);

            JSONObject datos_tabla4 = new JSONObject();

            while (s.rs.next()) {
                datos_tabla4.put(s.rs.getString("especifica_medio"), new Integer(s.rs.getInt("numero")));
            }

            String sql_5 = "select nombre_usuario_alias(" + id_reclutador + ") as Reclutador", nombre = "";
            s.rs = s.st.executeQuery(sql_5);
            while (s.rs.next()) {
                nombre = s.rs.getString("Reclutador");
            }

//            System.out.println(datos_tabla1);
//            System.out.println(datos_tabla2);
//            System.out.println(datos_tabla3);
//            System.out.println(datos_tabla4); 
            s.rs.close();
            s.st.close();
            s.conn.close();
            return datos_tabla1.toString() + "##" + datos_tabla2.toString() + "##" + datos_tabla3.toString() + "##" + datos_tabla4.toString() + "##" + nombre;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String resumen_reclutadores() {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "select id, alias from arcade_usuarios where id_puesto = 21 and f_active = 1;";
            s.rs = s.st.executeQuery(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud e = new Solicitud();
                e.setId_reclutador(s.rs.getInt("id"));
                e.setNombre(s.rs.getString("alias"));
                solicitud.add(e);
            }
            for (Solicitud c : solicitud) {
                renglones += "<option value='" + c.getId_reclutador() + "'>" + c.getNombre() + "</option>";
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

    public static String select_citados_rango(String desde, String hasta, String opcion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select id_cita, nombre_usuario_alias(id_reclutador) as recl, nombre, fecha_insert, medio, especifica_medio, fecha, puesto, status_cita, hora, contacto from citados where  if('" + desde + "' = '0000-00-00', fecha = curdate() , fecha between '" + desde + "' and '" + hasta + "' ) ;";
            s.rs = s.st.executeQuery(sql);
//            System.out.println(sql);
            List<Solicitud> solicitud = new ArrayList<Solicitud>();
            while (s.rs.next()) {
                Solicitud c = new Solicitud();
                //estos son los encabezadso de la columna de la tabla de mysql
                c.setId_solicitud(s.rs.getInt("id_cita"));
                c.setNombre(s.rs.getString("nombre"));
                c.setFecha_alta(s.rs.getString("fecha"));
                c.setMedio(s.rs.getString("medio"));
                c.setEspecifica_medio(s.rs.getString("especifica_medio"));
                c.setFecha(s.rs.getString("hora"));
                c.setReclutador(s.rs.getString("recl"));
                solicitud.add(c);
//                System.out.println(solicitud.size());
            }
            if (opcion.equals("valor")) {
                resultado = Integer.toString(solicitud.size());
            } else {
                resultado = ""
                        + "<table id='tabla_solicitudes' class='striped bordered highlight'><thead><tr>"
                        + "<th>NOMBRE</th>"
                        + "<th>MEDIO</th>"
                        + "<th>ESP. MEDIO</th>"
                        + "<th>FECHA</th>"
                        + "<th>HORA</th>"
                        + "<th>RECLUTADOR</th>"
                        + "</tr></thead>"
                        + "<tbody>"
                        + "<tr><td colspan='7'>"
                        + "<div class='innerb'>"
                        + "<table class=''>"
                        + "<tbody>";

                // CUEPRO DE LA TABLA
                for (Solicitud c : solicitud) {

                    resultado += ""
                            + "<tr id='" + c.getId_solicitud() + "' style='cursor: pointer;'>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getMedio() + "</td>"
                            + "<td>" + c.getEspecifica_medio() + "</td>"
                            + "<td>" + c.getFecha_alta() + "</td>"
                            + "<td>" + c.getFecha() + "</td>"
                            + "<td>" + c.getReclutador() + "</td>"
                            + "</tr>";
                }
                resultado += "</tbody>"
                        + "</table>"
                        + "</div>"
                        + "</td></tr>"
                        + "</tbody>"
                        + "</table>";
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
