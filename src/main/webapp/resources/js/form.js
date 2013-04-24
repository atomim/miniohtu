var i = 0;
function change() {
    $("#key-" + i).val($("#value-" + i).val());
    i++;
}
$(document).ready(function() {
    $("#newForm").click(function() {
        $("<input class='text' name='' type='text' id='key-" + i + "' onchange='this.name=this.value'><input class='text' type='text' id='value-" + i + "' onchange='change()'>").appendTo("#formSpace");
    });
});