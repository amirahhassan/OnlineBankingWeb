$(document).ready(function () {
    $("#failSave, #successSave").hide();

    $(".upperCase").on("input", function () {
        $(this).val($(this).val().toUpperCase());
    });

    // Attach a single input event handler
    $("#cnic").on('input', function() {
        // Remove non-numeric characters
        var cleanedValue = this.value.replace(/[^0-9]/g, '');

        // Ensure the total length does not exceed 12 characters
        if (cleanedValue.length > 12) {
            cleanedValue = cleanedValue.slice(0, 12);
        }

        // Add "-" after the first 6 digits
        if (cleanedValue.length >= 6) {
            cleanedValue = cleanedValue.slice(0, 6) + '-' + cleanedValue.slice(6);
        }

        // Add "-" after the second 2 digits
        if (cleanedValue.length >= 9) {
            cleanedValue = cleanedValue.slice(0, 9) + '-' + cleanedValue.slice(9);
        }

        // Update the input field value
        this.value = cleanedValue;
    });

    $("#saveAccount").click(function () {
        let name = $("#name").val().trim();
        let ic = $("#cnic").val().trim();
        let accountNumber = $("#accountNo").val().trim();
        let accountType = $("select#accountType").val().trim();
        let city = $("#city").val().trim();
        let address = $("#address").val().trim();
        let email = $("#email").val().trim();
        let password = $("#password").val().trim();
        let deposit = $("#balance").val().trim();
        let sourceIncome = $("#source").val().trim();
        let contactNumber = $("#number").val().trim();
        let branch = $("select#branch").val().trim();

        // Check if any field is empty
        if (!name || !ic || !accountNumber || !accountType || !city || !address || !email || !password || !deposit || !sourceIncome || !contactNumber || !branch) {
            // If any field is empty, show an alert
            alert("Please fill in all the fields");
            return; // Stop here, don't proceed further
        }

        // Validate IC number format (e.g., 897878-09-8798)
        let icRegex = /^\d{6}-\d{2}-\d{4}$/;
        if (!ic.match(icRegex)) {
            // If the format is invalid, show an alert or provide feedback to the user
            alert("Invalid IC number format. Please use the format 123456-78-9012");
            return; // Stop here, don't proceed further
        }

        // Validate email format
        let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!email.match(emailRegex)) {
            // If the format is invalid, show an alert or provide feedback to the user
            alert("Invalid email format. Please enter a valid email address.");
            return; // Stop here, don't proceed further
        }

        // Validate phone number format (accepts only numeric values)
        let phoneRegex = /^\d+$/;
        if (!phoneRegex.test(contactNumber)) {
            // If the format is invalid, show an alert or provide feedback to the user
            alert("Invalid phone number format. Please enter only numeric values (0-9).");
            return; // Stop here, don't proceed further
        }

        $.ajax({
            type: "POST",
            url: "addUserAdmin",
            data: {
                name: name,
                ic: ic,
                accountNumber: accountNumber,
                accountType: accountType,
                city: city,
                address: address,
                email: email,
                password: password,
                deposit: deposit,
                sourceIncome: sourceIncome,
                contactNumber: contactNumber,
                branch: branch
            },
            success: function (data, textStatus, jqXHR) {
                if (jqXHR.status === 200) {
                    // Handle success
                    $("#successSave").show();
                    setTimeout(function(){
                        $("#successSave").hide();
                    }, 3000);

                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Handle errors
                $("#failSave").show();
                setTimeout(function(){
                    $("#failSave").hide();
                }, 3000);
            }
        })
    });
});