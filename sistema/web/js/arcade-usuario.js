//==============================================================================
function select_usuario_tabla(_id_caja) {
    var params = {
        accion: "select_usuario_tabla"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
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
function select_usuario_tabla_nomina(_id_caja) {
    var params = {
        accion: "select_usuario_tabla_nomina"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
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
function select_usuario_combo(_f_active, _id_caja) {
    var params = {
        accion: "select_usuario_combo",
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append('<option value="0">SELECCIONE...</option>');
            $("#" + _id_caja).append(dataRes);
             $("#" + _id_caja).material_select();
        }
    });
}
;
//==============================================================================
function insert_usuario(_nombre, _alias, _id_sucursal, _id_puesto, _id_jefe_inmediato, _sexo, _telefono, _celular, _email) {
    var params = {
        accion: "insert_usuario",
        nombre: _nombre,
        alias: _alias,
        id_sucursal: _id_sucursal,
        id_puesto: _id_puesto,
        id_jefe_inmediato: _id_jefe_inmediato,
        sexo: _sexo,
        telefono: _telefono,
        celular: _celular,
        email: _email
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            location.href = "usuarios.jsp";
           
        }
    });
}
;
//==============================================================================
function update_usuario(_id_usuario, _usuario) {
    var params = {
        accion: "update_usuario",
        id_usuario: _id_usuario,
        usuario: _usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================
function delete_usuario(_id_usuario, _id_caja) {
    var params = {
        accion: "delete_usuario",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            select_usuario_tabla(_id_caja);
        }
    });
}
;
//==============================================================================
function select_usuario_filtro(_filtro, _id_caja) {
    var params = {
        accion: "select_usuario_filtro",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
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
function partir_datos(dataRes, _campo, _forlimit) {
    var campos = dataRes.split("#AND#");
    console.log(campos);
    for (i = 1; i <= _forlimit; i++) {
        $("#" + _campo + i).val(campos[i]);
    }

    $('#dato12').prop('checked', (campos[12] =="true") );
    $('#dato13').prop('checked', (campos[13] =="true") );
    $('#dato14').prop('checked', (campos[14] =="true") );
    $('#dato15').prop('checked', (campos[15] =="true") );
    $('#dato16').prop('checked', (campos[16] =="true") );
    $('#dato17').prop('checked', (campos[17] =="true") );
    $('#dato18').prop('checked', (campos[18] =="true") );
    $('#dato19').prop('checked', (campos[19] =="true") );
    $('#dato20').prop('checked', (campos[20] =="true") );
 
    // CARGAR LOS ESTATUS POSIBLES DE LAS CUENTAS...
    $("#" + _campo + 4).empty();
    $("#" + _campo + 4).append(campos[4]);
 
    $("#" + _campo + 8).empty();
    $("#" + _campo + 8).append(campos[8]);
    select_usuario_combo_sin_borrar(1, "dato8");
 
    $("#" + _campo + 9).empty();
    $("#" + _campo + 9).append(campos[9]);
 
    $("#" + _campo + 10).empty();
    $("#" + _campo + 10).append(campos[10]);
    select_sucursal_combo_sin_borrar("dato10");
       $("#" + _campo + 4).material_select();
        $("#" + _campo + 9).material_select();
}
;
//==============================================================================
function select_datos_usuario(_id_usuario) {
    var params = {
        accion: "select_datos_usuario",
        id_usuario: _id_usuario
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            partir_datos(dataRes, "dato", 20);
        }
    });
}
;
//==============================================================================
function update_usuario_rrhh( _id_seleccion, _d1, _d2, _d3, _d4, _d5, _d6, _d7, _d8, _d9, _d10,_d11) {
    var params = {
        accion: "update_usuario_rrhh",
        id_seleccion: _id_seleccion,
        d1: _d1,
        d2: _d2,
        d3: _d3,
        d4: _d4,
        d5: _d5,
        d6: _d6,
        d7: _d7,
        d8: _d8,
        d9: _d9,
        d10: _d10,
        d11: _d11
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
            $("#div_usuario").show();
            $("#div_edicion").hide();
            select_usuario_filtro($('#filtro').val(), "listado_usuarios");
        }
    });
}
;
//==============================================================================
function select_usuario_combo_sin_borrar(_f_active, _id_caja) {
    var params = {
        accion: "select_usuario_combo",
        f_active: _f_active
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).append(dataRes);
            $("#" + _id_caja).material_select();
        }
    });
}
;
//==============================================================================
function select_entrada_tabla(_fecha, _id_caja) {
    var params = {
        accion: "select_entrada_tabla",
        fecha: _fecha
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#xlsx").show();
        }
    });
}
;
//==============================================================================
function select_resumen_usuario(_id_caja) {
    var params = {
        accion: "select_resumen_usuario"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            partir_datos(dataRes, "res", 3);
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
//==============================================================================
function select_inactivos_tabla_filtro(_filtro, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_inactivos_tabla_filtro",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
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
function select_activos_tabla_filtro(_filtro, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_activos_tabla_filtro",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
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
function select_reporte_entradas(_id_sucursal, _id_admin, _fecha1, _fecha2, _id_caja) {
    var params = {
        accion: "select_reporte_entradas",
        id_sucursal:_id_sucursal,
        id_admin:_id_admin,
        fecha1: _fecha1,
        fecha2: _fecha2
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageEntrada",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            $("#xlsx").show();
        }
    });
}
;
//==============================================================================
function update_cargo(_id_usuario, _cargo) {
    var params = {
        accion: "update_cargo",
        id_usuario: _id_usuario,
        cargo: _cargo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
        }
    });
}
;
//==============================================================================
function select_calendario_entradas(_id_usuario, _fecha) {
    var params = {
        accion: "select_calendario_entradas",
        id_usuario: _id_usuario,
        fecha: _fecha
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            //PARTIR DATOS
            var datos = dataRes.split("#corte#");
            var fechas = datos[0].split("##") ;
            var status = datos[1].split("#c#");
            // MOSTRAR EN CONSOLA
            console.log(datos,fechas,status);
            
            // DECLARAR VARIABLE TIPO JSON
            var temprano = [];
            var tarde = [];
            
            //INTROUCIR DATOS EN LA VARIABLE TIPO JSON
            for (var i = 0; i < fechas.length; i++) {
                if (status[i] == 0) {
                    temprano.push({date: new Date(fechas[i])});
                }else {
                    tarde.push({date: new Date(fechas[i])});
                }
            }
            
            
            console.log(temprano, tarde);

            $('#mydate').glDatePicker({
                showAlways: true,
                cssName: 'darkneon',
                selectedDate: new Date(2018, 10, 11),
                specialDates: temprano,
                specialDates2: tarde,
                onClick: function (target, cell, date, data) {
                    $('#mydate').empty();
                    target.val(date.getFullYear() + '-' +
                            date.getMonth() + '-' +
                            date.getDate());

                    if (data != null) {
                        alert(data.message + '\n' + date);
                    }
                }
            });


        }
    });
};
//==============================================================================
function select_dato_contrato(_id) {
    var params = {
        accion: "select_dato_contrato",
        id:_id 
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
        partir_datos_contrato(dataRes, "dato", 22);    
            
        }
    });
}
;
//==============================================================================
function partir_datos_contrato(dataRes, _campo, _forlimit) {
    var campos = dataRes.split("[corte]");
    console.log(campos);
    for (i = 1; i <= _forlimit; i++) {
        $("#" + _campo + i).val(campos[i]);
    }
    };

