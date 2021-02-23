<%-- 
    Document   : index-mod-1
    Created on : 28/01/2021, 07:54:47 AM
    Author     : zuagu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Sistema Gestor</title>

        <link rel="stylesheet" type="text/css" href="css/css/login_tara.css">
    </head>
    <body>

        <div class="login-box">
            <h2>Login</h2>
            <form id="login" class="back" style="" name="login" action="/sistema/main.jsp" method="post">
                <div class="user-box">
                    <input id="id_usuario" type="text" name="id_usuario" required="">
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input id="password" type="password" name="password" required="">
                    <label>Password</label>
                </div>
                <button id="enviar_data">
                    <a>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        Submit
                    </a>
                </button>
            </form>
        </div>
    </body>
</html>
