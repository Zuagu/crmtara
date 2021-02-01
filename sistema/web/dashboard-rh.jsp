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
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <script type="text/javascript" src="js/arcade-excel.js"></script>
        <!--ARCADE JS-->

        <!--MATERIALIZE-->
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/arcade-nav.css">
        <!--MATERIALIZE-->

        <!-- HIGHCHARTS-->

        <script type="text/javascript" src="js/arcade-solicitud.js"></script>
        <!-- HIGHCHARTS-->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/sunburst.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <style>
            .pointer{
                cursor: pointer;
            }
            html {
                height: 100%;
            }
            body {
                background:#ffffff;
                /*                min-height: 100%;*/
            }
            .highcharts-background {
                fill:rgba(255, 255, 255, 0.2);
                stroke:rgba(0, 0, 0, 0.2);
                stroke-width:0px;
            }
            .letcolor{
                color: white !important;
            }
            .letcolor2{
                background-color: white !important;
                border-radius: 4%;
                transform: scale(1.0, .9);
            }
            .chi{
                padding: 0px 8px;
            }

            .size_button{
                transform: scale(.8, .8);
                width: 150px;
                margin-right: 50px !important;
                border-radius: 7px;
            }
            .size_button2{
                transform: scale(.5, .8);
                margin-right: 50px !important;
                margin-left: 0px !important;
                border-radius: 7px;
                padding-left: 16px;
                padding-right: 0px;
                /*                width: 1px;*/
            }
            .size_button3{
                transform: scale(.5, .7);
                margin-right: 70px !important;
                margin-left: 0px !important;
                border-radius: 7px;
                padding-left: 16px;
                padding-right: 0px;
                background-color: #616161;
                /*                width: 1px;*/
            }
            .select-wrapper input.select-dropdown {
                margin: 0px 0px 0px 8px;
                width: 90%;
                position: relative;
                cursor: pointer;
                background-color: transparent;
                border: none;
                border-bottom-color: currentcolor;
                border-bottom-style: none;
                border-bottom-width: medium;
                border-bottom: 1px solid #fff;
                outline: none;
                height: 2rem;
                line-height: 3rem;
                font-size: 1rem;
                padding: 0;
                display: block;
            }
            .innerb{
                overflow: auto;
                height : 25em;

            }
            .highcharts-container{
                height: 603px;   
            }
            .highcharts-container-1{
                height: 483.59px;
            }

        </style>

    </head>
    <body>
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="container-fluid">
            <div class="row">
                <nav id="ayuda_nav" class="hide_print" style="background:linear-gradient(to left, rgba(189,189,189,0.1), rgba(189,189,189,1));">
                    <div class="nav-wrapper">
                        <ul class="right"  style="margin-right:2%;">   
                            <li><a id="imprimir_reporte" class="waves-effect waves-light btn size_button black" style="color:white;">Reporte</a></li>
                            <li style="margin-top: 3px;">
                                <select id="reporte_individual" class="letcolor2 z-depth-1">
                                </select>
                            </li>
                            <li style="margin-left: -10px;"><a id="burro" class="waves-effect waves-light btn size_button2 black" style="color:white;"><i class="material-icons left">send</i></a></li>
                            <li><i class="medium material-icons" style="margin-top: -13px;">access_time</i></li>
                            <li><input id="desde" name="fecha" type="text" class="validate datepicker" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;background: white;"></li>
                            <li style="margin-left: 10px;margin-top: -13px;"><i class="medium material-icons">access_time</i></li>
                            <li><input id="hasta" name="fecha" type="text" class="validate datepicker" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-right: 0px;margin-left: 10px;background: white;"></li>
                            <li  style="margin-top: -1px; margin-left: -10px;"><a id="enviar" class="waves-effect waves-light btn size_button3" style="color:white;"><i class="material-icons left">send</i></a></li>
                            <li id="pdf_horas-clase-maestro" style="margin-left: 117px;"><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
                            <li id="roboto">Manuales de usuario de este modulo</li>
                        </ul>
                    </div>
                </nav>
            </div>

            <div class="row" style="margin-top: -20px;">

                <div class="col s12 m12 l12" style="margin-left:1.5%">
                    <div class="col s6 m6 l2"> 
                        <div class="col s12 m12 l10  z-depth-3 letcolor" style="background:linear-gradient(to left, rgba(107,182,29,0.6), rgba(107,182,29,1));border-radius: 3px;padding-right: 18px; padding-left: 18px;"  >
                            <h6 class="center-align">Ingresos</h6>
                            <h4 id="ingreso" class="center-align pointer"></h4>
                        </div>
                    </div>
                    <div class="col s6 m6 l2"> 
                        <div class="col s12 m12 l10  z-depth-3 letcolor" style=" background:linear-gradient(to left, rgba(255,0,0,0.6), rgba(255,0,0,1));border-radius: 3px; padding-right: 18px; padding-left: 18px;"> 
                            <h6 class="center-align">Bajas</h6>
                            <h4 id="baja" class="center-align pointer"></h4>
                        </div>
                    </div>
                    <div class="col s6 m6 l2"> 
                        <div class="col s12 m12 l10  z-depth-3 letcolor" style="background:linear-gradient(to left, rgba(0,174,239,0.6), rgba(0,174,239,1));border-radius: 3px;padding-right: 18px; padding-left: 18px;"> 
                            <h6 class="center-align">Usu. Operacion</h6>
                            <h4 id="activo" class="center-align pointer"></h4>
                        </div>
                    </div>
                    <div class="col s6 m6 l2"> 
                        <div class="col s12 m12 l10  z-depth-3 letcolor" style="background:linear-gradient(to left, rgba(134,57,2,0.6), rgba(134,57,2,0.9));border-radius: 3px;padding-right: 18px; padding-left: 18px;"> 
                            <h6 class="center-align">Total Usu.</h6>
                            <h4 id="activo_total" class="center-align pointer">80</h4>
                        </div>
                    </div>
                    <div class="col s6 m6 l2"> 
                        <div class="col s12 m12 l10  z-depth-3 letcolor" style=" background:linear-gradient(to left, rgba(255,109,0,0.6), rgba(255,109,0,1));border-radius: 3px; padding-right: 18px; padding-left: 18px;"> 
                            <h6 class="center-align">Permanencia.</h6>
                            <h4 id="permanencia" class="center-align">10</h4>
                        </div>
                    </div>
                    <div class="col s6 m6 l2"> 
                        <div class="col s12 m12 l10  z-depth-3 letcolor" style=" background:linear-gradient(to left, rgba(103,45,188,0.6), rgba(103,45,188,0.9));border-radius: 3px; padding-right: 18px; padding-left: 18px;"> 
                            <h6 class="center-align">Entrevistas.</h6>
                            <h4 id="entrevista" class="center-align">10</h4>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="">
                <div class="col s12 m12 l12" style="margin-left:1.5%">
                    <div class="col s6 m6 l4"> 
                        <div class="col s12 m12 l5 z-depth-3 letcolor" style=" background:linear-gradient(to left,rgba(255,153,0,0.6), rgba(255,153,0,0.9));border-radius: 3px; padding-right: 18px; padding-left: 18px;margin-bottom:5%"> 
                            <h6 class="center-align">Rotacion Par.</h6>
                            <h4 id="rotacion" class="center-align"></h4>
                        </div>
                        <div class="col s12 m12 l5 offset-l1  z-depth-3 letcolor" style=" background:linear-gradient(to left, rgba(34,54,68,0.6), rgba(34,54,68,0.9));border-radius: 3px; padding-right: 18px; padding-left: 18px;margin-bottom:5%"> 
                            <h6 class="center-align">Rotacion Glob.</h6>
                            <h4 id="rotacion_glob" class="center-align"></h4>
                        </div>
                        <div class="col s12 m12 l11  z-depth-3 highcharts-container-1" style=" background:linear-gradient(to left, rgba(242,243,244,0.6), rgba(242,243,244,0.9));border-radius: 3px;"> 
                            <div id="container3"></div> 
                        </div>
                    </div>
                    <div class="col s12 m6 l4">
                        <div class="col s12 m12 l5 z-depth-3 letcolor" style=" background:linear-gradient(to left,rgba(0,93,170,0.6), rgba(0,93,170,1));border-radius: 3px; padding-right: 18px; padding-left: 18px;margin-bottom:5%"> 
                            <h6 class="center-align">Citas.</h6>
                            <h4 id="cita" class="center-align">10</h4>
                        </div>
                        <div class="col s12 m12 l11  z-depth-3  highcharts-container-1" id="container1" style="border-radius: 3px;"></div>
                    </div>
                    <div class="col s12 m6 l4">
                        <div class="col s12 m12 l11  z-depth-3 highcharts-container" id="container" style=" border-radius: 3px;"></div>    
                    </div>
                </div>
            </div>




            <!--END CONTENT-->
            <!------------------------------------------------INICIO MODALES------------------------------------------------>
            <div id="modal1" class="modal">
                <div class="modal-content">
                    <h4>Activos</h4>
                    <div id="activo_div"></div>
                </div>
                <div class="modal-footer">
                    <<a onclick="tableToExcel('activo_div', 'ACTIVOS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a>
                </div>
            </div>
            <div id="modal2" class="modal">
                <div class="modal-content">
                    <h4>Bajas</h4>
                    <div id="baja_div"></div>
                </div>
                <div class="modal-footer">
                    <a onclick="tableToExcel('baja_div', 'BAJAS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a>
                </div>
            </div>
            <div id="modal3" class="modal">
                <div class="modal-content">
                    <h4>Ingresos</h4>
                    <div id="ingreso_div"></div>
                </div>
                <div class="modal-footer">
                    <a onclick="tableToExcel('ingreso_div', 'INGRESOS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a>
                </div>
            </div>
            <div id="modal4" class="modal">
                <div class="modal-content">
                    <h4>Activos Total</h4>
                    <div id="total_div"></div>
                </div>
                <div class="modal-footer">
                    <a onclick="tableToExcel('total_div', 'USUARIOS TOTALES')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a>
                </div>
            </div>
            <div id="modal5" class="modal">
                <div class="modal-content">
                    <h4>Entrevistas</h4>
                    <div id="entrevista_div"></div>
                </div>
                <div class="modal-footer">
                    <a onclick="tableToExcel('entrevista_div', 'ENTREVISTAS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a> 
                </div>
            </div>
            <div id="modal6" class="modal">
                <div class="modal-content">
                    <h4>Permanencia</h4>
                    <div id="permanenecia_div"></div>
                </div>
                <div class="modal-footer">
                    <a onclick="tableToExcel('permanenecia_div', 'PERMANENCIA')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a>
                </div>
            </div>
            <div id="modal7" class="modal">
                <div class="modal-content">
                    <h4>Citas</h4>
                    <div id="citas_div"></div>
                </div>
                <div class="modal-footer">
                    <a onclick="tableToExcel('citas_div', 'CITAS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a>
                </div>
            </div>
            <!------------------------------------------------FIN MODALES------------------------------------------------>
            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                $('.modal').modal();
                datos_grafica_dashboart();
                datos_grafica_dashboart_dos("0000-00-00", "0000-00-00", 0);
                select_activos("activo", "valor");
                select_activos_total("activo_total", "valor");
                select_ingresos("ingreso", "valor");
                select_entrevista("entrevista", "valor");
                select_bajas("baja", "valor");
                datos_grafica_dashboart3(0, "0000-00-00", "0000-00-00");
                select_citados_rango("cita", "0000-00-00", "0000-00-00", "valor");
                select_reclutadores();
                $('select').material_select();
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    closeOnSelect: true // Close upon selecting a date,
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
            $(".delete_xxyyzz").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_xxyyzz($(this).closest("tr").attr("id"));
                }
            });
            //==================================================================
            $("#meses_visualizar").live("click", () => {
                datos_grafica_dashboart(0, "", "");
            });
            //==================================================================
            // de la mierda
            $("#1").live("click", () => {
                datos_grafica_dashboart_mensual('1', '', '');
                datos_grafica_dashboart_dos("0000-00-00", "0000-00-00", 1);
                datos_grafica_dashboart3(1, "0000-00-00", "0000-00-00");
            });
            $("#2").live("click", () => {
                datos_grafica_dashboart_mensual('2', '', '');
                datos_grafica_dashboart_dos("0000-00-00", "0000-00-00", 2);
                datos_grafica_dashboart3(2, "0000-00-00", "0000-00-00");
            });
            $("#3").live("click", () => {
                datos_grafica_dashboart_mensual('3', '', '');
            });
            $("#4").live("click", () => {
                datos_grafica_dashboart_mensual('4', '', '');
            });
            $("#5").live("click", () => {
                datos_grafica_dashboart_mensual('5', '', '');
            });
            $("#6").live("click", () => {
                datos_grafica_dashboart_mensual('6', '', '');
            });
            $("#7").live("click", () => {
                datos_grafica_dashboart_mensual('7', '', '');
            });
            $("#8").live("click", () => {
                datos_grafica_dashboart_mensual('8', '', '');
            });
            $("#9").live("click", () => {
                datos_grafica_dashboart_mensual('9', '', '');
            });
            $("#10").live("click", () => {
                datos_grafica_dashboart_mensual('10', '', '');
            });
            $("#11").live("click", () => {
                datos_grafica_dashboart_mensual('11', '', '');
            });
            $("#12").live("click", () => {
                datos_grafica_dashboart_mensual('12', '', '');
            });

            //==================================================================
            function rotacion_chunung() {
                var ingres = parseInt($("#ingreso").text(), 10);
                var baj = parseInt($("#baja").text(), 10);
                var res = baj / ingres;
                var resu = res * 100;
                var resu = resu.toFixed(2) + "%";
                $("#rotacion").text(resu);
            }
            //==================================================================
            function rotacion_chunung_2() {
                var act = parseInt($("#activo").text(), 10);
                var baj = parseInt($("#baja").text(), 10);
                var res = baj / act;
                var resu = res * 100;
                var resu = resu.toFixed(2) + "%";
                $("#rotacion_glob").text(resu);
            }
            //==================================================================
            $("#activo").on("click", () => {
                $('#modal1').modal('open');
                select_activos("activo_div", "tabla");
            });
            $("#baja").on("click", () => {
                $('#modal2').modal('open');
                if ($("#desde").val() == "" && $("#hasta").val() == "") {
                    select_bajas("baja_div", "tabla");
                } else {
                    select_bajas_rango("baja_div", $("#desde").val(), $("#hasta").val(), "tabla");
                }
            });
            $("#ingreso").on("click", () => {
                $('#modal3').modal('open');
                if ($("#desde").val() == "" && $("#hasta").val() == "") {
                    select_ingresos("ingreso_div", "tabla");
                } else {
                    select_ingresos_rango("ingreso_div", $("#desde").val(), $("#hasta").val(), "tabla");
                }
            });
            $("#activo_total").on("click", () => {
                $('#modal4').modal('open');
                select_activos_total("total_div", "tabla");
            });
            $("#entrevista").on("click", () => {
                $('#modal5').modal('open');
                if ($("#desde").val() == "" && $("#hasta").val() == "") {
                    select_entrevista("entrevista_div", "tabla");
                } else {
                    select_entrevistas_rango("entrevista_div", $("#desde").val(), $("#hasta").val(), "tabla");
                }
            });
            $("#permanencia").on("click", () => {
                $('#modal6').modal('open');
                select_permanencia("permanenecia_div", $("#desde").val(), $("#hasta").val(), "tabla");
            });
                 $("#cita").on("click", () => {
                $('#modal7').modal('open');
                if ($("#desde").val() == "" && $("#hasta").val() == "") {
                    select_citados_rango("citas_div", "0000-00-00", "0000-00-00", "tabla");
                } else {
                    select_citados_rango("citas_div", $("#desde").val(), $("#hasta").val(), "tabla");
                }
            });
            //==================================================================
            $("#enviar").on("click", () => {
                if ($("#desde").val() == '' || $("#hasta").val() == '') {
                    datos_grafica_dashboart();
                    datos_grafica_dashboart_dos("0000-00-00", "0000-00-00", 0);
                    select_activos("activo", "valor");
                    select_activos_total("activo_total", "valor");
                    select_ingresos("ingreso", "valor");
                    select_entrevista("entrevista", "valor");
                    select_bajas("baja", "valor");
                    datos_grafica_dashboart3(0, "0000-00-00", "0000-00-00");
                    select_reclutadores();
                } else {
                    select_citados_rango("cita", $("#desde").val(), $("#hasta").val(), "valor");
                    select_permanencia("permanencia", $("#desde").val(), $("#hasta").val(), "valor");
                    select_ingresos_rango("ingreso", $("#desde").val(), $("#hasta").val(), "valor");
                    select_bajas_rango("baja", $("#desde").val(), $("#hasta").val(), "valor");
                    select_entrevistas_rango("entrevista", $("#desde").val(), $("#hasta").val(), "valor");
                    //grafica 1 
                    datos_grafica_dashboart_mensual(0, $("#desde").val(), $("#hasta").val());
                    //grafica 2
                    datos_grafica_dashboart_dos($("#desde").val(), $("#hasta").val(), 0);
                    //grafica 3
                    datos_grafica_dashboart3(0, $("#desde").val(), $("#hasta").val());
                    window.setTimeout(() => {
                        rotacion_chunung();
                        rotacion_chunung_2();
                    }, 300);
                }
            });
            //================================================================== 
            $("#imprimir_reporte").on("click", () => {
                var fecha_input_desde = $("#desde").val();
                var fecha_input_hasta = $("#hasta").val();
                window.open("/sistema/informe_vacantes.jsp?" + fecha_input_desde + fecha_input_hasta);
            });
            //================================================================== 
            $("#burro").on("click", () => {
                var fecha_input_desde = $("#desde").val();
                var fecha_input_hasta = $("#hasta").val();
                var select_reclutador = $("#reporte_individual").val();
                window.open("/sistema/informe_reclutador.jsp?" + fecha_input_desde + fecha_input_hasta + select_reclutador);
            });

//               window.location.reload(true);
// Splice in transparent for the center circle

            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>