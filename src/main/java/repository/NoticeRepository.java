package repository;

import dto.UserNotice;
import entity.Notice;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class NoticeRepository {
    public static boolean addNewNotice(Notice notice) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student objects
            session.persist(notice);

            // commit transaction
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public static List<UserNotice> getAllNoticesByUserId(int id) {
        Transaction transaction = null;
        List<UserNotice> dtoRsltLit = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            String hql = "SELECT T1.notice FROM Notice T1 WHERE T1.userId =:id ORDER BY T1.timeStamp DESC";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List<Object[]> resultList = query.list();

            for (Object[] result : resultList) {
                // Each 'result' array contains the selected fields in the order you specified in the query
                // Access the fields using indices (0, 1, 2, ...) corresponding to the order in your SELECT statement
                String userNoticeById = (String) result[0];
                System.out.println("what is her name "+userNoticeById);
                UserNotice userNotice = new UserNotice(userNoticeById);
                dtoRsltLit.add(userNotice);
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
}