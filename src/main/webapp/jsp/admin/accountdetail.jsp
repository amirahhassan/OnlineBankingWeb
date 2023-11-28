<%@ page import="util.BankInformation" %>
<%@ page import="service.UserService" %>
<%@ page import="dto.AccountProfile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
</head>
<body style="background-size: 100%" class="bg-gradient-secondary">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">
        <img src="images/logo.png" style="object-fit:cover;object-position:center center" width="30" height="30" class="d-inline-block align-top" alt="">
        <%= BankInformation.getBankName() %>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link active" href="${pageContext.request.contextPath}/indexAdmin">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/addNewUserAdmin">Add New Account</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/feedbackAdmin">Feedback</a></li>
        </ul>
        <jsp:include page="/jsp/admin/sidebutton.jsp"/>
    </div>
</nav><br><br><br>
<div class="container">
    <div class="card w-100 text-center shadowBlue">
        <%
            // Retrieve the parameter
            String userId = (String) request.getAttribute("userId");
            AccountProfile accountProfile = UserService.getUserById(Integer.parseInt(userId));
        %>
        <div class="card-header">
            Account profile for <%= accountProfile.getName() %> <kbd>#<%= accountProfile.getAccountNo() %></kbd>
        </div>
        <div class="card-body">
            <table class="table table-bordered text-center">
                <tbody>
                <tr>
                    <td>Name</td>
                    <th><%= accountProfile.getName() %></th>
                    <td>Account No</td>
                    <th><%= accountProfile.getAccountNo() %></th>
                </tr><tr>
                    <td>Branch Name</td>
                    <th><%= accountProfile.getBranchName() %></th>
                    <td>Branch Code</td>
                    <th><%= accountProfile.getBranchCode() %></th>
                </tr><tr>
                    <td>Current Balance</td>
                    <th><%= accountProfile.getBalance() %></th>
                    <td>Account Type</td>
                    <th><%= accountProfile.getAccountType() %></th>
                </tr><tr>
                    <td>Cnic</td>
                    <th><%= accountProfile.getCnic() %></th>
                    <td>City</td>
                    <th><%= accountProfile.getCity() %></th>
                </tr><tr>
                    <td>Contact Number</td>
                    <th><%= accountProfile.getPhoneNumber() %></th>
                    <td>Address</td>
                    <th><%= accountProfile.getAddress() %></th>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-muted">
            <%= BankInformation.getBankName() %>
        </div>
    </div>
</div>
</body>
</html>