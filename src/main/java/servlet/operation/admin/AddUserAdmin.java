package servlet.operation.admin;

import com.mysql.cj.log.Log;
import entity.Login;
import entity.UserAccount;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUserAdmin")
public class AddUserAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String ic = req.getParameter("ic");
        String accountNumber = req.getParameter("accountNumber");
        String accountType = req.getParameter("accountType");
        String city = req.getParameter("city");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String deposit = req.getParameter("deposit");
        String sourceIncome = req.getParameter("sourceIncome");
        String contactNumber = req.getParameter("contactNumber");
        String branch = req.getParameter("branch");

        System.out.println("inside AddUser");
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setPassword(password);
        userAccount.setEmail(email);
        userAccount.setCnic(ic);
        userAccount.setPhoneNumber(contactNumber);
        userAccount.setAccountType(accountType);
        userAccount.setCity(city);
        userAccount.setAddress(address);
        userAccount.setSourceIncome(sourceIncome);
        userAccount.setBranch(branch);
        userAccount.setBalance(deposit);
        userAccount.setAccountNo(accountNumber);

        Login login = new Login();
        // 0 - stands for normal user
        // 1 - stands for admin user
        login.setType("0");
        login.setAccountNo(accountNumber);
        login.setPassword(password);
        login.setEmail(email);

        boolean isSuccess = UserService.addNewUser(userAccount, login);
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        if (isSuccess){
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}