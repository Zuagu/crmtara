var options_estatus_llamadas = "";
$(document).ready(function () {
    //iniciar el dropdown del menu
    $('.fixed-action-btn').floatingActionButton();
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
        autoClose: true,
        closeOnSelect: true, // Close upon selecting a date,
        format: "yyyy-mm-dd"
    });
    $('.timepicker').timepicker({
        default: 'now',
        twelveHour: false,
        container: 'body'
    });
    $("#tiempo_actual").val("00:00:00");
    $("#retraso_actual").val("00:00:00");


});

window.onload = function () {
    select_cuenta_siguiente(id_usuario);
    select_llamadas_gestor(id_usuario);
    options_estatus_llamadas = '<option value="0"  selected>Selecciona Codigo</option>' +
            '<option value="1">1A (promesa de Pago)</option>' +
            '<option value="2">3D (Contacto con Titular)</option>' +
            '<option value="3">3A (Contacto con Familiar)</option>' +
            '<option value="4">3B (No Contacto)</option>' +
            '<option value="5">3E (Llamada Entrante)</option>' +
            '<option value="6">2A (Gestion de Visita)</option>' +
            '<option value="7">1B (Pago Parcial)</option>' +
            '<option value="8">1C (Cuenta Liquidada)</option>' +
            '<option value="9">1D (Pendiente Reactivar)</option>' +
            '<option value="10">3C (No Gestion)</option>' +
            '<option value="11">4A (Buzon Voz)</option>' +
            '<option value="12">4B (Tel No Existe)</option>' +
            '<option value="13">4C (Tel Suspendido)</option>' +
            '<option value="14">4D (No Conoce a Titular)</option>' +
            '<option value="15">4F (Cambio Domicilio)</option>' +
            '<option value="16">4G (Ilocalizable)</option>' +
            '<option value="17">4E (A Peticion de Famsa)</option>' +
            '<option value="18">4H (Dictaminada)</option>' +
            '<option value="19">4J (No Contesta Predictivo)</option>' +
            '<option value="20">2B (Segunda Gestion Visita)</option>' +
            '<option value="21">3F (Tercera Gestion Visita)</option>';
    $("#codigo_llamada").append(options_estatus_llamadas);
    $('select').formSelect();
}

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
// funcion que esconde el menu 
$("#colect").delegate('.collection-item', 'click', function () {
    $("#resultado_menu").addClass("hide");
});

$(".row").click(function () {
    $("#resultado_menu").addClass("hide");
});
// funciones del pantalla del gestor
//pagos_diarios tab
$("#tab_pagos_diarios").click(function () {
    $(".rango_fechas_pagos_diarios").removeClass("hide");
    $(".div_tabla_pagos_diarios").addClass("hide");


});
$("#mostrar_pagos_diarios").click(function () {
    $(".rango_fechas_pagos_diarios").addClass("hide");
    $(".div_tabla_pagos_diarios").removeClass("hide");


});


