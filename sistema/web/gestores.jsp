<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="arcade.data.GestorDao"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>


        <!--ICONS PARA MATERIALIZE-->
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/arcade-style-frame.css" media="screen">
        <!--ICONS PARA MATERIALIZE-->

        <!-- INICIA JQUERY -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>       
        <!--TERMINA JQUERY -->

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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--MATERIALIZE-->

        <!-- HIGHCHARTS-->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script> 
        <script type="text/javascript" src="highcharts/exporting.js"></script>
        <!-- HIGHCHARTS-->


        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/arcade-gestor.js"></script>
        <script type="text/javascript" src="js/arcade-usuario.js"></script>

        <script type="text/javascript" src="js/arcade-estatus-cuenta.js"></script>


        <%
            request.getParameter("desde");
            request.getParameter("hasta");
            request.getParameter("id_gestor");

            String convenios;
            String pagos;

            String prop_tabla;
            String grafica;

            String subtitulo = request.getParameter("id_gestor");
            String fechas = "";
//            String subtitulo;
            if (request.getParameter("desde") == null || request.getParameter("desde").isEmpty()) {

                prop_tabla = "";
                grafica = "display:none;";

                convenios = "0";
                pagos = "0";

            } else {
                convenios = GestorDao.select_gestor_convenios(request.getParameter("desde"), request.getParameter("hasta"), Integer.parseInt(request.getParameter("id_gestor")));
                pagos = GestorDao.select_gestor_pagos(request.getParameter("desde"), request.getParameter("hasta"), Integer.parseInt(request.getParameter("id_gestor")));

                prop_tabla = "display:none;";
                grafica = "";

                fechas = GestorDao.select_gestor_fechas(request.getParameter("desde"), request.getParameter("hasta"), Integer.parseInt(request.getParameter("id_gestor")));
            }
        %>

        <style>

            .estilo_volver{
                font-size: 1.2rem;
                color: #ABABAB;
                text-decoration: none;
                transition: .8s;
            }
            .estilo_volver:hover{
                font-size: 1.2rem;
                color: #FE5D49;
                text-decoration: none;
            }


        </style>

    </head>
    <body>
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="container-fluid">

            <div class="row">
                <nav id="ayuda_nav" class="grey lighten-4" >
                    <div class="nav-wrapper">
                        <a class="ayuda_name" class="brand-logo ">Gestores</a>
                        <ul class="right hide-on-med-and-down"  style="margin-right:2%;">
                            <li id="pdf_horas-clase-maestro"><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
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
                <div style="<%= prop_tabla%>">
                    <form id="generar_grafica" name="generar_grafica" action="gestores.jsp">

                        <div id="div_listado">
                            <div class="col s12 center-align" style="margin: 0px auto;margin-bottom: 0px;">
                                <h5 style="margin-bottom: 0px;">LISTADO DE GESTORES</h5>
                            </div>
                            <div class="col s12 center-align">
                                <input id="filtro" class="filtro" type="text" style="width:400px;">
                            </div>


                            <div class="col s12 ">
                                <br><br>
                                <div id="listado_gestores" class="striped z-depth-4" style="height: 280px;;overflow: auto;margin: 0px auto;width: 85%;font-size: 12px;"></div>
                            </div>

                            <div class="col s4" style="margin-top: 19px;margin-left: 100px;">
                                <a id="nueva_categoria" class="waves-effect waves-light btn blue z-depth-5" style="padding: 0px 1rem;">NUEVA CATEGORIA</a>
                                <input id="id_gestor" name="id_gestor" type="hidden" value="0">
                                <a class="waves-effect waves-light btn green darken-3 z-depth-5" onclick="tableToExcel('listado_usuarios', 'LISTADO DE USUARIOS')" style="border-radius: 4px;padding: 0px 1rem;">xslx</a>
                            </div>
                            <div class="col s4 z-depth-4 " style="float: right;margin-top: 19px;margin-right: 110px;height: 80px;">
                                <!--CAMBIAR ESTA TABLA POR UN DIV POR QUE ESTA NO NOS ESTA DANDOMAS ESP PARA LA SELECCION PROBLEMA DEL GOOGLE CHROME-->
                                <table>
                                    <thead>
                                        <tr>
                                            <th colspan="2" style="padding:0px;">CAMBIAR CATEGORIA</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr style="padding:0px;">
                                            <td style="text-align: center;padding:0px;"><select id="id_categoria" ></select></td>
                                            <td style="text-align: center;padding:10px;"><a id="update_categoria_gestor" class="waves-effect waves-light btn blue z-depth-4">APLICAR</a></td>
                                        </tr>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                        <div id="div_categoria" style="display:none; margin:0px auto" class="center-align">

                            <div id="listado_categoria" class="col s4 offset-s4 z-depth-4 center-align blue" style="font-size:12px"></div>
                            <div class="col s12">
                                <a id="cancelar_editar" class="estilo_volver" href="#" style="margin: 0px auto;margin-top: 20px;">Cancelar</a>
                            </div>
                        </div>
                        <div id="div_fecha"  class="col s12 center-align" style="display:none">
                            <div class="col s12">
                                <h4>Selecciona el rango</h4>
                            </div>
                            <div class="input-field col s3 offset-s3">
                                <input  id="desde" type="text" class="datepicker validate" name="desde">
                                <label class="active" for="first_date" >Desde</label>
                            </div>
                            <div class="input-field col s3">
                                <input  id="hasta" type="text" class="datepicker validate" name="hasta">
                                <label class="active" for="second_date">Hasta</label>
                            </div>

                            <div class="col s12">
                                <a id="btn_grafica" class="waves-effect waves-light btn blue z-depth-2" style="border-radius:3px;font-weight: bold;border-radius: 4px;padding: 0px 1rem;">GRAFICAR</a>
                            </div>
                            <div class="col s12">
                                <a id="cancelar_datepicker" class="estilo_volver" href="#" style="margin: 0px auto;margin-top: 20px;font-size: 12px;">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div id="grafica" class="col s12 center-align" style="<%= grafica%>">
                    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                    <div class="col s12">
                        <a id="regresar" class="estilo_volver" href="#" style="margin: 0px auto;margin-top: 20px;font-size: 12px;">Regresar</a>
                    </div>
                </div>

            </div>



            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                //select_xxyyzz_tabla("listado_xxyyzz");
                select_categoria_combo("id_categoria");
                select_gestor_tabla_control_filtro("", "listado_gestores");
                $('select').material_select();
                Materialize.updateTextFields();
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    closeOnSelect: false // Close upon selecting a date,

                });
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

            $("#filtro").on("keyup",
                    function () {
                        select_gestor_tabla_control_filtro($('#filtro').val(), "listado_gestores");
                    }
            );
            //==================================================================
            $("#ver_usuario").live("click",
                    function () {
                        select_usuario($(this).closest("tr").attr("id"));
                    }
            );
            //==================================================================
            $("#buscar_usuarios").click(
                    function () {
                        buscar_usuarios();
                    }
            );
            //==================================================================
            $("#update_usuario").live("click",
                    function () {
                        _id_usuario = $(this).closest("tr").attr("id");
                        $("#dialog_2").dialog("open");
                    }
            );
            //==================================================================
            $("#insert_categoria").live("click", function () {
                insert_categoria_gestor(
                        $("#categoria").val()
                        );
            });
            //==================================================================
            //            $(".delete_categoria").live("click", function () {
            //                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
            //                if (confirma) {
            //                    delete_usuario($(this).closest('tr').attr('id'), "listado_categoria");
            //                }
            //            });
            //==================================================================
            $(".delete_usuario").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_usuario($(this).closest('tr').attr('id'), "listado_categoria");
                }
            });
            //==================================================================
            $(".renglon").live("click", function () {
                $("#id_gestor").val($(this).attr("id"));
            });
            //==================================================================
            $(".update_f_bloqueado").live("click", function () {
                update_f_bloqueado($(this).closest("tr").attr("id"), "listado_gestores");
            });
            //==================================================================
            $("#update_categoria_gestor").click(
                    function () {
                        update_categoria_gestor(
                                $('#id_gestor').val(),
                                $('#id_categoria').val(),
                                );
                    }
            );
            //==================================================================
            $("#id_estrategia").change(function () {
                if ($("#id_estrategia").val() == "2") {
                    $("#mostrar_estatus_estrategia").show();
                } else {
                    $("#mostrar_estatus_estrategia").hide();
                }
            });
            //==================================================================
            $("#nueva_categoria").click(function () {
                $("#div_listado").hide();
                $("#div_categoria").show();
            });
            //==================================================================
            $("#cancelar_editar").click(function () {
                $("#div_listado").show();
                $("#div_categoria").hide();
            });
            //==================================================================
            $("#cancelar_datepicker").click(function () {
                $("#div_listado").show();
                $("#div_fecha").hide();
            });
            //==================================================================
            $("#volver").click(function () {
                $("#div_listado").show();
                $("#div_fecha").hide();
            });
            //==================================================================
            $("#btn_grafica").click(function () {
//                $("#grafica").show();
//                $("#div_fecha").hide();
                document.generar_grafica.submit();
            });
            //==================================================================
            $("#regresar").click(function () {
                $("#div_listado").show();
                $("#grafica").hide();
                document.generar_grafica.submit();

            });
            //==================================================================
            $(".usuario").live("dblclick", function () {
                $("#div_fecha").show();
                $("#div_listado").hide();
            });
            //==================================================================
            $("#fecha").on("change", function () {
                select_inbound_fecha($("#desde").val(), $("#hasta").val(), "datos_tabla");
                select_inbound_fecha_resumen($("#desde").val(), $("#hasta").val(), "did", "resumen1");
                select_inbound_fecha_resumen($("#desde").val(), $("#hasta").val(), "disposition", "resumen2");
            });
            //==================================================================
            Highcharts.chart('container', {
                chart: {
                    type: 'line'
                },
                title: {
                    text: 'GRAFICA DE RECUPERACION'
                },
                subtitle: {
                    text: 'DEL GESTOR <%= subtitulo%>'
                },
                xAxis: {
                    categories: [<%= fechas%>]
                },
                yAxis: {
                    title: {
                        text: 'IMPORTE $'
                    }
                },
                plotOptions: {
                    line: {
                        dataLabels: {
                            enabled: true
                        },
                        enableMouseTracking: false
                    }
                },
                series: [{
                        name: 'CONVENIOS',
                        data: [<%= convenios%>]
                    }, {
                        name: 'PAGOS',
                        data: [<%= pagos%>]
                    }]
            });
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>