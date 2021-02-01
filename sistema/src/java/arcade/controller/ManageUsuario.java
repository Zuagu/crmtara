package arcade.controller;

import arcade.data.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//==============================================================================
/* @author ARCADE Software Group� */
//==============================================================================

public class ManageUsuario extends HttpServlet {

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
        if ("iniciar_sesion".equals(accion)) {
            int resultado = UsuarioDao.iniciar_sesion(
                    Integer.parseInt(request.getParameter("id_perfil")),
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("password")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(resultado);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("nombre_usuario".equals(accion)) {
            String renglon = UsuarioDao.nombre_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("cambiar_password".equals(accion)) {
            String renglones = UsuarioDao.cambiar_password(
                    Integer.parseInt(request.getParameter("id_perfil")),
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("password0")
            );
            response.setContentType("text/html; charset=UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("select_usuario_tabla".equals(accion)) {
            String renglones = UsuarioDao.select_usuario_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//====================================================================
        else if ("select_usuario_tabla_nomina".equals(accion)) {
            String renglones = UsuarioDao.select_usuario_tabla_nomina();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_usuario_filtro".equals(accion)) {
            String renglones = UsuarioDao.select_usuario_filtro(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_usuario_combo".equals(accion)) {
            String renglones = UsuarioDao.select_usuario_combo(
                    Integer.parseInt(request.getParameter("f_active"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("insert_usuario".equals(accion)) {
            String renglones = UsuarioDao.insert_usuario(
                    request.getParameter("nombre"),
                    request.getParameter("alias"),
                    Integer.parseInt(request.getParameter("id_sucursal")),
                    Integer.parseInt(request.getParameter("id_puesto")),
                    Integer.parseInt(request.getParameter("id_jefe_inmediato")),
                    request.getParameter("sexo"),
                    request.getParameter("telefono"),
                    request.getParameter("celular"),
                    request.getParameter("email")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_usuario".equals(accion)) {
            String renglones = UsuarioDao.update_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("delete_usuario".equals(accion)) {
            String renglones = UsuarioDao.delete_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_datos_usuario".equals(accion)) {
            String renglones = UsuarioDao.select_datos_usuario(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_usuario_rrhh".equals(accion)) {
            String renglones = UsuarioDao.update_usuario_rrhh(
                    Integer.parseInt(request.getParameter("id_seleccion")),
                    request.getParameter("d1"),
                    request.getParameter("d2"),
                    request.getParameter("d3"),
                    request.getParameter("d4"),
                    request.getParameter("d5"),
                    request.getParameter("d6"),
                    request.getParameter("d7"),
                    request.getParameter("d8"),
                    request.getParameter("d9"),
                    request.getParameter("d10"),
                    request.getParameter("d11")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_entrada_tabla".equals(accion)) {
            String renglones = UsuarioDao.select_entrada_tabla(
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("select_resumen_usuario".equals(accion)) {
            String renglones = UsuarioDao.select_resumen_usuario();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } //====================================================================
        else if ("select_inactivos_tabla_filtro".equals(accion)) {
            String renglones = UsuarioDao.select_inactivos_tabla_filtro(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_activos_tabla_filtro".equals(accion)) {
            String renglones = UsuarioDao.select_activos_tabla_filtro(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_cargo".equals(accion)) {
            String renglones = UsuarioDao.update_cargo(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("cargo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_calendario_entradas".equals(accion)) {
            String renglones = UsuarioDao.select_calendario_entradas(
                    Integer.parseInt(request.getParameter("id_usuario")),
                    request.getParameter("fecha")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_dato_contrato".equals(accion)) {
            String renglones = UsuarioDao.select_datos_contrato(
                    Integer.parseInt(request.getParameter("id"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_chunnun".equals(accion)) {
            String renglones = UsuarioDao.update_chunnun(
                    Integer.parseInt(request.getParameter("idusu")),
                    Boolean.parseBoolean(request.getParameter("acta")),
                    Boolean.parseBoolean(request.getParameter("ife")),
                    Boolean.parseBoolean(request.getParameter("nss")),
                    Boolean.parseBoolean(request.getParameter("curp1")),
                    Boolean.parseBoolean(request.getParameter("comp_est")),
                    Boolean.parseBoolean(request.getParameter("comp_dom")),
                    Boolean.parseBoolean(request.getParameter("cartas")),
                    Boolean.parseBoolean(request.getParameter("fotos")),
                    Boolean.parseBoolean(request.getParameter("infonavit1")),
                    Boolean.parseBoolean(request.getParameter("rfcc"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("datos_usuarios".equals(accion)) {
            String renglones = UsuarioDao.datos_usuarios();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("update_formato".equals(accion)) {
            String renglones = UsuarioDao.update_formato(
                    Integer.parseInt(request.getParameter("id_user")),
                    request.getParameter("col"),
                    request.getParameter("datos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_tabla_hoario".equals(accion)) {
            String renglones = UsuarioDao.select_tabla_hoario(
                    Integer.parseInt(request.getParameter("id_user"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("select_lista_horarios".equals(accion)) {
            String renglones = UsuarioDao.select_lista_horarios();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================
        else if ("arcade_select_puesto".equals(accion)) {
            String renglones = UsuarioDao.arcade_select_puesto();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }//=====================================================================

    }


}
 
/* FIN DEL SERVLET*/
