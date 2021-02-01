<%-- 
    Document   : organigrama_def
    Created on : 13/11/2019, 11:38:54 AM
    Author     : zuagu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="shortcut icon" href="image/logoSicsa/icon-sicsa.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style.css">
        <title>Organigrama</title>
        <style>
            .contenedor {
                border: 1px solid #0D3059;
            }
            .level {
                display: inline-flex;
                border: 1px solid #0D3059;
                padding: 3px;
                width: 14%;
                height: 100px;
                text-align: center;
            }
            .cajas{
                border: 1px solid #0D3059;
                text-align: center;
                margin: 5px;
                display: inline-flex;
                text-align: center;
            }
            .intter {
                border: 1px solid #0D3059;
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
        <div class="row">
            <div class="grafica">

            </div>
        </div>
        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/menu.js"></script>
        <script type="text/javascript">

            var orga = [
                {
                    "id_nodo": 1,
                    "area": "DIRECCION",
                    "descripcion": "DIRECTOR GENERAL",
                    "id_padre": 0,
                    "nivel": 1,
                    "menu": "{}",
                    "pantalla_inicio": "gestores"
                },
                {
                    "id_nodo": 2,
                    "area": "OPERACION",
                    "descripcion": "COORDINADOR OPERACION",
                    "id_padre": 1,
                    "nivel": 2,
                    "menu": "{}",
                    "pantalla_inicio": "gestores"
                },
                {
                    "id_nodo": 7,
                    "area": "FINANZAS",
                    "descripcion": "CONTADOR",
                    "id_padre": 1,
                    "nivel": 2,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 16,
                    "area": "CHARBACK",
                    "descripcion": "COORDINADOR CHARGBACK",
                    "id_padre": 1,
                    "nivel": 2,
                    "menu": "{}",
                    "pantalla_inicio": "inicio"
                },
                {
                    "id_nodo": 20,
                    "area": "OPERACION",
                    "descripcion": "COORDINADOR VISITADORES",
                    "id_padre": 1,
                    "nivel": 2,
                    "menu": "{}",
                    "pantalla_inicio": "inicio"
                },
                {
                    "id_nodo": 22,
                    "area": "SISTEMAS",
                    "descripcion": "COORDINADOR SISTEMAS",
                    "id_padre": 1,
                    "nivel": 2,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 25,
                    "area": "AREA GENERAL",
                    "descripcion": "MANTENIMIENTO",
                    "id_padre": 1,
                    "nivel": 2,
                    "menu": "{}",
                    "pantalla_inicio": "inicio"
                },
                {
                    "id_nodo": 27,
                    "area": "ADMINISTRACION",
                    "descripcion": "COORDINADOR ADMINISTRACION",
                    "id_padre": 1,
                    "nivel": 2,
                    "menu": "{}",
                    "pantalla_inicio": "inicio"
                },
                {
                    "id_nodo": 10,
                    "area": "OPERACION",
                    "descripcion": "MESA CONTROL",
                    "id_padre": 2,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 11,
                    "area": "OPERACION",
                    "descripcion": "CALIDAD",
                    "id_padre": 2,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "gestores"
                },
                {
                    "id_nodo": 12,
                    "area": "OPERACION",
                    "descripcion": "SUPERVISOR APERTURA",
                    "id_padre": 2,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 13,
                    "area": "OPERACION",
                    "descripcion": "SUPERVISOR CIERRES",
                    "id_padre": 2,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 8,
                    "area": "FINANZAS",
                    "descripcion": "FISCALISTA",
                    "id_padre": 8,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "inicio"
                },
                {
                    "id_nodo": 17,
                    "area": "CHARBACK",
                    "descripcion": "SUPERVISOR CHBCK",
                    "id_padre": 16,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 26,
                    "area": "SISTEMAS",
                    "descripcion": "SUPERVISOR SISTEMAS",
                    "id_padre": 22,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 3,
                    "area": "ADMINISTRACION",
                    "descripcion": "JEFE RRHH",
                    "id_padre": 27,
                    "nivel": 3,
                    "menu": "{}",
                    "pantalla_inicio": "dashboard-rh"
                },
                {
                    "id_nodo": 4,
                    "area": "ADMINISTRACION",
                    "descripcion": "AUXILIAR RRHH",
                    "id_padre": 3,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "usuarios"
                },
                {
                    "id_nodo": 5,
                    "area": "ADMINISTRACION",
                    "descripcion": "RECLUTADOR RS",
                    "id_padre": 3,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "dashboard-reclutador"
                },
                {
                    "id_nodo": 6,
                    "area": "ADMINISTRACION",
                    "descripcion": "RECLUTADOR DE CAMPO",
                    "id_padre": 3,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "dashboard-reclutador"
                },
                {
                    "id_nodo": 9,
                    "area": "ADMINISTRACION",
                    "descripcion": "RECEPCIONISTA",
                    "id_padre": 3,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "update-entrada"
                },
                {
                    "id_nodo": 19,
                    "area": "OPERACION",
                    "descripcion": "CAPACITACION",
                    "id_padre": 10,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 15,
                    "area": "OPERACION",
                    "descripcion": "GESTOR APERTURA",
                    "id_padre": 12,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "gestor"
                },
                {
                    "id_nodo": 21,
                    "area": "OPERACION",
                    "descripcion": "GESTOR VISITADOR",
                    "id_padre": 12,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "captura"
                },
                {
                    "id_nodo": 14,
                    "area": "OPERACION",
                    "descripcion": "GESTOR CIERRES",
                    "id_padre": 13,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "gestor"
                },
                {
                    "id_nodo": 18,
                    "area": "CHARBACK",
                    "descripcion": "GESTOR CHBCK",
                    "id_padre": 17,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "chargeback"
                },
                {
                    "id_nodo": 23,
                    "area": "SISTEMAS",
                    "descripcion": "SOPORTE TECNICO",
                    "id_padre": 26,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                },
                {
                    "id_nodo": 24,
                    "area": "SISTEMAS",
                    "descripcion": "DESARROLLO",
                    "id_padre": 26,
                    "nivel": 4,
                    "menu": "{}",
                    "pantalla_inicio": "user-stories"
                }
            ];


//            $("#grafica").delegate(".level", "click", function () {
//
//                for (var i in orga) {
//
//                    if (orga[i].id_padre === parseInt($(".id_nodo", this).val())) {
//
//                        console.log(".level" + $(".id_nodo", this).val());
//
//                        if (document.getElementsByClassName("level" + orga[i].id_nodo).length === 0) {
//                            $(".level" + $(".id_nodo", this).val()).append('<div class="level">' +
//                                    '<input class="id_nodo" type="hidden" value="' + orga[i].id_nodo + '"><a class="">' + orga[i].descripcion + '</a>' +
//                                    '</div>');
//                            $("#grafica").append('<div class="col s12 level' + orga[i].id_nodo + ' contenedor"></div>');
//                        }
//
//                    }
//                }
//
//            });
            var nivel_ac = orga[0].nivel;
            for (var i in orga) {
                if (nivel_ac !== orga[i].nivel) {
                    $(".grafica").append('<div class="col s12 ' + nivel_ac + ' z-depth-1 contenedor"></div>');
                }
                nivel_ac = orga[i].nivel;
            }
            $(".grafica").append('<div class="col s12 ' + nivel_ac + ' z-depth-1 contenedor"></div>');
//            var pri_nodo_padre = orga[0].id_padre;
//
//            var _html = '<div class="nivel' + pri_nodo_padre + ' cajas"><ul class="intter">';
//            for (var i in orga) {
//                if (pri_nodo_padre !== orga[i].id_padre) {
//
//                    _html += '</ul></div>';
//                    console.log(_html);
//                    $(".grafica").append(_html);
//                    _html = '<div class="nivel' + orga[i].id_padre + ' ' + orga[i].id_padre + ' cajas"><ul class="intter">';
//                    _html += '<li class="' + orga[i].id_nodo + '">' + orga[i].descripcion + '</li>';
//                } else {
//                    _html += '<li class="' + orga[i].id_nodo + '">' + orga[i].descripcion + '</li>';
//                }
//                pri_nodo_padre = orga[i].id_padre;
//
//            }
            var nivel = orga[0].nivel;
            var pri_nodo_padre = orga[0].id_padre;
            var _html = '';
            for (var i in orga) {
                _html = '<div class="cajas">' +
                        '<p>' + orga[i].descripcion + '</p>' +
                        '</div>';
                $("." + orga[i].nivel).append(_html);
            }
//            alert( $(".nivel2").html() );
//            $(".2").append( $(".nivel2").html() );


        </script>
    </body>

</html>