//visitas tab
$("#mostrar_visitas").click(function () {
    $(".rango-fechas-visitas").addClass("hide");
    $("#tabla_visitas").removeClass("s10 m10 l10");
    $("#tabla_visitas").addClass("s12 m12 l12");
});
$("#tab_visitas").click(function () {
    $(".rango-fechas-visitas").removeClass("hide");
    $("#tabla_visitas").removeClass("s12 m12 l12");
    $("#tabla_visitas").addClass("s10 m10 l10");
});
//convenios tab
$("#mostrar_convenios").click(function () {
    $(".rango-fechas-convenios").addClass("hide");
    $("#tabla_convenios").removeClass("s10 m10 l10");
    $("#tabla_convenios").addClass("s12 m12 l12");
});
$("#tab_convenios").click(function () {
    $(".rango-fechas-convenios").removeClass("hide");
    $("#tabla_convenios").removeClass("s12 m12 l12");
    $("#tabla_convenios").addClass("s10 m10 l10");
});
//estadisticas tab
$("#mostrar_estadisticas").click(function () {
    $(".rango-fechas-estadisticas").addClass("hide");
    $("#tabla_estadisticas").removeClass("s10 m10 l10");
    $("#tabla_estadisticas").addClass("s12 m12 l12");
});
$("#tab_estadisticas").click(function () {
    $(".rango-fechas-estadisticas").removeClass("hide");
    $("#tabla_estadisticas").removeClass("s12 m12 l12");
    $("#tabla_estadisticas").addClass("s10 m10 l10");
});
//agendas tab
$("#mostrar_agendas").click(function () {
    $(".rango-fechas-agendas").addClass("hide");
    $("#tabla_agendas").removeClass("s10 m10 l10");
    $("#tabla_agendas").addClass("s12 m12 l12");
});
$("#tab_agendas").click(function () {
    $(".rango-fechas-agendas").removeClass("hide");
    $("#tabla_agendas").removeClass("s12 m12 l12");
    $("#tabla_agendas").addClass("s10 m10 l10");
});
//funcion de buscador
function buscar_cuentas_gestor(_busqueda, _id_puesto, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_central.gif' width='100%'>");
    var params = {
        action: "select_buscar_cuentas",
        busqueda: _busqueda,
        id_puesto: _id_puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (cuentas) {
//            console.log(cuentas);
            $("#" + _div).empty();
            for (var i in cuentas) {
                $("#" + _div).append('<div class="col s12 m12 l12 hoverable z-depth-2 div-res">' +
                        '<input class="val_cuenta" type="hidden" value="' + cuentas[i].id_cuenta + ',' + cuentas[i].cuenta + '">' +
                        '<span class="black-text cuentas_data "><b>Cuenta: </b><span>' + cuentas[i].cuenta + '</span></span>' +
                        '<span class="black-text cuentas_data"><b>&nbsp;&nbsp;&nbsp; Exp:</b> ' + cuentas[i].expediente + '</span> <br>' +
                        '<span class="black-text cuentas_data"><b>Nombre:</b> ' + cuentas[i].nombre + '</span> <br>' +
                        '<span class="black-text cuentas_data"><b>Asig:</b> ' + cuentas[i].asignacion + '</span>' +
                        '<span class="black-text cuentas_data"><b>&nbsp;&nbsp;&nbsp; Estatus:</b> ' + cuentas[i].ultimo_estatus_cuenta + '</span>' +
                        '<span class="black-text cuentas_data"><b>&nbsp;&nbsp;&nbsp; Codigo:</b> ' + cuentas[i].ultimo_estatus_llamada + '</span><br>' +
                        '<span class="black-text cuentas_data"><b>Ref1:</b> ' + cuentas[i].referencia1 + '</span><br>' +
                        '<span class="black-text cuentas_data"><b>:Ref2:</b> ' + cuentas[i].referencia2 + '</span>' +
                        '</div>');
            }
        }
    });
}
;

$("#buscador_cuentas_gestor").keyup(function (e) {

    if (e.keyCode === 13) {
        if ($("#buscador_cuentas_gestor").val().length > 5) {
            //limipiar inputs info_gestor, info_gestor_secundario
//            $("#info_gestor input, #info_gestor_secundario input").val("");
//            $("#tbody_tabla_convenios, #tbody_tabla_gestiones, #tbody_tabla_pagos").empty();

            $("#div_cuentas_encontradas").removeClass("hide");
            $("#div_telefonos_cuenta").addClass("hide");
            $(".div_search_gestor").addClass("s3 m3 l3");
            $(".div_search_gestor").removeClass("s2 m2 l2");
            $(".contenido-datos").addClass("s9 m9 l9");
            $(".contenido-datos").removeClass("s10 m10 l10");
            buscar_cuentas_gestor($("#buscador_cuentas_gestor").val(), id_puesto_usuario, "div_cuentas_encontradas");
        } else {
            $("#modal_alerta").modal("open");
            $("#mensaje_alerta").empty();
            $("#mensaje_alerta").append("<br>El criterio de busqueda es muy corto");
        }
    }
});

$("#buscador_cuentas_gestor").click(function () {
//    $("#div_cuentas_encontradas").empty();
});
// funciones de datos cuenta
function select_datos_cuenta(_cuenta) {
    var params = {
        action: "select_datos_cuenta",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
            console.log(datos_cuenta);
            for (var dato in datos_cuenta) {
                $("#" + dato).empty();
                $("#" + dato).val(datos_cuenta[dato]);
            }
            $("#estatus").empty();
            $("#estatus").append('<option value="0"  selected>Selecciona Estatus</option>' + datos_cuenta.status);
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();
            $("#div_telefonos_cuenta").empty();
            $("#numero_marcado_deudor, #gestion").val("");
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
            pintar_telefonos_cuenta(datos_cuenta["telefonos"]);
            telefonos_relacionados(datos_cuenta["cuenta_deudor"]);
            var f_inicio = datos_cuenta["inicio_deudor"].split(" ");
            select_gestiones_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_gestiones");
            select_pagos_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_pagos");
        }
    });
}
function select_datos_cuenta_relacionada(_cuenta) {
    var params = {
        action: "select_datos_cuenta_relacionada",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
//            console.log(datos_cuenta);
            for (var dato in datos_cuenta) {
                $("#" + dato).empty();
                $("#" + dato).val(datos_cuenta[dato]);
            }
            $("#estatus").empty();
            $("#estatus").append('<option value="0"  selected>Selecciona Estatus</option>' + datos_cuenta.status);
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();
            $("#div_telefonos_cuenta").empty();
            $("#numero_marcado_deudor, #gestion").val("");
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
            pintar_telefonos_cuenta(datos_cuenta["telefonos"]);
            telefonos_relacionados(datos_cuenta["cuenta_deudor"]);
            var f_inicio = datos_cuenta["inicio_deudor"].split(" ");
            select_gestiones_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_gestiones");
            select_pagos_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_pagos");
        }
    });
}

