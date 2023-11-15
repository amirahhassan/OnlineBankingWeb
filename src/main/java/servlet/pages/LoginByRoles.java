package servlet.pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginByRoles")
public class LoginByRoles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Your servlet code here to determine the condition
        boolean conditionMet = true; // Replace with your actual condition check

        String userType = request.getParameter("userType");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("gg "+ email);
        System.out.println("gg "+ password);
        System.out.println("gg "+ userType);

        if (conditionMet) {
            // Use RequestDispatcher to forward to the specific JSP page
            if(userType.equals("user")){
                response.getWriter().write(request.getContextPath() + "/indexUser");
            }
            if(userType.equals("manager")){
                response.getWriter().write(request.getContextPath() + "/indexAdmin");
            }
        } else {
            // Handle the condition not being met
            response.getWriter().println("Condition not met.");
        }
    }
}
