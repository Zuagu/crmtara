//==============================================================================
function select_solicitudes_tabla(_filtro, _id_caja) {
    var params = {
        accion: "select_solicitudes_tabla",
        filtro: _filtro
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function insert_solicitud(
        _nombre,
        _puesto,
        _fecha,
        _exp,
        _sucursal,
        _medio,
        _reclutador,
        _calle,
        _tel,
        _cel,
        _colonia,
        _ciudad,
        _mail,
        _fecha_n,
        _lugar_n,
        _sexo,
        _edad,
        _num_imss,
        _clinica,
        _civil,
        _religion,
        _rfc,
        _dep_eco,
        _curp,
        _infonavit,
        _complexion,
        _edo_sal,
        _tipo_empleo,
        _cambio_res,
        _viajar,
        _auto,
        _lic,
        _extra,
        _tbj_act,
        _horario_1,
        _est_act,
        _horario_2,
        _call_center,
        _mora,
        _nivel,
        _grado,
        _idioma_1,
        _rango_1,
        _idioma_2,
        _rango_2,
        _software,
        _padre,
        _edad_padre,
        _domicilio_padre,
        _ocupacion_padre,
        _madre,
        _edad_madre,
        _domicilio_madre,
        _ocupacion_madre,
        _otro_1,
        _otro_1_edad,
        _otro_1_domicilio,
        _otro_1_ocupacion,
        _otro_2,
        _otro_2_edad,
        _otro_2_domicilio,
        _otro_2_ocupacion,
        _nombre_1,
        _giro_1,
        _area_1,
        _puesto_1,
        _domi_1,
        _dura_1,
        _mora_1,
        _tel_1,
        _jefe_1,
        _inicio_1,
        _termina_1,
        _sueldo_1,
        _comision_1,
        _producto_1,
        _motivo_1,
        _rh_1,
        _funcion_1,
        _tec_1,
        _nombre_2,
        _giro_2,
        _area_2,
        _puesto_2,
        _domi_2,
        _dura_2,
        _mora_2,
        _tel_2,
        _jefe_2,
        _inicio_2,
        _termina_2,
        _sueldo_2,
        _comision_2,
        _producto_2,
        _motivo_2,
        _rh_2,
        _funcion_2,
        _tec_2,
        _nombre_3,
        _giro_3,
        _area_3,
        _puesto_3,
        _domi_3,
        _dura_3,
        _mora_3,
        _tel_3,
        _jefe_3,
        _inicio_3,
        _termina_3,
        _sueldo_3,
        _comision_3,
        _producto_3,
        _motivo_3,
        _rh_3,
        _funcion_3,
        _tec_3,
        _virtud,
        _especificaMedio,
        _alias
        ) {
    var params = {
        accion: "insert_solicitud",
        nombre: _nombre,
        puesto: _puesto,
        fecha: _fecha,
        exp: _exp,
        sucursal: _sucursal,
        medio: _medio,
        reclutador: _reclutador,
        calle: _calle,
        tel: _tel,
        cel: _cel,
        colonia: _colonia,
        ciudad: _ciudad,
        mail: _mail,
        fecha_n: _fecha_n,
        lugar_n: _lugar_n,
        sexo: _sexo,
        edad: _edad,
        num_imss: _num_imss,
        clinica: _clinica,
        civil: _civil,
        religion: _religion,
        rfc: _rfc,
        dep_eco: _dep_eco,
        curp: _curp,
        infonavit: _infonavit,
        complexion: _complexion,
        edo_sal: _edo_sal,
        tipo_empleo: _tipo_empleo,
        cambio_res: _cambio_res,
        viajar: _viajar,
        auto: _auto,
        lic: _lic,
        extra: _extra,
        tbj_act: _tbj_act,
        horario_1: _horario_1,
        est_act: _est_act,
        horario_2: _horario_2,
        call_center: _call_center,
        mora: _mora,
        nivel: _nivel,
        grado: _grado,
        idioma_1: _idioma_1,
        rango_1: _rango_1,
        idioma_2: _idioma_2,
        rango_2: _rango_2,
        software: _software,
        padre: _padre,
        edad_padre: _edad_padre,
        domicilio_padre: _domicilio_padre,
        ocupacion_padre: _ocupacion_padre,
        madre: _madre,
        edad_madre: _edad_madre,
        domicilio_madre: _domicilio_madre,
        ocupacion_madre: _ocupacion_madre,
        otro_1: _otro_1,
        otro_1_edad: _otro_1_edad,
        otro_1_domicilio: _otro_1_domicilio,
        otro_1_ocupacion: _otro_1_ocupacion,
        otro_2: _otro_2,
        otro_2_edad: _otro_2_edad,
        otro_2_domicilio: _otro_2_domicilio,
        otro_2_ocupacion: _otro_2_ocupacion,
        nombre_1: _nombre_1,
        giro_1: _giro_1,
        area_1: _area_1,
        puesto_1: _puesto_1,
        domi_1: _domi_1,
        dura_1: _dura_1,
        mora_1: _mora_1,
        tel_1: _tel_1,
        jefe_1: _jefe_1,
        inicio_1: _inicio_1,
        termina_1: _termina_1,
        sueldo_1: _sueldo_1,
        comision_1: _comision_1,
        producto_1: _producto_1,
        motivo_1: _motivo_1,
        rh_1: _rh_1,
        funcion_1: _funcion_1,
        tec_1: _tec_1,
        nombre_2: _nombre_2,
        giro_2: _giro_2,
        area_2: _area_2,
        puesto_2: _puesto_2,
        domi_2: _domi_2,
        dura_2: _dura_2,
        mora_2: _mora_2,
        tel_2: _tel_2,
        jefe_2: _jefe_2,
        inicio_2: _inicio_2,
        termina_2: _termina_2,
        sueldo_2: _sueldo_2,
        comision_2: _comision_2,
        producto_2: _producto_2,
        motivo_2: _motivo_2,
        rh_2: _rh_2,
        funcion_2: _funcion_2,
        tec_2: _tec_2,
        nombre_3: _nombre_3,
        giro_3: _giro_3,
        area_3: _area_3,
        puesto_3: _puesto_3,
        domi_3: _domi_3,
        dura_3: _dura_3,
        mora_3: _mora_3,
        tel_3: _tel_3,
        jefe_3: _jefe_3,
        inicio_3: _inicio_3,
        termina_3: _termina_3,
        sueldo_3: _sueldo_3,
        comision_3: _comision_3,
        producto_3: _producto_3,
        motivo_3: _motivo_3,
        rh_3: _rh_3,
        funcion_3: _funcion_3,
        tec_3: _tec_3,
        virtud: _virtud,
        especificaMedio: _especificaMedio,
        alias: _alias
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            alert(dataRes);
        }
    });
}
;

