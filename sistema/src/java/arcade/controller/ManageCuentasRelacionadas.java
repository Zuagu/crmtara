package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.CuentaRelacionadaDao;
import arcade.model.CuentaRelacionada;

/**
 * @author AYCM
 */
public class ManageCuentasRelacionadas extends HttpServlet {

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
        else if ("insert_cuentarelacionada".equals(accion)) {
            String renglon;
            CuentaRelacionada cuentarelacionada = new CuentaRelacionada();
            renglon = CuentaRelacionadaDao.insert_cuentarelacionada(cuentarelacionada);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_cuentarelacionada".equals(accion)) {
            String renglon;
            CuentaRelacionada cuentarelacionada = new CuentaRelacionada();
            renglon = CuentaRelacionadaDao.update_cuentarelacionada(cuentarelacionada);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_cuentarelacionada".equals(accion)) {
            String renglon;
            CuentaRelacionada cuentarelacionada = new CuentaRelacionada();
            renglon = CuentaRelacionadaDao.delete_cuentarelacionada(cuentarelacionada);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        }//===================================================================== 
        // else if ("select_cuentas_relacionadas".equals(accion)) { TUVIMOS UN ERROR DE DEDO, esa accion no existia
        else if ("select_cuentas_relacionadas".equals(accion)) {
            String renglones = LISTADO_CUENTAS_RELACIONADAS_HTML(
                    CuentaRelacionadaDao.select_cuentas_relacionadas(Integer.parseInt(request.getParameter("cuenta")))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================

    }

    private String LISTADO_CUENTAS_RELACIONADAS_HTML(List<CuentaRelacionada> CuentaRelacionada) {
        String renglones;
        int consecutivo = 0;
        renglones = ""
                + "<table style='width:100%;'>"
                + "<thead>"
                + "<tr>"
                + "<th style='font-size: 12px;'>ID CR</th>"
                + "<th style='font-size: 12px;'>TELÉFONO DE CR</th>"
                + "<th style='font-size: 12px;'>ESTATUS CR</th>"
                + "<th style='font-size: 12px;'>FECHA DE ACTIVACION</th>"
                // + "<th style='font-size: 12px;'>NOMBRE</th>"
                + "<th style='font-size: 12px;'>RFC</th>"
                + "</tr>"
                + "</thead>";
        for (CuentaRelacionada cr : CuentaRelacionada) {
            //consecutivo = consecutivo = 1; =???
            consecutivo = consecutivo + 1;
            renglones
                    += "<tr id='" + cr.getId_cr() + "'>"
                    + "<td>" + cr.getId_cr() + "</td>"
                    + "<td><a class='a_marcar' href='#'>" + cr.getTelefono() + "</a></td>"
                    + "<td>" + cr.getEstatus() + "</td>"
                    + "<td>" + cr.getNombre() + "</td>"
                    + "<td>" + cr.getRfc() + "</td>"
                    + "</tr>";
        }
        //renglones += "</table></div>";
        renglones += "</table>";
        return renglones;
    }
}
