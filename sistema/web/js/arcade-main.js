//==============================================================================
$(document).ready(function () {
    $("#imagen_empleado").attr("src", "http://192.168.0.12:8080/archivosrh/" + $("#usuario_sistema").val() + ".png");
    ajuste_frame();
    select_noticias();
    cargar_menu();
//    mensajes_sin_leer();
    barrer_news();

});
//==============================================================================
$("#gotohome").live("click",
        function () {
            top.frames['centro'].location.href = 'inicio.jsp';
        }
);
//==============================================================================
$("#logout").live("click",
        function () {
            logout($("#usuario_sistema").val());
        }
);
//==============================================================================
$(".signout").live("click",
        function () {
            submenu($(this).text());
            $("#slide-out").empty();
            $('#slide-out').append(menu_origonal);
            $('.collapsible').collapsible();
        }
);
//==============================================================================
$("#sidenav-overlay, .drag-target").live("click",function () {
    $("#slide-out").empty();
    $('#slide-out').append(menu_origonal);
//    console.log("que pedo");
    $('.collapsible').collapsible();
});
//==============================================================================
function mensajes_sin_leer() {
    var params = {
        accion: "mensajes_sin_leer",
        id_perfil: $("#perfil_usuario").val(),
        id_usuario: $("#usuario_sistema").val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEmpleados",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#mensajes_sin_leer").empty();
            $("#mensajes_sin_leer").append(dataRes);
        }
    });
}
//==============================================================================
function cargar_menu() {
    var params = {
        accion: "cargar_menu",
        id_perfil: $("#perfil_usuario").val(),
        id_usuario: $("#usuario_sistema").val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMenu",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            nombre_usuario();
            $('#slide-out').append(dataRes);
            $('.collapsible').collapsible();
        }
    });
}
;
//==============================================================================
function submenu(_jsp) {
    var jsp = "";
    jsp = _jsp;
    jsp = jsp.toLocaleLowerCase();
    jsp = jsp.replace(/ /g, "-");
    top.frames['centro'].location.href = jsp.toLowerCase() + '.jsp';
}
//==============================================================================
function ajuste_frame() {
    $('#centro').height($(window).height() - 0);
    $(window).resize(function () {
        $('#centro').height($(this).height() - 0);
    });
}
//==============================================================================
function nombre_usuario() {
    var params = {
        accion: "nombre_usuario",
        id_perfil: $("#perfil_usuario").val(),
        id_usuario: $("#usuario_sistema").val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#nombre_usuario").append(dataRes);
        }
    });
}
//==============================================================================
function logout() {
    var params = {
        accion: "logout",
        id_usuario: $("#usuario_sistema").val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            location.href = "index.jsp";
        }
    });
}