//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.NodoOrganigramaDao;
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

public class ManageNodosOrganigrama extends HttpServlet {
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
        if ("select_nodos_organigrama".equals(accion)) {
            String renglones = NodoOrganigramaDao.select_nodos_organigrama(
                    Integer.parseInt(request.getParameter("id_padre"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_nodo_organigrama".equals(accion)) {
            String renglones = NodoOrganigramaDao.insert_nodo_organigrama(
                    request.getParameter("descripcion"),
                    Integer.parseInt(request.getParameter("id_padre"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_nodo_organigrama".equals(accion)) {
            String renglones = NodoOrganigramaDao.update_nodo_organigrama(
                    Integer.parseInt(request.getParameter("id_nodo")),
                    request.getParameter("descripcion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_nodo_organigrama".equals(accion)) {
            String renglones = NodoOrganigramaDao.delete_nodo_organigrama(
                    Integer.parseInt(request.getParameter("id_padre"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tipos_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.select_tipos_nodo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_tipo_nodo_organigrama".equals(accion)) {
            String renglones = NodoOrganigramaDao.delete_tipo_nodo_organigrama(
                    Integer.parseInt(request.getParameter("id_tipo_nodo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_tipo_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.insert_tipo_nodo(
                    request.getParameter("tipo_nodo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tipos_nodo_combo".equals(accion)) {
            String renglones = NodoOrganigramaDao.select_tipos_nodo_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_contenido_tipo_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.insert_contenido_tipo_nodo(
                    Integer.parseInt(request.getParameter("id_tipo_nodo")),
                    request.getParameter("descripcion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_contenidos_tipo_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.select_contenidos_tipo_nodo(
                    Integer.parseInt(request.getParameter("id_tipo_nodo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_contenido_tipo_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.delete_contenido_tipo_nodo(
                    Integer.parseInt(request.getParameter("id_tipo_nodo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_contenidos_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.insert_contenidos_nodo(
                    Integer.parseInt(request.getParameter("id_nodo")),
                    Integer.parseInt(request.getParameter("id_tipo_nodo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_contenidos_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.select_contenidos_nodo(
                    Integer.parseInt(request.getParameter("id_nodo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_contenido_nodo".equals(accion)) {
            String renglones = NodoOrganigramaDao.update_contenido_nodo(
                    Integer.parseInt(request.getParameter("id_contenido")),
                    request.getParameter("contenido")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
