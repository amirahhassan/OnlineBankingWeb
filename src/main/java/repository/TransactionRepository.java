package repository;

import dto.UserAccount;
import entity.Otheraccounts;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

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
}
