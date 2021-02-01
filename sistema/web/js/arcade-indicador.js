//==============================================================================
function select_indicador_tabla(_fecha, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_indicador_tabla",
        fecha: _fecha
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageIndicador",
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
function select_indicador_rango_tabla(_fecha, _fecha_fin, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_indicador_rango_tabla",
        fecha: _fecha,
        fecha_fin: _fecha_fin
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageIndicador",
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
function select_indicador_rango_chbk_tabla(_fecha, _fecha_fin, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_indicador_rango_chbk_tabla",
        fecha: _fecha,
        fecha_fin: _fecha_fin
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageIndicador",
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
function select_indicador_combo(_id_caja) {
    var params = {
        accion: "select_indicador_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageIndicador",
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
function insert_indicador(_id_indicador, _indicador, _id_caja) {
    var params = {
        accion: "insert_indicador",
        id_indicador: _id_indicador,
        indicador: _indicador
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageIndicador",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_indicador_tabla(_id_caja);
            select_indicador_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_indicador(_id_indicador, _indicador) {
    var params = {
        accion: "update_indicador",
        id_indicador: _id_indicador,
        indicador: _indicador
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageIndicador",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_indicador(_id_indicador, _id_caja) {
    var params = {
        accion: "delete_indicador",
        id_indicador: _id_indicador
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageIndicador",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_indicador_tabla(_id_caja);
            select_indicador_combo(_id_caja);
        }
    });
}
;