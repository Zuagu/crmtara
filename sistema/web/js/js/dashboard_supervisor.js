////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

window.onload = function () {
    // select_gestor_tabla(id_usuario, id_puesto_usuario , "", "tbody_listado_gestores");
    select_valores_usuarios();
    select_regiones();
    select_usuarios_cargo("tbody_listado_gestores");
};
//funcion cerrar sesion con boton
$("#cerrar").click(function () {
    Cerrar(id_usuario);
});
//actualizar el estatus de f_logeado al cerar pestaña
function Cerrar(id) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerUsuario",
        data: {action: "cerrar_sesion", id_usuario: id}
    });
}

$(".row").click(function () {
    $("#resultado_menu").addClass("hide");
});
// funcion que lanza el menu lateral
$(".img_log").click(function () {
    $('.sidenav').sidenav('open');
});
// funcion que pinta los submenus al dar click
function verSubmenu(indice) {
    $("#contenido").empty();
    for (row in menu[indice].submenus) {
        $("#contenido").append('<div class="col s6 m4 l4">' +
                '<div class="col s10 offset-s1 padding_submenus" >' +
                '<div class="s12 center-align background_submenus_title">' + menu[indice].submenus[row] + '</div>' +
                '<div class="s12 center-align background_submenus"><a href="' + menu[indice].jsp[row] + '"><i class="medium material-icons white-icon">' + menu[indice].iconosSubmenus[row] + '</i></a><br></div>' +
                '</div>' +
                '</div>'
                );
    }
}

// Funciones para rl buscador
$("#filtro").click(function () {
    $("#resultado_menu").removeClass("hide");
    $("#colect").empty();
    for (p in menu) {
        for (r in menu[p].submenus) {
            $("#colect").append('<a href="' + menu[p].jsp[r] + '" class="collection-item">' + menu[p].submenus[r] + '</a>');
        }
    }
});
function myFunction_buscar() {
    var query = $("#filtro").val();
    var li = document.querySelectorAll('#resultado_menu div a');
    for (var i = 0; i < li.length; i++) {
        var a = li[i];
        if (a.textContent.toLowerCase().indexOf(query.toLowerCase().trim()) > -1) {
            a.style.display = "";
        } else {
            a.style.display = "none";
        }
    }
}

//==================================================================
$("#filtro_gestor").on("keyup",
        function () {
            select_gestor_tabla(id_usuario, id_puesto_usuario, $('#filtro_gestor').val(), "tbody_listado_gestores");
        }
);
//==================================================================
$("#listado_gestores").delegate(".gestores", "click", function () {
    $(".datos_gestor").empty();
    $(".datos_gestor").append($("._id_gestor", this).text() + " " + $("._nombre_gestor", this).text());
});
//==================================================================
$("#listado_gestores").delegate(".gestores", "dblclick", function () {
    $("#modal_gestor_data").modal("open");
    $("#id_gestor_modal").empty();
    $("#id_gestor_modal").append($("._id_gestor", this).text() + " " + $("._nombre_gestor", this).text());
});
//==================================================================
$("#boton_usuarios_tabla").on("click", function () {
    select_regitro_usuarios_entrada("tbody_tabla_usuarios");
});
//=================================================================
$("#select_region").change(function () {
    $("#select_asignacion").empty();
    var id_region = "";
    if($("#select_region").val().length >= 2){
        id_region = $("#select_region").val().substr(0 ,$("#select_region").val().length - 1);
    }else{
        id_region = $("#select_region").val();
    }
        
    let params = {
        action: "select_asignaciones_region",
        id_region: id_region

    };
    console.log(params);
    select_asignaciones_region(params);


    if ($("#select_region").val() === "") {
        $("#div_asignacion").addClass("hide");
    } else {
        $("#div_asignacion").removeClass("hide");
    }
});
//==============================================================================
function select_gestor_tabla(_id_usuario, _id_puesto, _busqueda, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_gestor_tabla",
        id_usuario: _id_usuario,
        id_puesto: _id_puesto,
        busqueda: _busqueda
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerDashboardSupervisor",
        data: params,
        dataType: "json",
        success: function (gestores) {
            console.log(gestores);
            $("#" + _div).empty();
            for (var i in gestores) {
                $("#" + _div).append(
                        '<tr id="' + gestores[i].id + '" class="gestores" style="cursor:pointer;" >' +
//                        '<td style="width:15%; text-align: center;"><img class="img_gestores" src="images/yuna.jpg" ></td>' +
                        '<td style="width:15%; text-align: center;"><img class="img_gestores" src="http://gruposicsa.com/fotos/' + gestores[i].id + '.jpg"></td>' +
                        '<td class="_id_gestor">' + gestores[i].id + '</td>' +
                        '<td class="_nombre_gestor">' + gestores[i].nombre + '</td>' +
                        '</tr>'
                        );
            }
            $(".gestores").click(function () {
                $(".gestores").removeClass("gestores_selected");
                $(this).addClass("gestores_selected");
            });
        }
    });
}
//==============================================================================
function select_gestor_tabla_filtro(_filtro, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_gestor_tabla_filtro",
        filtro: _filtro
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerDashboardSupervisor",
        data: params,
        dataType: "json",
        success: function (gestores) {
            $("#" + _div).empty();
            for (var i in equipos) {
                $("#" + _div).append(
                        '<tr id="' + gestores[i].id + '" class="gestores" style="cursor:pointer;" >' +
//                        '<td style="width:15%; text-align: center;"><img class="img_gestores" src="images/yuna.jpg" ></td>' +
                        '<td style="width:15%; text-align: center;"><img class="img_gestores" src="http://gruposicsa.com/fotos/' + gestores[i].id + '.jpg"></td>' +
                        '<td class="_id_gestor">' + gestores[i].id + '</td>' +
                        '<td class="_nombre_gestor">' + gestores[i].nombre + '</td>' +
                        '</tr>'
                        );
            }
            $(".gestores").click(function () {
                $(".gestores").removeClass("gestores_selected");
                $(this).addClass("gestores_selected");
            });
        }
    });
}

