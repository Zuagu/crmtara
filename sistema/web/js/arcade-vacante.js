//==============================================================================
function select_vacante_tabla(_id_puesto, _id_caja) {
    $("#" + _id_caja).css("cursor", "progress");
    var params = {
        accion: "select_vacante_tabla",
        id_puesto: _id_puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVacante",
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
function select_vacante_combo(_id_caja) {
    var params = {
        accion: "select_vacante_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVacante",
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
function insert_vacante(_vacante, _id_puesto, _id_caja) {
    var params = {
        accion: "insert_vacante",
        vacante: _vacante,
        id_puesto: _id_puesto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVacante",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            select_vacante_tabla(_id_puesto, _id_caja);
        }
    });
}
;
//==============================================================================
function update_vacante(_id_vacante, _vacante) {
    var params = {
        accion: "update_vacante",
        id_vacante: _id_vacante,
        vacante: _vacante
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVacante",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_vacante(_id_vacante, _id_puesto, _id_caja) {
    var params = {
        accion: "delete_vacante",
        id_vacante: _id_vacante
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVacante",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
}
;
//==============================================================================
function udpate_id_usuario_vacante(_id_vacante, _id_usuario, _sueldo, _id_puesto, _id_caja) {
    var params = {
        accion: "udpate_id_usuario_vacante",
        id_vacante: _id_vacante,
        id_usuario: _id_usuario,
        sueldo: _sueldo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVacante",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            select_vacante_tabla(_id_puesto, _id_caja);
        }
    });
}
;
//==============================================================================
function select_puesto_tabla_vac(_id_caja) {
    var params = {
        accion: "select_puesto_tabla_vac"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePuesto",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $('select').material_select();
        }
    });
}
;
//==============================================================================
function reasignar_vacante(_puesto, _vacante, _usuario_id) {
    var params = {
        accion: "reasignar_vacante",
        puesto: _puesto,
        vacante: _vacante,
        usuario_id: _usuario_id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVacante",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
}
;