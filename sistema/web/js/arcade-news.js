


function select_noticias() {
    var params = {
        accion: "select_noticias"
    };
    $.ajax({
        type: "POST",
        url: "/sistema/ManageNoticias",
        data: params,
        dataType: "html",
        success: function (dataRes) {
            var datos = dataRes.split("+");
            $("#noticia1").val(datos[0]);
            $("#noticia2").val(datos[1]);
            $("#noticia3").val(datos[2]);
            $("#noticia4").val(datos[3]);
            $("#noticia5").val(datos[4]);
        }
    });
}
;

//==============================================================================
function barrer_news() {

    var i = 1;
    setInterval(
            function () {
                var ancho = parseInt($("#div_noticias_barrido").css("width"));
                $("#div_noticias_barrido").css("width", ancho - 2 + "px");

                if (parseInt($("#div_noticias_barrido").css("width")) == 0) {
                    if (i == 5) {
                        i = 0;
                    }
                    i = i + 1;
                    $("#div_noticias_barrido").css("width", "440px");
                    $("#label_noticia").val($("#noticia" + i).val());
                }

            }, 13);


}
