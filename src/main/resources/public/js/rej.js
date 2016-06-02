$(document).ready(function() {
		var $login = $("#login");
		var $email = $("#email");
		var $secondname = $("#second_name");
		var $firstname = $("#first_name");
		var $password = $("#password");
		var $cpassword = $("#cpassword");
	
	$('#rej').on("click",function(){
		$("#green").fadeOut(1000);
	});

	$('#rej').click(function() {

		var user = {
			login: $login.val(),
			password: $password.val(),
			first_name: $first_name.val(),

		}
		 $.ajax({
		 	type: 'POST',
        		url: "/user/create",
        		data: {
					login: $login.val(),
					password: $password.val(),
					first_name: $first_name.val(),
				},
		        		success: function(newUser){
        			('<li>id: '+ id_user +'</li>');
        		},
        		error: function(){
        			alert('blad');
        		}
    		});
	
	});
});
