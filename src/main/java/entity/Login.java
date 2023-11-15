package entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
}
