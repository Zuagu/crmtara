<%-- 
    Document   : lista_agendas
    Created on : 23/02/2021, 10:54:17 PM
    Author     : zuagu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Gestor Azteca</title>
        <link rel="shortcut icon" href="image/logoInco.fw.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor_black.css">
        <style>
            .img_log, #foto_perfil {
                width: 27px;
                margin: 1px;
                margin-top: 3px;
            }
            .div_tabla_agendas {
                height: 70vh;
            }
            .input-field input{
                color: white;
            }
            .input-field label{
                color: #E4EEF3 !important;
            }
            .div_tabla_agendas {
                color:  #E4EEF3 !important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header_3.jsp"/>
        <div class="row">
            <div class="col s12 m12 l12">
                <div class="col s12 m5 l5 offset-m1 offset-l1">
                    <h4 class="white-text">Lista de agendas</h4>
                </div>
                <div class="col s12 m5 l5">
                    <div class="col s6 input-field">
                        <input id="fecha" type="text" class="datepicker validate">
                        <label for="fecha">Fecha</label>
                    </div>
                    <div class="col s6 input-field">
                        <a id="select_agendas" class="btn waves-effect waves-light blue"><i class="material-icons right">send</i>Consultar</a>
                    </div>
                </div>
            </div>
            <div class="col s12 m12 l12">
                <div class="col s12 m10 l10 offset-m1 offset-l1 blue-grey darken-4 div_tabla_agendas">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>CLIENTE_UNICO</th>
                                <th>DESCRIPCION</th>
                                <th>FECHA_INSERT</th>
                                <th>FECHA_AGENDA</th>
                                <th>GESTOR</th>
                            </tr>
                        </thead>
                        <tbody id="tbody_agendas">

                        </tbody>
                    </table>
                </div>
            </div>

        </div>

        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/menu.js"></script>
        <script>
            $('#select_agendas').click(function () {
                $.ajax({
                    type: 'post',
                    url: 'ControllerGestor',
                    data: { action:'select_lista_agendas', fecha: $('#fecha').val() },
                    dataType: 'json',
                    success: function(_data) {
                        $('#tbody_agendas').empty();
                        for (let row of _data) {
                            $('#tbody_agendas').append('<tr>' +
                                '<td>' + row.ID_REGISTRO + '</td>' +
                                '<td>' + row.CLIENTE_UNICO + '</td>' +
                                '<td>' + row.DESCRIPCION + '</td>' +
                                '<td>' + row.FECHA_INSERT + '</td>' +
                                '<td>' + row.FECHA_AGENDA + '</td>' +
                                '<td>' + row.GESTOR + '</td>' +
                                '</tr>');
                        }
                    },
                    error: function(error) {
                        console.log(error);
                    }
                });
            });
        </script>
    </body>
</html>
