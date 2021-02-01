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


<i class="material-icons img_log">menu</i>
<a class="size_perfil dropdown-trigger right black-text" href="#!" data-target="dropdown1"><i id="foto_perfil" class="material-icons">account_circle</i></a>

<!--<nav class="header_nav blue darken-1">
    <div class="nav-wrapper icon_nav">
        <ul>
            
        </ul> 
        <ul class="right size_ul ul_margin_top">
            
        </ul>
    </div>
</nav>-->
<ul id="slide-out" class="sidenav login1 collapsible">
</ul>



