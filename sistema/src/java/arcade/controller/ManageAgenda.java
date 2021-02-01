package arcade.controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.AgendaDao;
import arcade.model.Agenda;
 
/* @author Luis Cortez */
public class ManageAgenda extends HttpServlet {
 
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
        if ("insert_agenda".equals(accion)) {
            String renglon;
            Agenda agenda = new Agenda();
 
            agenda.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            agenda.setCuenta(request.getParameter("cuenta"));
            agenda.setFecha(request.getParameter("fecha"));
            agenda.setHora(request.getParameter("hora"));
 
            renglon = AgendaDao.insert_agenda(agenda);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("update_agenda".equals(accion)) {
            String renglon;
            Agenda agenda = new Agenda();
            renglon = AgendaDao.update_agenda(agenda);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("delete_agenda".equals(accion)) {
            String renglon;
            Agenda agenda = new Agenda();
            renglon = AgendaDao.delete_agenda(agenda);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("select_agendas_pareja".equals(accion)) {
            String renglones = AgendaDao.select_agendas_pareja(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_agenda_tabla".equals(accion)) {
            String renglones = AgendaDao.select_agenda_tabla(
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
 
}