$(document).ready(function () {
    //iniciar el dropdown del menu
    $('.modal').modal({
        dismissible: true,
        opacity: 0.4,
        inDuration: 500,
        outDuration: 250
    });
    $('.tabs').tabs();
    $('select').formSelect({container: "body"});
    
    $(".dropdown-trigger").dropdown({constrainWidth: false});
    $('.sidenav').sidenav();
    $(".sidenav").append(`<li class="center"><img src="image/icon-user.png"><li>`);
    // funcion que pinta el menu
    for (let indice in menu) {
        let submenu_text = '';
        for (let i in menu[indice].submenus) {
            submenu_text += `<a href="${menu[indice].jsp[i]}" class="collection-item"><i class="material-icons left">${menu[indice].iconosSubmenus[i]}</i>${menu[indice].submenus[i]}</a>`;
        }
        $(".sidenav").append(`<li>
            <div class="collapsible-header"><i class="material-icons">${menu[indice].icono}</i>${menu[indice].name}</div>
            <div class="collapsible-body collection">${submenu_text}</div>
        </li>`);
    }
    
    $('.tooltipped').tooltip({margin: 20});
    $("#info_gestor").fadeIn(1500);
    
    $('.datepicker').datepicker({
        container: "body",
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year,
        today: 'Today',
        clear: 'Clear',
        close: 'Ok',
        autoClose: true,
        closeOnSelect: true, // Close upon selecting a date,
        format: "yyyy-mm-dd"
    });
    $('.timepicker').timepicker({
        default: 'now', // Set default time: 'now', '1:30AM', '16:30'
        fromnow: 0, // set default time to * milliseconds from now (using with default = 'now')
        twelvehour: false, // Use AM/PM or 24-hour format
        donetext: 'OK', // text for done-button
        cleartext: 'Clear', // text for clear-button
        canceltext: 'Cancel', // Text for cancel-button,
        container: "body", // ex. 'body' will append picker to body
        autoclose: false, // automatic close timepicker
        ampmclickable: true, // make AM PM clickable
        aftershow: function () {} //Function for after opening timepicker
    });
    $('select').formSelect();
    $('.collapsible').collapsible();

});


//funcion cerrar sesion con boton
$("#cerrar").click(function () {
    Cerrar();
});

//actualizar el estatus de f_logeado al cerar pestaña
function Cerrar() {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerUsuario",
        data: {action: "cerrar_sesion", id_usuario: id_usuario}
    });
}

// funcion que lanza el menu lateral
$(".img_log").click(function () {
    $('.sidenav').sidenav('open');
});

