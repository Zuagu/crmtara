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
        <script type="text/javascript" src="js/arcade-blacklist.js"></script>
        <!--ARCADE JS-->
 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
    </head>
    <body style="background-image: url('images/background-cliente.png')">
 
 
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="page-title-breadcrumb option-demo">
            <div class="page-header pull-right">
                <div class="page-title">
                    Blacklist
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
        <div class="contenedor-responsive" style="max-width: 520px;">
            <br>
            <div>
                <input id="agregar_nuevo" type="button" value="AGREGAR CUENTA" style="margin-right: 3%;float: right; font-weight: bold">
                <br>
                <br>
                <div id="blacklist" class="datagrid sombra" style="max-height: 580px; overflow: auto;"></div>
            </div>
 
            <!--END CONTENT-->
 
            <!--END PAGE WRAPPER-->
        </div>
 
        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_blacklist("blacklist");
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
            $("#agregar_nuevo").click(function () {
                var _cuenta = prompt("INGRESE CUENTA:\n", "");
 
                // DESCOMENTAR ESTAS LINEAS PARA DEBUGGEAR LAS VARIABLES RECIBIDAS
//                alert($('#usuario_sistema', parent.document).val());
//                alert(_cuenta);
                if (_cuenta == "") {
                    alert("INGRESE UNA CUENTA...");
                } else {
                    update_blacklist($('#usuario_sistema', parent.document).val(), _cuenta, 1);
                }
 
            });
            //==================================================================
            $(".delete_blacklist").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    update_blacklist($('#usuario_sistema', parent.document).val(), $(this).closest("tr").attr("id"), 0);
                }
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>