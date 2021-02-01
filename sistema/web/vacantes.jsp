<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>

        <!---cambio--->
        <!--ICONS PARA MATERIALIZE-->
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/arcade-style-frame.css" media="screen">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--ICONS PARA MATERIALIZE-->

        <!--ARCADE CSS-->
        <!--        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
                <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">
       
                <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
                <link type="text/css" rel="stylesheet" href="styles/all.css">
                <link type="text/css" rel="stylesheet" href="styles/main.css">-->
        <!--ARCADE CSS-->

        <!-- INICIA CALENDARIO -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>  
        <!--        <script type="text/javascript" src="path_to/jquery.leanModal.min.js"></script>-->
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>
        <!--    <script>
                    $(function () {
                        $(".datepicker").datepicker({changeMonth: true, changeYear: true, numberOfMonths: 1});
                    });
                </script>-->
        <!--TERMINA CALENDARIO -->

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <!--ARCADE JS-->

        <!--MATERIALIZE-->
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/arcade-nav.css">
        <!--MATERIALIZE-->

        <!--HIGHCHARTS-->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script>
        <script type="text/javascript" src="highcharts/exporting.js"></script>    
        <!--HIGHCHARTS-->


        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/arcade-puesto.js"></script>
        <script type="text/javascript" src="js/arcade-vacante.js"></script>
        <script type="text/javascript" src="js/arcade-usuario.js"></script>

        <style>

            /*             label color
                        .input-field label {
                            color: #000;
                        }
                         label focus color
                        .input-field input[type=text]:focus + label {
                            color: #000;
                        }
                         label underline focus color
                        .input-field input[type=text]:focus {
                            border-bottom: 1px solid #000;
                            box-shadow: 0 1px 0 0 #000;
                        }
                         valid color
                        .input-field input[type=text].valid {
                            border-bottom: 1px solid #000;
                            box-shadow: 0 1px 0 0 #000;
                        }
                         invalid color
                        .input-field input[type=text].invalid {
                            border-bottom: 1px solid #000;
                            box-shadow: 0 1px 0 0 #000;
                        }
                         icon prefix focus color
                        .input-field .prefix.active {
                            color: #000;
                            }
            */
            td{
                padding: 4px 16px;
            }
            th{
                padding: 4px 16px;
            }
            #eliminar{
                font-size: 1.2rem !important;
                color: #ABABAB !important;
                text-decoration: none !important;
                transition: .8s !important;
            }
            #eliminar:hover{
                font-size: 1.2rem !important;
                color: #FE5D49 !important;
                text-decoration: none !important;
            }
            #regresar{
                font-size: 1.2rem !important;
                color: #ABABAB !important;
                text-decoration: none !important;
                transition: .8s !important;
            }
            #regresar:hover{
                font-size: 1.2rem !important;
                color: #FE5D49 !important;
                text-decoration: none !important;
            }
            .innerb{
                overflow: auto;
                height : 29em;
            }
            .innerc{
                overflow: auto;
                height : 12em;
            }
            .innerd{
                overflow: auto;
                height : 25em;
            }
            .size_button{
                transform: scale(.8, .8);
                width: 150px;
            }
            .size_button3{
                transform: scale(.8, .8);
                margin: 6px !important;
            }
            .size_button2{
                transform: scale(.7, .7);
                width: 80px;
            }
            .tam{
                transform: scale(.9, .9);
                width: 300px;
            }
            .tam2{
                width: 80%;
                max-height: 100%;
                transform: scale(1) !important;
                height: 76%;
            }
            .tam3{
                /*                transform: scale(.1, .1);*/
                width: 50%;
            }
            .tam4{
                /*                transform: scale(.1, .1);*/
                width: 35%;
            }
            /*            .modal_height { height: 750px !important ; }*/
        </style>
    </head>
    <body class="grey lighten-3">
        <input id="id_usuario_to_asign" type="hidden" value="0">
        <input id="id_usuario_to_reasign" type="hidden" value="0">
        <!--BEGIN TITLE & BREADCRUMB PAGE-- nav-->
        <div class="container-fluid">
            <div class="row">
                <nav id="ayuda_nav" class="grey lighten-4" >
                    <div class="nav-wrapper">
                        <a class="ayuda_name" class="brand-logo ">Vacantes</a>
                        <ul class="right hide-on-med-and-down"  style="margin-right:12%;">
                            <li><input id="filtro_nav" class="filtro  center-align grey darken-2" type="text"style="width:400px;border-radius: 4px;margin-right: 50px;" placeholder="Buscar"></li>
                            <li id="pdf_horas-clase-maestro"><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
                            <li id="roboto">Manuales de usuario de este modulo</li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->           
            <!--http://materializecss.com/ Guia Materialize-->              
            <!--BEGIN CONTENT-->
            <!-- row linea si solo ocupas un div con la mitad o menos del tamaño pon un row siguiente y salta a la siguiente-->
            <!--Recuerda que la pantalla se divide en 12 dependiendo del col s que uses 12 como 100% -->
            <div class="row">
                <div class="col s10 offset-s1 z-depth-2" id="listado_puestos">
                </div>
                <input id="id_puesto" type="hidden" value="">
                <div class="input-field"><input id="id_vacante" type="hidden" value="" readonly style="text-align: center;"></div>
                <div class="col s10 offset-s1 z-depth-2 hide" id="list" >
                    <div id="listado_vacantes">
                    </div>
                </div>
            </div>
            <!----------------------------------------------Inicio Modales--------------------------------->
            <div id="modal1" class="modal tam2">
                <div class="modal-content modal_height">
                    <h5 id="modal_text" class="center-align"></h5>
                    <div id="puestos_modal" class="innerd">
                    </div>
                    <input id="hide_input" type="hidden" value="">
                    <input id="hide_input2" type="hidden" value="">
                    <div class="modal-footer">                  
                        <a id="cerrar_puesto" class="waves-effect waves-light btn blue left-align size_button3">Cerrar</a>
                        <a id="reasignar_puesto" class="waves-effect waves-light btn orange left-align size_button3">Reasignar Vacante</a>
                        <a id="eliminar_puesto" class="waves-effect waves-light btn red size_button3">Eliminar Vacante</a>  
                        <a id="agregar_puesto" class="waves-effect waves-light btn green size_button3">Nuevo Puesto</a>
                    </div>
                </div>
            </div>
            <div id="modal2" class="modal tam">
                <div class="modal-content">
                    <h6 class="center-align">Seguro que desea eliminar a</h6>
                    <h6 id="vacante_nombre" class="center-align"></h6>
                    <div class="row">
                        <div class="col s4 offset-s2">
                            <a id="cancelar_eliminacion" class="waves-effect waves-light btn red size_button2">NO</a>
                        </div>
                        <div class="col s4">
                            <a id="si_eliminar" class="waves-effect waves-light btn green size_button2">Si</a>
                        </div>
                    </div>    
                </div>
            </div>
            <div id="modal3" class="modal tam3">
                <div class="modal-content">
                    <h6>Nombre Puesto</h6>
                    <input id="input_crear" type="text" value="">
                    <div class="modal-footer">
                        <a id="cancelar_puesto" class="waves-effect waves-light btn red size_button">Cancelar</a>  
                        <a id="confirmar_puesto" class="waves-effect waves-light btn green size_button">Crear</a>
                    </div>
                </div>
            </div>
            <div id="modal4" class="modal tam3">
                <div class="modal-content">
                    <input id="filtro" class="validate" type="text" size="60" placeholder="Escribe el nombre del Usuario" style="margin-bottom:10px;" >
                    <div class="innerc z-depth-1" id="id_usuario">

                    </div>
                    <div class="modal-footer">
                        <a id="cancelar_actualizacion" class="waves-effect waves-light btn red size_button">Cancelar</a>  
                        <a id="udpate_id_usuario_vacante" class="waves-effect waves-light btn green size_button">Asignar</a>
                    </div>
                </div>
            </div>
            <div id="modal5" class="modal tam3">
                <div class="modal-content">
                    <div class='center-align'>
                        <p>Vacante Asignada Correctamente</p>
                        <p>Desea Asignar el Horario?</p>
                    </div>
                    <div class='row'> 
                        <div class='col s3'><a id="cancelar_horario" class="waves-effect waves-light btn red size_button3">Regresar</a></div>
                        <div class='col s4 offset-s2'><a id="horario_admin" href="/sistema/horarios-administracion.jsp?" class="waves-effect waves-light btn green size_button3">Administrativo</a></div>
                        <div class='col s3'><a id="horario_op" href="/sistema/horarios-operacion.jsp?" class="waves-effect waves-light btn blue size_button3">Operativo</a></div>     
                    </div>
                </div>
            </div>    
            <div id="modal6" class="modal tam3">
                <div class="modal-content">
                    <div class='center-align'>
                        <p>Usuario a quien se reasignara al siguiente puesto:</p>
                        <p id="puesto_reasig"></p>
                        <div class="row">
                            <div class="input-field col s10 offset-s1">
                                <input placeholder="Id" id="reasig_id" type="text" class="validate">
                                <label for="first_name">Numero Usuario</label>
                                <div id="usuario_reasig" class="innerc z-depth-1">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class='row'> 
                        <div class='col s3 offset-s2'><a id="cancel_reasig" class="waves-effect waves-light btn red size_button3">Cancelar</a></div>     
                        <div class='col s3 offset-s2'><a id="confirm_reasig" class="waves-effect waves-light btn green size_button3">Confirmar</a></div>     
                    </div>
                </div>
            </div>    
            <!------------------------------------------------------ fin de los modales-------------------------------------------->
            <!--END CONTENT-->
            <input id="nom_vac" type="hidden" value="">
            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_puesto_tabla("listado_puestos");
                select_inactivos_tabla_filtro("", "id_usuario");
                select_activos_tabla_filtro("", "usuario_reasig");
                $('select').material_select();
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    closeOnSelect: false // Close upon selecting a date,
                });
                $('.modal').modal({
                    dismissible: false, // Modal can be dismissed by clicking outside of the modal
                    opacity: .5, // Opacity of modal background
                    inDuration: 300, // Transition in duration
                    outDuration: 200, // Transition out duration
                    startingTop: '4%', // Starting top style attribute
                    endingTop: '10%' // Ending top style attribute
                });
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
            //modal 1 puestos asig borrar o crear
            $(".select_menu_puesto").live("click", function () {
                $('#modal1').modal('open');
                var _id_puesto = $(this).closest("tr").attr("id");
                $("#id_puesto").val(_id_puesto);
                select_vacante_tabla(_id_puesto, "puestos_modal");
                $("#hide_input2").val("");
                $("#hide_input").val("");
                $("#id_vacante").val("");
            });
            //==================================================================
            //eliminar vacante modal 2
            $("#eliminar_puesto").on("click", () => {
                $('#modal2').modal('open');
                $('#vacante_nombre').text($("#hide_input2").val() + " del puesto?");
            });
            $("#si_eliminar").on("click", () => {
                delete_vacante($("#hide_input").val(), $("#id_puesto").val(), "listado_vacantes");
                $("#modal2").modal('close');
                select_vacante_tabla($("#id_puesto").val(), "puestos_modal");
                select_puesto_tabla("listado_puestos");
//                window.setTimeout(() => {
//                $("#modal1").leanModal();
//            },1000);
            });
            //==================================================================
            //crear nuevo puesto modal 3 
            $("#agregar_puesto").on("click", () => {
                $('#modal3').modal('open');
            });
            $("#confirmar_puesto").on("click", () => {
                insert_vacante($("#input_crear").val(), $("#id_puesto").val(), "listado_vacantes");
                $("#modal3").modal('close');
                select_vacante_tabla($("#id_puesto").val(), "puestos_modal");
                select_puesto_tabla("listado_puestos");
                window.setTimeout(() => {
                    $("#input_crear").val("");
                }, 200);
            });
            //==================================================================
            //actualizar vacante modal 4
            $(".vacante_tr").live("dblclick", () => {
                $('#modal4').modal('open');
                $("#id_usuario_to_asign").val("");
            });
            $("#udpate_id_usuario_vacante").click(function () {
                var hideInput = $("#hide_input2").val();
                if (hideInput === "") {
                    udpate_id_usuario_vacante(
                            $("#id_vacante").val(),
                            $("#id_usuario_to_asign").val(),
                            0.00,
                            $("#id_puesto").val(),
                            "listado_vacantes"
                            );
                    $('#modal5').modal('open');
                } else {
                    alert("Eliminar Usuario antes de Asignar uno Nuevo");
                }
                select_vacante_tabla($("#id_puesto").val(), "puestos_modal");
                select_puesto_tabla("listado_puestos");
                $('#modal4').modal('close');
            });
            //filtro
            $("#filtro").on("keyup",
                    function () {
                        select_inactivos_tabla_filtro($('#filtro').val(), "id_usuario");
                    }
            );
            //dato para actualizar
            $(".agregar_gestor").live("click", function () {
                $("#id_usuario_to_asign").val($(this).closest("tr").attr("id"));
            });
            //==================================================================
            //reasignar nuevo puesto modal 6 
            $("#reasignar_puesto").on("click", () => {
                $('#modal6').modal('open');
                $("#puesto_reasig").text($("#nom_vac").val());
            });
            $("#confirm_reasig").on("click", () => {
                var hideInput = $("#hide_input2").val();
                if (hideInput === "") {
                    reasignar_vacante($("#id_puesto").val(), $("#id_vacante").val(), $("#id_usuario_to_reasign").val());
                    $("#nom_vac").text("");
                    $("#reasig_id").val("");
                    $("#modal6").modal('close');
                    select_vacante_tabla($("#id_puesto").val(), "puestos_modal");
                    select_activos_tabla_filtro("", "usuario_reasig");
                } else {
                    alert("Esta vacante ya contiene un Usuario");
                }
            });
            //filtro
            $("#reasig_id").on("keyup", function () {
                select_activos_tabla_filtro($('#reasig_id').val(), "usuario_reasig");
            });
            //dato para actualizar
            $(".reasignar_gestor").live("click", function () {
                $("#id_usuario_to_reasign").val($(this).closest("tr").attr("id"));
            });
            $("#cancel_reasig").on("click", () => {
                $("#nom_vac").text("");
                $("#reasig_id").val("");
                $("#modal6").modal('close');
            });
            //==================================================================
            //datos para modificaciones modal
            $(".vacante_tr").live("click", function () {
                $("#hide_input2").val($(this).find(".get_usuarioName").html());
                $("#hide_input").val($(this).closest("tr").attr("id"));
                $("#id_vacante").val($(this).closest("tr").attr("id"));
                $("#nom_vac").val($(this).find(".get_id_vacante").html());
            });
            //==================================================================
            //cancels cerrar modales
            $("#cerrar_puesto").on("click", function () {
                $('#modal1').modal('close');
                $("#hide_input2").val("");
                $("#hide_input").val("");
                $("#id_vacante").val("");
                $("#id_usuario_to_asign").val("");
                select_puesto_tabla("listado_puestos");
            });
            $("#cancelar_eliminacion").on("click", function () {
                $('#modal2').modal('close');
                $("#hide_input").val("");
            });
            $("#cancelar_puesto").on("click", function () {
                $('#modal3').modal('close');
                $("#input_crear").val("");
            });
            $("#cancelar_actualizacion").on("click", function () {
                $('#modal4').modal('close');
                $("#id_usuario_to_asign").val("");
            });
            $("#cancelar_horario").on("click", function () {
                $('#modal5').modal('close');
            });
//            $("#contrato").on("click", function () {
////                var id_usu = $("#id_usuario_to_asign").val();
//////                location.href="/sistema/usuarios.jsp?"+ id_usu, "_blank"; 
////                 window.open("/sistema/usuarios.jsp?"+ id_usu, "_blank");
////                console.log(id_usu);
//            });
            //==================================================================
            $("#horario_admin").on("click", function () {
                update_cargo($("#id_usuario_to_asign").val(), 1);
            });
            $("#horario_op").on("click", () => {
                update_cargo($("#id_usuario_to_asign").val(), 0);
            });
            //==================================================================
            document.querySelector("#filtro_nav").onkeyup = function () {
                $TableFilter("#tabla_puestos", this.value);
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
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>