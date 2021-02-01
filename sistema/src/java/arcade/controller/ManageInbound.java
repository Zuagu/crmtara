package arcade.controller;
 
import arcade.data.InboundDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/** @author Luis Cortez*/
 
public class ManageInbound extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        //======================================================================
        if ("select_inbound_fecha".equals(accion)) {
            String renglones = InboundDao.select_inbound_fecha(
                    request.getParameter("fecha"),
                    request.getParameter("hasta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }
        //======================================================================
        else if ("select_inbound_fecha_resumen".equals(accion)) {
            String renglones = InboundDao.select_inbound_fecha_resumen(
                    request.getParameter("fecha"),
                    request.getParameter("hasta"),
                    request.getParameter("group")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }
        //======================================================================
        else if ("select_outbound_fecha".equals(accion)) {
            String renglones = InboundDao.select_outbound_fecha(
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }
        //======================================================================
        else if ("select_outbound_fecha_resumen".equals(accion)) {
            String renglones = InboundDao.select_inbound_fecha_resumen(
                    request.getParameter("fecha"),
                    request.getParameter("hasta"),
                    request.getParameter("group")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }
 
    }
}