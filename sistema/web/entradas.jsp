<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ERP</title>
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/arcade-style-frame.css" media="screen">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- JQUERY -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>       
        <!-- JQUERY -->

        <!--ARCADE JS-->

        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-excel.js"></script>
        <script type="text/javascript" src="js/arcade-sucursal.js"></script>

        <!--materialize-->
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="css/arcade-nav.css">
        <!--ARCADE JS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/arcade-region.js"></script>
        <script type="text/javascript" src="js/arcade-usuario.js"></script>


        <style>
            .row{
                margin-bottom: 0px !important;
            }
            .size_button{
                transform: scale(.8, .6);
                width: 116% !important;
            }
            .show_print{        
                display: none;
            }
            @media print {
            }
            td, th {
                border-bottom: 2px solid #000;
                border-right: .1px dotted #d0d0d0;
                text-align: left;
                padding: 3px;
            }
            td {
                width: 1px;
            }
            th {
                border-top: 2px solid #000;
            }
            .ajuste2, .ajuste1{
                border-right: 2px solid #000;
                background-color: #dddddd;
            }
            /*            tr:nth-child(even) {
                            background-color: #dddddd;
                        }
                        table {
                            border-collapse: separate;
                        }*/
            .innerb{
                overflow: auto;
                /*                width : 70em;*/
                height: 470px;
            }
            .innerc{
                overflow: auto;
                padding-bottom: 15px;
                border-bottom: 0px solid #d0d0d0;
                height: 362px;
            }
            .pruebahide{
                display: none;
            }
            .entrada{
                color: blue;
            }   
            .salida{
                color: blue;
            }   
            /*            .fixed_header tbody{
                            display:block;
                            overflow:auto;
                            height:200px;
                            width:100%;
                        }
                        .fixed_header thead{
                            display:block;
                        }*/
            /*            .ajuste1{
                           padding-left: 0px; 
                           padding-right: 0px; 
                        }
                        .ajuste2{
                           padding-: 0px; 
                           padding-right: 0px; 
                        }*/
        </style>
    </head>
    <body id="body">
        <div class="row hide">
            <nav id="ayuda_nav" class="grey lighten-1 hide_print" >
                <div class="nav-wrapper">
                    <div>
                        <a class="ayuda_name brand-logo" style="color:white;">Entradas</a>
                    </div>
                    <ul class="right"  style="margin-right:2%;">    

                        <li><input id="filtro" class="filtro  center-align grey darken-2" type="text"style="width:400px;border-radius: 4px" placeholder="Buscar"></li>
                        <li id="pdf_horas-clase-maestro" style="margin-left: 117px;"><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
                        <li id="roboto">Manuales de usuario de este modulo</li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container-fluid">
            <ul id="tabs-swipe-demo" class="tabs">
                <li class="tab col s3"><a class="active" href="#test-swipe-1" style="color:#db040e">ENTRADAS</a></li>
                <li class="tab col s3"><a href="#test-swipe-2" style="color:#db040e">REPORTE ENTRADAS</a></li>

            </ul>
            <div id="test-swipe-1" class="col s12" style="margin-top:10px;"> 
                <div class="row center-align">
                    <div class="inpunt-field col s12" style="padding:10px;border-radius: 5px;">
                        <label for="first_name" style="color:#212121;font-size:12px">FECHA</label>
                        <br>
                        <input id="fecha" type="text"class="validate datepicker center-align" style="margin: 0px auto; width: 190px;" >
                    </div>

                    <br><br>
                    <div class="col s10 offset-s1 center-align">
                        <div class="z-depth-2" id="datos_tabla" style="max-height:400px; margin: 0px auto; overflow:auto;margin-bottom:0px; border-radius:4px;"></div>
                        <br>
                        <a class="waves-effect waves-green btn green z-depth-4" id="xlsx" style="border-radius:4px;margin-right:2%; float: right;" onclick="tableToExcel('tabla_entradas', 'LISTADO DE ENTRADAS')" >XLSX</a>
                    </div>
                    <!--                <div class="col s12"  style="padding: 10px;">
                    <a class="waves-effect waves-green btn z-depth-4" id="xlsx" style=" background-color: #02723a;margin: 0px auto;  border-radius:4px;" onclick="tableToExcel('tabla_entradas', 'LISTADO DE ENTRADAS')" >XLSX</a>
                    </div>-->

                </div>
            </div>
            <div id="test-swipe-2" class="col s12" style="margin-top:10px;">
                <div class="row">
                    <div class="col s12">
                        <div class="input-field col s2" style="margin-right:10px;" >
                            <select id="id_sucursal" name="id_sucursal">
                                <option value="1">Monterrey</option>
                                <option value="2">Puebla</option>
                                <option value="0">Todos</option>
                            </select>
                            <label>SUCURSAL</label>
                        </div>
                        <div class="input-field col s2" style="margin-right:10px;" >
                            <select id="id_admin" name="id_sucursal">
                                <option value="1">Administrativo</option>
                                <option value="0">Operativo</option>
                                <option value="2">Todos</option>
                            </select>
                            <label>Area</label>
                        </div>
                        <div class="input-field col s1" >
                            <input placeholder="" id="fecha2" name="fecha2" type="text" class="validate datepicker" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;">
                            <label for="fecha2">Desde</label>
                        </div>
                        <div class="input-field col s1" >
                            <input placeholder="" id="fecha3" name="fecha3" type="text" class="validate datepicker" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;">
                            <label for="fecha3">Hasta</label>
                        </div>
                        <div class="input-field col s4">
                            <a id="enviar" class="waves-effect waves-light btn blue" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">send</i></a> 
                            <a onclick="tableToExcel('datos_tabla2', 'REPORTE ENTRADAS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a> 
                        </div>
                        <div class="row">
                            <div class="col s1 offset-s1">
                                <a id="bajar_btn" class="btn btn-large waves-effect waves-light red size_button z-depth-3 hide"><i class="material-icons">arrow_downward</i></a>
                            </div>
                            <div class="col s1">
                                <a id="regresar_btn" class="btn btn-large waves-effect waves-light red size_button z-depth-3 hide"><i class="material-icons">arrow_back</i></a>                        </div>
                            <div class="col s1 offset-s6">
                                <a id="avanzar_btn" class="btn btn-large waves-effect waves-light red size_button z-depth-3 hide"><i class="material-icons">arrow_forward</i></a>
                            </div>
                            <div class="col s1">
                                <a id="subir_btn" class="btn btn-large waves-effect waves-light red size_button z-depth-3 hide"><i class="material-icons">arrow_upward</i></a>
                            </div>
                        </div>
                        <div id="datos_tabla2" class="col s12" style="margin-top:10px;">
                        </div>
                    </div>
                </div> 

            </div>  
            <input id="hide_input" class="hide">
        </div>    

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software
            //==================================================================
            $(document).ready(function () {
                fecha_hoy("fecha");
                select_region_combo_materialize(1, "id_region", true);
                select_entrada_tabla($("#fecha").val(), "datos_tabla");
                $('select').material_select();
                document.onmousedown = function (e) {
                    if (e.which === 2) {
                        document.getElementById("datos_tabla2").onwheel = function (e) {
                            if (e.deltaY < 0) {
                                var array1 = regresar(tamaño4, tamañoCol2);
                                tamaño4 = array1[0];
                                tamañoCol2 = array1[1];
                            }
                            if (e.deltaY > 0) {
                                var array1 = avanzar(tamañoCol0, tamañoCol2, tamaño4);
                                tamañoCol2 = array1[0];
                                tamaño4 = array1[1];
                            }
                        };
                    } else {
                        document.getElementById("datos_tabla2").onwheel = function (e) {
                            if (e.deltaY < 0) {
                                var array1 = subir(tamaño5, tamañoRow2);
                                tamaño5 = array1[0];
                                tamañoRow2 = array1[1];
                            }
                            if (e.deltaY > 0) {
                                var array1 = bajar(tamañoRow0, tamañoRow2, tamaño5);
                                tamañoRow2 = array1[0];
                                tamaño5 = array1[1];
                            }
                        };
                    }
                }
                document.onkeydown = function (e) {
                    e = e || window.event;
                    if (e.keyCode == '38') {
                        var array1 = subir(tamaño5, tamañoRow2);
                        tamaño5 = array1[0];
                        tamañoRow2 = array1[1];
                    } else if (e.keyCode == '40') {
                        var array1 = bajar(tamañoRow0, tamañoRow2, tamaño5);
                        tamañoRow2 = array1[0];
                        tamaño5 = array1[1];
                    } else if (e.keyCode == '37') {
                        var array1 = regresar(tamaño4, tamañoCol2);
                        tamaño4 = array1[0];
                        tamañoCol2 = array1[1]
                    } else if (e.keyCode == '39') {
                        var array1 = avanzar(tamañoCol0, tamañoCol2, tamaño4);
                        tamañoCol2 = array1[0];
                        tamaño4 = array1[1];
                    }
                }

            });
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
            document.querySelector("#filtro").onkeyup = function () {
                $TableFilter("#tabla_entradas", this.value);
            };
            $TableFilter = function (id, value) {
                var rows = document.querySelectorAll(id + ' tbody tr');
                for (var i = 0; i < rows.length; i++) {
                    var showRow = false;
                    var row = rows[i];
                    row.style.display = 'none';
                    for (var x = 0; x < row.childElementCount; x++) {
                        if (row.children[x].textContent.toLowerCase().indexOf(value.toLowerCase().trim()) > -1) {
                            showRow = true;
                            break;
                        }
                    }

                    if (showRow) {
                        row.style.display = null;
                    }
                }
            };
            //==================================================================

            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15, // Creates a dropdown of 15 years to control year,
                today: 'Today',
                format: 'yyyy-mm-dd',
                clear: 'Clear',
                close: 'Ok',
                closeOnSelect: true // Close upon selecting a date,
            });
            //==================================================================
            $("#fecha").on("change", function () {
                select_entrada_tabla($("#fecha").val(), "datos_tabla");
            });
            //==================================================================
            //mostrar solo 10 primeras columnas y 6 filas
            var tamañoCol0 = 0;
            var tamañoCol1 = 0;
            var tamañoCol2 = 0;
            var tamañoRow0 = 0;
            var tamañoRow1 = 0;
            var tamañoRow2 = 0;
            var tamaño4 = 0;
            var tamaño5 = 0;
            $("#enviar").on("click", function () {
                select_reporte_entradas($("#id_sucursal").val(), $("#id_admin").val(), $("#fecha2").val(), $("#fecha3").val(), "datos_tabla2");
                $("#avanzar_btn").removeClass("hide");
                $("#regresar_btn").removeClass("hide");
                $("#bajar_btn").removeClass("hide");
                $("#subir_btn").removeClass("hide");
                window.setTimeout(() => {
                    tamañoCol0 = document.getElementById('entrada_tabla').rows[1].cells.length;
                    tamañoRow0 = document.getElementById('entrada_tabla').getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;
                    tamaño4 = 0;
                    tamaño5 = 0;
                    tamañoCol1 = tamañoCol0 - 10;
                    tamañoCol2 = tamañoCol0 - tamañoCol1;
                    tamañoRow1 = tamañoRow0 - 4;
                    tamañoRow2 = tamañoRow0 - tamañoRow1;
                }, 2000);
            });
            //==================================================================
            //eventos botones avanzar y regresar
            $("#avanzar_btn").live("click", function () {
                var array1 = avanzar(tamañoCol0, tamañoCol2, tamaño4);
                tamañoCol2 = array1[0];
                tamaño4 = array1[1];
            });
            $("#regresar_btn").live("click", function () {
                var array1 = regresar(tamaño4, tamañoCol2);
                tamaño4 = array1[0];
                tamañoCol2 = array1[1];
            });
            $("#bajar_btn").live("click", function () {
                var array1 = bajar(tamañoRow0, tamañoRow2, tamaño5);
                tamañoRow2 = array1[0];
                tamaño5 = array1[1];
            });
            $("#subir_btn").live("click", function () {
                var array1 = subir(tamaño5, tamañoRow2);
                tamaño5 = array1[0];
                tamañoRow2 = array1[1];
            });
            //==================================================================
            //Funciones de botones 
            function avanzar(tamañoCol0, tamañoCol2, tamaño4) {
                if (tamañoCol2 < tamañoCol0) {
                    var tamaño3 = tamañoCol2 + 1;
                    for (i = tamañoCol2; i < tamaño3; i++) {
                        $("." + i).removeClass("hide");
                    }
                    $("." + tamaño4).addClass("hide");
                    tamañoCol2 += 1;
                    tamaño4 += 1;
                }
                return [tamañoCol2, tamaño4];
            }
            function regresar(tamaño4, tamañoCol2) {
                if (10 < tamañoCol2) {
                    tamaño4 -= 1;
                    $("." + tamaño4).removeClass("hide");
                    $("." + tamañoCol2).addClass("hide");
                    tamañoCol2 -= 1;
                }
                return [tamaño4, tamañoCol2];
            }
            function bajar(tamañoRow0, tamañoRow2, tamaño5) {
                if (tamañoRow2 < tamañoRow0) {
                    var tamaño3 = tamañoRow2 + 1;
                    for (i = tamañoRow2; i < tamaño3; i++) {
                        $(".row" + i).removeClass("hide");
                    }
                    $(".row" + tamaño5).addClass("hide");
                    tamañoRow2 += 1;
                    tamaño5 += 1;
                }
                return [tamañoRow2, tamaño5];
            }
            function subir(tamaño5, tamañoRow2) {
                if (4 < tamañoRow2) {
                    $(".row" + tamaño5).removeClass("hide");
                    tamaño5 -= 1;
                    $(".row" + tamañoRow2).addClass("hide");
                    tamañoRow2 -= 1;
                }
                return [tamaño5, tamañoRow2];
            }
            // ARCADE Software
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>

