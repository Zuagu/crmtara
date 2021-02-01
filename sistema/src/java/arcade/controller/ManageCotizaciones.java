//==============================================================================
package arcade.controller;
//==============================================================================

//==============================================================================
import arcade.data.CotizacionDao;
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

public class ManageCotizaciones extends HttpServlet {
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
        if ("select_cotizaciones_tabla".equals(accion)) {
            String renglones = CotizacionDao.select_cotizaciones_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("agregar_producto_cotizacion".equals(accion)) {
            String renglones = CotizacionDao.agregar_producto_cotizacion(Integer.parseInt(request.getParameter("cantidad")), request.getParameter("id_producto"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_cotizacion".equals(accion)) {
            String renglones = CotizacionDao.insert_cotizacion(
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
                    request.getParameter("lineas_cotizacion")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_cliente_cotizacion".equals(accion)) {
            String renglones = CotizacionDao.select_datos_cliente_cotizacion(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuerpo_cotizacion".equals(accion)) {
            String renglones = CotizacionDao.select_cuerpo_cotizacion(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_importes_cotizacion".equals(accion)) {
            String renglones = CotizacionDao.select_importes_cotizacion(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
