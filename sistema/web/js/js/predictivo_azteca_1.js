var options_estatus_llamadas = "";
var options_estatus_cuenta = "";

$(document).ready(function () {
//iniciar el dropdown del menu
    $('.fixed-action-btn').floatingActionButton();
    $('select').formSelect({container: 'body'});
    $('.modal').modal();
    $(".dropdown-trigger").dropdown({constrainWidth: false});
    $('.sidenav').sidenav();


    $(".sidenav").empty();
    $(".sidenav").append(`<li class="center"><img src="image/icon-user.png"><li>`);
    // funcion que pinta el menu
    for (let indice in menu) {
        let submenu_text = '';
        for (let i in menu[indice].submenus) {
            submenu_text += `<a href="${menu[indice].jsp[i]}" class="collection-item"><i class="material-icons left">${menu[indice].iconosSubmenus[i]}</i>${menu[indice].submenus[i]}</a>`;
        }
        $(".sidenav").append(`<li>
            <div class="collapsible-header"><i class="material-icons">${menu[indice].icono}</i>${menu[indice].name}</div>
            <div class="collapsible-body collection">${submenu_text}</div>
        </li>`);
    }

    $('.collapsible').collapsible();
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
    select_datos_cuenta($("#ID_CLIENTE_CLIENTE_UNICO").val());
//    select_agendas();
//    select_llamadas_gestor(id_usuario);
    options_estatus_llamadas = `<option value="5" selected>Selecciona Codigo</option>
        <option value="1">SIN CLASIFICAR</option>
        <option value="2">SIN DATOS</option>
        <option value="3">NO EXISTE</option>
        <option value="4">NO DISPONIBLE</option>
        <option value="5">NO CONTESTA</option>
        <option value="6">NUMERO OCUPADO</option>
        <option value="7">NO LO CONOCE</option>
        <option value="8">FUERA DE SERVICIO</option>
        <option value="9">CUELGA LLAMADA</option>
        <option value="10">CLIENTE NO VIVE AHÍ</option>
        <option value="11">MENSAJE EN BUZON</option>
        <option value="12">MENSAJE TERCERO</option>
        <option value="13">MENSAJE FAMILIAR</option>
        <option value="14">CLIENTE COLGO</option>
        <option value="15">NEGATIVA DE PAGO</option>
        <option value="16">SEGUIMIENTO</option>
        <option value="17">AVAL NO DEFINE</option>
        <option value="18">CLIENTE NO DEFINE</option>
        <option value="19">LIQUIDACION</option>
        <option value="20">REESTRUCTURA</option>
        <option value="21">PLAN ACTIVO</option>
        <option value="22">PROMESA RECURRENTE</option>
        <option value="23">PROMESA PAGO PARCIAL</option>
        <option value="24">PROMESA PAGO INICIAL</option>
        <option value="25">PROMESA DE PAGO</option>
        <option value="26">PLAN CANCELADO</option>
        <option value="27">PLAN INCUMPLIDO</option>
        <option value="28">PROMESA INCUMPLIDA</option>
        <option value="29">DEFUNCION</option>
        <option value="30">CUENTA LIQUIDADA</option>`;
    $("#codigo_llamada").append(options_estatus_llamadas);
    options_estatus_cuenta = ``;
    $("#estatus").append(options_estatus_cuenta);
    $('select').formSelect();

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
$("#new_agenda").click(function () {
    $('#modal_agregar_agenda').modal('open');
});


$("#editar_info_aval").click(function () {
    $('#editar_info_aval').addClass('hide');
    $('#save_info_aval').removeClass('hide');

    $('#datos_marcacion_aval').addClass('hide');
    $('#edit_datos_marcacion_aval').removeClass('hide');
});

$("#save_info_aval").click(function () {

    $('#save_info_aval').addClass('hide');
    $('#editar_info_aval').removeClass('hide');

    $('#edit_datos_marcacion_aval').addClass('hide');
    $('#datos_marcacion_aval').removeClass('hide');
    let cliente_unico = $("#CLIENTE_UNICO").val();
    console.log(cliente_unico.length);
    if (cliente_unico.length > 5) {
//        alert(cliente_unico);
        actualizar_informacion_aval();
    }

});


$("#edit_num").click(function () {

    let data_tel = {
        NOM_TEL1: $("#NOM_TEL1").val(),
        TELEFONO1: $("#TELEFONO1").val(),
        TELEFONO1_2: $("#TELEFONO1_2").val(),

        NOM_TEL2: $("#NOM_TEL2").val(),
        TELEFONO2: $("#TELEFONO2").val(),
        TELEFONO2_2: $("#TELEFONO2_2").val(),

        NOM_TEL3: $("#NOM_TEL3").val(),
        TELEFONO3: $("#TELEFONO3").val(),
        TELEFONO3_2: $("#TELEFONO3_2").val(),

        NOM_TEL4: $("#NOM_TEL4").val(),
        TELEFONO4: $("#TELEFONO4").val(),
        TELEFONO4_2: $("#TELEFONO4_2").val(),

        NOM_TEL5: $("#NOM_TEL5").val(),
        TELEFONO5: $("#TELEFONO5").val(),
        TELEFONO5_2: $("#TELEFONO5_2").val()
    };
    
    for (let tel in data_tel) {
        if ( data_tel[tel] === "" || data_tel[tel] === "SIN INFORMACION") {
        } else {
            $("#" + tel).attr("readonly","readonly");
        }
    }
    
    
//    console.log(data_tel);

    $('#edit_num').addClass('hide');
    $('#save_num').removeClass('hide');

    $('#datos_marcacion_directa').addClass('hide');
    $('#editar_marcacion_directa').removeClass('hide');

});

$("#editar_marcacion_directa input").click( function () {
    let atrib = $(this).attr("readonly");
    let id = $(this).attr("id");
    console.log(atrib);
    if (atrib === "readonly") {
        var person = prompt("Favor de ingresar el codigo de autorizacion", "");
        if (person === "1234") {
            $("#" + id).removeAttr("readonly");
        }else {
            alert("Clave de acceso no autorizado");
        }
    }
}); 



$("#save_num").click(function () {
    $('#save_num').addClass('hide');
    $('#edit_num').removeClass('hide');

    $('#datos_marcacion_directa').removeClass('hide');
    $('#editar_marcacion_directa').addClass('hide');
    let cliente_unico = $("#CLIENTE_UNICO").val();

    if ($("#CLIENTE_UNICO").val().length > 5) {
        actualizar_informacion_contacto();
    }
});

$("#buscar_cuentas").click(function () {
    $('#modal_busqueda').modal('open');
    $('#tb_cont_busqueda').empty();
});

$('#buqueda_relacionada').keyup(function (e) {
    if (e.keyCode === 13) {
        let busqueda = $(this).val();
        if (busqueda.length > 6) {
            buscar_cuentas_gestor(busqueda, id_usuario, 'tb_cont_busqueda');
        } else {
            $('#modal_alerta').modal('open');
            $('#mensaje_alerta').empty();
            $('#mensaje_alerta').append(`El criterio de busqueda es muy corto ingrese mas de 6 letras`);
        }
    }
});

$('#tb_cont_busqueda').on('click', '.cuenta_encontrada', function () {
//    console.log( $('.cuenta_en_CLIENTE_UNICO',this).text() );
    let cuenta = $('.cuenta_en_CLIENTE_UNICO', this).text();
    select_datos_cuenta(cuenta);
    $('#modal_busqueda').modal('close');
});



$('#tbody_tabla_gestiones').on('dblclick', '.tb_gestion_cuenta', function () {
    $('#modal_gestion').modal('open');

    $('#mod_gestion').empty();
    $('#mod_gestion').append($('.g_gestion', this).text());
});




//funcion de buscador
function buscar_cuentas_gestor(_busqueda, _id_puesto, _div) {
    $("#" + _div).empty();
    $("#" + _div).append('<div class="progress"><div class="indeterminate"></div></div>');
    var params = {
        action: "select_buscar_cuentas",
        busqueda: _busqueda,
        id_puesto: _id_puesto
    };
//    console.log();
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (cuentas) {
            $('#' + _div).empty();
            for (let item of cuentas) {
                $('#' + _div).append(`<tr class="cuenta_encontrada">
                <td class="cuenta_en_CLIENTE_UNICO">${item.CLIENTE_UNICO}</td>
                <td>${item.NOMBRE_CTE}</td>
                <td>${item.NOMBRE_AVAL}</td>
                <td>${item.ID_ESTATUS_CUENTA}</td>
                </tr>`);
            }
//            console.log(cuentas);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

$("#buscador_cuentas_gestor").keyup(function (e) {

    if (e.keyCode === 13) {
        if ($("#buscador_cuentas_gestor").val().length > 5) {
            select_datos_cuenta($("#buscador_cuentas_gestor").val());
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
        action: "datos_cuenta_azteca",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
            console.log(datos_cuenta);
            for (var dato in datos_cuenta) {
                $("#" + dato).empty();
                $("#" + dato).val(datos_cuenta[dato]);
            }
            $("#SALDO").val('$ ' + datos_cuenta.SALDO_TOTAL);
            $("#CANAL2").val(datos_cuenta.CANAL);
            $("#MORATORIOS").val('$ ' + datos_cuenta.MORATORIOS);
            $("#SALDO_TOTAL").val('$ ' + datos_cuenta.SALDO_TOTAL);
            $("#IMP_ULTIMO_PAGO").val('$ ' + datos_cuenta.IMP_ULTIMO_PAGO);
            $("#FECHA_ULTIMO_PAGO").val(datos_cuenta.FECHA_ULTIMO_PAGO.split(' ')[0]);

            $("#estatus").empty();
            $("#estatus").append('<option value="1" selected>Selecciona Estatus</option>' + datos_cuenta["ESTATUS_POSIBLES_TXT"]);
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();

            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
            $("#DIRECCION").val(`${datos_cuenta.DIRECCION_CTE}  #${datos_cuenta.NUM_EXT_CTE}`);
            $("#datos_marcacion_directa1").empty();
            $("#datos_marcacion_directa2").empty();
            $("#datos_marcacion_directa1").append(`
                <label>Referencia 1</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL1}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO1_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO1_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO1}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO1}</a></li>
                <label>Referencia 2</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL2}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO2_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO2}</a></li>
            `);
            $("#datos_marcacion_directa2").append(`
                <label>Referencia 3</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL3}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO3_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO3}</a></li>
                <label>Referencia 4</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL4}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO4_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO4_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO4}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO4}</a></li>
            `);
            
            
            $("#datos_marcacion_aval").empty();
            $("#datos_marcacion_aval").append(`<label>Aval Direcion: ${datos_cuenta.COLONIAAVAL} ${datos_cuenta.CALLEAVAL} ${datos_cuenta.NUMEXTAVAL}</label>
                <li class="collection-item black-text">${datos_cuenta.NOMBRE_AVAL}.</a></li>
                <li class="collection-item black-text">.<a class="right num_phone" href="zoiper://${datos_cuenta.TELAVAL2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELAVAL2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELAVAL}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELAVAL}</a></li>
            `);

            select_gestiones_cuenta(datos_cuenta["CLIENTE_UNICO"], "0000-00-00", "tbody_tabla_gestiones");

            $("#Direccion").val(`${datos_cuenta.COLONIA_CTE} ${datos_cuenta.DIRECCION_CTE} ${datos_cuenta.NUM_EXT_CTE} CP: ${datos_cuenta.CP_CTE}, ${datos_cuenta.POBLACION_CTE}, ${datos_cuenta.ESTADO_CTE}`);

            if ($('#primera_llamada').val() === '00:00:00') {
//                select_primera_llamada_gestor();
            }
//            select_numero_llamadas_gestor();
//            select_numero_cuentas_tocadas_gestor();
//            select_numero_convenios_gestor();
        }
    });
}

function actualizar_contacto(params) {
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    })
}

$("#div_telefonos_cuenta").on('click', '#guardar_tel_1', function () {
    let _objContacto = {
        _CUENTA: $('#CLIENTE_UNICO').val(),
        nom_tel_1: $('#nom_tel_1').val(),
        tipo_contact_tel_1: $('#tipo_contact_tel_1').val(),
        act_tel_1: $('#act_tel_1').val()
    };
    let params = {
        action: "actualizar_telefono_1",
        objContacto: JSON.stringify(_objContacto)
    };
    actualizar_contacto(params);
});
$("#div_telefonos_cuenta").on('click', '#guardar_tel_2', function () {
    let _objContacto = {
        _CUENTA: $('#CLIENTE_UNICO').val(),
        nom_tel_2: $('#nom_tel_2').val(),
        tipo_contact_tel_2: $('#tipo_contact_tel_2').val(),
        act_tel_2: $('#act_tel_2').val()
    };
    let params = {
        action: "actualizar_telefono_2",
        objContacto: JSON.stringify(_objContacto)
    };
    actualizar_contacto(params);
});
$("#div_telefonos_cuenta").on('click', '#guardar_tel_3', function () {
    let _objContacto = {
        _CUENTA: $('#CLIENTE_UNICO').val(),
        nom_tel_3: $('#nom_tel_3').val(),
        tipo_contact_tel_3: $('#tipo_contact_tel_3').val(),
        act_tel_3: $('#act_tel_3').val()
    };
    let params = {
        action: "actualizar_telefono_3",
        objContacto: JSON.stringify(_objContacto)
    };
    actualizar_contacto(params);
});
$("#div_telefonos_cuenta").on('click', '#guardar_tel_4', function () {
    let _objContacto = {
        _CUENTA: $('#CLIENTE_UNICO').val(),
        nom_tel_4: $('#nom_tel_4').val(),
        tipo_contact_tel_4: $('#tipo_contact_tel_4').val(),
        act_tel_4: $('#act_tel_4').val()
    };

    let params = {
        action: "actualizar_telefono_4",
        objContacto: JSON.stringify(_objContacto)
    };
    actualizar_contacto(params);
});

$("#div_telefonos_cuenta").on('click', '#guardar_tel_aval', function () {
    let _objContacto = {
        _CUENTA: $('#CLIENTE_UNICO').val(),
        nom_tel_aval: $('#nom_tel_aval').val(),
        tipo_contact_tel_aval: $('#tipo_contact_tel_aval').val(),
        act_tel_aval: $('#act_tel_aval').val()
    };
    let params = {
        action: "actualizar_telefono_5",
        objContacto: JSON.stringify(_objContacto)
    };
    actualizar_contacto(params);
});


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
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (gestiones) {
            $("#" + _div).empty();
            for (var i in gestiones) {
                $("#" + _div).append('<tr class="tb_gestion_cuenta">' +
                        '<td class="g_fecha">' + gestiones[i].FECHA_LARGA + '</td>' +
                        '<td class="g_hora">' + gestiones[i].HORA + '</td>' +
                        '<td class="g_num_marcado">' + gestiones[i].NUMERO_MARCADO + '</td>' +
                        '<td class="g_usuario">' + gestiones[i].ID_USUARIO + '</td>' +
                        '<td class="g_estatus">' + gestiones[i].ID_ESTATUS_CUENTA + '</td>' +
                        '<td class="g_codigo">' + gestiones[i].ID_ESTATUS_LLAMADA + '</td>' +
                        '<td class="g_gestion">' + gestiones[i].GESTION + '</td>' +
                        '<td class="g_duracio">' + gestiones[i].DURACION + '</td>' +
                        '</tr>'
                        );
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }

    });
}

