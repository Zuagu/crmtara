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

        <link type="text/css" rel="stylesheet" href="styles/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">

        <!-- INICIA CALENDARIO ARCADE -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>        
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>
        <script>
            $(function () {
                $(".datepicker").datepicker({changeMonth: true, changeYear: true, numberOfMonths: 1});
            });
        </script>
        <!-- INICIA CALENDARIO ARCADE -->

        <!--ARCADE CSS-->
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">
        <!--ARCADE CSS-->

        <script type="text/javascript" src="js/arcade-citas.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body style="background-image: url('images/background-cliente.png');">

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

        <script type="text/javascript">
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
                    id_perfil: $('#perfil_usuario', parent.document).val(),
                    id: $('#usuario_sistema', parent.document).val(),
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
