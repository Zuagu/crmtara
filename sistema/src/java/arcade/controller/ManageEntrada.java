//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.EntradaDao;
//==============================================================================
import java.io.IOException;
import java.io.PrintWriter;
//==============================================================================
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//==============================================================================
/* @author Luis Cortez */
//==============================================================================

public class ManageEntrada extends HttpServlet {
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
        if ("select_entrada_tabla".equals(accion)) {
            String renglones = EntradaDao.select_entrada_tabla(
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_nombre_entrada".equals(accion)) {
            String renglones = EntradaDao.select_nombre_entrada(
                    Integer.parseInt(request.getParameter("id"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_registro".equals(accion)) {
            String renglones = EntradaDao.insert_registro(
                    Integer.parseInt(request.getParameter("id"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_registro_2".equals(accion)) {
            String renglones = EntradaDao.insert_registro_2(
                    Integer.parseInt(request.getParameter("id"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_entrada".equals(accion)) {
            String renglones = EntradaDao.update_entrada(
                    Integer.parseInt(request.getParameter("id_entrada"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_entrada".equals(accion)) {
            String renglones = EntradaDao.delete_entrada(
                    Integer.parseInt(request.getParameter("id_entrada"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_hora_server".equals(accion)) {
            String renglones = EntradaDao.select_hora_server();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        if ("select_reporte_entradas".equals(accion)) {
            String renglones = EntradaDao.select_reporte_entradas(
                    Integer.parseInt(request.getParameter("id_sucursal")),
                    Integer.parseInt(request.getParameter("id_admin")),
                    request.getParameter("fecha1"),
                    request.getParameter("fecha2")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_entradas".equals(accion)) {
            String renglones = EntradaDao.select_datos_entradas(
                    Integer.parseInt(request.getParameter("region")),
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        if ("insert_comentarios".equals(accion)) {
            String renglones = EntradaDao.insert_comentarios(
                    request.getParameter("comentario"),
                    Integer.parseInt(request.getParameter("registro"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        if ("update_hora_emtrada".equals(accion)) {
            String renglones = EntradaDao.update_hora_emtrada(
                    Integer.parseInt(request.getParameter("registro")),
                    request.getParameter("nueva_h_entrada"),
                    request.getParameter("nueva_h_salida"),
                    Integer.parseInt(request.getParameter("status"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================

    }
}
