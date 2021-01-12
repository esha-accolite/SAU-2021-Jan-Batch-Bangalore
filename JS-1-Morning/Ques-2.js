function toggle_case(str) {
    var str1 = "";
    for (var i = 0; i < str.length; i++) {
        if (/[A-Z]/.test(str[i])) 
            str1 += str[i].toLowerCase();
        else 
            str1 += str[i].toUpperCase();
    }
    return str1;
}

// toggle_case("EsHa JaiSwaL");