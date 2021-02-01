//==============================================================================
function select_basegeneral_tabla(_id_region, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_basegeneral_tabla2",
        id_region: _id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<br><br>');
            $("#" + _id_caja).append(dataRes);
            $("#select_basegeneral").show();
            window.open("excel/base-general.csv");
        }
    });
}
;
//==============================================================================
function update_basegeneral(_id_asignacion, _basegeneral) {
    var params = {
        accion: "update_basegeneral",
        id_asignacion: _id_asignacion,
        basegeneral: _basegeneral
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function select_basegeneral_asignar_tabla(_id_asignacion, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_basegeneral_asignar_tabla",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#select_basegeneral").show();
        }
    });
}
;
//==============================================================================
function asignar_cuentas(_id_asignacion, _equipos, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/i_charm.gif'></div>");
    var params = {
        accion: "asignar_cuentas",
        id_asignacion: _id_asignacion,
        equipos: _equipos
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            select_basegeneral_asignar_tabla($("#id_asignacion").val(), "div_basegeneral");
            alert(dataRes);

        }
    });
}
;
//==============================================================================
function select_basechargeback_tabla(_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_basechargeback_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
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
function select_basechargeback_resumen_tabla(_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_basechargeback_resumen_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
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
function select_basechargeback_resumen_tabla_actual(_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_basechargeback_resumen_tabla_actual"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
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
function update_f_active_cuentas(_id_usuario, _cuentas, _f_active, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "update_f_active_cuentas",
        id_usuario: _id_usuario,
        cuentas: _cuentas,
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBasegeneral",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).append('<br><br><input id="finalizar" type="button" value="FINALIZAR" style="width:100px;">');
        }
    });
}
;