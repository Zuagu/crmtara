//===============================================================
package arcade.controller;
////==============================================================================

import arcade.data.ReferenciasDao;
import arcade.data.RegionDao;
////==============================================================================
import java.io.IOException;
import java.io.PrintWriter;
////==============================================================================
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

////==============================================================================

/**
 *
 * @author Soportec
 */
public class ManageReferencias extends HttpServlet {

//==============================================================================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
//==============================================================================

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        String json_str = request.getParameter("name");
//        Object[] array_object;
//        JSONArray list = new JSONArray();
//        list.add(json_str);
//        System.out.println(json_str);
//        
//        //String renglones = RegionDao.select_region_combo(datos);
//        
//        PrintWriter writer = response.getWriter();
//        writer.print(json_str);
//        writer.flush();
//        writer.close();
        //======================================================================
//    }
}
