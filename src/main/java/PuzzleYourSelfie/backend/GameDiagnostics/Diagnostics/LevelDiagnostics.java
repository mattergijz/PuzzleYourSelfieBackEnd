package PuzzleYourSelfie.backend.GameDiagnostics.Diagnostics;


import PuzzleYourSelfie.backend.GameDiagnostics.Level.Level;
import PuzzleYourSelfie.backend.GameDiagnostics.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelDiagnostics {

    @Id
    @Column
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private int timeLeft;

    private int piecesLeft;

    private boolean finished;

    public LevelDiagnostics(Level level, User user, int timeLeft, int piecesLeft, boolean finished) {
        this.level = level;
        this.user = user;
        this.timeLeft = timeLeft;
        this.piecesLeft = piecesLeft;
        this.finished = finished;
    }
}
