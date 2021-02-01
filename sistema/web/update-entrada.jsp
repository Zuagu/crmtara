<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta name="theme-color" content="#212f3d"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Entradas</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link rel="stylesheet" type="text/css" media="screen" href="movil/materialize/css/materialize.min.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet">


        <style type="text/css">
            html {
                background: -webkit-linear-gradient(top, rgba(128, 139, 150,0.9) 50%,  rgba(33, 47, 60, 0.7) 100%); /* Chrome10+,Safari5.1+ */
                background-image: linear-gradient(to right bottom, rgba(33, 47, 60), rgb(128, 139, 150));
                height: -webkit-fill-available;
                height: 100%;
            }

            .buscar[type=text]:not(.browser-default) {

                height: 3rem;
                background-color: rgba(175, 175, 175, 0.41);
                text-align: center;
                border-radius: 5px;
                margin: -2px 0 2px 0;
                color: #ecffff;
                font-size: 18px;
            }

            #modal_config input[type=text]:not(.browser-default):focus:not([readonly]) {
                border-bottom: 1px solid #e02020;
                -webkit-box-shadow: 0 1px 0 0 #a62626;
                box-shadow: 0 1px 0 0 #e02020;
            }

            html {
                font-size: 13px;
            }

            td,
            th {
                padding: 10px 5px;
            }
            td{
                padding: auto 0px;
            }
            #lista_entradas {
                max-height: 525px;
                overflow: auto;
                background-color: #212f3d;
                border-radius: 5px;
                color: #FFF;
            }

            .modal {
                width: 90%;
                max-height: 80%;
            }

            .imagen {
                border-radius: 10px;
            }

            .decoracion1 {
                width: 80%;
                height: 300px;
                background-color: #5e5e5e;

            }

            #modal_update {

                background-color: #212f3d;
                background-image: linear-gradient(to right bottom, rgba(33, 47, 60), rgb(128, 139, 150));
                /*background-color: rgb( 33, 47, 60 );*/
                border-radius: 5px;
                color: #FFF;
            }

            .modal input[type=text]:not(.browser-default) {
                background-color: rgba(0, 0, 0, 0.35);

                color: #FFF;
                border-radius: 5px;
            }

            .timepicker-digital-display {
                background-color: #ad0c00;
            }

            @media only screen and (min-width: 600px) {
                .modal {
                    width: 25%;
                }

                .timepicker-modal {
                    width: 90%;
                }
                .datepicker-modal {
                    width: 51%;
                }
            }

            .boton {
                background-color: rgba(0, 0, 0, 0.2);
                border-radius: 5px;
            }

            .rodar {
                -webkit-animation: spin 1s infinite linear;
            }

            #recargar {
                -webkit-transition: -webkit-transform .8s ease-in-out;
                -ms-transition: -ms-transform .8s ease-in-out;
                transition: transform .8s ease-in-out;
            }
            #config {
                -webkit-transition: -webkit-transform .8s ease-in-out;
                -ms-transition: -ms-transform .8s ease-in-out;
                transition: transform .8s ease-in-out;
            }

            @-webkit-keyframes spin {
                0% {
                    -webkit-transform: rotate(360deg);
                }

                100% {
                    -webkit-transform: rotate(0deg);
                }
            }

            #modal_config {
                background-image: linear-gradient(to right bottom, rgba(33, 47, 60), rgb(128, 139, 150));
                color: #FFF;
                border-top: 2px solid #5e5e5e;
                border-radius: 10px;
            }
            .dropdown-content {
                background-color: #212f3d;
            }
            .select-dropdown {
                text-align: center;
            }
            .datepicker-container {
                color: #000000;
            }
            .target{
                background-image: linear-gradient(to right bottom, rgba(56, 55, 55, 0.44), rgba(255, 2, 2, 0.64));
            }
            #enviar{
                border-radius: 4px;
            }
            .datepicker-date-display {
                background-color: #ad0c00;
            }
            .inner::-webkit-scrollbar {
                width: 0px;
                height: 0px;
                background: red;
            }
            .inner::-webkit-scrollbar-thumb {
                width: 0px;
                height: 0px;
                background: red;
            }
            #modal_status {
                height: 230px;
                background-image: linear-gradient(to right bottom, rgba(33, 47, 60), rgb(128, 139, 150));
            }
            #alerta_update {
                background-image: linear-gradient(to right bottom, #000, rgb(36, 1, 1));
                border: 1px solid red;
            }

        </style>

    </head>

    <body>



        <div class="container">
            <div class="row">
                <div class="col s12 white-text center">
                    <h5>Hora Entrada</h5>
                    <h6 id="la_fecha"></h6>
                </div>
                <div id="panel_opciones" class="col s2 m1 offset-m3  center waves-effect boton">
                    <i class="material-icons" id="config" style="font-size: 2.5rem;color: #fff;">settings</i>
                </div>
                <div class="col s8 m4 ">
                    <input placeholder="Buscar" id="filtro" type="text" class="validate buscar">
                </div>
                <div id="icono" class="col s2 m1 center waves-effect boton">
                    <i id="recargar" class="material-icons" style="font-size: 2.5rem;color: #fff;">sync</i>
                </div>
            </div>

            <div class="row">
                <div id="lista_entradas" class="col s12 z-depth-1 inner ">

                    <table id="entradas" class="highlight">
                        <thead class="">
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Entrada</th>
                                <th>Salida</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="cuerpo_tabla">
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

        <div id="modal_update" class="modal">
            <div class="modal-content center" style="height: 500px; padding:0px;">
                <div class="row">
                    <div class="col s12">
                        <h5 id="datos_usu"></h5>
                        <input id="id_usuario" type="hidden">
                        <input id="registro" type="hidden">
                    </div>

                    <div id="foto_usuario" class="col s8 offset-s2">

                    </div>

                    <div class="col s10 offset-s1" style="margin-bottom: 20px">
                        <h6>Datos de Entrada</h6>

                        <div class="input-field col s6 ">
                            <input placeholder="Hora Entrada" id="entrada" type="text" class="timepicker" style="text-align: center;">
                            <label for="entrada">Hora Entrada</label>
                        </div>

                        <div class="input-field col s6">
                            <input placeholder="Hora Salida" id="salida" type="text" class="timepicker" style="text-align: center;">
                            <label for="salida">Hora Salida</label>
                        </div>
                        <div class="input-field col s12">
                            <textarea id="comentario" class="materialize-textarea white-text" placeholder="" style="text-transform: uppercase; font-weight: bold;"></textarea>
                            <label for="comentario">Anexo:</label>
                        </div>
                    </div>


                </div>
            </div>

            <div class="row">
                <div class="col s10 offset-s1" style="margin-bottom: 20px">
                    <div class="col s6 left-align">
                        <a class="modal-close waves-effect red waves-light btn">Cancelar</a>
                    </div>
                    <div class="col s6 right-align">
                        <a id="update_hora" class="modal-close waves-effect blue waves-light btn">Actualizar</a>
                    </div>
                </div>
            </div>

        </div>


        <!-- Modal Structure -->
        <div id="modal_config" class="modal bottom-sheet">

            <div class="row">
                <div class="modal-content col s12">
                    <div class="input-field col s10 offset-s1">
                        <input id="fecha" type="text" class="datepicker validate center-align">
                        <label for="fecha">Fecha</label>
                    </div>
                    <div class="input-field col s10 offset-s1">
                        <select id="region">
                            <option value="0">Todos</option>
                            <option value="1">Monterrey</option>
                            <option value="2">Puebla</option>
                        </select>
                        <label>Sucursal</label>
                    </div>
                    <div class="col s10 offset-s1 center-align">
                        <a id="enviar" class="modal-close waves-effect blue white-text waves-blue btn col s12 center-align">Aplicar</a>
                    </div>

                </div>

            </div>

        </div>

        <div id="modal_status" class="modal">
            <div class="row col s12">
                <div class="modal-content">
                    <h4 class="center-align white-text">Estatus entrada</h4>
                    <div class="input-field col s10 offset-s1">
                        <select id="status">
                            <option value="1">Temprano</option>
                            <option value="2">Tarde</option>
                        </select>
                        <label>Estatus</label>
                    </div>
                    
                    <a id="act_horario" class="modal-close waves-effect waves-green blue btn col s10 offset-s1">Continuar</a>
                </div>
            </div>
        </div>
        
        <div id="alerta_update" class="modal">
            <div class="row col s12">
                <div class="modal-content">
                    <h4 class="center-align white-text">Alerta <br> usted no esta Autorizado a modificar las horas de Entrada. <br> Este registro se guardara para validar los datos a cambiar</h4>
                    <a class="modal-close waves-effect waves-green blue-grey btn col s10 offset-s1">Continuar</a>
                </div>
            </div>
        </div>




        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="movil/materialize/js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="movil/materialize/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js_movil_entradas.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('.modal').modal();
                $('.timepicker').timepicker({
                    default: 'now',
                    twelveHour: false,
                    container: 'body'
                });
                select_datos_entradas(0, "0000-00-00");
                $('select').formSelect();

                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd',
                    container: 'body'
                });

            });
            var usuarios;

            /* _________________________________________________________________________ */
