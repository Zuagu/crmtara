//==============================================================================
package arcade.controller;
//==============================================================================
 
import arcade.data.SucursalDao;
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
 
public class ManageSucursal extends HttpServlet {
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
        if ("select_sucursal_tabla".equals(accion)) {
            String renglones = SucursalDao.select_sucursal_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_sucursal_combo".equals(accion)) {
            String renglones = SucursalDao.select_sucursal_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_sucursal".equals(accion)) {
            String renglones = SucursalDao.insert_sucursal(
                    request.getParameter("sucursal")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_sucursal".equals(accion)) {
            String renglones = SucursalDao.update_sucursal(
                    Integer.parseInt(request.getParameter("id_sucursal")),
                    request.getParameter("sucursal")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_sucursal".equals(accion)) {
            String renglones = SucursalDao.delete_sucursal(
                    Integer.parseInt(request.getParameter("id_sucursal"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("generar_mapa".equals(accion)) {
            String renglones = SucursalDao.generar_mapa(
                    Integer.parseInt(request.getParameter("id_sucursal"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_clases".equals(accion)) {
            String renglones = SucursalDao.update_clases(
                    Integer.parseInt(request.getParameter("id_piso")),
                    request.getParameter("clases")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}