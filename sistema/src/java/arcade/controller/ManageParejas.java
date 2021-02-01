package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.ParejaDao;
import arcade.model.Pareja;

/* @author AYCM */
public class ManageParejas extends HttpServlet {

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
            System.out.println("qa");
        } //====================================================================
        else if ("insert_pareja".equals(accion)) {
            String renglon;
            Pareja pareja = new Pareja();
            renglon = ParejaDao.insert_pareja(pareja);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_pareja".equals(accion)) {
            String renglon;
            Pareja pareja = new Pareja();
            renglon = ParejaDao.insert_pareja(pareja);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_pareja".equals(accion)) {
            String renglon;
            Pareja pareja = new Pareja();
            renglon = ParejaDao.update_pareja(pareja);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_pareja".equals(accion)) {
            String renglon;
            Pareja pareja = new Pareja();
            renglon = ParejaDao.delete_pareja(pareja);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