//            $("#update_hora").click(function () {
//                update_hora_entrada($("#id_usuario").val(), $("#entrada").val(), $("#salida").val());
//            });
            /* _________________________________________________________________________ */
            $("#icono").click(function () {
                $("#recargar").addClass("rodar");
                if ($("#fecha" == "")) {
                    select_datos_entradas(0, "0000-00-00");
                } else {
                    select_datos_entradas($("#region").val(), $("#fecha").val());
                }
                window.setTimeout(() => {
                    $("#recargar").removeClass("rodar");
                }, 1000);
            });
            /* _________________________________________________________________________ */
            $("#panel_opciones").click(function () {
                $("#modal_config").modal('open');
            });
            /* _________________________________________________________________________ */

            /* _________________________________________________________________________ */
            $("#panel_opciones").click(function () {
                $("#config").addClass("rodar");
                window.setTimeout(() => {
                    $("#config").removeClass("rodar");
                }, 1000);
            });
            /* _________________________________________________________________________ */
            $("#enviar").click(function () {
                select_datos_entradas($("#region").val(), $("#fecha").val());
            });
            /* _________________________________________________________________________ */
            $("#update_hora").click(function () {
                insert_comentarios($("#comentario").val(), $("#registro").val());
            });
            /* _________________________________________________________________________ */
            $("#act_horario").click(function () { //salida
                if ($('#usuario_sistema', parent.document).val() == "1433" && $('#usuario_sistema', parent.document).val() == "1432") {
                    update_hora_emtrada($("#registro").val(), $("#entrada").val(), $("#salida").val(), $("#status").val());
                } else {
                    $("#alerta_update").modal('open');
                }
                
            });
            /* _________________________________________________________________________ */
            /* _________________________________________________________________________ */
            /* _________________________________________________________________________ */
            document.querySelector("#filtro").onkeyup = function () {
                $TableFilter("#entradas", this.value);
            }
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
            }

        </script>
    </body>

</html>