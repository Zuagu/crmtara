<%-- 
    Document   : cuentas-estatus
    Created on : 13/01/2018, 12:33:57 PM
    Author     : Luis Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Listado de cuentas x Estatus</title>
        <link rel="shortcut icon" href="images/arcade-favicon.ico">

        <!--ARCADE CSS-->
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">

        <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <!--ARCADE CSS-->

        <!-- INICIA CALENDARIO -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>        
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>
        <script>
            $(function () {
                $(".datepicker").datepicker({changeMonth: true, changeYear: true, numberOfMonths: 1});
            });
        </script>
        <!-- TERMINA CALENDARIO -->

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <!--ARCADE JS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript" src="js/arcade-variable-post.js"></script>
        <script type="text/javascript" src="js/arcade-estatus-cuenta.js"></script>

    </head>
    <body style="background-image: url('images/background-cliente.png')">
        <div>

            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div class="page-title-breadcrumb option-demo">
                <div class="page-header pull-right">
                    <div class="page-title">
                    </div>
                </div>
                <ol class="breadcrumb page-breadcrumb pull-left">
                    <li>Manuales de usuario de este modulo:</li>
                    <li><img class="help" src="images/logo-cliente.png" style="cursor: pointer;height: 20px;"></li>

                </ol>
                <div class="clearfix">
                </div>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->

            <!--BEGIN CONTENT-->
            <br>
            <div id="listado_cuentas_estatus" class="datagrid sombra" style="max-width: 380px;width: 100%;max-height: 387px;overflow: auto;"></div>
            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(
                    function () {

                        // Secreto para una relacion larga y duradera
                        // https://www.youtube.com/watch?v=7MDo6SmJ71s

                        var _clientes = obtener_variable_post('a').replace(/%20/g, "");
                        var _regiones = obtener_variable_post('b').replace(/%20/g, "");
                        var _asignaciones = obtener_variable_post('c').replace(/%20/g, "");
                        var _equipos = obtener_variable_post('d').replace(/%20/g, "");
                        var _resto = obtener_variable_post('e').replace(/%20/g, "");
                        var _tiene_cr = obtener_variable_post('f').replace(/%20/g, "");
                        var _id_estatus = obtener_variable_post('g').replace(/%20/g, "");

                        select_cuentas_estatus(
                                _clientes,
                                _regiones,
                                _asignaciones,
                                _equipos,
                                _resto,
                                _tiene_cr,
                                _id_estatus,
                                "listado_cuentas_estatus"
                                );
                    }
            );
            //==================================================================
            $(".help").on("click", function () {
                var src = location.href;
                var aux;
                var jsp;
                aux = src.split('/sistema/');
                jsp = aux[1];
                jsp = jsp.replace('.jsp', '');
                window.open("ayuda.jsp?tema=" + jsp, "_blank");
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>