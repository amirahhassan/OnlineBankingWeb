<%@ page import="util.BankInformation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
    <script src="${pageContext.request.contextPath}/js/user/feedback.js"></script>
</head>
<body style="background-size: 100%" class="bg-gradient-secondary">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="">
        <img src="images/logo.png" style="object-fit:cover;object-position:center center" width="30" height="30" class="d-inline-block align-top" alt="">
        <%= BankInformation.getBankName() %>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/indexUser">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/accountUser">Accounts</a></li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/statementUser">Account Statements</a></li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/transferUser">Funds Transfer</a></li>
        </ul>
        <jsp:include page="/jsp/user/sidebutton.jsp"/>
    </div>
</nav><br><br><br>
<div class="container">
    <div class="card  w-75 mx-auto">
        <div class="card-header text-center">
            Help Card
        </div>
        <div class="card-body">
            <form>
                <div class="alert alert-success w-50 mx-auto">
                    <h5>Enter your message</h5>
                    <textarea id="msg" class="form-control" required placeholder="Write your message"></textarea>
                    <button id="buttonSave" type="button" class="btn btn-primary btn-block btn-sm my-1">Send</button>
                </div>
            </form>
            <br>
            <div id="successNotify" class='alert alert-success'>Successfully send feedback</div>
            <div id="failNotify" class='alert alert-danger'>Not sent Error</div>
        </div>
        <div class="card-footer text-muted text-center">
            <%= BankInformation.getBankName() %>
        </div>
    </div>
</div>
</body>
</html>