package servlet.operation.user;

import entity.UserAccount;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addUserAdmin")
public class AddUserAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
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

        UserService.addNewUser(userAccount);
    }
}