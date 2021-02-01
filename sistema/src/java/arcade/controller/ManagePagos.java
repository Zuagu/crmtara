package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.PagoDao;

/* @author Luis Cortez */
public class ManagePagos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        //======================================================================
        if ("insert_pagos_asignacion".equals(accion)) {
            String resultado = PagoDao.insert_pagos_asignacion(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_cliente")),
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(resultado);
            writer.flush();
            writer.close();
        }//=====================================================================
    }

    //==========================================================================
    // FIN DE LAS ACCIONES DEL CONTROLLER - ARCADE SOFTWARE GROUP
    //==========================================================================
}
