<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>
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
        
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <script type="text/javascript" src="js/arcade-pem.js"></script>
        <script type="text/javascript" src="js/arcade-clientes.js"></script>
        <!--ARCADE JS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body style="background-image: url('images/background-cliente.png')">

        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="page-title-breadcrumb option-demo">
            <div class="page-header pull-right">
                <div class="page-title">
                    Listado del clientes
                </div>
            </div>
            <ol class="breadcrumb page-breadcrumb pull-left">
                <li>Manuales de usuario de este modulo:</li>
                <li id="pdf_horas-clase-maestro"><img class="help" src="images/help_pdf.png" style="cursor: pointer;"></li>

            </ol>
            <div class="clearfix">
            </div>
        </div>
        <!--END TITLE & BREADCRUMB PAGE-->

        <div class="contenedor-responsive">

            <!--BEGIN CONTENT-->

            <br>
            <div style="width: 80%;margin: 0px auto;">

                <table style="margin: 0px auto;">
                    <thead>
                        <tr>
                            <th style="text-align: center;">
                                <h4>LISTADO DE CLIENTES</h4>
                            </th>
                        </tr>
                    </thead>
                    <tr>
                        <td><input id="filtro" class="filtro sombra" type="text" size="60"/></td>
                    </tr>
                </table>
                <h5 style="float: right;"><a id="img_insert_cliente" href="#">Agregar nuevo</a></h5>
            </div>

            <br>
            <div class="datagrid sombra" id="listado_clientes" style="height: 390px;overflow: auto;"></div>

            <div class="datagrid sombra" id="div_insert_cliente" style="max-width: 520px;display:none;">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2" style="text-align: center;">AGREGAR NUEVO CLIENTE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>RAZON SOCIAL</td>
                            <td><input id="razon_social" class="alfanumerico" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>R. F. C.</td>
                            <td><input id="rfc" class="alfanumerico" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>CODIGO POSTAL:</td>
                            <td><input id="codigo_postal" class="entero" type="text" placeholder="" maxlength="6"></td>
                        </tr>
                        <tr>
                            <td>COLONIA:</td>
                            <td><input id="colonia" class="alfanumerico" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>CALLE:</td>
                            <td><input id="calle" class="alfanumerico" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>NUMERO EXTERIOR:</td>
                            <td><input id="num_ext" class="alfanumerico" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>NUMERO INTERIOR:</td>
                            <td><input id="num_int" value=" " class="alfanumerico" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>PAIS:</td>
                            <td>
                                <select id="id_pais" type="text" placeholder="">
                                    <option value="0">SELECCIONE...</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>ESTADO:</td>
                            <td>
                                <select id="id_estado" type="text" placeholder="">
                                    <option value="0">SELECCIONE...</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>MUNICIPIO:</td>
                            <td>
                                <select id='id_municipio' type="text" placeholder="">
                                    <option value="0">SELECCIONE...</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>TELEFONOS:</td>
                            <td><input id="telefonos" class="alfanumerico" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>EMAIL:</td>
                            <td><input id="email" type="text" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>CONTACTO:</td>
                            <td><textarea id="comentarios" class="alfanumerico" type="text" style="width: 96%;resize: none;" placeholder="" maxlength="1200"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center;padding: 22px;">
                                <button id="insert_cliente" style="background-color: #3A6F9F;border: none;color: white;font-weight: bold;font-family: verdana;" class="sombra">AGREGAR CLIENTE</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_clientes_tabla('listado_clientes');
                select_paises_combo('id_pais');
                $("#filtro").val('');
            }
            );
            //==================================================================
            $("#id_pais").on("change", function () {
                select_estados_pais_combo($("#id_pais").val(), 'id_estado');
            });
            //==================================================================
            $("#id_estado").on("change", function () {
                select_municipios_estado_combo($("#id_estado").val(), 'id_municipio');
            });
            //==================================================================
            $("#insert_cliente").on("click", function () {
                insert_cliente($("#razon_social").val(), $("#rfc").val(), $("#codigo_postal").val(), $("#colonia").val(), $("#calle").val(), $("#num_ext").val(), $("#num_int").val(), $("#id_pais").val(), $("#id_estado").val(), $("#id_municipio").val(), $("#telefonos").val(), $("#email").val(), $("#comentarios").val());
            });
            //==================================================================
            $(".delete_cliente").live("click", function () {
                var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_cliente($(this).closest('tr').attr('id'), $('#usuario_sistema', parent.document).val());
                }
            });
            //==================================================================
            $("#filtro").on("keyup", function () {
                select_clientes_filtro($("#filtro").val(), 'listado_clientes');
            });
            //==================================================================
            $(".update_cliente").live("click", function () {

                var params = [];
                var i = 0;

                $('#' + $(this).closest('tr').attr('id') + ' td input').each(function () {
                    params[i] = $(this).val();
                    i++;
                });

                update_cliente(params);
            });
            //==================================================================
            $("#img_insert_cliente").live("click", function () {

                if ($('#div_insert_cliente').is(':hidden')) {
                    $('#div_insert_cliente').show("fast");
                    $('#div_filtro').hide("fast");

                    $("#listado_clientes").hide("fast");
                } else {
                    $("#listado_clientes").show("fast");
                    $('#div_filtro').show("fast");

                    $('#div_insert_cliente').hide("fast");
                }
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>