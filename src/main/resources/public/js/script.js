$(document).ready(function() {

	
	$("#green").on("click", function(){
		$("#green").fadeOut(1000);
	});

	$('#rej').click(function() {
		$(#'rej').fadeOut(1000);

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
