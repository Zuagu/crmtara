//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.UpdateCoreDao;
//==============================================================================
import java.io.IOException;
import java.io.PrintWriter;
//==============================================================================
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//==============================================================================

public class ManageUpdateCore extends HttpServlet {
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
        //======================================================================
        String accion = request.getParameter("accion");
        //======================================================================
        if ("solicitud_core".equals(accion)) {
            String renglones = UpdateCoreDao.solicitud_core(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_cliente".equals(accion)) {
            String renglones = UpdateCoreDao.update_cliente(
                    request.getParameter("d1"), // cuenta
                    request.getParameter("d3"), // nombre
                    request.getParameter("d5"), // plan
                    request.getParameter("d6"), // Ciudad
                    request.getParameter("d7"), // cp
                    request.getParameter("d8"), // colonia
                    request.getParameter("d9"), // calle
                    request.getParameter("d10") // numero
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_convenios_cuenta".equals(accion)) {
            String renglones = UpdateCoreDao.select_convenios_cuenta(
                    Integer.parseInt(request.getParameter("cuenta")) // cuenta
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_datos_convenio".equals(accion)) {
            String renglones = UpdateCoreDao.update_datos_convenio(
                    Integer.parseInt(request.getParameter("id_convenio")), // cuenta
                    Float.parseFloat(request.getParameter("convenio")),
                    Integer.parseInt(request.getParameter("gestor")),
                    request.getParameter("fecha"),
                    Float.parseFloat(request.getParameter("aplica"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tabla_telefono".equals(accion)) {
            String renglones = UpdateCoreDao.select_tabla_telefono(
                    Integer.parseInt(request.getParameter("cuenta")) // cuenta
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_datos_telefono1".equals(accion)) {
            String renglones = UpdateCoreDao.update_datos_telefono1(
                    Integer.parseInt(request.getParameter("cuenta")), // 
                    request.getParameter("numero"), // 
                    request.getParameter("nombre"), // 
                    request.getParameter("tipo_tel") // 
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_datos_relacionada".equals(accion)) {
            String renglones = UpdateCoreDao.update_datos_relacionada(
                    Integer.parseInt(request.getParameter("cuenta")), // 
                    request.getParameter("numero"), // 
                    request.getParameter("tipo"), // 
                    request.getParameter("ant_tel") // 
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_pagos_cuenta".equals(accion)) {
            String renglones = UpdateCoreDao.select_pagos_cuenta(
                    Integer.parseInt(request.getParameter("cuenta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_pago".equals(accion)) {
            String renglones = UpdateCoreDao.delete_pago(
                    Integer.parseInt(request.getParameter("id_pago"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("eliminar_telefonos_individual".equals(accion)) {
            String renglones = UpdateCoreDao.eliminar_telefonos_individual(
                    Integer.parseInt(request.getParameter("cuenta")),
                    request.getParameter("numero"),
                    request.getParameter("codigo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_todo".equals(accion)) {
            String renglones = UpdateCoreDao.delete_todo(
                    Integer.parseInt(request.getParameter("cuenta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_convenio".equals(accion)) {
            String renglones = UpdateCoreDao.delete_convenio(
                    Integer.parseInt(request.getParameter("id_convenio"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
           else if ("select_tabla_gestiones".equals(accion)) {
            String renglones = UpdateCoreDao.select_tabla_gestiones(
                    Integer.parseInt(request.getParameter("cuenta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
           else if ("actualizar_gestiones".equals(accion)) {
            String renglones = UpdateCoreDao.actualizar_gestiones(
                    Integer.parseInt(request.getParameter("cuenta")),
                    Integer.parseInt(request.getParameter("numero_tabla")),
                    Integer.parseInt(request.getParameter("id_gestion")),
                    Integer.parseInt(request.getParameter("estatus"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
           else if ("actualizar_subgestiones".equals(accion)) {
            String renglones = UpdateCoreDao.actualizar_subgestiones(
                    Integer.parseInt(request.getParameter("cuenta")),
                    Integer.parseInt(request.getParameter("numero_tabla")),
                    Integer.parseInt(request.getParameter("id_gestion")),
                    Integer.parseInt(request.getParameter("estatus"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
