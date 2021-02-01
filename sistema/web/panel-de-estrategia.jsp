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


        <script type="text/javascript" src="js/arcade-usuario.js"></script>
        <script type="text/javascript" src="js/arcade-gestor.js"></script>

        <script type="text/javascript" src="js/arcade-estrategia.js"></script>
        <script type="text/javascript" src="js/arcade-estatus-cuenta.js"></script>

        <script type="text/javascript" src="js/arcade-clientes.js"></script>

        <script type="text/javascript" src="js/arcade-puesto.js"></script>

    </head>
    <body style="background-image: url('images/background-cliente.png')">

        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="page-title-breadcrumb option-demo">
            <div class="page-header pull-right">
                <div class="page-title">
                    Panel de estrategia (Marcación manual)
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
            <div class="datagrid" style="border: none;background: transparent;">
                <h4>Elige la configuración de la estrategia de cada uno de tus gestores.</h4>
            </div>

            <br>
            <div id="panel" class="datagrid sombra" style="height: 400px; overflow: auto;"></div>

            <br>
            <input id="id_usuario_actualizar" type="hidden">
            <input id="cadena_estatus" type="hidden">
            <input id="estatus" type="hidden">

            <div id="caja_estatus" style="width:94%;max-width:540px;text-align: center;display: none;margin: 0px auto;">
                <div id="listado_estatus_cuenta" class="datagrid sombra" style="width:94%;height: 350px;max-width:520px;overflow:auto;"></div>
                <br>
                <input id="finalizar" value="FINALIZAR" type="button" style="width: 120px;">
            </div>



            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_gestor_panel_tabla("panel");
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
            $(".estrategia_automatico").live("click", function () {
                update_estatus_estrategia_gestor(
                        $(this).closest("tr").attr("id"),
                        '1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 23, 24, 25, 26, 42, 43, 44, 45, 46, 47',
                        'SIN TOCAR, NC, TS, TNE, MB, DM1, DM2, DM3, DM4, PR, PI, NEG, NP, PP, IL1, IL2, IL3, IL4, NP16, NP17, NP24, NP25, NP27, NP28',
                        "panel",
                        true
                        );
            });
            //==================================================================
            $(".select_segui").live("change", function () {
                update_seguimientos_gestor($(this).closest("tr").attr("id"), $(this).val(), "panel", true);
            });
            //==================================================================
            $(".crs").live("change", function () {
                update_crs_gestor($(this).closest("tr").attr("id"), $(this).val(), "panel", true);
            });
            //==================================================================
            $(".update_importe_gestor").live("change", function () {
                update_importe_gestor($(this).closest("tr").attr("id"), $(this).val(), "panel", true);
            });
            //==================================================================
            $(".select_orden").live("change", function () {
                update_orden_gestor($(this).closest("tr").attr("id"), $(this).val(), "panel");
            });
            //==================================================================
            $(".definir_estatus").live("click", function () {
                $("#panel").hide();
                $("#caja_estatus").show();

                $("#id_usuario_actualizar").val($(this).closest("tr").attr("id"));

                select_estatus_cuenta_cliente_tabla2(
                        1,
                        "listado_estatus_cuenta"
                        );
            });
            //==================================================================
            $(".agregado").live("click", function () {

                $("#cadena_estatus").val('');
                $("#estatus").val('');

                $('#estatus_disponibles tr').each(function () {

                    if ($(this).closest('tr').find('.agregado').is(':checked')) {
                        $("#cadena_estatus").val($("#cadena_estatus").val() + $(this).closest('tr').attr("id") + ", ");
                        $("#estatus").val($("#estatus").val() + $(this).closest('tr').find('.abreviado').text() + ", ");
                    }
                });

            });
            //==================================================================
            $("#finalizar").click(function () {
                texto = $("#cadena_estatus").val();
                texto2 = $("#estatus").val();

                texto = texto.substring(0, texto.length - 2);
                texto2 = texto2.substring(0, texto2.length - 2);

                $("#cadena_estatus").val(texto);
                $("#estatus").val(texto2);

                $("#caja_estatus").hide();
                $("#panel").show();

                update_estatus_estrategia_gestor(
                        $('#id_usuario_actualizar').val(),
                        $("#cadena_estatus").val(),
                        $("#estatus").val(),
                        "panel",
                        true
                        );

            });
            //==================================================================
            $(".update_f_bloqueado").live("click", function () {
                update_f_bloqueado($(this).closest("tr").attr("id"), "panel");
            });
            //==================================================================
            $("#agregado_todos").live("click", function () {

                if ($("#agregado_todos").is(":checked")) {
                    $('.agregado').prop('checked', true);
                } else {
                    $('.agregado').prop('checked', false);
                }

            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>