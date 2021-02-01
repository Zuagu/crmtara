/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.CodigoDao;
import arcade.model.Codigo;

/**
 *
 * @author PC
 */
public class ManageCodigos extends HttpServlet {

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
        else if ("insert_codigo".equals(accion)) {
            String renglon;
            Codigo codigo = new Codigo();
            renglon = CodigoDao.insert_codigo(codigo);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("update_estatus".equals(accion)) {
            String renglon;
            Codigo estatus = new Codigo();
            renglon = CodigoDao.update_codigo(estatus);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("delete_codigo".equals(accion)) {
            String renglon;
            Codigo codigo = new Codigo();
            renglon = CodigoDao.delete_codigo(codigo);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_codigo_resultado".equals(accion)) {
            String renglones = "";
            List<Codigo> codigo = CodigoDao.select_codigo_resultado();

            for (Codigo e : codigo) {
                renglones += "<option value='" + e.getId_codigo() + "'>" + e.getDescripcion() + "</option>";
            }
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        //======================================================================
        // FIN DE LAS ACCIONES DEL CONTROLLER - ARCADE SOFTWARE GROUP
        //======================================================================
    }
}
