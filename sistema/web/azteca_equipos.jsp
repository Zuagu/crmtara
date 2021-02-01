
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Equipos</title>
        <link rel="shortcut icon" href="image/logoSicsa/icon-sicsa.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <!--<link rel="stylesheet" type="text/css" href="css/css/style.css">-->
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor.css">

        <style>

            .btnaction, .btnaction:hover{
                float: right;
                height: 30px;
                font-size: 1.5rem;
                padding: 0px;
                margin-right: 10px;
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
            table tbody tr:hover {
                transition: 0.6s;
                background-color: rgba(51, 230, 255, 0.4) !important;
            }
            .eliminar_gestor {
                cursor: pointer;
            }
            .filtro_equipo {
                margin-bottom: 6rem;
            }
            input {
                height: 2.5rem !important;
            }
            .cont_nom_equipo {
                margin-top: 1rem;
                margin-bottom: 2rem;
            }
            .margen_boton {
                margin-top: 0.7rem;
            }
            #cont_message {
                margin: 2rem 1rem;
            }
            th, td {
                font-size: 14px;
            }
            .tabla_gestores_selec_asig {
                max-height: 30vh;
                overflow: auto;
            }
            .tabla_gestores_disp_asig {
                max-height: 30vh;
                overflow: auto;
            }
            .tabla_equipos_asig {
                max-height: 65vh;
                overflow: auto;
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
                    <div class="col s10 m10 l10 offset-l1 offset-m1 offset-s1">
                        <div class="col s12 m12 l12">
                            <div class="col s6 m6 l6">
                                <p>Gestor: </p> <b id="id_ges_select">Nombre Gestor Selecionado</b>
                            </div>
                            <div class="col s6 m6 l6">
                                <p>Equipo: </p> <b id="id_equi_select">Nombre del Equipo Selecionado</b>
                            </div>  
                        </div>                          
                    </div>
                    <div class="col s12 m5 l5">

                        <div class="col s12 m12 l12  center-align div_gestores_disp_asig">
                            <h5>Gestores Equipo Activo</h5>
                            <div class="tabla_gestores_disp_asig z-depth-1 blue-grey lighten-5 ">
                                <table class="striped highlight">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody id="listado_gestores_equipo" class="datagrid sombra" style="overflow: auto;">
                                    </tbody>
                                </table>
                                <br>
                            </div>
                        </div>
                        <div class="col s12 m12 l12 center-align">
                            <h5>Gestores</h5>
                            <div class="datagrid sombra" style="border:none;"><input id="filtro_gestor" class="filtro_gestor blue-grey lighten-5 "placeholder="Buscar" type="text" size="60" style="border-radius:4px; border:1px solid black"/></div>
                            <div class="tabla_gestores_selec_asig z-depth-1 blue-grey lighten-5">
                                <table class="striped highlight">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                        </tr>
                                    </thead>
                                    <tbody id="listado_gestores" class="datagrid sombra" style="overflow: auto;"></tbody>
                                </table>
                            </div> 
                        </div>    
                    </div>
                    <input id="id_equipo" type="hidden" value="0">
                    <div class="col s12 m7 l7">
                        <div class="col s12 m12 l12 center-align">
                            <h5>Equipos</h5>
                        </div>

                        <div class="col s12 m12 l12 tabla_equipos_asig z-depth-1 blue-grey lighten-5">
                            <table class="striped highlight">
                                <thead>
                                    <tr>
                                        <th>Id Equipo</th>
                                        <th>Equipo</th>
                                        <th>Descripcion</th>
                                        <th>Cuentas</th>
                                        <th>Valor</th>
                                    </tr>
                                </thead>
                                <tbody id="div_equipos"></tbody>
                            </table>
                        </div>
                        <div class="col s12 m12 l12 right-align div_boton_insert" style="margin-top:10px">
                            <a id="asignar_cuentas" href="#modal_asignar_cuentas" class="btn-large waves-effect waves-light blue modal-trigger "><i class="material-icons">brightness_auto</i></a>
                        </div>
                    </div>
                </div>
                <div id="modal_asignar_cuentas" class="modal bottom-sheet estatico">
                    <div class="modal-content filtro_equipo">
                        <h4>Filtro De Cuentas</h4>
                        <div class="input-field col s6 m3 l3">
                            <select id="op_territorio" multiple>
                                <option value="0" disabled selected>Selecciona</option>
                                <option value="1">Option 1</option>
                                <option value="2">Option 2</option>
                                <option value="3">Option 3</option>
                            </select>
                            <label>Territorio</label>
                        </div>
                        <div class="input-field col s6 m3 l3">
                            <select id="op_gerente" multiple>
                                <option value="0" disabled selected>Selecciona</option>
                                <option value="1">Option 1</option>
                                <option value="2">Option 2</option>
                                <option value="3">Option 3</option>
                            </select>
                            <label>Gerente</label>
                        </div>
                        <div class="input-field col s6 m3 l3">
                            <select id="op_etapa" multiple>
                                <option value="0" disabled selected>Selecciona</option>
                                <option value="1">Option 1</option>
                                <option value="2">Option 2</option>
                                <option value="3">Option 3</option>
                            </select>
                            <label>Etapa</label>
                        </div>
                        <div class="input-field col s6 m3 l3 margen_boton">
                            <a id="crear_equipo" class="btn blue waves-effect">Crear Equipo</a>
                            <a id="agregar_mas_cuentas_equipo" class="btn blue waves-effect">Agregar Cuentas Equipo</a>
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

                <div id="nombre_equipo" class="modal col s10 offset-s1 m4 offset-m4 l4 offset-l4">
                    <div class="modal-content">
                        <h4 class="col s12">Nombre Equipo</h4>

                        <div class="input-field col s12 cont_nom_equipo">
                            <input id="nom_equipo" type="text" class="validate">
                            <label for="nom_equipo">Nombre del Equipo</label>
                            <div class="col s12 center">
                                <a class="modal-close waves-effect waves-yellow btn red">Cancelar</a>
                                <a id="crear_equipo_enviar" class="btn waves-effect blue">Aceptar</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="alerta_message" class="modal col s10 offset-s1 m6 offset-m3 l6 offset-l3">
                    <div class="modal-content">
                        <h4 class="col s12 center" id="title_message"></h4>

                        <div class="input-field col s12 center">
                            <h5 id="cont_message"></h5>
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

        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>

        <script type="text/javascript" src="js/js/menu.js"></script>
        <script type="text/javascript" src="js/js/equipos_azteca.js"></script>
        <script type="text/javascript" src="js/arcade-excel.js"></script>
        <!--<script type="text/javascript" src="js/js/script.js"></script>-->

    </body>
</html>