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
    $("#info_gestor").fadeIn(1500);
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
window.onload = function () {
    select_regiones();
    select_equipo_tabla("div_equipos");
    select_usuarios_cargo("listado_gestores");
    $("#cadena_ciclos").val("");
    $("#cadena_estados").val("");
    $("#cadena_estatus").val("");
};

//funcion cerrar sesion con boton
$("#cerrar").click(function () {
    Cerrar(id_usuario);
});

//actualizar el estatus de f_logeado al cerar pestaña

// funcion que lanza el menu lateral
$(".img_log").click(function () {
    $('.sidenav').sidenav('open');
});
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
//==================================================================
$("#filtro_gestor").on("keyup",
        function () {
            select_usuarios_cargo_filtro($('#filtro_gestor').val(), "listado_gestores");
        }
);
//==================================================================
$("#div_equipos").on("click", ".equipo_gestores", function () {
    $("#id_equipo").val($(this).closest("tr").attr("id"));
    $(".equipo_gestores").removeClass("equipo_gestores_selected");
    $(this).closest("tr").addClass("equipo_gestores_selected");

    select_usuarios_equipo($("#id_equipo").val(), "listado_gestores_equipo");
});
//==================================================================
$("#listado_gestores").on("click", ".agregar_gestor", function () {
    if ($("#id_equipo").val() == "0") {
        alert("SELECCONE UN EQUIPO");
    } else {
        agregar_gestor_equipo(
                $("#id_equipo").val(),
                $(this).closest("tr").attr("id")
                );
    }
});
//==================================================================
$("#insert_equipo").click(function () {
    insert_equipo();
});
//==================================================================
$("#listado_gestores_equipo").on("click", ".delete_gestor_equipo", function () {
    delete_usuario_equipo(
            $("#id_equipo").val(),
            $(this).closest("tr").attr("id")
            );
});
//==================================================================
$(".row").click(function () {
    $("#resultado_menu").addClass("hide");
});
//=================================================================
$("#select_region_f").change(function () {
    $("#select_asignacion_f").empty();
    $("#div_ciclos_f").empty();
    $("#div_estatus_f").empty();
    $("#div_estados_f").empty();
    let params = {
        action: "select_asignaciones_region",
        id_region: $("#select_region_f").val()

    };
    select_asignaciones_region(params);
    $("#cadena_ciclos").val("");
    $("#cadena_estados").val("");
    $("#cadena_estatus").val("");

    if ($("#select_region_f").val() === "") {
        $("#div_asignacion_f").addClass("hide");
    } else {
        $("#div_asignacion_f").removeClass("hide");
    }
});
//=================================================================
$("#select_asignacion_f").change(function () {
    $("#div_estados_f").empty();
    $("#div_estatus_f").empty();
    let params = {
        action: "select_ciclos_asignacion",
        id_asignacion: $("#select_asignacion_f").val()

    };
    if ($("#select_asignacion_f").val() === "") {
        $("#div_ciclos_f").addClass("hide");
    } else {
        $("#div_ciclos_f").removeClass("hide");
    }
    select_ciclos_asignacion(params);
    $("#cadena_ciclos").val("");
    $("#cadena_estados").val("");
    $("#cadena_estatus").val("");
});
//=================================================================
$("#div_ciclos_f").on("click", ".checkon_todos", function () {
    if ($(".checkon_todos").is(":checked")) {
        $(".checkon").prop("checked", true);
        $("#cadena_estatus").val("");
        $("#cadena_estados").val("");
        let cadena_ciclos = "";
        $("#div_ciclos_f input").map((input) => {
            if ($("#div_ciclos_f input")[input].value !== "on") {
                cadena_ciclos = cadena_ciclos + "'" + $("#div_ciclos_f input")[input].value + "',";
            }
        });
//        console.log(cadena_ciclos);
        $("#cadena_ciclos").val(cadena_ciclos);
        select_estados_ciclos();
    } else {
        $(".checkon").prop("checked", false);
        $("#cadena_estatus").val("");
        $("#cadena_estados").val("");
        $("#cadena_ciclos").val("");
        $("#div_estatus_f").empty();
        $("#div_estados_f").empty();
    }
    ;
});
//=================================================================
$("#div_ciclos_f").on("click", ".checkon", function () {
    if ($(this).is(":checked")) {
        $("#cadena_ciclos").val($("#cadena_ciclos").val() + "'" + $(this).val() + "',");
        $("#cadena_estados").val("");
        $("#cadena_estatus").val("");
        select_estados_ciclos();
    } else {
        $("#cadena_ciclos").val($("#cadena_ciclos").val().replace("'" + $(this).val() + "',", ""));
        $(".checkon_todos").prop("checked", false);
        $("#div_estados_f").empty();
        $("#div_estatus_f").empty();
        $("#cadena_estados").val("");
        $("#cadena_estatus").val("");
        if ($("#cadena_ciclos").val() !== "") {
            select_estados_ciclos();

        }
    }
    ;
});
//=================================================================
$("#div_estados_f").on("click", ".check_on_todos_estados", function () {
    if ($(".check_on_todos_estados").is(":checked")) {
        $(".check_on_estados").prop("checked", true);
        let cadena_estados = "";
        $("#cadena_estatus").val("");
        $("#div_estados_f input").map((input) => {
            if ($("#div_estados_f input")[input].value !== "on") {
                cadena_estados = cadena_estados + "'" + $("#div_estados_f input")[input].value + "'" + ",";
            }
        });
        $("#cadena_estados").val(cadena_estados);
        select_status_estados();
    } else {
        $(".check_on_estados").prop("checked", false);
        $("#cadena_estatus").val("");
        $("#cadena_estados").val("");
        $("#div_estatus_f").empty();
//        select_status_estados
    }
    ;
});
//=================================================================
$("#div_estados_f").on("click", ".check_on_estados", function () {
    if ($(this).is(":checked")) {
        $("#cadena_estados").val($("#cadena_estados").val() + "'" + $(this).val() + "'" + ",");
        $("#cadena_estatus").val("");
        select_status_estados();
    } else {
        $("#cadena_estados").val($("#cadena_estados").val().replace("'" + $(this).val() + "',", ""));
        $(".check_on_todos_estados").prop("checked", false);
        $("#cadena_estatus").val("");
        $("#div_estatus_f").empty();
        if ($("#cadena_estados").val() !== "") {
            select_status_estados();
        }
    }
    ;
});
//=================================================================

