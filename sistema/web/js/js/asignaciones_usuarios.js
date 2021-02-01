/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    select_asignaiones_usuarios();
};

$("#tbody_asignaciones_gestor").on('click', '.act_gestor', function () {
    let id_row = $(this).parent().parent().attr("id");
    console.log(id_row);
    let _val_select_order = $("#tbody_asignaciones_gestor #"+ id_row +" .order_ult_gestion select").val();
    let _val_select_order_importe = $("#tbody_asignaciones_gestor #"+ id_row +" .order_import select").val();
    console.log(_val_select_order);
    console.log(_val_select_order_importe);
    let _id_gestor = id_row.replace("gestor_","");
    console.log(_id_gestor);
    let params = {
        action: "update_config_gestor",
        val_order: _val_select_order,
        val_order_importe: _val_select_order_importe,
        id_gestor: _id_gestor
    };
    if (_id_gestor === "null") {
        alert("Esta Asignacion no esta asignado a ningun usuario");
    } else {
        update_config_gestor(params);
    }
});


$("#tbody_asignaciones_gestor").on('dblclick', '._asig_gestor', function () {
    let _id_gestor =  $(this).attr("id").replace("gestor_","");
    $("#nom_asig").empty();
    $("#nom_asig").append( $(".alias_gestor", this).text() );
    let params = {
        action: "estatus_asignacion_gestor",
        id_gestor: _id_gestor
    };
    estatus_asignacion_gestor(params);
});

$("#act_todos").click( function () {
    let params = {
        action: "update_config_todos_gestor",
        order_ult_gestion: $("#ultima_gestion_order_todos").val(),
        order_monto: $("#importe_order_todos").val()
    };
    update_config_todos_gestor(params);
});

// =============================================================================
// =============================================================================
// =============================================================================
// ======================= Funciones Ajax ======================================

function select_asignaiones_usuarios() {
    params = {
        action: "select_asignaiones_usuarios"
    };
    $.ajax({
        type: "POST",
        url: "ControllerAsignacionesUsuarios",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            $("#tbody_asignaciones_gestor").empty();
            for (let row of response)  {
                $("#tbody_asignaciones_gestor").append(`<tr class="_asig_gestor" id="gestor_${row.id_gestor}">
                <td class="alias_gestor">${row.gestor}</td>
                <td>${row.cantidad}</td>
                <td>${row.importe}</td>
                <td class="order_ult_gestion"><select><option value="${row.orden}">${row.orden}</option><option value="desc">Mas antiguo</option><option value="asc">Mas reciente</option></select></td>
                <td class="order_import"><select><option value="${row.orden_importe}">${row.orden_importe}</option><option value="desc">Mayor a Menor</option><option value="asc">Menor a Mayor</option></select></td>
                <td><a class="btn-small waves-effect waves-light act_gestor">Actualizar</a></td>
                </tr>`);
            }
            $('select').formSelect();
            
        },
        error: function (error) {
            console.log(error);
        }
    });
}


function update_config_gestor(params) {
    $.ajax({
        type: "POST",
        url: "ControllerAsignacionesUsuarios",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            alert(response.response);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function update_config_todos_gestor(params) {
    $.ajax({
        type: "POST",
        url: "ControllerAsignacionesUsuarios",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            alert(response.response);
            select_asignaiones_usuarios()
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function estatus_asignacion_gestor(params) {
    $.ajax({
        type: "POST",
        url: "ControllerAsignacionesUsuarios",
        data: params,
        dataType: "json",
        success: function (response) {
            $("#modal_data_asignacion").modal('open');
            $("#tbody_estatus_cuentas_asig").empty();
            for (let row of response)  {
                $("#tbody_estatus_cuentas_asig").append(`<tr>
                <td>${row.ESTATUS_LLAMADA}</td>
                <td>${row.cantidad}</td>
                
                </tr>`);
            }
            console.log(response);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

