showInforApp1();

function showInforApp1() {
	axios.get('http://localhost:8080/Request/getall')
    .then(function(response){   	
        var source = document.getElementById("tbodys-template").innerHTML;
        var template = Handlebars.compile(source);
        var html = template(response.data);
        $('#tbodys').html(html);
    })
    .catch(function(err){
    	console.log(err);
    })
}


