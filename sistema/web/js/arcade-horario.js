
//==============================================================================
function select_horario_tabla(_id_usuario,_id_caja) {
    
    var params = {
        accion: "select_horario_tabla",
        id_usuario:_id_usuario
    };

    $.ajax({
        type: "POST",
        url: "/sistema/ManageHorario",
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
function select_horario_user(_filtro, _f_administrativo, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_horario_user",
        filtro: _filtro,
        f_administrativo: _f_administrativo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageHorario",
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
function insert_horario(_id_usuario, _select_horario) {
    var params = {
        accion: "insert_horario",
        id_usuario: _id_usuario,
        select_horario: _select_horario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageHorario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            $('#modal1').modal('open');
            $("#modal_horario").text(dataRes);
        }
    });
};
//==============================================================================
//==============================================================================
function insert_horario_admin(_id_usuario, _dia, _entrada, _salida) {

    var n1 = _entrada.search("AM");
    var n2 = _salida.search("AM");

    if (n1 == -1) {
        var hora12 = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
        var hora24 = ["13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00"];
        var new_hora_entrada = _entrada.split(":");
      

        var posicion_hora1 = hora12.indexOf(new_hora_entrada[0]);
        

        var _hora_entrada = hora24[posicion_hora1] +":" + new_hora_entrada[1].replace("PM", ":00");
      

    } else {
        
        var _hora_entrada = _entrada.replace("AM", ":00");
      
        
    }
    if (n2 == -1) {
        var hora12 = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
        var hora24 = ["13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00"];
        var new_hora_salida = _salida.split(":");

        
        var posicion_hora2 = hora12.indexOf(new_hora_salida[0]);

        
        var _hora_salida = hora24[posicion_hora2] +":" + new_hora_salida[1].replace("PM", ":00");

    } else {
        
        var _hora_salida = _salida.replace("AM", ":00");
         
    }

    var params = {
        accion: "insert_horario_admin",
        id_usuario: _id_usuario,
        dia: _dia,
        entrada: _hora_entrada,
        salida: _hora_salida
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageHorario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $('#modal1').modal('open');
            $("#modal_horario").text(dataRes);
            select_horario_tabla($("#id_seleccion").val(), "div_datos");
        }
    });
}
;
//==============================================================================

function select_horarios_combo(_tipo, _op_act, _id_caja) {
    var params = {
        accion: "select_horarios_combo",
        tipo: _tipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageHorario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option>'+ _op_act +'</option>' + dataRes);
            $('select').material_select();
        }
    });
};
//==============================================================================
function select_nombre_usuario(_id_usuario,_id_caja) {
    var params = {
        accion: "select_nombre_usuario",
        id_usuario:_id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageHorario",
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
