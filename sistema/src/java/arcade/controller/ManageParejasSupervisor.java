package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.ParejaSupervisorDao;
import arcade.model.ParejaSupervisor;

/**
 * @author AYCM
 */
public class ManageParejasSupervisor extends HttpServlet {

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
        if ("qa".equals(accion)) {
            String renglon = "";
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();

        } //====================================================================
        else if ("insert_parejasupervisor".equals(accion)) {
            String renglon;
            ParejaSupervisor parejasupervisor = new ParejaSupervisor();
            renglon = ParejaSupervisorDao.insert_parejasupervisor(parejasupervisor);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("update_parejasupervisor".equals(accion)) {
            String renglon;
            ParejaSupervisor parejasupervisor = new ParejaSupervisor();
            renglon = ParejaSupervisorDao.update_parejasupervisor(parejasupervisor);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("delete_parejasupervisor".equals(accion)) {
            String renglon;
            ParejaSupervisor parejasupervisor = new ParejaSupervisor();
            renglon = ParejaSupervisorDao.delete_parejasupervisor(parejasupervisor);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
    }

}
