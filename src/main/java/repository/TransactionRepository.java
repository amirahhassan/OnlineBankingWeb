package repository;

import dto.AccountStatement;
import dto.UserAccount;
import dto.UserNotice;
import entity.Otheraccounts;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    public static void addNewUserTransaction(entity.Transaction transactEntity, Otheraccounts otheraccounts){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the transactEntity objects
            session.persist(transactEntity);
//            session.persist(otheraccounts);

            // commit transaction
            transaction.commit();

            // return true to indicate success
//            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
//        return false;
    }
    public static UserAccount getUserAccountBankInfo(String id){
         UserAccount userAccount = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT T1.id, T1.name, T1.accountNo, T1.balance FROM UserAccount T1 WHERE T1.id =:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            Object[] result = (Object[]) query.uniqueResult();
            userAccount = new UserAccount((Integer) result[0], (String) result[1], (String) result[2], (String) result[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userAccount;
    }

    public static List<AccountStatement> getAccountStatementByUserId(String id){
        List<AccountStatement> accountStatementList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // select * from transaction where userId = '$userData[id]' order by date desc
            String hql = "SELECT T1.action, T1.debit, T1.timeStamp, T1.other FROM Transaction T1 WHERE T1.userid =:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List<Object[]> resultList = query.list();


            for (Object[] result : resultList) {
                // Each 'result' array contains the selected fields in the order you specified in the query
                // Access the fields using indices (0, 1, 2, ...) corresponding to the order in your SELECT statement

                String action = (String) result[0];
                String debit = (String) result[1];

                LocalDateTime transferCreated = (LocalDateTime) result[2];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Adjust the pattern as needed
                String formattedTransferCreated = transferCreated.format(formatter);

                String receiverAccountNumber = (String) result[3];
                AccountStatement accountStatement = new AccountStatement(action, debit, formattedTransferCreated, receiverAccountNumber);
                accountStatementList.add(accountStatement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountStatementList;
    }
}
