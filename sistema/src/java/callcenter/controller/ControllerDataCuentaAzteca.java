/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelDataCuentaAzteca;

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
public class ControllerDataCuentaAzteca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Usamos el metodo del get para generar la pantalla del predictivo
        String cuenta = request.getParameter("cuenta");

        String telefono = request.getParameter("telefono");
        String id_usuario = request.getParameter("id_usuario");
        System.out.println("cuenta: " + cuenta + " id_usuario: " + id_usuario + " telefono: " + telefono);

        request.setAttribute("telefono", telefono);
        request.setAttribute("id_usuario", id_usuario);
        request.setAttribute("cuenta", cuenta);
        getServletContext().getRequestDispatcher("/predictivo_oscar.jsp").forward(request, response);
//        getServletContext().getRequestDispatcher("/predictivo_azteca.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
//        System.out.println(action);

        if (action.equals("datos_cuenta_azteca")) {
            String Respuesta = ModelDataCuentaAzteca.datosCuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_buscar_cuentas")) {
            String Respuesta = ModelDataCuentaAzteca.select_buscar_cuentas(
                    request.getParameter("busqueda"),
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_datos_cuenta_relacionada")) {
            String Respuesta = ModelDataCuentaAzteca.select_datos_cuenta_relacionada(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_telefonos_cr")) {
            String Respuesta = ModelDataCuentaAzteca.select_telefonos_cr(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_gestiones_cuenta")) {
            String Respuesta = ModelDataCuentaAzteca.select_gestiones_cuenta(
                    request.getParameter("cuenta"),
                    request.getParameter("fecha_inico")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_convenios_cuenta")) {
            String Respuesta = ModelDataCuentaAzteca.select_convenios_cuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_cuenta_siguiente")) {
            String Respuesta = ModelDataCuentaAzteca.select_cuenta_siguiente(
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();

        } else if (action.equals("guardar_gestion")) {
            String Respuesta = ModelDataCuentaAzteca.guardarGestion(
                    request.getParameter("datos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("insertar_convenio")) {
            String Respuesta = ModelDataCuentaAzteca.insertar_convenio(
                    request.getParameter("datos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();

        } else if (action.equals("select_cuentas_de_estaus")) {
            String Respuesta = ModelDataCuentaAzteca.select_cuentas_de_estaus(
                    request.getParameter("id_equipo"),
                    request.getParameter("id_status"),
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_primera_llamada_gestor")) {
            String Respuesta = ModelDataCuentaAzteca.select_primera_llamada_gestor(
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }else if (action.equals("select_numero_llamadas_gestor")) {
            String Respuesta = ModelDataCuentaAzteca.select_numero_llamadas_gestor(
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }else if (action.equals("select_numero_convenios_gestor")) {
            String Respuesta = ModelDataCuentaAzteca.select_numero_convenios_gestor(
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_numero_cuentas_tocadas_gestor")) {
            String Respuesta = ModelDataCuentaAzteca.select_numero_cuentas_tocadas_gestor(
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("actualizar_telefono_1")) {
            String Respuesta = ModelDataCuentaAzteca.actualizar_telefono_1(
                    request.getParameter("objContacto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("update_time_gestor")) {
            String Respuesta = ModelDataCuentaAzteca.update_time_gestor(
                    request.getParameter("id_gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("actualizar_informacion_contacto")) {
            String Respuesta = ModelDataCuentaAzteca.actualizar_informacion_contacto(
                    request.getParameter("nom_tel1"),
                    request.getParameter("tel1_1"),
                    request.getParameter("tel1_2"),
                    request.getParameter("nom_tel2"),
                    request.getParameter("tel2_1"),
                    request.getParameter("tel2_2"),
                    request.getParameter("nom_tel3"),
                    request.getParameter("tel3_1"),
                    request.getParameter("tel3_2"),
                    request.getParameter("nom_tel4"),
                    request.getParameter("tel4_1"),
                    request.getParameter("tel4_2"),
                    request.getParameter("nom_tel5"),
                    request.getParameter("tel5_1"),
                    request.getParameter("tel5_2"),
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("actualizar_informacion_aval")) {
            String Respuesta = ModelDataCuentaAzteca.actualizar_informacion_aval(
                    request.getParameter("nom_tel_aval"),
                    request.getParameter("tel_aval_1"),
                    request.getParameter("tel_aval_2"),
                    request.getParameter("calle_aval"),
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_pagos_cuenta")) {
            String Respuesta = ModelDataCuentaAzteca.select_pagos_cuenta(
                    request.getParameter("cuenta")
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
