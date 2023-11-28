<%@ page import="util.BankInformation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
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
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accountUser">Accounts</a></li>
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/statementUser">Account Statements</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/transferUser">Funds Transfer</a></li>
        </ul>
        <jsp:include page="/jsp/user/sidebutton.jsp"/>
    </div>
</nav><br><br><br>
<div class="container">
    <div class="card  w-75 mx-auto">
        <div class="card-header text-center">
            Transaction made against you account
        </div>
        <div class="card-body">
            <div id="list-group rounded-0">
                <?php
      $array = $con->query("select * from transaction where userId = '$userData[id]' order by date desc");
                if ($array ->num_rows > 0)
                {
                while ($row = $array->fetch_assoc())
                {
                if ($row['action'] == 'withdraw')
                {
                echo "<div class='list-group-item alert alert-secondary'>You withdraw Rs.$row[debit] from your account at $row[date]</div>";
                }
                if ($row['action'] == 'deposit')
                {
                echo "<div class='list-group-item alert alert-success'>You deposit Rs.$row[credit] in your account at $row[date]</div>";
                }
                if ($row['action'] == 'deduction')
                {
                echo "<div class='list-group-item alert alert-danger'>Deduction have been made for  Rs.$row[debit] from your account at $row[date] in case of $row[other]</div>";
                }
                if ($row['action'] == 'transfer')
                {
                echo "<div class='list-group-item alert alert-warning'>Transfer have been made for  Rs.$row[debit] from your account at $row[date] in  account no.$row[other]</div>";
                }

                }
                } else{
                echo "<div class='text-center'><small class='text-muted'><i>No Transcaction has been made yet.</i></small></div>";
                }
                ?>
            </div>
        </div>
        <div class="card-footer text-muted">
            <%= BankInformation.getBankName() %>
        </div>
    </div>
</div>
</body>
</html>