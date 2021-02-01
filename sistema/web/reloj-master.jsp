<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <script type="text/javascript" src="js/reloj.js"></script>
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
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


        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">


        <style>

            /*             label color
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
                        }*/
            * {
                margin: 0;
                padding: 0;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            body{
                font-family:calibri, sans-serif; 

            }
            .background-wrap{
                position: fixed;
                z-index: 1000;
                width:100%;
                height: 100%;
                overflow: hidden;
                top:0;
                left: 0;
            }
            #video-bg-elem{
                position: absolute;
                top:0;
                left: 0;
                min-height: 100%;
                min-width:100%; 
            }
            .content{
                position: absolute;
                width: 100%;
                min-height: 100%;
                z-index: 1000;
                background-color: rgba(0.0.0.7);
            }


            .widget{
                width: 100%;
                margin: 2em;

            }

            .widget p {
                display: inline-block;
                line-height: 1em;
            }
            .fecha{
                font-family: Times New Roman;
                text-align: center;
                font-size: 3.5em;
                margin-bottom: 0.3125rem;
                padding: 20px;
                width: 100%;

            }

            .reloj{
                font-family: Times New Roman;
                padding: 20px;
                width: 100%;
                height: 100%;
                font-size: 13em;
                text-align:center;



            }

            .reloj .caja-segundos{
                display: inline-block;
            }

            .reloj .segundos,
            .reloj .ampm{
                font-size: 6rem;
                display: block;
            }

        </style>

    </head>
    <body  style="background-image: url('images/imagensicso.jpg');background-size: 76%;background-repeat: no-repeat;background-position: top;">
        <div class="row">
<!--            <div class="col s12 background-wrap">
                <video id="video-bg-elem" preload="auto" autoplay="true" loop="loop" muted="muted">
                    <source src="images/video.mp4" type="video/mp4">
                    Video not supported
                </video>
            </div>    -->
            <div class=" col s10 offset-s1 content wrap" style="margin-top: 5.33%;;margin-left:8.333%;;background-color: rgba(255,255,255, 0.4);height: 80%;">
                <div class="widget">
                    <div class="fecha">
                        <p id="diaSemana" class="diaSemana"></p>
                        <p id="dia" class="dia"> </p>
                        <p>de </p>
                        <p id="mes" class="mes"> </p>
                        <p>del </p>
                        <p id="year" class="year"> </p>
                    </div>

                    <div class="reloj">
                        <p id="horas" class="horas"> </p>
                        <p>:</p>
                        <p id="minutos" class="minutos"> </p>
                        <p>:</p>
                        <div class="caja-segundos">
                            <p id="ampm" class="ampm"> </p>
                            <p id="segundos" class="segundos"> </p>
                        </div>
                    </div>
<!--                        <h2 class="center-align">¡¡¡¡¡¡¡¡FELICIDADES IVAN!!!!!!!</h2>-->
                </div>

            </div>
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                //select_xxyyzz_tabla("listado_xxyyzz");
                $('select').material_select();
                reloj();
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    closeOnSelect: false // Close upon selecting a date,
                });
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