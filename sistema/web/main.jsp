<%@page import="callcenter.model.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_perfil = -1;
    String id_usuario = "-1";
    String password = "-1";
    String puesto = " ", menu = " ";
    if (request.getParameter("id_usuario") == null || request.getParameter("id_usuario").isEmpty()
            || request.getParameter("password") == null || request.getParameter("password").isEmpty()) {
        response.sendRedirect("index.jsp");
    } else {
        id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
        id_usuario = request.getParameter("id_usuario");
        password = request.getParameter("password");
        // llamadas a metodos
        menu = ModelUsuario.cargar_menu(id_usuario);
        String id_puesto = ModelUsuario.id_puesto(id_usuario);
        String id_puesto2 = ModelUsuario.id_puesto2(id_usuario);
        String id_puesto3 = ModelUsuario.id_puesto3(id_usuario);
        puesto = ModelUsuario.jsp_puesto(id_usuario);
        String real_id = ModelUsuario.real_id(id_usuario);
        
        
        // se inicia una sesion para el usuario;
        HttpSession sesion = request.getSession();
        // sele empiezan a agregar atributos al la variable de sesion
        sesion.setAttribute("id_puesto", id_puesto);
        sesion.setAttribute("id_puesto2", id_puesto2);
        sesion.setAttribute("id_puesto3", id_puesto3);
        sesion.setAttribute("id_usuario", real_id);
        sesion.setAttribute("menu", menu);
        sesion.setAttribute("puesto", puesto);
        
        // System.out.println(id_puesto + " \n" + id_usuario + " \n" + menu + " \n" + puesto + " \n" );

    }
%>
<script>
    location.replace("<%=puesto%>" + ".jsp");
</script>
