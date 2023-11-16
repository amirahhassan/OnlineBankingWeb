$(document).ready(function(){
    $('.deleteButton').on('click', function() {
        let feedbackId = $(this).data('id');
        $.ajax({
            type: "POST",
            url: "deleteUserFeedback",
            data: {
                feedbackId : feedbackId,
            },
        }).then(
            function (successResponse) {
                // Handle success
                window.location.href = successResponse;
            },
            function (xhr, status, error) {
                // Handle failure
                alert("Fail to delete due to error")
            }
        );
    });
});