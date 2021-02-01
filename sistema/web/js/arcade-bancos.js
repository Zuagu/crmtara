//==============================================================================
function select_bancos_combo(_id_caja) {
    var params = {
        accion: "select_bancos_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBancos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;