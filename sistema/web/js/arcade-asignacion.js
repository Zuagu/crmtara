//==============================================================================
function select_asignacion_tabla(_id_caja, _f_active) {
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_asignacion_tabla",
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_asignacion_check(_cadena_regiones, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_asignacion_region_check",
        cadena_regiones: _cadena_regiones
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_asignacion_referencias(_id_caja) {
    var params = {
        accion: "select_asignacion_referencias"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function updt_col99(_id_asignacion, _id_cuenta, _ref1, _telr1, _ref2, _telr2) {
    var params = {
        accion: "updt_col99",
        id_cuenta: _id_cuenta,
        ref1: _ref1,
        telr1: _telr1,
        ref2: _ref2,
        telr2: _telr2

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_asignacion_referencias("listado_asignaciones");
            $("#" + _id_cuenta).remove();

        }
    });
}
;
//==============================================================================
function select_cuentas_referencias(_id_asignacion, _id_caja) {
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_cuentas_referencias",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_asignacion_region_tabla(_id_caja, _id_region, _f_active) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_asignacion_region_tabla",
        id_region: _id_region,
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_asignacion_region_check(_id_region, _id_caja, _f_active) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_asignacion_region_check",
        id_region: _id_region,
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_asignacion_combo(_id_caja, _f_active) {
    var params = {
        accion: "select_asignacion_combo",
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_asignacion_chbk_combo(_id_usuario, _id_caja) {
    var params = {
        accion: "select_asignacion_chbk_combo",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">TODOS...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_ciclos_chbk_usuario(_id_usuario, _id_caja) {
    var params = {
        accion: "select_ciclos_chbk_usuario",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">TODOS...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_chbk_usuario(_id_usuario, _ciclo, _id_caja) {
    var params = {
        accion: "select_estatus_chbk_usuario",
        id_usuario: _id_usuario,
        ciclo: _ciclo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">TODOS...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_estatus_gestion_chbk_usuario(_id_usuario, _ciclo, _estatus_original, _id_caja) {
    var params = {
        accion: "select_estatus_gestion_chbk_usuario",
        id_usuario: _id_usuario,
        ciclo: _ciclo,
        estatus_original: _estatus_original
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">TODOS...</option>');
            $("#" + _id_caja).append(dataRes);

        }
    });
}
;
//==============================================================================
function select_asignacion_cliente_combo(_id_cliente, _f_active, _id_caja) {
    var params = {
        accion: "select_asignacion_cliente_combo",
        id_cliente: _id_cliente,
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">TODAS...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_asignacion_region_combo(_id_region, _f_active, _id_caja) {
    var params = {
        accion: "select_asignacion_region_combo",
        id_region: _id_region,
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">TODAS...</option>');
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function insert_asignacion(_id_usuario, _asignacion, _id_sucursal, _id_cliente, _id_region, _fecha_inicio, _fecha_fin, _dias_anticipados, _meta) {
    var params = {
        accion: "insert_asignacion",
        id_usuario: _id_usuario,
        asignacion: _asignacion,
        id_sucursal: _id_sucursal,
        id_cliente: _id_cliente,
        id_region: _id_region,
        fecha_inicio: _fecha_inicio,
        fecha_fin: _fecha_fin,
        dias_anticipados: _dias_anticipados,
        meta: _meta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            match_datos_asignacion(dataRes);
        }
    });
}
;
//==============================================================================
function update_asignacion(_id_asignacion) {
    $("#listado_asignaciones").empty();
    $("#listado_asignaciones").append("<h4 style='text-align:center;'>Actualizando importes de asignacion...</h4>");
    $("#listado_asignaciones").append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div><br>");
    var params = {
        accion: "update_asignacion",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            select_asignacion_region_tabla("listado_asignaciones", $("#id_region").val(), 1);
        }
    });
}
;
//==============================================================================
function delete_asignacion(_id_asignacion, _id_caja) {
    var params = {
        accion: "delete_asignacion",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_asignacion_tabla(_id_caja);
            select_asignacion_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function insert_asignacion_original(_id_caja) {
    $("#cargando").show();
    $("#cargar_asignacion").hide();
    var params = {
        accion: "insert_asignacion_original"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacionOriginal",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#cargando").hide();
            $("#fin").show();
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function match_datos_asignacion(_id_asignacion) {
    var params = {
        accion: "match_datos_asignacion",
        id_asignacion: _id_asignacion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            location.href = "asignaciones.jsp";
        }
    });
}
;
//==============================================================================
function select_colas(_id_caja) {
    var params = {
        accion: "select_colas"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function insert_basechbk() {
    var params = {
        accion: "insert_basechbk"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#insert_basechbk").hide();
            $("#cargar").show();
            select_basechargeback_tabla("div_basechargeback");
            select_basechargeback_resumen_tabla("resumen_cuentas");
        }
    });
}
;
//==============================================================================
function contar_cuentas_chbk_usuario(_id_usuario, _ciclo, _estatus_original, _estatus, _id_caja) {
    var params = {
        accion: "contar_cuentas_chbk_usuario",
        id_usuario: _id_usuario,
        ciclo: _ciclo,
        estatus_original: _estatus_original,
        estatus: _estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).val(dataRes);
        }
    });
}
;
//==============================================================================
function select_ladas(_id_region, _cadena_asignaciones, _tiene_cr, _cadena_estatus, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_ladas",
        id_region: _id_region,
        cadena_asignaciones: _cadena_asignaciones,
        tiene_cr: _tiene_cr,
        cadena_estatus: _cadena_estatus
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_cuentas_sms_blaster(_id_region, _cadena_asignaciones, _tiene_cr, _cadena_ladas, _cadena_estatus, _importe, _orden, _id_caja) {
    $("#" + _id_caja).empty();
   $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_cuentas_sms_blaster",
        id_region: _id_region,
        cadena_asignaciones: _cadena_asignaciones,
        tiene_cr: _tiene_cr,
        cadena_ladas: _cadena_ladas,
        cadena_estatus: _cadena_estatus,
        importe: _importe,
        orden: _orden
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            var _filas = $('#cuentas tr').length;
            $("#num_cuentas").val(_filas);
        }
    });
}
;
//==============================================================================
function select_asignacion_region_combo_materialize(_id_region, _f_active, _id_caja) {
    var params = {
        accion: "select_asignacion_region_combo_materialize",
        id_region: _id_region,
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append("<option value='' disabled selected>SELECCIONE...</option>");
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).material_select();
        }
    });
}
;
//==============================================================================
//==============================================================================

