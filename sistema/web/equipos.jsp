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
        <script type="text/javascript" src="js/arcade-equipo.js"></script>

        <style>

            .btnaction, .btnaction:hover{
                float: right;
                height: 30px;
                font-size: 1.5rem;
                padding: 0px;
                margin-right: 10px;
            }

            .equipo_gestores{
            }
            .equipo_gestores_selected{
                box-sizing: border-box;
                background: rgb(137, 222, 255) !important;
            }
        </style>

    </head>
    <body style="background-image: url('images/background-cliente.png');height: 100%;">

        <div class="contenedor-responsive">

            <!--BEGIN TITLE & BREADCRUMB PAGE-->
            <div class="page-title-breadcrumb option-demo">
                <div class="page-header pull-right">
                    <div class="page-title">
                        Equipos Cobranza
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

            <!--BEGIN CONTENT-->
            <div style="float: left;width: 64%;height: 100%;">

                <input id="id_equipo" type="hidden" value="0">

                <div style="width: 90%;float: right;padding: 10px;">
                    <input id="insert_equipo" type="button" class="boton_chido btnaction" value=" + " style="width: 30px;background: #0099FF;">
                    <input id="refresh" type="button" class="boton_chido btnaction" value=" ACTUALIZAR " style="width: 160px;background: #7844CE;">
                    <input id="reset" type="button" class="boton_chido btnaction" value=" RESETEAR GRUPO "  style="width: 160px;background: #E21C2B;">
                    <input id="deshacer" type="button" class="boton_chido btnaction" value=" DESHACER ULTIMO " style="width: 160px;background: #1F804D;">
                </div>

                <br>
                <h4 style="margin-left: 3%;">Listado de equipos</h4>
                <br>
                <div id="div_equipos" class="datagrid sombra" style="height: 382px;margin-left: 3%;overflow: auto;"></div>

            </div>

            <div class="sombra" style="cursor:pointer;float: right;width: 36%;border-left: solid 1px #dadada;height: 100%;text-align: center;background: #FFF;">

                <br>
                <h4>Gestores Disponibles</h4>
                <div class="datagrid sombra" style="border:none;"><input id="filtro" class="filtro" type="text" size="60"/></div>

                <br>
                <div id="listado_gestores" class="datagrid sombra" style="height: 195px;overflow: auto;"></div>
                <br>

                <h4>Gestores Equipo Seleccionado</h4>
                <div id="listado_gestores_equipo" class="datagrid sombra" style="height: 108px;overflow: auto;"></div>
                <br>
            </div>
            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_gestor_tabla("listado_gestores");
                select_equipo_tabla("div_equipos");
            }
            );
            //==================================================================
            $("#filtro").on("keyup",
                    function () {
                        select_gestor_tabla_filtro($('#filtro').val(), "listado_gestores");
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
            $(".equipo_gestores").live("click", function () {
                $("#id_equipo").val($(this).closest("tr").attr("id"));
                $(".equipo_gestores").removeClass("equipo_gestores_selected");
                $(this).closest("tr").addClass("equipo_gestores_selected");

                select_usuarios_equipo($("#id_equipo").val(), "listado_gestores_equipo");
            });
            //==================================================================
            $(".agregar_gestor").live("click", function () {
                if ($("#id_equipo").val() == "0") {
                    alert("SELECCONE UN EQUIPO");
                } else {
                    agregar_gestor_equipo(
                            $("#id_equipo").val(),
                            $(this).closest("tr").attr("id")
                            );
                }
            });
            //==================================================================
            $("#insert_equipo").click(function () {
                insert_equipo();
            });
            //==================================================================
            $("#deshacer").click(function () {
                if ($("#id_equipo").val() == "0") {
                    alert("SELECCONE UN EQUIPO");
                } else {
                    deshacer_equipo(
                            $("#id_equipo").val()
                            );
                }
            });
            //==================================================================
            $("#reset").click(function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    if ($("#id_equipo").val() == "0") {
                        alert("SELECCONE UN EQUIPO");
                    } else {
                        reset_equipo(
                                $("#id_equipo").val()
                                );
                    }
                }
            });
            //==================================================================
            $("#refresh").click(function () {
                select_equipo_tabla("div_equipos");
            });
            //==================================================================
            $(".delete_gestor_equipo").live("click", function () {
                delete_usuario_equipo(
                        $(this).closest("tr").attr("id"),
                        $("#id_equipo").val()
                        );
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>