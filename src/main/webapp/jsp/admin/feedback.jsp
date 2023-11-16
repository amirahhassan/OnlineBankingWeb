<%@ page import="util.BankInformation" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.FeedbackAdmin" %>
<%@ page import="service.FeedbackService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
    <script src="${pageContext.request.contextPath}/js/admin/feedback.js"></script>
</head>
<body style="background-size: 100%" class="bg-gradient-seconday">
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
                <a class="nav-link" href="${pageContext.request.contextPath}/indexAdmin">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/addNewUserAdmin">Add New
                Account</a></li>
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/feedbackAdmin">Feedback</a>
            </li>
        </ul>
        <jsp:include page="/jsp/admin/sidebutton.jsp"/>
    </div>
</nav>
<br><br><br>
<div class="container">
    <div class="card w-100 text-center shadowBlue">
        <div class="card-header">
            Feedback from Account Holder
        </div>
        <div class="card-body">
            <table class="table table-bordered table-sm bg-dark text-white text-center">
                <thead>
                <tr>
                    <th scope="col">From</th>
                    <th scope="col">Account No.</th>
                    <th scope="col">Contact</th>
                    <th scope="col">Message</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<FeedbackAdmin> feedbackAdminList = FeedbackService.listAllFeedback();
                    for (FeedbackAdmin feedbackAdmin : feedbackAdminList) {
                %>
                <tr>
                    <td><%= feedbackAdmin.getAccountNameHolder() %></td>
                    <td><%= feedbackAdmin.getAccountNo() %></td>
                    <td><%= feedbackAdmin.getContact() %></td>
                    <td><%= feedbackAdmin.getMessage() %></td>
                    <td>
                        <a data-id="<%= feedbackAdmin.getId() %>" class='btn btn-danger btn-sm deleteButton' data-toggle='tooltip' title="Delete this Message">Delete</a>
                    </td>
                </tr>
                <%
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