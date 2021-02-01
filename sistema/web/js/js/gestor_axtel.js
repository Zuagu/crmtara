
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
    select_cuenta_siguiente(id_usuario);
    options_estatus_llamadas = `<option value="0" selected>Selecciona Codigo</option>
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
        <option value="30">CUENTA LIQUIDADA</option>
        <option value="31">ACLARACION</option>
        `;
    $("#codigo_llamada").append(options_estatus_llamadas);
    options_estatus_cuenta = ``;
    $("#estatus").append(options_estatus_cuenta);
    $('select').formSelect();
    select_agendas();
};


// =============================================================================
$("#cerrar").click(function () {
    Cerrar(id_usuario);
});
function Cerrar(id) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerUsuario",
        data: {action: "cerrar_sesion", id_usuario: id}
    });
}
// =============================================================================
// funcion que lanza el menu lateral
$(".img_log").click(function () {
    $('.sidenav').sidenav('open');
});

// =============================================================================

$("#edit_num").click(function () {
//    console.log("Funcion no disponible");
    $('#edit_num').addClass('hide');
    $('#save_num').removeClass('hide');

    $('#datos_marcacion_directa').addClass('hide');
    $('#editar_marcacion_directa').removeClass('hide');
    
});

$("#save_num").click(function () {
    
    $('#save_num').addClass('hide');
    $('#edit_num').removeClass('hide');

    $('#datos_marcacion_directa').removeClass('hide');
    $('#editar_marcacion_directa').addClass('hide');
    let cliente_unico = $("#CUENTA").val();

    if ( cliente_unico.length > 5) {
        actualizar_informacion_contacto();
    }
    
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
    let cliente_unico = $("#CUENTA").val();
    console.log(cliente_unico.length);
    if (cliente_unico.length > 5) {
        actualizar_informacion_cont_principal();
    }

});
// =============================================================================
$("#buscar_cuentas").click(function () {
    $('#modal_busqueda').modal('open');
    $('#tb_cont_busqueda').empty();
});
// =============================================================================
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

