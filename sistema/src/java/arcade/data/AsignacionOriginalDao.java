package arcade.data;

import arcade.model.AsignacionOriginal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author LUIS CORTEZ */
public class AsignacionOriginalDao {

    //==============================================================================
    public static String select_asignacionoriginal_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignacionoriginal();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<AsignacionOriginal> asignacionoriginal = new ArrayList<AsignacionOriginal>();
            while (s.rs.next()) {
                AsignacionOriginal a = new AsignacionOriginal();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                a.setId(s.rs.getInt("id"));
                a.setColumna1(s.rs.getString("columna1"));
                a.setColumna2(s.rs.getString("columna2"));
                a.setColumna3(s.rs.getString("columna3"));
                a.setColumna4(s.rs.getString("columna4"));
                a.setColumna5(s.rs.getString("columna5"));
                a.setColumna6(s.rs.getString("columna6"));
                a.setColumna7(s.rs.getString("columna7"));
                a.setColumna8(s.rs.getString("columna8"));
                a.setColumna9(s.rs.getString("columna9"));
                a.setColumna10(s.rs.getString("columna10"));
                a.setColumna11(s.rs.getString("columna11"));
                a.setColumna12(s.rs.getString("columna12"));
                a.setColumna13(s.rs.getString("columna13"));
                a.setColumna14(s.rs.getString("columna14"));
                a.setColumna15(s.rs.getString("columna15"));
                a.setColumna16(s.rs.getString("columna16"));
                a.setColumna17(s.rs.getString("columna17"));
                a.setColumna18(s.rs.getString("columna18"));
                a.setColumna19(s.rs.getString("columna19"));
                a.setColumna20(s.rs.getString("columna20"));
                a.setColumna21(s.rs.getString("columna21"));
                a.setColumna22(s.rs.getString("columna22"));
                a.setColumna23(s.rs.getString("columna23"));
                a.setColumna24(s.rs.getString("columna24"));
                a.setColumna25(s.rs.getString("columna25"));
                a.setColumna26(s.rs.getString("columna26"));
                a.setColumna27(s.rs.getString("columna27"));
                a.setColumna28(s.rs.getString("columna28"));
                a.setColumna29(s.rs.getString("columna29"));
                a.setColumna30(s.rs.getString("columna30"));
                a.setColumna31(s.rs.getString("columna31"));
                a.setColumna32(s.rs.getString("columna32"));
                a.setColumna33(s.rs.getString("columna33"));
                a.setColumna34(s.rs.getString("columna34"));
                a.setColumna35(s.rs.getString("columna35"));
                a.setColumna36(s.rs.getString("columna36"));
                a.setColumna37(s.rs.getString("columna37"));
                a.setColumna38(s.rs.getString("columna38"));
                a.setColumna39(s.rs.getString("columna39"));
                a.setColumna40(s.rs.getString("columna40"));
                a.setColumna41(s.rs.getString("columna41"));
                a.setColumna42(s.rs.getString("columna42"));
                a.setColumna43(s.rs.getString("columna43"));
                a.setColumna44(s.rs.getString("columna44"));
                a.setColumna45(s.rs.getString("columna45"));
                a.setColumna46(s.rs.getString("columna46"));
                a.setColumna47(s.rs.getString("columna47"));
                a.setColumna48(s.rs.getString("columna48"));
                a.setColumna49(s.rs.getString("columna49"));
                a.setColumna50(s.rs.getString("columna50"));

                a.setColumna51(s.rs.getString("columna51"));
                a.setColumna52(s.rs.getString("columna52"));
                a.setColumna53(s.rs.getString("columna53"));
                a.setColumna54(s.rs.getString("columna54"));
                a.setColumna55(s.rs.getString("columna55"));
                a.setColumna56(s.rs.getString("columna56"));
                a.setColumna57(s.rs.getString("columna57"));
                a.setColumna58(s.rs.getString("columna58"));
                a.setColumna59(s.rs.getString("columna59"));
                a.setColumna60(s.rs.getString("columna60"));
                a.setColumna61(s.rs.getString("columna61"));
                a.setColumna62(s.rs.getString("columna62"));
                a.setColumna63(s.rs.getString("columna63"));
                a.setColumna64(s.rs.getString("columna64"));
                a.setColumna65(s.rs.getString("columna65"));
                a.setColumna66(s.rs.getString("columna66"));
                a.setColumna67(s.rs.getString("columna67"));
                a.setColumna68(s.rs.getString("columna68"));
                a.setColumna69(s.rs.getString("columna69"));
                a.setColumna70(s.rs.getString("columna70"));
                a.setColumna71(s.rs.getString("columna71"));
                a.setColumna72(s.rs.getString("columna72"));
                a.setColumna73(s.rs.getString("columna73"));
                a.setColumna74(s.rs.getString("columna74"));
                a.setColumna75(s.rs.getString("columna75"));
                a.setColumna76(s.rs.getString("columna76"));
                a.setColumna77(s.rs.getString("columna77"));
                a.setColumna78(s.rs.getString("columna78"));
                a.setColumna79(s.rs.getString("columna79"));
                a.setColumna80(s.rs.getString("columna80"));
                a.setColumna81(s.rs.getString("columna81"));
                a.setColumna82(s.rs.getString("columna82"));
                a.setColumna83(s.rs.getString("columna83"));
                a.setColumna84(s.rs.getString("columna84"));
                a.setColumna85(s.rs.getString("columna85"));
                a.setColumna86(s.rs.getString("columna86"));
                a.setColumna87(s.rs.getString("columna87"));
                a.setColumna88(s.rs.getString("columna88"));
                a.setColumna89(s.rs.getString("columna89"));
                a.setColumna90(s.rs.getString("columna90"));
                a.setColumna91(s.rs.getString("columna91"));
                a.setColumna92(s.rs.getString("columna92"));
                a.setColumna93(s.rs.getString("columna93"));
                a.setColumna94(s.rs.getString("columna94"));
                a.setColumna95(s.rs.getString("columna95"));
                a.setColumna96(s.rs.getString("columna96"));
                a.setColumna97(s.rs.getString("columna97"));
                a.setColumna98(s.rs.getString("columna98"));
                a.setColumna99(s.rs.getString("columna99"));
                a.setColumna100(s.rs.getString("columna100"));

                asignacionoriginal.add(a);
            }

