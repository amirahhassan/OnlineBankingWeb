package service;

import dto.AccountProfile;
import entity.UserAccount;
import repository.UserRepository;

import java.util.List;

public class UserService {
    public static void addNewUser(UserAccount userAccount){
        UserRepository.addNewUser(userAccount);
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
}
