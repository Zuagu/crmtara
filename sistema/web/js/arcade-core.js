//==============================================================================
function select_core_tabla(_filtro, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_core_tabla",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCore",
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
function select_core_combo(_id_caja) {
    var params = {
        accion: "select_core_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCore",
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
function insert_core(_id_core, _core, _id_caja) {
    var params = {
        accion: "insert_core",
        id_core: _id_core,
        core: _core
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_core_tabla(_id_caja);
            select_core_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_core(_id_core, _core) {
    var params = {
        accion: "update_core",
        id_core: _id_core,
        core: _core
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_core(_id_core, _id_caja) {
    var params = {
        accion: "delete_core",
        id_core: _id_core
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_core_tabla(_id_caja);
            select_core_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_dato_core(_id_usuario, _id_registro, _columna, _nuevo_valor) {
    var params = {
        accion: "update_dato_core",
        id_usuario: _id_usuario,
        id_registro: _id_registro,
        columna: _columna,
        nuevo_valor: _nuevo_valor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;