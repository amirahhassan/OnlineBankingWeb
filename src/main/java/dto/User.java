package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {
    private String name;
    private String password;
    private String email;
    private String cnic;
    private String phoneNumber;
    private String city;
    private String address;
    private String sourceIncome;
    private String accountNo;
    private String branch;
    private String accountType;
}