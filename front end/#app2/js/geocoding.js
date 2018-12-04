
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

           document.getElementById("latlng").value = lat + "," + lng;
           map = new google.maps.Map(document.getElementById("map"), mapProp);
           var geocoder = new google.maps.Geocoder;
           var infowindow = new google.maps.InfoWindow;

           document.getElementById('submit').addEventListener('click', function() {
               geocodeLatLng(geocoder, map, infowindow);

           });
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
                map.setZoom(11);
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