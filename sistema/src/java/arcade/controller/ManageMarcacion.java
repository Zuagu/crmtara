//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.MarcacionDao;
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

public class ManageMarcacion extends HttpServlet {
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
        if ("select_marcacion_tabla".equals(accion)) {
            String renglones = MarcacionDao.select_marcacion_tabla(
                    request.getParameter("estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_marcacion_combo".equals(accion)) {
            String renglones = MarcacionDao.select_marcacion_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_marcacion".equals(accion)) {
            String renglones = MarcacionDao.insert_marcacion(request.getParameter("marcacion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_marcacion".equals(accion)) {
            String renglones = MarcacionDao.insert_marcacion(request.getParameter("marcacion"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_marcacion".equals(accion)) {
            String renglones = MarcacionDao.delete_marcacion(
                    Integer.parseInt(request.getParameter("id_marcacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_campania_marcacion".equals(accion)) {
            String renglones = MarcacionDao.insert_campania_marcacion(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    Integer.parseInt(request.getParameter("f_tipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_estatus_campania".equals(accion)) {
            String renglones = MarcacionDao.update_estatus_campania(
                    Integer.parseInt(request.getParameter("id_campaign"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_cola_campania".equals(accion)) {
            String renglones = MarcacionDao.update_cola_campania(
                    Integer.parseInt(request.getParameter("id_campaign")),
                    Integer.parseInt(request.getParameter("cola"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("identificar".equals(accion)) {
            String renglones = MarcacionDao.identificar();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_numeros_tabla".equals(accion)) {
            String renglones = MarcacionDao.select_numeros_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
