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

        <script type="text/javascript" src="js/arcade-clientes.js"></script>
        <script type="text/javascript" src="js/arcade-estatus-cuenta.js"></script>

        <script type="text/javascript" src="js/arcade-puesto.js"></script>

    </head>
    <body style="background-image: url('images/background-cliente.png')">

        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="page-title-breadcrumb option-demo">
            <div class="page-header pull-right">
                <div class="page-title">
                    Estatus de Cuentas por Cliente
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
            <table style="width: 94%;border: 0px;margin: 0px auto;">
                <tr>
                    <td style="width: 76%;">
                        <div class="datagrid sombra" style="width: 94%;">
                            <table>
                                <thead>
                                    <tr>
                                        <th colspan="2" style="text-align: center;">CLIENTE</th>
                                    </tr>
                                </thead>
                                <tr>
                                    <td>
                                        <select id="id_cliente"></select>
                                    </td>
                                </tr>
                            </table>
                        </div>

                        <br>
                        <div id="listado_estatus_cuenta" class="datagrid sombra" style="width:94%;height:368px;overflow:auto;"></div>

                        <br>
                        <input id="actualizar_ealqpc" type="button" value="Actualizar" style="margin-left: 3%;">
                        <input id="para_editar" type="hidden" value="0" class="entero">
                        <input id="estatus_posibles" type="hidden">
                        <input id="estatus_posibles_txt" type="hidden">
                    </td>

                    <td style="width: 4%;">
                        <input id="insert_estatus_puesto" type="button" value=" > " style="font-size: 26px;height: 39px;width:39px;padding: 0px;margin: 0px auto;">
                    </td>

                    <td style="width: 20%;">
                        <div class="datagrid sombra" style="width: 94%;max-width: 520px;">
                            <table>
                                <thead>
                                    <tr>
                                        <th colspan="2" style="text-align: center;">PUESTO</th>
                                    </tr>
                                </thead>
                                <tr>
                                    <td>
                                        <select id="id_puesto"></select>
                                    </td>
                                </tr>
                            </table>
                        </div>

                        <br>
                        <div id="listado_estatus_puesto" class="datagrid sombra" style="width:94%;max-width:520px;height:368px;overflow:auto;"></div>

                        <input id="cadena_estatus" type='hidden'>
                    </td>
                </tr>
            </table>

            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_clientes_combo("id_cliente", true);
                select_puesto_combo("id_puesto");
            }
            );
            //==================================================================
            $("#actualizar_ealqpc").click(function () {

                if ($("#para_editar").val() == '0') {
                    alert("ELIGA UN ESTATUS A EDITAR");
                } else {
                    editar_puede_cambiar(
                            $("#para_editar").val(),
                            $("#estatus_posibles").val(),
                            $("#estatus_posibles_txt").val(),
                            "listado_estatus_cuenta"
                            );
                }
            });
            //==================================================================
            $(".editar_estatus_nivel").live("click", function () {
                $("#para_editar").val($(this).closest("tr").attr("id"));
            });
            //==================================================================
            $("#insert_estatus_cuenta").live("click", function () {
                insert_estatus_cuenta(
                        $("#estatus_cuenta_insert").val(),
                        $("#descripcion_insert").val(),
                        $("#id_cliente").val(),
                        "listado_estatus_cuenta"
                        );
            });
            //==================================================================
            $(".delete_estatus_cuenta").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_estatus_cuenta(
                            $(this).closest("tr").attr("id"),
                            "listado_estatus_cuenta"
                            );
                }
            });
            //==================================================================
            $("#insert_estatus_cuenta").live("click", function () {
                insert_estatus_cuenta(
                        $("#estatus_cuenta_insert").val(),
                        $("#descripcion_insert").val(),
                        "listado_estatus_cuenta"
                        );
            });
            //==================================================================
            $("#id_cliente").live("change", function () {
                select_estatus_cuenta_cliente_tabla3(
                        $("#id_cliente").val(),
                        "listado_estatus_cuenta"
                        );
            });
            //==================================================================
            $("#id_puesto").live("change", function () {
                select_estatus_puesto_tabla($("#id_puesto").val(), "listado_estatus_puesto");
            });
            //==================================================================
            $(".select_productos_estatus_cuenta").live("click", function () {

                $('.agregado').prop('checked', true);
            });
            //==================================================================
            $("#agregado_todos").live("click", function () {

                if ($("#agregado_todos").is(":checked")) {
                    $('.agregado').prop('checked', true);
                } else {
                    $('.agregado').prop('checked', false);
                }

                // FUNCION QUE GENERA LOS ESTATUS POSIBLES A LOS
                // QUE PUEDE CAMBIAR UN ESTATUS EN EL MANUAL
                genera_datos_eec();

            });
            //==================================================================
            $(".agregado").live("click", function () {

                // FUNCION QUE GENERA LOS ESTATUS POSIBLES A LOS
                // QUE PUEDE CAMBIAR UN ESTATUS EN EL MANUAL
                genera_datos_eec();

            });
            //==================================================================
            $("#insert_estatus_puesto").click(function () {
                if ($("#id_cliente").val() == "0") {
                    alert("SELECCIONE UN CLIENTE...");
                } else {
                    if ($("#id_puesto").val() == "0") {
                        alert("SELECCIONE UN PUESTO...");
                    } else {
                        var _estatus = "";
                        var _cant = 0;
                        $('#estatus_disponibles tr').each(function () {

                            if ($(this).closest('tr').find('.agregado').is(':checked')) {
                                _estatus = _estatus + "(" + $("#id_puesto").val() + ", " + $(this).attr("id") + "), ";
                                _cant++;
                            }
                        });
                        if (_cant == 0) {
                            alert("SELECCIONE POR LO MENOS UN ESTATUS...");
                        } else {
                            insert_estatus_puesto($("#id_puesto").val(), _estatus);
                        }

                    }
                }

            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>