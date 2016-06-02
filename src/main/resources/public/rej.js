$(document).ready(function() {
        var $login = $("#login");
        var $email = $("#email");
        var $secondname = $("#second_name");
        var $firstname = $("#first_name");
        var $password = $("#password");
        var $cpassword = $("#cpassword");
    
    $('rej').on("click", function() {

        $("#green").fadeOut(1000);
        var user = {
            login: $login.val(),
            password: $password.val(),
            first_name: $first_name.val(),
            second_name: $second_name.val(),
        }
         $.ajax({
            type: 'POST',
                url: "/user/create",
                data: user,

           });
    
    });
});
