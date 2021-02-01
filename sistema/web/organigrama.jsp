
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cierre Asignacion</title>
        <link rel="shortcut icon" href="image/logoSicsa/icon-sicsa.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style.css">

        <style>



            .gestores{
            }
            .gestores_selected{
                box-sizing: border-box;

                background: rgb(137, 222, 255) !important;
            }
            body {
                background:white;
                background-position-x: 0%;
                background-position-y: 0%;
                background-repeat: repeat;
                background-image: none;
                background-size: auto;
                background-image: url("image/logoSicsa/logo_sicsa2.png");
                width: max-content;
                background-repeat: no-repeat;
                background-position: 1rem 3rem;
                background-size: 30%;
            }


        </style>
    </head>
    <%
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("id_usuario") != null) {
            out.write("<script>var menu = " + sesion.getAttribute("menu") + "; var id_usuario = " + sesion.getAttribute("id_usuario") + "; var id_puesto_usuario = " + sesion.getAttribute("id_puesto") + "; </script>");
        } else {
            out.write("<script>location.replace('index.jsp');</script>");
        }
    %>
    <body onbeforeunload="return Cerrar(<%out.write("" + sesion.getAttribute("id_usuario"));%>)">
        <jsp:include page="header.jsp" />
        <div class="row" id="contenido"></div>
        <div class="contenedor-responsive">


            <!--BEGIN CONTENT-->
            <div class="row">
                <div class="col s12 m12 l12">
                    <div class="col s1 m1 l1 center-align"> 
                        <!--<a id="ver_modal_controller" class=" btn-large waves-effect waves-light transparent icon_organigrama"><i class="material-icons transparent"></i></a>-->
                    </div>
                    <div class="organigrama">
                        <ul> 
                            <li>
                                <a id="ver_modal_controller" class=""><img src="image/logoSicsa/logo_sicsa3.png" width="150px"></a>
                                <ul>
                                    <li>
                                        <a id="1" class="puesto">Director General</a>
                                        <ul>
                                            <li>
                                                <a id="3" class="puesto">Subdirector</a>
                                                <ul>
                                                    <li>
                                                        <a id="8" class="puesto">Coordinador Sistemas</a>
                                                        <ul>
                                                            <li>
                                                                <ul>
                                                                    <li>
                                                                        <a id="16" class="puesto">Supervisor Sistemas</a>
                                                                        <ul>
                                                                            <a id="29" class="puesto">Desarollador</a>
                                                                        </ul>
                                                                    </li>  
                                                                </ul>
                                                            </li>
                                                        </ul>
                                                    </li>  
                                                    <li>
                                                        <a id="7" class="puesto">Coordinador RH</a>
                                                        <ul>
                                                            <li>
                                                                <ul>
                                                                    <li>
                                                                        <a id="19" class="puesto">Reclutador Rs</a>
                                                                    </li>  
                                                                    <li>
                                                                        <a id="20" class="puesto">Reclutador Campo</a>
                                                                    </li>  
                                                                </ul>
                                                            </li>
                                                        </ul>
                                                    </li>  
                                                    <li>
                                                        <a id="6" class="puesto">Coordinador Charback</a>
                                                        <ul>
                                                            <li>
                                                                <ul>
                                                                    <li>
                                                                        <a id="15" class="puesto">Supervisor Charback</a>
                                                                        <ul>
                                                                            <li>
                                                                                <a id="21" class="puesto">Recepcionista</a>
                                                                            </li>  
                                                                            <li>
                                                                                <a id="22" class="puesto">Gestor Charback</a>
                                                                            </li>  
                                                                        </ul>
                                                                    </li>  
                                                                </ul>
                                                            </li>
                                                        </ul>
                                                    </li>  
                                                    <li>
                                                        <a id="5" class="puesto">Coordinador Operacion</a>
                                                        <ul>
                                                            <li>
                                                                <ul>
                                                                    <li>
                                                                        <a id="9" class="puesto">Supervisor Apertura Monterrey</a>
                                                                        <ul>
                                                                            <li>
                                                                                <a id="23" class="puesto">Gestor Apertura Monterrey</a>
                                                                            </li>  
                                                                        </ul>
                                                                    </li>  
                                                                    <li>
                                                                        <a id="10" class="puesto">Supervisor Apertura Chihuahua</a>
                                                                        <ul>
                                                                            <li>
                                                                                <a id="24" class="puesto">Gestor Apertura Chihuahua</a>
                                                                            </li>  
                                                                        </ul>
                                                                    </li>  
                                                                    <li>
                                                                        <a id="11" class="puesto">Supervisor Apertura Puebla</a>
                                                                        <ul>
                                                                            <li>
                                                                                <a id="25" class="puesto">Gestor Apertura Puebla</a>
                                                                            </li>  
                                                                        </ul>
                                                                    </li>  
                                                                    <li>
                                                                        <a id="12" class="puesto">Supervisor Cierres Monterrey</a>
                                                                        <ul>
                                                                            <li>
                                                                                <a id="26" class="puesto">Gestor Cierres Monterrey</a>
                                                                            </li>  
                                                                        </ul>
                                                                    </li>  
                                                                    <li>
                                                                        <a id="13" class="puesto">Supervisor Cierres Chihuahua</a>
                                                                        <ul>
                                                                            <li>
                                                                                <a id="27" class="puesto">Gestor Cierres Chihuahua</a>
                                                                            </li>  
                                                                        </ul>
                                                                    </li>  
                                                                    <li>
                                                                        <a id="14" class="puesto">Supervisor Cierres Puebla</a>
                                                                        <ul>
                                                                            <li>
                                                                                <a id="28" class="puesto">Gestor Cierres Puebla</a>
                                                                            </li>  
                                                                        </ul>
                                                                    </li>  
                                                                </ul>
                                                            </li>
                                                        </ul>
                                                    </li>  
                                                    <li>
                                                        <a id="30" class="puesto">Jefe de Mantenimiento</a>
                                                        <ul>
                                                            <a id="31" class="puesto">Asistencia</a>
                                                        </ul>
                                                    </li>  
                                                </ul>
                                        </ul>
                                    </li>
                                    <li>
                                        <a id="2" class="puesto">Director Finanzas</a>
                                        <ul>
                                            <a>Contador</a>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>          
                    </div>
                </div>

            </div>

            <!-- Modal Structure -->
            <div class="row">
                <div id="div_puestos" class="modal">
                    <div class="modal-content">
                        <h4 id="addGestor" class="titulo_puesto col s8">Modal Header</h4>
                        <input type="hidden" id="id_puesto_selected" >
                        <input type="hidden" id="id_user_selected" >
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>Foto</b></td>
                                    <td> <b>id</b></td>
                                    <td> <b>Nombre</b></td>
                                    <td> <b>Puesto</b></td>
                                    <td> <b>fecha ingreso</b></td>
                                    <td> <b>Horario</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_puestos">
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a id="addUserVac" class="btn-floating btn-large waves-effect waves-light green right"><i class="material-icons">add</i></a>
                        <a id="deleteUserVac" class="btn-floating btn-large waves-effect waves-light red right"><i class="material-icons">cancel</i></a>
                    </div>
                </div>
            </div>
            <!-- Modal Structure -->
            <div id="div_controller_puestos" class="modal">
                <div class="modal-content">
                    <div class=" col s12 m12 l12 div_tabs">
                        <h4 class="">Vacantes</h4>
                    </div>
                    <div id="div_mod_vacantes" class="col s12 m12 l12 div_gestores_disp_asig center-align">
                        <table class="highlight" id="tabla_vacantes">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>Puesto</b></td>
                                    <td> <b>puestos Requeridos</b></td>
                                    <td> <b>puestos Ocupados</b></td>
                                    <td> <b>Vacantes</b></td>
                                    <td><b><i class="material-icons right">autorenew</i></b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_vacantes">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Modal Structure -->
            <div class="row">
                <div id="div_lista_gestores" class="modal">
                    <div class="modal-content">
                        <h4 class="titulo_puesto col s8">Gestores</h4>
                        <div class="datagrid sombra" style="border:none;"><input id="filtro_gestor" class="filtro_gestor  "placeholder="Buscar" type="text" size="60"/></div>
                        <table class="highlight">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>Foto</b></td>
                                    <td> <b>id</b></td>
                                    <td> <b>Nombre</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_lista_gestores">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <script src="https://code.highcharts.com/highcharts.js"></script>
            <script src="https://code.highcharts.com/highcharts-more.js"></script>
            <script src="https://code.highcharts.com/modules/solid-gauge.js"></script>
            <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
            <script type="text/javascript" src="js/js/materialize.min.js"></script>
            <script type="text/javascript" src="js/js/menu.js"></script>
            <script type="text/javascript" src="js/js/organigrama.js"></script>
    </body>
</html>