// =============================================================================
$(".limpiar_texto").keyup(function () {
    var cadena = $(this).val().replace(/[&\/\#,+()$~%'":*?<>{}|]/g, '');
    $(this).val(cadena);
});
// =============================================================================
$("#datos_marcacion_directa").delegate(".num_phone", "click", function () {
    $("#numero_marcado_deudor").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
    $(".num_phone").removeClass("numero_marcado");
    $(this).addClass("numero_marcado");
    let num = $(this).text().replace('phone_iphone', '').replace('local_phone', '');
    if (num.length >= 8) {
        $("#gestion").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
        $("#gestion").removeAttr("readonly");
    } else {
        alert("El dato selecionado no es numero");
    }
});

$("#datos_marcacion_aval").delegate(".num_phone", "click", function () {
    $("#numero_marcado_deudor").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
    $(".num_phone").removeClass("numero_marcado");
    $(this).addClass("numero_marcado");
    let num = $(this).text().replace('phone_iphone', '').replace('local_phone', '');
    if (num.length >= 8) {
        $("#gestion").val($(this).text().replace('phone_iphone', '').replace('local_phone', ''));
        $("#gestion").removeAttr("readonly");
    } else {
        alert("El dato selecionado no es numero");
    }
});
// =============================================================================
$("#guardar_gestion").click(function () {
    console.log($("#codigo_llamada").val());
    console.log($("#gestion").val());
    console.log($("#numero_marcado_deudor").val());
    console.log($("#estatus").val());

    if ($("#codigo_llamada").val() !== "0" && $("#gestion").val() !== "" && $("#numero_marcado_deudor").val() !== "" && $("#estatus").val() !== "") {
        var myObjGestion = {
            _CUENTA: $('#CUENTA').val(),
            _NUMERO_MARCADO: $('#numero_marcado_deudor').val(),
            _ID_ESTATUS_CUENTA: $('#estatus').val(),
            _ID_ESTATUS_LLAMADA: $('#codigo_llamada').val(),
            _ID_USUARIO: id_usuario,
            _GESTION: $('#gestion').val(),
            _DURACION: $('#tiempo_actual').val(),
            _RETASO: $('#retraso_actual').val(),
            _ID_PUESTO: id_puesto_usuario,
            _PROMESA: 0,
            _F_PREDICTIVO: 0
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
// =============================================================================
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
// =============================================================================
$('#tb_cont_busqueda').on('click', '.cuenta_encontrada', function () {
//    console.log( $('.cuenta_en_CLIENTE_UNICO',this).text() );
    let cuenta = $('.cuenta_en_CLIENTE_UNICO', this).text();
    select_datos_cuenta(cuenta);
    $('#modal_busqueda').modal('close');
});

// =============================================================================
$("#cuenta_siguiente").click( function () {
    select_cuenta_siguiente(id_usuario);
});
// =============================================================================
$("#VENCIDO").click( function () {
    $("#modal_vencido_b").modal('open');
});
// =============================================================================
// Seccion de Agendas
$("#new_agenda").click(function () {
    $('#modal_agregar_agenda').modal('open');
});


$('#insertar_agenda').click(function () {
    insertar_agenda();
});

$('#tab_agendas').click(function () {
    select_agendas();
});

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

// =============================================================================

// =============================================================================

// =============================================================================

// =============================================================================
// =============================================================================
// =============================================================================
// =============================================================================
// ============================== Funciones ====================================
// =============================================================================
// =============================================================================
// =============================================================================
function select_cuenta_siguiente(_id_usuario) {
    var params = {
        action: "cuentaSiguiete",
        id_usuario: _id_usuario
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAxtel",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
            console.log(datos_cuenta);
            if (datos_cuenta.IDENTIFICADOR === '0') {
                alert('Esta cuenta ya esta inactiva y asignada a otro despacho');
            }
            for (var dato in datos_cuenta) {
                $("#" + dato).empty();
                $("#" + dato).val(datos_cuenta[dato]);
            }
            
            $("#estatus").empty();
            $("#estatus").append('<option value=""  selected>Selecciona Estatus</option>' + datos_cuenta["ESTATUS_POSIBLES_TXT"]);
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();

            $("#numero_marcado_deudor, #gestion").val("");
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");

            $("#datos_marcacion_directa").empty();
            $("#datos_marcacion_directa").append(`
                <label>NOM_TEL2</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL2}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO2_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO2}</a></li>
                <label>NOM_TEL3</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL3}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO3_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO3}</a></li>
            `);
            $("#datos_marcacion_aval").empty();
            $("#datos_marcacion_aval").append(`<label>Contacto Princial: ${datos_cuenta.CONTACTO_PRINCIAL}</label>
                <li class="collection-item black-text">.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO_PRINCIPAL_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO_PRINCIPAL_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO_PRINCIPAL}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO_PRINCIPAL}</a></li>
                <li class="collection-item black-text"><a> ${datos_cuenta.COMENTERIO1} </a><a> ${datos_cuenta.COMENTERIO2} </a><a> ${datos_cuenta.COMENTERIO3} </a></li>
            `);
            select_gestiones_cuenta(datos_cuenta.CUENTA, "0000-00-00", "tbody_tabla_gestiones");
            $("#DIRECCION_AXTEL").val(`${datos_cuenta.COLONIA} ${datos_cuenta.CALLE_NUM} CP: ${datos_cuenta.CP}, ${datos_cuenta.CIUDAD}, ${datos_cuenta.ESTADO}`);
            
            $("#TOTAL_DESCUENTO").val( (parseFloat(datos_cuenta.DESCUENTO.replace("%","")) *  parseFloat(datos_cuenta.TOTAL))/100  );
        },
        error: function (error) {
            console.log(error);
        }
    });
}
    
// =============================================================================

function select_datos_cuenta(_cuenta) {
    var params = {
        action: "datos_cuenta_axtel",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAxtel",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
            console.log(datos_cuenta);
            if (datos_cuenta.IDENTIFICADOR === '0') {
                alert('Esta cuenta ya esta inactiva y asignada a otro despacho');
            }
            for (var dato in datos_cuenta) {
                $("#" + dato).empty();
                $("#" + dato).val(datos_cuenta[dato]);
            }
            $("#SALDO").val('$ ' + datos_cuenta.SALDO_TOTAL);


            $("#estatus").empty();
            $("#estatus").append('<option value=""  selected>Selecciona Estatus</option>' + datos_cuenta["ESTATUS_POSIBLES_TXT"]);
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();

            $("#numero_marcado_deudor, #gestion").val("");
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");

            $("#datos_marcacion_directa").empty();
            $("#datos_marcacion_directa").append(`
                <label>NOM_TEL2</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL2}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO2_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO2}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO2}</a></li>
                <label>NOM_TEL3</label>
                <li class="collection-item black-text">${datos_cuenta.NOM_TEL3}.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO3_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO3}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO3}</a></li>
            `);
            $("#datos_marcacion_aval").empty();
            $("#datos_marcacion_aval").append(`<label>Contacto Princial: ${datos_cuenta.CONTACTO_PRINCIAL}</label>
                <li class="collection-item black-text">.<a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO_PRINCIPAL_2}"><i class="material-icons small">local_phone</i>${datos_cuenta.TELEFONO_PRINCIPAL_2}</a> <a class="right num_phone" href="zoiper://${datos_cuenta.TELEFONO_PRINCIPAL}"><i class="material-icons small">phone_iphone</i>${datos_cuenta.TELEFONO_PRINCIPAL}</a></li>
                <li class="collection-item black-text"><a> ${datos_cuenta.COMENTERIO1} </a><a> ${datos_cuenta.COMENTERIO2} </a><a> ${datos_cuenta.COMENTERIO3} </a></li>
            `);
            select_gestiones_cuenta(datos_cuenta.CUENTA, "0000-00-00", "tbody_tabla_gestiones");
            $("#DIRECCION_AXTEL").val(`${datos_cuenta.COLONIA} ${datos_cuenta.CALLE_NUM} CP: ${datos_cuenta.CP}, ${datos_cuenta.CIUDAD}, ${datos_cuenta.ESTADO}`);
            
            $("#TOTAL_DESCUENTO").val( (parseFloat(datos_cuenta.DESCUENTO.replace("%","")) *  parseFloat(datos_cuenta.TOTAL))/100  );
            
        }
    });
}

// =============================================================================
function insertar_gestion(myObj) {
//    console.log(myObj);

    var params = {
        action: "guardar_gestion",
        datos: JSON.stringify(myObj)
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAxtel",
        data: params,
        dataType: "json",
        success: function (result) {
            alert("Gestion guardada");
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $("#gestion").val("");
            $('select').formSelect();
            $("#numero_marcado_deudor").val("");
            $("#gestion").attr("readonly", "readonly");
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
// =============================================================================
function select_gestiones_cuenta(_cuenta, _fecha_inico, _div) {
    $("#" + _div).empty();
    $("#" + _div).append('<div class="progress"><div class="indeterminate"></div></div>');
    var params = {
        action: "select_gestiones_cuenta",
        cuenta: _cuenta,
        fecha_inico: _fecha_inico
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAxtel",
        data: params,
        dataType: "json",
        success: function (gestiones) {
            
            $("#" + _div).empty();
            for (var i in gestiones) {
                $("#" + _div).append('<tr class="tb_gestion_cuenta">' +
                        '<td class="g_fecha">' + gestiones[i].FECHA_INSERT + '</td>' +
                        '<td class="g_hora">' + gestiones[i].HORA + '</td>' +
                        '<td class="g_num_marcado">' + gestiones[i].NUMERO_MARCADO + '</td>' +
                        '<td class="g_usuario">' + gestiones[i].ID_USUARIO + '</td>' +
                        '<td class="g_estatus">' + gestiones[i].ID_ESTATUS_CUENTA + '</td>' +
                        '<td class="g_codigo">' + gestiones[i].ID_ESTATUS_LLAMDA + '</td>' +
                        '<td class="g_gestion">' + gestiones[i].GESTION + '</td>' +
                        '<td class="g_duracio">' + gestiones[i].DURACION + '</td>' +
                        '</tr>'
                        );
            }
        },
        error: function (error) {
            console.log(error);
        }

    });
}
// =============================================================================
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
        url: "ControllerDataCuentaAxtel",
        data: params,
        dataType: "json",
        success: function (cuentas) {
            $('#' + _div).empty();
            for (let item of cuentas) {
                $('#' + _div).append(`<tr class="cuenta_encontrada">
                <td class="cuenta_en_CLIENTE_UNICO">${item.CUENTA}</td>
                <td>${item.CLIENTE}</td>
                <td>${item.REFERENCIA}</td>
                <td>${item.CATEGORIA}</td>
                </tr>`);
            }
//            console.log(cuentas);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

// =============================================================================
function actualizar_informacion_contacto() {
    let params = {
        action: 'actualizar_informacion_contacto',
        
        NOM_TEL2: $('#NOM_TEL2').val(),
        TELEFONO2: $('#TELEFONO2').val(),
        TELEFONO2_2: $('#TELEFONO2_2').val(),
        
        NOM_TEL3: $('#NOM_TEL3').val(),
        TELEFONO3: $('#TELEFONO3').val(),
        TELEFONO3_2: $('#TELEFONO3_2').val(),
        
        CLIENTE_UNICO: $('#CUENTA').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAxtel",
        data: params,
        dataType: "json",
        success: function (result) {
            console.log(result);
            select_datos_cuenta(params.CLIENTE_UNICO);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

// =============================================================================
function actualizar_informacion_cont_principal() {
    let params = {
        action: 'actualizar_informacion_cont_principal',
        
        CONTACTO_PRINCIAL: $('#CONTACTO_PRINCIAL').val(),
        TELEFONO_PRINCIPAL: $('#TELEFONO_PRINCIPAL').val(),
        TELEFONO_REFERENCIA2: $('#TELEFONO_PRINCIPAL_2').val(),
        
        CLIENTE_UNICO: $('#CUENTA').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAxtel",
        data: params,
        dataType: "json",
        success: function (result) {
            console.log(result);
            select_datos_cuenta(params.CLIENTE_UNICO);
        },
        error: function (error) {
            console.log(error);
        }
    });
}
// Secion de codigo de agenda
// =============================================================================

function select_agendas() {
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAxtel",
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
        url: "ControllerDataCuentaAxtel",
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

// tb_cont_agenda
function select_list_agendas_modal(_cuenta, _descripcion, _fecha, _hora, _id_reg_agenda) {
    $("#agenta_cliente_unico").val(_cuenta);
    $("#agenta_descripcion").val(_descripcion);
    $("#agenta_fecha").val(_fecha);
    $("#agenta_hora").val(_hora);
    $("#id_agenda_gestor").val(_id_reg_agenda);
}
