//==============================================================================
function select_metodos_combo(_id_caja) {
    var params = {
        accion: "select_metodos_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMetodosPago",
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