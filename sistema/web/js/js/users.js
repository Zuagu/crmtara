
function select_usuarios(_box) {
    var params = {
        accion: "datos_usuarios"
    };
    $.ajax({
        url: '/sistema/ManageUsuario',
        type: 'POST',
        data: params,
        success: function (ress) {
            users = JSON.parse(ress);
            pintar_tabla_usuarios(users, _box);
        },
        error: function (err) {
//            console.log(err);
            $("#" + _box).append(err.responseText);
        }
    });
}

function pintar_tabla_usuarios(user_data, _box) {
    $("#" + _box).empty();
    var row_print = '<table id="tabla_usuarios" class="highlight striped"><thead><tr><th>Id</th><th>Nombre</th><th>Puesto</th><th>Fecha Alta</th><th>Celular</th><th>Jefe Inmediato</th><th>Estatus</th></thead><tbody>';
    for (var i in user_data) {
        row_print += '<tr id="' + i + '" class="row_user ' + user_data[i].active + '" style="' + (user_data[i].f_active == 0 ? "display:none; background-image: linear-gradient(rgba(255, 0, 0, 0.2), rgba(255, 255, 255, 0.77), rgba(255, 0, 0, 0.2));" : "") + '">';
        row_print += '<td>' + user_data[i].id + '</td>';
        row_print += '<td>' + user_data[i].nombre + '<br>' + user_data[i].sucursal + '</td>';
        row_print += '<td>' + user_data[i].puesto + '</td>';
        row_print += '<td>' + user_data[i].fecha_alta + '</td>';
        row_print += '<td>' + user_data[i].celular + '</td>';
        row_print += '<td>' + user_data[i].jefe + '</td>';
        row_print += '<td>' + user_data[i].active + '</td>';
        row_print += '</tr>';
        jefes[user_data[i].nombre] = null;
    }
    $("#" + _box).append(row_print);
    row_print += '</tbody></table>';
    console.log(users);
//    console.log(jefes);

}
var jefes = {};
var users = [], horarios = [];
var index_pos;
var ident_tr = 0;

window.onload = function () {
    select_usuarios('table_user');
    select_horarios();
};
// pintar datos del usuarios en el modal =========================================================================================================
function print_data_user_modal(index_pos) {
    $(".cont_img").css('background-image', 'url("image/icon-user.png")');
//    $(".fondo").css('background-image', 'url("image/users/fondo_time.png');
//    $(".fondo").css('background-size', '37%');
//    $(".fondo").css('background-repeat', 'no-repeat');
//    $(".fondo").css('background-position-x', 'right');
    $('#id_user').text(users[index_pos].id);
    $('#puesto').text(users[index_pos].puesto);
    $('#name').val(users[index_pos].nombre);
    $('#alias').val(users[index_pos].alias);
    $('#sexo').empty();
    $('#sexo').append('<option value="' + users[index_pos].sexo + '">' + users[index_pos].sexo1 + '</option>' + '<option value="H">Masculino</option><option value="M">Femenino</option>');
    $('#ingreso').val(users[index_pos].fecha_alta);
    $('#telefono').val(users[index_pos].telefono);
    $('#celular').val(users[index_pos].celular);
    $('#correo').val(users[index_pos].email);
    $('#jefe').val(users[index_pos].jefe);
    // $('#empleado').val(users[index_pos][17]);
    $('#empleado').empty();
    $('#empleado').append('<option value="' + users[index_pos].f_administrativo + '">' + users[index_pos].tipo + '</option><option value="1">Administrativo</option><option value="0">Operativo</option>');

    $('#sucursal').empty();
    $('#sucursal').append('<option value="' + users[index_pos].id_sucursal + '">' + users[index_pos].sucursal + '</option><option value="1">Monterrey</option><option value="2">Puebla</option>');
    $('#f_nacimiento').val(users[index_pos].f_nacimiento);
    $('#horario').val(users[index_pos].horario);

    $('#f_naci').prop('checked', (users[index_pos].acta === "true"));
    $('#ife').prop('checked', (users[index_pos].ife === "true"));
    $('#nss').prop('checked', (users[index_pos].nss === "true"));
    $('#fotos').prop('checked', (users[index_pos].fotos === "true"));
    $('#curp').prop('checked', (users[index_pos].curp === "true"));
    $('#com_est').prop('checked', (users[index_pos].comp_est === "true"));
    $('#com_dom').prop('checked', (users[index_pos].comp_dom === "true"));
    $('#carta').prop('checked', (users[index_pos].cartas === "true"));
    $('#no_infv').prop('checked', (users[index_pos].infonavit === "true"));
    $('#rfc').prop('checked', (users[index_pos].rfc === "true"));

    $('select').formSelect();
}
// funcion para abrir el modal ===================================================================================================================
$("#table_user").delegate('.row_user', 'click', function () {
    $('#modal1').modal("open");
    index_pos = $(this).closest("tr").attr("id");
    print_data_user_modal(index_pos);
    // $(".image_perfil").attr("src", "http://201.172.31.105:8080/sistema/images/usuarios/" + users[index_pos][0] + "-min.png");

});
// funciones para editar y guardar datos del usuarios ============================================================================================
$(".edit").click(function () {
    $(".edit").addClass("hide");
    $(".save").removeClass("hide");
    $(".input-field input").removeAttr("readonly");
});

