<%-- 
    Document   : user-stories
    Created on : 16-mar-2018, 20:23:58
    Author     : luiscortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>

        <!--ICONS PARA MATERIALIZE-->
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--ICONS PARA MATERIALIZE-->

        <!-- INICIA JQUERTY -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>       
        <!--TERMINA JQUERTY -->

        <!--MATERIALIZE-->
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/arcade-nav.css">
        <!--MATERIALIZE-->

        <!-- HIGHCHARTS-->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script> 
        <script type="text/javascript" src="highcharts/exporting.js"></script>
        <!-- HIGHCHARTS-->

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <script type="text/javascript" src="js/arcade-story.js"></script>
        <script type="text/javascript" src="js/arcade-ticket.js"></script>
        <!--ARCADE JS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            .deshunde{
                color: #595959;
                background: #e4e4e4;
                padding: 3px 16px;
                border-radius: 25px;
                box-shadow: 0px 2px 4px #4B4949;
                transition: .2s;
            }
            .deshunde:hover{
                color: #595959;
                background: #e4e4e4;
                padding: 3px 16px;
                border-radius: 25px;
                box-shadow: 0px 2px 2px gray !important;
            }

            .ocultable{
                display: none;
            }
            .ocultable_off{
                display: block;
            }
        </style>

    </head>
    <body>
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <% 
        HttpSession sesion = request.getSession();
        
        if(sesion.getAttribute("id_usuario")!= null){
            out.write(" " + sesion.getAttribute("menu")); 
            out.write("<script> $('.button-collapse').sideNav(); </script>");
        }
        else{
            out.write("<script>location.replace('index.jsp');</script>");
        }
        
        
        
        
        
        
        %>
        <div class="container-fluid">
            <div class="row">
                <nav id="ayuda_nav" class="grey lighten-4" >
                    <div class="nav-wrapper">
                        <a id="ver_div_stories" class="deshunde" href="#" style="margin-left: 20px;">User Stories</a>
                        <a id="ver_div_nuevo_story" class="deshunde" href="#" style="margin-left: 20px;">Nuevo Story</a>
                        <a id="ver_div_mis_tickets" class="deshunde" href="#" style="margin-left: 20px;">Ver mis tickets</a>
                        <a id="ver_div_resumen_stories" class="deshunde" href="#" style="margin-left: 20px;">Resumen Departamento</a>
                        <a id="ver_div_en_proceso" class="deshunde" href="#" style="margin-left: 20px;">En proceso</a>

                        <ul class="right hide-on-med-and-down"  style="margin-right:2%;">
                            <li id="pdf_horas-clase-maestro"><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
                            <li id="roboto">Manuales de usuario de este modulo</li>
                        </ul>

                    </div>
                </nav>
            </div>

            <!--END TITLE & BREADCRUMB PAGE-->           

            <!--BEGIN CONTENT-->
            <input id="id_story" type="hidden" value="0">

            <div id="div_stories" class="ocultable row">
                <div class="col s12" style="border:1px solid #dadada;border-radius: 4px;max-height: 540px;overflow: auto;">
                    <table class="striped bordered highlight">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>STORY</td>
                                <td>DESCRIPCION</td>
                                <td>TICKETS</td>
                                <td>ESTIMADO</td>
                            </tr>
                        </thead>
                        <tbody id="tbody_stories">
                        </tbody>
                    </table>
                </div>
            </div>

            <div id="div_tickets_story" class="ocultable row">
                <div class="col s12" style="border:1px solid #dadada;border-radius: 4px;max-height: 540px;overflow: auto;">
                    <table class="striped bordered highlight">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>TICKET</td>
                                <td>DESCRIPCION</td>
                                <td>ASIGNADO:</td>
                                <td>ESTIMADO</td>
                                <td>REAL</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody id="tbody_tickets">
                        </tbody>
                    </table>
                </div>
            </div>

            <div id="div_nuevo_story" class="ocultable row">
                <div class="col s4 offset-l4" style="border:1px solid #dadada;border-radius: 4px;max-height: 540px;overflow: auto;">
                    <table class="bordered">
                        <thead>
                            <tr>
                                <td>
                                    <span style="font-weight:bold;">NUEVO STORY</span>
                                    <a id="cancel_alta_story" href="#" style="float: right;">Cancelar</a>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <label>NOMBRE CORTO DEL STORY</label>
                                    <input id="is_1" type="text" style="font-weight: bold;" class="validate letras">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>DESCRIPCION:</label>
                                    <textarea id="is_2" type="text" style="font-weight: bold;height: 100px;resize: none;" class="validate"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <a id="insert_story" href="#" class="waves-effect waves-light btn">
                                        Finalizar
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div id="div_mis_tickets" class="ocultable row">
                <div class="col s12" style="border:1px solid #dadada;border-radius: 4px;max-height: 540px;overflow: auto;">
                    <table class="striped bordered highlight">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>TICKET</td>
                                <td>DESCRIPCION</td>
                                <td>ESTIMADO</td>
                                <td>REAL</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody id="tbody_tickets_usuario">
                        </tbody>
                    </table>
                </div>
            </div>

            <div id="div_alta_ticket" class="ocultable row">
                <div class="col s4 offset-l4" style="border:1px solid #dadada;border-radius: 4px;max-height: 540px;overflow: auto;">
                    <table class="bordered">
                        <thead>
                            <tr>
                                <td>
                                    <span style="font-weight:bold;">INGRESE LOS DATOS</span>
                                    <a id="cancel_alta_ticket" href="#" style="float: right;">Cancelar</a>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <label>NOMBRE CORTO DEL TICKET:</label>
                                    <input id="it_1" type="text" style="font-weight: bold;" class="validate">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>DESCRIPCION:</label>
                                    <textarea id="it_2" type="text" style="font-weight: bold;height: 100px;resize: none;" class="validate"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>USUARIO ASIGNADO:</label>
                                    <select id="it_3" type="text" style="font-weight: bold;" class="validate"></select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>TIEMPO ESTIMADO (EN HORAS): </label>
                                    <input id="it_4" type="text" class="timepicker" style="font-weight: bold;" class="validate"></select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>CATEGORIA (FRONTEND, BACKEND, ANALISIS, EXTRA):</label>
                                    <input id="it_5" type="text" style="font-weight: bold;" class="letras validate"></select>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <a id="insert_ticket" href="#" class="waves-effect waves-light btn">
                                        Finalizar
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div id="div_resumen_stories" class="ocultable row" style="display: none;">
                <div id="div_resumen_stories2" class="col s10 offset-l1" style="max-height: 540px;overflow: auto;">
                </div>
            </div>

            <div id="div_en_proceso" class="ocultable row" style="display: none;">
                <div id="div_en_proceso2" class="col s12" style="max-height: 540px;overflow: auto;">
                    <table class="striped bordered">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>TICKET</td>
                                <td>DESCRIPCION</td>
                                <td style='text-align:center;'>ASIGNADO</td>
                                <td>ESTIMADO</td>
                                <td>REAL</td>
                                <td>ACTUAL</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody id="tbody_tickets_en_proceso">
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                $("#div_stories").show();
                select_story_tabla("tbody_stories");
                select_usuarios_desarrollo("it_3");
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    closeOnSelect: false // Close upon selecting a date,
                });
                $('.timepicker').pickatime({
                    default: 'now', // Set default time: 'now', '1:30AM', '16:30'
                    fromnow: 0, // set default time to * milliseconds from now (using with default = 'now')
                    twelvehour: false, // Use AM/PM or 24-hour format
                    donetext: 'OK', // text for done-button
                    cleartext: 'Clear', // text for clear-button
                    canceltext: 'Cancel', // Text for cancel-button
                    autoclose: false, // automatic close timepicker
                    ampmclickable: true, // make AM PM clickable
                    aftershow: function () {} //Function for after opening timepicker
                });
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
            $(".renglon").live("dblclick", function () {
                $(".ocultable").hide();
                $("#div_tickets_story").show();
                $("#id_story").val($(this).closest("tr").attr("id"));

                select_ticket_tabla($(this).closest("tr").attr("id"), "tbody_tickets");
            });
            //==================================================================
            $("#regresar_a_stories").live("click", function () {
                $(".ocultable").hide();
                $("#div_stories").show();
                select_story_tabla("tbody_stories");
            });
            //==================================================================
            $("#ver_div_stories").live("click", function () {
                select_story_tabla("tbody_stories");
            });
            //==================================================================
            $(".insert_ticket").live("click", function () {
                $(".ocultable").hide();
                $("#div_alta_ticket").show();
            });
            //==================================================================
            $("#insert_ticket").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    insert_ticket(
                            $("#it_1").val(),
                            $("#id_story").val(),
                            $("#it_2").val(),
                            $('#usuario_sistema', parent.document).val(),
                            $("#it_3").val(),
                            $("#it_4").val(),
                            $("#it_5").val()
                            );
                }
            });
            //==================================================================
            $("#insert_story").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    insert_story($('#usuario_sistema', parent.document).val(), $("#is_1").val(), $("#is_2").val());
                }
            });
            //==================================================================
            $("#cancel_alta_story").live("click", function () {
                $(".ocultable").hide();
                $("#div_stories").show();
            });
            //==================================================================
            $("#cancel_alta_ticket").live("click", function () {
                $(".ocultable").hide();
                $("#div_tickets_story").show();
            });
            //==================================================================
            $("#ver_div_mis_tickets").click(function () {
                select_tickets_usuario($('#usuario_sistema', parent.document).val(), "tbody_tickets_usuario"); // depa, abierto
            });
            //==================================================================
            $("#ver_div_resumen_stories").click(function () {
                select_resumen_tickets_usuario("div_resumen_stories2"); // depa, abierto
            });
            //==================================================================
            $("#ver_div_en_proceso").click(function () {
                select_tickets_en_proceso("tbody_tickets_en_proceso"); // depa, abierto
            });
            //==================================================================
            $(".update_tiempos").live("click", function () {
                update_tiempos_tickets($(this).closest("tr").attr("id"));
            });
            //==================================================================
            $(".deshunde").live("click", function () {
                $(".ocultable").hide();
                var _x = $(this).attr("id");
                _x = _x.replace("ver_", "");
                $("#" + _x).show();
            });
            //==================================================================
			
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>