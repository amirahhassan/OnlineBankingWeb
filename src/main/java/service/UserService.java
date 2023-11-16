package service;

import entity.UserAccount;
import repository.UserRepository;

import java.util.List;

public class UserService {
    public static void addNewUser(UserAccount userAccount){
        System.out.println("inside UserService");
        UserRepository.addNewUser(userAccount);
    }

    public static void deleteUserById(int id){
        UserRepository.deleteUserById(id);
    }
    public static List<dto.UserAccount> listAllUsers(){
        return UserRepository.listAllUsers();
    }
}
