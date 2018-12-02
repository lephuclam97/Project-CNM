
 function locationIdentifier(addr, id) {
  
    
	var addr2;
	if(id === ''){
         alert("This Request hasn't a Driver!");
         location.reload();
    }
    else{
      
      var info_url = "http://localhost:8080/Driver/"; 
        $.ajax({
            url: info_url + id,
            type: 'GET',
            dataType: 'json',
            timeout: 10000                         
        }).done(function(val) { 
          addr2 = val.address;
          document.getElementById("reqAddDriver").innerHTML = val.address;
        })
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
               zoom: 30,           
               mapTypeId: google.maps.MapTypeId.ROADMAP    
           };

         
           map = new google.maps.Map(document.getElementById("map"), mapProp);

           var myLatLng = {lat, lng};
          

           var marker = new google.maps.Marker({
               map : map,
               position: myLatLng,
               draggable: true,           
           });

           var directionsService = new google.maps.DirectionsService;
           directionsService.route({
               origin:addr,
               destination:addr2,
               travelMode: 'DRIVING',
           },function(result,status){
               if(status === 'OK')
               {
                   directionsDisplay = new google.maps.DirectionsRenderer({
                       directions: result,
                       map:map
                   });
                   console.log(result);
               }
           });

           google.maps.event.addListener(marker, 'dragend', function() {
               var marker_pos = marker.getPosition();

           });
     })
     .catch(function(err) { 
         console.log(err);
     })
    }
 }