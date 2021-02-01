package callcenter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import callcenter.model.ModelUsuario;
import javax.servlet.http.HttpSession;

public class ControllerUsuario extends HttpServlet {
//==========================================================================

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
        ////////////////////////////////////////////////////////////////////////
        if (action.equals("iniciar_sesion")) {
            int Respuesta = ModelUsuario.iniciar_sesion(
                    Integer.parseInt(request.getParameter("id_perfil")),
                    request.getParameter("id_usuario"),
                    request.getParameter("password"),
                    request.getParameter("ip")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } ////////////////////////////////////////////////////////////////////////
        else if ("cerrar_sesion".equals(action)) {
            HttpSession sesion = request.getSession();
            sesion.invalidate();
            
            ModelUsuario.cerrar_sesion(
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            System.out.println("Controlador usuario" + request.getParameter("id_usuario"));
        } //====================================================================
        else if (action.equals("select_id_puesto")) {
            String Respuesta = ModelUsuario.id_puesto(
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }//====================================================================
        else if (action.equals("select_usuarios")) {
            String Respuesta = ModelUsuario.select_usuarios(
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }//====================================================================
        else if (action.equals("select_usuarios_cargo")) {
            String Respuesta = ModelUsuario.select_usuarios_cargo(
                    Integer.parseInt(request.getParameter("puesto")),
                    Integer.parseInt(request.getParameter("puesto2")),
                    Integer.parseInt(request.getParameter("puesto3"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_usuarios_cargo_filtro")) {
            String Respuesta = ModelUsuario.select_usuarios_cargo_filtro(
                    Integer.parseInt(request.getParameter("puesto")),
                    Integer.parseInt(request.getParameter("puesto2")),
                    Integer.parseInt(request.getParameter("puesto3")),
                    request.getParameter("filtro")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("add_user")) {
            String Respuesta = ModelUsuario.add_user(
                    request.getParameter("nombre_m"),
                    request.getParameter("alias_m"),
                    request.getParameter("telefono_m"),
                    request.getParameter("celular_m"),
                    request.getParameter("email_m"),
                    request.getParameter("sexo_m"),
                    request.getParameter("puesto_m"),
                    request.getParameter("jefe_m")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_puestos_disponobles")) {
            String Respuesta = ModelUsuario.select_puestos_disponobles();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }

    }
}