$(".save").click(function () {
    $(".save").addClass("hide");
    $(".edit").removeClass("hide");
    $(".input-field input").attr("readonly", "readonly");
    $("#modal_alert").modal("open");
    $(".title").text("Atencion");
    $(".sms_alert").text("Guardar Cambios");
});
// funciones para eliminar usuario ============================================================================================
$(".eliminar").click(function () {
    alert();
    $.ajax({
        url: '/sistema/ManageUsuario', type: 'POST', data: {accion: "delete_usuario", id_usuario: users[index_pos].id},
        success: function (ress) {

        }
    });
});

// funciones horarios ============================================================================================================================
function select_horarios() {
    $.ajax({
        url: '/sistema/ManageUsuario', type: 'POST',
        data: {accion: "select_lista_horarios"},
        success: function (ress) {
            horarios = JSON.parse(ress);
//            console.log(horarios);
        }
    });
}
$("#horario").click(function () {
    $('#modal_schedules').modal("open");
    $('#h_name_user').text(users[index_pos].nombre);
    $("#select_schedules").empty();
    for (var i in horarios) {
        if (horarios[i].tipo_admin === users[index_pos].f_administrativo) {
            $("#select_schedules").append('<option value="' + horarios[i].descripcion + '">' + horarios[i].descripcion + '</option>');
        }
    }
    $.ajax({
        url: '/sistema/ManageUsuario', type: 'POST',
        data: {accion: "select_tabla_hoario", id_user: users[index_pos].id},
        success: function (ress) {
            var data_table = JSON.parse(ress);
            $("#body_table_horario").empty();
            for (var i in data_table) {
                $("#body_table_horario").append('<tr id=' + data_table[i].id_entrada + '>' +
                        '<td>' + data_table[i].dia + '</td>' +
                        '<td>' + data_table[i].hora_entrada + '</td>' +
                        '<td>' + data_table[i].hora_salida + '</td>' +
                        '<td>' + data_table[i].horas_trabajadas + '</td>' +
                        '<td>' + data_table[i].turno + '</td></tr>');
            }

        }
    });
    $('select').formSelect({container: "body"});
});

$("#update_horario").click(function () {
    $.ajax({
        url: '/sistema/ManageHorario', type: 'POST',
        data: {accion: "insert_horario", id_usuario: users[index_pos].id, select_horario: $("#select_schedules").val()},
        success: function (ress) {
//            console.log(ress);
            update_dataJSON();
            $('#horario').val($("#select_schedules").val());
            $('#modal_schedules').modal("close");
        }
    });
});

$("#create_schedules").click(function () {
    $("#modal_create_schedules").modal("open");
});

$("#insert_horario_especial").click(function () {
    $.ajax({
        url: '/sistema/ManageHorario', type: 'POST',
        data: {
            accion: "insert_horario_admin",
            id_usuario: users[index_pos].id,
            dia: $("#select_day").val(),
            entrada: $("#especial_entrada").val(),
            salida: $("#especial_salida").val()
        },
        success: function (ress) {
//            console.log(ress);
        }
    });
});

// funciones de avanzar y regrezar modal =========================================================================================================
$(".nex").click(function () {
    index_pos++;
    $('#modal1').modal("close");
    print_data_user_modal(index_pos);
    $('#modal1').modal("open");
});

