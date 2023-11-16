package repository;

import dto.FeedbackAdmin;
import entity.Feedback;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {
    public static void addNewFeedback(Feedback feedback){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student objects
            session.persist(feedback);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<FeedbackAdmin> listAllFeedback(){
        Transaction transaction = null;
        List<FeedbackAdmin> dtoRsltLit = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            String hql = "SELECT T2.id, T1.name, T1.accountNo, T1.phoneNumber, T2.message FROM UserAccount T1, Feedback T2 WHERE T1.id = CAST(T2.userId AS INTEGER)";
            Query query = session.createQuery(hql);
            List<Object[]> resultList = query.list();

            for (Object[] result : resultList) {
                // Each 'result' array contains the selected fields in the order you specified in the query
                // Access the fields using indices (0, 1, 2, ...) corresponding to the order in your SELECT statement
                int feedbackId = (Integer) result[0];
                String userName = (String) result[1];
                String accountNo = (String) result[2];
                String phoneNumber = (String) result[3];
                String feedbackMessage = (String) result[4];
                FeedbackAdmin feedbackAdmin = new FeedbackAdmin(feedbackId, userName, accountNo, phoneNumber, feedbackMessage);
                dtoRsltLit.add(feedbackAdmin);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return dtoRsltLit;
    }

    public static void deleteFeedbackById(int feedbackId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            String hql = "DELETE FROM Feedback T1 WHERE T1.id = :feedbackId";
            Query query = session.createQuery(hql);
            query.setParameter("feedbackId", feedbackId);
            query.executeUpdate();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}