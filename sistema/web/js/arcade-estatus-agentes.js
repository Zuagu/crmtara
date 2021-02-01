//==============================================================================
function select_estatus_agentes_tabla(_id_caja) {
    $("#" + _id_caja).css("cursor", "progress");
    var params = {
        accion: "select_estatus_agentes_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).css("cursor", "default");
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_agentes_combo(_id_caja) {
    var params = {
        accion: "select_estatus_agentes_combo"
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
function insert_estatus_agentes(_id_estatus_agentes, _estatus_agentes, _id_caja) {
    var params = {
        accion: "insert_estatus_agentes",
        id_estatus_agentes: _id_estatus_agentes,
        estatus_agentes: _estatus_agentes
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estatus_agentes_tabla(_id_caja);
            select_estatus_agentes_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_estatus_agentes(_id_estatus_agentes, _estatus_agentes) {
    var params = {
        accion: "update_estatus_agentes",
        id_estatus_agentes: _id_estatus_agentes,
        estatus_agentes: _estatus_agentes
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
function delete_estatus_agentes(_id_estatus_agentes, _id_caja) {
    var params = {
        accion: "delete_estatus_agentes",
        id_estatus_agentes: _id_estatus_agentes
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estatus_agentes_tabla(_id_caja);
            select_estatus_agentes_combo(_id_caja);
        }
    });
}
;