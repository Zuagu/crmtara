//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.CargarArchivoDao;
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

public class ManageCargarArchivo extends HttpServlet {
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
        if ("select_nombre_archivos_tabla".equals(accion)) {
            String renglones = CargarArchivoDao.select_nombre_archivos_tabla(
                    request.getParameter("filtro"),
                    Integer.parseInt(request.getParameter("usuario_sistema"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_cargar_archivo".equals(accion)) {
            String renglones = CargarArchivoDao.insert_cargar_archivo(
                    request.getParameter("fichero"),
                    Integer.parseInt(request.getParameter("usuario_sistema"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_archivo_filtro".equals(accion)) {
            String renglones = CargarArchivoDao.select_archivo_filtro(
                    request.getParameter("filtro"),
                    Integer.parseInt(request.getParameter("usuario_sistema"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_cargar_archivo_rh".equals(accion)) {
            String renglones = CargarArchivoDao.insert_cargar_archivo_rh(
                    request.getParameter("fichero"),
                    Integer.parseInt(request.getParameter("usuario_sistema"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_archivo_filtro_rh".equals(accion)) {
            String renglones = CargarArchivoDao.select_archivo_filtro_rh(
                    request.getParameter("filtro"),
                    Integer.parseInt(request.getParameter("usuario_sistema"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
