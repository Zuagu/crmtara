//==============================================================================
package arcade.controller;
//==============================================================================

//==============================================================================
import arcade.data.PagoProveedorDao;
import arcade.model.PagoProveedor;
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

public class ManagePagosProveedor extends HttpServlet {
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
        if ("select_pagos_proveedor_tabla".equals(accion)) {
            String renglones = PagoProveedorDao.select_pagos_proveedor_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_pago_oc".equals(accion)) {
            PagoProveedor pago = new PagoProveedor();

            pago.setId_registrante(Integer.parseInt(request.getParameter("id_usuario")));
            pago.setId_proveedor(Integer.parseInt(request.getParameter("id_proveedor")));
            pago.setId_oc(Integer.parseInt(request.getParameter("orden")));
            pago.setImporte(Float.parseFloat(request.getParameter("importe")));
            pago.setId_metodopago(request.getParameter("id_metodopago"));
            pago.setId_cuenta(Integer.parseInt(request.getParameter("id_cuenta")));
            pago.setId_banco_destino(Integer.parseInt(request.getParameter("id_banco_destino")));
            pago.setId_cuenta_destino(Integer.parseInt(request.getParameter("id_cuenta_destino")));
            pago.setComentarios(request.getParameter("comentarios"));

            String renglones = PagoProveedorDao.insert_pago_oc(pago);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_pago_oc".equals(accion)) {
            String renglones = PagoProveedorDao.delete_pago_oc(Integer.parseInt(request.getParameter("folio")), Integer.parseInt(request.getParameter("id_usuario")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
