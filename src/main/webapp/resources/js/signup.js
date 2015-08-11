$(document).ready(function(){
	
	$("#signupform").submit(function(e){
		e.preventDefault();
		var data = {};
        $("#signupform").serializeArray().map(function(x) {data[x.name] = x.value;});
        $.ajax({
            url : "signup",
            headers : {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            type : "post",
            dataType : 'json',
            data : JSON.stringify(data),
            beforeSend : function(xhr) {
                var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");
                xhr.setRequestHeader(header,token);
            }
        }).done(function(data){
        	var f = true;
        	$("#emaildiv").removeClass("has-error");
        	$("#passdiv").removeClass("has-error");
        	$("#repassdiv").removeClass("has-error");
        	$("#emailspan").css("visibility","hidden");
        	$("#passspan").css("visibility","hidden");
        	$("#repassspan").css("visibility","hidden");
        	$('[data-toggle="tooltip"]').tooltip();
        	$("#emaildiv input").attr("data-original-title","");
        	$("#passdiv input").attr("data-original-title","");
        	$("#repassdiv input").attr("data-original-title","");
        	if(data["email"]){
        		$("#emaildiv").addClass("has-error");
        		$("#emailspan").css("visibility","");
        		$("#emaildiv input").attr("data-original-title",data["email"]);
        		f = false;
        	}
        	if(data["pass"]){
        		$("#passdiv").addClass("has-error");
        		$("#passspan").css("visibility","");
        		$("#passdiv input").attr("data-original-title",data["pass"]);
        		f = false;
        	}
        	if(data["repass"]){
        		$("#repassdiv").addClass("has-error");
        		$("#repassspan").css("visibility","");
        		$("#repassdiv input").attr("data-original-title",data["repass"]);
        		f = false;
        	}
        	if(f){
        		bootbox.alert("Register successfully, You can login now!",function(){
        			window.location = "login";
        		});
        	}
        }).fail(function(error){
        	bootbox.alert("Error!");
        });
	});
});