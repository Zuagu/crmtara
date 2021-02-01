package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.SpeechDao;
import arcade.model.Speech;

/**
 * @author AYCM
 */
public class ManageSpeeches extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        //======================================================================
        if ("qa".equals(accion)) {
            System.out.println("qa");
        } //====================================================================
        else if ("insert_speech".equals(accion)) {
            String renglon;
            Speech speech = new Speech();
            renglon = SpeechDao.insert_speech(speech);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("update_speech".equals(accion)) {
            String renglon;
            Speech speech = new Speech();
            renglon = SpeechDao.update_speech(speech);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("delete_speech".equals(accion)) {
            String renglon;
            Speech speech = new Speech();
            renglon = SpeechDao.delete_speech(speech);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
    }

}
