//==============================================================================
function select_asignacionoriginal_tabla(_id_caja) {
    $("#" + _id_caja).css("cursor", "progress");
    var params = {
        accion: "select_asignacionoriginal_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacionOriginal",
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
function select_asignacionoriginal_combo(_id_caja) {
    var params = {
        accion: "select_asignacionoriginal_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacionOriginal",
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
function insert_asignacionoriginal(_id_asignacionoriginal, _asignacionoriginal, _id_caja) {
    var params = {
        accion: "insert_asignacionoriginal",
        id_asignacionoriginal: _id_asignacionoriginal,
        asignacionoriginal: _asignacionoriginal
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacionOriginal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_asignacionoriginal_tabla(_id_caja);
            select_asignacionoriginal_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_asignacionoriginal(_id_asignacionoriginal, _asignacionoriginal) {
    var params = {
        accion: "update_asignacionoriginal",
        id_asignacionoriginal: _id_asignacionoriginal,
        asignacionoriginal: _asignacionoriginal
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacionOriginal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_asignacionoriginal(_id_asignacionoriginal, _id_caja) {
    var params = {
        accion: "delete_asignacionoriginal",
        id_asignacionoriginal: _id_asignacionoriginal
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacionOriginal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_asignacionoriginal_tabla(_id_caja);
            select_asignacionoriginal_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function truncate_asignacion_temporal() {
    var params = {
        accion: "truncate_asignacion_temporal"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacionOriginal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_asignacionoriginal_tabla("listado_asignacion_original");
        }
    });
}
;