package service;

import dto.AccountStatement;
import dto.UserAccount;
import entity.Otheraccounts;
import entity.Transaction;
import org.hibernate.Session;
import repository.TransactionRepository;
import util.HibernateUtil;

import java.util.List;

public class TransactionService {

    public static void addNewUserTransaction(Transaction transaction, Otheraccounts otheraccounts){
        TransactionRepository.addNewUserTransaction(transaction, otheraccounts);
    }
    public static UserAccount getUserAccountBankInfo(String id){
        return TransactionRepository.getUserAccountBankInfo(id);
    }

    public static List<AccountStatement> getAccountStatementByUserId(String id){
        return TransactionRepository.getAccountStatementByUserId(id);
    }

}
