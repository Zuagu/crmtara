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
            console.log(err);
            $("#" + _box).append(err.responseText)
        }
    });
}

function pintar_tabla_usuarios(user_data, _box) {
    $("#" + _box).empty();
    var row_print = '<table id="tabla_usuarios" class="highlight striped responsive-table"><thead><tr><th>Id</th><th>Nombre</th><th>Puesto</th><th>Fecha Alta</th><th>Celular</th><th>Jefe Inmediato</th><th>Estatus</th></thead><tbody>';
    for (i in user_data) {
        row_print += '<tr id="' + i + '" class="row_user">';
        for (x in user_data[i]) {
            if (x < 7) {
                if (x == 1) {
                    row_print += '<td>' + user_data[i][x] + '<br>' + user_data[i][18] + '</td>';
                } else {
                    row_print += '<td>' + user_data[i][x] + '</td>';
                }

            }
        }
        row_print += '</tr>';
    }
    $("#" + _box).append(row_print);
    row_print += '</tbody></table>'
    console.log(users)
}

var users = [];
var index_pos, suspencion = [];
var ident_tr = 0;
$(document).ready(function () {
    $('.modal').modal({
        dismissible: true,
        inDuration: 500,
        outDuration: 250
    });
    $('.tabs').tabs();
    $('select').formSelect();
    select_usuarios('table_user');
    $('.datepicker').datepicker({
        format: "yyyy-mm-dd"
    });

});

function print_data_user_modal(index_pos) {
    $(".cont_img").css('background-image', 'url("http://201.172.31.105:8080/sistema/images/usuarios/' + users[index_pos][0] + '-min.png")');
    $('#id_user').text(users[index_pos][0]);
    $('#puesto').text(users[index_pos][2]);
    $('#name').val(users[index_pos][1]);
    $('#alias').val(users[index_pos][7]);
    $('#sexo').empty();
    $('#sexo').append('<option value="' + users[index_pos][15] + '">' + users[index_pos][14] + '</option>' + '<option value="H">Masculino</option><option value="M">Femenino</option>');
    $('#ingreso').val(users[index_pos][3]);
    $('#telefono').val(users[index_pos][13]);
    $('#celular').val(users[index_pos][4]);
    $('#correo').val(users[index_pos][8]);
    $('#jefe').val(users[index_pos][5]);
    // $('#empleado').val(users[index_pos][17]);
    $('#empleado').empty();
    $('#empleado').append('<option value="' + users[index_pos][17] + '">' + users[index_pos][16] + '</option><option value="1">Administrativo</option><option value="0">Operativo</option>');

    $('#sucursal').empty();
    $('#sucursal').append('<option value="' + users[index_pos][9] + '">' + users[index_pos][18] + '</option><option value="1">Monterrey</option><option value="2">Puebla</option>');
    $('#f_nacimiento').val(users[index_pos][19]);
    $('#horario').val(users[index_pos][30]);

    suspencion = JSON.parse(users[index_pos][31]);
    console.log(suspencion);

    $('#f_naci').prop('checked', (users[index_pos][20] == "true"));
    $('#ife').prop('checked', (users[index_pos][21] == "true"));
    $('#nss').prop('checked', (users[index_pos][22] == "true"));
    $('#fotos').prop('checked', (users[index_pos][23] == "true"));
    $('#curp').prop('checked', (users[index_pos][24] == "true"));
    $('#com_est').prop('checked', (users[index_pos][25] == "true"));
    $('#com_dom').prop('checked', (users[index_pos][26] == "true"));
    $('#carta').prop('checked', (users[index_pos][27] == "true"));
    $('#no_infv').prop('checked', (users[index_pos][28] == "true"));
    $('#rfc').prop('checked', (users[index_pos][29] == "true"));

    $('select').formSelect();
}

$("#table_user").delegate('.row_user', 'click', function () {
    $('#modal1').modal("open");
    index_pos = $(this).closest("tr").attr("id");
    print_data_user_modal(index_pos);
    // $(".image_perfil").attr("src", "http://201.172.31.105:8080/sistema/images/usuarios/" + users[index_pos][0] + "-min.png");

});

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

$("#horario").click(function () {
    alert();
});

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

$("#suspencion").click(function () {
    $('#modal_formato').modal("open");
    $("#insert_format").attr("onclick", "update_suspencion(30);");
    $('#nom_format').html($(this, ".nom_docx").text());
    $('#data_format').empty();
    for (i in suspencion) {
        console.log(suspencion[i]);
        $('#data_format').append('<a class="collection-item">Numero: ' + (i) + ' Fecha: ' + suspencion[i].fecha + '</a>');
    }
});
function update_suspencion(puntero) {
    var MyDate = new Date();
    MyDate.setDate(MyDate.getDate());
    var MyDateString = MyDate.getFullYear() + '-' + ('0' + (MyDate.getMonth() + 1)).slice(-2) + '-' + ('0' + MyDate.getDate()).slice(-2);
    var datos = {numero: suspencion.length, fecha: MyDateString};
    suspencion.push(datos);
    // alert(JSON.stringify(suspencion));
    $('#data_format').empty();
    for (i in suspencion) {
        console.log(suspencion[i]);
        $('#data_format').append('<a class="collection-item">Numero: ' + (i) + ' Fecha: ' + suspencion[i].fecha + '</a>');
    }

}


document.querySelector("#filtro").onkeyup = function () {
    $TableFilter("#tabla_usuarios", this.value);
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