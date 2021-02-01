//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.PagocuentaDao;
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

public class ManagePagocuenta extends HttpServlet {
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
        if ("select_pagos_asignacion_tabla".equals(accion)) {
            String renglones = PagocuentaDao.select_pagos_asignacion_tabla(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_pagos_asignacion_tabla_fecha".equals(accion)) {
            String renglones = PagocuentaDao.select_pagos_asignacion_tabla_fecha(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_pagocuenta".equals(accion)) {
            String renglones = PagocuentaDao.insert_pagocuenta(
                    request.getParameter("pagocuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_pagocuenta".equals(accion)) {
            String renglones = PagocuentaDao.insert_pagocuenta(request.getParameter("pagocuenta"));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_pagocuenta".equals(accion)) {
            String renglones = PagocuentaDao.delete_pagocuenta(Integer.parseInt(request.getParameter("id_pagocuenta")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_pagos_cuenta_tabla".equals(accion)) {
            String renglones = PagocuentaDao.select_pagos_cuenta_tabla(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
    }
}