$('#tab_pagos').click(function () {
    let id_cliente = $('#CLIENTE_UNICO').val();
    select_pagos_cuenta(id_cliente, 'tbody_tabla_pagos');
});

function select_pagos_cuenta(_cuenta, _div) {

    var params = {
        action: "select_pagos_cuenta",
        cuenta: _cuenta
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (pagos) {
            $("#" + _div).empty();
            console.log(pagos);
            if (pagos.length === 0) {
                $("#" + _div).append("Esta cuenta no tiene ningun pago");
            } else {
                for (var item of pagos) {
                    $("#" + _div).append(`<tr>
                        <td>${item.ID_PAGO}</td>
                        <td>${item.CLIENTE_UNICO}</td>
                        <td>${item.ZONA}</td>
                        <td>${item.GERENTE}</td>
                        <td>${item.FECHA_GESTION}</td>
                        <td>${item.RECUPERACION_CAPITAL}</td>
                        <td>${item.RECUPERACION_MORATORIOS}</td>
                        </tr>`
                            );
                }
            }

        },
        error: function (error) {
            console.log(error);
        }
    });
}



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
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (convenios) {
//            console.log(convenios);
            var color_status = ["", "yellow", "green", "red lighten-2"];
            $("#" + _div).empty();
            for (var i in convenios) {
                $("#" + _div).append('<tr class="' + color_status[ convenios[i].ID_CONVENIO ] + '">' +
                        '<td>' + convenios[i].CUENTA + '</td>' +
                        '<td>' + convenios[i].ID_USUARIO + '</td>' +
                        '<td>' + convenios[i].CONVENIO + '</td>' +
                        '<td>' + convenios[i].FECHA_INSET + '</td>' +
                        '<td>' + convenios[i].ATRASO_MAXIMO + '</td>' +
                        '<td>' + convenios[i].FECHA + '</td>' +
                        '<td>' + convenios[i].PAGOS + '</td>' +
                        '<td>' + convenios[i].FECHA_PAGO + '</td>' +
                        '<td>' + convenios[i].EFECTIVIDAD + '</td>' +
                        '<td>' + convenios[i].ID_ESTATUS + '</td>' +
                        '</tr>'
                        );
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
$("#tab_convenios").click(function () {
    if ($("#cuenta_deudor").val() !== "") {
        select_convenios_cuenta($("#CLIENTE_UNICO").val(), "tbody_tabla_convenios");
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
//            console.log(respuesta);
            $("#primera_llamada").val(respuesta.hora.substr(11, 15));
            $("#cuentas_tocadas").val(respuesta.cuentas);
            $("#llamadas_realizadas").val(respuesta.llamadas);
            $("#convenios").val(respuesta.convenios);
        }
    });
}

// funciones de select Cuenta siguete
function select_cuenta_siguiente(_id_usuario) {
    var params = {
        action: "select_cuenta_siguiente",
        id_usuario: _id_usuario
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
//            console.log(datos_cuenta);
            if (datos_cuenta.id_cuenta === 0) {
                alert("Sin cuentas");
            } else {
                $("#div_cuentas_encontradas").addClass("hide");
                $("#div_telefonos_cuenta").removeClass("hide");
                for (var dato in datos_cuenta) {
                    $("#" + dato).empty();
                    $("#" + dato).val(datos_cuenta[dato]);
                }
                $("#SALDO").val('$ ' + datos_cuenta.SALDO_TOTAL);
                $("#CANAL2").val(datos_cuenta.CANAL);
                $("#MORATORIOS").val('$ ' + datos_cuenta.MORATORIOS);
                $("#SALDO_TOTAL").val('$ ' + datos_cuenta.SALDO_TOTAL);
                $("#IMP_ULTIMO_PAGO").val('$ ' + datos_cuenta.IMP_ULTIMO_PAGO);
                $("#FECHA_ULTIMO_PAGO").val(datos_cuenta.FECHA_ULTIMO_PAGO.split(' ')[0]);

                $("#estatus").empty();
                $("#estatus").append('<option value="0"  selected>Selecciona Estatus</option>' + datos_cuenta["ESTATUS_POSIBLES_TXT"]);
                $("#codigo_llamada").empty();
                $("#codigo_llamada").append(options_estatus_llamadas);
                $('select').formSelect();

                $("#numero_marcado_deudor, #gestion").val("");
                $("#tiempo_actual").val("00:00:00");
                $("#retraso_actual").val("00:00:00");
                $("#DIRECCION").val(`${datos_cuenta.DIRECCION_CTE}  #${datos_cuenta.NUM_EXT_CTE}`);
               $("#datos_marcacion_directa1").empty();
            $("#datos_marcacion_directa2").empty();
            $("#datos_marcacion_directa1").append(`
                <label>Referencia 1</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL1}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO1_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO1_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO1}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO1}</a></li>
                <label>Referencia 2</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL2}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO2_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO2}</a></li>
            `);
            $("#datos_marcacion_directa2").append(`
                <label>Referencia 3</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL3}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO3_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO3}</a></li>
                <label>Referencia 4</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL4}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO4_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO4_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO4}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO4}</a></li>
            `);
            
            
            $("#datos_marcacion_aval").empty();
            $("#datos_marcacion_aval").append(`<label>Aval Direcion: ${datos_cuenta.COLONIAAVAL} ${datos_cuenta.CALLEAVAL} ${datos_cuenta.NUMEXTAVAL}</label>
                <li class="collection-item black-text">${datos_cuenta.NOMBRE_AVAL}.</a></li>
                <li class="collection-item black-text">.<a class="right num_phone" href="zoiper://${datos_cuenta.TELAVAL2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELAVAL2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELAVAL}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELAVAL}</a></li>
            `);

                $('#cuenta_siguiente').removeClass('disabled');

                select_gestiones_cuenta(datos_cuenta["CLIENTE_UNICO"], '0000-00-00', "tbody_tabla_gestiones");


                $("#Direccion").val(`${datos_cuenta.COLONIA_CTE} ${datos_cuenta.DIRECCION_CTE} ${datos_cuenta.NUM_EXT_CTE} CP: ${datos_cuenta.CP_CTE}, ${datos_cuenta.POBLACION_CTE}, ${datos_cuenta.ESTADO_CTE}`);


                if ($('#primera_llamada').val() === '00:00:00') {
//                    select_primera_llamada_gestor();
                }
//                select_numero_llamadas_gestor();
//                select_numero_cuentas_tocadas_gestor();
//                select_numero_convenios_gestor();
            }

        },
        error: function (err) {
            console.log(err.responseText);
        }
    });
}

