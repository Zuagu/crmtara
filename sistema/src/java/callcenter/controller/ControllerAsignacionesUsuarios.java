/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelEquipoAzteca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zuagu
 */
public class ControllerAsignacionesUsuarios extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action.equals("select_asignaiones_usuarios")) {
            String Respuesta = ModelEquipoAzteca.select_asignaiones_usuarios();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("update_config_gestor")) {
            String Respuesta = ModelEquipoAzteca.update_config_gestor(
                    request.getParameter("val_order"),
                    request.getParameter("val_order_importe"),
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("estatus_asignacion_gestor")) {
            String Respuesta = ModelEquipoAzteca.estatus_asignacion_gestor(
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("update_config_todos_gestor")) {
            String Respuesta = ModelEquipoAzteca.update_config_todos_gestor(
                    request.getParameter("order_ult_gestion"),
                    request.getParameter("order_monto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
