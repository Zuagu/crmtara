//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.IndicadorDao;
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

public class ManageIndicador extends HttpServlet {
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
        if ("select_indicador_tabla".equals(accion)) {
            String renglones = IndicadorDao.select_indicador_tabla(
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_indicador_rango_tabla".equals(accion)) {
            String renglones = IndicadorDao.select_indicador_rango_tabla(
                    request.getParameter("fecha"),
                    request.getParameter("fecha_fin")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_indicador_rango_chbk_tabla".equals(accion)) {
            String renglones = IndicadorDao.select_indicador_rango_chbk_tabla(
                    request.getParameter("fecha"),
                    request.getParameter("fecha_fin")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_indicador_combo".equals(accion)) {
            String renglones = IndicadorDao.select_indicador_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_indicador".equals(accion)) {
            String renglones = IndicadorDao.insert_indicador(
                    request.getParameter("indicador")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_indicador".equals(accion)) {
            String renglones = IndicadorDao.insert_indicador(
                    request.getParameter("indicador")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_indicador".equals(accion)) {
            String renglones = IndicadorDao.delete_indicador(
                    Integer.parseInt(request.getParameter("id_indicador"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
