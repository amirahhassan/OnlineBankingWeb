package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "FEEDBACK")
@Setter
@Getter
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // `feedbackId` int(11) NOT NULL

    @NotNull
    @Column(name = "MESSAGE")
    private String message; // `message` text NOT NULL

    @NotNull
    @Column(name = "USERID")
    private String userId ; // `userId` String NOT NULL

    @NotNull
    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP

    @PrePersist
    private void onCreate() {
        timeStamp = LocalDateTime.now();
    }
}