$(document).ready(function(){
    $("#userLogin, #managerLogin").click(function () {
        let email = $("#userLoginEmail").val();
        let password = $("#userLoginPassword").val();

        if (email.trim().length > 0 && password.trim().length > 0) {
            $.ajax({
                type: "POST",
                url: "loginByRoles",
                data: {
                    email : email,
                    password : password
                }, success: function(data, textStatus, jqXHR) {
                    if (jqXHR.status === 200) {
                        // Handle success
                        window.location.href = data;
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    // Handle errors
                    alert("Wrong email/password")
                }
            })
        }else {
            alert("Please fill in the fields required")
        }
    });
    // $("#userLogin, #managerLogin").click(function () {
    //     // Get the ID of the clicked button
    //     let clickedButtonId = $(this).attr('id');
    //     let userType = '';
    //     let email = '';
    //     let password = '';
    //
    //     // Use the ID to determine which button is clicked
    //     if (clickedButtonId === 'userLogin') {
    //         userType = $('.btn[name="userLogin"]').attr('data-type');
    //         email = $("#userLoginEmail").val();
    //         password = $("#userLoginPassword").val();
    //     } else if (clickedButtonId === 'managerLogin') {
    //         userType = $('.btn[name="managerLogin"]').attr('data-type');
    //         email = $("#managerLoginEmail").val();
    //         password = $("#managerLoginPassword").val();
    //     }
    //
    //     $.ajax({
    //         type: "POST",
    //         url: "loginByRoles",
    //         data: {
    //             userType : userType,
    //             email : email,
    //             password : password
    //         }, success: function(data, textStatus, jqXHR) {
    //             if (jqXHR.status === 200) {
    //                 // Handle success
    //                 window.location.href = data;
    //             }
    //         },
    //         error: function(jqXHR, textStatus, errorThrown) {
    //             // Handle errors
    //             alert("Wrong email/password")
    //         }
    //     })
    // });
});