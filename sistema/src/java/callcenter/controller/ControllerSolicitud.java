/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelSolicitud;

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
public class ControllerSolicitud extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        
        if(action.equals("select_values_inputselect")) {
            String Respuesta = ModelSolicitud.select_values_inputselect();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if(action.equals("select_tipo_pregunta")) {
            String Respuesta = ModelSolicitud.select_tipo_pregunta();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if(action.equals("select_preguntas")) {
            String Respuesta = ModelSolicitud.select_preguntas(
                    request.getParameter("tipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if(action.equals("select_data_inputselect")) {
            String Respuesta = ModelSolicitud.select_data_inputselect(
                    request.getParameter("id_selector")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if(action.equals("insert_new_option")) {
            String Respuesta = ModelSolicitud.insert_new_option(
                    request.getParameter("id_selector"),
                    request.getParameter("pregunta"),
                    request.getParameter("tipo"),
                    request.getParameter("value")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        
    }

    

}