$("#div_estatus_f").on("click", ".check_on_todos_estatus", function () {
    if ($(".check_on_todos_estatus").is(":checked")) {
        $(".check_on_estatus").prop("checked", true);
        let cadena_estatus = "";
        $("#div_estatus_f input").map((input) => {
            if ($("#div_estatus_f input")[input].value !== "on") {
                cadena_estatus = cadena_estatus + "'" + $("#div_estatus_f input")[input].value + "',";
            }
        });
        $("#cadena_estatus").val(cadena_estatus);
    } else {
        $(".check_on_estatus").prop("checked", false);

        $("#cadena_estatus").val("");
    }
});

//=================================================================
$("#div_estatus_f").on("click", ".check_on_estatus", function () {
    if ($(this).is(":checked")) {
        $("#cadena_estatus").val($("#cadena_estatus").val() + "'" + $(this).val() + "',");
    } else {
        $("#cadena_estatus").val($("#cadena_estatus").val().replace("'" + $(this).val() + "',", ""));
        $(".check_on_todos_estatus").prop("checked", false);
    }
    ;
});
//=================================================================
$("#ver_cuentas_equipo").click(function () {
    ver_cuentas_nuevo_equipo_especial();
});
//=================================================================
$("#crear_equipo").click(function () {
    console.log(';ldskf;sldf');
    crear_equipo_especial();
});
//=================================================================
$("#div_equipos").on("dblclick", ".equipo_gestores", function () {
    $("#modal_cuentas_equipo").modal("open");

    let _params = {
        action: "select_cuentas_equipo",
        id_equipo: $(this).closest("tr").attr("id"),
        nom_asig: $(".nom_asig", this).text()
    };
    select_cuentas_equipo(_params, "tbody_cuentas_equipo");
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function Cerrar(id) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerUsuario",
        data: {action: "cerrar_sesion", id_usuario: id}
    });
}
//=================================================================
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
//=================================================================
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
//=================================================================
function select_equipo_tabla(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_equipo_tabla"
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: params,
        dataType: "json",
        success: function (equipos) {
            $("#" + _div).empty();
            for (var i in equipos) {
                $("#" + _div).append(
                        '<tr id="' + equipos[i].id_equipo + '" class=" equipo_gestores" style="cursor:pointer;">' +
                        '<td>' + equipos[i].id_equipo + '</td>' +
                        '<td class="nom_asig">' + equipos[i].asignacion + '</td>' +
                        '<td>' + equipos[i].equipo + '</td>' +
                        '<td>' + equipos[i].cuentas + '</td>' +
                        '<td>' + equipos[i].importe + '</td>' +
                        '</tr>'
                        );
            }
            $("#" + $("#id_equipo").val()).addClass("equipo_gestores_selected");
        }
    });
}
//==============================================================================
function select_usuarios_cargo(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_usuarios_cargo",
        puesto: id_puesto_usuario,
        puesto2: id_puesto2_usuario,
        puesto3: id_puesto3_usuario,
    };
