////==============================================================================
//package arcade.controller;
////==============================================================================
//
//import arcade.data.XxyyzzDao;
////==============================================================================
//import java.io.IOException;
//import java.io.PrintWriter;
////==============================================================================
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
////==============================================================================
///* @author Luis Cortez */
////==============================================================================
//
//public class ManageXxyyzz extends HttpServlet {
////==============================================================================
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doPost(request, response);
//    }
////==============================================================================
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //======================================================================
//        String accion = request.getParameter("accion");
//        //======================================================================
//        if ("select_xxyyzz_tabla".equals(accion)) {
//            String renglones = XxyyzzDao.select_xxyyzz_tabla();
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(renglones);
//            writer.flush();
//            writer.close();
//        }//=====================================================================
//        else if ("select_xxyyzz_combo".equals(accion)) {
//            String renglones = XxyyzzDao.select_xxyyzz_combo();
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(renglones);
//            writer.flush();
//            writer.close();
//        }//=====================================================================
//        else if ("insert_xxyyzz".equals(accion)) {
//            String renglones = XxyyzzDao.insert_xxyyzz(request.getParameter("xxyyzz"));
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(renglones);
//            writer.flush();
//            writer.close();
//        }//=====================================================================
//        else if ("update_xxyyzz".equals(accion)) {
//            String renglones = XxyyzzDao.update_xxyyzz(request.getParameter("xxyyzz"));
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(renglones);
//            writer.flush();
//            writer.close();
//        }//=====================================================================
//        else if ("delete_xxyyzz".equals(accion)) {
//            String renglones = XxyyzzDao.delete_xxyyzz(Integer.parseInt(request.getParameter("id_xxyyzz")));
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(renglones);
//            writer.flush();
//            writer.close();
//        }//=====================================================================
//    }
//}
