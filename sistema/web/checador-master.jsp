<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>ERP</title>


        <!--ICONS PARA MATERIALIZE-->
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/arcade-style-frame.css" media="screen">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--ICONS PARA MATERIALIZE-->

        <!--ARCADE CSS-->
        <!--        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
                <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">
       
                <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
                <link type="text/css" rel="stylesheet" href="styles/all.css">
                <link type="text/css" rel="stylesheet" href="styles/main.css">-->
        <!--ARCADE CSS-->

        <!-- INICIA CALENDARIO -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>       
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>
        <!--    <script>
                    $(function () {
                        $(".datepicker").datepicker({changeMonth: true, changeYear: true, numberOfMonths: 1});
                    });
                </script>-->
        <!--TERMINA CALENDARIO -->

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <script type="text/javascript" src="js/arcade-hora-server.js"></script>
        <!--ARCADE JS-->

        <!--MATERIALIZE-->
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/arcade-nav.css">
        <!--MATERIALIZE-->

        <!-- HIGHCHARTS-->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script> 
        <script type="text/javascript" src="highcharts/exporting.js"></script>
        <!-- HIGHCHARTS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <style>

            label color
            .input-field label {
                color: #000;
            }
            label focus color
            .input-field input[type=text]:focus + label {
                color: #000;
            }
            label underline focus color
            .input-field input[type=text]:focus {
                border-bottom: 1px solid #000;
                box-shadow: 0 1px 0 0 #000;
            }
            valid color
            .input-field input[type=text].valid {
                border-bottom: 1px solid #000;
                box-shadow: 0 1px 0 0 #000;
            }
            invalid color
            .input-field input[type=text].invalid {
                border-bottom: 1px solid #000;
                box-shadow: 0 1px 0 0 #000;
            }
            icon prefix focus color
            .input-field .prefix.active {
                color: #000;
            }
            .colore{
                background-color: #5c0403;
            }
            .font{
                color: #ffffff;
            }
        </style>

    </head>
    <body style="background-image: url('images/font.jpg');background-size:100% auto;background-repeat: no-repeat; background-attachment: fixed;  -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover; ">
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="row">
            <div class="col s10 offset-s1 center-align">
                <div class="col s10 offset-s1"><img id="imagen_empleado" width="300"  onerror="this.src='images/1.jpg'" style="margin-top: 4%;border-radius: 9px;"></div>                    
                <div class="z-depth-5 col s6 offset-s3 colore " style="margin-top: -6px;border-radius: 9px;">
                    <div>
                        <h4 id="dato1" class=" font"></h4>
                    </div>
                </div>
            </div>
            <div class="col s10 offset-s1 center-align">
                <div class="col s6 offset-s3 z-depth-5" style="border-radius: 8px;">
                    <h4 id="dato0" class="center-align"></h4>
                </div>
            </div>
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            var id;
            $(document).ready(function () {
                var id = window.location.search.substring(1);
                select_nombre_entradas(id, "div_mensaje");
                $("#imagen_empleado").attr("src", "http://192.168.0.12:8080/archivosrh/" + id + ".png");
                console.log("http://192.168.0.12:8080/archivosrh/" + id + ".png");
            });
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