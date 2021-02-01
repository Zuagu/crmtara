
function select_activos(_id_caja, _opcion) {
    var params = {
        accion: "select_activos",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_activos_total(_id_caja, _opcion) {
    var params = {
        accion: "select_activos_total",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_entrevista(_id_caja, _opcion) {
    var params = {
        accion: "select_entrevista",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_bajas(_id_caja, _opcion) {
    var params = {
        accion: "select_bajas",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            window.setTimeout(() => {
                rotacion_chunung();
                rotacion_chunung_2();
            }, 300);
        }
    });
}
;
//==============================================================================
function select_usuarios_activos(_id_caja) {
    var params = {
        accion: "select_activos" //modificar la llamada para traer los nombres de los usuarios activos de operaciones
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_usuarios_bajas(_id_caja) {
    var params = {
        accion: "select_bajas" //modificar llamada para traer los nombres de las bajas 
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_permanencia(_id_caja, _desde, _hasta, _opcion, _usuario) {
    var params = {
        accion: "select_permanencia",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion,
        usuario: _usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
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
function select_datos_informe_vacantes(_desde, _hasta) {
    var params = {
        accion: "select_datos_informe_vacantes",
        desde: _desde,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "text",
        success: function (dataRes) {
            partir_datos_pintar(dataRes);
            rango_fecha_pintar(_desde, _hasta);
        }
    });
}
;
//==============================================================================
function select_ingresos_rango(_id_caja, _desde, _hasta, _opcion, _usuario) {
    var params = {
        accion: "select_ingresos_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion,
        usuario: _usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
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
function select_bajas_rango(_id_caja, _desde, _hasta, _opcion, _usuario) {
    var params = {
        accion: "select_bajas_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion,
        usuario: _usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
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
function select_entrevistas_rango(_id_caja, _desde, _hasta, _opcion, _usuario) {
    var params = {
        accion: "select_entrevistas_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion,
        usuario: _usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
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
function select_tabla_citados(_id_caja, _desde, _hasta, _usuario) {
    var params = {
        accion: "select_tabla_citados",
        desde: _desde,
        hasta: _hasta,
        usuario: _usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
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
function select_citados_rango(_id_caja, _desde, _hasta, _opcion, _usuario) {
    var params = {
        accion: "select_citados_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion,
        usuario: _usuario
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
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
function insert_cita(_usuario_sistema, _nombre, _medio, _especificaMedio, _fecha, _hora, _desc) {
    var params = {
        accion: "insert_cita",
        usuario_sistema: _usuario_sistema,
        nombre: _nombre,
        medio: _medio,
        especificaMedio: _especificaMedio,
        fecha: _fecha,
        hora: _hora,
        desc: _desc
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
        data: params,
        dataType: "html",
        success: function (dataRes) {

            $('#modal7').modal('close');
            $('#modal_alert').modal('open');
            $('#titulo').text("Estado de resgistro");
            $('#mensaje_estatus').text(dataRes);
            select_tabla_citados("citados", "0000-00-00", "0000-00-00", $('#usuario_sistema', parent.document).val());

        }
    });
}
;
//==============================================================================
function select_grafica_entrevistas(_opcion ,_desde, _hasta, _id) {
    var params = {
        accion: "select_grafica_entrevistas",
        opcion: _opcion,
        desde: _desde,
        hasta: _hasta,
        id: _id
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageDashboardReclutador",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            container(dataRes);
        }
    });
};
//==============================================================================
function container(dataRes) {
    console.log(dataRes);
    datos = dataRes.split(",#");
    var datos_para_grafica = [];

    console.log(datos);
    for (var i = 0; i < datos.length - 1; i++) {
        datos_para_grafica[i] = datos[i].split(",");
    }
    console.log(datos_para_grafica);

    for (var i = 1; i < datos.length - 1; i++) {
        datos_para_grafica[i] = datos_para_grafica[i].map(Number);
    }
    console.log(datos_para_grafica[0]);
    console.log(datos_para_grafica[1]);
    console.log(datos_para_grafica[2]);
    console.log(datos_para_grafica[3]);
    console.log(datos_para_grafica[4]);
    console.log(datos_para_grafica[5]);
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Entrevistas',
            useHTML: true
        },
        subtitle: {
            text: '',
            useHTML: true
        },
        xAxis: {
            categories: datos_para_grafica[0], // yo modifique a qui emmanuel
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Solicitudes'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
                name: 'Aprobado',
                data: datos_para_grafica[1]

            }, {
                name: 'Caido',
                data: datos_para_grafica[2]

            }, {
                name: 'No Aplica',
                data: datos_para_grafica[3]

            }, {
                name: 'No Evaluado',
                data: datos_para_grafica[4]

            }, {
                name: 'Stand By',
                data: datos_para_grafica[5]

            }]
    });

}
;
//==============================================================================