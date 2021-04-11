<%-- 
    Document   : cambiar-password.jsp // Nuevo 2015 ;)
    Created on : 13-ene-2015, 12:47:27
    Author     : luiscortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>


        <!-- INICIA CALENDARIO ARCADE -->


        <script type="text/javascript" src="js/arcade-citas.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" href="image/logoInco.fw.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor_3.css">

    </head>
    <body>
        <jsp:include page="header_3.jsp"/>

        <div>

            <br>
            <div id="logo-cliente">
                <img src="images/logo-cliente.png" alt="">
            </div>

            <br>
            <div class="datagrid sombra" style="max-width: 520px;text-align: center;margin: 0px auto;">
                <table style="width: 100%;border-spacing: 7px;">
                    <thead>
                        <tr>
                            <th colspan="2" style="text-align: center;">INGRESA TU NUEVA CONTRASEÑA</th>
                        </tr>
                    </thead>
                    <tr>
                        <td><input placeholder="NUEVA CONTRASEÑA" style="width: 100%;text-align: center;height: 50px;font-weight: bold;font-size: 21px;color: #337CA4;" id="password1" type="password" maxlength="45" required="required"/></td>
                    </tr>
                    <tr>
                        <td><input placeholder="CONFIRMA TU CONTRASEÑA" style="width: 100%;text-align: center;height: 50px;font-weight: bold;font-size: 21px;color: #337CA4;" id="password2" type="password" maxlength="45" required="required"/></td>
                    </tr>
                </table>

            </div>

            <br>
            <div style="text-align: center;width: 100%;">
                <input id="btncambiar_password" name="accion" class="boton_chido sombra" type="button" value="CAMBIAR PASSWORD" />
            </div>
        </div>
         
        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript">

            $(document).ready(function () {
//iniciar el dropdown del menu
                $('.fixed-action-btn').floatingActionButton();
                $('select').formSelect({container: 'body'});
                $('.modal').modal();
                $(".dropdown-trigger").dropdown({constrainWidth: false});
                $('.sidenav').sidenav();
                $('.slider').slider();

                $(".sidenav").empty();
                $(".sidenav").append(`<li class="center"><img src="image/icon-user.png"><li>`);
                // funcion que pinta el menu

                for (let indice in menu) {
                    let submenu_text = '';
                    for (let i in menu[indice].submenus) {
                        submenu_text += `<a href="${menu[indice].jsp[i]}" class="collection-item"><i class="material-icons left">${menu[indice].iconosSubmenus[i]}</i>${menu[indice].submenus[i]}</a>`;
                    }
                    $(".sidenav").append(`<li>
            <div class="collapsible-header"><i class="material-icons">${menu[indice].icono}</i>${menu[indice].name}</div>
            <div class="collapsible-body collection">${submenu_text}</div>
        </li>`);
                }
//    for (indice in menu) {
//        $(".sidenav").append('<li><a onclick="verSubmenu(' + indice + ')">
//        <i class="material-icons white-icon tooltipped" data-position="right"  data-tooltip="' + menu[indice].name + '">' + menu[indice].icono + '</i></a></li>');
//    }
                $('.collapsible').collapsible();
                $('.tooltipped').tooltip({margin: 20});
                $("#info_gestor").fadeIn(1500);
                $('.tabs').tabs();
                $('.datepicker').datepicker({
                    container: "body",
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    autoClose: true,
                    closeOnSelect: true, // Close upon selecting a date,
                    format: "yyyy-mm-dd"
                });
                $('.timepicker').timepicker({
                    default: 'now',
                    twelveHour: false,
                    container: 'body'
                });
                $("#tiempo_actual").val("00:00:00");
                $("#retraso_actual").val("00:00:00");
            });
            //==================================================================
            $("#btncambiar_password").click(
                    function () {
                        if ($("#password1").val() != $("#password2").val()) {
                            alert("LAS CONTRASEÑAS NO COINCIDDEN, FAVOR DE VERIFICAR.");
                        } else {
                            cambiar_password();
                        }
                    }
            );
            //==================================================================
            function cambiar_password() {
                var params = {
                    accion: "cambiar_password",
                    id_perfil: 2,
                    id: id_usuario ,
                    password0: $("#password2").val()
                };
                $.ajax({
                    type: "POST",
                    url: "/sistema/ManageUsuario",
                    data: params,
                    dataType: "html",
                    success: function (dataRes) {
                        alert(dataRes);
                        parent.document.location.href = "/sistema/";
                    }
                });
            }
            //==================================================================
        </script>  
    </body>
</html>
