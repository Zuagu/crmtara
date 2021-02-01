$(document).on('ready', function () {
    var costume = Math.floor(Math.random() * 3) + 1;
//    $("#box_image").empty();
//    $("#box_image").append('<img class="width_100" src="image/incomark.png">');
    $("#iniciar_sesion").addClass('button_log' + costume);

//    $.getJSON('https://api.ipify.org?format=json', function (data) {
////                    console.log(data.ip);
//        $("#ip").val(data.ip);
//    });
    

});
//==============================================================================
$("#iniciar_sesion").click(function () {
    iniciar_sesion();
});
//==============================================================================
$("#password").keyup(function (e) {
    if (e.keyCode == 13) {
        iniciar_sesion();
    }
});
//==============================================================================
function iniciar_sesion() {
    $("#iniciar_sesion").hide();
    $("#cargando").show();
    if ($("#password").val() == "" || $("#id_usuario").val() == "") {
        alert("INGRESE TODOS LOS DATOS REQUERIDOS.");
        $("#iniciar_sesion").show();
        $("#cargando").hide();
    } else {
        var params = {
            action: "iniciar_sesion",
            id_perfil: $("#id_perfil").val(),
            id_usuario: $("#id_usuario").val(),
            password: $("#password").val(),
            ip: $("#ip").val()
        };
        console.log(params);
        $.ajax({
            type: "POST",
            url: "/sistema/ControllerUsuario",
            data: params,
            dataType: "html",
            success: function (dataRes) {
                mostrar_alerta(dataRes);
            }
        });
    }
}
;
//==============================================================================
function mostrar_alerta(dataRes) {
    if (dataRes == 0) {
        alert("FALTA CHECAR ENTRADA");
        $("#cargando").hide();
        $("#iniciar_sesion").show();
    }
    if (dataRes == 1) {
        document.login.submit();
    }
    if (dataRes == 2) {
        alert("YA TIENE UNA SESION INICIADA, SOLO PUEDE TENER UNA A LA VEZ.");
        $("#cargando").hide();
        $("#iniciar_sesion").show();
    }
    if (dataRes == 3) {
        alert("CONTRASEÑA ERRONEA. FAVOR DE VERIFICAR.");
        $("#cargando").hide();
        $("#iniciar_sesion").show();
    }
    if (dataRes == 4) {
        alert("EMPLEADO INACTIVO. FAVOR DE VERIFICAR.");
        $("#cargando").hide();
        $("#iniciar_sesion").show();
    }
    if (dataRes == 5) {
        alert("USUARIO NO EXISTE");
        $("#cargando").hide();
        $("#iniciar_sesion").show();
    }
    if (dataRes == 6) {
        alert("HA ALCANZADO NUMERO MAXIMO DE USUARIOS EN SU LICENCIA.\n\
\n\
SOLICITE AL ADMINSITRADOR UNA LICENCIA PARA MAS USUARIOS.\n\
");

        $("#cargando").hide();
        $("#iniciar_sesion").show();
    }
}
;

//==============================================================================
function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

//==============================================================================