function pintar_telefonos_cuenta(telefonos) {
    $("#div_telefonos_cuenta").append('<div class="div-telefonos hoverable z-depth-1">' +
            '<span class="black-text"><b>Telefonos</b></span><br>' +
            '<span class="">T1: <a class="tell" href="zoiper://' + telefonos["T1"].replace(/ /g, "") + '">' + telefonos["T1"] + '</a></span><br>' +
            '<span class="">T2: <a class="tell" href="zoiper://' + telefonos["T2"].replace(/ /g, "") + '">' + telefonos["T2"] + '</a></span>' +
            '</div>');
    var tel_ref1 = telefonos["R1"].split(":");
    var tel_ref2 = telefonos["R2"].split(":");
    $("#div_telefonos_cuenta").append('<div class="div-telefonos hoverable z-depth-1">' +
            '<span class="black-text"><b>Referencias</b></span><br>' +
            '<span class="">' + tel_ref1[0] + '<br><a class="tell" href="zoiper://' + tel_ref1[1].replace(/ /g, "") + '">' + tel_ref1[1] + '</a></span><br>' +
            '<span class="">' + tel_ref2[0] + '<br><a class="tell" href="zoiper://' + tel_ref2[1].replace(/ /g, "") + '">' + tel_ref2[1] + '</a></span>' +
            '</div>');
}
function telefonos_relacionados(_cuenta) {
    var params = {
        action: "select_telefonos_cr",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (tels_cr) {
//            console.log(tels_cr);

            var crs = '<div class="div-telefonos hoverable z-depth-1"><b>Relacionadas</b><br>';
            for (var i in tels_cr) {
                crs += '<span class="">' + tels_cr[i].nombre + ':</span><br>';
                crs += '<span class=""><a class="tell" href="zoiper://' + tels_cr[i].telefono.replace(/ /g, "") + '">' + tels_cr[i].telefono + '</a></span><br>';
            }
            crs += '</div>';
            $("#div_telefonos_cuenta").append(crs);
        }
    });
}
function select_gestiones_cuenta(_cuenta, _fecha_inico, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_gestiones_cuenta",
        cuenta: _cuenta,
        fecha_inico: _fecha_inico
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (gestiones) {
            $("#" + _div).empty();

            for (var i in gestiones) {
                $("#" + _div).append('<tr>' +
                        '<td>' + gestiones[i].fecha + '</td>' +
                        '<td>' + gestiones[i].hora + '</td>' +
                        '<td>' + gestiones[i].numero_marcado + '</td>' +
                        '<td>' + gestiones[i].gestor + '</td>' +
                        '<td>' + gestiones[i].estatus_cuenta + '</td>' +
                        '<td>' + gestiones[i].estatus_llamada + '</td>' +
                        '<td>' + gestiones[i].gestion + '</td>' +
                        '<td>' + gestiones[i].duracion + '</td>' +
                        '</tr>'
                        );
            }

        }
    });
}
function select_pagos_cuenta(_cuenta, _fecha_inico, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_pagos_cuenta",
        cuenta: _cuenta,
        fecha_inico: _fecha_inico
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (pagos) {
            $("#" + _div).empty();
//            console.log(pagos.length);
            if (pagos.length === 0) {
                $("#" + _div).append("Esta cuenta no tiene ningun pago");
            } else {
                for (var i in pagos) {
                    $("#" + _div).append('<tr>' +
                            '<td>' + pagos[i].cuenta + '</td>' +
                            '<td>' + pagos[i].fecha_pago + '</td>' +
                            '<td>' + pagos[i].origen + '</td>' +
                            '<td>' + pagos[i].importe + '</td>' +
                            '<td>' + pagos[i].forma + '</td>' +
                            '<td>' + pagos[i].status + '</td>' +
                            '<td>' + pagos[i].fecha_aplicacion + '</td>' +
                            '</tr>'
                            );
                }
            }

        }
    });
}
$("#div_cuentas_encontradas").delegate(".div-res", "click", function () {
    var cuenta = $(".val_cuenta", this).val().split(",");
//    console.log(cuenta);
    if (cuenta[0] !== "0") {
        select_datos_cuenta(cuenta[0]);
    } else {
//        alert(cuenta[1]);
        select_datos_cuenta_relacionada(cuenta[1]);
    }
    $(".div_search_gestor").addClass("s2 m2 l2");
    $(".div_search_gestor").removeClass("s3 m3 l3");
    $(".contenido-datos").addClass("s10 m10 l10");
    $(".contenido-datos").removeClass("s9 m9 l9");
    $("#div_cuentas_encontradas").addClass("hide");
    $("#div_telefonos_cuenta").removeClass("hide");
});

