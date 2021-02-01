//==============================================================================
function select_puesto_tabla(_id_caja) {
    var params = {
        accion: "select_puesto_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
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
function select_puesto_combo(_id_caja) {
    var params = {
        accion: "select_puesto_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).material_select();
        }
    });
}
;
//==============================================================================
function insert_puesto(_id_puesto, _puesto, _id_caja) {
    var params = {
        accion: "insert_puesto",
        id_puesto: _id_puesto,
        puesto: _puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_puesto_tabla(_id_caja);
            select_puesto_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_puesto(_id_puesto, _puesto) {
    var params = {
        accion: "update_puesto",
        id_puesto: _id_puesto,
        puesto: _puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_puesto(_id_puesto, _id_caja) {
    var params = {
        accion: "delete_puesto",
        id_puesto: _id_puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_puesto_tabla(_id_caja);
            select_puesto_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function select_menu_puesto(_id_puesto, _id_caja) {
    var params = {
        accion: "select_menu_puesto",
        id_puesto: _id_puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).val(dataRes);
        }
    });
}
;
//==============================================================================
function update_menu_puesto(_id_puesto, _html_menu) {
    var params = {
        accion: "update_menu_puesto",
        id_puesto: _id_puesto,
        html_menu: _html_menu
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;