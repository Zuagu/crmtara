<!DOCTYPE html>
<%@page import="arcade.data.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>ERP</title>

        <!--ARCADE CSS-->
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">

        <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <!--ARCADE CSS-->

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

        <!--<script language="javascript" src="js/arcade-main.js"></script>-->
        <script language="javascript" src="js/arcade-news.js"></script>
        <!--ARCADE JS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%String color_menu = UsuarioDao.color();%>

        <style>
            #menu-responsive ul li{
                background-color: <%= color_menu%>;
            }
        </style>

    </head>
    <body style="background-image: url('images/background-cliente.png');">

        <div>

            <!--BEGIN CONTENT-->

            <br>
            <div id="logo-cliente">
                <img src="images/logo-cliente.png" alt="">
            </div>

            <br>
            <div id="win_log" class="sombra" style="border: solid 5px #C9C9C9;margin: 0px auto;width: 100%;max-width: 450px;background: #000;color:#FFF;font-size: 1.1rem;height: 320px;">
                <div style="background: #C9C9C9;padding-bottom: 4px;color:#000;">Log del sistema...</div>
                <div id="log" style="cursor: none;padding: 10px;"></div>

            </div>
            <div id="menu-responsive"></div>
            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            var timer_log = setInterval(function () {
                log();
            }, 10000);
            //==================================================================
            function log() {
                select_log("log");
            }
            //==================================================================
            $(document).ready(function () {
                cargar_menu();
                select_log("log");
            }
            );
            //==================================================================
            function cargar_menu() {
                var params = {
                    accion: "cargar_menu",
                    id_perfil: $("#perfil_usuario", parent.document).val(),
                    id_usuario: $("#usuario_sistema", parent.document).val()
                };
                $.ajax({
                    type: "POST",
                    url: "/sistema/ManageMenu",
                    data: params,
                    dataType: "html",
                    success: function (dataRes) {
                        $("#menu-responsive").append(dataRes);
                        $("#menu-responsive").append('<li><a href="#">SISTEMA</a><ul><li><a href="#" class="signout">Cambiar Password</a></li><li id="salir"><a href="index.jsp" target="parent">Salir</a></li></ul><li>');
                    }
                });
            }
            ;
            //==============================================================================
            $(".signout").live("click",
                    function () {
                        submenu($(this).text());
                    }
            );
            //==============================================================================
            function submenu(_jsp) {
                var jsp = "";
                jsp = _jsp;
                jsp = jsp.toLocaleLowerCase();
                jsp = jsp.replace(/ /g, "-");
                top.frames['centro'].location.href = jsp.toLowerCase() + '.jsp';
            }
            //==============================================================================
            function select_log(_id_caja) {
                var params = {
                    accion: "select_log_tabla"
                };
                $.ajax({
                    type: "POST",
                    url: "/sistema/ManageLog",
                    data: params,
                    dataType: "html",
                    success: function (dataRes) {
                        $("#" + _id_caja).empty();
                        $("#" + _id_caja).append(dataRes);
                    }
                });
            }
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>