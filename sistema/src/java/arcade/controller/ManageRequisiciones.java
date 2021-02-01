package arcade.controller;

import arcade.data.RequisicionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageRequisiciones
        extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("select_requisiciones_tabla".equals(accion)) {
            String renglones = RequisicionDao.select_requisiciones_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("select_requisiciones_tabla_usuario".equals(accion)) {
            String renglones = RequisicionDao.select_requisiciones_tabla_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("agregar_producto_requisicion".equals(accion)) {
            String renglones = RequisicionDao.agregar_producto_requisicion(
                    Float.parseFloat(request.getParameter("cantidad")),
                    request.getParameter("id_producto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("insert_requisicion".equals(accion)) {
            String renglones = RequisicionDao.insert_requisicion(
                    Integer.parseInt(request.getParameter("usuario_sistema")),
                    request.getParameter("fecha_requerida"),
                    (Boolean.parseBoolean(request.getParameter("f_urgente")) ? 1 : 0),
                    request.getParameter("comentarios"),
                    request.getParameter("lineas_requisicion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("select_cuerpo_requisicion".equals(accion)) {
            String renglones = RequisicionDao.select_cuerpo_requisicion(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("select_detalles_documento".equals(accion)) {
            String renglones = RequisicionDao.select_detalles_documento(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }
    }
}
