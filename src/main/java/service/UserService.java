package service;

import entity.UserAccount;
import repository.UserRepository;

public class UserService {
    public static void addNewUser(UserAccount userAccount){
        System.out.println("inside UserService");
        UserRepository.addNewUser(userAccount);
    }

    public static void deleteUserById(int id){
        UserRepository.deleteUserById(id);
    }
}
