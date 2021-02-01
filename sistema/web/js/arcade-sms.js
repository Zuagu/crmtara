//==============================================================================
function select_sms_tabla(_id_caja) {
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_sms_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageManageSms",
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
function select_sms_combo(_id_caja) {
    var params = {
        accion: "select_sms_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageManageSms",
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
function insert_sms(_id_sms, _sms, _id_caja) {
    var params = {
        accion: "insert_sms",
        id_sms: _id_sms,
        sms: _sms
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageManageSms",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_sms_tabla(_id_caja);
            select_sms_combo(_id_caja);
        }
    });
}
;
