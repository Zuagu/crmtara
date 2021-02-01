//==============================================================================
function select_reporte_gestiones(_id_sucursal, _fecha_inicio, _fecha_fin, _columna, _orden, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_reporte_gestiones",
        id_sucursal: _id_sucursal,
        fecha_inicio: _fecha_inicio,
        fecha_fin: _fecha_fin,
        columna: _columna,
        orden: _orden
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            var _suma_promesado = 0;

            $('#tabla_promesado tbody tr td.importe_promesado').each(function () {
                var _importe = $(this).text();
                _importe = _importe.replace('$', '');
                _importe = _importe.replace(',', '');
                _suma_promesado = _suma_promesado + parseFloat(_importe);
            });
            var _suma_promesado_formateado = currency(_suma_promesado, 2, [',', "'", '.']); // con esto datos formato de numero

            $("#resumen_convenios").empty();
            $("#resumen_convenios").append("LO PROMESADO DE HOY ES IGUAL A $" + _suma_promesado_formateado);
            ;

        }
    });
}
;
//==============================================================================
function select_reporte_gestiones2(_id_sucursal, _fecha_inicio, _fecha_fin, _columna, _orden, _id_caja) {
    var params = {
        accion: "select_reporte_gestiones",
        id_sucursal: _id_sucursal,
        fecha_inicio: _fecha_inicio,
        fecha_fin: _fecha_fin,
        columna: _columna,
        orden: _orden
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            var _suma_promesado = 0;

            $('#tabla_promesado tbody tr td.importe_promesado').each(function () {
                var _importe = $(this).text();
                _importe = _importe.replace('$', '');
                _importe = _importe.replace(',', '');
                _suma_promesado = _suma_promesado + parseFloat(_importe);
            });
            var _suma_promesado_formateado = currency(_suma_promesado, 2, [',', "'", '.']); // con esto datos formato de numero

            $("#resumen_convenios").empty();
            $("#resumen_convenios").append("LO PROMESADO DE HOY ES IGUAL A $" + _suma_promesado_formateado);
            ;

        }
    });
}
;
//==============================================================================
function select_reporte_gestiones_csv(_id_cliente, _id_region, _id_asignacion, _desde, _hasta, _hora_inicial, _hora_final, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_reporte_gestiones_csv",
        id_cliente: _id_cliente,
        id_region: _id_region,
        id_asignacion: _id_asignacion,
        fecha_inicial: _desde,
        fecha_final: _hasta,
        hora_inicial: _hora_inicial,
        hora_final: _hora_final
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<br><br>');
            $("#" + _id_caja).append(dataRes);
            window.open("excel/reporte-gestiones.csv");
        }
    });
}
//==============================================================================
function import_gestiones_blaster(_id_usuario, _id_cliente, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "import_gestiones_blaster",
        id_usuario: _id_usuario,
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<br>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_gestiones_chbk(_desde, _hasta, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_gestiones_chbk",
        desde: _desde,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).show();
            window.open("excel/gestiones-chbk.csv");
        }
    });
}
;
//==============================================================================
function select_reporte_gestiones_region(_id_region, _desde, _hasta, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_reporte_gestiones_region",
        id_region: _id_region,
        desde: _desde,
        hasta: _hasta
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
;