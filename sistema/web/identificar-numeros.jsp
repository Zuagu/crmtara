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

        <style>
            h3{
                color: #FFFFFF;
                background: #001840;
                padding: 15px;
                margin-top: 0px;
                font-size: 3rem;
            }
            h4{
                /*color: #FFFFFF;*/
                font-size: 1.7rem;
                padding: 10px;

            }
            span{
                color: #666666;
                font-size: 1.7rem;
            }
            img{
                width: 100%;
            }
            #datos_cliente{
                width: 94%;
                margin: 0px auto;
            }
            #datos_cliente tbody tr td input{
                width: 100%;
                border-radius: 5px;
                border: solid 1px #d5cccc;
                padding: 6px;
                color: #484848;
            }
            #datos_cliente tbody tr td{
                text-align: right;
                color: #5A5A5A;
            }
        </style>


    </head>
    <body style="background-image: url('images/background-cliente.png')">

        <div style="background: #001840;">
            <div style="margin: 0px auto;max-width: 920px;">
                <img id="imprimir" src="images/logo_arcade2018-b-p.png" style="width: 180px;float: right;margin-top: 6px;">
                <h3 id="titulo-ayuda" style="text-align: left;">Identificador de Números</h3>
            </div>
        </div>

        <div style="width: 100%;">

            <div style="padding: 20px 40px;color: #9CB8C3;text-align: center;">
                <h4>
                    Con esta herramienta, podrás identificar el tipo de número que marcarás.<br>
                    Sólo necesitas agregar los numeros, sin encabezados.
                </h4>
                <img src="images/e_joy-128.png" alt="" style="width: 32px;"><br>
            </div>

            <div>
                <form action="subir-identificacion.jsp" enctype="multipart/form-data" method="post" style="margin: 0px auto;width: 100%;max-width: 320px;text-align: center;">
                    <input type="file" class="sombra" name="file" style="margin: 0px auto;background: #F0FFFF;border: solid 1px #DADADA;padding: 12px;"/><br>
                    <input class="sombra" type="submit" value="CARGAR ARCHIVO" style="width: 140px;"/><br>

                </form>
            </div>

        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
            }
            );
            //==================================================================
            $(".help").on("click", function () {
                var src = location.href;
                var jsp;
                src = src.replace('/sistema/', '');
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
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>