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

        <!-- INICIA CALENDARIO -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>

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

        <!--HIGHCHARTS-->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script>
        <script type="text/javascript" src="highcharts/exporting.js"></script>
        <!--HIGHCHARTS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/arcade-clientes.js"></script>
        <script type="text/javascript" src="js/arcade-region.js"></script>
        <script type="text/javascript" src="js/arcade-asignacion.js"></script>
        <script type="text/javascript" src="js/arcade-carteos.js"></script>
        <script type="text/javascript" src="js/arcade-visitas.js"></script>
    </head>
    <style type="text/css">

    </style>
    <body style="overflow:auto; background:#ffffff ">
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="row" id="barra">
            <nav id="ayuda_nav" class="grey lighten-4">
                <div class="nav-wrapper">
                    <a id="ayuda_name" class="brand-logo " style="color:black">Control Visitas</a>
                    <ul class="right hide-on-med-and-down" style="margin-right:2%;">
                        <li id="print_carteo">
                            <a href="#">
                                <i id="nav_i" class="material-icons">print</i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i id="nav_i" class="material-icons help">picture_as_pdf</i>
                            </a>
                        </li>
                        <li id="roboto">Manuales de usuario de este modulo</li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container-fluid" style="overflow: no-display;margin: 10px 20px 10px 20px;">


            <!--END TITLE & BREADCRUMB PAGE-->

            <!--http://materializecss.com/ Guia Materialize-->

            <!--BEGIN CONTENT-->
            <!-- row linea si solo ocupas un div con la mitad o menos del tamaño pon un row siguiente y salta a la siguiente-->
            <!--Recuerda que la pantalla se divide en 12 dependiendo del col s que uses 12 como 100% -->

            <div class="row" style="margin-left: auto;margin-right: auto;margin-bottom: 20px; position: fixed;">

                <form action="captura" method="POST">
                    <div class="col s12  z-depth-1" style="background:#eceff1; padding: 6px 1rem;border: solid 1px black ;">
                        <div class="input-field col s2 " style="width: 147px;padding: 0 1rem;">
                            <!--SELECT TIPO DE CARTA-->
                            <select id="id_carta" name="id_carta">
                                <option value="1">PREVIA </option>
                                <option value="2">FINAL</option>
                            </select>
                            <br><br>
                            <!--SELECT REGION-->
                            <select id="id_region" name="id_region"></select>
                            <br><br>
                        </div>

                        <div class="col s1" id="todo_asignaciones" style="width: 147px;padding: 0 1rem;">
                            <input id="cadena_asignaciones" type="hidden">
                            <br>
                            <div id="div_asignaciones"></div>
                        </div>
                        <div class="col s3" id="todo_ciudades" style="width: 235px;padding: 0 1rem;">
                            <input id="cadena_ciudades" type="hidden">
                            <br>
                            <div id="div_ciudades" style="overflow:auto; height:170px;"></div>
                        </div>
                        <!--modificado-->
                        <div class="col s2" id="todo_codigos" style="width: 147px;padding: 0 1rem;">
                            <input id="cadena_codigos" type="hidden">
                            <br>
                            <div id="div_codigos" style="overflow:auto; height:170px;"></div>
                        </div>
                        <div class="col s2" id="todo_colonias" style="width: 247px;padding: 0 1rem;">
                            <input id="cadena_colonias" type="hidden">
                            <br>
                            <div id="div_colonias" style="overflow:auto; height:170px;"></div>
                        </div>
                        <!--fin de modificado-->
                        <div class="col s2" id="todo_ladas" style="width: 147px;padding: 0 1rem;">
                            <input id="cadena_ladas" type="hidden">
                            <br>
                            <div id="div_ladas" style="overflow:auto; height:170px;"></div>
                        </div>
                        <div  id="div_enviar" class="col s1 align-center" style="margin-top: 18px;width: 133px;display: none;">
                            <label for="resto" style="text-align:center;">  CUENTAS CON MONTO MAYOR A:</label>
                            <input id="resto" type="text" value="0" class="entero checked" style="font-size: 2rem;font-weight: bold;text-align: center;border:none;">
                            <a id="enviar" class="waves-effect waves-light btn blue" style="margin-left: 16px;width: 80px;">
                                <i class="material-icons left">done</i>
                            </a>
                            <br>
                            <label id="cantidad" style="font-size: 13px;"></label>
                        </div>


                    </div>
                    <div id="datos_visitas" class="col s12 z-depth-3" style="margin-top:20px;max-height:250px;overflow: auto; padding: 0px;"> </div>
                    <div id="div_confirmar" class="col s12 right-align " style="margin-top: 10px;padding: 0px;display:none;">
                        <label id="info_cartas" style="font-size: 18px; margin-right: 15px; margin-top: 5px;"></label>
                        <a onclick="tableToExcel('datos_visitas', 'BITACORA VISITAS')" class="waves-effect waves-light btn green"><i class="material-icons">explicit</i></a>
                        <a class="waves-effect waves-light btn blue z-depth-3" id="print_cart">
                            CONFIRMAR CUENTAS<i class="material-icons left">done</i>
                        </a>
                    </div>
            </div>
        </div>

        <div class="row" id="contenedor_carta" style="font-size:12px">

        </div>
        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_region_combo_materialize(1, "id_region", true);
                $('select').material_select();
                //                    select_carteos();
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 55, // Creates a dropdown of 15 years to control year,
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
            $("#print_cart").on("click", function () {
                if ($("#id_carta").val() == 1) {
                    //ENVIA LOS DATOS PARA GENERAR LAS CARTA DE NOTIFICACION PREVIA 
                    select_cadena_datos_cartas(
                            $("#id_region").val(),
                            $("#cadena_asignaciones").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            $("#cadena_ladas").val(),
                            $("#resto").val(),
                            "contenedor_carta");
                    $("#barra").hide(); 
                    $(".container-fluid").hide();

                } else {
                    //TRAE ENVIA LOS DATOS PARA GENERAR LAS CARTAS 
                    select_cadena_datos_cartas2(
                            $("#id_region").val(),
                            $("#cadena_asignaciones").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            $("#cadena_ladas").val(),
                            $("#resto").val(),
                            "contenedor_carta");
                    $("#barra").hide();      
                    $(".container-fluid").hide();
                }

            });
            //==================================================================
            $(".print_carteo").live("click", function () {
                var src = $(this).closest("tr").attr("id");
                window.open("imprimiendo-carteo2.jsp?" + src, "_blank");
            });
            //==================================================================
            $("#enviar").on("click", function () {
                $("#div_confirmar").show();
                if ($("#id_carta").val() == 1) {
                    select_datos_visitas(
                            $("#id_region").val(),
                            $("#cadena_asignaciones").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            $("#cadena_ladas").val(),
                            $("#resto").val(),
                            "datos_visitas");
                } else {
                    //alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
                    select_datos_segunda_visitas(
                            $("#id_region").val(),
                            $("#cadena_asignaciones").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            $("#cadena_ladas").val(),
                            $("#resto").val(),
                            "datos_visitas");
                }

            });
            //==================================================================
            $("#id_region").change(function () {
                $("#todo_asignaciones").show();
                /* evalua que tipo de carta se escogio y en base a eso se ejecuta la consulta coresponsiente 
                 * 1 = PREVIA NOTIFICACION
                 * 2 = NOTIFICACION FINAL -- cuentas que ya han sido vistadas por primera vez */
                if ($("#id_carta").val() == 1) {
                    select_asignacion_region_check_materialize($("#id_region").val(), "div_asignaciones");
                } else {
//                    alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
                    select_asignacion_region_check_visitas($("#id_region").val(), "div_asignaciones");
                }

            });
            //==================================================================
            function genera_cadena(_plural, _singular) {

                // Delimitamos la variable
                var _texto;

                // LIMPIAMOS LA CAJA DE TEXTO
                $("#cadena_" + _plural).val('');

                $('#' + _singular + '_disp tbody tr').each(function () {
                    if ($(this).closest('tr').find('.check_' + _singular).is(':checked')) {
                        $("#cadena_" + _plural).val($("#cadena_" + _plural).val() + $(this).closest('tr').attr("id") + ", ");
                    }
                });
                _texto = $("#cadena_" + _plural).val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_" + _plural).val(_texto);
                _texto = $("#cadena_" + _plural).val();

            }
            //==================================================================
            $(".check_asignacion").live("click", function () {
                var _texto;
                $("#cadena_asignaciones").val('');
                $('#div_asignaciones .check_asignacion').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_asignaciones").val($("#cadena_asignaciones").val() + $(this).attr("id") + ", ");
                    }
                });
                _texto = $("#cadena_asignaciones").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_asignaciones").val(_texto);
                _texto = $("#cadena_asignaciones").val();

                if ($("#cadena_asignaciones").val() != '') {
                    //select_ciudades_asignaciones_check($("#cadena_asignaciones").val(), "div_ciudades");
                    /* evalua que tipo de carta se escogio y en base a eso se ejecuta la consulta coresponsiente 
                     * 1 = PREVIA NOTIFICACION
                     * 2 = NOTIFICACION FINAL -- cuentas que ya han sido vistadas por primera vez */
                    if ($("#id_carta").val() == 1) {
                        select_ciudades_asignaciones_check($("#cadena_asignaciones").val(), $("#id_region").val(), "div_ciudades");
                    } else {
//                        alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
                        select_ciudades_check($("#cadena_asignaciones").val(), $("#id_region").val(), "div_ciudades");
                    }
                } else {
                    $("#div_ciudades").empty();
                }
            });
            //==================================================================
            $("#check_asignacion_todos").live("click", function () {
                if ($("#check_asignacion_todos").is(":checked")) {
                    $(".check_asignacion").prop("checked", true);
                } else {
                    $(".check_asignacion").prop("checked", false);
                }
                var _texto;
                $("#cadena_asignaciones").val('');
                $('#div_asignaciones .check_asignacion').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_asignaciones").val($("#cadena_asignaciones").val() + $(this).attr("id") + ", ");
                    }
                });
                _texto = $("#cadena_asignaciones").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_asignaciones").val(_texto);
                _texto = $("#cadena_asignaciones").val();

                if ($("#id_carta").val() == 1) {
                    select_ciudades_asignaciones_check($("#cadena_asignaciones").val(), $("#id_region").val(), "div_ciudades");
                } else {
                    //alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
                    select_ciudades_check($("#cadena_asignaciones").val(), $("#id_region").val(), "div_ciudades");
                }
            });
            //==================================================================
            $(".check_ciudad").live("click", function () {
                var _texto;
                $("#cadena_ciudades").val('');
                $('#div_ciudades .check_ciudad').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_ciudades").val($("#cadena_ciudades").val() + "'" + $(this).attr("id") + "', ");
                    }
                });
                _texto = $("#cadena_ciudades").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_ciudades").val(_texto);
                _texto = $("#cadena_ciudades").val();

                if ($("#cadena_ciudades").val() != '') {
                    //identificamos que tipo de carta que esta seleccionada
                    if ($("#id_carta").val() == 1) {
                        select_codigo_postal_colonias_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), "div_codigos");
