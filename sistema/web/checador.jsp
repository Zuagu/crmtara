<%--
    Document   : checador
    Created on : 21-feb-2018, 10:50:04
    Author     : luiscortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Checador :: Grupo SICSA</title>

        <!--FAVICON AND IPHONE ICONS-->
        <link rel="shortcut icon" href="images/arcade-favicon.ico">

        <link rel="apple-touch-icon-precomposed" sizes="57x57" href="http://leimihost.com/favicons/sicsa/sicsa-57.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://leimihost.com/favicons/sicsa/sicsa-114.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://leimihost.com/favicons/sicsa/sicsa-72.png" />
        <!--FAVICON AND IPHONE ICONS-->

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
        <script type="text/javascript" src="js/arcade-sucursal.js"></script>
        <script type="text/javascript" src="js/arcade-hora-server.js"></script>
        <!--ARCADE JS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- CODIGO CSS -->
        <style>
            /*======================= ESTILO DEL LOGO DE INICIO ==================*/
            .logo_inicio {
                background-color: #FFF;
                text-align: center;
            }
            /*===================== ESTILO DE LA VENTANA DEL CODIGO ==========*/          
            .ventana_codigo {
                /*background-color: red;*/
                height: 150px;
                text-align: center;
                margin: 0px auto;
            }

            .num_empleado {
                height: 40px;
                width: 300px;
                text-align: center;
                font-size: 30px;
                margin-top: 40px;
                background-color: transparent;
                border: none;
            }
            /*===================== ESTILO DEL MENSAJE AL EMPLEADO ===========*/
            .mensaje_gestor {
                background-color: #FFF;
                height:200px;
                text-align: center;
                font-size: 20px;
            }
            .cont_emogi {
                display: inline;
                padding: 10px;
            }
            .cont_estado {
                display: inline;
                padding: 10px;
            }
            #hora_server{
                text-align: center;
                font-size: 26rem;
                width: 100%;
                border: none;
                box-sizing: border-box;
                font-weight: bold;  
                padding-top: 6%;
            }
            #div_mensaje{
                width: 50%;
                position: absolute;
                right: 3%;
                bottom: 5%;
                height: 280px;
                background:transparent;
                border: none;
            }
            #id{ text-align: center;
                 border: none;
                 background: transparent;
                 float: right;
                 color :white;
            }

        </style>
        <!-- FIN DE CODIGO CSS -->

    </head>
    <body>
        <div class="contenedor-responsive">
            <!--BEGIN CONTENT-->

            <!-- SECCION DEL LOGO -->
            <img src="images/logo-cliente.png" style="position: absolute; left:0px;top: 2%;width: 320px;">

            <div id="contenedor_imagen" class="logo_inicio">
                <!-- inicia reloj -->
                <input type="text" id="hora_server" value="00:00:00" readonly>
                <!-- termina reloj -->
            </div>
            <!-- FIN DEL SECCION DEL LOGO -->

            <!-- SECCION DE NUMERO DE EMPLEADO -->

            <input type="text" id="id" class="entero" value="" maxlength="13">          

            <!-- FIN DE LA SECCION DEL NUENRO DE EMPLEADO -->

            <div style="position: absolute !important;bottom: 2% !important;left: 1% !important;">
                <div id="cont_7a0d5ad4046731ac62fe6ccd2d31c4dc"><script type="text/javascript" async src="https://www.meteored.mx/wid_loader/7a0d5ad4046731ac62fe6ccd2d31c4dc"></script></div>
            </div>

            <div id="div_mensaje" class="datagrid" >
            </div>
            <!--END CONTENT-->
        </div>

        <!--CORE JAVASCRIPT-->

        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                mover_reloj($('#hora_server').val());
                $("#id").focus();
            }
            );
            //==================================================================
            $("body").click(function () {
                $("#id").focus();
            });
            //==================================================================
            $("#id").change(function () {
                insert_registro($(this).val(), "div_mensaje");
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>