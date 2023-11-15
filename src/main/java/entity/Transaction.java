package entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION")
@Setter
@Getter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTIONID")
    private int transactionId; // int(11) NOT NULL

    @Column(name = "ACTION")
    private String action;

    @Column(name = "CREDIT")
    private String credit;

    @Column(name = "DEBIT")
    private String debit;

    @Column(name = "BALANCE")
    private String balance;

    @Column(name = "BENEID")
    private String beneId;

    @Column(name = "OTHER")
    private String other;

    @Column(name = "USERID")
    private int userid;

    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
}
