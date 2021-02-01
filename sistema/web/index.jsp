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
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <title>Sistema Gestor</title>
        <style type="text/css">

            .contenedor_principal {
                background: #354152;
            }
            
/*            .contenedor_principal {
                background: linear-gradient(-45deg, #002750, #192655, #291a31);
                background-size: 600% 600%;

                -webkit-animation: AnimationName 12s ease infinite;
                -moz-animation: AnimationName 12s ease infinite;
                animation: AnimationName 12s ease infinite;
            }

            @-webkit-keyframes AnimationName {
                0%{background-position:0% 50%}
                50%{background-position:100% 50%}
                100%{background-position:0% 50%}
            }
            @-moz-keyframes AnimationName {
                0%{background-position:0% 50%}
                50%{background-position:100% 50%}
                100%{background-position:0% 50%}
            }
            @keyframes AnimationName {
                0%{background-position:0% 50%}
                50%{background-position:100% 50%}
                100%{background-position:0% 50%}
            }
*/

            .contenedor_principal {
                display: table;
                width: 100%;
                height: 100%;
                position: absolute;
            }
            .centrar {
                display: table-cell;
                vertical-align: middle;
                width: 100%;
            }
            .login {
                border-radius: 4px;
                padding: 2rem 1rem !important;
            }
            .boton {
                width: 100%;
                margin-top: 1rem;
            }
            .boton {
                transition: 0.6s;
                background-color: rgba(0,0,0,0.2);
            }
            .boton:hover {
                transition: 0.6s;
                background-color: rgba(41, 128, 185,0.7);
                color: #FFF;
            }
            input[type=text]:not(.browser-default) {
                border-bottom: 0px solid #9e9e9e;
            }
            input[type=text]:not(.browser-default):focus:not([readonly]) {
                border-bottom: 0px solid #26a69a;
                -webkit-box-shadow: 0 1px 0 0 #26a69a;
                box-shadow: 0px 0px 3px 0px #868686;
            }
            input.valid[type=text]:not(.browser-default) {
                border-bottom: 0px solid #4CAF50;
                -webkit-box-shadow: 0 1px 0 0 #4CAF50;
                box-shadow: 0px 0px 3px 0px #868686;
            }
            input[type=password]:not(.browser-default) {
                border-bottom: 0px solid #9e9e9e;
            }
            input[type=password]:not(.browser-default):focus:not([readonly]) {
                border-bottom: 0px solid #26a69a;
                -webkit-box-shadow: 0 1px 0 0 #26a69a;
                box-shadow: 0px 0px 3px 0px #868686;
            }
            input.valid[type=password]:not(.browser-default) {
                border-bottom: 0px solid #4CAF50;
                -webkit-box-shadow: 0 1px 0 0 #4CAF50;
                box-shadow: 0px 0px 3px 0px #868686;
            }
            input {
                background-color: rgba(0,0,0,0.06) !important;
                border: none;
                border-radius: 5px !important;
            }
            .img_login {
                margin-bottom: 1rem;
            }
        </style>
    </head>
    <body>
        <div class="contenedor_principal">
            <div class="centrar">
                <div class="row">
                    <div class="col s10 offset-s1 m4 l4 offset-m4 offset-l4 white login z-depth-5 hoverable">
                        <!--<img src="./imagenes/Allsafe-Financial-Services.jpg" width="100%"/>-->
                        <h4 class="center-align">Iniciar Sesion</h4>
                        <form action="/sistema/main.jsp" method="POST" class="center-align">
                            <div class="input-field">
                                <input type="text" name="id_usuario" name="id_usuario" id="_user" class="validate">
                                <label for="_user">Usuario</label>
                            </div>
                            <div class="input-field">
                                <input type="password" name="password" name="password" id="_pass" class="validate">
                                <label for="_pass">Password</label>
                            </div>
                            <button class="btn-flat boton waves-effect waves-green">Enviar</button>
                            <input id="id_perfil" value="2" type="hidden" name="id_perfil" tabindex="3">
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
    </body>
</html>
