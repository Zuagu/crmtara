//==============================================================================
function select_xxyyzz_tabla(_id_caja) {
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_xxyyzz_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
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
function select_xxyyzz_combo(_id_caja) {
    var params = {
        accion: "select_xxyyzz_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function insert_xxyyzz(_id_xxyyzz, _xxyyzz, _id_caja) {
    var params = {
        accion: "insert_xxyyzz",
        id_xxyyzz: _id_xxyyzz,
        xxyyzz: _xxyyzz
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_xxyyzz_tabla(_id_caja);
            select_xxyyzz_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_xxyyzz(_id_xxyyzz, _xxyyzz) {
    var params = {
        accion: "update_xxyyzz",
        id_xxyyzz: _id_xxyyzz,
        xxyyzz: _xxyyzz
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_xxyyzz(_id_xxyyzz, _id_caja) {
    var params = {
        accion: "delete_xxyyzz",
        id_xxyyzz: _id_xxyyzz
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_xxyyzz_tabla(_id_caja);
            select_xxyyzz_combo(_id_caja);
        }
    });
}
;