//==============================================================================
package arcade.controller;
//==============================================================================
 
import arcade.data.RegionDao;
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
 
public class ManageRegion extends HttpServlet {
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
        if ("select_region_tabla".equals(accion)) {
            String renglones = RegionDao.select_region_tabla(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_region_check".equals(accion)) {
            String renglones = RegionDao.select_region_check(
                    request.getParameter("cadena_clientes")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_region_combo".equals(accion)) {
            String renglones = RegionDao.select_region_combo(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_region".equals(accion)) {
            String renglones = RegionDao.insert_region(
                    request.getParameter("region"),
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_region".equals(accion)) {
            String renglones = RegionDao.update_region(
                    Integer.parseInt(request.getParameter("region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_region".equals(accion)) {
            String renglones = RegionDao.delete_region(Integer.parseInt(request.getParameter("id_region")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("select_region_combo_materialize".equals(accion)) {
            String renglones = RegionDao.select_region_combo(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}