/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * todas estas funciones se ejecutan despues de haber cargado todo el documento html
 */
window.onload = function () {
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
    $("#tiempo_actual").val("00:00:00");
    $("#retraso_actual").val("00:00:00");
    select_id_puesto(id_usuario);
    select_cuenta_siguiente(id_usuario);
    
//    select_llamadas_gestor(id_usuario);
};
/* 
 * Metodos de JQuery para Eventos o para llamar funciones
 */
// Selecionar tabla de Convenio
$("#tab_convenios").click(function () {
    if ($("#cuenta_deudor").val() !== "") {
        select_convenios_cuenta($("#cuenta_deudor").val(), "tbody_tabla_convenios");
    } else {
        $("#tbody_tabla_convenios").empty();
        $("#tbody_tabla_convenios").append("No hay una Cuenta Selecionada");
    }
});

// Guardar Gestion
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
            id_puesto: id_puesto,
            gestion: $("#gestion").val().replace(/"|,|'|-/gi, ""),
            duracion: $("#tiempo_actual").val(),
            retraso_llamada: $("#retraso_actual").val(),
            expediente: $("#expediente_deudor").val(),
            f_predictivo: 0
        };
        console.log(myObjGestion);
        insertar_gestion(myObjGestion);
    } else {
        $("#modal_alerta").modal("open");
        $("#mensaje_alerta").empty();
        $("#mensaje_alerta").append('Favor de rellenar los sigientes campos<br><br>' +
                '- Disposicion <br>- Codigo de llamada <br>- Numero marcado');
    }
});

// Insert Convenio
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
            id_puesto: id_puesto,
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
        id_puesto: id_puesto,
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



/* 
 * Funciones de javascript
 */
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
            var f_inicio = datos_cuenta["inicio_deudor"].split(" ");
            select_gestiones_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_gestiones");
            select_pagos_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_pagos");
            $("#gestion").val(nuemero_marcado + " ");
            $("#numero_marcado_deudor").val(nuemero_marcado);
            
        }
    });
}

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

// Obtener el id_puesto del gestor
function select_id_puesto(_id_usuario) {
    $.ajax({
        type: 'POST',
        url: "/sistema/ControllerUsuario",
        data: {action: "select_id_puesto", id_usuario: _id_usuario},
        dataType: 'html',
        success: function (respuesta) {
            console.log(respuesta);
            id_puesto = parseInt(respuesta);
        }
    });
}


function conteo_llamadas_guardar_gestion(_id_status_llamada) {
    console.log(_id_status_llamada);
    var llamadas = parseInt( $("#llamadas_realizadas").val() );
    llamadas ++;
    $("#llamadas_realizadas").val(llamadas);
    if(_id_status_llamada === "1") {
        var convenios = parseInt( $("#convenios").val() );
        convenios ++;
        $("#convenios").val(convenios);
    }
}
function conteo_llamadas_cuenta_siguiente(){
    var cuentas_tocadas = parseInt( $("#cuentas_tocadas").val() );
    cuentas_tocadas++;
    $("#cuentas_tocadas").val(cuentas_tocadas);
}

// Traer gestiones cuenta 
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

// traer pagos de la cuenta
function select_pagos_cuenta(_cuenta, _fecha_inico, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_pagos_cuenta",
        cuenta: _cuenta,
        fecha_inico: _fecha_inico
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (pagos) {
            $("#" + _div).empty();
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


function insertar_gestion(myObj) {
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
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
            conteo_llamadas_guardar_gestion(myObj.id_estatus_llamada);
            select_gestiones_cuenta(myObj["cuenta"], f_inicio[0], "tbody_tabla_gestiones");
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
//    console.log(params);
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

$(".limpiar_texto").keyup(function () {
    var cadena = $(this).val().replace(/[&\/\#,+()$~%'":*?<>{}|]/g, '');
    cadena = cadena.toUpperCase();
    $(this).val(cadena);
});

// Insert Convenio 
function insertar_convenio(_myObjConvenio, _myObjGestion) {
//    console.log(_myObjConvenio);
    var params = {
        action: "insertar_convenio",
        datos: JSON.stringify(_myObjConvenio)
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerGestor",
        data: params,
        dataType: "json",
        success: function (respuesta) {
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