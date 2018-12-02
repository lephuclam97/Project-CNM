// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}

$( "#target" ).click(function() {
	var name = document.getElementById("name").value;
	var pass = document.getElementById("pass").value;
	var info_url = 'http://localhost:8080/Driver/login/'+name+'/'+pass;
	$.ajax({
		url : 'http://localhost:8080/Driver/login/'+name+'/'+pass,
		type : 'GET',
		dataType : 'json',
		timeout : 10000
	}).done(function(data) {
//		if(data===null){
//			alert("none");
//		}
//		else{
			alert("Hello! I am an alert box!!");
//		}
	})
});