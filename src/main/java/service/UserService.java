package service;

import entity.User;
import repository.UserRepository;

public class UserService {
    public static void addNewUser(User user){
        System.out.println("inside UserService");
        UserRepository.addNewUser(user);
    }

//    public static void deleteUserById(int id){
//        System.out.println("inside UserService");
//        UserRepository.addNewUser(user);
//    }
}
