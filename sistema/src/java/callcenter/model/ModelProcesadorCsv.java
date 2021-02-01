package callcenter.model;

import java.sql.SQLException;

/**
 *
 * @author zuagu
 */
public class ModelProcesadorCsv {

    public static String cargar_base_azteca(String dirFile) {
        try {

            StartConexion ic = new StartConexion();
            String sql_import_csv = "LOAD DATA LOCAL INFILE '" + dirFile + "' INTO TABLE azteca_carga_diaria \n"
                    + "FIELDS TERMINATED BY ',' \n"
                    + "LINES TERMINATED BY '\\n' \n"
                    + "IGNORE 1 ROWS (@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10,\n"
                    + "@col11, @col12, @col13, @col14, @col15, @col16, @col17, @col18, @col19, @col20,\n"
                    + "@col21, @col22, @col23, @col24, @col25, @col26, @col27, @col28, @col29, @col30,\n"
                    + "@col31, @col32, @col33, @col34, @col35, @col36, @col37, @col38, @col39, @col40,\n"
                    + "@col41, @col42, @col43, @col44, @col45, @col46, @col47, @col48, @col49, @col50,\n"
                    + "@col51, @col52, @col53, @col54, @col55, @col56, @col57, @col58, @col59, @col60,\n"
                    + "@col61, @col62, @col63, @col64, @col65, @col66, @col67, @col68, @col69, @col70,\n"
                    + "@col71, @col72, @col73, @col74, @col75, @col76, @col77, @col78, @col79, @col80,\n"
                    + "@col81, @col82, @col83)\n"
                    + "set \n"
                    + "CLIENTE_UNICO=@col1,\n"
                    + "NOMBRE_CTE=@col2,\n"
                    + "CUADRANTE=@col3,\n"
                    + "ZONA_GEO=@col4,\n"
                    + "RFC_CTE=@col5,\n"
                    + "ID_DESPACHO=@col6,\n"
                    + "DIRECCION_CTE=@col7,\n"
                    + "NUM_EXT_CTE=@col8,\n"
                    + "NUM_INT_CTE=@col9,\n"
                    + "CP_CTE=@col10,\n"
                    + "COLONIA_CTE=@col11,\n"
                    + "POBLACION_CTE=@col12,\n"
                    + "ESTADO_CTE=@col13,\n"
                    + "CLASIFICACION_CTE=@col14,\n"
                    + "ATRASO_MAXIMO=@col15,\n"
                    + "SALDO=@col16,\n"
                    + "MORATORIOS=@col17,\n"
                    + "SALDO_TOTAL=@col18,\n"
                    + "DIA_DE_PAGO=@col19,\n"
                    + "FECHA_ULTIMO_PAGO=@col20,\n"
                    + "ANO=@col21,\n"
                    + "IMP_ULTIMO_PAGO=@col22,\n"
                    + "CALLE_EMPLEO=@col23,\n"
                    + "NUM_EXT_EMPLEO=@col24,\n"
                    + "NUM_INT_EMPLEO=@col25,\n"
                    + "COLONIA_EMPLEO=@col26,\n"
                    + "POBLACION_EMPLEO=@col27,\n"
                    + "ESTADO_EMPLEO=@col28,\n"
                    + "NOMBRE_AVAL=@col29,\n"
                    + "TELAVAL=@col30,\n"
                    + "CALLEAVAL=@col31,\n"
                    + "NUMEXTAVAL=@col32,\n"
                    + "COLONIAAVAL=@col33,\n"
                    + "CPAVAL=@col34,\n"
                    + "POBLACIONAVAL=@col35,\n"
                    + "ESTADOAVAL=@col36,\n"
                    + "DIA_PAGO=@col37,\n"
                    + "TELEFONO1=@col38,\n"
                    + "TIPOTEL1=@col39,\n"
                    + "TELEFONO2=@col40,\n"
                    + "TIPOTEL2=@col41,\n"
                    + "TELEFONO3=@col42,\n"
                    + "TIPOTEL3=@col43,\n"
                    + "TELEFONO4=@col44,\n"
                    + "TIPOTEL4=@col45,\n"
                    + "MIGRADO_A_CYBER=@col46,\n"
                    + "LATITUD=@col47,\n"
                    + "LONGITUD=@col48,\n"
                    + "GERENCIA=@col49,\n"
                    + "GERENTE=@col50,\n"
                    + "TERRITORIO=@col51,\n"
                    + "CAMPANIA=@col52,\n"
                    + "IDENTIFICADOR=@col53,\n"
                    + "CANAL=@col54,\n"
                    + "EDAD=@col55,\n"
                    + "SCORE=@col56,\n"
                    + "RANGO=@col57,\n"
                    + "RANGO_DE_EDAD=@col58,\n"
                    + "IDENTIFICADOR2=@col59,\n"
                    + "ID_EQUIPO=@col60,\n"
                    + "ID_ESTATUS_CUENTA=@col61,\n"
                    + "ID_ESTATUS_LLAMADA=@col62,\n"
                    + "ID_SUCURSAL=@col63,\n"
                    + "ID_CLIENTE=@col64,\n"
                    + "NOM_TEL1=@col65,\n"
                    + "NOM_TEL2=@col66,\n"
                    + "NOM_TEL3=@col67,\n"
                    + "NOM_TEL4=@col68,\n"
                    + "TIPO_CONTACTO1=@col69,\n"
                    + "TIPO_CONTACTO2=@col70,\n"
                    + "TIPO_CONTACTO3=@col71,\n"
                    + "TIPO_CONTACTO4=@col72,\n"
                    + "PLAN=@col73,\n"
                    + "STATUS=@col74,\n"
                    + "GRUPO=@col75,\n"
                    + "ETAPA=@col76,\n"
                    + "PRODUCTO=@col77,\n"
                    + "MICRO=@col78,\n"
                    + "ITALICA=@col79,\n"
                    + "PROXIMAS_RETIRO=@col80,\n"
                    + "FECHA_INSERT=@col81,\n"
                    + "FECHA_REACT=@col82,\n"
                    + "FECHA_RETIRADA=@col83;";
            ic.st.executeUpdate("truncate azteca_carga_diaria;");
//            System.out.println(sql_import_csv);
            ic.st.executeUpdate(sql_import_csv);

            ic.st.close();
            ic.conn.close();
            return "La base a sido cargada corectamente";
        } catch (SQLException e) {
            return "SQL: Error al ingresar los datos del CSV a la tabla Code Error: " + e;
        }
    }
    
