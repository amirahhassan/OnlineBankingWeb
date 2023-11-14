package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "BRANCH")
@Setter
@Getter
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // int(11) NOT NULL

    @NotNull
    @Column(name = "USERID")
    private String userId; // `userId` varchar(111) NOT NULL

    @NotNull
    @Column(name = "BRANCHNAME")
    private String branchName; // `notice` text NOT NULL

    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timeStamp; // `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
}
