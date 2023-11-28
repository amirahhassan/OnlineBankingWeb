<%@ page import="util.BankInformation" %>
<%@ page import="service.NoticeService" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.UserNotice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
</head>
<body style="background-size: 100%" class="bg-gradient-secondary">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="">
        <img src="images/logo.png" style="object-fit:cover;object-position:center center" width="30" height="30"
             class="d-inline-block align-top" alt=""> <%= BankInformation.getBankName() %>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link active" href="${pageContext.request.contextPath}/indexUser">Home <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/accountUser">Accounts</a>
            </li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/statementUser">Account
                Statements</a></li>
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/transferUser">Funds
                Transfer</a></li>
        </ul>
        <jsp:include page="/jsp/user/sidebutton.jsp"/>
    </div>
</nav>
<br><br><br>
<div class="row w-100">
    <div class="col" style="padding: 22px;padding-top: 0">
        <div class="jumbotron shadowBlack" style="padding: 25px;min-height: 241px;max-height: 241px">
            <h4 class="display-5">Welcome to <%= BankInformation.getBankName() %>
            </h4>
            <p class="lead alert alert-warning"><b>Latest Notification:</b>
                    <%
                    // Retrieve the parameter
//                    String userId = (String) request.getAttribute("userId");
                    String userId = "1";
                    List<UserNotice> userNotices = NoticeService.getAllNoticesByUserId(Integer.parseInt(userId));
                    int countMessage = 1;
                    if (userNotices.size() > 0){
                        for (UserNotice userNotice : userNotices) {
                            if (countMessage <= 3){
                                %>
                <br><%= userNotice.getMessage() %>
                    <%
                            }
                            countMessage++;
                        }
                    }else {
                        %>
            <div class='alert alert-info'>Notice box empty</div>
            <%
                }
            %>
            </p>
        </div>
        <div id="carouselExampleIndicators" class="carousel slide my-2 rounded-1 shadowBlack" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="images/bank1.jpg" alt="First slide" style="max-height: 250px">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="images/bank2.jpg" alt="Second slide" style="max-height: 250px">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="images/bank3.png" alt="Third slide" style="max-height: 250px">
                </div>

            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="col">
        <div class="row" style="padding: 22px;padding-top: 0">
            <div class="col">
                <div class="card shadowBlack ">
                    <img class="card-img-top" src="images/journal.jpg" style="max-height: 155px;min-height: 155px"
                         alt="Card image cap">
                    <div class="card-body">
                        <a href="${pageContext.request.contextPath}/accountUser"
                           class="btn btn-outline-info shadow btn-block">Account Summary</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadowBlack ">
                    <img class="card-img-top" src="images/mtransfer.jpg" alt="Card image cap"
                         style="max-height: 155px;min-height: 155px">
                    <div class="card-body">
                        <a href="${pageContext.request.contextPath}/transferUser"
                           class="btn btn-outline-info shadow btn-block">Transfer Money</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="padding: 22px">
            <div class="col">
                <div class="card shadowBlack ">
                    <img class="card-img-top" src="images/notif.gif" style="max-height: 155px;min-height: 155px"
                         alt="Card image cap">
                    <div class="card-body">
                        <a href="${pageContext.request.contextPath}/noticeUser"
                           class="btn btn-outline-primary btn-block">Check Notification</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadowBlack ">
                    <img class="card-img-top" src="images/send_mail.gif" alt="Card image cap"
                         style="max-height: 155px;min-height: 155px">
                    <div class="card-body">
                        <a href="${pageContext.request.contextPath}/feedbackUser"
                           class="btn btn-outline-primary btn-block">Contact Us</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>