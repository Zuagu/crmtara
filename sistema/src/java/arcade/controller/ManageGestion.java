//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.GestionDao;
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

public class ManageGestion extends HttpServlet {
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
        if ("select_gestion_tabla".equals(accion)) {
            String renglones = GestionDao.select_gestion_tabla(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestiones_cuenta".equals(accion)) {
            String renglones = GestionDao.select_gestiones_cuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestiones_cuenta_fit".equals(accion)) {
            String renglones = GestionDao.select_gestiones_cuenta_fit(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestiones_cuenta_todas".equals(accion)) {
            String renglones = GestionDao.select_gestiones_cuenta_todas(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestion_combo".equals(accion)) {
            String renglones = GestionDao.select_gestion_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_gestion".equals(accion)) {
            String renglones = GestionDao.insert_gestion(
                    request.getParameter("cuenta"),
                    request.getParameter("numero_marcado"),
                    Integer.parseInt(request.getParameter("id_estatus_cuenta")),
                    Integer.parseInt(request.getParameter("id_estatus_llamada")),
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("gestion"),
                    request.getParameter("duracion"),
                    request.getParameter("retraso_llamada"),
                    request.getParameter("expediente"),
                    Integer.parseInt(request.getParameter("f_predictivo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_gestion".equals(accion)) {
            String renglones = GestionDao.update_gestion(
                    Integer.parseInt(request.getParameter("gestion")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_gestion".equals(accion)) {
            String renglones = GestionDao.delete_gestion(Integer.parseInt(request.getParameter("id_gestion")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_reporte_gestiones".equals(accion)) {
            String renglones = GestionDao.select_reporte_gestiones(
                    Integer.parseInt(request.getParameter("id_sucursal")),
                    request.getParameter("fecha_inicio"),
                    request.getParameter("fecha_fin"),
                    request.getParameter("columna"),
                    request.getParameter("orden")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_reporte_gestiones_csv".equals(accion)) {
            String renglones = GestionDao.select_reporte_gestiones_csv(
                    Integer.parseInt(request.getParameter("id_cliente")),
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("fecha_inicial"),
                    request.getParameter("fecha_final"),
                    request.getParameter("hora_inicial"),
                    request.getParameter("hora_final")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_llamadas_gestor".equals(accion)) {
            System.out.println("ManageGestion: Línea 149: " + Integer.parseInt(request.getParameter("id_usuario")));
            String renglones = GestionDao.select_llamadas_gestor(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_llamadas_gestor2".equals(accion)) {
            String renglones = GestionDao.select_llamadas_gestor2(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("import_gestiones_blaster".equals(accion)) {
            String renglones = GestionDao.import_gestiones_blaster(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestiones_chbk".equals(accion)) {
            String resultado = GestionDao.select_gestiones_chbk_csv(
                    request.getParameter("desde"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(resultado);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_reporte_gestiones_region".equals(accion)) {
            String renglones = GestionDao.select_reporte_gestiones_region(
                    Integer.parseInt(request.getParameter("id_region")),
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
