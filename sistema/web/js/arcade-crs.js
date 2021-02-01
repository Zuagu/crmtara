//==============================================================================
function select_cr_tabla(_id_asignacion, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_cr_tabla",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCr",
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
function select_cr_combo(_id_caja) {
    var params = {
        accion: "select_cr_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCr",
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
function insert_cr(_id_asignacion) {
    var params = {
        accion: "insert_cr",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCr",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#finalizar", parent.document).show();
            $("#form_cargar_crs", parent.document).hide();
        }
    });
}
;
//==============================================================================
function update_cr(_id_cr, _cr) {
    var params = {
        accion: "update_cr",
        id_cr: _id_cr,
        cr: _cr
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCr",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_cr(_id_cr, _id_caja) {
    var params = {
        accion: "delete_cr",
        id_cr: _id_cr
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCr",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_cr_tabla(_id_caja);
            select_cr_combo(_id_caja);
        }
    });
}
;