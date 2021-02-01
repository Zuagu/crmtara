//==============================================================================
function select_datos_metricas_operativas(_id_region, _desde, _hasta) {
    var params = {
        accion: "select_datos_metricas_operativas",
        id_region: _id_region,
        desde: _desde,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageMetricasOperativas",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            partir_datos(dataRes, "dato", 32);
        }
    });
}
;
//==============================================================================
function partir_datos(dataRes, _campo, _forlimit) {
    var campos = dataRes.split("#AND#");
    for (i = 1; i <= _forlimit; i++) {
        $("#" + _campo + i).text(campos[i]);
    }
}
;