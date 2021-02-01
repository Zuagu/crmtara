//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.HorarioDao;
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

public class ManageHorario extends HttpServlet {
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
        if ("select_horario_tabla".equals(accion)) {
            String renglones = HorarioDao.select_horario_tabla(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_horario_user_adm".equals(accion)) {
            String renglones = HorarioDao.select_empleado(
                    request.getParameter("filtro"),
                    Integer.parseInt(request.getParameter("f_administrativo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_horario_user".equals(accion)) {
            String renglones = HorarioDao.select_horario_user(
                    request.getParameter("filtro"),
                    Integer.parseInt(request.getParameter("f_administrativo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_horario".equals(accion)) {
            String renglones = HorarioDao.insert_horario2(
//                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("id_usuario"),
                    request.getParameter("select_horario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_horario_admin".equals(accion)) {
            String renglones = HorarioDao.insert_horario_admin(
                    request.getParameter("id_usuario"),
                    Integer.parseInt(request.getParameter("dia")),
                    request.getParameter("entrada"),
                    request.getParameter("salida")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_horario".equals(accion)) {
            String renglones = HorarioDao.delete_horario(
                    Integer.parseInt(request.getParameter("id_horario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("select_horarios_combo".equals(accion)) {
            String renglones = HorarioDao.select_horarios_combo(
                    request.getParameter("tipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("select_nombre_usuario".equals(accion)) {
            String renglones = HorarioDao.select_nombre_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
   }
}

