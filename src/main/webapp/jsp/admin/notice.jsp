<%@ page import="util.BankInformation" %>
<%@ page import="service.UserService" %>
<%@ page import="dto.AccountProfile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
</head>
<body style="background-size: 100%" class="bg-gradient-seconday">
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
                <a class="nav-link active" href="${pageContext.request.contextPath}/indexAdmin">Home <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/addNewUserAdmin">Add New
                Account</a></li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/feedbackAdmin">Feedback</a></li>
        </ul>
        <jsp:include page="/jsp/admin/sidebutton.jsp"/>
    </div>
</nav><br><br><br>
<%
    // Retrieve the parameter
    String userId = (String) request.getAttribute("userId");
    AccountProfile accountProfile = UserService.getUserById(Integer.parseInt(userId));
%>
<div class="container">
    <div class="card w-100 text-center shadowBlue">
        <div class="card-header">
            Send Notice to <%= accountProfile.getName() %>
        </div>
        <div class="card-body">
            <form method="POST">
                <div class="alert alert-success w-50 mx-auto">
                    <h5>Write notice for <%= accountProfile.getName() %></h5>
                    <input type="hidden" name="userId" value="<?php echo $row['id'] ?>">
                    <textarea class="form-control" name="notice" required placeholder="Write your message"></textarea>
                    <button type="submit" name="send" class="btn btn-primary btn-block btn-sm my-1">Send</button>
                </div>
            </form>
<%--            <?php--%>
<%--    if (isset($_POST['send']))--%>
<%--    {--%>
<%--      if ($con->query("insert into notice (notice,userId) values ('$_POST[notice]','$_POST[userId]')")) {--%>
<%--            echo "<div class='alert alert-success'>Successfully send</div>";--%>
<%--            }else--%>
<%--            echo "<div class='alert alert-danger'>Not sent Error is:".$con->error."</div>";--%>
<%--            }--%>

<%--            ?>--%>
        </div>
        <div class="card-footer text-muted">
            <%= BankInformation.getBankName() %>
        </div>
    </div>
</div>
</body>
</html>