<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("id_usuario") != null) {
        out.write("<script>"
                + " var menu = " + sesion.getAttribute("menu")
                + "; var id_usuario = " + sesion.getAttribute("id_usuario")
                + "; var id_puesto_usuario = " + sesion.getAttribute("id_puesto")
                + "; var id_puesto2_usuario = " + sesion.getAttribute("id_puesto2")
                + "; var id_puesto3_usuario = " + sesion.getAttribute("id_puesto3")
                + "; </script>");
    } else {
        out.write("<script>location.replace('index.jsp');</script>");
    }
%>

<ul id="dropdown1" class="dropdown-content">
    <li><a>Informacion Personal</a></li>
    <li><a>Cambiar Password</a></li>
    <li class="divider"></li>
    <li><a href="index.jsp" id="cerrar">Cerrar Sesion</a></li>
</ul>
<ul id="dropdown_app" class="dropdown-content">
    <li><a href="https://incomarkpbx.systelvoice.com/index.php"  class="center-align" target="_blank"><img class="width_ext size_ul" src="image/issabel.png"></a></li>
</ul>
<nav class="header_nav blue darken-1">
    <div class="nav-wrapper icon_nav">
        <ul>
            <li href="#!" class=""><img src="image/logoInco.fw.png" alt="image/logoInco.fw.png" class="img_log"></li> 
        </ul> 

        <div class="contenedor_buscar white">
            <input id="buscador_cuentas_gestor" class="search_cuentas center-align" type="text" placeholder="Buscar">
        </div>
        <a id="buscar_cuentas" class="btn-flat col s12"><i class="material-icons tiny right">search</i></a>

        <ul class="right size_ul ul_margin_top">
            <li><a class="size_ul dropdown-trigger" href="#!" data-target="dropdown1"><img id="foto_perfil" class="circle size_ul margin_17_top" src="image/icon-user.png"></a></li>
        </ul>
    </div>
</nav>
<ul id="slide-out" class="sidenav login1 collapsible">
</ul>