function select_asignacion_region_check_materialize(_cadena_regiones, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_asignacion_region_check_materialize",
        cadena_regiones: _cadena_regiones
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
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
function select_ciudades_asignaciones_check(_cadena_asignaciones, _id_region, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_ciudades_asignaciones_check",
        cadena_asignaciones: _cadena_asignaciones,
        region:_id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            //console.log(dataRes);
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_colonias_ciudades_check(_id_asignacion, _cadena_ciudades, _cadena_codigos, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_colonias_ciudades_check",
        id_asignacion: _id_asignacion,
        cadena_ciudades: _cadena_ciudades,
        cadena_codigos:_cadena_codigos
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            //console.log(dataRes);
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_codigo_postal_colonias_check(_cadena_asignaciones, _cadena_ciudades, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_codigo_postal_colonias_check",
        cadena_asignaciones: _cadena_asignaciones,
        cadena_ciudades: _cadena_ciudades
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            //console.log(dataRes);
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_status_codigo_postal_check(_cadena_asignaciones, _cadena_colonias ,_cadena_codigos, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_status_codigo_postal_check",
        cadena_asignaciones: _cadena_asignaciones,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            //console.log(dataRes);
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_saldo_lada_check(_cadena_ladas, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_saldo_lada_check",
        cadena_ladas: _cadena_ladas
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_datos_visitas(_id_region,_cadena_asignaciones, _cadena_ciudades, _cadena_colonias,_cadena_codigos,_cadena_ladas,_resto, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_datos_visitas",
        id_region: _id_region,
        cadena_asignaciones: _cadena_asignaciones,
        cadena_ciudades: _cadena_ciudades,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos,
        cadena_ladas: _cadena_ladas,
        resto: _resto
        
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            var num = document.getElementById("lista_user").rows.length;
            $("#cantidad").empty();
            $("#cantidad").append(num-1 + " "+"CARTAS PARA IMPRIMIR");
        }
    });
}
;
//==============================================================================
function select_datos_carteo(_id_region,_id_asignacion, _cadena_ciudades, _cadena_colonias,_cadena_codigos,_id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_datos_carteo",
        id_region: _id_region,
        id_asignaciones: _id_asignacion,
        cadena_ciudades: _cadena_ciudades,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos
       
        
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageAsignacion",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);

            genera_resumen();

        }
    });
}
;
//==============================================================================
