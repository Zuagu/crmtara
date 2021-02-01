// INICIAN SCRIPTS PARA VALIDAR DATOS DE ENTRADA

$("td.alfanumerico").live("keyup", function ()
{
    var alNumRegex = /^([a-z A-Z 0-9 ñ Ñ & . , - - + * /]+)$/; //only letters and numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("text", $(this).text().toUpperCase());
    } else
    {
        cadena = $(this).text();

        $(this).attr("text", cadena.substring(0, cadena.length - 1));
    }

});

$("input.alfanumerico").live("keyup", function ()
{
    var alNumRegex = /^([a-z A-Z 0-9 ñ Ñ & . , - - + * /]+)$/; //only letters and numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();

        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }

});

$("textarea.alfanumerico").live("keyup", function ()
{
    var alNumRegex = /^([a-z A-Z 0-9 ñ Ñ & . , - - + * /]+)$/; //only letters and numbers
    // var alNumRegex = /^([a-z A-Z 0-9 ñ Ñ & . , - + * /]+)$/; //only letters and numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();

        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }

});

$("textarea.sms").live("keyup", function ()
{
    var alNumRegex = /^([a-z A-Z 0-9 . , _ ]+)$/; //only letters and numbers
//     var alNumRegex = /^([a-z A-Z 0-9 ñ Ñ & . , - + * /]+)$/; //only letters and numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();

        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }

});

$("textarea.letras").live("keyup", function ()
{
    var alNumRegex = /^([a-z A-Z ñ Ñ]+)$/; //only letters and numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();

        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }

});

$("input.entero").live("keyup", function ()
{
    var alNumRegex = /^([0-9]+)$/; //only numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();

        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }

});

$("input.letras").live("keyup", function ()
{
    var alNumRegex = /^([a-z A-Z ñ Ñ]+)$/; //only letters and numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();

        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }

});

$("input.flotante").live("keyup", function ()
{
    var alNumRegex = /^([0-9 . ]+)$/; //only numbers
    var cadena = new Array();
    if (alNumRegex.test($(this).val())) {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();

        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }

});

$("input.rfcF").live("keyup", function ()
{
    var letras = /^([a-z A-Z 0-9 -]+)$/;
    var cadena = new Array();
    cadena = $(this).val();
    if (cadena.length == 4 || cadena.length == 11)
        $(this).attr("value", cadena + "-");
    if (letras.test($(this).val()))
    {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();
        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }
});

$("input.rfcM").live("keyup", function ()
{
    var letras = /^([a-z A-Z 0-9 -]+)$/;
    var cadena = new Array();
    cadena = $(this).val();
    if (cadena.length > 14)
        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    if (cadena.length == 3 || cadena.length == 10)
        $(this).attr("value", cadena + "-");
    if (letras.test($(this).val()))
    {
        $(this).attr("value", $(this).val().toUpperCase());
    } else
    {
        cadena = $(this).val();
        $(this).attr("value", cadena.substring(0, cadena.length - 1));
    }
}
);

// TERMINAN SCRIPTS PARA VALIDAR DATOS DE ENTRADA