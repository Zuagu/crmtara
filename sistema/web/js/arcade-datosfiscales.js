//==============================================================================
function update_datos_fiscales(_nombre_comercial, _razon_social, _rfc, _colonia, _calle_y_num, _codigo_postal, _municipio, _estado, _telefonos, _pagina_web) {
    var params = {
        accion: "update_datos_fiscales",
        nombre_comercial: _nombre_comercial,
        razon_social: _razon_social,
        rfc: _rfc,
        colonia: _colonia,
        calle_y_num: _calle_y_num,
        codigo_postal: _codigo_postal,
        municipio: _municipio,
        estado: _estado,
        telefonos: _telefonos,
        pagina_web: _pagina_web
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#nombre_comercial").val('');
            $("#razon_social").val('');
            $("#rfc").val('');
            $("#colonia").val('');
            $("#calle_y_num").val('');
            $("#codigo_postal").val('');
            $("#municipio").val('');
            $("#estado").val('');
            $("#telefonos").val('');
            $("#pagina_web").val('');
        }
    });
}
//==============================================================================