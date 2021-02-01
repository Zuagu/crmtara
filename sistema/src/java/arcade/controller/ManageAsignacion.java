//==============================================================================
package arcade.controller;
//==============================================================================
 
import arcade.data.AsignacionDao;
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
 
public class ManageAsignacion extends HttpServlet {
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
        if ("select_asignacion_tabla".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_tabla(
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_check".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_tabla(
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_referencias".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_referencias();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuentas_referencias".equals(accion)) {
            String renglones = AsignacionDao.select_cuentas_referencias(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("updt_col99".equals(accion)) {
            String renglones = AsignacionDao.updt_col99(
                    Integer.parseInt(request.getParameter("id_cuenta")),
                    request.getParameter("ref1"),
                    request.getParameter("telr1"),
                    request.getParameter("ref2"),
                    request.getParameter("telr2")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_region_tabla".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_region_tabla(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_region_check".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_region_check(
                    request.getParameter("cadena_regiones")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_combo".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_combo(
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_chbk_combo".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_chbk_combo(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ciclos_chbk_usuario".equals(accion)) {
            String renglones = AsignacionDao.select_ciclos_chbk_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_chbk_usuario".equals(accion)) {
            String renglones = AsignacionDao.select_estatus_chbk_usuario(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("ciclo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_gestion_chbk_usuario".equals(accion)) {
            String renglones = AsignacionDao.select_estatus_gestion_chbk_usuario(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("ciclo")),
                    request.getParameter("estatus_original")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("contar_cuentas_chbk_usuario".equals(accion)) {
            int resultado = AsignacionDao.contar_cuentas_chbk_usuario(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("ciclo")),
                    request.getParameter("estatus_original"),
                    request.getParameter("estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(resultado);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_cliente_combo".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_cliente_combo(
                    Integer.parseInt(request.getParameter("id_cliente")),
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_asignacion_region_combo".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_region_combo(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_asignacion".equals(accion)) {
            String renglones = AsignacionDao.insert_asignacion(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("asignacion"),
                    Integer.parseInt(request.getParameter("id_sucursal")),
                    Integer.parseInt(request.getParameter("id_cliente")),
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("fecha_inicio"),
                    request.getParameter("fecha_fin"),
                    Integer.parseInt(request.getParameter("dias_anticipados")),
                    Float.parseFloat(request.getParameter("meta"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_asignacion".equals(accion)) {
           String renglones = AsignacionDao.update_asignacion(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_asignacion".equals(accion)) {
            String renglones = AsignacionDao.delete_asignacion(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("match_datos_asignacion".equals(accion)) {
            String renglones = AsignacionDao.match_datos_asignacion(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_colas".equals(accion)) {
            String renglones = AsignacionDao.select_colas();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("reasignar".equals(accion)) {
            String renglones = AsignacionDao.reasignar(
                    Integer.parseInt(request.getParameter("id_asignacion"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_basechbk".equals(accion)) {
            String renglones = AsignacionDao.insert_basechbk();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_ladas".equals(accion)) {
            String renglones = AsignacionDao.select_ladas_check(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("tiene_cr"),
                    request.getParameter("cadena_estatus")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_estatus_cuenta_check".equals(accion)) {
            String renglones = AsignacionDao.select_estatus_cuenta_check(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("tiene_cr"),
                    request.getParameter("cadena_ladas")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_cuentas_sms_blaster".equals(accion)) {
            String renglones = AsignacionDao.select_cuentas_sms_blaster(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("tiene_cr"),
                    request.getParameter("cadena_ladas"),
                    request.getParameter("cadena_estatus"),
                    Integer.parseInt(request.getParameter("importe")),
                    request.getParameter("orden")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
             else if ("select_asignacion_region_combo_materialize".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_region_combo_materialize(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
         else if ("select_asignacion_region_check_materialize".equals(accion)) {
            String renglones = AsignacionDao.select_asignacion_region_check_materialize(
                    request.getParameter("cadena_regiones")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
		else if ("select_ciudades_asignaciones_check".equals(accion)) {
            String renglones = AsignacionDao.select_ciudades_asignaciones_check(
                    request.getParameter("cadena_asignaciones"),
                    Integer.parseInt(request.getParameter("region"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_colonias_ciudades_check".equals(accion)) {
            String renglones = AsignacionDao.select_colonias_ciudades_check(
                    request.getParameter("id_asignacion"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_codigos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
          else if ("select_codigo_postal_colonias_check".equals(accion)) {
            String renglones = AsignacionDao.select_codigo_postal_colonias_check(
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_status_codigo_postal_check".equals(accion)) {
            String renglones = AsignacionDao.select_status_codigo_postal_check(
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
                else if ("select_datos_visitas".equals(accion)) {
            String renglones = AsignacionDao.select_datos_visitas(
                    Integer.parseInt(request.getParameter("id_region")),
                    request.getParameter("cadena_asignaciones"),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos"),
                    request.getParameter("cadena_ladas"),
                    Integer.parseInt(request.getParameter("resto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_carteo_tabla".equals(accion)) {
            String renglones = AsignacionDao.select_datos_carteo_tabla(
                    Integer.parseInt(request.getParameter("id_region")),
                    Integer.parseInt(request.getParameter("id_asignaciones")),
                    request.getParameter("cadena_ciudades"),
                    request.getParameter("cadena_colonias"),
                    request.getParameter("cadena_codigos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        
    }
}