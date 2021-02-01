//==============================================================================
function select_estatus_llamada_tabla(_id_caja) {
    $("#" + _id_caja).css("cursor", "progress");
    var params = {
        accion: "select_estatus_llamada_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusLlamada",
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
function select_estatus_llamada_combo(_id_caja, _seleccione) {
    var params = {
        accion: "select_estatus_llamada_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusLlamada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            if (_seleccione) {
                $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            }
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function insert_estatus_llamada(_estatus_llamada, _descripcion, _id_caja) {
    var params = {
        accion: "insert_estatus_llamada",
        estatus_llamada: _estatus_llamada,
        descripcion: _descripcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusLlamada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estatus_llamada_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function update_estatus_llamada(_id_estatus_llamada, _estatus_llamada) {
    var params = {
        accion: "update_estatus_llamada",
        id_estatus_llamada: _id_estatus_llamada,
        estatus_llamada: _estatus_llamada
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusLlamada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_estatus_llamada(_id_estatus_llamada, _id_caja) {
    var params = {
        accion: "delete_estatus_llamada",
        id_estatus_llamada: _id_estatus_llamada
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstatusLlamada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estatus_llamada_tabla(_id_caja);
        }
    });
}
;