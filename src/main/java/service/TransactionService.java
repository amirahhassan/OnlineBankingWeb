package service;

import dto.UserAccount;
import entity.Otheraccounts;
import entity.Transaction;
import org.hibernate.Session;
import repository.TransactionRepository;
import util.HibernateUtil;

public class TransactionService {

    public static void addNewUserTransaction(Transaction transaction, Otheraccounts otheraccounts){
        TransactionRepository.addNewUserTransaction(transaction, otheraccounts);
    }
    public static UserAccount getUserAccountBankInfo(String id){
        return TransactionRepository.getUserAccountBankInfo(id);
    }
}
