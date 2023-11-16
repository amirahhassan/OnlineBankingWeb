package servlet.operation.feedback;

import service.FeedbackService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserFeedback")
public class DeleteUserFeedback extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int feedbackId = Integer.parseInt(req.getParameter("feedbackId"));
        FeedbackService.deleteFeedbackById(feedbackId);
        resp.getWriter().write(req.getContextPath() + "/feedbackAdmin");
    }
}
