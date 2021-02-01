
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Asignacion Equipos</title>
        <link rel="shortcut icon" href="image/logoSicsa/icon-sicsa.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style.css">

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
            .modal.bottom-sheet {
                top: auto;
                bottom: -100%;
                margin: 0;
                width: 100%;
                max-height: 86%;
                border-radius: 0;
                will-change: bottom, opacity;
            }
            .div_chek {
                height: 35vh;
                /*border: 1px solid;*/
                overflow: auto;
                border-radius: 3px;
                border:1px solid rgba(0,0,0,0.2);
                margin: 3px;
                margin-bottom: 1rem;
            }
            .div_chek2 {
                width: 15%;
            }
            .estatico {
                overflow: unset;
            }
            .div_cuentas_asignar {
                height: 50vh;
                overflow: auto;
            }
            .div_cuentas_asignar {
                height: 50vh;
                overflow: auto;
                margin-bottom: 2rem;
                border: 1px solid rgba(0,0,0,0.2);
                border-radius: 2px;
            }
            td, th {
                padding: 8px 3px;
                display: table-cell;
                text-align: left;
                vertical-align: middle;
                border-radius: 2px;
            }
            .margen {
                margin-bottom: 1rem;
            }
            .modal {
                max-height: 85%;
            }
            .div_cuentas_asignar p {
                display: inline-block;
                padding: 3px 12px;
                background-color: rgb(137, 222, 255);
                border: 1px solid rgb(15, 137, 185);
                margin-left: 8px;
            }
            
            *::-webkit-scrollbar {
                width: 8px;
            }

            *::-webkit-scrollbar-track {
                box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
            }

            *::-webkit-scrollbar-thumb {
                background-color: darkgrey;
                outline: 1px solid slategrey;
                border-radius: 5px;
            }

        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" />
        <div class="row" id="contenido"></div>
        <div class="contenedor-responsive">

            <!--BEGIN CONTENT-->
            <div class="row">
                <div class="col s12 m12 l12">
                    <input id="id_equipo" type="hidden" value="0">
                    <div class="col s7 m7 l7">
                        <div class="col s12 m12 l12 center-align">
                            <h5>Equipos</h5>
                        </div>
                        <div class="col s12 m12 l12 right-align div_boton_insert">
                            <a id="asignar_cuentas" href="#modal_asignar_cuentas" class="btn-floating btn-large waves-effect waves-light green modal-trigger "><i class="material-icons">brightness_auto</i></a>
                        </div>
                        <div class="col s12 m12 l12 tabla_equipos_asig z-depth-1">
                            <table class="striped highlight ">
                                <thead class="blue">
                                    <tr>
                                        <td>Equipo</td>
                                        <td>Asignacion</td>
                                        <td>Equipo</td>
                                        <td>Cuentas</td>
                                        <td>Importe</td>
                                    </tr>
                                </thead>
                                <tbody id="div_equipos"></tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col s5 m5 l5">
                        <div class="col s11 m11 l11 offset-s1 offset-m1 offset-l1  center-align">
                            <h5>Gestores </h5>
                            <div class="datagrid sombra" style="border:none;"><input id="filtro_gestor" class="filtro_gestor  "placeholder="Buscar" type="text" size="60"/></div>
                            <div class="tabla_gestores_selec_asig z-depth-1 ">
                                <table class="striped highlight">
                                    <thead>
                                        <tr>
                                            <td>Id</td>
                                            <td>Nombre</td>
                                        </tr>
                                    </thead>
                                    <tbody id="listado_gestores" class="datagrid sombra" style="overflow: auto;"></tbody>
                                </table>
                            </div> 
                        </div>    
                        <div class="col s11 m11 l11 offset-s1 offset-m1 offset-l1  center-align div_gestores_disp_asig">
                            <h5>Gestores Equipo Seleccionado</h5>
                            <div class="tabla_gestores_disp_asig z-depth-1 ">
                                <table class="striped highlight">
                                    <thead>
                                        <tr>
                                            <td>Id</td>
                                            <td>Nombre</td>
                                        </tr>
                                    </thead>
                                    <tbody id="listado_gestores_equipo" class="datagrid sombra" style="overflow: auto;">
                                    </tbody>
                                </table>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="modal_asignar_cuentas" class="modal bottom-sheet estatico">
                    <div class="modal-content">
                        <h4>Filtro De Cuentas</h4>
                        <div class="col s12 m12">
                            <input type="hidden" value="" id="cadena_ciclos" style="width: 300px;">
                            <input type="hidden" value="" id="cadena_estados" style="width: 300px;">
                            <input type="hidden" value="" id="cadena_estatus" style="width: 300px;">
                        </div>
                        <div>
                            <div class="input-field col s2 m2 l2">
                                <select id="select_region_f"></select>
                                <label>Region</label>
                            </div>
                            <div class="input-field col s2 m2 l2 hide" id="div_asignacion_f" >
                                <select id="select_asignacion_f" ></select>
                                <label>Asignacion</label>
                            </div>

                            <div class="col s2 m2 l2 div_chek" id="div_ciclos_f">Ciclos</div>

                            <div class="col s2 m2 l2 div_chek" id="div_estados_f">Estados</div>

                            <div class="col s2 m2 l2 div_chek" id="div_estatus_f">Estatus</div>
                            <div class="col div_chek div_chek2 center-align">
                                <div class="col s10 m12 l12" >
                                    <select id="select_cr_f">
                                        <option value="0">No</option>
                                        <option value="1">Si</option>
                                        <option value="0,1">Ambos</option>
                                    </select>
                                </div>
                                <div class="col s10 m12 l12" id="div_monto_f">
                                    <input id="input_monto_f" type="number">
                                </div>

                                <div class="col s10 m12 l12">
                                    <a id="ver_cuentas_equipo" class="waves-effect waves-light btn btn_guardar_gestiones"><i class="material-icons right">save</i>Generar</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div id="modal_cuentas" class="modal">
                    <div class="modal-content">
                        <h4 class="col s12">Filtro De Cuentas <b id="numero_reg"></b></h4>

                        <div class="col s12 margen">
                            <a id="crear_equipo" class="waves-effect waves-light btn">Generar equipo</a>
                            <a class="waves-effect waves-light btn" onclick="tableToExcel('tabla_cuentas_select', 'Cuentas equipo')">Excel</a>
                            <a class="waves-effect modal-close red lighten-1 waves-light btn">Cancelar</a>
                        </div>
                        <div id="div_cuentas_asignar" class="div_cuentas_asignar col s12 m12 l12">
                            <table id="tabla_cuentas_select">
                                <thead>
                                    <tr>
                                        <th>CUENTA</th>
                                        <th>CICLO</th>
                                        <th>ESTADO</th>
                                        <th>ESTATUS</th>
                                        <th>TIENE CR</th>
                                        <th>RESTO</th>
                                    </tr>
                                </thead>
                                <tbody id="tbody_cuentas_selecionadas">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div id="modal_cuentas_equipo" class="modal">
                    <div class="modal-content">
                        <h4 class="col s12">Cuentas <b id="numero_regis"></b></h4>

                        <div class="col s12 margen">
                            <a class="waves-effect waves-light btn" onclick="tableToExcel('tabla_cuentas_equipo', 'Cuentas equipo')">Excel</a>
                        </div>
                        <div class="col s12">
                            <ul class="tabs">
                                <li class="tab col s3"><a class="active" href="#test1">Cuentas</a></li>
                                <li class="tab col s6"><a href="#test2">Parametros Creacion</a></li>
                            </ul>
                        </div>
                        <div id="test1" class="col s12">
                            <div class="div_cuentas_asignar" class="col s12 m12 l12">
                                <table id="tabla_cuentas_equipo">
                                    <thead>
                                        <tr>
                                            <th>CUENTA</th>
                                            <th>CICLO</th>
                                            <th>ESTADO</th>
                                            <th>ESTATUS</th>
                                            <th>TIENE CR</th>
                                            <th>RESTO</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_cuentas_equipo"></tbody>
                                </table>
                            </div>
                        </div>
                        <div id="test2" class="col s12">
                            <div class="div_cuentas_asignar" class="col s12 m12 l12">
                                <div>
                                    <label>Nombre Asignacion</label>
                                    <div class="col s12" id="caja_asignacion"></div>
                                </div>
                                <div>
                                    <label>Ciclos</label>
                                    <div class="col s12" id="caja_ciclos"></div>
                                </div>
                                <div>
                                    <label>Estados</label>
                                    <div class="col s12" id="caja_estados"></div>
                                </div>
                                <div>
                                    <label>Estatus</label>
                                    <div class="col s12" id="caja_estatus"></div>
                                </div>
                                
                                <div>
                                    <label>Monto</label>
                                    <div class="col s12" id="caja_monto"></div>
                                </div>
                                <div>
                                    <label>Cr</label>
                                    <div class="col s12" id="caja_con_cr"></div>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>


            </div> 

            <!--END CONTENT-->
            <input id="nuevo_equipo" type="hidden" value="">
            <!--END PAGE WRAPPER-->
        </div>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/highcharts-more.js"></script>
        <script src="https://code.highcharts.com/modules/solid-gauge.js"></script>
        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/asignacion_equipos.js"></script>
        <script type="text/javascript" src="js/arcade-excel.js"></script>
        <!--<script type="text/javascript" src="js/js/script.js"></script>-->

    </body>
</html>