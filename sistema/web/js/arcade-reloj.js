function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    var dn = "PM";
    if (h < 12) {
        dn = "AM";
    }
    if (h > 12) {
        h = h - 12;
    }
    if (h == 0) {
        h = 12;
    }
    m = checkTime(m);
    s = checkTime(s);

    document.getElementById('reloj_main').innerHTML =
            h + ":" + m + ":" + s + " " + dn;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    ;  // add zero in front of numbers < 10
    return i;
}