<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>


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

        <!-- HIGHCHARTS-->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script> 
        <script type="text/javascript" src="highcharts/exporting.js"></script>
        <!-- HIGHCHARTS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/arcade-updateCore.js"></script>

        <style>
            .size_button{
                transform: scale(.8, .8);
                width: 150px;
            }
            .size_button2{
                transform: scale(.7, .7);
                width: 80px;
            }
            .size_button3{
                transform: scale(.6, .6);
            }
            .tam{
                transform: scale(.9, .9);
                width: 300px;
            }
            .pointer{
                cursor: pointer;
            }
            #note {
                position: absolute;
                z-index: 101;
                top: 0;
                left: 0;
                right: 0;
                background: #76ff03;
                text-align: center;
                line-height: 2.5;
                overflow: hidden; 
                -webkit-box-shadow: 0 0 5px black;
                -moz-box-shadow:    0 0 5px black;
                box-shadow:         0 0 5px black;
            }
            #note2 {
                position: absolute;
                z-index: 101;
                top: 0;
                left: 0;
                right: 0;
                background: #f44336;
                text-align: center;
                line-height: 2.5;
                overflow: hidden; 
                -webkit-box-shadow: 0 0 5px black;
                -moz-box-shadow:    0 0 5px black;
                box-shadow:         0 0 5px black;
            }
            .colorSel:hover {
                background-color: green;
            }
            /*agregado por emmanuel*/

            .picker__holder {
                overflow: visible!important;
            }
            #modal1{
                overflow: visible!important; 
            }
            #modal11{
                overflow: visible!important; 
            }
            #modal12{
                overflow: visible!important; 
            }
            .show {
                display: none;
            }
            .colorBack:hover { 
                background-color: #bbdefb;
            }
        </style>
    </head>
    <body style="overflow: scroll" class="grey lighten-5">
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div id="note" class="hide">
            Actualizacion exitosa
        </div>
        <div id="note2" class="hide">
            Datos Eliminados
        </div>
        <div class="container-fluid grey lighten-5">
            <div class="row">
                <nav id="ayuda_nav" class="grey lighten-1" >
                    <div class="nav-wrapper">
                        <div class="col s3 offset-s1">
                            <a class="ayuda_name brand-logo" style="color:white;">Cambios de Datos</a>
                        </div>
                        <div class="col s4">   
                            <li style="list-style: none;" class='center-align'><input id="buscar_cuenta" class="center-align grey darken-2" type="text"style="width:400px;border-radius: 4px" placeholder="Buscar"></li>
                        </div>
                        <div class="col s1" style="padding-bottom: 10px;" >
                            <a href="#" class="center-align"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a>
                        </div>
                        <div class="col s3">
                            <li id="roboto" style="list-style: none;">Manuales de usuario de este modulo</li>
                        </div>
                    </div>
                </nav>
            </div>
            <!----------------------------INPUTS FIJOS Y HERMOSOS-------------------------------->
            <div class="row">
                <div class="input-field col s4 offset-s1">
                    <input value="" id="dato1" type="text" readonly="readonly" class="validate" placeholder="Cuenta">
                    <label>Cuenta</label>
                </div>
                <div class="input-field col s4 offset-s2">
                    <input id="dato2" type="text" readonly="readonly" class="validate" placeholder="Expediente">
                    <label>Expediente</label>
                </div>
            </div>
            <!--------------------------TABS DESPLEGABLES INICIO----------------------------------->
            <div class="row" id="body_render">
                <div class="col s10 offset-s1">
                    <ul class="collapsible popout" data-collapsible="accordion">
                        <li>
                            <div class="collapsible-header z-depth-3"><i class="material-icons">account_box</i>Datos del Cliente</div>
                            <div id="dato_cliente" class="collapsible-body">
                                <div class="row">
                                    <div class="input-field col s3 offset-s1">
                                        <input id="dato3" type="text" class="validate" placeholder="Nombre">
                                        <label>Nombre</label>
                                    </div>
                                    <div class="input-field col s2 offset-s1">
                                        <input id="dato4" type="text" class="validate" placeholder="Asignacion">
                                        <label>Asignacion</label>
                                    </div>
                                    <div class="input-field col s3 offset-s1">
                                        <input value="" id="dato5" type="text" class="validate" placeholder="Plan">
                                        <label>Plan</label>
                                    </div>   
                                </div>
                                <div class="row">
                                    <div class="input-field col s3 offset-s1">
                                        <input value="" id="dato6" type="text" class="validate" placeholder="Ciudad">
                                        <label>Ciudad</label>
                                    </div>
                                    <div class="input-field col s2 offset-s1">
                                        <input value="" id="dato10" type="text" class="validate center-align" placeholder="C.P.">
                                        <label>Numero</label>
                                    </div>
                                    <div class="input-field col s3 offset-s1">
                                        <input value="" id="dato7" type="text" class="validate" placeholder="Colonia">
                                        <label>C.P.</label>
                                    </div>   
                                </div>
                                <div class="row">
                                    <div class="input-field col s4 offset-s1">
                                        <input value="" id="dato9" type="text" class="validate" placeholder="Calle">
                                        <label>Calle</label>
                                    </div> 
                                    <div class="input-field col s4 offset-s2">
                                        <input value="" id="dato8" type="text" class="validate" placeholder="Numero">
                                        <label>Colonia</label>
                                    </div> 
                                </div> 
                                <div class="row"> 
                                    <div class="col s1 offset-s10">
                                        <a id="actualizar_cliente" class="waves-effect waves-light btn red size_button">Actualizar</a>
                                    </div>
                                </div> 
                            </div>
                        </li>
                        <li>
                            <div class="collapsible-header z-depth-3"><i class="material-icons">contact_phone</i>Telefonos</div>
                            <div id="dato_tel" class="collapsible-body">

                                <div class="row">
                                    <div class="col s10 offset-s1 z-depth-2 center-align grey lighten-1">
                                        TITULARES
                                    </div> 
                                    <div id="dato_telefono3" class="col s10 offset-s1 z-depth-2"></div>    
                                </div>
                                <div class="row">
                                    <div class="col s10 offset-s1 z-depth-2 center-align grey lighten-1">
                                        RELACIONADAS
                                    </div>
                                    <div id="dato_telefono2" class="col s10 offset-s1 z-depth-2"></div>
                                </div>
                                <div class="row">
                                    <div class="col s10 offset-s1 z-depth-2 center-align grey lighten-1">
                                        REFERENCIAS
                                    </div> 
                                    <div id="dato_telefono" class="col s10 offset-s1 z-depth-2"></div>    
                                </div>
                                <div class="row"> 
                                    <div class="col s10 offset-s1 right-align">
                                        <a id="eliminar_tel" class="waves-effect waves-light btn red size_button right-align" >Eliminar</a>
                                    </div>
                                </div> 
                            </div>
                        </li>
                        <li>
                            <div class="collapsible-header z-depth-3" id="tab_convenio"><i class="material-icons">message</i>Convenios</div>
                            <div id="dato_convenio" class="collapsible-body"><span></span></div>
                        </li>
                        <li>
                            <div class="collapsible-header z-depth-3"><i class="material-icons">monetization_on</i>Pagos</div>
                            <div id="dato_pago" class="collapsible-body"></div>                         
                        </li>
                        <li>
                            <div class="collapsible-header z-depth-3"><i class="material-icons">contacts</i>Gestiones</div>
                            <div id="dato_gestion" class="collapsible-body"></div>                         
                        </li>
                    </ul>                 
                </div>
                </form>
            </div>
            <!------------------------------- INICIO DE LOS MODALES----------------------------------->
            <div id="modal1" class="modal">
                <div class="modal-content">
                    <h4 class="center-align">Actualizar Convenio</h4>
                    <div class="row">
                        <input id="id_convenio_input" type="hidden">
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="convenio_input" type="text" class="validate" value=''>
                            <label for="first_name">Convenio</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="gestor_input" type="text" class="validate">
                            <label for="first_name">Id_gestor</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="fecha_input" type="text" class="validate datepicker">
                            <label for="first_name">Fecha convenio</label>
                        </div>
                    </div>
					<div class="row">
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="aplica_input" type="text" class="validate">
                            <label for="first_name">Aplica</label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a id="cancelar_convenio" class="waves-effect waves-light btn red size_button">Cancelar</a>  
                        <a id="actualizar_convenio" class="waves-effect waves-light btn green size_button">Actualizar</a>
                    </div>
                </div>
            </div>

            <div id="modal2" class="modal">
                <div class="modal-content">
                    <h5 class="center-align">Actualizar Referencia</h5>
                    <div class="row">
                        <input id="id_tel_input" type="hidden">
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="numero_input" type="text" class="validate" value=''>
                            <label for="first_name">Numero</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="nombre_input" type="text" class="validate">
                            <label for="first_name">Nombre</label>
                        </div>
                        <input placeholder="" id="tipo_tel_input" type="hidden" class="validate">                          
                    </div>
                    <div class="modal-footer">
                        <a id="cancelar_referencia" class="waves-effect waves-light btn red size_button">Cancelar</a>  
                        <a id="actualizar_referencia" class="waves-effect waves-light btn green size_button">Actualizar</a>
                    </div>
                </div>
            </div>

            <div id="modal3" class="modal">
                <div class="modal-content">
                    <h5 class="center-align">Actualizar Relacionadas</h5>
                    <div class="row">
                        <input id="id_tel_input" type="hidden">
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="numero_input2" type="text" class="validate" value=''>
                            <label for="first_name">Numero</label>
                        </div>
                        <input placeholder="" id="tipo_tel_input2" type="hidden" class="validate">
                    </div>
                    <div class="modal-footer">
                        <a id="cancelar_relacionada" class="waves-effect waves-light btn red size_button">Cancelar</a>  
                        <a id="actualizar_relacionada" class="waves-effect waves-light btn green size_button">Actualizar</a>
                    </div>
                </div>
            </div>
            <div id="modal10" class="modal">
                <div class="modal-content">
                    <h5 class="center-align">Actualizar Titulares</h5>
                    <div class="row">
                        <!--                        <input id="id_tel_input" type="hidden">-->
                        <div class="input-field col s10 offset-s1">
                            <input placeholder="" id="numero_input3" type="text" class="validate" value=''>
                            <label for="first_name">Numero</label>
                        </div>
                        <input placeholder="" id="tipo_tel_input2" type="hidden" class="validate">
                    </div>
                    <div class="modal-footer">
                        <a id="cancelar_titular" class="waves-effect waves-light btn red size_button">Cancelar</a>  
                        <a id="actualizar_titular" class="waves-effect waves-light btn green size_button">Actualizar</a>
                    </div>
                </div>
            </div>
            <div id="modal11" class="modal tam">
                <div class="modal-content">
                    <h5 class="center-align">Actualizar Estatus</h5>
                    <div class="row">
                        <div class="input-field col s12">
                            <select id="select_estatus">
                                <option  value="" disabled selected>Seleccionar un Estatus</option>
                                <option  class="subestatus_gestor" value="1">SIN TOCAR</option>
                                <option  class="subestatus_gestor" value="2">NC</option>
                                <option  class="subestatus_gestor" value="3">TS</option>
                                <option  class="subestatus_gestor" value="4">TNE</option>
                                <option  class="subestatus_gestor" value="5">MB</option>
                                <option  class="subestatus_gestor" value="6">DM1</option>
                                <option  class="subestatus_gestor" value="7">DM2</option>
                                <option  class="subestatus_gestor" value="8">DM3</option>
                                <option  class="subestatus_gestor" value="9">DM4</option>
                                <option  class="subestatus_gestor" value="10">PR</option>
                                <option  class="subestatus_gestor" value="11">PI</option>
                                <option  class="subestatus_gestor" value="12">NEG</option>
                                <option  class="subestatus_gestor" value="13">NP</option>
                                <option  class="subestatus_gestor" value="14">PP</option>
                                <option  class="subestatus_gestor" value="15">PRE</option>
                                <option  class="subestatus_gestor" value="16">PT</option>
                                <option  class="subestatus_gestor" value="17">AC</option>
                                <option  class="subestatus_gestor" value="18">CL</option>
                                <option  class="subestatus_gestor" value="19">REA</option>
                                <option  class="subestatus_gestor" value="20">BH</option>
                                <option  class="subestatus_gestor" value="21">FI</option>
                                <option  class="subestatus_gestor" value="32">206</option>
                            </select>
                            <label>Materialize Select</label>
                        </div>
                    </div>
                    <input placeholder="" class="id_gestor" type="hidden" class="validate">
                    <input placeholder="" class="num_gestor" type="hidden" class="validate">
                </div>
                <div class="row">
                    <div class="col s4 offset-s1">
                        <a id="cancelar_gestion" class="waves-effect waves-light btn red size_button3">cancelar</a>
                    </div>
                    <div class="col s4">
                        <a id="actualizar_gestion" class="waves-effect waves-light btn green size_button3">Actualizar</a>
                    </div>
                </div>
            </div>
            <div id="modal12" class="modal tam">
                <div class="modal-content">
                    <h5 class="center-align">Actualizar Subestatus</h5>
                    <div class="row">
                        <div class="input-field col s12">
                            <select id="select_subestatus">
                                <option  value="" disabled selected>Seleccionar un Subestatus</option>
                                <option  class="subestatus_gestor" value="1">1A</option>
                                <option  class="subestatus_gestor" value="2">3D</option>
                                <option  class="subestatus_gestor" value="3">3A</option>
                                <option  class="subestatus_gestor" value="4">3B</option>
                                <option  class="subestatus_gestor" value="5">3E</option>
                                <option  class="subestatus_gestor" value="6">2A</option>
                                <option  class="subestatus_gestor" value="7">1B</option>
                                <option  class="subestatus_gestor" value="8">1C</option>
                                <option  class="subestatus_gestor" value="9">1D</option>
                                <option  class="subestatus_gestor" value="10">3C</option>
                                <option  class="subestatus_gestor" value="11">4A</option>
                                <option  class="subestatus_gestor" value="12">4B</option>
                                <option  class="subestatus_gestor" value="13">4C</option>
                                <option  class="subestatus_gestor" value="14">4D</option>
                                <option  class="subestatus_gestor" value="15">4F</option>
                                <option  class="subestatus_gestor" value="16">4G</option>
                                <option  class="subestatus_gestor" value="17">4E</option>
                                <option  class="subestatus_gestor" value="18">4H</option>
                                <option  class="subestatus_gestor" value="19">4J</option>
                                <option  class="subestatus_gestor" value="20">2B</option>
                                <option  class="subestatus_gestor" value="21">3F</option>
                            </select>
                            <label>Materialize Select</label>
                        </div>
                    </div>
                    <input placeholder="" class="id_gestor" type="hidden" class="validate">
                    <input placeholder="" class="num_gestor" type="hidden" class="validate">
                </div>
                <div class="row">
                    <div class="col s4 offset-s1">
                        <a id="cancelar_subgestion" class="waves-effect waves-light btn red size_button3">cancelar</a>
                    </div>
                    <div class="col s4">
                        <a id="actualizar_subgestion" class="waves-effect waves-light btn green size_button3">Actualizar</a>
                    </div>
                </div>
            </div>


            <div id="modal4" class="modal tam">
                <div class="modal-content">
                    <h6 class="center-align">Seguro que desea eliminar el pago con este ID_PAGO?</h6>
                    <h6 id="pago_input" class="center-align"></h6>
                    <div class="row">
                        <div class="col s4 offset-s2">
                            <a id="cancelar_pago" class="waves-effect waves-light btn red size_button2">NO</a>
                        </div>
                        <div class="col s4">
                            <a id="eliminar_pago" class="waves-effect waves-light btn green size_button2">Si</a>
                        </div>
                    </div>    
                </div>
            </div>
            <div id="modal5" class="modal tam">
                <div class="modal-content">
                    <h6 class="center-align">Seguro que desea eliminar la referencia con el siguiente numero?</h6>
                    <h6 id="referencia_input" class="center-align"></h6>
                    <input id="referencia_input2" class="center-align" type="hidden">
                    <div class="row">
                        <div class="col s4 offset-s2">
                            <a id="cancelar_referencia2" class="waves-effect waves-light btn red size_button2">NO</a>
                        </div>
                        <div class="col s4">
                            <a id="eliminar_referencia" class="waves-effect waves-light btn green size_button2">Si</a>
                        </div>
                    </div>    
                </div>
            </div>
            <div id="modal6" class="modal tam">
                <div class="modal-content">
                    <h6 class="center-align">Seguro que desea eliminar la relacionada con el siguiente numero?</h6>
                    <h6 id="relacionada_input" class="center-align"></h6>
                    <input id="relacionada_input2" class="center-align" type="hidden">
                    <div class="row">
                        <div class="col s4 offset-s2">
                            <a id="cancelar_relacionada2" class="waves-effect waves-light btn red size_button2">NO</a>
                        </div>
                        <div class="col s4">
                            <a id="eliminar_relacionada" class="waves-effect waves-light btn green size_button2">Si</a>
                        </div>
                    </div>    
                </div>
            </div>
            <div id="modal9" class="modal tam">
                <div class="modal-content">
                    <h6 class="center-align">Seguro que desea eliminar el titular con el siguiente numero?</h6>
                    <h6 id="titular_input" class="center-align"></h6>
                    <input id="titular_input2" class="center-align" type="hidden">
                    <div class="row">
                        <div class="col s4 offset-s2">
                            <a id="cancelar_titular2" class="waves-effect waves-light btn red size_button2">NO</a>
                        </div>
                        <div class="col s4">
                            <a id="eliminar_titular" class="waves-effect waves-light btn green size_button2">Si</a>
                        </div>
                    </div>    
                </div>
            </div>
            <div id="modal7" class="modal tam">
                <div class="modal-content">
                    <h6 class="center-align">Seguro que desea eliminar todas las referencias, relacionadas y titulares de esta cuenta?</h6>
                    <div class="row">
                        <div class="col s4 offset-s2">
                            <a id="cancelar_todo" class="waves-effect waves-light btn red size_button2">NO</a>
                        </div>
                        <div class="col s4">
                            <a id="eliminar_todo" class="waves-effect waves-light btn green size_button2">Si</a>
                        </div>
                    </div>    
                </div>
            </div>
            <div id="modal8" class="modal tam">
                <div class="modal-content">
                    <h6 class="center-align">Seguro que desea eliminar el convenio con este folio?</h6>
                    <h6 id="conv_input" class="center-align"></h6>
                    <div class="row">
                        <div class="col s4 offset-s2">
                            <a id="cancelar_conv" class="waves-effect waves-light btn red size_button2">NO</a>
                        </div>
                        <div class="col s4">
                            <a id="eliminar_conve" class="waves-effect waves-light btn green size_button2">Si</a>
                        </div>
                    </div>    
                </div>
            </div>
            <!------------------------------FIN DE LOS MODALES-------------------------------------------->
            <!----------------------------EMPIEZAN LOS MALOS MODALES-------------------------------------->

            <!--------------------------- INPUTS INVISIBLES DE RESPALDO ---------------------------------->
            <input value="" id="respaldo_id_convenio_input" type="hidden" class="validate" placeholder="Calle">
            <input value="" id="respaldo_convenio_input" type="hidden" class="validate" placeholder="Calle">
            <input value="" id="respaldo_gestor_input" type="hidden" class="validate" placeholder="Calle">
            <input value="" id="respaldo_fecha_input" type="hidden" class="validate" placeholder="Calle">
        </div>



        <!--END CONTENT-->

        <!--END PAGE WRAPPER-->

    </div>

    <!--CORE JAVASCRIPT-->
    <script type="text/javascript">
        // ARCADE Software®
        //==================================================================
        $(document).ready(function () {
            //select_xxyyzz_tabla("listado_xxyyzz");
            $('select').material_select();
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15, // Creates a dropdown of 15 years to control year,
                today: 'Today',
                clear: 'Clear',
                close: 'Ok',
                closeOnSelect: false // Close upon selecting a date,
            });
            $('.modal').modal();
        });
        //==================================================================
        $("#buscar_cuenta").on('keyup', function (e) {
            if (e.keyCode === 13) {
                solicitud_core($("#buscar_cuenta").val());
                select_convenios_cuenta($("#buscar_cuenta").val(), "dato_convenio");
                //agregado por emmanuel
                select_tabla_telefono($("#buscar_cuenta").val(), "dato_telefono", "dato_telefono2", "dato_telefono3");
                select_pagos_cuenta($("#buscar_cuenta").val(), "dato_pago");
                select_tabla_gestiones($("#buscar_cuenta").val(), "dato_gestion");
                $("#body_render").addClass("show");
                window.setTimeout(function () {
                    $("#body_render").removeClass("show");
                }, 500);
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
        //===================(datos del cliente)============================
        $("#actualizar_cliente").on("click", () => {
            update_datos_cliente(
                    $("#dato1").val(), //cuenta
                    $("#dato3").val(), //nombre
                    $("#dato5").val(), //plan
                    $("#dato6").val(), //ciudad
                    $("#dato7").val(), //cp
                    $("#dato8").val(), //colonia
                    $("#dato9").val(), //calle
                    $("#dato10").val()); //numero
            //animacion actualizacion
            $('.collapsible').collapsible('close', 0);
            $("#note").removeClass();
            window.setTimeout(function () {
                $("#note").addClass("hide");
            }, 2500);
        });
        //==================================================================
        //============================(convenios)===========================
         $(".select").live("dblclick", function () {
            $('#modal1').modal('open');
            // $(this).closest("tr").attr("id").add($('#convenio_input').val($("#importe_convenio").text()));
            $('#id_convenio_input').val($(this).closest("tr").attr("id"));
            $('#convenio_input').val($(this).find("#importe_convenio").html());
            $('#gestor_input').val($(this).find("#id_gestor").html());
            $('#fecha_input').val($(this).find("#fecha_convenio").html());
            $('#aplica_input').val($(this).find("#aplica").html());
            //respaldo
            $('#respaldo_id_convenio_input').val($(this).closest("tr").attr("id"));
            $('#respaldo_convenio_input').val($(this).find("#importe_convenio").html());
            $('#respaldo_gestor_input').val($(this).find("#id_gestor").html());
            $('#respaldo_fecha_input').val($(this).find("#fecha_convenio").html());
        });
        //===============================================================================================================================================
        // convenios
        $("#actualizar_convenio").live("click", () => {

            //            cargar_respaldo_convenio(                                     js esta listo
            //                   $('#respaldo_id_convenio_input').val(),// FALTA EL BACK DE ESTA mcMANUEL //IMPORTANTE// ABAJO HAY MAS MENSAJITOS 
            //                    $('#respaldo_convenio_input').val(),///////////////////////////////////////////////////////////////////////////
            //                    $('#respaldo_gestor_input').val(),       /////////////////////////////////////////////////////////////////
            //                    $('#respaldo_fecha_input').val()                   
            //                );

            update_datos_convenio(
                    $('#id_convenio_input').val(),
                    $('#convenio_input').val(),
                    $('#gestor_input').val(),
                    $('#fecha_input').val(),
                    $('#aplica_input').val()
                    );

            $('#modal1').modal('close');
            $('.collapsible').collapsible('close', 2);
            $("#note").removeClass();
            window.setTimeout(() => {
                $("#note").addClass("hide");
            }, 1500);
            select_convenios_cuenta($("#buscar_cuenta").val(), "dato_convenio");

        });
        //===================================================================
        //convenios
        $("#cancelar_convenio").on("click", () => {
            $("#modal1").modal('close');
        });
        $("#cancelar_conv").on("click", () => {
            $("#modal8").modal('close');
        });
        //===================================================================
        //convenios eliminar
        $("#eliminar_conv").live("click", function () {
            $("#modal8").modal("open");
            $('#conv_input').text($(this).parent().find("#id_convenio").html());
        });
        //===================================================================
        //convenios eliminar modal
        $("#eliminar_conve").on("click", function () {
            delete_convenio($("#conv_input").text());
            $('#modal8').modal('close');
            $('.collapsible').collapsible('close', 2);
            $("#note2").removeClass();
            window.setTimeout(() => {
                $("#note2").addClass("hide");
            }, 1500);
        });
        //===================================================================
        //==============================(telefonos)==========================
        //telefonos
        $(".selectTel1").live("dblclick", function () {
            $('#modal2').modal('open');
            $('#numero_input').val($(this).find("#numero_R").html());
            $('#nombre_input').val($(this).find("#nombre_R").html());
            $('#tipo_tel_input').val($(this).find("#tipo_tel").html());
        });
        //===================================================================
        //telefonos
        $(".selectTel2").live("dblclick", function () {
            $('#modal3').modal('open');
            $('#numero_input2').val($(this).find("#numero_C").html());
            $('#id_tel_input').val($(this).find("#numero_C").html());
        });
        //===================================================================
        //telefonos
        $(".selectTel3").live("dblclick", function () {
            $('#modal10').modal('open');
            $('#numero_input3').val($(this).find("#numero_T").html());
            //            $('#id_tel_input').val($(this).find("#numero_C").html());
        });
        //===================================================================
        //telefonos
        $("#actualizar_referencia").live("click", () => { //FALTA EL BACK DE ESTA mcMANUEL <======== MENSAJITO #2
            update_datos_telefono1(
                    $("#dato1").val(), //cuenta
                    $('#numero_input').val(),
                    $('#nombre_input').val(),
                    $('#tipo_tel_input').val(),
                    );
            $('#modal2').modal('close');
            $('.collapsible').collapsible('close', 1);
            $("#note").removeClass();
            window.setTimeout(() => {
                $("#note").addClass("hide");
            }, 1500);
            // select_convenios_cuenta($("#buscar_cuenta").val(), "dato_convenio");
            //
        });
        //===================================================================
        // telefonos
        $("#actualizar_relacionada").live("click", () => { // Y TAMBIEN EL BACK DE ESTA.............................................................Y EL BACK DE LA GORDIS TAMBIEN.............................................hahahahahhahahaaha
            update_datos_relacionada(//MENSAJITO #3
                    $("#dato1").val(), //cuenta
                    $('#numero_input2').val(),
                    "CR",
                    $('#id_tel_input').val()
                    );
            $('#modal3').modal('close');
            $('.collapsible').collapsible('close', 1);
            $("#note").removeClass();
            window.setTimeout(() => {
                $("#note").addClass("hide");
            }, 1500);
        });
        //===================================================================
        // telefonos
        $("#actualizar_titular").live("click", () => {
            update_datos_titular(
                    $("#dato1").val(),
                    $('#numero_input3').val(),
                    "T1"
                    );
            $('#modal10').modal('close');
            $('.collapsible').collapsible('close', 1);
            $("#note").removeClass();
            window.setTimeout(() => {
                $("#note").addClass("hide");
            }, 1500);
        });
        //===================================================================
        //telefonos cancel
        $("#cancelar_referencia").on("click", () => {
            $("#modal2").modal('close');
        });
        $("#cancelar_relacionada").on("click", () => {
            $("#modal3").modal('close');
        });
        $("#cancelar_referencia2").on("click", () => {
            $("#modal5").modal('close');
        });
        $("#cancelar_relacionada2").on("click", () => {
            $("#modal6").modal('close');
        });
        $("#cancelar_todo").on("click", () => {
            $("#modal7").modal('close');
        });
        $("#cancelar_titular2").on("click", () => {
            $("#modal9").modal('close');
        });
        $("#cancelar_titular").on("click", () => {
            $("#modal10").modal('close');
        });
        //===================================================================
        //telefonos eliminar
        $("#eliminar1").live("click", function () {
            $("#modal9").modal("open");
            $('#titular_input').text($(this).parent().find("#numero_T").html());
            $('#titular_input2').val($(this).parent().find("#codigo_T").html());
        });
        $("#eliminar3").live("click", function () {
            $("#modal5").modal("open");
            $('#referencia_input').text($(this).parent().find("#numero_R").html());
            $('#referencia_input2').val($(this).parent().find("#codigo_R").html());
        });
        $("#eliminar2").live("click", function () {
            $("#modal6").modal("open");
            $('#relacionada_input').text($(this).parent().find("#numero_C").html());
            $('#relacionada_input2').val($(this).parent().find("#codigo_C").html());
        });
        //===================================================================
        //telefonos eliminar
        $("#eliminar_titular").on("click", () => {
            eliminar_telefonos_individual(
                    $("#titular_input").text(),
                    $("#titular_input2").val(),
                    $("#dato1").val()
                    );
            $('#modal9').modal('close');
            $('.collapsible').collapsible('close', 1);
            $("#note2").removeClass();
            window.setTimeout(() => {
                $("#note2").addClass("hide");
            }, 1500);
        });
        //===================================================================
        //telefonos eliminar
        $("#eliminar_relacionada").on("click", () => {
            eliminar_telefonos_individual(
                    $("#relacionada_input").text(),
                    $("#relacionada_input2").val(),
                    $("#dato1").val()
                    );
            $('#modal6').modal('close');
            $('.collapsible').collapsible('close', 1);
            $("#note2").removeClass();
            window.setTimeout(() => {
                $("#note2").addClass("hide");
            }, 1500);
        });
        //===================================================================
        //telefonos eliminar
        $("#eliminar_referencia").on("click", () => {
            eliminar_telefonos_individual(
                    $("#referencia_input").text(),
                    $("#referencia_input2").val(),
                    $("#dato1").val()
                    );
            $('#modal5').modal('close');
            $('.collapsible').collapsible('close', 1);
            $("#note2").removeClass();
            window.setTimeout(() => {
                $("#note2").addClass("hide");
            }, 1500);
        });
        //===================================================================
        //telefonos eliminar todo
        $("#eliminar_tel").on("click", () => {
            $("#modal7").modal("open");
        });
        $("#eliminar_todo").on("click", () => {
            delete_todo($("#dato1").val());
            $('#modal7').modal('close');
            $('.collapsible').collapsible('close', 1);
            $("#note2").removeClass();
            window.setTimeout(() => {
                $("#note2").addClass("hide");
            }, 1500);
        });
        //===================================================================      
        //==========================(Pagos Duplicados)=======================
        $("#eliminar").live("click", function () {
            $('#modal4').modal('open');
            $('#pago_input').text($(this).parent().find("#id_pago").html());
        });
        //===================================================================
        //pago cancel
        $("#cancelar_pago").on("click", () => {
            $("#modal4").modal('close');
        });
        //===================================================================
        //pago eliminar
        $("#eliminar_pago").on("click", () => {
            delete_pago(
                    $("#pago_input").text()
                    );
            $('#modal4').modal('close');
            $('.collapsible').collapsible('close', 3);
            $("#note").removeClass();
            window.setTimeout(() => {
                $("#note").addClass("hide");
            }, 1500);
        });
        //====================================================================
        //////////////////////////)(gestiones)(///////////////////////////////
        $(".get_estatus").live("dblclick", function () {
            $("#modal11").modal('open');
            $('.num_gestor').val($(this).parent().find("#num_num").html());
        });

        $(".get_subestatus").live("dblclick", function () {
            $("#modal12").modal('open');
            $('.num_gestor').val($(this).parent().find("#num_num").html());
        });
        //====================================================================
        //gestiones
        $(".select_gestion").live("click", function () {
            $(".id_gestor").val($(this).closest("tr").attr("id"));
        });
        //====================================================================
        //gestiones cancel
        $("#cancelar_gestion").on("click", () => {
            $("#modal11").modal('close');
        });
        $("#cancelar_subgestion").on("click", () => {
            $("#modal12").modal('close');
        });
        //====================================================================
        //gestiones actualizar
        $("#actualizar_gestion").on("click", () => {
            actualizar_gestiones(
                    $("#dato1").val(),
                    $(".num_gestor").val(),
                    $(".id_gestor").val(),
                    $("#select_estatus").val()
                    );
            $("#modal11").modal('close');
            $('.collapsible').collapsible('close', 4);
            $("#note").removeClass();
            window.setTimeout(() => {
                $("#note").addClass("hide");
                select_tabla_gestiones($("#buscar_cuenta").val(), "dato_gestion");
            }, 1500);            
        });
        $("#actualizar_subgestion").on("click", () => {
            actualizar_subgestiones(
                    $("#dato1").val(),
                    $(".num_gestor").val(),
                    $(".id_gestor").val(),
                    $("#select_subestatus").val()
                    );
            $("#modal12").modal('close');
            $('.collapsible').collapsible('close', 4);
            $("#note").removeClass();
            window.setTimeout(() => {
                $("#note").addClass("hide");
                select_tabla_gestiones($("#buscar_cuenta").val(), "dato_gestion");
            }, 1500);         
        });

        //=================================================================

        // ARCADE Software®
    </script>
    <!--CORE JAVASCRIPT-->
</body>
</html>