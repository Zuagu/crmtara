<%-- 
    Document   : new_predictivo
    Created on : 11/12/2019, 10:39:05 AM
    Author     : zuagu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="shortcut icon" href="image/logoSicsa/icon-sicsa.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style.css">
        <title>Predictivo</title>
    </head>
    <body onbeforeunload="return Cerrar()">
        <jsp:include page="header.jsp" />
        <div class="row" id="contenido">
            <div class="container-fluid">
                <div class="col s2 m2 l2 z-depth-2 div_search_gestor inner hide">
                    <div class="input-field col s12 m12 l12">
                        <input id="buscador_cuentas_gestor" class="search_cuentas center-align" type="text" placeholder="Buscar">
                    </div>
                    <div id="div_cuentas_encontradas" class=" col s12 m12 l12 hide">

                    </div>
                    <div id="div_telefonos_cuenta" class=" col s12 m12 l12 hide">

                    </div>
                </div>    
                <div class="col s12 m12 l12 contenido-datos">
                    <input id="id_cuenta_deudor" type="hidden">
                    <input id="id_asignacion_deudor" type="hidden">
                    <input id="id_region_deudor" type="hidden">
                    <input id="id_cliente_deudor" type="hidden">
                    <input id="fecha_fin_deudor" type="hidden">
                    <input id="numero_marcado_deudor" type="hidden">
                    <div id="info_gestor" class=" col s12 m12 l12 div_input_gestor_info blue z-depth-1">
                        <div class="input-field col s6 m2 l2">
                            <input id="cuenta_deudor" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="cuenta_deudor">Cuenta</label>
                        </div>
                        <div class="input-field col s12 m4 l4">
                            <input id="nombre_deudor" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="nombre_deudor">Nombre</label>
                        </div>
                        <div class="input-field col s6 m2 l2">
                            <input id="expediente_deudor" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="expediente_deudor">Expediente</label>
                        </div>
                        <div class="input-field col s6 m2 l2">
                            <input id="resto_deudor" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="resto_deudor">Resto</label>
                        </div>
                        <div class="input-field col s6 m2 l2">
                            <input id="cancelacion_deudor" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="cancelacion_deudor">Cancelacion</label>
                        </div>
                    </div>
                    <div id="info_gestor_secundario" class="col s12 m12 l12 div_input_gestor_tiempos z-depth-1 div_info_secundaria">
                        <div class="input-field col s2 m2 l2">
                            <input id="vencido_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="vencido_deudor">Vencido</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="pagado_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="pagado_deudor">Pagado</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="penafineq_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="penafineq_deudor">Pena Fineq</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="penakitbp_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="penakitbp_deudor">Pena Kit BP</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="ult_pago_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="ult_pago_deudor">Ultimo Pago</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="plazo_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="plazo_deudor">Plazo</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="cuentas_dobles_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="cuentas_dobles_deudor">Ctas. Dobles</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="total_cuentas_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="total_cuentas_deudor">Total Cuentas Dbls</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="inicio_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="inicio_deudor">Inicio</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="devolucion_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="devolucion_deudor">Devolucion</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="asignacion_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="asignacion_deudor">Asignacion</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="plan_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="plan_deudor">Plan</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="equipo_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="equipo_deudor">Equipo</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="baja_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="baja_deudor">M. Baja</label>
                        </div>
                        <div class="input-field col s8 m8 l8">
                            <input id="direccion_deudor" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="direccion_deudor">Direccion</label>
                        </div>
                    </div>
                    <div class=" col s12 m12 l12 div_tabs">
                        <ul id="tabs-swipe-demo" class="tabs hide_print ul_tabs">
                            <li class="tab col s1"><a id="tab_gestiones" class="active gestor_tab tooltipped" data-position="bottom" data-tooltip="Gestiones" href="#div_gestiones" style="color:#db040e"><i class="icon_gestor_tab small material-icons">contact_phone</i></a></li>
                            <li class="tab col s1"><a class=" gestor_tab tooltipped " data-position="bottom" data-tooltip="Ref. Bancarias" href="#test-swipe-2" style="color:#db040e"><i class="icon_gestor_tab small material-icons">credit_card</i></a></li>
                            <li class="tab col s1"><a id="tab_pagos" class=" gestor_tab tooltipped" data-position="bottom" data-tooltip="Pagos" href="#div_pagos" style="color:#db040e"><i class="icon_gestor_tab small material-icons">monetization_on</i></a></li>
                            <li class="tab col s1"><a id="tab_pagos_diarios" class=" gestor_tab tooltipped" data-position="bottom" data-tooltip="Pagos_diarios" href="#div_pagos_diarios" style="color:#db040e"><i class="icon_gestor_tab small material-icons">attach_money</i></a></li>
                            <li class="tab col s1"><a id="tab_agendas" class=" gestor_tab tooltipped" data-position="bottom" data-tooltip="Agenda" href="#div_agendas" style="color:#db040e"><i class="icon_gestor_tab small material-icons">insert_invitation</i></a></li>
                            <li class="tab col s1"><a id="tab_visitas" class=" gestor_tab tooltipped" data-position="bottom" data-tooltip="Visitas" href="#div_visitas" style="color:#db040e"><i class="icon_gestor_tab small material-icons">location_on</i></a></li>
                            <li class="tab col s1"><a id="tab_convenios" class=" gestor_tab tooltipped" data-position="bottom" data-tooltip="Convenios" href="#div_convenios" style="color:#db040e"><i class="icon_gestor_tab small material-icons">stars</i></a></li>
                            <li class="tab col s1"><a id="tab_saldos" class=" gestor_tab tooltipped"data-position="bottom" data-tooltip="Saldos" href="#div_saldos" style="color:#db040e"><i class="icon_gestor_tab small material-icons">pie_chart</i></a></li>
                            <li class="tab col s1"><a id="tab_estadisticas" class=" gestor_tab tooltipped" data-position="bottom" data-tooltip="Estadisticas" href="#div_estadisticas" style="color:#db040e"><i class="icon_gestor_tab small material-icons">poll</i></a></li>
                        </ul>
                    </div>    
                    <div id="div_gestiones" class="col s12 z-depth-1 div_gestor_contenido" style="margin-top:10px;"> 
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
                    <div id="test-swipe-2" class="col s12 z-depth-1 div_gestor_contenido" style="margin-top:10px;">
                        <ul class="collection">
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/banamex.fw.png" alt="" class="circle">
                                <span class="title">Banamex</span>
                                <input id="ref_bancaria1" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/bancomer.fw.png" alt="" class="circle">
                                <span class="title">Bancomer</span>
                                <h6 class="">182251</h6>
                                <input id="ref_bancaria2" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar">
                                <img src="image/logo-bancos/hsbc.fw.png" alt="" class="circle">
                                <span class="title">HSBC</span>
                                <h6 class="">2904</h6>
                                <input id="ref_bancaria3" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/banorte.fw.png" alt="" class="circle">
                                <span class="title">Banorte</span>
                                <h6 class="">37478</h6>
                                <input id="ref_bancaria4" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/santander.fw.png" alt="" class="circle">
                                <span class="title">Santander</span>
                                <h6 class="">4565</h6>
                                <input id="ref_bancaria5" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                        </ul>
                    </div>
                    <div id="div_pagos" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <table class="highlight" id="tabla_pagos">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>CUENTA</b></td>
                                    <td><b>FECHA PAGO</b></td>
                                    <td><b>ORIGEN</b></td>
                                    <td><b>IMPORTE</b></td>
                                    <td><b>FORMA</b></td>
                                    <td><b>ESTATUS</b></td>
                                    <td><b>FECHA APLICACION</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_pagos">
                            </tbody>
                        </table>
                    </div>
                    <div id="div_pagos_diarios" class="col s12 m12 l12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s4 m4 l4 offset-s4 offset-m4 offset-l4 rango_fechas_pagos_diarios hide">
                            <input id="desde_pagos_gestor" type="text" class="datepicker input_date center-align" placeholder="desde">
                            <input id="hasta_pagos_gestor" type="text" class="datepicker input_date center-align" placeholder="hasta">
                            <a id="mostrar_pagos_diarios" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div class="div_tabla_pagos_diarios hide">
                            <table class="highlight striped" id="tabla_pagos_diarios">
                                <thead class="blue">
                                    <tr class="text-white">
                                        <td><b>CUENTA</b></td>
                                        <td><b>FECHA PAGO</b></td>
                                        <td><b>ORIGEN</b></td>
                                        <td><b>IMPORTE</b></td>
                                        <td><b>FORMA</b></td>
                                        <td><b>ESTATUS</b></td>
                                        <td><b>FECHA APLICACION</b></td>
                                    </tr>
                                </thead>
                                <tbody id="tbody_tabla_pagos_diarios">
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="div_agendas" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s2 m2 l2 rango-fechas-agendas hide ">
                            <input type="text" class="datepicker input_date center-align" placeholder="Fecha">
                            <input type="text" class="timepicker input_date center-align" placeholder="Hora">
                            <a id="mostrar_agendas" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div id="tabla_agendas" class="col s12 m12 l12">jkshaksjdhkasjh</div>
                    </div>
                    <div id="div_visitas" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s2 m2 l2 rango-fechas-visitas hide">
                            <input type="text" class="datepicker input_date center-align" placeholder="desde">
                            <input type="text" class="timepicker input_date center-align" placeholder="hasta">
                            <a id="mostrar_visitas" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div id="tabla_visitas" class="col s12 m12 l12">jkshaksjdhkasjh</div>
                    </div>
                    <div id="div_convenios" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <table class="highlight" id="tabla_convenios">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>CUENTA</b></td>
                                    <td><b>GESTOR</b></td>
                                    <td><b>CONVENIO</b></td>
                                    <td><b>FECHA GESTION</b></td>
                                    <td><b>PLAZO</b></td>
                                    <td><b>FECHA</b></td>
                                    <td><b>PAGOS</b></td>
                                    <td><b>FECHA PAGOS</b></td>
                                    <td><b>EFECTIVIDAD</b></td>
                                    <td><b>STATUS</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_convenios">
                            </tbody>
                        </table>
                    </div>
                    <div id="div_saldos" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <table class="highlight" id="tabla_equipos_usuario">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>ASIGNACION</b></td>
                                    <td><b>EQUIPO</b></td>
                                    <td><b>CUENTAS</b></td>
                                    <td><b>ASIGNADO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_equipos_usuario">
                            </tbody>
                        </table>
                        <table class="highlight hide" id="tabla_saldos_status">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>REGION</b></td>
                                    <td><b>ESTATUS</b></td>
                                    <td><b>CUENTAS</b></td>
                                    <td><b>VALOR</b></td>
                                    <td><b>ULTIMO TOQUE</b></td>
                                    <td><b>GRUPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_saldos_status">
                            </tbody>
                        </table>
                        <table class="highlight hide" id="tabla_cuentas_status">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>REGION</b></td>
                                    <td><b>CUENTA</b></td>
                                    <td><b>ESTATUS</b></td>
                                    <td><b>RESTO</b></td>
                                    <td><b>ULTIMO TOQUE</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_cuentas_status">
                            </tbody>
                        </table>
                    </div>
                    <div id="div_estadisticas" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s2 m2 l2 rango-fechas-estadisticas hide">
                            <input type="text" class="datepicker input_date center-align" placeholder="desde">
                            <input type="text" class="datepicker input_date center-align" placeholder="hasta">
                            <a id="mostrar_estadisticas" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div id="tabla_estadisticas" class="col s12 m12 l12">jkshaksjdhkasjh</div>
                    </div>
                    <div class=" col s12 m12 l12  div_gestor_gestion">
                        <div class=" col s6 m6 l6 z-depth-1 div_gestor_textarea grey lighten-5 input_gestion">
                            <textarea id="gestion" class="materialize-textarea limpiar_texto" data-length="1000" placeholder="Gestion"></textarea>
                        </div>
                        <div class=" col s6 m6 l6">
                            <div class="input-field col s6 m6 l6">
                                <select id="estatus">
                                    <option value="0" selected>Selecciona Estatus</option>
                                </select>
                                <label>Estatus</label>
                            </div>
                            <div class="input-field col s6 m6 l6">
                                <select id="codigo_llamada"></select>
                                <label>Codigo</label>
                            </div>
                            <div class="col s12 m12 l12 center-align">
                                <a class="waves-effect waves-light btn hide btn_gestiones pulse"><i class="material-icons right">send</i>convenio</a>
                                <a id="guardar_gestion" class="waves-effect waves-light btn btn_guardar_gestiones"><i class="material-icons right">save</i>Ok.</a>
                                <a id="cuenta_siguiente" class="waves-effect waves-light btn btn_siguiente hide"><i class="material-icons right">send</i>Sig.</a>
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m12 l12 div_input_gestor_tiempos z-depth-1">
                        <div class="input-field col s2 m2 l2">
                            <input id="primera_llamada" type="text" class="validate" placeholder="" readonly="readonly" value="00:00:00">
                            <label for="primera_llamada">P.llamada</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="tiempo_actual" type="text" class="validate" placeholder="" readonly="readonly" value="00:00:00">
                            <label for="tiempo_actual">Actual</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="retraso_actual" type="text" class="validate" placeholder="" readonly="readonly" value="00:00:00">
                            <label for="retraso_actual">R. Actual</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="cuentas_tocadas" type="text" class="validate" placeholder="" readonly="readonly" value="0000">
                            <label for="cuentas_tocadas">Cuentas</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="llamadas_realizadas" type="text" class="validate" placeholder="" readonly="readonly" value="0000">
                            <label for="llamadas_realizadas" class="centro">Llamadas</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="convenios" type="text" class="validate" placeholder="" readonly="readonly" value="0000">
                            <label for="convenios">Convenios</label>
                        </div>
                    </div>

                </div>
            </div>
            <div id="modal_convenio" class="modal scale-transition">
                <div class="modal-content">
                    <h3 class="center">Generar Convenio</h3>
                    <h6 id="alerta_convenio" class="red-text center"></h6>
                    <div class="input-field col s12 m4 l4 offset-m2 offset-l2">
                        <input id="importe_convenio" type="text" class="validate limpiar_numero">
                        <label for="importe_convenio">Importe</label>
                    </div>
                    <div class="input-field col s12 m4 l4 offset-m1 offset-l1">
                        <input id="fecha_convenio" type="text" class="datepicker" placeholder="Fecha del convenio">
                    </div>
                    <div class="col s12 center">
                        <br>
                        <a id="cancelar_convenio" class="waves-effect waves-light btn red modal-close btn_gestiones "><i class="material-icons right">cancel</i>Cancel</a>
                        <a id="insert_convenio" class="waves-effect waves-light btn green btn_gestiones"><i class="material-icons right">save</i>Ok</a>
                        <br>
                        <br>
                    </div>
                </div>
            </div>
            <div id="modal_alerta" class="modal">
                <div class="modal-content">
                    <h3 class="center">Alerta</h3>
                    <h5 id="mensaje_alerta" class="mensaje_alerta">

                    </h5>
                </div>
            </div>

        </div>



        <script type="text/javascript">
            var menu = {};
            var tel = <% out.write(request.getParameter("tel")); %>,
                    cuenta = <% out.write(request.getParameter("cuenta")); %>,
                    id_usuario = <% out.write("\"" + request.getParameter("gestor") + "\""); %>,
                    nuemero_marcado = <% out.write(request.getParameter("marcando"));%>,
                    options_estatus_llamadas = "",
                    id_puesto = 0;
            id_usuario = id_usuario.replace("Agent/", "");
        </script>
        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/menu.js"></script>
        <script type="text/javascript" src="js/js/predictivo.js"></script>
    </body>
</html>
