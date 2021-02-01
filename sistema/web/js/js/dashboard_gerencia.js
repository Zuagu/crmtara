////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
$(document).ready(function () {
    //iniciar el dropdown del menu
    $('select').formSelect();
    $('.modal').modal();
    $(".dropdown-trigger").dropdown({constrainWidth: false});
    $('.sidenav').sidenav();
    document.getElementById('foto_perfil').src = "http://gruposicsa.com/fotos/" + id_usuario + ".jpg";
    $(".sidenav").empty();
    // funcion que pinta el menu
    for (indice in menu) {
        $(".sidenav").append('<li><a onclick="verSubmenu(' + indice + ')"><i class="material-icons white-icon tooltipped" data-position="right"  data-tooltip="' + menu[indice].name + '">' + menu[indice].icono + '</i></a></li>');
    }
    $('.tooltipped').tooltip({margin: 20});
    $('.tabs').tabs();
    $('.datepicker').datepicker({
        container: "body",
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year,
        today: 'Today',
        clear: 'Clear',
        close: 'Ok',
        closeOnSelect: false // Close upon selecting a date,
    });
    $('.timepicker').timepicker({
        default: 'now', // Set default time: 'now', '1:30AM', '16:30'
        fromnow: 0, // set default time to * milliseconds from now (using with default = 'now')
        twelvehour: false, // Use AM/PM or 24-hour format
        donetext: 'OK', // text for done-button
        cleartext: 'Clear', // text for clear-button
        canceltext: 'Cancel', // Text for cancel-button,
        container: "body", // ex. 'body' will append picker to body
        autoclose: false, // automatic close timepicker
        ampmclickable: true, // make AM PM clickable
        aftershow: function () {} //Function for after opening timepicker
    });

    
});

window.onload = function(){
    select_gestor_tabla(id_usuario, id_puesto_usuario , "", "tbody_listado_gestores");
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



//==============================================================================
function select_gestor_tabla(_id_usuario,_id_puesto,_busqueda,_div) {
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
