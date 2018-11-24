var stompClient = null;

$( document ).ready(function() {
	   
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (e) {
        	
        	var arr= JSON.parse(e.body);
        	
        	data=[arr];
        	 var source = document.getElementById("product-template").innerHTML;
             var template = Handlebars.compile(source);
             var html = template(data);
             document.getElementById('products').innerHTML += html;

        });
    });    

    var info_url = "http://localhost:8080/Request/getall"; 
    $.ajax({
        url: info_url,
        type: 'GET',
        dataType: 'json',
        timeout: 10000
    }).done(function(data) {
 
        var source = document.getElementById("product-template").innerHTML;
        var template = Handlebars.compile(source);
        var html = template(data);
        document.getElementById('products').innerHTML += html;

    })
});


