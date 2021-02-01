//==============================================================================
function select_blacklist(_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_blacklist"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlacklist",
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
function update_blacklist(_id_usuario, _cuenta, _fbl) {
    var params = {
        accion: "update_blacklist",
        id_usuario: _id_usuario,
        cuenta: _cuenta,
        fbl: _fbl
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlacklist",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_blacklist("blacklist");
        }
    });
}
;