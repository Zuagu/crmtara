/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelDashboardSupervisor;
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
public class ControllerDashboardSupervisor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("select_gestor_tabla")) {
            String Respuesta = ModelDashboardSupervisor.select_gestor_tabla(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        if (action.equals("select_valores_usuarios")) {
            String Respuesta = ModelDashboardSupervisor.select_valores_usuarios(
                    Integer.parseInt(request.getParameter("id_puesto_usuario")),
                    Integer.parseInt(request.getParameter("id_puesto2_usuario")),
                    Integer.parseInt(request.getParameter("id_puesto3_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        if (action.equals("select_regitro_usuarios_entrada")) {
            String Respuesta = ModelDashboardSupervisor.select_regitro_usuarios_entrada(
                    Integer.parseInt(request.getParameter("id_puesto_usuario")),
                    Integer.parseInt(request.getParameter("id_puesto2_usuario")),
                    Integer.parseInt(request.getParameter("id_puesto3_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }

        if (action.equals("select_regiones")) {
            String Respuesta = ModelDashboardSupervisor.select_regiones(
                    Integer.parseInt(request.getParameter("puesto")),
                    Integer.parseInt(request.getParameter("puesto2")),
                    Integer.parseInt(request.getParameter("puesto3")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        if (action.equals("select_asignaciones_region")) {
            String Respuesta = ModelDashboardSupervisor.select_asignaciones_region(
                    request.getParameter("id_region"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();

        }
        if (action.equals("select_regitro_usuarios_entrada_rango")) {
            String Respuesta = ModelDashboardSupervisor.select_regitro_usuarios_entrada_rango(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("region"),
                    request.getParameter("asignacion"),
                    Integer.parseInt(request.getParameter("id_puesto_usuario")),
                    Integer.parseInt(request.getParameter("id_puesto2_usuario")),
                    Integer.parseInt(request.getParameter("id_puesto3_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
    }

}