    public static String cargar_pagos_azteca(String dirFile) {
        try {
            // ID_PAGO, ANIO, SEMANA, DIA, PAIS, CANAL, SUCURSAL, FOLIO, RECUPERACION_CAPITAL, RECUPERACION_MORATORIOS, SALDO_ACTUAL, MORATORIO, FECHA_GESTION, CARGO_AUTOMATICO
            StartConexion ic = new StartConexion();
            String sql_import_csv = "LOAD DATA LOCAL INFILE '" + dirFile + "' INTO TABLE azteca_pagos_temporal \n"
                    + "FIELDS TERMINATED BY ',' \n"
                    + "LINES TERMINATED BY '\\n' \n"
                    + "IGNORE 1 ROWS (@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10,\n"
                    + "@col11, @col12, @col13)\n"
                    + "set \n"
                    + "ANIO=@col1,\n"
                    + "SEMANA=@col2,\n"
                    + "DIA=str_to_date(@col3, '%d/%m/%Y'),\n"
                    + "PAIS=@col4,\n"
                    + "CANAL=@col5,\n"
                    + "SUCURSAL=@col6,\n"
                    + "FOLIO=@col7,\n"
                    + "RECUPERACION_CAPITAL=@col8,\n"
                    + "RECUPERACION_MORATORIOS=@col9,\n"
                    + "SALDO_ACTUAL=@col10,\n"
                    + "MORATORIO=@col11,\n"
                    + "FECHA_GESTION=str_to_date(@col12, '%d/%m/%Y'),\n"
                    + "CARGO_AUTOMATICO=@col13,"
                    + "CLIENTE_UNICO=concat(@col4,' - ',@col5,' - ',@col6,' - ',@col7)\n";
            ic.st.executeUpdate("truncate azteca_pagos_temporal;");
//            System.out.println(sql_import_csv);
            ic.st.executeUpdate(sql_import_csv);
            ic.st.executeQuery("CALL azteca_procesar_pagos();");

            ic.st.close();
            ic.conn.close();
            return "La base a sido cargada corectamente";
        } catch (SQLException e) {
            return "SQL: Error al ingresar los datos del CSV a la tabla Code Error: " + e;
        }
    }
    
