//==============================================================================
function select_marcacion_tabla(_id_caja, _estatus) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_marcacion_tabla",
        estatus: _estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
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
function select_marcacion_combo(_id_caja) {
    var params = {
        accion: "select_marcacion_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
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
function insert_marcacion(_id_marcacion, _marcacion, _id_caja) {
    var params = {
        accion: "insert_marcacion",
        id_marcacion: _id_marcacion,
        marcacion: _marcacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_marcacion_tabla(_id_caja);
            select_marcacion_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_marcacion(_id_marcacion, _marcacion) {
    var params = {
        accion: "update_marcacion",
        id_marcacion: _id_marcacion,
        marcacion: _marcacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_marcacion(_id_marcacion, _id_caja) {
    var params = {
        accion: "delete_marcacion",
        id_marcacion: _id_marcacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_marcacion_tabla(_id_caja, $("#estatus").val());
        }
    });
}
;
//==============================================================================
function insert_campania_marcacion(_id_asignacion, _f_tipo, _id_caja) {
    var params = {
        accion: "insert_campania_marcacion",
        id_asignacion: _id_asignacion,
        f_tipo: _f_tipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_marcacion_tabla(_id_caja, $("#estatus").val());
        }
    });
}
;
//==============================================================================
function update_estatus_campania(_id_campain, _id_caja) {
    var params = {
        accion: "update_estatus_campania",
        id_campaign: _id_campain
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_marcacion_tabla(_id_caja, $("#estatus").val());
        }
    });
}
;
//==============================================================================
function update_cola_campania(_id_campain, _cola) {
    var params = {
        accion: "update_cola_campania",
        id_campaign: _id_campain,
        cola: _cola
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMarcacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_marcacion_tabla("listado_campanias_marcacion", $("#estatus").val());
            select_colas("cola");
        }
    });
}
;