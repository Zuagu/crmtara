//==============================================================================
function select_estatus_cuenta_cliente_tabla(_id_cliente, _id_caja) {
    var params = {
        accion: "select_estatus_cuenta_cliente_tabla",
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_cuenta_cliente_tabla2(_id_cliente, _id_caja) {
    var params = {
        accion: "select_estatus_cuenta_cliente_tabla2",
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_cuenta_cliente_tabla3(_id_cliente, _id_caja) {
    var params = {
        accion: "select_estatus_cuenta_cliente_tabla3",
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_cuenta_tabla(_id_cliente, _id_caja) {
    $("#" + _id_caja).css("cursor", "progress");
    var params = {
        accion: "select_estatus_cuenta_tabla",
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).css("cursor", "default");
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_cuenta_combo(_id_usuario, _id_caja) {
    var params = {
        accion: "select_estatus_cuenta_combo",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_cuenta_cuenta_combo(_id_usuario, _id_caja) {
    var params = {
        accion: "select_estatus_cuenta_cuenta_combo",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_puesto_combo(_id_usuario, _id_caja) {
    var params = {
        accion: "select_estatus_puesto_combo",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function insert_estatus_cuenta(_estatus_cuenta, _descripcion, _id_cliente, _id_caja) {
    var params = {
        accion: "insert_estatus_cuenta",
        estatus_cuenta: _estatus_cuenta,
        descripcion: _descripcion,
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_estatus_cuenta_cliente_tabla3($("#id_cliente").val(), _id_caja);
        }
    });
}
;
//==============================================================================
function update_estatus_cuenta(_id_estatus_cuenta, _estatus_cuenta) {
    var params = {
        accion: "update_estatus_cuenta",
        id_estatus_cuenta: _id_estatus_cuenta,
        estatus_cuenta: _estatus_cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_estatus_cuenta(_id_estatus_cuenta, _id_caja) {
    var params = {
        accion: "delete_estatus_cuenta",
        id_estatus_cuenta: _id_estatus_cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estatus_cuenta_cliente_tabla3($("#id_cliente").val(), _id_caja);
        }
    });
}
;
//==============================================================================
function insert_estatus_puesto(_id_puesto, _estatus, _id_caja) {
    var params = {
        accion: "insert_estatus_puesto",
        id_puesto: _id_puesto,
        estatus: _estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estatus_puesto_tabla(_id_puesto, "listado_estatus_puesto");
        }
    });
}
;
//==============================================================================
function select_estatus_puesto_tabla(_id_puesto, _id_caja) {
    var params = {
        accion: "select_estatus_puesto_tabla",
        id_puesto: _id_puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_cuenta_check(_id_region, _cadena_asignaciones, _tiene_cr, _cadena_ladas, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_estatus_cuenta_check",
        id_region: _id_region,
        cadena_asignaciones: _cadena_asignaciones,
        tiene_cr: _tiene_cr,
        cadena_ladas: _cadena_ladas
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

        }
    });
}
;
//==============================================================================
function select_saldos_estatus(_cadena_clientes, _cadena_regiones, _cadena_asignaciones, _cadena_equipos, _resto, _tiene_cr, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_saldos_estatus",
        cadena_clientes: _cadena_clientes,
        cadena_regiones: _cadena_regiones,
        cadena_asignaciones: _cadena_asignaciones,
        cadena_equipos: _cadena_equipos,
        resto: _resto,
        tiene_cr: _tiene_cr
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            genera_resumen();

        }
    });
}
;
//==============================================================================
function genera_resumen() {

    var _cuentas = 0;
    var _importe = 0.00;
    var _importe_tr;

    $('#resultado_saldos_estatus tbody tr').each(function () {
        if ($(this).closest('tr').find('.check_id_estatus').is(':checked')) {
            _cuentas = _cuentas + parseInt($(this).closest('tr').find('.td_num_cuentas').text());
            _importe_tr = $(this).closest('tr').find('.td_valor_estatus').text();
            _importe_tr = _importe_tr.replace("$", "");
            _importe_tr = _importe_tr.replace(/,/g, "");
            _importe = _importe + parseFloat(_importe_tr);
            ;
        }
    });

    var _importe2 = currency(_importe, 2, [',', "'", '.']); // con esto datos formato de numero
    $("#resumen_total_cuentas").text(_cuentas);
    $("#resumen_importe_cuentas").text(_importe2);

}
;
//==============================================================================
function select_saldos_estatus(_cadena_clientes, _cadena_regiones, _cadena_asignaciones, _cadena_equipos, _resto, _tiene_cr, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_saldos_estatus",
        cadena_clientes: _cadena_clientes,
        cadena_regiones: _cadena_regiones,
        cadena_asignaciones: _cadena_asignaciones,
        cadena_equipos: _cadena_equipos,
        resto: _resto,
        tiene_cr: _tiene_cr
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            genera_resumen();

        }
    });
}
;
//==============================================================================
function select_cuentas_estatus(_clientes, _regiones, _asignaciones, _equipos, _resto, _tiene_cr, _id_estatus, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_cuentas_estatus",
        clientes: _clientes,
        regiones: _regiones,
        asignaciones: _asignaciones,
        equipos: _equipos,
        resto: _resto,
        tiene_cr: _tiene_cr,
        id_estatus: _id_estatus,
        id_caja: _id_caja
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function editar_puede_cambiar(_id_estatus, _puede_cambiar, _puede_cambiar_txt, _id_caja) {
    var params = {
        accion: "editar_puede_cambiar",
        id_estatus: _id_estatus,
        puede_cambiar: _puede_cambiar,
        puede_cambiar_txt: _puede_cambiar_txt
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusCuenta",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_estatus_cuenta_cliente_tabla3($("#id_cliente").val(), _id_caja);
        }
    });
}
;
//==============================================================================
function genera_datos_eec() {
    // FUNCION QUE GENERA LOS ESTATUS POSIBLES A LOS
    // QUE PUEDE CAMBIAR UN ESTATUS EN EL MANUAL
    var _texto1 = "";
    var _texto2 = "";
    $("#estatus_posibles").val('');
    $("#estatus_posibles_txt").val('');

    $('#estatus_disponibles tr').each(function () {
        if ($(this).closest('tr').find('.agregado').is(':checked')) {
            _texto1 = _texto1 + $(this).closest('tr').find('.abreviado').text() + ", ";
            _texto2 = _texto2 + $(this).closest('tr').find('.estatus_detallado').val();
        }
    });

    _texto1 = _texto1.substring(0, _texto1.length - 2);

    $("#estatus_posibles").val(_texto1);
    $("#estatus_posibles_txt").val(_texto2);
}