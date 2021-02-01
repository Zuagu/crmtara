package arcade.data;

import arcade.model.UpdateCore;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
        

public class UpdateCoreDao {

    //==========================================================================
    public static String solicitud_core(String cuenta) {
        
      
        try {
            StartConn s = new StartConn();
            String response = "";
            String sql = "select concat( \n"
                    + "'#and#', columna1,'#and#', -- cuenta \n"
                    + "columna3,'#and#', -- expediente \n"
                    + "columna2,'#and#', -- nombre \n"
                    + "nombre_asignacion(id_asignacion),'#and#', -- asignacion \n"
                    + "columna77,'#and#', -- plan \n"
                    + "columna32,'#and#', -- ciudad \n"
                    + "columna36, '#and#', -- cp \n"
                    + "columna33,'#and#', -- colonia  \n"
                    + "columna31,'#and#', -- calle \n"
                    + "columna30 -- numero \n"
                    + ") as datos from arcade_basegeneral where columna1 = " + cuenta + " ;\n";
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            while (s.rs.next()) {
                response = (s.rs.getString("datos"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return response;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================

    public static String select_convenios_cuenta(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + "id_convenio, \n"
                    + "cuenta, \n"
                    + "convenio, \n"
                    + "id_usuario, \n"
                    + "fecha, \n"
                    + "date(fecha_insert) as fecha_insert, \n"
                    + "time(fecha_insert) as hora, \n"
                    + "aplica as aplica \n"
                    + "from arcade_convenios where cuenta = " + cuenta + " order by fecha_insert desc; \n";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<UpdateCore> updateCore = new ArrayList<UpdateCore>();
            while (s.rs.next()) {
                UpdateCore c = new UpdateCore();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_convenio(s.rs.getInt("id_convenio"));
                c.setCuenta(s.rs.getInt("cuenta"));
                c.setConvenio(s.rs.getFloat("convenio"));
                c.setId_usuario(s.rs.getInt("id_usuario"));
                c.setFecha(s.rs.getString("fecha"));
                c.setFecha_insert(s.rs.getString("fecha_insert"));
                c.setHora(s.rs.getString("hora"));
                c.setAplica(s.rs.getString("aplica"));
                updateCore.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th> FOLIO </th>"
                    + "<th> CUENTA </th>"
                    + "<th> CONVENIO </th>"
                    + "<th> ID_GESTOR </th>"
                    + "<th> FECHA CONVENIO </th>"
                    + "<th> FECHA INSERT </th>"
                    + "<th> HORA </th>"
                    + "<th> APLICA </th>"
                    + "<th> ELIMINAR </th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (UpdateCore c : updateCore) {
                renglones += ""
                        + "<tr id='" + c.getId_convenio() + "' class='select pointer colorSel'>"
                        + "<td id= 'id_convenio' style='text-align:left;'>" + c.getId_convenio() + "</td>"
                        + "<td style='text-align:left;'>" + c.getCuenta() + "</td>"
                        + "<td id= 'importe_convenio' style='text-align:left;'>" + c.getConvenio() + "</td>"
                        + "<td id= 'id_gestor' style='text-align:left;'>" + c.getId_usuario() + "</td>"
                        + "<td id= 'fecha_convenio' style='text-align:left;'>" + c.getFecha() + "</td>"
                        + "<td id= 'fecha_insert' style='text-align:left;'>" + c.getFecha_insert() + "</td>"
                        + "<td id= 'fecha_insert' style='text-align:left;'>" + c.getHora() + "</td>"
                        + "<td id= 'aplica' style='text-align:left;'>" + c.getAplica() + "</td>"
                        + "<td class='eliminar_convenio' id='eliminar_conv'" + c.getId_convenio() + " ' style='text-align:center;'> <i class='tiny material-icons' style='color:red;background-color: rgba(255, 0, 0,0.4);border-radius: 50%;padding: 2px;cursor: pointer;'>clear</i> </td>"
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
    public static String update_datos_convenio(int id_convenio, float convenio, int id_gestor, String fecha, float aplica) {
        try {
            StartConn s = new StartConn();
            String resultado = "";

            String sql = "INSERT INTO \n"
                    + " arcade_call.arcade_respaldo_updatecore (\n"
                    + " id_convenio, cuenta, convenio, id_gestor, fecha, fecha_update, comentario\n"
                    + " )\n"
                    + "SELECT \n"
                    + " id_convenio, cuenta, convenio, id_usuario, fecha, now(), 'ACTUALIZACION DE CONVENIO'\n"
                    + "FROM arcade_convenios\n"
                    + "WHERE id_convenio = " + id_convenio + ";";

            String sql2 = "UPDATE arcade_convenios \n "
                    + " SET \n"
                    + "convenio = " + convenio + ", \n"
                    + "fecha = '" + fecha + "', \n"
                    + "aplica = '" + aplica + "', \n"
                    + "id_usuario = " + id_gestor + " \n"
                    + "WHERE \n"
                    + "id_convenio = " + id_convenio + "; \n";

            s.st.executeUpdate(sql);
            System.out.println(sql);

            s.st.executeUpdate(sql2);
            System.out.println(sql2);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
    public static String select_tabla_telefono(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "CALL arcade_telefonos_cuenta(" + cuenta + ")";
            String renglones = "";
            int i;
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<UpdateCore> updateCore = new ArrayList<UpdateCore>();
            while (s.rs.next()) {
                UpdateCore c = new UpdateCore();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setTipo_tel(s.rs.getString("tipo_tel"));
                c.setNumero(s.rs.getString("numero"));
                c.setLlamando(s.rs.getString("llamando"));
                c.setNombre(s.rs.getString("nombre"));
                updateCore.add(c);
            }

            // CICLO PARA SEPARA LOS TIPOS DE NUMEROS POR TABLA COMO TENEOMOS TRES TIPOS DE REFERENCIAS SE REPITE 
            // TRES CLICLOS
            for (i = 0; i <= 2; i++) {
                System.out.println("vuelta " + i);
                renglones += "<table><thead><tr>";
                // ESTS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA

                renglones += "<th> NUMERO </th>"
                        + "<th> CODIGO </th>";

                if (i == 2) {
                    renglones += "<th> NOMBRE </th>";
                }

                renglones += "<th style='text-align: center;' > ELIMINAR </th></tr></thead><tbody>";

                // CUEPRO DE LA TABLA
                for (UpdateCore c : updateCore) {

                    if (i == 0) {
                        if (c.getLlamando().equals("T1") || c.getLlamando().equals("T2")) {
                            renglones += ""
                                    + "<tr id='" + cuenta + "' class='pointer selectTel3'>"
                                    + "<td id='numero_T' style='text-align:left;'>" + c.getNumero() + "</td>"
                                    + "<td id='codigo_T' style='text-align:left;'>" + c.getLlamando() + "</td>"
                                    + "<td id= 'eliminar1' style='text-align:center;'> <i class='tiny material-icons' style='color:red;background-color: rgba(255, 0, 0,0.4);border-radius: 50%;padding: 2px;cursor: pointer;'>clear</i> </td>"
                                    + "</tr>";
                        }

                    } else if (i == 1) {
                        if (c.getLlamando().equals("CR")) {
                            renglones += ""
                                    + "<tr id='" + cuenta + "' class='pointer selectTel2'>"
                                    + "<td id='numero_C' style='text-align:left;'>" + c.getNumero() + "</td>"
                                    + "<td id='codigo_C' style='text-align:left;'>" + c.getLlamando() + "</td>"
                                    + "<td id= 'eliminar2' style='text-align:center;'> <i class='tiny material-icons' style='color:red;background-color: rgba(255, 0, 0,0.4);border-radius: 50%;padding: 2px;cursor: pointer;'>clear</i> </td>"
                                    + "</tr>";
                        }

                    } else if (i == 2) {
                        if (c.getLlamando().equals("R1") || c.getLlamando().equals("R2")) {
                            renglones += ""
                                    + "<tr id= '' '" + cuenta + "' class='pointer selectTel1'>"
                                    + "<td id='numero_R' style='text-align:left;'>" + c.getNumero() + "</td>"
                                    + "<td id='codigo_R' style='text-align:left;'>" + c.getLlamando() + "</td>"
                                    + "<td id= 'nombre_R' style='text-align:left;'>" + c.getNombre() + "</td>"
                                    + "<td id= 'eliminar3' style='text-align:center;'> <i class='tiny material-icons' style='color:red;background-color: rgba(255, 0, 0,0.4);border-radius: 50%;padding: 2px;cursor: pointer;'>clear</i> </td>"
                                    + "</tr>";
                        }

                    }

                }
                renglones += "</tbody></table> #AND#";
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
    public static String update_cliente(String cuenta, String nombre, String plan, String ciudad, String cp, String colonia, String calle, String numero) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "INSERT INTO \n"
                    + " arcade_call.arcade_respaldo_updatecore ( \n"
                    + " columna2, columna77, columna32, columna36, columna33, columna31, columna30, cuenta, fecha_update, comentario \n"
                    + " )\n"
                    + "SELECT \n"
                    + " columna2, columna77, columna32, columna36, columna33, columna31, columna30, columna1, now(), 'ACTUALIZAR DATOS CLIENTE' \n"
                    + "FROM \n"
                    + " arcade_call.arcade_basegeneral \n"
                    + "WHERE \n"
                    + " columna1 = '" + cuenta + "';";

            String sql2 = "update arcade_basegeneral \n"
                    + "set \n"
                    + "columna2 = '" + nombre + "', -- nombre \n"
                    + "columna77 = '" + plan + "', -- plan \n"
                    + "columna32 = '" + ciudad + "', -- ciudad \n"
                    + "columna36= '" + cp + "', -- c.p. \n"
                    + "columna33= '" + colonia + "', -- colonia \n"
                    + "columna31= '" + calle + "', -- calle \n"
                    + "columna30= '" + numero + "' -- numero \n"
                    + "where columna1 ='" + cuenta + "';";

            s.st.executeUpdate(sql);
            System.out.println(sql);

            s.st.executeUpdate(sql2);
            System.out.println(sql2);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_datos_telefono1(int cuenta, String numero, String nombre, String tipo_tel) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql, sql2;

            // QUERY DE RESPALDO
            if (tipo_tel.equals("R1")) {
                sql = "INSERT INTO arcade_respaldo_updatecore (\n"
                        + " cuenta, nombre_referencia, numero_referencia, tipo_contacto, fecha_update, comentario\n"
                        + " )\n"
                        + "SELECT \n"
                        + " columna1, referencia1, tel_referencia1, '" + tipo_tel + "', now(), 'ACTUALIZACION DATOS REFERENCIA'\n"
                        + "FROM arcade_basegeneral \n"
                        + "WHERE columna1 = " + cuenta + "\n"
                        + "AND f_active = 1;";
            } else {
                sql = "INSERT INTO arcade_respaldo_updatecore (\n"
                        + " cuenta, nombre_referencia, numero_referencia, tipo_contacto, fecha_update, comentario\n"
                        + " )\n"
                        + "SELECT \n"
                        + " columna1, referencia1, tel_referencia1, '" + tipo_tel + "', now(), 'ACTUALIZACION DATOS REFERENCIA'\n"
                        + "FROM arcade_basegeneral \n"
                        + "WHERE columna1 = " + cuenta + "\n"
                        + "AND f_active = 1;";
            }

            // QUERY DEL UPDATE
            if (tipo_tel.equals("R1")) {
                sql2 = "UPDATE arcade_basegeneral\n"
                        + "SET  \n"
                        + "     tel_referencia1 = '" + numero + "',\n"
                        + "     referencia1 = '" + nombre + "'\n"
                        + "WHERE \n"
                        + "     columna1 = " + cuenta + "\n"
                        + "     AND f_active = 1;";
            } else {
                sql2 = "UPDATE arcade_basegeneral\n"
                        + "SET  \n"
                        + "     tel_referencia2 = '" + numero + "',\n"
                        + "     referencia2 = '" + nombre + "'\n"
                        + "WHERE \n"
                        + "     columna1 = " + cuenta + "\n"
                        + "     AND f_active = 1;";
            }

            s.st.executeUpdate(sql);
            s.st.executeUpdate(sql2);

            System.out.println(sql);
            System.out.println(sql2);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_datos_relacionada(int cuenta, String numero, String tipo, String ant_tel) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql, sql2, sql_select;
            int id_relacionada = 0;

            System.out.println("pasp por aqui");

            // QUERY DE RESPALDO
            sql = "INSERT INTO  arcade_respaldo_updatecore (\n"
                    + "    columna2,\n"
                    + "    cuenta,\n"
                    + "    telefono_cr,\n"
                    + "    tipo_contacto,\n"
                    + "    fecha_update,\n"
                    + "    comentario\n"
                    + ")\n"
                    + "SELECT \n"
                    + "    nombre,\n"
                    + "    cuenta, \n"
                    + "    numero_relacionado,\n"
                    + "    'CR',\n"
                    + "    NOW(),\n"
                    + "    'ACTUALIZACION DE TEL CR'\n"
                    + "FROM arcade_cuentas_relacionadas\n"
                    + "WHERE cuenta = " + cuenta + " AND numero_relacionado =  '" + ant_tel + "' LIMIT 1;";
            s.st.executeUpdate(sql);
            System.out.println(sql);

            // SELECT PARA OBTENER EL ID_RWLACIONADA
            sql_select = "SELECT id_relacionada FROM arcade_cuentas_relacionadas WHERE cuenta = " + cuenta + " AND numero_relacionado = '" + ant_tel + "' ORDER BY id_relacionada DESC LIMIT 1 ;";
            System.out.println(sql_select);
            s.rs = s.st.executeQuery(sql_select);
            while (s.rs.next()) {
                id_relacionada = s.rs.getInt("id_relacionada");
            }
            System.out.println(id_relacionada);

            // QUERY DEL UPDATE
            sql2 = "update arcade_cuentas_relacionadas\n"
                    + "set \n"
                    + " numero_relacionado = '" + numero + "' \n"
                    + "where id_relacionada = " + id_relacionada + " ;";

            s.st.executeUpdate(sql2);

            System.out.println(sql2);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_pagos_cuenta(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "select \n"
                    + " id_pago,\n"
                    + "    fecha_pago,\n"
                    + "    origen,\n"
                    + "    status,\n"
                    + "    importe,\n"
                    + "    fecha_aplicacion,\n"
                    + "    f_anticipado\n"
                    + "from arcade_pagos \n"
                    + "where cuenta = " + cuenta + " order by fecha_aplicacion desc;";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            System.out.println(sql);
            List<UpdateCore> updateCore = new ArrayList<UpdateCore>();
            while (s.rs.next()) {
                UpdateCore c = new UpdateCore();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId_pago(s.rs.getInt("id_pago"));
                c.setFecha_pago(s.rs.getString("fecha_pago"));
                c.setOrigen(s.rs.getString("origen"));
                c.setEstatus(s.rs.getString("status"));
                c.setImporte(s.rs.getString("importe"));
                c.setFecha_aplicacion(s.rs.getString("fecha_aplicacion"));
                c.setF_anticipado(s.rs.getInt("f_anticipado"));
                updateCore.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th> ID_PAGO </th>"
                    + "<th> FECHA PAGO </th>"
                    + "<th> ORIGEN </th>"
                    + "<th> STATUS </th>"
                    + "<th> IMPORTE </th>"
                    + "<th> FECHA APLICACION </th>"
                    + "<th> ANTICIPADO </th>"
                    + "<th style='text-align:center;'> ELIMINAR </th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (UpdateCore c : updateCore) {
                renglones += ""
                        + "<tr id='" + c.getId_pago() + "' class='selectPagos'>"
                        + "<td id= 'id_pago' style='text-align:left;'>" + c.getId_pago() + "</td>"
                        + "<td style='text-align:left;'>" + c.getFecha_pago() + "</td>"
                        + "<td id= '' style='text-align:left;'>" + c.getOrigen() + "</td>"
                        + "<td id= '' style='text-align:left;'>" + c.getEstatus() + "</td>"
                        + "<td id= '' style='text-align:left;'>" + c.getImporte() + "</td>"
                        + "<td id= '' style='text-align:left;'>" + c.getFecha_aplicacion() + "</td>"
                        + "<td id= '' style='text-align:left;'>" + (c.getF_anticipado() == 0 ? "NO" : "SI") + "</td>"
                        + "<td id= 'eliminar' style='text-align:center;'> <i class='tiny material-icons' style='color:red;background-color: rgba(255, 0, 0,0.4);border-radius: 50%;padding: 2px;cursor: pointer;'>clear</i> </td>"
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
    public static String delete_pago(int id_pago) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql_insert = "INSERT INTO arcade_respaldo_updatecore (\n"
                    + " cuenta,\n"
                    + "    importe_pago,\n"
                    + "    id_asignacion,\n"
                    + "    fecha_pago,\n"
                    + "    status,\n"
                    + "    origen,\n"
                    + "    fecha_aplicacion,\n"
                    + "    fecha_update,\n"
                    + "    comentario\n"
                    + ")\n"
                    + "SELECT \n"
                    + " cuenta,\n"
                    + "    importe,\n"
                    + "    id_asignacion,\n"
                    + "    fecha_pago,\n"
                    + " status,\n"
                    + "    origen,\n"
                    + "    fecha_aplicacion,\n"
                    + "    now(),\n"
                    + "    'ELIMINACION DE PAGOS'\n"
                    + "FROM arcade_pagos where id_pago = " + id_pago + ";";

            s.st.executeUpdate(sql_insert);
            System.out.println(sql_insert);

            String sql = "delete from arcade_pagos\n"
                    + "where id_pago = '" + id_pago + "' limit 1;";

            s.st.executeUpdate(sql);
            // QUERY DE RESPALDO
            System.out.println(sql);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String eliminar_telefonos_individual(int cuenta, String numero, String codigo) {
        try {
            StartConn s = new StartConn();
            String resultado = "", columnas="", tabla="", condicion="", columnas_delete="";
            String sql_respaldo, sql_eliminar, sql_select, id_cuenta = "";

            if (codigo.equals("R1")) {
                columnas = " columna2, columna1, referencia1, tel_referencia1, 'R1', '', id_asignacion, now(), 'ELIMINACION DE R1' ";
                tabla = " arcade_basegeneral ";
                condicion=" columna1 = " + cuenta + " and " + " tel_referencia1 = '" + numero + "' ; ";
                columnas_delete = "referencia1 = '', tel_referencia1 = '' ";

            }else if (codigo.equals("R2")) {
                columnas = " columna2, columna1, referencia2, tel_referencia2, 'R2', '', id_asignacion, now(), 'ELIMINACION DE R2' ";
                tabla = " arcade_basegeneral ";
                condicion=" columna1 = " + cuenta + " and " + " tel_referencia2 = '" + numero + "'; ";
                columnas_delete = "referencia2 = '', tel_referencia2 = '' ";

            }else if (codigo.equals("T1")) {
                columnas = " columna2, columna1, 'N/A', columna40, 'T1', '', id_asignacion, now(), 'ELIMINACION DE T1' ";
                tabla = " arcade_basegeneral ";
                condicion=" columna1 = " + cuenta + " and " + " columna40 = '" + numero + "'; ";
                columnas_delete = "columna40 = '' ";

            }else if (codigo.equals("T2")) {
                columnas = " columna2, columna1, 'N/A', columna80, 'T2', '', id_asignacion, now(), 'ELIMINACION DE T2' ";
                tabla = " arcade_basegeneral ";
                condicion=" columna1 = " + cuenta + " and " + " columna81 = '" + numero + "'; ";
                columnas_delete = "columna80 = '' ";

            }else if (codigo.equals("T3")) {
                columnas = " columna2, columna1, 'N/A', columna57, 'T3', '', id_asignacion, now(), 'ELIMINACION DE T3' ";
                tabla = " arcade_basegeneral ";
                condicion=" columna1 = " + cuenta + " and " + " columna57 = '" + numero + "'; ";
                columnas_delete = "columna57 = '' ";

            }else if (codigo.equals("CR")) {
                columnas = " nombre, cuenta, 'N/A', '', 'CR', numero_relacionado, id_asignacion, NOW(), 'ELIMINACION DE CR' ";
                tabla = " arcade_cuentas_relacionadas ";
                condicion=" cuenta = " + cuenta + " and " + " numero_relacionado = '" + numero + "';";

            }


            // QUERY DE RESPALDO
            sql_respaldo = "INSERT INTO arcade_respaldo_updatecore (\n"
                    + "    columna2, cuenta, nombre_referencia, numero_referencia, tipo_contacto, telefono_cr, id_asignacion, fecha_update, comentario\n"
                    + ") \n"
                    + "select " + columnas + " from " + tabla + " where " + condicion + " \n";
            System.out.println(sql_respaldo);
            s.st.executeUpdate(sql_respaldo);
            

            // SELECT PARA OBTENER EL ID_CUENTA O ID_RELACIONADA DEPENDIENDO QUE SE VAYA A ELMINAR
            if (codigo.equals("CR")) {      //condicion para saber que tipo de numero se va a eliminar 
                sql_select = "select id_relacionada as id from arcade_cuentas_relacionadas where cuenta = '" + cuenta + "' and numero_relacionado = '" + numero + "' limit 1;";
            } else {
                sql_select = "select id_cuenta as id from arcade_basegeneral where columna1 = '" + cuenta + "' order by fecha_fin desc limit 1;";
            }
            //ejecuta la consulta a la base de datos
            System.out.println(sql_select);
            s.rs = s.st.executeQuery(sql_select);
            while (s.rs.next()) {
                id_cuenta = s.rs.getString("id");
            }
            System.out.println(id_cuenta);

            // QUERY DEL UPDATE PARA ELIMINAR EL NUMERO
            if (codigo.equals("CR")) {
                sql_eliminar = "update arcade_cuentas_relacionadas \n"
                        + " set numero_relacionado = ''\n"
                        + "where id_relacionada = '" + id_cuenta + "';"; 
            } else {
                sql_eliminar = "update basegeneral \n"
                        + "set \n"
                        + " "+ columnas_delete +" \n" 
                        + " where id_cuenta = '" + id_cuenta + "'; \n";
            }

             s.st.executeUpdate(sql_eliminar);
            System.out.println(sql_eliminar);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
    public static String delete_todo(int cuenta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql_respaldo, sql_eliminar, sql_eliminar2;

            // QUERY DE RESPALDO
            sql_respaldo = "INSERT INTO arcade_respaldo_updatecore (\n"
                    + " columna2, cuenta, nombre_referencia, numero_referencia, tipo_contacto, telefono_cr, id_asignacion, fecha_update, comentario\n"
                    + ") \n"
                    + "SELECT * FROM ( \n"
                    + " #DATOS CR\n"
                    + " SELECT \n"
                    + "     nombre, \n"
                    + "     cuenta,\n"
                    + "        'N/A' AS nombre_r,\n"
                    + "        '' as tel,\n"
                    + "        'CR', \n"
                    + "        numero_relacionado, \n"
                    + "        id_asignacion, \n"
                    + "        now(), \n"
                    + "        'ELIMINACION DE NUMEROS CR DE TELEFONO' \n"
                    + "        FROM arcade_cuentas_relacionadas WHERE cuenta = '" + cuenta + "'\n"
                    + " UNION ALL\n"
                    + "    #DATOS DE T1\n"
                    + "    SELECT \n"
                    + "     columna2, \n"
                    + "        columna1,  \n"
                    + "        referencia1,\n"
                    + "        tel_referencia1,\n"
                    + "        'R1', \n"
                    + "        '',\n"
                    + "        id_asignacion,\n"
                    + "        now(),\n"
                    + "        'ELIMINACION DE NUMEROS DE R1 TELEFONO' \n"
                    + "        FROM arcade_basegeneral WHERE columna1 = '" + cuenta + "'\n"
                    + "     UNION ALL\n"
                    + "    #DATOS DE T2\n"
                    + "    SELECT \n"
                    + "     columna2, \n"
                    + "        columna1,  \n"
                    + "        referencia2,\n"
                    + "        tel_referencia2,\n"
                    + "        'R2', \n"
                    + "        '',\n"
                    + "        id_asignacion,\n"
                    + "        now(),\n"
                    + "        'ELIMINACION DE NUMEROS DE R1 TELEFONO' \n"
                    + "        FROM arcade_basegeneral WHERE columna1 = '" + cuenta + "'\n"
                    + ") AS src;";
            // s.ql_respaldo);
            
            System.out.println(sql_respaldo);
            s.st.executeUpdate(sql_respaldo);
            
            
            // QUERY DEL ELIMINAR
            sql_eliminar = "update arcade_cuentas_relacionadas \n"
                    + " set numero_relacionado = ''\n"
                    + "where cuenta = '" + cuenta + "';";

            sql_eliminar2 = " update arcade_basegeneral\n"
                    + " SET tel_referencia1 = '',\n"
                    + "    referencia1 = '',\n"
                    + "    tel_referencia2 = '',\n"
                    + "    columna40 = '',\n"
                    + "    columna81 = '',\n"
                    + "    columna57 = ''\n"
                    + "where \n"
                    + " columna1 = '" + cuenta + "';";

            s.st.executeUpdate(sql_eliminar);
            s.st.executeUpdate(sql_eliminar2);
            
            
            System.out.println(sql_eliminar);
            System.out.println(sql_eliminar2);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String delete_convenio(int id_convenio) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql_insert, sql_eliminar;

            sql_insert = "INSERT INTO \n"
                    + " arcade_call.arcade_respaldo_updatecore (\n"
                    + " id_convenio, cuenta, convenio, id_gestor, fecha, fecha_update, comentario\n"
                    + " )\n"
                    + "SELECT \n"
                    + " id_convenio, cuenta, convenio, id_usuario, fecha, now(), 'ELIMINACION DE CONVENIO'\n"
                    + "FROM arcade_convenios\n"
                    + "WHERE id_convenio = " + id_convenio + ";";
             s.st.executeUpdate(sql_insert);
            System.out.println(sql_insert);

            sql_eliminar = "delete from arcade_convenios  where id_convenio = '" + id_convenio + "' limit 1;";

             s.st.executeUpdate(sql_eliminar);
            // QUERY DE RESPALDO
            System.out.println(sql_eliminar);
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

    public static String select_tabla_gestiones(int cuenta) {
        try {
            StartConn s = new StartConn();
            String sql = "SELECT \n"
                    + "  id_gestion,\n"
                    + "     date(fecha_larga) as fecha,\n"
                    + "     time(fecha_larga) as hora,\n"
                    + "     numero_marcado as numero,\n"
                    + "     nombre_usuario_alias(id_gestor) as agente,\n"
                    + "     nombre_estatus_cuenta(id_estatus_cuenta) as estatus,\n"
                    + "     nombre_estatus_llamada(id_estatus_llamada) as subestatus,\n"
                    + "     gestion as disposicion,\n"
                    + "     duracion as tiempo\n"
                    + "FROM arcade_gestiones WHERE cuenta = '"+cuenta+"' ORDER BY fecha_larga DESC; \n";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            int i = 1;
            System.out.println(sql);
            List<UpdateCore> updateCore = new ArrayList<UpdateCore>();
            while (s.rs.next()) {
                UpdateCore c = new UpdateCore();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setGestion(s.rs.getString("id_gestion"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setNumero(s.rs.getString("numero"));
                c.setAgente(s.rs.getString("agente"));
                c.setEstatus(s.rs.getString("estatus"));
                c.setSubestatus(s.rs.getString("subestatus"));
                c.setDisposicion(s.rs.getString("disposicion"));
                c.setTiempo(s.rs.getString("tiempo"));
                updateCore.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width:1px; ' > # </th>"
                    + "<th> FECHA </th>"
                    + "<th> HORA </th>"
                    + "<th> NUMERO </th>"
                    + "<th> AGENTE </th>"
                    + "<th> ESTATUS </th>"
                    + "<th> SUBESTATUS </th>"
                    + "<th> DISPOSICION </th>"
                    + "<th> TIEMPO </th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (UpdateCore c : updateCore) {
                renglones += ""
                        + "<tr id='" + c.getGestion() + "' class='select_gestion' >"
                        + "<td id='num_num'>" + i + "</td>"
                        + "<td>" + c.getFecha() + "</td>"
                        + "<td>" + c.getHora() + "</td>"
                        + "<td class='num_id'>" + c.getNumero() + "</td>"
                        + "<td>" + c.getAgente() + "</td>"
                        + "<td class='get_estatus pointer colorBack'>" + c.getEstatus() + "</td>"
                        + "<td class='get_subestatus pointer colorBack'>" + c.getSubestatus() + "</td>"
                        + "<td>" + c.getDisposicion() + "</td>"
                        + "<td>" + c.getTiempo() + " </td>"
                        + "</tr>";
                i++;
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
    public static String actualizar_gestiones(int cuenta, int numero_tabla, int id_gestion, int estatus ) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql_update = "", sql_respaldo = "";

            sql_respaldo = "INSERT INTO arcade_respaldo_updatecore(  \n"
                    + " cuenta, id_asignacion, id_estatus_cuenta, fecha_update, comentario \n"
                    + " ) \n"
                    + "select cuenta, id_asignacion, id_estatus_cuenta, now(), 'SE HA CAMBIADO EL ESTATUS DE LA CUENTA' from arcade_gestiones where id_gestion = "+ id_gestion +";";
            s.st.executeUpdate(sql_respaldo);
            System.out.println(sql_respaldo);

            // Aqui hacemos la comparacion de ( si es la ultima gestion el que se modifico se actualiza tambien en basegeneral )
            if (numero_tabla == 1) {
                sql_update = " update arcade_basegeneral set ultimo_estatus_cuenta = " + estatus + " where columna1 = '" + cuenta + "' limit 1 ";
            }
            s.st.executeUpdate(sql_update);
            System.out.println(sql_update);
            
            //a qui se ejecuta la actualizacion de en la tabla de gestiones 
            sql_update = " update arcade_gestiones "
            +"  set id_estatus_cuenta = ' " + estatus + " ' \n"
            +"  where id_gestion = " + id_gestion + " limit 1;";

            s.st.executeUpdate(sql_update);
            System.out.println(sql_update);



            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
    public static String actualizar_subgestiones(int cuenta, int numero_tabla, int id_gestion, int estatus ) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql_update = "", sql_respaldo="";

            sql_respaldo = "INSERT INTO arcade_respaldo_updatecore(  \n"
                    + " cuenta, id_asignacion, id_estatus_llamadas, fecha_update, comentario \n"
                    + " ) \n"
                    + "select cuenta, id_asignacion, id_estatus_llamada, now(), 'SE HA CAMBIADO EL ESTATUS DE LA LLAMADA' from arcade_gestiones where id_gestion = "+ id_gestion +";";
            s.st.executeUpdate(sql_respaldo);
            System.out.println(sql_respaldo);

            // Aqui hacemos la comparacion de ( si es la ultima gestion el que se modifico se actualiza tambien en basegeneral )
            if (numero_tabla == 1) {
                sql_update = " UPDATE arcade_basegeneral SET ultimo_estatus_llamada = " + estatus + " WHERE columna1 = '" + cuenta + "' limit 1 ";
            }
            s.st.executeUpdate(sql_update);
            System.out.println(sql_update);
            
            //a qui se ejecuta la actualizacion de en la tabla de gestiones 
            sql_update = " update arcade_gestiones "
            +"  set id_estatus_llamada = " + estatus + " \n"
            +"  where id_gestion = " + id_gestion + " limit 1;";

            s.st.executeUpdate(sql_update);
            System.out.println(sql_update);



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
