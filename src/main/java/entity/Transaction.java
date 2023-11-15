package entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Column(name = "ACTION")
    private String action;

    @NotNull
    @Column(name = "CREDIT")
    private String credit;

    @NotNull
    @Column(name = "DEBIT")
    private String debit;

    @NotNull
    @Column(name = "BALANCE")
    private String balance;

    @NotNull
    @Column(name = "BENEID")
    private String beneId;

    @NotNull
    @Column(name = "OTHER")
    private String other;

    @NotNull
    @Column(name = "USERID")
    private int userid;

    @NotNull
    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP

    @PrePersist
    private void onCreate() {
        timeStamp = LocalDateTime.now();
    }
}
