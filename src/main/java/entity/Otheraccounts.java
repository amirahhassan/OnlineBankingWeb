package entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Column(name = "ACCOUNTNO")
    private String accountNo;

    @NotNull
    @Column(name = "BANKNAME")
    private String bankName;

    @NotNull
    @Column(name = "HOLDERNAME")
    private String holderName;

    @NotNull
    @Column(name = "BALANCE")
    private String balance;

    @NotNull
    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP

    @PrePersist
    private void onCreate() {
        timeStamp = LocalDateTime.now();
    }
}