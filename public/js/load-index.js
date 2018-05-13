import $ from "/assets/js/lib/jquery-3.3.1.js";

$(document).ready(function(){
    let baseUrl = window.location.host;
    $.get('${baseUrl}/book-count',function(data,status){
        console.log(data);
    });
    $("button#bt").click(function(){
//                console.log($.get('http://localhost:5974/users'));
        $.get('http://localhost:5974/users',function(data,status){
        });

    });
});