$(".prev").click(function () {
    index_pos--;
    $('#modal1').modal("close");
    print_data_user_modal(index_pos);
    $('#modal1').modal("open");
});

// funciones para ver y actualizar formatos ======================================================================================================
function alert_format(data, name, name_property) {
    data_format = JSON.parse(data);
    $("#modal_formato").modal("open");
    $("#insert_format").attr("onclick", "update_format(users[index_pos]." + name_property + ", '" + name_property + "');");
    $("#nom_format").html(name);
    $("#data_format").empty();
    for (var i in data_format) {
        $('#data_format').append('<a class="collection-item">Numero: ' + data_format[i].numero + ' Fecha: ' + data_format[i].fecha + '</a>');
    }
}
function update_format(data, name) {
    data_format = JSON.parse(data);
    var MyDate = new Date();
    MyDate.setDate(MyDate.getDate());
    var MyDateString = MyDate.getFullYear() + '-' + ('0' + (MyDate.getMonth() + 1)).slice(-2) + '-' + ('0' + MyDate.getDate()).slice(-2);
    var new_data = {numero: (data_format.length + 1), fecha: MyDateString};
    data_format.push(new_data);
    $('#data_format').empty();
    for (var i in data_format) {
        $('#data_format').append('<a class="collection-item">Numero: ' + data_format[i].numero + ' Fecha: ' + data_format[i].fecha + '</a>');
    }
    $.ajax({
        url: '/sistema/ManageUsuario', type: 'POST',
        data: {accion: "update_formato", id_user: users[index_pos].id, col: name, datos: JSON.stringify(data_format)},
        success: function (ress) {
            update_dataJSON();
        },
        error: function (ress) {
//            console.log(ress);
        }
    });
    window.setTimeout(function () {
        $('#modal_formato').modal("close");
        window.open("formato_" + name + ".jsp", "_blank");
    }, 500);
}
// Actualizar Json front que contiene los datos de los usuarios   =========================================================================
function update_dataJSON() {
    $.ajax({
        url: '/sistema/ManageUsuario', type: 'POST', data: {accion: "datos_usuarios"},
        success: function (ress) {
            users = JSON.parse(ress);
        }
    });
}
// funcines para actualizar datos del Usuarios   =======================================================================================
$("#update_user").click(function () {
    var d = {
        accion: "update_data_user",
        id: users[index_pos].id,
        nombre: $("#name").val(),
        alias: $("#alias").val(),
        correo: $("#correo").val(),
        jefe: $("#jefe").val(),
        sexo: $("#sexo").val(),
        fecha_nacimiento: $("#f_nacimiento").val(),
        tipo_epleado: $("#empleado").val(),
        fecha_ingreso: $("#ingreso").val(),
        telefono: $("#telefono").val(),
        celular: $("#celular").val(),
        sucursal: $("#sucursal").val(),
        acta_nacimiento: $("#f_naci").prop("checked"),
        ife: $("#ife").prop("checked"),
        nss: $("#nss").prop("checked"),
        fotos: $("#fotos").prop("checked"),
        curp: $("#curp").prop("checked"),
        comprovante_est: $("#com_est").prop("checked"),
        comprovante_dom: $("#com_dom").prop("checked"),
        carta: $("#carta").prop("checked"),
        no_infanavit: $("#no_infv").prop("checked"),
        rfc: $("#rfc").prop("checked")
    };
    console.log(d);
//    $.ajax({
//        url: '/sistema/ManageUsuario', type: 'POST', 
//        data: {
//            accion: "update_data_user",
//            nombre: $("#name").val(),
//            alias: $("#alias").val(),
//            correo: $("#correo").val(),
//            jefe: $("#jefe").val(),
//            sexo: $("#sexo").val(),
//            fecha_nacimiento: $("#f_nacimiento").val(),
//            tipo_epleado: $("#empleado").val(),
//            fecha_ingreso: $("#ingreso").val(),
//            telefono: $("#telefono").val(),
//            celular: $("#celular").val(),
//            sucursal: $("#sucursal").val()
//        },
//        success: function (ress) {
//            users = JSON.parse(ress);
//        }
//    });
    $('#modal_alert').modal("close");
});

