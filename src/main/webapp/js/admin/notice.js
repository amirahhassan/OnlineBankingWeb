$(document).ready(function(){
    $("#successNotify, #failNotify").hide();

    $("#sendButton").click(function () {
        if ($("#noticeMessage").val().length > 0){
            let noticeMessage = $("#noticeMessage").val();
            let userId = $("#userId").val();
            $.ajax({
                type: "POST",
                url: "addNoticeAdmin",
                data: {
                    noticeMessage : noticeMessage,
                    userId : userId,
                },
                success: function (data, textStatus, jqXHR) {
                    if (jqXHR.status === 200) {
                        // Handle success
                        $("#successNotify").show();
                        setTimeout(function(){
                            $("#successNotify").hide();
                        }, 3000);

                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    // Handle errors
                    $("#failNotify").show();
                    setTimeout(function(){
                        $("#failNotify").hide();
                    }, 3000);
                }
            })
        } else {
            alert("Enter some text")
            $("#failNotify").show();
        }
        setTimeout(function(){
            $("#failNotify").hide();
        }, 3000);
    });
});