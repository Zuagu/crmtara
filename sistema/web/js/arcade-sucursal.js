//==============================================================================
function select_sucursal_tabla(_id_caja) {
    var params = {
        accion: "select_sucursal_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
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
function select_sucursal_combo(_id_caja, _seleccione) {
    var params = {
        accion: "select_sucursal_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            if (_seleccione) {
                $("#" + _id_caja).append("<option value='-1'>SELECCIONE...</option>");
            }
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).material_select();
        }
    });
}
;
//==============================================================================
function select_sucursal_combo_reporte_gestiones(_id_caja) {
    var params = {
        accion: "select_sucursal_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append("<option value='0'>TODAS</option>");
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_sucursal_combo_sin_borrar(_id_caja) {
    var params = {
        accion: "select_sucursal_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).material_select();
        }
    });
}
;
//==============================================================================
function insert_sucursal(_sucursal) {
    var params = {
        accion: "insert_sucursal",
        sucursal: _sucursal
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_sucursal_tabla("listado_sucursal");
        }
    });
}
;
;
//==============================================================================
function update_sucursal(_id_sucursal, _sucursal) {
    var params = {
        accion: "update_sucursal",
        id_sucursal: _id_sucursal,
        sucursal: _sucursal
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_sucursal_tabla("listado_sucursal");
        }
    });
}
;
//==============================================================================
function delete_sucursal(_id) {
    var params = {
        accion: "delete_sucursal",
        id_sucursal: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_sucursal_tabla("listado_sucursal");
        }
    });
}
;
//==============================================================================
function generar_mapa(_id_sucursal, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "generar_mapa",
        id_sucursal: _id_sucursal
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
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
function update_clases(_id_piso, _clases) {
    var params = {
        accion: "update_clases",
        id_piso: _id_piso,
        clases: _clases
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSucursal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;