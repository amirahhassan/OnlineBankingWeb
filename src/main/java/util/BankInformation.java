package util;

import java.util.HashMap;
import java.util.Map;

public class BankInformation {
    public static String getBankName(){
        return "CatchFlow Bank";
    }
    public static Map<String, String> getBankBranch(){
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

    public static Map<String, String> getBankNameList(){
        Map<String, String> bankList = new HashMap<>();
        bankList.put("MYB", "MAYBANK BANK");
        bankList.put("CIMB", "CIMB BANK");
        bankList.put("RHB", "RHB BANK");
        bankList.put("PB", "PUBLIC BANK");
        return bankList;
    }

    public static long generateAccountNumber(){
        long startNum = 1;
        long endNum = 999999;
        long rand = (int)(Math.random() * (endNum - startNum)) + startNum;
        return rand;
    }
}