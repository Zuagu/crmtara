//==============================================================================
function select_ticket_tabla(_id_story, _id_caja) {
    var params = {
        accion: "select_ticket_tabla",
        id_story: _id_story
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
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
function select_ticket_combo(_id_caja) {
    var params = {
        accion: "select_ticket_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
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
function insert_ticket(_ticket, _id_story, _comentarios, _id_usuario, _id_usuario_asignado, _tiempo_estimado, _categoria) {
    var params = {
        accion: "insert_ticket",

        ticket: _ticket,
        id_story: _id_story,
        comentarios: _comentarios,
        id_usuario: _id_usuario,
        id_usuario_asignado: _id_usuario_asignado,
        tiempo_estimado: _tiempo_estimado,
        categoria: _categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $(".ocultable").hide();
            $("#div_tickets_story").show();
            select_ticket_tabla($("#id_story").val(), "tbody_tickets");
        }
    });
}
;
//==============================================================================
function update_ticket(_id_usuario, _id_ticket, _respuesta, _id_estatus) {
    var params = {
        accion: "update_ticket",
        id_usuario: _id_usuario,
        id_ticket: _id_ticket,
        respuesta: _respuesta,
        id_estatus: _id_estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            $(".ocultable").hide();
            $("#div_tickets_story").show();
            select_ticket_tabla($(this).closest("tr").attr("id"), "tbody_tickets");
        }
    });
}
;
//==============================================================================
function update_tiempos_tickets(_id_ticket) {
    var params = {
        accion: "update_tiempos_tickets",
        id_ticket: _id_ticket

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_tickets_usuario($('#usuario_sistema', parent.document).val(), "tbody_tickets_usuario"); // depa, abierto
        }
    });
}
;
//==============================================================================
function delete_ticket(_id_ticket) {
    var params = {
        accion: "delete_ticket",
        id_ticket: _id_ticket
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $(".ocultable").hide();
            $("#div_tickets_story").show();

            select_ticket_tabla($(this).closest("tr").attr("id"), "tbody_tickets");
        }
    });
}
;
//==============================================================================
function select_detalles_tickets() {
    var params = {
        accion: "select_detalles_tickets"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
        data: params,
        dataType: "html",
        success: function (dataRes) {

            var campos = dataRes.split("#AND#");

            for (i = 1; i <= 6; i++) {
                //SE AJUSTA CON +1 PORQUE EL ARRAY NO CONTIENE INICIO COMO EN DATOS CUENTA
                $("#dt" + i).text(campos[i]);
            }
        }
    });
}
;
//==============================================================================
function select_tickets_usuario(_id_usuario, _id_caja) {
    var params = {
        accion: "select_tickets_usuario",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
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
function select_resumen_tickets_usuario(_id_caja) {
    var params = {
        accion: "select_resumen_tickets_usuario"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
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
function select_tickets_en_proceso(_id_caja) {
    var params = {
        accion: "select_tickets_en_proceso"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageTicket",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;