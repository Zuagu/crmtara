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

        <!--MATERIALIZE-->
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/arcade-nav.css">
        <!--MATERIALIZE-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/arcade-clientes.js"></script>
        <script type="text/javascript" src="js/arcade-region.js"></script>
        <script type="text/javascript" src="js/arcade-asignacion.js"></script>
        <script type="text/javascript" src="js/arcade-visitas.js"></script>
    </head>
    <body>
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="container-fluid">
            <div class="row">
                <nav id="ayuda_nav" class="grey lighten-4" >
                    <div class="nav-wrapper">
                        Contol Carteo
                        <a id="ayuda_name" class="brand-logo"></a>
                        <ul class="right hide-on-med-and-down"  style="margin-right:2%;">
                            <li id="print_carteo"><a href="#"><i id="nav_i" class="material-icons">print</i></a></li>
                            <li ><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
                            <li id="roboto">Manuales de usuario de este modulo</li>
                        </ul>
                    </div>
                </nav>
            </div>

            <!--END TITLE & BREADCRUMB PAGE-->            

            <!--http://materializecss.com/ Guia Materialize-->               

            <!--BEGIN CONTENT--> 
            <!-- row linea si solo ocupas un div con la mitad o menos del tamaño pon un row siguiente y salta a la siguiente-->
            <!--Recuerda que la pantalla se divide en 12 dependiendo del col s que uses 12 como 100% -->
            <div class="row">
                <div class="col s10 offset-s1">
                    <form action="captura" method="POST">
                        <div class="input-field col s2" style="width: 147px;">
                            <select id="id_region" name="id_region"></select>
                            <label>REGION</label>
                            <br>
                            <select id="id_carta" name="id_carta">
                                <option value="1">TIPO DE CARTA</option>
                                <option value="1">CARTEO 1</option>
                                <option value="2">CARTEO 2</option>
                            </select>
                        </div>
                        <div id="div_asignacion" class="input-field col s2" style="width: 200px;display: none;">
                            <select id="id_asignacion" name="id_asignacion"></select>
                            <label>ASIGNACION</label>
                        </div>
                        <div class="col s3" id="todo_ciudades" style="width: 235px;">
                            <input id="cadena_ciudades" type="hidden" ><br>
                            <div id="div_ciudades" style="overflow:auto; height:170px;"></div>
                        </div>

                        <div class="col s3" id="todo_colonias" style="width: 247px;">
                            <input id="cadena_colonias" type="hidden"><br>
                            <div id="div_colonias" style="overflow:auto; height:170px;"></div>
                        </div>
                        <div class="col s1" id="todo_codigos" style="width: 147px;">
                            <input id="cadena_codigos" type="hidden"><br>
                            <div id="div_codigos" style="overflow:auto; height:170px;"></div>
                        </div>
                        <div class="col s1 " style="height:53.5px; padding-top:7px;margin-top: 48px;">
                            <a id="enviar" class="waves-effect waves-light btn blue" style="margin-left: 5px;width: 80px;display: none;"><i class="material-icons left">send</i></a> 
                        </div>
                    </form>
                </div>
                <div id="datos_carteo" class="col s10 offset-s1 z-depth-3" style="margin-top:20px;max-height:300px;overflow: auto;">
                </div>
                <div id="div_confirmar" class="col s10 offset-s1 right-align" style="margin-top: 10px; display: none">
                    <label id="info_cartas" style="font-size: 18px; margin-right: 15px; margin-top: 5px;"></label>
                    <a class="waves-effect waves-light btn blue z-depth-2" id="print_cart">
                        CONFIRMAR CUENTAS<i class="material-icons left">done</i>
                    </a>
                </div>
            </div> 
        </div>

        <div class="row" style="font-size:13px">

        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_region_combo_materialize(1, "id_region", true);
                $('select').material_select();
                
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 55, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    closeOnSelect: false // Close upon selecting a date
                });
            }
            );
            //==================================================================
            $("#id_carta").change(function () {
                $("#div_asignacion").show();
                select_asignacion_region_combo_materialize($("#id_region").val(), 1, "id_asignacion");
            });
            //==================================================================
            $("#enviar").on("click", function () {
                if ( $('#id_carta').val() == 1) {
                    select_datos_carteo_tabla(
                        $("#id_region").val(),
                        $("#id_asignacion").val(),
                        $("#cadena_ciudades").val(),
                        $("#cadena_colonias").val(),
                        $("#cadena_codigos").val(),
                        "datos_carteo");
                } else {
                    select_datos_segundo_carteo_tabla(
                        $("#id_region").val(),
                        $("#id_asignacion").val(),
                        $("#cadena_ciudades").val(),
                        $("#cadena_colonias").val(),
                        $("#cadena_codigos").val(),
                        0,
                        "datos_carteo");
                }
                $('#div_confirmar').show();
            });
            //==================================================================
            $("#print_cart").on("click", function () {
                if ($('#id_carta').val() == 1) {
                    select_datos_carteo(
                            $("#id_region").val(),
                            $("#id_asignacion").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            0,
                            "row");
                    $(".container-fluid").hide();
                    insert_datos_carteo(
                            $("#id_region").val(),
                            $("#id_asignacion").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            0, );
                } else {
                    //CONDICION SI LA CARTA QUE SE ESTA ENVIANDO ES LA SEGUNDA
                    select_datos_segundo_carteo(
                            $("#id_region").val(),
                            $("#id_asignacion").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            0,
                            "row");
                    $(".container-fluid").hide();
                    //EN POCESO
                    update_numero_carta(
                            $("#id_region").val(),
                            $("#id_asignacion").val(),
                            $("#cadena_ciudades").val(),
                            $("#cadena_colonias").val(),
                            $("#cadena_codigos").val(),
                            0, );
                }
            });
            //==================================================================
            $("#id_asignacion").change(function () {
                $("#todo_ciudades").show();
                if ($('#id_carta').val() == 1) {
                    select_ciudades_asignaciones_check($("#id_asignacion").val(), "div_ciudades");
                } else {
                    select_ciudades_check($("#id_asignacion").val(), 2, "div_ciudades");
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
                    if ($('#id_carta').val() == 1) {
                        select_colonias_ciudades_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), "div_colonias");
                    } else {
                        select_colonias_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), 2, "div_colonias");
                    }
                } else {
                    $("#div_colonias").empty();
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
                    if ($('#id_carta').val() == 1) {
                        select_colonias_ciudades_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), "div_colonias");
                    } else {
                        select_colonias_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), 2, "div_colonias");
                    }
                } else {
                    $("#div_colonias").empty();
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
                    if ($('#id_carta').val() == 1) {
                        select_codigo_postal_colonias_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), $("#cadena_colonias").val(), "div_codigos");
                    } else {
                        select_codigo_postal_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), $("#cadena_colonias").val(), 2, "div_codigos");
                    }
                } else {
                    $("#div_codigos").empty();
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
                    if ($('#id_carta').val() == 1) {
                        select_codigo_postal_colonias_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), $("#cadena_colonias").val(), "div_codigos");
                    } else {
                        select_codigo_postal_check($("#id_asignacion").val(), $("#cadena_ciudades").val(), $("#cadena_colonias").val(), 2, "div_codigos");
                    }
                } else {
                    $("#div_codigos").empty();
                }
            });
            //==================================================================
            $(".check_codigo").live("click", function () {
                $("#enviar").show();
                var _texto;
                $("#cadena_codigos").val('');
                $('#div_codigos .check_codigo').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_codigos").val($("#cadena_codigos").val() + "'" + $(this).attr("id") + "', ");
                    }
                });
                _texto = $("#cadena_codigos").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_codigos").val(_texto);
                _texto = $("#cadena_codigos").val();
                
                
            });
            //==================================================================
            $("#check_codigo_todos").live("click", function () {
                $("#enviar").show();
                if ($("#check_codigo_todos").is(":checked")) {
                    $(".check_codigo").prop("checked", true);
                } else {
                    $(".check_codigo").prop("checked", false);
                }
                var _texto;
                $("#cadena_codigos").val('');
                $('#div_codigos .check_codigo').each(function () {
                    if ($(this).is(':checked')) {
                        $("#cadena_codigos").val($("#cadena_codigos").val() + "'" + $(this).attr("id") + "', ");
                    }
                });
                _texto = $("#cadena_codigos").val();
                _texto = _texto.substring(0, _texto.length - 2);
                $("#cadena_codigos").val(_texto);
                _texto = $("#cadena_codigos").val();
                
                
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>
