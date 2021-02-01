//==============================================================================
function select_gestor_tabla_control(_id_caja) {
    var params = {
        accion: "select_gestor_tabla_control"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
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
function select_gestor_tabla_control_filtro(_filtro, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_gestor_tabla_control_filtro",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#" + $("#id_gestor").val()).addClass('agregar_gestor_selected');
        }
    });
}
;
//==============================================================================
function select_gestor_tabla_filtro(_filtro, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_gestor_tabla_filtro",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).css("cursor", "default");
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_gestor_combo(_id_caja) {
    var params = {
        accion: "select_gestor_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
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
function insert_gestor(_id_gestor, _gestor, _id_caja) {
    var params = {
        accion: "insert_gestor",
        id_gestor: _id_gestor,
        gestor: _gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_gestor_tabla(_id_caja);
            select_gestor_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_gestor(_id_gestor, _gestor) {
    var params = {
        accion: "update_gestor",
        id_gestor: _id_gestor,
        gestor: _gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_gestor(_id_gestor, _id_caja) {
    var params = {
        accion: "delete_gestor",
        id_gestor: _id_gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_gestor_tabla(_id_caja);
            select_gestor_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_f_bloqueado(_id_gestor, _id_caja) {
    var params = {
        accion: "update_f_bloqueado",
        id_gestor: _id_gestor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            if (_id_caja == "panel") {
                select_gestor_panel_tabla("panel");
           } else {
                select_gestor_tabla_control_filtro("", _id_caja);
            }
        }
    });
}
;
//==============================================================================
function select_gestor_panel_tabla(_id_caja) {
    var params = {
        accion: "select_gestor_panel_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
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
function update_crs_gestor(_id_usuario, _f_cr, _id_caja, _actualizar) {
    var params = {
        accion: "update_crs_gestor",
        id_usuario: _id_usuario,
        f_cr: _f_cr
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            if (_actualizar) {
                select_gestor_panel_tabla(_id_caja);
            } else {
                ajustes_estrategia_gestor(_id_usuario, "ajustes_estrategia_gestor");
            }
        }
    });
}
;
//==============================================================================
function update_importe_gestor(_id_usuario, _valor, _id_caja, _actualizar) {
 
    var params = {
        accion: "update_importe_gestor",
       id_usuario: _id_usuario,
        importe: _valor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            if (_actualizar) {
                select_gestor_panel_tabla(_id_caja);
            } else {
                ajustes_estrategia_gestor(_id_usuario, "ajustes_estrategia_gestor");
            }
        }
    });
}
;
//==============================================================================
function update_orden_gestor(_id_usuario, _valor, _id_caja) {
 
    var params = {
        accion: "update_orden_gestor",
        id_usuario: _id_usuario,
        orden: _valor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_gestor_panel_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function update_estatus_estrategia_gestor(_id_usuario, _cadena_estatus, _estatus, _id_caja, _actualizar) {
 
    var params = {
        accion: "update_estatus_estrategia_gestor",
        id_usuario: _id_usuario,
        cadena_estatus: _cadena_estatus,
        estatus: _estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            if (_actualizar) {
                select_gestor_panel_tabla(_id_caja);
            } else {
                ajustes_estrategia_gestor(_id_usuario, "ajustes_estrategia_gestor");
                select_llamadas_gestor($('#usuario_sistema', parent.document).val());
            }
        }
    });
}
;
//==============================================================================
function update_seguimientos_gestor(_id_usuario, _valor, _id_caja, _actualizar) {
 
    var params = {
        accion: "update_seguimientos_gestor",
        id_usuario: _id_usuario,
        f_seguimiento: _valor
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            if (_actualizar) {
                select_gestor_panel_tabla(_id_caja);
            } else {
                ajustes_estrategia_gestor(_id_usuario, "ajustes_estrategia_gestor");
            }
        }
    });
 
}
;
//==============================================================================
function select_categoria_combo(_id_caja) {
    var params = {
        accion: "select_categoria_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $('select').material_select();
        }
    });
}
;
//==============================================================================
function update_categoria_gestor(_id_gestor, _id_categoria) {
    var params = {
        accion: "update_categoria_gestor",
        id_gestor: _id_gestor,
        id_categoria: _id_categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_gestor_tabla_control_filtro($('#filtro').val(), "listado_gestores");
        }
    });
}
;
//==============================================================================
function insert_categoria_gestor(_categoria, _id_caja) {
    var params = {
        accion: "insert_categoria",
 
        categoria: _categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_gestor_tabla_control_filtro(_categoria, _id_caja);
        }
    });
}
;
//==============================================================================
function delete_categoria(_id_categoria, _categoria, _id_caja) {
    var params = {
        accion: "delete_categoria",
        id_categoria: _id_categoria,
        categoria: _categoria
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_gestor_tabla_control_filtro(_categoria, _id_caja);
        }
    });
};
//==============================================================================
function select_gestor_fecha(_desde, _hasta, id_caja) {
    var params = {
        accion: "select_gestor_fecha",
        desde: _desde,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + id_caja).empty();
            $("#" + id_caja).append(dataRes);
            $("#xlsx").show();
            $("#enviar_grafica").show();
        }
    });
}
;
//==================================================================
function select_nombre_gestor(_id_usuario, _id_caja) {
    var params = {
        accion: "select_nombre_gestor",
       id_usuario:_id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageGestor",
        data: params,
        dataType: "html",
        success: function (dataRes) { 
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;