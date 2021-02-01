<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Ingresos</title>


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

        <script type="text/javascript" src="js/arcade-solicitud.js"></script>


        <style>
            td, th {
                padding: 3px 13px;
            }
            /*            thead {
                            border-bottom: 1px solid #fff;
                        }*/
            .error2.select-wrapper input.select-dropdown{
                border-bottom: 1px solid #f44336;
            }
            textarea.materialize-textarea{
                /*                height: 1rem;*/
                padding: .0rem 0 0.0rem 0 !important;
                min-height: 1rem !important;
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
            .innerb{
                overflow: auto;
                height : 29em;
            }
            .innerc{
                overflow: auto;
                height : 6em;
            }
            .solicitud{
            }
            .solicitud_selected{
                box-sizing: border-box;
                background: rgb(137, 222, 255) !important;
            }
            .error{
                border-bottom: 1px solid #f44336 !important;
                box-shadow: 0 1px 0 0 #f44336 !important;
            }
            .show_print{        
                display: none;
            }

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
                        }*/
            .select-dropdown{
                /*                overflow: visible!important;*/
                overflow-y: auto !important;
                /*                max-height: 65px !important;*/
            }
            @media print {
                .hide_print {
                    display: none!important;
                }
                .size{
                    font-size: 13px!important;
                }
                .size2{
                    font-size: 10px!important;
                }
                .show_print{
                    display: block;
                }
                .scale{
                    transform: scale(.5, .5);
                }
                select{
                    font-size: 13px!important;
                }
                optgroup { font-size:10px; }
            }

        </style>

    </head>
    <body id="body">
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="container-fluid">
            <div class="row">
                <nav id="ayuda_nav" class="grey lighten-1 hide_print" >
                    <div class="nav-wrapper">
                        <div>
                            <a class="ayuda_name brand-logo" style="color:white;">Solicitudes</a>
                        </div>
                        <ul class="right"  style="margin-right:2%;">    

                            <li><input id="filtro" class="filtro  center-align grey darken-2" type="text"style="width:400px;border-radius: 4px" placeholder="Buscar"></li>
                            <li id="pdf_horas-clase-maestro" style="margin-left: 117px;"><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
                            <li id="roboto">Manuales de usuario de este modulo</li>
                            <li> <a id="nueva_solicitud" class="btn-floating waves-effect waves-light" style="border-radius: 21px;margin-top: 14px;margin-left: 33px;;margin-right: 0px; background:#c60516;"><i class="material-icons" style="border-radius: 21px;">add</i></a></li>
                        </ul>
                    </div>
                </nav>
                <div id="div_solicitudes" class="col s10 offset-s1 hide_print z-depth-1" style="margin-top:25px;">
                    <div id="listado_solicitudes" class="">
                    </div>
                    <input id="id_seleccion" type="hidden" value="0">
                </div>
                <div id="solicitud" class="col s10 offset-s1 hide_print" style="display:none;">
                    <div class="row">

                        <div class="col s12 center-align">
                            <h3>SOLICITUD DE EMPLEO</h3>
                        </div>
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="nombre" type="text" class="validate" style="text-transform: uppercase;" >
                                <label for="nombre">Nombre Completo</label>
                            </div>  
                            <!--                            modifique esta-->
                            <!--                            modifique esta----------------------------------------------------------------------------------->
                            <div class="input-field col s3 offset-s1">
                                <select id="puesto_nuevo" class="">
                                    <option value="" disabled selected></option>
                                    <option value="Gestor">Gestor</option>
                                    <option value="Reclutador">Reclutador</option>
                                    <option value="Supervisor">Supervisor</option>
                                    <option value="Otros">Otros</option>
                                </select>
                                <label>Puesto Solicitado</label>
                            </div>
                            <!--                            hasta aqui---------------------------------------------------------------------------------------->
                            <div class="input-field col s3 offset-s1">
                                <input id="fecha" type="text" class="datepicker" >
                                <label for="fecha">Fecha:</label>
                            </div>
                            <div class="input-field col s4 ">
                                <select id="call_center"  style="width:205px">
                                    <option value="" disabled selected></option>
                                    <option value="Cobranza">Cobranza</option>
                                    <option value="Atencion a Clientes">Atencion a Clientes</option>
                                    <option value="Ventas">Ventas</option>
                                    <option value="Ninguno">Ninguno</option>
                                </select>
                                <label  style="width:205px">A trabajado en Call Center de:</label>
                            </div>
                            <!--                            modifique esta-------------------------------------------------------------------------------------->
                            <div class="input-field col s3 offset-s1">
                                <select id="exp">
                                    <option value="" disabled selected></option>
                                    <option value="Ninguno">Ninguno</option>
                                    <option value="Predictivo">Predictivo</option>
                                    <option value="Manual">Manual</option>
                                    <option value="Ambos">Ambos</option>
                                </select>
                                <label>Tipo de Marcacion</label>
                            </div>
                            <!--gjhgjgjuyhguyguyguyniujjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
                            <!--                            hasta aqui---------------------------------------------------------------------------------------->
                            <div class="input-field col s3 offset-s1 ">
                                <select id="sucursal">
                                    <option value="" disabled selected></option>
                                    <option value="Monterrey">Monterrey</option>
                                    <option value="Puebla">Puebla</option>
                                </select>
                                <label>Sucursal</label>
                            </div>
                            <!--                            modifique esta------------------------------------------------------------------------------------->
                            <div class="input-field col s4">
                                <select id="medio" class="seleccionador sele">
                                    <option value="" disabled selected></option>
                                    <option value="Publicidad Fija">Publicidad Fija</option>
                                    <option value="Bolsas Electronicas">Bolsas Electronicas</option>
                                    <option value="Trabajo en Campo">Trabajo en Campo</option>
                                    <option value="Redes Sociales">Redes Sociales</option>
                                    <option value="Otros">Otros</option>
                                    <option value="Escuelas">Escuelas</option>
                                    <option value="Periodico">Periodico</option>
                                    <option value="Bolsas Municipales">Bolsas Municipales</option>
                                    <option value="Intercambio de Bolsas">Intercambio de Bolsas</option>
                                    <option value="Outsourcing">Outsourcing</option>
                                </select>
                                <label>Medio por el cual te enteraste?</label>
                            </div>
                            <input id="especificaMedio" class="hide">
                            <div id="medioDiv0" class="input-field col s3 offset-s1">
                                <select id="especificaMedio0">
                                    <option value="" disabled selected></option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv1" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio1">
                                    <option value="" disabled selected></option>
                                    <option value="Anuncio Ventana">Anuncio Ventana</option>
                                    <option value="Banner">Banner</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv2" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio2">
                                    <option value="" disabled selected></option>
                                    <option value="COMPUTRABAJO">COMPUTRABAJO</option>
                                    <option value="INDEED">INDEED</option>
                                    <option value="TALENTECA">TALENTECA</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv3" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio3">
                                    <option value="" disabled selected></option>
                                    <option value="BRIGADA MONTERREY">BRIGADA MONTERREY</option>
                                    <option value="FERIA EMPLEO GUADALUPE">FERIA EMPLEO GUADALUPE</option>
                                    <option value="FERIA EMPLEO SAN NICOLAS">FERIA EMPLEO SAN NICOLAS</option>
                                    <option value="FERIA EMPLEO ESCOBEDO">FERIA EMPLEO ESCOBEDO</option>
                                    <option value="VOLANTEO">VOLANTEO</option>
                                    <option value="FERIA DE EMPLEO">FERIA DE EMPLEO</option>
                                    <option value="POSTEO">POSTEO</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv4" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio4">
                                    <option value="" disabled selected></option>
                                    <option value="FACEBOOK(PERSONAL)">FACEBOOK(PERSONAL)</option>
                                    <option value="FACEBOOK(PAGINA SICSA)">FACEBOOK(PAGINA SICSA)</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv5" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio5">
                                    <option value="" disabled selected></option>
                                    <option value="RECOMENDACION">RECOMENDACION</option>
                                    <option value="REF. CONOCIDO">REF. CONOCIDO</option>
                                    <option value="REINGRESO">REINGRESO</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv6" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio6">
                                    <option value="" disabled selected></option>
                                    <option value="UANL">UANL</option>
                                    <option value="UMM">UMM</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv7" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio7">
                                    <option value="" disabled selected></option>
                                    <option value="EL METRO">EL METRO</option>
                                    <option value="EL NORTE">EL NORTE</option>
                                    <option value="EL SOL DE PUEBLA">EL SOL DE PUEBLA</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv8" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio8">
                                    <option value="" disabled selected></option>
                                    <option value="BOLSA SAN PEDRO">BOLSA SAN PEDRO</option>
                                    <option value="BOLSA MONTERREY">BOLSA MONTERREY</option>
                                    <option value="BOLSA ESCOBEDO">BOLSA ESCOBEDO</option>
                                    <option value="BOLSA APODACA">BOLSA APODACA</option>
                                    <option value="BOLSA SAN NICOLAS">BOLSA SAN NICOLAS</option>
                                    <option value="BOLSA GUADALUPE">BOLSA GUADALUPE</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv9" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio9">
                                    <option value="" disabled selected></option>
                                    <option value="INTERCAMBIO DE CARTERA">INTERCAMBIO DE CARTERA</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <div id="medioDiv10" class="input-field col s3 offset-s1 hide">
                                <select id="especificaMedio10" class="grey lighten-4">
                                    <option value="" disabled selected></option>
                                    <option value="EMPRESA">EMPRESA</option>
                                </select>
                                <label>Especifica el Medio</label>
                            </div>
                            <!--                            hasta aqui----------------------------------------------------------------------------------------->
                            <div class="input-field col s3 offset-s1">
                                <input id="reclutador" type="text" class="validate" onkeypress="return isNumberKey(event)" >
                                <label for="reclutador">Codigo del Reclutador:</label>
                            </div>
                        </div>
                        <!--0.0.00.00.0.0.0.0.00.000.00...0....0.HASTA AQUI..0.0.00.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.-->
                        <div class="col s12 center-align">
                            <h5>DATOS GENERALES</h5>
                        </div>
                        <div class="input-field col s4">
                            <input id="calle" type="text" class="validate">
                            <label for="calle">Calle y No:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="tel" type="text" class="validate" onkeypress="return isNumberKey(event)">
                            <label for="tel">Teléfono Casa:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="cel" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="cel">Telefono Celular:</label>
                        </div>    
                        <div class="input-field col s4">
                            <input id="colonia" type="text" class="validate">
                            <label for="colonia">Colonia:</label>
                        </div>

                        <div class="input-field col s3 offset-s1">
                            <input id="ciudad" type="text" class="validate">
                            <label for="ciudad">Ciudad, Estado:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="mail" type="email" class="validate">
                            <label for="mail">Email:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="fecha_n" type="text" class="datepicker"  >
                            <label for="fecha_n">Fecha de Nacimiento:</label>
                        </div>

                        <div class="input-field col s3 offset-s1">
                            <input id="lugar_n" type="text" class="validate"  >
                            <label for="lugar_n">Lugar de Nacimiento:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="sexo">
                                <option value="" disabled selected></option>
                                <option value="Hombre">Hombre</option>
                                <option value="Mujer">Mujer</option>
                            </select>
                            <label>Sexo:</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="edad" type="text" class="validate" onkeypress="return isNumberKey(event)" >
                            <label for="edad">edad:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="num_imss" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="num_imss">Numero del IMSS:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="clinica" type="text" class="validate">
                            <label for="clinica">Clinica:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="civil"  style="width:265px">
                                <option value="" disabled selected></option>
                                <option value="Soltero(a)">Soltero(a)</option>
                                <option value="Casado(a)">Casado(a)</option>
                                <option value="Union Libre">Union Libre</option>
                                <option value="Divorciado(a)">Divorciado(a)</option>
                                <option value="Viudo(a)">Viudo(a)</option>
                            </select>
                            <label  style="width:265px">Estado Civil:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="religion"  style="width:265px">
                                <option value="" disabled selected></option>
                                <option value="Catolica">Catolica</option>
                                <option value="Cristiana">Cristiana</option>
                                <option value="Testigo de Jehova">Testigo de Jehova</option>
                                <option value="Mormones">Mormones</option>
                                <option value="Ateo">Ateo</option>
                                <option value="Otro">Otro</option>
                            </select>
                            <label  style="width:265px">Religion:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="rfc" type="text" class="validate">
                            <label for="rfc">RFC:</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="dep_eco" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="dep_eco">Dep.Economicos:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="mora"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Ninguna">Ninguna</option>
                                <option value="30">30</option>
                                <option value="60">60</option>
                                <option value="90">90</option>
                                <option value="120">120</option>
                                <option value="Mas">Mas</option>
                            </select>
                            <label  style="width:205px">¿que mora ha trabajado?</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="infonavit" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="infonavit">No Credito de Infonavit:</label>
                        </div>
                        <div class="input-field col s3">
                            <select id="complexion"  style="width:265px">
                                <option value="" disabled selected></option>
                                <option value="Delgada">Delgada</option>
                                <option value="Media">Media</option>
                                <option value="Robusta">Robusta</option>
                            </select>
                            <label  style="width:265px">Complexion:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="edo_sal"  style="width:265px">
                                <option value="" disabled selected></option>
                                <option value="Bueno">Bueno</option>
                                <option value="Malo">Malo</option>
                                <option value="Regular">Regular</option>
                            </select>
                            <label  style="width:265px">Estado de salud:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="tipo_empleo"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Completo">Completo</option>
                                <option value="Parcial">Parcial</option>
                                <option value="Rotativo">Rotativo</option>
                                <option value="Fijo">Fijo</option>
                            </select>
                            <label  style="width:205px">Turno Deseado</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="cambio_res"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  style="width:205px">Disp. cambio de Residencia:</label>
                        </div>
                        <div class="input-field col s3">
                            <select id="viajar"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  style="width:205px">Disponibilidad de Viajar:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="auto"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  style="width:205px">Automovil Propio:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="lic"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  style="width:205px">Licencia:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="extra" type="text" class="validate" onkeypress="return isNumberKey(event)">
                            <label for="extra">No Contacto Extra:</label>
                        </div>
                        <div class="input-field col s3">
                            <select id="tbj_act"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  style="width:205px">Trabaja Actualmente:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="horario_1" type="text" class="validate">
                            <label for="dato25">Horario de Trabajo:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="est_act"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  style="width:205px">Estudia Actualmente:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="horario_2" type="text" class="validate">
                            <label for="horario_2">Horario de Estudio:</label>
                        </div>
                        <!------------------------------------------------------------------------------------------------>
                        <div class="input-field col s4">
                            <input id="curp" type="text" class="validate">
                            <label for="curp">CURP:</label>
                        </div>
                        <!------------------------------------------------------------------------------------------------->
                        <div class="input-field col s6 offset-s2">
                            <input id="virtud" type="text" class="validate" >
                            <label for="grado">Menciona Tus Virtudes y Cualidades:</label>
                        </div>

                        <div class="col s12 center-align">
                            <h5>Estudios Académicos y Actualizaciones</h5>
                        </div>
                        <div class="input-field col s5">
                            <select id="nivel"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Ninguna">Ninguna</option>
                                <option value="Primaria">Primaria</option>
                                <option value="Secundaria">Secundaria</option>
                                <option value="Preparatoria">Preparatoria</option>
                                <option value="Tecnica">Tecnica</option>
                                <option value="Profesional">Profesional</option>
                            </select>
                            <label  style="width:205px">Nivel de Estudios</label>
                        </div>
                        <div class="input-field col s5 offset-s2">
                            <input id="grado" type="text" class="validate" >
                            <label for="grado">Ultima o Actual Institucion Academica y Grado:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="idioma_1" type="text" class="validate" >
                            <label for="idioma_1">Idioma:</label>
                        </div>
                        <div class="input-field col s2 range-field">
                            <input id="rango_1" type="range" id="test5" min="0" max="10" />
                            <label for="">Porcentaje</label>
                        </div>
                        <div class="input-field col s3 offset-s2">
                            <input id="idioma_2" type="text" class="validate" >
                            <label for="idioma_2">Idioma:</label>
                        </div>
                        <div class="input-field col s2 range-field">
                            <input id="rango_2" type="range" id="test5" min="0" max="10" />
                            <label for="">Porcentaje</label>
                        </div>
                        <div class="input-field col s8">
                            <input id="software" type="text" class="validate" >
                            <label for="software">Menciona el software que utiliza o sabe manejar:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="alias" type="text" class="validate" placeholder="">
                            <label for="alias">Alias</label>
                        </div>
                        <div class="col s12 center-align">
                            <h5>Datos Familiares</h5>
                        </div>
                        <div class="input-field col s3">
                            <input id="padre" type="text" class="validate" >
                            <label for="padre">Padre:</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="edad_padre" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="edad_padre">Edad:</label>
                        </div>
                        <div class="input-field col s4 offset-s1">
                            <input id="domicilio_padre" type="text" class="validate" >
                            <label for="domicilio_padre">Domicilio:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="ocupacion_padre" type="text" class="validate" >
                            <label for="ocupacion_padre">Ocupacion:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="madre" type="text" class="validate" >
                            <label for="madre">Madre:</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="edad_madre" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="edad_madre">Edad:</label>
                        </div>
                        <div class="input-field col s4 offset-s1">
                            <input id="domicilio_madre" type="text" class="validate" >
                            <label for="domicilio_madre">Domicilio:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="ocupacion_madre" type="text" class="validate" >
                            <label for="ocupacion_madre">Ocupacion:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="otro_1" type="text" class="validate" >
                            <label for="otro_1">Otro(a):</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="otro_1_edad" type="text" class="validate entero" onkeypress="return isNumberKey(event)" >
                            <label for="otro_1_edad">Edad:</label>
                        </div>
                        <div class="input-field col s4 offset-s1">
                            <input id="otro_1_domicilio" type="text" class="validate">
                            <label for="otro_1_domicilio">Domicilio:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="otro_1_ocupacion" type="text" class="validate" >
                            <label for="otro_1_ocupacion">Ocupacion:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="otro_2" type="text" class="validate" >
                            <label for="otro_2">Otro(a):</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="otro_2_edad" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="otro_2_edad">Edad:</label>
                        </div>
                        <div class="input-field col s4 offset-s1">
                            <input id="otro_2_domicilio" type="text" class="validate" >
                            <label for="otro_2_domicilio">Domicilio:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="otro_2_ocupacion" type="text" class="validate" >
                            <label for="otro_2_ocupacion">Ocupacion:</label>
                        </div>
                        <div class="col s12 center-align">
                            <h5>Experiencia Laboral</h5>
                            <h6>Comenzar por su ultimo trabajo o Actual</h6>
                        </div>
                        <div class="input-field col s3">
                            <input id="nombre_1" type="text" class="validate" >
                            <label for="nombre_1">Nombre de la Empresa:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="giro_1" type="text" class="validate" >
                            <label for="giro_1">Giro de la Empresa:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="area_1" type="text" class="validate" >
                            <label for="area_1">Dep. o Area:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="puesto_1" type="text" class="validate" >
                            <label for="puesto_1">Puesto:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="domi_1" type="text" class="validate" >
                            <label for="domi_1">Domicilio:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="dura_1" type="text" class="validate">
                            <label for="dura_1">Duracion en puesto:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="mora_1" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="mora_1">MORA:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="tel_1" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="tel_1">Telefono:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="jefe_1" type="text" class="validate">
                            <label for="jefe_1">Nombre de su Jefe:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="inicio_1" type="text" class="datepicker">
                            <label for="inicio_1">Fecha de Inicio:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="termina_1" type="text" class="datepicker">
                            <label for="termina_1">Fecha de Terminación:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="sueldo_1" type="text" class="validate entero" onkeypress="return isNumberKey(event)" >
                            <label for="sueldo_1">Sueldo Mensual:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="comision_1" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="comision_1">Comisiones:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="producto_1" type="text" class="validate">
                            <label for="prodcuto_1">Producto:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="motivo_1" type="text" class="validate">
                            <label for="motivo_1">Motivo de Separación:</label>
                        </div>
                        <div class="input-field col s2">
                            <input id="rh_1" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="rh_1">Telefono RH:</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="funcion_1" type="text" class="validate" >
                            <label for="funcion_1">Funciones y Actividades principales:</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="tec_1" type="text" class="validate" >
                            <label for="tec_1">Herramienta y Equipo Utilizado:</label>
                        </div>
                        <div class="col s12 center-align">
                            <h5>Experiencia Laboral</h5>
                        </div>
                        <div class="input-field col s3">
                            <input id="nombre_2" type="text" class="validate" >
                            <label for="nombre_2">Nombre de la Empresa:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="giro_2" type="text" class="validate" >
                            <label for="giro_2">Giro de la Empresa:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="area_2" type="text" class="validate" >
                            <label for="area_2">Dep. o Area:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="puesto_2" type="text" class="validate" >
                            <label for="puesto_2">Puesto:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="domi_2" type="text" class="validate" >
                            <label for="domi_2">Domicilio:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="dura_2" type="text" class="validate">
                            <label for="dura_2">Duracion en puesto:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="mora_2" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="mora_2">MORA:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="tel_2" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="tel_2">Telefono:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="jefe_2" type="text" class="validate">
                            <label for="jefe_2">Nombre de su Jefe:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="inicio_2" type="text" class="datepicker">
                            <label for="inicio_2">Fecha de Inicio:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="termina_2" type="text" class="datepicker" >
                            <label for="termina_2">Fecha de Terminación:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="sueldo_2" type="text" class="validate entero" onkeypress="return isNumberKey(event)" >
                            <label for="sueldo_2">Sueldo Mensual:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="comision_2" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="comision_2">Comisiones:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="producto_2" type="text" class="validate">
                            <label for="prodcuto_2">Producto:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="motivo_2" type="text" class="validate">
                            <label for="motivo_2">Motivo de Separación:</label>
                        </div>
                        <div class="input-field col s2">
                            <input id="rh_2" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="rh_2">Telefono RH:</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="funcion_2" type="text" class="validate" >
                            <label for="funcion_2">Funciones y Actividades principales:</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="tec_2" type="text" class="validate" >
                            <label for="tec_2">Herramienta y Equipo Utilizado:</label>
                        </div>
                        <div class="col s12 center-align">
                            <h5>Experiencia Laboral</h5>
                        </div>
                        <div class="input-field col s3">
                            <input id="nombre_3" type="text" class="validate" >
                            <label for="nombre_3">Nombre de la Empresa:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="giro_3" type="text" class="validate" >
                            <label for="giro_3">Giro de la Empresa:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="area_3" type="text" class="validate" >
                            <label for="area_3">Dep. o Area:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="puesto_3" type="text" class="validate" >
                            <label for="puesto_3">Puesto:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="domi_3" type="text" class="validate" >
                            <label for="domi_3">Domicilio:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="dura_3" type="text" class="validate">
                            <label for="dura_3">Duracion en puesto:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="mora_3" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="mora_3">MORA:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="tel_3" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="tel_3">Telefono:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="jefe_3" type="text" class="validate">
                            <label for="jefe_3">Nombre de su Jefe:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="inicio_3" type="text" class="datepicker">
                            <label for="inicio_3">Fecha de Inicio:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="termina_3" type="text" class="datepicker">
                            <label for="termina_3">Fecha de Terminación:</label>
                        </div>
                        <div class="input-field col s2 ">
                            <input id="sueldo_3" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="sueldo_3">Sueldo Mensual:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="comision_3" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="comision_3">Comisiones:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="producto_3" type="text" class="validate">
                            <label for="prodcuto_3">Producto:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="motivo_3" type="text" class="validate">
                            <label for="motivo_3">Motivo de Separación:</label>
                        </div>
                        <div class="input-field col s2">
                            <input id="rh_3" type="text" class="validate entero" onkeypress="return isNumberKey(event)">
                            <label for="rh_3">Telefono RH:</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="funcion_3" type="text" class="validate" >
                            <label for="funcion_3">Funciones y Actividades principales:</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="tec_3" type="text" class="validate" >
                            <label for="tec_3">Tecnologias, Metodologia y Programas:</label>
                        </div>
                        <div class="col s12 center-align">
                            <button id="insert_solicitud" class="btn waves-effect waves-light" type="submit" name="action" style='background:#c60516;margin-top:10px;'>Finalizar
                                <i class="material-icons right">send</i>
                            </button>
                        </div>
                    </div>
                </div>
                <!--------------------------------------------------------------------------------------------------------------------------------->
                <!--------------------------------------------------------------------------------------------------------------------------------->
                <div id="div_evaluacion" class="col s10 offset-s1 show_print" style="display:none;">
                    <div class="row">
                        <div class="col s12 center-align">
                            <h3>SOLICITUD DE EMPLEO</h3>
                        </div>
                        <div class="input-field col s4">
                            <input  placeholder="" id="dato1" type="text" class="validate" style="text-transform: uppercase;" >
                            <label for="dato1">Nombre Completo</label>
                        </div>  
                        <div class="input-field col s3 offset-s1">
                            <select id="dato2" class="">
                                <option value="" disabled selected></option>
                                <option value="Ninguno">Gestor</option>
                                <option value="Predictivo">Reclutador</option>
                                <option value="Manual">Supervisor</option>
                                <option value="Ambos">Otros</option>
                            </select>
                            <label>Puesto Solicitado</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="dato3" type="text" class="validate datepicker" placeholder="" >
                            <label for="dato3">Fecha:</label>
                        </div>
                        <div class="input-field col s4 ">
                            <select id="dato37"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Cobranza">Cobranza</option>
                                <option value="Atencion a Clientes">Atencion a Clientes</option>
                                <option value="Ventas">Ventas</option>
                                <option value="Ninguno">Ninguno</option>
                            </select>
                            <label for="dato37">A trabajado en Call Center de:</label>
                        </div>
                        <div class="input-field col s3 offset-s1 ">
                            <select id="dato4">
                                <option value="" disabled selected></option>
                                <option value="Ninguno">Ninguno</option>
                                <option value="Predictivo">Predictivo</option>
                                <option value="Manual">Manual</option>
                                <option value="Ambos">Ambos</option>
                            </select>
                            <label>Tipo de Marcacion</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <select id="dato116">
                                <option value="" disabled selected></option>
                                <option value="Monterrey">Monterrey</option>
                                <option value="Puebla">Puebla</option>
                            </select>
                            <label>Sucursal</label>
                        </div>
                        <div class="input-field col s4 ">
                            <select id="dato5" class="seleccionador2">
                                <option value="" disabled selected></option>
                                <option value="Publicidad Fija">Publicidad Fija</option>
                                <option value="Bolsas Electronicas">Bolsas Electronicas</option>
                                <option value="Trabajo en Campo">Trabajo en Campo</option>
                                <option value="Redes Sociales">Redes Sociales</option>
                                <option value="Otros">Otros</option>
                                <option value="Escuelas">Escuelas</option>
                                <option value="Periodico">Periodico</option>
                                <option value="Bolsas Municipales">Bolsas Municipales</option>
                                <option value="Intercambio de Bolsas">Intercambio de Bolsas</option>
                                <option value="Outsourcing">Outsourcing</option>
                            </select>
                            <label for="dato5">Medio por el cual te enteraste?</label>
                        </div>
                        <!-------------------------------------------checar nombre id's---------------------------------------------------------------------->
                        <input id="dato130" class="hide">
                        <div id="medioDiv01" class="input-field col s3 offset-s1">
                            <select id="dato142">
                                <option value="" disabled selected></option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv11" class="input-field col s3 offset-s1 hide">
                            <select id="dato133">
                                <option value="" disabled selected></option>
                                <option value="Anuncio Ventana">Anuncio Ventana</option>
                                <option value="Banner">Banner</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv21" class="input-field col s3 offset-s1 hide">
                            <select id="dato134">
                                <option value="" disabled selected></option>
                                <option value="COMPUTRABAJO">COMPUTRABAJO</option>
                                <option value="INDEED">INDEED</option>
                                <option value="TALENTECA">TALENTECA</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv31" class="input-field col s3 offset-s1 hide">
                            <select id="dato135">
                                <option value="" disabled selected></option>
                                <option value="BRIGADA MONTERREY">BRIGADA MONTERREY</option>
                                <option value="FERIA EMPLEO GUADALUPE">FERIA EMPLEO GUADALUPE</option>
                                <option value="FERIA EMPLEO SAN NICOLAS">FERIA EMPLEO SAN NICOLAS</option>
                                <option value="FERIA EMPLEO ESCOBEDO">FERIA EMPLEO ESCOBEDO</option>
                                <option value="VOLANTEO">VOLANTEO</option>
                                <option value="FERIA DE EMPLEO">FERIA DE EMPLEO</option>
                                <option value="POSTEO">POSTEO</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv41" class="input-field col s3 offset-s1 hide">
                            <select id="dato136">
                                <option value="" disabled selected></option>
                                <option value="FACEBOOK(PERSONAL)">FACEBOOK(PERSONAL)</option>
                                <option value="FACEBOOK(PAGINA SICSA)">FACEBOOK(PAGINA SICSA)</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv51" class="input-field col s3 offset-s1 hide">
                            <select id="dato137">
                                <option value="" disabled selected></option>
                                <option value="RECOMENDACION">RECOMENDACION</option>
                                <option value="REF. CONOCIDO">REF. CONOCIDO</option>
                                <option value="REINGRESO">REINGRESO</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv61" class="input-field col s3 offset-s1 hide">
                            <select id="dato138">
                                <option value="" disabled selected></option>
                                <option value="UANL">UANL</option>
                                <option value="UMM">UMM</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv71" class="input-field col s3 offset-s1 hide">
                            <select id="dato139">
                                <option value="" disabled selected></option>
                                <option value="EL METRO">EL METRO</option>
                                <option value="EL NORTE">EL NORTE</option>
                                <option value="EL SOL DE PUEBLA">EL SOL DE PUEBLA</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv81" class="input-field col s3 offset-s1 hide">
                            <select id="dato140">
                                <option value="" disabled selected></option>
                                <option value="BOLSA SAN PEDRO">BOLSA SAN PEDRO</option>
                                <option value="BOLSA MONTERREY">BOLSA MONTERREY</option>
                                <option value="BOLSA ESCOBEDO">BOLSA ESCOBEDO</option>
                                <option value="BOLSA APODACA">BOLSA APODACA</option>
                                <option value="BOLSA SAN NICOLAS">BOLSA SAN NICOLAS</option>
                                <option value="BOLSA GUADALUPE">BOLSA GUADALUPE</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <div id="medioDiv91" class="input-field col s3 offset-s1 hide">
                            <select id="dato141">
                                <option value="" disabled selected></option>
                                <option value="INTERCAMBIO DE CARTERA">INTERCAMBIO DE CARTERA</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                         <div id="medioDiv101" class="input-field col s3 offset-s1 hide">
                            <select id="dato143" class="grey lighten-4">
                                <option value="" disabled selected></option>
                                <option value="EMPRESA">EMPRESA</option>
                            </select>
                            <label>Especifica el Medio</label>
                        </div>
                        <!------------------------------------------------------------------------------------------------------------------------------->
                        <div class="input-field col s2 offset-s1" style="margin-bottom: 20px">
                            <input id="dato6" type="text" class="validate"placeholder="" onkeypress="return isNumberKey(event)">
                            <label for="dato6" class="size">Codigo Reclutador</label>
                        </div>
                        <div class="col s12 center-align">
                            <h5>DATOS GENERALES</h5>
                        </div>
                        <div class="input-field col s4">
                            <input id="dato7" type="text" class="validate" placeholder="" >
                            <label for="dato7">Calle y No:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="dato8" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                            <label for="dato8">Teléfono Casa:</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="dato9" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                            <label for="dato9">Telefono Celular:</label>
                        </div>    
                        <div class="input-field col s3">
                            <input id="dato10" type="text" class="validate" placeholder="" >
                            <label for="dato10">Colonia:</label>
                        </div>

                        <div class="input-field col s3 offset-s1">
                            <input id="dato11" type="text" class="validate" placeholder="" >
                            <label for="dato11">Ciudad, Estado:</label>
                        </div>
                        <div class="input-field col s4 offset-s1">
                            <input id="dato12" type="email" class="validate" placeholder="" >
                            <label for="dato12">Email:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="dato13" type="text" class="validate datepicker" placeholder="" >
                            <label for="dato13">Fecha de Nacimiento:</label>
                        </div>

                        <div class="input-field col s3 offset-s1">
                            <input id="dato14" type="text" class="validate" placeholder="" >
                            <label for="dato14">Lugar de Nacimiento:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato15">
                                <option value="" disabled selected></option>
                                <option value="Hombre">Hombre</option>
                                <option value="Mujer">Mujer</option>
                            </select>
                            <label>Sexo:</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="dato16" type="text" class="validate" placeholder="" >
                            <label for="dato16">edad:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="dato17" type="text" class="validate" placeholder="" >
                            <label for="dato17">Numero del IMSS:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="dato18" type="text" class="validate" placeholder="" >
                            <label for="dato18">Clinica:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato19">
                                <option value="" disabled selected></option>
                                <option value="Soltero(a)">Soltero(a)</option>
                                <option value="Casado(a)">Casado(a)</option>
                                <option value="Union Libre">Union Libre</option>
                                <option value="Divorciado(a)">Divorciado(a)</option>
                                <option value="Viudo(a)">Viudo(a)</option>
                            </select>
                            <label  for="dato19">Estado Civil:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato20"  style="width:265px">
                                <option value="" disabled selected></option>
                                <option value="Catolica">Catolica</option>
                                <option value="Cristiana">Cristiana</option>
                                <option value="Testigo de Jehova">Testigo de Jehova</option>
                                <option value="Mormones">Mormones</option>
                                <option value="Ateo">Ateo</option>
                                <option value="Otro">Otro</option>
                            </select>
                            <label for="dato20">Religion:</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="dato21" type="text" class="validate" placeholder="" >
                            <label for="dato21">RFC:</label>
                        </div>
                        <div class="input-field col s1 offset-s1">
                            <input id="dato22" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                            <label for="dato22" class="hide_print">Dep.Economicos:</label>
                            <label for="dato22" class="show_print">Dep.Eco</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato38"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Ninguna">Ninguna</option>
                                <option value="30">30</option>
                                <option value="60">60</option>
                                <option value="90">90</option>
                                <option value="120">120</option>
                                <option value="Mas">Mas</option>
                            </select>
                            <label  for="dato38" class="hide_print size2">¿que mora ha trabajado?</label>
                        </div>
                        <div class="input-field col s3 offset-s1">
                            <input id="dato24" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                            <label for="dato24"># Credito Infonavit:</label>
                        </div>
                        <div class="input-field col s3">
                            <select id="dato25"  style="width:265px">
                                <option value="" disabled selected></option>
                                <option value="Delgada">Delgada</option>
                                <option value="Media">Media</option>
                                <option value="Robusta">Robusta</option>
                            </select>
                            <label  for="dato25">Complexion:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato26"  style="width:265px">
                                <option value="" disabled selected></option>
                                <option value="Bueno">Bueno</option>
                                <option value="Malo">Malo</option>
                                <option value="Regular">Regular</option>
                            </select>
                            <label  for="dato26" class='size2'>Estado de salud:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato27"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Completo">Completo</option>
                                <option value="Parcial">Parcial</option>
                                <option value="Rotativo">Rotativo</option>
                                <option value="Fijo">Fijo</option>
                            </select>
                            <label  for="dato27">turno Deseado:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato28"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label   for="dato28" class="size2">Disp.cambio Residencia</label>
                        </div>
                        <div class="input-field col s3">
                            <select id="dato29"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  for="dato29">Disponibilidad de Viajar:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato30"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label for="dato30" class="size2">Automovil Propio</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato31"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  for="dato31">Licencia:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="dato32" type="text" class="validate" placeholder="" onkeypress="return isNumberKey(event)">
                            <label for="dato32" class="size"># Contacto Extra</label>
                        </div>
                        <div class="input-field col s3">
                            <select id="dato33"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label  for="dato33">Trabaja Actualmente:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="dato34" type="text" class="validate" placeholder="" >
                            <label for="dato34" class="size">Horario Trabajo</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="dato35"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Si">Si</option>
                                <option value="No">No</option>
                            </select>
                            <label for="dato35" class="size2">Estudia Actualmente</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="dato36" type="text" class="validate" placeholder="" >
                            <label for="dato36" class="size">Horario Estudio</label>
                        </div>
                        <!------------------------------------------------------------------------------------------------------------------->
                        <div class="input-field col s4">
                            <input id="dato23" type="text" class="validate" placeholder="" >
                            <label for="dato23">CURP:</label>
                        </div>
                        <!-------------------------------------------------------------------------------------------------------------------------------->
                        <div class="input-field col s6 offset-s2">
                            <input id="dato131" type="text" class="validate" style="margin-bottom: 20px" placeholder="">
                            <label for="grado" class='size'>Menciona Tus Virtudes y Cualidades:</label>
                        </div>
                        <div class="col s12 center-align">
                            <h5>Estudios Académicos y Actualizaciones</h5>
                        </div>
                        <div class="input-field col s5">
                            <select id="dato39"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Ninguna">Ninguna</option>
                                <option value="Primaria">Primaria</option>
                                <option value="Secundaria">Secundaria</option>
                                <option value="Preparatoria">Preparatoria</option>
                                <option value="Tecnica">Tecnica</option>
                                <option value="Profesional">Profesional</option>
                            </select>
                            <label  for="dato39">Nivel de Estudios</label>
                        </div>
                        <div class="input-field col s5 offset-s2">
                            <input id="dato40" type="text" class="validate" placeholder=""  >
                            <label for="dato40" class="size2">Ultima o Actual Institucion Academica y Grado</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="dato41" type="text" class="validate" placeholder="" >
                            <label for="dato41">Idioma:</label>
                        </div>
                        <div class="input-field col s2 range-field">
                            <input  type="range" id="dato42" min="0" max="10"  class="hide_print" />
                            <input type='text' id="porcentaje_print" class="show_print center-align" placeholder="">
                            <label for="">Porcentaje</label>
                        </div>
                        <div class="input-field col s3 offset-s2">
                            <input id="dato43" type="text" class="validate" placeholder="" >
                            <label for="dato43">Idioma:</label>
                        </div>
                        <div class="input-field col s2 range-field">
                            <input  type="range" id="dato44" min="0" max="10" class="hide_print" />
                            <input type='text' id="porcentaje_print2" class="show_print center-align" placeholder="">
                            <label for="">Porcentaje</label>
                        </div>
                        <div class="input-field col s8" style="margin-bottom: 40px">
                            <input id="dato45" type="text" class="validate" placeholder="" >
                            <label for="dato45">Menciona el software que utiliza o sabe manejar:</label>
                        </div>
                        <div class="input-field col s2 offset-s1" style="margin-bottom: 40px">
                            <input id="dato132" type="text" class="validate" placeholder="" >
                            <label for="dato132">Alias</label>
                        </div>

                        <div>
                            <div class="col s12 center-align">
                                <h5>Datos Familiares(Referencias)</h5>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato46" type="text" class="validate" placeholder="" >
                                <label for="dato46">Padre:</label>
                            </div>
                            <div class="input-field col s1 offset-s1">
                                <input id="dato47" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato47">Edad:</label>
                            </div>
                            <div class="input-field col s4 offset-s1">
                                <input id="dato48" type="text" class="validate" placeholder="" >
                                <label for="dato48">Domicilio:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato49" type="text" class="validate" placeholder="" >
                                <label for="dato49">Ocupacion:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato50" type="text" class="validate" placeholder="" >
                                <label for="dato50">Madre:</label>
                            </div>
                            <div class="input-field col s1 offset-s1">
                                <input id="dato51" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato51">Edad:</label>
                            </div>
                            <div class="input-field col s4 offset-s1">
                                <input id="dato52" type="text" class="validate" placeholder="" >
                                <label for="dato52">Domicilio:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato53" type="text" class="validate" placeholder="" >
                                <label for="dato53">Ocupacion:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato54" type="text" class="validate" placeholder="" >
                                <label for="dato54">Otro(a):</label>
                            </div>
                            <div class="input-field col s1 offset-s1">
                                <input id="dato55" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato55">Edad:</label>
                            </div>
                            <div class="input-field col s4 offset-s1">
                                <input id="dato56" type="text" class="validate" placeholder="" >
                                <label for="dato56">Domicilio:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato57" type="text" class="validate" placeholder="" >
                                <label for="dato57">Ocupacion:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato58" type="text" class="validate"  placeholder="" >
                                <label for="dato58">Otro(a):</label>
                            </div>
                            <div class="input-field col s1 offset-s1">
                                <input id="dato59" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato59">Edad:</label>
                            </div>
                            <div class="input-field col s4 offset-s1">
                                <input id="dato60" type="text" class="validate" placeholder="" >
                                <label for="dato60">Domicilio:</label>
                            </div>
                            <div class="input-field col s2 " style="margin-bottom: 20px">
                                <input id="dato61" type="text" class="validate" placeholder="" >
                                <label for="dato61">Ocupacion:</label>
                            </div>
                        </div>    
                        <div id="exp1">
                            <div class="col s12 center-align">
                                <h5>Experiencia Laboral</h5>
                                <h6>Comenzar por su ultimo trabajo o Actual</h6>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato62" type="text" class="validate" placeholder="" >
                                <label for="dato62">Empresa</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato63" type="text" class="validate" placeholder="" >
                                <label for="dato63" class='size'>Giro de Empresa:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato64" type="text" class="validate"  placeholder="" >
                                <label for="dato64">Dep. o Area:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato65" type="text" class="validate"placeholder="" >
                                <label for="dato65">Puesto:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato66" type="text" class="validate" placeholder="" >
                                <label for="dato66">Domicilio:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato67" type="text" class="validate" placeholder="" >
                                <label for="dato67" class="size2">Duracion en puesto</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato68" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato68">MORA:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato69" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato69">Telefono:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato70" type="text" class="validate" placeholder="" >
                                <label for="dato70">Nombre de su Jefe:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato71" type="text" class="validate datepicker" placeholder="" >
                                <label for="dato71" class='size'>Fecha Inicio</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato72" type="text" class="validate datepicker" placeholder="" >
                                <label for="dato72"class='size'>Fecha de Terminación</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato73" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato73" class='size'>Sueldo Mensual</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato74" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato74">Comisiones:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato75" type="text" class="validate" placeholder="" >
                                <label for="dato75">Producto:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato76" type="text" class="validate" placeholder="" >
                                <label for="dato76" class='size'>Motivo de Separación</label>
                            </div>
                            <div class="input-field col s2">
                                <input id="dato77" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato77">Telefono RH:</label>
                            </div>
                            <div class="input-field col s12">
                                <input id="dato78" type="text" class="validate"  placeholder="" >
                                <label for="dato78">Funciones y Actividades principales:</label>
                            </div>
                            <div class="input-field col s12" style="margin-bottom: 20px">
                                <input id="dato79" type="text" class="validate"  placeholder="" >
                                <label for="dato79">Herramienta y Equipo Utilizado:</label>
                            </div>
                        </div>    
                        <div id="exp2">   
                            <div class="col s12 center-align">
                                <h5>Experiencia Laboral</h5>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato80" type="text" class="validate"  placeholder="" >
                                <label for="dato80">Empresa:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato81" type="text" class="validate"  placeholder="" >
                                <label for="dato81" class="size">Giro de Empresa:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato82" type="text" class="validate" placeholder="" >
                                <label for="dato82">Dep. o Area:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato83" type="text" class="validate" placeholder="" >
                                <label for="dato83">Puesto:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato84" type="text" class="validate" placeholder="" >
                                <label for="dato84">Domicilio:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato85" type="text" class="validate" placeholder="" >
                                <label for="dato85" class="size2">Duracion en puesto:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato86" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato86">MORA:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato87" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato87">Telefono:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato88" type="text" class="validate" placeholder="" >
                                <label for="dato88">Nombre de su Jefe:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato89" type="text" class="validate datepicker" placeholder="" >
                                <label for="dato89" class="size">Fecha Inicio:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato90" type="text" class="validate datepicker" placeholder="" >
                                <label for="dato90" class="size">Fecha de Terminación:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato91" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato91" class="size">Sueldo Mensual:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato92" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato92">Comisiones:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato93" type="text" class="validate" placeholder="" >
                                <label for="dato93">Producto:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato94" type="text" class="validate" placeholder="" >
                                <label for="dato94" class="size">Motivo de Separación:</label>
                            </div>
                            <div class="input-field col s2">
                                <input id="dato95" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato95">Telefono RH:</label>
                            </div>
                            <div class="input-field col s12">
                                <input id="dato96" type="text" class="validate" placeholder="" >
                                <label for="dato96">Funciones y Actividades principales:</label>
                            </div>
                            <div class="input-field col s12" style="margin-bottom: 20px">
                                <input id="dato97" type="text" class="validate" placeholder="" >
                                <label for="dato97">Herramienta y Equipo Utilizado:</label>
                            </div>
                        </div>
                        <div id="exp3">
                            <div class="col s12 center-align">
                                <h5>Experiencia Laboral</h5>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato98" type="text" class="validate" placeholder="" >
                                <label for="dato98">Empresa:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato99" type="text" class="validate" placeholder="" >
                                <label for="dato99" class="size">Giro de Empresa</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato100" type="text" class="validate"  placeholder="" >
                                <label for="dato100">Dep. o Area:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato101" type="text" class="validate" placeholder="" >
                                <label for="dato101">Puesto:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato102" type="text" class="validate"  placeholder="" >
                                <label for="dato102">Domicilio:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato103" type="text" class="validate" placeholder="" >
                                <label for="dato103" class="size2">Duracion en puesto:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato104" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato104">MORA:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato105" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato105">Telefono:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato106" type="text" class="validate " placeholder="" >
                                <label for="dato106">Nombre de su Jefe:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato107" type="text" class="datepicker" placeholder="" >
                                <label for="dato107" class="size">Fecha Inicio:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato108" type="text" class="datepicker" placeholder="" >
                                <label for="dato108" class="size">Fecha de Terminación:</label>
                            </div>
                            <div class="input-field col s2 ">
                                <input id="dato109" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder=""  >
                                <label for="dato109" class="size">Sueldo Mensual:</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="dato110" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder="" >
                                <label for="dato110">Comisiones:</label>
                            </div>
                            <div class="input-field col s2 offset-s1">
                                <input id="dato111" type="text" class="validate" placeholder="" >
                                <label for="dato111">Producto:</label>
                            </div>
                            <div class="input-field col s3 offset-s1">
                                <input id="dato112" type="text" class="validate" placeholder="" > 
                                <label for="dato112" class="size">Motivo de Separación:</label>
                            </div>
                            <div class="input-field col s2">
                                <input id="dato113" type="text" class="validate entero" onkeypress="return isNumberKey(event)" placeholder=""  >
                                <label for="dato113">Telefono RH:</label>
                            </div>
                            <div class="input-field col s12">
                                <input id="dato114" type="text" class="validate"  placeholder="" >
                                <label for="dato114">Funciones y Actividades principales:</label>
                            </div>
                            <div class="input-field col s12" style="margin-bottom: 20px">
                                <input id="dato115" type="text" class="validate" placeholder="" >
                                <label for="dato115">Herramienta y Equipo Utilizado:</label>
                            </div>
                        </div>    
                        <div class="col s12 center-align">
                            <h5>Evaluacion</h5>
                        </div>
                        <div class="input-field col s3">
                            <select id="presentacion"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Presentacion:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="experiencia"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Experiencia:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="facilidad"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Facilidad de Palabra:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="normas"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Apego a Normas:</label>
                        </div>
                        <div class="input-field col s3">
                            <select id="influencia"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Influencia:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="equipo"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Trabajo en Equipo:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="estabilidad"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Estabilidad:</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <select id="logro"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Mal">Mal</option>
                                <option value="Regular">Regular</option>
                                <option value="Bien">Bien</option>
                                <option value="Muy Bien">Muy Bien</option>

                            </select>
                            <label  style="width:205px">Enfoque a Logros:</label>
                        </div>
                        <div class="input-field col s2">
                            <select id="contratacion"  style="width:205px">
                                <option value="" disabled selected></option>
                                <option value="Aprobado">Aprobado</option>
                                <option value="Caido">Caido</option>
                                <option value="Stand By">Stand By</option>
                                <option value="No Aplica">No Aplica</option>
                            </select>
                            <label  style="width:205px">Candidato a Contratación</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="evaluador_rh" type="text" class="validate" placeholder="" onkeypress="return isNumberKey(event)">
                            <label for="evaluador_rh">Id Evaluó</label>
                        </div>
                        <div class="input-field col s2 offset-s1">
                            <input id="reclutador_rh" type="text" class="validate" placeholder="" onkeypress="return isNumberKey(event)">
                            <label for="reclutador_rh">Id Reclutador</label>
                        </div>
                        <!--                        <div class="input-field col s2 offset-s1">
                                                    <select id="reclutador_rh"  style="width:205px">
                                                        <option value="" disabled selected></option>
                                                        <option value="Referido">Referido</option>
                                                        <option value="Jocelyn Morales">Jocelyn Morales</option>
                                                        <option value="Kevin Morales">Kevin Morales</option>
                                                        <option value="Genesis Mendoza">Genesis Mendoza</option>
                                                        <option value="Arturo Arellano">Arturo Arellano</option>
                                                        <option value="Diana Salazar">Diana Salazar</option>
                                                        <option value="Yadira Fernandez">Yadira Fernandez</option>
                                                    </select>
                                                    <label  style="width:205px">Reclutador:</label>
                                                </div>-->
                        <div class="input-field col s3 offset-s1">
                            <input id="dato128" type="text" class="validate" placeholder="" onkeypress="return isNumberKey(event)">
                            <label for="dato128">Referido por:</label>
                        </div>
                        <div class="input-field col s2">
                            <input id="fecha_ingreso" type="text" class="datepicker" placeholder="">
                            <label for="fecha_ingreso" class='size'>Fecha para Ingreso</label>
                        </div>
                        <div class="input-field col s9  offset-s1">
                            <textarea id="dato129" class="materialize-textarea" placeholder=""></textarea>
                            <label for="dato129">Observaciones RH:</label>
                        </div>
                        <div class="input-field col s12 ">
                            <textarea id="anexo_rh" class="materialize-textarea" placeholder=""></textarea>
                            <label for="anexo">Anexo RH:</label>
                        </div>
                        <div class="input-field col s12 ">
                            <textarea id="anexo" class="materialize-textarea" placeholder=""></textarea>
                            <label for="anexo">Anexo:</label>
                        </div>
                        <div class="col s12 center-align">
                            <button id="enviar_evaluacion" class="btn waves-effect waves-light hide_print" type="submit" name="action" style='background:#c60516;margin-top:10px;'>Evaluar
                                <i class="material-icons right">send</i>
                            </button>
                        </div>
                        <div class="col s6 left-align">
                            <a id="regresar" class="btn-floating waves-effect waves-light hide_print" style="border-radius: 21px;margin-top: 14px;margin-left: 33px;;margin-right: 0px; background:#c60516;"><i class="material-icons" style="border-radius: 21px;">chevron_left</i></a>
                        </div>
                        <div class="col s6 right-align">
                            <a id="print" class="waves-effect waves-light btn hide hide_print" style="border-radius: 14px;margin-top: 14px;margin-left: 33px;;margin-right: 0px; background:#c60516;"><i class="material-icons" style="margin: -10px;">print</i></a>
                            <a id="asignar_btn" class="waves-effect waves-light btn hide hide_print pulse" style="border-radius: 14px;margin-top: 14px;margin-left: 33px;;margin-right: 0px; background:#c60516;"><i class="material-icons right">assignment_ind</i>Asignar</a>
                        </div>
                    </div>
                </div>
                <div id="div_finalizar" class="col s12 center-align hide_print" style="display: none;">
                    <h2>TERMINASTE TU SOLICITUD</h2>
                    <h3>FAVOR DE INFORMAR AL RECLUTADOR</h3>
                    <div class="col s12 right-align">
                        <a id="regresar2" class="btn-floating waves-effect waves-light" style="border-radius: 21px;margin-top: 14px;margin-left: 33px;;margin-right: 0px; background:#c60516;"><i class="material-icons" style="border-radius: 21px;">chevron_left</i></a>
                    </div>
                </div>
                <!--END TITLE & BREADCRUMB PAGE--> 

                <!------------//////////////////////modales(Inicio)//////////////////////////////////-------->
                <div id="modal1" class="modal">
                    <div class="modal-content center-align">
                        <p style="font-size:120%;">Al Usuario:</p><p id="nameUsu" style="font-size:120%;"></p><p style="font-size:120%;">Se le ha asignado el siguiente Id:</p><p id="idUsu" style="font-size:120%;"></p>
                    </div>
                    <div class="modal-footer">
                        <a href="/sistema/vacantes.jsp" class="modal-action modal-close waves-effect green btn">Aceptar</a>
                    </div>
                </div>

                <div id="modal2" class="modal" style="height: 40%;">
                    <div class="modal-content center-align">
                        <h4>Documentos</h4>
                        <form action="#">
                            <div class="col s4">
                                <p>
                                    <input type="checkbox" id="acta"  />
                                    <label for="acta">Acta de Nacimiento</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="ife"  />
                                    <label for="ife">IFE</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="nss"  />
                                    <label for="nss">Numero del Seguro Social</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="fotos"  />
                                    <label for="fotos">Fotos</label>
                                </p>
                            </div> 
                            <div class="col s4 ">
                                <p>
                                    <input type="checkbox" id="curp1"  />
                                    <label for="curp1">CURP</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="comp_est"  />
                                    <label for="comp_est">Comprobante de Estudios</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="comp_dom"  />
                                    <label for="comp_dom">Comprobante de Domicilio</label>
                                </p>

                            </div>
                            <div class="col s4 ">
                                <p>
                                    <input type="checkbox" id="cartas"  />
                                    <label for="cartas">Cartas de Referencia</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="infonavit1"  />
                                    <label for="infonavit1">No Infonavit</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="infonavit1"  />
                                    <label for="rfcc">RFC</label>
                                </p>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <a id="enviar_check" class="waves-effect waves-light btn blue z-depth-4 size_button" style="padding: 0px 1rem;margin-right: 7px;">GUARDAR CAMBIOS</a>
                    </div>
                </div>
                <!------------//////////////////////modales(Fin)//////////////////////////////////-------->

            </div>
        </div>
        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_solicitudes_tabla("", "listado_solicitudes");
                $('select').material_select();
                var MyDate = new Date();
                var MyDateString;
                MyDate.setDate(MyDate.getDate());
                MyDateString = MyDate.getFullYear() + '-' + ('0' + (MyDate.getMonth() + 1)).slice(-2) + '-' + ('0' + MyDate.getDate()).slice(-2);
                $("#fecha").val(MyDateString);
                $('.modal').modal();

                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 100, // Creates a dropdown of 15 years to control year,
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
                    canceltext: 'Cancel', // Text for cancel-button,
                    container: undefined, // ex. 'body' will append picker to body
                    autoclose: false, // automatic close timepicker
                    ampmclickable: true, // make AM PM clickable
                    aftershow: function () {} //Function for after opening timepicker
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
//            $("#filtro").on("keyup", function () {
//                select_solicitudes_tabla($('#filtro').val(), "tabla_solicitudes");
//            });
            //==================================================================
            document.querySelector("#filtro").onkeyup = function () {
                $TableFilter("#tabla_solicitudes", this.value);
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
            $(".delete_xxyyzz").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_xxyyzz($(this).closest("tr").attr("id"));
                }
            });
            //==================================================================
            $("#nueva_solicitud").click(function () {
                $("#solicitud").show();
                $("#div_solicitudes").hide();
                $("#div_finalizar").hide();
                $("#div_evaluacion").hide();
                $("#ayuda_nav").hide();
            });
            //==================================================================
            $("#regresar").click(function () {
                window.location.reload(true);
            });
            $("#regresar2").click(function () {
                window.location.reload(true);
            });
            //==================================================================
            function validacion_addColor() {
                $("#nombre").val(($("#nombre").val()).toUpperCase());
                var validaciones = [
                    $('#nombre'),
                    $('#calle'),
                    $('#cel'),
                    $('#colonia'),
                    $('#ciudad'),
                    $('#fecha_n'),
                    $('#edad'),
                    $('#reclutador')
                ];
                for (i = 0; i < validaciones.length; i++) {
                    if (validaciones[i].val() == "") {
                        validaciones[i].addClass("error");
                    } else {
                        validaciones[i].removeClass("error");
                    }
                }
                ;
            }
            function validacion_addColor2() {
                var validaciones = [
                    $('#exp'),
                    $('#medio'),
                    $('#sexo'),
                    $('#civil'),
                    $('#religion'),
                    $('#complexion'),
                    $('#edo_sal'),
                    $('#tipo_empleo'),
                    $('#cambio_res'),
                    $('#viajar'),
                    $('#auto'),
                    $('#lic'),
                    $('#tbj_act'),
                    $('#est_act'),
                    $('#call_center'),
                    $('#mora'),
                    $('#nivel'),
                    $('#tbj_act'),
                    $('#puesto_nuevo'),
                    $('#sucursal'),
                    $('#especificaMedio0'),
                    $('#especificaMedio1'),
                    $('#especificaMedio2'),
                    $('#especificaMedio3'),
                    $('#especificaMedio4'),
                    $('#especificaMedio5'),
                    $('#especificaMedio6'),
                    $('#especificaMedio7'),
                    $('#especificaMedio8'),
                    $('#especificaMedio9')
                ];
                for (i = 0; i < validaciones.length; i++) {
                    if (validaciones[i].val() == null) {
                        validaciones[i].addClass("error2");
                    } else {
                        validaciones[i].removeClass("error2");
                    }
                }
                ;
                $('select').material_select();
            }
            function validacion_removeColor() {
                $('#exp').removeClass('error2');
                $('#medio').removeClass('error2');
                $('#sexo').removeClass('error2');
                $('#civil').removeClass('error2');
                $('#religion').removeClass('error2');
                $('#complexion').removeClass('error2');
                $('#edo_sal').removeClass('error2');
                $('#tipo_empleo').removeClass('error2');
                $('#cambio_res').removeClass('error2');
                $('#viajar').removeClass('error2');
                $('#auto').removeClass('error2');
                $('#lic').removeClass('error2');
                $('#tbj_act').removeClass('error2');
                $('#est_act').removeClass('error2');
                $('#call_center').removeClass('error2');
                $('#mora').removeClass('error2');
                $('#nivel').removeClass('error2');
                $('#tbj_act').removeClass('error2');
                $('#puesto_nuevo').removeClass('error2');
                $('#sucursal').removeClass('error2');
                $('#especificaMedio0').removeClass('error2');
                $('#especificaMedio1').removeClass('error2');
                $('#especificaMedio2').removeClass('error2');
                $('#especificaMedio3').removeClass('error2');
                $('#especificaMedio4').removeClass('error2');
                $('#especificaMedio5').removeClass('error2');
                $('#especificaMedio6').removeClass('error2');
                $('#especificaMedio7').removeClass('error2');
                $('#especificaMedio8').removeClass('error2');
                $('#especificaMedio9').removeClass('error2');
                $('#nombre').removeClass("error");
                $('#calle').removeClass("error");
                $('#cel').removeClass("error");
                $('#colonia').removeClass("error");
                $('#ciudad').removeClass("error");
                $('#fecha_n').removeClass("error");
                $('#edad').removeClass("error");
                $('#reclutador').removeClass("error");
                $('.error1').removeClass("error");
            }
            //==================================================================
            $("#insert_solicitud").click(
                    function () {
                        if ($("#sucursal").val() == "" ||
                                $('#puesto_nuevo').val() == "" ||
                                $('#reclutador').val() == "" ||
                                $('#especificaMedio').val() == "" ||
                                $('#exp').val() == "" ||
                                $('#medio').val() == "" ||
                                $('#sexo').val() == "" ||
                                $('#civil').val() == "" ||
                                $('#religion').val() == "" ||
                                $('#complexion').val() == "" ||
                                $('#edo_sal').val() == "" ||
                                $('#tipo_empleo').val() == "" ||
                                $('#cambio_res').val() == "" ||
                                $('#viajar').val() == "" ||
                                $('#auto').val() == "" ||
                                $('#lic').val() == "" ||
                                $('#tbj_act').val() == "" ||
                                $('#est_act').val() == "" ||
                                $('#call_center').val() == "" ||
                                $('#mora').val() == "" ||
                                $('#nivel').val() == "" ||
                                $('#nombre').val() == "" ||
                                $('#calle').val() == "" ||
                                $('#cel').val() == "" ||
                                $('#colonia').val() == "" ||
                                $('#ciudad').val() == "" ||
                                $('#fecha_n').val() == "" ||
                                $('#fecha').val() == "" ||
                                $('#edad').val() == "")
                        {
                            alert("FAVOR DE VERIFICAR  LOS DATOS INGESADOS (LOS CAMPOS EN ROJO SON OBLIGATORIOS)");
                            $("#solicitud").show();
                            validacion_addColor();
                            validacion_addColor2();
                        } else {
                            //==============================================
                            $("#nombre").val(($("#nombre").val()).toUpperCase());
                            insert_solicitud(
                                    $("#nombre").val(),
                                    $("#puesto_nuevo").val(),
                                    $("#fecha").val(),
                                    $("#exp").val(),
                                    $("#sucursal").val(),
                                    $("#medio").val(),
                                    $("#reclutador").val(),
                                    $("#calle").val(),
                                    $("#tel").val(),
                                    $("#cel").val(),
                                    $("#colonia").val(),
                                    $("#ciudad").val(),
                                    $("#mail").val(),
                                    $("#fecha_n").val(),
                                    $("#lugar_n").val(),
                                    $("#sexo").val(),
                                    $("#edad").val(),
                                    $("#num_imss").val(),
                                    $("#clinica").val(),
                                    $("#civil").val(),
                                    $("#religion").val(),
                                    $("#rfc").val(),
                                    $("#dep_eco").val(),
                                    $("#curp").val(),
                                    $("#infonavit").val(),
                                    $("#complexion").val(),
                                    $("#edo_sal").val(),
                                    $("#tipo_empleo").val(),
                                    $("#cambio_res").val(),
                                    $("#viajar").val(),
                                    $("#auto").val(),
                                    $("#lic").val(),
                                    $("#extra").val(),
                                    $("#tbj_act").val(),
                                    $("#horario_1").val(),
                                    $("#est_act").val(),
                                    $("#horario_2").val(),
                                    $("#call_center").val(),
                                    $("#mora").val(),
                                    $("#nivel").val(),
                                    $("#grado").val(),
                                    $("#idioma_1").val(),
                                    $("#rango_1").val(),
                                    $("#idioma_2").val(),
                                    $("#rango_2").val(),
                                    $("#software").val(),
                                    $("#padre").val(),
                                    ($("#edad_padre").val() == "" ? 0 : $("#edad_padre").val()),
                                    $("#domicilio_padre").val(),
                                    $("#ocupacion_padre").val(),
                                    $("#madre").val(),
                                    ($("#edad_madre").val() == "" ? 0 : $("#edad_padre").val()),
                                    $("#domicilio_madre").val(),
                                    $("#ocupacion_madre").val(),
                                    $("#otro_1").val(),
                                    ($("#otro_1_edad").val() == "" ? 0 : $("#otro_1_edad").val()),
                                    $("#otro_1_domicilio").val(),
                                    $("#otro_1_ocupacion").val(),
                                    $("#otro_2").val(),
                                    ($("#otro_2_edad").val() == "" ? 0 : $("#otro_2_edad").val()),
                                    $("#otro_2_domicilio").val(),
                                    $("#otro_2_ocupacion").val(),
                                    $("#nombre_1").val(),
                                    $("#giro_1").val(),
                                    $("#area_1").val(),
                                    $("#puesto_1").val(),
                                    $("#domi_1").val(),
                                    $("#dura_1").val(),
                                    $("#mora_1").val(),
                                    $("#tel_1").val(),
                                    $("#jefe_1").val(),
                                    $("#inicio_1").val(),
                                    $("#termina_1").val(),
                                    $("#sueldo_1").val(),
                                    $("#comision_1").val(),
                                    $("#producto_1").val(),
                                    $("#motivo_1").val(),
                                    $("#rh_1").val(),
                                    $("#funcion_1").val(),
                                    $("#tec_1").val(),
                                    //==========================
                                    $("#nombre_2").val(),
                                    $("#giro_2").val(),
                                    $("#area_2").val(),
                                    $("#puesto_2").val(),
                                    $("#domi_2").val(),
                                    $("#dura_2").val(),
                                    $("#mora_2").val(),
                                    $("#tel_2").val(),
                                    $("#jefe_2").val(),
                                    $("#inicio_2").val(),
                                    $("#termina_2").val(),
                                    $("#sueldo_2").val(),
                                    $("#comision_2").val(),
                                    $("#producto_2").val(),
                                    $("#motivo_2").val(),
                                    $("#rh_2").val(),
                                    $("#funcion_2").val(),
                                    $("#tec_2").val(),
                                    //==================================
                                    $("#nombre_3").val(),
                                    $("#giro_3").val(),
                                    $("#area_3").val(),
                                    $("#puesto_3").val(),
                                    $("#domi_3").val(),
                                    $("#dura_3").val(),
                                    $("#mora_3").val(),
                                    $("#tel_3").val(),
                                    $("#jefe_3").val(),
                                    $("#inicio_3").val(),
                                    $("#termina_3").val(),
                                    $("#sueldo_3").val(),
                                    $("#comision_3").val(),
                                    $("#producto_3").val(),
                                    $("#motivo_3").val(),
                                    $("#rh_3").val(),
                                    $("#funcion_3").val(),
                                    $("#tec_3").val(),
                                    $("#virtud").val(),
                                    $("#especificaMedio").val(),
                                    $("#alias").val()
                                    );
                            $("#div_finalizar").show();
                            $("#solicitud").hide();
                            validacion_removeColor();
                            $('#exp').removeClass("error2");
                            $('#medio').removeClass("error2");
                            $('#sexo').removeClass("error2");
                            $('#civil').removeClass("error2");
                            $('#religion').removeClass("error2");
                            $('#complexion').removeClass("error2");
                            $('#edo_sal').removeClass("error2");
                            $('#tipo_empleo').removeClass("error2");
                            $('#cambio_res').removeClass("error2");
                            $('#viajar').removeClass("error2");
                            $('#auto').removeClass("error2");
                            $('#lic').removeClass("error2");
                            $('#tbj_act').removeClass("error2");
                            $('#est_act').removeClass("error2");
                            $('#call_center').removeClass("error2");
                            $('#mora').removeClass("error2");
                            $('#nivel').removeClass("error2");
                            $('#tbj_act').removeClass("error2");
                            $('#puesto_nuevo').removeClass("error2");
                            $('#sucursal').removeClass("error2");
                            $('#especificaMedio0').removeClass("error2");
                            $('select').material_select();
                        }
                    });
            //==================================================================
            //==================================================================
            $(".solicitud").live("click", function () {
                $("#id_seleccion").val($(this).closest("tr").attr("id"));
            });
            //==================================================================
            $(".solicitud").live("dblclick", function () {
                $("#id_seleccion").val($(this).closest("tr").attr("id"));
                $("#div_evaluacion").show();
                $("#div_solicitudes").hide();
                $("#ayuda_nav").hide();
                $("#print").removeClass("hide");
                window.setTimeout(() => {
                    if ($("#contratacion").val() == "Aprobado") {
                        $("#asignar_btn").removeClass('hide');
                        console.log("aprobado");
                    } else {
                        console.log("no aprobado");
                        $("#asignar_btn").addClass('hide');
                    }
                }, 300);
                select_datos_solicitud($("#id_seleccion").val());
                window.setTimeout(() => {
                    soyUnaVerga($("#anexo"));
                    soyUnaVerga($("#dato129"));
                    soyUnaVerga($("#anexo_rh"));
                }, 200);
            });
            //==================================================================
            $("#enviar_evaluacion").on("click",
                    function () {
                        $("#dato1").val(($("#dato1").val()).toUpperCase());
                        enviar_evaluacion(
                                $("#dato1").val(),
                                $("#dato2").val(),
                                $("#dato3").val(),
                                $("#dato4").val(),
                                $("#dato5").val(),
                                $("#dato6").val(),
                                $("#dato7").val(),
                                $("#dato8").val(),
                                $("#dato9").val(),
                                $("#dato10").val(),
                                $("#dato11").val(),
                                $("#dato12").val(),
                                $("#dato13").val(),
                                $("#dato14").val(),
                                $("#dato15").val(),
                                $("#dato16").val(),
                                $("#dato17").val(),
                                $("#dato18").val(),
                                $("#dato19").val(),
                                $("#dato20").val(),
                                $("#dato21").val(),
                                $("#dato22").val(),
                                $("#dato23").val(),
                                $("#dato24").val(),
                                $("#dato25").val(),
                                $("#dato26").val(),
                                $("#dato27").val(),
                                $("#dato28").val(),
                                $("#dato29").val(),
                                $("#dato30").val(),
                                $("#dato31").val(),
                                $("#dato32").val(),
                                $("#dato33").val(),
                                $("#dato34").val(),
                                $("#dato35").val(),
                                $("#dato36").val(),
                                $("#dato37").val(),
                                $("#dato38").val(),
                                $("#dato39").val(),
                                $("#dato40").val(),
                                $("#dato41").val(),
                                $("#dato42").val(),
                                $("#dato43").val(),
                                $("#dato44").val(),
                                $("#dato45").val(),
                                $("#dato46").val(),
                                $("#dato47").val(),
                                $("#dato48").val(),
                                $("#dato49").val(),
                                $("#dato50").val(),
                                $("#dato51").val(),
                                $("#dato52").val(),
                                $("#dato53").val(),
                                $("#dato54").val(),
                                $("#dato55").val(),
                                $("#dato56").val(),
                                $("#dato57").val(),
                                $("#dato58").val(),
                                $("#dato59").val(),
                                $("#dato60").val(),
                                $("#dato61").val(),
                                $("#dato62").val(),
                                $("#dato63").val(),
                                $("#dato64").val(),
                                $("#dato65").val(),
                                $("#dato66").val(),
                                $("#dato67").val(),
                                $("#dato68").val(),
                                $("#dato69").val(),
                                $("#dato70").val(),
                                $("#dato71").val(),
                                $("#dato72").val(),
                                $("#dato73").val(),
                                $("#dato74").val(),
                                $("#dato75").val(),
                                $("#dato76").val(),
                                $("#dato77").val(),
                                $("#dato78").val(),
                                $("#dato79").val(),
                                $("#dato80").val(),
                                $("#dato81").val(),
                                $("#dato82").val(),
                                $("#dato83").val(),
                                $("#dato84").val(),
                                $("#dato85").val(),
                                $("#dato86").val(),
                                $("#dato87").val(),
                                $("#dato88").val(),
                                $("#dato89").val(),
                                $("#dato90").val(),
                                $("#dato91").val(),
                                $("#dato92").val(),
                                $("#dato93").val(),
                                $("#dato94").val(),
                                $("#dato95").val(),
                                $("#dato96").val(),
                                $("#dato97").val(),
                                $("#dato98").val(),
                                $("#dato99").val(),
                                $("#dato100").val(),
                                $("#dato101").val(),
                                $("#dato102").val(),
                                $("#dato103").val(),
                                $("#dato104").val(),
                                $("#dato105").val(),
                                $("#dato106").val(),
                                $("#dato107").val(),
                                $("#dato108").val(),
                                $("#dato109").val(),
                                $("#dato110").val(),
                                $("#dato111").val(),
                                $("#dato112").val(),
                                $("#dato113").val(),
                                $("#dato114").val(),
                                $("#dato115").val(),
                                $("#dato116").val(),
                                $("#id_seleccion").val(),
                                $("#presentacion").val(),
                                $("#experiencia").val(),
                                $("#facilidad").val(),
                                $("#normas").val(),
                                $("#influencia").val(),
                                $("#equipo").val(),
                                $("#estabilidad").val(),
                                $("#logro").val(),
                                $("#contratacion").val(),
                                $("#fecha_ingreso").val(),
                                $("#reclutador_rh").val(),
                                $("#dato128").val(),
                                $("#dato129").val(),
                                $("#dato130").val(),
                                $("#dato131").val(),
                                $("#dato132").val(),
                                $("#evaluador_rh").val(),
                                $("#anexo").val(),
                                $("#anexo_rh").val()
                                );
//                                $("#div_solicitudes").show();
//                                $("#div_evaluacion").hide();
                        if ($("#contratacion").val() == "Aprobado") {
                            $("#asignar_btn").removeClass('hide');
                        } else {
                            $("#asignar_btn").addClass('hide');
                        }
                        this.style.backgroundColor = "green";
                        $("#enviar_evaluacion").html('evaluado<i class="material-icons right">send</i>');
//                            $("#body").hide();
//                            window.setTimeout(() => {
//                                $("#body").show();
//                            }, 300);
                    });
            //=========================================================================
            $("input.entero").live("keyup", function ()
            {
                var alNumRegex = /^([0-9]+)$/; //only numbers
                var cadena = new Array();
                if (alNumRegex.test($(this).val())) {
                    $(this).attr("value", $(this).val().toUpperCase());
                } else
                {
                    cadena = $(this).val();

                    $(this).attr("value", cadena.substring(0, cadena.length - 1));
                }

            });
            //============================================================================================
            //====================agregado nuevo========================================================00
            $(".seleccionador").change(function () {
                if ($('#medio').val() == "Publicidad Fija") {
                    $('#medioDiv1').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                } else if ($("#medio").val() == "Bolsas Electronicas") {
                    $('#medioDiv2').removeClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                } else if ($("#medio").val() == "Trabajo en Campo") {
                    $('#medioDiv3').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                } else if ($("#medio").val() == "Redes Sociales") {
                    $('#medioDiv4').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                } else if ($("#medio").val() == "Otros") {
                    $('#medioDiv5').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                } else if ($("#medio").val() == "Escuelas") {
                    $('#medioDiv6').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                } else if ($("#medio").val() == "Periodico") {
                    $('#medioDiv7').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                } else if ($("#medio").val() == "Bolsas Municipales") {
                    $('#medioDiv8').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                } else if ($("#medio").val() == "Intercambio de Bolsas") {
                    $('#medioDiv9').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv10").addClass('hide');
                 }else if ($("#medio").val() == "Outsourcing") {
                    $('#medioDiv10').removeClass('hide');
                    $("#medioDiv2").addClass('hide');
                    $("#medioDiv3").addClass('hide');
                    $("#medioDiv4").addClass('hide');
                    $("#medioDiv5").addClass('hide');
                    $("#medioDiv6").addClass('hide');
                    $("#medioDiv7").addClass('hide');
                    $("#medioDiv8").addClass('hide');
                    $("#medioDiv1").addClass('hide');
                    $("#medioDiv0").addClass('hide');
                    $("#medioDiv9").addClass('hide');
                }
            });
            $("#especificaMedio1").change(function () {
                $("#especificaMedio").val($("#especificaMedio1").val());
            });
            $("#especificaMedio2").change(function () {
                $("#especificaMedio").val($("#especificaMedio2").val());
            });
            $("#especificaMedio3").change(function () {
                $("#especificaMedio").val($("#especificaMedio3").val());
            });
            $("#especificaMedio4").change(function () {
                $("#especificaMedio").val($("#especificaMedio4").val());
            });
            $("#especificaMedio5").change(function () {
                $("#especificaMedio").val($("#especificaMedio5").val());
            });
            $("#especificaMedio6").change(function () {
                $("#especificaMedio").val($("#especificaMedio6").val());
            });
            $("#especificaMedio7").change(function () {
                $("#especificaMedio").val($("#especificaMedio7").val());
            });
            $("#especificaMedio8").change(function () {
                $("#especificaMedio").val($("#especificaMedio8").val());
            });
            $("#especificaMedio9").change(function () {
                $("#especificaMedio").val($("#especificaMedio9").val());
            });
            $("#especificaMedio10").change(function () {
                $("#especificaMedio").val($("#especificaMedio10").val());
            });

            $(".seleccionador2").change(function () {
                if ($("#dato5").val() == "Publicidad Fija") {
                    $('#medioDiv11').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Bolsas Electronicas") {
                    $('#medioDiv21').removeClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Trabajo en Campo") {
                    $('#medioDiv31').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Redes Sociales") {
                    $('#medioDiv41').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Otros") {
                    $('#medioDiv51').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Escuelas") {
                    $('#medioDiv61').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Periodico") {
                    $('#medioDiv71').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Bolsas Municipales") {
                    $('#medioDiv81').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Intercambio de Bolsas") {
                    $('#medioDiv91').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv101").addClass('hide');
                } else if ($("#dato5").val() == "Outsourcing") {
                    $('#medioDiv101').removeClass('hide');
                    $("#medioDiv21").addClass('hide');
                    $("#medioDiv31").addClass('hide');
                    $("#medioDiv41").addClass('hide');
                    $("#medioDiv51").addClass('hide');
                    $("#medioDiv61").addClass('hide');
                    $("#medioDiv71").addClass('hide');
                    $("#medioDiv81").addClass('hide');
                    $("#medioDiv11").addClass('hide');
                    $("#medioDiv01").addClass('hide');
                    $("#medioDiv91").addClass('hide');
                }
            });
            $("#dato133").change(function () {
                $("#dato130").val($("#dato133").val());
            });
            $("#dato134").change(function () {
                $("#dato130").val($("#dato134").val());
            });
            $("#dato135").change(function () {
                $("#dato130").val($("#dato135").val());
            });
            $("#dato136").change(function () {
                $("#dato130").val($("#dato136").val());
            });
            $("#dato137").change(function () {
                $("#dato130").val($("#dato137").val());
            });
            $("#dato138").change(function () {
                $("#dato130").val($("#dato138").val());
            });
            $("#dato139").change(function () {
                $("#dato130").val($("#dato139").val());
            });
            $("#dato140").change(function () {
                $("#dato130").val($("#dato140").val());
            });
            $("#dato141").change(function () {
                $("#dato130").val($("#dato141").val());
            });
            $("#dato143").change(function () {
                $("#dato130").val($("#dato143").val());
            });

            function isNumberKey(evt) {
                var charCode = (evt.which) ? evt.which : event.keyCode
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                    return false;
                return true;
            }

            $("#boton_prueba").click(function () {
                window.location.reload(true);
            });
            $("#print").on("click", function () {
                if ($("#dato62").val() == '') {
                    $("#exp1").addClass('hide_print');
                }
                if ($("#dato80").val() == '') {
                    $("#exp2").addClass('hide_print');
                }
                if ($("#dato98").val() == '') {
                    $("#exp3").addClass('hide_print');
                }
                $("#porcentaje_print").val($("#dato42").val() + '0%');
                $("#porcentaje_print2").val($("#dato44").val() + '0%');
                window.focus();
                window.print();

            });

            $("#asignar_btn").on("click", () => {
                $("#dato1").val(($("#dato1").val()).toUpperCase());
                usuarios_datos(
                        $("#dato1").val(),
                        $("#dato132").val(),
                        $("#dato116").val(),
                        $("#dato15").val(),
                        $("#dato8").val(),
                        $("#dato9").val(),
                        $("#dato12").val(),
                        $("#dato6").val()
                        );
                $("#nameUsu").text($("#dato1").val());
                $('#modal2').modal('open');
            });
            //==================================================================
            $("#enviar_check").on("click", () => {
                $('#modal2').modal('close');
                $('#modal1').modal('open');
                update_chunnun(
                        $("#idUsu").text(),
                        $("#acta").prop("checked"),
                        $("#ife").prop("checked"),
                        $("#nss").prop("checked"),
                        $("#curp1").prop("checked"),
                        $("#comp_est").prop("checked"),
                        $("#comp_dom").prop("checked"),
                        $("#cartas").prop("checked"),
                        $("#fotos").prop("checked"),
                        $("#infonavit1").prop("checked"),
                        $("#rfcc").prop("checked"));
            });
            //====================================================================================================================== 
            //== Angel material chingon master
            var hiddenDiv = $('.hiddendiv').first();
            if (!hiddenDiv.length) {
                hiddenDiv = $('<div class="hiddendiv common"></div>');
                $('body').append(hiddenDiv);
            }
            var text_area_selector = '.materialize-textarea';

            function soyUnaVerga($textarea) {
                // Set font properties of hiddenDiv
                var fontFamily = $textarea.css('font-family');
                var fontSize = $textarea.css('font-size');
                var lineHeight = $textarea.css('line-height');
                var padding = $textarea.css('padding');

                if (fontSize) {
                    hiddenDiv.css('font-size', fontSize);
                }
                if (fontFamily) {
                    hiddenDiv.css('font-family', fontFamily);
                }
                if (lineHeight) {
                    hiddenDiv.css('line-height', lineHeight);
                }
                if (padding) {
                    hiddenDiv.css('padding', padding);
                }

                // Set original-height, if none
                if (!$textarea.data('original-height')) {
                    $textarea.data('original-height', $textarea.height());
                }

                if ($textarea.attr('wrap') === 'off') {
                    hiddenDiv.css('overflow-wrap', 'normal').css('white-space', 'pre');
                }

                hiddenDiv.text($textarea.val() + '\n');
                var content = hiddenDiv.html().replace(/\n/g, '<br>');
                hiddenDiv.html(content);

                // When textarea is hidden, width goes crazy.
                // Approximate with half of window size

                if ($textarea.is(':visible')) {
                    hiddenDiv.css('width', $textarea.width());
                } else {
                    hiddenDiv.css('width', $(window).width() / 2);
                }

                /**
                 * Resize if the new height is greater than the
                 * original height of the textarea
                 */
                if ($textarea.data('original-height') <= hiddenDiv.height()) {
                    $textarea.css('height', hiddenDiv.height());
                } else if ($textarea.val().length < $textarea.data('previous-length')) {
                    /**
                     * In case the new height is less than original height, it
                     * means the textarea has less text than before
                     * So we set the height to the original one
                     */
                    $textarea.css('height', $textarea.data('original-height'));
                }
                $textarea.data('previous-length', $textarea.val().length);
            }
            ;
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>