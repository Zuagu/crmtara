//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.EstatusCuentaDao;
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

public class ManageEstatusCuenta extends HttpServlet {
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
        if ("select_estatus_cuenta_cliente_tabla".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_cuenta_cliente_tabla(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_cuenta_cliente_tabla2".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_cuenta_cliente_tabla2(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_cuenta_cliente_tabla3".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_cuenta_cliente_tabla3(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_cuenta_tabla".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_cuenta_tabla(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_puesto_tabla".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_puesto_tabla(
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_cuenta_combo".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_cuenta_combo(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_cuenta_cuenta_combo".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_cuenta_cuenta_combo(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_puesto_combo".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_puesto_combo(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_estatus_cuenta".equals(accion)) {
            String renglones = EstatusCuentaDao.insert_estatus_cuenta(
                    request.getParameter("estatus_cuenta"),
                    request.getParameter("descripcion"),
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_estatus_cuenta".equals(accion)) {
            String renglones = EstatusCuentaDao.update_estatus_cuenta(
                    Integer.parseInt(request.getParameter("estatus_cuenta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_estatus_cuenta".equals(accion)) {
            String renglones = EstatusCuentaDao.delete_estatus_cuenta(
                    Integer.parseInt(request.getParameter("id_estatus_cuenta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_estatus_puesto".equals(accion)) {
            String renglones = EstatusCuentaDao.insert_estatus_puesto(
                    Integer.parseInt(request.getParameter("id_puesto")),
                    request.getParameter("estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_saldos_estatus".equals(accion)) {
            String renglones = EstatusCuentaDao.select_estatus_cuenta_tabla(
                    request.getParameter("cadena_clientes"),
                    request.getParameter("cadena_regiones"),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_equipos"),
                    Integer.parseInt(request.getParameter("resto")),
                    request.getParameter("tiene_cr")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuentas_estatus".equals(accion)) {
            String renglones = EstatusCuentaDao.select_cuentas_estatus(
                    request.getParameter("clientes"),
                    request.getParameter("regiones"),
                    request.getParameter("asignaciones"),
                    request.getParameter("equipos"),
                    request.getParameter("resto"),
                    request.getParameter("tiene_cr"),
                    request.getParameter("id_estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("editar_puede_cambiar".equals(accion)) {
            String renglones = EstatusCuentaDao.editar_puede_cambiar(
                    Integer.parseInt(request.getParameter("id_estatus")),
                    request.getParameter("puede_cambiar"),
                    request.getParameter("puede_cambiar_txt")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
