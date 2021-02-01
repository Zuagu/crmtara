/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function () {
    select_usuarios('listado_gestores');
    select_equipo_tabla('div_equipos');
    select_territorio_options();
    
    $('#id_equipo').val(0);
    $('#filtro').addClass('hide');
};


$('#div_equipos').on('click', '.row_equipos', function () {
    $('#id_equipo').val($('.id_equipo', this).text());
    $('#id_equi_select').empty();
    $('#id_equi_select').append(`${$('.nombre_equipo', this).text()}`);
    select_usarios_equipo('listado_gestores_equipo', $('.id_equipo', this).text());
});

$('#div_equipos').on('dblclick', '.row_equipos', function () {
    $('#crear_equipo').addClass('hide');
    $('#agregar_mas_cuentas_equipo').removeClass('hide');
    $('#modal_asignar_cuentas').modal('open');
});

$('#listado_gestores').on('click', '.row_gestor', function () {
    let id_equipo = $('#id_equipo').val();
//    console.log(id_equipo);
    if (id_equipo === '0' || id_equipo === '') {
        $('#alerta_message').modal('open');
        $('#title_message').empty();
        $('#title_message').append(`Alerta`);
        $('#cont_message').empty();
        $('#cont_message').append(`No se ha selecionado ningun equipo`);

    } else {
        $('#id_ges_select').empty();
        $('#id_ges_select').append(`${$('.nombre_gestor', this).text()}`);
        agregar_gestor_a_equipo($('.id_gestor', this).text(), id_equipo);
    }
});

$('#listado_gestores_equipo').on('click', '.eliminar_gestor', function () {

    let id_equipo = $('#id_equipo').val();
    let id_gestor = $(this).parent().attr('id').replace('_eu', '');
    eliminar_gestor_de_equipo(id_gestor, id_equipo);
});

$('#op_territorio').change(function () {
    let op_territorio = JSON.stringify($('#op_territorio').val()).replace(/\[|]/gi, "");
    console.log(op_territorio);
    select_gerente_options(op_territorio);
});

$('#op_gerente').change(function () {
    let op_gerente = JSON.stringify($('#op_gerente').val()).replace(/\[|]/gi, "");
    console.log(op_gerente);
    select_etapas_options(op_gerente);
});

$('#op_etapa').change(function () {
    let op_etapa = JSON.stringify($('#op_etapa').val()).replace(/\[|]/gi, "");
    console.log(op_etapa);
});

$('#crear_equipo').click(function () {
    let op_territorio = JSON.stringify($('#op_territorio').val()).replace(/\[|]/gi, "");
    let op_gerente = JSON.stringify($('#op_gerente').val()).replace(/\[|]/gi, "");
    let op_etapa = JSON.stringify($('#op_etapa').val()).replace(/\[|]/gi, "");
    if (op_territorio.length !== 0 && op_gerente.length !== 0 && op_etapa.length !== 0) {
        $('#nombre_equipo').modal('open');
    } else {
        $('#alerta_message').modal('open');
        $('#title_message').empty();
        $('#title_message').append(`Alerta`);
        $('#cont_message').empty();
        $('#cont_message').append(`Falta completar una de las siguentes opciones:<br> [ Territorio ]  [ Gerente ]  [ Etapa ]`);
    }

});

$('#asignar_cuentas').click(function () {
    $('#agregar_mas_cuentas_equipo').addClass('hide');
    $('#crear_equipo').removeClass('hide');
});

$('#crear_equipo_enviar').click(function () {
    $('#alerta_message').modal('open');
    $('#title_message').empty();
    $('#title_message').append(`Completando Proceso`);
    $('#cont_message').empty();
    $('#cont_message').append(`<div class="preloader-wrapper big active"><div class="spinner-layer spinner-blue-only">
        <div class="circle-clipper left"><div class="circle"></div></div><div class="gap-patch"><div class="circle">
        </div></div><div class="circle-clipper right"><div class="circle"></div></div></div></div>`);
    let nombre = $('#nom_equipo').val();
    crear_equipo(nombre);
});

$('#agregar_mas_cuentas_equipo').click(function () {
    let op_territorio = JSON.stringify($('#op_territorio').val()).replace(/\[|]/gi, "");
    let op_gerente = JSON.stringify($('#op_gerente').val()).replace(/\[|]/gi, "");
    let op_etapa = JSON.stringify($('#op_etapa').val()).replace(/\[|]/gi, "");
    let id_equipo = $('#id_equipo').val();
    if (op_territorio.length !== 0 && op_gerente.length !== 0 && op_etapa.length !== 0) {
        $('#alerta_message').modal('open');
        $('#title_message').empty();
        $('#title_message').append(`Completando Proceso`);
        $('#cont_message').empty();
        $('#cont_message').append(`<div class="preloader-wrapper big active"><div class="spinner-layer spinner-blue-only">
            <div class="circle-clipper left"><div class="circle"></div></div><div class="gap-patch">
            <div class="circle"></div></div><div class="circle-clipper right"><div class="circle"></div></div></div></div>`);
        agregar_nuevas_cuentas_equipo(op_territorio, op_gerente, op_etapa, id_equipo);
    } else {
        $('#alerta_message').modal('open');
        $('#title_message').empty();
        $('#title_message').append(`Alerta`);
        $('#cont_message').empty();
        $('#cont_message').append(`Falta completar una de las siguentes opciones:<br> [ Territorio ]  [ Gerente ]  [ Etapa ]`);
    }

});









