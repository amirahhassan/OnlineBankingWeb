package entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "OTHERACCOUNTS")
@Setter
@Getter
@NoArgsConstructor
public class Otheraccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // int(11) NOT NULL

    @Column(name = "ACCOUNTNO")
    private String accountNo;

    @Column(name = "BANKNAME")
    private String bankName;

    @Column(name = "HOLDERNAME")
    private String holderName;

    @Column(name = "BALANCE")
    private String balance;

    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
}
