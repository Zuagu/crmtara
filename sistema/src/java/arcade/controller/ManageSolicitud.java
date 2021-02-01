//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.SolicitudDao;
//==============================================================================
import java.io.IOException;
import java.io.PrintWriter;
//==============================================================================
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//==============================================================================
/* @author Luis Cortez */
//==============================================================================

public class ManageSolicitud extends HttpServlet {
//==============================================================================

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
//==============================================================================

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //======================================================================
        String accion = request.getParameter("accion");
        //======================================================================
        if ("select_solicitudes_tabla".equals(accion)) {
            String renglones = SolicitudDao.select_solicitud_tabla(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_solicitud".equals(accion)) {
            String renglones = SolicitudDao.delete_solicitud(Integer.parseInt(request.getParameter("id_solicitud")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_solicitud".equals(accion)) {
            String renglones = SolicitudDao.insert_solicitud(
                    request.getParameter("nombre"),
                    request.getParameter("puesto"),
                    request.getParameter("fecha"),
                    request.getParameter("exp"),
                    request.getParameter("sucursal"),
                    request.getParameter("medio"),
                    request.getParameter("reclutador"),
                    request.getParameter("calle"),
                    request.getParameter("tel"),
                    request.getParameter("cel"),
                    request.getParameter("colonia"),
                    request.getParameter("ciudad"),
                    request.getParameter("mail"),
                    request.getParameter("fecha_n"),
                    request.getParameter("lugar_n"),
                    request.getParameter("sexo"),
                    Integer.parseInt(request.getParameter("edad")),
                    request.getParameter("num_imss"),
                    request.getParameter("clinica"),
                    request.getParameter("civil"),
                    request.getParameter("religion"),
                    request.getParameter("rfc"),
                    request.getParameter("dep_eco"),
                    request.getParameter("curp"),
                    request.getParameter("infonavit"),
                    request.getParameter("complexion"),
                    request.getParameter("edo_sal"),
                    request.getParameter("tipo_empleo"),
                    request.getParameter("cambio_res"),
                    request.getParameter("viajar"),
                    request.getParameter("auto"),
                    request.getParameter("lic"),
                    request.getParameter("extra"),
                    request.getParameter("tbj_act"),
                    request.getParameter("horario_1"),
                    request.getParameter("est_act"),
                    request.getParameter("horario_2"),
                    request.getParameter("call_center"),
                    request.getParameter("mora"),
                    request.getParameter("nivel"),
                    request.getParameter("grado"),
                    request.getParameter("idioma_1"),
                    Integer.parseInt(request.getParameter("rango_1")),
                    request.getParameter("idioma_2"),
                    Integer.parseInt(request.getParameter("rango_2")),
                    request.getParameter("software"),
                    request.getParameter("padre"),
                    request.getParameter("edad_padre"),
                    request.getParameter("domicilio_padre"),
                    request.getParameter("ocupacion_padre"),
                    request.getParameter("madre"),
                    request.getParameter("edad_madre"),
                    request.getParameter("domicilio_madre"),
                    request.getParameter("ocupacion_madre"),
                    request.getParameter("otro_1"),
                    request.getParameter("otro_1_edad"),
                    request.getParameter("otro_1_domicilio"),
                    request.getParameter("otro_1_ocupacion"),
                    request.getParameter("otro_2"),
                    request.getParameter("otro_2_edad"),
                    request.getParameter("otro_2_domicilio"),
                    request.getParameter("otro_2_ocupacion"),
                    request.getParameter("nombre_1"),
                    request.getParameter("giro_1"),
                    request.getParameter("area_1"),
                    request.getParameter("puesto_1"),
                    request.getParameter("domi_1"),
                    request.getParameter("dura_1"),
                    request.getParameter("mora_1"),
                    request.getParameter("tel_1"),
                    request.getParameter("jefe_1"),
                    request.getParameter("inicio_1"),
                    request.getParameter("termina_1"),
                    request.getParameter("sueldo_1"),
                    request.getParameter("comision_1"),
                    request.getParameter("producto_1"),
                    request.getParameter("motivo_1"),
                    request.getParameter("rh_1"),
                    request.getParameter("funcion_1"),
                    request.getParameter("tec_1"),
                    request.getParameter("nombre_2"),
                    request.getParameter("giro_2"),
                    request.getParameter("area_2"),
                    request.getParameter("puesto_2"),
                    request.getParameter("domi_2"),
                    request.getParameter("dura_2"),
                    request.getParameter("mora_2"),
                    request.getParameter("tel_2"),
                    request.getParameter("jefe_2"),
                    request.getParameter("inicio_2"),
                    request.getParameter("termina_2"),
                    request.getParameter("sueldo_2"),
                    request.getParameter("comision_2"),
                    request.getParameter("producto_2"),
                    request.getParameter("motivo_2"),
                    request.getParameter("rh_2"),
                    request.getParameter("funcion_2"),
                    request.getParameter("tec_2"),
                    request.getParameter("nombre_3"),
                    request.getParameter("giro_3"),
                    request.getParameter("area_3"),
                    request.getParameter("puesto_3"),
                    request.getParameter("domi_3"),
                    request.getParameter("dura_3"),
                    request.getParameter("mora_3"),
                    request.getParameter("tel_3"),
                    request.getParameter("jefe_3"),
                    request.getParameter("inicio_3"),
                    request.getParameter("termina_3"),
                    request.getParameter("sueldo_3"),
                    request.getParameter("comision_3"),
                    request.getParameter("producto_3"),
                    request.getParameter("motivo_3"),
                    request.getParameter("rh_3"),
                    request.getParameter("funcion_3"),
                    request.getParameter("tec_3"),
                    request.getParameter("virtud"),
                    request.getParameter("especificaMedio"),
                    request.getParameter("alias")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_solicitud".equals(accion)) {
            String renglones = SolicitudDao.select_datos_solicitud(
                    Integer.parseInt(request.getParameter("id_solicitud"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("enviar_evaluacion".equals(accion)) {
            String renglones = SolicitudDao.enviar_evaluacion(
                    request.getParameter("dato1"),
                    request.getParameter("dato2"),
                    request.getParameter("dato3"),
                    request.getParameter("dato4"),
                    request.getParameter("dato5"),
                    request.getParameter("dato6"),
                    request.getParameter("dato7"),
                    request.getParameter("dato8"),
                    request.getParameter("dato9"),
                    request.getParameter("dato10"),
                    request.getParameter("dato11"),
                    request.getParameter("dato12"),
                    request.getParameter("dato13"),
                    request.getParameter("dato14"),
                    request.getParameter("dato15"),
                    Integer.parseInt(request.getParameter("dato16")),
                    request.getParameter("dato17"),
                    request.getParameter("dato18"),
                    request.getParameter("dato19"),
                    request.getParameter("dato20"),
                    request.getParameter("dato21"),
                    request.getParameter("dato22"),
                    request.getParameter("dato23"),
                    request.getParameter("dato24"),
                    request.getParameter("dato25"),
                    request.getParameter("dato26"),
                    request.getParameter("dato27"),
                    request.getParameter("dato28"),
                    request.getParameter("dato29"),
                    request.getParameter("dato30"),
                    request.getParameter("dato31"),
                    request.getParameter("dato32"),
                    request.getParameter("dato33"),
                    request.getParameter("dato34"),
                    request.getParameter("dato35"),
                    request.getParameter("dato36"),
                    request.getParameter("dato37"),
                    request.getParameter("dato38"),
                    request.getParameter("dato39"),
                    request.getParameter("dato40"),
                    request.getParameter("dato41"),
                    Integer.parseInt(request.getParameter("dato42")),
                    request.getParameter("dato43"),
                    Integer.parseInt(request.getParameter("dato44")),
                    request.getParameter("dato45"),
                    request.getParameter("dato46"),
                    request.getParameter("dato47"),
                    request.getParameter("dato48"),
                    request.getParameter("dato49"),
                    request.getParameter("dato50"),
                    request.getParameter("dato51"),
                    request.getParameter("dato52"),
                    request.getParameter("dato53"),
                    request.getParameter("dato54"),
                    request.getParameter("dato55"),
                    request.getParameter("dato56"),
                    request.getParameter("dato57"),
                    request.getParameter("dato58"),
                    request.getParameter("dato59"),
                    request.getParameter("dato60"),
                    request.getParameter("dato61"),
                    request.getParameter("dato62"),
                    request.getParameter("dato63"),
                    request.getParameter("dato64"),
                    request.getParameter("dato65"),
                    request.getParameter("dato66"),
                    request.getParameter("dato67"),
                    request.getParameter("dato68"),
                    request.getParameter("dato69"),
                    request.getParameter("dato70"),
                    request.getParameter("dato71"),
                    request.getParameter("dato72"),
                    request.getParameter("dato73"),
                    request.getParameter("dato74"),
                    request.getParameter("dato75"),
                    request.getParameter("dato76"),
                    request.getParameter("dato77"),
                    request.getParameter("dato78"),
                    request.getParameter("dato79"),
                    request.getParameter("dato80"),
                    request.getParameter("dato81"),
                    request.getParameter("dato82"),
                    request.getParameter("dato83"),
                    request.getParameter("dato84"),
                    request.getParameter("dato85"),
                    request.getParameter("dato86"),
                    request.getParameter("dato87"),
                    request.getParameter("dato88"),
                    request.getParameter("dato89"),
                    request.getParameter("dato90"),
                    request.getParameter("dato91"),
                    request.getParameter("dato92"),
                    request.getParameter("dato93"),
                    request.getParameter("dato94"),
                    request.getParameter("dato95"),
                    request.getParameter("dato96"),
                    request.getParameter("dato97"),
                    request.getParameter("dato98"),
                    request.getParameter("dato99"),
                    request.getParameter("dato100"),
                    request.getParameter("dato101"),
                    request.getParameter("dato102"),
                    request.getParameter("dato103"),
                    request.getParameter("dato104"),
                    request.getParameter("dato105"),
                    request.getParameter("dato106"),
                    request.getParameter("dato107"),
                    request.getParameter("dato108"),
                    request.getParameter("dato109"),
                    request.getParameter("dato110"),
                    request.getParameter("dato111"),
                    request.getParameter("dato112"),
                    request.getParameter("dato113"),
                    request.getParameter("dato114"),
                    request.getParameter("dato115"),
                    request.getParameter("dato116"),
                    Integer.parseInt(request.getParameter("id_solicitud")),
                    request.getParameter("presentacion"),
                    request.getParameter("experiencia"),
                    request.getParameter("facilidad"),
                    request.getParameter("normas"),
                    request.getParameter("influencia"),
                    request.getParameter("equipo"),
                    request.getParameter("estabilidad"),
                    request.getParameter("logro"),
                    request.getParameter("contratacion"),
                    request.getParameter("fecha_ingreso"),
                    request.getParameter("nombre_reclutador"),
                    request.getParameter("referido"),
                    request.getParameter("observacion"),
                    request.getParameter("virtud"),
                    request.getParameter("especificaMedio"),
                    request.getParameter("alias"),
                    request.getParameter("evaluador_rh"),
                    request.getParameter("anexo"),
                    request.getParameter("anexo_rh")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_nuevo_usuario".equals(accion)) {
            String renglones = SolicitudDao.insert_usuario(
                    request.getParameter("nombre_usu"),
                    request.getParameter("alias_usu"),
                    request.getParameter("sucursal_usu"),
                    request.getParameter("sexo_usu"),
                    request.getParameter("tel_usu"),
                    request.getParameter("cel_usu"),
                    request.getParameter("mail_usu"),
                    Integer.parseInt(request.getParameter("codigo_reclutador"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("datos_grafica_dashboart".equals(accion)) {
            String renglones = SolicitudDao.datos_grafica_dashboart();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("datos_grafica_dashboart2".equals(accion)) {
            String renglones = SolicitudDao.datos_grafica_dashboart_mensual(
                    Integer.parseInt(request.getParameter("mes")),
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("datos_grafica_dashboart_dos".equals(accion)) {
            String renglones = SolicitudDao.datos_grafica_dashboart_dos(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    Integer.parseInt(request.getParameter("opcion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_activos".equals(accion)) {
            String renglones = SolicitudDao.select_activos(
                    request.getParameter("opcion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_activos_total".equals(accion)) {
            String renglones = SolicitudDao.select_activos_total(
                    request.getParameter("opcion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_entrevista".equals(accion)) {
            String renglones = SolicitudDao.select_entrevista(
                    request.getParameter("opcion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ingresos".equals(accion)) {
            String renglones = SolicitudDao.select_ingresos(
                    request.getParameter("opcion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_bajas".equals(accion)) {
            String renglones = SolicitudDao.select_bajas(
                    request.getParameter("opcion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("datos_grafica_dashboart3".equals(accion)) {
            String renglones = SolicitudDao.datos_grafica_dashboart3(
                    Integer.parseInt(request.getParameter("mes")),
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_permanencia".equals(accion)) {
            String renglones = SolicitudDao.select_permanencia(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ingresos_rango".equals(accion)) {
            String renglones = SolicitudDao.select_ingresos_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_bajas_rango".equals(accion)) {
            String renglones = SolicitudDao.select_bajas_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_informe_vacantes".equals(accion)) {
            String renglones = SolicitudDao.select_datos_informe_vacantes(
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_entrevistas_rango".equals(accion)) {
            String renglones = SolicitudDao.select_entrevistas_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_informe_reclutadores".equals(accion)) {
            String renglones = SolicitudDao.select_datos_informe_reclutadores(
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            ); 
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_reclutadores".equals(accion)) {
            String renglones = SolicitudDao.select_reclutadores();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_informe_individual_vacantes".equals(accion)) {
            String renglones = SolicitudDao.select_datos_informe_individual_vacantes(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("id_reclutador")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_citados_rango".equals(accion)) {
            String renglones = SolicitudDao.select_citados_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
