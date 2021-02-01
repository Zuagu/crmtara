<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Reportes Azteca</title>
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor.css">
        <style>
            .encabezados_csv span {
                background-color: rgba(0, 0, 0, 0.13);
                margin: 0.5rem;
                width: 200px;
                display: none;
                text-align: center;
                padding: 4px;
                border-radius: 3px;
            }
            .dt {
                overflow: auto;
                height: 75vh;
            }
            .div_resumen {
                overflow: auto;
                height: 50vh;
            }
            .div_resumen table {
                margin-top: 0.7rem;
            }
            td, th {
                padding: 5px 5px !important;
                
            }
            td {
                font-size: 13px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row" id="contenido"></div>

        <div class="row">
            <div class="col s12 m12 l12">
                <div class="col s12 m12 l12">
                    <ul id="tabs-swipe-demo" class="tabs hide_print">
                        <li class="tab col s3"><a class="active" href="#test-swipe-1" style="color:#db040e">Gestiones</a></li>
                        <li class="tab col s3"><a class="active" href="#test-swipe-2" style="color:#db040e">Convenios</a></li>
                        <li class="tab col s2"><a class="active" href="#test-swipe-3" style="color:#db040e">Pagos</a></li>
                        <li class="tab col s2"><a class="active" href="#test-swipe-4" style="color:#db040e">Base General</a></li>
                        <li class="tab col s2"><a class="active" href="#test-swipe-5" style="color:#db040e">Tiempos</a></li>
                    </ul>
                    <div id="test-swipe-1" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s12 hide_print">
                                <div class="input-field col s3 " >
                                    <select id="id_ter_gestion" name="id_region"></select>
                                    <label>Territorio</label>
                                </div>
                                <div class="input-field col s9" >
                                    <input id="desde_gestiones" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                    <label class="" for="desde_gestiones"></label>
                                    <input id="hasta_gestiones" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                    <label class="" for="hasta_gestiones"></label>
                                    <a id="enviar_gestiones" class="waves-effect waves-light btn blue"><i class="material-icons">send</i></a> 
                                    <a onclick="tableToExcel('datos_tabla_gestiones', 'GESTIONES')" class="waves-effect waves-light btn green"><i class="material-icons">explicit</i></a> 
                                    <a id="ver_resumen_gestion" class="btn blue waves-effect">ver resumen</a>
                                    <a id="ver_lista_gestion" class="btn blue hide waves-effect">lista gestiones</a>
                                    <a id="descarga_directa_lista_gestion" class="btn blue waves-effect">Descarga Directa</a>
                                </div>
                            </div>
                            <div id="resumen_gestiones" class="col s12 m12 l12 hide">
                                <h5 id="cantidad_gestiones" class="right-align"></h5>
                                <div class="col s12 m2 z-depth-2 div_resumen">
                                    <table>
                                        <thead>
                                            <tr class="green accent-2">
                                                <th>Territorio</th>
                                                <th>N#</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tb_territorio">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="col s12 m2 z-depth-2 div_resumen">
                                    <table>
                                        <thead>
                                            <tr class="green accent-2">
                                                <th>Canal</th>
                                                <th>N#</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tb_canal">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="col s12 m2 z-depth-2 div_resumen">
                                    <table>
                                        <thead>
                                            <tr class="green accent-2">
                                                <th>Atraso_maximo</th>
                                                <th>N#</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tb_atraso_maximo">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="col s12 m2 z-depth-2 div_resumen">
                                    <table>
                                        <thead>
                                            <tr class="green accent-2">
                                                <th>Gestor</th>
                                                <th>N#</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tb_gestor">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="col s12 m2 z-depth-2 div_resumen">
                                    <table>
                                        <thead>
                                            <tr class="green accent-2">
                                                <th>Estatus cuenta</th>
                                                <th>N#</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tb_estatus_cuenta">

                                        </tbody>
                                    </table>
                                </div>
                                <div class="col s12 m2 z-depth-2 div_resumen">
                                    <table>
                                        <thead>
                                            <tr class="green accent-2">
                                                <th>Estatus llamda</th>
                                                <th>N#</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tb_estatus_llamda">

                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div id="datos_tabla_gestiones" class="col s12 z-depth-2 dt">
                                <table class="highlight" id="tabla_pagos">
                                    <thead class="blue">
                                        <tr class="text-white">
                                            <td><b>ID</b></td>
                                            <td><b>HORA</b></td>
                                            <td><b>TERRITORIO</b></td>
                                            <td><b>FECHA_LARGA</b></td>
                                            <td><b>CUENTA</b></td>
                                            <td><b>NUMERO_MARCADO</b></td>
                                            <td><b>ID_ESTATUS_LLAMADA</b></td>
                                            <td><b>USUARIO</b></td>
                                            <td><b>GESTION</b></td>
                                            <td><b>DURACION</b></td>
                                            <td><b>RETASO</b></td>
                                            <td><b>PROMESA</b></td>
                                            <td><b>PREDICTIVO</b></td>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_tabla_gestiones">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div id="test-swipe-2" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s12 hide_print">
                                <div class="input-field col s3" >
                                    <select id="id_ter_convenio" name="id_region"></select>
                                    <label>Territorio</label>
                                </div>
                                <div class="input-field col s9" >
                                    <input id="desde_convenios" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                    <label class="" for="desde_convenios"></label>
                                    <input id="hasta_convenios" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                    <label class="" for="hasta_convenios"></label>
                                    <a id="enviar_convenios" class="waves-effect waves-light btn blue"><i class="material-icons right-align">send</i></a> 
                                    <a onclick="tableToExcel('datos_tabla_convenios', 'CONVENIOS')" class="waves-effect waves-light btn green"><i class="material-icons right-align">explicit</i></a>
                                    <a id="descarga_directa_convenios" class="waves-effect waves-light btn blue">Descarga Directa</a> 
                                    <a id="cantidad_convenios"></a>
                                </div>
                            </div>
                            <div id="datos_tabla_convenios" class="col s12 z-depth-2 dt">
                                <table class="highlight" id="tabla_pagos">
                                    <thead class="blue">
                                        <tr class="text-white">
                                            <td><b>ID_CONVENIO</b></td>
                                            <td><b>CONVENIO</b></td>
                                            <td><b>RESTO</b></td>
                                            <td><b>APLICA</b></td>
                                            <td><b>TERRITORIO</b></td>
                                            <td><b>CANAL</b></td>
                                            <td><b>ATRASO_MAXIMO</b></td>
                                            <td><b>FECHA</b></td>
                                            <td><b>USUARIO</b></td>
                                            <td><b>CUENTA</b></td>
                                            <td><b>ID_ESTATUS</b></td>
                                            <td><b>FECHA_INSET</b></td>
                                            <td><b>PAGOS</b></td>
                                            <td><b>FECHA_PAGO</b></td>
                                            <td><b>EFECTIVIDAD</b></td>
                                            <td><b>ID_EQUIPO</b></td>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_tabla_convenios">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div id="test-swipe-3" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s12 hide_print">
                                <div class="input-field col s3" >
                                    <select id="id_ter_pagos" name="id_region"></select>
                                    <label>ZONA</label>
                                </div>
                                <div class="input-field col s9" >
                                    <input id="desde_pagos" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                    <label class="" for="desde_pagos"></label>
                                    <input id="hasta_pagos" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                    <label class="" for="hasta_pagos"></label>
                                    <a id="enviar_pagos" class="waves-effect waves-light btn blue"><i class="material-icons right-align">send</i></a> 
                                    <a onclick="tableToExcel('datos_tabla_pagos', 'PAGOS')" class="waves-effect waves-light btn green"><i class="material-icons right-align">explicit</i></a> 
                                    <a id="ver_resumen_pagos" class="btn blue">ver resumen</a>
                                    <a id="ver_lista_pagos" class="btn blue hide">lista gestiones</a>
                                </div>
                            </div>

                            <div id="resumen_pagos" class="col s12 z-depth-2 hide">
                                <h5 id="cantidad_pagos" class="right-align"></h5>
                                <table>
                                    <thead>
                                        <tr class="green accent-2">
                                            <th>ZONA</th>
                                            <th>GERENTES</th>
                                            <th>PAGOS</th>
                                            <th>RECUPERACION CAPITAL</th>
                                            <th>RECUPERACION MORATORIOS</th>
                                            <th>SALDO ACTUAL</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tb_resumen_pagos">

                                    </tbody>

                                </table>
                            </div>
                            <div id="datos_tabla_pagos" class="col s12 z-depth-2 dt">
                                <table class="highlight" id="tabla_pagos">
                                    <thead class="blue">
                                        <tr class="text-white">
                                            <td><b>CLIENTE UNICO</b></td>
                                            <td><b>AÑO</b></td>
                                            <td><b>SEMANA</b></td>
                                            <td><b>DIA</b></td>
                                            <td><b>RECUPERACION_CAPITAL</b></td>
                                            <td><b>RECUPERACION_MORATORIOS</b></td>
                                            <td><b>SALDO_ACTUAL</b></td>
                                            <td><b>MORATORIO</b></td>
                                            <td><b>FECHA_GESTION</b></td>
                                            <td><b>CARGO_AUTOMATICO</b></td>
                                            <td><b>ZONA</b></td>
                                            <td><b>GERENTE</b></td>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_tabla_pagos">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div id="test-swipe-4" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s12 m12 l12 center-align">
                                <h4>Descarga de Base General</h4>
                            </div>
                            <div class="col s12 m12 l12 center-align">
                                <a id="descargar_base" class="btn waves-effect waves-teal">Descargar Base</a>
                            </div>

                        </div>
                    </div>

                    <div id="test-swipe-5" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s12 m12 l12">
                                <h4>Reporte de horas Gestor</h4>
                            </div>
                            <div class="input-field col s12" >
                                <input id="desde_tiempos" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                <label class="" for="desde_tiempos"></label>
                                <input id="hasta_tiempos" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                <label class="" for="hasta_tiempos"></label>
                                <a id="enviar_tiempos" class="waves-effect waves-light btn blue"><i class="material-icons right-align">send</i></a> 
                                <a onclick="tableToExcel('datos_tabla_tiempos', 'PAGOS')" class="waves-effect waves-light btn green"><i class="material-icons right-align">explicit</i></a>
                                <a id="descarga_directa_tiempos" class="waves-effect waves-light btn blue">Descarga Directa</a>
                            </div>
                            <div id="datos_tabla_tiempos" class="col s12 m12 l12">
                                <table class="highlight" id="tabla_pagos">
                                    <thead class="blue">
                                        <tr class="text-white">
                                            <td><b>ID USUARIO</b></td>
                                            <td><b>NOMBRE</b></td>
                                            <td><b>FECHA</b></td>
                                            <td><b>HORA INICIAL</b></td>
                                            <td><b>TIEMPO CONECTADO</b></td>
                                            <td><b>SEMANA</b></td>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_tabla_tiempos">
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>


                </div>
            </div>
        </div>



        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/menu.js"></script>
        <script type="text/javascript" src="js/js/reportes.js"></script>
    </body>
</html>
