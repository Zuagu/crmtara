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
 * @author Emmanuel Medina
 */
public class ControllerEquiposAzteca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equals("select_equipo_tabla")) {
            String Respuesta = ModelEquipoAzteca.select_equipos();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("agregar_gestor_a_equipo")) {
            String Respuesta = ModelEquipoAzteca.agregar_gestor_a_equipo(
                    request.getParameter("id_gestor"),
                    request.getParameter("id_equipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_usarios_equipo")) {
            String Respuesta = ModelEquipoAzteca.select_usarios_equipo(
                    request.getParameter("id_equipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("eliminar_gestor_de_equipo")) {
            String Respuesta = ModelEquipoAzteca.eliminar_gestor_de_equipo(
                    request.getParameter("id_gestor"),
                    request.getParameter("id_equipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_territorio_options")) {
            String Respuesta = ModelEquipoAzteca.select_territorio_options();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_gerente_options")) {
            String Respuesta = ModelEquipoAzteca.select_gerente_options(
                    request.getParameter("territorio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_etapas_options")) {
            String Respuesta = ModelEquipoAzteca.select_etapas_options(
                    request.getParameter("territorio"),
                    request.getParameter("gerente")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("crear_equipo")) {
            String Respuesta = ModelEquipoAzteca.crear_equipo(
                    request.getParameter("nombre_equipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("agregar_cuentas_equipo")) {
            String Respuesta = ModelEquipoAzteca.agregar_cuentas_equipo(
                    request.getParameter("territorio"),
                    request.getParameter("gerente"),
                    request.getParameter("etapa")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("agregar_nuevas_cuentas_equipo")) {
            String Respuesta = ModelEquipoAzteca.agregar_nuevas_cuentas_equipo(
                    request.getParameter("territorio"),
                    request.getParameter("gerente"),
                    request.getParameter("etapa"),
                    request.getParameter("id_equipo")
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
