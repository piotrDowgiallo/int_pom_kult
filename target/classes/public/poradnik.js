// logika do komunikacji front-endu z back-endem

// nauka jquery - AJAX: http://learn.jquery.com/ajax/
//  https://www.codecademy.com/learn/jquery

$(document).ready(function() {
    $.ajax({
        url: "/testowy",
        data: test.login
    })
    //    .then(function(data) {
    //    $('.greeting-id').append(data.id);
    //    $('.greeting-content').append(data.content);
    //});
});