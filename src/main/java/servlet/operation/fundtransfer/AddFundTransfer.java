package servlet.operation.fundtransfer;

import entity.Otheraccounts;
import entity.Transaction;
import service.TransactionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addFundTransfer")
public class AddFundTransfer extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String beneficiaryAccountNo = req.getParameter("beneficiaryAccountNo");
        String amountTransfer = req.getParameter("amountTransfer");
        String bankSelect = req.getParameter("bankSelect");
        String action = req.getParameter("action");
        String userId = req.getParameter("userId");
        String beneficiaryAccountName = req.getParameter("beneficiaryAccountName");

        Otheraccounts otheraccounts = new Otheraccounts();
        otheraccounts.setHolderName(beneficiaryAccountName);
        otheraccounts.setBankName(bankSelect);
        otheraccounts.setAccountNo(beneficiaryAccountNo);
        otheraccounts.setBalance(amountTransfer);

        Transaction transaction = new Transaction();
        transaction.setAction(action);
        transaction.setDebit(amountTransfer);
        transaction.setOther(beneficiaryAccountNo);
        transaction.setUserid(Integer.parseInt(userId));
        transaction.setOtherAccount(otheraccounts);

        boolean isSuccess = TransactionService.addNewUserTransaction(transaction, otheraccounts);
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        if (isSuccess){
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}