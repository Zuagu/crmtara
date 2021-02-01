//==============================================================================
function select_tasas_combo(_id_caja) {
    var params = {
        accion: "select_tasas_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTasas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;