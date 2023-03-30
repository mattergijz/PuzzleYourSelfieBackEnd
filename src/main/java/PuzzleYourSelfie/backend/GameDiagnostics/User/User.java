package PuzzleYourSelfie.backend.GameDiagnostics.User;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.UUID;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private int age;

    private String name;

    @CreationTimestamp
    private Date registeredAt;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
