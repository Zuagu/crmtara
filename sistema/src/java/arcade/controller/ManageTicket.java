//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.TicketDao;
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

public class ManageTicket extends HttpServlet {
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
        if ("select_ticket_tabla".equals(accion)) {
            String renglones = TicketDao.select_ticket_tabla(
                    Integer.parseInt(request.getParameter("id_story"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tickets_en_proceso".equals(accion)) {
            String renglones = TicketDao.select_tickets_en_proceso();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tickets_usuario".equals(accion)) {
            String renglones = TicketDao.select_tickets_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_resumen_tickets_usuario".equals(accion)) {
            String renglones = TicketDao.select_resumen_tickets_usuario();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ticket_combo".equals(accion)) {
            String renglones = TicketDao.select_ticket_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_ticket".equals(accion)) {
            String renglones = TicketDao.insert_ticket(
                    request.getParameter("ticket"),
                    Integer.parseInt(request.getParameter("id_story")),
                    request.getParameter("comentarios"),
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_usuario_asignado")),
                    request.getParameter("tiempo_estimado"),
                    request.getParameter("categoria")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_ticket".equals(accion)) {
            String renglones = TicketDao.update_ticket(
                    //                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_ticket"))
            //                    request.getParameter("respuesta"),
            //                    Integer.parseInt(request.getParameter("id_estatus"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_tiempos_tickets".equals(accion)) {
            String renglones = TicketDao.update_tiempos_tickets(
                    Integer.parseInt(request.getParameter("id_ticket"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_ticket".equals(accion)) {
            String renglones = TicketDao.delete_ticket(
                    Integer.parseInt(request.getParameter("id_ticket"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
//        else if ("update_prioridad_ticket".equals(accion)) {
//            String renglones = TicketDao.update_prioridad_ticket(
//                    Integer.parseInt(request.getParameter("id_ticket"))
//            );
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(renglones);
//            writer.flush();
//            writer.close();
//        }//=====================================================================
//        else if ("select_detalles_tickets".equals(accion)) {
//            String renglones = TicketDao.select_detalles_tickets();
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(renglones);
//            writer.flush();
//            writer.close();
//        }//=====================================================================
    }
}
