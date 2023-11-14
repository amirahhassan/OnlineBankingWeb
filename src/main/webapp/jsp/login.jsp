<%@ page import="util.BankInformation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="libraries.jsp"/>
    <script src="${pageContext.request.contextPath}/js/general/login.js"></script>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/banking_wp.jpg);background-size: 100%">
<h1 class="alert alert-dark bg-gradient-dark rounded-0"><%= BankInformation.getBankName() %></h1>
<br>
<?php echo $error ?>
<br>
<div id="accordion" role="tablist" class="w-25 float-right shadowBlack" style="margin-right: 222px">
    <br><h4 class="text-center">Select Your Session</h4>
    <div class="card rounded-0">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a style="text-decoration: none;" data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    <button class="btn btn-outline-primary btn-block">User Login</button>
                </a>
            </h5>
        </div>
        <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
            <div class="card-body">
                <form>
                    <input type="email" id="userLoginEmail" name="email" class="form-control" required placeholder="Enter Email">
                    <input type="password" id="userLoginPassword" name="password" class="form-control" required placeholder="Enter Password">
                    <button type="button" id="userLogin" data-type="user" class="btn btn-primary btn-block btn-sm my-1" name="userLogin">Enter </button>
                </form>
            </div>
        </div>
    </div>
    <div class="card rounded-0">
        <div class="card-header" role="tab" id="headingTwo">
            <h5 class="mb-0">
                <a class="collapsed btn btn-outline-primary btn-block" data-toggle="collapse" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Manager Login
                </a>
            </h5>
        </div>
        <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo" data-parent="#accordion">
            <div class="card-body">
                <form>
                    <input type="email" id="managerLoginEmail" name="email" class="form-control" required placeholder="Enter Email">
                    <input type="password" id="managerLoginPassword" name="password" class="form-control" required placeholder="Enter Password">
                    <button type="button" id="managerLogin" data-type="manager" class="btn btn-primary btn-block btn-sm my-1" name="managerLogin">Enter </button>
                </form>
            </div>
        </div>
    </div>
<%--    <div class="card rounded-0">--%>
<%--        <div class="card-header" role="tab" id="headingThree">--%>
<%--            <h5 class="mb-0">--%>
<%--                <a class="collapsed btn btn-outline-primary btn-block" data-toggle="collapse" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">--%>
<%--                    Cashier Login--%>
<%--                </a>--%>
<%--            </h5>--%>
<%--        </div>--%>
<%--        <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree" data-parent="#accordion">--%>
<%--            <div class="card-body">--%>
<%--                <form method="POST">--%>
<%--                    <input type="email" value="cashier@cashier.com" name="email" class="form-control" required placeholder="Enter Email">--%>
<%--                    <input type="password" name="password" value="cashier" class="form-control" required placeholder="Enter Password">--%>
<%--                    <button type="submit"  class="btn btn-primary btn-block btn-sm my-1" name="cashierLogin">Enter </button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>
</body>
</html>