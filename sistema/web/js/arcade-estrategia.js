//==============================================================================
function select_estrategia_tabla(_id_usuario, _id_caja) {
    $("#" + _id_caja).css("cursor", "progress");
    var params = {
        accion: "select_estrategia_tabla",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
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
function select_estrategia_combo(_id_usuario, _id_caja) {
    var params = {
        accion: "select_estrategia_combo",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
//            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function insert_estrategia(_id_estrategia, _estrategia, _id_caja) {
    var params = {
        accion: "insert_estrategia",
        id_estrategia: _id_estrategia,
        estrategia: _estrategia
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estrategia_tabla(_id_caja);
            select_estrategia_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_estrategia(_id_estrategia, _estrategia) {
    var params = {
        accion: "update_estrategia",
        id_estrategia: _id_estrategia,
        estrategia: _estrategia
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_estrategia(_id_estrategia, _id_caja) {
    var params = {
        accion: "delete_estrategia",
        id_estrategia: _id_estrategia
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_estrategia_tabla(_id_caja);
            select_estrategia_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_estrategia_gestor(_id_gestor, _id_estrategia, _id_estatus) {
    var params = {
        accion: "update_estrategia_gestor",
        id_usuario: _id_gestor,
        id_estrategia: _id_estrategia,
        id_estatus: _id_estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstrategia",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#consola").empty();
            $("#consola").append(dataRes);
            console.log(dataRes);
            $("#id_estrategia").val('0');

//            REVISAR QUE HACE
//            select_nombre_estrategia();
        }
    });
}