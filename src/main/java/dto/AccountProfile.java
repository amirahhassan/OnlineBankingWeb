package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountProfile {
    private String id;
    private String name;
    private String accountNo;
    private String branchName;
    private String branchCode;
    private String balance;
    private String accountType;
    private String cnic;
    private String city;
    private String phoneNumber;
    private String address;
}