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

        <script type="text/javascript" src="js/arcade-clientes.js"></script>
        <script type="text/javascript" src="js/arcade-region.js"></script>

        <style>
            table.estadistica tr:hover, table.estadistica tr td:hover, table.estadistica tr td{
                background: #FFF !important;
            }
            table.estadistica tr{
                background: #FFF !important;
            }

            .flecha {
                border: 1px solid #ccc;
                background: URL(../imagenes/arrow.png) no-repeat 298px 3px #fff !important;
                -moz-appearance: none;
                -webkit-appearance: none;
                appearance: none;
            }
        </style>

    </head>
    <body style="background-image: url('images/background-cliente.png');height: 100%;">

        <div class="contenedor-responsive"> 

            <!--BEGIN CONTENT-->
            <br>
            <div class="datagrid sombra">

                <table class="estadistica">
                    <tr>
                        <td style="width: 20%;text-align: center;border: none;"><img id="imagen_cliente" style="width: 120px;"></td>
                        <td style="width: 60%;text-align: center;border: none;font-size: 2.2rem;font-weight: bold;">
                            <br>ESTADISTICA
                            <select id="id_cliente" class="flecha" style="border: none;font-size: 2.2rem;width: 90px;font-weight: bold;text-align: center;"></select>
                            <select id="id_region" class="flecha" style="border: none;font-size: 2.2rem;width: 150px;font-weight: bold;text-align: left;"></select>
                        </td>
                        <td style="width: 20%;text-align: right;border: none;"><img src="images/logo-cliente.png" style="height: 80px;"></td>
                    </tr>
                    <tr>
                        <td style="border:none;"></td>
                        <td style="border:none;"><input id="fecha" class="datepicker" type="text" readonly="" style="border:none;text-align: center;font-size: 2.2rem;font-weight: bold;"></td>
                        <td style="border:none;"></td>
                    </tr>
                </table>

                <br>
                <div id="div_equipos" class="" style="height: 400px;margin-left: 3%;"></div>

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
                fecha_hoy("fecha");
                select_clientes_combo("id_cliente", false);
                //                select_equipo_tabla("div_equipos");
            }
            );
            //==================================================================
            $("#id_cliente").change(function () {
                select_region_combo($("#id_cliente").val(), "id_region");
                $("#imagen_cliente").attr("src", "images/id_cliente" + $("#id_cliente").val() + ".png");
            });
            //==================================================================
            // ARCADE Software®
    </script>
    <!--CORE JAVASCRIPT-->
</body>
</html>