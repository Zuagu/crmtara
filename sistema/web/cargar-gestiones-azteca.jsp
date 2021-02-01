<%-- 
    Document   : cargar-cartera-banco-azteca
    Created on : 30/06/2020, 07:51:12 AM
    Author     : zuagu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cargar Gestiones</title>
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <!--<link rel="stylesheet" type="text/css" href="css/css/style.css">-->
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
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row" id="contenido"></div>

        <div class="row">
            <div class="col s12 m12 l12">
                <div class="col s12 m6 l6 offset-m3 offset-l3">
                    <form method="POST" action="ControllerUploadGestiones" enctype="multipart/form-data">
                        <div class="col s12 m12 l12">
                            <h6>Carga de Cuentas a Gestiones</h6>
                        </div> 
                        <div class="file-field input-field">
                            <div class="btn blue">
                                <span>Archivo CSV</span>
                                <input type="file" name="uploadFile" accept=".csv">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
                            <div class="col s4 m14 l14 offset-l4 offset-m4 input-field">
                                <button class="btn waves-effect waves-purple" type="submit" name="action">Cargar<i class="material-icons right">send</i></button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>


        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/menu.js"></script>
    </body>
</html>
