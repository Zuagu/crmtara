//==============================================================================
function select_cadena_datos_carta_visita(_cuenta) {
    var params = {
        accion: "select_cadena_datos_carta_visita",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            partir_datos_cuentas_indi(dataRes);
        }
    });
}
;
//==============================================================================
function select_cadena_datos_cartas(_id_region, _cadena_asignaciones, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _cadena_ladas, _resto, _id_caja) {
    var params = {
        accion: "select_cadena_datos_cartas",
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
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            partir_datos_cuenta_carta1(dataRes, _id_caja);
        }
    });
}
;
//==============================================================================
function select_cadena_datos_cartas2(_id_region, _cadena_asignaciones, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _cadena_ladas, _resto, _id_caja) {
    var params = {
        accion: "select_cadena_datos_cartas2",
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
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            partir_datos_cuenta_carta2(dataRes, _id_caja);
        }
    });
}
;
//==============================================================================
function insert_cuentas_visitas(_id_region, _cadena_asignaciones, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _cadena_ladas, _resto) {
    var params = {
        accion: "insert_cuentas_visitas",
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
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert("se ha Guardo un Registro de las Cuentas Que se le mandaran una La Carta" + dataRes);
        }
    });
}
;
//==============================================================================
function update_numero_visitas(_id_region, _cadena_asignaciones, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _cadena_ladas, _resto) {
    alert("voy a actualizar le nuemro de visitas ");
    var params = {
        accion: "update_numero_visitas",
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
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert("se ha Guardo un " + dataRes);
        }
    });
}
;
//==============================================================================
//==============================================================================
//================ PARTIR DATOS CARTA NOTIFICACON PREVIA    ====================
function partir_datos_cuenta_carta1(dataRes, id_caja) {
    //partimos los datos por persona 
    var datos_cuentas = dataRes.split("#CORTE#");
    console.log(datos_cuentas);
    var carta = '';
    // Empezamos a leer los datos por persona 
    for (var i = 0; i < datos_cuentas.length; i++) {
        //a qui partimos los datos de forma individual para pintarlos en las cartas
        var datos_persona = datos_cuentas[i].split(",");
        console.log(datos_persona);
        carta += '<div class="carta col s12">' +
                '<br>' +
                '<div class="col s6" style="border-bottom:solid 1px black; height:100px;text-align: left;">' +
                '<img onclick="window.print()" src="images/logo-cliente-z.png" height="100%">' +
                '</div>' +
                '<div class="col s6" style="border-bottom:solid 1px black;height:100px;text-align: right;">' +
                '<p>' +
                'e-mail: ' + datos_persona[0] + ' <br>' +
                'Tels: ' + datos_persona[1] +
                'Fecha: ' + datos_persona[21] +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p>' +
                'ESTIMADO(a): ' + datos_persona[2] + '<br>' +
                'RFC: ' + datos_persona[3] + ' CUENTA: ' + datos_persona[4] + ' <br>' +
                'DOMICILIO: ' + datos_persona[5] + ' COLONIA: ' + datos_persona[6] + ' <br>' +
                'CIUDAD: ' + datos_persona[7] + ' C.P.: ' + datos_persona[8] + ' <br>' +
                'LINEA: ' + datos_persona[9] + ' ADEUDO: ' + datos_persona[10] +
                '</P>' +
                '</div>' +
                '<div class="col s12">' +
                '<h4 class="center-align"><b style="text-decoration:underline;">PREVIA NOTIFICACION</b></h4>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'DEBIDO A QUE USTED NO ANTENDIÓ LOS REQUERIMIENTOS DE PAGO QUE EN FECHAS ANTERIORES SE LE HAN ENVIADO POR EL ADEUDO VENCIDO QUE PRESENTA' +
                'EN SU PLAN TARIFARO(TELCEL), SE LE NOTIFICA QUE SE PROCEDERÁ A EJERCER LA COBRANZA DE DICHA DEUDA POR MEDIO DE DEMANDA VÍA AFIANZADORA, DÁNDOSE POR ENTERADO' +
                'QUE YA SE ENCUENTRA BOLETINADO EN EL  <b style="text-decoration:underline;">BÚRO NACIONAL DE CRÉDITO</b> COMO PERSONA QUE NO CUMPLE CON SUS COMPROMISOS DE PAGO.' +
                '</p>' +
                '</div>' +
                '<div class="col s12" style="height:145px;">' +
                '<p style="text-align: justify">' +
                'POR LO TANTO, NOS VEMOS INSTADOS A REQUERIRLE DEL INMEDIATO PAGO TOTAL DEL ADEUDO VENCIDO, COMPUESTO DE PRINCIPAL Y SUERTES ACCESORIAS,' +
                'PARA QUE PASE AL CENTREO DE ATENCIÓN DE TELCEL HOY MISMO O SU DÍA INMEDIATO HÁBIL A LIQUIDAR PARA EVITAR LA DEMANDA POR MEDIO DE LA AFIANZADORA' +
                '</p>' +
                '</div>' +
                '<div class="col s12" style="height:200px;">' +
                '<p><b style="text-decoration:underline;">' +
                'EVÍTESE UN PROBLEMA Y LA PENA MORAL DE VERSE PRESIONADO POR SU UNCUMPLIMIENTO DE PAGO EN EL CONTRATO DE SU LÍNE TELCEL, PUES NOSOTROS AÚN' +
                'CREEMOS EN LA HONORABILIDAD DE LAS PERSONAS Y SUS ACTOS DE COMERCIO Y SIEMPRE ESTAMOS DISPUESTOS A UN ARREGLO PERTINENTE. CUMPLA CON SUS OBLIGACIONES DE PAGO,' +
                '</b></p>' +
                '</div>' +
                '<div class="col s12 center-align">' +
                '<p>ATENTAMENTE<br>' +
                'Departamento de Recuperación Legal<br>' +
                datos_persona[12] + '<br>' +
                '(Teléfono Monterrey y Área Metropolitana)</p>' +
                '</div>' +
                '<div class="col s12" style=" margin-bottom: 50px; ">' +
                '<p style="text-align: justify">' +
                '<b>NOTA:</b> FAVOR DE HACER CASO OMISO EN CASO DE HABER YA REALIZADO EL PAGO SOLICITADO EN LA PRESENTE. NUESTROS ' +
                'REPRESENTANTES NO ESTARÁN AUTORIZADOS A RECIBIR EFECTIVO, EL PAGO DEVERA REALIZARSE EN CENTROS DE ATENCION TELCEL.' +
                '</p>' +
                '</div>' +
                '</div>' +
                '<div class="carta col s12 texto2" style="">' +
                '<div class="col s6" style="text-align: left;">' +
                '<p>' +
                'Nombre: ' + datos_persona[2] + '<br>' +
                'Dirección: ' + datos_persona[5] + '<br>' +
                'Colonia: ' + datos_persona[6] + '<br>' +
                'Ciudad: ' + datos_persona[7] + '<br>' +
                'Cuenta: ' + datos_persona[4] + '<br> Expediente: ' + datos_persona[13] + '<br>' +
                '</p>' +
                '</div>' +
                '<div class="col s6" style="text-align: left;">' +
                '<p>' +
                'Asign: ' + datos_persona[14] + '<br>' +
                'Estatus: ' + datos_persona[16] + '<br>' +
                'Saldo: ' + datos_persona[17] + '<br>' +
                'Multa: ' + datos_persona[18] + '<br>' +
                'Total: ' + datos_persona[19] + '<br>' +
                'Saldo Act: ' + datos_persona[20] + '<br>' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<div class="col s6 intro-text">' +
                '<b>1.- CONTACTO</b> <br>   ' +
                '<form action="#">' +
                '<p>' +
                '<input type="checkbox" id="test5"/>' +
                '<label for="test5">201 Promesa de pago / Convenio </label>' +
                '<br>' +
                '<input type="checkbox" id="test6"/>' +
                '<label for="test6">202 Titular ya realizó el pago</label>' +
                '<br>' +
                '<input type="checkbox" id="test7"/>' +
                '<label for="test7">203 Titular no reconoce el adeudo</label>' +
                '<br>' +
                '<input type="checkbox" id="test8"/>' +
                '<label for="test8">204 Deudor está en desacuerdo con adeudo</label>' +
                '<br>' +
                '<input type="checkbox" id="test9"/>' +
                '<label for="test9">205 Notificación con Familiar</label>' +
                '<br>' +
                '<input type="checkbox" id="test1"/>' +
                '<label for="test1">206 Notificación con Familiar/Tercero()</label>' +
                '<br>' +
                '<input type="checkbox" id="test2"/>' +
                '<label for="test2">207 Deudor Falleció</label>' +
                '<br>' +
                '<input type="checkbox" id="test3"/>' +
                '<label for="test3">208 Se niegan a recibir notificación</label>' +
                '<br>' +
                '<input type="checkbox" id="test4"/>' +
                '<label for="test4">215 Titular no define pago</label>' +
                '<br>' +
                '</p>' +
                '</form>' +
                '</div>' +
                '<div class="col s6 intro-text">' +
                '<b>2.- NO CONTACTO</b> <br>' +
                '<form action="#">' +
                '<p>' +
                '<input type="checkbox" id="test11"/>' +
                '<label for="test11">209 Notificación en puerta</label>' +
                '<br>' +
                '<input type="checkbox" id="test12"/>' +
                '<label for="test12">210 No reconocen a Deudor </label>' +
                '<br>' +
                '<br>' +
                '<b>3.- ILOCALIZABLE</b><br>' +
                '<input type="checkbox" id="test13"/>' +
                '<label for="test13">211 Inmueble deshabitado</label>' +
                '<br>' +
                '<input type="checkbox" id="test14"/>' +
                '<label for="test14"> 212 No se localiza domicilio</label>' +
                '<br>' +
                '<input type="checkbox" id="test15"/>' +
                '<label for="test15"> 213 Zona de Riesgo</label>' +
                '<br>' +
                '<input type="checkbox" id="test16"/>' +
                '<label for="test16">214 Casa de Renta(Ya no vive en Domicilio)</label>' +
                '<br>' +
                '</p>' +
                '</form>' +
                '</div>' +
                '<div class="col s12">' +
                '<table>' +
                '<thead>' +
                '<tr>' +
                '<th><b>TIPO INMUEBLE</b><br></th>' +
                '<th><b><b>CARACTERISITICAS</b></b><br></th>' +
                '<th><b>COMENTARIOS</b><br></th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test16"/>' +
                '<label for="test16">Casa</label>' +
                '</td>' +
                '<td>' +
                'Color:<input  style="width: 272px;height: 1rem;" type="text">' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test17"/>' +
                '<label for="test17">Vecindad</label>' +
                '</td>' +
                '<td>' +
                'No. Pisos:<input  style="width: 243px;height: 1rem;" type="text">' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test18"/>' +
                '<label for="test18">Departamento</label>' +
                '</td>' +
                '<td>' +
                'No. Ventanas <input style="width:243px;height:1rem;" type = "text" > ' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test19"/>' +
                '<label for="test19">Oficina/Negocio</label> ' +
                '<br>' +
                '</td>' +
                '<td>' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>  ' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test20"/>' +
                '<label for="test20">Otro</label>' +
                '</td>' +
                '<td>' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr> ' +
                '</tbody>' +
                '</table>' +
                '<div class="col s12 ceter-align" style="text-align:center;">' +
                '<b>INFORMACION ADICIONAL</b>' +
                '</div>' +
                '<div class="col s6">' +
                'Domicilio:<input  style="height: 1rem;" type="text"><br>' +
                'Telèfono:<input  style="height: 1rem;" type="text"><br>' +
                'Nombre y parentesco de quien proporciona info:' +
                '<input  style="height: 1rem;" type="text"><br>' +
                'Núm Medidor:<input  style="height: 1rem;width: " type="text"><br>' +
                'Servicio:<input  style="height: 1rem;" type="text"><br>' +
                'Ejecutivo de Campo:<input  style="height: 1rem;" type="text"><br>' +
                'Fecha y Hora:<input  style="height: 1rem;" type="text"><br>' +
                'Confirmaciòn del domicilio con Vecino:<input  style="height: 1rem;" type="text">' +
                '</div>' +
                '<div class="col s6" style="text-align:center;">' +
                '<div>' +
                '<b>MAPA DE UBICACIÓN:</b>' +
                '</div>    ' +
                '<div style="border:solid 1px black;">' +
                '<img src="images/croquis-visita.png" alt="croquis-visitas"  width="100%"> ' +
                '</div>' +
                '</div>' +
                '<div class="col s12" style="text-align: center; margin-top:13px;">' +
                '*****(RECUERDA)QUE LOS CONVENIOS NO DEBEN SER MAYORES A 48HRS *****' +
                '</div>' +
                '<div class="col s12" style="text-align: center;">' +
                '<div class="col s3 offset-s2">F1Visita:<input   style="width: 50%;height: 1rem;"type="text"><br></div>' +
                '<div class="col s3">F2Visita:<input   style="width: 50%;height: 1rem;"type="text"><br></div>' +
                '<div class="col s3">F3Visita:<input   style="width: 50%;height: 1rem;"type="text"><br></div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
    }
    $("#" + id_caja).empty();
    $("#" + id_caja).append(carta);
}
;
//==============================================================================
//==============================================================================
//============== PARTIR DATOS PARA CARTA NOTIFICACION FINAL ====================
function partir_datos_cuenta_carta2(dataRes, id_caja) {
    //partimos los datos por persona 
    var datos_cuentas = dataRes.split("#CORTE#");
    console.log(datos_cuentas);
    var carta = '';
    var i;
    var vueltas = datos_cuentas.length;
    // Empezamos a leer los datos por persona 
    for (i = 0; i < vueltas ; i++) {
        //a qui partimos los datos de forma individual para pintarlos en las cartas

        var datos_persona = datos_cuentas[i].split(",");

        console.log(datos_persona);


        carta += '<div class="carta col s12">' +
                '<br>' +
                '<div class="col s6" style="border-bottom:solid 1px black; height:100px;text-align: left;">' +
                '<img onclick="window.print()" src="images/logo-cliente-z.png" height="100%">' +
                '</div>' +
                '<div class="col s6" style="border-bottom:solid 1px black;height:100px;text-align: right;">' +
                '<p>' +
                'e-mail: ' + datos_persona[0] + ' <br>' +
                'Tels: ' + datos_persona[1] +
                'Fecha: ' + datos_persona[21] +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p>' +
                'ESTIMADO(a): ' + datos_persona[2] + '<br>' +
                'RFC: ' + datos_persona[3] + ' CUENTA: ' + datos_persona[4] + ' <br>' +
                'DOMICILIO: ' + datos_persona[5] + ' COLONIA: ' + datos_persona[6] + ' <br>' +
                'CIUDAD: ' + datos_persona[7] + ' C.P.: ' + datos_persona[8] + ' <br>' +
                'LINEA: ' + datos_persona[9] + ' ADEUDO: ' + datos_persona[10] +
                '</P>' +
                '</div>' +
                '<div class="col s12">' +
                '<h4 class="center-align"><b style="text-decoration:underline;">NOTIFICACION FINAL</b></h4>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'Ante la negativa de pago a los diversos requerimientos hechos en su domicilio así como el teléfonos de contacto y el incumplimiento' +
                'al convenio realizado para el pago de su adeudo, por disposición de la empresa que representamos<b style="text-decoration:underline;">Radio Móvil Dipsa, S.A. DE C.V.</b>' +
                'le informamos que se procede a integrar expediente para escrito inicial de su contra, por lo que se le requiere se comunique dentro de las 24 hrs.' +
                'después de haber recibido esta información con la finalidad de informarle el avance de su procedimiento y garantizar su adeudo.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'De no comunicarse se visitará de inmediato su domicilio para confirmar inspección ocular de bienes muebles e inmuebles, entendiéndonos con la persona' +
                'que se encuentre al momento de la visita y le exigiremos el pago inmediato tanto de la suerte principal como los gastos e intereses que se generen por la falta' +
                'de pagos en esta Cuenta: ' + datos_persona[4] + ' que puede ser por un monto de hasta 3 veces el valor del contrato para garantizar el cumplimiento de la obligación.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'En caso de oposición a las prácticas ordenadas se le informa que a futuro se solicitaran las medidas de apremio necesarias para garantizar' +
                'el pago del adeudo y las costas.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'Es por esa razón, que se le requiere el pago inmediato de la cantidad que adeuda, ahora bien, entendiendo que la comunicación es un acto importante,' +
                'le solicitamos que dentro del término de 24 horas se comunique con nuestros asesores jurídicos a los números telefónicos impresos y aclaremos su situación' +
                'en el entendido que tendrá que regularse en el pago de su adeudo, evitando erogaciones de su parte por concepto de gastos, honorarios u otras prestaciones' +
                'que corresponden al despacho jurídico.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p>' +
                'Le solicitamos se comunique con nosotros lo más pronto posible, ya que, aun sin conocerle creemos que usted es una persona consciente, y en su caso para' +
                'no distraerle mucho su tiempo le pedimos el expediente: ' + datos_persona[13] +
                '</p>' +
                '</div>' +
                '<div class="col s12 center-align">' +
                '<p>ATENTAMENTE<br>' +
                'Departamento de Recuperación Legal<br>' +
                datos_persona[12] + '<br>' +
                '(Teléfono Monterrey y Área Metropolitana)</p>' +
                '</div>' +
                '<div class="col s12" style="margin-top:50px;">' +
                '<p style="text-align: justify">' +
                '<b>NOTA:</b> FAVOR DE HACER CASO OMISO EN CASO DE HABER YA REALIZADO EL PAGO SOLICITADO EN LA PRESENTE. NUESTROS ' +
                'REPRESENTANTES NO ESTARÁN AUTORIZADOS A RECIBIR EFECTIVO, EL PAGO DEVERA REALIZARSE EN CENTROS DE ATENCION TELCEL.' +
                '</p>' +
                '</div>' +
                '<div class="carta col s12 texto2">' +
                '<div class="col s6" style="text-align: left;">' +
                '<p>' +
                'Nombre: ' + datos_persona[2] + '<br>' +
                'Dirección: ' + datos_persona[5] + '<br>' +
                'Colonia: ' + datos_persona[6] + '<br>' +
                'Ciudad: ' + datos_persona[7] + '<br>' +
                'Cuenta: ' + datos_persona[4] + '<br> Expediente: ' + datos_persona[13] + '<br>' +
                '</p>' +
                '</div>' +
                '<div class="col s6" style="text-align: left;">' +
                '<p>' +
                'Asign: ' + datos_persona[14] + '<br>' +
                'Estatus: ' + datos_persona[16] + '<br>' +
                'Saldo: ' + datos_persona[17] + '<br>' +
                'Multa: ' + datos_persona[18] + '<br>' +
                'Total: ' + datos_persona[19] + '<br>' +
                'Saldo Act: ' + datos_persona[20] + '<br>' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<div class="col s6 intro-text">' +
                '<b>1.- CONTACTO</b> <br>   ' +
                '<form action="#">' +
                '<p>' +
                '<input type="checkbox" id="test5"/>' +
                '<label for="test5">201 Promesa de pago / Convenio </label>' +
                '<br>' +
                '<input type="checkbox" id="test6"/>' +
                '<label for="test6">202 Titular ya realizó el pago</label>' +
                '<br>' +
                '<input type="checkbox" id="test7"/>' +
                '<label for="test7">203 Titular no reconoce el adeudo</label>' +
                '<br>' +
                '<input type="checkbox" id="test8"/>' +
                '<label for="test8">204 Deudor está en desacuerdo con adeudo</label>' +
                '<br>' +
                '<input type="checkbox" id="test9"/>' +
                '<label for="test9">205 Notificación con Familiar</label>' +
                '<br>' +
                '<input type="checkbox" id="test1"/>' +
                '<label for="test1">206 Notificación con Familiar/Tercero()</label>' +
                '<br>' +
                '<input type="checkbox" id="test2"/>' +
                '<label for="test2">207 Deudor Falleció</label>' +
                '<br>' +
                '<input type="checkbox" id="test3"/>' +
                '<label for="test3">208 Se niegan a recibir notificación</label>' +
                '<br>' +
                '<input type="checkbox" id="test4"/>' +
                '<label for="test4">215 Titular no define pago</label>' +
                '<br>' +
                '</p>' +
                '</form>' +
                '</div>' +
                '<div class="col s6 intro-text">' +
                '<b>2.- NO CONTACTO</b> <br>' +
                '<form action="#">' +
                '<p>' +
                '<input type="checkbox" id="test11"/>' +
                '<label for="test11">209 Notificación en puerta</label>' +
                '<br>' +
                '<input type="checkbox" id="test12"/>' +
                '<label for="test12">210 No reconocen a Deudor </label>' +
                '<br>' +
                '<br>' +
                '<b>3.- ILOCALIZABLE</b><br>' +
                '<input type="checkbox" id="test13"/>' +
                '<label for="test13">211 Inmueble deshabitado</label>' +
                '<br>' +
                '<input type="checkbox" id="test14"/>' +
                '<label for="test14"> 212 No se localiza domicilio</label>' +
                '<br>' +
                '<input type="checkbox" id="test15"/>' +
                '<label for="test15"> 213 Zona de Riesgo</label>' +
                '<br>' +
                '<input type="checkbox" id="test16"/>' +
                '<label for="test16">214 Casa de Renta(Ya no vive en Domicilio)</label>' +
                '<br>' +
                '</p>' +
                '</form>' +
                '</div>' +
                '<div class="col s12">' +
                '<table>' +
                '<thead>' +
                '<tr>' +
                '<th><b>TIPO INMUEBLE</b><br></th>' +
                '<th><b><b>CARACTERISITICAS</b></b><br></th>' +
                '<th><b>COMENTARIOS</b><br></th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test16"/>' +
                '<label for="test16">Casa</label>' +
                '</td>' +
                '<td>' +
                'Color:<input  style="width: 272px;height: 1rem;" type="text">' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test17"/>' +
                '<label for="test17">Vecindad</label>' +
                '</td>' +
                '<td>' +
                'No. Pisos:<input  style="width: 243px;height: 1rem;" type="text">' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test18"/>' +
                '<label for="test18">Departamento</label>' +
                '</td>' +
                '<td>' +
                'No. Ventanas <input style="width:243px;height:1rem;" type = "text" > ' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test19"/>' +
                '<label for="test19">Oficina/Negocio</label> ' +
                '<br>' +
                '</td>' +
                '<td>' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr>  ' +
                '<tr>' +
                '<td>' +
                '<input type="checkbox" id="test20"/>' +
                '<label for="test20">Otro</label>' +
                '</td>' +
                '<td>' +
                '</td>' +
                '<td>' +
                '<input style="height: .7rem;">' +
                '</td>' +
                '</tr> ' +
                '</tbody>' +
                '</table>' +
                '<div class="col s12 ceter-align" style="text-align:center;">' +
                '<b>INFORMACION ADICIONAL</b>' +
                '</div>' +
                '<div class="col s6">' +
                'Domicilio:<input  style="height: 1rem;" type="text"><br>' +
                'Telèfono:<input  style="height: 1rem;" type="text"><br>' +
                'Nombre y parentesco de quien proporciona info:' +
                '<input  style="height: 1rem;" type="text"><br>' +
                'Núm Medidor:<input  style="height: 1rem;width: " type="text"><br>' +
                'Servicio:<input  style="height: 1rem;" type="text"><br>' +
                'Ejecutivo de Campo:<input  style="height: 1rem;" type="text"><br>' +
                'Fecha y Hora:<input  style="height: 1rem;" type="text"><br>' +
                'Confirmaciòn del domicilio con Vecino:<input  style="height: 1rem;" type="text">' +
                '</div>' +
                '<div class="col s6" style="text-align:center;">' +
                '<div>' +
                '<b>MAPA DE UBICACIÓN:</b>' +
                '</div>    ' +
                '<div style="border:solid 1px black;">' +
                '<img src="images/croquis-visita.png" alt="croquis-visitas"  width="100%"> ' +
                '</div>' +
                '</div>' +
                '<div class="col s12" style="text-align: center; margin-top:13px;">' +
                '*****(RECUERDA)QUE LOS CONVENIOS NO DEBEN SER MAYORES A 48HRS *****' +
                '</div>' +
                '<div class="col s12" style="text-align: center;">' +
                '<div class="col s3 offset-s2">F1Visita:<input   style="width: 50%;height: 1rem;"type="text"><br></div>' +
                '<div class="col s3">F2Visita:<input   style="width: 50%;height: 1rem;"type="text"><br></div>' +
                '<div class="col s3">F3Visita:<input   style="width: 50%;height: 1rem;"type="text"><br></div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
    }


    $("#" + id_caja).empty();
    $("#" + id_caja).append(carta);
}
;
//==============================================================================
//==============================================================================
//==============================================================================

