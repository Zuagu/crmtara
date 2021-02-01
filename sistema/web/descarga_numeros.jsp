<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="image/logoInco.fw.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Descarga Numeros</title>
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
                    <h5 class="col s12 m9 l9">Descargar base de numeros Completa</h5>

                    <div class="input-field col s6 m3 l3 left-align">
                        <a id="descargar_todos" class="btn-small waves-effect blue right"><i class="material-icons right">archive</i>Descargar</a>
                    </div>
                </div>
            </div>
            <div class="col s10 m10 l10 offset-s1 offset-m1 offset-l1">
                <div class="col s12 m12 l12 z-depth-2 inner actualizar_todos white">
                    <div class="input-field col s3">
                        <select id="territorios" multiple>
                            
                        </select>
                        <label>Territorios</label>
                    </div>
                    <div class="input-field col s3">
                        <select id="gerentes" multiple>
                            
                        </select>
                        <label>Gertentes</label>
                    </div>
                    <div class="input-field col s6 right-align">
                        <a id="descargar_todos_select" class="btn-small waves-effect blue"><i class="material-icons right">archive</i>Descargar</a>
                    </div>
                </div>
            </div>

            <div class="col s10 m10 l10 offset-s1 offset-m1 offset-l1">
                <div class="col s12 m12 l12 z-depth-2 inner white div_gerencias">
                    <table>
                        <thead>
                            <tr>
                                <th>Gerencia</th>
                                <th>Cuentas</th>
                                <th class="right-align">Descargar</th>
                            </tr>
                        </thead>
                        <tbody id="tbody_gerencias_descargar">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>





        <script src="js/js/jquery-2.2.4.min.js"></script>
        <script src="js/js/materialize.min.js"></script>
        <script src="js/js/menu.js"></script>
        <script src="js/js/descarga_numeros.js"></script>
    </body>

</html>