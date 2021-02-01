/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelReportesAzteca;
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
public class ControllerReportesAzteca extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        System.out.println(action);
        
        if(action.equals("reporte_gestiones_tabla")) {
            String Respuesta = ModelReportesAzteca.reporte_gestiones_tabla(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("territorio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if(action.equals("reporte_gestiones_descarga")) {
            String Respuesta = ModelReportesAzteca.reporte_gestiones_descarga(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("territorio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("reporte_convenios_descarga")) {
            String Respuesta = ModelReportesAzteca.reporte_convenios_descarga(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("territorio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("azteca_reporte_operacion_descarga")) {
            String Respuesta = ModelReportesAzteca.azteca_reporte_operacion_descarga(
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("azteca_reporte_convenios")) {
            String Respuesta = ModelReportesAzteca.reporte_convenios_tabla(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("territorio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_options_territorios")) {
            String Respuesta = ModelReportesAzteca.select_options_territorios();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_options_territorios_convenios")) {
            String Respuesta = ModelReportesAzteca.select_options_territorios_convenios();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("azteca_reporte_pagos")) {
            String Respuesta = ModelReportesAzteca.azteca_reporte_pagos(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("zona")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_options_zona")) {
            String Respuesta = ModelReportesAzteca.select_options_zona();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("descargar_base")) {
            String Respuesta = ModelReportesAzteca.descargar_base();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("azteca_reporte_operacion")) {
            String Respuesta = ModelReportesAzteca.azteca_reporte_operacion(
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("reporte_promesado_diario")) {
            String Respuesta = ModelReportesAzteca.reporte_promesado_diario(
                    request.getParameter("territorio"),
                    request.getParameter("desde")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("reporte_promesas_incumplidas")) {
            String Respuesta = ModelReportesAzteca.reporte_promesas_incumplidas(
                    request.getParameter("desde")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("reporte_promesado_al_momento")) {
            String Respuesta = ModelReportesAzteca.reporte_promesado_al_momento(
                    request.getParameter("territorio"),
                    request.getParameter("desde")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("reporte_promesas_por_gestor")) {
            String Respuesta = ModelReportesAzteca.reporte_promesas_por_gestor(
                    request.getParameter("f_inicio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_territorios")) {
            String Respuesta = ModelReportesAzteca.select_territorios();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_gerentes")) {
            String Respuesta = ModelReportesAzteca.select_gerentes(
                    request.getParameter("_territorios")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_gerencias")) {
            String Respuesta = ModelReportesAzteca.select_gerencias(
                    request.getParameter("_territorios"),
                    request.getParameter("_gerentes")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("generar_csv_telefonos")) {
            String Respuesta = ModelReportesAzteca.generar_csv_telefonos(
                    request.getParameter("_tipo_base"),
                    request.getParameter("territorio"),
                    request.getParameter("gerente"),
                    request.getParameter("gerencia")
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
