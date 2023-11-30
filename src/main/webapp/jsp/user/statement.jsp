<%@ page import="util.BankInformation" %>
<%@ page import="dto.AccountStatement" %>
<%@ page import="service.TransactionService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
</head>
<body style="background-size: 100%" class="bg-gradient-secondary">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="">
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
                <a class="nav-link" href="${pageContext.request.contextPath}/indexUser">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accountUser">Accounts</a>
            </li>
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/statementUser">Account
                Statements</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/transferUser">Funds
                Transfer</a></li>
        </ul>
        <jsp:include page="/jsp/user/sidebutton.jsp"/>
    </div>
</nav>
<br><br><br>
<div class="container">
    <div class="card  w-75 mx-auto">
        <div class="card-header text-center">
            Transaction made against you account
        </div>
        <%
            // Retrieve the parameter
            String userId = (String) request.getAttribute("userId");
            List<AccountStatement> accountStatementList = TransactionService.getAccountStatementByUserId("5");
            int stopperCheck = 0;
        %>
        <div class="card-body">
            <div id="list-group rounded-0">
                <%
                    if (accountStatementList.size() > 0) {
                        for (AccountStatement statement : accountStatementList) {
                            stopperCheck++;
                            if (stopperCheck < 5) {
                                if (statement.getAction().equals("transfer")) {
                %>
                <div class='list-group-item alert alert-warning'>Transfer have been made for
                    RM <%= statement.getDebit() %> from your account at <%= statement.getTimeStamp() %> in account
                    no <%= statement.getReceiverAccountNumber() %>
                </div>
                <%
                                }
                            }
                        }
                    } else {
                %>
                <div class='text-center'><small class='text-muted'><i>No Transaction has been made yet.</i></small>
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <div class="card-footer text-muted text-center">
            <%= BankInformation.getBankName() %>
        </div>
    </div>
</div>
</body>
</html>