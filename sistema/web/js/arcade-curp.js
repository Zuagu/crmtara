
// INICIA CODIGO PARA GENERAR CURP
function generar_curp() {
    var paterno1st = $('#paternos').val();

    paterno1st = paterno1st.replace("LAS ", "");
    paterno1st = paterno1st.replace("DEL ", "");

    var paterno = paterno1st.replace("LA ", "");
    paterno = paterno.replace("DE ", "");
    paterno = paterno.replace("Y ", "");

    while (paterno[0] == " ") {
        paterno = paterno.substr(1, paterno.length - 1);
    }

    var materno1st = $('#maternos').val();
    var materno1st = materno1st.replace("LAS ", "");
    materno1st = materno1st.replace("DEL ", "");
    materno1st = materno1st.replace("DE ", "");

    var materno = materno1st.replace("LA ", "");
    materno = materno.replace("Y", "");

    while (materno[0] == " ") {
        materno = materno.substr(1, materno.length - 1);
    }

    var nombre = $('#nombres').val();

    var op_paterno = paterno.length;
    var vocales = /^[AEIOU]/i;
    var consonantes = /^[BCDFGHJKLMNÑPQRSTVWXYZ]/i;

    var s1 = "";
    var s2 = "";
    var s8 = "";

    var i = 1;
    var z = true;

    if (paterno[0] == "Ñ") {
        s1 = "X";
    } else {
        s1 = paterno[0];
    }

    while (i < op_paterno) {

        if ((vocales.test(paterno[i]) == true) && (z != false)) {
            s2 = s2 + paterno[i];
            paterno = paterno.substring(1);
            z = false;
        }
        i++;
    }

    var ix = 0;
    var y = true;
    var nparteno = paterno.length;

    while (ix < nparteno) {
        if ((consonantes.test(paterno[ix]) == true) && (y != false)) {
            s8 = s8 + paterno[ix];
            y = false;
        }
        ix++;
    }

    //calculos apellido materno
    var maternosize = materno.length;
    var j = 1;
    var s9 = "";
    var xm = true;
    var ym = true;

    while (j < maternosize) {
        if ((consonantes.test(materno[j]) == true) && (xm != false)) {
            s9 = s9.replace(materno[j], "");
            xm = false;
        }

        if ((consonantes.test(materno[j]) == true) && (ym != false)) {
            s9 = s9 + materno[j];
            ym = false;
        }

        j++;
    }

    var nombresize = nombre.length;
    var im = 1;
    var s10 = "";
    var wx = true;
    var wz = true;

    while (im < nombresize) {

        if ((consonantes.test(nombre[im]) == true) && (wz != false)) {
            s10 = s10 + nombre[im];
            nombre = nombre.replace(nombre[im], "");
            wz = false;
        }
        im++;
    }

    var sexo = $('#sexos').val();
    if (sexo == 'H') {
        sexo = "H";
    } else {
        sexo = "M";
    }

    var edo = $('#id_estados').val();

    switch (edo) {
        case '1':
            edo = "AS";
            break;
        case '2':
            edo = "BC";
            break;
        case '3':
            edo = "BS";
            break;
        case '4':
            edo = "CC";
            break;
        case '5':
            edo = "CS";
            break;
        case '6':
            edo = "CH";
            break;
        case '7':
            edo = "CL";
            break;
        case '8':
            edo = "CM";
            break;
        case '9':
            edo = "DF";
            break;
        case '10':
            edo = "DG";
            break;
        case '11':
            edo = "GT";
            break;
        case '12':
            edo = "GR";
            break;
        case '13':
            edo = "HG";
            break;
        case '14':
            edo = "JC";
            break;
        case '15':
            edo = "MC";
            break;
        case '16':
            edo = "MN";
            break;
        case '17':
            edo = "MS";
            break;
        case '18':
            edo = "NT";
            break;
        case '19':
            edo = "NL";
            break;
        case '20':
            edo = "OC";
            break;
        case '21':
            edo = "PL";
            break;
        case '22':
            edo = "QT";
            break;
        case '23':
            edo = "QR";
            break;
        case '24':
            edo = "SP";
            break;
        case '25':
            edo = "SL";
            break;
        case '26':
            edo = "SR";
            break;
        case '27':
            edo = "TC";
            break;
        case '28':
            edo = "TS";
            break;
        case '29':
            edo = "TL";
            break;
        case '30':
            edo = "VZ";
            break;
        case '31':
            edo = "YN";
            break;
        case '32':
            edo = "ZS";
            break;
    }

    var s3 = materno[0];
    var s4 = nombre[0];

    var fecha = $('#f_nacimientos').val();

    var anio = fecha.substring(2, 4);
    var mes = fecha.substring(5, 7);
    var dia = fecha.substring(8, 10);

    /*document.getElementById('txt_RFC').value = s1+s2+s3+s4+s5+s6+s7;*/
    $('#curps').val(s1 + s2 + s3 + s4 + anio + mes + dia + sexo + edo + s8 + s9 + s10);
    $('#curps').val($("#curps").val().substr(0, 23));
}
// TERMINA CODIGO PARA GENERAR CURP

