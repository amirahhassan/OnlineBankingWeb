package service;

import dto.AccountDetail;
import dto.AccountProfile;
import entity.Login;
import entity.UserAccount;
import repository.UserRepository;

import java.text.DecimalFormat;
import java.util.List;

public class UserService {
    public static boolean addNewUser(UserAccount userAccount, Login login){
        String latestBalance = userAccount.getBalance();

        // Format the result to always have two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String formattedBalance = decimalFormat.format(latestBalance);
        userAccount.setBalance(formattedBalance);
        return UserRepository.addNewUser(userAccount, login);
    }

    public static AccountProfile getUserById(int id){
        return UserRepository.getUserById(id);
    }

    public static AccountDetail getUserAccountDetailById(int id){
        return UserRepository.getUserAccountDetailById(id);
    }

    public static void deleteUserById(int id){
        UserRepository.deleteUserById(id);
    }

    public static List<dto.UserAccount> listAllUsers(){
        return UserRepository.listAllUsers();
    }

    public static Long checkUserExist(String email, String password) {
        return UserRepository.checkUserExist(email, password);
    }

    public static Integer getUserId(String email, String password) {
        return UserRepository.getUserId(email, password);
    }
}