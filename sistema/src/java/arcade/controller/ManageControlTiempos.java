/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.ControlTiemposDao;
import arcade.model.ControlTiempos;

/**
 *
 * @author PC
 */
public class ManageControlTiempos extends HttpServlet {

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
        if ("qa".equals(accion)) {
            String renglon = "";
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();

        } //====================================================================
        else if ("insert_registro_tiempo".equals(accion)) {
            String renglon;
            ControlTiempos reporte = new ControlTiempos();
            reporte.setId_gestor(Integer.parseInt(request.getParameter("id_usuario")));
            reporte.setRetraso_acumulado((request.getParameter("retraso_acumulado")));
            reporte.setRetraso_acumulado(String.valueOf(request.getParameter("retraso_acumulado")));
            renglon = ControlTiemposDao.insert_registro_tiempo(reporte);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        //======================================================================
        // FIN DE LAS ACCIONES DEL CONTROLLER - ARCADE SOFTWARE GROUP
        //======================================================================
    }
}
