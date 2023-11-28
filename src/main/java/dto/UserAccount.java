package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    private int id;
    private String name;
    private String accountNo;
    private String branch;
    private String balance;
    private String accountType;
    private String phoneNumber;

    public UserAccount(int id, String name, String accountNo, String balance) {
        this.id = id;
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
    }
}