//=============================================================================
function partir_datos(dataRes, _campo, _forlimit) {
    var campos = dataRes.split("#$");
    console.log(campos);
    for (i = 1; i <= _forlimit; i++) {
        console.log("#" + _campo + i + " valor { " + campos[i] + " }");
        $("#" + _campo + i).empty();
        $("#" + _campo + i).val(campos[i]);
    }


    $("#evaluador_rh").empty();
    $("#evaluador_rh").val(campos[133]);
    $("#anexo").empty();
    $("#anexo").val(campos[134]);
    $("#anexo_rh").empty();
    $("#anexo_rh").val(campos[135]);
    $("#fecha_ingreso").empty();
    $("#fecha_ingreso").val(campos[126]);


    $("#" + _campo + 2).empty();
    $("#" + _campo + 2).append('<option value="' + campos[2] + '">' + campos[2] + '</option>' +
            '<option value="Ninguno">Ninguno</option>' +
            '<option value="Gestor">Gestor</option>' +
            '<option value="Reclutador">Reclutador</option>' +
            '<option value="Supervisor">Supervisor</option>' +
            '<option value="Otros">Otros</option>'
            );

    $("#" + _campo + 4).empty();
    $("#" + _campo + 4).append('<option value="' + campos[4] + '">' + campos[4] + '</option>' +
            '<option value="Ninguno">Ninguno</option>' +
            '<option value="Predictivo">Predictivo</option>' +
            '<option value="Manual">Manual</option>' +
            '<option value="Ambos">Ambos</option>'
            );

    $("#" + _campo + 5).empty();
    $("#" + _campo + 5).append('<option value="' + campos[5] + '">' + campos[5] + '</option>' +
            '<option value="Publicidad Fija">Publicidad Fija</option>' +
            '<option value="Bolsas Electronicas">Bolsas Electronicas</option>' +
            '<option value="Trabajo en Campo">Trabajo en Campo</option>' +
            '<option value="Redes Sociales">Redes Sociales</option>' +
            '<option value="Otros">Otros</option>' +
            '<option value="Escuelas">Escuelas</option>' +
            '<option value="Periodico">Periodico</option>' +
            '<option value="Bolsas Municipales">Bolsas Municipales</option>' +
            '<option value="Intercambio de Bolsas">Intercambio de Bolsas</option>'+
            '<option value="Outsourcing">Outsourcing</option>'
            );
    $("#" + _campo + 131).empty();
    $("#" + _campo + 131).append('<option value="' + campos[131] + '">' + campos[131] + '</option>'
            );

    $("#" + _campo + 15).empty();
    $("#" + _campo + 15).append('<option value="' + campos[15] + '">' + campos[15] + '</option>' +
            '<option value="Hombre">Hombre</option>' +
            '<option value="Mujer">Mujer</option>'
            );

    $("#" + _campo + 19).empty();
    $("#" + _campo + 19).append('<option value="' + campos[19] + '">' + campos[19] + '</option>' +
            '<option value="Soltero(a)">Soltero(a)</option>' +
            '<option value="Casado(a)">Casado(a)</option>' +
            '<option value="Union Libre">Union Libre</option>' +
            '<option value="Divorciado(a)">Divorciado(a)</option>' +
            '<option value="Viudo(a)">Viudo(a)</option>'
            );

    $("#" + _campo + 20).empty();
    $("#" + _campo + 20).append('<option value="' + campos[20] + '">' + campos[20] + '</option>' +
            '<option value="Catolica">Catolica</option>' +
            '<option value="Cristiana">Cristiana</option>' +
            '<option value="Testigo de Jehova">Testigo de Jehova</option>' +
            '<option value="Mormones">Mormones</option>' +
            '<option value="Ateo">Ateo</option>' +
            '<option value="Otro">Otro</option>'
            );

    $("#" + _campo + 25).empty();
    $("#" + _campo + 25).append('<option value="' + campos[25] + '">' + campos[25] + '</option>' +
            '<option value="Delgada">Delgada</option>' +
            '<option value="Media">Media</option>' +
            '<option value="Robusta">Robusta</option>'
            );

    $("#" + _campo + 26).empty();
    $("#" + _campo + 26).append('<option value="' + campos[26] + '">' + campos[26] + '</option>' +
            '<option value="Bueno">Bueno</option>' +
            ' <option value="Malo">Malo</option>' +
            '<option value="Regular">Regular</option>'
            );

    $("#" + _campo + 27).empty();
    $("#" + _campo + 27).append('<option value="' + campos[27] + '">' + campos[27] + '</option>' +
            '<option value="Completo">Completo</option>' +
            '<option value="Parcial">Parcial</option>' +
            '<option value="Rotativo">Rotativo</option>' +
            '<option value="Fijo">Fijo</option>'
            );

    $("#" + _campo + 28).empty();
    $("#" + _campo + 28).append('<option value="' + campos[28] + '">' + campos[28] + '</option>' +
            '<option value="Si">Si</option>' +
            '<option value="No">No</option>'
            );

    $("#" + _campo + 29).empty();
    $("#" + _campo + 29).append('<option value="' + campos[29] + '">' + campos[29] + '</option>' +
            '<option value="Si">Si</option>' +
            '<option value="No">No</option>'
            );

    $("#" + _campo + 30).empty();
    $("#" + _campo + 30).append('<option value="' + campos[30] + '">' + campos[30] + '</option>' +
            '<option value="Si">Si</option>' +
            '<option value="No">No</option>'
            );

    $("#" + _campo + 31).empty();
    $("#" + _campo + 31).append('<option value="' + campos[31] + '">' + campos[31] + '</option>' +
            '<option value="Si">Si</option>' +
            '<option value="No">No</option>'
            );

    $("#" + _campo + 33).empty();
    $("#" + _campo + 33).append('<option value="' + campos[33] + '">' + campos[33] + '</option>' +
            '<option value="Si">Si</option>' +
            '<option value="No">No</option>'
            );

    $("#" + _campo + 35).empty();
    $("#" + _campo + 35).append('<option value="' + campos[35] + '">' + campos[35] + '</option>' +
            '<option value="Si">Si</option>' +
            '<option value="No">No</option>'
            );

    $("#" + _campo + 37).empty();
    $("#" + _campo + 37).append('<option value="' + campos[37] + '">' + campos[37] + '</option>' +
            '<option value="Cobranza">Cobranza</option>' +
            '<option value="Atencion a Clientes">Atencion a Clientes</option>' +
            '<option value="Ventas">Ventas</option>' +
            '<option value="Ninguno">Ninguno</option>'
            );

    $("#" + _campo + 38).empty();
    $("#" + _campo + 38).append('<option value="' + campos[38] + '">' + campos[38] + '</option>' +
            '<option value="Ninguna">Ninguna</option>' +
            '<option value="30">30</option>' +
            '<option value="60">60</option>' +
            '<option value="90">90</option>' +
            '<option value="120">120</option>' +
            '<option value="Mas">Mas</option>'
            );

    $("#" + _campo + 39).empty();
    $("#" + _campo + 39).append('<option value="' + campos[39] + '">' + campos[39] + '</option>' +
            '<option value="Ninguna">Ninguna</option>' +
            '<option value="Primaria">Primaria</option>' +
            '<option value="Secundaria">Secundaria</option>' +
            '<option value="Preparatoria">Preparatoria</option>' +
            '<option value="Tecnica">Tecnica</option>' +
            '<option value="Profesional">Profesional</option>'
            );

    $("#" + _campo + 116).empty();
    $("#" + _campo + 116).append('<option value="' + campos[116] + '">' + campos[116] + '</option>' +
            '<option value="Monterrey">Monterrey</option>' +
            '<option value="Puebla">Puebla</option>'
            );
    $("#presentacion").empty();
    $("#presentacion").append('<option value="' + campos[117] + '">' + campos[117] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#experiencia").empty();
    $("#experiencia").append('<option value="' + campos[118] + '">' + campos[118] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#facilidad").empty();
    $("#facilidad").append('<option value="' + campos[119] + '">' + campos[119] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#normas").empty();
    $("#normas").append('<option value="' + campos[120] + '">' + campos[120] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#influencia").empty();
    $("#influencia").append('<option value="' + campos[121] + '">' + campos[121] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#equipo").empty();
    $("#equipo").append('<option value="' + campos[122] + '">' + campos[122] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#estabilidad").empty();
    $("#estabilidad").append('<option value="' + campos[123] + '">' + campos[123] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#logro").empty();
    $("#logro").append('<option value="' + campos[124] + '">' + campos[124] + '</option>' +
            '<option value="Mal">Mal</option>' +
            '<option value="Regular">Regular</option>' +
            '<option value="Bien">Bien</option>' +
            '<option value="Muy Bien">Muy Bien</option>'
            );

    $("#contratacion").empty();
    $("#contratacion").append('<option value="' + campos[125] + '">' + campos[125] + '</option>' + '<option value="Aprobado">Aprobado</option>' +
            '<option value="Caido">Caido</option>' +
            '<option value="Stand By">Stand By</option>' +
            '<option value="No Aplica">No Aplica</option>'
            );

    $("#reclutador_rh").empty();
    $("#reclutador_rh").val(campos[127]);

    $("#dato142").empty();
    $("#dato142").append('<option value="' + campos[130] + '">' + campos[130] + '</option>');



    $('select').material_select();

}
;
//==============================================================================
function select_datos_solicitud(_id_solicitud) {
    var params = {
        accion: "select_datos_solicitud",
        id_solicitud: _id_solicitud
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            partir_datos(dataRes, "dato", 132);
        }
    });
}
;
//==============================================================================
//==============================================================================
function enviar_evaluacion(
        _dato1,
        _dato2,
        _dato3,
        _dato4,
        _dato5,
        _dato6,
        _dato7,
        _dato8,
        _dato9,
        _dato10,
        _dato11,
        _dato12,
        _dato13,
        _dato14,
        _dato15,
        _dato16,
        _dato17,
        _dato18,
        _dato19,
        _dato20,
        _dato21,
        _dato22,
        _dato23,
        _dato24,
        _dato25,
        _dato26,
        _dato27,
        _dato28,
        _dato29,
        _dato30,
        _dato31,
        _dato32,
        _dato33,
        _dato34,
        _dato35,
        _dato36,
        _dato37,
        _dato38,
        _dato39,
        _dato40,
        _dato41,
        _dato42,
        _dato43,
        _dato44,
        _dato45,
        _dato46,
        _dato47,
        _dato48,
        _dato49,
        _dato50,
        _dato51,
        _dato52,
        _dato53,
        _dato54,
        _dato55,
        _dato56,
        _dato57,
        _dato58,
        _dato59,
        _dato60,
        _dato61,
        _dato62,
        _dato63,
        _dato64,
        _dato65,
        _dato66,
        _dato67,
        _dato68,
        _dato69,
        _dato70,
        _dato71,
        _dato72,
        _dato73,
        _dato74,
        _dato75,
        _dato76,
        _dato77,
        _dato78,
        _dato79,
        _dato80,
        _dato81,
        _dato82,
        _dato83,
        _dato84,
        _dato85,
        _dato86,
        _dato87,
        _dato88,
        _dato89,
        _dato90,
        _dato91,
        _dato92,
        _dato93,
        _dato94,
        _dato95,
        _dato96,
        _dato97,
        _dato98,
        _dato99,
        _dato100,
        _dato101,
        _dato102,
        _dato103,
        _dato104,
        _dato105,
        _dato106,
        _dato107,
        _dato108,
        _dato109,
        _dato110,
        _dato111,
        _dato112,
        _dato113,
        _dato114,
        _dato115,
        _dato116,
        _id_seleccion, _presentacion, _experiencia, _facilidad, _normas, _influencia, _equipo, _estabilidad, _logro, _contratacion, _fecha_ingreso, _nombre_reclutador, _dato128, _dato129, _dato130, _dato131, _dato132, _evaluador_rh, _anexo, _anexo_rh) {
    var params = {
        accion: "enviar_evaluacion",
        dato1: _dato1,
        dato2: _dato2,
        dato3: _dato3,
        dato4: _dato4,
        dato5: _dato5,
        dato6: _dato6,
        dato7: _dato7,
        dato8: _dato8,
        dato9: _dato9,
        dato10: _dato10,
        dato11: _dato11,
        dato12: _dato12,
        dato13: _dato13,
        dato14: _dato14,
        dato15: _dato15,
        dato16: _dato16,
        dato17: _dato17,
        dato18: _dato18,
        dato19: _dato19,
        dato20: _dato20,
        dato21: _dato21,
        dato22: _dato22,
        dato23: _dato23,
        dato24: _dato24,
        dato25: _dato25,
        dato26: _dato26,
        dato27: _dato27,
        dato28: _dato28,
        dato29: _dato29,
        dato30: _dato30,
        dato31: _dato31,
        dato32: _dato32,
        dato33: _dato33,
        dato34: _dato34,
        dato35: _dato35,
        dato36: _dato36,
        dato37: _dato37,
        dato38: _dato38,
        dato39: _dato39,
        dato40: _dato40,
        dato41: _dato41,
        dato42: _dato42,
        dato43: _dato43,
        dato44: _dato44,
        dato45: _dato45,
        dato46: _dato46,
        dato47: _dato47,
        dato48: _dato48,
        dato49: _dato49,
        dato50: _dato50,
        dato51: _dato51,
        dato52: _dato52,
        dato53: _dato53,
        dato54: _dato54,
        dato55: _dato55,
        dato56: _dato56,
        dato57: _dato57,
        dato58: _dato58,
        dato59: _dato59,
        dato60: _dato60,
        dato61: _dato61,
        dato62: _dato62,
        dato63: _dato63,
        dato64: _dato64,
        dato65: _dato65,
        dato66: _dato66,
        dato67: _dato67,
        dato68: _dato68,
        dato69: _dato69,
        dato70: _dato70,
        dato71: _dato71,
        dato72: _dato72,
        dato73: _dato73,
        dato74: _dato74,
        dato75: _dato75,
        dato76: _dato76,
        dato77: _dato77,
        dato78: _dato78,
        dato79: _dato79,
        dato80: _dato80,
        dato81: _dato81,
        dato82: _dato82,
        dato83: _dato83,
        dato84: _dato84,
        dato85: _dato85,
        dato86: _dato86,
        dato87: _dato87,
        dato88: _dato88,
        dato89: _dato89,
        dato90: _dato90,
        dato91: _dato91,
        dato92: _dato92,
        dato93: _dato93,
        dato94: _dato94,
        dato95: _dato95,
        dato96: _dato96,
        dato97: _dato97,
        dato98: _dato98,
        dato99: _dato99,
        dato100: _dato100,
        dato101: _dato101,
        dato102: _dato102,
        dato103: _dato103,
        dato104: _dato104,
        dato105: _dato105,
        dato106: _dato106,
        dato107: _dato107,
        dato108: _dato108,
        dato109: _dato109,
        dato110: _dato110,
        dato111: _dato111,
        dato112: _dato112,
        dato113: _dato113,
        dato114: _dato114,
        dato115: _dato115,
        dato116: _dato116,
        id_solicitud: _id_seleccion,
        presentacion: _presentacion,
        experiencia: _experiencia,
        facilidad: _facilidad,
        normas: _normas,
        influencia: _influencia,
        equipo: _equipo,
        estabilidad: _estabilidad,
        logro: _logro,
        contratacion: _contratacion,
        fecha_ingreso: _fecha_ingreso,
        nombre_reclutador: _nombre_reclutador,
        referido: _dato128,
        observacion: _dato129,
        virtud: _dato131,
        especificaMedio: _dato130,
        alias: _dato132,
        evaluador_rh: _evaluador_rh,
        anexo: _anexo,
        anexo_rh: _anexo_rh
    };
    console.log("DATOS ENVIADOS PARA HACER EL UPDATE");
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#div_solicitudes").show();
            $("#div_evaluacion").hide();
            alert(dataRes);
            select_solicitudes_tabla('', "listado_solicitudes");
        }
    });
}
;
//==============================================================================
function usuarios_datos(_nombre, _alias, _sucursal, _sexo, _tel, _cel, _mail, _codigo_reclutador) {
    var params = {
        accion: "insert_nuevo_usuario",
        nombre_usu: _nombre,
        alias_usu: _alias,
        sucursal_usu: _sucursal,
        sexo_usu: _sexo,
        tel_usu: _tel,
        cel_usu: _cel,
        mail_usu: _mail,
        codigo_reclutador: _codigo_reclutador
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            if (dataRes == '') {
                alert("errorrrrrr");
            } else {
                $("#idUsu").text(dataRes);
            }
        }
    });
}
;
//==============================================================================
function update_chunnun(_idusu, _acta, _ife, _nss, _curp1, _comp_est, _comp_dom, _cartas, _fotos, _infonavit1) {
    console.log(_idusu, _acta, _ife, _nss, _curp1, _comp_est, _comp_dom, _cartas, _fotos, _infonavit1);
    var params = {
        accion: "update_chunnun",
        idusu: _idusu,
        acta: _acta,
        ife: _ife,
        nss: _nss,
        curp1: _curp1,
        comp_est: _comp_est,
        comp_dom: _comp_dom,
        cartas: _cartas,
        fotos: _fotos,
        infonavit1: _infonavit1

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
}
;
//==============================================================================
function datos_grafica_dashboart() {

    var params = {
        accion: "datos_grafica_dashboart"
    };

    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            datos_graficas(dataRes);
        }
    });
}
;
//==============================================================================
function datos_grafica_dashboart_mensual(_mes, _desde, _hasta) {
    var params = {
        accion: "datos_grafica_dashboart2",
        mes: _mes,
        desde: _desde,
        hasta: _hasta
    };

    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("container").empty();
            datos_graficas(dataRes);

        }
    });
}
;
//==============================================================================
function datos_graficas(dataRes) {
    console.log(dataRes);
    datos = dataRes.split(",#");
    var datos_para_grafica = [];

    console.log(datos);
    for (var i = 0; i < datos.length - 1; i++) {
        datos_para_grafica[i] = datos[i].split(",");
    }
    console.log(datos_para_grafica);

    for (var i = 1; i < datos.length - 1; i++) {
        datos_para_grafica[i] = datos_para_grafica[i].map(Number);
    }
    console.log(datos_para_grafica[0]);
    console.log(datos_para_grafica[1]);
    console.log(datos_para_grafica[2]);
    console.log(datos_para_grafica[3]);
    console.log(datos_para_grafica[4]);
    console.log(datos_para_grafica[5]);
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: '<a id="meses_visualizar" class="waves-effect waves-light btn-flat chi" style="color:blue;">Meses</a>\n\
                    Entrevistas',
            useHTML: true
        },
        subtitle: {
            text: '<a id="1" class="waves-effect waves-light btn-flat chi">Ene</a>\n\
                   <a id="2" class="waves-effect waves-light btn-flat chi">Feb</a>\n\
                   <a id="3" class="waves-effect waves-light btn-flat chi">Mar</a>\n\
                   <a id="4" class="waves-effect waves-light btn-flat chi">Abr</a>\n\
                   <a id="5" class="waves-effect waves-light btn-flat chi">May</a>\n\
                   <a id="6" class="waves-effect waves-light btn-flat chi">Jun</a>\n\
                   <a id="7" class="waves-effect waves-light btn-flat chi">Jul</a>\n\
                   <a id="8" class="waves-effect waves-light btn-flat chi">Ago</a>\n\
                   <a id="9" class="waves-effect waves-light btn-flat chi">Sep</a>\n\
                   <a id="10" class="waves-effect waves-light btn-flat chi">Oct</a>\n\
                   <a id="11" class="waves-effect waves-light btn-flat chi">Nov</a>\n\
                   <a id="12" class="waves-effect waves-light btn-flat chi">Dic</a>\n\
                   ',
            useHTML: true
        },
        xAxis: {
            categories: datos_para_grafica[0], // yo modifique a qui emmanuel
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Solicitudes'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
                name: 'Aprobado',
                data: datos_para_grafica[1]

            }, {
                name: 'Caido',
                data: datos_para_grafica[2]

            }, {
                name: 'No Aplica',
                data: datos_para_grafica[3]

            }, {
                name: 'No Evaluado',
                data: datos_para_grafica[4]

            }, {
                name: 'Stand By',
                data: datos_para_grafica[5]

            }]
    });

}
;
//==============================================================================
function datos_grafica_dashboart_dos(_desde, _hata, _opcion) {
    var params = {
        accion: "datos_grafica_dashboart_dos",
        desde: _desde,
        hasta: _hata,
        opcion: _opcion
    };

    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "text",
        success: function (dataJson) {
//            console.log(dataJson);
            datos_graficas_evaluacion_reclutador(dataJson);

        }
    });
}
;
//==============================================================================
function datos_graficas_evaluacion_reclutador(dataJson) {
    var datos_reclutadores = JSON.parse(dataJson);
//    console.log(datos_reclutadores);
//    console.log(datos_reclutadores.ingreso);

    Highcharts.chart('container1', {
        chart: {
            inverted: true,
            type: 'column'

        },
        title: {
            text: 'Evaluacion por Reclutador'
        },
        xAxis: {
            categories: datos_reclutadores.reclutador
        },
        yAxis: [{
                min: 0,
                title: {
                    text: 'Entrevistados'
                }
            }, {
                title: {
                    text: 'Entrevistados'
                },
                opposite: true
            }],
        legend: {
            shadow: false
        },
        tooltip: {
            shared: true
        },
        plotOptions: {
            column: {
                grouping: false,
                shadow: false,
                borderWidth: 0
            }
        },
        series: [{
                name: 'Ingresos',
                color: 'rgba(248,161,63,1)',
                data: datos_reclutadores.ingreso,
                pointPadding: 0.3,
                pointPlacement: -0.2
            }, {
                name: 'Entrevistados',
                color: 'rgba(186,60,61,.9)',
                data: datos_reclutadores.entevistas,
                pointPadding: 0.4,
                pointPlacement: -0.2
            }
            /*, {
             name: 'ingresos',
             color: 'rgba(248,161,63,1)',
             data: [183.6, 178.8, 198.5],
             tooltip: {
             valuePrefix: '$',
             valueSuffix: ' M'
             },
             pointPadding: 0.3,
             pointPlacement: 0.2,
             yAxis: 1
             }, {
             name: 'entrevistados',
             color: 'rgba(186,60,61,.9)',
             data: [203.6, 198.8, 208.5],
             tooltip: {
             valuePrefix: '$',
             valueSuffix: ' M'
             },
             pointPadding: 0.4,
             pointPlacement: 0.2,
             yAxis: 1
             }*/
        ]
    });
}
//==============================================================================
function select_activos(_id_caja, _opcion) {
    var params = {
        accion: "select_activos",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_activos_total(_id_caja, _opcion) {
    var params = {
        accion: "select_activos_total",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_entrevista(_id_caja, _opcion) {
    var params = {
        accion: "select_entrevista",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_ingresos(_id_caja, _opcion) {
    var params = {
        accion: "select_ingresos",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_bajas(_id_caja, _opcion) {
    var params = {
        accion: "select_bajas",
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
            window.setTimeout(() => {
                rotacion_chunung();
                rotacion_chunung_2();
            }, 300);
        }
    });
}
;
//==============================================================================
function select_usuarios_activos(_id_caja, ) {
    var params = {
        accion: "select_activos" //modificar la llamada para traer los nombres de los usuarios activos de operaciones
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_usuarios_bajas(_id_caja) {
    var params = {
        accion: "select_bajas" //modificar llamada para traer los nombres de las bajas 
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_usuarios_ingresos(_id_caja) {
    var params = {
        accion: "select_ingresos" //modificar llamada para traer los nombres de los usuarios que ingresaron
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function datos_grafica_dashboart3(_mes, _desde, _hasta) {
    var params = {
        accion: "datos_grafica_dashboart3",
        mes: _mes,
        desde: _desde,
        hasta: _hasta
    };

    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "text",
        success: function (dataJson) {
            gafica3(dataJson);
//            console.log(dataJson);


        }
    });
}
;
//==============================================================================
function gafica3(dataJson) {

    var data = JSON.parse(dataJson);
//    console.log(data);

    Highcharts.getOptions().colors.splice(0, 0);
    Highcharts.chart('container3', {

        chart: {
            height: '79%'
        },

        title: {
            text: 'Medios de Reclutamiento'
        },
        subtitle: {
            text: ''
        },
        series: [{
                type: "sunburst",
                data: data,
                allowDrillToNode: true,
                cursor: 'pointer',
                dataLabels: {
                    format: '{point.name}',
                    filter: {
                        property: 'innerArcLength',
                        operator: '>',
                        value: 16
                    }
                },
                levels: [{
                        level: 1,
                        levelIsConstant: false,
                        dataLabels: {
                            filter: {
                                property: 'outerArcLength',
                                operator: '>',
                                value: 64
                            }
                        }
                    }, {
                        level: 2,
                        colorByPoint: true
                    },
                    {
                        level: 3,
                        colorVariation: {
                            key: 'brightness',
                            to: -0.5
                        }
                    }, {
                        level: 4,
                        colorVariation: {
                            key: 'brightness',
                            to: 0.5
                        }
                    }]

            }],
        tooltip: {
            headerFormat: "",
            pointFormat: 'The population of <b>{point.name}</b> is <b>{point.value}</b>'
        }
    });
}
//==============================================================================
function select_permanencia(_id_caja, _desde, _hasta, _opcion) {
    var params = {
        accion: "select_permanencia",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_datos_informe_vacantes(_desde, _hasta) {
    var params = {
        accion: "select_datos_informe_vacantes",
        desde: _desde,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "text",
        success: function (dataRes) {
            console.log(dataRes);
            partir_datos_pintar(dataRes);
            rango_fecha_pintar(_desde, _hasta);
        }
    });
}
;
//==============================================================================
function partir_datos_pintar(dataRes) {
    var datoglob = dataRes.split('##');
    var entrevistas = JSON.parse(datoglob[0]);
    var ingresos = JSON.parse(datoglob[1]);
    var ingresosp = JSON.parse(datoglob[2]);
    var entre_programadas = JSON.parse(datoglob[3]);
    // programados entrevista
    var AnuncioVentana_Ep = parseInt(entre_programadas["Anuncio Ventana"]) || 0;
    var Banner_Ep = parseInt(entre_programadas["Banner"]) || 0;
    var COMPUTRABAJO_Ep = parseInt(entre_programadas["COMPUTRABAJO"]) || 0;
    var INDEED_Ep = parseInt(entre_programadas["INDEED"]) || 0;
    var TALENTECA_Ep = parseInt(entre_programadas["TALENTECA"]) || 0;
    var BRIGADAMONTERREY_Ep = parseInt(entre_programadas["BRIGADA MONTERREY"]) || 0;
    var FERIAEMPLEOGUADALUPE_Ep = parseInt(entre_programadas["FERIA EMPLEO GUADALUPE"]) || 0;
    var FERIAEMPLEOSANNICOLAS_Ep = parseInt(entre_programadas["FERIA EMPLEO SAN NICOLAS"]) || 0;
    var FERIAEMPLEOSANESCOBEDO_Ep = parseInt(entre_programadas["FERIA EMPLEO ESCOBEDO"]) || 0;
    var VOLANTEO_Ep = parseInt(entre_programadas["VOLANTEO"]) || 0;
    var FERIAEMPLEO_Ep = parseInt(entre_programadas["FERIA EMPLEO"]) || 0;
    var POSTEO_Ep = parseInt(entre_programadas["POSTEO"]) || 0;
    var FACEBOOKPERSONAL_Ep = parseInt(entre_programadas["FACEBOOK(PERSONAL)"]) || 0;
    var FACEBOOKPAGINASICSA_Ep = parseInt(entre_programadas["FACEBOOK(PAGINA SICSA)"]) || 0;
    var RECOMENDACION_Ep = parseInt(entre_programadas["RECOMENDACION"]) || 0;
    var REFCONOCIDO_Ep = parseInt(entre_programadas["REF. CONOCIDO"]) || 0;
    var REINGRESO_Ep = parseInt(entre_programadas["REINGRESO"]) || 0;
    var UANL_Ep = parseInt(entre_programadas["UANL"]) || 0;
    var UMM_Ep = parseInt(entre_programadas["UMM"]) || 0;
    var METRO_Ep = parseInt(entre_programadas["EL METRO"]) || 0;
    var NORTE_Ep = parseInt(entre_programadas["EL NORTE"]) || 0;
    var ELSOLPUEBLA_Ep = parseInt(entre_programadas["EL SOL DE PUEBLA"]) || 0;
    var SANPEDRO_Ep = parseInt(entre_programadas["BOLSA SAN PEDRO"]) || 0;
    var MONTERREY_Ep = parseInt(entre_programadas["BOLSA MONTERREY"]) || 0;
    var ESCOBEDO_Ep = parseInt(entre_programadas["BOLSA ESCOBEDO"]) || 0;
    var APODACA_Ep = parseInt(entre_programadas["BOLSA APODACA"]) || 0;
    var SANNICOLAS_Ep = parseInt(entre_programadas["BOLSA SAN NICOLAS"]) || 0;
    var GUADALUPE_Ep = parseInt(entre_programadas["BOLSA GUADALUPE"]) || 0;
    var INTERCAMBIODECARTERA_Ep = parseInt(entre_programadas["INTERCAMBIO DE CARTERA"]) || 0;
    var EMPRESA_Ep = parseInt(entre_programadas["EMPRESA"]) || 0;
    //variables para tener enteros sin undefined entrevistas
    var AnuncioVentana_E = parseInt(entrevistas["Anuncio Ventana"]) || 0;
    var Banner_E = parseInt(entrevistas["Banner"]) || 0;
    var COMPUTRABAJO_E = parseInt(entrevistas["COMPUTRABAJO"]) || 0;
    var INDEED_E = parseInt(entrevistas["INDEED"]) || 0;
    var TALENTECA_E = parseInt(entrevistas["TALENTECA"]) || 0;
    var BRIGADAMONTERREY_E = parseInt(entrevistas["BRIGADA MONTERREY"]) || 0;
    var FERIAEMPLEOGUADALUPE_E = parseInt(entrevistas["FERIA EMPLEO GUADALUPE"]) || 0;
    var FERIAEMPLEOSANNICOLAS_E = parseInt(entrevistas["FERIA EMPLEO SAN NICOLAS"]) || 0;
    var FERIAEMPLEOSANESCOBEDO_E = parseInt(entrevistas["FERIA EMPLEO ESCOBEDO"]) || 0;
    var VOLANTEO_E = parseInt(entrevistas["VOLANTEO"]) || 0;
    var FERIAEMPLEO_E = parseInt(entrevistas["FERIA EMPLEO"]) || 0;
    var POSTEO_E = parseInt(entrevistas["POSTEO"]) || 0;
    var FACEBOOKPERSONAL_E = parseInt(entrevistas["FACEBOOK(PERSONAL)"]) || 0;
    var FACEBOOKPAGINASICSA_E = parseInt(entrevistas["FACEBOOK(PAGINA SICSA)"]) || 0;
    var RECOMENDACION_E = parseInt(entrevistas["RECOMENDACION"]) || 0;
    var REFCONOCIDO_E = parseInt(entrevistas["REF. CONOCIDO"]) || 0;
    var REINGRESO_E = parseInt(entrevistas["REINGRESO"]) || 0;
    var UANL_E = parseInt(entrevistas["UANL"]) || 0;
    var UMM_E = parseInt(entrevistas["UMM"]) || 0;
    var METRO_E = parseInt(entrevistas["EL METRO"]) || 0;
    var NORTE_E = parseInt(entrevistas["EL NORTE"]) || 0;
    var ELSOLPUEBLA_E = parseInt(entrevistas["EL SOL DE PUEBLA"]) || 0;
    var SANPEDRO_E = parseInt(entrevistas["BOLSA SAN PEDRO"]) || 0;
    var MONTERREY_E = parseInt(entrevistas["BOLSA MONTERREY"]) || 0;
    var ESCOBEDO_E = parseInt(entrevistas["BOLSA ESCOBEDO"]) || 0;
    var APODACA_E = parseInt(entrevistas["BOLSA APODACA"]) || 0;
    var SANNICOLAS_E = parseInt(entrevistas["BOLSA SAN NICOLAS"]) || 0;
    var GUADALUPE_E = parseInt(entrevistas["BOLSA GUADALUPE"]) || 0;
    var INTERCAMBIODECARTERA_E = parseInt(entrevistas["INTERCAMBIO DE CARTERA"]) || 0;
    var EMPRESA_E = parseInt(entrevistas["EMPRESA"]) || 0;
    //variables ingresos
    var AnuncioVentana_I = parseInt(ingresos["Anuncio Ventana"]) || 0;
    var Banner_I = parseInt(ingresos["Banner"]) || 0;
    var COMPUTRABAJO_I = parseInt(ingresos["COMPUTRABAJO"]) || 0;
    var INDEED_I = parseInt(ingresos["INDEED"]) || 0;
    var TALENTECA_I = parseInt(ingresos["TALENTECA"]) || 0;
    var BRIGADAMONTERREY_I = parseInt(ingresos["BRIGADA MONTERREY"]) || 0;
    var FERIAEMPLEOGUADALUPE_I = parseInt(ingresos["FERIA EMPLEO GUADALUPE"]) || 0;
    var FERIAEMPLEOSANNICOLAS_I = parseInt(ingresos["FERIA EMPLEO SAN NICOLAS"]) || 0;
    var FERIAEMPLEOSANESCOBEDO_I = parseInt(ingresos["FERIA EMPLEO ESCOBEDO"]) || 0;
    var VOLANTEO_I = parseInt(ingresos["VOLANTEO"]) || 0;
    var FERIAEMPLEO_I = parseInt(ingresos["FERIA EMPLEO"]) || 0;
    var POSTEO_I = parseInt(ingresos["POSTEO"]) || 0;
    var FACEBOOKPERSONAL_I = parseInt(ingresos["FACEBOOK(PERSONAL)"]) || 0;
    var FACEBOOKPAGINASICSA_I = parseInt(ingresos["FACEBOOK(PAGINA SICSA)"]) || 0;
    var RECOMENDACION_I = parseInt(ingresos["RECOMENDACION"]) || 0;
    var REFCONOCIDO_I = parseInt(ingresos["REF. CONOCIDO"]) || 0;
    var REINGRESO_I = parseInt(ingresos["REINGRESO"]) || 0;
    var UANL_I = parseInt(ingresos["UANL"]) || 0;
    var UMM_I = parseInt(ingresos["UMM"]) || 0;
    var METRO_I = parseInt(ingresos["EL METRO"]) || 0;
    var NORTE_I = parseInt(ingresos["EL NORTE"]) || 0;
    var ELSOLPUEBLA_I = parseInt(ingresos["EL SOL DE PUEBLA"]) || 0;
    var SANPEDRO_I = parseInt(ingresos["BOLSA SAN PEDRO"]) || 0;
    var MONTERREY_I = parseInt(ingresos["BOLSA MONTERREY"]) || 0;
    var ESCOBEDO_I = parseInt(ingresos["BOLSA ESCOBEDO"]) || 0;
    var APODACA_I = parseInt(ingresos["BOLSA APODACA"]) || 0;
    var SANNICOLAS_I = parseInt(ingresos["BOLSA SAN NICOLAS"]) || 0;
    var GUADALUPE_I = parseInt(ingresos["BOLSA GUADALUPE"]) || 0;
    var INTERCAMBIODECARTERA_I = parseInt(ingresos["INTERCAMBIO DE CARTERA"]) || 0;
    var EMPRESA_I = parseInt(ingresos["EMPRESA"]) || 0;
    //variables ingresosp programados
    var AnuncioVentana_Ip = parseInt(ingresosp["Anuncio Ventana"]) || 0;
    var Banner_Ip = parseInt(ingresosp["Banner"]) || 0;
    var COMPUTRABAJO_Ip = parseInt(ingresosp["COMPUTRABAJO"]) || 0;
    var INDEED_Ip = parseInt(ingresosp["INDEED"]) || 0;
    var TALENTECA_Ip = parseInt(ingresosp["TALENTECA"]) || 0;
    var BRIGADAMONTERREY_Ip = parseInt(ingresosp["BRIGADA MONTERREY"]) || 0;
    var FERIAEMPLEOGUADALUPE_Ip = parseInt(ingresosp["FERIA EMPLEO GUADALUPE"]) || 0;
    var FERIAEMPLEOSANNICOLAS_Ip = parseInt(ingresosp["FERIA EMPLEO SAN NICOLAS"]) || 0;
    var FERIAEMPLEOSANESCOBEDO_Ip = parseInt(ingresosp["FERIA EMPLEO ESCOBEDO"]) || 0;
    var VOLANTEO_Ip = parseInt(ingresosp["VOLANTEO"]) || 0;
    var FERIAEMPLEO_Ip = parseInt(ingresosp["FERIA EMPLEO"]) || 0;
    var POSTEO_Ip = parseInt(ingresosp["POSTEO"]) || 0;
    var FACEBOOKPERSONAL_Ip = ingresosp["FACEBOOK(PERSONAL)"] || 0;
    var FACEBOOKPAGINASICSA_Ip = parseInt(ingresosp["FACEBOOK(PAGINA SICSA)"]) || 0;
    var RECOMENDACION_Ip = parseInt(ingresosp["RECOMENDACION"]) || 0;
    var REFCONOCIDO_Ip = parseInt(ingresosp["REF. CONOCIDO"]) || 0;
    var REINGRESO_Ip = parseInt(ingresosp["REINGRESO"]) || 0;
    var UANL_Ip = parseInt(ingresosp["UANL"]) || 0;
    var UMM_Ip = parseInt(ingresosp["UMM"]) || 0;
    var METRO_Ip = parseInt(ingresosp["EL METRO"]) || 0;
    var NORTE_Ip = parseInt(ingresosp["EL NORTE"]) || 0;
    var ELSOLPUEBLA_Ip = parseInt(ingresosp["EL SOL DE PUEBLA"]) || 0;
    var SANPEDRO_Ip = parseInt(ingresosp["BOLSA SAN PEDRO"]) || 0;
    var MONTERREY_Ip = parseInt(ingresosp["BOLSA MONTERREY"]) || 0;
    var ESCOBEDO_Ip = parseInt(ingresosp["BOLSA ESCOBEDO"]) || 0;
    var APODACA_Ip = parseInt(ingresosp["BOLSA APODACA"]) || 0;
    var SANNICOLAS_Ip = parseInt(ingresosp["BOLSA SAN NICOLAS"]) || 0;
    var GUADALUPE_Ip = parseInt(ingresosp["BOLSA GUADALUPE"]) || 0;
    var INTERCAMBIODECARTERA_Ip = parseInt(ingresosp["INTERCAMBIO DE CARTERA"]) || 0;
    var EMPRESA_Ip = parseInt(ingresosp["EMPRESA"]) || 0;
    //programados a entevistas///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    $("#proga_entr_publi1").text(AnuncioVentana_Ep);
    $("#proga_entr_publi2").text(Banner_Ep);
    $("#proga_entr_bolse1").text(COMPUTRABAJO_Ep);
    $("#proga_entr_bolse2").text(INDEED_Ep);
    $("#proga_entr_bolse3").text(TALENTECA_Ep);
    $("#proga_entr_trab1").text(BRIGADAMONTERREY_Ep);
    $("#proga_entr_trab2").text(FERIAEMPLEOGUADALUPE_Ep);
    $("#proga_entr_trab3").text(FERIAEMPLEOSANNICOLAS_Ep);
    $("#proga_entr_trab4").text(FERIAEMPLEOSANESCOBEDO_Ep);
    $("#proga_entr_trab5").text(VOLANTEO_Ep);
    $("#proga_entr_trab6").text(FERIAEMPLEO_Ep);
    $("#proga_entr_trab7").text(POSTEO_Ep);
    $("#proga_entr_red1").text(FACEBOOKPERSONAL_Ep);
    $("#proga_entr_red2").text(FACEBOOKPAGINASICSA_Ep);
    $("#proga_entr_otros1").text(RECOMENDACION_Ep);
    $("#proga_entr_otros2").text(REFCONOCIDO_Ep);
    $("#proga_entr_otros3").text(REINGRESO_Ep);
    $("#proga_entr_esc1").text(UANL_Ep);
    $("#proga_entr_esc2").text(UMM_Ep);
    $("#proga_entr_per1").text(METRO_Ep);
    $("#proga_entr_per2").text(NORTE_Ep);
    $("#proga_entr_per3").text(ELSOLPUEBLA_Ep);
    $("#proga_entr_bolm1").text(SANPEDRO_Ep);
    $("#proga_entr_bolm2").text(MONTERREY_Ep);
    $("#proga_entr_bolm3").text(ESCOBEDO_Ep);
    $("#proga_entr_bolm4").text(APODACA_Ep);
    $("#proga_entr_bolm5").text(SANNICOLAS_Ep);
    $("#proga_entr_bolm6").text(GUADALUPE_Ep);
    $("#proga_entr_inter1").text(INTERCAMBIODECARTERA_Ep);
    $("#proga_entr_outsour1").text(EMPRESA_Ep);
    //entrevistas////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    $("#entrevist_entr_publi1").text(AnuncioVentana_E);
    $("#entrevist_entr_publi2").text(Banner_E);
    $("#entrevist_entr_bolse1").text(COMPUTRABAJO_E);
    $("#entrevist_entr_bolse2").text(INDEED_E);
    $("#entrevist_entr_bolse3").text(TALENTECA_E);
    $("#entrevist_entr_trab1").text(BRIGADAMONTERREY_E);
    $("#entrevist_entr_trab2").text(FERIAEMPLEOGUADALUPE_E);
    $("#entrevist_entr_trab3").text(FERIAEMPLEOSANNICOLAS_E);
    $("#entrevist_entr_trab4").text(FERIAEMPLEOSANESCOBEDO_E);
    $("#entrevist_entr_trab5").text(VOLANTEO_E);
    $("#entrevist_entr_trab6").text(FERIAEMPLEO_E);
    $("#entrevist_entr_trab7").text(POSTEO_E);
    $("#entrevist_entr_red1").text(FACEBOOKPERSONAL_E);
    $("#entrevist_entr_red2").text(FACEBOOKPAGINASICSA_E);
    $("#entrevist_entr_otros1").text(RECOMENDACION_E);
    $("#entrevist_entr_otros2").text(REFCONOCIDO_E);
    $("#entrevist_entr_otros3").text(REINGRESO_E);
    $("#entrevist_entr_esc1").text(UANL_E);
    $("#entrevist_entr_esc2").text(UMM_E);
    $("#entrevist_entr_per1").text(METRO_E);
    $("#entrevist_entr_per2").text(NORTE_E);
    $("#entrevist_entr_per3").text(ELSOLPUEBLA_E);
    $("#entrevist_entr_bolm1").text(SANPEDRO_E);
    $("#entrevist_entr_bolm2").text(MONTERREY_E);
    $("#entrevist_entr_bolm3").text(ESCOBEDO_E);
    $("#entrevist_entr_bolm4").text(APODACA_E);
    $("#entrevist_entr_bolm5").text(SANNICOLAS_E);
    $("#entrevist_entr_bolm6").text(GUADALUPE_E);
    $("#entrevist_entr_inter1").text(INTERCAMBIODECARTERA_E);
    $("#entrevist_entr_outsour1").text(EMPRESA_E);
    //sumas totales por medio
    $("#entrevist_entr_publi").text(AnuncioVentana_E + Banner_E);
    $("#entrevist_entr_blose").text(COMPUTRABAJO_E + INDEED_E + TALENTECA_E);
    $("#entrevist_entr_trab").text(BRIGADAMONTERREY_E + FERIAEMPLEOGUADALUPE_E + FERIAEMPLEOSANNICOLAS_E + FERIAEMPLEOSANESCOBEDO_E + VOLANTEO_E + FERIAEMPLEO_E + POSTEO_E);
    $("#entrevist_entr_red").text(FACEBOOKPERSONAL_E + FACEBOOKPAGINASICSA_E);
    $("#entrevist_entr_otros").text(RECOMENDACION_E + REFCONOCIDO_E + REINGRESO_E);
    $("#entrevist_entr_esc").text(UANL_E + UMM_E);
    $("#entrevist_entr_per").text(METRO_E + NORTE_E + ELSOLPUEBLA_E);
    $("#entrevist_entr_bolm").text(SANPEDRO_E + MONTERREY_E + ESCOBEDO_E + APODACA_E + SANNICOLAS_E + GUADALUPE_E);
    $("#entrevist_entr_inter").text(INTERCAMBIODECARTERA_E);
    $("#entrevist_entr_outsour").text(EMPRESA_E);
    //llenar tabla con sumas
    $("#cantidad_pub_entr").text($("#entrevist_entr_publi").text());
    $("#cantidad_bole_entr").text($("#entrevist_entr_blose").text());
    $("#cantidad_trab_entr").text($("#entrevist_entr_trab").text());
    $("#cantidad_red_entr").text($("#entrevist_entr_red").text());
    $("#cantidad_otros_entr").text($("#entrevist_entr_otros").text());
    $("#cantidad_esc_entr").text($("#entrevist_entr_esc").text());
    $("#cantidad_per_entr").text($("#entrevist_entr_per").text());
    $("#cantidad_bolm_entr").text($("#entrevist_entr_bolm").text());
    $("#cantidad_inter_entr").text($("#entrevist_entr_inter").text());
    $("#cantidad_outsour_entr").text($("#entrevist_entr_outsour").text());
    //totales de tabla CITADOS
    var total_citados = 0;
    for (i in entre_programadas) {
        total_citados = total_citados + entre_programadas[i];
    }
    $("#prog_tot_entr2").text(total_citados);
    $("#tot_entr").text(total_citados);
    //totales de tabla
    var total_entrevistas = 0;
    for (i in entrevistas) {
        entrevistas[i];
        total_entrevistas = total_entrevistas + entrevistas[i];
    }
    $("#cant_tot_entr").text(total_entrevistas);
    $("#cant_tot_entr2").text(total_entrevistas);
    $("#entr_present").text(total_entrevistas);
    //promedios entrevistas
    var porm_entr_pub = (parseInt($("#entrevist_entr_publi").text()) / total_entrevistas) * 100;
    $("#prom_pub_entr").text((porm_entr_pub).toFixed(2) + '%');
    $("#promedio_entr_publi").text((porm_entr_pub).toFixed(2) + '%');
    var porm_bole_entr = (parseInt($("#entrevist_entr_blose").text()) / total_entrevistas) * 100;
    $("#prom_bole_entr").text((porm_bole_entr).toFixed(2) + '%');
    $("#promedio_entr_bolse").text((porm_bole_entr).toFixed(2) + '%');
    var porm_trab_entr = (parseInt($("#entrevist_entr_trab").text()) / total_entrevistas) * 100;
    $("#prom_trab_entr").text((porm_trab_entr).toFixed(2) + '%');
    $("#promedio_entr_trab").text((porm_trab_entr).toFixed(2) + '%');
    var porm_red_entr = (parseInt($("#entrevist_entr_red").text()) / total_entrevistas) * 100;
    $("#prom_red_entr").text((porm_red_entr).toFixed(2) + '%');
    $("#promedio_entr_red").text((porm_red_entr).toFixed(2) + '%');
    var porm_otros_entr = (parseInt($("#entrevist_entr_otros").text()) / total_entrevistas) * 100;
    $("#prom_otros_entr").text((porm_otros_entr).toFixed(2) + '%');
    $("#promedio_entr_otros").text((porm_otros_entr).toFixed(2) + '%');
    var porm_esc_entr = (parseInt($("#entrevist_entr_esc").text()) / total_entrevistas) * 100;
    $("#prom_esc_entr").text((porm_esc_entr).toFixed(2) + '%');
    $("#promedio_entr_esc").text((porm_esc_entr).toFixed(2) + '%');
    var porm_per_entr = (parseInt($("#entrevist_entr_per").text()) / total_entrevistas) * 100;
    $("#prom_per_entr").text((porm_per_entr).toFixed(2) + '%');
    $("#promedio_entr_per").text((porm_per_entr).toFixed(2) + '%');
    var porm_bolm_entr = (parseInt($("#entrevist_entr_bolm").text()) / total_entrevistas) * 100;
    $("#prom_bolm_entr").text((porm_bolm_entr).toFixed(2) + '%');
    $("#promedio_entr_bolm").text((porm_bolm_entr).toFixed(2) + '%');
    var porm_inter_entr = (parseInt($("#entrevist_entr_inter").text()) / total_entrevistas) * 100;
    $("#prom_inter_entr").text((porm_inter_entr).toFixed(2) + '%');
    $("#promedio_entr_inter").text((porm_inter_entr).toFixed(2) + '%');
    
    var porm_inter_outsour = (parseInt($("#entrevist_entr_outsour").text()) / total_entrevistas) * 100;
    $("#prom_outsour_entr").text((porm_inter_outsour).toFixed(2) + '%');
    $("#promedio_entr_outsour").text((porm_inter_outsour).toFixed(2) + '%');
    //suma promedios entrevistas
    $("#prom_tot_entr").text((porm_entr_pub + porm_bole_entr + porm_trab_entr + porm_red_entr
            + porm_otros_entr + porm_esc_entr + porm_per_entr + porm_bolm_entr + porm_inter_entr + porm_inter_outsour).toFixed(0) + '%');
    //promedios por medio
    var promedio_entr_publi1 = (AnuncioVentana_E / total_entrevistas) * 100;
    $("#promedio_entr_publi1").text((promedio_entr_publi1).toFixed(2));
    var promedio_entr_publi2 = (Banner_E / total_entrevistas) * 100;
    $("#promedio_entr_publi2").text((promedio_entr_publi2).toFixed(2));
    var promedio_entr_bolse1 = (COMPUTRABAJO_E / total_entrevistas) * 100;
    $("#promedio_entr_bolse1").text((promedio_entr_bolse1).toFixed(2));
    var promedio_entr_bolse2 = (INDEED_E / total_entrevistas) * 100;
    $("#promedio_entr_bolse2").text((promedio_entr_bolse2).toFixed(2));
    var promedio_entr_bolse3 = (TALENTECA_E / total_entrevistas) * 100;
    $("#promedio_entr_bolse3").text((promedio_entr_bolse3).toFixed(2));
    var promedio_entr_trab1 = (BRIGADAMONTERREY_E / total_entrevistas) * 100;
    $("#promedio_entr_trab1").text((promedio_entr_trab1).toFixed(2));
    var promedio_entr_trab2 = (FERIAEMPLEOGUADALUPE_E / total_entrevistas) * 100;
    $("#promedio_entr_trab2").text((promedio_entr_trab2).toFixed(2));
    var promedio_entr_trab3 = (FERIAEMPLEOSANNICOLAS_E / total_entrevistas) * 100;
    $("#promedio_entr_trab3").text((promedio_entr_trab3).toFixed(2));
    var promedio_entr_trab4 = (FERIAEMPLEOSANESCOBEDO_E / total_entrevistas) * 100;
    $("#promedio_entr_trab4").text((promedio_entr_trab4).toFixed(2));
    var promedio_entr_trab5 = (VOLANTEO_E / total_entrevistas) * 100;
    $("#promedio_entr_trab5").text((promedio_entr_trab5).toFixed(2));
    var promedio_entr_trab6 = (FERIAEMPLEO_E / total_entrevistas) * 100;
    $("#promedio_entr_trab6").text((promedio_entr_trab6).toFixed(2));
    var promedio_entr_trab7 = (POSTEO_E / total_entrevistas) * 100;
    $("#promedio_entr_trab7").text((promedio_entr_trab7).toFixed(2));
    var promedio_entr_red1 = (FACEBOOKPERSONAL_E / total_entrevistas) * 100;
    $("#promedio_entr_red1").text((promedio_entr_red1).toFixed(2));
    var promedio_entr_red2 = (FACEBOOKPAGINASICSA_E / total_entrevistas) * 100;
    $("#promedio_entr_red2").text((promedio_entr_red2).toFixed(2));
    var promedio_entr_otros1 = (RECOMENDACION_E / total_entrevistas) * 100;
    $("#promedio_entr_otros1").text((promedio_entr_otros1).toFixed(2));
    var promedio_entr_otros2 = (REFCONOCIDO_E / total_entrevistas) * 100;
    $("#promedio_entr_otros2").text((promedio_entr_otros2).toFixed(2));
    var promedio_entr_otros3 = (REINGRESO_E / total_entrevistas) * 100;
    $("#promedio_entr_otros3").text((promedio_entr_otros3).toFixed(2));
    var promedio_entr_esc1 = (UANL_E / total_entrevistas) * 100;
    $("#promedio_entr_esc1").text((promedio_entr_esc1).toFixed(2));
    var promedio_entr_esc2 = (UMM_E / total_entrevistas) * 100;
    $("#promedio_entr_esc2").text((promedio_entr_esc2).toFixed(2));
    var promedio_entr_per1 = (METRO_E / total_entrevistas) * 100;
    $("#promedio_entr_per1").text((promedio_entr_per1).toFixed(2));
    var promedio_entr_per2 = (NORTE_E / total_entrevistas) * 100;
    $("#promedio_entr_per2").text((promedio_entr_per2).toFixed(2));
    var promedio_entr_per3 = (ELSOLPUEBLA_E / total_entrevistas) * 100;
    $("#promedio_entr_per3").text((promedio_entr_per3).toFixed(2));
    var promedio_entr_bolm1 = (SANPEDRO_E / total_entrevistas) * 100;
    $("#promedio_entr_bolm1").text((promedio_entr_bolm1).toFixed(2));
    var promedio_entr_bolm2 = (MONTERREY_E / total_entrevistas) * 100;
    $("#promedio_entr_bolm2").text((promedio_entr_bolm2).toFixed(2));
    var promedio_entr_bolm3 = (ESCOBEDO_E / total_entrevistas) * 100;
    $("#promedio_entr_bolm3").text((promedio_entr_bolm3).toFixed(2));
    var promedio_entr_bolm4 = (APODACA_E / total_entrevistas) * 100;
    $("#promedio_entr_bolm4").text((promedio_entr_bolm4).toFixed(2));
    var promedio_entr_bolm5 = (SANNICOLAS_E / total_entrevistas) * 100;
    $("#promedio_entr_bolm5").text((promedio_entr_bolm5).toFixed(2));
    var promedio_entr_bolm6 = (GUADALUPE_E / total_entrevistas) * 100;
    $("#promedio_entr_bolm6").text((promedio_entr_bolm6).toFixed(2));
    var promedio_entr_inter1 = (INTERCAMBIODECARTERA_E / total_entrevistas) * 100;
    $("#promedio_entr_inter1").text((promedio_entr_inter1).toFixed(2));
    // add  emmanuiel
    var promedio_entr_outsour1 = (EMPRESA_E / total_entrevistas) * 100;
    $("#promedio_entr_outsour1").text((promedio_entr_outsour1).toFixed(2));
    //total porcentajes entrevistas
    var total_porcentajes_entrevistas = porm_entr_pub + porm_bole_entr + porm_trab_entr + porm_red_entr + porm_otros_entr
            + porm_esc_entr + porm_per_entr + porm_bolm_entr + porm_inter_entr + porm_inter_outsour;
    $("#prom_tot_entr2").text(total_porcentajes_entrevistas + '%');
    $("#porcent_tot_entr").text(total_porcentajes_entrevistas + '%');
    $("#equiv_porcent_entr").text(total_porcentajes_entrevistas + '%');
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ingresos///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    $("#ingresaron_ingr_publi1").text(AnuncioVentana_I);
    $("#ingresaron_ingr_publi2").text(Banner_I);
    $("#ingresaron_ingr_bolse1").text(COMPUTRABAJO_I);
    $("#ingresaron_ingr_bolse2").text(INDEED_I);
    $("#ingresaron_ingr_bolse3").text(TALENTECA_I);
    $("#ingresaron_ingr_trab1").text(BRIGADAMONTERREY_I);
    $("#ingresaron_ingr_trab2").text(FERIAEMPLEOGUADALUPE_I);
    $("#ingresaron_ingr_trab3").text(FERIAEMPLEOSANNICOLAS_I);
    $("#ingresaron_ingr_trab4").text(FERIAEMPLEOSANESCOBEDO_I);
    $("#ingresaron_ingr_trab5").text(VOLANTEO_I);
    $("#ingresaron_ingr_trab6").text(FERIAEMPLEO_I);
    $("#ingresaron_ingr_trab7").text(POSTEO_I);
    $("#ingresaron_ingr_red1").text(FACEBOOKPERSONAL_I);
    $("#ingresaron_ingr_red2").text(FACEBOOKPAGINASICSA_I);
    $("#ingresaron_ingr_otros1").text(RECOMENDACION_I);
    $("#ingresaron_ingr_otros2").text(REFCONOCIDO_I);
    $("#ingresaron_ingr_otros3").text(REINGRESO_I);
    $("#ingresaron_ingr_esc1").text(UANL_I);
    $("#ingresaron_ingr_esc2").text(UMM_I);
    $("#ingresaron_ingr_per1").text(METRO_I);
    $("#ingresaron_ingr_per2").text(NORTE_I);
    $("#ingresaron_ingr_per3").text(ELSOLPUEBLA_I);
    $("#ingresaron_ingr_bolm1").text(SANPEDRO_I);
    $("#ingresaron_ingr_bolm2").text(MONTERREY_I);
    $("#ingresaron_ingr_bolm3").text(ESCOBEDO_I);
    $("#ingresaron_ingr_bolm4").text(APODACA_I);
    $("#ingresaron_ingr_bolm5").text(SANNICOLAS_I);
    $("#ingresaron_ingr_bolm6").text(GUADALUPE_I);
    $("#ingresaron_ingr_inter1").text(INTERCAMBIODECARTERA_I);
    $("#ingresaron_ingr_outsour1").text(EMPRESA_I);
    //sumas totales por medio
    $("#ingresaron_ingr_publi").text(AnuncioVentana_I + Banner_I);
    $("#ingresaron_ingr_bolse").text(COMPUTRABAJO_I + INDEED_I + TALENTECA_I);
    $("#ingresaron_ingr_trab").text(BRIGADAMONTERREY_I + FERIAEMPLEOGUADALUPE_I + FERIAEMPLEOSANNICOLAS_I + FERIAEMPLEOSANESCOBEDO_I + VOLANTEO_I + FERIAEMPLEO_I + POSTEO_I);
    $("#ingresaron_ingr_red").text(FACEBOOKPERSONAL_I + FACEBOOKPAGINASICSA_I);
    $("#ingresaron_ingr_otros").text(RECOMENDACION_I + REFCONOCIDO_I + REINGRESO_I);
    $("#ingresaron_ingr_esc").text(UANL_I + UMM_I);
    $("#ingresaron_ingr_per").text(METRO_I + NORTE_I + ELSOLPUEBLA_I);
    $("#ingresaron_ingr_bolm").text(SANPEDRO_I + MONTERREY_I + ESCOBEDO_I + APODACA_I + SANNICOLAS_I + GUADALUPE_I);
    $("#ingresaron_ingr_inter").text(INTERCAMBIODECARTERA_I);
    $("#ingresaron_ingr_outsour").text(EMPRESA_I);
    //llenar tabla con sumas
    $("#cantidad_pub_ingre").text($("#ingresaron_ingr_publi").text());
    $("#cantidad_bole_ingre").text($("#ingresaron_ingr_bolse").text());
    $("#cantidad_trab_ingre").text($("#ingresaron_ingr_trab").text());
    $("#cantidad_red_ingre").text($("#ingresaron_ingr_red").text());
    $("#cantidad_otros_ingre").text($("#ingresaron_ingr_otros").text());
    $("#cantidad_esc_ingre").text($("#ingresaron_ingr_esc").text());
    $("#cantidad_per_ingre").text($("#ingresaron_ingr_per").text());
    $("#cantidad_bolm_ingre").text($("#ingresaron_ingr_bolm").text());
    $("#cantidad_inter_ingre").text($("#ingresaron_ingr_inter").text());
    $("#cantidad_outsour_ingre").text($("#ingresaron_ingr_outsour").text());
    //totales de la tabla
    var total_ingresos = 0;
    for (i in ingresos) {
        ingresos[i];
        total_ingresos = total_ingresos + ingresos[i];
    }
    $("#cant_tot_ingre").text(total_ingresos);
    $("#cant_tot_ingre2").text(total_ingresos);
    $("#ingr_present").text(total_ingresos);
    //promedios
    var porm_ingre_pub = (parseInt($("#ingresaron_ingr_publi").text()) / total_ingresos) * 100;
    $("#prom_pub_ingre").text((porm_ingre_pub).toFixed(2) + '%');
    var porm_bole_pub = (parseInt($("#ingresaron_ingr_bolse").text()) / total_ingresos) * 100;
    $("#prom_bole_ingre").text((porm_bole_pub).toFixed(2) + '%');
    var porm_trab_pub = (parseInt($("#ingresaron_ingr_trab").text()) / total_ingresos) * 100;
    $("#prom_trab_ingre").text((porm_trab_pub).toFixed(2) + '%');
    var porm_red_pub = (parseInt($("#ingresaron_ingr_red").text()) / total_ingresos) * 100;
    $("#prom_red_ingre").text((porm_red_pub).toFixed(2) + '%');
    var porm_otros_pub = (parseInt($("#ingresaron_ingr_otros").text()) / total_ingresos) * 100;
    $("#prom_otros_ingre").text((porm_otros_pub).toFixed(2) + '%');
    var porm_esc_pub = (parseInt($("#ingresaron_ingr_esc").text()) / total_ingresos) * 100;
    $("#prom_esc_ingre").text((porm_esc_pub).toFixed(2) + '%');
    var porm_per_pub = (parseInt($("#ingresaron_ingr_per").text()) / total_ingresos) * 100;
    $("#prom_per2_ingre").text((porm_per_pub).toFixed(2) + '%');
    var porm_bolm_pub = (parseInt($("#ingresaron_ingr_bolm").text()) / total_ingresos) * 100;
    $("#prom_bolm_ingre").text((porm_bolm_pub).toFixed(2) + '%');
    var porm_inter_pub = (parseInt($("#ingresaron_ingr_inter").text()) / total_ingresos) * 100;
    $("#prom_inter_ingre").text((porm_inter_pub).toFixed(2) + '%');
    // edito emmanuel
    var porm_outsour_pub = (parseInt($("#ingresaron_ingr_outsour").text()) / total_ingresos) * 100;
    $("#prom_outsour_ingre").text((porm_outsour_pub).toFixed(2) + '%');
    //suma promedios
    $("#prom_tot_ingre").text((porm_ingre_pub + porm_bole_pub + porm_trab_pub + porm_red_pub
            + porm_otros_pub + porm_esc_pub + porm_per_pub + porm_bolm_pub + porm_inter_pub + porm_outsour_pub).toFixed(0) + '%');
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ingresos programados///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //coloca datos en tabla
    $("#proga_ingr_publi1").text(AnuncioVentana_Ip);
    $("#proga_ingr_publi2").text(Banner_Ip);
    $("#proga_ingr_bolse1").text(COMPUTRABAJO_Ip);
    $("#proga_ingr_bolse2").text(INDEED_Ip);
    $("#proga_ingr_bolse3").text(TALENTECA_Ip);
    $("#proga_ingr_trab1").text(BRIGADAMONTERREY_Ip);
    $("#proga_ingr_trab2").text(FERIAEMPLEOGUADALUPE_Ip);
    $("#proga_ingr_trab3").text(FERIAEMPLEOSANNICOLAS_Ip);
    $("#proga_ingr_trab4").text(FERIAEMPLEOSANESCOBEDO_Ip);
    $("#proga_ingr_trab5").text(VOLANTEO_Ip);
    $("#proga_ingr_trab6").text(FERIAEMPLEO_Ip);
    $("#proga_ingr_trab7").text(POSTEO_Ip);
    $("#proga_ingr_red1").text(FACEBOOKPERSONAL_Ip);
    $("#proga_ingr_red2").text(FACEBOOKPAGINASICSA_Ip);
    $("#proga_ingr_otros1").text(RECOMENDACION_Ip);
    $("#proga_ingr_otros2").text(REFCONOCIDO_Ip);
    $("#proga_ingr_otros3").text(REINGRESO_Ip);
    $("#proga_ingr_esc1").text(UANL_Ip);
    $("#proga_ingr_esc2").text(UMM_Ip);
    $("#proga_ingr_per1").text(METRO_Ip);
    $("#proga_ingr_per2").text(NORTE_Ip);
    $("#proga_ingr_per3").text(ELSOLPUEBLA_Ip);
    $("#proga_ingr_bolm1").text(SANPEDRO_Ip);
    $("#proga_ingr_bolm2").text(MONTERREY_Ip);
    $("#proga_ingr_bolm3").text(ESCOBEDO_Ip);
    $("#proga_ingr_bolm4").text(APODACA_Ip);
    $("#proga_ingr_bolm5").text(SANNICOLAS_Ip);
    $("#proga_ingr_bolm6").text(GUADALUPE_Ip);
    $("#proga_ingr_inter1").text(INTERCAMBIODECARTERA_Ip);
    $("#proga_ingr_outsour1").text(EMPRESA_Ip);
    //sumas totales por medio
    $("#proga_entr_publi").text(AnuncioVentana_Ep + Banner_Ep);
    $("#proga_entr_bolse").text(COMPUTRABAJO_Ep + INDEED_Ep + TALENTECA_Ep);
    $("#proga_entr_trab").text(BRIGADAMONTERREY_Ep+FERIAEMPLEOGUADALUPE_Ep+FERIAEMPLEOSANNICOLAS_Ep+FERIAEMPLEOSANESCOBEDO_Ep+VOLANTEO_Ep+FERIAEMPLEO_Ep+POSTEO_Ep);
    $("#proga_entr_red").text(FACEBOOKPERSONAL_Ep + FACEBOOKPAGINASICSA_Ep);
    $("#proga_entr_otros").text(RECOMENDACION_Ep + REFCONOCIDO_Ep + REINGRESO_Ep);
    $("#proga_entr_esc").text(UANL_Ep + UMM_Ep);
    $("#proga_entr_per").text(METRO_Ep + NORTE_Ep + ELSOLPUEBLA_Ep);
    $("#proga_entr_bolm").text(SANPEDRO_Ep + MONTERREY_Ep + ESCOBEDO_Ep + APODACA_Ep + SANNICOLAS_Ep + GUADALUPE_Ep);
    $("#proga_entr_inter").text(INTERCAMBIODECARTERA_Ep);
    $("#proga_entr_outsour").text(EMPRESA_Ep);
    //sumas totales por medio
    $("#proga_ingr_publi").text(AnuncioVentana_Ip + Banner_Ip);
    $("#proga_ingr_bolse").text(COMPUTRABAJO_Ip + INDEED_Ip + TALENTECA_Ip);
    $("#proga_ingr_trab").text(BRIGADAMONTERREY_Ip + FERIAEMPLEOGUADALUPE_Ip + FERIAEMPLEOSANNICOLAS_Ip
            + FERIAEMPLEOSANESCOBEDO_Ip + VOLANTEO_Ip + FERIAEMPLEO_Ip + POSTEO_Ip);
    $("#proga_ingr_red").text(FACEBOOKPERSONAL_Ip + FACEBOOKPAGINASICSA_Ip);
    $("#proga_ingr_otros").text(RECOMENDACION_Ip + REFCONOCIDO_Ip + REINGRESO_Ip);
    $("#proga_ingr_esc").text(UANL_Ip + UMM_Ip);
    $("#proga_ingr_per").text(METRO_Ip + NORTE_Ip + ELSOLPUEBLA_Ip);
    $("#proga_ingr_bolm").text(SANPEDRO_Ip + MONTERREY_Ip + ESCOBEDO_Ip + APODACA_Ip + SANNICOLAS_Ip + GUADALUPE_Ip);
    $("#proga_ingr_inter").text(INTERCAMBIODECARTERA_Ip);
    $("#proga_ingr_outsour").text(INTERCAMBIODECARTERA_Ip);
    //totales de la tabla
    var total_ingresosp = 0;
    for (i in ingresosp) {
        ingresosp[i];
        total_ingresosp = total_ingresosp + ingresosp[i];
    }
    $("#porg_tot_ingre2").text(total_ingresosp);
    $("#tot_ingr").text(total_ingresosp);
    //promedios
    var prom_ingr_publi1 = (parseFloat(((AnuncioVentana_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_publi1").text(parseFloat(prom_ingr_publi1) || 0 + '%');
    var prom_ingr_publi2 = (parseFloat(((Banner_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_publi2").text(prom_ingr_publi2 + '%');
    var prom_ingr_bolse1 = (parseFloat(((COMPUTRABAJO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolse1").text(prom_ingr_bolse1 + '%');
    var prom_ingr_bolse2 = (parseFloat(((INDEED_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolse2").text(prom_ingr_bolse2 + '%');
    var prom_ingr_bolse3 = (parseFloat(((TALENTECA_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolse3").text(prom_ingr_bolse3 + '%');
    var prom_ingr_trab1 = (parseFloat(((BRIGADAMONTERREY_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_trab1").text(prom_ingr_trab1 + '%');
    var prom_ingr_trab2 = (parseFloat(((FERIAEMPLEOGUADALUPE_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_trab2").text(prom_ingr_trab2 + '%');
    var prom_ingr_trab3 = (parseFloat(((FERIAEMPLEOSANNICOLAS_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_trab3").text(prom_ingr_trab3 + '%');
    var prom_ingr_trab4 = (parseFloat(((FERIAEMPLEOSANESCOBEDO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_trab4").text(prom_ingr_trab4 + '%');
    var prom_ingr_trab5 = (parseFloat(((VOLANTEO_Ip / VOLANTEO_E) * 100).toFixed(2)) || 0);
    $("#prom_ingr_trab5").text(prom_ingr_trab5 + '%');
    var prom_ingr_trab6 = (parseFloat(((FERIAEMPLEO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_trab6").text(prom_ingr_trab6 + '%');
    var prom_ingr_trab7 = (parseFloat(((POSTEO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_trab7").text(prom_ingr_trab7 + '%');
    var prom_ingr_red1 = (parseFloat(((FACEBOOKPERSONAL_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_red1").text(prom_ingr_red1 + '%');
    var prom_ingr_red2 = (parseFloat(((FACEBOOKPAGINASICSA_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_red2").text(prom_ingr_red2 + '%');
    var prom_ingr_otros1 = (parseFloat(((RECOMENDACION_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_otros1").text(prom_ingr_otros1 + '%');
    var prom_ingr_otros2 = (parseFloat(((REFCONOCIDO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_otros2").text(prom_ingr_otros2 + '%');
    var prom_ingr_otros3 = (parseFloat(((REINGRESO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_otros3").text(prom_ingr_otros3 + '%');
    var prom_ingr_esc1 = (parseFloat(((UANL_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_esc1").text(prom_ingr_esc1 + '%');
    var prom_ingr_esc2 = (parseFloat(((UMM_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_esc2").text(prom_ingr_esc2 + '%');
    var prom_ingr_per1 = (parseFloat(((METRO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_per1").text(prom_ingr_per1 + '%');
    var prom_ingr_per2 = (parseFloat(((NORTE_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_per2").text(prom_ingr_per2 + '%');
    var prom_ingr_per3 = (parseFloat(((ELSOLPUEBLA_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_per3").text(prom_ingr_per3 + '%');
    var prom_ingr_bolm1 = (parseFloat(((SANPEDRO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolm1").text(prom_ingr_bolm1 + '%');
    var prom_ingr_bolm2 = (parseFloat(((MONTERREY_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolm2").text(prom_ingr_bolm2 + '%');
    var prom_ingr_bolm3 = (parseFloat(((ESCOBEDO_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolm3").text(prom_ingr_bolm3 + '%');
    var prom_ingr_bolm4 = (parseFloat(((APODACA_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolm4").text(prom_ingr_bolm4 + '%');
    var prom_ingr_bolm5 = (parseFloat(((SANNICOLAS_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolm5").text(prom_ingr_bolm5 + '%');
    var prom_ingr_bolm6 = (parseFloat(((GUADALUPE_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_bolm6").text(prom_ingr_bolm6 + '%');
    var prom_ingr_inter1 = (parseFloat(((INTERCAMBIODECARTERA_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_inter1").text(prom_ingr_inter1 + '%');
    // agrego emmanuel
    var prom_ingr_outsour1 = (parseFloat(((EMPRESA_Ip / total_ingresosp) * 100).toFixed(2)) || 0);
    $("#prom_ingr_outsour1").text(prom_ingr_outsour1 + '%');
    //suma promedios
    var prom_ingr_publi = prom_ingr_publi1 + prom_ingr_publi2;
    $("#prom_ingr_publi").text((prom_ingr_publi).toFixed(2) + '%');
    var prom_ingr_bolse = prom_ingr_bolse1 + prom_ingr_bolse2 + prom_ingr_bolse3;
    $("#prom_ingr_bolse").text((prom_ingr_bolse).toFixed(2) + '%');
    var prom_ingr_trab = prom_ingr_trab1 + prom_ingr_trab2 + prom_ingr_trab3 + prom_ingr_trab4 + prom_ingr_trab5 + prom_ingr_trab6 + prom_ingr_trab7;
    $("#prom_ingr_trab").text((prom_ingr_trab).toFixed(2) + '%');
    var prom_ingr_red = prom_ingr_red1 + prom_ingr_red2;
    $("#prom_ingr_red").text((prom_ingr_red).toFixed(2) + '%');
    var prom_ingr_otros = prom_ingr_otros1 + prom_ingr_otros2 + prom_ingr_otros3;
    $("#prom_ingr_otros").text((prom_ingr_otros).toFixed(2) + '%');
    var prom_ingr_esc = prom_ingr_esc1 + prom_ingr_esc2;
    $("#prom_ingr_esc").text((prom_ingr_esc).toFixed(2) + '%');
    var prom_ingr_per = prom_ingr_per1 + prom_ingr_per2 + prom_ingr_per3;
    $("#prom_ingr_per").text((prom_ingr_per).toFixed(2) + '%');
    var prom_ingr_bolm = prom_ingr_bolm1 + prom_ingr_bolm2 + prom_ingr_bolm3 + prom_ingr_bolm4 + prom_ingr_bolm5 + prom_ingr_bolm6;
    $("#prom_ingr_bolm").text((prom_ingr_bolm).toFixed(2) + '%');
    var prom_ingr_inter = prom_ingr_inter1;
    $("#prom_ingr_inter").text((prom_ingr_inter).toFixed(2) + '%');
    //edito emmanuel
    var prom_ingr_outsour = prom_ingr_outsour1;
    $("#prom_ingr_outsour").text((prom_ingr_outsour).toFixed(2) + '%');
    //promedios total
    var total_porcentaje = prom_ingr_publi + prom_ingr_bolse + prom_ingr_trab + prom_ingr_red + prom_ingr_otros + prom_ingr_esc + prom_ingr_per
            + prom_ingr_bolm + prom_ingr_inter + prom_ingr_outsour;
    $("#porm2_tot_ingre2").text(total_porcentaje + '%');
    $("#porcent_tot_ingr").text(total_porcentaje + '%');
    //promedio final
    var promedio_ingr_publi1 = (parseFloat(((AnuncioVentana_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_publi1").text(promedio_ingr_publi1 + '%');
    var promedio_ingr_publi2 = (parseFloat(((Banner_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_publi2").text(promedio_ingr_publi2 + '%');
    var promedio_ingr_bolse1 = (parseFloat(((COMPUTRABAJO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolse1").text(promedio_ingr_bolse1 + '%');
    var promedio_ingr_bolse2 = (parseFloat(((INDEED_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolse2").text(promedio_ingr_bolse2 + '%');
    var promedio_ingr_bolse3 = (parseFloat(((TALENTECA_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolse3").text(promedio_ingr_bolse3 + '%');
    var promedio_ingr_trab1 = (parseFloat(((BRIGADAMONTERREY_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_trab1").text(promedio_ingr_trab1 + '%');
    var promedio_ingr_trab2 = (parseFloat(((FERIAEMPLEOGUADALUPE_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_trab2").text(promedio_ingr_trab2 + '%');
    var promedio_ingr_trab3 = (parseFloat(((FERIAEMPLEOSANNICOLAS_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_trab3").text(promedio_ingr_trab3 + '%');
    var promedio_ingr_trab4 = (parseFloat(((FERIAEMPLEOSANESCOBEDO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_trab4").text(promedio_ingr_trab4 + '%');
    var promedio_ingr_trab5 = (parseFloat(((VOLANTEO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_trab5").text(promedio_ingr_trab5 + '%');
    var promedio_ingr_trab6 = (parseFloat(((FERIAEMPLEO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_trab6").text(promedio_ingr_trab6 + '%');
    var promedio_ingr_trab7 = (parseFloat(((POSTEO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_trab7").text(promedio_ingr_trab7 + '%');
    var promedio_ingr_red1 = (parseFloat(((FACEBOOKPERSONAL_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_red1").text(promedio_ingr_red1 + '%');
    var promedio_ingr_red2 = (parseFloat(((FACEBOOKPAGINASICSA_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_red2").text(promedio_ingr_red2 + '%');
    var promedio_ingr_otros1 = (parseFloat(((RECOMENDACION_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_otros1").text(promedio_ingr_otros1 + '%');
    var promedio_ingr_otros2 = (parseFloat(((REFCONOCIDO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_otros2").text(promedio_ingr_otros2 + '%');
    var promedio_ingr_otros3 = (parseFloat(((REINGRESO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_otros3").text(promedio_ingr_otros3 + '%');
    var promedio_ingr_esc1 = (parseFloat(((UANL_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_esc1").text(promedio_ingr_esc1 + '%');
    var promedio_ingr_esc2 = (parseFloat(((UMM_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_esc2").text(promedio_ingr_esc2 + '%');
    var promedio_ingr_per1 = (parseFloat(((METRO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_per1").text(promedio_ingr_per1 + '%');
    var promedio_ingr_per2 = (parseFloat(((NORTE_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_per2").text(promedio_ingr_per2 + '%');
    var promedio_ingr_per3 = (parseFloat(((ELSOLPUEBLA_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_per3").text(promedio_ingr_per3 + '%');
    var promedio_ingr_bolm1 = (parseFloat(((SANPEDRO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolm1").text(promedio_ingr_bolm1 + '%');
    var promedio_ingr_bolm2 = (parseFloat(((MONTERREY_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolm2").text(promedio_ingr_bolm2 + '%');
    var promedio_ingr_bolm3 = (parseFloat(((ESCOBEDO_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolm3").text(promedio_ingr_bolm3 + '%');
    var promedio_ingr_bolm4 = (parseFloat(((APODACA_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolm4").text(promedio_ingr_bolm4 + '%');
    var promedio_ingr_bolm5 = (parseFloat(((SANNICOLAS_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolm5").text(promedio_ingr_bolm5 + '%');
    var promedio_ingr_bolm6 = (parseFloat(((GUADALUPE_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_bolm6").text(promedio_ingr_bolm6 + '%');
    var promedio_ingr_inter1 = (parseFloat(((INTERCAMBIODECARTERA_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_inter1").text(promedio_ingr_inter1 + '%');
    // edito emmanuel 
    var promedio_ingr_outsour1 = (parseFloat(((EMPRESA_I / total_ingresos) * 100).toFixed(2)) || 0);
    $("#promedio_ingr_outsour1").text(promedio_ingr_outsour1 + '%');
    //suma promedio final
    var promedio_ingr_publi = promedio_ingr_publi1 + promedio_ingr_publi2;
    $("#promedio_ingr_publi").text((promedio_ingr_publi).toFixed(2) + '%');
    var promedio_ingr_bolse = promedio_ingr_bolse1 + promedio_ingr_bolse2 + promedio_ingr_bolse3;
    $("#promedio_ingr_bolse").text((promedio_ingr_bolse).toFixed(2) + '%');
    var promedio_ingr_trab = promedio_ingr_trab1 + promedio_ingr_trab2 + promedio_ingr_trab3 + promedio_ingr_trab4 + promedio_ingr_trab5 + promedio_ingr_trab6 + promedio_ingr_trab7;
    $("#promedio_ingr_trab").text((promedio_ingr_trab).toFixed(2) + '%');
    var promedio_ingr_red = promedio_ingr_red1 + promedio_ingr_red2;
    $("#promedio_ingr_red").text((promedio_ingr_red).toFixed(2) + '%');
    var promedio_ingr_otros = promedio_ingr_otros1 + promedio_ingr_otros2 + promedio_ingr_otros3;
    $("#promedio_ingr_otros").text((promedio_ingr_otros).toFixed(2) + '%');
    var promedio_ingr_esc = promedio_ingr_esc1 + promedio_ingr_esc2;
    $("#promedio_ingr_esc").text((promedio_ingr_esc).toFixed(2) + '%');
    var promedio_ingr_per = promedio_ingr_per1 + promedio_ingr_per2 + promedio_ingr_per3;
    $("#promedio_ingr_per").text((promedio_ingr_per).toFixed(2) + '%');
    var promedio_ingr_bolm = promedio_ingr_bolm1 + promedio_ingr_bolm2 + promedio_ingr_bolm3 + promedio_ingr_bolm4 + promedio_ingr_bolm5 + promedio_ingr_bolm6;
    $("#promedio_ingr_bolm").text((promedio_ingr_bolm).toFixed(2) + '%');
    var promedio_ingr_inter = promedio_ingr_inter1;
    $("#promedio_ingr_inter").text((promedio_ingr_inter).toFixed(2) + '%');
    //edito emmanuel
    var promedio_ingr_outsour = promedio_ingr_outsour1;
    $("#promedio_ingr_outsour").text((promedio_ingr_outsour).toFixed(2) + '%');
    //totales promedio final
    var total_porcentaje_final = promedio_ingr_publi + promedio_ingr_bolse + promedio_ingr_trab + promedio_ingr_red + promedio_ingr_otros + promedio_ingr_esc + promedio_ingr_per
            + promedio_ingr_bolm + promedio_ingr_inter + promedio_ingr_outsour;
    $("#prom_tot_ingre2").text(total_porcentaje_final + '%');
    $("#equiv_porcent_ingr").text(total_porcentaje_final + '%');
}
;
//==============================================================================
function select_ingresos_rango(_id_caja, _desde, _hasta, _opcion) {
    var params = {
        accion: "select_ingresos_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_bajas_rango(_id_caja, _desde, _hasta, _opcion) {
    var params = {
        accion: "select_bajas_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_entrevistas_rango(_id_caja, _desde, _hasta, _opcion) {
    var params = {
        accion: "select_entrevistas_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
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
function select_datos_informe_reclutadores(_desde, _hasta) {
    var params = {
        accion: "select_datos_informe_reclutadores",
        desde: _desde,
        hasta: _hasta
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            console.log(dataRes);
            pintar_reclutadores(dataRes);
        }
    });
}
;
//==============================================================================
function pintar_reclutadores(dato) {
    var datos_reclutadores = JSON.parse(dato);
    console.log(datos_reclutadores);
    var total_citados = 0;
    var total_entrevistados = 0;
    var total_ingresos = 0;
    var total_ingresaron = 0;
    console.log(datos_reclutadores);
    for (i in datos_reclutadores) {
        $("#entrevistados_table").append('<tr>' +
                '<td>' + datos_reclutadores[i].Nombre + '</td>' +
                '<td>' + datos_reclutadores[i].Citados + '</td>' +
                '<td>' + datos_reclutadores[i].Entrevistas + '</td>' +
                '</tr>');
        total_citados = total_citados + datos_reclutadores[i].Citados;
        total_entrevistados = total_entrevistados + datos_reclutadores[i].Entrevistas;
    }
    $("#tot_citados").text(total_citados);
    $("#tot_entrevist").text(total_entrevistados);

    for (i in datos_reclutadores) {
        $("#ingresaron_table").append('<tr>' +
                '<td>' + datos_reclutadores[i].Nombre + '</td>' +
                '<td>' + datos_reclutadores[i].Programados + '</td>' +
                '<td>' + datos_reclutadores[i].Ingresos + '</td>' +
                '</tr>');
        total_ingresos = total_ingresos + datos_reclutadores[i].Programados;
        total_ingresaron = total_ingresaron + datos_reclutadores[i].Ingresos;
    }
    $("#tot_ingresos").text(total_ingresos);
    $("#tot_ingresaron").text(total_ingresaron);
}
;
//==============================================================================
function rango_fecha_pintar(desde, hasta) {
    var desde_bien = rearrangeDate(desde);
    var hasta_bien = rearrangeDate(hasta);
    function rearrangeDate(date) {
        var numbers = date.substring(0, 4);
        var numbers1 = date.substring(5, 7);
        return date.substring(8) + '-' + numbers1 + '-' + numbers;
    }
    $("#rango_fecha").append('<h6>' + '<b>' + "FECHA:" + ' ' + desde_bien + ' ' + "AL" + ' ' + hasta_bien + '</b>' + '</h6>');
}
//==============================================================================
function select_reclutadores() {
    var params = {
        accion: "select_reclutadores"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
//            console.log(dataRes);
            $("#reporte_individual").empty();
            $("#reporte_individual").append('<option value="" disabled selected>Seleciona un Reclutador</option>' + dataRes);

            $('select').material_select();
        }
    });
}
;
//==============================================================================
function select_datos_informe_individual_vacantes(_desde, _hasta, _id) {
    var params = {
        accion: "select_datos_informe_individual_vacantes",
        desde: _desde,
        hasta: _hasta,
        id_reclutador: _id
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            partir_datos_pintar(dataRes);
            rango_fecha_pintar(_desde, _hasta);
            var dato = dataRes.split('##');
            $("#nombre_reclu").text(dato[4]);
            console.log(dataRes);
        }
    });
}
//==============================================================================
function select_citados_rango(_id_caja, _desde, _hasta, _opcion) {
    var params = {
        accion: "select_citados_rango",
        desde: _desde,
        hasta: _hasta,
        opcion: _opcion

    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "/sistema/ManageSolicitud",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            $("#" + _id_caja).empty();
            $("#" + _id_caja).append(dataRes);
        }
    });
}
;