//==============================================================================
function select_usuarios(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    let params = {
        action: "select_usuarios",
        filtro: ""
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerUsuario",
        data: params,
        dataType: "json",
        success: function (users) {
            $("#" + _div).empty();
            for (let user of users) {
                $("#" + _div).append(`<tr class='row_gestor'>
                    <td class='id_gestor'>${user.id}</td>
                    <td class='nombre_gestor'>${user.nombre}</td>
                </tr>`);
            }
        }
    });
}

//==============================================================================
function agregar_gestor_a_equipo(_id_gestor, _id_equipo) {
    let params = {
        action: "agregar_gestor_a_equipo",
        id_gestor: _id_gestor,
        id_equipo: _id_equipo
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            select_equipo_tabla('div_equipos');
            select_usarios_equipo('listado_gestores_equipo', $('#id_equipo').val());
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
//==============================================================================
function select_equipo_tabla(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    let params = {
        action: "select_equipo_tabla"
    };
//    console.log(params); // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (equipos) {
            $("#" + _div).empty();
            for (let equipo of equipos) {
//                console.log(equipo);
                $("#" + _div).append(`<tr class='row_equipos'>
                    <td class='id_equipo'>${equipo.ID_EQUIPO}</td>
                    <td class='nombre_equipo'>${equipo.NOMBRE_EQUIPO}</td>
                    <td>${equipo.DESCRIPCION}</td>
                    <td>${equipo.CUENTAS}</td>
                    <td>${equipo.VALOR}</td>
                </tr>`);
            }
        }
    });
}
//==============================================================================
function select_usarios_equipo(_div, _id_equipo) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    let params = {
        action: "select_usarios_equipo",
        id_equipo: _id_equipo
    };
//    console.log(params); // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (users) {
            $("#" + _div).empty();
            for (let user of users) {
                $("#" + _div).append(`<tr id='${user.id}_eu' class='row_gestor'>
                    <td class='id_gestor'>${user.id}</td>
                    <td class='nombre_gestor'>${user.nombre}</td>
                    <td class='eliminar_gestor'><a><i class="material-icons">close</i></a></td>
                </tr>`);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
//==============================================================================
function eliminar_gestor_de_equipo(_id_gestor, _id_equipo) {
    let params = {
        action: "eliminar_gestor_de_equipo",
        id_gestor: _id_gestor,
        id_equipo: _id_equipo
    };
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            select_equipo_tabla('div_equipos');
            select_usarios_equipo('listado_gestores_equipo', $('#id_equipo').val());
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);

        }
    });
}
//==============================================================================
function select_territorio_options() {
    let params = {
        action: "select_territorio_options"
    };
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#op_territorio').empty();
            $('#op_territorio').append(`<option value="0" disabled selected>Selecciona</option>`);
            for (let territorio of response) {
                $('#op_territorio').append(`<option value="${territorio}">${territorio}</option>`);
            }
            $('select').formSelect();

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);

        }
    });
}
//==============================================================================
function select_gerente_options(_territorio) {
    let params = {
        action: "select_gerente_options",
        territorio: _territorio
    };
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#op_gerente').empty();
            $('#op_gerente').append(`<option value="0" disabled selected>Selecciona</option>`);
            for (let gerente of response) {
                $('#op_gerente').append(`<option value="${gerente}">${gerente}</option>`);
            }
            $('select').formSelect();

        },
        error: function (error) {
            console.log(error);

        }
    });
}
//==============================================================================
function select_etapas_options(_gerente) {
    let op_territorio = JSON.stringify($('#op_territorio').val()).replace(/\[|]/gi, "");
    let params = {
        action: "select_etapas_options",
        territorio: op_territorio,
        gerente: _gerente
    };
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#op_etapa').empty();
            $('#op_etapa').append(`<option value="0" disabled selected>Selecciona</option>`);
            for (let etapa of response) {
                $('#op_etapa').append(`<option value="${etapa}">${etapa}</option>`);
            }
            $('select').formSelect();

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);

        }
    });
}
//==============================================================================
function crear_equipo(_nombre_equipo) {
    let params = {
        action: "crear_equipo",
        nombre_equipo: _nombre_equipo
    };
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            
            $('#nombre_equipo').modal('close');
            agregar_cuentas_equipo();
//            console.log(response);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
//==============================================================================
function agregar_cuentas_equipo() {
    let op_etapa = JSON.stringify($('#op_etapa').val()).replace(/\[|]/gi, "");
    let op_gerente = JSON.stringify($('#op_gerente').val()).replace(/\[|]/gi, "");
    let op_territorio = JSON.stringify($('#op_territorio').val()).replace(/\[|]/gi, "");
    let params = {
        action: "agregar_cuentas_equipo",
        territorio: op_territorio,
        gerente: op_gerente,
        etapa: op_etapa
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            select_equipo_tabla('div_equipos');
            $('#alerta_message').modal('close');
            $('#title_message').empty();
            $('#cont_message').empty();
//            console.log(response);
        },
        error: function (error) {
            console.log(error);

        }
    });
}
//==============================================================================
function agregar_nuevas_cuentas_equipo(op_territorio, op_gerente, op_etapa, op_id_equipo) {
    let params = {
        action: "agregar_nuevas_cuentas_equipo",
        territorio: op_territorio,
        gerente: op_gerente,
        etapa: op_etapa,
        id_equipo: op_id_equipo
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            select_equipo_tabla('div_equipos');
//            console.log(response);
            $('#modal_asignar_cuentas').modal('close');
            $('#alerta_message').modal('close');
            $('#title_message').empty();
            $('#cont_message').empty();
        },
        error: function (error) {
            console.log(error);

        }
    });
}