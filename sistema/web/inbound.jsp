
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="arcade.data.InboundDao"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/arcade-style-frame.css" media="screen">

        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
        <link type="text/css" rel="stylesheet" href="styles/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">

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

        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-excel.js"></script>
        <!--ARCADE JS-->

        <%
            request.getParameter("fecha");
            request.getParameter("hasta");

            String busy;
            String failed;
            String answer;
            String no_answer;

            String prop_tabla;
            String grafica;

            String titulo = "";
            String subtitulo = "";
            String fechas = "";
//            String subtitulo;
            if (request.getParameter("fecha") == null || request.getParameter("fecha").isEmpty()) {

                prop_tabla = "";
                grafica = "display:none;";

                busy = "0";
                failed = "0";
                answer = "0";
                no_answer = "0";

            } else {

                busy = InboundDao.select_inbound_serie(request.getParameter("fecha"), request.getParameter("hasta"), "BUSY");
                failed = InboundDao.select_inbound_serie(request.getParameter("fecha"), request.getParameter("hasta"), "FAILED");
                answer = InboundDao.select_inbound_serie(request.getParameter("fecha"), request.getParameter("hasta"), "ANSWERED");
                no_answer = InboundDao.select_inbound_serie(request.getParameter("fecha"), request.getParameter("hasta"), "NO ANSWER");

                prop_tabla = "display:none;";
                grafica = "";

                titulo = "titulo";
                subtitulo = "subtitulo";
                fechas = InboundDao.select_inbound_serie(request.getParameter("fecha"), request.getParameter("hasta"), "FECHAS");;
            }
        %>

        <!--HIGHCHARTS -->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script> 
        <script type="text/javascript" src="highcharts/exporting.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/arcade-inbound.js"></script>

    </head>
    <body  style="text-align: center;">

        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="page-title-breadcrumb option-demo">
            <div class="page-header pull-right">
                <div class="page-title">
                    Inbound
                </div>
            </div>
            <ol class="breadcrumb page-breadcrumb pull-left">
                <li>Manuales de usuario de este modulo:</li>
                <li id="pdf_horas-clase-maestro"><img class="help" src="images/help_pdf.png" style="cursor: pointer;"></li>

            </ol>
            <div class="clearfix">
            </div>
        </div>
        <!--END TITLE & BREADCRUMB PAGE-->

        <div class="contenedor-responsive" style="max-width: 90%;">
            <div id="tabla" style="<%= prop_tabla%>">
                <div style="float: left;width: 50%;">

                    <br>
                    <div id="encabesado" style="margin-left: 3%;"><!-- Inicio Seleccion de Fecha -->
                        <form id="generar_grafica" name="generar_grafica" action="inbound.jsp">
                            <table>
                                <tr>
                                    <td style=" text-align: right;">FECHA DE:</td>
                                    <td><input id="fecha" name="fecha" type="text" class="datepicker" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold;"></td>
                                    <td style=" text-align: left;">HASTA:</td>
                                    <td><input id="hasta" name="hasta" type="text" class="datepicker" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold;"></td>
                                </tr>
                            </table> 
                        </form>
                    </div><!-- Fin Seleccion de Fecha -->
                    <br>
                    <!-- Seccion de la Tabla -->
                    <div id="datos_tabla" class="datagrid sombra" style="max-height:450px;overflow: auto;margin: 0px auto;"></div>
                    <br>

                    <!-- Fin de la Seccion de la Tabla -->


                </div>
                <div style="float: right;width: 45%;padding-top: 70px;">
                    <div id="resumen1" class="datagrid sombra" style="float:left; width:48%"></div>
                    <div id="resumen2" class="datagrid sombra" style="float: right; width:48%"></div>
                    <br>
                    <br>
                    <input id="xlsx" onclick="tableToExcel('tabla_entradas', 'LISTADO DE ENTRADAS')" type="button" value="EXPORTAR A EXCEL" class="sombra" style="background:#1F804D;color:#FFF;font-weight: bold;margin-right: 3%;float:right; display: none; margin-top:10px; ">
                    <input id="enviar_grafica" type="button" value="GRAFICAR" class="sombra" style="margin-right: 3%;float:right; display: none; margin-top:10px;font-weight:bold;">
                </div>
            </div>
            <div id="grafica" style="width: 90%; margin: 0px auto;<%= grafica%>">
                <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
            </div>
        </div>

        <div>

        </div>


        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software
            //==================================================================
            $(document).ready(
                    function () {
                        fecha_hoy("fecha");
                        fecha_hoy("hasta");
                        select_inbound_fecha($("#fecha").val(), $("#hasta").val(), "datos_tabla");
                        select_inbound_fecha_resumen($("#fecha").val(), $("#hasta").val(), "did", "resumen1");
                        select_inbound_fecha_resumen($("#fecha").val(), $("#hasta").val(), "disposition", "resumen2");
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
            $("#fecha").on("change", function () {
                select_inbound_fecha($("#fecha").val(), $("#hasta").val(), "datos_tabla");
                select_inbound_fecha_resumen($("#fecha").val(), $("#hasta").val(), "did", "resumen1");
                select_inbound_fecha_resumen($("#fecha").val(), $("#hasta").val(), "disposition", "resumen2");
            });
            //==================================================================
            $("#hasta").on("change", function () {
                select_inbound_fecha($("#fecha").val(), $("#hasta").val(), "datos_tabla");
                select_inbound_fecha_resumen($("#fecha").val(), $("#hasta").val(), "did", "resumen1");
                select_inbound_fecha_resumen($("#fecha").val(), $("#hasta").val(), "disposition", "resumen2");
            });
            //==================================================================
            $("#enviar_grafica").click(function () {
                document.generar_grafica.submit();
            });
            //==================================================================
            Highcharts.chart('container', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Detalle de llamadas de entrada por día'
                },
                xAxis: {
                    categories: [<%= fechas%>]
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Número de llamadas de entrada'
                    },
                    stackLabels: {
                        enabled: true,
                        style: {
                            fontWeight: 'bold',
                            color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                        }
                    }
                },
                legend: {
                    align: 'right',
                    x: -30,
                    verticalAlign: 'top',
                    y: 25,
                    floating: true,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                    borderColor: '#CCC',
                    borderWidth: 1,
                    shadow: false
                },
                tooltip: {
                    headerFormat: '<b>{point.x}</b><br/>',
                    pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
                },
                plotOptions: {
                    column: {
                        stacking: 'normal',
                        dataLabels: {
                            enabled: true,
                            color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                        }
                    }
                },
                series: [
                    {
                        name: 'CONTESTADAS',
                        data: [<%= answer%>]
                    }, {
                        name: 'OCUPADAS',
                        data: [<%= busy%>]
                    }, {
                        name: 'NO CONTESTADAS',
                        data: [<%= no_answer%>]
                    }, {
                        name: 'FALLIDAS',
                        data: [<%= failed%>]
                    }]
            });
            // ARCADE Software
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>