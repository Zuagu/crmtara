//==============================================================================
function select_story_tabla(_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_story_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
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
function select_story_combo(_id_caja) {
    var params = {
        accion: "select_story_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
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
function insert_story(_id_usuario, _story, _descripcion) {
    var params = {
        accion: "insert_story",
        id_usuario: _id_usuario,
        story: _story,
        descripcion: _descripcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);

            $("#div_tickets_story").hide();
            $("#div_alta_ticket").hide();
            $("#div_nuevo_story").hide();
            $("#div_mis_tickets").hide();
            $("#div_stories").show();

            select_story_tabla("tbody_stories");

        }
    });
}
;
//==============================================================================
function update_story(_id_story, _story) {
    var params = {
        accion: "update_story",
        id_story: _id_story,
        story: _story
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_story(_id_story, _id_caja) {
    var params = {
        accion: "delete_story",
        id_story: _id_story
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_story_tabla(_id_caja);
            select_story_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function select_usuarios_desarrollo(_id_caja) {
    var params = {
        accion: "select_usuarios_desarrollo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).material_select();
        }
    });
}
;
//==============================================================================
function select_reporte_actividades(_id_usuario, _fecha, _hasta, id_caja) {
    var params = {
        accion: "select_reporte_actividades",
        id_usuario: _id_usuario,
        fecha: _fecha,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + id_caja).empty();
            $("#" + id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_datos_reporte_actividades(_id_usuario, _desde, _hasta) {
    var params = {
        accion: "select_datos_reporte_actividades",
        id_usuario: _id_usuario,
        desde: _desde,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageStory",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            partir_datos(dataRes, "dato", 5);
        }
    });
}
;
//==============================================================================
function partir_datos(dataRes, _campo, _forlimit) {
    var campos = dataRes.split("#AND#");
    for (i = 1; i <= _forlimit; i++) {
        $("#" + _campo + i).val(campos[i]);
    }
}
;