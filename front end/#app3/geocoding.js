
 function locationIdentifier(addr) {
  
    
	if(document.getElementById('addressDriver').value === ''){
         alert("Please Enter the address of Driver!");
         location.reload();
    }
    else{
    document.getElementById("reqAddr").innerHTML = addr;
    document.getElementById("reqAddDriver").innerHTML = document.getElementById("addressDriver").value;

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
               destination:document.getElementById("addressDriver").value,
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