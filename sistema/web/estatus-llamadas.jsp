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

        <script type="text/javascript" src="js/arcade-estatus-llamada.js"></script>

    </head>
    <body>

        <div class="contenedor-responsive" style="max-width:420px;text-align: center;">
            <!--BEGIN CONTENT-->
            <br>
            <h2>Estatus de llamada</h2>
            <h5>Aquí puede personalizar los estatus<br> para los resultados de las llamadas</h5>

            <br>
            <div id="listado_estatus_llamadas" class="datagrid sombra" style="height:400px;overflow:auto;"></div>
            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_estatus_llamada_tabla("listado_estatus_llamadas");
            }
            );
            //==================================================================
            $("#insert_estatus_llamada").live("click", function () {
                insert_estatus_llamada(
                        $("#estatus_llamada_insert").val(),
                        $("#descripcion_insert").val(),
                        "listado_estatus_llamadas"
                        );
            });
            //==================================================================
            $(".delete_estatus_llamada").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_estatus_llamada(
                            $(this).closest("tr").attr("id"),
                            "listado_estatus_llamadas"
                            );
                }
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>