//==============================================================================
function update_chunnun(_idusu,_acta, _ife, _nss, _curp1, _comp_est, _comp_dom, _cartas, _fotos, _infonavit1,_rfcc) {
  
    var params = {
        accion: "update_chunnun",
        idusu:_idusu,
        acta:_acta,
        ife:_ife,
        nss:_nss,
        curp1:_curp1,
        comp_est:_comp_est,
        comp_dom:_comp_dom,
        cartas:_cartas,
        fotos:_fotos,
        infonavit1:_infonavit1, 
        rfcc:_rfcc 
 
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            
        }
    });
};
//==============================================================================
function insert_chunnun(_id_usuario,_dato12, _dato13, _dato14, _dato15, _dato16, _dato17, _dato18, _dato19, _dato20) {
    console.log(_id_usuario,_dato12, _dato13, _dato14, _dato15, _dato16, _dato17, _dato18, _dato19, _dato20);
    var params = {
        accion: "update_chunnun",
        id_usuario:_id_usuario,
        dato12:_dato12,
        dato13:_dato13,
        dato14:_dato14,
        dato15:_dato15,
        dato16:_dato16,
        dato17:_dato17,
        dato18:_dato18,
        dato19:_dato19,
        dato20:_dato20
 
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageUsuario",
        data: params,
        dataType: "html",
        success: function (dataRes) {
        }
    });
};