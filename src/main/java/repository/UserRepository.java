package repository;

import dto.AccountDetail;
import dto.AccountProfile;
import entity.Login;
import entity.UserAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static boolean addNewUser(UserAccount userAccount, Login login) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student objects
            session.persist(userAccount);
            session.persist(login);

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

    public static void deleteUserById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a userAccount object
            UserAccount userAccount = session.get(UserAccount.class, id);
            Login loginAccount = session.get(Login.class, id);
            if (userAccount != null && loginAccount != null) {
                session.delete(userAccount);
                session.delete(loginAccount);
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<dto.UserAccount> listAllUsers() {
        List<dto.UserAccount> dtoRsltLit = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT T1.id, T1.name, T1.accountNo, T1.branch, T1.balance, T1.accountType, T1.phoneNumber FROM UserAccount T1";
            Query query = session.createQuery(hql);
            List<Object[]> resultList = query.list();

            for (Object[] result : resultList) {
                // Each 'result' array contains the selected fields in the order you specified in the query
                // Access the fields using indices (0, 1, 2, ...) corresponding to the order in your SELECT statement
                int accountId = (Integer) result[0];
                String holderName = (String) result[1];
                String accountNo = (String) result[2];
                String branch = (String) result[3];
                String currentBalance = (String) result[4];
                String accountType = (String) result[5];
                String contact = (String) result[6];
                dto.UserAccount userAccount = new dto.UserAccount(accountId, holderName, accountNo, branch, currentBalance, accountType, contact);
                dtoRsltLit.add(userAccount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoRsltLit;
    }

    public static AccountProfile getUserById(int id) {
        AccountProfile accountProfile = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT T1.id, T1.name, T1.accountNo, T1.branch, T2.branchLocation, T1.balance, T1.accountType, T1.cnic, T1.city, T1.phoneNumber, T1.address " +
                    "FROM UserAccount T1, Branch T2 WHERE T1.id =:id AND T1.branch = T2.branchName";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            Object[] result = (Object[]) query.uniqueResult();

            int accountId = (Integer) result[0];
            String holderName = (String) result[1];
            String accountNo = (String) result[2];
            String branchCode = (String) result[3];
            String branchLocation = (String) result[4];
            String balance = (String) result[5];
            String accountType = (String) result[6];
            String cnic = (String) result[7];
            String city = (String) result[8];
            String phoneNumber = (String) result[9];
            String address = (String) result[10];

            accountProfile = new AccountProfile(String.valueOf(accountId), holderName, accountNo, branchCode, branchLocation, balance, accountType, cnic, city, phoneNumber, address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountProfile;
    }

    public static AccountDetail getUserAccountDetailById(int id) {
        AccountDetail accountDetail = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT T1.accountNo, T1.branch, T2.branchLocation,  T1.accountType, T1.timeStamp " +
                    "FROM UserAccount T1, Branch T2 WHERE T1.id =:id AND T1.branch = T2.branchName";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            Object[] result = (Object[]) query.uniqueResult();

            String accountNo = (String) result[0];
            String branch = (String) result[1];
            String branchLocation = (String) result[2];
            String accountType = (String) result[3];
            LocalDateTime accountCreated = (LocalDateTime) result[4];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Adjust the pattern as needed
            String formattedAccountCreated = accountCreated.format(formatter);

            accountDetail = new AccountDetail(accountNo, branchLocation, branch, accountType, formattedAccountCreated);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountDetail;
    }

    public static Long checkUserExist(String email, String password) {
        Long countUserCheck = 0L;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(*) AS COUNTUSERCHECK FROM Login T1 WHERE T1.email =:email AND T1.password =:password";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("password", password);

            countUserCheck = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countUserCheck;
    }
}