// INICIA CODIGO PARA GENERAR CURP
function generar_curp_insert() {
    var paterno1st = $('#paterno').val();

    paterno1st = paterno1st.replace("LAS ", "");
    paterno1st = paterno1st.replace("DEL ", "");

    var paterno = paterno1st.replace("LA ", "");
    paterno = paterno.replace("DE ", "");
    paterno = paterno.replace("Y ", "");

    while (paterno[0] == " ") {
        paterno = paterno.substr(1, paterno.length - 1);
    }

    var materno1st = $('#materno').val();
    var materno1st = materno1st.replace("LAS ", "");
    materno1st = materno1st.replace("DEL ", "");
    materno1st = materno1st.replace("DE ", "");

    var materno = materno1st.replace("LA ", "");
    materno = materno.replace("Y", "");

    while (materno[0] == " ") {
        materno = materno.substr(1, materno.length - 1);
    }

    var nombre = $('#nombre').val();

    var op_paterno = paterno.length;
    var vocales = /^[AEIOU]/i;
    var consonantes = /^[BCDFGHJKLMNÑPQRSTVWXYZ]/i;

    var s1 = "";
    var s2 = "";
    var s8 = "";

    var i = 1;
    var z = true;

    if (paterno[0] == "Ñ") {
        s1 = "X";
    } else {
        s1 = paterno[0];
    }

    while (i < op_paterno) {

        if ((vocales.test(paterno[i]) == true) && (z != false)) {
            s2 = s2 + paterno[i];
            paterno = paterno.substring(1);
            z = false;
        }
        i++;
    }

    var ix = 0;
    var y = true;
    var nparteno = paterno.length;

    while (ix < nparteno) {
        if ((consonantes.test(paterno[ix]) == true) && (y != false)) {
            s8 = s8 + paterno[ix];
            y = false;
        }
        ix++;
    }

    //calculos apellido materno
    var maternosize = materno.length;
    var j = 1;
    var s9 = "";
    var xm = true;
    var ym = true;

    while (j < maternosize) {
        if ((consonantes.test(materno[j]) == true) && (xm != false)) {
            s9 = s9.replace(materno[j], "");
            xm = false;
        }

        if ((consonantes.test(materno[j]) == true) && (ym != false)) {
            s9 = s9 + materno[j];
            ym = false;
        }

        j++;
    }

    var nombresize = nombre.length;
    var im = 1;
    var s10 = "";
    var wx = true;
    var wz = true;

    while (im < nombresize) {

        if ((consonantes.test(nombre[im]) == true) && (wz != false)) {
            s10 = s10 + nombre[im];
            nombre = nombre.replace(nombre[im], "");
            wz = false;
        }
        im++;
    }

    var sexo = $('#sexo').val();
    if (sexo == 'H') {
        sexo = "H";
    } else {
        sexo = "M";
    }

    var edo = $('#id_estado').val();

    switch (edo) {
        case '1':
            edo = "AS";
            break;
        case '2':
            edo = "BC";
            break;
        case '3':
            edo = "BS";
            break;
        case '4':
            edo = "CC";
            break;
        case '5':
            edo = "CS";
            break;
        case '6':
            edo = "CH";
            break;
        case '7':
            edo = "CL";
            break;
        case '8':
            edo = "CM";
            break;
        case '9':
            edo = "DF";
            break;
        case '10':
            edo = "DG";
            break;
        case '11':
            edo = "GT";
            break;
        case '12':
            edo = "GR";
            break;
        case '13':
            edo = "HG";
            break;
        case '14':
            edo = "JC";
            break;
        case '15':
            edo = "MC";
            break;
        case '16':
            edo = "MN";
            break;
        case '17':
            edo = "MS";
            break;
        case '18':
            edo = "NT";
            break;
        case '19':
            edo = "NL";
            break;
        case '20':
            edo = "OC";
            break;
        case '21':
            edo = "PL";
            break;
        case '22':
            edo = "QT";
            break;
        case '23':
            edo = "QR";
            break;
        case '24':
            edo = "SP";
            break;
        case '25':
            edo = "SL";
            break;
        case '26':
            edo = "SR";
            break;
        case '27':
            edo = "TC";
            break;
        case '28':
            edo = "TS";
            break;
        case '29':
            edo = "TL";
            break;
        case '30':
            edo = "VZ";
            break;
        case '31':
            edo = "YN";
            break;
        case '32':
            edo = "ZS";
            break;
    }

    var s3 = materno[0];
    var s4 = nombre[0];

    var fecha = $('#f_nacimiento').val();

    var anio = fecha.substring(2, 4);
    var mes = fecha.substring(5, 7);
    var dia = fecha.substring(8, 10);

    /*document.getElementById('txt_RFC').value = s1+s2+s3+s4+s5+s6+s7;*/
    $('#curp').val(s1 + s2 + s3 + s4 + anio + mes + dia + sexo + edo + s8 + s9 + s10);
    $('#curp').val($("#curp").val().substr(0, 23));
}
// TERMINA CODIGO PARA GENERAR CURP
// =============================================================================
// INICIA CODIGO PARA GENERAR CURP
function generar_curp_contratos() {
    var paterno1st = $('#paterno_titular').val();

    paterno1st = paterno1st.replace("LAS ", "");
    paterno1st = paterno1st.replace("DEL ", "");

    var paterno = paterno1st.replace("LA ", "");
    paterno = paterno.replace("DE ", "");
    paterno = paterno.replace("Y ", "");

    while (paterno[0] == " ") {
        paterno = paterno.substr(1, paterno.length - 1);
    }

    var materno1st = $('#materno_titular').val();
    var materno1st = materno1st.replace("LAS ", "");
    materno1st = materno1st.replace("DEL ", "");
    materno1st = materno1st.replace("DE ", "");

    var materno = materno1st.replace("LA ", "");
    materno = materno.replace("Y", "");

    while (materno[0] == " ") {
        materno = materno.substr(1, materno.length - 1);
    }

    var nombre = $('#nombre_titular').val();

    var op_paterno = paterno.length;
    var vocales = /^[AEIOU]/i;
    var consonantes = /^[BCDFGHJKLMNÑPQRSTVWXYZ]/i;

    var s1 = "";
    var s2 = "";
    var s8 = "";

    var i = 1;
    var z = true;

    if (paterno[0] == "Ñ") {
        s1 = "X";
    } else {
        s1 = paterno[0];
    }

    while (i < op_paterno) {

        if ((vocales.test(paterno[i]) == true) && (z != false)) {
            s2 = s2 + paterno[i];
            paterno = paterno.substring(1);
            z = false;
        }
        i++;
    }

    var ix = 0;
    var y = true;
    var nparteno = paterno.length;

    while (ix < nparteno) {
        if ((consonantes.test(paterno[ix]) == true) && (y != false)) {
            s8 = s8 + paterno[ix];
            y = false;
        }
        ix++;
    }

    //calculos apellido materno
    var maternosize = materno.length;
    var j = 1;
    var s9 = "";
    var xm = true;
    var ym = true;

    while (j < maternosize) {
        if ((consonantes.test(materno[j]) == true) && (xm != false)) {
            s9 = s9.replace(materno[j], "");
            xm = false;
        }

        if ((consonantes.test(materno[j]) == true) && (ym != false)) {
            s9 = s9 + materno[j];
            ym = false;
        }

        j++;
    }

    var nombresize = nombre.length;
    var im = 1;
    var s10 = "";
    var wx = true;
    var wz = true;

    while (im < nombresize) {

        if ((consonantes.test(nombre[im]) == true) && (wz != false)) {
            s10 = s10 + nombre[im];
            nombre = nombre.replace(nombre[im], "");
            wz = false;
        }
        im++;
    }

    var sexo = $('#sexo').val();
    if (sexo == 'H') {
        sexo = "H";
    } else {
        sexo = "M";
    }

    var edo = $('#id_estado').val();

    switch (edo) {
        case '1':
            edo = "AS";
            break;
        case '2':
            edo = "BC";
            break;
        case '3':
            edo = "BS";
            break;
        case '4':
            edo = "CC";
            break;
        case '5':
            edo = "CS";
            break;
        case '6':
            edo = "CH";
            break;
        case '7':
            edo = "CL";
            break;
        case '8':
            edo = "CM";
            break;
        case '9':
            edo = "DF";
            break;
        case '10':
            edo = "DG";
            break;
        case '11':
            edo = "GT";
            break;
        case '12':
            edo = "GR";
            break;
        case '13':
            edo = "HG";
            break;
        case '14':
            edo = "JC";
            break;
        case '15':
            edo = "MC";
            break;
        case '16':
            edo = "MN";
            break;
        case '17':
            edo = "MS";
            break;
        case '18':
            edo = "NT";
            break;
        case '19':
            edo = "NL";
            break;
        case '20':
            edo = "OC";
            break;
        case '21':
            edo = "PL";
            break;
        case '22':
            edo = "QT";
            break;
        case '23':
            edo = "QR";
            break;
        case '24':
            edo = "SP";
            break;
        case '25':
            edo = "SL";
            break;
        case '26':
            edo = "SR";
            break;
        case '27':
            edo = "TC";
            break;
        case '28':
            edo = "TS";
            break;
        case '29':
            edo = "TL";
            break;
        case '30':
            edo = "VZ";
            break;
        case '31':
            edo = "YN";
            break;
        case '32':
            edo = "ZS";
            break;
    }

    var s3 = materno[0];
    var s4 = nombre[0];

    var fecha = $('#fecha_nacimiento').val();

    var anio = fecha.substring(2, 4);
    var mes = fecha.substring(5, 7);
    var dia = fecha.substring(8, 10);

    /*document.getElementById('txt_RFC').value = s1+s2+s3+s4+s5+s6+s7;*/
    $('#curp').val(s1 + s2 + s3 + s4 + anio + mes + dia + sexo + edo + s8 + s9 + s10);
    $('#curp').val($("#curp").val().substr(0, 23));
}
// TERMINA CODIGO PARA GENERAR CURP