// Cambiar Puesto =====================================================================================
$("#puesto").click(function () {
    $('#modal_puestos').modal("open");
    $.ajax({
        url: '/sistema/ManageUsuario', type: 'POST', data: {accion: "arcade_select_puesto"},
        success: function (ress) {
            list_puesto = JSON.parse(ress);
            print_puestos();
        }
    });
    $('.collapsible').collapsible();
});
// funcion de pintar lista de puestos
function print_puestos() {
    $(".collapsible").empty();
    var old_puesto = list_puesto[0].departamento, cont = "";
    for (var i in list_puesto) {
        if (list_puesto[i].departamento != old_puesto) {
            $(".collapsible").append('<li> <div class="collapsible-header"><i class="material-icons">filter_drama</i>' + old_puesto + '</div><div class="collapsible-body"><div class="collection">' + cont + '</div></div></li>');
            old_puesto = list_puesto[i].departamento;
            cont = "";
        }
        cont += '<a class="collection-item" id="' + list_puesto[i].id_puesto + '"><span class="badge">' + list_puesto[i].vacantes_cubiertas + '/' + list_puesto[i].vacantes + '</span>' + list_puesto[i].puesto + '</a>';
    }
}
function print_vacantes() {
    $("#list_vacantes").empty();
    for (var i in data_vacante) {
        $("#list_vacantes").append('<tr id="' + data_vacante[i].id_vacante + '">' +
                '<td>' + data_vacante[i].vacante + '</td>' +
                '<td>' + data_vacante[i].usuario + '</td>' +
                '<td>' + data_vacante[i].fecha_creacion_vacante + '</td>' +
                '<td>' + data_vacante[i].fecha_asignacion_usuario + '</td>' +
                '</tr>');
    }
}
// click de los puestos
$(".caja_puesto").delegate(".collection-item", "click", function () {
    $("#modal_user_puestos").modal("open");
    $("#name_puesto").text($(this).text());
    var _id_puesto = $(this).attr("id");
    $("#id_puesto_modal_puestos").val(_id_puesto);
    $.ajax({
        url: '/sistema/ManageVacante', type: 'POST', data: {accion: "select_data_vacante", id_puesto: _id_puesto},
        success: function (ress) {
            data_vacante = JSON.parse(ress);
            print_vacantes();
        }
    });

});
// UPDATE DATOS DE LA VARIABLE data_vacante y pintar coll\place
$("#update_puesto").click(function () {
    alert("puesto: " + $("#id_puesto_modal_puestos").val() + " id_vacante: " + $(".select_vacante").attr("id") + " id_usuario: " + users[index_pos].id);
    // ligica de reasignar o asignar vacante dependiendo del status del usuario
    // estamos trabajndo en esto
    var params = {};
    if (users[index_pos].f_active === "1") {
        params = {
            accion: "reasignar_vacante",
            puesto: $("#id_puesto_modal_puestos").val(),
            vacante: $(".select_vacante").attr("id"),
            usuario_id: users[index_pos].id,
            sueldo: "0.00"
        };
    } else {
        params = {
            accion: "udpate_id_usuario_vacante",
            id_vacante: $(".select_vacante").attr("id"),
            id_usuario: users[index_pos].id,
            sueldo: "0.00"
        };
    }
    console.log(params);
    $.ajax({
        url: '/sistema/ManageVacante', type: 'POST',
        data: params,
        success: function () {
            $.ajax({
                url: '/sistema/ManageVacante', type: 'POST',
                data: {accion: "select_data_vacante", id_puesto: $("#id_puesto_modal_puestos").val()},
                success: function (ress) {
                    data_vacante = JSON.parse(ress);
                    print_vacantes();
                }
            });
        }
    });
});

$("#btn_nueva_vacante").click(function () {
    $("#modal_nueva_vacante").modal("open");
});

