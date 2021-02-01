//==============================================================================
function select_categoria_sms_tabla(_id_caja) {
    var params = {
        accion: "select_categoria_sms_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategoriaSms",
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
function select_categoria_sms_combo(_id_caja) {
    var params = {
        accion: "select_categoria_sms_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategoriaSms",
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
function insert_categoria_sms(_id_usuario, _categoria_sms, _id_caja) {
    var params = {
        accion: "insert_categoria_sms",
        id_usuario: _id_usuario,
        categoria_sms: _categoria_sms
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategoriaSms",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_categoria_sms_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function update_sms(_id_usuario, _id_sms, _sms) {
    var params = {
        accion: "update_sms",
        id_usuario: _id_usuario,
        id_sms: _id_sms,
        sms: _sms
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategoriaSms",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#update_sms").hide();
            select_categoria_sms_tabla("div_categorias_sms");
            $("#delete_sms").show();
        }
    });
}
;
//==============================================================================
function delete_sms(_id_usuario, _id_sms, _id_caja) {
    var params = {
        accion: "delete_sms",
        id_usuario: _id_usuario,
        id_sms: _id_sms
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategoriaSms",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_categoria_sms_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function autorizar_sms(_id_usuario, _id_sms, _id_caja) {
    var params = {
        accion: "autorizar_sms",
        id_usuario: _id_usuario,
        id_sms: _id_sms
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategoriaSms",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_categoria_sms_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function select_sms(_id_sms, _id_caja_sms, _id_caja) {
    var params = {
        accion: "select_sms",
        id_sms: _id_sms
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategoriaSms",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja_sms).val('');
            $("#" + _id_caja_sms).val(dataRes);
            select_categoria_sms_tabla(_id_caja);

            var _largo = $("#mensaje").val().length;
            $("#contador").html(_largo + "/160");
        }
    });
}
;