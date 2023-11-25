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
        List<UserNotice> dtoRsltLit = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "SELECT T1.notice FROM Notice T1 WHERE T1.userId =:id ORDER BY T1.timeStamp DESC";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List<String> resultList = query.list();

            for (String result : resultList) {
                // Each 'result' array contains the selected fields in the order you specified in the query
                // Access the fields using indices (0, 1, 2, ...) corresponding to the order in your SELECT statement
                UserNotice userNotice = new UserNotice(result);
                dtoRsltLit.add(userNotice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoRsltLit;
    }
}