// funciones de pagos diarios gestor
function mostrar_pagos_diarios(_desde, _hasta, _id_usuario, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "mostrar_pagos_diarios",
        desde: _desde,
        hasta: _hasta,
        id_usuario: _id_usuario
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (pagos_diarios) {
            $("#" + _div).empty();
//            console.log(pagos_diarios.length);
            if (pagos_diarios.length === 0) {
                $("#" + _div).append("No hay");
            } else {

                var totales = [];
                var total_pagos = 0;
                var total_aplica = 0;
                var actualAsignacion = pagos_diarios[0].asignacion;
                for (var i in pagos_diarios) {
                    total_pagos = total_pagos + pagos_diarios[i].pago;
                    total_aplica = total_aplica + pagos_diarios[i].aplica;

                    if (actualAsignacion !== pagos_diarios[i].asignacion) {
                        totales.push(total_pagos, total_aplica);
                        total_pagos = total_pagos + pagos_diarios[i].pago;
                        total_aplica = total_aplica + pagos_diarios[i].aplica;

                        $("#" + _div).append('<tr>' +
                                '<td></td>' +
                                '<td>' + actualAsignacion + '</td>' +
                                '<td></td>' +
                                '<td>' + pagos_diarios[i].id_equipo + '</td>' +
                                '<td>' + pagos_diarios[i - 1].nombre_equipo + '</td>' +
                                '<td></td>' +
                                '<td></td>' +
                                '<td>' + total_pagos.toFixed(2) + '</td>' +
                                '<td>' + total_aplica.toFixed(2) + '</td>' +
                                '<td></td>' +
                                '</tr>'
                                );
                    }

                    actualAsignacion = pagos_diarios[i].asignacion;

                    $("#" + _div).append('<tr>' +
                            '<td>' + pagos_diarios[i].fecha + '</td>' +
                            '<td>' + pagos_diarios[i].asignacion + '</td>' +
                            '<td>' + pagos_diarios[i].cuenta + '</td>' +
                            '<td>' + pagos_diarios[i].id_equipo + '</td>' +
                            '<td>' + pagos_diarios[i].nombre_equipo + '</td>' +
                            '<td>' + pagos_diarios[i].vencido.toFixed(2) + '</td>' +
                            '<td>' + pagos_diarios[i].resto.toFixed(2) + '</td>' +
                            '<td>' + pagos_diarios[i].pago.toFixed(2) + '</td>' +
                            '<td>' + pagos_diarios[i].aplica.toFixed(2) + '</td>' +
                            '<td>' + pagos_diarios[i].resto_actual.toFixed(2) + '</td>' +
                            '</tr>'
                            );
                }
                $("#" + _div).append('<tr>' +
                        '<td></td>' +
                        '<td>' + pagos_diarios[i].asignacion + '</td>' +
                        '<td>' + +'</td>' +
                        '<td>' + pagos_diarios[i].id_equipo + '</td>' +
                        '<td>' + pagos_diarios[i].nombre_equipo + '</td>' +
                        '<td></td>' +
                        '<td></td>' +
                        '<td>' + total_pagos.toFixed(2) + '</td>' +
                        '<td>' + total_aplica.toFixed(2) + '</td>' +
                        '<td></td>' +
                        '</tr>'
                        );
//                console.log(totales);
            }

        }
    });
}
$("#mostrar_pagos_diarios").click(function () {
    mostrar_pagos_diarios($("#desde_pagos_gestor").val(), $("#hasta_pagos_gestor").val(), id_usuario, "tbody_tabla_pagos_diarios");

});

