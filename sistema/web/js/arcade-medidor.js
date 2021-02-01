//==============================================================================
function select_medidor_tabla(_id_puesto, _id_caja) {
    var params = {
        accion: "select_medidor_tabla",
        id_puesto: _id_puesto

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMedidores",
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
function select_medidor_combo(_id_caja) {
    var params = {
        accion: "select_medidor_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMedidores",
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
function insert_medidor(_id_puesto, _medidor, _descripcion, _id_caja) {
    var params = {
        accion: "insert_medidor",
        id_puesto: _id_puesto,
        medidor: _medidor,
        descripcion: _descripcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMedidores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_medidor_tabla(_id_puesto, _id_caja);
//            select_medidor_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_medidor(_id_medidor, _medidor) {
    var params = {
        accion: "update_medidor",
        id_medidor: _id_medidor,
        medidor: _medidor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMedidores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_medidor(_id_puesto, _id_medidor, _id_caja) {
    var params = {
        accion: "delete_medidor",
        id_medidor: _id_medidor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMedidores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_medidor_tabla(_id_puesto, _id_caja);
//            select_medidor_combo(_id_caja);
        }
    });
}
;