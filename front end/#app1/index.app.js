
$(".btn-submit").click(function(){
    var request = createJSON();
    var info_url = "http://localhost:8080/Request/add";
    $.ajax({

        type: "POST",
        url : info_url,
        data: JSON.stringify(request),
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
});

function createJSON() {
    if($("#Name").val()=="" || $("#Phone").val()=="" || $("#Address").val()=="" || $("#Notes").val()=="")
        return;
    var d = new Date();
    var obj = new Object();
    obj.name = $("#Name").val();
    obj.phone  = $("#Phone").val();
    obj.address = $("#Address").val();
    obj.note =  $("#Notes").val();
    obj.position = null;
    obj.status =null;
    obj.time = d.getTime();
    obj.id_drive =null;
    return obj;
}