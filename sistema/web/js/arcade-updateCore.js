
//==============================================================================
function select_xxyyzz_combo(_id_caja) {
    var params = {
        accion: "select_xxyyzz_combo"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
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
function insert_xxyyzz(_id_xxyyzz, _xxyyzz, _id_caja) {
    var params = {
        accion: "insert_xxyyzz",
        id_xxyyzz: _id_xxyyzz,
        xxyyzz: _xxyyzz
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_xxyyzz_tabla(_id_caja);
            select_xxyyzz_combo(_id_caja);
        }
    });
}
;
//==============================================================================
function update_datos_convenio(_id_convenio, _convenio, _id_gestor, _fecha, _aplica ) {
    var params = {
        accion: "update_datos_convenio",
        id_convenio: _id_convenio,
        convenio: _convenio,
        gestor: _id_gestor,
        fecha: _fecha,
        aplica: _aplica
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            alert(dataRes);
        }
    });
}
;
//==============================================================================
function datos_convenio( _id_convenio ) {
     alert(_id_convenio);
    var params = {
        accion: "delete_xxyyzz",
        id_convenio: _id_convenio
    };
   
    $.ajax({
        type: "POST",
        url: "/sistema/ManageXxyyzz",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_xxyyzz_tabla(_id_caja);
            select_xxyyzz_combo(_id_caja);
        }
    });
};
//==============================================================================

function partir_datos(dataRes, campo, forlimit) {
    var campos = dataRes.split("#and#");
    console.log(campos);
    for (i = 0; i <= forlimit; i++) {
        $("#" + campo + i).val(campos[i]);     
    }
    }; 
//==============================================================================
 
function solicitud_core(_cuenta) {
    var params = {
        accion: "solicitud_core",
        cuenta: _cuenta
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
             partir_datos(dataRes, "dato", 10);
             console.log(dataRes);
         }
    });
  };
//==============================================================================
function update_datos_cliente( _d1,_d3, _d5, _d6, _d7, _d8, _d9, _d10) {
    var params = {
        accion: "update_cliente",
        d1: _d1, //cuenta
        d3: _d3, //nombre
        d5: _d5, //plan
        d6: _d6, //ciudad
        d7: _d7, //cp
        d8: _d8, //colonia
        d9: _d9, //calle
        d10: _d10 //numero
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
function select_convenios_cuenta(_cuenta, _caja) {
    var params = {
        accion: "select_convenios_cuenta",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _caja).empty();
            $("#" + _caja).append(dataRes);
        }
    });
};
//==============================================================================
function select_tabla_telefono(_cuenta, _id_caja, _id_caja2, _id_caja3) {
    
    var params = {
        accion: "select_tabla_telefono",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var tablas = dataRes.split("#AND#");
//            console.log(tablas);
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(tablas[2]);
            $("#" + _id_caja2).empty();
            $("#" + _id_caja2).append(tablas[1]);
            $("#" + _id_caja3).empty();
            $("#" + _id_caja3).append(tablas[0]);
        }
    });
};
//==============================================================================
function cargar_respaldo_convenio(_respaldo_id_convenio,_respaldo_convenio, _respaldo_gestor, _respaldo_fecha) {
    var params = {
        accion: "cargar_respaldo_convenio",
        id_convenio: _respaldo_id_convenio,
        convenio: _respaldo_convenio,
        gestor: _respaldo_gestor,
        fecha: _respaldo_fecha
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
};

//==============================================================================
function update_datos_telefono1(_cuenta, _numero, _nombre, _tipo_tel) {
    var params = {
        accion: "update_datos_telefono1",
        cuenta: _cuenta,
        numero: _numero,
        nombre: _nombre,
        tipo_tel: _tipo_tel
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            alert(dataRes);
        }
    });
};
//==============================================================================
function update_datos_relacionada(_cuenta, _numero2, _tipo_tel, _ant_tel) {
    var params = {
        accion: "update_datos_relacionada",
        cuenta: _cuenta,
        numero: _numero2,
        tipo: _tipo_tel,
        ant_tel:_ant_tel
    };
    console.log(params);
    
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            alert(dataRes);
            
        }
    });
};
//==============================================================================
function update_datos_titular(_cuenta, _numero3, _tipo_tel) {
    var params = {
        accion: "update_datos_relacionada",
        cuenta: _cuenta,
        numero: _numero3,
        tipo: _tipo_tel,
    };
    console.log(params);
    
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            alert(dataRes);
            
        }
    });
};
//==============================================================================
function select_pagos_cuenta(_cuenta, _caja) {
    var params = {
        accion: "select_pagos_cuenta",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _caja).empty();
            $("#" + _caja).append(dataRes);
        }
    });
};
//==============================================================================
//funcion para eliminar el pago recibe como parametro el id_ del pago
function delete_pago(_id_pago) {
    var params = {
        accion: "delete_pago",
        id_pago: _id_pago
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
// FUNCION PARA ELMINAR PAGOS DE MANERA INDIVIDUAL
function eliminar_telefonos_individual(_numero, _codigo, _cuenta) {
    var params = {
        accion: "eliminar_telefonos_individual",
        cuenta: _cuenta,
        numero: _numero,
        codigo: _codigo
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            alert(dataRes);
        }
    });
};
//==============================================================================
function delete_referencia(_numero, _codigo, _cuenta) {
    var params = {
        accion: "delete_referencia",
        numero: _numero,
        codigo: _codigo,
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
function delete_relacionada(_numero, _codigo, _cuenta) {
    var params = {
        accion: "delete_relacionada",
        numero: _numero,
        cogigo: _codigo,
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
function delete_titular(_numero, _codigo, _cuenta) {
    var params = {
        accion: "delete_titular",
        numero: _numero,
        cogigo: _codigo,
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
function delete_todo(_cuenta) {
    var params = {
        accion: "delete_todo",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
function delete_convenio(_id_convenio) {
    var params = {
        accion: "delete_convenio",
        id_convenio: _id_convenio
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
function select_tabla_gestiones(_cuenta, _caja) {
    var params = {
        accion: "select_tabla_gestiones",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _caja).empty();
            $("#" + _caja).append(dataRes);
        }
    });
};
//==============================================================================
function actualizar_gestiones(_cuenta, _numero_tabla, _id_gestion, _estatus) {
    var params = {
        accion: "actualizar_gestiones",
        cuenta: _cuenta,
        numero_tabla: _numero_tabla,
        id_gestion:_id_gestion,
        estatus:_estatus
    };
    console.log(_cuenta, _numero_tabla, _id_gestion, _estatus);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
        }
    });
};
//==============================================================================
function actualizar_subgestiones(_cuenta, _numero_tabla, _id_gestion, _estatus) {
    var params = {
        accion: "actualizar_subgestiones",
        cuenta: _cuenta,
        numero_tabla: _numero_tabla,
        id_gestion:_id_gestion,
        estatus:_estatus
    };
    console.log(_cuenta, _numero_tabla, _id_gestion, _estatus);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUpdateCore",
        data: params,
        dataType: "html",
        success: function (dataRes) {
        }
    });
};
//==============================================================================