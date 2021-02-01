//==============================================================================
function select_nombre_archivos_tabla(_filtro, _usuario_sistema,_id_caja) {
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_nombre_archivos_tabla",
        filtro:_filtro,
        usuario_sistema:_usuario_sistema
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCargarArchivo",
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
function select_nombre_archivos_tabla_rh(_filtro, _usuario_sistema,_id_caja) {
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_nombre_archivos_tabla",
        filtro:_filtro,
        usuario_sistema:_usuario_sistema
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCargarArchivo",
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
function insert_cargar_archivo(_fichero,_usuario_sistema) {
    var params = {
        accion: "insert_cargar_archivo",
        fichero:_fichero,
        usuario_sistema:_usuario_sistema
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCargarArchivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}

//==============================================================================
function insert_cargar_archivo_rh(_fichero,_usuario_sistema) {
    var params = {
        accion: "insert_cargar_archivo_rh",
        fichero:_fichero,
        usuario_sistema:_usuario_sistema
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCargarArchivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
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
//==============================================================================
function select_archivo_filtro(_filtro, _usuario_sistema, _id_caja) {
    var params = {
        accion: "select_archivo_filtro",
        filtro: _filtro,
        usuario_sistema:_usuario_sistema
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCargarArchivo",
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
function select_archivo_filtro_rh(_filtro, _usuario_sistema, _id_caja) {
    var params = {
        accion: "select_archivo_filtro_rh",
        filtro: _filtro,
        usuario_sistema:_usuario_sistema
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCargarArchivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;