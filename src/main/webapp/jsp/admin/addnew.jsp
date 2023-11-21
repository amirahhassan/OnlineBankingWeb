<%@ page import="util.BankInformation" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
    <script src="${pageContext.request.contextPath}/js/admin/addnew.js"></script>
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
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/addNewUserAdmin">Add New Account</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/feedbackAdmin">Feedback</a></li>
        </ul>
        <jsp:include page="/jsp/admin/sidebutton.jsp"/>
    </div>
</nav>
<br>
<br>
<br>

<div id="failSave" class='alert alert-danger text-center'>Failed to add account</div>
<div id="successSave" class='alert alert-info text-center'>Account added Successfully</div>

<div class="container">
    <div class="card w-100 text-center shadowBlue">
        <div class="card-header">
            New Account Form
        </div>
        <div class="card-body bg-dark text-white">
            <form>
                <table class="table text-center">
                    <tbody>
                    <tr>
                        <th class="text-white"><span style="color: red;">&ast;</span> Name</th>
                        <td><input type="text" name="name" id="name" class="form-control input-sm upperCase"></td>
                        <th class="text-white"><span style="color: red;">&ast;</span> IC Number</th>
                        <td><input type="text" name="cnic" id="cnic" class="form-control input-sm"></td>
                    </tr>
                    <tr>
                        <th class="text-white"><span style="color: red;">&ast;</span> Account Number</th>
                        <td><input type="" name="accountNo" id="accountNo" readonly value="<%= BankInformation.generateAccountNumber() %>"
                                   class="form-control input-sm"></td>
                        <th class="text-white"><span style="color: red;">&ast;</span> Account Type</th>
                        <td>
                            <select class="form-control input-sm" name="accountType" id="accountType">
                                <option selected value="">Please Select..</option>
                                <%
                                    Map<String, String> accountTypeList = BankInformation.getAccountType();
                                    for (Map.Entry<String, String> entry : accountTypeList.entrySet()) {
                                %>
                                <option value='<%= entry.getKey() %>'><%= entry.getKey() %>-<%= entry.getValue() %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th class="text-white"><span style="color: red;">&ast;</span> City</th>
                        <td><input type="text" name="city" id="city" class="form-control input-sm upperCase"></td>
                        <th class="text-white"><span style="color: red;">&ast;</span> Address</th>
                        <td><input type="text" name="address" id="address" class="form-control input-sm upperCase"></td>
                    </tr>
                    <tr>
                        <th class="text-white"><span style="color: red;">&ast;</span> Email</th>
                        <td><input type="email" name="email" id="email" class="form-control input-sm"></td>
                        <th class="text-white"><span style="color: red;">&ast;</span> Password</th>
                        <td><input type="password" name="password" id="password" class="form-control input-sm"></td>
                    </tr>
                    <tr>
                        <th class="text-white"><span style="color: red;">&ast;</span> Deposit</th>
                        <td><input type="number" name="balance" id="balance" min="10" class="form-control input-sm"></td>
                        <th class="text-white"><span style="color: red;">&ast;</span> Source of income</th>
                        <td><input type="text" name="source" id="source" class="form-control input-sm upperCase"></td>
                    </tr>
                    <tr>
                        <th class="text-white"><span style="color: red;">&ast;</span> Contact Number</th>
                        <td><input type="text" name="number" id="number" class="form-control input-sm"></td>
                        <th class="text-white"><span style="color: red;">&ast;</span> Branch</th>
                        <td>
                            <select name="branch" id="branch" class="form-control input-sm">
                                <option selected value="">Please Select..</option>
                                <%
                                    Map<String, String> bankBrnchList = BankInformation.getBankBranch();
                                    for (Map.Entry<String, String> entry : bankBrnchList.entrySet()) {
                                %>
                                <option value='<%= entry.getKey() %>'><%= entry.getKey() %>-<%= entry.getValue() %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <button type="button" name="saveAccount" id="saveAccount" class="btn btn-primary btn-sm">
                                Save Account
                            </button>
                            <button type="Reset" class="btn btn-secondary btn-sm">Reset</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="card-footer text-muted">
            <%= BankInformation.getBankName() %>
        </div>
    </div>
</div>
</body>
</html>