package servlet.pages.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/noticeAdmin")
public class NoticeAdmin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Your servlet code here to determine the condition
        boolean conditionMet = true; // Replace with your actual condition check

        String userId = request.getParameter("userId");

        if (conditionMet) {
            // Use RequestDispatcher to forward to the specific JSP page
            // Set the parameter before redirecting
            request.setAttribute("userId", userId);

            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/notice.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle the condition not being met
            response.getWriter().println("Condition not met.");
        }
    }
}
