//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.VacanteDao;
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

public class ManageVacante extends HttpServlet {
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
        if ("select_vacante_tabla".equals(accion)) {
            String renglones = VacanteDao.select_vacante_tabla(
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_vacante_combo".equals(accion)) {
            String renglones = VacanteDao.select_vacante_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_vacante".equals(accion)) {
            String renglones = VacanteDao.insert_vacante(
                    request.getParameter("vacante"),
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_vacante".equals(accion)) {
            String renglones = VacanteDao.update_vacante(
                    Integer.parseInt(request.getParameter("id_vacante"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_vacante".equals(accion)) {
            String renglones = VacanteDao.delete_vacante(
                    Integer.parseInt(request.getParameter("id_vacante"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("udpate_id_usuario_vacante".equals(accion)) {
            String renglones = VacanteDao.udpate_id_usuario_vacante(
                    Integer.parseInt(request.getParameter("id_vacante")),
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Float.parseFloat(request.getParameter("sueldo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("reasignar_vacante".equals(accion)) {
            String renglones = VacanteDao.reasignar_vacante(
                    Integer.parseInt(request.getParameter("puesto")),
                    Integer.parseInt(request.getParameter("vacante")),
                    Integer.parseInt(request.getParameter("usuario_id"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_data_vacante".equals(accion)) {
            String renglones = VacanteDao.select_data_vacante(
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
