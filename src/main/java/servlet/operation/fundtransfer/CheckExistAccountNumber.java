package servlet.operation.fundtransfer;

import entity.Feedback;
import service.FeedbackService;
import service.TransactionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkExistAccountNumber")
public class CheckExistAccountNumber extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String recipientAccountNum = req.getParameter("recipientAccountNum");

//        boolean isUserExist = TransactionService.checkExistAccountNumber(recipientAccountNum);
    }
}