function select_datos_entradas(_region, _fecha) {
    var params = {
        accion: "select_datos_entradas",
        region: _region,
        fecha: _fecha
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            pintar_tabla_entradas(dataRes);
//            alert(dataRes);
        }
    });
}
//======================================================================
function pintar_tabla_entradas(dataRes) {
    usuarios = JSON.parse(dataRes);
//    console.log(usuarios);
    $('#cuerpo_tabla').empty();
    for (var i = 0; i < usuarios.length; i++) {
//        var cooo =  usuarios[i].comentario;
//        console.log(cooo);
        $('#cuerpo_tabla').append('<tr id="' + i + '" class="entra_usu ' + usuarios[i].status + '"><td>' + usuarios[i].id + '</td><td>' + usuarios[i].nombre + '</td><td>' + usuarios[i].entrada + '</td><td>' + usuarios[i].salida + '</td><td>'+ ( usuarios[i].comentario != "" ? '<i class="material-icons">info_outline</i>' : '' ) + '</td> </tr>');
    }

//    $(".entra_usu").dblclick(function () {
    $(".entra_usu").click(function () {
        var posicion = $(this).closest("tr").attr("id");
        $("#datos_usu").empty();
        $("#datos_usu").append(usuarios[posicion].nombre);

        $("#entrada").val(usuarios[posicion].entrada);

        $("#salida").val(usuarios[posicion].salida);
        $("#comentario").val(usuarios[posicion].comentario);

        $("#id_usuario").val(usuarios[posicion].id);
        $("#registro").val(usuarios[posicion].registro);

        $("#foto_usuario").empty();
        $("#foto_usuario").append("<img class='imagen z-depth-3' src='images/usuarios/" + usuarios[posicion].id + "-min.png' width='80%'>");


        $("#modal_update").modal('open');

    });

}
//======================================================================
function update_hora_emtrada(_registro, _nueva_h_entrada, _nueva_h_salida, _status) {
    
    var params = {
        accion: "update_hora_emtrada",
        registro: _registro,
        nueva_h_entrada: _nueva_h_entrada,
        nueva_h_salida: _nueva_h_salida,
        status: _status
    };
        console.log(params);
    
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_datos_entradas(0, "0000-00-00");
        }
    });
}
//======================================================================
function insert_comentarios(_comentario, _registro) {
    var params = {
        accion: "insert_comentarios",
        comentario: _comentario,
        registro: _registro
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_datos_entradas(0, "0000-00-00");
            $("#modal_status").modal('open');
        }
    });
}