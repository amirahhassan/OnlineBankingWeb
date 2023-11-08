package servlet.user;

import entity.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("inside AddUser");
        User user = new User();
        user.setName("Ramesh");
        user.setPassword("Datastore");
        user.setEmail("rameshfadatare@javaguides.com");
        user.setRoles("USER");
        UserService.addNewUser(user);
    }
}