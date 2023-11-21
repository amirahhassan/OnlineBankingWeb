package entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "LOGIN")
@Setter
@Getter
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // int(11) NOT NULL

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @NotNull
    @Column(name = "ACCOUNTNO")
    private String accountNo;

    @NotNull
    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP

    @PrePersist
    private void onCreate() {
        timeStamp = LocalDateTime.now();
    }
}
