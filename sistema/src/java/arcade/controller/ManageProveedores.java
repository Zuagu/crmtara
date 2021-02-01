//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.model.Proveedor;
import arcade.data.ProveedorDao;
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

public class ManageProveedores extends HttpServlet {
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
        if ("select_proveedores_tabla".equals(accion)) {
            String renglones = ProveedorDao.select_proveedores_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_proveedores_filtro".equals(accion)) {
            String renglones = ProveedorDao.select_proveedores_filtro(request.getParameter("filtro"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_proveedores_combo".equals(accion)) {
            String renglones = ProveedorDao.select_proveedores_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_proveedor".equals(accion)) {
            Proveedor p = new Proveedor();

            p.setRazon_social(request.getParameter("razon_social"));
            p.setRfc(request.getParameter("rfc"));
            p.setCodigo_postal(Integer.parseInt(request.getParameter("codigo_postal")));
            p.setColonia(request.getParameter("colonia"));
            p.setCalle(request.getParameter("calle"));
            p.setNum_ext(request.getParameter("num_ext"));
            p.setNum_int(request.getParameter("num_int"));
            p.setId_pais(Integer.parseInt(request.getParameter("id_pais")));
            p.setId_estado(Integer.parseInt(request.getParameter("id_estado")));
            p.setId_municipio(Integer.parseInt(request.getParameter("id_municipio")));
            p.setTelefonos(request.getParameter("telefonos"));
            p.setEmail(request.getParameter("email"));
            p.setComentarios(request.getParameter("comentarios"));

            String renglones = ProveedorDao.insert_proveedor(p);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_proveedor".equals(accion)) {

            Proveedor p = new Proveedor();

            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setRazon_social(request.getParameter("razon_social"));
            p.setRfc(request.getParameter("rfc"));
            p.setColonia(request.getParameter("colonia"));
            p.setCalle(request.getParameter("calle"));
            p.setNum_ext(request.getParameter("num_ext"));
            p.setNum_int(request.getParameter("num_int"));
            p.setTelefonos(request.getParameter("telefonos"));
            p.setEmail(request.getParameter("email"));
            p.setComentarios(request.getParameter("comentarios"));

            String renglones = ProveedorDao.update_proveedor(p);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_proveedor".equals(accion)) {
            String renglones = ProveedorDao.select_datos_proveedor(Integer.parseInt(request.getParameter("id")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_proveedor".equals(accion)) {
            String renglones = ProveedorDao.delete_proveedor(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("id_usuario")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("cuerpo_estado_de_cuenta".equals(accion)) {
            String renglones = ProveedorDao.cuerpo_estado_de_cuenta(Integer.parseInt(request.getParameter("id")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_importes_edc".equals(accion)) {
            String renglones = ProveedorDao.select_importes_edc(Integer.parseInt(request.getParameter("id")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("cuerpo_estado_de_cuenta_deudaactual".equals(accion)) {
            String renglones = ProveedorDao.cuerpo_estado_de_cuenta_deudaactual(Integer.parseInt(request.getParameter("id")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_importes_edc_deudaactual".equals(accion)) {
            String renglones = ProveedorDao.select_importes_edc_deudaactual(Integer.parseInt(request.getParameter("id")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        
    }
}
