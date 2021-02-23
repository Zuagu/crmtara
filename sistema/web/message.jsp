<%-- 
    Document   : message
    Created on : 30/06/2020, 08:35:36 AM
    Author     : zuagu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Respuesta de carga archivo</title>
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
    </head>
    <body>
        <div class="container center-align">
            <h3>${message}</h3>
            <h4>${message_db} ${jsp_redirecion}</h4>
            <div class="row">
                <div class="col s10 m4 l4 offset-s1 offset-m4 offset-l4">
                    <a class="btn waves-effect" onclick="history.back();">Regresar</a>
                </div> 
            </div>
        </div>
    </body>
</html>
