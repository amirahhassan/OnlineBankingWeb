<%@ page import="util.BankInformation" %>
<%@ page import="service.UserService" %>
<%@ page import="dto.UserAccount" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
    <script src="${pageContext.request.contextPath}/js/admin/index.js"></script>
</head>
<body style="background-size: 100%" class="bg-gradient-secondary">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/indexAdmin">
        <img src="images/logo.png" style="object-fit:cover;object-position:center center" width="30" height="30"
             class="d-inline-block align-top" alt="">
        <%= BankInformation.getBankName() %>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link active" href="${pageContext.request.contextPath}/indexAdmin">Home <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/addNewUserAdmin">Add New
                Account</a></li>
            <li class="nav-item "><a class="nav-link"
                                     href="${pageContext.request.contextPath}/feedbackAdmin">Feedback</a></li>
        </ul>
        <jsp:include page="/jsp/admin/sidebutton.jsp"/>
    </div>
</nav>
<br><br><br>
<div class="container">
    <div class="card w-100 text-center shadowBlue">
        <div class="card-header">
            All accounts
        </div>
        <div class="card-body">
            <table class="table text-center table-bordered table-sm">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Holder Name</th>
                    <th scope="col">Account No.</th>
                    <th scope="col">Branch Name</th>
                    <th scope="col">Current Balance</th>
                    <th scope="col">Account type</th>
                    <th scope="col">Contact</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<UserAccount> userAccountList = UserService.listAllUsers();
                    int numberPosition = 1;
                    for (UserAccount userAccount : userAccountList) {
                %>
                <tr>
                    <th scope="row"><%= numberPosition %>
                    </th>
                    <td><%= userAccount.getName() %>
                    </td>
                    <td><%= userAccount.getAccountNo() %>
                    </td>
                    <td><%= userAccount.getBranch() %>
                    </td>
                    <td>RM <%= userAccount.getBalance() %>
                    </td>
                    <td><%= userAccount.getAccountType() %>
                    </td>
                    <td><%= userAccount.getPhoneNumber() %>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/showUserAccountAdmin?userId=<%= userAccount.getId() %>"
                           class='btn btn-success btn-sm'
                           data-toggle='tooltip' title="View More info">View</a>
                        <a href="${pageContext.request.contextPath}/noticeAdmin?userId=<%= userAccount.getId() %>"
                           class='btn btn-primary btn-sm'
                           data-toggle='tooltip' title="Send notice to this">Send Notice</a>
                        <a class='btn btn-danger btn-sm deleteButton' data-id="<%= userAccount.getId() %>"
                           data-toggle='tooltip' title="Delete this account">Delete</a>
                    </td>
                </tr>
                <%
                        numberPosition++;
                    }
                %>
                </tbody>
            </table>
            <div class="card-footer text-muted">
                <%= BankInformation.getBankName() %>
            </div>
        </div>
    </div>
</div>
</body>
</html>