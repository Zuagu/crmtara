package arcade.controller;

import arcade.data.NoticiaDao;
//==============================================================================
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//==============================================================================

public class ManageNoticias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
//==============================================================================

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//==============================================================================
        String accion = request.getParameter("accion");
        //EN ESTA ACCION ELIMINAMOS UNA CITA EN BASE AL ID DE LA CITA ESPECIFICADA
        //LA BORRA DE LA TABLA CITA
//==============================================================================
        if ("qa".equals(accion)) {
            System.out.println("QA.");

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print("QA.");
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_noticias".equals(accion)) {
            String renglones = NoticiaDao.select_noticias();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//====================================================================

    }

}