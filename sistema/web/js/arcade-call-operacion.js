// ARCADE Software
// arcade-call-operacion.js
// Luis Cortez
//==============================================================================
function select_cuenta_siguiente(_id_usuario) {
    limpiar_datos_cuenta();
    var params = {
        accion: "select_cuenta_siguiente",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            pasar_datos_a_pantalla(dataRes);

            if ($("#dato_general1").val() != "" && $("#dato_general1").val() != "SIN CUENTAS") {
                f_seguimiento($("#dato_general1").val());
                telefonos_cuenta($("#dato_general1").val(), "numeros_contacto");
            }

            $("#consola").empty();
            $("#consola").append('LISTO');
        }
    });
}
//==============================================================================
function telefonos_cuenta(_cuenta, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "telefonos_cuenta",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTelefono",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_cuenta_siguiente_chbk(_id_usuario, _ciclo, _estatus_original, _estatus) {
    limpiar_datos_cuenta();
    var params = {
        accion: "select_cuenta_siguiente_chbk",
        id_usuario: _id_usuario,
        ciclo: _ciclo,
        estatus_original: _estatus_original,
        estatus: _estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            pasar_datos_a_pantalla_chbk(dataRes);
        }
    });
}
//==============================================================================
function select_pagos_anticipados_gestor() {
    $("#mis_pagos").empty();
    $("#mis_pagos").append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_pagos_anticipados_gestor",
        id_usuario: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePagos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#mis_pagos").empty();
            $("#mis_pagos").append(dataRes);
        }
    });
}
//==============================================================================
function select_pagos_de_hoy_gestor() {
    $("#mis_pagos").empty();
    $("#mis_pagos").append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_pagos_de_hoy_gestor",
        id_usuario: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePagos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#mis_pagos").empty();
            $("#mis_pagos").append(dataRes);
        }
    });
}
//==============================================================================
function select_pagos_asignacion_gestor() {
    $("#mis_pagos").empty();
    $("#mis_pagos").append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_pagos_asignacion_gestor",
        id_usuario: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePagos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#mis_pagos").empty();
            $("#mis_pagos").append(dataRes);
        }
    });
}
//==============================================================================
function select_nombre_estatus() {
    var params = {
        accion: "select_nombre_estatus",
        id_gestor: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatus",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var datos = dataRes.split("+");
            $("#nombre_estatus").val(datos[0]);
            $("#cuentas_estatus").val(datos[1]);
        }
    });
}
//==============================================================================
function select_nombre_estrategia() {
    var params = {
        accion: "select_nombre_estrategia",
        id_gestor: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var datos = dataRes.split("+");
            $("#nombre_estrategia").val(datos[0]);
            $("#cuentas_estrategia").val(datos[1]);
        }
    });
}
//==============================================================================
function select_datos_cuenta(_cuenta) {
    limpiar_datos_cuenta();
    var params = {
        accion: "select_datos_cuenta",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            pasar_datos_a_pantalla(dataRes);
        }
    });
}
//==============================================================================
function select_datos_cuenta_chbk(_cuenta) {
    limpiar_datos_cuenta();
    var params = {
        accion: "select_datos_cuenta_chbk",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            pasar_datos_a_pantalla_chbk(dataRes);
        }
    });
}
//==============================================================================
function select_datos_cuenta_captura(_cuenta) {
    limpiar_datos_cuenta();
    var params = {
        accion: "select_datos_cuenta",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            pasar_datos_a_pantalla_captura(dataRes);
        }
    });
}
//==============================================================================
function pasar_datos_a_pantalla(dataRes) {
    var campos = dataRes.split("#AND#");
    for (i = 1; i <= 26; i++) {
        $("#dato_general" + i).val(campos[i]);
    }

    // columna 23
    $("#consola").empty();
    $("#consola").append(campos[23]); // fn tiene_cr(); -- NUEVA VERSION

    // columna 24
    $("#consola2").empty();
    $("#consola2").append(campos[24]); // fn tiene_cr();

    // columna 25
    $("#id_estatus_cuenta").empty(); // ID ESTATUS CUENTA
    $("#id_estatus_cuenta").append(campos[25]);

    if ($("#dato_general1").val() != "") {
        select_gestiones_cuenta($("#dato_general1").val(), "divapp1");
        telefonos_cuenta($("#dato_general1").val(), "numeros_contacto");
    }
}
;
//==============================================================================
function pasar_datos_a_pantalla_captura(dataRes) {
    var campos = dataRes.split("#AND#");
    for (i = 1; i <= 26; i++) {
        $("#dato_general" + i).val(campos[i]);
    }

    // columna 23
    $("#consola").empty();
    $("#consola").append(campos[32]); // fn tiene_cr();

    // columna 24
    $("#consola2").empty();
    $("#consola2").append(campos[33]); // fn tiene_cr();

//    // columna 25
//    $("#id_estatus_cuenta").empty();
//    $("#id_estatus_cuenta").append(campos[34]);

    if ($("#dato_general1").val() != "") {
        select_gestiones_cuenta($("#dato_general1").val(), "divapp1");
        telefonos_cuenta($("#dato_general1").val(), "numeros_contacto");
    }
}
;
//==============================================================================
function pasar_datos_a_pantalla_chbk(dataRes) {
    var campos = dataRes.split("#AND#");
    for (i = 1; i <= 35; i++) {
        $("#dato_general" + i).val(campos[i]);
    }

    $("#consola2").empty();
    $("#consola2").append(campos[32]); // fn tiene_cr();

    // Probablemente este campo fijo ya NO exista...
    $("#campo_fijo").val(campos[33]);

    if ($("#dato_general1").val() != "") {
        select_gestiones_cuenta_todas($("#dato_general1").val(), "divapp1");
    }
}
;
//==============================================================================
function select_estatus_llamada_puesto() {
    var params = {
        accion: "select_estatus_llamada_puesto",
        id_usuario: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatus",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#id_estatus").append(dataRes);
        }
    });
}
//==============================================================================
function select_codigo_resultado() {
    var params = {
        accion: "select_codigo_resultado"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCodigos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#id_codigo").append(dataRes);
        }
    });
}
//==============================================================================
function select_estrategias(_id_usuario, _id_caja) {
    var params = {
        accion: "select_estrategias",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_estatus() {
    var params = {
        accion: "select_estatus",
        id_usuario: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatus",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#id_estatus").empty();
            $("#id_estatus").append(dataRes);
            //   $("id_estatus_gestor").append(dataRes); para mostrar la imagen
        }
    });
}
//==============================================================================
function reset_relojes(x) {
    $("#mensaje_consola").val('');
    $("#mensaje_consola").val(x);
    $("#id_estatus").val('0');
    $("#id_codigo").val('0');
    $("#comentario").val('');
    $("#gestiones").empty();
    $("#minutos_lla").val('0');
    $("#segundos_lla").val('0');
    $("#minutos_r").val('0');
    $("#segundos_r").val('0');
    cargar_gestiones();
    $("#relojes").css("background-color", "#1CB12A");
}
//==============================================================================
function contar_agendas() {
    var params = {
        accion: "contar_agendas",
        id_usuario: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAgenda", //
        data: params,
        dataType: "html",
        success: function (dataRes) {
            if (dataRes > 0) {
                $("#mensaje_consola2").val('AGENDA');
            } else {
                $("#mensaje_consola2").val('');
            }

        }
    });
}
;
//==============================================================================
function cronometro_llamada_actual(_id_usuario) {
    var datos = $("#reloj_llamada_actual").val().split(":");
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
        select_llamadas_gestor(_id_usuario);
        minutos = 0;
        horas++;
    }
    if (minutos <= 9)
        minutos = "0" + minutos;
    if (minutos >= 5 || horas > 0) {
        $("#relojes").css("background-color", "#FFD550");
        cronometro_retraso_actual();
    }
    if (minutos == 10)
        $("#relojes").css("background-color", "#D0130C");
    if (segundos <= 9)
        segundos = "0" + segundos;
    if (horas <= 9)
        horas = "0" + horas;

    $("#reloj_llamada_actual").val('');
    $("#reloj_llamada_actual").val(horas + ":" + minutos + ":" + segundos);
}
//==============================================================================
function insert_no_gestion(_cuenta, _numero_marcado, _id_estatus_cuenta, _id_estatus_llamada, _id_usuario, _gestion, _duracion, _retraso) {
    var params = {
        accion: "insert_gestion",
        cuenta: _cuenta,
        numero_marcado: _numero_marcado,
        id_estatus_cuenta: _id_estatus_cuenta,
        id_estatus_llamada: _id_estatus_llamada,
        id_usuario: _id_usuario,
        gestion: _gestion,
        duracion: _duracion,
        retraso_llamada: _retraso
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            window.open('', '_self').close();
        }
    });
}
//==============================================================================
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
//==============================================================================
function cronometror() {
    var minutosr = $("#minutos_r").val();
    var segundosr = $("#segundos_r").val();
    if ($("#minutos_lla").val() >= 5) {
        segundosr++;
        if (segundosr >= 60)
        {
            segundosr = 0;
            minutosr++;
        }
        if (minutosr <= 9)
            minutosr = "0" + minutosr;
        if (segundosr <= 9)
            segundosr = "0" + segundosr;
        $("#minutos_r").val(parseInt(minutosr));
        $("#segundos_r").val(segundosr);
    }
}
//BOTONES
//==============================================================================
function select_gestiones_cuenta(_cuenta, _id_caja) {
    if (es_entero(_cuenta) == 1) {
        $("#" + _id_caja).empty();
        $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
        var params = {
            accion: "select_gestiones_cuenta",
            cuenta: _cuenta
        };
        $.ajax({
            type: "POST",
            url: "/sistema/ManageGestion",
            data: params,
            dataType: "html",
            success: function (dataRes) {
                $("#" + _id_caja).empty();
                $("#" + _id_caja).append(dataRes);
            }
        });
    }
}
//==============================================================================
function select_gestiones_cuenta_todas(_cuenta, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_gestiones_cuenta_todas",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function limpiar_datos_cuenta() {
    for (i = 1; i <= 31; i++) {
        $("#dato_general" + i).val('');
    }
}
//==============================================================================
function select_referencias_bancarias(_cuenta, _id_caja) {
    var params = {
        accion: "select_referencias_bancarias",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).val(dataRes);

        }
    });
}
//==============================================================================
function delete_nota(id_nota) {
    var params = {
        accion: "delete_nota",
        id_nota: id_nota
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNotas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#consola").val(dataRes);
            select_notas_equipo(
                    $('#usuario_sistema', parent.document).val(),
                    "listado_notas"
                    );
        }
    });
}
//==============================================================================
function select_buscar_cuentas(_cadena, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_buscar_cuentas",
        cadena: _cadena
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_buscar_cuentas_chbk(_cadena, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_buscar_cuentas_chbk",
        cadena: _cadena
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_pagos_cuenta_tabla(_cuenta, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_pagos_cuenta_tabla",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePagocuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_cuentas_relacionadas(_cuenta, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_cr_cuenta_tabla",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCr",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}

//==============================================================================
function listado_por_estatus_gestor(_id_gestor, _id_estatus, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "listado_por_estatus_gestor",
        id_gestor: _id_gestor,
        id_estatus: _id_estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function insert_agenda(_id_usuario, _cuenta, _fecha, _hora, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "insert_agenda",
        id_usuario: _id_usuario,
        cuenta: _cuenta,
        fecha: _fecha,
        hora: _hora
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAgenda",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#consola").empty();
            $("#consola").append(dataRes);
            select_agendas_pareja(
                    _id_usuario,
                    _id_caja
                    );
        }
    });
}
//==============================================================================
function insert_nota(_id_usuario, _nota, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "insert_nota",
        id_usuario: _id_usuario,
        nota: _nota
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNotas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#consola").empty();
            $("#consola").append(dataRes);
            select_notas_equipo(_id_usuario, _id_caja);
        }
    });
}
//==============================================================================
function select_pastel_gestor() {
    $("#mi_pastel").empty();
    $("#mi_pastel").append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_pastel_gestor",
        id_usuario: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#mi_pastel").empty();
            $("#mi_pastel").append(dataRes);
        }
    });
}
//==============================================================================
function select_gestiones_visita() {
    if ($("#cuenta").val() != "SIN CUENTAS ASIGNADAS") {
        $("#divapp10").empty();
        $("#divapp10").append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
        var params = {
            accion: "select_gestiones_visita",
            cuenta: $("#cuenta").val()
        };
        $.ajax({
            type: "POST",
            url: "/sistema/ManageGestion",
            data: params,
            dataType: "html",
            success: function (dataRes) {
                $("#divapp10").empty();
                $("#divapp10").append(dataRes);
            }
        });
    }
}
//==============================================================================
function marcar_agenda_vista(id_agenda, cuenta) {
    $("#listado_visitas").empty();
    $("#listado_visitas").append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "marcar_agenda_vista",
        id_agenda: id_agenda
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAgenda",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var x = dataRes;
            buscar_cuenta(cuenta);
            $("#div_agenda").hide();
            $("#tabla_gestiones").show();
            $("#mensaje_consola").val(x);
            contar_agendas();
        }
    });
}
//==============================================================================
function select_agendas_pareja(_id_usuario, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_agendas_pareja",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAgenda",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_notas_equipo(_id_usuario, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_notas_equipo",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNotas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_speech_cuenta() {
}
//==============================================================================
function es_entero(numero) {
    if (isNaN(numero)) {
        return 0;
    } else {
        return 1;
    }
}
//==============================================================================
function aumentar_llamada() {
    var params = {
        accion: "aumentar_llamada",
        id_gestor: $('#usuario_sistema', parent.document).val(),
        id_estatus: $("#id_estatus").val(),
        id_codigo: $("#id_codigo").val(),
        minutos_retraso: $("#minutos_r").val(),
        segundos_retraso: $("#segundos_r").val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAgenda", //
        data: params,
        dataType: "html",
        success: function () {
            hora_entrada();
        }
    });
}
//==============================================================================
function select_control_tiempos() {
    var params = {
        accion: "select_control_tiempos",
        id_gestor: $('#usuario_sistema', parent.document).val()
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var datos = dataRes.split("+");
            $("#hora_entrada").val(datos[0]);
            $("#contador_cuentas").val(datos[1]);
            $("#contador_llamadas").val(datos[2]);
            $("#retraso_acumulado").val(datos[3]);
        }
    });
}
//==============================================================================
function insert_gestion(_cuenta, _numero_marcado, _id_estatus_cuenta, _id_estatus_llamada, _id_usuario, _gestion, _duracion, _retraso, _expediente, _predictivo, _f_predictivo) {

    if (_predictivo) {
        $("#insert_gestion").hide();
    }

    var params = {
        accion: "insert_gestion",
        cuenta: _cuenta,
        numero_marcado: _numero_marcado,
        id_estatus_cuenta: _id_estatus_cuenta,
        id_estatus_llamada: _id_estatus_llamada,
        id_usuario: _id_usuario,
        gestion: _gestion,
        duracion: _duracion,
        retraso_llamada: _retraso,
        expediente: _expediente,
        f_predictivo: _f_predictivo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            if (_predictivo) {
                alert(dataRes);
                window.open('', '_self').close();
            } else {
                $("#insert_gestion").show();
                $("#consola").empty();
                $("#consola").append(dataRes);
                $("#gestion").val('');
                select_gestiones_cuenta($("#dato_general1").val(), "divapp1");
                select_llamadas_gestor($('#usuario_sistema', parent.document).val());
            }
			$("#div_registrar_gestion").hide();
			
        }
    });
}
//==============================================================================
function insert_gestion1a(_cuenta, _numero_marcado, _id_estatus_cuenta, _id_estatus_llamada, _id_usuario, _gestion, _duracion, _retraso, _expediente, _predictivo, _f_predictivo) {

    if (_predictivo) {
        $("#insert_gestion").hide();
    }

    var params = {
        accion: "insert_gestion",
        cuenta: _cuenta,
        numero_marcado: _numero_marcado,
        id_estatus_cuenta: _id_estatus_cuenta,
        id_estatus_llamada: _id_estatus_llamada,
        id_usuario: _id_usuario,
        gestion: _gestion,
        duracion: _duracion,
        retraso_llamada: _retraso,
        expediente: _expediente,
        f_predictivo: _f_predictivo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            if (_predictivo) {
                alert(dataRes);
                window.open('', '_self').close();
            } else {
                $("#insert_gestion").show();
                $("#consola").empty();
                $("#consola").append(dataRes);
                $("#gestion").val('');
                select_gestiones_cuenta($("#dato_general1").val(), "divapp1");
                select_llamadas_gestor($('#usuario_sistema', parent.document).val());
            }
            $("#div_registrar_gestion").hide();
            select_cuenta_siguiente($('#usuario_sistema', parent.document).val() );
        }
    });
}
//==============================================================================
function insert_gestion_chbk(_cuenta, _numero_marcado, _id_estatus_cuenta, _id_estatus_llamada, _id_usuario, _gestion, _duracion, _retraso, _expediente, _predictivo, _f_predictivo) {

    if (_predictivo) {
        $("#insert_gestion").hide();
    }

    var params = {
        accion: "insert_gestion",
        cuenta: _cuenta,
        numero_marcado: _numero_marcado,
        id_estatus_cuenta: _id_estatus_cuenta,
        id_estatus_llamada: _id_estatus_llamada,
        id_usuario: _id_usuario,
        gestion: _gestion,
        duracion: _duracion,
        retraso_llamada: _retraso,
        expediente: _expediente,
        f_predictivo: _f_predictivo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            if (_predictivo) {
                alert(dataRes);
                window.open('', '_self').close();
            } else {
                $("#insert_gestion").show();
                $("#consola").empty();
                $("#consola").append(dataRes);
                $("#gestion").val('');
                select_gestiones_cuenta_todas($("#dato_general1").val(), "divapp1");
            }
        }
    });
}
//==============================================================================
function select_llamadas_gestor(_id_usuario) {
    var params = {
        accion: "select_llamadas_gestor",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var dato = dataRes.split("#AND#");

            $("#reloj_llamada_actual").val("00:00:00");
            $("#contador_cuentas").val(dato[0]);
            $("#contador_llamadas").val(dato[1]);
            $("#hora_entrada").val(dato[2]);
            $("#estrategia").val(dato[3]);
            $("#cuentas").val(dato[4]);
        }
    });
}
//==============================================================================
function select_llamadas_gestor2(_id_usuario) {
    var params = {
        accion: "select_llamadas_gestor2",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var dato = dataRes.split("#AND#");

            $("#reloj_llamada_actual").val("00:00:00");
            $("#contador_cuentas").val(dato[0]);
            $("#contador_llamadas").val(dato[1]);
            $("#hora_entrada").val(dato[2]);
            $("#estrategia").val(dato[3]);
            $("#cuentas").val(dato[4]);
        }
    });
}
//==============================================================================
function select_llamadas_gestor_chbk(_id_usuario) {
    var params = {
        accion: "select_llamadas_gestor",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var dato = dataRes.split("#AND#");

            $("#reloj_llamada_actual").val("00:00:00");
            $("#contador_cuentas").val(dato[0]);
            $("#contador_llamadas").val(dato[1]);
            $("#hora_entrada").val(dato[2]);
            $("#estrategia").val('NO APLICA');
        }
    });
}
//==============================================================================
function update_f_seguimiento_cuenta(_cuenta, _f_seguimiento) {
    var params = {
        accion: "update_f_seguimiento_cuenta",
        cuenta: _cuenta,
        f_seguimiento: _f_seguimiento

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
//==============================================================================
function f_seguimiento(_cuenta) {
    var params = {
        accion: "f_seguimiento",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#valor_f_seguimiento").val(dataRes);
            $("#f_seguimiento").empty();
            $("#f_seguimiento").append("<img src='images/i_star" + $("#valor_f_seguimiento").val() + ".png' alt='' title='DARLE SEGUIMIENTO ESPECIAL A ESTA CUENTA' style='margin: 5px 0px 0px 7px; float: right; cursor: pointer;'>");
        }
    });
}
//==============================================================================
function select_etiquetas_cliente(_id_puesto, _etiquetas) {
    var params = {
        accion: "select_etiquetas_cliente",
        id_puesto: _id_puesto,
        etiquetas: _etiquetas
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {

            var campos = dataRes.split("#AND#");

            for (i = 1; i <= 31; i++) {
                //SE AJUSTA CON +1 PORQUE EL ARRAY NO CONTIENE INICIO COMO EN DATOS CUENTA
                $("#etiqueta" + i).text(campos[i]);
            }

        }
    });
}
//==============================================================================
function select_etiquetas_puesto_usuario(_id_usuario) {
    var params = {
        accion: "select_etiquetas_puesto_usuario",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {

            var campos = dataRes.split("#AND#");

            for (i = 1; i <= 31; i++) {
                //SE AJUSTA CON +1 PORQUE EL ARRAY NO CONTIENE INICIO COMO EN DATOS CUENTA
                $("#etiqueta" + i).text(campos[i]);
            }

        }
    });
}
//==============================================================================
function insert_etiquetas_cliente(_id_puesto, _etiquetas) {
    var params = {
        accion: "insert_etiquetas_cliente",
        id_puesto: _id_puesto,
        etiquetas: _etiquetas
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {

            $("#consola").empty();
            $("#consola").append(dataRes);

        }
    });
}
//==============================================================================
function clonar_etiquetas(_id_puesto, _id_puesto2) {
    var params = {
        accion: "clonar_etiquetas",
        id_puesto: _id_puesto,
        id_puesto2: _id_puesto2
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);

            $("#consola").empty();
            $("#consola").append(dataRes);

        }
    });
}
//==============================================================================
function insert_nuevo_numero_contacto(_id_usuario, _cuenta, _numero) {
    var params = {
        accion: "insert_nuevo_numero_contacto",
        id_usuario: _id_usuario,
        cuenta: _cuenta,
        numero: _numero
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#consola").empty();
            $("#consola").append(dataRes);

        }
    });
}
//==============================================================================
function ajustes_estrategia_gestor(_id_usuario, _id_caja) {
    var params = {
        accion: "ajustes_estrategia_gestor",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

        }
    });
}
//==============================================================================
function select_gestiones_cuenta_fit(_cuenta, _id_caja) {
    if (es_entero(_cuenta) == 1) {
        $("#" + _id_caja).empty();
        $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
        var params = {
            accion: "select_gestiones_cuenta_fit",
            cuenta: _cuenta
        };
        $.ajax({
            type: "POST",
            url: "/sistema/ManageGestion",
            data: params,
            dataType: "html",
            success: function (dataRes) {
                $("#" + _id_caja).empty();
                $("#" + _id_caja).append(dataRes);
            }
        });
    }
}
//==============================================================================
function select_numero_visitas( _cuenta, _id_caja) {
    var params = {
        accion: "select_numero_visitas",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).val(dataRes);
            select_estatus_llamada_combo("id_estatus_llamada", true);
            if(dataRes == "1" ){
                alert("ESTA CUENTA " + dataRes + " VISITA");
                removeOption(1);
            }else if(dataRes == "2"){
                alert("ESTA CUENTA " + dataRes + " VISITAS");
                removeOption(2);
            }else{
                
            }
        }
    });
}
function removeOption(dato) {
    if(dato == 1){
        var x= $("#id_estatus_llamada option[value="+6+"]");
		x.remove(x.selectedIndex);
    }else{
		var x= $("#id_estatus_llamada option[value="+6+"]");
		var y= $("#id_estatus_llamada option[value="+20+"]");
		x.remove(x.selectedIndex);
		y.remove(y.selectedIndex);
    }
}
//==============================================================================
function update_numero_visitas(_cuenta, _codigo ) {
    //alert("la cuentases: "+_cuenta+" El codigo de llamada: "+_codigo);
    var params = {
        accion: "update_numero_visitas",
        cuenta: _cuenta,
        codigo: _codigo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
//==============================================================================
function evaluar_estatus_f_bloqueado( _id_gestor ) {
    var params = {
        accion: "evaluar_estatus_f_bloqueado",
        id_gestor: _id_gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            if (dataRes = 1) {
                alert("NO TIENES PERMISO DE CAMBIAR TI DISPOSICION");
            } else {
                $("#caja_estatus").show();
                select_estatus_cuenta_cliente_tabla2( 1, "listado_estatus_cuenta");
            }
        }
    });
};
//==============================================================================
function select_saldos_gestores(id_usuario,_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_saldos_gestores",
        usuario: id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_cuentas_de_estaus(_id_usuario, _id_estatus,_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_cuentas_de_estaus",
        id_usuario: _id_usuario,
        id_estatus: _id_estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCuentas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================