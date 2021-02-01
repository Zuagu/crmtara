
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Dashboard Supervisor</title>
        <link rel="shortcut icon" href="image/logoSicsa/icon-sicsa.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <!--<link rel="stylesheet" type="text/css" href="css/css/style.css">-->
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor.css">
        <style>
            .gestores{
            }
            .gestores_selected{
                box-sizing: border-box;
                background: rgb(137, 222, 255) !important;
            }
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"   />
        <div class="row" id="contenido"></div>
        <div class="contenedor-responsive">


            <!--BEGIN CONTENT-->
            <div class="row">
                <div class="col s12 m12 l12">
                    <div class="col s12 m12 l12">
                        <div class="col s2 m2 l2">
                            <h5>Dashboard</h5> 
                        </div>
                        <div class="col s2 m2 l2 input-field"> 
                            <input id="desde_dash_super" name="fecha" type="text" class="validate datepicker date_picks_dash_sup" readonly="">
                            <label class="" for="desde_dash_super">Desde</label>
                        </div>
                        <div class="col s2 m2 l2 input-field"> 
                            <input id="hasta_dash_super" name="fecha" type="text" class="validate datepicker date_picks_dash_sup" readonly="" >
                            <label class="" for="hasta_dash_super">Hasta</label>
                        </div>
                        <div class="col s2 m2 l2 select_30">
                            <select id="select_region" class="">
                            </select>
                            <label>Region</label>
                        </div>                                
                        <div class="col s2 m2 l2 select_30">
                            <select id="select_asignacion" class="">
                            </select>
                            <label>Asignacion</label>
                        </div>                              
                        <div class="col s12 m12 l12 margin_20_down z-depth-2">
                            <div class=" col s12 m12 l12 div_tabs">
                                <ul id="tabs_datos_general" class="tabs  ul_tabs">
                                    <li class="tab col s1"><a class="active gestor_tab tooltipped" data-position="bottom" data-tooltip="Progreso" href="#div_datos_general_1" style="color:#db040e"><i class="icon_gestor_tab small material-icons">contact_phone</i></a></li>
                                    <li class="tab col s1"><a class=" gestor_tab tooltipped " data-position="bottom" data-tooltip="Permisos" href="#div_datos_general_2" style="color:#db040e"><i class="icon_gestor_tab small material-icons">credit_card</i></a></li>
                                </ul>
                            </div>  
                            <div id="div_datos_general_1" class="col s12 m12 l12 div_gestores_disp_asig">
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_1">
                                        <div class="col s5 m5 l5">
                                            <a id="boton_usuarios_tabla" class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_1"><i class="material-icons">person</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Usuarios</h6>
                                            <h6 id="valores_usuario"></h6>
                                            <h6 id="porcentaje_usuario">80%</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img src="image/graf1.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_2">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_2"><i class="material-icons">phone</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>LLamadas</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf2.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_5">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_3"><i class="material-icons">people</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>convenios</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf3.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_3">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_4"><i class="material-icons">monetization_on</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Recuperacion</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf4.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="div_datos_general_2" class="col s12 m12 l12 div_gestores_disp_asig">
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_6">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_5"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Pagos</h6>
                                            <h6>456/456</h6>
                                            <h6>456/456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img src="image/graf2.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_4">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_6"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Estadisticas</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf3.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_7">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_7"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Pendiente</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf4.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s3 m3 l3">
                                    <div class="col s12 m12 l12 back_dash_data_8">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_8"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Pendientes</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf1.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col s4 m4 l4">
                        <div class="col s12 m12 l12 z-depth-2">
                            <div >
                                <input id="filtro_gestor" class="filtro_gestor  "placeholder="Buscar" type="text" size="60"/>
                            </div>
                            <div id="listado_gestores" class="listado_gestores">
                                <table>
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_listado_gestores"></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col s8 m8 l8">

                        <div class="col s12 m12 l12 z-depth-2 data_gestores_dash">
                            <div class="col s12 m12 l12">
                                <h6 class="datos_gestor">Id y Nombre del Gestor </h6>
                            </div>
                            <div class=" col s12 m12 l12 div_tabs">
                                <ul id="tabs-swipe-demo" class="tabs  ul_tabs">
                                    <li class="tab col s1"><a class="active gestor_tab tooltipped" data-position="bottom" data-tooltip="Progreso" href="#div_gestor_1" style="color:#db040e"><i class="icon_gestor_tab small material-icons">contact_phone</i></a></li>
                                    <li class="tab col s1"><a class=" gestor_tab tooltipped " data-position="bottom" data-tooltip="Permisos" href="#div_gestor_2" style="color:#db040e"><i class="icon_gestor_tab small material-icons">credit_card</i></a></li>
                                </ul>
                            </div>  
                            <div id="div_gestor_1" class="col s12 m12 l12 div_gestores_disp_asig center-align">
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_1">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_9"><i class="material-icons">person</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Usuarios</h6>
                                            <h6>456/456</h6>
                                            <h6>456/456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img src="image/graf1.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_2">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_10"><i class="material-icons">phone</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>LLamadas</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf2.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_5">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_11"><i class="material-icons">people</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>convenios</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf3.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_3">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_12"><i class="material-icons">monetization_on</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Recuperacion</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf4.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="div_gestor_2" class="col s12 m12 l12 div_gestores_disp_asig center-align">
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_6">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_13"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Pase de Salida</h6>
                                            <h6>456/456</h6>
                                            <h6>456/456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img src="image/graf2.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_4">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_14"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Carta Compromiso</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf3.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_7">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_15"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Vacacion</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf4.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                                <div class="col s6 m6 l6">
                                    <div class="col s12 m12 l12 back_dash_data_8">
                                        <div class="col s5 m5 l5">
                                            <a class="btn-floating btn-large waves-effect waves-light back_dash_graf_1 modal-trigger"href="#modal_dash_sup_16"><i class="material-icons">add</i></a>
                                        </div>
                                        <div  class="col s7 m7 l7 center-align">
                                            <h6>Otro</h6>
                                            <h6>456</h6>
                                            <h6>456</h6>
                                        </div>
                                        <div class="col s12 m12 l12">
                                            <img  src="image/graf1.png" width="100%">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 


                <!--Modals-->
                <div id="modal_dash_sup_1" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Usuarios</h4>
                        <table class="highlight" id="tabla_usuarios">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td class="center"> <b><i class="material-icons">account_circle</i></b></td>
                                    <td> <b>ID</b></td>
                                    <td> <b>Nombre</b></td>
                                    <td> <b>Horario</b></td>
                                    <td> <b>Hora de Entrada</b></td>
                                    <td class="center"> <b><i class="material-icons">fingerprint</i></b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_usuarios">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id="" class="waves-effect waves-light btn green size_button">Crear</a>
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cerrar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_2" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Llamadas</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>ID</b></td>
                                    <td> <b>Usuario</b></td>
                                    <td> <b>LLamada</b></td>
                                    <td> <b>Ext</b></td>
                                    <td> <b>Hora</b></td>
                                    <td> <b>Duracion</b></td>
                                    <td> <b>Costo</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cerrar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_3" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Convenios</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>Folio</b></td>
                                    <td> <b>Cuenta</b></td>
                                    <td> <b>Gestor</b></td>
                                    <td> <b>Importe Pr</b></td>
                                    <td> <b>F.Gestion</b></td>
                                    <td> <b>Plazo</b></td>
                                    <td> <b>F.Promesa</b></td>
                                    <td> <b>Pagado</b></td>
                                    <td> <b>F.Pago</b></td>
                                    <td> <b>Efectivo</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cerrar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_4" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Recuperacion</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>Asignacion</b></td>
                                    <td> <b>Equipo</b></td>
                                    <td> <b>Asignacion</b></td>
                                    <td> <b>Punto</b></td>
                                    <td> <b>Cuenta</b></td>
                                    <td> <b>Recuperacion</b></td>
                                    <td> <b>%</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_5" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pagos</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>Fecha</b></td>
                                    <td> <b>Asignacion</b></td>
                                    <td> <b>Cuenta</b></td>
                                    <td> <b>ID Equipo</b></td>
                                    <td> <b>Nombre Equipo</b></td>
                                    <td> <b>Vencido</b></td>
                                    <td> <b>Resto</b></td>
                                    <td> <b>Pago</b></td>
                                    <td> <b>Aplica</b></td>
                                    <td> <b>Resto Actual</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_6" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pendiente</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_7" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pendiente</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_8" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pendiente</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_9" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Usuarios</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_10" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>LLamadas</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_11" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Convenios</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_12" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Recuperacion</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_13" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pendiente</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_14" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pendiente</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_15" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pendiente</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_dash_sup_16" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h4>Pendiente</h4>
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id=""href="#!" class="waves-effect waves-light btn red size_button modal-close">Cancelar</a>  
                    </div>
                </div>
                <div id="modal_gestor_data" class="modal bottom-sheet">
                    <div class="modal-content">
                        <div class="col s12 m12 l12">
                            <h4 id="id_gestor_modal">Modal Header</h4>
                        </div>
                        <div>
                            <p>A bunch of text</p> 
                        </div>

                    </div>
                    <div class="modal-footer">
                        <a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
                    </div>
                </div>


                <!--END CONTENT-->

                <!--END PAGE WRAPPER-->
            </div>
            <script src="https://code.highcharts.com/highcharts.js"></script>
            <script src="https://code.highcharts.com/highcharts-more.js"></script>
            <script src="https://code.highcharts.com/modules/solid-gauge.js"></script>
            <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
            <script type="text/javascript" src="js/js/materialize.min.js"></script>
            <script type="text/javascript" src="js/js/menu.js"></script>
            <script type="text/javascript" src="js/js/dashboard_supervisor.js"></script>
            <!--<script type="text/javascript" src="js/js/script.js"></script>-->

    </body>
</html>