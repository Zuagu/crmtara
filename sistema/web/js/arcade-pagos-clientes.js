//==============================================================================
function select_ordenes_sin_pagar_proveedor(_id_proveedor, _id_caja) {
    var params = {
        accion: "select_ordenes_sin_pagar_proveedor",
        id_proveedor: _id_proveedor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
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