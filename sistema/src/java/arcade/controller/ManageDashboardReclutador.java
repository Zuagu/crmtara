//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.DashboardReclutadorDao;
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

public class ManageDashboardReclutador extends HttpServlet {
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
        if ("select_xxyyzz_tabla".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_xxyyzz_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_xxyyzz_combo".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_xxyyzz_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_bajas_rango".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_bajas_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"),
                    Integer.parseInt(request.getParameter("usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ingresos_rango".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_ingresos_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"),
                    Integer.parseInt(request.getParameter("usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_entrevistas_rango".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_entrevistas_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"),
                    Integer.parseInt(request.getParameter("usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_permanencia".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_permanencia(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"),
                    Integer.parseInt(request.getParameter("usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tabla_citados".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_tabla_citados(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    Integer.parseInt(request.getParameter("usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_citados_rango".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_citados_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("opcion"),
                    Integer.parseInt(request.getParameter("usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_cita".equals(accion)) {
            String renglones = DashboardReclutadorDao.insert_cita(
                    Integer.parseInt(request.getParameter("usuario_sistema")),
                    request.getParameter("nombre"),
                    request.getParameter("medio"),
                    request.getParameter("especificaMedio"),
                    request.getParameter("fecha"),
                    request.getParameter("hora"),
                    request.getParameter("desc")
                    
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_grafica_entrevistas".equals(accion)) {
            String renglones = DashboardReclutadorDao.select_grafica_entrevistas(
                    Integer.parseInt(request.getParameter("opcion")),
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    Integer.parseInt(request.getParameter("id"))
                    
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
