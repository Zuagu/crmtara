//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.OrdenDeCompraDao;
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

public class ManageOrdenesDeCompra extends HttpServlet {
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
        if ("select_ordenes_tabla".equals(accion)) {
            String renglones = OrdenDeCompraDao.select_ordenes_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("agregar_producto_orden".equals(accion)) {
            String renglones = OrdenDeCompraDao.agregar_producto_orden(
                    Float.parseFloat(request.getParameter("cantidad")),
                    request.getParameter("id_producto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_orden".equals(accion)) {
            String renglones = OrdenDeCompraDao.insert_orden(
                    Integer.parseInt(request.getParameter("usuario_sistema")),
                    Integer.parseInt(request.getParameter("id_proveedor")),
                    Integer.parseInt(request.getParameter("id_requisicion")),
                    Integer.parseInt(request.getParameter("id_empresa")),
                    Float.parseFloat(request.getParameter("subtotal")),
                    Float.parseFloat(request.getParameter("iva")),
                    Float.parseFloat(request.getParameter("total")),
                    Integer.parseInt(request.getParameter("id_formapago")),
                    Integer.parseInt(request.getParameter("numero_parcialidades")),
                    request.getParameter("id_metodopago"),
                    Integer.parseInt(request.getParameter("cuenta_pago")),
                    Integer.parseInt(request.getParameter("id_condicionespago")),
                    Integer.parseInt(request.getParameter("dias_credito")),
                    Integer.parseInt(request.getParameter("lugar_entrega")),
                    request.getParameter("comentarios"),
                    request.getParameter("lineas_orden")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_proveedor_orden".equals(accion)) {
            String renglones = OrdenDeCompraDao.select_datos_proveedor_orden(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuerpo_orden".equals(accion)) {
            String renglones = OrdenDeCompraDao.select_cuerpo_orden(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuerpo_orden_requisicion".equals(accion)) {
            String renglones = OrdenDeCompraDao.select_cuerpo_orden_requisicion(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_importes_orden".equals(accion)) {
            String renglones = OrdenDeCompraDao.select_importes_orden(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_orden_compra".equals(accion)) {
            String renglones = OrdenDeCompraDao.update_orden_compra(
                    Integer.parseInt(request.getParameter("folio")),
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("f_autorizado"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_factura_orden".equals(accion)) {
            String renglones = OrdenDeCompraDao.update_factura_orden(
                    Integer.parseInt(request.getParameter("id_oc")),
                    request.getParameter("factura")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_fecha_factura_orden".equals(accion)) {
            String renglones = OrdenDeCompraDao.update_fecha_factura_orden(
                    Integer.parseInt(request.getParameter("id_oc")),
                    request.getParameter("fecha_factura")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ordenes_sin_pagar_proveedor".equals(accion)) {
            String renglones = OrdenDeCompraDao.select_ordenes_sin_pagar_proveedor(
                    Integer.parseInt(request.getParameter("id_proveedor"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_deuda_general".equals(accion)) {
            String renglones = OrdenDeCompraDao.select_deuda_general(
                    Integer.parseInt(request.getParameter("id_empresa"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
