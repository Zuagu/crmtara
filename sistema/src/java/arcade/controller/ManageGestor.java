//==============================================================================
package arcade.controller;
//==============================================================================
 
import arcade.data.GestorDao;
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
 
public class ManageGestor extends HttpServlet {
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
        if ("select_gestor_tabla".equals(accion)) {
            String renglones = GestorDao.select_gestor_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestor_tabla_control".equals(accion)) {
            String renglones = GestorDao.select_gestor_tabla_control();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestor_tabla_control_filtro".equals(accion)) {
            String renglones = GestorDao.select_gestor_tabla_control_filtro(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestor_tabla_filtro".equals(accion)) {
            String renglones = GestorDao.select_gestor_tabla_filtro(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestor_combo".equals(accion)) {
            String renglones = GestorDao.select_gestor_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_gestor".equals(accion)) {
            String renglones = GestorDao.insert_gestor(
                    request.getParameter("gestor")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_gestor".equals(accion)) {
            String renglones = GestorDao.insert_gestor(request.getParameter("gestor"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_gestor".equals(accion)) {
            String renglones = GestorDao.delete_gestor(Integer.parseInt(request.getParameter("id_gestor")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_f_bloqueado".equals(accion)) {
            String renglones = GestorDao.update_f_bloqueado(
                    Integer.parseInt(request.getParameter("id_gestor"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_gestor_panel_tabla".equals(accion)) {
            String renglones = GestorDao.select_gestor_panel_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_crs_gestor".equals(accion)) {
            String renglones = GestorDao.update_crs_gestor(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("f_cr"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_importe_gestor".equals(accion)) {
            String renglones = GestorDao.update_importe_gestor(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("importe"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_orden_gestor".equals(accion)) {
            String renglones = GestorDao.update_orden_gestor(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("orden")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_estatus_estrategia_gestor".equals(accion)) {
            String renglones = GestorDao.update_estatus_estrategia_gestor(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("cadena_estatus"),
                    request.getParameter("estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_seguimientos_gestor".equals(accion)) {
            String renglones = GestorDao.update_seguimientos_gestor(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("f_seguimiento"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("ajustes_estrategia_gestor".equals(accion)) {
            System.out.println("ManageGestor: Línea 180: " + Integer.parseInt(request.getParameter("id_usuario")));
            String renglones = GestorDao.ajustes_estrategia_gestor(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_categoria_combo".equals(accion)) {
            String renglones = GestorDao.select_categoria_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_categoria_gestor".equals(accion)) {
            String renglones = GestorDao.update_categoria_gestor(
                    Integer.parseInt(request.getParameter("id_gestor")),
                    Integer.parseInt(request.getParameter("id_categoria"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_categoria_gestor".equals(accion)) {
            String renglones = GestorDao.insert_categoria_gestor(
                   request.getParameter("cadena_estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_categoria".equals(accion)) {
            String renglones = GestorDao.delete_categoria(
                    Integer.parseInt(request.getParameter("id_categoria"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("select_nombre_gestor".equals(accion)) {
            String renglones = GestorDao.select_nombre_gestor(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
		else if ("evaluar_estatus_f_bloqueado".equals(accion)) {
            String renglones = GestorDao.evaluar_estatus_f_bloqueado(
                    Integer.parseInt(request.getParameter("id_gestor"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}