
<%-- 
Document   : predictivo.jsp
Created on : 04/06/2015, 12:22:36 AM
Author     : AYCM & LECA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
    <head>
        <title>ARCADE Software :: Predictivo</title>

        <!--FAVICON AND IPHONE ICONS-->
        <link rel="shortcut icon" href="http://leimihost.com/favicons/arcade-favicon.ico">

        <link rel="apple-touch-icon-precomposed" sizes="57x57" href="http://leimihost.com/favicons/arcade-57.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://leimihost.com/favicons/arcade-114.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://leimihost.com/favicons/arcade-72.png" />
        <!--FAVICON AND IPHONE ICONS-->

        <!--ARCADE CSS-->
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">

        <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <!--ARCADE CSS-->

        <!-- INICIA CALENDARIO -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>        
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>
        <script>
            $(function () {
                $(".datepicker").datepicker({changeMonth: true, changeYear: true, numberOfMonths: 1});
            });
        </script>
        <!-- TERMINA CALENDARIO -->

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-organigrama.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--        <link rel="stylesheet" type="text/css" href="css/style-operacion.css" media="screen"/>-->
        <script type="text/javascript" src="js/arcade-call-operacion.js"></script>

        <script type="text/javascript" src="js/arcade-estatus-llamada.js"></script>
        <script type="text/javascript" src="js/arcade-estatus-cuenta.js"></script>

        <script type="text/javascript" src="js/arcade-variable-post.js"></script>

        <script type="text/javascript" src="js/arcade-convenio.js"></script>

        <style>
            #barra_menus .div_boton_menu, #barra_menus .div_boton_menu_format {
                height:32px;
                width: 32px;
                cursor: pointer;
                float: left;
                margin-right: 5px;
                opacity: .8;
                border-radius: 4px;
                background:#424242;
                background-position: 0px 0px;
                background-repeat: no-repeat;
                background-size: 100%;
            }
            #barra_menus .div_boton_menu_selected {
                height:32px;
                width: 32px;
                cursor: pointer;
                float: left;
                margin-right: 5px;
                opacity: 1;
                border-radius: 4px;
                background:#424242;
                background-position: 0px 0px;
                background-repeat: no-repeat;
                background-size: 100%;
            }
            #relojes table tbody td input{
                width: 100%;
            }
            #insert_gestion{
                border-radius: 4px;background: #04B196;color: #FFF;border:none;padding: 4px 12px;width: 100%;font-size: 1.5rem;
            }
            #btnsiguiente{
                border-radius: 4px;background: #E14D57;color: #FFF;border:none;padding: 4px 12px;width: 100%;font-size: 1.2rem;
            }
            #insert_gestion_buzon{
                width: 50px;font-weight: bold;height: 50px;border-radius: 5px;background: #CF2222;color: #FFF;font-size: 13px;border: none;
            }
            #insert_gestion_promesa{
                width: 50px;font-weight: bold;height: 50px;border-radius: 5px;background: #2C8BD1;color: #FFF;font-size: 13px;border: none;
            }
            label{
                text-align: right;
            }
            .etiqueta_dinamica{
                text-align: right;
                font-size: 1rem;
            }
            #contactos td,#contactos th {
                padding: 6px 12px;
            }
            .select_eyc{
                padding-bottom: 3px;
                /*font-weight:bold;*/
                font-size:16px;
            }

            #gestion{
                padding-bottom: 3px;
                font-size:16px;
                height: 59px;
            }

            .tabla_gestor table tbody tr td{
                color: #303030;
                border-left: 1px solid #FFF;
                /*border-bottom: 1px solid #FFF;*/
                font-size: 11px;
                font-weight: normal;
                background: #f0f0f0 !important;
            }
            .tabla_gestor table tbody tr td input{
                color: #000000;
                font-weight: bold;
                font-size: 1.16rem;
            }
            textarea{
                border: solid 1px #a7a7a7;
                border-radius: 3px;
                padding: 2px 4px;
                font-weight: bold;
                font-size: 1.2rem;
            }

        </style>
    </head>

    <body style="background-image: url('images/background-cliente.png');">

        <!--BEGIN CONTENT-->
        <div style="width: 100%; height: 5px;float: left;background:#4267B2;"></div>

        <div class="contenedor-responsive">

            <!-- HERRAMIENTA PARA EL POP UP GUARDAR PROMESA -->
            <div id="div_registrar_convenio" class="datagrid sombra" style="position: absolute;
                 position: absolute;
                 left: 528px;
                 top: 261px;
                 width: 202px;
                 box-shadow: rgba(0, 0, 0, .60) 0px 0px 77px 265px;
                 display: none;
                 ">
                <table border="0">
                    <thead>
                        <tr>
                            <th colspan="2" style="text-align: center;">REGISTRAR CONVENIO...</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="width: 9%;text-align: right;"><img src="images/calendario16.png"></td>
                            <td><input id="fecha_promesa_pago" type="text" class="datepicker" placeholder="FECHA DEL PRIMER PAGO" readonly/></td>
                        </tr>
                        <tr>
                            <td style="width: 2%;text-align: right;"><img src="images/dinero.png"></td>
                            <td><input id="importe_convenio" type="text" value="0.00" class="flotante" placeholder="IMPORTE DEL PRIMER PAGO" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center;"><input id="insert_convenio" type="button" value="REGISTRAR" style="width: 50%;"></td>
                        </tr>
                    </tbody>
                </table>

            </div>            
            <!-- HERRAMIENTA PARA EL POP UP GUARDAR PROMESA-->

            <!-- TOOLS NEW -->
            <div style="width: 100%; height: 5px;float: left;"></div>

            <div id="barra_menus" class="datagrid" style="width: 99%;border:none;padding: 0px;background: transparent;">

                <div id="bm1" class="div_boton_menu" title="GESTIONES DE LA CUENTA." style="background-image: url('images/botones-operacion/btn1.png');"></div>
                <div id="bm2" class="div_boton_menu" title="REFERENCIAS BANCARIAS." style="background-image: url('images/botones-operacion/btn2.png');"></div>
                <div id="bm3" class="div_boton_menu" title="PAGOS DE LA CUENTA." style="background-image: url('images/botones-operacion/btn4.png');"></div>
                <!--                <div id="bm4" class="div_boton_menu" title="CUENTAS RELACIONADASDE LA CUENTA ACTUAL." style="background-image: url('images/botones-operacion/btn5.png');"></div>
                
                                <div id="bm5" class="div_boton_menu" title="MIS CUENTAS CON ESTATUS PR." style="background-image: url('images/botones-operacion/btn6.png');"></div>
                                <div id="bm6" class="div_boton_menu" title="MIS CUENTAS CON PROMESA INCUMPLIDA." style="background-image: url('images/botones-operacion/btn7.png');"></div>-->
                <div id="bm7" class="div_boton_menu" title="AGENDAS." style="background-image: url('images/botones-operacion/btn8.png');"></div>
                <div id="bm8" class="div_boton_menu" title="CALENDARIO Y NOTAS." style="background-image: url('images/botones-operacion/btn9.png');"></div>

                <div id="bm9" class="div_boton_menu" title="VISITAS A LA CUENTA." style="background-image: url('images/botones-operacion/btn10.png');"></div>
                <div id="bm10" class="div_boton_menu" title="CONVENIOS DE LA CUENTA." style="background-image: url('images/botones-operacion/btn11.png');"></div>
                <!--<div id="bm11" class="div_boton_menu" title="CALCULADORA." style="background-image: url('images/botones-operacion/btn12.png');"></div>-->
                <!--<div id="bm12" class="div_boton_menu" title="MIS PAGOS." style="background-image: url('images/botones-operacion/btn13.png');"></div>-->

                <div id="bm13" class="div_boton_menu" title="SCRIPTS." style="background-image: url('images/botones-operacion/btn14.png');"></div>
                <div id="bm14" class="div_boton_menu" title="MI CONFIGURACION." style="background-image: url('images/botones-operacion/btn15.png');"></div>
                <!--<div id="bm15" class="div_boton_menu" title="MI ESTADISTICA (PASTEL)." style="background-image: url('images/botones-operacion/btn16.png');"></div>-->

                <div id="consola" class="div_boton_menu_format consola" style="float:left;background:#000000;max-width:18%;width:230px;margin-right:0px;border-radius:4px 0 0 4px;opacity:1;color:#ECE000;padding:8px;font-weight: bold;"></div>
                <div id="consola2" class="div_boton_menu_format consola" style="float:left;background:#000000;max-width:20%;width:252px;border-radius:0 4px 4px 0;opacity:1;color:#ECE000;padding:8px;font-weight:bold;"></div>

                <input id="valor_f_seguimiento" type="hidden" value="0">
                <div id="f_seguimiento"></div>

                <div id="bm16" class="div_boton_menu" style="float: right;margin: 0px;width: 26%;border: 1px solid #9cb8c3;background: #FFF;background-image: url('images/i_lupa24.png');background-repeat: no-repeat;background-position-x:4px;background-position-y:4px;">
                    <input id="busqueda" type="text" class="filtro" placeholder="Escribe algo y presiona enter..." style="background: transparent;padding-left: 32px;height: 100%;color: #4A4A4A;font-size: 1.5rem;border:none;width: 100%;">
                </div>

            </div>

            <div style="width: 73%;float: left;">

                <!-- DATOS DE LOCALIZACION-->
                <div style="width: 100%; height: 5px;float: left;"></div>
                <div class="datagrid tabla_gestor" style="width: 99%;">
                    <table style="background-color: #E4EEF3;">
                        <thead>
                            <tr>
                                <th colspan="11" style="font-size: 12px;">DATOS DEL CLIENTE</th>
                            </tr>
                        </thead>
                        <tr style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 12px">
                            <td><label id="etiqueta1" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general1" type="button" readonly></td>
                            <td><label id="etiqueta2" class="etiqueta_dinamica"></label></td>
                            <td style="width: 25%;"><input type="text" id="dato_general2" readonly></td>
                            <td><label id="etiqueta3" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general3" readonly></td>
                            <td><label id="etiqueta4" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general4" readonly></td>
                        </tr>
                        <tr style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 12px">
                            <td><label id="etiqueta5" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general5" readonly></td>
                            <td><label id="etiqueta6" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general6" readonly></td>
                            <td><label id="etiqueta7" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general7" readonly></td>
                            <td><label id="etiqueta8" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general8" readonly></td>
                        </tr>
                        <tr style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 12px">
                            <td><label id="etiqueta9" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general9" readonly></td>
                            <td><label id="etiqueta10" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general10" readonly></td>
                            <td><label id="etiqueta11" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general11" readonly></td>
                            <td><label id="etiqueta12" class="etiqueta_dinamica"></label></td>
                            <td><input type="text" id="dato_general12" readonly></td>
                        </tr>
                    </table>
                </div>
                <!-- DATOS DE LOCALIZACION-->

                <!-- SALDOS -->
                <div style="width: 100%; height: 5px;float: left;"></div>
                <div class="datagrid tabla_gestor" style="width: 99%;">
                    <table style="background-color: #E4EEF3;">
                        <thead>
                            <tr>
                                <th colspan="11" style="font-size: 12px;">INFORMACIÓN ECONÓMICA DE LA CUENTA</th>
                            </tr>
                        </thead>
                        <tr style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 12px;">
                            <td align="right"><label id="etiqueta13" class="etiqueta_dinamica"></label></td>
                            <td style="width: 15%;"><input id="dato_general13" readonly type="text" ></td>
                            <td align="right"><label id="etiqueta14" class="etiqueta_dinamica"></label></td>
                            <td><input readonly type="text"  id="dato_general14"></td>
                            <td align="right"><label id="etiqueta15" class="etiqueta_dinamica"></label></td>
                            <td><input readonly type="text"  id="dato_general15"></td>
                            <td align="right"><label id="etiqueta16" class="etiqueta_dinamica"></label></td>
                            <td><input readonly type="text"  id="dato_general16"></td>
                        </tr>
                        <tr>
                            <td align="right"><label id="etiqueta17" class="etiqueta_dinamica"></label></td>
                            <td><input id="dato_general17" readonly type="text"  id=""></td>
                            <td align="right"><label id="etiqueta18" class="etiqueta_dinamica"></label></td>
                            <td><input id="dato_general18" readonly type="text"  id=""></td>
                            <td align="right"><label id="etiqueta19" class="etiqueta_dinamica"></label></td>
                            <td><input id="dato_general19" readonly type="text"  id=""></td>
                            <td align="right"><label id="etiqueta20" class="etiqueta_dinamica"></label></td>
                            <td><input id="dato_general20" readonly type="text"  id=""></td>
                        </tr>
                    </table>
                </div>
                <!-- SALDOS -->

            </div>

            <div style="width: 27%;float: right;padding: 0px 5px 0px 0px;border: none;height: 212px;overflow: auto;">

                <div style="width: 100%; height: 5px;float: left;"></div>
                <div id="numeros_contacto" class="datagrid" style="width: 100%;height: 207px;overflow: auto;"></div>

            </div>

            <!-- GESTION DE LA LLAMADA -->
            <div style="width: 100%; height: 5px;float: left;"></div>
            <div class="datagrid tabla_gestor" style="width: 99.3%;">
                <table style="background-color: #E4EEF3;">

                    <thead>
                        <tr>
                            <th colspan="2" style="font-size: 12px;">INFORMACIÓN EXTRA</th>
                            <th colspan="1" style="font-size: 12px;">DISPOSICION DE LA LLAMADA</th>
                            <th colspan="3" style="font-size: 12px;">CONCLUIR GESTIÓN</th>
                        </tr>
                    </thead>

                    <tr style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 9px">
                        <td style="min-width: 92px;" align="right"><label id="etiqueta21" class="etiqueta_dinamica"></label></td>
                        <td><input id="dato_general21" readonly type="text"  id=""></td>
                        <td rowspan="2" style="width: 61%;"><textarea rows="2" id="gestion" maxlength="255" value="" class="alfanumerico" style="resize: none;width: 100%;" tabindex="1"></textarea></td>
                        <td align="right"><b>ESTATUS:</td>
                        <td><select style="width: 100px;" id="id_estatus_cuenta" required="required" tabindex="2"><option value="0">SELECCIONE</option></select></td>

                        <td><input id='insert_gestion' type="button" value="OK" tabindex="4"></td>
                    </tr>

                    <tr style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 9px;">
                        <td align="right"><label id="etiqueta22" class="etiqueta_dinamica"></label></td>
                        <td><input id="dato_general22" readonly type="text"  id=""></td>
                        <td align="right"><b>CODIGO:</b></td>
                        <td><select style="width: 100px;" id="id_estatus_llamada" required="required" tabindex="3"><option value="0">SELECCIONE</option></select></td>

                        <td><input id="btnsiguiente"  type="button" value=" > " tabindex="5"></td>
                    </tr>

                </table>
            </div>
            <!-- GESTION DE LA LLAMADA -->

            <!-- CUADROS DE APPS -->
            <div style="width: 100%; height: 5px;float: left;"></div>
            <div class="datagrid" class="esconder_tool" style="width: 72%;margin-left: .4%;float: left;height:210px;overflow:auto;">

                <!-- GESTIONES -->
                <div id="divapp1" class="esconder_tool" style="height: 208px; overflow: auto;"></div>
                <!-- GESTIONES -->

                <!-- REFERENCIAS BANCARIAS -->
                <div id="divapp2" class="esconder_tool" style="display: none; height: 208px; overflow: auto;background: #F0F0F0;">
                    <table>
                        <thead>
                        <th>
                            REFERENCIAS BANCARIAS 
                        </th>
                        </thead>
                        <tr>
                            <td>
                                <textarea id="input_referencias_bancarias" class="sombra" rows="4" readonly style="margin-top: 6px;width: 99%; resize:none;font-size: 1.5rem;"></textarea>
                            </td>
                        </tr>
                    </table>
                </div>
                <!-- REFERENCIAS BANCARIAS -->

                <!-- PAGOS DE LA CUENTA -->
                <div id="divapp3" class="esconder_tool" style="display:none;height:208px;overflow: auto;"></div>
                <!-- PAGOS DE LA CUENTA -->

                <!-- CUENTAS RELACIONADAS -->  
                <div id="divapp4" class="esconder_tool" style="display:none;height:208px;overflow: auto;"></div>
                <!-- CUENTAS RELACIONADAS -->  

                <!-- PROMESAS DE PAGO --> 
                <div id="divapp5" class="esconder_tool" style="display:none;height:208px;overflow: auto;">

                </div>
                <!-- PROMESAS DE PAGO -->

                <!-- PROMESAS INCUMPLIDAS -->
                <div id="divapp6" class="esconder_tool" style="display:none;height:208px;overflow:auto;">

                </div>
                <!-- PROMESAS INCUMPLIDAS -->

                <!-- AGENDAR LLAMADA -->
                <div id="divapp7" class="esconder_tool" style="display:none;height:208px;overflow:auto;">
                    <table style="background-color: #E4EEF3;">
                        <thead>
                            <tr>
                                <th colspan="7" style='font-size: 12px;'>AGENDAR LLAMADA</th>
                            </tr>
                        </thead>
                        <tr>
                            <td style="width: 30%;text-align: right;"><b style="float: left;">AGENDAS EQUIPO</b>FECHA:</td>
                            <td><input id="fecha_agenda" class="datepicker" type="text" readonly></td>
                            <td>HORA:</td>
                            <td>
                                <select id="hora_agenda">
                                    <option value="07">7 AM</option>
                                    <option value="08">8 AM</option>
                                    <option value="09">9 AM</option>
                                    <option value="10">10 AM</option>
                                    <option value="11">11 AM</option>
                                    <option value="12">12 AM</option>
                                    <option value="13">1 PM</option>
                                    <option value="14">2 PM</option>
                                    <option value="15">3 PM</option>
                                    <option value="16">4 PM</option>
                                    <option value="17">5 PM</option>
                                    <option value="18">6 PM</option>
                                    <option value="19">7 PM</option>
                                    <option value="20">8 PM</option>
                                    <option value="21">9 PM</option>
                                </select>
                            </td>
                            <td>MINUTO:</td>
                            <td>
                                <select id="minuto_agenda">
                                    <option value=":00:00">00</option>
                                    <option value=":05:00">05</option>
                                    <option value=":10:00">10</option>
                                    <option value=":15:00">15</option>
                                    <option value=":20:00">20</option>
                                    <option value=":25:00">25</option>
                                    <option value=":30:00">30</option>
                                    <option value=":35:00">35</option>
                                    <option value=":40:00">40</option>
                                    <option value=":45:00">45</option>
                                    <option value=":50:00">50</option>
                                    <option value=":55:00">55</option>
                                </select>
                            </td>
                            <td><input id="insert_agenda" type="button" value="AGENDAR LLAMADA"></td>
                        </tr>
                    </table>
                    <div id="listado_agendas_pareja" class="datagrid sombra" style="width: 97%;height: 132px;overflow: auto;margin-top: 6px;"></div>
                </div>
                <!-- AGENDAR LLAMADA -->

                <!-- CALENDARIO Y NOTAS -->
                <div id="divapp8" class="esconder_tool" style="display:none;height:208px;overflow: auto;">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="7" style='font-size: 12px;'>VER CALENDARIO O GUARDAR NOTA</th>
                            </tr>
                        </thead>
                        <tr>
                            <td style="width: 3%;"><img src="images/calendario16.png"></td>
                            <td style="width: 100px; text-align:center;"><input class="datepicker" type="text" placeholder="CALENDARIO" readonly></td>
                            <td>NOTA:</td>
                            <td style="width:60%;"><input id="nota" style="width:98%;" class="alfanumerico"></textarea></td>
                            <td><input id="insert_nota" type="button" value="GUARDAR NOTA"></td>
                        </tr>
                    </table>
                    <div id="listado_notas" class="datagrid sombra" style="width: 97%;height: 124px;color: #000;margin-top: 10px;overflow: auto;"></div>
                </div>
                <!-- CALENDARIO Y NOTAS -->

                <!-- GESTIONES VISITA -->
                <div id="divapp9" class="esconder_tool" style="display:none;height:208px;overflow: auto;">
                    <div style="padding: 20px 40px;color: #9CB8C3;text-align: center;">
                        <h4>
                            Aquí verás las gestiones domiciliarias de la cuenta.<br>
                            Pronto estará disponible.
                        </h4>
                        <img src="images/e_embarrass-128.png" alt="" style="width: 32px;"><br>
                    </div>
                </div>
                <div id="divapp9" class="esconder_tool" style="display:none;height:208px;overflow: auto;">
                    <iframe src="reloj.jsp" frameborder="0" style=" width: 100%;height: 230px !important;"></iframe>
                </div>
                <!-- GESTIONES VISITA -->

                <!-- CONVENIO -->
                <div id="divapp10" class="esconder_tool" style="display:none;height:208px;overflow: auto;background: #F0F0F0 !important">
                    <table  style="background-color: #F0F0F0 !important;">
                        <thead>
                            <tr>
                                <th colspan="7" style="font-size: 12px;">CONVENIOS DE PAGO</th>
                            </tr>
                        </thead>
                        <tr>
                            <td style="padding-top: 10px;text-align: left;">
                                <input id="select_mis_convenios" type="button" value="MIS CONVENIOS" style="width: 50%;">
                            </td>
                            <td></td>
                            <td style="text-align: right;"></td>
                            <td style="text-align: right;"></td>
                            <td style="text-align: right;"></td>
                            <td style="text-align: right;"></td>
                        </tr>
                    </table>
                    <div id="listado_convenios" class="datagrid sombra" style="width: 99%;height: 120px;color: #000;margin-top: 10px;overflow: auto;"></div>
                </div>
                <!-- CONVENIO -->

                <!-- MIS PAGOS -->
                <div id="divapp12" class="esconder_tool" style="display:none;height:208px;overflow: auto;">
                    <table style="width:100%;margin: 0px auto;background-color: #E4EEF3;">
                        <thead>
                            <tr>
                                <th style="font-size: 12px;">PAGOS DE MI EQUIPO DURANTE MI ASIGNACION ACTUAL</th>
                            </tr>
                        </thead>
                        <tr>
                            <td>
                                <div id="pagos_equipo" class="datagrid sombra" style="width: 100%;height: 195px;"></div>    
                            </td>
                        </tr>
                    </table>
                </div>
                <!-- MIS PAGOS -->

                <!-- SPEECHES -->
                <div id="divapp13" class="esconder_tool" style="display:none;height:208px;overflow: auto;">
                    <table style="background-color: #F0F0F0;">
                        <thead>
                            <tr>
                                <th  style="font-size: 12px;">SPEECHES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td  style="font-size: 1.5rem">
                                    <div id="speech_cuenta" class="datagrid sombra" style="width: 100%;height: 160px;color: #000;margin: 6px 0 11px 0;overflow: auto;"></div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- SPEECHES -->

                <!-- CONFIGURACION-->
                <div id="divapp14" class="esconder_tool sombra" style="display:none;height:208px;overflow: auto;background: #F0F0F0 !important;">
                    <table style="background-color: #F0F0F0 !important;">
                        <thead>
                            <tr>
                                <th style='width:10%;text-align:center;'><img src='images/i_filter.png'>CON CRs?</th>
                                <th style='width:6%;text-align:center;'><img src='images/dinero.png'> >=</th>
                                <th style='width:10%;text-align:center;'>ORDEN</th>
                                <th colspan='2' style='width:30%;text-align:center;'><img src='images/i_filter.png'>ESTATUS</th>
                                <th style='width:5%;text-align:center;'><img src='images/i_star1.png'></th>
                                <th style='width:4%;text-align:center;'></th>
                                <th style='width:5%;text-align:center;'>CUENTAS</th>
                            </tr>
                        </thead>

                        <tr id="ajustes_estrategia_gestor"></tr>

                        <tr id="mostrar_estatus_estrategia" style="display: none;">
                            <td style="width: 55%;text-align: right;">ESTATUS: </td>
                            <td style="width: 18%;text-align: center;">
                                <select id="id_estatus" class="alfanumerico"></select>
                            </td>
                            <td></td>
                        </tr>
                        <thead>
                            <tr>
                                <th colspan="8">SOLICITUD DE NUEVO NUMERO DE CONTACTO</th>
                            </tr>
                        </thead>
                        <tr>
                            <td colspan="5" style="width: 50%;"></td>
                            <td style="text-align: right;">NÚMERO:</td>
                            <td style="width: 10%;"><input id="id_nuevo_numero_contacto" type="text" style="text-align: center;font-weight: bold;"></td>
                            <td>
                                <input id="insert_nuevo_numero_contacto" type="button" value="REGISTRAR"/>
                            </td>
                        </tr>
                    </table>
                </div>
                <!-- CONFIGURACION-->

                <!-- GENERAR PASTEL -->
                <div id="divapp15" class="esconder_tool" desc="generar_pastel"  style="display:none;height:208px;overflow: auto;">
                    <table style="width:100%;margin: 0px auto;background-color: #E4EEF3;">
                        <thead>
                            <tr>
                                <th style="font-size: 12px;">RESUMEN DE MIS CUENTAS</th>
                            </tr>
                        </thead>
                        <tr>
                            <td>
                                <input id="select_pastel_gestor" style="width: 18%;margin-left: 5px;float: right;margin-right: 5px;" type="button" value="GENERAR">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div id="mi_pastel" class="datagrid" style="width:99%;height:176px;"></div>
                            </td>
                        </tr>
                    </table>
                </div>
                <!-- GENERAR PASTEL -->

                <!-- BUSQUEDA -->
                <div id="divapp16" class="esconder_tool" style="display:none;height:208px;overflow:auto;">
                    <div style="padding: 20px 40px;color: #9CB8C3;text-align: center;">
                        <h4>
                            Ahora escribe algo en la barra de la parte superior derecha y presiona enter para obtener los resultados.<br>
                            Puedes escribir números de teléfono, el nombre del titular o el de alguna referencia...<br>
                            También el número de cuenta.
                        </h4>
                        <img src="images/e_surprise-128.png" alt="" style="width: 32px;"><br>
                    </div>
                </div> 
                <!-- BUSQUEDA -->

                <!-- TERMINAN LOS DIVS-->
            </div>
            <!-- CUADROS DE APPS -->

            <!-- RELOJES -->
            <div id='relojes' class="datagrid tabla_gestor" style="width: 27%;background-color: #0AE90A;height:210px;">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2" style='font-size: 12px;'>CONTROL DE TIEMPOS</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr><td style="width: 50%;"><b>PRIMER LLAMADA:</b></td><td><input id="hora_entrada" type="text" value="00:00:00" ></td></tr>
                        <tr><td><b>ACTUAL:</b></td><td><input id="reloj_llamada_actual" type="text" value="00:00:00" readonly></td></tr>
                        <tr><td><b>CUENTAS:</b></td><td><input id="contador_cuentas" type="text" readonly></td></tr>
                        <tr><td><b>LLAMADAS:</b></td><td><input id="contador_llamadas" type="text" readonly></td></tr>
                        <tr><td><b>R. ACTUAL:</b></td><td><input id="retraso_actual" type="text" value="00:00:00" readonly></td></tr>
                        <tr style="display: none;"><td><b>ESTRATEGIA:</b></td><td><input id="estrategia" type="text" value=" " readonly></td></tr>
                        <tr><td><b>CONVENIOS:</b></td><td><input id="cuentas" type="text" value="0" readonly></td></tr>
                    </tbody>
                </table>
            </div>
            <!-- RELOJES -->

            <input id="telefono" type="text" style="display: none;">
            <input id="cuenta" type="text" style="display: none;">
            <input id="agente" type="text" style="display: none;">
            <input id="id_campana" type="text" style="display: none;">
            <!-- MARCACION -->
            <!--<object type="text/html" data="webphone/esoftphone.html" style="width: 16%;height: 320px;margin: 0 .5%;float: right;border-radius: 5px;"></object>-->
            <!-- MARCACION -->

            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->

            <!-- CAJA ESTATUS-->
            <div id="caja_estatus" style="width:94%;max-width:540px;text-align: center;display: none;position: absolute;left: 500px;top: 110px;">
                <div id="listado_estatus_cuenta" class="datagrid sombra" style="width:94%;height: 350px;max-width:520px;overflow:auto;"></div>
                <br>
                <input id="finalizar" value="FINALIZAR" type="button" style="width: 120px;">
            </div>
            <!-- CAJA ESTATUS-->

            <input id="id_usuario_actualizar" type="hidden">
            <input id="cadena_estatus" type="hidden">
            <input id="estatus" type="hidden">

            <!--CORE JAVASCRIPT-->
        </div>

        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(
                    function () {

                        // EXCLUSIVO PREDICTIVO
                        var _telefono = obtener_variable_post('tel');
                        _telefono = _telefono.substr(_telefono.length - 10);
                        var _agente = obtener_variable_post('gestor');
                        var _agenteda = _agente.split("Agent%2F");
                        _agente = _agenteda[1];
                        var _cuenta = obtener_variable_post('cuenta');
                        var _marcando = obtener_variable_post('marcando');

                        $("#telefono").val(_telefono);
                        $("#agente").val(_agente);
                        $("#cuenta").val(_cuenta);

                        // LE INDICAMOS AL AGENTE QUE NUMERO SE ESTA MARCANDO...
                        $("#consola").empty();
                        $("#consola").append("MARCANDO A " + _marcando.toString().toUpperCase());

                        select_datos_cuenta(_cuenta);

                        // EXCLUSIVO PREDICTIVO

                        select_etiquetas_puesto_usuario(_agente);

                        select_estatus_puesto_combo(_agente, "id_estatus");
                        select_estatus_puesto_combo(_agente, "id_estatus_cuenta");
                        select_estatus_llamada_combo("id_estatus_llamada", true);

                        fecha_hoy("fecha_agenda");
                        fecha_hoy("fecha_promesa_pago");

                        select_llamadas_gestor2(_agente);

                    }
            );

            //==================================================================
            $("#insert_nuevo_numero_contacto").click(
                    function () {
                        var _numero = $("#dato_general1").val();
                        if (es_entero(_numero)) {
                            insert_nuevo_numero_contacto(
                                    $('#agente').val(),
                                    $("#dato_general1").val(),
                                    $("#id_nuevo_numero_contacto").val()
                                    );
                        } else {
                            $("#consola").empty();
                            $("#consola").append('INVALIDO');
                        }
                    }
            );
            //==================================================================
            $("#btnsiguiente").click(
                    function () {
                        alert($('#cuenta').val());
                        alert($('#agente').val());
                        alert($('#telefono').val());
                    }
            );
            //==================================================================
            $("#insert_gestion").click(
                    function () {

                        if ($("#gestion").val() == "" || $("#id_estatus_cuenta").val() == null) {
                            alert("INGRESE DISPOSICION DE LLAMADA.\n\
                \n\
VERIFICA QUE PUEDAS ELEGIR UN ESTATUS, DE NO SER ASI, SOLICITA A\n\
SISTEMAS INGRESAR TU USUARIO A UN EQUIPO DE LA OPERACION.");
                        } else {

                            if ($("#id_estatus_cuenta").val() == 0) {
                                $("#consola").empty();
                                $("#consola").append('SELECCIONE UN ESTATUS...');
                            } else {
                                insert_gestion(
                                        $("#cuenta").val(), // PREDICTIVO
                                        $("#telefono").val(), // PREDICTIVO
                                        $("#id_estatus_cuenta").val(),
                                        $("#id_estatus_llamada").val(),
                                        $("#agente").val(), // PREDICTIVO
                                        $("#gestion").val(),
                                        $("#reloj_llamada_actual").val(),
                                        $("#retraso_actual").val(),
                                        $("#dato_general3").val(),
                                        true, // PREDICTIVO,
                                        1  // F_PREDICTIVO
                                        );
                            }
                        }

                    }
            );
            //==================================================================
            var tiempo_llamada_actual = setInterval(function () {
                cronometro_llamada_actual($("#agente").val());
            }, 1000);
            //==================================================================
            //================ BOTONES DEL MENU ================================
            //==================================================================
            $("#bm1").dblclick(function () {
                select_gestiones_cuenta_todas($("#dato_general1").val(), "divapp1");
            }
            );
            //==================================================================
            $("#bm2").click(function () {
                select_referencias_bancarias(
                        $("#dato_general1").val(),
                        "input_referencias_bancarias"
                        );
            }
            );
            //==================================================================                    
            $("#bm3").click(function () {
                select_pagos_cuenta_tabla(
                        $("#dato_general1").val(),
                        "divapp3"
                        );
            }
            );
            //==================================================================
            $("#bm4").click(
                    function () {
                        if ($("#dato_general1").val() != "") {
                            select_cuentas_relacionadas(
                                    $("#dato_general1").val(),
                                    "divapp4"
                                    );
                        }
                    }
            );
            //==================================================================
            $("#bm5").live("click",
                    function () {
                        listado_por_estatus_gestor(
                                $('#agente').val(),
                                10,
                                "divapp5"
                                ); // estatus 10: PRs
                    }
            );
            //==================================================================
            $("#bm6").live("click",
                    function () {
                        listado_por_estatus_gestor(
                                $('#agente').val(),
                                11,
                                "divapp6"
                                ); // estatus 11: PIs
                    }
            );
            //==================================================================
            $("#bm7").live("click",
                    function () {
                        select_agendas_pareja(
                                $('#agente').val(),
                                "listado_agendas_pareja"
                                );
                    }
            );
            $("#insert_agenda").live("click",
                    function () {
                        insert_agenda(
                                $('#agente').val(),
                                $("#dato_general1").val(),
                                $("#fecha_agenda").val(),
                                $("#hora_agenda").val() + $("#minuto_agenda").val(),
                                "listado_agendas_pareja"
                                );
                    }
            );
            // INICIA FUNCION PARA VER DETALLES DEL ELEMENTO EN ESPECIFICO
            $("input.datos_cuenta_agenda").live("click",
                    function () {
                        marcar_agenda_vista($(this).closest("tr").attr("id"), $("#cuenta" + $(this).closest("tr").attr("id")).val());
                    }
            );
            //==================================================================
            $("#bm8").click(
                    function () {

                        select_notas_equipo(
                                $('#agente').val(),
                                "listado_notas"
                                );
                    }
            );
            $("#insert_nota").click(
                    function () {
                        if ($("#nota").val() != "") {
                            insert_nota(
                                    $('#agente').val(),
                                    $("#nota").val(),
                                    "listado_notas"
                                    );
                        }
                    }
            );
            $(".delete_nota").live("click",
                    function () {

                        var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                        if (confirma) {
                            delete_nota($(this).closest("tr").attr("id"));
                        }

                    }
            );
            //==================================================================
            $("#bm9").click(
                    function () {
                        select_gestiones_cuenta($("#dato_general1").val(), "divapp1");
                    }
            );

            //==================================================================
            $("#bm10").click(
                    function () {
                        select_convenio_cuenta_tabla(
                                $("#dato_general1").val(),
                                "listado_convenios"
                                );
                    }
            );

            $("#insert_convenio").click(
                    function () {
                        if ($("#fecha_promesa_pago").val() == "" || $("#importe_convenio").val() == "") {
                            $("#consola").empty();
                            $("#consola").append('INGRESE VALORES');
                        } else {
                            insert_convenio(
                                    $("#importe_convenio").val(),
                                    $("#fecha_promesa_pago").val(),
                                    $('#agente').val(),
                                    $("#dato_general1").val()
                                    );
                        }
                    }
            );
            $(".delete_convenio").live("click",
                    function () {
                        delete_convenio(
                                $(this).closest("tr").attr("id"),
                                $('#agente').val()
                                );
                    }
            );

            $("#select_mis_convenios").click(function () {
                select_convenio_gestor_tabla(
                        $('#agente').val(),
                        "listado_convenios"
                        );
            });
            //==================================================================
            $("#bm12").click(
                    function () {
//                        cargar pagos de la asignacion del equipo del gestor...
                    }
            );
            //==================================================================
            $("#boton_mis_pagos").click(
                    function () {
                        cargar_mis_pagos();
                    });
            //==================================================================
            $("#bm13").click(
                    function () {

                        select_speech_cuenta();
                    }
            );
            //==================================================================
            $("#bm14").click(
                    function () {
                        select_estrategia_combo(
                                $('#agente').val(),
                                "id_estrategia"
                                );
                    }
            );
            $("#update_estrategia_gestor").click(
                    function () {
                        update_estrategia_gestor(
                                $('#agente').val(),
                                $('#id_estrategia').val(),
                                $('#id_estatus').val()
                                );
                        select_llamadas_gestor($('#agente').val());
                        $(".esconder_tool").hide();
                        $("#divapp1").show();
                    }
            );
            //==================================================================
            // PASTEL        
            $("#bm15").click(
                    function () {
                        alert("pastel");
                    }
            );
            //==================================================================
            $("#bm16").keyup(function (e) {
                if (e.keyCode == 13) {
                    select_buscar_cuentas($("#busqueda").val(), "divapp16");
                }
            });
            //==================================================================
            //================ BOTONES DEL MENU ================================
            //==================================================================
            $(".consola").dblclick(
                    function () {
                        $(this).empty();
                    }
            );
            //==================================================================
            $(".div_boton_menu").live("click", function () {
                $(".div_boton_menu").removeClass("div_boton_menu_selected");
                $(this).addClass('div_boton_menu_selected');
                $(".esconder_tool").hide();
                var _x = $(this).attr("id");
                _x = _x.split("bm");
                var _id = _x[1];
                $("#divapp" + _id).show();
            });
            //==================================================================
            $(".cuenta_encontrada").live("click", function () {
                select_datos_cuenta($(this).closest("tr").attr("id"));
                $(".esconder_tool").hide();
                $("#divapp1").show();
            });
            //==================================================================
            $("#f_seguimiento").click(function () {

                if ($("#dato_general1").val() != "") {

                    if ($("#valor_f_seguimiento").val() == 0) {
                        $("#valor_f_seguimiento").val(1);
                    } else {
                        $("#valor_f_seguimiento").val(0);
                    }

                    update_f_seguimiento_cuenta(
                            $("#dato_general1").val(),
                            $("#valor_f_seguimiento").val()
                            );
                    $(this).empty();
                    $(this).append("<img src='images/i_star" + $("#valor_f_seguimiento").val() + ".png' alt='' title='DARLE SEGUIMIENTO ESPECIAL A ESTA CUENTA' style='margin: 5px 0px 0px 7px; float: right; cursor: pointer;'>");
                }

            });
            //==================================================================
            $("#id_estrategia").change(function () {
                if ($("#id_estrategia").val() == 2) {
                    $("#mostrar_estatus_estrategia").show();
                } else {
                    $("#mostrar_estatus_estrategia").hide();
                }
            });
            //==================================================================
            $("#id_estatus_llamada").change(function () {
                if ($("#id_estatus_llamada").val() == 1) {
                    $("#div_registrar_convenio").show();
                } else {
                    $("#div_registrar_convenio").hide();
                }
            });
            //==================================================================
            $(".a_marcar").live("click", function () {
                if ($(this).text() == "") {
                    $("#consola").empty();
                    $("#consola").append($(this).val() + " ES EL NUMERO A MARCAR.");
                }
            });
            //==================================================================
            // ARCADE Software®
        </script>
    </body>
</html>