            renglones = ""
                    + "<table>"
                    + "";

            // CUEPRO DE LA TABLA
            for (AsignacionOriginal c : asignacionoriginal) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td style='text-align:center;'>" + c.getColumna1() + "</td>"
                        + "<td>" + c.getColumna2() + "</td>"
                        + "<td>" + c.getColumna3() + "</td>"
                        + "<td>" + c.getColumna4() + "</td>"
                        + "<td>" + c.getColumna5() + "</td>"
                        + "<td>" + c.getColumna6() + "</td>"
                        + "<td>" + c.getColumna7() + "</td>"
                        + "<td>" + c.getColumna8() + "</td>"
                        + "<td>" + c.getColumna9() + "</td>"
                        + "<td>" + c.getColumna10() + "</td>"
                        + "<td>" + c.getColumna11() + "</td>"
                        + "<td>" + c.getColumna12() + "</td>"
                        + "<td>" + c.getColumna13() + "</td>"
                        + "<td>" + c.getColumna14() + "</td>"
                        + "<td>" + c.getColumna15() + "</td>"
                        + "<td>" + c.getColumna16() + "</td>"
                        + "<td>" + c.getColumna17() + "</td>"
                        + "<td>" + c.getColumna18() + "</td>"
                        + "<td>" + c.getColumna19() + "</td>"
                        + "<td>" + c.getColumna20() + "</td>"
                        + "<td>" + c.getColumna21() + "</td>"
                        + "<td>" + c.getColumna22() + "</td>"
                        + "<td>" + c.getColumna23() + "</td>"
                        + "<td>" + c.getColumna24() + "</td>"
                        + "<td>" + c.getColumna25() + "</td>"
                        + "<td>" + c.getColumna26() + "</td>"
                        + "<td>" + c.getColumna27() + "</td>"
                        + "<td>" + c.getColumna28() + "</td>"
                        + "<td>" + c.getColumna29() + "</td>"
                        + "<td>" + c.getColumna30() + "</td>"
                        + "<td>" + c.getColumna31() + "</td>"
                        + "<td>" + c.getColumna32() + "</td>"
                        + "<td>" + c.getColumna33() + "</td>"
                        + "<td>" + c.getColumna34() + "</td>"
                        + "<td>" + c.getColumna35() + "</td>"
                        + "<td>" + c.getColumna36() + "</td>"
                        + "<td>" + c.getColumna37() + "</td>"
                        + "<td>" + c.getColumna38() + "</td>"
                        + "<td>" + c.getColumna39() + "</td>"
                        + "<td>" + c.getColumna40() + "</td>"
                        + "<td>" + c.getColumna41() + "</td>"
                        + "<td>" + c.getColumna42() + "</td>"
                        + "<td>" + c.getColumna43() + "</td>"
                        + "<td>" + c.getColumna44() + "</td>"
                        + "<td>" + c.getColumna45() + "</td>"
                        + "<td>" + c.getColumna46() + "</td>"
                        + "<td>" + c.getColumna47() + "</td>"
                        + "<td>" + c.getColumna48() + "</td>"
                        + "<td>" + c.getColumna49() + "</td>"
                        + "<td>" + c.getColumna50() + "</td>"
                        + "<td>" + c.getColumna51() + "</td>"
                        + "<td>" + c.getColumna52() + "</td>"
                        + "<td>" + c.getColumna53() + "</td>"
                        + "<td>" + c.getColumna54() + "</td>"
                        + "<td>" + c.getColumna55() + "</td>"
                        + "<td>" + c.getColumna56() + "</td>"
                        + "<td>" + c.getColumna57() + "</td>"
                        + "<td>" + c.getColumna58() + "</td>"
                        + "<td>" + c.getColumna59() + "</td>"
                        + "<td>" + c.getColumna60() + "</td>"
                        + "<td>" + c.getColumna61() + "</td>"
                        + "<td>" + c.getColumna62() + "</td>"
                        + "<td>" + c.getColumna63() + "</td>"
                        + "<td>" + c.getColumna64() + "</td>"
                        + "<td>" + c.getColumna65() + "</td>"
                        + "<td>" + c.getColumna66() + "</td>"
                        + "<td>" + c.getColumna67() + "</td>"
                        + "<td>" + c.getColumna68() + "</td>"
                        + "<td>" + c.getColumna69() + "</td>"
                        + "<td>" + c.getColumna70() + "</td>"
                        + "<td>" + c.getColumna71() + "</td>"
                        + "<td>" + c.getColumna72() + "</td>"
                        + "<td>" + c.getColumna73() + "</td>"
                        + "<td>" + c.getColumna74() + "</td>"
                        + "<td>" + c.getColumna75() + "</td>"
                        + "<td>" + c.getColumna76() + "</td>"
                        + "<td>" + c.getColumna77() + "</td>"
                        + "<td>" + c.getColumna78() + "</td>"
                        + "<td>" + c.getColumna79() + "</td>"
                        + "<td>" + c.getColumna80() + "</td>"
                        + "<td>" + c.getColumna81() + "</td>"
                        + "<td>" + c.getColumna82() + "</td>"
                        + "<td>" + c.getColumna83() + "</td>"
                        + "<td>" + c.getColumna84() + "</td>"
                        + "<td>" + c.getColumna85() + "</td>"
                        + "<td>" + c.getColumna86() + "</td>"
                        + "<td>" + c.getColumna87() + "</td>"
                        + "<td>" + c.getColumna88() + "</td>"
                        + "<td>" + c.getColumna89() + "</td>"
                        + "<td>" + c.getColumna90() + "</td>"
                        + "<td>" + c.getColumna91() + "</td>"
                        + "<td>" + c.getColumna92() + "</td>"
                        + "<td>" + c.getColumna93() + "</td>"
                        + "<td>" + c.getColumna94() + "</td>"
                        + "<td>" + c.getColumna95() + "</td>"
                        + "<td>" + c.getColumna96() + "</td>"
                        + "<td>" + c.getColumna97() + "</td>"
                        + "<td>" + c.getColumna98() + "</td>"
                        + "<td>" + c.getColumna99() + "</td>"
                        + "<td>" + c.getColumna100() + "</td>"
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

