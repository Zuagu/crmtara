//==============================================================================
function insert_pago_oc(_id_usuario, _id_proveedor, _orden, _importe, _id_metodopago, _id_cuenta, _id_banco_destino, _id_cuenta_destino, _comentarios) {
    var params = {
        accion: "insert_pago_oc",
        id_usuario: _id_usuario,
        id_proveedor: _id_proveedor,
        orden: _orden,
        importe: _importe,
        id_metodopago: _id_metodopago,
        id_cuenta: _id_cuenta,
        id_banco_destino: _id_banco_destino,
        id_cuenta_destino: _id_cuenta_destino,
        comentarios: _comentarios
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePagosProveedor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_pagos_proveedor_tabla('div_ultimos_pagos');
            $("#insert_pago_proveedor").show();

        }
    });
}
;
//==============================================================================
function select_pagos_proveedor_tabla(_id_caja) {
    var params = {
        accion: "select_pagos_proveedor_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePagosProveedor",
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