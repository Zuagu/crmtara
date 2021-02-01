//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.PagosDiariosDao;
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

public class ManagePagosDiarios extends HttpServlet {
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
        if ("select_pagos_diarios_tabla".equals(accion)) {
            String renglones = PagosDiariosDao.select_pagos_diarios_tabla(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        if ("select_pagos_diarios_gestor".equals(accion)) {
            String renglones = PagosDiariosDao.select_pagos_diarios_gestor(
                    Integer.parseInt(request.getParameter("usuario_sistema")),
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_reporte_recuperacion_previa".equals(accion)) {
            String renglones = PagosDiariosDao.select_reporte_recuperacion_previa(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("desde")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        if ("select_reporte_estadistica".equals(accion)) {
            String renglones = PagosDiariosDao.select_reporte_estadistica(
                    Integer.parseInt(request.getParameter("id_region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("select_reporte_estadistica_diaria".equals(accion)) {
            String renglones = PagosDiariosDao.select_reporte_estadistica_diaria(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================

    }
}
