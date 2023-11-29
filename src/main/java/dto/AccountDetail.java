package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetail {
    private String accountNo;
    private String branchCode;
    private String branchLocation;
    private String accountType;
    private String accountCreated;
}
