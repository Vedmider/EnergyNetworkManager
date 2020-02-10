(function($) {

    $(".toggle-password").click(function() {

        $(this).toggleClass("zmdi-eye zmdi-eye-off");
        var input = $($(this).attr("toggle"));
        if (input.attr("type") == "password") {
          input.attr("type", "text");
        } else {
          input.attr("type", "password");
        }
    });




})(jQuery);

$(document).ready(function () {

    $('#signup-form').on("submit", function (e) {
        e.preventDefault();
        let login = $('#login').val();
        let password = $('#password').val();
        let email = $('#email').val();
        let first_name = $('#first-name').val();
        let last_name = $('#last-name').val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "registration",
            data: JSON.stringify({"login": login, "password": password, "email": email, "first_name": first_name, "last_name": last_name}),
            success: function (data) {
                console.log(data);
                if (data.success) {
                    alert("Successfully registered");
                    $(location).attr('href', data.url)
                } else {
                    let textNode = document.createTextNode(data.message);
                    $('.register-message').append(textNode);
                }

            }
        })
    })
})