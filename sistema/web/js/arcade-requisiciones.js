//==============================================================================
function select_requisiciones_tabla(_id_caja) {
    var params = {
        accion: "select_requisiciones_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRequisiciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_requisiciones_tabla_usuario(_id_usuario, _id_caja) {
    var params = {
        accion: "select_requisiciones_tabla_usuario",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRequisiciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_cuerpo_requisicion(_folio, _id_caja) {
    var params = {
        accion: "select_cuerpo_requisicion",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRequisiciones",
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
function select_detalles_documento(_folio) {
    var params = {
        accion: "select_detalles_documento",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRequisiciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var dato = dataRes.split('+');
            $("#req_1").text(dato[0]);
            $("#req_2").text(dato[1]);
            $("#req_3").text(dato[2]);
            $("#req_4").text(dato[3]);
            $("#req_5").text(dato[4]);
        }
    });
}
;
//==============================================================================