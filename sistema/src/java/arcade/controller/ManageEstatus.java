package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.EstatusDao;
import arcade.model.Estatus;
//==============================================================================
/* @author ARCADE Software Group */
//==============================================================================

public class ManageEstatus extends HttpServlet {

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
        else if ("insert_estatus".equals(accion)) {
            String renglon;
            Estatus estatus = new Estatus();
            renglon = EstatusDao.insert_estatus(estatus);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("update_estatus".equals(accion)) {
            String renglon;
            Estatus estatus = new Estatus();
            renglon = EstatusDao.update_estatus(estatus);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("delete_estatus".equals(accion)) {
            String renglon;
            Estatus estatus = new Estatus();
            renglon = EstatusDao.delete_estatus(estatus);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_estatus_gestor".equals(accion)) {
            String renglon;
            Estatus estrategia = new Estatus();

            estrategia.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            estrategia.setId_estatus(Integer.parseInt(request.getParameter("id_estatus")));

            renglon = EstatusDao.update_estatus_gestor(estrategia);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//================================================================
        else if ("select_estatus_conexion".equals(accion)) {
            String renglones = "";
            List<Estatus> estatus = EstatusDao.select_estatus_conexion(
                    Integer.parseInt(request.getParameter("id_usuario")));

            for (Estatus e : estatus) {
                renglones += "<option value='" + e.getId_estatus() + "'>" + e.getEstatus() + "</option>";
            }
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_nombre_estatus".equals(accion)) {
            String renglon;
            renglon = EstatusDao.select_nombre_estatus(Integer.parseInt(request.getParameter("id_gestor")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_llamada_puesto".equals(accion)) {
            String renglones = "";

            List<Estatus> estatus = EstatusDao.select_estatus_llamada_puesto(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );

            for (Estatus e : estatus) {
                renglones += "<option value='" + e.getId_estatus() + "'>" + e.getDescripcion() + "</option>";
            }
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================

        //======================================================================
        // FIN DE LAS ACCIONES DEL CONTROLLER - ARCADE SOFTWARE GROUP
        //======================================================================
    }

}
