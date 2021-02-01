//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.ConvenioDao;
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

public class ManageConvenio extends HttpServlet {
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
        if ("select_convenio_tabla".equals(accion)) {
            String renglones = ConvenioDao.select_convenio_tabla(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_cliente")),
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    Integer.parseInt(request.getParameter("id_reporte"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_convenio_agrupado_tabla".equals(accion)) {
            String renglones = ConvenioDao.select_convenio_agrupado_tabla(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_cliente")),
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    Integer.parseInt(request.getParameter("id_reporte"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_convenio_cuenta_tabla".equals(accion)) {
            String renglones = ConvenioDao.select_convenio_cuenta_tabla(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_convenio_combo".equals(accion)) {
            String renglones = ConvenioDao.select_convenio_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_convenio".equals(accion)) {
            String renglones = ConvenioDao.insert_convenio(
                    Float.parseFloat(request.getParameter("importe")),
                    request.getParameter("fecha"),
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_convenio".equals(accion)) {
            String renglones = ConvenioDao.update_convenio(
                    Integer.parseInt(request.getParameter("convenio"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_convenio".equals(accion)) {
            String renglones = ConvenioDao.delete_convenio(
                    Integer.parseInt(request.getParameter("id_convenio"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_convenio_gestor_tabla".equals(accion)) {
            String renglones = ConvenioDao.select_convenio_gestor_tabla(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_por_cobrar".equals(accion)) {
            String renglones = ConvenioDao.select_por_cobrar(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_reporte_gral".equals(accion)) {
            String renglones = ConvenioDao.select_reporte_gral(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    Integer.parseInt(request.getParameter("id_reporte"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================

    }
}
