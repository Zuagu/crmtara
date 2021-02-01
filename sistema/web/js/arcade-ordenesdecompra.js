//==============================================================================
function select_ordenes_tabla(_id_caja) {
    var params = {
        accion: "select_ordenes_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
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
function select_datos_proveedor_orden(_folio) {
    var params = {
        accion: "select_datos_proveedor_orden",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            pasar_datos_proveedor_orden(dataRes);
        }
    });
}
;
//==============================================================================
function select_cuerpo_orden(_folio, _id_caja) {
    var params = {
        accion: "select_cuerpo_orden",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
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
function select_cuerpo_orden_requisicion(_id_requisicion, _id_caja) {
    var params = {
        accion: "select_cuerpo_orden_requisicion",
        folio: _id_requisicion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            var lv = 0;
            $('#cuerpo_orden  > tr').each(function () {
                $(this).closest('tr').find('.lv').text(lv + 1);
                lv++;
            });
        }
    });
}
;
//==============================================================================
function select_importes_orden(_folio) {
    var params = {
        accion: "select_importes_orden",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
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

            $("#firma1").attr('src', 'images/firma' + datos_imp[11] + '.png');
            $("#firma2").attr('src', 'images/firma' + datos_imp[12] + '.png');
            $("#firma3").attr('src', 'images/firma' + datos_imp[13] + '.png');
        }
    });
}
;
//==============================================================================
function pasar_datos_proveedor_orden(datos) {
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
function update_orden_compra(_folio, _id_usuario, _f_autorizado) {
    var params = {
        accion: "update_orden_compra",
        folio: _folio,
        id_usuario: _id_usuario,
        f_autorizado: _f_autorizado
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_ordenes_tabla("listado_ordenes");
        }
    });
}
;
//==============================================================================
function update_factura_orden(_id_oc, _factura) {
    var params = {
        accion: "update_factura_orden",
        id_oc: _id_oc,
        factura: _factura
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================
function update_fecha_factura_orden(_id_oc, _fecha_factura) {
    var params = {
        accion: "update_fecha_factura_orden",
        id_oc: _id_oc,
        fecha_factura: _fecha_factura
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageOrdenesDeCompra",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================