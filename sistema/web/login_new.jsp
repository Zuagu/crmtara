<%@page contentType="text/html" pageEncoding="UTF-8"%>                                                                                                                                                                                 
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CALLCENTER</title>
        <!--icono de la pestaña del explorador-->
        <link rel="shortcut icon" href="image/logoInco.fw.png">
        <link rel="apple-touch-icon" href="">
        <link href="css/css/icons-material.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/login_1.css">
    </head>

    <body id="loginjsp" class="style">
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="#">
                    <h1>Registrate</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>Inicia tu solicitud</span>
                    <input type="text" placeholder="Nombre" />
                    <input type="email" placeholder="Email" />
                    <input type="Telefono" placeholder="Telefono"/>
                    <button>Enviar</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="#">
                    <h1>Ingresa</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>Inicia tu Sesion </span>
                    <input type="text" placeholder="Usuario" />
                    <input type="password" placeholder="Contraseña" />
                    <a href="#">Olivdaste tu contraseña?</a>
                    <button>Acceder</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Regresa!</h1>
                        <p>Si ya tienes cuenta regresa para iniciar tu session</p>
                        <button class="ghost" id="signIn">Regresar</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Trabaja con Nosotros!</h1>
                        <p>Ingresa tu informacion para ser parte de nuesto Equipo</p>
                        <button class="ghost" id="signUp">Acceder</button>
                    </div>
                </div>
            </div>
        </div>
        <%
//            //System.out.println(request.getSession().getAttribute("id_usuario"));
//            if (request.getSession().getAttribute("id_usuario") != null) {
//                System.out.println(request.getSession().getAttribute("puesto"));
//                out.write("<script> location.replace('" + request.getSession().getAttribute("puesto") + ".jsp'); </script>");
//            } else if (request.getParameter("cerrar") != null) {
//                HttpSession sesion = request.getSession();
//                sesion.invalidate();
//            }
        %>
        <script src="js/js/jquery-2.2.4.min.js"></script>
        <script src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/login_1.js"></script>
    </body>
</html>
