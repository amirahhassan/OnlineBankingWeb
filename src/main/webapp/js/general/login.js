$(document).ready(function(){
    $("#userLogin, #managerLogin").click(function () {
        // Get the ID of the clicked button
        let clickedButtonId = $(this).attr('id');
        let userType = '';
        let email = '';
        let password = '';

        // Use the ID to determine which button is clicked
        if (clickedButtonId === 'userLogin') {
            userType = $('.btn[name="userLogin"]').attr('data-type');
            email = $("#userLoginEmail").val();
            password = $("#userLoginPassword").val();
        } else if (clickedButtonId === 'managerLogin') {
            userType = $('.btn[name="managerLogin"]').attr('data-type');
            email = $("#managerLoginEmail").val();
            password = $("#managerLoginPassword").val();
        }

        $.ajax({
            type: "POST",
            url: "loginByRoles",
            data: {
                userType : userType,
                email : email,
                password : password
            },
        }).then(
            function (successResponse) {
                // Handle success
                window.location.href = successResponse;
            },
            function (xhr, status, error) {
                // Handle failure
                alert("Wrong username/password")
            }
        );
    });
});