// funciones de select convenios
function select_convenios_cuenta(_cuenta, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_convenios_cuenta",
        cuenta: _cuenta
    };
    
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (convenios) {
//            console.log(convenios);
            var color_status = ["", "yellow", "green", "red lighten-2"];
            $("#" + _div).empty();
            for (var i in convenios) {
                $("#" + _div).append('<tr class="' + color_status[ convenios[i].id_estatus ] + '">' +
                        '<td>' + convenios[i].cuenta + '</td>' +
                        '<td>' + convenios[i].usuario + '</td>' +
                        '<td>' + convenios[i].convenio + '</td>' +
                        '<td>' + convenios[i].fecha_gestion + '</td>' +
                        '<td>' + convenios[i].plazo + '</td>' +
                        '<td>' + convenios[i].fecha_convenio + '</td>' +
                        '<td>' + convenios[i].pagos + '</td>' +
                        '<td>' + convenios[i].fecha_pago + '</td>' +
                        '<td>' + convenios[i].efectividad + '</td>' +
                        '<td>' + convenios[i].estatus + '</td>' +
                        '</tr>'
                        );
            }
        }
    });
}
$("#tab_convenios").click(function () {
    if ($("#cuenta_deudor").val() !== "") {
        select_convenios_cuenta($("#cuenta_deudor").val(), "tbody_tabla_convenios");
    } else {
        $("#tbody_tabla_convenios").empty();
        $("#tbody_tabla_convenios").append("No hay una Cuenta Selecionada");
    }

});
// Conteo de llamadas del gestor
function select_llamadas_gestor(_id_usuario) {
    $.ajax({
        type: 'POST',
        url: "/sistema/ControllerGestor",
        data: {action: "select_llamadas_gestor", id_usuario: _id_usuario},
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            $("#primera_llamada").val(respuesta.hora.substr(11, 15));
            $("#cuentas_tocadas").val(respuesta.cuentas);
            $("#llamadas_realizadas").val(respuesta.llamadas);
            $("#convenios").val(respuesta.convenios);
        }
    });
}

function conteo_llamadas_guardar_gestion(_id_status_llamada) {
    console.log(_id_status_llamada);
    var llamadas = parseInt($("#llamadas_realizadas").val());
    llamadas++;
    $("#llamadas_realizadas").val(llamadas);
    if (_id_status_llamada === "1") {
        var convenios = parseInt($("#convenios").val());
        convenios++;
        $("#convenios").val(convenios);
    }
}
function conteo_llamadas_cuenta_siguiente() {
    var cuentas_tocadas = parseInt($("#cuentas_tocadas").val());
    cuentas_tocadas++;
    $("#cuentas_tocadas").val(cuentas_tocadas);
}


// funciones de select Cuenta siguete
function select_cuenta_siguiente(_id_usuario) {
    var params = {
        action: "select_cuenta_siguiente",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
            console.log(datos_cuenta);
            if(datos_cuenta.cuenta_deudor === 0) {
                alert("Sin cuentas");
            }else {
                $("#div_cuentas_encontradas").addClass("hide");
                $("#div_telefonos_cuenta").removeClass("hide");
                for (var dato in datos_cuenta) {
                    $("#" + dato).empty();
                    $("#" + dato).val(datos_cuenta[dato]);
                }
                $("#estatus").empty();
                $("#estatus").append('<option value="0"  selected>Selecciona Estatus</option>' + datos_cuenta.status);
                $("#codigo_llamada").empty();
                $("#codigo_llamada").append(options_estatus_llamadas);
                $('select').formSelect();
                $("#div_telefonos_cuenta").empty();
                $("#numero_marcado_deudor, #gestion").val("");
                $("#tiempo_actual").val("00:00:00");
                $("#retraso_actual").val("00:00:00");
                conteo_llamadas_cuenta_siguiente();
                pintar_telefonos_cuenta(datos_cuenta["telefonos"]);
                telefonos_relacionados(datos_cuenta["cuenta_deudor"]);
                var f_inicio = datos_cuenta["inicio_deudor"].split(" ");
                select_gestiones_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_gestiones");
                select_pagos_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_pagos");
                $("#gestion").attr("readonly", "readonly");
            }
            
        }
    });
}

$("#cuenta_siguiente").click(function () {
    select_cuenta_siguiente(id_usuario);
});

// Funciones para insert Gestion

//$(".limpiar_numero").keyup( function (evt) {
//    console.log(evt);
//});

$(".limpiar_texto").keyup(function () {
    var cadena = $(this).val().replace(/[&\/\#,+()$~%'":*?<>{}|]/g, '');
    cadena = cadena.toUpperCase();
    $(this).val(cadena);

});

function insertar_gestion(myObj) {
//    console.log(myObj);

    var params = {
        action: "guardar_gestion",
        datos: JSON.stringify(myObj)
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
//            console.log(datos_cuenta);
            var f_inicio = myObj["fecha_inicio"].split(" ");
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $("#gestion").val("");
            $('select').formSelect();
            $("#numero_marcado_deudor").val("");
            $("#gestion").attr("readonly", "readonly");

            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
            conteo_llamadas_guardar_gestion(myObj.id_estatus_llamada);
            select_gestiones_cuenta(myObj["cuenta"], f_inicio[0], "tbody_tabla_gestiones");
        }
    });
}

