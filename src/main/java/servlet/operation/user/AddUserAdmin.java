package servlet.operation.user;

import entity.User;
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
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setCnic(ic);
        user.setPhoneNumber(contactNumber);
        user.setAccountType(accountType);
        user.setCity(city);
        user.setAddress(address);
        user.setSourceIncome(sourceIncome);
        user.setBranch(branch);
        user.setBalance(deposit);
        user.setAccountNo(accountNumber);

        UserService.addNewUser(user);
    }
}