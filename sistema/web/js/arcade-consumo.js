//==============================================================================
function select_consumo_tabla(_fecha, _id_caja) {
    var params = {
        accion: "select_consumo_tabla",
        fecha: _fecha
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConsumo",
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
function insert_consumo(_id_consumo, _consumo, _id_caja) {
    var params = {
        accion: "insert_consumo",
        id_consumo: _id_consumo,
        consumo: _consumo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConsumo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_consumo_tabla(_id_caja);
            select_consumo_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_consumo(_id_consumo, _consumo) {
    var params = {
        accion: "update_consumo",
        id_consumo: _id_consumo,
        consumo: _consumo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConsumo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_consumo(_id_consumo, _id_caja) {
    var params = {
        accion: "delete_consumo",
        id_consumo: _id_consumo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConsumo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_consumo_tabla(_id_caja);
            select_consumo_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function importar_consumo(_id_sucursal, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "importar_consumo",
        id_sucursal: _id_sucursal
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageConsumo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}