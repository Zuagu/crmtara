////==============================================================================
//function select_equipo_tabla(_id_caja) {
//    var params = {
//        accion: "select_equipo_tabla"
//    };
//    $.ajax({
//        type: "POST",
//        url: "/sistema/ManageEquipo",
//        data: params,
//        dataType: "html",
//        success: function (dataRes) {
//            $("#" + _id_caja).empty();
//            $("#" + _id_caja).append(dataRes);
//            $("#" + $("#id_equipo").val()).addClass("equipo_gestores_selected");
//        }
//    });
//}
//;
//==============================================================================
function select_equipo_check(_cadena_asignaciones, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_equipo_check",
        cadena_asignaciones: _cadena_asignaciones
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
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
function select_equipo_combo(_id_caja) {
    var params = {
        accion: "select_equipo_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
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
function insert_equipo() {
    var params = {
        accion: "insert_equipo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
        data: params,
        dataType: "html",
        success: function () {
            select_equipo_tabla("div_equipos");
        }
    });
}
;
//==============================================================================
function update_equipo(_id_equipo, _equipo) {
    var params = {
        accion: "update_equipo",
        id_equipo: _id_equipo,
        equipo: _equipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_equipo(_id_equipo, _id_caja) {
    var params = {
        accion: "delete_equipo",
        id_equipo: _id_equipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_equipo_tabla(_id_caja);
            select_equipo_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function agregar_gestor_equipo(_id_equipo, _id_gestor) {
    var params = {
        accion: "agregar_gestor_equipo",
        id_equipo: _id_equipo,
        id_gestor: _id_gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
        data: params,
        dataType: "html",
        success: function () {
            select_equipo_tabla("div_equipos");
            select_usuarios_equipo(_id_equipo, "listado_gestores_equipo");
        }
    });
}
;
//==============================================================================
function deshacer_equipo(_id_equipo) {
    var params = {
        accion: "deshacer_equipo",
        id_equipo: _id_equipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
        data: params,
        dataType: "html",
        success: function () {
            select_equipo_tabla("div_equipos");
            select_usuarios_equipo(_id_equipo, "listado_gestores_equipo");
        }
    });
}
;
//==============================================================================
function reset_equipo(_id_equipo) {
    var params = {
        accion: "reset_equipo",
        id_equipo: _id_equipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEquipo",
        data: params,
        dataType: "html",
        success: function () {
            select_equipo_tabla("div_equipos");
            select_usuarios_equipo(_id_equipo, "listado_gestores_equipo");
        }
    });
}
;
//==============================================================================