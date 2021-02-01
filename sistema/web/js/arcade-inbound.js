//==============================================================================
function select_inbound_fecha(_fecha, _hasta, id_caja) {
    var params = {
        accion: "select_inbound_fecha",
        fecha: _fecha,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageInbound",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + id_caja).empty();
            $("#" + id_caja).append(dataRes);
            $("#xlsx").show();
            $("#enviar_grafica").show();
        }
    });
}
;
//==============================================================================
function select_inbound_fecha_resumen(_fecha, _hasta, _group, id_caja) {
    var params = {
        accion: "select_inbound_fecha_resumen",
        fecha: _fecha,
        hasta: _hasta,
        group: _group
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageInbound",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + id_caja).empty();
            $("#" + id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_outbound_fecha(_fecha, id_caja) {
    var params = {
        accion: "select_outbound_fecha",
        fecha: _fecha
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageInbound",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + id_caja).empty();
            $("#" + id_caja).append(dataRes);
            $("#xlsx").show();
            $("#enviar_grafica").show();
        }
    });
}
;
//==============================================================================
function select_outbound_fecha_resumen(_fecha, _group, id_caja) {
    var params = {
        accion: "select_outbound_fecha_resumen",
        fecha: _fecha,
        group: _group
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageInbound",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + id_caja).empty();
            $("#" + id_caja).append(dataRes);
        }
    });
}
;