//==============================================================================
function agregar_producto_cotizacion(_cantidad, _id_producto) {
    var params = {
        accion: "agregar_producto_cotizacion",
        cantidad: _cantidad,
        id_producto: _id_producto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCotizaciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var lv = 0;
            $("#cuerpo_cotizacion").append(dataRes);
            $("#cantidad").val('1');
            $('#cuerpo_cotizacion  > tr').each(function () {
                $(this).closest('tr').find('.lv').text(lv + 1);
                lv++;
            });
            actualizar_importe_venta();
        }
    });
}
;
//==============================================================================
function actualizar_importe_venta() {
    var _subtotal = 0;
    var _iva = 0;
    var _total = 0;
    $('#cuerpo_cotizacion  > tr').each(function () {
        _subtotal = _subtotal + parseFloat($(this).closest('tr').find('input.importe').val());
        _iva = _subtotal * .16;
        _total = _subtotal + _iva;
    });
    $("#subtotal").val(_subtotal.toFixed(2));
    $("#iva").val(_iva.toFixed(2));
    $("#total").val(_total.toFixed(2));
}
;
//==============================================================================
function insert_cotizacion(_usuario_sistema, _id_cliente, _subtotal, _iva, _total, _id_formapago, _numero_parcialidades, _id_metodopago, _cuenta_pago, _id_condicionespago, _dias_credito, _lugar_entrega, _comentarios, _lineas_cotizacion
        ) {
    var params = {
        accion: "insert_cotizacion",
        usuario_sistema: _usuario_sistema,
        id_cliente: _id_cliente,
        subtotal: _subtotal,
        iva: _iva,
        total: _total,
        id_formapago: _id_formapago,
        numero_parcialidades: _numero_parcialidades,
        id_metodopago: _id_metodopago,
        cuenta_pago: _cuenta_pago,
        id_condicionespago: _id_condicionespago,
        dias_credito: _dias_credito,
        lugar_entrega: _lugar_entrega,
        comentarios: _comentarios,
        lineas_cotizacion: _lineas_cotizacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCotizaciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#encabezado").hide();
            $("#todo").hide();
            $("#formato_cotizacion").show();
            $("#folio").val(dataRes);

            select_datos_cliente_cotizacion($("#folio").val());
            select_cuerpo_cotizacion($("#folio").val(), 'cot_cuerpo_cotizacion');
            select_importes_cotizacion($("#folio").val());
        }
    });
}
;
//==============================================================================