$("#guardar_gestion").click(function () {

    if ($("#codigo_llamada").val() !== "0" && $("#gestion").val() !== "" && $("#numero_marcado_deudor").val() !== "" && $("#estatus").val() !== "") {
        var myObjGestion = {
            id_cuenta: $("#id_cuenta_deudor").val(),
            id_asignacion: $("#id_asignacion_deudor").val(),
            id_region: $("#id_region_deudor").val(),
            id_cliente: $("#id_cliente_deudor").val(),
            fecha_fin: $("#fecha_fin_deudor").val(),
            fecha_inicio: $("#inicio_deudor").val(),
            numero_marcado: $("#numero_marcado_deudor").val().replace(/ /gi, ""),
            cuenta: $("#cuenta_deudor").val(),
            id_estatus_cuenta: $("#estatus").val(),
            id_estatus_llamada: $("#codigo_llamada").val(),
            id_usuario: id_usuario,
            id_puesto: id_puesto_usuario,
            gestion: $("#gestion").val().replace(/"|,|'|-/gi, ""),
            duracion: $("#tiempo_actual").val(),
            retraso_llamada: $("#retraso_actual").val(),
            expediente: $("#expediente_deudor").val(),
            f_predictivo: 0
        };
        insertar_gestion(myObjGestion);
    } else {
        $("#modal_alerta").modal("open");
        $("#mensaje_alerta").empty();
        $("#mensaje_alerta").append('Favor de rellenar los sigientes campos<br><br>' +
                '- Disposicion <br>- Codigo de llamada <br>- Numero marcado');
    }
});

$("#div_telefonos_cuenta").delegate(".tell", "click", function () {
    $("#numero_marcado_deudor").val($(this).text());
    $(".tell").removeClass("numero_marcado");
    $(this).addClass("numero_marcado");
    $("#gestion").val($(this).text());
    $("#gestion").removeAttr("readonly");
});

// Insert Convenio 
function insertar_convenio(_myObjConvenio, _myObjGestion) {
//    console.log(_myObjConvenio);
    var params = {
        action: "insertar_convenio",
        datos: JSON.stringify(_myObjConvenio)
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (respuesta) {
//            console.log(respuesta);
            $("#alerta_convenio").empty();
            $("#alerta_convenio").append(respuesta.resultado);
            $("#importe_convenio").val("");
            $("#fecha_convenio").val("");
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();

            if (respuesta.resultado !== "NO PERMITIDO" && respuesta.resultado !== "VERIFICA FECHA" && respuesta.resultado !== "VERIFIQUE IMPORTE Y LA FECHA DEL CONVENIO") {
                insertar_gestion(_myObjGestion);
                $("#modal_convenio").modal("close");

            }
        }
    });
}

