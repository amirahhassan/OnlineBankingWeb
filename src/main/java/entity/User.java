package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "CNIC")
    private String cnic;

    @NotNull
    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    @NotNull
    @Column(name = "SOURCEINCOME")
    private String sourceIncome;

    @NotNull
    @Column(name = "ACCOUNTNO")
    private String accountNo;

    @NotNull
    @Column(name = "BRANCH")
    private String branch;

    @NotNull
    @Column(name = "ACCOUNTTYPE")
    private String accountType;

    @NotNull
    @Column(name = "BALANCE")
    private String balance;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timeStamp;
}