$("#cuenta_siguiente").click(function () {
    $('#cuenta_siguiente').addClass('disabled');
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
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (result) {
            alert("Gestion guardada");
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $("#gestion").val("");
            $('select').formSelect();
            $("#numero_marcado_deudor").val();
            $("#gestion").val($("#numero_marcado_deudor").val());
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
            $('#guardar_gestion').removeClass('disabled');

            select_gestiones_cuenta(myObj["_CUENTA"], '0000-00-00', "tbody_tabla_gestiones");
        },

        error: function (error) {
            console.log(error);
        }
    });
}

$("#guardar_gestion").click(function () {

    if ($("#codigo_llamada").val() !== "0" && $("#gestion").val() !== "" && $("#numero_marcado_deudor").val() !== "" && $("#estatus").val() !== "") {
        var myObjGestion = {
            _ID_SUCURSAL: $('#ID_SUCURSAL').val(),
            _ID_CLIENTE: $('#ID_CLIENTE').val(),
            _TERRITORIO: $('#TERRITORIO').val(),
            _CANAL: $('#CANAL').val(),
            _ATRASO_MAXIMO: $('#ATRASO_MAXIMO').val(),
            _CUENTA: $('#CLIENTE_UNICO').val(),
            _NUMERO_MARCADO: $('#numero_marcado_deudor').val(),
            _ID_ESTATUS_CUENTA: $('#estatus').val(),
            _ID_ESTATUS_LLAMADA: $('#codigo_llamada').val(),
            _ID_USUARIO: id_usuario,
            _GESTION: $('#gestion').val(),
            _DURACION: $('#tiempo_actual').val(),
            _RETASO: $('#retraso_actual').val(),
            _ID_PUESTO: id_puesto_usuario,
            _PROMESA: 0,
            _F_PREDICTIVO: 1,
            _ID_EQUIPO: $('#ID_EQUIPO').val()
        };

        $('#guardar_gestion').addClass('disabled');
//        console.log(myObjGestion);
        insertar_gestion(myObjGestion);
    } else {
        $("#modal_alerta").modal("open");
        $("#mensaje_alerta").empty();
        $("#mensaje_alerta").append('Favor de rellenar los sigientes campos<br><br>' +
                '- Disposicion <br>- Codigo de llamada <br>- Numero marcado');
    }
});
$("#datos_marcacion_directa1").delegate(".num_phone", "click", function () {
    $("#numero_marcado_deudor").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
    $(".num_phone").removeClass("numero_marcado");
    $(this).addClass("numero_marcado");
    $("#gestion").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
    $("#gestion").removeAttr("readonly");
});
$("#datos_marcacion_directa2").delegate(".num_phone", "click", function () {
    $("#numero_marcado_deudor").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
    $(".num_phone").removeClass("numero_marcado");
    $(this).addClass("numero_marcado");
    $("#gestion").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
    $("#gestion").removeAttr("readonly");
});
// Insert Convenio 
function insertar_convenio(_myObjConvenio, _myObjGestion) {
//    console.log(_myObjConvenio);
//    console.log(_myObjGestion);
    var params = {
        action: "insertar_convenio",
        datos: JSON.stringify(_myObjConvenio)
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (respuesta) {
//            console.log(respuesta);
            $("#alerta_convenio").empty();
            $("#alerta_convenio").append(`${respuesta.resultado} ${respuesta.mensaje}`);
            $("#importe_convenio").val("");
            $("#fecha_convenio").val("");

            if (respuesta.resultado !== "NO PERMITIDO" && respuesta.resultado !== "VERIFICA FECHA" && respuesta.resultado !== "VERIFIQUE IMPORTE Y LA FECHA DEL CONVENIO") {
                insertar_gestion(_myObjGestion);
                $("#modal_convenio").modal("close");
                $("#codigo_llamada").empty();
                $("#codigo_llamada").append(options_estatus_llamadas);
                $('select').formSelect();
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

$("#codigo_llamada").change(function () {
    if ($("#codigo_llamada").val() === "22" || $("#codigo_llamada").val() === "23" || $("#codigo_llamada").val() === "24" || $("#codigo_llamada").val() === "25" || $("#codigo_llamada").val() === "19") {
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
        if (validacion === 0 && $("#estatus").val() !== "0") {
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
        _ID_SUCURSAL: $('#ID_SUCURSAL').val(),
        _ID_CLIENTE: $('#ID_CLIENTE').val(),
        _TERRITORIO: $('#TERRITORIO').val(),
        _CANAL: $('#CANAL').val(),
        _ATRASO_MAXIMO: $('#ATRASO_MAXIMO').val(),
        _CUENTA: $('#CLIENTE_UNICO').val(),
        _NUMERO_MARCADO: $('#numero_marcado_deudor').val().replace(/ /gi, ""),
        _ID_ESTATUS_CUENTA: $('#estatus').val(),
        _ID_ESTATUS_LLAMADA: $('#codigo_llamada').val(),
        _ID_USUARIO: id_usuario,
        _GESTION: $('#gestion').val().replace(/"|,|'|-/gi, ""),
        _DURACION: $('#tiempo_actual').val(),
        _RETASO: $('#retraso_actual').val(),
        _ID_PUESTO: id_puesto_usuario,
        _PROMESA: 1,
        _F_PREDICTIVO: 0,
        _ID_EQUIPO: $('#ID_EQUIPO').val()
    };
    var myObjConvenio = {
        CONVENIO: $("#importe_convenio").val(),
        FECHA: $("#fecha_convenio").val(),
        ID_USUARIO: id_usuario,
        CUENTA: $('#CLIENTE_UNICO').val(),
        TERRITORIO: $('#TERRITORIO').val(),
        GERENCIA: $('#GERENCIA').val(),
        ID_ESTATUS_LLAMADA: $('#codigo_llamada').val(),
        TIPO_CONVENIO: $('#TIPO_CONVENIO').val(),
        GERENTE: $('#GERENTE').val(),
        NOMBRE_CTE: $('#NOMBRE_CTE').val(),
        CANAL: $('#CANAL').val(),
        ATRASO_MAXIMO: $('#ATRASO_MAXIMO').val(),
        ID_EQUIPO: $('#ID_EQUIPO').val(),
        PASSwORD: $('#password_convenio').val()
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
//    console.log($(this).text());
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

function update_time_gestor() {
    let params = {
        action: "update_time_gestor",
        id_gestor: id_usuario
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}

//var time_gestor = setInterval(function () {
//    update_time_gestor();
//}, 59000);

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

        minutos = 0;
        horas++;
    }
    if (minutos <= 9)
        minutos = "0" + minutos;
    if (minutos >= 20 || horas > 0) {
        $(".div_input_gestor_tiempos").css("background-color", "#ffeb3b");
        cronometro_retraso_actual();
    }
    if (minutos === 30)
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

$("#TIPO_CONVENIO").change(function () {
    if ($(this).val() === "3") {
        $("#CAJA_SEMANAS_PAGO").removeClass("hide");
    } else {
        $("#CAJA_SEMANAS_PAGO").addClass("hide");
    }
});

$('#insertar_agenda').click(function () {
    insertar_agenda();
});

$('#tab_agendas').click(function () {
    select_agendas();
});

function insertar_agenda() {
    let params = {
        action: 'insertar_agenda',
        cliente_unico: $('#cliente_unico_agenda').val(),
        id_usuario: id_usuario,
        descripcion: $('#descripcion_agenda').val(),
        fecha: $('#fecha_agenda').val(),
        hora: $('#hora_agenda').val()
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerGestor",
        data: params,
        dataType: "json",
        success: function (result) {
            console.log(result);
            if (result.response === 'OK') {
                $('#cliente_unico_agenda').val('');
                $('#descripcion_agenda').val('');
                $('#fecha_agenda').val('');
                $('#hora_agenda').val('');
                $('#modal_agregar_agenda').modal('close');
                select_agendas();
            } else {
                $('#mensaje_error_agenda').empty();
                $('#mensaje_error_agenda').append(result.response);

            }
        },
        error: function (err) {
            console.log(err);
        }
    });

}

function select_agendas() {
    $.ajax({
        type: "POST",
        url: "ControllerGestor",
        data: {action: 'select_agendas', id_gestor: id_usuario},
        dataType: "json",
        success: function (result) {
            console.log(result);
            $('#tb_list_agenda').empty();
            for (let item of result) {
                $('#tb_list_agenda').append(`<tr id='row_agenda_${item.ID_REGISTRO}' class='row_reg_agenda ${item.F_ACTIVE}'>
                <td>${item.ID_REGISTRO}</td>
                <td>${item.CLIENTE_UNICO}</td>
                <td>${item.DESCRIPCION}</td>
                <td>${item.FECHA}</td>
                <td>${item.HORA}</td>
                </tr>`);
                if (parseInt(item.H_EJECUTAR) > 0) {
                    console.log(parseInt(item.H_EJECUTAR));
                    setTimeout(() => {
                        select_list_agendas_modal(item.CLIENTE_UNICO, item.DESCRIPCION, item.FECHA, item.HORA, item.ID_REGISTRO);
                        $('#modal_ver_agenda').modal('open');
                    }, parseInt(item.H_EJECUTAR) * 1000);
                }

            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

$('#agenta_hora').click(function () {
    $('#mensaje_error_agenda').empty();
});

$("#tb_list_agenda").on("click", ".row_reg_agenda", function () {
    $(".row_reg_agenda").removeClass("selected");
    $("#id_reg_agenda").val($(this).attr("id").replace("row_agenda_", ""));
    $(this).addClass("selected");
});

$("#cuenta_agenda_datos").click(function () {
    let cliente_unico = $("#agenta_cliente_unico").val();
    let id_reg_agenda = $("#id_agenda_gestor").val();
    select_datos_cuenta(cliente_unico);
    descartar_agenda_gestor(id_reg_agenda);
});

$("#ver_modal_agendas").click(function () {
    $('#modal_ver_agenda').modal('open');
});

// tb_cont_agenda
function select_list_agendas_modal(_cuenta, _descripcion, _fecha, _hora, _id_reg_agenda) {
    $("#agenta_cliente_unico").val(_cuenta);
    $("#agenta_descripcion").val(_descripcion);
    $("#agenta_fecha").val(_fecha);
    $("#agenta_hora").val(_hora);
    $("#id_agenda_gestor").val(_id_reg_agenda);
//    $.ajax({
//        type: "POST",
//        url: "ControllerGestor",
//        data: {action: 'select_agendas', id_gestor: id_usuario},
//        dataType: "json",
//        success: function (result) {
//            $('#tb_cont_agenda').empty();
//            for (let item of result) {
//                $('#tb_cont_agenda').append(`<tr class='${item.HORA}'>
//                <td>${item.CLIENTE_UNICO}</td>
//                <td>${item.DESCRIPCION}</td>
//                <td>${item.FECHA}</td>
//                <td>${item.HORA}</td>
//                </tr>`);
//            }
//            
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
}


function actualizar_informacion_contacto() {
    let params = {
        action: 'actualizar_informacion_contacto',
        nom_tel1: $('#NOM_TEL1').val(),
        tel1_1: $('#TELEFONO1').val(),
        tel1_2: $('#TELEFONO1_2').val(),
        nom_tel2: $('#NOM_TEL2').val(),
        tel2_1: $('#TELEFONO2').val(),
        tel2_2: $('#TELEFONO2_2').val(),
        nom_tel3: $('#NOM_TEL3').val(),
        tel3_1: $('#TELEFONO3').val(),
        tel3_2: $('#TELEFONO3_2').val(),
        nom_tel4: $('#NOM_TEL4').val(),
        tel4_1: $('#TELEFONO4').val(),
        tel4_2: $('#TELEFONO4_2').val(),
        nom_tel5: $('#NOM_TEL5').val(),
        tel5_1: $('#TELEFONO5').val(),
        tel5_2: $('#TELEFONO5_2').val(),
        cuenta: $('#CLIENTE_UNICO').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (result) {
            console.log(result);
            select_datos_cuenta(params.cuenta);
        },
        error: function (error) {
            console.log(error);
        }
    });
}


function actualizar_informacion_aval() {
    let params = {
        action: 'actualizar_informacion_aval',
        nom_tel_aval: $('#NOMBRE_AVAL').val(),
        tel_aval_1: $('#TELAVAL').val(),
        tel_aval_2: $('#TELAVAL2').val(),
        calle_aval: $('#CALLEAVAL').val(),
        cuenta: $('#CLIENTE_UNICO').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (result) {
            console.log(result);
            select_datos_cuenta(params.cuenta);
        },
        error: function (error) {
            console.log(error);
        }
    });
}


function select_primera_llamada_gestor() {
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: {action: 'select_primera_llamada_gestor', id_gestor: id_usuario},
        dataType: "json",
        success: function (result) {
//            console.log(result);
            $('#primera_llamada').val(result.HORA);
        },
        error: function (error) {
            console.log(error);
        }
    });
}
function select_numero_llamadas_gestor() {
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: {action: 'select_numero_llamadas_gestor', id_gestor: id_usuario},
        dataType: "json",
        success: function (result) {
//            console.log(result);
            $('#llamadas_realizadas').val(result.NUM_GESTIONES);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function select_numero_convenios_gestor() {
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: {action: 'select_numero_convenios_gestor', id_gestor: id_usuario},
        dataType: "json",
        success: function (result) {
//            console.log(result);
            $('#convenios').val(result.NUM_CONVENIOS);
        },
        error: function (error) {
            console.log(error);
        }
    });
}
function select_numero_cuentas_tocadas_gestor() {
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: {action: 'select_numero_cuentas_tocadas_gestor', id_gestor: id_usuario},
        dataType: "json",
        success: function (result) {
//            console.log(result);
            $('#cuentas_tocadas').val(result.NUM_CUENTAS);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

$("#m_familiar").click(function () {
    $('#modal_mensaje_familiar').modal('open');
});

$("#m_tercero").click(function () {
    $('#modal_mensaje_tercero').modal('open');
});

$("#m_aval").click(function () {
    $('#modal_mensaje_aval').modal('open');
});

$("#m_tt").click(function () {
    $('#modal_mensaje_tt').modal('open');
});

function descartar_agenda_gestor(_id_registro) {
    $.ajax({
        type: "POST",
        url: "ControllerGestor",
        data: {action: 'descartar_agenda_gestor', id_reg: _id_registro},
        dataType: "json",
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
}
