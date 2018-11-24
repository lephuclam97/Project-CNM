
 function locationIdentifier(addr) {


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


           map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

           var myLatLng = {lat, lng};
          

           var marker = new google.maps.Marker({
               map : map,
               position: myLatLng,
               draggable: true,           
           });

           google.maps.event.addListener(marker, 'dragend', function() {
               var marker_pos = marker.getPosition();
               document.getElementById('lat').innerHTML = marker_pos.lat();
               document.getElementById('lng').innerHTML = marker_pos.lng();
           });

     })
     .catch(function(err) { 
         console.log(err);
     })
 }