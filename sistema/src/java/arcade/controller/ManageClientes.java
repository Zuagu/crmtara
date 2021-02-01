//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.model.Cliente;
import arcade.data.ClienteDao;
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

public class ManageClientes extends HttpServlet {
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
        if ("select_clientes_tabla".equals(accion)) {
            String renglones = ClienteDao.select_clientes_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_clientes_check".equals(accion)) {
            String renglones = ClienteDao.select_clientes_check();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_clientes_filtro".equals(accion)) {
            String renglones = ClienteDao.select_clientes_filtro(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_clientes_combo".equals(accion)) {
            String renglones = ClienteDao.select_clientes_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_cliente".equals(accion)) {
            Cliente c = new Cliente();

            c.setRazon_social(request.getParameter("razon_social"));
            c.setRfc(request.getParameter("rfc"));
            c.setCodigo_postal(Integer.parseInt(request.getParameter("codigo_postal")));
            c.setColonia(request.getParameter("colonia"));
            c.setCalle(request.getParameter("calle"));
            c.setNum_ext(request.getParameter("num_ext"));
            c.setNum_int(request.getParameter("num_int"));
            c.setId_pais(Integer.parseInt(request.getParameter("id_pais")));
            c.setId_estado(Integer.parseInt(request.getParameter("id_estado")));
            c.setId_municipio(Integer.parseInt(request.getParameter("id_municipio")));
            c.setTelefonos(request.getParameter("telefonos"));
            c.setEmail(request.getParameter("email"));
            c.setComentarios(request.getParameter("comentarios"));

            String renglones = ClienteDao.insert_cliente(c);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();

        }//=====================================================================
        else if ("update_cliente".equals(accion)) {

            Cliente c = new Cliente();

            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setRazon_social(request.getParameter("razon_social"));
            c.setRfc(request.getParameter("rfc"));
            c.setColonia(request.getParameter("colonia"));
            c.setCalle(request.getParameter("calle"));
            c.setNum_ext(request.getParameter("num_ext"));
            c.setNum_int(request.getParameter("num_int"));
            c.setTelefonos(request.getParameter("telefonos"));
            c.setEmail(request.getParameter("email"));
            c.setComentarios(request.getParameter("comentarios"));

            String renglones = ClienteDao.update_cliente(c);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_cliente".equals(accion)) {
            String renglones = ClienteDao.delete_cliente(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("id_usuario")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_fiscales".equals(accion)) {
            String renglones = ClienteDao.select_datos_fiscales();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_fiscales_oc".equals(accion)) {
            String renglones = ClienteDao.select_datos_fiscales_oc(Integer.parseInt(request.getParameter("folio")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_datos_fiscales".equals(accion)) {

            Cliente c = new Cliente();

            c.setNombre_comercial(request.getParameter("nombre_comercial"));
            c.setRazon_social(request.getParameter("razon_social"));
            c.setRfc(request.getParameter("rfc"));
            c.setColonia(request.getParameter("rfc"));
            c.setCalle(request.getParameter("calle_y_num"));
            c.setCodigo_postal(Integer.parseInt(request.getParameter("codigo_postal")));
            c.setMunicipio(request.getParameter("municipio"));
            c.setEstado(request.getParameter("estado"));
            c.setTelefonos(request.getParameter("telefonos"));
            c.setPagina_web(request.getParameter("pagina_web"));

            String renglones = ClienteDao.update_datos_fiscales(c);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("select_clientes_combo_materialize".equals(accion)) {
            String renglones = ClienteDao.select_clientes_combo_materialize();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