//==============================================================================
function select_valores_usuarios() {

    var params = {
        action: "select_valores_usuarios",
        id_puesto_usuario: id_puesto_usuario,
        id_puesto2_usuario: id_puesto2_usuario,
        id_puesto3_usuario: id_puesto3_usuario

    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerDashboardSupervisor",
        data: params,
        dataType: "json",
        success: function (usuarios) {
            console.log(usuarios);
            $("#valores_usuario").empty();
            $("#valores_usuario").append(usuarios.total_activos + '/' + usuarios.total_usuarios);
            $("#porcentaje_usuario").empty();
            $("#porcentaje_usuario").append((usuarios.total_activos * 100) / usuarios.total_usuarios + '%');
        }
    });
}
//==============================================================================
function select_regitro_usuarios_entrada(_div) {

    var params = {
        action: "select_regitro_usuarios_entrada",
        id_puesto_usuario: id_puesto_usuario,
        id_puesto2_usuario: id_puesto2_usuario,
        id_puesto3_usuario: id_puesto3_usuario

    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerDashboardSupervisor",
        data: params,
        dataType: "json",
        success: function (usuarios) {
            $("#" + _div).empty();
            for (var i in usuarios) {
                $("#" + _div).append(
                        '<tr id="' + usuarios[i].id + '" class="estatus_entrada' + usuarios[i].estatus_entrada + '" style="cursor:pointer;" >' +
                        '<td style="width:15%; text-align: center;"><img class="img_gestores" src="http://gruposicsa.com/fotos/' + usuarios[i].id + '.jpg"></td>' +
                        '<td >' + usuarios[i].id + '</td>' +
                        '<td >' + usuarios[i].nombre + '</td>' +
                        '<td >' + usuarios[i].entrada + '</td>' +
                        '<td >' + usuarios[i].hora_entrada + '</td>' +
                        '<td class="center"><i class="material-icons f_llegada' + usuarios[i].f_llegada + '">fingerprint</i></td>' +
                        '</tr>'
                        );
            }
        }
    });
}

//=================================================================
function select_usuarios_cargo(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_usuarios_cargo",
        puesto: id_puesto_usuario,
        puesto2: id_puesto2_usuario,
        puesto3: id_puesto3_usuario,
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerUsuario",
        data: params,
        dataType: "json",
        success: function (equipos) {
            $("#" + _div).empty();
            for (var i in equipos) {
                $("#" + _div).css("cursor", "default");
                $("#" + _div).append(
                        '<tr id="' + equipos[i].id + '"  class="agregar_gestor" style="cursor:pointer;">' +
                        '<td></td>' +
                        '<td>' + equipos[i].id + '</td>' +
                        '<td>' + equipos[i].nombre + '</td>' +
                        '</tr>'
                        );
            }
        }
    });
}

//=================================================================
function select_regiones() {

    var params = {
        action: "select_regiones",
        puesto: id_puesto_usuario,
        puesto2: id_puesto2_usuario,
        puesto3: id_puesto3_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerDashboardSupervisor",
        data: params,
        dataType: "json",
        success: function (regiones) {
            $("#select_region").empty();
            $("#select_region").append('<option value="">Selecciona</option>');
            let cadena_regiones = "";
            for (let i in regiones) {
                cadena_regiones += regiones[i].id_region + ",";
                $("#select_region").append('<option value="' + regiones[i].id_region + '">' + regiones[i].region + '</option>');
            }
            $("#select_region").append('<option value="' + cadena_regiones + '">Todos</option>');
            $('select').formSelect();
        }
    });
}

//==============================================================================
function select_asignaciones_region(_params) {

    $.ajax({
        type: "POST",
        url: "/sistema/ControllerDashboardSupervisor",
        data: _params,
        dataType: "json",
        success: function (asignaciones) {
            $("#select_asignacion").empty();
            $("#select_asignacion").append('<option value="">Selecciona</option>');
            let cadena_asignaciones = "";

            for (let i in asignaciones) {
                cadena_asignaciones += asignaciones[i].id_asignacion + ",";
                $("#select_asignacion").append('<option value="' + asignaciones[i].id_asignacion + '">' + asignaciones[i].asignacion + '</option>');


            }
            $("#select_asignacion").append('<option value="' + cadena_asignaciones + '">Todos</option>');
            $('select').formSelect();
        }
    });
}
//==============================================================================
function select_regitro_usuarios_entrada_rango(_desde, _hasta, _region ,asignacion) {

    var params = {
        action: "select_regitro_usuarios_entrada_rango",
        desde: _desde,
        hasta: _hasta,
        region: _region,
        asignacion: _asignacion,
        id_puesto_usuario: id_puesto_usuario,
        id_puesto2_usuario: id_puesto2_usuario,
        id_puesto3_usuario: id_puesto3_usuario

    };
    console.log(params);
    
    
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerDashboardSupervisor",
        data: params,
        dataType: "json",
        success: function (usuarios) {
            console.log(usuarios);
            $("#valores_usuario").empty();
            $("#valores_usuario").append(usuarios.total_activos + -+usuarios.total_usuarios);
            $("#porcentaje_usuario").empty();
            $("#porcentaje_usuario").append((usuarios.total_activos * 100) / usuarios.total_usuarios + '%');
        }
    });
}


