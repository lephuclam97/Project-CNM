var stompClient = null;

$( document ).ready(function() {
	   
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (e) {
        	
//        	var arr= JSON.parse(e.body);
//        	
//        	data=[arr];
//        	 var source = document.getElementById("product-template").innerHTML;
//             var template = Handlebars.compile(source);
//             var html = template(data);
//             document.getElementById('products').innerHTML += html;
        	
        	$("#tableRemove tr").remove();
//        	$('#tableRemove > tr > td').remove();
        	var info_url2 = "http://localhost:8080/Request/getall"; 
            $.ajax({
                url: info_url2,
                type: 'GET',
                dataType: 'json',
                timeout: 10000
            }).done(function(data) {
         
                var source = document.getElementById("product-template").innerHTML;
                var template = Handlebars.compile(source);
                var html = template(data);
                document.getElementById('tbodys').innerHTML += html;

            })

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
        document.getElementById('tbodys').innerHTML += html;

    })
});

function loadDriver(id) {
	var info_url = "http://localhost:8080/Driver/"; 
    $.ajax({
        url: info_url + id,
        type: 'GET',
        dataType: 'json',
        timeout: 10000      		               
    }).done(function(val) {
 
//    	var val = JSON.parse(data);
		$("#id1").val(val.id_driver);
		$("#name1").val(val.name);
		$("#address1").val(val.address);
		$("#status1").val(val.status);

    })
}

