package dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatement {

    private String action;
    private String debit;
    private String timeStamp;
    private String receiverAccountNumber;

}