//    console.log(params);
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
                        '<td>' + equipos[i].id + '</td>' +
                        '<td>' + equipos[i].nombre + '</td>' +
                        '</tr>'
                        );
            }
        }
    });
}
//==============================================================================
function select_usuarios_cargo_filtro(_filtro, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_usuarios_cargo_filtro",
        puesto: id_puesto_usuario,
        puesto2: id_puesto2_usuario,
        puesto3: id_puesto3_usuario,
        filtro: _filtro
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerUsuario",
        data: params,
        dataType: "json",
        success: function (equipos) {
//            console.log(equipos);
            $("#" + _div).empty();
            for (var i in equipos) {
                $("#" + _div).append(
                        '<tr id="' + equipos[i].id + '"  class="agregar_gestor renglon" style="cursor:pointer;">' +
                        '<td>' + equipos[i].id + '</td>' +
                        '<td>' + equipos[i].nombre + '</td>' +
                        '</tr>'
                        );
            }
        }
    });
}
//==============================================================================
function select_usuarios_equipo(_id_equipo, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_usuarios_equipo",
        id_equipo: _id_equipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: params,
        dataType: "json",
        success: function (usuarios) {
//            console.log(usuarios);
            $("#" + _div).empty();
            for (var i in usuarios) {
                $("#" + _div).append(
                        '<tr id="' + usuarios[i].id_usuario + '">' +
                        '<td>' + usuarios[i].id_usuario + '</td>' +
                        '<td>' + usuarios[i].usuario + '</td>' +
                        "<td><img class='delete_gestor_equipo' src='image/i_delete.png'></td>" +
                        '</tr>'
                        );
            }
        }
    });
}
//==============================================================================
function agregar_gestor_equipo(_id_equipo, _id_gestor) {
    var params = {
        action: "agregar_gestor_equipo",
        id_equipo: _id_equipo,
        id_gestor: _id_gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: params,
        dataType: "html",
        success: function (res) {
            alert(res);
            select_equipo_tabla("div_equipos");
            select_usuarios_equipo(_id_equipo, "listado_gestores_equipo");
            guardar_registro_equipo_usuario(params.id_equipo, params.id_gestor);
        }
    });
}
;
//==============================================================================
function delete_usuario_equipo(_id_equipo, _id_gestor) {
    var params = {
        action: "delete_usuario_equipo",
        id_equipo: _id_equipo,
        id_usuario: _id_gestor
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: params,
        dataType: "json",
        success: function (respuesta) {
//            console.log(respuesta);
            select_usuarios_equipo(_id_equipo, "listado_gestores_equipo");
            select_equipo_tabla("div_equipos");

        }
    });
}
;
//==============================================================================
function select_asignaciones_region(_params) {

    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (asignaciones) {
            $("#select_asignacion_f").empty();
            $("#select_asignacion_f").append('<option value="">Selecciona</option>');
            for (let i in asignaciones) {
                $("#select_asignacion_f").append('<option value="' + asignaciones[i].id_asignacion + '">' + asignaciones[i].asignacion + '</option>');
            }
            $('select').formSelect();
        }
    });
}
//=================================================================
function select_regiones() {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: {action: "select_regiones"},
        dataType: "json",
        success: function (regiones) {
            $("#select_region_f").empty();
            $("#select_region_f").append('<option value="">Selecciona</option>');
            for (let i in regiones) {
                $("#select_region_f").append('<option value="' + regiones[i].id_region + '">' + regiones[i].region + '</option>');
            }
            $('select').formSelect();
        }
    });
}
//=================================================================
function select_ciclos_asignacion(_params) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (ciclos) {
            $("#div_ciclos_f").empty();
            $("#div_ciclos_f").append('Ciclos <p><label><input class="checkon_todos"  type="checkbox"/><span>Todos</span></label></p>');
            for (let i in ciclos) {
                $("#div_ciclos_f").append('<p><label><input class="checkon" value="' + ciclos[i].ciclo + '" type="checkbox"/><span>' + ciclos[i].ciclo + '</span></label></p>');
            }

        }
    });
}
//=================================================================
function select_estados_ciclos() {
    let _params = {
        action: "select_estados_ciclos",
        id_asignacion: $("#select_asignacion_f").val(),
        cadena_ciclos: $("#cadena_ciclos").val().substr(0, $("#cadena_ciclos").val().length - 1)
    };
//    console.log(_params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (estados) {
//            console.log(estados);
            $("#div_estados_f").empty();
            $("#div_estados_f").append('Estados <p><label><input class="check_on_todos_estados"  type="checkbox"/><span>Todos</span></label></p>');
            for (let i in estados) {
                $("#div_estados_f").append('<p><label><input class="check_on_estados" value="' + estados[i].estado + '" type="checkbox"/><span>' + estados[i].estado + '</span></label></p>');
            }

        }
    });
}
//=================================================================
function select_status_estados() {
    let _params = {
        action: "select_status_estados",
        id_asignacion: $("#select_asignacion_f").val(),
        cadena_ciclos: $("#cadena_ciclos").val().substr(0, $("#cadena_ciclos").val().length - 1),
        cadena_estados: $("#cadena_estados").val().substr(0, $("#cadena_estados").val().length - 1)

    };
//    console.log(_params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (status) {
//            console.log(status);
            $("#div_estatus_f").empty();
            $("#div_estatus_f").append('Estatus <p><label><input class="check_on_todos_estatus"  type="checkbox"/><span>Todos</span></label></p>');
            for (let i in status) {
                $("#div_estatus_f").append('<p><label><input class="check_on_estatus" value="' + status[i].id_estatus_cuenta + '" type="checkbox"/><span>' + status[i].estatus + '</span></label></p>');
            }

        }
    });
}
//=================================================================
function ver_cuentas_nuevo_equipo_especial() {
    let _params = {
        action: "ver_cuentas_nuevo_equipo_especial",
        id_asignacion: $("#select_asignacion_f").val(),
        cadena_ciclos: $("#cadena_ciclos").val().substr(0, $("#cadena_ciclos").val().length - 1),
        cadena_estados: $("#cadena_estados").val().substr(0, $("#cadena_estados").val().length - 1),
        cadena_estatus: $("#cadena_estatus").val().substr(0, $("#cadena_estatus").val().length - 1),
        tiene_cr: $("#select_cr_f").val(),
        monto: $("#input_monto_f").val()
    };
//    console.log(_params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (cuentas) {
            $("#tbody_cuentas_selecionadas").empty();
            $("#modal_cuentas").modal("open");
            cuentas.map((_cuenta) => {
                $("#tbody_cuentas_selecionadas").append('<tr>' +
                        '<td>' + _cuenta.cuenta + '</td>' +
                        '<td>' + _cuenta.ciclo + '</td>' +
                        '<td>' + _cuenta.estado + '</td>' +
                        '<td>' + _cuenta.estatus + '</td>' +
                        '<td>' + _cuenta.tiene_cr + '</td>' +
                        '<td>' + _cuenta.resto + '</td>' +
                        '</tr>'
                        );
            });
            $("#numero_reg").empty();
            $("#numero_reg").append((document.getElementById("tabla_cuentas_select").rows.length - 1) + " Cuentas");
        }
    });
}
//=================================================================
function crear_equipo_especial() {
    console.log('entro por a qui');
    let _params = {
        action: "crear_equipo_especial",
        id_asignacion: $("#select_asignacion_f").val(),
        cadena_ciclos: $("#cadena_ciclos").val().substr(0, $("#cadena_ciclos").val().length - 1),
        cadena_estados: $("#cadena_estados").val().substr(0, $("#cadena_estados").val().length - 1),
        cadena_estatus: $("#cadena_estatus").val().substr(0, $("#cadena_estatus").val().length - 1),
        tiene_cr: $("#select_cr_f").val(),
        monto: $("#input_monto_f").val()
    };
    console.log(_params);

    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (estatus) {
            console.log(estatus.mensaje);
            $("#tbody_cuentas_selecionadas").empty();
            $("#tbody_cuentas_selecionadas").append("<h5>" + estatus.mensaje + "<h5>");
            $("#nuevo_equipo").val(estatus.id_equipo_nuevo);
            select_equipo_tabla("div_equipos");
            guardar_registro_equipo();
            $("#modal_asignar_cuentas").modal("close");
        }
    });
}
//=================================================================
function guardar_registro_equipo() {
    let _params = {
        action: "guardar_registro_equipo",
        id_asignacion: $("#select_asignacion_f").val(),
        cadena_ciclos: $("#cadena_ciclos").val().substr(0, $("#cadena_ciclos").val().length - 1),
        cadena_estados: $("#cadena_estados").val().substr(0, $("#cadena_estados").val().length - 1),
        cadena_estatus: $("#cadena_estatus").val().substr(0, $("#cadena_estatus").val().length - 1),
        tiene_cr: $("#select_cr_f").val(),
        monto: $("#input_monto_f").val(),
        id_equipo: $("#nuevo_equipo").val()
    };
    console.log(_params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (data) {
            console.log(data);
            console.log("se guardo el registro");
        },
        error: function (er) {
            console.log(er);
        }
    });
}
//=================================================================
function guardar_registro_equipo_usuario(_id_equipo, _id_gestor) {
    let _params = {
        action: "guardar_registro_equipo_usuario",
        id_equipo: _id_equipo,
        id_gestor: _id_gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function () {

        }
    });
}
//=================================================================
function select_cuentas_equipo(_params, _div) {

    $.ajax({
        type: "POST",
        url: "/sistema/ControllerEquipos",
        data: _params,
        dataType: "json",
        success: function (cuentas) {
            let status = {"1": "SIN TOCAR",
                "2": "NC","3": "TS",
                "4": "TNE","5": "MB",
                "6": "DM1","7": "DM2",
                "8": "DM3","9": "DM4",
                "10": "PR","11": "PI",
                "12": "NEG","13": "NP",
                "14": "PP","15": "PRE",
                "16": "PT","17": "AC",
                "18": "CL","19": "REA",
                "20": "BH","21": "FI",
                "22": "AJ","23": "IL1",
                "24": "IL2","25": "IL3",
                "26": "IL4","41": "215",
                "42": "NP16","43": "NP17",
                "44": "NP24","45": "NP25",
                "46": "NP27","47": "NP28",
                "48": "EA","49": "EM",
                "50": "SM","51": "SP",
                "52": "SS","53": "FP",
                "54": "BCO","55": "BNC",
                "56": "SMS"
            };

            $("#" + _div).empty();
            cuentas.map((cuenta) => {
                if(cuenta.cuenta !== undefined) {
                    $("#" + _div).append('<tr>' +
                        '<td>' + cuenta.cuenta + '</td>' +
                        '<td>' + cuenta.ciclo + '</td>' +
                        '<td>' + cuenta.estado + '</td>' +
                        '<td>' + cuenta.estatus + '</td>' +
                        '<td>' + cuenta.tiene_cr + '</td>' +
                        '<td>' + cuenta.resto + '</td>' +
                        '</tr>'
                        );
                }
                
            });
            let parametros_creacion = JSON.parse(cuentas[cuentas.length - 1]);

            let cadena_status = parametros_creacion.cadena_status.split(",");
            $("#caja_asignacion").empty();
            $("#caja_asignacion").append('<p>' + _params.nom_asig + '</p>');
            $("#caja_estatus").empty();
            for (let x in cadena_status) {
                $("#caja_estatus").append('<p>' + status[parseInt(cadena_status[x])] + '</p>');
            }
            
            let cadena_estados = parametros_creacion.cadena_estados.split(",");
            $("#caja_estados").empty();
            for (let x in cadena_estados) {
                $("#caja_estados").append('<p>' + cadena_estados[x] + '</p>');
            }
            
            let cadena_ciclos = parametros_creacion.cadena_ciclos.split(",");
            $("#caja_ciclos").empty();
            for (let x in cadena_ciclos) {
                $("#caja_ciclos").append('<p>' + cadena_ciclos[x] + '</p>');
            }
            
            $("#caja_monto").empty();
            $("#caja_monto").append('<p>' + parametros_creacion.monto + '</p>');
            
            $("#caja_con_cr").empty();
            if(parametros_creacion.con_cr === "1"){
                $("#caja_con_cr").append('<p>Si</p>');
            }else if(parametros_creacion.con_cr === "0") {
                $("#caja_con_cr").append('<p>No</p>');
            } else {
                $("#caja_con_cr").append('<p>Ambos</p>');
            }

            $("#numero_regis").empty();
            $("#numero_regis").append((document.getElementById("tabla_cuentas_equipo").rows.length - 1) + " Cuentas");

        }
    });
} 