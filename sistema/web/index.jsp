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
                <a id="enviar_data">
                    <b>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        Submit
                    </b>
                </a>
            </form>
        </div>
        <script src="js/js/jquery-2.2.4.min.js"></script>
        <script>
            $("#enviar_data").click(function () {
                iniciar_sesion();
            });
            function iniciar_sesion() {
                $("#iniciar_sesion").hide();
                $("#cargando").show();
                if ($("#password").val() == "" || $("#id_usuario").val() == "") {
                    alert("INGRESE TODOS LOS DATOS REQUERIDOS.");
                    $("#iniciar_sesion").show();
                    $("#cargando").hide();
                } else {
                    var params = {
                        action: "iniciar_sesion",
                        id_perfil: 2,
                        id_usuario: $("#id_usuario").val(),
                        password: $("#password").val(),
                        ip: '127.0.0.0'
                    };
//                    console.log(params);
                    $.ajax({
                        type: "POST",
                        url: "/sistema/ControllerUsuario",
                        data: params,
                        dataType: "html",
                        success: function (dataRes) {
                            console.log(dataRes);
                            mostrar_alerta(parseInt(dataRes));
                        }
                    });
                }
            }
            function mostrar_alerta(dataRes) {
                if (dataRes === 0) {
                    alert("FALTA CHECAR ENTRADA");
                    $("#cargando").hide();
                    $("#iniciar_sesion").show();
                }
                if (dataRes === 1) {
                    document.login.submit();
                }
                if (dataRes === 2) {
                    alert("YA TIENE UNA SESION INICIADA, SOLO PUEDE TENER UNA A LA VEZ.");
                    $("#cargando").hide();
                    $("#iniciar_sesion").show();
                }
                if (dataRes === 3) {
                    alert("CONTRASEÑA ERRONEA. FAVOR DE VERIFICAR.");
                    $("#cargando").hide();
                    $("#iniciar_sesion").show();
                }
                if (dataRes === 4) {
                    alert("EMPLEADO INACTIVO. FAVOR DE VERIFICAR.");
                    $("#cargando").hide();
                    $("#iniciar_sesion").show();
                }
                if (dataRes === 5) {
                    alert("USUARIO NO EXISTE");
                    $("#cargando").hide();
                    $("#iniciar_sesion").show();
                }
                if (dataRes === 6) {
                    alert("HA ALCANZADO NUMERO MAXIMO DE USUARIOS EN SU LICENCIA.\n\n\
            SOLICITE AL ADMINSITRADOR UNA LICENCIA PARA MAS USUARIOS.\n\
        ");

                    $("#cargando").hide();
                    $("#iniciar_sesion").show();
                }
            }
        </script>
    </body>
</html>
