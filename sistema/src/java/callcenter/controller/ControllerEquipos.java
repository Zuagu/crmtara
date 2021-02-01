package callcenter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import callcenter.model.ModelEquipos;
import java.io.PrintWriter;

public class ControllerEquipos extends HttpServlet {
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
        String action = request.getParameter("action");
//        PrintWriter writer;
//////////////////////////////////////////////////////////////

        if (action.equals("select_equipo_tabla")) {
            String Respuesta = ModelEquipos.select_equipo_tabla();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if ("agregar_gestor_equipo".equals(action)) {
            String renglones = ModelEquipos.agregar_gestor_equipo(
                    Integer.parseInt(request.getParameter("id_equipo")),
                    Integer.parseInt(request.getParameter("id_gestor"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("select_usuarios_equipo".equals(action)) {
            String renglones = ModelEquipos.select_usuarios_equipo(
                    Integer.parseInt(request.getParameter("id_equipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("delete_usuario_equipo".equals(action)) {
            String renglones = ModelEquipos.delete_usuario_equipo(
                    Integer.parseInt(request.getParameter("id_equipo")),
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("select_regiones".equals(action)) {
            String renglones = ModelEquipos.select_regiones();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("select_asignaciones_region".equals(action)) {
            String renglones = ModelEquipos.select_asignaciones_region(
                    Integer.parseInt(request.getParameter("id_region")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("select_ciclos_asignacion".equals(action)) {
            String renglones = ModelEquipos.select_ciclos_asignacion(
                    Integer.parseInt(request.getParameter("id_asignacion")));
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("select_estados_ciclos".equals(action)) {
            String renglones = ModelEquipos.select_estados_ciclos(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciclos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("select_status_estados".equals(action)) {
            String renglones = ModelEquipos.select_status_estados(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciclos"),
                    request.getParameter("cadena_estados")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("ver_cuentas_nuevo_equipo_especial".equals(action)) {
            String renglones = ModelEquipos.ver_cuentas_nuevo_equipo_especial(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciclos"),
                    request.getParameter("cadena_estados"),
                    request.getParameter("cadena_estatus"),
                    request.getParameter("tiene_cr"),
                    request.getParameter("monto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("crear_equipo_especial".equals(action)) {
            String renglones = ModelEquipos.crear_equipo_especial(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciclos"),
                    request.getParameter("cadena_estados"),
                    request.getParameter("cadena_estatus"),
                    request.getParameter("tiene_cr"),
                    request.getParameter("monto")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("guardar_registro_equipo".equals(action)) {
            String renglones = ModelEquipos.guardar_registro_equipo(
                    Integer.parseInt(request.getParameter("id_asignacion")),
                    request.getParameter("cadena_ciclos"),
                    request.getParameter("cadena_estados"),
                    request.getParameter("cadena_estatus"),
                    request.getParameter("tiene_cr"),
                    request.getParameter("monto"),
                    request.getParameter("id_equipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("guardar_registro_equipo_usuario".equals(action)) {
            String renglones = ModelEquipos.guardar_registro_equipo_usuario(
                    Integer.parseInt(request.getParameter("id_equipo")),
                    Integer.parseInt(request.getParameter("id_gestor"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        } else if ("select_cuentas_equipo".equals(action)) {
            String renglones = ModelEquipos.select_cuentas_equipo(
                    Integer.parseInt(request.getParameter("id_equipo"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }
    }
}
