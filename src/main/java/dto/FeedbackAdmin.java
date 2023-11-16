package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackAdmin {
    private int id;
    private String accountNameHolder;
    private String accountNo;
    private String contact;
    private String message;
}