package arcade.data;

import java.sql.SQLException;

/* @author Luis Cortez */
public class PagoDao {

    //==========================================================================
    public static String insert_pagos_asignacion(int id_usuario, int id_cliente, int id_region, int id_asignacion, String desde, String hasta) {
        try {
            StartConn s = new StartConn();
            String resultado = "";

            
            String update_cadena_unica_cargados = "call arcade_update_cadenaunica_pagos_cargados();";
            
            String sql_import = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\pagos.csv'\n"
                    + "INTO TABLE arcade_pagos_cargados -- 10 columnas\n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "IGNORE 1 ROWS\n"
                    + "(@col1,@col2,@col3,@col4,@col5,@col6,@col7)\n"
                    + "set\n"
                    + "id_cliente='" + id_cliente + "', id_region='" + id_region + "', id_asignacion='" + id_asignacion + "',\n"
                    + "cuenta=@col1, fecha_pago=fecha_sistema(@col2), origen=@col3,\n"
                    + "importe=@col4, forma=@col5, status=@col6, fecha_aplicacion=fecha_sistema(@col7), cadenaunica=concat(@col1,fecha_sistema(@col7),@col4,@col5,@col6);";

            String mover_pagos_rango = "call arcade_mover_pagos_rango('" + id_asignacion + "', '" + desde + "', '" + hasta + "');";

            String existen_pagos = "call arcade_verificar_existencia_pagos('" + id_asignacion + "');";

            // IMPORTAMOS EL ARCHIVO CSV A LA TABLA PAGOS CARGADOS
            s.st.executeUpdate(sql_import);
//            System.out.println(sql_import);

            // AQUI ACTUALIZAMOS LA CADENAUNICA DE LOS PAGOS CARGADOS PARA EVITAR
            // EL ERROR DE LOS PAGOS DUPLICADOS
            s.st.executeUpdate(update_cadena_unica_cargados);
//            System.out.println(update_cadena_unica_cargados);

            s.st.executeUpdate(mover_pagos_rango); // SE ELIMINAN DE LOS PAGOS DE LA TABLA DE PAGOS Y SE MUEVEN A UNA TABLA TEMPORAL
//            System.out.println(mover_pagos_rango);

            s.rs = s.st.executeQuery(existen_pagos);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex);
            return "COMUNICARSE CON SISTEMAS. ERROR insert_pagos_asignacion"
                    + "SQL error: " + ex;
        }
    }
    // =========================================================================
}
