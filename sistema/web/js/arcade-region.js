//==============================================================================
function select_region_tabla(_id_cliente, _id_caja) {
    $("#" + _id_caja).css("cursor", "progress");
    var params = {
        accion: "select_region_tabla",
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRegion",
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
function select_region_check(_cadena_clientes, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_region_check",
        cadena_clientes: _cadena_clientes
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRegion",
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
function select_region_combo(_id_cliente, _id_caja, _seleccione) {
    var params = {
        accion: "select_region_combo",
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRegion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            if (_seleccione) {
                $("#" + _id_caja).append('<option value="0">TODAS...</option>');
            }
            $("#" + _id_caja).append('<option value="0">TODAS...</option>' + dataRes);
        }
    });
}
;
//==============================================================================
function insert_region(_region, _id_cliente, _id_caja) {
    var params = {
        accion: "insert_region",
        region: _region,
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRegion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_region_tabla(_id_cliente, _id_caja);
        }
    });
}
;
//==============================================================================
function update_region(_id_region, _region) {
    var params = {
        accion: "update_region",
        id_region: _id_region,
        region: _region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRegion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_region(_id_region, _id_cliente, _id_caja) {
    var params = {
        accion: "delete_region",
        id_region: _id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRegion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_region_tabla(_id_cliente, _id_caja);
        }
    });
}
;
//==============================================================================
function select_region_combo_materialize(_id_cliente, _id_caja, _seleccione) {
    var params = {
        accion: "select_region_combo",
        id_cliente: _id_cliente
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRegion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            if (_seleccione) {
                $("#" + _id_caja).append('<option value="0">TODAS...</option>');
            }
            $("#" + _id_caja).append(dataRes);
             $('select').material_select();
        }
    });
}
;
//==============================================================================