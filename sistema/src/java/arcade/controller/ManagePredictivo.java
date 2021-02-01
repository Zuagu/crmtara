//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.PredictivoDao;
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

public class ManagePredictivo extends HttpServlet {
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
        if ("datos_regiones".equals(accion)) {
            String renglones = PredictivoDao.datos_regiones();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("estatus_regiones".equals(accion)) {
            String renglones = PredictivoDao.estatus_regiones();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("estatus_region".equals(accion)) {
            String renglones = PredictivoDao.estatus_region(
                    Integer.parseInt(request.getParameter("id_region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("datos_asignacion".equals(accion)) {
            String renglones = PredictivoDao.datos_asignacion(
                    Integer.parseInt(request.getParameter("id_region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("estatus_asignacion".equals(accion)) {
            String renglones = PredictivoDao.estatus_asignacion(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_caja_asignaciones".equals(accion)) {
            String renglones = PredictivoDao.select_caja_asignaciones(
                    Integer.parseInt(request.getParameter("tiempo")),
                    request.getParameter("id_region")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_caja_estados".equals(accion)) {
            String renglones = PredictivoDao.select_caja_estados(
                    request.getParameter("cadena_asignaciones")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_caja_status".equals(accion)) {
            String renglones = PredictivoDao.select_caja_status(
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_estados")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tabla_predictivo".equals(accion)) {
            String renglones = PredictivoDao.select_tabla_predictivo(
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_estados"),
                    request.getParameter("cadena_status"),
                    request.getParameter("cadena_tipo_numero"),
                    Integer.parseInt(request.getParameter("cr")),
                    Float.parseFloat(request.getParameter("resto")),
                    request.getParameter("desde")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}