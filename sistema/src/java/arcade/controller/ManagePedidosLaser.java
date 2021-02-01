//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.PedidoLaserDao;
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

public class ManagePedidosLaser extends HttpServlet {
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
        if ("select_pedidos_laser_tabla".equals(accion)) {
            String renglones = PedidoLaserDao.select_pedidos_laser_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_pedidos_laser_combo".equals(accion)) {
            String renglones = PedidoLaserDao.select_pedidos_laser_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_pedidos_laser_usuario_combo".equals(accion)) {
            String renglones = PedidoLaserDao.select_pedidos_laser_usuario_combo(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        //        else if ("insert_pedido_laser".equals(accion)) {
        //            String renglones = PedidoLaserDao.insert_pedido_laser(request.getParameter("pedido_laser"));
        //            response.setContentType("text/html; charset=UTF-8");
        //            PrintWriter writer = response.getWriter();
        //            writer.print(renglones);
        //            writer.flush();
        //            writer.close();
        //        }//=====================================================================
        else if ("update_pedido_laser".equals(accion)) {
            String renglones = PedidoLaserDao.insert_pedido_laser(
                    request.getParameter("pedido_laser")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_pedido_laser".equals(accion)) {
            String renglones = PedidoLaserDao.delete_pedido_laser(
                    Integer.parseInt(request.getParameter("id_pedido_laser"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_pedido_laser".equals(accion)) {
            String renglones = PedidoLaserDao.insert_pedido_laser(
                    Integer.parseInt(request.getParameter("id_cotizacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_detalles_pedido_laser".equals(accion)) {
            String renglones = PedidoLaserDao.select_detalles_pedido_laser(
                    Integer.parseInt(request.getParameter("id_pedido"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
