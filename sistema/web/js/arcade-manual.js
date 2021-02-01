//==============================================================================
function select_manual(_jsp, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_manual",
        jsp: _jsp
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageManual",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;