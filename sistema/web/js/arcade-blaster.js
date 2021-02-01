//==============================================================================
function select_blaster_tabla(_id_caja) {
    var params = {
        accion: "select_blaster_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
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
function select_blaster_combo(_id_caja) {
    var params = {
        accion: "select_blaster_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
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
function insert_blaster(_nombre, _reintentos, _timbrado, _troncal, _prefijo, _audio, _confirmar) {
    var params = {
        accion: "insert_blaster",
        nombre: _nombre,
        reintentos: _reintentos,
        timbrado: _timbrado,
        troncal: _troncal,
        prefijo: _prefijo,
        audio: _audio,
        confirmar: _confirmar

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            location.href = "blasters.jsp";
        }
    });
}
;
//==============================================================================
function update_blaster(_id_blaster, _blaster) {
    var params = {
        accion: "update_blaster",
        id_blaster: _id_blaster,
        blaster: _blaster
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;

//==============================================================================
function delete_blaster(_id_blaster, _id_caja) {
    var params = {
        accion: "delete_blaster",
        id_blaster: _id_blaster
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_blaster_tabla(_id_caja);
        }
    });
}
;

//==============================================================================
function remarcar_blaster(_id_usuario, _id_blaster, _todo, _id_caja) {
    var params = {
        accion: "remarcar_blaster",
        id_usuario: _id_usuario,
        id_blaster: _id_blaster,
        todo: _todo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_blaster_tabla(_id_caja);
        }
    });
}
;

//==============================================================================
function obtener_resultado_blaster(_id_blaster, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div><br>");
    $("#" + _id_caja).append("<div style='text-align:center;'><h4>TARIFICANDO RESULTADOS...</h4></div>");
    var params = {
        accion: "obtener_resultado_blaster",
        id_blaster: _id_blaster
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#" + _id_caja).empty();
            select_blaster_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function genera_predictivo(_id_usuario, _id_blaster, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div><br>");
    $("#" + _id_caja).append("<div style='text-align:center;'><h4>GENERANDO PREDICTIVO...</h4></div>");
    var params = {
        accion: "genera_predictivo",
        id_usuario: _id_usuario,
        id_blaster: _id_blaster
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#" + _id_caja).empty();
            select_blaster_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function select_blaster_resultado_tabla(_id_blaster, _ans, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_blaster_resultado_tabla",
        id_blaster: _id_blaster,
        ans: _ans
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
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
function select_audios_blaster(_id_caja, _f_active) {
    var params = {
        accion: "select_audios_blaster",
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
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
function select_audios_blaster_tabla(_id_caja, _f_active) {
    var params = {
        accion: "select_audios_blaster_tabla",
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
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
function update_nombre_audio_blaster(_id_audio, _audio) {
    var params = {
        accion: "update_nombre_audio_blaster",
        id_audio: _id_audio,
        audio: _audio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================
function update_estatus_audio_blaster(_id_audio, _f_active) {
    var params = {
        accion: "update_estatus_audio_blaster",
        id_audio: _id_audio,
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageBlaster",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;