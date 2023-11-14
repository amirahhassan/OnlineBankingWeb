$(document).ready(function(){
    $("#failSave, #successSave").hide();



    $("#saveAccount").click(function () {

        let name = $("#name").val();
        let ic = $("#cnic").val();
        let accountNumber = $("#accountNo").val();
        let accountType = $( "select#accountType" ).val();
        let city = $("#city").val();
        let address = $("#address").val();
        let email = $("#email").val();
        let password = $("#password").val();
        let deposit = $("#balance").val();
        let sourceIncome = $("#source").val();
        let contactNumber = $("#number").val();
        let branch = $( "select#branch" ).val();
        $.ajax({
            type: "POST",
            url: "addUserAdmin",
            data: {
                name : name,
                ic : ic,
                accountNumber : accountNumber,
                accountType : accountType,
                city : city,
                address : address,
                email : email,
                password : password,
                deposit : deposit,
                sourceIncome : sourceIncome,
                contactNumber : contactNumber,
                branch : branch
            },
        }).then(
            function (successResponse) {
                // Handle success
                $('#successSave').show();
                console.log("Success:", successResponse);
                // Your success logic here
            },
            function (xhr, status, error) {
                // Handle failure
                $('#failSave').show();
                console.log("Error:", status, error);
                // Your error handling logic here
            }
        );
    });
});