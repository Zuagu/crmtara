package callcenter.controller;

import callcenter.model.ModelOrganigrama;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mac
 */
public class ControllerOrganigrama extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("select_organigrama")) {
            String Respuesta = ModelOrganigrama.select_organigrama();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_lista_usuarios_vacantes")) {
            String Respuesta = ModelOrganigrama.select_lista_usuarios_vacantes(
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("sic_vacantes_organigrama")) {
            String Respuesta = ModelOrganigrama.sic_vacantes_organigrama();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("update_numero_vacantes")) {
            String Respuesta = ModelOrganigrama.update_numero_vancantes(
                    Integer.parseInt(request.getParameter("id_puesto")),
                    Integer.parseInt(request.getParameter("vacantes"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_lista_gestores")) {
            String Respuesta = ModelOrganigrama.select_lista_gestores();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("asignar_puesto_vacante")) {
            String Respuesta = ModelOrganigrama.asignar_puesto_vacante(
                    Integer.parseInt(request.getParameter("id_user")),
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_lista_gestores_filtro")) {
            String Respuesta = ModelOrganigrama.select_lista_gestores_filtro(
            request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("eliminar_usuario_vacante")) {
            String Respuesta = ModelOrganigrama.eliminar_usuario_vacante(
            Integer.parseInt(request.getParameter("id_usuario")),
            Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }

    }

}
