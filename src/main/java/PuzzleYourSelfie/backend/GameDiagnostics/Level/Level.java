package PuzzleYourSelfie.backend.GameDiagnostics.Level;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID id;

    @Column
    private int number;

    @Column
    private int verticalAmount;

    @Column
    private int horizontalAmount;

    @Column
    private int time;

}
