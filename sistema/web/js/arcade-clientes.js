//==============================================================================
function insert_cliente(_razon_social, _rfc, _codigo_postal, _colonia, _calle, _num_ext, _num_int, _id_pais, _id_estado, _id_municipio, _telefonos, _email, _comentarios) {
    var params = {
        accion: "insert_cliente",
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
        url: "/sistema/ManageClientes",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            limpiar_formulario_alta();
            $("#listado_clientes").show("fast");
            $("#div_insert_cliente").hide("fast");
            select_clientes_tabla('listado_clientes');
        }
    });
}
;
//==============================================================================
function update_cliente(data) {
    var params = {
        accion: "update_cliente",
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
        url: "/sistema/ManageClientes",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
//==============================================================================
function delete_cliente(_id, _id_usuario) {
    var params = {
        accion: "delete_cliente",
        id: _id,
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_clientes_tabla('listado_clientes');
        }
    });
}
;
//==============================================================================
function select_clientes_combo(_id_caja, _seleccione) {
    var params = {
        accion: "select_clientes_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            if (_seleccione) {
                $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            }
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>' + dataRes);
        }
    });
}
;
//==============================================================================
function select_clientes_tabla(_id_caja) {
    var params = {
        accion: "select_clientes_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
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
function select_clientes_check(_id_caja) {
    var params = {
        accion: "select_clientes_check"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
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
function select_clientes_filtro(_filtro, _id_caja) {
    var params = {
        accion: "select_clientes_filtro",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
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
function select_datos_fiscales(_id_caja) {
    var params = {
        accion: "select_datos_fiscales"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_datos_fiscales_oc(_id_caja, _folio) {
    var params = {
        accion: "select_datos_fiscales_oc",
        folio: _folio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
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
function select_clientes_combo_materialize(_id_caja, _seleccione) {
    var params = {
        accion: "select_clientes_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageClientes",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//         $("#" + _id_caja).empty();
            if (_seleccione) {
                $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            }
            $("#" + _id_caja).append(dataRes);
            $('select').material_select();
        }
    });
}
;
//==============================================================================