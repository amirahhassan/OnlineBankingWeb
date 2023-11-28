$(document).ready(function () {
    $('#beneficiaryAccountNo').on('input', function (e) {
        // Allow only numbers (0-9)
        $(this).val(function (index, value) {
            return value.replace(/\D/g, '');
        });
    });

    $('input[name="amount"]').on('input', function () {
        // Get the user input value
        let userInput = $(this).val();

        // Validate if the input is a valid number with up to two decimal places
        if (!/^\d*\.?\d{0,2}$/.test(userInput)) {
            alert('Please enter a valid number with up to two decimal places.');
            $(this).val(''); // Clear the input field
            return;
        }

        // Convert the input value to a float for comparison
        let amount = parseFloat(userInput);

        // Get the min and max values from the HTML attributes
        let minValue = parseFloat($(this).attr('min'));
        let maxValue = parseFloat($(this).attr('max'));

        // Validate if the input is within the specified range
        if (amount < minValue || amount > maxValue) {
            alert('Please enter a value between ' + minValue + ' and ' + maxValue + '.');
            $(this).val(''); // Clear the input field
            return;
        }
    });

    $("#transfer").click(function () {
        let userId = $("#userId").val().trim();
        let beneficiaryAccountNo = $("#beneficiaryAccountNo").val().trim();
        let beneficiaryAccountName = $("#beneficiaryAccountName").val().trim();
        let amountTransfer = $("#amountTransfer").val().trim();
        let bankSelect = $("#bankSelect").val().trim();
        let action = 'transfer';

        if ($("#beneficiaryAccountNo").val().length > 0 && $("#amountTransfer").val().length > 0 && $('#bankSelect').val() != '' && $('#beneficiaryAccountName').val() != '') {
            alert("success bro")

            $.ajax({
                type: "POST",
                url: "addFundTransfer",
                data: {
                    beneficiaryAccountNo: beneficiaryAccountNo,
                    amountTransfer: amountTransfer,
                    bankSelect: bankSelect,
                    action: action,
                    userId: userId,
                    beneficiaryAccountName: beneficiaryAccountName,
                },
            }).then(
                function (successResponse) {
                    // Handle success
                    $("#transferForm").show();
                },
                function (xhr, status, error) {
                    // Handle failure
                    $("#transferForm").show();
                    // alert("No account number exists in record")
                }
            );
        } else {
            alert('Please fill in all required fields.');
        }
        // setTimeout(function(){
        //     $("#failNotify, #successNotify").hide();
        // }, 3000);

        // }else {
        //     $("#transferForm").hide();
        //     alert("Enter account number");
        // }
    });
});