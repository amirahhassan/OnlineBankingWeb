package servlet.pages;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginByRoles")
public class LoginByRoles extends HttpServlet {
    //    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        // Your servlet code here to determine the condition
//        boolean conditionMet = true; // Replace with your actual condition check
//
//        String userType = request.getParameter("userType");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        if (conditionMet) {
//            // Use RequestDispatcher to forward to the specific JSP page
//            if(userType.equals("user") && !email.equals("admin@cflobank.com") && !password.equals("123")){
//                Long userExist = UserService.checkUserExist(email, password);
//                if (userExist == 1){
//                    response.setStatus(HttpServletResponse.SC_OK);
//                    response.getWriter().write(request.getContextPath() + "/indexUser");
//                }
//            }
//            if(userType.equals("manager") && email.equals("admin@cflobank.com") && password.equals("123")){
//                response.setStatus(HttpServletResponse.SC_OK);
//                response.getWriter().write(request.getContextPath() + "/indexAdmin");
//            }
//        } else {
//            // Handle the condition not being met
//            response.getWriter().write(request.getContextPath());
//        }
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Your servlet code here to determine the condition
        boolean conditionMet = true; // Replace with your actual condition check

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        HttpSession session=request.getSession(true);

        // Set session expiration time to 1 minutes (in seconds)
        session.setMaxInactiveInterval(60);


        if (conditionMet) {
            // Use RequestDispatcher to forward to the specific JSP page
            if (!email.equals("admin@cflobank.com") && !password.equals("123")) {
                Long userExist = UserService.checkUserExist(email, password);
                Integer loginId = UserService.getUserId(email, password);

                if (userExist == 1) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    session.setAttribute("uuId",loginId);
//                    request.setAttribute("uuId", loginId);
                    response.getWriter().write(request.getContextPath() + "/indexUser");
                }
            }
            if (email.equals("admin@cflowbank.com") && password.equals("123")) {
                response.setStatus(HttpServletResponse.SC_OK);
                session.setAttribute("uuId","admin");
                response.getWriter().write(request.getContextPath() + "/indexAdmin");
            }
        } else {
            // Handle the condition not being met
            response.getWriter().write(request.getContextPath());
        }
    }
}