$("#btn_insert_vacante").click(function () {
    // si el campo esta vacio no inserta nada
    if ($("#name_vacante").val() != "") {
        $.ajax({
            url: '/sistema/ManageVacante', type: 'POST',
            data: {accion: "insert_vacante", vacante: $("#name_vacante").val(), id_puesto: $("#id_puesto_modal_puestos").val()},
            success: function (ress) {
                $.ajax({
                    url: '/sistema/ManageVacante', type: 'POST',
                    data: {accion: "select_data_vacante", id_puesto: $("#id_puesto_modal_puestos").val()},
                    success: function (ress) {
                        data_vacante = JSON.parse(ress);
                        print_vacantes();
                    }
                });
                $("#modal_nueva_vacante").modal("close");
            }
        });
    } else {
    }
});
$("#btn_delete_vacante").click(function () {
    $("#modal_delete_vacante").modal("open");
});
$("#btn_confirm_delete_vacante").click(function () {
    $.ajax({
        url: '/sistema/ManageVacante', type: 'POST', data: {accion: "delete_vacante", id_vacante: $(".select_vacante").attr("id")},
        success: function (ress) {

            $.ajax({
                url: '/sistema/ManageVacante', type: 'POST',
                data: {accion: "select_data_vacante", id_puesto: $("#id_puesto_modal_puestos").val()},
                success: function (ress) {
                    data_vacante = JSON.parse(ress);
                    print_vacantes();
                }
            });
        }
    });
    $("#modal_delete_vacante").modal("close");
});
$("#btn_close_vacantes").click(function () {
    $("#btn_delete_vacante").addClass("disabled");
    $("#update_puesto").addClass("disabled");
    $("#modal_user_puestos").modal("close");
});
// selected ==============================================================================================================================
$("#modal_user_puestos").delegate('tbody tr', 'click', function () {
    $("tr").removeClass("select_vacante");
    $(this).addClass("select_vacante");
    $("#btn_delete_vacante").removeClass("disabled");
    $("#update_puesto").removeClass("disabled");
});
// funcion de Agregar nuevo Usuario =======================================================================================================
$("#btn_add_user").click(function () {
    $.ajax({
        url: 'ControllerUsuario',
        type: 'POST',
        dataType: "json",
        data: {
            action: "add_user",
            nombre_m: $("#nombre_m").val(),
            alias_m: $("#alias_m").val(),
            telefono_m: $("#telefono_m").val(),
            celular_m: $("#celular_m").val(),
            email_m: $("#email_m").val(),
            sexo_m: $("#sexo_m").val(),
            puesto_m: $("#puesto_m").val(),
            jefe_m: $("#jefe_m").val()

        },
        success: function (ress) {
            console.log(ress);
            console.log(ress['mensaje']);
            if (ress.response === 'ok') {
                $("#nombre_m").val('');
                $("#alias_m").val('');
                $("#telefono_m").val('');
                $("#celular_m").val('');
                $("#email_m").val('');
                $("#sexo_m").val('');
                $("#puesto_m").val('');
                $("#jefe_m").val('');
                $("#sms_agregado").empty();
                $("#sms_agregado").append(ress['mensaje']);

            } else {
                $("#sms_agregado").empty();
                $("#sms_agregado").append(ress['mensaje']);

            }

        },
        error: function (error) {
            console.log(error);

            $("#sms_agregado").empty();
            $("#sms_agregado").append(error.responseText);
        }
    });
});
$('#modal_nuevo_usuario input').click( function () {
    $("#sms_agregado").empty();
});
// funcion de filtro =====================================================================================================================
function hide_inactives() {
    var inac = document.querySelectorAll(".INACTIVO");
//    console.l
//    og(inac);
    for (var i = 0; i < inac.length; i++) {
        var row = inac[i];
        row.style.display = 'none';
    }
}
;

function select_puestos_disponobles() {
    let params = {
        action: 'select_puestos_disponobles'
    };
    $.ajax({
        type: "POST",
        url: "ControllerUsuario",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);

        },
        error: function (error) {
            console.log(error);
        }
    });
}

document.querySelector("#buscador_cuentas_gestor").onkeyup = function () {
    if (this.value === "") {
        hide_inactives();
    } else {
        $TableFilter("#tabla_usuarios", this.value);
    }
};
$TableFilter = function (id, value) {
    var rows = document.querySelectorAll(id + ' tbody tr');
    for (var i = 0; i < rows.length; i++) {
        var showRow = false;
        var row = rows[i];
        row.style.display = 'none';
        for (var x = 0; x < row.childElementCount; x++) {
            if (row.children[x].textContent.toLowerCase().indexOf(value.toLowerCase().trim()) > -1) {
                showRow = true;
                break;
            }
        }
        if (showRow) {
            row.style.display = null;
        }
    }
};

