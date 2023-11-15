$(document).ready(function(){
    $("#successNotify, #failNotify").hide();

    $("#buttonSave").click(function () {
        if ($("#msg").val().length > 0){
            let msg = $("#msg").val();
            $.ajax({
                type: "POST",
                url: "addUserFeedback",
                data: {
                    userMsg : msg,
                    userId : "12",
                },
            }).then(
                function (successResponse) {
                    // Handle success
                    $("#successNotify").show();
                    setTimeout(function(){
                        $("#successNotify").hide();
                    }, 3000);
                },
                function (xhr, status, error) {
                    // Handle failure
                    alert("Wrong username/password")
                    $("#failNotify").show();
                    setTimeout(function(){
                        $("#failNotify").hide();
                    }, 3000);
                }
            );
        }else {
            alert("Enter some text")
            $("#failNotify").show();
        }
        setTimeout(function(){
            $("#failNotify, #successNotify").hide();
        }, 3000);
    });
});