//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.AsignacionDao;
import arcade.data.BasegeneralDao;
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

public class ManageBasegeneral extends HttpServlet {
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
        if ("select_basegeneral_tabla".equals(accion)) {
            String renglones = BasegeneralDao.select_basegeneral_tabla(
                    Integer.parseInt(request.getParameter("id_region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_basegeneral_tabla2".equals(accion)) {
            String resultado = BasegeneralDao.select_basegeneral_csv(
                    Integer.parseInt(request.getParameter("id_region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(resultado);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_basegeneral".equals(accion)) {
            String renglones = BasegeneralDao.update_basegeneral(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_basegeneral_asignar_tabla".equals(accion)) {
            String renglones = BasegeneralDao.select_basegeneral_asignar_tabla(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("asignar_cuentas".equals(accion)) {
            String renglones = BasegeneralDao.asignar_cuentas(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("equipos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_basechargeback_tabla".equals(accion)) {
            String renglones = BasegeneralDao.select_basechargeback_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_basechargeback_resumen_tabla".equals(accion)) {
            String renglones = BasegeneralDao.select_basechargeback_resumen_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_basechargeback_resumen_tabla_actual".equals(accion)) {
            String renglones = BasegeneralDao.select_basechargeback_resumen_tabla_actual();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_f_active_cuentas".equals(accion)) {
            String renglones = BasegeneralDao.update_f_active_cuentas(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("cuentas"),
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