    //==============================================================================
    public static String select_asignacionoriginal_combo() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignacionoriginal();";
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<AsignacionOriginal> asignacionoriginal = new ArrayList<AsignacionOriginal>();
            while (s.rs.next()) {
                AsignacionOriginal e = new AsignacionOriginal();
                e.setId(s.rs.getInt("id"));
                e.setColumna1(s.rs.getString("columna1"));
                asignacionoriginal.add(e);
            }
            for (AsignacionOriginal c : asignacionoriginal) {
                renglones += "<option value='" + c.getId() + "'>" + c.getColumna1() + "</option>";
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
    public static List<AsignacionOriginal> select_asignacionoriginal() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_asignacionoriginal();";
            s.rs = s.st.executeQuery(sql);
            List<AsignacionOriginal> asignacionoriginal = new ArrayList<AsignacionOriginal>();
            while (s.rs.next()) {
                AsignacionOriginal e = new AsignacionOriginal();
                e.setId(s.rs.getInt("id"));
                e.setColumna1(s.rs.getString("columna1"));
                asignacionoriginal.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return asignacionoriginal;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_asignacionoriginal(String nombre) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_asignacionoriginal('" + nombre + "');";
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
    public static String update_asignacionoriginal(int id_asignacionoriginal) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_asignacionoriginal('" + id_asignacionoriginal + "');";
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
    public static String delete_asignacionoriginal(int id_asignacionoriginal) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_asignacionoriginal('" + id_asignacionoriginal + "');";
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
    public static String insert_asignacion_original() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql_result = "call arcade_carga_datos();";
            String sql = "LOAD DATA LOCAL INFILE 'C:\\\\sistema\\\\asignacion.csv'\n"
                    + "INTO TABLE arcade_asignacion_original -- 150 columnas\n"
                    + "FIELDS TERMINATED BY ','\n"
                    + "LINES TERMINATED BY '\\n'\n"
                    + "(\n"
                    + "@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,\n"
                    + "@col11,@col12,@col13,@col14,@col15,@col16,@col17,@col18,@col19,@col20,\n"
                    + "@col21,@col22,@col23,@col24,@col25,@col26,@col27,@col28,@col29,@col30,\n"
                    + "@col31,@col32,@col33,@col34,@col35,@col36,@col37,@col38,@col39,@col40,\n"
                    + "@col41,@col42,@col43,@col44,@col45,@col46,@col47,@col48,@col49,@col50,\n"
                    + "@col51,@col52,@col53,@col54,@col55,@col56,@col57,@col58,@col59,@col60,\n"
                    + "@col61,@col62,@col63,@col64,@col65,@col66,@col67,@col68,@col69,@col70,\n"
                    + "@col71,@col72,@col73,@col74,@col75,@col76,@col77,@col78,@col79,@col80,\n"
                    + "@col81,@col82,@col83,@col84,@col85,@col86,@col87,@col88,@col89,@col90,\n"
                    + "@col91,@col92,@col93,@col94,@col95,@col96,@col97,@col98,@col99,@col100\n"
                    + ")\n"
                    + "set\n"
                    + "columna1=@col1,columna2=@col2,columna3=@col3,columna4=@col4,columna5=@col5,columna6=@col6,columna7=@col7,columna8=@col8,columna9=@col9,columna10=@col10,\n"
                    + "columna11=@col11,columna12=@col12,columna13=@col13,columna14=@col14,columna15=@col15,columna16=@col16,columna17=@col17,columna18=@col18,columna19=@col19,columna20=@col20,\n"
                    + "columna21=@col21,columna22=@col22,columna23=@col23,columna24=@col24,columna25=@col25,columna26=@col26,columna27=@col27,columna28=@col28,columna29=@col29,columna30=@col30,\n"
                    + "columna31=@col31,columna32=@col32,columna33=@col33,columna34=@col34,columna35=@col35,columna36=@col36,columna37=@col37,columna38=@col38,columna39=@col39,columna40=@col40,\n"
                    + "columna41=@col41,columna42=@col42,columna43=@col43,columna44=@col44,columna45=@col45,columna46=@col46,columna47=@col47,columna48=@col48,columna49=@col49,columna50=@col50,\n"
                    + "columna51=@col51,columna52=@col52,columna53=@col53,columna54=@col54,columna55=@col55,columna56=@col56,columna57=@col57,columna58=@col58,columna59=@col59,columna60=@col60,\n"
                    + "columna61=@col61,columna62=@col62,columna63=@col63,columna64=@col64,columna65=@col65,columna66=@col66,columna67=@col67,columna68=@col68,columna69=@col69,columna70=@col70,\n"
                    + "columna71=@col71,columna72=@col72,columna73=@col73,columna74=@col74,columna75=@col75,columna76=@col76,columna77=@col77,columna78=@col78,columna79=@col79,columna80=@col80,\n"
                    + "columna81=@col81,columna82=@col82,columna83=@col83,columna84=@col84,columna85=@col85,columna86=@col86,columna87=@col87,columna88=@col88,columna89=@col89,columna90=@col90,\n"
                    + "columna91=@col91,columna92=@col92,columna93=@col93,columna94=@col94,columna95=@col95,columna96=@col96,columna97=@col97,columna98=@col98,columna99=@col99,columna100=@col100;\n";

            s.st.executeUpdate("TRUNCATE arcade_asignacion_original;");
            s.st.executeUpdate(sql);
            s.rs = s.st.executeQuery(sql_result);
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
    public static String truncate_asignacion_temporal() {
        try {
            StartConn s = new StartConn();
            String resultado = "Se ha ejecutado: TRUNCATE arcade_asignacion_original;";

            s.st.executeUpdate("TRUNCATE arcade_asignacion_original;");

//            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;

        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================
}
