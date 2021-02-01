//==============================================================================
function select_contratos_usuario(_id_usuario, _id_caja) {
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_contratos_usuario",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageContrato",
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
function insert_contrato(_id_usuario, _id_seleccion, _fecha_inicio, _fecha_fin, _salario_diario, _horas_semana, _tipo_contrato) {
    var params = {
        accion: "insert_contrato",
        id_usuario: _id_usuario,
        id_seleccion: _id_seleccion,
        fecha_inicio: _fecha_inicio,
        fecha_fin: _fecha_fin,
        salario_diario: _salario_diario,
        horas_semana: _horas_semana,
        tipo_contrato: _tipo_contrato
    }
    ;
    $.ajax({
        type: "POST",
        url: "/sistema/ManageContrato",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#contrato_nuevo").hide();
            $("#btns_inf2").hide();
            $("#contrato_actual").show();
            select_contratos_usuario(_id_seleccion, "contrato_actual");
        }
    });
}
;