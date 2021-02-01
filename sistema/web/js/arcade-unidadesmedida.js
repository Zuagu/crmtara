//==============================================================================
function select_unidades_combo(_id_caja) {
    var params = {
        accion: "select_unidades_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUnidadesMedida",
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