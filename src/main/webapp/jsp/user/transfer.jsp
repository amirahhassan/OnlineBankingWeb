<%@ page import="util.BankInformation" %>
<%@ page import="dto.UserAccount" %>
<%@ page import="service.TransactionService" %>
<%@ page import="java.util.Map" %>
<%@ page import="dto.AccountStatement" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
    <script src="${pageContext.request.contextPath}/js/user/transfer.js"></script>
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
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/statementUser">Account
                Statements</a></li>
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/transferUser">Funds
                Transfer</a></li>
        </ul>
        <jsp:include page="/jsp/user/sidebutton.jsp"/>
    </div>
</nav>
<br><br><br>
<div class="container">
    <div class="card  w-75 mx-auto">
        <div class="card-header text-center">
            Funds Transfer
        </div>
        <%
            // Retrieve the parameter
//            String userId = (String) request.getAttribute("userId");
            String userId = "5";
            UserAccount userAccount = TransactionService.getUserAccountBankInfo(userId);
        %>
        <input type='text' value='<%= userAccount.getId() %>' id="userId" name='userId' hidden>
        <div class="card-body">
            <div class='alert alert-success w-50 mx-auto'>
                <form>
                    Account No.
                    <input type='text' value='<%= userAccount.getAccountNo() %>' id="senderAccountNo"
                           name='senderAccountNo' class='form-control ' readonly required>

                    Account Holder Name.
                    <input type='text' class='form-control' value='<%= userAccount.getName() %>' readonly required>

                    Account Holder Bank Name.
                    <input type='text' class='form-control' value='<%= BankInformation.getBankName() %>' readonly
                           required>

                    Beneficiary Account No.
                    <input type='text' id="beneficiaryAccountNo" name='beneficiaryAccountNo' class='form-control'
                           required>

                    Beneficiary Account Holder Name.
                    <input type='text' id="beneficiaryAccountName" name='beneficiaryAccountName' class='form-control'
                           required>

                    Beneficiary Bank Name.
                    <select name="bankSelect" id="bankSelect" class="form-control input-sm" required>
                        <option selected value="">Please Select..</option>
                        <%
                            Map<String, String> bankList = BankInformation.getBankNameList();
                            for (Map.Entry<String, String> entry : bankList.entrySet()) {
                        %>
                        <option value='<%= entry.getKey() %>'><%= entry.getKey() %>-<%= entry.getValue() %>
                        </option>
                        <%
                            }
                        %>
                    </select>

                    Enter Amount for transfer.
                    <input type='text' id="amountTransfer" name='amount' class='form-control' min='1'
                           max='<%= userAccount.getBalance() %>' required>

                    <div class="text-center">
                        <button type="button" id="transfer" name='transfer'
                                class='btn btn-primary btn-bloc btn-sm my-1'>Transfer
                        </button>
                    </div>
                </form>
            </div>

            <br>
            <h5>Transfer History</h5>
            <div id="list-group rounded-0">
                <%
                    List<AccountStatement> accountStatementList = TransactionService.getAccountStatementByUserId("5");
                    int stopperCheck = 0;

                    if (accountStatementList.size() > 0) {
                        for (AccountStatement statement : accountStatementList) {
                            if (statement.getAction().equals("transfer")) {
                                stopperCheck++;
                                if (stopperCheck == 1) {
                %>
                <div class='list-group-item alert alert-warning'>Transfer have been made for
                    RM <%= statement.getDebit() %> from your account at <%= statement.getTimeStamp() %> in account
                    no <%= statement.getReceiverAccountNumber() %>
                </div>
                <%
                                }
                            }
                        }
                    } else{
                %>
                <div class='list-group-item list-group-item-action text-muted'>You have made no transfer yet.</div>
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