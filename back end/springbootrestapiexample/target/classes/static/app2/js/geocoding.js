/*var stompClient = null;   
var socket = new SockJS('/gs-guide-websocket');
stompClient = Stomp.over(socket);

 function locationIdentifier(addr, id) {


    document.getElementById("reqAddr").innerHTML = addr;
  

     axios.get('https://maps.googleapis.com/maps/api/geocode/json', {
         params: {
           address: addr,
           key: "AIzaSyAtRB-MgrsBuBBB_HvpA5zwuJP9iwjN9T8"
         }
     })
     .then(function(response) { 
           var map;
           
           var lat = response.data.results[0].geometry.location.lat;
           var lng = response.data.results[0].geometry.location.lng;

           var mapProp = {
               center: new google.maps.LatLng(lat, lng),
               zoom: 15,
             
               mapTypeId: google.maps.MapTypeId.ROADMAP    
           };

           document.getElementById("latlng").value = lat + "," + lng;
           map = new google.maps.Map(document.getElementById("map"), mapProp);
           var geocoder = new google.maps.Geocoder;
           var infowindow = new google.maps.InfoWindow;

        
           var myLatLng = {lat, lng};
          

           var marker = new google.maps.Marker({
               map : map,
               position: myLatLng,
               draggable: true,           
           });

           

     })
     .catch(function(err) { 
         console.log(err);
     })
     
     $( "#submit" ).click(function() {
    	 var info_url = "http://localhost:8080/Request/position/"; 
    	 var info_url2 = "http://localhost:8080/Request/geocoding/"; 
    	 var content = document.getElementById("latlng").value;
    	 var request = createJSON2();

    	 stompClient.send("/app/realtime", {}, JSON.stringify(request));
 	    $.ajax({

 	        type: "PUT",
 	        url : info_url + id,
 	        
 	        contentType: "application/json; charset=utf-8",
 	        dataType: "json",
 	        processData: false,
 	        success: function( data, textStatus, jQxhr ){
 	            $('#response pre').html( JSON.stringify( data ) );
 	           $.ajax({

 	  	        type: "PUT",
 	  	        url : info_url2 + id +"/" +content,
 	  	        
 	  	        contentType: "application/json; charset=utf-8",
 	  	        dataType: "json",
 	  	        processData: false,
 	  	        success: function( data, textStatus, jQxhr ){
 	  	            $('#response pre').html( JSON.stringify( data ) );
 	  	        },
 	  	        error: function( jqXhr, textStatus, errorThrown ){
 	  	            console.log( errorThrown );
 	  	        }
 	  	    });
 	        },
 	        error: function( jqXhr, textStatus, errorThrown ){
 	            console.log( errorThrown );
 	        }
 	    });
    	});
 }

 function geocodeLatLng(geocoder, map, infowindow) {
    var input = document.getElementById('latlng').value;
    var latlngStr = input.split(',', 2);
    var latlng = {
        lat: parseFloat(latlngStr[0]),
        lng: parseFloat(latlngStr[1])
    };
    geocoder.geocode({
        'location': latlng
    }, function(results, status) {
        if (status === 'OK') {
            if (results[0]) {
                map.setZoom(15);
                var marker = new google.maps.Marker({
                    position: latlng,
                    map: map
                });
                infowindow.setContent(results[0].formatted_address);
                infowindow.open(map, marker);
            } else {
                window.alert('No results found');
            }
        } else {
            window.alert('Geocoder failed due to: ' + status);
        }
    });
}
 
 function createJSON2() {
	    var d = new Date();
	    var obj = new Object();
	    obj.name = null;
	    obj.phone  = null;
	    obj.address = null;
	    obj.note = "Unknow";
	    obj.position = null;
	    obj.status = null;
	    obj.time = d.getTime();
	    obj.id_drive = null;
	    obj.id_request= 1;
	    obj.geocode = null;
	    return obj;
	}*/