//                        select_colonias_ciudades_check( $("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), "div_colonias");
                    } else {
//                        alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
//                        select_colonias_check( $("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), 1, "div_colonias");
                        select_codigo_postal_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), 1, "div_codigos");
                    }
                } else {
//                    $("#div_colonias").empty();
                    $("#div_codigos").empty();
                }
            });
            //==================================================================
            $("#check_ciudad_todos").live("click", function () {
                if ($("#check_ciudad_todos").is(":checked")) {
                    $(".check_ciudad").prop("checked", true);
                } else {
                    $(".check_ciudad").prop("checked", false);
                }
                var _texto;
                $("#cadena_ciudades").val('');
                $('#div_ciudades .check_ciudad').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_ciudades").val($("#cadena_ciudades").val() + "'" + $(this).attr("id") + "', ");
                    }
                });
                _texto = $("#cadena_ciudades").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_ciudades").val(_texto);
                _texto = $("#cadena_ciudades").val();

                if ($("#cadena_ciudades").val() != '') {
                    //identificamos que tipo de carta que esta seleccionada
                    if ($("#id_carta").val() == 1) {
                        select_codigo_postal_colonias_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), "div_codigos");
//                        select_colonias_ciudades_check( $("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), "div_colonias");
                    } else {
                        //alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
//                        select_colonias_check( $("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), 1, "div_colonias");
                        select_codigo_postal_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), 1, "div_codigos");
                    }
                } else {
//                    $("#div_colonias").empty();
                    $("#div_codigos").empty();
                }
            });
            //==================================================================
            $(".check_colonia").live("click", function () {
                var _texto;
                $("#cadena_colonias").val('');
                $('#div_colonias .check_colonia').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_colonias").val($("#cadena_colonias").val() + "'" + $(this).attr("id") + "', ");
                    }
                });
                _texto = $("#cadena_colonias").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_colonias").val(_texto);
                _texto = $("#cadena_colonias").val();

                if ($("#cadena_colonias").val() != '') {
                    //identificamos que tipo de carta que esta seleccionada
                    if ($("#id_carta").val() == 1) {
//                        select_codigo_postal_colonias_check( $("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), $("#cadena_colonias").val(), "div_codigos");
                        select_status_codigo_postal_check($("#cadena_asignaciones").val(), $("#cadena_colonias").val(), $("#cadena_codigos").val(), "div_ladas");
                    } else {
                        //alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
//                        select_codigo_postal_check( $("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), $("#cadena_colonias").val(), 1, "div_codigos");
                        select_status_check($("#cadena_asignaciones").val(), $("#cadena_colonias").val(), $("#cadena_codigos").val(), "div_ladas");
                    }
                } else {
                    $("#div_ladas").empty();
                }
            });
            //==================================================================
            $("#check_colonia_todos").live("click", function () {
                if ($("#check_colonia_todos").is(":checked")) {
                    $(".check_colonia").prop("checked", true);
                } else {
                    $(".check_colonia").prop("checked", false);
                }
                var _texto;
                $("#cadena_colonias").val('');
                $('#div_colonias .check_colonia').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_colonias").val($("#cadena_colonias").val() + "'" + $(this).attr("id") + "', ");
                    }
                });
                _texto = $("#cadena_colonias").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_colonias").val(_texto);
                _texto = $("#cadena_colonias").val();

                if ($("#cadena_colonias").val() != '') {
                    //identificamos que tipo de carta que esta seleccionada
                    if ($("#id_carta").val() == 1) {
//                        select_codigo_postal_colonias_check( $("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), $("#cadena_colonias").val(), "div_codigos");
                        select_status_codigo_postal_check($("#cadena_asignaciones").val(), $("#cadena_colonias").val(), $("#cadena_codigos").val(), "div_ladas");
                    } else {
                        //alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
                        select_status_check($("#cadena_asignaciones").val(), $("#cadena_colonias").val(), $("#cadena_codigos").val(), "div_ladas");
                    }
                } else {
                    $("#div_ladas").empty();
                }
            });
            //==================================================================
            $(".check_codigo").live("click", function () {
                var _texto;
                $("#cadena_codigos").val('');
                $('#div_codigos .check_codigo').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_codigos").val($("#cadena_codigos").val() + "" + $(this).attr("id") + ", ");
                    }
                });
                _texto = $("#cadena_codigos").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_codigos").val(_texto);
                _texto = $("#cadena_codigos").val();

                if ($("#cadena_codigos").val() != '') {
                    //identificamos que tipo de carta que esta seleccionada
                    if ($("#id_carta").val() == 1) {
//                        select_lada_codigo_postal_check( $("#cadena_asignaciones").val(), $("#cadena_codigos").val(), "div_ladas");
                        select_colonias_ciudades_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), $("#cadena_codigos").val(), "div_colonias");
                    } else {
//                        alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
//                        select_lada_check( $("#cadena_asignaciones").val(), $("#cadena_codigos").val(), "div_ladas");
                        select_colonias_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), $("#cadena_codigos").val(), 1, "div_colonias");
                    }
                } else {
                    $("#div_colonias").empty();
                }
            });
            //==================================================================
            $("#check_codigo_todos").live("click", function () {
                if ($("#check_codigo_todos").is(":checked")) {
                    $(".check_codigo").prop("checked", true);
                } else {
                    $(".check_codigo").prop("checked", false);
                }
                var _texto;
                $("#cadena_codigos").val('');
                $('#div_codigos .check_codigo').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_codigos").val($("#cadena_codigos").val() + "" + $(this).attr("id") + ", ");
                    }
                });
                _texto = $("#cadena_codigos").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_codigos").val(_texto);
                _texto = $("#cadena_codigos").val();

                if ($("#cadena_codigos").val() != '') {
                    //identificamos que tipo de carta que esta seleccionada
                    if ($("#id_carta").val() == 1) {
                        select_colonias_ciudades_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), $("#cadena_codigos").val(), "div_colonias");
                    } else {
                        //alert("AQUI SE EJECUTARA LA CONSULTA PARA SEGUNDA CARTA");
                        select_colonias_check($("#cadena_asignaciones").val(), $("#cadena_ciudades").val(), $("#cadena_codigos").val(), 1, "div_colonias");
                    }
                } else {
                    $("#div_colonias").empty();
                }
            });
            //==================================================================
            $(".check_lada").live("click", function () {
                $("#div_enviar").show();
                var _texto;
                $("#cadena_ladas").val('');
                $('#div_ladas .check_lada').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_ladas").val($("#cadena_ladas").val() + "" + $(this).attr("id") + ", ");
                    }
                });
                _texto = $("#cadena_ladas").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_ladas").val(_texto);
                _texto = $("#cadena_ladas").val();

            });
            //==================================================================
            $("#check_lada_todos").live("click", function () {
                $("#div_enviar").show();
                if ($("#check_lada_todos").is(":checked")) {
                    $(".check_lada").prop("checked", true);
                } else {
                    $(".check_lada").prop("checked", false);
                }
                var _texto;
                $("#cadena_ladas").val('');
                $('#div_ladas .check_lada').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_ladas").val($("#cadena_ladas").val() + "" + $(this).attr("id") + ", ");
                    }
                });
                _texto = $("#cadena_ladas").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_ladas").val(_texto);
                _texto = $("#cadena_ladas").val();

            });
            //==================================================================
            // ARCADE Software®
        </script>

    </body>

</html>
