var i = 0;

function changeName(value) {
    console.log("#input-" + (i-1));
    console.log(value);
    $("#input-" + (i-1))[0].setAttribute("name", value);
}

function changeValue(value) {
    console.log("#input-" + (i-1));
    console.log(value);
    $("#input-" + (i-1))[0].setAttribute("value", value);
}

$(document).ready(function() {
    $("#newForm").click(function() {
        $("<br><input class='text' type='text' placeholder='Type..' onkeyup='changeName(this.value)'>\n\
           <input class='text' type='text' placeholder='Value..' onkeyup='changeValue(this.value)'>\n\
           <input class='hidden' id='input-"+i+"' style=display:none>").appendTo("#formSpace");
        i++;
    });
});