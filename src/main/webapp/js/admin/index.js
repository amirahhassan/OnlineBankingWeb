$(document).ready(function () {
    $('.deleteButton').on('click', function () {
        let userId = $(this).data('id');
        $.ajax({
            type: "GET",
            url: "deleteUser",
            data: {
                userId: userId
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