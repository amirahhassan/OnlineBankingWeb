package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "NOTICE")
@Setter
@Getter
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // `id` int(11) NOT NULL

    @NotNull
    @Column(name = "USERID")
    private String userId; // `userId` varchar(111) NOT NULL

    @NotNull
    @Column(name = "NOTICE")
    private String notice; // `notice` text NOT NULL

    @NotNull
    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP

    @PrePersist
    private void onCreate() {
        timeStamp = LocalDateTime.now();
    }
}