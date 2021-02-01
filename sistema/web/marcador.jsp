<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ARCADE Software_</title>

        <!--FAVICON AND IPHONE ICONS-->
        <link rel="shortcut icon" href="http://leimihost.com/favicons/arcade-favicon.ico">

        <link rel="apple-touch-icon-precomposed" sizes="57x57" href="http://leimihost.com/favicons/arcade-57.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://leimihost.com/favicons/arcade-114.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://leimihost.com/favicons/arcade-72.png" />
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
        <!--ARCADE JS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body style="background-image: url('images/background-cliente.png')">
        <div>

            <!--BEGIN CONTENT-->
            <div style="background:#FFF;border-bottom: solid 1px #dadada;">
                <img src="images/logo-cliente.png" alt="" style="width: 240px;border-bottom: solid 1px #DCDCDC;">
            </div>
            <div id="pantalla_marcador" style="float: left;width: 80%;">
                <object type="text/html" data="http://192.168.0.5/" style="width: 100%;height: 568px;"></object>
            </div>
            <div style="float: right;width: 20%;">
                <object type="text/html" data="webphone/softphone.html" style="width: 100%;height: 568px;"></object>
            </div>
            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
//                select_xxyyzz_tabla("listado_xxyyzz");
            }
            );
            //==================================================================
            $("#insert_xxyyzz").live("click", function () {
                insert_xxyyzz($("#xxyyzz_insert").val());
            });
            //==================================================================
            $(".delete_xxyyzz").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_xxyyzz($(this).closest("tr").attr("id"));
                }
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>