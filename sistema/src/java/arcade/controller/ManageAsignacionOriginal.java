//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.AsignacionOriginalDao;
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

public class ManageAsignacionOriginal extends HttpServlet {
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
        if ("select_asignacionoriginal_tabla".equals(accion)) {
            String renglones = AsignacionOriginalDao.select_asignacionoriginal_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacionoriginal_combo".equals(accion)) {
            String renglones = AsignacionOriginalDao.select_asignacionoriginal_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_asignacion_original".equals(accion)) {
            String renglones = AsignacionOriginalDao.insert_asignacion_original();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_asignacionoriginal".equals(accion)) {
            String renglones = AsignacionOriginalDao.insert_asignacionoriginal(
                    request.getParameter("asignacionoriginal")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_asignacionoriginal".equals(accion)) {
            String renglones = AsignacionOriginalDao.delete_asignacionoriginal(
                    Integer.parseInt(request.getParameter("id_asignacionoriginal"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("truncate_asignacion_temporal".equals(accion)) {
            String renglones = AsignacionOriginalDao.truncate_asignacion_temporal();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
