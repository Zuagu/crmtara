//==============================================================================
function select_categorias(_id_caja) {
    var params = {
        accion: "select_categorias_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategorias",
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
function select_categorias_combo(_id_caja) {
    var params = {
        accion: "select_categorias_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategorias",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_categoria_cliente_combo(_id_usuario, _id_caja) {
    var params = {
        accion: "select_categoria_cliente_combo",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategorias",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            select_productos_categoria_combo($("#id_categoria").val(), "id_producto"); /* SOLO PARA TG*/
        }
    });
}
;
//==============================================================================
function select_categorias_laser_combo(_id_caja) {
    var params = {
        accion: "select_categorias_laser_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategorias",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_productos_categoria(_id_categoria, _id_caja) {
    var params = {
        accion: "select_productos_categoria_tabla",
        id_categoria: _id_categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
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
function select_productos_categoria_corte(_id_categoria, _id_caja) {
    var params = {
        accion: "select_productos_categoria_tabla_corte",
        id_categoria: _id_categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
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
function select_productos_categoria_combo(_id_categoria, _id_caja) {
    var params = {
        accion: "select_productos_categoria_combo",
        id_categoria: _id_categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
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
function insert_producto(_id_producto, _id_categoria, _nombre, _descripcion, _id_unidadmedida, _cantidad_minima, _id_moneda, _id_tasa, _preciosiniva, _iva, _precio, _f_comprable) {
    var params = {
        accion: "insert_producto",
        id_producto: _id_producto,
        id_categoria: _id_categoria,
        nombre: _nombre,
        descripcion: _descripcion,
        id_unidadmedida: _id_unidadmedida,
        cantidad_minima: _cantidad_minima,
        id_moneda: _id_moneda,
        id_tasa: _id_tasa,
        precio_sin_iva: _preciosiniva,
        iva: _iva,
        precio: _precio,
        f_comprable: _f_comprable
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_productos_categoria(0, "listado_productos");

            $("#listado_productos").show("fast");
            $('#agregar_producto').hide("fast");
        }
    });
}
;
//==============================================================================
function insert_categoria(_categoria) {
    var params = {
        accion: "insert_categoria",
        categoria: _categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategorias",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_categorias("listado_categorias");
            select_categorias_combo("insert_id_categoria");
        }
    });
}
;
//==============================================================================
function update_categoria(_id) {
    alert(_id);
}
;
//==============================================================================
function delete_categoria(_id) {
    var params = {
        accion: "delete_categoria",
        id_categoria: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageCategorias",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_categorias("listado_categorias");
        }
    });
}
;
//==============================================================================
function delete_producto(_id) {
    var params = {
        accion: "delete_producto",
        id_producto: _id
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_productos_categoria(0, "listado_productos");
        }
    });
}
;
//==============================================================================
function calcular_precio1() {
    var a = parseFloat($("#insert_preciosiniva").val());
    var b;
    var c;
    var iva = parseFloat($("#insert_id_tasa").val() / 100);
    b = a * iva;
    c = a + b;
    b = b.toFixed(2);
    c = c.toFixed(2);
    $("#insert_iva").val(b);
    $("#insert_precio").val(c);
}
;
//==============================================================================
function calcular_precio2() {
    var a;
    var b;
    var c = parseFloat($("#insert_precio").val());
    var iva = parseFloat($("#insert_id_tasa").val() / 100);
    a = c / (iva + 1);
    b = a * iva;
    a = a.toFixed(2);
    b = b.toFixed(2);
    $("#insert_preciosiniva").val(a);
    $("#insert_iva").val(b);
}
;
//==============================================================================
function update_calibre(_id, _calibre) {
    var params = {
        accion: "update_calibre",
        id_producto: _id,
        calibre: _calibre
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================
function update_perimetro(_id, _perimetro) {
    var params = {
        accion: "update_perimetro",
        id_producto: _id,
        perimetro: _perimetro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================
function update_area(_id, _area) {
    var params = {
        accion: "update_area",
        id_producto: _id,
        area: _area
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================
function update_tiempo(_id, _tiempo) {
    var params = {
        accion: "update_tiempo",
        id_producto: _id,
        tiempo: _tiempo

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================
function update_inicios(_id, _inicios) {
    var params = {
        accion: "update_inicios",
        id_producto: _id,
        inicios: _inicios
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageProductos",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
;
//==============================================================================