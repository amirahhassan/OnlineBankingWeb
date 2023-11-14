<%@ page import="util.BankInformation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/libraries.jsp"/>
</head>
<body style="background-size: 100%" class="bg-gradient-seconday">
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
            <li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/statementUser">Account Statements</a></li>
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/transferUser">Funds Transfer</a></li>
        </ul>
        <jsp:include page="/jsp/user/sidebutton.jsp"/>
    </div>
</nav><br><br><br>
<div class="container">
    <div class="card  w-75 mx-auto">
        <div class="card-header text-center">
            Funds Transfer
        </div>
        <div class="card-body">
            <form method="POST">
                <div class="alert alert-success w-50 mx-auto">
                    <h5>New Transfer</h5>
                    <input type="text" name="otherNo" class="form-control " placeholder="Enter Receiver Account number" required>
                    <button type="submit" name="get" class="btn btn-primary btn-bloc btn-sm my-1">Get Account Info</button>
                </div>
            </form>
            <?php if (isset($_POST['get']))
      {
        $array2 = $con->query("select * from otheraccounts where accountNo = '$_POST[otherNo]'");
            $array3 = $con->query("select * from userAccounts where accountNo = '$_POST[otherNo]'");
            {
            if ($array2->num_rows > 0)
            { $row2 = $array2->fetch_assoc();
            echo "<div class='alert alert-success w-50 mx-auto'>
            <form method='POST'>
                Account No.
                <input type='text' value='$row2[accountNo]' name='otherNo' class='form-control ' readonly required>
                Account Holder Name.
                <input type='text' class='form-control' value='$row2[holderName]' readonly required>
                Account Holder Bank Name.
                <input type='text' class='form-control' value='$row2[bankName]' readonly required>
                Enter Amount for tranfer.
                <input type='number' name='amount' class='form-control' min='1' max='$userData[balance]' required>
                <button type='submit' name='transfer' class='btn btn-primary btn-bloc btn-sm my-1'>Tranfer</button>
            </form>
        </div>";
            }elseif ($array3->num_rows > 0) {
            $row2 = $array3->fetch_assoc();
            echo "<div class='alert alert-success w-50 mx-auto'>
            <form method='POST'>
                Account No.
                <input type='text' value='$row2[accountNo]' name='otherNo' class='form-control ' readonly required>
                Account Holder Name.
                <input type='text' class='form-control' value='$row2[name]' readonly required>
                Account Holder Bank Name.
                <input type='text' class='form-control' value='".bankname."' readonly required>
                Enter Amount for tranfer.
                <input type='number' name='amount' class='form-control' min='1' max='$userData[balance]' required>
                <button type='submit' name='transferSelf' class='btn btn-primary btn-bloc btn-sm my-1'>Tranfer</button>
            </form>
        </div>";
            }
            else
            echo "<div class='alert alert-success w-50 mx-auto'>Account No. $_POST[otherNo] Does not exist</div>";
            }
            }
            ?>
            <br>
            <h5>Transfer History</h5>
            <div id="list-group rounded-0">
                <?php
    if (isset($_POST['transferSelf']))
    {
      $amount = $_POST['amount'];
      setBalance($amount,'debit',$userData['accountNo']);
      setBalance($amount,'credit',$_POST['otherNo']);
      makeTransaction('transfer',$amount,$_POST['otherNo']);
      echo "<script>alert('Transfer Successfull');window.location.href='transfer.php'</script>";
                }
                if (isset($_POST['transfer']))
                {
                $amount = $_POST['amount'];
                setBalance($amount,'debit',$userData['accountNo']);
                makeTransaction('transfer',$amount,$_POST['otherNo']);
                echo "<script>alert('Transfer Successfull');window.location.href='transfer.php'</script>";
                }
                $array = $con->query("select * from transaction where userId = '$userData[id]' AND action = 'transfer' order by date desc");
                if ($array ->num_rows > 0)
                {
                while ($row = $array->fetch_assoc())
                {
                if ($row['action'] == 'transfer')
                {
                echo "<div class='list-group-item list-group-item-action bg-gradient-info'>Transfer have been made for  Rs.$row[debit] from your account at $row[date] in  account no.$row[other]</div>";
                }

                }
                }
                else
                echo "<div class='list-group-item list-group-item-action text-muted'>You have made no transfer yet.</div>";
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