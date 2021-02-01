window.onload = function () {

    sic_vacantes_organigrama();
};
$(".puesto").click(function () {
    var params = {
        action: "select_lista_usuarios_vacantes",
        id_puesto: $(this).attr("id")
    };
    select_lista_usuarios_vacantes(params, "tbody_puestos");
    $('.titulo_puesto').empty();
    $('.titulo_puesto').append($(this).text());
    $("#id_puesto_selected").val(params.id_puesto);
});
$("#ver_modal_controller").click(function () {
    $("#div_controller_puestos").modal("open");
    select_organigrama("tbody_vacantes");

});
$("#tbody_vacantes").delegate('.reload', 'click', function () {
//    alert($(this).parent().attr("class"));
//    console.log( $("#puesto" + $(this).parent().attr("class") + " .nvacante").val() );
    let params = {
        action: "update_numero_vacantes",
        id_puesto: $(this).parent().attr("class"),
        vacantes: $("#puesto" + $(this).parent().attr("class") + " .nvacante").val()
    };
    update_numero_vancantes(params);

});

$("#addGestor").click(function () {
    select_lista_usuario();
});

$("#addUserVac").click(function () {
    $(".filtro_gestor").val("");
    select_lista_gestores();

});

$("#tbody_lista_gestores").delegate(".gestor", "click", function () {
    let params = {
        action: "asignar_puesto_vacante",
        id_user: $(".id", this).html(),
        id_puesto: $("#id_puesto_selected").val()
    };
    asignar_puesto_vacante(params);

});

$("#filtro_gestor").on("keyup",
        function () {
            select_lista_gestores_filtro($('#filtro_gestor').val(), "tbody_lista_gestores");
        }
);

$("#tbody_puestos").on("click", ".gestores", function () {
    $(".gestores").removeClass("selected");
    $(this).addClass("selected");
    $("#id_user_selected").val($(".id", this).text());

});
$("#deleteUserVac").on("click", function () {
    eliminar_usuario_vacante($("#id_user_selected").val());
});





//Funciones 
function sic_vacantes_organigrama() {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: {action: "sic_vacantes_organigrama"},
        dataType: "json",
        success: function (data) {
            console.log(data);
            for (var i in data) {
                $("#" + data[i].id_puesto + " p").empty();
                $("#" + data[i].id_puesto).append("<p>" + data[i].cant_usuarios + "/" + data[i].vacantes + "</p>");

            }
        }
    });
}

function select_lista_usuarios_vacantes(params, _div) {

    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: params,
        dataType: "json",
        success: function (data) {
            $("#" + _div).empty();
            for (var i in data) {
                $("#" + _div).append(
                        '<tr id="' + data[i].id + '" class="gestores" style="cursor:pointer;" >' +
                        '<td style="width:15%; text-align: center;"><img class="img_gestores" src="http://gruposicsa.com/fotos/' + data[i].id + '.jpg"></td>' +
                        '<td class="id">' + data[i].id + '</td>' +
                        '<td>' + data[i].nombre + '</td>' +
                        '<td>' + data[i].puesto + '</td>' +
                        '<td>' + data[i].fecha_ingreso + '</td>' +
                        '<td>' + data[i].horario + '</td>' +
                        '</tr>'
                        );
            }
            $("#div_puestos").modal("open");
        }
    });
}
function select_organigrama(_div) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: {action: "select_organigrama"},
        dataType: "json",
        success: function (data) {
            // console.log(data);
            $("#" + _div).empty();
            for (var i in data) {
                $("#" + _div).append(
                        '<tr id="puesto' + data[i].id_puesto + '" style="cursor:pointer;" >' +
                        '<td>' + data[i].puesto + '</td>' +
                        '<td><input type="number"  class="nvacante width_input_vac" value="' + data[i].vacantes + '" onkeypress=" return isNumberKey(event)" ></td>' +
                        '<td><b>' + data[i].ocupado + '</b></td>' +
                        '<td><b>' + (data[i].vacantes - data[i].ocupado) + '</b></td>' +
                        '<td class="' + data[i].id_puesto + '"><a class="waves-effect waves-light btn blue reload"><i class="material-icons right">autorenew</i></a></td>' +
                        '</tr>'
                        );

            }
        }
    });
}

function update_numero_vancantes(_params) {
    // console.log(_params);
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: _params,
        dataType: "json",
        success: function (data) {
            alert(data.mensaje);
            sic_vacantes_organigrama();
            select_organigrama("tbody_vacantes");

        }
    });
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function select_lista_gestores() {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: {action: "select_lista_gestores"},
        dataType: "json",
        success: function (data) {
            $("#div_lista_gestores").modal("open");
            $("#tbody_lista_gestores").empty();
            data.map((usuario) => {
                //console.log(usuario);
                $("#tbody_lista_gestores").append(
                        '<tr class="gestor">' +
                        '<td style="width:15%; text-align: center;"></td>' +
                        '<td class="id">' + usuario["id"] + '</td>' +
                        '<td>' + usuario["nombre"] + '</td>' +
                        '<tr>'
                        );
            });


        }
    });
}

function select_lista_gestores_filtro(_filtro) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: {action: "select_lista_gestores_filtro",
            filtro: _filtro},
        dataType: "json",
        success: function (data) {
            $("#div_lista_gestores").modal("open");
            $("#tbody_lista_gestores").empty();
            data.map((usuario) => {
                //console.log(usuario);
                $("#tbody_lista_gestores").append(
                        '<tr class="gestor" style="cursor:pointer;">' +
                        '<td style="width:15%; text-align: center;"><img class="img_gestores" src="http://gruposicsa.com/fotos/' + usuario["id"] + '.jpg"></td>' +
                        '<td class="id">' + usuario["id"] + '</td>' +
                        '<td>' + usuario["nombre"] + '</td>' +
                        '<tr>'
                        );
            });
        }
    });
}

function asignar_puesto_vacante(_params) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: _params,
        dataType: "json",
        success: function (data) {
            sic_vacantes_organigrama();
//            select_lista_usuarios_vacantes(_params.id_puesto, "tbody_puestos");
            $("#div_lista_gestores").modal("close");
            var params = {
                action: "select_lista_usuarios_vacantes",
                id_puesto: $("#id_puesto_selected").val()
            };
            select_lista_usuarios_vacantes(params, "tbody_puestos");
            
        }
    });
}
function eliminar_usuario_vacante(_id_usuario) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerOrganigrama",
        data: {
            action: "eliminar_usuario_vacante",
            id_usuario: _id_usuario,
            id_puesto: $("#id_puesto_selected").val()
        },
        dataType: "json",
        success: function (data) {
            $("#id_user_selected").val("");
            sic_vacantes_organigrama();
            var params = {
                action: "select_lista_usuarios_vacantes",
                id_puesto: $("#id_puesto_selected").val()
            };
            select_lista_usuarios_vacantes(params, "tbody_puestos");
            //tabla_gestiones var totalRowCount = table.rows.length;
        }
    });
}












