package repository;

import dto.AccountStatement;
import dto.UserAccount;
import entity.Otheraccounts;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    public static boolean addNewUserTransaction(entity.Transaction transactEntity, Otheraccounts otheraccounts) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            Query query = null;

            // Write the HQL query to retrieve the balance by user ID
            String hqlRetrieve = "SELECT T1.balance FROM UserAccount T1 WHERE T1.id = :userId";
            query = session.createQuery(hqlRetrieve);
            query.setParameter("userId", transactEntity.getUserid());

            // Execute the query and get the result
            String initialBalance = (String) query.uniqueResult();

            double latestBalance = Double.parseDouble(initialBalance) - Double.parseDouble(transactEntity.getDebit());

            // Format the result to always have two decimal places
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String formattedBalance = decimalFormat.format(latestBalance);

            // Write the HQL query to retrieve the balance by user ID
            String hqlUpdate = "UPDATE UserAccount T1 SET T1.balance =:debitAmount  WHERE T1.id = :userId";
            query = session.createQuery(hqlUpdate);
            query.setParameter("userId", transactEntity.getUserid());
            query.setParameter("debitAmount", formattedBalance);

            int result = query.executeUpdate();
            System.out.println("Rows affected for updating: " + result);

            // save the transactEntity objects
            session.persist(transactEntity);
            session.persist(otheraccounts);

            // commit transaction
            transaction.commit();

            // return true to indicate success
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public static UserAccount getUserAccountBankInfo(String id) {
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

    public static List<AccountStatement> getAccountStatementByUserId(String id) {
        List<AccountStatement> accountStatementList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT T1.action, T1.debit, T1.timeStamp, T1.other FROM Transaction T1 WHERE T1.userid =:id ORDER BY T1.timeStamp DESC";
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

    public static String getBalanceByUserId(int id) {
        String amountBalanceByUserId = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT T1.balance FROM UserAccount T1 WHERE T1.id =:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            amountBalanceByUserId = (String) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amountBalanceByUserId;
    }
}