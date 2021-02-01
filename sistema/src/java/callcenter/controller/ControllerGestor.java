package callcenter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import callcenter.model.ModelGestor;
import java.io.PrintWriter;

public class ControllerGestor extends HttpServlet {
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
        String action = request.getParameter("action");
//        PrintWriter writer;
//////////////////////////////////////////////////////////////
        if (action.equals("select_buscar_cuentas")) {
            String Respuesta = ModelGestor.select_buscar_cuentas(
                    request.getParameter("busqueda"),
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_datos_cuenta")) {
            String Respuesta = ModelGestor.select_datos_cuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_datos_cuenta_relacionada")) {
            String Respuesta = ModelGestor.select_datos_cuenta_relacionada(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_telefonos_cr")) {
            String Respuesta = ModelGestor.select_telefonos_cr(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_gestiones_cuenta")) {
            String Respuesta = ModelGestor.select_gestiones_cuenta(
                    request.getParameter("cuenta"),
                    request.getParameter("fecha_inico")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("mostrar_pagos_diarios")) {
            String Respuesta = ModelGestor.mostrar_pagos_diarios(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_convenios_cuenta")) {
            String Respuesta = ModelGestor.select_convenios_cuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_gestor_tabla")) {
            String Respuesta = ModelGestor.select_gestor_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_gestor_tabla_filtro")) {
            String Respuesta = ModelGestor.select_gestor_tabla_filtro(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_cuenta_siguiente")) {
            String Respuesta = ModelGestor.select_cuenta_siguiente(
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("guardar_gestion")) {
            String Respuesta = ModelGestor.guardar_gestion(
                    request.getParameter("datos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("insertar_convenio")) {
            String Respuesta = ModelGestor.insertar_convenio(
                    request.getParameter("datos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_saldos_gestores")) {
            String Respuesta = ModelGestor.select_saldos_gestores(
                    request.getParameter("id_usuario"),
                    request.getParameter("id_equipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_cuentas_de_estaus")) {
            String Respuesta = ModelGestor.select_cuentas_de_estaus(
                    request.getParameter("id_equipo"),
                    request.getParameter("id_status"),
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_equipos_usuario")) {
            String Respuesta = ModelGestor.select_equipos_usuario(
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_llamadas_gestor")) {
            String Respuesta = ModelGestor.select_llamadas_gestor(
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("insertar_agenda")) {
            String Respuesta = ModelGestor.insertar_agenda(
                    request.getParameter("cliente_unico"),
                    request.getParameter("id_usuario"),
                    request.getParameter("descripcion"),
                    request.getParameter("fecha"),
                    request.getParameter("hora")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_agendas")) {
            String Respuesta = ModelGestor.select_agendas(
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("descartar_agenda_gestor")) {
            String Respuesta = ModelGestor.descartar_agenda_gestor(
                    request.getParameter("id_reg")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }

    }
}
