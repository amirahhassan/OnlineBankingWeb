<%@ page import="service.TransactionService" %>
<%
    // Retrieve the parameter
//  String userId = (String) request.getAttribute("userId");
    String amountBalanceByUserId = TransactionService.getBalanceByUserId(Integer.parseInt("1"));
%>
<form class="form-inline my-2 my-lg-0">
    <a href="" class="btn btn-outline-primary" data-toggle="tooltip" title="Your current Account Balance">Account Balance : RM <%= amountBalanceByUserId %></a>
    <a href="${pageContext.request.contextPath}/accountUser" data-toggle="tooltip" title="Account Summary" class="btn btn-outline-info mx-1" ><i class="fa fa-book fa-fw"></i></a>
    <a href="${pageContext.request.contextPath}/noticeUser" data-toggle="tooltip" title="View Notice" class="btn btn-outline-info mx-1" ><i class="fa fa-envelope fa-fw"></i></a>
    <a href="${pageContext.request.contextPath}/feedbackUser" data-toggle="tooltip" title="Help?" class="btn btn-outline-info mx-1" ><i class="fa fa-question fa-fw"></i></a>
    <a href="${pageContext.request.contextPath}/" data-toggle="tooltip" id="Logout" class="btn btn-outline-danger mx-1" ><i class="fa fa-sign-out fa-fw"></i></a>
</form>