// initialize validation messages variable
$.validation = {
    messages: {}
};

// add validation templates to show fancy icons with message text
$.extend($.validation.messages, {
    required: '<i class="fa fa-exclamation-circle"></i> required.',
    email: '<i class="fa fa-exclamation-circle"></i> Please enter a valid email.',
    signup_confirm_password: '<i class="fa fa-exclamation-circle"></i> Confirm password must match the password.'
});

// call our 'validateSignupForm' function when page is ready
$(document).ready(function () {
    validateSignupForm();
});

// bind jQuery validation event and form 'submit' event
var validateSignupForm = function () {
    var form_signup = $('#form_signup');
    var signup_result = $('#signup_result');

    // bind jQuery validation event
    form_signup.validate({
        rules: {
            signup_name: {
                required: true      // firstname field is required
            },
            signup_lastname: {
                required: true      // lastname field is required
            },
            signup_email: {
                required: true,     // email field is required
                email: true         // validate email address
            },
            signup_password: {
                required: true      // password field is required
            },
            signup_confirm_password: {
                required: true,     // confirm password field is required
                equalTo: '#signup_password'
            }
        },
        messages: {
            signup_name: {
                required: $.validation.messages.required
            },
            signup_lastname: {
                required: $.validation.messages.required
            },
            signup_email: {
                required: $.validation.messages.required,
                email: $.validation.messages.email
            },
            signup_password: {
                required: $.validation.messages.required
            },
            signup_confirm_password: {
                required: $.validation.messages.required,
                equalTo: $.validation.messages.signup_confirm_password
            }
        },
        errorPlacement: function (error, element) {
            // insert error message after invalid element
            error.insertAfter(element);

            // hide error message on window resize event
            $(window).resize(function () {
                error.remove();
            });
        },
        invalidHandler: function (event, validator) {
            var errors = validator.numberOfInvalids();
            if (errors) {
            } else {
            }
        }
    });

    var signup_name = $('#signup_name');
    var signup_lastname = $('#signup_lastname');
    var signup_email = $('#signup_email');
    var signup_password = $('#signup_password');

    // bind form submit event
    form_signup.on('submit', function (e) {
        // if form is valid then call AJAX script
        if (form_signup.valid()) {
            var ajaxRequest = $.ajax({
                url: 'ajax/signup.php',
                type: "POST",
                data: {
                    firstname: signup_name.val(),
                    lastname: signup_lastname.val(),
                    email: signup_email.val(),
                    password: signup_password.val()
                },
                beforeSend: function () {
                }
            });

            ajaxRequest.fail(function (data, status, errorThrown) {
                // error
                var $message = data.responseText;
                signup_result.html('<div class="alert alert-danger">' + $message + '</div>');
            });

            ajaxRequest.done(function (response) {
                // done
                var $response = $.parseJSON(response);
                signup_result.html('<div class="alert alert-success">' + $response.message + '</div>');
            });
        }

        // stop default submit event of form
        e.preventDefault();
        e.stopPropagation();
    });
}