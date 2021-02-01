//==============================================================================
function select_cierre_tabla(_id_usuario, _id_asignacion, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_cierre_tabla",
        id_usuario: _id_usuario,
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCierre",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#caja_excel").show();
        }
    });
}
;
//==============================================================================
function select_cierre_combo(_id_caja) {
    var params = {
        accion: "select_cierre_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCierre",
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
function insert_cierre(_id_cierre, _cierre, _id_caja) {
    var params = {
        accion: "insert_cierre",
        id_cierre: _id_cierre,
        cierre: _cierre
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCierre",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_cierre_tabla(_id_caja);
            select_cierre_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_cierre(_id_cierre, _cierre) {
    var params = {
        accion: "update_cierre",
        id_cierre: _id_cierre,
        cierre: _cierre
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCierre",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_cierre(_id_cierre, _id_caja) {
    var params = {
        accion: "delete_cierre",
        id_cierre: _id_cierre
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCierre",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_cierre_tabla(_id_caja);
            select_cierre_combo(_id_caja);
        }
    });
}
;