    public static String cargar_gestiones_azteca(String dirFile) {
        try {
            // ID_PAGO, ANIO, SEMANA, DIA, PAIS, CANAL, SUCURSAL, FOLIO, RECUPERACION_CAPITAL, RECUPERACION_MORATORIOS, SALDO_ACTUAL, MORATORIO, FECHA_GESTION, CARGO_AUTOMATICO
            StartConexion ic = new StartConexion();
            String sql_import_csv = "LOAD DATA LOCAL INFILE '" + dirFile + "' INTO TABLE azteca_carga_gestiones \n"
                    + "FIELDS TERMINATED BY ',' \n"
                    + "LINES TERMINATED BY '\\n' \n"
                    + "IGNORE 1 ROWS (@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10, @col11)\n"
                    + "set \n"
                    + "FECHA_LARGA=concat(str_to_date(@col1, '%d/%m/%Y'),' ',@col2),\n"
                    + "ATRASO_MAXIMO=@col3,\n"
                    + "CUENTA=@col4,\n"
                    + "NUMERO_MARCADO=@col5,\n"
                    + "ID_ESTATUS_CUENTA=@col6,\n"
                    + "ID_ESTATUS_LLAMADA=@col7,\n"
                    + "ID_USUARIO=@col8,\n"
                    + "GESTION=@col9,\n"
                    + "DURACION=@col10,\n"
                    + "ID_PUESTO=@col11 \n";
//            System.out.println(sql_import_csv);
            ic.st.executeUpdate("truncate azteca_carga_gestiones;");
            ic.st.executeUpdate(sql_import_csv);
            
            ic.st.executeQuery("CALL azteca_completar_carga_gestiones();");

            ic.st.close();
            ic.conn.close();
            return "La base a sido cargada corectamente";
        } catch (SQLException e) {
            return "SQL: Error al ingresar los datos del CSV a la tabla Code Error: " + e;
        }
    }
    
    public static String cargar_equipos_azteca(String dirFile) {
        try {
            // ID_PAGO, ANIO, SEMANA, DIA, PAIS, CANAL, SUCURSAL, FOLIO, RECUPERACION_CAPITAL, RECUPERACION_MORATORIOS, SALDO_ACTUAL, MORATORIO, FECHA_GESTION, CARGO_AUTOMATICO
            StartConexion ic = new StartConexion();
            String sql_import_csv = "LOAD DATA LOCAL INFILE '" + dirFile + "' INTO TABLE azteca_mach_equipos \n"
                    + "FIELDS TERMINATED BY ',' \n"
                    + "LINES TERMINATED BY '\\n' \n"
                    + "IGNORE 1 ROWS (@col1, @col2, @col3, @col4)\n"
                    + "set \n"
                    + "cuenta=@col1,\n"
                    + "alias=@col2,\n"
                    + "id_usuario=@col3,\n"
                    + "id_equipo=@col4 \n";
            ic.st.executeUpdate("truncate azteca_mach_equipos;");
//            System.out.println(sql_import_csv);
            ic.st.executeUpdate(sql_import_csv);
            ic.st.executeQuery("CALL azteca_asignar_cuentas_equipos();");

            ic.st.close();
            ic.conn.close();
            return "La base a sido cargada corectamente";
        } catch (SQLException e) {
            return "SQL: Error al ingresar los datos del CSV a la tabla Code Error: " + e;
        }
    }

}
