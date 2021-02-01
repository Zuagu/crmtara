//==============================================================================
function select_cotizaciones_tabla(_id_caja) {
    var params = {
        accion: "select_cotizaciones_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCotizaciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_datos_cliente_cotizacion(_folio) {
    var params = {
        accion: "select_datos_cliente_cotizacion",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCotizaciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            pasar_datos_cliente_cotizacion(dataRes);
        }
    });
}
;
//==============================================================================
function select_cuerpo_cotizacion(_folio, _id_caja) {
    var params = {
        accion: "select_cuerpo_cotizacion",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCotizaciones",
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
function select_importes_cotizacion(_folio) {
    var params = {
        accion: "select_importes_cotizacion",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCotizaciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            datos_imp = dataRes.split('+');
            $("#cot_subtotal").text(datos_imp[0]);
            $("#cot_iva").text(datos_imp[1]);
            $("#cot_total").text(datos_imp[2]);
            $("#cot_importeletra").text(datos_imp[3]);
            $("#cond_1").text(datos_imp[4]);
            $("#cond_2").text(datos_imp[5]);
            $("#cond_3").text(datos_imp[6]);
            $("#cond_4").text(datos_imp[7]);
            $("#cond_5").text(datos_imp[8]);
            $("#cond_6").text(datos_imp[9]);
            $("#cond_7").text(datos_imp[10]);
        }
    });
}
;
//==============================================================================
function pasar_datos_cliente_cotizacion(datos) {
    dato = datos.split('+');
    $("#cot_fecha").text(dato[0]);
    $("#cot_razon_social").text(dato[1]);
    $("#cot_rfc").text(dato[2]);
    $("#cot_direccion").text(dato[3]);
    $("#cot_telefonos").text(dato[4]);
    $("#cot_contacto").text(dato[5]);

}
;
//==============================================================================