<%-- 
    Document   : predictivos.jsp
    Created on : 26/12/2017, 05:30:29 PM
    Author     : Luis Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>

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

        <script type="text/javascript" src="js/arcade-asignacion.js"></script>
        <script type="text/javascript" src="js/arcade-marcacion.js"></script>
        <script type="text/javascript" src="js/arcade-region.js"></script>
        <script type="text/javascript" src="js/arcade-clientes.js"></script>
        <script type="text/javascript" src="js/arcade-asignacion.js"></script>

        <script src="highcharts/highcharts.js"></script>
        <script src="highcharts/data.js"></script>
        <script src="highcharts/exporting.js"></script>

    </head>

    <body style="background-image: url('images/background-cliente.png')">

        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="page-title-breadcrumb option-demo">
            <div class="page-header pull-right">
                <div class="page-title">
                    Campañas de predictivo
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

        <div class="contenedor-responsive">

            <!--BEGIN CONTENT-->
            <br>
            <h5 style="margin-left: 3%;">
                <input id="estatus" type="hidden" value="'T'">
                <b>CAMPAÑAS DE PREDICTIVOS [ <label><input id='e1' value="A" type='checkbox' class="x"> ACTIVAS</label> <label><input id="e2" value="I" type='checkbox' class="x"> PAUSADAS</label> <label><input id="e3" value="T" type='checkbox' class="x" checked> TERMINADAS </label> ]</b>
                <input value='ACTUALIZAR' id="actualizar_campaigns" type='button' style='width: 140px;background: #04b196;font-weight: bold;float: right;margin-right: 3%;'/>
                <select id="cola" value="0" style='border-radius: 5px;font-size: 11px;width: 140px;border: solid 1px #DADADA;font-weight: bold;padding: 2px 20px;float: right;margin-right: 1%;'></select>
                <input id="id_campana" type="hidden" readonly style="border-radius: 5px;font-size: 11px;width: 54px;border: solid 1px #DADADA;font-weight: bold;padding: 5px 10px;float: right;margin-right: 1%;text-align: center;"/>
            </h5>
            <div id="listado_campanias_marcacion" class="datagrid sombra nohover" style="overflow: auto;height: 420px;"></div>

            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(
                    function () {
//                        select_clientes_combo("id_cliente", true);
                        select_marcacion_tabla("listado_campanias_marcacion", $("#estatus").val());
                        select_colas("cola");
                    }
            );
            //==================================================================
            $(".x").live("click", function () {

                $("#estatus").val('');
                for (i = 1; i <= 3; i++) {
                    if ($("#e" + i).is(":checked")) {
                        $("#estatus").val($("#estatus").val() + "'" + $("#e" + i).val() + "'" + ",");
                    }
                    ;
                }
                var _texto = $("#estatus").val();
                _texto = _texto.substring(0, _texto.length - 1);
                $("#estatus").val(_texto);
                if ($("#estatus").val() == '') {
                    $("#estatus").val('\'\'');
                }

                select_marcacion_tabla("listado_campanias_marcacion", $("#estatus").val());

            }
            );
            //==================================================================
            $(".update_asignacion").live("click", function () {
                update_asignacion($(this).closest("tr").attr("id"));
            }
            );
            //==================================================================
            $("#id_cliente").change(function () {
                select_region_combo($("#id_cliente").val(), "id_region", false);
            });
            //==================================================================
            $("#select_asignacion_tabla").click(function () {
//                select_asignacion_tabla("listado_asignaciones", 1);
                select_asignacion_region_tabla("listado_asignaciones", $("#id_region").val(), 1);

            });
            //==================================================================
            $("#actualizar_campaigns").click(function () {
                select_marcacion_tabla("listado_campanias_marcacion", $("#estatus").val());
            }
            );
            //==================================================================
            $(".generar_campania_crs").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    insert_campania_marcacion(
                            $(this).closest("tr").attr("id"),
                            1,
                            "listado_campanias_marcacion"
                            );
                }
            }
            );
            //==================================================================
            $(".generar_campania_cel").live("click", function () {

                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    insert_campania_marcacion(
                            $(this).closest("tr").attr("id"),
                            2,
                            "listado_campanias_marcacion"
                            );
                }
            }
            );
            //==================================================================
            $(".generar_campania_casa").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    insert_campania_marcacion(
                            $(this).closest("tr").attr("id"),
                            3,
                            "listado_campanias_marcacion"
                            );
                }
            }
            );
            //==================================================================
            $(".update_estatus_campania").live("click", function () {
                update_estatus_campania(
                        $(this).closest("tr").attr("id"),
                        "listado_campanias_marcacion"
                        );
            }
            );
            //==================================================================
            $("#mo_listado_asignaciones").live("click", function () {
                if ($("#listado_asignaciones").is(":visible")) {
                    $("#listado_asignaciones").hide();
                } else {
                    $("#listado_asignaciones").show();
                }
            }
            );
            //==================================================================
            $("#mo_listado_campanias_marcacion").live("click", function () {
                if ($("#listado_campanias_marcacion").is(":visible")) {
                    $("#listado_campanias_marcacion").hide();
                } else {
                    $("#listado_campanias_marcacion").show();
                }
            }
            );
            //==================================================================
            $(".delete_marcacion").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_marcacion($(this).closest("tr").attr("id"), "listado_campanias_marcacion");
                }
            }
            );
            //==================================================================
            $(".select_id_campaign").live("click", function () {
                $("#id_campana").val($(this).closest("tr").attr("id"));
            }
            );
            //==================================================================
            $(".obtener_resultado_predictivo").live("click", function () {
                window.open("https://192.168.0.6/index.php?menu=campaign_out&action=csv_data&id_campaign=" + $(this).closest("tr").attr("id") + "&rawmode=yes");

            }
            );
            //==================================================================
            $("#cola").live("change", function () {
                if ($("#id_campana").val() == '') {
                    alert("SELECCIONE UNA CAMPAÑA");
                } else {
                    update_cola_campania($("#id_campana").val(), $("#cola").val());
                }
            }
            );
            //==================================================================
            $("#id_campana").contextmenu(function () {
                $(this).val('');
            }
            );
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>
