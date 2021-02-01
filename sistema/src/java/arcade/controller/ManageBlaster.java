//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.BlasterDao;
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

public class ManageBlaster extends HttpServlet {
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
        if ("select_blaster_tabla".equals(accion)) {
            String renglones = BlasterDao.select_blaster_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_blaster_combo".equals(accion)) {
            String renglones = BlasterDao.select_blaster_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_blaster".equals(accion)) {
            String renglones = BlasterDao.insert_blaster(
                    request.getParameter("nombre"),
                    Integer.parseInt(request.getParameter("reintentos")),
                    Integer.parseInt(request.getParameter("timbrado")),
                    request.getParameter("troncal"),
                    request.getParameter("prefijo"),
                    request.getParameter("audio"),
                    Integer.parseInt(request.getParameter("confirmar"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_blaster".equals(accion)) {
            String renglones = BlasterDao.update_blaster(
                    Integer.parseInt(request.getParameter("id_blaster"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_blaster".equals(accion)) {
            String renglones = BlasterDao.delete_blaster(Integer.parseInt(request.getParameter("id_blaster")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("remarcar_blaster".equals(accion)) {
            String renglones = BlasterDao.remarcar_blaster(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_blaster")),
                    Integer.parseInt(request.getParameter("todo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("obtener_resultado_blaster".equals(accion)) {
            String renglones = BlasterDao.obtener_resultado_blaster(
                    Integer.parseInt(request.getParameter("id_blaster"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("genera_predictivo".equals(accion)) {
            String renglones = BlasterDao.genera_predictivo(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_blaster"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_blaster_resultado_tabla".equals(accion)) {
            String renglones = BlasterDao.select_blaster_resultado_tabla(
                    Integer.parseInt(request.getParameter("id_blaster")),
                    Integer.parseInt(request.getParameter("ans"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_audios_blaster".equals(accion)) {
            String renglones = BlasterDao.select_audios_blaster(
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_audios_blaster_tabla".equals(accion)) {
            String renglones = BlasterDao.select_audios_blaster_tabla(
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_nombre_audio_blaster".equals(accion)) {
            String renglones = BlasterDao.update_nombre_audio_blaster(
                    Integer.parseInt(request.getParameter("id_audio")),
                    request.getParameter("audio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_estatus_audio_blaster".equals(accion)) {
            String renglones = BlasterDao.update_estatus_audio_blaster(
                    Integer.parseInt(request.getParameter("id_audio")),
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
