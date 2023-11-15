package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "USERACCOUNT")
@Setter
@Getter
@NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // `id` int(11) NOT NULL

    @NotNull
    @Column(name = "NAME")
    private String name; // `name` varchar(111) NOT NULL

    @NotNull
    @Column(name = "PASSWORD")
    private String password; // `password` text NOT NULL

    @NotNull
    @Column(name = "EMAIL")
    private String email; // `email` text NOT NULL

    @NotNull
    @Column(name = "CNIC")
    private String cnic; // `cnic` varchar(111) NOT NULL

    @NotNull
    @Column(name = "PHONENUMBER")
    private String phoneNumber; // `cnic` varchar(111) NOT NULL

    @NotNull
    @Column(name = "CITY")
    private String city; // `city` varchar(111) NOT NULL

    @NotNull
    @Column(name = "ADDRESS")
    private String address; // `address` varchar(111) NOT NULL

    @NotNull
    @Column(name = "SOURCEINCOME")
    private String sourceIncome; // `source` varchar(111) NOT NULL

    @NotNull
    @Column(name = "ACCOUNTNO")
    private String accountNo; // `accountNo` varchar(111) NOT NULL

    @NotNull
    @Column(name = "BRANCH")
    private String branch; // `branch` varchar(111) NOT NULL

    @NotNull
    @Column(name = "ACCOUNTTYPE")
    private String accountType; // `accountType` varchar(111) NOT NULL

    @NotNull
    @Column(name = "BALANCE")
    private String balance; // `balance` varchar(111) NOT NULL

    @NotNull
    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP

    @PrePersist
    private void onCreate() {
        timeStamp = LocalDateTime.now();
    }
}