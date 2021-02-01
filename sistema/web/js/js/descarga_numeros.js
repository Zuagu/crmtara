/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function () {
    select_territorios();
};

$('#territorios').change(function () {
    let op_territorio = JSON.stringify($('#territorios').val()).replace(/\[|]/gi, "");
    console.log(op_territorio);
    select_gerentes(op_territorio);
});

$('#gerentes').change(function () {
    let op_territorio = JSON.stringify($('#territorios').val()).replace(/\[|]/gi, "");
    let op_gerentes = JSON.stringify($('#gerentes').val()).replace(/\[|]/gi, "");
    console.log(op_territorio);
    console.log(op_gerentes);
    select_gerencias(op_territorio, op_gerentes);
});

$("#descargar_todos").click( function () {
    descargar_todos();
});

$("#descargar_todos_select").click( function () {
    descargar_todos_select();
});

$("#tbody_gerencias_descargar").on('click', '.descargar_tel_gerencia', function () {
    let gerencia = $(this).parent().parent().attr("id") ;
    descargar_tel_gerencia(gerencia);
});

// =============================================================================
// =============================================================================
// =============================================================================
// =============================================================================

function select_territorios() {
    let params = {
        action: 'select_territorios'
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#territorios').empty();
            $('#territorios').append(`<option value="" disabled selected>Territorios</option>`);
            for (let item of response) {
                if (item.TERRITORIO !== null && item.TERRITORIO !== "") {
                    console.log(item.TERRITORIO);
                    $('#territorios').append(`<option value="${item.TERRITORIO}">(${item.catidad}) - ${item.TERRITORIO}</option>`);
                }

            }
            $('select').formSelect();
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function select_gerentes(territorios) {
    let params = {
        action: 'select_gerentes',
        _territorios: territorios
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#gerentes').empty();
            $('#gerentes').append(`<option value="" disabled selected>Gerentes</option>`);
            for (let item of response) {
                if (item.TERRITORIO !== null && item.TERRITORIO !== "") {
//                    console.log(item.GERENTE);
                    $('#gerentes').append(`<option value="${item.GERENTE}">(${item.catidad}) - ${item.GERENTE}</option>`);
                }
            }
            $('select').formSelect();
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function select_gerencias(territorios, gerentes) {
    let params = {
        action: 'select_gerencias',
        _territorios: territorios,
        _gerentes: gerentes
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            $('#tbody_gerencias_descargar').empty();
//            $('#gerencias').append(`<option value="" disabled selected>Gerencias</option>`);
            for (let item of response) {
                $('#tbody_gerencias_descargar').append(`<tr id="${item.GERENCIA}">
                <td>${item.GERENCIA}</td>
                <td>${item.catidad}</td>
                <td class="right-align"><a class="btn-small waves-effect blue descargar_tel_gerencia"><i class="material-icons right">archive</i>Descargar</a></td>
                </tr>`);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function descargar_todos() {
    let params = {
        action: 'generar_csv_telefonos',
        _tipo_base: "completo",
        territorio: "0",
        gerente: "0",
        gerencia: "0"
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            window.open("excel/NumerosBaseCrm.csv");
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function descargar_todos_select() {
    
    let op_territorio = JSON.stringify($('#territorios').val()).replace(/\[|]/gi, "");
    let op_gerentes = JSON.stringify($('#gerentes').val()).replace(/\[|]/gi, "");
    
    let params = {
        action: 'generar_csv_telefonos',
        _tipo_base: "medio_completo",
        territorio: op_territorio,
        gerente: op_gerentes,
        gerencia: "0"
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            window.open("excel/NumerosBaseCrm.csv");
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function descargar_tel_gerencia(gerencia) {
    
    let op_territorio = JSON.stringify($('#territorios').val()).replace(/\[|]/gi, "");
    let op_gerentes = JSON.stringify($('#gerentes').val()).replace(/\[|]/gi, "");
    
    let params = {
        action: 'generar_csv_telefonos',
        _tipo_base: "con_gerencia",
        territorio: op_territorio,
        gerente: op_gerentes,
        gerencia: gerencia
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            let url_sever = document.URL.replace('descarga_numeros.jsp','excel/');
//            downloadDataUrlFromJavascript('NumerosBaseCrm.csv',url_sever);
//            document.execCommand('SaveAs',true,url_sever + 'excel/NumerosBaseCrm.csv');
            window.open("excel/NumerosBaseCrm.csv");
        },
        error: function (error) {
            console.log(error);
            
        }
    });
}

function downloadDataUrlFromJavascript(filename, dataUrl) {

       // Construct the a element
       var link = document.createElement("a");
       link.download = filename;
       link.target = "_blank";

       // Construct the uri
       link.href = dataUrl;
       document.body.appendChild(link);
       link.click();

       // Cleanup the DOM
       document.body.removeChild(link);
       delete link;
}