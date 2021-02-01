//==============================================================================
function select_convenio_tabla(_id_usuario, _id_cliente, _id_region, _desde, _hasta, _id_reporte, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_convenio_tabla",
        id_usuario: _id_usuario,
        id_cliente: _id_cliente,
        id_region: _id_region,
        desde: _desde,
        hasta: _hasta,
        id_reporte: _id_reporte
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            var _suma_pr1 = 0;
            var _suma_pagos1 = 0;

            $('#tabla_convenios tbody tr td.importe_convenio').each(function () {
                var _importe = $(this).text();
                _importe = _importe.replace('$', '');
                _importe = _importe.replace(',', '');
                _suma_pr1 = _suma_pr1 + parseFloat(_importe);
            });
            var _suma_pr2 = currency(_suma_pr1, 2, [',', "'", '.']); // con esto datos formato de numero

            $('#tabla_convenios tbody tr td.importe_aplica').each(function () {
                var _importe = $(this).text();
                _importe = _importe.replace('$', '');
                _importe = _importe.replace(',', '');
                _suma_pagos1 = _suma_pagos1 + parseFloat(_importe);
            });
            var _suma_pagos2 = currency(_suma_pagos1, 2, [',', "'", '.']); // con esto datos formato de numero

            $("#resumen_convenios").empty();

            if (_id_reporte == 1) {
                // PRODUCCION DE PROMESAS
                var _prom;
                if (_suma_pr1 == 0.00) {
                    _prom = 0.00;
                } else {
                    _prom = (_suma_pagos1 / _suma_pr1) * 100;
                }

                $("#resumen_convenios").append('<h4>LO PROMESADO TOTAL EN EL RANGO DE FECHAS SELECCIONADO ES DE $<b>' + _suma_pr2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LO PAGADO REAL EN EL RANGO DE FECHAS SELECCIONADO ES DE $<b>' + _suma_pagos2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LA EFECTIVIDAD DEL PERIODO ES DE <b>' + _prom.toFixed(2) + '%</b></h4>');
            } else {
                // POR COBRAR
                var _prom;
                if (_suma_pr1 == 0.00) {
                    _prom = 0.00;
                } else {
                    _prom = (_suma_pagos1 / _suma_pr1) * 100;
                }
                $("#resumen_convenios").append('<h4>LO MAXIMO QUE PUEDES COBRAR HOY CON BASE A TUS CONVENIOS  ES $<b>' + _suma_pr2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LO PAGADO REAL EN EL RANGO DE FECHAS SELECCIONADO ES DE $<b>' + _suma_pagos2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LA EFECTIVIDAD DEL PERIODO ES DE <b>' + _prom.toFixed(2) + '%</b></h4>');
            }

        }
    });
}
;
//==============================================================================
function select_convenio_agrupado_tabla(_id_usuario, _id_cliente, _id_region, _desde, _hasta, _id_reporte, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_convenio_agrupado_tabla",
        id_usuario: _id_usuario,
        id_cliente: _id_cliente,
        id_region: _id_region,
        desde: _desde,
        hasta: _hasta,
        id_reporte: _id_reporte
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            var _suma_pr1 = 0;
            var _suma_pagos1 = 0;

            $('#tabla_convenios tbody tr td.importe_convenio').each(function () {
                var _importe = $(this).text();
                _importe = _importe.replace('$', '');
                _importe = _importe.replace(',', '');
                _suma_pr1 = _suma_pr1 + parseFloat(_importe);
            });
            var _suma_pr2 = currency(_suma_pr1, 2, [',', "'", '.']); // con esto datos formato de numero

            $('#tabla_convenios tbody tr td.importe_aplica').each(function () {
                var _importe = $(this).text();
                _importe = _importe.replace('$', '');
                _importe = _importe.replace(',', '');
                _suma_pagos1 = _suma_pagos1 + parseFloat(_importe);
            });
            var _suma_pagos2 = currency(_suma_pagos1, 2, [',', "'", '.']); // con esto datos formato de numero

            $("#resumen_convenios").empty();

            if (_id_reporte == 1) {
                // PRODUCCION DE PROMESAS
                var _prom;
                if (_suma_pr1 == 0.00) {
                    _prom = 0.00;
                } else {
                    _prom = (_suma_pagos1 / _suma_pr1) * 100;
                }

                $("#resumen_convenios").append('<h4>LO PROMESADO TOTAL EN EL RANGO DE FECHAS SELECCIONADO ES DE $<b>' + _suma_pr2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LO PAGADO REAL EN EL RANGO DE FECHAS SELECCIONADO ES DE $<b>' + _suma_pagos2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LA EFECTIVIDAD DEL PERIODO ES DE <b>' + _prom.toFixed(2) + '%</b></h4>');
            } else {
                // POR COBRAR
                var _prom;
                if (_suma_pr1 == 0.00) {
                    _prom = 0.00;
                } else {
                    _prom = (_suma_pagos1 / _suma_pr1) * 100;
                }
                $("#resumen_convenios").append('<h4>LO MAXIMO QUE PUEDES COBRAR HOY CON BASE A TUS CONVENIOS  ES $<b>' + _suma_pr2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LO PAGADO REAL EN EL RANGO DE FECHAS SELECCIONADO ES DE $<b>' + _suma_pagos2 + '</b></h4>');
                $("#resumen_convenios").append('<h4>LA EFECTIVIDAD DEL PERIODO ES DE <b>' + _prom.toFixed(2) + '%</b></h4>');
            }

        }
    });
}
;
//==============================================================================
function select_convenio_combo(_id_caja) {
    var params = {
        accion: "select_convenio_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
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
function insert_convenio(_importe, _fecha, _id_usuario, _cuenta) {
    var params = {
        accion: "insert_convenio",
        importe: _importe,
        fecha: _fecha,
        id_usuario: _id_usuario,
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            $("#consola").empty();
//            $("#consola").append(dataRes);
            alert(dataRes);

            if(dataRes == "VERIFIQUE IMPORTE Y LA FECHA DEL CONVENIO"){
                alert("Selecciona la fecha con un rango no mayor a 4 días");
            }else{
            
            fecha_hoy("fecha_promesa_pago");
            $("#importe_convenio").val('0.00');

            select_convenio_cuenta_tabla(
                    _cuenta,
                    "listado_convenios"
                    );
            
            $("#div_registrar_convenio").hide();
            $("#div_registrar_gestion").show();
           
            }
        }
    });
}
//==============================================================================
function update_convenio(_id_convenio, _convenio, _id_gestor, _fecha ) {
    var params = {
        accion: "update_convenio",
        id_convenio: _id_convenio,
        convenio: _convenio,
        gestor: _id_gestor,
        fecha: _fecha
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_convenio(_id_convenio, _id_usuario) {
    var params = {
        accion: "delete_convenio",
        id_convenio: _id_convenio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#consola").empty();
            $("#consola").append(dataRes);

            select_convenio_gestor_tabla(_id_usuario, "listado_convenios");
        }
    });
}
//==============================================================================
function select_convenio_gestor_tabla(_id_usuario, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_convenio_gestor_tabla",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_convenio_cuenta_tabla(_cuenta, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_convenio_cuenta_tabla",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
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
function select_reporte_gral(_id_usuario, _desde, _hasta, _id_reporte, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_reporte_gral",
        id_usuario: _id_usuario,
        desde: _desde,
        hasta: _hasta,
        id_reporte: _id_reporte
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConvenio",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $(".barra").show("slow");

        }
    });
}
;
//==============================================================================