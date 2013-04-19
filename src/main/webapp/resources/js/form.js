$(document).ready(function(){
  $("#newForm").click(function(){
   $("<input class='text' name=entries['key'] type='text'><input class='text' name=entries['value'] type='text'>").appendTo("#formSpace")
  });
});

