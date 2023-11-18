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
}