$("#codigo_llamada").change(function () {
    if ($("#codigo_llamada").val() === "1") {
        var validacion = 0;
        var myObjGestion = {
            id_cuenta: $("#id_cuenta_deudor").val(),
            id_asignacion: $("#id_asignacion_deudor").val(),
            id_region: $("#id_region_deudor").val(),
            id_cliente: $("#id_cliente_deudor").val(),
            fecha_fin: $("#fecha_fin_deudor").val(),
            fecha_inicio: $("#inicio_deudor").val(),
            numero_marcado: $("#numero_marcado_deudor").val().replace(/ /gi, ""),
            cuenta: $("#cuenta_deudor").val(),
            id_estatus_cuenta: $("#estatus").val(),
            id_estatus_llamada: $("#codigo_llamada").val(),
            id_usuario: id_usuario,
            id_puesto: id_puesto_usuario,
            gestion: $("#gestion").val().replace(/"|,|'|-/gi, ""),
            duracion: $("#tiempo_actual").val(),
            retraso_llamada: $("#retraso_actual").val(),
            expediente: $("#expediente_deudor").val(),
            f_predictivo: 0
        };
        for (var obj in myObjGestion) {
            if (myObjGestion[obj] === "") {
                validacion++;
            }
        }
        if ($("#codigo_llamada").val() === "1" && validacion === 0 && $("#estatus").val() !== "0") {
            $("#modal_convenio").modal("open");
        } else {
            $("#modal_alerta").modal("open");
            $("#mensaje_alerta").empty();
            $("#mensaje_alerta").append('Favor de rellenar los sigientes campos para poder agregar un convenio<br><br>' +
                    '- Disposicion <br>- Codigo de llamada <br>- Numero marcado <br>');
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();
        }
    }

});

$("#insert_convenio").click(function () {
    var myObjGestion = {
        id_cuenta: $("#id_cuenta_deudor").val(),
        id_asignacion: $("#id_asignacion_deudor").val(),
        id_region: $("#id_region_deudor").val(),
        id_cliente: $("#id_cliente_deudor").val(),
        fecha_fin: $("#fecha_fin_deudor").val(),
        fecha_inicio: $("#inicio_deudor").val(),
        numero_marcado: $("#numero_marcado_deudor").val().replace(/ /gi, ""),
        cuenta: $("#cuenta_deudor").val(),
        id_estatus_cuenta: $("#estatus").val(),
        id_estatus_llamada: $("#codigo_llamada").val(),
        id_usuario: id_usuario,
        id_puesto: id_puesto_usuario,
        gestion: $("#gestion").val().replace(/"|,|'|-/gi, ""),
        duracion: $("#tiempo_actual").val(),
        retraso_llamada: $("#retraso_actual").val(),
        expediente: $("#expediente_deudor").val(),
        f_predictivo: 0
    };

    var myObjConvenio = {
        convenio: $("#importe_convenio").val(),
        fecha: $("#fecha_convenio").val(),
        id_usuario: id_usuario,
        cuenta: $("#cuenta_deudor").val(),
        id_asignacion: $("#id_asignacion_deudor").val(),
        id_region: $("#id_region_deudor").val()
    };
    var validacion = 0;
    for (var obj in myObjConvenio) {
        if (myObjConvenio[obj] === "") {
            validacion++;
        }
    }
    if (validacion === 0) {
        insertar_convenio(myObjConvenio, myObjGestion);
    } else {
        $("#alerta_convenio").empty();
        $("#alerta_convenio").append("Faltan datos por llenar");
    }
});
$("#importe_convenio, #fecha_convenio").click(function () {
    $("#alerta_convenio").empty();
});
$("#cancelar_convenio").click(function () {
    $("#alerta_convenio").empty();
    $("#importe_convenio").val("");
    $("#fecha_convenio").val("");
    $("#codigo_llamada").empty();
    $("#codigo_llamada").append(options_estatus_llamadas);
    $('select').formSelect();
});
// funciones de select_saldos_gestores
function select_equipos_usuario(_id_usuario, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='35%'>");
    var params = {
        action: "select_equipos_usuario",
        id_usuario: _id_usuario
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (saldos) {
//            console.log(saldos);
            var totales = {
                descripcion: "TOTAL",
                suma_cuentas: 0,
                suma_asignado: 0
            };
            $("#" + _div).empty();
            for (var i in saldos) {
                totales.suma_cuentas += saldos[i].cuentas;
                totales.suma_asignado += saldos[i].asignado;
                $("#" + _div).append('<tr id="' + saldos[i].id_equipo + '" class="equipo_usuario">' +
                        '<td>' + saldos[i].asignacion + '</td>' +
                        '<td>' + saldos[i].equipo + '</td>' +
                        '<td>' + saldos[i].cuentas + '</td>' +
                        '<td>' + saldos[i].asignado + '</td>' +
                        '</tr>'
                        );
            }
//            console.log(totales);
            $("#" + _div).append('<tr id="' + _id_usuario + '" class="equipo_usuario green">' +
                    '<td></td> <td>' + totales.descripcion + '</td><td>' + totales.suma_cuentas + '</td><td>' + totales.suma_asignado + '</td></tr>');
        }
    });
}

function select_saldos_gestores(_id_usuario, _id_equipo, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='35%'>");
    var params = {
        action: "select_saldos_gestores",
        id_usuario: _id_usuario,
        id_equipo: _id_equipo
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (saldos) {
            $("#" + _div).empty();
            for (var i in saldos) {
                $("#" + _div).append('<tr id="' + saldos[i].ultimo_estatus_cuenta + '" class="grupos_estatus ' + saldos[i].color + '">' +
                        '<td class="equipo hide">' + _id_equipo + '</td>' +
                        '<td>' + saldos[i].region + '</td>' +
                        '<td>' + saldos[i].estatus + '</td>' +
                        '<td>' + saldos[i].cuentas + '</td>' +
                        '<td>' + saldos[i].valor + '</td>' +
                        '<td>' + saldos[i].ultimo_toque + '</td>' +
                        '<td>' + saldos[i].grupo + '</td>' +
                        '</tr>'
                        );
            }
        }
    });
}
function select_cuentas_de_estaus(_id_usuario, _id_equipo, _id_status, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='35%'>");
    var params = {
        action: "select_cuentas_de_estaus",
        id_equipo: _id_equipo,
        id_status: _id_status,
        id_usuario: _id_usuario
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (saldos) {
//            console.log(saldos);
            $("#" + _div).empty();
            for (var i in saldos) {
                $("#" + _div).append('<tr>' +
                        '<td>' + saldos[i].region + '</td>' +
                        '<td  class="saldos_status_cuenta"><a>' + saldos[i].cuenta + '</a></td>' +
                        '<td>' + saldos[i].estatus + '</td>' +
                        '<td>' + saldos[i].resto + '</td>' +
                        '<td>' + saldos[i].ultima_gestion + '</td>' +
                        '</tr>'
                        );
            }
        }
    });
}

