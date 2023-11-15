package servlet.operation.feedback;

import entity.Feedback;
import service.FeedbackService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addUserFeedback")
public class AddUserFeedback extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userMsg = req.getParameter("userMsg");
        String userId = req.getParameter("userId");

        Feedback feedback = new Feedback();
        feedback.setMessage(userMsg);
        feedback.setUserId(userId);

        FeedbackService.addNewFeedback(feedback);
    }
}