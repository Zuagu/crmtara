//==============================================================================
function agregar_producto_requisicion(_cantidad, _id_producto) {
    var params = {
        accion: "agregar_producto_requisicion",
        cantidad: _cantidad,
        id_producto: _id_producto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRequisiciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var lv = 0;
            $("#cuerpo_requisicion").append(dataRes);
            $("#cantidad").val('1');
            $('#cuerpo_requisicion  > tr').each(function () {
                $(this).closest('tr').find('.lv').text(lv + 1);
                lv++;
            });
        }
    });
}
;
//==============================================================================
function insert_requisicion(_usuario_sistema, _fecha_requerida, _f_urgente, _comentarios, _lineas_requisicion) {
    var params = {
        accion: "insert_requisicion",
        usuario_sistema: _usuario_sistema,
        fecha_requerida: _fecha_requerida,
        f_urgente: _f_urgente,
        comentarios: _comentarios,
        lineas_requisicion: _lineas_requisicion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageRequisiciones",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#encabezado").hide();
            $("#todo").hide();
            $("#formato_requisicion").show();
            $("#folio").val(dataRes);

            select_cuerpo_requisicion($("#folio").val(), 'cot_cuerpo_requisicion');
            select_detalles_documento($("#folio").val());
        }
    });
}
;
//==============================================================================