//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.VisitasDao;
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

public class ManageVisita extends HttpServlet {
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
        if ("select_cadena_datos_carta_visita".equals(accion)) {
            String renglones = VisitasDao.select_cadena_datos_carta_visita(
                    Integer.parseInt(request.getParameter("cuenta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cadena_datos_cartas".equals(accion)) {
            String renglones = VisitasDao.select_cadena_datos_cartas(
                    request.getParameter("id_region"),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    request.getParameter("cadena_ladas"),
                    request.getParameter("resto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cadena_datos_cartas2".equals(accion)) {
            String renglones = VisitasDao.select_cadena_datos_cartas2(
                    request.getParameter("id_region"),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    request.getParameter("cadena_ladas"),
                    request.getParameter("resto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_cuentas_visitas".equals(accion)) {
            String renglones = VisitasDao.insert_cuentas_visitas(
                    request.getParameter("id_region"),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    request.getParameter("cadena_ladas"),
                    request.getParameter("resto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_numero_visitas".equals(accion)) {
            String renglones = VisitasDao.update_numero_visitas(
                    request.getParameter("id_region"),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    request.getParameter("cadena_ladas"),
                    request.getParameter("resto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_region_check_visitas".equals(accion)) {
            String renglones = VisitasDao.select_asignacion_region_check_visitas(
                    Integer.parseInt(request.getParameter("id_region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ciudades_check".equals(accion)) {
            String renglones = VisitasDao.select_ciudades_check(
                    request.getParameter("cadena_asignacion"),
                    Integer.parseInt(request.getParameter("id_region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_colonias_check".equals(accion)) {
            String renglones = VisitasDao.select_colonias_check(
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_codigos"),
                    Integer.parseInt(request.getParameter("tipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_codigo_postal_check".equals(accion)) {
            String renglones = VisitasDao.select_codigo_postal_check(
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    Integer.parseInt(request.getParameter("tipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_status_check".equals(accion)) {
            String renglones = VisitasDao.select_status_check(
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_segunda_visitas".equals(accion)) {
            String renglones = VisitasDao.select_datos_segunda_visitas(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    request.getParameter("cadena_ladas"),
                    Integer.parseInt(request.getParameter("resto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_carteo".equals(accion)) {
            String renglones = VisitasDao.select_datos_carteo(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    Integer.parseInt(request.getParameter("resto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_datos_carteo".equals(accion)) {
            String renglones = VisitasDao.insert_datos_carteo(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    Integer.parseInt(request.getParameter("resto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_segundo_carteo_tabla".equals(accion)) {
            String renglones = VisitasDao.select_datos_segundo_carteo_tabla(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("id_asignacion"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    Integer.parseInt(request.getParameter("resto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_segundo_carteo".equals(accion)) {
            String renglones = VisitasDao.select_datos_segundo_carteo(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    Integer.parseInt(request.getParameter("resto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_numero_carta".equals(accion)) {
            String renglones = VisitasDao.update_numero_carta(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
