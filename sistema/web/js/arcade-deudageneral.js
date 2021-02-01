//==============================================================================
function select_deuda_general(_id_empresa, _id_caja) {
    var params = {
        accion: "select_deuda_general",
        id_empresa: _id_empresa
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