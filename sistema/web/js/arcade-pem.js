//==============================================================================
function select_paises_combo(_id_caja) {
    var params = {
        accion: "select_paises_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePaises",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function select_estados_pais_combo(_id_pais, _id_caja) {
    var params = {
        accion: "select_estados_pais_combo",
        id_pais: _id_pais
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEstados",
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
function select_municipios_estado_combo(_id_estado, _id_caja) {
    var params = {
        accion: "select_municipios_estado_combo",
        id_estado: _id_estado
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMunicipios",
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
