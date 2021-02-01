//==============================================================================
function insert_nodo_organigrama(_desc_nodo, _id_padre) {
    var params = {
        accion: "insert_nodo_organigrama",
        descripcion: _desc_nodo,
        id_padre: _id_padre
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            console.log(dataRes);
            alert(dataRes);
            select_nodos_organigrama(0, "div_organigrama");
        }
    });
}
//==============================================================================
function delete_nodo_organigrama(_id_padre) {
    var params = {
        accion: "delete_nodo_organigrama",
        id_padre: _id_padre
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            console.log(dataRes);
            alert(dataRes);
            select_nodos_organigrama(0, "div_organigrama");
        }
    });
}
//==============================================================================
function select_nodos_organigrama(_id_nodo, _id_caja) {
    var params = {
        accion: "select_nodos_organigrama",
        id_padre: _id_nodo

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function update_nodo_organigrama(_id_nodo, _descripcion) {
    var params = {
        accion: "update_nodo_organigrama",
        id_nodo: _id_nodo,
        descripcion: _descripcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}
//==============================================================================
function select_tipos_nodo(_id_caja) {
    var params = {
        accion: "select_tipos_nodo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function delete_tipo_nodo_organigrama(_id_tipo_nodo) {
    var params = {
        accion: "delete_tipo_nodo_organigrama",
        id_tipo_nodo: _id_tipo_nodo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_tipos_nodo("tipos_nodo");
            select_tipos_nodo_combo("id_tipo_nodo");
            select_tipos_nodo_combo("id_tipo_nodo2");
        }
    });
}
//==============================================================================
function insert_tipo_nodo(_tipo_nodo) {
    var params = {
        accion: "insert_tipo_nodo",
        tipo_nodo: _tipo_nodo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_tipos_nodo("tipos_nodo");
            select_tipos_nodo_combo("id_tipo_nodo");
            select_tipos_nodo_combo("id_tipo_nodo2");
        }
    });
}
//==============================================================================
function select_tipos_nodo_combo(_id_caja) {
    var params = {
        accion: "select_tipos_nodo_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function insert_contenido_tipo_nodo(_id_tipo_nodo, _descripcion) {
    var params = {
        accion: "insert_contenido_tipo_nodo",
        id_tipo_nodo: _id_tipo_nodo,
        descripcion: _descripcion

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_contenidos_tipo_nodo($("#id_tipo_nodo").val(), "div_contenidos_tipo_nodo");
        }
    });
}
//==============================================================================
function select_contenidos_tipo_nodo(_id_tipo_nodo, _id_caja) {
    var params = {
        accion: "select_contenidos_tipo_nodo",
        id_tipo_nodo: _id_tipo_nodo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function delete_contenido_tipo_nodo(_id_tipo_nodo) {
    var params = {
        accion: "delete_contenido_tipo_nodo",
        id_tipo_nodo: _id_tipo_nodo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_contenidos_tipo_nodo($("#id_tipo_nodo").val(), "div_contenidos_tipo_nodo");
        }
    });
}
//==============================================================================
function insert_contenidos_nodo(_id_nodo, _id_tipo_nodo) {
    var params = {
        accion: "insert_contenidos_nodo",
        id_nodo: _id_nodo,
        id_tipo_nodo: _id_tipo_nodo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_contenidos_nodo($("#id_padre").val(), "contenidos_nodo");
        }
    });
}
//==============================================================================
function select_contenidos_nodo(_id_nodo, _id_caja) {
    var params = {
        accion: "select_contenidos_nodo",
        id_nodo: _id_nodo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
//==============================================================================
function update_contenido_nodo(_id_contenido, _contenido) {
    var params = {
        accion: "update_contenido_nodo",
        id_contenido: _id_contenido,
        contenido: _contenido
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNodosOrganigrama",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
        }
    });
}