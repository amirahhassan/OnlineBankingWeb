package service;

import dto.AccountProfile;
import entity.Login;
import entity.UserAccount;
import repository.UserRepository;

import java.util.List;

public class UserService {
    public static boolean addNewUser(UserAccount userAccount, Login login){
        return UserRepository.addNewUser(userAccount, login);
    }

    public static AccountProfile getUserById(int id){
        return UserRepository.getUserById(id);
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
}
