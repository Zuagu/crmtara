<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organigrama</title>

        <!--bootstrap-->
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/arcade-style-frame.css" media="screen">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <!--bootstrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!-- INICIA CALENDARIO -->
        <!--        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>  
                <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-organigrama.js"></script>
        <script type="text/javascript" src="js/arcade-puesto.js"></script>
        <script type="text/javascript" src="js/arcade-vacante.js"></script>
        <script type="text/javascript" src="js/arcade-usuario.js"></script>

        <!-------------------------organigrama plugin------------------------------>

        <script type="text/javascript" src="js/jquery.orgchart.js"></script>    
        <link rel="stylesheet" type="text/css" href="css/jquery.orgchart.css">

        <style>
            html {
                height: 100%;
            }
            body {
                background: linear-gradient(to bottom, #fafafa 22%, #9e9e9e 119%);
                /*                min-height: 100%;*/
            }
        </style>
    </head>
    <body>
        <div class="organigrama">
            <ul id="sicsa-org" style="display: none">
                <li>Director
                    <ul>
                        <li>Director Ejecutivo
                            <ul>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                            </ul>
                        </li> 
                        <li>Coordinador
                            <ul>
                                <li>subordinados</li>
                                <li>subordinados</li>
                            </ul>
                        </li>
                        <li>Vicepresidente
                            <ul>
                                <li>subordinados
                                    <ul>
                                        <li>gato1</li>
                                        <li>gatito2</li>
                                    </ul>
                                </li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                            </ul>
                        </li>

                        <li>Vicepresidente
                            <ul>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                                <li>subordinados</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
            <div id="organigrama-resultante">
            </div>
        </div>
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" id="prueba_modal"></h4>
                    </div>
                    <div class="modal-body">
                        <p></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col s1">
            <button  id="print" type="button" class="btn btn-danger">Imprimir<span class="badge badge-light">4</span></button>
        </div>
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_nodos_organigrama(0, "organigrama");
                window.setTimeout(() => {
                    $('#organigrama-resultante').orgchart({
                        'data': $('#sicsa-org')
                    });
                }, 500);
            });
            //==================================================================
            $("#print").on("click", function () {
                window.focus();
                window.print(); // checar por que no se imprime bien posible causa se imprime lo que esta en el html y no lo del plugin
                // checar por que no puedo poner un pinche icon de imprimir en el boton con bootstrap 
            });
            $("#organigrama-resultante").delegate(".title", "dblclick", function () {
                $("#prueba_modal").text($(".focused").text());
                $("#myModal").modal();
                console.log("funciona");
            });

            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->        
    </body>
</html>
