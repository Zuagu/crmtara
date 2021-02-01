//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.StoryDao;
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

public class ManageStory extends HttpServlet {
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
        if ("select_story_tabla".equals(accion)) {
            String renglones = StoryDao.select_story_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_story_combo".equals(accion)) {
            String renglones = StoryDao.select_story_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_story".equals(accion)) {
            String renglones = StoryDao.insert_story(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("story"),
                    request.getParameter("descripcion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_story".equals(accion)) {
            String renglones = StoryDao.update_story(
                    Integer.parseInt(request.getParameter("id_story"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_story".equals(accion)) {
            String renglones = StoryDao.delete_story(
                    Integer.parseInt(request.getParameter("id_story"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_usuarios_desarrollo".equals(accion)) {
            String renglones = StoryDao.select_usuarios_desarrollo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_reporte_actividades".equals(accion)) {
            String renglones = StoryDao.select_reporte_actividades(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("fecha"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_reporte_actividades".equals(accion)) {
            String renglones = StoryDao.select_datos_reporte_actividades(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
