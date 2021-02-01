function mover_reloj(_hora) {

    if (_hora == '00:00:00') {
        select_hora_server('hora_server');
    }

    var Digital = $('#hora_server').val().split(':');

    var hours = parseInt(Digital[0]);
    var minutes = parseInt(Digital[1]);
    var seconds = parseInt(Digital[2]) + 1;

    if (minutes == 45 && seconds == 1) {
        select_hora_server('hora_server');
        var Digital = $('#hora_server').val().split(':');

        var hours = parseInt(Digital[0]);
        var minutes = parseInt(Digital[1]);
        var seconds = parseInt(Digital[2]) + 1;
    }

    if (seconds == 60) {
        seconds = "0";
        minutes = minutes + 1;
        if (minutes == 60) {
            minutes = 0;
            hours = hours + 1;
            if (hours == 12) {
                hours = 0;
            }
        }
    }
    if (hours > 12)
        hours = hours - 12;
    if (hours <= 9)
        hours = "0" + hours;
    if (minutes <= 9)
        minutes = "0" + minutes;
    if (seconds <= 9)
        seconds = "0" + seconds;

    $('#hora_server').val(hours + ":" + minutes + ":" + seconds);


    setTimeout(function () {
        mover_reloj(hours + ":" + minutes + ":" + seconds);
    }, 1000);
}
;
// =============================================================================
function select_hora_server(_id_input) {
    var params = {
        accion: "select_hora_server"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $('#' + _id_input).val(dataRes);
        }
    });
}
;
// =============================================================================
function insert_registro(_id, id_caja) {
    var params = {
        accion: "insert_registro",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#id").val('');
            $("#" + id_caja).empty();
            $("#" + id_caja).append(dataRes);
            $("#id").focus();
        }
    });
}
;
// =============================================================================
function insert_registro_2(_id, id_caja) {
    var params = {
        accion: "insert_registro_2",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
           
        }
    });
}
;// =============================================================================
function select_nombre_entradas(_id, id_caja) {
    var params = {
        accion: "select_nombre_entrada",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            partir_datos(dataRes, 'dato', 1);
            insert_registro_2(_id, id_caja);
        }
    });
}
;

//==============================================================================
function partir_datos(dataRes, _campo, forlimit) {
        var campos = dataRes.split("#and#");
        console.log(campos);
        for (i = 0; i <= forlimit; i++) {
            console.log("#" + _campo + i + " valor { "+ campos[i] + " }");
            $("#" + _campo + i).empty();
            $("#" + _campo + i).text(campos[i]);
        }
    }