//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.EstatusLlamadaDao;
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

public class ManageEstatusLlamada extends HttpServlet {
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
        if ("select_estatus_llamada_tabla".equals(accion)) {
            String renglones = EstatusLlamadaDao.select_estatus_llamada_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_llamada_combo".equals(accion)) {
            String renglones = EstatusLlamadaDao.select_estatus_llamada_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_estatus_llamada".equals(accion)) {
            String renglones = EstatusLlamadaDao.insert_estatus_llamada(
                    request.getParameter("estatus_llamada"),
                    request.getParameter("descripcion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_estatus_llamada".equals(accion)) {
            String renglones = EstatusLlamadaDao.update_estatus_llamada(
                    Integer.parseInt(request.getParameter("estatus_llamada"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_estatus_llamada".equals(accion)) {
            String renglones = EstatusLlamadaDao.delete_estatus_llamada(Integer.parseInt(request.getParameter("id_estatus_llamada")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
