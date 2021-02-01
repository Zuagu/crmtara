//==============================================================================
function comas_chunun(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
//==============================================================================
function datos_regiones(_id_caja) {
    var params = {
        accion: "datos_regiones"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            pintar_datos_globales(dataRes);
        }
    });
}
;
//==============================================================================
function pintar_datos_globales(dataRes) {
    var datos_globales = JSON.parse(dataRes);
//    console.log(datos_globales);

    $("#mty_cuentas").text("Cuentas: " +  datos_globales["MONTERREY"].cuentas);
    $("#mty_total").text("$ " + comas_chunun(datos_globales["MONTERREY"].a_gestionar.toFixed(2))); 
    $("#mty_resto").text("$ " + comas_chunun( datos_globales["MONTERREY"].resto.toFixed(2)));

    $("#pue_cuentas").text("Cuentas: " + datos_globales["PUEBLA"].cuentas);
    $("#pue_total").text("$ " + comas_chunun(datos_globales["PUEBLA"].a_gestionar.toFixed(2)));
    $("#pue_resto").text("$ " + comas_chunun(datos_globales["PUEBLA"].resto.toFixed(2)));

    $("#chi_cuentas").text("Cuentas: " + datos_globales["CHIHUAHUA"].cuentas);
    $("#chi_total").text("$ " + comas_chunun(datos_globales["CHIHUAHUA"].a_gestionar.toFixed(2)));
    $("#chi_resto").text("$ " + comas_chunun(datos_globales["CHIHUAHUA"].resto.toFixed(2)));

    var tot_cuentas = 0;
    var tot_resto = 0;
    var tot_a_gestionar = 0.00;
    for (region in datos_globales) {
        tot_a_gestionar = tot_a_gestionar + datos_globales[region].a_gestionar;
        tot_cuentas = tot_cuentas + datos_globales[region].cuentas;
        tot_resto = tot_resto + datos_globales[region].resto;
    }

    $("#glob_cuentas").text("Cuentas: " + tot_cuentas);
    $("#glob_total").text("$ " +comas_chunun( tot_a_gestionar.toFixed(2)));
    $("#glob_resto").text("$ " + comas_chunun( tot_resto.toFixed(2)));
}



//==============================================================================
function select_estatus_regiones(_id_caja) {
    var params = {
        accion: "estatus_regiones"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var datos = JSON.parse(dataRes);
            console.log(datos);

            $("#" + _id_caja).empty();

            for (i in datos) {
                $("#" + _id_caja).append('<div class=" col s6">' +
                        '<label  for="_' + i + '" >' + i + ': ' + datos[i].cuentas + '</label>' +
                        '<input id="_' + i + '" type="text" placeholder="" value="$ ' + comas_chunun(datos[i].resto) + '" class="center-align">' +
                        '</div>'
                        );
            }

        }
    });
}
;
//==============================================================================
function estatus_region(_id_caja, _id_region) {
    var params = {
        accion: "estatus_region",
        id_region: _id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var datos = JSON.parse(dataRes);
//            console.log(datos);

            $("#" + _id_caja).empty();

            for (i in datos) {
                $("#" + _id_caja).append('<div class=" col s6">' +
                        '<label  for="_' + i + '" >' + i + ': ' + datos[i].cuentas + '</label>' +
                        '<input id="_' + i + '" type="text" placeholder="" value="$ ' + comas_chunun(datos[i].resto) + '" class="center-align">' +
                        '</div>'
                        );
            }
        }
    });
}
;
//==============================================================================

function datos_asignacion(_id_caja, _id_region) {
    var params = {
        accion: "datos_asignacion",
        id_region: _id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
           
            $("#" + _id_caja ).empty();
            $("#" + _id_caja ).append(dataRes);
        }
    });
}
;
//==============================================================================
function estatus_asignacion(_id_caja, _id_asignacion) {
    var params = {
        accion: "estatus_asignacion",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var datos = JSON.parse(dataRes);
//            console.log(datos);

            $("#" + _id_caja).empty();

            for (i in datos) {
                $("#" + _id_caja).append('<div class=" col s6">' +
                        '<label  for="_' + i + '" >' + i + ': ' + datos[i].cuentas + '</label>' +
                        '<input id="_' + i + '" type="text" placeholder="" value="$ ' +comas_chunun(datos[i].resto) + '" class="center-align">' +
                        '</div>'
                        );
            }
        }
    });
}
;
//==============================================================================
function select_caja_asignaciones(_id_caja, _tiempo, _id_region) {
    var params = {
        accion: "select_caja_asignaciones",
        tiempo: _tiempo,
        id_region: _id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja ).empty();
            $("#" + _id_caja ).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_caja_estados(_id_caja, _cadena_asignaciones) {
    var params = {
        accion: "select_caja_estados",
        cadena_asignaciones: _cadena_asignaciones
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja ).empty();
            $("#" + _id_caja ).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_caja_status(_id_caja, _cadena_asignaciones, _cadena_estados) {
    var params = {
        accion: "select_caja_status",
        cadena_asignaciones: _cadena_asignaciones,
        cadena_estados: _cadena_estados
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja ).empty();
            $("#" + _id_caja ).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_tabla_predictivo(
        _cadena_asignaciones,
        _cadena_estados,
        _cadena_status,
        _cadena_tipo_numero,
        _cr,
        _resto,
        _desde,
        _id_caja
    ) {
    var params = {
        accion: "select_tabla_predictivo",
        cadena_asignaciones:_cadena_asignaciones,
        cadena_estados:_cadena_estados,
        cadena_status:_cadena_status,
        cadena_tipo_numero:_cadena_tipo_numero,
        cr:_cr,
        resto:_resto,
        desde:_desde
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManagePredictivo",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja ).empty();
            $("#" + _id_caja ).append(dataRes);
            
            var num = document.getElementById("tabla_predictivo").rows.length;
            console.log(num);
            $("#info").text( num + " Registros Devueltos ");
        }
    });
}
;
//==============================================================================