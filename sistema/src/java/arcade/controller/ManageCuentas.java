package arcade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arcade.data.CuentaDao;
import arcade.model.Pastel;

/* @author ARCADE Software Group */
public class ManageCuentas extends HttpServlet {

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
        if (accion.isEmpty()) {
        } //====================================================================
        else if ("select_datos_cuenta".equals(accion)) {
            String renglones = CuentaDao.select_datos_cuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_cuenta_chbk".equals(accion)) {
            String renglones = CuentaDao.select_datos_cuenta_chbk(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuenta_siguiente".equals(accion)) {
            String renglones = CuentaDao.select_cuenta_siguiente(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuenta_siguiente_chbk".equals(accion)) {
            String renglones = CuentaDao.select_cuenta_siguiente_chbk(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("ciclo")),
                    request.getParameter("estatus_original"),
                    request.getParameter("estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_referencias_bancarias".equals(accion)) {
            String renglones = CuentaDao.select_referencias_bancarias(
                    Integer.parseInt(request.getParameter("cuenta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_buscar_cuentas".equals(accion)) {
            String renglones = CuentaDao.select_buscar_cuentas(
                    request.getParameter("cadena")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_buscar_cuentas_chbk".equals(accion)) {
            String renglones = CuentaDao.select_buscar_cuentas_chbk(
                    request.getParameter("cadena")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("listado_por_estatus_gestor".equals(accion)) {
            String renglones = CuentaDao.listado_por_estatus_gestor(
                    Integer.parseInt(request.getParameter("id_gestor")),
                    Integer.parseInt(request.getParameter("id_estatus"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_speech_cuenta".equals(accion)) {
            String renglones
                    = CuentaDao.select_speech_cuenta(
                            Integer.parseInt(request.getParameter("cuenta"))
                    );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_control_tiempos".equals(accion)) {
            String renglones
                    = CuentaDao.select_control_tiempos(
                            Integer.parseInt(request.getParameter("id_gestor"))
                    );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_referencia_cuenta".equals(accion)) {
            String renglones
                    = CuentaDao.select_referencia_cuenta(
                            Integer.parseInt(request.getParameter("cuenta"))
                    );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_referencia_cuenta".equals(accion)) {
            String renglones = CuentaDao.update_referencia_cuenta(
                    Integer.parseInt(request.getParameter("cuenta")),
                    request.getParameter("referencia")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_pastel_gestor".equals(accion)) {
            String renglones = PASTEL_HTML(
                    CuentaDao.select_pastel_gestor(
                            Integer.parseInt(request.getParameter("id_usuario"))
                    )
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_f_seguimiento_cuenta".equals(accion)) {
            String renglones = CuentaDao.update_f_seguimiento_cuenta(
                    request.getParameter("cuenta"),
                    Integer.parseInt(request.getParameter("f_seguimiento"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("f_seguimiento".equals(accion)) {
            String renglones = CuentaDao.f_seguimiento(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_etiquetas_cliente".equals(accion)) {
            String renglones = CuentaDao.select_etiquetas_cliente(
                    Integer.parseInt(request.getParameter("id_puesto")),
                    request.getParameter("etiquetas")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_etiquetas_puesto_usuario".equals(accion)) {
            String renglones = CuentaDao.select_etiquetas_puesto_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_etiquetas_cliente".equals(accion)) {
            String renglones = CuentaDao.insert_etiquetas_cliente(
                    Integer.parseInt(request.getParameter("id_puesto")),
                    request.getParameter("etiquetas")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("clonar_etiquetas".equals(accion)) {
            String renglones = CuentaDao.clonar_etiquetas(
                    Integer.parseInt(request.getParameter("id_puesto")),
                    Integer.parseInt(request.getParameter("id_puesto2"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_nuevo_numero_contacto".equals(accion)) {
            String renglones = CuentaDao.insert_nuevo_numero_contacto(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("cuenta"),
                    request.getParameter("numero")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
		else if ("select_numero_visitas".equals(accion)) {
            String renglones = CuentaDao.select_numero_visitas(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
		else if ("update_numero_visitas".equals(accion)) {
            String renglones = CuentaDao.update_numero_visitas(
                Integer.parseInt(request.getParameter("cuenta")),
                Integer.parseInt(request.getParameter("codigo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_saldos_gestores".equals(accion)) {
            String renglones = CuentaDao.select_saldos_gestores(
                            Integer.parseInt(request.getParameter("usuario"))
                    );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuentas_de_estaus".equals(accion)) {
            String renglones = CuentaDao.select_cuentas_de_estaus(
                            Integer.parseInt(request.getParameter("id_usuario")),
                            Integer.parseInt(request.getParameter("id_estatus"))
                    );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }

    //==========================================================================
    private String PASTEL_HTML(List<Pastel> quequitos) {
        String renglones;
        renglones
                = "<table style='width: 100%'>"
                + "<thead>"
                + "<tr>"
                + "<th>ESTATUS</th>"
                + "<th>PAGADAS</th>"
                + "<th>POR COBRAR</th>"
                + "<th>TOTAL</th>"
                + "<th>VALOR PAGADO</th>"
                + "<th>VALOR POR COBRAR</th>"
                + "<th>VALOR ESTATUS</th>"
                + "<th>ULTIMA GESTION</th>"
                + "</tr>"
                + "</thead>";

        for (Pastel p : quequitos) {
            renglones += ""
                    + "<tr>"
                    + "<td>" + p.getEstatus() + "</td>"
                    + "<td>" + p.getPagadas() + "</td>"
                    + "<td>" + p.getPor_cobrar() + "</td>"
                    + "<td>" + p.getCuentas() + "</td>"
                    + "<td>" + p.getPagado_estatus() + "</td>"
                    + "<td>" + p.getPor_cobrar_estatus() + "</td>"
                    + "<td>" + p.getValor_estatus() + "</td>"
                    + "<td>" + p.getUltima_gestion() + "</td>"
                    + "</tr>";
        }
        renglones += "</table>";

        return renglones;
    }
    //==========================================================================
    // FIN DE LAS ACCIONES DEL CONTROLLER - ARCADE SOFTWARE GROUP
    //==========================================================================
}