//=========================     PARTIR DATOS INDIVIDUAL  =======================
function partir_datos_cuentas_indi(dataRes) {
    //partimos los datos por persona
    var datos_cuentas = dataRes.split(",");
    console.log(datos_cuentas);
    for (var j = 0; j < datos_cuentas.length; j++) {
        $(".dato" + (j + 1)).empty();
        $(".dato" + (j + 1)).append(datos_cuentas[j]);
    }
}
;
//==============================================================================
function select_asignacion_region_check_visitas(_id_region, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_asignacion_region_check_visitas",
        id_region: _id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
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
function select_ciudades_check(_cadena_asignacion, _id_region, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_ciudades_check",
        cadena_asignacion: _cadena_asignacion,
        id_region: _id_region
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
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
function select_colonias_check(_cadena_asignaciones, _cadena_ciudades, _cadena_codigos, _tipo, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_colonias_check",
        cadena_asignaciones: _cadena_asignaciones,
        cadena_ciudades: _cadena_ciudades,
        cadena_codigos: _cadena_codigos,
        tipo: _tipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
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
function select_codigo_postal_check(_cadena_asignaciones, _cadena_ciudades, _tipo, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_codigo_postal_check",
        cadena_asignaciones: _cadena_asignaciones,
        cadena_ciudades: _cadena_ciudades,
        tipo: _tipo
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
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
function select_status_check(_cadena_asignaciones, _cadena_colonias, _cadena_codigos, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_status_check",
        cadena_asignaciones: _cadena_asignaciones,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
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
function select_datos_segunda_visitas(_id_region, _cadena_asignaciones, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _cadena_ladas, _resto, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_datos_segunda_visitas",
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
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            var num = document.getElementById("lista_user").rows.length;
            $("#info_cartas").empty();
            $("#info_cartas").append(num - 1 + " " + "CARTAS PARA IMPRIMIR");
        }
    });
}
;
// =============================================================================
// ==================== FUNCIONES PARA IMPRIMIR CARTEO =========================
// =============================================================================
function select_datos_carteo(_id_region, _id_asignacion, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _resto, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_datos_carteo",
        id_region: _id_region,
        id_asignacion: _id_asignacion,
        cadena_ciudades: _cadena_ciudades,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos,
        resto: _resto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert("estoy llegando a la base" + dataRes);
            console.log(dataRes);
            paint_letter_previa(dataRes, _id_caja);
        }
    });
}
;
// =============================================================================
function select_datos_segundo_carteo(_id_region, _id_asignacion, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _resto, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_datos_segundo_carteo",
        id_region: _id_region,
        id_asignacion: _id_asignacion,
        cadena_ciudades: _cadena_ciudades,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos,
        resto: _resto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            paint_letter_previa(dataRes, _id_caja);
        }
    });
}
;
//==============================================================================
function select_datos_segundo_carteo_tabla(_id_region, _id_asignacion, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _resto, _id_caja) {
    $("#" + _id_caja).empty();
    $("#" + _id_caja).append("<div style='text-align:center;'><br><img src='images/cargando-fb.gif'><br></div>");
    var params = {
        accion: "select_datos_segundo_carteo_tabla",
        id_region: _id_region,
        id_asignacion: _id_asignacion,
        cadena_ciudades: _cadena_ciudades,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos,
        resto: _resto

    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            var num = document.getElementById("lista_user").rows.length;
            $("#info_cartas").empty();
            $("#info_cartas").append(num - 1 + " " + "CARTAS PARA IMPRIMIR");
        }
    });
}
;
//==============================================================================
//========= UPDATE DE NUMERO DE CARTA PARA SEGUNDO CARTEO O MAS ================
function update_numero_carta(_id_region, _id_asignacion, _cadena_ciudades, _cadena_colonias, _cadena_codigos) {
    alert("ACTUALIZANDO EL NUMERO DE CARTA.. ");
    var params = {
        accion: "update_numero_carta",
        id_region: _id_region,
        id_asignacion: _id_asignacion,
        cadena_ciudades: _cadena_ciudades,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;
//==============================================================================

function paint_letter_previa(dataRes, id_caja) {
    //partimos los datos por persona 
    var datos_cuentas = dataRes.split("#CORTE#");
    console.log(datos_cuentas);
    var carta = '';
    // Empezamos a leer los datos por persona 
    for (var i = 0; i < datos_cuentas.length; i++) {
        //a qui partimos los datos de forma individual para pintarlos en las cartas
        var datos_persona = datos_cuentas[i].split(",");
        console.log(datos_persona);
        carta += '<div class="carta col s12">' +
                '<br> <br>' +
                '<div class="col s6" style="border-bottom:solid 1px black; height:100px;text-align: left;">' +
                '<img onclick="window.print()" src="images/logo-cliente-z.png" height="100%">' +
                '</div>' +
                '<div class="col s6" style="border-bottom:solid 1px black;height:100px;text-align: right;">' +
                '<p>' +
                'e-mail: ' + datos_persona[0] + ' <br>' +
                'Tels: ' + datos_persona[1] +
                'Fecha: ' + datos_persona[15] +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p>' +
                'ESTIMADO(a): ' + datos_persona[2] + '<br>' +
                'RFC: ' + datos_persona[3] + ' CUENTA: ' + datos_persona[4] + ' <br>' +
                'DOMICILIO: ' + datos_persona[5] + ' COLONIA: ' + datos_persona[6] + ' <br>' +
                'CIUDAD: ' + datos_persona[7] + ' C.P.: ' + datos_persona[8] + ' <br>' +
                'LINEA: ' + datos_persona[9] + ' ADEUDO: ' + datos_persona[10] +
                '</P>' +
                '</div>' +
                '<div class="col s12">' +
                '<h4 class="center-align"><b style="text-decoration:underline;">PREVIA NOTIFICACION</b></h4>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'DEBIDO A QUE USTED NO ANTENDIÓ LOS REQUERIMIENTOS DE PAGO QUE EN FECHAS ANTERIORES SE LE HAN ENVIADO POR EL ADEUDO VENCIDO QUE PRESENTA' +
                'EN SU PLAN TARIFARO(TELCEL), SE LE NOTIFICA QUE SE PROCEDERÁ A EJERCER LA COBRANZA DE DICHA DEUDA POR MEDIO DE DEMANDA VÍA AFIANZADORA, DÁNDOSE POR ENTERADO' +
                'QUE YA SE ENCUENTRA BOLETINADO EN EL  <b style="text-decoration:underline;">BÚRO NACIONAL DE CRÉDITO</b> COMO PERSONA QUE NO CUMPLE CON SUS COMPROMISOS DE PAGO.' +
                '</p>' +
                '</div>' +
                '<div class="col s12" style="height:145px;">' +
                '<p style="text-align: justify">' +
                'POR LO TANTO, NOS VEMOS INSTADOS A REQUERIRLE DEL INMEDIATO PAGO TOTAL DEL ADEUDO VENCIDO, COMPUESTO DE PRINCIPAL Y SUERTES ACCESORIAS,' +
                'PARA QUE PASE AL CENTREO DE ATENCIÓN DE TELCEL HOY MISMO O SU DÍA INMEDIATO HÁBIL A LIQUIDAR PARA EVITAR LA DEMANDA POR MEDIO DE LA AFIANZADORA' +
                '</p>' +
                '</div>' +
                '<div class="col s12" style="height:200px;">' +
                '<p><b style="text-decoration:underline;">' +
                'EVÍTESE UN PROBLEMA Y LA PENA MORAL DE VERSE PRESIONADO POR SU UNCUMPLIMIENTO DE PAGO EN EL CONTRATO DE SU LÍNE TELCEL, PUES NOSOTROS AÚN' +
                'CREEMOS EN LA HONORABILIDAD DE LAS PERSONAS Y SUS ACTOS DE COMERCIO Y SIEMPRE ESTAMOS DISPUESTOS A UN ARREGLO PERTINENTE. CUMPLA CON SUS OBLIGACIONES DE PAGO,' +
                '</b></p>' +
                '</div>' +
                '<div class="col s12 center-align">' +
                '<p>ATENTAMENTE<br>' +
                'Departamento de Recuperación Legal<br>' +
                datos_persona[1] + '<br>' +
                '(Teléfono Monterrey y Área Metropolitana)</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                '<b>NOTA:</b> FAVOR DE HACER CASO OMISO EN CASO DE HABER YA REALIZADO EL PAGO SOLICITADO EN LA PRESENTE. NUESTROS ' +
                'REPRESENTANTES NO ESTARÁN AUTORIZADOS A RECIBIR EFECTIVO, EL PAGO DEVERA REALIZARSE EN CENTROS DE ATENCION TELCEL.' +
                '</p>' +
                '</div>' +
                '</div>';
    }
    $("#" + id_caja).empty();
    $("#" + id_caja).append(carta);
}
;
//==============================================================================
function paint_letter_final(dataRes, id_caja) {
    //partimos los datos por persona 
    var datos_cuentas = dataRes.split("#CORTE#");
    console.log(datos_cuentas);
    var carta = '';
    // Empezamos a leer los datos por persona 
    for (var i = 0; i < datos_cuentas.length; i++) {
        //a qui partimos los datos de forma individual para pintarlos en las cartas
        var datos_persona = datos_cuentas[i].split(",");
        console.log(datos_persona);
        carta += '<div class="carta col s12">' +
                '<br> <br>' +
                '<div class="col s6" style="border-bottom:solid 1px black; height:100px;text-align: left;">' +
                '<img onclick="window.print()" src="images/logo-cliente-z.png" height="100%">' +
                '</div>' +
                '<div class="col s6" style="border-bottom:solid 1px black;height:100px;text-align: right;">' +
                '<p>' +
                'e-mail: ' + datos_persona[0] + ' <br>' +
                'Tels: ' + datos_persona[1] +
                'Fecha: ' + datos_persona[15] +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p>' +
                'ESTIMADO(a): ' + datos_persona[2] + '<br>' +
                'RFC: ' + datos_persona[3] + ' CUENTA: ' + datos_persona[4] + ' <br>' +
                'DOMICILIO: ' + datos_persona[5] + ' COLONIA: ' + datos_persona[6] + ' <br>' +
                'CIUDAD: ' + datos_persona[7] + ' C.P.: ' + datos_persona[8] + ' <br>' +
                'LINEA: ' + datos_persona[9] + ' ADEUDO: ' + datos_persona[10] +
                '</P>' +
                '</div>' +
                '<div class="col s12">' +
                '<h4 class="center-align"><b style="text-decoration:underline;">NOTIFICACION FINAL</b></h4>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'Ante la negativa de pago a los diversos requerimientos hechos en su domicilio así como el teléfonos de contacto y el incumplimiento' +
                'al convenio realizado para el pago de su adeudo, por disposición de la empresa que representamos<b style="text-decoration:underline;">Radio Móvil Dipsa, S.A. DE C.V.</b>' +
                'le informamos que se procede a integrar expediente para escrito inicial de su contra, por lo que se le requiere se comunique dentro de las 24 hrs.' +
                'después de haber recibido esta información con la finalidad de informarle el avance de su procedimiento y garantizar su adeudo.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'De no comunicarse se visitará de inmediato su domicilio para confirmar inspección ocular de bienes muebles e inmuebles, entendiéndonos con la persona' +
                'que se encuentre al momento de la visita y le exigiremos el pago inmediato tanto de la suerte principal como los gastos e intereses que se generen por la falta' +
                'de pagos en esta Cuenta: ' + datos_persona[4] + ' que puede ser por un monto de hasta 3 veces el valor del contrato para garantizar el cumplimiento de la obligación.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'En caso de oposición a las prácticas ordenadas se le informa que a futuro se solicitaran las medidas de apremio necesarias para garantizar' +
                'el pago del adeudo y las costas.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                'Es por esa razón, que se le requiere el pago inmediato de la cantidad que adeuda, ahora bien, entendiendo que la comunicación es un acto importante,' +
                'le solicitamos que dentro del término de 24 horas se comunique con nuestros asesores jurídicos a los números telefónicos impresos y aclaremos su situación' +
                'en el entendido que tendrá que regularse en el pago de su adeudo, evitando erogaciones de su parte por concepto de gastos, honorarios u otras prestaciones' +
                'que corresponden al despacho jurídico.' +
                '</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p>' +
                'Le solicitamos se comunique con nosotros lo más pronto posible, ya que, aun sin conocerle creemos que usted es una persona consciente, y en su caso para' +
                'no distraerle mucho su tiempo le pedimos el expediente: ' + datos_persona[11] +
                '</p>' +
                '</div>' +
                '<div class="col s12 center-align">' +
                '<p>ATENTAMENTE<br>' +
                'Departamento de Recuperación Legal<br>' +
                datos_persona[1] + '<br>' +
                '(Teléfono Monterrey y Área Metropolitana)</p>' +
                '</div>' +
                '<div class="col s12">' +
                '<p style="text-align: justify">' +
                '<b>NOTA:</b> FAVOR DE HACER CASO OMISO EN CASO DE HABER YA REALIZADO EL PAGO SOLICITADO EN LA PRESENTE. NUESTROS ' +
                'REPRESENTANTES NO ESTARÁN AUTORIZADOS A RECIBIR EFECTIVO, EL PAGO DEVERA REALIZARSE EN CENTROS DE ATENCION TELCEL.' +
                '</p>' +
                '</div>';
    }
    $("#" + id_caja).empty();
    $("#" + id_caja).append(carta);
}
;
//==============================================================================
function insert_datos_carteo(_id_region, _id_asignacion, _cadena_ciudades, _cadena_colonias, _cadena_codigos, _resto) {
    var params = {
        accion: "insert_datos_carteo",
        id_region: _id_region,
        id_asignacion: _id_asignacion,
        cadena_ciudades: _cadena_ciudades,
        cadena_colonias: _cadena_colonias,
        cadena_codigos: _cadena_codigos,
        resto: _resto
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageVisita",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert("se Ha Guardo Un Registro De Las Cuentas Que Se Le Mandaran Una La Carta " + dataRes);
        }
    });
}
;
//==============================================================================