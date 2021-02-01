//==============================================================================
function insert_proveedor(_razon_social, _rfc, _codigo_postal, _colonia, _calle, _num_ext, _num_int, _id_pais, _id_estado, _id_municipio, _telefonos, _email, _comentarios) {
    var params = {
        accion: "insert_proveedor",
        razon_social: _razon_social,
        rfc: _rfc,
        codigo_postal: _codigo_postal,
        colonia: _colonia,
        calle: _calle,
        num_ext: _num_ext,
        num_int: _num_int,
        id_pais: _id_pais,
        id_estado: _id_estado,
        id_municipio: _id_municipio,
        telefonos: _telefonos,
        email: _email,
        comentarios: _comentarios
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            limpiar_formulario_alta();
            $("#listado_proveedores").show("fast");
            $("#div_insert_proveedor").hide("fast");
            select_proveedores_tabla('listado_proveedores');
        }
    });
}
;
//==============================================================================
function update_proveedor(data) {
    var params = {
        accion: "update_proveedor",
        id: data[0],
        razon_social: data[1],
        rfc: data[2],
        colonia: data[3],
        calle: data[4],
        num_ext: data[5],
        num_int: data[6],
        telefonos: data[7],
        email: data[8],
        comentarios: data[9]
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
//==============================================================================
function delete_proveedor(_id, _id_usuario) {
    var params = {
        accion: "delete_proveedor",
        id: _id,
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_proveedores_tabla('listado_proveedores');
        }
    });
}
;
//==============================================================================
function select_proveedores_combo(_id_caja) {
    var params = {
        accion: "select_proveedores_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
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
function select_proveedores_tabla(_id_caja) {
    var params = {
        accion: "select_proveedores_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
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
function select_proveedores_filtro(_filtro, _id_caja) {
    var params = {
        accion: "select_proveedores_filtro",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
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
function select_datos_proveedor(_id) {
    var params = {
        accion: "select_datos_proveedor",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            pasar_datos_proveedor(dataRes);
        }
    });
}
;
//==============================================================================
function pasar_datos_proveedor(datos) {
    dato = datos.split('+');
    $("#p_razon_social").text(dato[1]);
    $("#p_rfc").text(dato[2]);
    $("#p_direccion").text(dato[3]);
    $("#p_telefonos").text(dato[4]);
    $("#p_contacto").text(dato[5]);
}
;
//==============================================================================
function limpiar_formulario_alta() {
    $("#razon_social").val('');
    $("#rfc").val('');
    $("#codigo_postal").val('');
    $("#colonia").val('');
    $("#calle").val('');
    $("#num_ext").val('');
    $("#num_int").val('');
    $("#id_pais").val(0);
    $("#telefonos").val('');
    $("#email").val('');
    $("#comentarios").val('');
}
;
//==============================================================================
function cuerpo_estado_de_cuenta(_id, _id_caja) {
    var params = {
        accion: "cuerpo_estado_de_cuenta",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
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
function select_importes_edc(_id) {
    var params = {
        accion: "select_importes_edc",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            datos_imp = dataRes.split('+');
            $("#edc_cargos").text(datos_imp[1]);
            $("#edc_abonos").text(datos_imp[2]);
            $("#edc_saldo").text(datos_imp[3]);
        }
    });
}
;
//==============================================================================
function cuerpo_estado_de_cuenta_deudaactual(_id, _id_caja) {
    var params = {
        accion: "cuerpo_estado_de_cuenta_deudaactual",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
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
function select_importes_edc_deudaactual(_id) {
    var params = {
        accion: "select_importes_edc_deudaactual",
        id: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProveedores",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            datos_imp = dataRes.split('+');
            $("#edc_cargos").text(datos_imp[1]);
            $("#edc_abonos").text(datos_imp[2]);
            $("#edc_saldo").text(datos_imp[3]);
        }
    });
}
;
//==============================================================================
