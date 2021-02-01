//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.ProductoDao;
import arcade.model.Producto;
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

public class ManageProductos extends HttpServlet {
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
        if ("select_productos_categoria_tabla".equals(accion)) {
            String renglones = ProductoDao.select_productos_categoria_tabla(Integer.parseInt(request.getParameter("id_categoria")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_productos_categoria_tabla_corte".equals(accion)) {
            String renglones = ProductoDao.select_productos_categoria_tabla_corte(Integer.parseInt(request.getParameter("id_categoria")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_productos_categoria_combo".equals(accion)) {
            String renglones = ProductoDao.select_productos_categoria_combo(Integer.parseInt(request.getParameter("id_categoria")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_producto".equals(accion)) {
            Producto p = new Producto();

            p.setId_producto(request.getParameter("id_producto"));
            p.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
            p.setNombre(request.getParameter("nombre"));
            p.setDescripcion(request.getParameter("descripcion"));
            p.setId_unidadmedida(Integer.parseInt(request.getParameter("id_unidadmedida")));
            p.setCantidad_minima(Integer.parseInt(request.getParameter("cantidad_minima")));
            p.setId_moneda(Integer.parseInt(request.getParameter("id_moneda")));
            p.setId_tasa(Integer.parseInt(request.getParameter("id_tasa")));
            p.setPrecio_sin_iva(Float.parseFloat(request.getParameter("precio_sin_iva")));
            p.setIva(Float.parseFloat(request.getParameter("iva")));
            p.setPrecio(Float.parseFloat(request.getParameter("precio")));
            p.setF_comprable(Integer.parseInt(request.getParameter("f_comprable")));

            String renglones = ProductoDao.insert_producto(p);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_producto".equals(accion)) {
            String renglones = ProductoDao.delete_producto(request.getParameter("id_producto"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_calibre".equals(accion)) {
            String renglones = ProductoDao.update_calibre(
                    request.getParameter("id_producto"),
                    request.getParameter("calibre")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_perimetro".equals(accion)) {
            String renglones = ProductoDao.update_perimetro(
                    request.getParameter("id_producto"),
                    Float.parseFloat(request.getParameter("perimetro"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_area".equals(accion)) {
            String renglones = ProductoDao.update_area(
                    request.getParameter("id_producto"),
                    Float.parseFloat(request.getParameter("area"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_tiempo".equals(accion)) {
            String renglones = ProductoDao.update_tiempo(
                    request.getParameter("id_producto"),
                    Float.parseFloat(request.getParameter("tiempo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_inicios".equals(accion)) {
            String renglones = ProductoDao.update_inicios(
                    request.getParameter("id_producto"),
                    Integer.parseInt(request.getParameter("inicios"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
