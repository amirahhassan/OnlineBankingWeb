package util;

import dto.BranchDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankInformation {
    public static String getBankName(){
        return "CatchFlow Bank";
    }
    public static Map<String, String> getBankBranch(){
//        Transaction transaction = null;
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//
//            // Create and execute a select query
//            String hql = "SELECT T1.branchName, T1.branchLocation FROM Branch T1"; // Replace YourEntityName with your actual entity class name
//            Query query = session.createQuery(hql);
//            List<BranchDto> resultBrnchDtoList = query.list();
//
//            // Process the selected data
//            for (YourEntityName entity : resultList) {
//                // Access entity attributes as needed
//            }
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }






        Map<String, String> bankBrnchList = new HashMap<>();
        bankBrnchList.put("PJ", "SELANGOR");
        bankBrnchList.put("SJ", "SELANGOR");
        bankBrnchList.put("PCH", "SELANGOR");
        bankBrnchList.put("AOR", "KEDAH");
        bankBrnchList.put("SGP", "KEDAH");
        bankBrnchList.put("PLK", "KEDAH");
        return bankBrnchList;
    }

    public static Map<String, String> getAccountType(){
        Map<String, String> accountTypeList = new HashMap<>();
        accountTypeList.put("SAV", "SAVING");
        accountTypeList.put("CURR", "CURRENT");
        accountTypeList.put("INV", "INVESTMENT");
        accountTypeList.put("ORG", "ORGANIZATION");
        return accountTypeList;
    }
}