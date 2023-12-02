$(document).ready(function(){
    $("#userLogin").click(function () {
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
});