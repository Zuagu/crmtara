//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.EquipoDao;
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

public class ManageEquipo extends HttpServlet {
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
        if ("select_equipo_check".equals(accion)) {
            String renglones = EquipoDao.select_equipo_check(
                    request.getParameter("cadena_asignaciones")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_equipo_combo".equals(accion)) {
            String renglones = EquipoDao.select_equipo_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_equipo".equals(accion)) {
            String renglones = EquipoDao.insert_equipo( //                    request.getParameter("equipo")
                    );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_equipo".equals(accion)) {
            String renglones = EquipoDao.update_equipo(
                    Integer.parseInt(request.getParameter("id_equipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_equipo".equals(accion)) {
            String renglones = EquipoDao.delete_equipo(
                    Integer.parseInt(request.getParameter("id_equipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("deshacer_equipo".equals(accion)) {
            String renglones = EquipoDao.deshacer_equipo(
                    Integer.parseInt(request.getParameter("id_equipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("reset_equipo".equals(accion)) {
            String renglones = EquipoDao.reset_equipo(
                    Integer.parseInt(request.getParameter("id_equipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_usuarios_equipo".equals(accion)) {
            String renglones = EquipoDao.select_usuarios_equipo(
                    Integer.parseInt(request.getParameter("id_equipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
