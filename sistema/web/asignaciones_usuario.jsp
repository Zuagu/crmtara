<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="image/logoInco.fw.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Asignacion usuarios</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/usuarios.css">
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor.css">

    </head>

    <body>
        <jsp:include page="header.jsp"/>

        <div class="row">
            <div class="col s12"></div>
            <div class="col s10 m10 l10 offset-s1 offset-m1 offset-l1">
                <div class="col s12 m12 l12 z-depth-2 inner actualizar_todos white">
                    <h5 class="col s12 m4 l4">Ordenar todos</h5>
                    <div class="input-field col s6 m3 l3">
                        <select id="ultima_gestion_order_todos">
                            <option value="asc">Mas Antiguo</option>
                            <option value="desc">Mas Reciente</option>
                        </select>
                        <label for="ultima_gestion_order_todos">Ultima Gestion Todos</label>
                    </div>
                    <div class="input-field col s6 m3 l3">
                        <select id="importe_order_todos">
                            <option value="asc">Menor a Mayor</option>
                            <option value="desc">Mayor a Menor</option>
                        </select>
                        <label for="importe_order_todos">Importe Todos</label>
                    </div>
                    
                    <div class="input-field col s6 m1 l1">
                        <a id="act_todos" class="btn-small waves-effect blue">Actualizar</a>
                    </div>
                </div>
            </div>
            <div class="col s10 m10 l10 offset-s1 offset-m1 offset-l1">
                <div class="col s12 m12 l12 z-depth-2 inner white">
                    <table>
                        <thead>
                            <tr>
                                <th>Gestor</th>
                                <th>Cantidad</th>
                                <th>Importe</th>
                                <th>Orden Fecha Gestion</th>
                                <th>Orden Importe</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="tbody_asignaciones_gestor">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Modal Structure -->
        <div id="modal_data_asignacion" class="modal">
            <div class="modal-content">
                <div class="row">
                    <h4 class="col s12 m8 l8 offset-m1 offset-l2 margen_top1_5"><b id="nom_asig"></b></h4>

                    <div class="col s12 m8 l8 offset-m1 offset-l2 altura_max_modal_asig">
                        <table>
                            <thead>
                                <tr>
                                    <th>Estatus llamada</th>
                                    <th>Cantidad</th>
                                </tr>
                            </thead>
                            <tbody id="tbody_estatus_cuentas_asig">
                            </tbody>
                        </table>
                    </div>
                </div>


            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-close waves-effect waves-green btn red">Cerrar</a>
            </div>
        </div>




        <script src="js/js/jquery-2.2.4.min.js"></script>
        <script src="js/js/materialize.min.js"></script>
        <script src="js/js/menu.js"></script>
        <script src="js/js/asignaciones_usuarios.js"></script>
    </body>

</html>