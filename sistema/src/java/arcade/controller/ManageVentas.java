//==============================================================================
package arcade.controller;
//==============================================================================

//==============================================================================
import arcade.data.VentaDao;
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

public class ManageVentas extends HttpServlet {
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
        if ("select_ventas_tabla".equals(accion)) {
            String renglones = VentaDao.select_ventas_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("agregar_producto_venta".equals(accion)) {
            String renglones = VentaDao.agregar_producto_venta(Integer.parseInt(request.getParameter("cantidad")), request.getParameter("id_producto"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_venta".equals(accion)) {
            String renglones = VentaDao.insert_venta(
                    Integer.parseInt(request.getParameter("usuario_sistema")),
                    Integer.parseInt(request.getParameter("id_cliente")),
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
                    request.getParameter("lineas_venta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_cliente_venta".equals(accion)) {
            String renglones = VentaDao.select_datos_cliente_venta(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuerpo_venta".equals(accion)) {
            String renglones = VentaDao.select_cuerpo_venta(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_importes_venta".equals(accion)) {
            String renglones = VentaDao.select_importes_venta(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
