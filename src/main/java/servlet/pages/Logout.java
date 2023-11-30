package servlet.pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Your servlet code here to determine the condition
        boolean conditionMet = true; // Replace with your actual condition check

        if (conditionMet) {
            // Use RequestDispatcher to forward to the specific JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle the condition not being met
            response.getWriter().println("Condition not met.");
        }
    }
}