$("#tab_saldos").click(function () {
//    select_saldos_gestores(id_usuario, 'tbody_tabla_saldos_status');
    select_equipos_usuario(id_usuario, 'tbody_tabla_equipos_usuario');
    $("#tabla_equipos_usuario").removeClass("hide");
    $("#tabla_saldos_status").addClass("hide");
    $("#tabla_cuentas_status").addClass("hide");
});

$("#tbody_tabla_equipos_usuario").delegate('.equipo_usuario', 'dblclick', function () {
    select_saldos_gestores(id_usuario, $(this).closest("tr").attr("id"), 'tbody_tabla_saldos_status');
    $("#tabla_equipos_usuario").addClass("hide");
    $("#tabla_saldos_status").removeClass("hide");
});
$("#tbody_tabla_saldos_status").delegate('.grupos_estatus', 'dblclick', function () {
    if ($(this).closest("tr").attr("id") !== "") {
        select_cuentas_de_estaus(id_usuario, $('.equipo', this).text(), $(this).closest("tr").attr("id"), 'tbody_tabla_cuentas_status');
        $("#tabla_saldos_status").addClass("hide");
        $("#tabla_cuentas_status").removeClass("hide");
    }
});
$("#tbody_tabla_cuentas_status").delegate('.saldos_status_cuenta', 'click', function () {
    console.log($(this).text());
    $("#tab_saldos").removeClass("active");
    $("#tab_gestiones").addClass("active");
    $('.tabs').tabs();
    select_datos_cuenta_relacionada($(this).text());
});


// Controlar tiempos del gestor 
function cronometro_retraso_actual() {
    var datos = $("#retraso_actual").val().split(":");
    var horas = datos[0];
    var minutos = datos[1];
    var segundos = datos[2];

    horas = parseInt(horas);
    minutos = parseInt(minutos);
    segundos = parseInt(segundos);
    segundos++;

    if (segundos >= 60) {
        segundos = 0;
        minutos++;
    }
    if (minutos >= 60) {
        minutos = 0;
        horas++;
    }
    if (minutos <= 9)
        minutos = "0" + minutos;
    if (segundos <= 9)
        segundos = "0" + segundos;
    if (horas <= 9)
        horas = "0" + horas;

    $("#retraso_actual").val('');
    $("#retraso_actual").val(horas + ":" + minutos + ":" + segundos);
}

function cronometro_llamada_actual() {
    var datos = $("#tiempo_actual").val().split(":");
    var horas = datos[0];
    var minutos = datos[1];
    var segundos = datos[2];

    horas = parseInt(horas);
    minutos = parseInt(minutos);
    segundos = parseInt(segundos);
    segundos++;

    if (segundos >= 60) {
        segundos = 0;
        minutos++;
    }
    if (minutos >= 60) {
//        select_llamadas_gestor(_id_usuario);
        minutos = 0;
        horas++;
    }
    if (minutos <= 9)
        minutos = "0" + minutos;
    if (minutos >= 5 || horas > 0) {
        $(".div_input_gestor_tiempos").css("background-color", "#ffeb3b");
        cronometro_retraso_actual();
    }
    if (minutos === 10)
        $(".div_input_gestor_tiempos").css("background-color", "#f44336");
    if (segundos <= 9)
        segundos = "0" + segundos;
    if (horas <= 9)
        horas = "0" + horas;

    $("#tiempo_actual").val('');
    $("#tiempo_actual").val(horas + ":" + minutos + ":" + segundos);
}
var tiempo_llamada_actual = setInterval(function () {
    cronometro_llamada_actual();
}, 1000);

// funciones de Agenda
function insert_agenda() {
    var params = {
        action: "insert_agenda",
        fecha: "2019-12-06",
        hora: "12:30:00",
        descripcion: ""
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (result) {
//            console.log(saldos);
        }
    });
}

function select_agenda_disponible() {
    var params = {
        action: "select_agenda_disponible",
        id_usuario: 69
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (result) {
//            console.log(saldos);
        }
    });
}
